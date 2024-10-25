package lab4;

public class Punctuation {
    private char value;

    public Punctuation(char value) {
        if (!isPunctuation(value)) {
            throw new IllegalArgumentException("Invalid punctuation: " + value);
        }
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public static boolean isPunctuation(char ch) {
        return ",?!.:;()-".indexOf(ch) != -1;
    }
}
