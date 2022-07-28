package perminov.otus.homeworks.finalwork;

public interface ReadConsole {
    String readConsole(String question);

    String getCurrency();

    void showCurrency(String currency);

    void showResult(String result);

    void close();
}
