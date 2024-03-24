package game.player;

import java.util.HashSet;
import java.util.Random;

public class ComputerPlayer implements IPlayer {
    @Override
    public int generateSeed(int maxNumberLength, boolean isRepeatable) {
        Random random = new Random();
        StringBuilder seed = new StringBuilder();
        while (seed.length() < maxNumberLength) {
            int digit = random.nextInt(10);
            if (isRepeatable || seed.indexOf(String.valueOf(digit)) == -1) {
                seed.append(digit);
            }
        }
        return Integer.parseInt(seed.toString());
    }
}
