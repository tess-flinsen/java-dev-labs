package lab5;

public abstract class Appliance {
    private String brand;
    private int power; 
    private boolean isOn;
    private int radiationLevel;

    public Appliance(String brand, int power) {
        this.brand = brand;
        this.power = power;
        this.isOn = false;
        this.radiationLevel = 0;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(getClass().getSimpleName() + " " + brand + " is turned on.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(getClass().getSimpleName() + " " + brand + " is turned off.");
    }

    public boolean isOn() {
        return isOn;
    }

    public int getPower() {
        return power;
    }

    public String getBrand() {
        return brand;
    }

    public int getRadiationLevel() {
        return radiationLevel;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setRadiationLevel(int radiationLevel) {
        this.radiationLevel = radiationLevel;
    }

    public void printDetails() {
        System.out.print(getClass().getSimpleName() + ", Brand: " + brand + ", Power: " + power + "W, ");
    }
}
