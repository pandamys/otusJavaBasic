package perminov.otus.homeworks.dice.Test;

import perminov.otus.homeworks.dice.game.DiceImpl;
import perminov.otus.homeworks.dice.game.Game;
import perminov.otus.homeworks.dice.game.GameWinnerConsolePrinter;
import perminov.otus.homeworks.dice.game.Player;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DiceGameTest {

    public void testNumberRandom(){
        String scenario = "Тест выпавших костей: ";
        int r;
        DiceImpl dice = new DiceImpl();

        try {
            for (int i = 0; i < 30; i++) {
                r = dice.roll();
                if (r < 1 || r > 6) {
                    throw new Exception("Ошибка");
                }
            }
            System.out.println(scenario + " пройден");
        } catch (Exception e){System.err.println(scenario + "не пройден: выпало число больше/меньше, чем количество граней кубика");}
    }

    public void testOutput(){
        String scenario = "Тест вывода результата: ";
        String name = "Виталий";
        String expectResult = "Победитель: " + name + "\r\n";

        PrintStream oldConsole = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newConsole = new PrintStream(byteArrayOutputStream);

        System.setOut(newConsole);

        Player player = new Player(name);
        Game game = new Game(new DiceImpl(), new GameWinnerConsolePrinter());
        game.playGame(player, player);

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

        try {
            Player player = new Player("Андрей");
            Game game = new Game(null, new GameWinnerConsolePrinter());
            game.playGame(player, player);
            System.out.println(scenario + " пройден");
        } catch (NullPointerException e){
            System.err.println(scenario + "не пройден: объект Game не проверяет входящие объекты на null");
        }
    }

    public void testWinner(){
        String scenario = "Тест проверки объекта-результата: ";
        Player player1 = new Player("Андрей");
        Player player2 = new Player("Илья");

        GameWinnerConsolePrinterTest gameWinnerConsolePrinterTest = new GameWinnerConsolePrinterTest();
        DiceTest diceTest = new DiceTest();

        Game game = new Game(diceTest, gameWinnerConsolePrinterTest);
        game.playGame(player1, player2);

        if (gameWinnerConsolePrinterTest.getWinnerPlayer().equals(player2)){
            System.out.println(scenario + "пройден");
        } else {
            System.err.println(scenario + "результат отличается от ожидаемого");
        }
    }

    public void testDraw(){
        String scenario = "Тест проверки на ничью: ";
        String expectResult = "У нас ничья";

        Player player1 = new Player("Андрей");
        Player player2 = new Player("Илья");

        GameWinnerConsolePrinterTest gameWinnerConsolePrinterTest = new GameWinnerConsolePrinterTest();
        DiceDraw diceDraw = new DiceDraw();

        PrintStream oldConsole = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newConsole = new PrintStream(byteArrayOutputStream);

        System.setOut(newConsole);

        Game game = new Game(diceDraw, gameWinnerConsolePrinterTest);
        game.playGame(player1, player2);

        String result = byteArrayOutputStream.toString();
        System.setOut(oldConsole);

        if (expectResult.equals(result)){
            System.out.println(scenario + "пройден");
        } else {
            System.err.println(scenario + "результат отличается от ожидаемого");
        }
    }
}
