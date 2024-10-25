package lab4;

public class Text {
    private Sentence[] sentences;

    public Text(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text cannot be null or empty.");
        }

        // Replace sequences of tabs and spaces with a single space
        text = replaceWhitespace(text);
        sentences = parseText(text);
    }

    private String replaceWhitespace(String text) {
        return text.replaceAll("[\\s]+", " "); // Replaces one or more whitespace characters (spaces, tabs) with a single space
    }

    private Sentence[] parseText(String text) {
        String[] sentenceStrings = text.split("(?<=[.!?])\\s*"); // Split on sentence endings
        Sentence[] sentencesArray = new Sentence[sentenceStrings.length];

        for (int i = 0; i < sentenceStrings.length; i++) {
            sentencesArray[i] = new Sentence(sentenceStrings[i]);
        }

        return sentencesArray;
    }

    public Sentence[] getSentences() {
        return sentences;
    }
}
