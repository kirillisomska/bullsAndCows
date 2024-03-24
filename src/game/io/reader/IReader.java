package game.io.reader;

import java.io.FileNotFoundException;

public interface IReader {
    int readNumber(int digits, boolean repeatable) throws FileNotFoundException;
}
