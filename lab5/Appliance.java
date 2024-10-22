package lab5;

/**
 * The abstract class Appliance represents a general appliance with properties such as brand,
 * power consumption, on/off state, and radiation level. It provides methods to manipulate
 * these properties and to turn the appliance on or off.
 */

public abstract class Appliance {
    private String brand;               // The brand of the appliance
    private int power;                  // Power consumption of the appliance in watts
    private boolean isOn;               // Indicates whether the appliance is currently on
    private int radiationLevel;          // Radiation level of the appliance

    /**
     * Constructs an Appliance with the specified brand and power.
     * 
     * @param brand the brand of the appliance
     * @param power the power consumption of the appliance in watts
     * @throws IllegalArgumentException if brand is null or empty, or if power is non-positive or exceeds 3000
     */
    public Appliance(String brand, int power) {
        setBrand(brand);
        setPower(power);
        this.isOn = false;
        this.radiationLevel = 0; 
    }

    /**
     * Sets the brand of the appliance.
     * 
     * @param brand the brand to set
     * @throws IllegalArgumentException if brand is null or empty
     */
    private void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Brand cannot be empty.");
        }
        this.brand = brand;
    }

    /**
     * Sets the power of the appliance.
     * 
     * @param power the power to set in watts
     * @throws IllegalArgumentException if power is non-positive or exceeds 3000
     */
    public void setPower(int power) {
        if (power <= 0 || power > 3000) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Power must be between 1 and 3000.");
        }
        this.power = power;
    }

    /**
     * Sets the radiation level of the appliance.
     * 
     * @param radiationLevel the radiation level to set
     * @throws IllegalArgumentException if radiationLevel is less than 0 or exceeds 400
     */
    public void setRadiationLevel(int radiationLevel) {
        if (radiationLevel < 0 || radiationLevel > 400) { 
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Radiation level must be between 0 and 400.");
        }
        this.radiationLevel = radiationLevel;
    }

    /**
     * Turns on the appliance if it is not already on.
     */
    public void turnOn() {
        if (!isOn) { // Check if the appliance is already on
            isOn = true;
            System.out.println(getClass().getSimpleName() + " " + brand + " is turned on.");
        } else {
            System.out.println(getClass().getSimpleName() + " " + brand + " is already on.");
        }
    }

    /**
     * Turns off the appliance if it is currently on.
     */
    public void turnOff() {
        if (isOn) { // Check if the appliance is currently on
            isOn = false;
            System.out.println(getClass().getSimpleName() + " " + brand + " is turned off.");
        } else {
            System.out.println(getClass().getSimpleName() + " " + brand + " is already off.");
        }
    }

    /**
     * Checks if the appliance is currently on.
     * 
     * @return true if the appliance is on, false otherwise
     */
    public boolean isOn() {
        return isOn;
    }

    /**
     * Gets the power consumption of the appliance.
     * 
     * @return the power in watts
     */
    public int getPower() {
        return power;
    }

    /**
     * Gets the brand of the appliance.
     * 
     * @return the brand of the appliance
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Gets the radiation level of the appliance.
     * 
     * @return the radiation level
     */
    public int getRadiationLevel() {
        return radiationLevel;
    }

    /**
     * Prints the details of the appliance, including its class name, brand, and power.
     */
    public void printDetails() {
        System.out.print(getClass().getSimpleName() + ", Brand: " + brand + ", Power: " + power + "W, ");
    }
}
