package lab4;

public class Text {
    private Sentence[] sentences;

    public Text(String text) {
        parseText(text);
    }

    private void parseText(String text) {
        String[] sentenceArray = text.split("(?<=[.!?])\\s*");
        sentences = new Sentence[sentenceArray.length];

        for (int i = 0; i < sentenceArray.length; i++) {
            sentences[i] = new Sentence(sentenceArray[i].trim());
        }
    }

    public Sentence[] getSentences() {
        return sentences;
    }
}
