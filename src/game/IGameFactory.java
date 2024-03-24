package game;

import game.configuration.GameConfiguration;
import game.io.reader.IReader;
import game.io.writer.IWriter;

public interface IGameFactory {
    IGame createGame(GameConfiguration gameConfiguration, IWriter writer, IReader reader);
}
