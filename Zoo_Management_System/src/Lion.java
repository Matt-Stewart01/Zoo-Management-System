public class Lion extends Animal implements Walkable{
    private int mane_Size; // unique int variable

    // Constructor to initialise variables from animal along with new Lion specific variables
    public Lion(String name, int age, String colour, double weight, int mane_Size) {
        super(name, age, colour, weight);
        this.mane_Size = mane_Size;
    }

    // Shows polymorphism by providing specific class defined sounds | Will be used for the main = DailyCare
    @Override
    public String makeSound(){
        return ("Roarrrr!. I am "+ getName()+", a "+getAge()+" year old Lion.");
    }

    // Implementation of Interfaces
    @Override
    public void walk(){
        System.out.println(getName()+" is walking around the enclosure.");
    }

    @Override
    public void check_Limbs(){
        System.out.println("Checking "+getName()+" Limbs for injuries.");
    }

    // getters and setters which will be used for getting data and setting data of a defined animal
    public int getMane_Size(){
        return mane_Size;
    }

    public void setMane_Size(int mane_Size) {
        this.mane_Size = mane_Size;
    }
}
