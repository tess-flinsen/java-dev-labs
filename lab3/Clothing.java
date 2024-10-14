package lab3;

/**
 * The {@code Clothing} class represents an article of clothing with attributes such as 
 * name, size, price, color, brand, and material. It includes validation checks to ensure 
 * that the attributes are within specified limits.
 * <p>
 * Example usage:
 * <pre>
 *     Clothing shirt = new Clothing("Doctor Who T-shirt", "L", 49.99, "Blue", "Tardis Corp", "Cotton");
 * </pre>
 * </p>
 */
public class Clothing {
    private String name;     // The name of the clothing item (e.g., "Shirt")
    private String size;     // The size of the clothing item (e.g., "M", "L")
    private double price;    // The price of the clothing item
    private String color;    // The color of the clothing item (e.g., "Blue")
    private String brand;    // The brand of the clothing item (e.g., "BrandA")
    private String material; // The material of the clothing item (e.g., "Cotton")

    /**
     * Constructs a {@code Clothing} object with the specified attributes.
     *
     * @param name     The name of the clothing item. Must be between 1 and 100 characters.
     * @param size     The size of the clothing item. Must be between 1 and 5 characters.
     * @param price    The price of the clothing item. Must be between 0.01 and 100,000.
     * @param color    The color of the clothing item. Must be between 1 and 100 characters.
     * @param brand    The brand of the clothing item. Must be between 1 and 100 characters.
     * @param material The material of the clothing item. Must be between 1 and 100 characters.
     * @throws IllegalArgumentException If any of the parameters are out of the specified ranges.
     */
    public Clothing(String name, String size, double price, String color, String brand, String material) {
        // Validation checks
        if (name == null || name.length() < 1 || name.length() > 100) {
            throw new IllegalArgumentException("Name must be between 1 and 100 characters.");
        }
        if (size == null || size.length() < 1 || size.length() > 5) {
            throw new IllegalArgumentException("Size must be between 1 and 5 characters.");
        }
        if (price < 0.01 || price > 100000.0) {
            throw new IllegalArgumentException("Price must be between 0.01 and 100,000.");
        }
        if (color == null || color.length() < 1 || color.length() > 100) {
            throw new IllegalArgumentException("Color must be between 1 and 100 characters.");
        }
        if (brand == null || brand.length() < 1 || brand.length() > 100) {
            throw new IllegalArgumentException("Brand must be between 1 and 100 characters.");
        }
        if (material == null || material.length() < 1 || material.length() > 100) {
            throw new IllegalArgumentException("Material must be between 1 and 100 characters.");
        }

        // Assign the values after validation
        this.name = name;
        this.size = size;
        this.price = price;
        this.color = color;
        this.brand = brand;
        this.material = material;
    }

    /**
     * Returns the name of the clothing item.
     *
     * @return The name of the clothing item.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the size of the clothing item.
     *
     * @return The size of the clothing item.
     */
    public String getSize() {
        return size;
    }

    /**
     * Returns the price of the clothing item.
     *
     * @return The price of the clothing item.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the color of the clothing item.
     *
     * @return The color of the clothing item.
     */
    public String getColor() {
        return color;
    }

    /**
     * Returns the brand of the clothing item.
     *
     * @return The brand of the clothing item.
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Returns the material of the clothing item.
     *
     * @return The material of the clothing item.
     */
    public String getMaterial() {
        return material;
    }
}
