package lab5;

public class RobotVacuum extends VacuumCleaner {
    private int batteryLife; // in minutes
    private static final int ROBOT_VACUUM_STANDARD_RADIATION_LEVEL = 50;

    public RobotVacuum(String brand, int power, int suctionPower, int batteryLife) {
        super(brand, power, suctionPower);
        this.batteryLife = batteryLife; // Initialize battery life
        setRadiationLevel(ROBOT_VACUUM_STANDARD_RADIATION_LEVEL);
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
