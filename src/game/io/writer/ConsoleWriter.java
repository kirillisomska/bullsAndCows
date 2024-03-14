package game.io.writer;

public class ConsoleWriter implements IWriter {
    @Override
    public void writeMessage(String message) {
        System.out.println(message);
    }
}
