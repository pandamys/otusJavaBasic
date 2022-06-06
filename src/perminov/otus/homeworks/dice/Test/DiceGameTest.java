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

        try {
            for (int i = 0; i < 30; i++) {
                r = new DiceImpl().roll();
                if (r < 1 || r > 6) {
                    throw new Throwable("Ошибка");
                }
            }
            System.out.println(scenario + " пройден");
        } catch (Throwable e){System.err.println(scenario + "не пройден: выпало число больше/меньше, чем количество граней кубика");}
    }

    public void testOutput(){
        String name = "Виталий";

        String scenario = "Тест вывода результата: ";
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
}
