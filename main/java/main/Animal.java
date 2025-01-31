package main;

public class Animal {
    //Variables
    String species;
    String name;
    int age;


    //Constructor to initialize the new animal
    public Animal(String species, String name, int age) 
    {
        this.species = species;
        this.name = name;
        this.age = age;
    }
    //This part was from ChatGPT: "The Getters" 
    public String getSpecies() {
        return species;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    //ChatGPT part ends
    
    //Method to run we call this in zoo
    public void run(int laps)
    {
        for(int i = 0; i<laps; i++)
        {
            System.out.println(name+" runs really fast!");
        }
    }
}

