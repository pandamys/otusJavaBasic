package perminov.otus.homeworks.collections;

public class Account {
    private final Integer numberAccount;

    public Account(Integer numberAccount){
        this.numberAccount = numberAccount;
    }

    public Integer getNumberAccount() {
        return numberAccount;
    }

    @Override
    public boolean equals(Object obj){
        Account temp = (Account) obj;
        return temp.getNumberAccount().equals(numberAccount);
    }
}
