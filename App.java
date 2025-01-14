package com.main;
//Import Scanner to read terminal value
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        //Make a basic hedgehog and open a scanner to read terminal input
        Hedgehog sonic = new Hedgehog("Pikseli", 5);
        Scanner scanner = new Scanner(System.in);

        while(true){
            //Call the start function to ask the question. 
            //I know it could be done by just asking here but I try to be fancy
            sonic.start();
            //Ask user what to do?
            int choice; 
            try{
                choice = Integer.parseInt(scanner.nextLine());  
            }  
            catch(Exception e){
                System.out.println("Wrong input value");
                continue;
            }   
            //If choice 1 ask user for phrase for hedgehog to say 
            if(choice == 1){
                System.out.println("What does the hedgehog say?");
                String phrase = scanner.nextLine();
                sonic.speak(phrase);
            }
            //If choice 2 ask user for name and age and construct new hedgehog
            else if(choice == 2){
                System.out.println("What is the name of hedgehog?");
                String name = scanner.nextLine();
                System.out.println("What is the name of hedgehog?");
                int age = -1;
                try{
                    age = Integer.parseInt(scanner.nextLine());  
                }  
                catch(Exception e){
                    System.out.println("Wrong input value");
                    continue;
                } 
                sonic = new Hedgehog(name, age);
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
                sonic.run(laps);
            }
            //If choice 0 break the loop and print thank you!
            else if(choice == 0){
              System.out.println("Thank you for using the program!");
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
