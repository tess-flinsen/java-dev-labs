package lab5;

public class HandheldVacuum extends VacuumCleaner {
    private int weight; // in grams
    private int dustContainerCapacity; // in liters
    private static final int HANDHELD_VACUUM_STANDARD_RADIATION_LEVEL = 35;

    // Constructor
    public HandheldVacuum(String brand, int power, int suctionPower, int weight, int dustContainerCapacity) {
        super(brand, power, suctionPower);
        setWeight(weight); // Initialize weight using setter for validation
        setDustContainerCapacity(dustContainerCapacity); // Initialize dust container capacity using setter for validation
        setRadiationLevel(HANDHELD_VACUUM_STANDARD_RADIATION_LEVEL);
    }

    private void setWeight(int weight) {
        if (weight < 300 || weight > 8000) { // Max weight limit in grams (e.g., 5 kg)
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Вага має бути в межах 300-8000 грам.");
        }
        this.weight = weight;
    }

    private void setDustContainerCapacity(int dustContainerCapacity) {
        if (dustContainerCapacity <= 0 || dustContainerCapacity > 2) { // Max capacity limit in liters (e.g., 2 liters)
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Ємність контейнера для пилу має бути в межах 1-2 літри.");
        }
        this.dustContainerCapacity = dustContainerCapacity;
    }

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

