import game.IGame;
import game.SoloGame;
import game.io.writer.ConsoleReader;
import game.io.writer.ConsoleWriter;
import game.io.writer.IReader;
import game.io.writer.IWriter;
import game.player.HumanPlayer;
import game.player.IPlayer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IWriter writer = new ConsoleWriter();
        IReader reader = new ConsoleReader(writer);

        IPlayer player = new HumanPlayer(reader);
        IGame game = new SoloGame(4, true, player, writer);
        game.play();

    }
}