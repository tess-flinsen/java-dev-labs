package lab5;

/**
 * The HandheldVacuum class represents a handheld vacuum cleaner with properties such as 
 * weight, dust container capacity, and standard radiation level. It extends the VacuumCleaner class 
 * and provides methods to manipulate these properties.
 */
public class HandheldVacuum extends VacuumCleaner {
    private int weight; // Weight of the handheld vacuum in grams
    private int dustContainerCapacity; // Dust container capacity in liters
    private static final int HANDHELD_VACUUM_STANDARD_RADIATION_LEVEL = 35; // Standard radiation level

    /**
     * Constructs a HandheldVacuum with the specified brand, power, suction power, weight, 
     * and dust container capacity.
     * 
     * @param brand the brand of the handheld vacuum
     * @param power the power consumption of the handheld vacuum in watts
     * @param suctionPower the suction power of the handheld vacuum in watts
     * @param weight the weight of the handheld vacuum in grams
     * @param dustContainerCapacity the dust container capacity of the handheld vacuum in liters
     * @throws IllegalArgumentException if weight is out of range or if 
     *         dustContainerCapacity is non-positive or exceeds 2
     */
    public HandheldVacuum(String brand, int power, int suctionPower, int weight, int dustContainerCapacity) {
        super(brand, power, suctionPower);
        setWeight(weight); // Initialize weight using setter for validation
        setDustContainerCapacity(dustContainerCapacity); // Initialize dust container capacity using setter for validation
        setRadiationLevel(HANDHELD_VACUUM_STANDARD_RADIATION_LEVEL); // Set the standard radiation level
    }

    /**
     * Sets the weight of the handheld vacuum.
     * 
     * @param weight the weight to set in grams
     * @throws IllegalArgumentException if weight is less than 300 or greater than 8000
     */
    private void setWeight(int weight) {
        if (weight < 300 || weight > 8000) { // Max weight limit in grams (e.g., 5 kg)
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Weight must be between 300 and 8000 grams.");
        }
        this.weight = weight; // Initialize weight
    }

    /**
     * Sets the dust container capacity of the handheld vacuum.
     * 
     * @param dustContainerCapacity the capacity to set in liters
     * @throws IllegalArgumentException if dustContainerCapacity is non-positive or exceeds 2
     */
    private void setDustContainerCapacity(int dustContainerCapacity) {
        if (dustContainerCapacity <= 0 || dustContainerCapacity > 2) { // Max capacity limit in liters (e.g., 2 liters)
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Dust container capacity must be between 1 and 2 liters.");
        }
        this.dustContainerCapacity = dustContainerCapacity; // Initialize dust container capacity
    }

    /**
     * Gets the weight of the handheld vacuum.
     * 
     * @return the weight in grams
     */
    public int getWeight() {
        return weight; // Return weight
    }

    /**
     * Gets the dust container capacity of the handheld vacuum.
     * 
     * @return the dust container capacity in liters
     */
    public int getDustContainerCapacity() {
        return dustContainerCapacity; // Return dust container capacity
    }

    /**
     * Prints the details of the handheld vacuum, including its class name, brand, power,
     * suction power, weight, and dust container capacity.
     */
    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Weight: " + weight + " grams" + ", Dust container capacity: " + dustContainerCapacity + " liters");
        System.out.println();
    }
}
