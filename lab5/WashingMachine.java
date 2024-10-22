package lab5;

/**
 * The WashingMachine class represents a washing machine appliance with properties such as
 * drum size, spin speed, and radiation level. It extends the Appliance class and provides
 * methods to manipulate these properties.
 */
public class WashingMachine extends Appliance {
    private int drumSize;             // Drum size of the washing machine in kilograms
    private int spinSpeed;            // Spin speed of the washing machine in RPM (rotations per minute)
    private static final int WM_STANDARD_RADIATION_LEVEL = 30; // Standard radiation level

    /**
     * Constructs a WashingMachine with the specified brand, power, drum size, and spin speed.
     * 
     * @param brand the brand of the washing machine
     * @param power the power consumption of the washing machine in watts
     * @param drumSize the drum size of the washing machine in kilograms
     * @param spinSpeed the spin speed of the washing machine in RPM
     * @throws IllegalArgumentException if drumSize is non-positive or exceeds 10, or if spinSpeed
     *                                   is non-positive or exceeds 2000
     */
    public WashingMachine(String brand, int power, int drumSize, int spinSpeed) {
        super(brand, power);
        setDrumSize(drumSize);
        setSpinSpeed(spinSpeed);
        setRadiationLevel(WM_STANDARD_RADIATION_LEVEL);
    }

    /**
     * Sets the drum size of the washing machine.
     * 
     * @param drumSize the drum size to set in kilograms
     * @throws IllegalArgumentException if drumSize is non-positive or exceeds 10
     */
    public void setDrumSize(int drumSize) {
        if (drumSize <= 0 || drumSize > 10) { // Max drum size limit in kg
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Drum size must be between 1 and 10 kg.");
        }
        this.drumSize = drumSize; // Initialize drum size
    }

    /**
     * Sets the spin speed of the washing machine.
     * 
     * @param spinSpeed the spin speed to set in RPM
     * @throws IllegalArgumentException if spinSpeed is non-positive or exceeds 2000
     */
    public void setSpinSpeed(int spinSpeed) {
        if (spinSpeed <= 0 || spinSpeed > 2000) { // Max spin speed limit in RPM
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Spin speed must be between 1 and 2000 RPM.");
        }
        this.spinSpeed = spinSpeed; // Initialize spin speed
    }

    /**
     * Gets the drum size of the washing machine.
     * 
     * @return the drum size in kilograms
     */
    public int getDrumSize() {
        return drumSize;
    }

    /**
     * Gets the spin speed of the washing machine.
     * 
     * @return the spin speed in RPM
     */
    public int getSpinSpeed() {
        return spinSpeed;
    }

    /**
     * Prints the details of the washing machine, including its class name, brand, power, drum size,
     * and spin speed.
     */
    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Drum Size: " + drumSize + "kg, Spin Speed: " + spinSpeed + "RPM");
        System.out.println();
    }
}
