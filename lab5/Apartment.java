package lab5;
import java.util.ArrayList;
import java.util.List;

public class Apartment {
    private Appliance[] appliances;

    public Apartment(Appliance[] appliances) {
        this.appliances = appliances;
    }

    // Увімкнути прилад за індексом.
    public void turnOn(int index) {
        if (index >= 0 && index < appliances.length) {
            appliances[index].turnOn();
        } else {
            System.out.println("Invalid index: " + index);
        }
    }

    // Підрахувати загальну споживану потужність лише увімкнених приладів.
    public int calculateTotalPower() {
        int totalPower = 0;
        for (Appliance appliance : appliances) {
            if (appliance.isOn()) { // Перевіряємо, чи увімкнений прилад.
                totalPower += appliance.getPower();
            }
        }
        return totalPower;
    }

    // Сортування ввімкнутих приладів за потужністю.
    public void sortAppliancesByPower() {
        // Create a temporary list to hold the appliances that are turned on
        List<Appliance> onAppliances = new ArrayList<>();
    
        // Add only the appliances that are on to the list
        for (Appliance appliance : appliances) {
            if (appliance.isOn()) {
                onAppliances.add(appliance);
            }
        }
    
        // Sort the appliances that are on by power
        for (int i = 0; i < onAppliances.size() - 1; i++) {
            for (int j = i + 1; j < onAppliances.size(); j++) {
                if (onAppliances.get(i).getPower() > onAppliances.get(j).getPower()) {
                    Appliance temp = onAppliances.get(i);
                    onAppliances.set(i, onAppliances.get(j));
                    onAppliances.set(j, temp);
                }
            }
        }
    
        // Update the original array with the sorted appliances
        System.out.println("Ввімкнуті прилади, відсортовані за потужністю:");
        for (Appliance appliance : onAppliances) {
            System.out.println(getClass().getSimpleName() + " " + appliance.getBrand() + " with Power: " + appliance.getPower() + "W");
        }
        System.out.println();
    }

    // Знайти прилад за заданим діапазоном електромагнітного випромінювання.
    public Appliance findApplianceByRadiationRange(int minRadiation, int maxRadiation) {
        for (Appliance appliance : appliances) {
            int radiation = appliance.getRadiationLevel();
            if (radiation >= minRadiation && radiation <= maxRadiation) {
                return appliance;
            }
        }
        return null;
    }

    // Вивести інформацію про всі прилади.
    public void printAppliances() {
        for (Appliance appliance : appliances) {
            appliance.printDetails();
        }
        System.out.println();
    }
}