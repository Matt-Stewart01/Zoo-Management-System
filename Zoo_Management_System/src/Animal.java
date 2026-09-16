public abstract class Animal { // abstract class used for all animals.
    private String name; // variables defining the name, age, colour and weight
    private int age;
    private String colour;
    private double weight;

    // Constructor used to initialise the variables
    public Animal(String name,int age,String colour,double weight){
        this.name = name;
        this.age = age;
        this.colour = colour;
        this.weight = weight;
    }

    // getters and setters
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getColour(){
        return colour;
    }
    public double getWeight(){
        return weight;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // IsValid is a method that is used to check that data input isn't empty or invalid
    public boolean IsValid(){
        return name != null && !name.isEmpty() && colour != null && !colour.isEmpty();
    }

    // a method used for the animal sound when triggered
    public abstract String makeSound();


}
