package lab4;

/**
 * The TextProcessor class processes a Text object by replacing words of a specified 
 * length with a replacement word.
 */
public class TextProcessor {
    private Text text;
    private int wordLength;
    private Word replacement;

    /**
     * Constructs a TextProcessor with the specified text, word length, and replacement word.
     *
     * @param text the Text object to be processed
     * @param wordLength the length of words to be replaced
     * @param replacement the Word object to replace matching words
     * @throws IllegalArgumentException if text is null or if wordLength is not in the range 1-30
     */
    public TextProcessor(Text text, int wordLength, Word replacement) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null.");
        }
        if (wordLength < 1 || wordLength > 30) {
            throw new IllegalArgumentException("Word length must be set between 1 and 30.");
        }

        this.text = text;
        this.wordLength = wordLength;
        this.replacement = replacement;
    }

    /**
     * Processes the text by replacing words of the specified length with the replacement word.
     *
     * @return the processed text as a String
     */
    public String processText() {
        StringBuilder result = new StringBuilder();

        for (Sentence sentence : text.getSentences()) {
            for (int i = 0; i < sentence.getElements().length; i++) {
                Object element = sentence.getElements()[i];

                if (element instanceof Word) {
                    Word word = (Word) element;
                    if (word.length() == wordLength) {
                        result.append(replacement.getValue());
                    } else {
                        result.append(word.getValue());
                    }
                } else if (element instanceof Punctuation) {
                    Punctuation punctuation = (Punctuation) element;
                    result.append(punctuation.getValue());
                }
            }
            result.append(" "); 
        }

        return result.toString().trim(); // Trim to remove trailing whitespace
    }
}
