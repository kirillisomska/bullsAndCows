package game.player;

import game.io.writer.IReader;

public class HumanPlayer implements IPlayer {
    private final IReader reader;
    @Override
    public int[] generateSeed(int maxNumberLength, boolean isRepeatable) {
        return reader.readNumber(maxNumberLength, isRepeatable);
    }

    @Override
    public int[] guessNumber(int maxNumberLength, boolean isRepeatable) {
        return reader.readNumber(maxNumberLength, isRepeatable);
    }

    public HumanPlayer(IReader reader) {
        this.reader = reader;
    }
}
