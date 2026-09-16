import java.util.ArrayList;

public class ZooKeeper {
    private String name; // name of the zookeeper which will be defined in either zoo or the menu class

    // the constructor for the zookeeper
    public ZooKeeper(String name){
        this.name = name;
    }

    // a method called dailycare which goes from the animal arraylist and triggers their functions for each different
    // interface while also triggering the "makeSound" in the specific animal class
    public void DailyCare(ArrayList<Animal> animals){
        System.out.println(name + " is starting daily rounds...");
        for (Animal a : animals){ // the for loop that goes through each animal
            System.out.println("Checking on " + a.getName());

            if (a instanceof Swimmable){ // instanceof checks if an object is an instance of or have a specific class.
                ((Swimmable)a).check_Gills();
            }

            if (a instanceof Flyable){
                ((Flyable)a).check_Wings();
            }

            if (a instanceof Climbable){
                ((Climbable)a).check_Limbs();
            }
            if (a instanceof  Walkable){
                ((Walkable)a).check_Limbs();
            }

            System.out.println("Interacting with: " + a.getName() + ". responds with: " + a.makeSound());

            System.out.println(" "); // buffer to space out the animals
        }
    }
}
