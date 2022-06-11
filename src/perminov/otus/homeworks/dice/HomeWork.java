package perminov.otus.homeworks.dice;


import perminov.otus.homeworks.dice.Test.DiceGameTest;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше

        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {
        DiceGameTest test = new DiceGameTest();
        test.testNumberRandom();
        test.testOutput();
        test.testNull();
        test.testWinner();
        test.testDraw();
    }
    
}