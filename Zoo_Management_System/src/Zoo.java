import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Zoo {
    // Zoo class that will be used to store the animals into an array while holding functions to manipulate
    // the animals
    private String zooName;
    private ArrayList<Animal> animals;
    private ZooKeeper keeper = new ZooKeeper("John");

    // Constructor for the Zoo class initialising its variables
    public Zoo(String zooName) {
        this.zooName = zooName;
        this.animals = new ArrayList<>();
    }

    // getters
    public String getZooName(){
        return zooName;
    }
    public ArrayList<Animal> getAnimals(){
        return animals;
    }

    // method used to upon creating the animal which checks if the animal is valid first of.
    public void addAnimal(Animal a) {
        if (a != null && a.IsValid()) {
            if (a.getAge() < 0) {
                System.out.println("Error, Age cannot be added. Animal will not be implemented");
            } else {
                animals.add(a);
            }

        }
    }

    // method used to remove the animal
    public void removeAnimal(String query1, String query2){
        int initialSize = animals.size();

        // removeIf uses a lambda expression to check each animal
        animals.removeIf(a -> a.getClass().getSimpleName().equalsIgnoreCase(query1) &&
                a.getName().equalsIgnoreCase(query2)
        );

        if (animals.size() < initialSize) {
            System.out.println("SUCCESS: " + query1 + ", " + query2 + " removed from the zoo.");
        } else {
            System.out.println("ERROR: No " + query1 + " named," + query2 + " was found.");
        }
    }

    // method to search for the animal with either a name or colour
    public void searchAnimal(String query){
        boolean found = false;
        System.out.println("Searching...");

        for (Animal a : animals){
            if (a.getName().equalsIgnoreCase(query) || a.getColour().equalsIgnoreCase(query)){
                System.out.println("Found: " + a.getName());
                System.out.println("Response: " + a.makeSound());
                found = true;
            }
        }
        if (!found){
            System.out.println("Query does not match no animals in the zoo.");
        }
    }

    // method to view all the animals, uses a string which gets all the information of the animal and then prints it
    // out in output
    public void viewAnimals(){
        if (animals.isEmpty()){
            System.out.println("The zoo currently has no animals!");
        }

        for (Animal a : animals){
            String dataLine = "Animal Type: " + a.getClass() + ", Name: " + a.getName() + ", Age: " + a.getAge() +
            ", Colour: " + a.getColour() + ", Weight: " + a.getWeight();

            if (a instanceof Monkey) {
                dataLine += ", Tail Strength: " + ((Monkey) a).getTail_Strength();
            } else if (a instanceof Spider) {
                dataLine += ", Silk Strength: " + ((Spider) a).getSilk_Strength();
            } else if (a instanceof Shark) {
                dataLine += ", Jaw Strength: " + ((Shark) a).getJaw_Strength();
            } else if (a instanceof Squid) {
                dataLine += ", Ink Intensity: " + ((Squid) a).getInk_Intensity();
            } else if (a instanceof Dolphin) {
                dataLine += ", Sonar Strength: " + ((Dolphin) a).getSonar_Strength();
            } else if (a instanceof Owl) {
                dataLine += ", Grip Power: " + ((Owl) a).getGrip_Power();
            } else if (a instanceof Eagle) {
                dataLine += ", Wing Span: " + ((Eagle) a).getWing_Span();
            } else if (a instanceof Elephant) {
                dataLine += ", Trunk Length: " + ((Elephant) a).getTrunk_length();
            } else if (a instanceof Lion) {
                dataLine += ", Mane_Size: " + ((Lion) a).getMane_Size();
            }

            System.out.println(dataLine);

            if (a instanceof Swimmable){
                ((Swimmable)a).swim();
            }
            if (a instanceof Flyable){
                ((Flyable)a).fly();
            }
            if (a instanceof Climbable){
                ((Climbable)a).climb();
            }
            if (a instanceof  Walkable){
                ((Walkable)a).walk();
            }

            System.out.println(" ");
        }
    }

    // method used to modify the animals with the likes of inputs given by the user based on a specific animal stated.
    public void modifyAnimal(String Type, String Name, Scanner input){
        for (Animal a : animals){


            if (a.getClass().getSimpleName().equalsIgnoreCase(Type) || a.getName().equalsIgnoreCase(Name)){
                try {
                    System.out.println("Found "+ a.getName() + ". Select which detail you wish to change.");
                    System.out.println("1. Name");
                    System.out.println("2. Age");
                    System.out.println("3. Colour");
                    System.out.println("4. Weight");
                    System.out.print("Selection: ");

                    int choice = input.nextInt();
                    input.nextLine();

                    switch(choice){ // gets the next int that the user puts in and a case is called
                        // depending on if the int matches the case
                        case 1:
                            System.out.print("Enter new Name: ");
                            a.setName(input.nextLine());
                            break;
                        case 2:
                            System.out.print("Enter new Age: ");
                            a.setAge(input.nextInt());
                            input.nextLine();
                            break;
                        case 3:
                            System.out.print("Enter new Colour: ");
                            a.setColour(input.nextLine());
                            break;
                        case 4:
                            System.out.print("Enter new Weight: ");
                            a.setWeight(input.nextDouble());
                            input.nextLine();
                            break;
                        case 5: // the case where the animal specific variable value is defined
                            if (a instanceof Monkey){ // this if statement will be used a lot.
                                System.out.print("Enter new Tail Strength: ");
                                ((Monkey) a).setTail_Strength(input.nextInt());
                            } else if (a instanceof Spider){
                                System.out.println("Enter new Silk Strength: ");
                                ((Spider) a).setSilk_Strength(input.nextInt());
                            } else if (a instanceof Shark){
                                System.out.println("Enter new Jaw Strength: ");
                                ((Shark) a).setJaw_Strength(input.nextInt());
                            } else if (a instanceof Squid){
                                System.out.println("Enter new Ink Intensity: ");
                                ((Squid) a).setInk_Intensity(input.nextInt());
                            } else if (a instanceof Dolphin){
                                System.out.println("Enter new Sonar Strength: ");
                                ((Dolphin) a).setSonar_Strength(input.nextInt());
                            } else if (a instanceof Owl){
                                System.out.println("Enter new Grip Power: ");
                                ((Owl) a).setGrip_Power(input.nextInt());
                            } else if (a instanceof Eagle){
                                System.out.println("Enter new Wing Span: ");
                                ((Eagle) a).setWing_Span(input.nextInt());
                            } else if (a instanceof Elephant){
                                System.out.println("Enter new Trunk Length: ");
                                ((Elephant) a).setTrunk_length(input.nextInt());
                            } else if (a instanceof Lion){
                                System.out.println("Enter new Mane Size: ");
                                ((Lion) a).setMane_Size(input.nextInt());
                            }
                            break;
                        default: // default case if no case is picked
                            System.out.println("Update complete");
                    }
                } catch (InputMismatchException e){
                    System.out.println("ERROR: input is not valid");
                    return;
                }
                System.out.println("Animal Info Updated");
                return;
            }
        }
        System.out.println("Animal not found.");
    }

    // method used to save all animal and zoo details to disk.
    public void saveToDisk() {
        try (PrintWriter zooWriter = new PrintWriter("ZooDetails.txt");
             PrintWriter animalWriter = new PrintWriter("AnimalDetails.txt")) {

            zooWriter.println(zooName);

            for (Animal a : animals) { // gets each of the animal
                if (a.IsValid()) {
                    String dataLine = a.getClass().getSimpleName() + "," + a.getName() + "," +
                            a.getAge() + "," + a.getColour() + "," + a.getWeight();

                    if (a instanceof Monkey) {
                        dataLine += "," + ((Monkey) a).getTail_Strength();
                    } else if (a instanceof Spider) {
                        dataLine += "," + ((Spider) a).getSilk_Strength();
                    } else if (a instanceof Shark) {
                        dataLine += "," + ((Shark) a).getJaw_Strength();
                    } else if (a instanceof Squid) {
                        dataLine += "," + ((Squid) a).getInk_Intensity();
                    } else if (a instanceof Dolphin) {
                        dataLine += "," + ((Dolphin) a).getSonar_Strength();
                    } else if (a instanceof Owl) {
                        dataLine += "," + ((Owl) a).getGrip_Power();
                    } else if (a instanceof Eagle) {
                        dataLine += "," + ((Eagle) a).getWing_Span();
                    } else if (a instanceof Elephant) {
                        dataLine += "," + ((Elephant) a).getTrunk_length();
                    } else if (a instanceof Lion) {
                        dataLine += "," + ((Lion) a).getMane_Size();
                    }

                    animalWriter.println(dataLine);
                }

            }
        } catch (IOException e) { // Exception if an error occurs.
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void printReport(){
        System.out.println("\n--- Zoo Report for " + zooName + " ---");
        System.out.println("Total Animals: " + animals.size());

        String dominantColour = null;
        int maxCount = 0;

        for (int i = 0; i < animals.size(); i++){ // gets the size of the animal ArrayList
            String currentColour = animals.get(i).getColour();
            int currentCount = 0;

            for (int j = 0; j < animals.size(); j++){ // get each of the animals favourite colour
                if (animals.get(j).getColour().equalsIgnoreCase(currentColour)){
                    currentCount++;
                }
            }
            if (currentCount > maxCount){
                maxCount = currentCount;
                dominantColour = currentColour;
            }
        }

        // defined variables for counter.
        int monkeyCount = 0;
        int spiderCount = 0;
        int sharkCount = 0;
        int squidCount = 0;
        int dolphinCount = 0;
        int owlCount = 0;
        int eagleCount = 0;
        int elephantCount = 0;
        int lionCount = 0;

        for (Animal a : animals){ // the counter which adds based on animal present of that species
            if (a instanceof Monkey) monkeyCount++;
            if (a instanceof Spider) spiderCount++;
            if (a instanceof Shark) sharkCount++;
            if (a instanceof Squid) squidCount++;
            if (a instanceof Dolphin) dolphinCount++;
            if (a instanceof Owl) owlCount++;
            if (a instanceof Eagle) eagleCount++;
            if (a instanceof Elephant) elephantCount++;
            if (a instanceof Lion) lionCount++;
        }
        // prints out each of the animal max count as well as the dominant colour overall
        System.out.println("Dominant Colour is " + dominantColour + " of " + maxCount + " Animal(s).");
        System.out.println("Monkeys: " + monkeyCount);
        System.out.println("Spiders: " + spiderCount);
        System.out.println("Sharks: " + sharkCount);
        System.out.println("Squids: " + squidCount);
        System.out.println("Dolphins: " + dolphinCount);
        System.out.println("Owls: " + owlCount);
        System.out.println("Eagles: " + eagleCount);
        System.out.println("Elephant: " + elephantCount);
        System.out.println("Lions: " + lionCount);


    }

}
