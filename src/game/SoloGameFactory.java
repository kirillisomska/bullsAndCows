package game;

import game.configuration.GameConfiguration;
import game.io.reader.IReader;
import game.io.writer.IWriter;
import game.logic.SoloGameLogic;
import game.player.ComputerPlayer;

public class SoloGameFactory implements IGameFactory {
    public SoloGameFactory() {
    }

    @Override
    public IGame createGame(GameConfiguration gameConfiguration, IWriter writer, IReader reader) {
        SoloGameLogic gameLogic = new SoloGameLogic(gameConfiguration, new ComputerPlayer());
        return new SoloGame(writer, reader, gameLogic, gameConfiguration);
    }
}
