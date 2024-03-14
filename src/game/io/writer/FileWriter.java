package game.io.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter implements IWriter {
    private final PrintWriter writer;
    public FileWriter(String filePath) throws FileNotFoundException {
        this.writer = new PrintWriter(new File(filePath));
    }

    @Override
    public void writeMessage(String message) {
        writer.println(message);
    }

    public void close() {
        writer.close();
    }
}
