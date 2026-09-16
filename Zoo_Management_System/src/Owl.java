public class Owl extends Animal implements Flyable{
    private int Grip_Power; // unique int variable

    // Constructor to initialise variables from animal along with new Owl specific variables
    public Owl(String name, int age, String colour, double weight, int Grip_Power) {
        super(name, age, colour, weight);
        this.Grip_Power = Grip_Power;
    }

    // shows polymorphism by providing specific class defined sounds | will be used for the main = DailyCare
    @Override
    public String makeSound(){
        return ("Hoot Hoot. I am "+ getName()+", a "+getAge()+" year old Owl.");
    }

    // Implementation of Interfaces
    @Override
    public void fly(){
        System.out.println(getName()+" is soaring the enclosure.");
    }

    @Override
    public void check_Wings(){
        System.out.println("Checking "+getName()+" Wings for injuries.");
    }

    // getters and setters which will be used for getting data and setting data of a defined animal
    public int getGrip_Power(){
        return Grip_Power;
    }

    public void setGrip_Power(int grip_Power) {
        Grip_Power = grip_Power;
    }
}
