package game.logic;

import dto.GameProgressResult;
import exception.IncorrectNumberLengthException;
import game.configuration.GameConfiguration;
import game.configuration.GameRules;
import game.player.ComputerPlayer;

import java.util.List;
import java.util.stream.IntStream;

public class SoloGameLogic implements IGameLogic {
    private final GameConfiguration gameConfiguration;
    private final List<Integer> secretNumber;
    private boolean isGameEnd;

    public SoloGameLogic(GameConfiguration gameConfiguration, ComputerPlayer computerPlayer) {
        this.gameConfiguration = gameConfiguration;
        int computerSecretNumber = computerPlayer.generateSeed(gameConfiguration.getMaxNumberLength(), gameConfiguration.getGameRules() == GameRules.REPEATABLE);
        this.secretNumber = String.valueOf(computerSecretNumber).chars()
                .map(Character::getNumericValue)
                .boxed()
                .toList();
        this.isGameEnd = false;
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

        long bulls = IntStream.range(0, guessIntList.size())
                .filter(i -> secretNumber.get(i).equals(guessIntList.get(i)))
                .count();

        long cows = guessIntList.stream()
                .filter(secretNumber::contains)
                .count() - bulls;

        if (bulls == gameConfiguration.getMaxNumberLength()) {
            this.isGameEnd = true;
        }

        return new GameProgressResult(number, (int) cows, (int) bulls, isGameEnd);
    }
}