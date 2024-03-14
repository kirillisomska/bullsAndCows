import game.IGame;
import game.IGameFactory;
import game.MultiplayerGameFactory;
import game.io.writer.*;

import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IWriter writer = new ConsoleWriter();
        IReader reader = new ConsoleReader(writer);

        IGameFactory gameFactory = new MultiplayerGameFactory();

        IGame game = gameFactory.createGame(4, false, writer, reader);
        game.play();

    }
}