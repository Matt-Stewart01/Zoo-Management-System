public class Eagle extends Animal implements Flyable{
    private int Wing_Span; // unique int variable

    // Constructor to initialise variables from animal along with new Eagle specific variables
    public Eagle(String name, int age, String colour, double weight, int Wing_Span) {
        super(name, age, colour, weight);
        this.Wing_Span = Wing_Span;
    }

    // Shows polymorphism by providing specific class defined sounds | Will be used for the main = DailyCare
    @Override
    public String makeSound(){
        return ("Caw. Caw. I am "+ getName()+", a "+getAge()+" year old Eagle.");
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
    public int getWing_Span(){return Wing_Span;}

    public void setWing_Span(int wing_Span) {
        Wing_Span = wing_Span;
    }
}
