package lab5;

public class Microwave extends Appliance {
    private int capacity; // in liters
    private int maxOutputPower; // in watts
    private static final int MICROWAVE_STANDARD_RADIATION_LEVEL = 120; 

    // Constructor with default radiation level
    public Microwave(String brand, int power, int capacity, int maxOutputPower) {
        super(brand, power);
        setCapacity(capacity);
        setMaxOutputPower(maxOutputPower);
        setRadiationLevel(MICROWAVE_STANDARD_RADIATION_LEVEL);
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0 || capacity > 50) { // Max capacity limit in liters
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Ємність має бути в межах 1-50 літрів.");
        }
    }
    
    private void setMaxOutputPower(int maxOutputPower) {
        if (maxOutputPower <= 0 || maxOutputPower > 1500) { // Max output power limit in watts
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Максимальна потужність має бути в межах 1-1500 Вт.");
        }
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
