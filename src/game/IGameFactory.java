package game;

import game.io.writer.IReader;
import game.io.writer.IWriter;
import game.player.IPlayer;

public interface IGameFactory {
    IGame createGame(int maxNumberLength, boolean isRepeatable, IWriter writer, IReader reader);
}
