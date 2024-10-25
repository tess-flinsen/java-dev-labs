package lab4;

/**
 * The Text class represents a collection of sentences, allowing for text manipulation 
 * and processing.
 */
public class Text {
    private Sentence[] sentences;

    /**
     * Constructs a Text object from the specified string.
     *
     * @param text the string representation of the text
     * @throws IllegalArgumentException if the text is null or empty
     */
    public Text(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        // Replace sequences of tabs and spaces with a single space
        text = replaceWhitespace(text);
        sentences = parseText(text);
    }

    /**
     * Replaces sequences of whitespace (spaces and tabs) with a single space.
     *
     * @param text the original text
     * @return the modified text with replaced whitespace
     */
    private String replaceWhitespace(String text) {
        return text.replaceAll("[\\s]+", " "); // Replaces one or more whitespace characters with a single space
    }

    /**
     * Parses the text into sentences based on sentence-ending punctuation.
     *
     * @param text the text to parse
     * @return an array of Sentence objects created from the text
     */
    private Sentence[] parseText(String text) {
        String[] sentenceStrings = text.split("(?<=[.!?])\\s*"); // Split on sentence endings
        Sentence[] sentencesArray = new Sentence[sentenceStrings.length];

        for (int i = 0; i < sentenceStrings.length; i++) {
            sentencesArray[i] = new Sentence(sentenceStrings[i]);
        }

        return sentencesArray;
    }

    /**
     * Returns the sentences in this text.
     *
     * @return an array of Sentence objects
     */
    public Sentence[] getSentences() {
        return sentences;
    }
}
