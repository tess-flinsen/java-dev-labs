package lab4;

public class Sentence {
    private Word[] words;
    private Punctuation[] punctuations;

    public Sentence(String sentence) {
        parseSentence(sentence);
    }

    private void parseSentence(String sentence) {
        StringBuilder currentWord = new StringBuilder();
        StringBuilder punctuationBuilder = new StringBuilder();
        int wordCount = 0;
        int punctuationCount = 0;

        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            if (Letter.isLetter(currentChar)) {
                currentWord.append(currentChar);
            } else if (Punctuation.isPunctuation(currentChar)) {
                if (currentWord.length() > 0) {
                    wordCount++;
                    currentWord.setLength(0); // Reset for the next word
                }
                punctuationBuilder.append(currentChar);
            }
        }

        // Handle the last word and punctuation
        if (currentWord.length() > 0) {
            wordCount++;
        }
        if (punctuationBuilder.length() > 0) {
            punctuationCount = punctuationBuilder.length();
        }

        // Initialize arrays
        words = new Word[wordCount];
        punctuations = new Punctuation[punctuationCount];

        // Fill the words array
        currentWord.setLength(0); // Reset for reuse
        int wordIndex = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char currentChar = sentence.charAt(i);

            if (Letter.isLetter(currentChar)) {
                currentWord.append(currentChar);
            } else if (Punctuation.isPunctuation(currentChar)) {
                if (currentWord.length() > 0) {
                    words[wordIndex++] = new Word(currentWord.toString());
                    currentWord.setLength(0);
                }
                punctuations[punctuationCount++] = new Punctuation(currentChar);
            }
        }

        // Handle the last word if any
        if (currentWord.length() > 0) {
            words[wordIndex] = new Word(currentWord.toString());
        }
    }

    public Word[] getWords() {
        return words;
    }

    public Punctuation[] getPunctuations() {
        return punctuations;
    }
}
