# Zoo-Management-System
This is a terminal command line interface type of zoo management System which i have developed as part of my second coursework at university during my second semester using OOP principles that I have learned through 12-14 weeks from the start to finish of the module.

The zoo managament system is a terminal command line interfaced program in which it allows us to manage a zoo system practically such as being able to add, remove, modify, view and print report of animals using key OOP concepts such as file I/O, Error and debugging, Polymorphism, method overriding and inhertitence and Encapulation. Along with some other concepts as well with abtract and interface classes.

# Programming Language
Java

# Functions
- Adding Animals
        To add an animal it will ask you a list of questions to input into the terminal such as             what animal it is. The name, age, colour and weight. Then asking you to specify the special         animal unqiue value. Then it validates if the information is valid and inputted correct and         if yes. Then it will add the animal to the ArrayList.
- Removing Animals
        Asks you to input an animal name and then finds the animal in the arraylist and removes it.
- Modify Animal
        Asks the name of the animal to modify and then triggers a function allowing you to select a         specific feature of the animal to change.
- View All Animals
      Simply prints out all the animals from the ArrayList and then plays their sound which is            basically just a simple greet.
- Print Zoo Report
      This report prints the total amount of animals along with the animals of each type as well.         It will also find what is the dominant colour out of the all of the colours. 
- Perform Daily Care
      This is a function found with the zoo keeper in which it will go through each animal in the         arraylist and trigger a specicalised function in the animal class found in the specified            animal interface.
- Search Animal By Name/Colour
      This function asks the user to input either a name or colour to find a specific animal or           multiple animals with the same name or colour. After you input a name or colour it will             search through the ArrayList for the animal which matches the inputs.
- Save
      A simple method calling where it gets all the data saved in the arraylist and saved it to a         text file using file I/O methods.
- Save & Exit
      This does the same as save however it simply ends the program.
