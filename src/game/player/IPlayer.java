package game.player;

public interface IPlayer {
    int[] generateSeed(int maxNumberLength, boolean isRepeatable);

    int[] guessNumber(int maxNumberLength, boolean isRepeatable);
}
