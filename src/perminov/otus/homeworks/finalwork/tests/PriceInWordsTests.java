package perminov.otus.homeworks.finalwork.tests;

import perminov.otus.homeworks.finalwork.ConvertNumberToString;
import perminov.otus.homeworks.finalwork.PriceInWords;
import perminov.otus.homeworks.finalwork.Terminal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PriceInWordsTests {
    public void testOutput(){
        String scenario = "Тест вывода результата: ";
        String expectResult = "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять рублей";

        PrintStream oldConsole = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newConsole = new PrintStream(byteArrayOutputStream);

        System.setOut(newConsole);

        PriceInWords priceInWords = new PriceInWords();
        ConvertNumberToString cns = new ConvertNumberToString();
        Terminal terminal = new Terminal();
        priceInWords.startConverter(cns, terminal);

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
        priceInWords.startConverter(new ConvertNumberToString(), null);
        try {
            System.out.println(scenario + " пройден");
        } catch (NullPointerException e){
            System.err.println(scenario + "не пройден: объект Game не проверяет входящие объекты на null");
        }
    }
}
