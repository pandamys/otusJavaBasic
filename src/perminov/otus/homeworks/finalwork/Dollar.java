package perminov.otus.homeworks.finalwork;

public class Dollar extends Currency{

    private String[] forms = new String[]{"доллар","доллара","долларов"};

    public Dollar(String name) {
        super(name);
    }

    @Override
    public String[] getForms() {
        return forms;
    }

    @Override
    public void setForms(String[] forms) {
        this.forms = forms;
    }
}