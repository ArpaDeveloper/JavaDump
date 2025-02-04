package main;

//imports
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class University {
    
    //Arraylist for the students
    private ArrayList<Student> students = new ArrayList<>();

    //Serial version UID for ensuring compability (I guess this is used for filehandling)
    private static final long serialVersionUID = 1L;
    
    //This was ChatGPT part. (The ArrayList were a bit of a problem for me)
    public University(ArrayList<Student> students){
        this.students = students;
    }
    //ChatGPT part ends.

    public void addStudent(String s_name, String s_number) {
        Student student = new Student(s_name, s_number);  
        students.add(student);  
    }

    //This part was from ChatGPT (way to get students, couldn't figure out how the Arraylist works here)
    public ArrayList<Student> getStudent(){
        return students;
    }

    //Method to lits and print all the students. I had this done better but codegrade wants to students start from 0 >:(
    public void listStudents(){
        if(students.isEmpty()){
            System.out.println("No students found");
        }
        else{
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                System.out.println((i)+": "+student.getNumber()+": "+student.getName());
            }
        }
        
    }

 
    //Getters
    public int getIndex(int s_number) {
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getNumber().equals(s_number)) {
            return i;  
        }
    }
    return -1;  
    }
    //ChatGPT part ends

    //I used youtube tutorial+ChatGpt+Slides to make the file handling
    public static void saveFile(ArrayList<Student> students, String filename){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(students);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    //This loads the file
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadFile(String filename){
        ArrayList<Student> loadedStudents = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                loadedStudents = (ArrayList<Student>) obj;
            } else {
                System.out.println("Error: The file content is not of type ArrayList<Student>.");
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return loadedStudents;
    }

    //This puts the loaded students in the students
    public void FromFileToList(String filename) {
        ArrayList<Student> loadedStudents = loadFile(filename);
        
        if (!loadedStudents.isEmpty()) {
            //Add students instead of replacing the whole list
            //students.addAll(loadedStudents);
            students = loadedStudents;
            System.out.println("Students loaded from file.");
        } else {
            System.out.println("No students found in the file.");
        }
    }
}
