package lab5;

public class WashingMachine extends Appliance {
    private int drumSize; // in kilograms
    private int spinSpeed; // in RPM (rotations per minute)
    private static final int WM_STANDARD_RADIATION_LEVEL = 30;

    // Constructor with default radiation level (0)
    public WashingMachine(String brand, int power, int drumSize, int spinSpeed) {
        super(brand, power);
        this.drumSize = drumSize;
        this.spinSpeed = spinSpeed;
        setRadiationLevel(WM_STANDARD_RADIATION_LEVEL);
    }

    // Getters for drum size and spin speed
    public int getDrumSize() {
        return drumSize;
    }

    public int getSpinSpeed() {
        return spinSpeed;
    }

    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Drum Size: " + drumSize + "kg, Spin Speed: " + spinSpeed + "RPM");
        System.out.println();
    }
}
