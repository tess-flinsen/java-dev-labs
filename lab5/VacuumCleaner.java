package lab5;


public abstract class VacuumCleaner extends Appliance {
    private int suctionPower; // in watts

    public VacuumCleaner(String brand, int power, int suctionPower) {
        super(brand, power);
        this.suctionPower = suctionPower;
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