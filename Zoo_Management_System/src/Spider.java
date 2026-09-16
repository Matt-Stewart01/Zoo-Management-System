public class Spider extends Animal implements Climbable{
    private int silk_Strength; // unique int variable

    // Constructor to initialise variables from animal along with new Spider specific variables
    public Spider(String name, int age, String colour, double weight, int Silk_Strength) {
        super(name, age, colour, weight);
        this.silk_Strength = Silk_Strength;
    }

    // Shows polymorphism by providing specific class defined sounds | Will be used for the main = DailyCare
    @Override
    public String makeSound() {
        return ("Hiss. I am "+ getName()+", a "+getAge()+" year old Spider.");
    }

    // Implementation of Interfaces
    @Override
    public void climb(){
        System.out.println(getName()+" is climbing up a log.");
    }

    @Override
    public void check_Limbs(){
        System.out.println("Checking "+getName()+" Legs for injuries.");
    }

    // getters and setters which will be used for getting data and setting data of a defined animal
    public int getSilk_Strength(){
        return silk_Strength;
    }

    public void setSilk_Strength(int Silk_Strength) {
        silk_Strength = Silk_Strength;
    }
}
