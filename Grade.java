package main;

//Imports
import java.io.Serializable;

public class Grade implements Serializable{

    //Variables
    private String course;
    private int grade;

    //Constructor
    public Grade(String course, int grade){
        this.course = course;
        this.grade = grade;
    }

    //Getters
    public String getCourse(){
        return course;
    }
   
    public int getGrade(){
        return grade;
    }

}