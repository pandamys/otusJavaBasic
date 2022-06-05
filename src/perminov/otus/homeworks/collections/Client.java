package perminov.otus.homeworks.collections;

import java.util.ArrayList;
import java.util.Objects;

public class Client {
    private final String clientName;
    private final Integer age;
    private final ArrayList<Account> accounts = new ArrayList<>();

    public Client(String clientName, Integer age, int[] numbers){
        this.clientName = clientName;
        this.age = age;
        for (int number : numbers) {
            accounts.add(new Account(number));
        }
    }

    public Client(String clientName, Integer age) {
        this.clientName = clientName;
        this.age = age;
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
        System.out.printf("Сравение двух объектов %s - %s%n", this, obj);

        if (this == obj){ return true;}

        if (obj instanceof Client){
            Client temp = (Client) obj;
            return temp.clientName.equals(this.clientName) && temp.age.equals(this.age);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, age);
    }
}
