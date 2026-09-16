public class Elephant extends Animal implements Walkable{
    private int trunk_length; // unique int variable

    // Constructor to initialise variables from animal along with new Elephant specific variables
    public Elephant(String name, int age, String colour, double weight, int trunk_length) {
        super(name, age, colour, weight);
        this.trunk_length = trunk_length;
    }

    // Shows polymorphism by providing specific class defined sounds | Will be used for the main = DailyCare
    @Override
    public String makeSound(){
        return ("Barrruuuhh. Toot!. I am "+ getName()+", a "+getAge()+" year old Elephant.");
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
    public int getTrunk_length(){
        return trunk_length;
    }

    public void setTrunk_length(int trunk_length) {
        this.trunk_length = trunk_length;
    }
}
