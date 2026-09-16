import java.util.ArrayList; // the imports that I will be using to assist with programming
import java.util.InputMismatchException;
import java.util.Scanner; // used to read data from the AnimalDetails.txt
import java.io.*;

public class Main { // the menu interface that the user will be interacting with
    public static void main(String[] args){
        Zoo myZoo = loadData();
        ZooKeeper keeper = new ZooKeeper("Morgan");
        Scanner input = new Scanner(System.in);

        boolean Active_Session = true; // if false then session ends/ EXIT
        while (Active_Session){ // while loop which keeps the menu active
            System.out.println("\n---- " + myZoo.getZooName() + " Management System ----");
            System.out.println("1. Add Animal");
            System.out.println("2. Remove Animal");
            System.out.println("3. Modify Animal");
            System.out.println("4. View All Animals");
            System.out.println("5. Print Zoo Report");
            System.out.println("6. Perform Daily Care");
            System.out.println("7. Search by Name/Colour");
            System.out.println("8. Save");
            System.out.println("9. Save & Exit");
            System.out.println("Select an Option: ");

            // gets the input of the user
            try {
                int choice = Integer.parseInt(input.nextLine());

                switch(choice){ // switch used to trigger what event is called in a specific case
                    case 1:
                        try {
                            Animal newAnimal = null;
                            System.out.println("Select Animal Type");

                            DisplayAnimals();

                            int type = input.nextInt();
                            input.nextLine();
                            // inputs name, age, colour, weight
                            System.out.print("Enter Name: ");
                            String name = input.nextLine();

                            System.out.print("Enter Age: ");
                            int age = input.nextInt();

                            System.out.print("Enter Colour: ");
                            input.nextLine();
                            String colour = input.nextLine();

                            System.out.print("Enter Weight: ");
                            double weight = input.nextDouble();

                            if (type == 1){ // used to define the animal specific variable value
                                System.out.println("Enter Tail Strength: ");
                                int tail_Strength = input.nextInt();
                                newAnimal = new Monkey(name, age, colour, weight, tail_Strength);
                            } else if (type == 2) {
                                System.out.println("Enter Silk Strength");
                                int silk_Strength = input.nextInt();
                                newAnimal = new Spider(name, age, colour, weight, silk_Strength);
                            } else if (type == 3) {
                                System.out.println("Enter Jaw Strength");
                                int jaw_Strength = input.nextInt();
                                newAnimal = new Shark(name, age, colour, weight, jaw_Strength);
                            } else if (type == 4) {
                                System.out.println("Enter Ink Intensity");
                                int ink_Intensity = input.nextInt();
                                newAnimal = new Squid(name, age, colour, weight, ink_Intensity);
                            } else if (type == 5) {
                                System.out.println("Enter Sonar Strength");
                                int sonar_Strength = input.nextInt();
                                newAnimal = new Dolphin(name, age, colour, weight, sonar_Strength);
                            } else if (type == 6) {
                                System.out.println("Enter Grip Strength");
                                int grip_Strength = input.nextInt();
                                newAnimal = new Owl(name, age, colour, weight, grip_Strength);
                            } else if (type == 7) {
                                System.out.println("Enter Wing Span");
                                int wing_Span = input.nextInt();
                                newAnimal = new Eagle(name, age, colour, weight, wing_Span);
                            } else if (type == 8) {
                                System.out.println("Enter Trunk Length");
                                int trunk_Length = input.nextInt();
                                newAnimal = new Elephant(name, age, colour, weight, trunk_Length);
                            } else if (type == 9) {
                                System.out.println("Enter Mane Size");
                                int mane_size = input.nextInt();
                                newAnimal = new Lion(name, age, colour, weight, mane_size);
                            }

                            assert newAnimal != null;
                            if (newAnimal.IsValid()){ // checks if the animal is valid (will be saved if true)
                                myZoo.addAnimal(newAnimal);
                                System.out.println("Animal successfully implemented.");
                            } else {
                                System.out.println("Warning, one or more fields were left blank. Animal will not be saved to disk");
                            }
                            break;
                        } catch (InputMismatchException e){
                            System.out.println("ERROR: input is not valid");
                            break;
                        }

                    case 2: // case to remove the animal
                        System.out.println("Enter Animal Type to remove: ");
                        String query1 = input.nextLine();

                        System.out.println("Enter Animal Name to remove: ");
                        String query2 = input.nextLine();

                        myZoo.removeAnimal(query1 ,query2);
                        break;
                    case 3: // case to modify the animal
                        System.out.println("Enter Animal Type to modify: ");
                        String modify_query1 = input.nextLine();

                        System.out.println("Enter Animal Name to modify: ");
                        String modify_query2 = input.nextLine();

                        myZoo.modifyAnimal(modify_query1,modify_query2,input);
                        break;
                    case 4: // case used to view all animals
                        System.out.println("Getting Animal Information...");
                        myZoo.viewAnimals();
                        break;
                    case 5: // case used to print the report
                        myZoo.printReport();
                        break;
                    case 6: // case used for daily care
                        ArrayList<Animal> ToCareFor = myZoo.getAnimals();

                        if (ToCareFor.isEmpty()){
                            System.out.println("There are no animals to care for!");
                        } else {
                            keeper.DailyCare(ToCareFor);
                        }
                        break;
                    case 7: // case used to search for animal
                        try {
                            System.out.println("Enter a name of colour to search for: ");
                            myZoo.searchAnimal(input.nextLine());
                            break;
                        } catch (InputMismatchException e){
                            System.out.println("ERROR: input contains invalid characters");
                            break;
                        }

                    case 8: // case used to save all animals to AnimalDetails.txt
                        System.out.println("Saving animal data to disk");
                        myZoo.saveToDisk();
                        break;
                    case 9: // case used to save all animals and exit
                        System.out.println("Saving animal data and ending program.");
                        myZoo.saveToDisk();
                        Active_Session = false;
                        break;
                    default: // default case triggered if no cases are defined in the switch input
                        System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR: Input is not a valid number. Not text");
            }
        }

    }

    private static void DisplayAnimals(){
        String[] CurrAnimals = {"Monkey","Spider","Shark","Squid","Dolphin","Owl","Eagle","Elephant","Lion"};

        for (int i = 0; i < CurrAnimals.length; i++) {
            System.out.println((i+1)+". "+CurrAnimals[i]);
        }
    }

    private static Zoo loadData(){ // method used to get the data from AnimalDetails.txt and ZooDetails.txt
        String zooName = "Default Zoo"; // variable used if ZooDetails file does not exist

        try (Scanner zooScanner = new Scanner(new File("ZooDetails.txt"))){
            if (zooScanner.hasNextLine()){
                zooName = zooScanner.nextLine();
            }
        } catch (FileNotFoundException e){
            System.out.println("ZooDetails.txt not found. Using default name");
        }

        Zoo loadedZoo = new Zoo(zooName);

        try (Scanner scanner = new Scanner(new File("AnimalDetails.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()){
                    continue;
                }
                String [] data = line.split(","); // data used to hold all animal details.

                String type = data[0];
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String colour = data[3];
                double weight = Double.parseDouble(data[4]);

                if (type.equalsIgnoreCase("Monkey")){
                    int tail_strength = Integer.parseInt(data[5]);
                    loadedZoo.addAnimal(new Monkey(name, age, colour, weight, tail_strength));
                }
                if (type.equalsIgnoreCase("Spider")){
                    int Silk_Strength = Integer.parseInt(data[5]);
                    loadedZoo.addAnimal(new Spider(name, age, colour, weight, Silk_Strength));
                }
                if (type.equalsIgnoreCase("Shark")){
                    int Jaw_strength = Integer.parseInt(data[5]);
                    loadedZoo.addAnimal(new Shark(name, age, colour, weight, Jaw_strength));
                }
                if (type.equalsIgnoreCase("Squid")){
                    int Ink_Intensity = Integer.parseInt(data[5]);
                    loadedZoo.addAnimal(new Squid(name, age, colour, weight, Ink_Intensity));
                }
                if (type.equalsIgnoreCase("Dolphin")){
                    int Sonar = Integer.parseInt(data[5]);
                    loadedZoo.addAnimal(new Dolphin(name, age, colour, weight, Sonar));
                }
                if (type.equalsIgnoreCase("Owl")){
                    int Grip_Power = Integer.parseInt(data[5]);
                    loadedZoo.addAnimal(new Owl(name, age, colour, weight, Grip_Power));
                }
                if (type.equalsIgnoreCase("Eagle")){
                    int Wing_Span = Integer.parseInt(data[5]);
                    loadedZoo.addAnimal(new Eagle(name, age, colour, weight, Wing_Span));
                }
                if (type.equalsIgnoreCase("Elephant")){
                    int trunk_length = Integer.parseInt(data[5]);
                    loadedZoo.addAnimal(new Elephant(name, age, colour, weight, trunk_length));
                }
                if (type.equalsIgnoreCase("Lion")){
                    int mane_Length = Integer.parseInt(data[5]);
                    loadedZoo.addAnimal(new Lion(name, age, colour, weight, mane_Length));
                }

            }
            System.out.println("Data loaded from disk.");
        } catch (Exception e){
            System.out.println("Error reading animal records: " + e.getMessage());
        } return loadedZoo;
    }
}
