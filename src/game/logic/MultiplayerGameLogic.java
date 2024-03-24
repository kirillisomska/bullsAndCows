package game.logic;

import dto.GameProgressResult;
import exception.IncorrectNumberLengthException;
import game.configuration.GameConfiguration;
import game.configuration.GameRules;

import java.util.List;
import java.util.stream.IntStream;

public class MultiplayerGameLogic implements IGameLogic {
    private final GameConfiguration gameConfiguration;
    private final List<Integer> firstPlayerSecretNumber;
    private final List<Integer> secondPlayerSecretNumber;
    private boolean isFirstPlayerStep;

    public MultiplayerGameLogic(GameConfiguration gameConfiguration, int firstPlayerSecretNumber, int secondPlayerSecretNumber) {
        this.gameConfiguration = gameConfiguration;
        this.firstPlayerSecretNumber = String.valueOf(firstPlayerSecretNumber).chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
        this.secondPlayerSecretNumber = String.valueOf(secondPlayerSecretNumber).chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
        this.isFirstPlayerStep = true;
    }

    @Override
    public GameProgressResult makeAssumption(int number) throws IncorrectNumberLengthException {
        List<Integer> guessIntList = String.valueOf(number).chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();

        if (guessIntList.size() > gameConfiguration.getMaxNumberLength()) {
            throw new IncorrectNumberLengthException("Maximum game number length is "
                    + gameConfiguration.getMaxNumberLength() + " but received " + guessIntList.size());
        }

        List<Integer> secretNumber = isFirstPlayerStep ? secondPlayerSecretNumber : firstPlayerSecretNumber;

        long bulls = IntStream.range(0, guessIntList.size())
                .filter(i -> secretNumber.get(i).equals(guessIntList.get(i)))
                .count();

        long cows = guessIntList.stream()
                .filter(secretNumber::contains)
                .count() - bulls;

        this.isFirstPlayerStep = !isFirstPlayerStep;

        return new GameProgressResult(number, (int) cows, (int) bulls, bulls == gameConfiguration.getMaxNumberLength());
    }
}
