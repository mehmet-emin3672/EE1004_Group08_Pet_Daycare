import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter daycare name: ");
        String daycareName = scanner.nextLine();
        PetDaycare daycare = new PetDaycare(daycareName);

        while (true) {
            System.out.println("\nPet Daycare Menu");
            System.out.println("1. Register a pet");
            System.out.println("2. List all pets");
            System.out.println("3. Feed a pet");
            System.out.println("4. List hungry pets");
            System.out.println("5. Print care summary");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid token
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter pet type (dog/cat/bird): ");
                    String type = scanner.nextLine().toLowerCase();
                    
                    if (!type.equals("dog") && !type.equals("cat") && !type.equals("bird")) {
                        System.out.println("Unknown pet type. Skipping...");
                        break;
                    }

                    System.out.print("Enter pet name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter pet age: ");
                    int age = 0;
                    try {
                        age = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid age input. Skipping...");
                        scanner.nextLine(); // Clear token
                        break;
                    }

                    System.out.print("Enter owner name: ");
                    String owner = scanner.nextLine();

                    Pet newPet = null;
                    if (type.equals("dog")) {
                        newPet = new Dog(name, age, owner);
                    } else if (type.equals("cat")) {
                        newPet = new Cat(name, age, owner);
                    } else if (type.equals("bird")) {
                        newPet = new Bird(name, age, owner);
                    }

                    if (newPet != null) {
                        daycare.registerPet(newPet);
                    }
                    break;

                case 2:
                    daycare.listAllPets();
                    break;

                case 3:
                    System.out.print("Enter pet name to feed: ");
                    String feedName = scanner.nextLine();
                    daycare.feedPet(feedName);
                    break;

                case 4:
                    daycare.listHungryPets();
                    break;

                case 5:
                    daycare.printCareSummary();
                    break;

                case 6:
                    System.out.println("Exiting. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 6.");
            }
        }
    }
}