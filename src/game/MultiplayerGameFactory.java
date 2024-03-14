package game;

import game.io.writer.IReader;
import game.io.writer.IWriter;
import game.player.HumanPlayer;
import game.player.IPlayer;

public class MultiplayerGameFactory implements IGameFactory {
    @Override
    public IGame createGame(int maxNumberLength, boolean isRepeatable, IWriter writer, IReader reader) {
        IPlayer firstPlayer = new HumanPlayer(reader);
        IPlayer secondPlayer = new HumanPlayer(reader);

        return new MultiplayerGame(maxNumberLength, isRepeatable, firstPlayer, secondPlayer, writer);
    }
}
