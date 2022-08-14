package perminov.otus.homeworks.finalwork.tests;

import perminov.otus.homeworks.finalwork.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PriceInWordsTests {
    public void testOutput(){
        String scenario = "Тест вывода результата: ";
        String expectResult = "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять рублей\r\n";

        PrintStream oldConsole = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newConsole = new PrintStream(byteArrayOutputStream);

        System.setOut(newConsole);

        PriceInWords priceInWords = new PriceInWords();
        priceInWords.startConverter(new ConvertNumberToString(), new TerminalTest());

        String result = byteArrayOutputStream.toString();
        System.setOut(oldConsole);

        if (expectResult.equals(result)){
            System.out.println(scenario + "пройден");
        } else {
            System.err.println(scenario + "результат отличается от ожидаемого");
        }
    }

    public void testNull(){
        String scenario = "Тест проверки входящих объектов на null: ";
        PriceInWords priceInWords = new PriceInWords();
        try {
            priceInWords.startConverter(new ConvertNumberToString(), null);
            System.out.println(scenario + " пройден");
        } catch (NullPointerException e){
            System.err.println(scenario + "не пройден: объект PriceInWords не проверяет входящие объекты на null");
        }
    }

    public void testCurrency(){
        String scenario = "Тест проверки на введённую валюту: ";
        String expectResult = "Нет справочника для данной валюты!\r\n";

        PrintStream oldConsole = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newConsole = new PrintStream(byteArrayOutputStream);

        System.setOut(newConsole);

        PriceInWords priceInWords = new PriceInWords();
        priceInWords.startConverter(new ConvertNumberToString(), new TerminalTestCurrency());

        String result = byteArrayOutputStream.toString();
        System.setOut(oldConsole);

        if (expectResult.equals(result)){
            System.out.println(scenario + "пройден");
        } else {
            System.err.println(scenario + "результат отличается от ожидаемого");
        }
    }

    public void testConvertNumberToString(){
        String scenario = "Тест проверки конвертации строки в цифры: ";
        String expectResult = "двести тридцать пять тысяч сто семьдесят четыре";

        ConvertNumberToString cnt = new ConvertNumberToString();
        String result = cnt.calculatePartOfNumber(235174);

        if (expectResult.equals(result)){
            System.out.println(scenario + "пройден");
        } else {
            System.err.println(scenario + "результат отличается от ожидаемого");
        }
    }

    public void testCorrectCurrencyForm(){
        String scenario = "Тест правильного выбора падежа для валюты: ";
        String expectResult = "рублей";

        Ruble ruble = new Ruble("рубль");
        String result = Currency.getFormCurrency(ruble, 17);

        if (expectResult.equals(result)){
            System.out.println(scenario + "пройден");
        } else {
            System.err.println(scenario + "результат отличается от ожидаемого");
        }
    }
}
