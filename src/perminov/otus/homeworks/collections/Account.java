package perminov.otus.homeworks.collections;

import java.util.Objects;

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
        System.out.printf("Сравение двух объектов %s - %s%n", this, obj);

        if (this == obj){ return true;}

        if (obj instanceof Account){
            Account temp = (Account) obj;
            return temp.numberAccount.equals(this.numberAccount);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberAccount);
    }
}
