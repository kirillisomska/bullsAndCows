package game.io.validation;

public class Validation {
    public static boolean validateNumber(int checkedNumber, boolean repeatable, int maxNumberLength) {
        String numberStr = Integer.toString(checkedNumber);

        if (numberStr.length() > maxNumberLength) {
            return false;
        }

        return repeatable || numberStr.chars().distinct().count() >= numberStr.length();
    }

    public Validation() {
    }
}
