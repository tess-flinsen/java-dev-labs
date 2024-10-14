package lab3;

/**
 * The {@code ClothingApplication} class serves as the entry point for the clothing 
 * management application. It demonstrates the functionality of the 
 * {@code Clothing} and {@code ClothingManager} classes by creating clothing 
 * objects, sorting them, and finding a specific clothing item.
 * <p>
 * Example usage:
 * <pre>
 *     public static void main(String[] args) {
 *         ClothingApplication.main(args);
 *     }
 * </pre>
 * </p>
 */
public class ClothingApplication {

    /**
     * The main method that executes the clothing management application.
     * It creates an array of {@code Clothing} objects, sorts them, and 
     * attempts to find a specific clothing item in the array.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try {
            // Create an array of Clothing objects
            Clothing[] clothes = {
                new Clothing("Galaxy Tee", "M", 67.10, "Blue", "Cosmic Threads", "Cotton"),
                new Clothing("Stealth Cargo", "L", 49.99, "Black", "Urban Outfitters", "Denim"),
                new Clothing("Galaxy Tee", "S", 19.99, "Crimson Red", "Firefly Fashion", "Silk"),
                new Clothing("Eclipse Jacket", "M", 89.99, "Storm Gray", "Astral Apparel", "Wool"),
                new Clothing("Mystic Hoodie", "M", 35.50, "White", "Enchanted Styles", "Linen"),
                new Clothing("Rogue Leather Pants", "M", 79.99, "Olive", "Urban Outfitters", "Leather"),
                new Clothing("Vortex Windbreaker", "L", 55.50, "Green", "Astral Apparel", "Polyester")
            };
            
            // Create an instance of ClothingManager
            ClothingManager clothingManager = new ClothingManager();

            System.out.println("\n---Sorting---");
            System.out.println("\n* based on fields: 1) Name (ascending), 2) Price (descending) *\n");

            // Sort the array of clothing objects
            System.out.println("\nBefore sorting:");
            printClothingArray(clothes, clothingManager);

            clothingManager.sortClothing(clothes);

            System.out.println("\nAfter sorting:");
            printClothingArray(clothes, clothingManager);

            System.out.println("\n---Finding identical object---");

            // Create a target Clothing object to find
            Clothing targetClothing = new Clothing("Rogue Leather Pants", "M", 79.99, "Olive", "Urban Outfitters", "Leather");
            System.out.println("\nThe target clothing: ");
            clothingManager.printClothing(targetClothing);

            // Find the target clothing in the array
            Clothing foundClothing = clothingManager.findClothing(clothes, targetClothing);

            // Display the result of the search using the printClothing method
            if (foundClothing != null) {
                System.out.println("\nFound the target clothing: ");
                clothingManager.printClothing(foundClothing);
            } else {
                System.out.println("\nTarget clothing not found.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("\n\nError: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    /**
     * Helper method to print the array of {@code Clothing} objects 
     * using the {@code ClothingManager}'s printClothing method.
     *
     * @param clothes The array of {@code Clothing} objects to print.
     * @param clothingManager The {@code ClothingManager} instance used for printing.
     */
    private static void printClothingArray(Clothing[] clothes, ClothingManager clothingManager) {
        for (Clothing clothing : clothes) {
            clothingManager.printClothing(clothing);
        }
    }
}
