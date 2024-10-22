package lab5;


public abstract class VacuumCleaner extends Appliance {
    private int suctionPower; // in watts

    public VacuumCleaner(String brand, int power, int suctionPower) {
        super(brand, power);
        setSuctionPower(suctionPower);
    }

    private void setSuctionPower(int suctionPower) {
        if (suctionPower <= 0 || suctionPower > 1000) { // Max suction power limit in watts
            throw new IllegalArgumentException(getClass().getSimpleName() + " - Потужність всмоктування має бути в межах 1-1000 Вт.");
        }
    }

    public int getSuctionPower() {
        return suctionPower;
    }

    @Override
    public void printDetails() {
        super.printDetails(); // Call the parent class method
        System.out.print("Suction Power: " + suctionPower + "W, ");
    }

}