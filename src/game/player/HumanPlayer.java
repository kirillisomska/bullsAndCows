package game.player;

import game.io.reader.IReader;

import java.io.FileNotFoundException;

public class HumanPlayer implements IPlayer {
    private final IReader reader;
    @Override
    public int generateSeed(int maxNumberLength, boolean isRepeatable) throws FileNotFoundException {
        return reader.readNumber(maxNumberLength, isRepeatable);
    }

    public HumanPlayer(IReader reader) {
        this.reader = reader;
    }
}
