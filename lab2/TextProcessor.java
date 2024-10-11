package lab2;

public class TextProcessor {

    private StringBuilder text;
    private int wordLength;
    private StringBuilder replacement;

    public TextProcessor(StringBuilder text, int wordLength, StringBuilder replacement) throws IllegalArgumentException {
        if (text == null || replacement == null) {
            throw new IllegalArgumentException("Text or replacement cannot be null.");
        }

        if (text.length() == 0) {
            throw new IllegalArgumentException("Input text cannot be empty.");
        }

        if (replacement.length() == 0) {
            throw new IllegalArgumentException("Replacement string cannot be empty.");
        }

        if (text.length() > 1000) {
            throw new IllegalArgumentException("Input text must not be longer than 1000 characters.");
        }

        if (replacement.length() > 100) {
            throw new IllegalArgumentException("Replacement text must not be longer than 100 characters.");
        }

        if (wordLength < 1 || wordLength > 30) {
            throw new IllegalArgumentException("Word length must be set between 1 and 30.");
        }

        this.text = text;
        this.wordLength = wordLength;
        this.replacement = replacement;
    }

    public StringBuilder replaceWords() {
        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (isLetter(currentChar)) {
                currentWord.append(currentChar); 
            } else {   // Process the word if it's complete
                appendProcessedWord(result, currentWord);
                result.append(currentChar); 
                currentWord.setLength(0); // Reset for the next word
            }
        }

        if (currentWord.length() > 0) {  // Handle the last word if there is one
            appendProcessedWord(result, currentWord);
        }

        return result;
    }

    private void appendProcessedWord(StringBuilder result, StringBuilder word) {
        if (word.length() == wordLength) {
            result.append(replacement); 
        } else if (word.length() > 0) {
            result.append(word); 
        }
    }

    private boolean isLetter(char ch) {
        // Check for English letters
        if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) { // 'A'-'Z' or 'a'-'z'
            return true;
        }
        // Check for Ukrainian letters
        if ((ch >= 1040 && ch <= 1071) || (ch >= 1072 && ch <= 1103) || // 'А'-'Я' or 'а'-'я'
            ch == 1028 || ch == 1106 || // 'Є' or 'є'
            ch == 1027 || ch == 1105 || // 'Ї' or 'ї'
            ch == 1030 || ch == 1110) { // 'І' or 'і'
            return true;
        }
        
        return false;
    }
}
