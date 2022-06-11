package perminov.otus.homeworks.dice.Test;

import perminov.otus.homeworks.dice.game.Dice;

public class DiceDraw implements Dice {
    @Override
    public int roll() {
        return 2;
    }
}
