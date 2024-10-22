package lab5;

/**
 * The Microwave class represents a microwave appliance with properties such as capacity,
 * maximum output power, and radiation level. It extends the Appliance class and provides
 * methods to manipulate these properties.
 */
public class Microwave extends Appliance {
    private int capacity;              // Capacity of the microwave in liters
    private int maxOutputPower;        // Maximum output power of the microwave in watts
    private static final int MICROWAVE_STANDARD_RADIATION_LEVEL = 120; // Standard radiation level

    /**
     * Constructs a Microwave with the specified brand, power, capacity, and maximum output power.
     * 
     * @param brand the brand of the microwave
     * @param power the power consumption of the microwave in watts
     * @param capacity the capacity of the microwave in liters
     * @param maxOutputPower the maximum output power of the microwave in watts
     * @throws IllegalArgumentException if capacity is non-positive or exceeds 50, or if maxOutputPower
     *                                   is non-positive or exceeds 1500
     */
    public Microwave(String brand, int power, int capacity, int maxOutputPower) {
        super(brand, power);
        setCapacity(capacity);
        setMaxOutputPower(maxOutputPower);
        setRadiationLevel(MICROWAVE_STANDARD_RADIATION_LEVEL);
    }

    /**
     * Sets the capacity of the microwave.
     * 
     * @param capacity the capacity to set in liters
     * @throws IllegalArgumentException if capacity is non-positive or exceeds 50
     */
    private void setCapacity(int capacity) {
        if (capacity <= 0 || capacity > 50) { // Max capacity limit in liters
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Capacity must be between 1 and 50 liters.");
        }
        this.capacity = capacity; // Initialize capacity
    }
    
    /**
     * Sets the maximum output power of the microwave.
     * 
     * @param maxOutputPower the maximum output power to set in watts
     * @throws IllegalArgumentException if maxOutputPower is non-positive or exceeds 1500
     */
    private void setMaxOutputPower(int maxOutputPower) {
        if (maxOutputPower <= 0 || maxOutputPower > 1500) { // Max output power limit in watts
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Maximum output power must be between 1 and 1500 watts.");
        }
        this.maxOutputPower = maxOutputPower; // Initialize maximum output power
    }

    /**
     * Gets the capacity of the microwave.
     * 
     * @return the capacity of the microwave in liters
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the maximum output power of the microwave.
     * 
     * @return the maximum output power in watts
     */
    public int getMaxPowerLevel() {
        return maxOutputPower;
    }

    /**
     * Prints the details of the microwave, including its class name, brand, power, capacity,
     * and maximum output power.
     */
    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Capacity: " + capacity + "L, Max Output Power: " + maxOutputPower + "W");
        System.out.println();
    }
}
