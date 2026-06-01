import java.util.ArrayList;
import java.util.List;

public class PetDaycare {
    private String name;
    private List<Pet> pets;

    public PetDaycare(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

    public void registerPet(Pet p) {
        pets.add(p);
        System.out.println("Pet registered!");
    }

    public void listAllPets() {
        for (Pet p : pets) {
            System.out.println(p.toString());
        }
    }

    public void feedPet(String petName) {
        for (Pet p : pets) {
            if (p.getName().equalsIgnoreCase(petName)) {
                p.feed();
                System.out.println(p.getName() + " has been fed! (" + p.getDailyFoodTotal() + "g total today)");
                return;
            }
        }
        System.out.println("Pet not found.");
    }

    public void listHungryPets() {
        System.out.println("Hungry pets:");
        for (Pet p : pets) {
            if (!p.isFedToday()) {
                System.out.println(p.getBaseInfo());
            }
        }
    }

    public void printCareSummary() {
        System.out.println("========== Care Summary ==========");
        for (Pet p : pets) {
            String type = p.getClass().getSimpleName();
            String status = p.isFedToday() ? "Fed Today" : "NOT Fed";
            System.out.println("[" + type + "] " + p.getName() + ": " + p.getCareInstructions() + 
                               ", " + p.getDailyFoodTotal() + "g food/day \t" + status);
        }
    }
}