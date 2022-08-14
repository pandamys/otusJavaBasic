package perminov.otus.homeworks.finalwork.tests;

import perminov.otus.homeworks.finalwork.ReadConsole;

public class TerminalTestCurrency implements ReadConsole {
    @Override
    public String readConsole(String question) {
        return "123456789";
    }

    @Override
    public String getCurrency(){
        return "доллар";
    }

    @Override
    public void showCurrency(String currency) {

    }

    @Override
    public void showResult(String result){
        System.out.println(result);
    }

    @Override
    public void close() {

    }
}