package lab5;

public class Microwave extends Appliance {
    private int capacity; // in liters
    private int maxOutputPower; // in watts
    private static final int MICROWAVE_STANDARD_RADIATION_LEVEL = 120; 

    // Constructor with default radiation level
    public Microwave(String brand, int power, int capacity, int maxOutputPower) {
        super(brand, power);
        this.capacity = capacity;
        this.maxOutputPower = maxOutputPower;
        setRadiationLevel(MICROWAVE_STANDARD_RADIATION_LEVEL);
    }

    // Getters for capacity and max power level
    public int getCapacity() {
        return capacity;
    }

    public int getMaxPowerLevel() {
        return maxOutputPower;
    }

    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Capacity: " + capacity + "L, Max Output Power: " + maxOutputPower + "W");
        System.out.println();
    }
}
