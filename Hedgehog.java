package com.main;

public class Hedgehog {
    //Variables
    String name;
    int age;


    //Constructor to initialize the Hedgehog with variables name and age
    public Hedgehog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Method to make the hedgehod speak
    public void speak(String phrase) {
        //If phrase is empty print this
        if(phrase == ""){
            System.out.println("I am "+name+"and my age is "+age);  
        }
        //If phrase not empty print this
        else{
            System.out.println(name+":"+phrase);
        }
    }
    
    //This method makes the hedgehod run
    public void run(int laps){

        for(int i = 0; i<laps; i++)
        {
            System.out.println(name+" runs really fast!");
        }

    }

    //This methods just prints the question
    public void start() {
        System.out.println("1) Make hedgehog talk, 2) Create new hedgehog, 3) Make hedgehog run, 0) Quit");
    }
}
