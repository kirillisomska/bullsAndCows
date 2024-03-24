package game.io.reader;

import game.io.validation.Validation;
import game.io.writer.IWriter;

import java.util.Scanner;

public class ConsoleReader implements IReader {
    private final IWriter writer;
    public int readNumber(int digits, boolean repeatable) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        while (!Validation.validateNumber(number, repeatable, digits)) {
            writer.writeMessage("Incorrect input, try again: ");
            number = scanner.nextInt();
        }

        return number;
    }

    public ConsoleReader(IWriter writer) {
        this.writer = writer;
    }
}
