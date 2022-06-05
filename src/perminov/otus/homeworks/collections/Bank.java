package perminov.otus.homeworks.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Bank {
    private static final HashMap<Client, HashSet<Account>> clients = new HashMap<>();

    public static void main(String[] args) {
        addClientsToBank();
        HashSet<Account> accounts = getAccounts(new Client("Perminov", 31));
        printAccountsByClient(accounts);

        Client client = findClient(new Account(345));
        printClientByAccount(client);
    }

    public static void addClientsToBank(){
        addClientToBank("Perminov", 31, new int[]{123, 345});
        addClientToBank("Sidorov", 21, new int[]{234});
        addClientToBank("Ivanov", 15, new int[]{456, 321, 765});
    }

    public static void addClientToBank(String name, Integer age, int[] numbers){
        Client client = new Client(name, age);
        HashSet<Account> accounts = new HashSet<>();

        for (Integer number: numbers){
            accounts.add(new Account(number));
        }

        clients.put(client, accounts);
    }

    public static HashSet<Account> getAccounts(Client client){
        for (Client c: clients.keySet()){
            if (client.equals(c)){
                return clients.get(c);
            }
        }
        return null;
    }

    public static Client findClient(Account account){
        Client client;
        HashSet<Account> accounts;

        for (Map.Entry<Client, HashSet<Account>> entry: clients.entrySet()) {
            client = entry.getKey();
            accounts = entry.getValue();

            if (accounts.contains(account)){
                return client;
            }
        }
        return null;
    }

    public static void printAccountsByClient(HashSet<Account> accounts){
        if (accounts != null) {
            for (Account account : accounts) {
                System.out.println(account.getNumberAccount());
            }
        } else {
            System.out.println("Клиент не найден или у клиентов нет счетов");
        }
    }

    public static void printClientByAccount(Client client){
        if (client != null) {
            System.out.println(client.getClientName());
        } else {
            System.out.println("Клиент не найден");
        }
    }
}
