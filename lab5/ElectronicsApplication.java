package lab5;

public class ElectronicsApplication {
    public static void main(String[] args) {
        // Створення приладів
        Appliance washingMachine = new WashingMachine("Samsung", 500, 7, 1200);
        Appliance microwave = new Microwave("LG", 800, 25, 1000);
        Appliance robotVacuum = new RobotVacuum("iRobot", 100, 30, 60);
        Appliance handheldVacuum = new HandheldVacuum("Dyson", 200, 25, 500, 1);

        // Додавання приладів до масиву
        Appliance[] appliances = { washingMachine, microwave, handheldVacuum, robotVacuum};
        Apartment apartment = new Apartment(appliances);

        System.out.println("Створений масив приладів:");
        apartment.printAppliances();

        // Увімкнення деяких приладів
        apartment.turnOn(0); // Увімкнути пральну машину
        apartment.turnOn(1); // Увімкнути мікрохвильовку
        apartment.turnOn(3); // Увімкнути автоматичний пилосос

        // Підрахунок загальної потужності
        int totalPower = apartment.calculateTotalPower();
        System.out.println("Загальна споживана потужність: " + totalPower + " Вт");
        System.out.println();

        // Сортування приладів за потужністю
        apartment.sortAppliancesByPower();

        // Пошук приладу за рівнем випромінювання
        Appliance foundAppliance = apartment.findApplianceByRadiationRange(70, 200); // Діапазон радіації
        if (foundAppliance != null) {
            System.out.println("Знайдено прилад із заданим діапазоном випромінювання: " + foundAppliance.getClass().getSimpleName());
        } else {
            System.out.println("Прилад із заданим діапазоном випромінювання не знайдено.");
        }
    }
}
