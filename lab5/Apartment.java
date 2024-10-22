package lab5;

import java.util.ArrayList;
import java.util.List;

/**
 * The Apartment class represents an apartment that contains a collection of appliances.
 * It provides methods to manage the appliances, including turning them on, calculating 
 * total power consumption, sorting appliances by power, finding appliances by radiation 
 * range, and printing details of all appliances.
 * <p>
 * Example usage:
 * <pre>
 * Appliance[] appliances = { new WashingMachine("Samsung", 500, 7, 1200), new Microwave("LG", 800, 25, 1000) };
 * Apartment apartment = new Apartment(appliances);
 * apartment.turnOn(0); // Turn on the first appliance (WashingMachine)
 * System.out.println("Total Power: " + apartment.calculateTotalPower() + "W");
 * </pre>
 * </p>
 */
public class Apartment {
    private Appliance[] appliances; // Array of appliances in the apartment

    /**
     * Constructs an Apartment with the specified array of appliances.
     * 
     * @param appliances the array of appliances in the apartment
     */
    public Apartment(Appliance[] appliances) {
        this.appliances = appliances; // Initialize appliances
    }

    /**
     * Turns on the appliance at the specified index.
     * 
     * @param index the index of the appliance to turn on
     */
    public void turnOn(int index) {
        try {
            appliances[index].turnOn(); // Try to turn on the appliance
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index: " + index); // Handle invalid index
        }
    }

    /**
     * Calculates the total power consumption of all turned-on appliances.
     * 
     * @return the total power consumption in watts
     */
    public int calculateTotalPower() {
        int totalPower = 0;
        for (Appliance appliance : appliances) {
            if (appliance.isOn()) { // Check if the appliance is on
                totalPower += appliance.getPower(); // Add its power to the total
            }
        }
        return totalPower; // Return total power
    }

    /**
     * Sorts the turned-on appliances by their power consumption in ascending order
     * and prints the sorted list.
     */
    public void sortAppliancesByPower() {
        // Create a temporary list to hold the appliances that are turned on
        List<Appliance> onAppliances = new ArrayList<>();

        // Add only the appliances that are on to the list
        for (Appliance appliance : appliances) {
            if (appliance.isOn()) {
                onAppliances.add(appliance);
            }
        }

        // Sort the appliances that are on by power using bubble sort
        for (int i = 0; i < onAppliances.size() - 1; i++) {
            for (int j = i + 1; j < onAppliances.size(); j++) {
                if (onAppliances.get(i).getPower() > onAppliances.get(j).getPower()) {
                    // Swap appliances
                    Appliance temp = onAppliances.get(i);
                    onAppliances.set(i, onAppliances.get(j));
                    onAppliances.set(j, temp);
                }
            }
        }

        // Print sorted appliances
        System.out.println("Turned-on appliances sorted by power:");
        for (Appliance appliance : onAppliances) {
            System.out.println(getClass().getSimpleName() + " " + appliance.getBrand() + " with Power: " + appliance.getPower() + "W");
        }
        System.out.println();
    }

    /**
     * Finds an appliance with a radiation level within the specified range.
     * 
     * @param minRadiation the minimum radiation level
     * @param maxRadiation the maximum radiation level
     * @return the appliance that matches the radiation range, or null if none found
     * @throws IllegalArgumentException if the radiation levels are invalid
     */
    public Appliance findApplianceByRadiationRange(int minRadiation, int maxRadiation) {
        // Check for valid radiation range
        if (minRadiation < 0 || maxRadiation < 0 || minRadiation > 1000 || maxRadiation > 1000) {
            throw new IllegalArgumentException("Radiation level must be in the range of 0 to 1000."); // Validate range
        }
        if (minRadiation > maxRadiation) {
            throw new IllegalArgumentException("Minimum radiation level cannot exceed the maximum."); // Validate order
        }

        // Search for appliance within the radiation range
        for (Appliance appliance : appliances) {
            int radiation = appliance.getRadiationLevel();
            if (radiation >= minRadiation && radiation <= maxRadiation) {
                return appliance; // Return the first matching appliance
            }
        }
        return null; // No matching appliance found
    }

    /**
     * Prints the details of all appliances in the apartment.
     */
    public void printAppliances() {
        for (Appliance appliance : appliances) {
            appliance.printDetails(); // Print details of each appliance
        }
        System.out.println();
    }
}
