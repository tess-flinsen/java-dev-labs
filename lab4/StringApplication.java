package lab4;

public class StringApplication {
    public static void main(String[] args) {
        String inputText = "This is a simple test for string processing. There are some, and others!";
        int wordLength = 4;
        Word replacement = new Word("lala");

        try {
            Text text = new Text(inputText);
            TextProcessor textProcessor = new TextProcessor(text, wordLength, replacement);

            System.out.println("Input text: " + inputText);
            String processedText = textProcessor.processText();
            System.out.println("\nProcessed text: " + processedText);
        } catch (IllegalArgumentException e) {
            System.err.println("Input validation error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
