package game.player;

import java.util.HashSet;
import java.util.Random;

public class ComputerPlayer implements IPlayer {
    @Override
    public int[] generateSeed(int maxNumberLength, boolean isRepeatable) {
        int[] secretNumber = new int[maxNumberLength];
        Random random = new Random();
        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < maxNumberLength; i++) {
            if (isRepeatable) {
                secretNumber[i] = random.nextInt(10);
            } else {
                while (true) {
                    int number = random.nextInt(10);
                    if (!uniqueNumbers.contains(number)) {
                        uniqueNumbers.add(number);
                        secretNumber[i] = number;
                        break;
                    }
                }
            }
        }
        return secretNumber;
    }

    @Override
    public int[] guessNumber(int maxNumberLength, boolean isRepeatable) {
        return new int[0];
    }
}
