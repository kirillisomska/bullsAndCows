package game;

import game.io.writer.IReader;
import game.io.writer.IWriter;
import game.player.HumanPlayer;
import game.player.IPlayer;

public class SoloGameFactory implements IGameFactory {
    public SoloGameFactory() {
    }

    @Override
    public IGame createGame(int maxNumberLength, boolean isRepeatable, IWriter writer, IReader reader) {
        IPlayer player = new HumanPlayer(reader);

        return new SoloGame(maxNumberLength, isRepeatable, player, writer);
    }
}
