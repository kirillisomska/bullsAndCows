package game.io.reader;

import game.io.validation.Validation;
import game.io.writer.IWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FileReader implements IReader {
    private final IWriter writer;
    private final String pathToFile;

    public FileReader(IWriter writer, String pathToFile) {
        this.writer = writer;
        this.pathToFile = pathToFile;
    }

    @Override
    public int readNumber(int digits, boolean repeatable) throws FileNotFoundException {
        File file = new File(pathToFile);
        Scanner scanner = new Scanner(file);

        int number = scanner.nextInt();

        while (!Validation.validateNumber(number, repeatable, digits)) {
            writer.writeMessage("Incorrect input in the file, try again: ");
            number = scanner.nextInt();
        }

        scanner.close();

        return number;
    }
}
