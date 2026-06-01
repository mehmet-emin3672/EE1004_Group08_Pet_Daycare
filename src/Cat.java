public class Cat extends Pet {
    public Cat(String name, int age, String ownerName) {
        super(name, age, ownerName, 100, 3);
    }

    @Override
    public String getCareInstructions() {
        return "Clean litter box";
    }

    @Override
    public String toString() {
        return getBaseInfo() + "\n" + (isFedToday ? "Fed Today" : "Not Fed");
    }
}