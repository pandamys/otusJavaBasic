package perminov.otus.homeworks.dice.Test;

import perminov.otus.homeworks.dice.game.GameWinnerPrinter;
import perminov.otus.homeworks.dice.game.Player;

import java.util.ArrayList;

public class GameWinnerConsolePrinterTest implements GameWinnerPrinter {

    private Player winnerPlayer;

    @Override
    public void printWinner(Player winner) {
        winnerPlayer = winner;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }
}
