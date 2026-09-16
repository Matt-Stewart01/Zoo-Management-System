public class Monkey extends Animal implements Climbable{
    private int tail_Strength;  // unique int variable

    // Constructor to initialise variables from animal along with new Monkey specific variables
    public Monkey(String name, int age, String colour, double weight, int tail_Strength) {
        super(name, age, colour, weight);
        this.tail_Strength = tail_Strength;
    }

    // Shows polymorphism by providing specific class defined sounds | Will be used for the main = DailyCare
    @Override
    public String makeSound(){
        return ("Ooh ooh, aah ah. I am "+ getName()+", a "+getAge()+" year old monkey.");
    }

    // Implementation of Interfaces
    @Override
    public void climb(){
        System.out.println(getName()+" is climbing up a tree.");
    }

    @Override
    public void check_Limbs(){
        System.out.println("Checking "+getName()+" Legs and Arms for injuries.");
    }

    // getters and setters which will be used for getting data and setting data of a defined animal
    public int getTail_Strength(){
        return tail_Strength;
    }

    public void setTail_Strength(int tail_strength) {
        this.tail_Strength = tail_strength;
    }
}
