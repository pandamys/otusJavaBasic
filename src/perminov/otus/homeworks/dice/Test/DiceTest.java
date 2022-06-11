package perminov.otus.homeworks.dice.Test;

import perminov.otus.homeworks.dice.game.Dice;

public class DiceTest implements Dice {

    private int start = 6;

    @Override
    public int roll() {
        start--;
        return start;
    }
}
