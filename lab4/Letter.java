package lab4;

public class Letter {
    private char value;

    public Letter(char value) {
        if (!isLetter(value)) {
            throw new IllegalArgumentException("Invalid letter: " + value);
        }
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static boolean isLetter(char ch) {
        return Character.isLetter(ch);
    }
}
