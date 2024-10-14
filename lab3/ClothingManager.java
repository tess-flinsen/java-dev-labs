package lab3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The {@code ClothingManager} class provides methods for managing and manipulating 
 * arrays of {@code Clothing} objects. It includes functionality for sorting clothing 
 * items, finding specific clothing items, and printing clothing details.
 * <p>
 * Example usage:
 * <pre>
 *     ClothingManager manager = new ClothingManager();
 *     manager.sortClothing(clothes);
 *     Clothing foundClothing = manager.findClothing(clothes, targetClothing);
 * </pre>
 * </p>
 */
public class ClothingManager {

    /**
     * Sorts an array of {@code Clothing} objects first by name in ascending order, 
     * and then by price in descending order if names are equal.
     *
     * @param clothes The array of {@code Clothing} objects to be sorted. 
     *                The array must not be null.
     */
    public void sortClothing(Clothing[] clothes) {
        Arrays.sort(clothes, Comparator
            .comparing(Clothing::getName) // Sort by name in ascending order.
            .thenComparing(Comparator.comparingDouble(Clothing::getPrice).reversed())); // Sort by price in descending order.
    }

    /**
     * Finds a specific {@code Clothing} object in an array by comparing all relevant attributes.
     *
     * @param clothes The array of {@code Clothing} objects to search. 
     *                The array must not be null.
     * @param target  The {@code Clothing} object to find in the array. 
     *                It must not be null.
     * @return The matching {@code Clothing} object if found, or null if not found.
     * @throws IllegalArgumentException if target is null.
     */
    public Clothing findClothing(Clothing[] clothes, Clothing target) {
        if (target == null) {
            throw new IllegalArgumentException("Target clothing cannot be null.");
        }
        
        for (Clothing clothing : clothes) {
            // Compare each attribute to see if the object matches the target
            if (clothing.getName().equals(target.getName()) &&
                clothing.getSize().equals(target.getSize()) &&
                clothing.getPrice() == target.getPrice() &&
                clothing.getColor().equals(target.getColor()) &&
                clothing.getBrand().equals(target.getBrand())) {
                return clothing; // Return the matching clothing item
            }
        }
        return null; // Return null if no match is found
    }

    /**
     * Prints the details of a {@code Clothing} object to the standard output.
     *
     * @param clothing The {@code Clothing} object to print. 
     *                 It can be null.
     */
    public void printClothing(Clothing clothing) {
        if (clothing != null) {
            System.out.println(clothing.getName() + ", " 
                    + clothing.getSize() + ", " 
                    + clothing.getPrice() + ", " 
                    + clothing.getColor() + ", " 
                    + clothing.getBrand() + ", " 
                    + clothing.getMaterial());
        } else {
            System.out.println("Clothing item is null.");
        }
    }
}
