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
        return (Character.isLetter(ch) || isUkrainianLetter(ch));
    }

    private static boolean isUkrainianLetter(char ch) {
        return (ch >= 1040 && ch <= 1071) || (ch >= 1072 && ch <= 1103) ||
               ch == 1028 || ch == 1106 || ch == 1027 || ch == 1105 || 
               ch == 1030 || ch == 1110;
    }
}
