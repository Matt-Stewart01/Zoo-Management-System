public class Shark extends Animal implements Swimmable{
    private int Jaw_Strength; // unique int variable

    // Constructor to initialise variables from animal along with new Shark specific variables
    public Shark(String name, int age, String colour, double weight, int Jaw_Strength) {
        super(name, age, colour, weight);
        this.Jaw_Strength = Jaw_Strength;
    }

    // Shows polymorphism by providing specific class defined sounds | Will be used for the main = DailyCare
    @Override
    public String makeSound(){
        return ("humm-hum. I am "+ getName()+", a "+getAge()+" year old Shark.");
    }

    // Implementation of Interfaces
    @Override
    public void swim(){
        System.out.println(getName()+" is swimming in it's tank.");
    }

    @Override
    public void check_Gills(){
        System.out.println("Checking "+getName()+" Gills for infection.");
    }

    // getters and setters which will be used for getting data and setting data of a defined animal
    public int getJaw_Strength(){
        return Jaw_Strength;
    }

    public void setJaw_Strength(int jaw_Strength) {
        Jaw_Strength = jaw_Strength;
    }
}
