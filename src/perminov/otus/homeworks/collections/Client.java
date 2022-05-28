package perminov.otus.homeworks.collections;

import java.util.ArrayList;

public class Client {
    private final String clientName;
    private Integer age;
    private final ArrayList<Account> accounts = new ArrayList<>();

    public Client(String clientName, Integer age, int[] numbers){
        this.clientName = clientName;
        this.age = age;
        for (int number : numbers) {
            accounts.add(new Account(number));
        }
    }

    public Client(String clientName) {
        this.clientName = clientName;
    }

    public void addNewAccount(Integer number){
        accounts.add(new Account(number));
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public String getClientName() {
        return clientName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj){
        Client temp = (Client) obj;
        return obj != null && temp.clientName.equals(this.clientName);
    }
}
