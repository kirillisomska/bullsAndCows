package game.logic;

import dto.GameProgressResult;
import exception.IncorrectNumberLengthException;

public interface IGameLogic {
    GameProgressResult makeAssumption(int number) throws IncorrectNumberLengthException, GameAlreadyEndException;
}
