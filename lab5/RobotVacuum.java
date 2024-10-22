package lab5;

public class RobotVacuum extends VacuumCleaner {
    private int batteryLife; // in minutes
    private static final int ROBOT_VACUUM_STANDARD_RADIATION_LEVEL = 50;

    public RobotVacuum(String brand, int power, int suctionPower, int batteryLife) {
        super(brand, power, suctionPower);
        setBatteryLife(batteryLife); // Initialize battery life
        setRadiationLevel(ROBOT_VACUUM_STANDARD_RADIATION_LEVEL);
    }

    private void setBatteryLife(int batteryLife) {
        if (batteryLife <= 0 || batteryLife > 360) { // Max battery life limit in minutes
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Час роботи батареї має бути в межах 1-360 хв.");
        }
    }

    public int getBatteryLife() {
        return batteryLife; 
    }

    public void displayBatteryStatus() {
        System.out.println("Battery life remaining: " + batteryLife + " minutes.");
    }

    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Battery Life: " + batteryLife + " minutes");
        System.out.println();
    }

}
