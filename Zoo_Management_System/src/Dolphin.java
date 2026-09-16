public class Dolphin extends Animal implements Swimmable{
    private int Sonar_Strength; // unique int variable

    // Constructor to initialise variables from animal along with new Dolphin specific variables
    public Dolphin(String name, int age, String colour, double weight, int Sonar) {
        super(name, age, colour, weight);
        this.Sonar_Strength = Sonar;
    }


    // Shows polymorphism by providing specific class defined sounds | Will be used for the main = DailyCare
    @Override
    public String makeSound(){
        return ("eee-ee ah-ah-ee. I am "+ getName()+", a "+getAge()+" year old Dolphin.");
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
    public int getSonar_Strength(){
        return Sonar_Strength;
    }

    public void setSonar_Strength(int sonar) {
        Sonar_Strength = sonar;
    }
}
