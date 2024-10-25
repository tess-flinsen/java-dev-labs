package lab6;

import lab5.Appliance;
import lab5.WashingMachine;
import lab5.Microwave;
import lab5.RobotVacuum;

import java.util.ArrayList;
import java.util.List;

public class SetApplication {
    public static void main(String[] args) {
        // Create instances of Appliance (use subclasses or Appliance if abstract is removed)
        Appliance appliance1 = new WashingMachine("Samsung", 500, 7, 1200);
        Appliance appliance2 = new Microwave("LG", 800, 25, 1000);
        Appliance appliance3 = new RobotVacuum("iRobot", 100, 30, 60);

        // Default constructor
        System.out.println("Using the default constructor:");
        ApplianceSet applianceSet = new ApplianceSet();
        applianceSet.add(appliance1);
        applianceSet.add(appliance2);
        printApplianceSet(applianceSet);

        // Constructor with a single Appliance
        System.out.println("Using the constructor with a single Appliance:");
        ApplianceSet singleApplianceSet = new ApplianceSet(appliance3);
        printApplianceSet(singleApplianceSet);

        // Constructor with a Collection of Appliances
        List<Appliance> newAppliances = new ArrayList<>();
        newAppliances.add(appliance2);
        newAppliances.add(appliance3);
        System.out.println("Using the constructor with a Collection of Appliances:");
        ApplianceSet collectionApplianceSet = new ApplianceSet(newAppliances);
        printApplianceSet(collectionApplianceSet);

        // Continue with other operations as before
        // Add all, retainAll, removeAll, and other methods demonstration
        System.out.println("\nAdding all appliances from the collection to the default set:");
        applianceSet.addAll(newAppliances);
        printApplianceSet(applianceSet);

        // Remove an appliance
        System.out.println("\nRemoving appliance2:");
        applianceSet.remove(appliance2);
        printApplianceSet(applianceSet);

        // Use retainAll to keep only a certain subset
        System.out.println("Retaining only appliances in the new collection:");
        applianceSet.retainAll(newAppliances);
        printApplianceSet(applianceSet);

        // Use removeAll to remove all appliances in the collection
        System.out.println("Removing all appliances in the new collection:");
        applianceSet.removeAll(newAppliances);
        printApplianceSet(applianceSet);

        // Check if the set is empty
        System.out.println("Is the appliance set empty? " + applianceSet.isEmpty());

        // Add appliances back and clear the set
        System.out.println("\nAdding appliance1 and appliance3 back to the set:");
        applianceSet.add(appliance1);
        applianceSet.add(appliance3);
        printApplianceSet(applianceSet);

        System.out.println("Clearing the appliance set:");
        applianceSet.clear();
        printApplianceSet(applianceSet);
        System.out.println("Is the appliance set empty after clearing? " + applianceSet.isEmpty());
    }

    // Utility method to print the contents of the ApplianceSet
    private static void printApplianceSet(ApplianceSet applianceSet) {
        System.out.println("ApplianceSet contents:");
        for (Appliance appliance : applianceSet) {
            appliance.printDetails();
        }
        System.out.println("Size: " + applianceSet.size());
        System.out.println();
    }
}