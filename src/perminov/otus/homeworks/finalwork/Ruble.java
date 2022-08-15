package perminov.otus.homeworks.finalwork;

public class Ruble extends Currency {

    private String[] forms = new String[]{"рубль","рубля","рублей"};

    public Ruble(String name) {
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
