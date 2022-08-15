package perminov.otus.homeworks.finalwork;

/**
 * main entry point
 */
public class PriceInWords {
    private static Currency currency;
    private static Integer number;

    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        ConvertNumberToString cnt = new ConvertNumberToString();
        startConverter(cnt, terminal);
    }

    public static void startConverter(Converter converter, ReadConsole terminal){
        String result, currencyName;

        currencyName = terminal.getCurrency();
        currency = Currency.getCurrency(currencyName);
        terminal.showCurrency(currency.getName());
        try {
            String line = terminal.readConsole("Введите только цифры");
            number = Integer.parseInt(line);
        } catch (NumberFormatException e){System.err.println("Введены не только цифры");}
        result = converter.convert(currency, number);
        terminal.showResult(result);
        terminal.close();
    }
}
