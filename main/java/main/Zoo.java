package main;
//Import arrays
import java.util.ArrayList;


public class Zoo {
    //Variables
    String zoo_name;
    ArrayList<Animal> animals_list;

    //Constructor to name the zoo and make list of the animals
    public Zoo(String zoo_name) 
    {
        this.zoo_name = zoo_name;
        animals_list = new ArrayList<>();
    }

    //Add an animal to the zoo
    public void addAnimal(String species, String name, int age) 
    {
        //Make new animal in animal.java with set variables
        Animal elukka = new Animal(species, name, age);
        //Add the new animal to the list
        animals_list.add(elukka);
    }

    public void ListAnimals()
    {
        if (animals_list.isEmpty()) //This method was from StackOverflow its a way to check if array is empty
        {
            System.out.println("There are no animals in the zoo.");
        } 
        else 
        {
            System.out.println(zoo_name+" contains the following animals:");
            //For loop to go through the animals
            for (Animal elukka : animals_list) //This loop was from ChatGpt (I couldn't get it to work without ChatGpt help)
            {
                System.out.println(elukka.species+": "+elukka.name+", "+elukka.age+" years");
            }
        }
    }
   
    public void RunAnimals(int laps)
    {
        if (animals_list.isEmpty()) //This method was from StackOverflow
        {
            System.out.println("There are no animals to run.");
        } 
        else 
        {
            for (Animal elukka : animals_list) //This loop was from ChatGpt 
            {
                elukka.run(laps); 
            }
        }
    }
   

}

