public class Dog extends Pet {
    public Dog(String name, int age, String ownerName) {
        super(name, age, ownerName, 250, 2);
    }

    @Override
    public String getCareInstructions() {
        return "Walk twice daily";
    }

    @Override
    public String toString() {
        return getBaseInfo() + "\n" + (isFedToday ? "Fed Today" : "Not Fed");
    }
}