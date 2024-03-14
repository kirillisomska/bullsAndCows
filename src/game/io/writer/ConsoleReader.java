package game.io.writer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConsoleReader implements IReader {
    private IWriter writer;
    public int[] readNumber(int digits, boolean repeatable) {
        Scanner scanner = new Scanner(System.in);
        int[] number = new int[digits];
        boolean validInput = false;

        while (!validInput) {
            writer.writeMessage("Enter a number with " + digits + " digits (repeating digits are " + (repeatable ? "allowed" : "not allowed") + "):");
            String input = scanner.nextLine();
            if (input.length() != digits) {
                writer.writeMessage("The entered number does not contain " + digits + " digits. Please try again.");
                continue;
            }

            Set<Character> uniqueChars = new HashSet<>();
            for (char c : input.toCharArray()) {
                if (!Character.isDigit(c)) {
                    writer.writeMessage("The entered number contains invalid characters. Please try again.");
                    continue;
                }

                if (repeatable) {
                    uniqueChars.add(c);
                } else {
                    if (uniqueChars.contains(c)) {
                        writer.writeMessage("The entered number contains repeating digits. Please try again.");
                        continue;
                    }
                    uniqueChars.add(c);
                }
            }

            validInput = true;
            for (int i = 0; i < digits; i++) {
                number[i] = input.charAt(i) - '0';
            }
        }

        return number;
    }

    public ConsoleReader(IWriter writer) {
        this.writer = writer;
    }
}
