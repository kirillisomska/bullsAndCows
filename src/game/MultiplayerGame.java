package game;

import game.io.writer.IWriter;
import game.player.IPlayer;

public class MultiplayerGame implements IGame {
    private final int maxNumberLength;
    private final boolean isRepeatable;

    private final IPlayer firstPlayer;
    private final IPlayer secondPlayer;

    private final IWriter writer;

    private boolean gameFinish = false;

    private int stepsCount = 0;

    private final int[] firstPlayerSecretNumber;
    private final int[] secondPlayerSecretNumber;

    @Override
    public void play() {

        while (!gameFinish) {
            this.stepsCount += 1;
            writer.writeMessage("First player guess number");
            boolean firstPlayerFinish = calculateResult(firstPlayer.guessNumber(maxNumberLength, isRepeatable), secondPlayerSecretNumber);

            writer.writeMessage("Second player guess number");
            boolean secondPlayerFinish = calculateResult(secondPlayer.guessNumber(maxNumberLength, isRepeatable), firstPlayerSecretNumber);

            if (secondPlayerFinish) {
                writer.writeMessage("Second player win. Steps " + stepsCount);
                gameFinish = true;
                break;
            }

            if (firstPlayerFinish) {
                writer.writeMessage("First player win. Steps " + stepsCount);
                gameFinish = true;
            }
        }
    }

    private boolean calculateResult(final int[] guess, final int[] secretNumber) {
        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < secretNumber.length; i++) {
            int secretDigit = secretNumber[i];
            int guessDigit = guess[i];

            if (secretDigit == guessDigit) {
                bulls++;
            }
            if (contains(secretNumber, guessDigit)) {
                cows++;
            }
        }

        if (bulls == maxNumberLength) {
            return true;
        }

        writer.writeMessage("Cows " + cows + " , bulls " + bulls);

        return false;
    }

    private boolean contains(int[] array, int value) {
        for (int j : array) {
            if (j == value) {
                return true;
            }
        }
        return false;
    }

    public MultiplayerGame(int maxNumberLength, boolean isRepeatable, IPlayer firstPlayer, IPlayer secondPlayer, IWriter writer) {
        this.maxNumberLength = maxNumberLength;
        this.isRepeatable = isRepeatable;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.writer = writer;
        writer.writeMessage("First player enter number");
        this.firstPlayerSecretNumber = firstPlayer.generateSeed(maxNumberLength, isRepeatable);
        writer.writeMessage("Second player enter number");
        this.secondPlayerSecretNumber = secondPlayer.generateSeed(maxNumberLength, isRepeatable);
    }
}
