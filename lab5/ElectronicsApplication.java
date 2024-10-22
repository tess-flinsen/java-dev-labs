package lab5;

/**
 * The ElectronicsApplication class serves as the entry point for the application.
 * It creates instances of various appliances, adds them to an apartment, and demonstrates
 * functionality such as turning on appliances, calculating total power consumption,
 * sorting appliances by power, and finding appliances by radiation range.
 */
public class ElectronicsApplication {
    public static void main(String[] args) {
        // Declare appliance references
        Appliance washingMachine = null;
        Appliance microwave = null;
        Appliance robotVacuum = null;
        Appliance handheldVacuum = null;

        try {
            // Create appliances
            washingMachine = new WashingMachine("Samsung", 500, 7, 1200);
            microwave = new Microwave("LG", 800, 25, 1000);
            robotVacuum = new RobotVacuum("iRobot", 100, 30, 60);
            handheldVacuum = new HandheldVacuum("Dyson", 200, 25, 500, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating appliances: " + e.getMessage()); // Handle creation errors
            return; 
        }
        
        // Add appliances to the array
        Appliance[] appliances = { washingMachine, microwave, handheldVacuum, robotVacuum };
        Apartment apartment = new Apartment(appliances); // Create an Apartment object

        System.out.println("Created array of appliances:");
        apartment.printAppliances(); // Print the details of the appliances

        // Turn on some appliances
        apartment.turnOn(0); // Turn on washing machine
        apartment.turnOn(1); // Turn on microwave
        apartment.turnOn(3); // Turn on robot vacuum

        // Calculate total power consumption
        int totalPower = apartment.calculateTotalPower();
        System.out.println("Total power consumption: " + totalPower + " W");
        System.out.println();

        // Sort appliances by power
        apartment.sortAppliancesByPower();

        // Find an appliance by radiation level range
        Appliance foundAppliance = apartment.findApplianceByRadiationRange(70, 200); // Radiation range
        if (foundAppliance != null) {
            System.out.println("Found appliance within the specified radiation range: " + foundAppliance.getClass().getSimpleName());
        } else {
            System.out.println("No appliance found within the specified radiation range.");
        }
    }
}
