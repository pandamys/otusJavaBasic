package perminov.otus.homeworks.finalwork;

public class PriceInWords {
    private static String currency;
    private static Integer number;

    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        ConvertNumberToString cnt = new ConvertNumberToString();
        startConverter(cnt, terminal);
    }

    public static void startConverter(Converter converter, ReadConsole terminal){
        String result;

        currency = "рубли";//terminal.readConsole("Введите валюту");
        terminal.showCurrency(currency);
        try {
            String line = terminal.readConsole("Введите только цифры");
            number = Integer.parseInt(line);
        } catch (NumberFormatException e){System.err.println("Введены не только цифры");}
        result = converter.convert(currency, number);
        terminal.showResult(result);
        terminal.close();
    }
}
