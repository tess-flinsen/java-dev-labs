package lab5;

/**
 * The VacuumCleaner class represents a vacuum cleaner appliance with properties such as
 * suction power. It extends the Appliance class and provides methods to manipulate this property.
 */
public abstract class VacuumCleaner extends Appliance {
    private int suctionPower; // Suction power of the vacuum cleaner in watts

    /**
     * Constructs a VacuumCleaner with the specified brand, power, and suction power.
     * 
     * @param brand the brand of the vacuum cleaner
     * @param power the power consumption of the vacuum cleaner in watts
     * @param suctionPower the suction power of the vacuum cleaner in watts
     * @throws IllegalArgumentException if suctionPower is non-positive or exceeds 1000
     */
    public VacuumCleaner(String brand, int power, int suctionPower) {
        super(brand, power);
        setSuctionPower(suctionPower);
    }

    /**
     * Sets the suction power of the vacuum cleaner.
     * 
     * @param suctionPower the suction power to set in watts
     * @throws IllegalArgumentException if suctionPower is non-positive or exceeds 1000
     */
    private void setSuctionPower(int suctionPower) {
        if (suctionPower <= 0 || suctionPower > 1000) { // Max suction power limit in watts
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Suction power must be between 1 and 1000 watts.");
        }
        this.suctionPower = suctionPower; // Initialize suction power
    }

    /**
     * Gets the suction power of the vacuum cleaner.
     * 
     * @return the suction power in watts
     */
    public int getSuctionPower() {
        return suctionPower;
    }

    /**
     * Prints the details of the vacuum cleaner, including its class name, brand, power, and suction power.
     */
    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Suction Power: " + suctionPower + "W, ");
    }
}
