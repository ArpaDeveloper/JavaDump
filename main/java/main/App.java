package main;
//Import Scanner to read terminal value
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //I copied my last code used in App/Hedgehog and modeled this new code from it
        
        //Make a scanner to read input from terminal
        Scanner scanner = new Scanner(System.in);
        //Ask user for zoo's name
        System.out.println("Please, name the zoo:");
        String zoo_name = scanner.nextLine();
        //Create new object in zoo with the zoo name
        Zoo tarha = new Zoo(zoo_name);

        while(true){
           
            //Ask user what to do?
            System.out.println("1) Create a new animal, 2) List all animals, 3) Run animals, 0) End the program");
            int choice;
            try{
                choice = Integer.parseInt(scanner.nextLine());  
            }
            catch(Exception e){
                System.out.println("Wrong input value");
                continue;
            }
            //If choice 1 ask user for species/name/age of new animal
            if(choice == 1){
                System.out.println("What species?");
                String species = scanner.nextLine();
                System.out.println("Enter the name of the animal:");
                String name = scanner.nextLine();
                System.out.println("Enter the age of the animal:");
                int age = -1;
                try{
                    age = Integer.parseInt(scanner.nextLine());   
                }
                catch(Exception e){
                    System.out.println("Wrong input value");
                    continue;
                }
                //Instead of calling the Animal constructor lets just call method in zoo to make an animal
                tarha.addAnimal(species, name, age);

            }
            //If choice 2 list all animals
            else if(choice == 2){
                //Call the method to list all animals
                tarha.ListAnimals();
            }
            else if(choice == 3){
                System.out.println("How many laps?");
                int laps = -1;
                try{
                    laps = Integer.parseInt(scanner.nextLine());   
                }
                catch(Exception e){
                    System.out.println("Wrong input value");
                    continue;
                }
                tarha.RunAnimals(laps);
            }
            //If choice 0 break the loop and print thank you!
            else if(choice == 0){
              System.out.println("Thank you for using the program.");
              scanner.close();
              break;
            }
            //If choice is not 0-3 its not valid
            else{
                System.out.println("Wrong input value");
            }
        }
    }
}
