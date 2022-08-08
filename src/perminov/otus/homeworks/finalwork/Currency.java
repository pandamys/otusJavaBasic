package perminov.otus.homeworks.finalwork;

public abstract class Currency {

    private final String name;

    public Currency(String name){
        this.name = name;
    }

    public abstract String[] getForms();

    public abstract void setForms(String[] forms);
}
