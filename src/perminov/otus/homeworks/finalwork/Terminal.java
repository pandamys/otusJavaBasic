package perminov.otus.homeworks.finalwork;

import java.util.Scanner;

public class Terminal implements ReadConsole {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String readConsole(String question) {
        String line = null;
        System.out.println(question);
        try {
            line = scanner.nextLine();
        } catch (NullPointerException e){System.out.println(e.getMessage());}

        return line;
    }

    public String getCurrency(){
        return readConsole("Введите валюту");
    }

    public void showCurrency(String currency){
        System.out.println("Работаем с валютой: " + currency);
    }

    public void showResult(String result){
        System.out.println(result);
    }

    public void close(){
        scanner.close();
    }
}
