package lab2;

public class StringApplication {

    public static void main(String[] args) {
        
        StringBuilder text = new StringBuilder("This is a @simple test 4444 for string processing. There are some, and others. Українська теж працює!");
        int wordLength = 4;
        StringBuilder replacement = new StringBuilder("!!!!");
            
        try {
            TextProcessor textProcessor = new TextProcessor(text, wordLength, replacement);

            System.out.println();
            System.out.println("Input text:     " + text);

            StringBuilder processedText = textProcessor.replaceWords();

            System.out.println("Processed text: " + processedText);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.err.println("Input validation error: " + e.getMessage());
            System.out.println();
        } catch (Exception e) {
            System.out.println();
            System.err.println("An unexpected error occurred: " + e.getMessage());
            System.out.println();
        }
    }
}


