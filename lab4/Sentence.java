package lab4;

/**
 * The Sentence class represents a sentence composed of words and punctuation.
 */
public class Sentence {
    private Object[] elements; // Can hold both Word and Punctuation

    /**
     * Constructs a Sentence from the specified string.
     *
     * @param sentence the string representation of the sentence
     * @throws IllegalArgumentException if the sentence is null or empty
     */
    public Sentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence cannot be null or empty.");
        }

        elements = new Object[sentence.length()]; // Initialize to the maximum possible length
        parseSentence(sentence);
    }

    /**
     * Parses the given sentence into words and punctuation marks.
     *
     * @param sentence the string representation of the sentence to be parsed
     */
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

    /**
     * Returns the elements of this sentence, which may include words and punctuation.
     *
     * @return an array of elements (Word and Punctuation) in this sentence
     */
    public Object[] getElements() {
        return elements;
    }
}
