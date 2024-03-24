package game;

import dto.GameProgressResult;
import exception.IncorrectNumberLengthException;
import game.configuration.GameConfiguration;
import game.configuration.GameRules;
import game.io.reader.IReader;
import game.io.writer.IWriter;
import game.logic.IGameLogic;

import java.io.FileNotFoundException;

public class SoloGame implements IGame {
    private final IWriter writer;
    private final IReader reader;

    private final IGameLogic gameLogic;

    private final GameConfiguration gameConfiguration;

    private int stepsCount = 0;

    @Override
    public void play() throws FileNotFoundException {
        int guess = reader.readNumber(gameConfiguration.getMaxNumberLength(), gameConfiguration.getGameRules() == GameRules.REPEATABLE);

        GameProgressResult assumptionResult = null;
        boolean gameFinish = false;

        try {
            assumptionResult = gameLogic.makeAssumption(guess);
        } catch (IncorrectNumberLengthException e) {
            throw new RuntimeException(e);
        }

        assert assumptionResult != null;
        writer.writeMessage("Cows = " + assumptionResult.getCowsCount() + " Bulls = " + assumptionResult.getBullsCount());

        while (!gameFinish) {
            guess = reader.readNumber(gameConfiguration.getMaxNumberLength(), gameConfiguration.getGameRules() == GameRules.REPEATABLE);
            try {
                assumptionResult = gameLogic.makeAssumption(guess);
            } catch (IncorrectNumberLengthException e) {
                throw new RuntimeException(e);
            }
            
            gameFinish = assumptionResult.isNumberGuessed();

            writer.writeMessage("Cows = " + assumptionResult.getCowsCount() + " Bulls = " + assumptionResult.getBullsCount());

            this.stepsCount += 1;
        }

        writer.writeMessage("Game finished. Steps count = " + stepsCount);
    }

    public SoloGame(IWriter writer, IReader reader, IGameLogic gameLogic, GameConfiguration gameConfiguration) {
        this.writer = writer;
        this.reader = reader;
        this.gameLogic = gameLogic;
        this.gameConfiguration = gameConfiguration;
    }
}
