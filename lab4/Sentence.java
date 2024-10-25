package lab4;

public class Sentence {
    private Object[] elements; // Can hold both Word and Punctuation

    public Sentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence cannot be null or empty.");
        }

        elements = new Object[sentence.length()]; // Initialize to the maximum possible length
        parseSentence(sentence);
    }

    private void parseSentence(String sentence) {
        StringBuilder currentWord = new StringBuilder();
        int count = 0;

        for (char ch : sentence.toCharArray()) {
            if (Letter.isLetter(ch)) {
                currentWord.append(ch);
            } else if (Punctuation.isPunctuation(ch)) {
                if (currentWord.length() > 0) {
                    elements[count++] = new Word(currentWord.toString());
                    currentWord.setLength(0);
                }
                elements[count++] = new Punctuation(ch);
            } else if (ch == ' ') {
                if (currentWord.length() > 0) {
                    elements[count++] = new Word(currentWord.toString());
                    currentWord.setLength(0);
                    elements[count++] = new Punctuation(ch);
                }
            }
        }

        // Add last word if exists
        if (currentWord.length() > 0) {
            elements[count++] = new Word(currentWord.toString());
        }

        // Create final array with the correct size
        Object[] finalElements = new Object[count];
        System.arraycopy(elements, 0, finalElements, 0, count);
        elements = finalElements; // Assign the finalized array back
    }

    public Object[] getElements() {
        return elements;
    }
}
