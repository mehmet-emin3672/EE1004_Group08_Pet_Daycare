public class Bird extends Pet {
    public Bird(String name, int age, String ownerName) {
        super(name, age, ownerName, 20, 4);
    }

    @Override
    public String getCareInstructions() {
        return "Clean cage";
    }

    @Override
    public String toString() {
        return getBaseInfo() + "\n" + (isFedToday ? "Fed Today" : "Not Fed");
    }
}