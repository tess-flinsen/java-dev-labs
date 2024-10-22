package lab5;

public class WashingMachine extends Appliance {
    private int drumSize; // in kilograms
    private int spinSpeed; // in RPM (rotations per minute)
    private static final int WM_STANDARD_RADIATION_LEVEL = 30;

    // Constructor with default radiation level (0)
    public WashingMachine(String brand, int power, int drumSize, int spinSpeed) {
        super(brand, power);
        setDrumSize(drumSize);
        setSpinSpeed(spinSpeed);
        setRadiationLevel(WM_STANDARD_RADIATION_LEVEL);
    }

    public void setDrumSize(int drumSize) {
        if (drumSize <= 0 || drumSize > 10) { // Max drum size limit in kg
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Розмір барабана має бути в межах 1-10 кг.");
        }
        this.drumSize = drumSize;

    }
    
    public void setSpinSpeed(int spinSpeed) {
        if (spinSpeed <= 0 || spinSpeed > 2000) { // Max spin speed limit in RPM
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Швидкість обертання має бути в межах 1-2000 RPM.");
        }
        this.spinSpeed = spinSpeed;

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
