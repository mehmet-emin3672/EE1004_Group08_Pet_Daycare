public abstract class Pet {
    protected String name;
    protected int age;
    protected String ownerName;
    protected boolean isFedToday;
    
    protected int gramsPerMeal;
    protected int mealsPerDay;

    public Pet(String name, int age, String ownerName, int gramsPerMeal, int mealsPerDay) {
        this.name = name;
        this.age = age;
        this.ownerName = ownerName;
        this.gramsPerMeal = gramsPerMeal;
        this.mealsPerDay = mealsPerDay;
        this.isFedToday = false;
    }

    public abstract String getCareInstructions();

    public int getDailyFoodTotal() {
        return gramsPerMeal * mealsPerDay;
    }

    public String getName() {
        return name;
    }

    public boolean isFedToday() {
        return isFedToday;
    }

    public void feed() {
        this.isFedToday = true;
    }

    public String getBaseInfo() {
        String type = this.getClass().getSimpleName();
        return "[" + type + "] " + name + " (Age: " + age + ") Owner: " + ownerName;
    }

    @Override
    public abstract String toString();
}