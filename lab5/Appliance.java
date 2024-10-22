package lab5;

public abstract class Appliance {
    private String brand;
    private int power; 
    private boolean isOn;
    private int radiationLevel;

    public Appliance(String brand, int power) {
        setBrand(brand);
        setPower(power);
        this.isOn = false;
        this.radiationLevel = 0; 
    }

    private void setBrand(String brand) {
        if (brand == null || brand.isEmpty()) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Бренд не може бути порожнім.");
        }
        this.brand = brand;
    }

    public void setPower(int power) {
        if (power <= 0 || power > 3000) {
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Потужність має бути в межах від 0 до 3000.");
        }
        this.power = power;
    }

    public void setRadiationLevel(int radiationLevel) {
        if (radiationLevel < 0 || radiationLevel > 400) { 
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Рівень випромінювання має бути від 0 до 400.");
        }
        this.radiationLevel = radiationLevel;
    }

    public void turnOn() {
        if (!isOn) { // Check if the appliance is already on
            isOn = true;
            System.out.println(getClass().getSimpleName() + " " + brand + " увімкнено.");
        } else {
            System.out.println(getClass().getSimpleName() + " " + brand + " вже увімкнений.");
        }
    }

    public void turnOff() {
        if (isOn) { // Check if the appliance is currently on
            isOn = false;
            System.out.println(getClass().getSimpleName() + " " + brand + " вимкнено.");
        } else {
            System.out.println(getClass().getSimpleName() + " " + brand + " вже вимкнено.");
        }
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

    public void printDetails() {
        System.out.print(getClass().getSimpleName() + ", Brand: " + brand + ", Power: " + power + "W, ");
    }
}
