package lab4;

public class Word {
    private Letter[] letters;

    public Word(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty.");
        }

        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!Letter.isLetter(currentChar)) { // Ensure only valid letters are added
                throw new IllegalArgumentException("Invalid character in word: " + currentChar);
            }
            letters[i] = new Letter(currentChar);
        }
    }

    public String getValue() {
        StringBuilder wordValue = new StringBuilder();
        for (Letter letter : letters) {
            wordValue.append(letter.getValue());
        }
        return wordValue.toString();
    }

    public int length() {
        return letters.length; // This is still valid; you could also track the number of letters added
    }
}
