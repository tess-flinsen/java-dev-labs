package lab5;

public class HandheldVacuum extends VacuumCleaner {
    private int weight; // in grams
    private int dustContainerCapacity; // in liters
    private static final int HANDHELD_VACUUM_STANDARD_RADIATION_LEVEL = 35;

    // Constructor
    public HandheldVacuum(String brand, int power, int suctionPower, int weight, int dustContainerCapacity) {
        super(brand, power, suctionPower);
        this.weight = weight; // Initialize weight
        this.dustContainerCapacity = dustContainerCapacity; // Initialize dust container capacity
        setRadiationLevel(HANDHELD_VACUUM_STANDARD_RADIATION_LEVEL);
    }

    // Getters for the new attributes
    public int getWeight() {
        return weight; // Return weight
    }

    public int getDustContainerCapacity() {
        return dustContainerCapacity; // Return dust container capacity
    }

    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Weight: " + weight + " kg" + ", Dust container capacity: " + dustContainerCapacity);
        System.out.println();
    }
}

