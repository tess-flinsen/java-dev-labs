package lab4;

public class StringApplication {

    public static void main(String[] args) {
        String inputText = "This is a simple test! Українська теж працює, при тому завжди?";
        Text text = new Text(inputText);
        
        for (Sentence sentence : text.getSentences()) {
            System.out.println("Sentence:");
            for (Word word : sentence.getWords()) {
                System.out.print(word.getValue() + " ");
            }
            for (Punctuation punctuation : sentence.getPunctuations()) {
                System.out.print(punctuation.getValue() + " ");
            }
            System.out.println();
        }
    }
}


