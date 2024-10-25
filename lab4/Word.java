package lab4;
public class Word {
    private Letter[] letters;

    public Word(String word) {
        letters = new Letter[word.length()];
        for (int i = 0; i < word.length(); i++) {
            letters[i] = new Letter(word.charAt(i));
        }
    }

    public String getValue() {
        StringBuilder wordValue = new StringBuilder();
        for (Letter letter : letters) {
            if (letter != null) {
                wordValue.append(letter.getValue());
            }
        }
        return wordValue.toString();
    }

    public int length() {
        return letters.length;
    }
}

