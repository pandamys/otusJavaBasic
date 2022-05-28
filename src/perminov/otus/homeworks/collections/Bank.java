package perminov.otus.homeworks.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static ArrayList<Client> clients = new ArrayList<>();

    public static void main(String[] args) {
        addClientsToBank();
        ArrayList<Account> accounts = getAccounts(new Client("Perminov"));
        System.out.println(accounts);
        Client client = findClient(new Account(321));
        System.out.println(client);
    }

    public static void addClientsToBank(){
        clients.add(new Client("Perminov", 18, new int[]{123, 345}));
        clients.add(new Client("Sidorov", 21, new int[]{234}));
        clients.add(new Client("Ivanov", 15, new int[]{456, 321, 765}));
    }

    public static ArrayList<Account> getAccounts(Client client){
        for (Client c: clients){
            if (client.equals(c)){
                return c.getAccounts();
            }
        }
        return null;
    }

    public static Client findClient(Account account){
        for (Client c: clients){
            if (c.getAccounts().contains(account)){
                return c;
            }
        }
        return null;
    }
}
