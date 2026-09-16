public class Squid extends Animal implements Swimmable{
    private int Ink_Intensity; // unique int variable

    // Constructor to initialise variables from animal along with new Squid specific variables
    public Squid(String name, int age, String colour, double weight, int Ink_Intensity) {
        super(name, age, colour, weight);
        this.Ink_Intensity = Ink_Intensity;
    }

    // Shows polymorphism by providing specific class defined sounds | Will be used for the main = DailyCare
    @Override
    public String makeSound(){
        return ("blub blub. I am "+ getName()+", a "+getAge()+" year old Squid.");
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
    public int getInk_Intensity(){
        return Ink_Intensity;
    }

    public void setInk_Intensity(int ink_Intensity) {
        Ink_Intensity = ink_Intensity;
    }
}
