package game;

import game.io.writer.IWriter;
import game.player.ComputerPlayer;
import game.player.IPlayer;

import java.util.Arrays;

public class SoloGame implements IGame {
    private final int maxNumberLength;
    private final boolean isRepeatable;

    private final IPlayer player;

    private final IWriter writer;

    private boolean gameFinish = false;

    private int stepsCount = 0;

    private final int[] secretNumber;

    @Override
    public void play() {
        System.out.println(Arrays.toString(secretNumber));
        while (!gameFinish) {
            int[] guess = player.guessNumber(maxNumberLength, isRepeatable);
            calculateResult(guess);

            this.stepsCount += 1;
        }

        writer.writeMessage("Game finished. Steps count = " + stepsCount);
    }

    private void calculateResult(int[] guess) {
        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < maxNumberLength; i++) {
            int secretDigit = secretNumber[i];
            int guessDigit = guess[i];

            if (secretDigit == guessDigit) {
                bulls++;
            }
            if (Arrays.binarySearch(secretNumber, guessDigit) >= 0) {
                cows++;
            }
        }

        if (bulls == maxNumberLength) {
            this.gameFinish = true;
        }

        if (!gameFinish) {
            writer.writeMessage("Cows " + cows + " , bulls " + bulls);
        }
    }

    public SoloGame(int maxNumberLength, boolean isRepeatable, IPlayer player, IWriter writer) {
        this.maxNumberLength = maxNumberLength;
        this.isRepeatable = isRepeatable;
        this.player = player;
        this.writer = writer;
        IPlayer computerPlayer = new ComputerPlayer();
        this.secretNumber = computerPlayer.generateSeed(maxNumberLength, isRepeatable);
    }
}
