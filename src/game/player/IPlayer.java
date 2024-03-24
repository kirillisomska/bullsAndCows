package game.player;

import java.io.FileNotFoundException;

public interface IPlayer {
    int generateSeed(int maxNumberLength, boolean isRepeatable) throws FileNotFoundException;
}
