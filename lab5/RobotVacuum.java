package lab5;

/**
 * The RobotVacuum class represents a robotic vacuum cleaner with properties such as 
 * battery life and standard radiation level. It extends the VacuumCleaner class and provides 
 * methods to manipulate these properties.
 */
public class RobotVacuum extends VacuumCleaner {
    private int batteryLife; // Battery life of the robot vacuum in minutes
    private static final int ROBOT_VACUUM_STANDARD_RADIATION_LEVEL = 50; // Standard radiation level

    /**
     * Constructs a RobotVacuum with the specified brand, power, suction power, and battery life.
     * 
     * @param brand the brand of the robot vacuum
     * @param power the power consumption of the robot vacuum in watts
     * @param suctionPower the suction power of the robot vacuum in watts
     * @param batteryLife the battery life of the robot vacuum in minutes
     * @throws IllegalArgumentException if batteryLife is non-positive or exceeds 360
     */
    public RobotVacuum(String brand, int power, int suctionPower, int batteryLife) {
        super(brand, power, suctionPower);
        setBatteryLife(batteryLife); // Initialize battery life
        setRadiationLevel(ROBOT_VACUUM_STANDARD_RADIATION_LEVEL); // Set the standard radiation level
    }

    /**
     * Sets the battery life of the robot vacuum.
     * 
     * @param batteryLife the battery life to set in minutes
     * @throws IllegalArgumentException if batteryLife is non-positive or exceeds 360
     */
    private void setBatteryLife(int batteryLife) {
        if (batteryLife <= 0 || batteryLife > 360) { // Max battery life limit in minutes
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Battery life must be between 1 and 360 minutes.");
        }
        this.batteryLife = batteryLife; // Initialize battery life
    }

    /**
     * Gets the battery life of the robot vacuum.
     * 
     * @return the battery life in minutes
     */
    public int getBatteryLife() {
        return batteryLife; 
    }

    /**
     * Displays the remaining battery status of the robot vacuum.
     */
    public void displayBatteryStatus() {
        System.out.println("Battery life remaining: " + batteryLife + " minutes.");
    }

    /**
     * Prints the details of the robot vacuum, including its class name, brand, power,
     * suction power, and battery life.
     */
    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Battery Life: " + batteryLife + " minutes");
        System.out.println();
    }
}
