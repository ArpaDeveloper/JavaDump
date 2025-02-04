package main;

//Imports
import java.util.Scanner;
import java.util.ArrayList;

//I started by using the lecture slides/example codes. Then I discussed with friend in the use of switch + trim
//App.java has menu logic/user interface
//Grade.java has course name/grade
//Student.java has the student name/number, ability to addGrade/getGrades
//University has file handling
//Calculator has the calculations

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        //ChatGPT part
        ArrayList<Student> students = new ArrayList<>();
        University uni = new University(students);
        //ChatGPT part ends
        Calculator calculator = new Calculator();

        String menutext = "1) Add student, 2) List students, 3) Add course completion for student, "
        + "4) List course completions of student, 5) Calculate the average of course completions, "
        + "6) Calculate median of course completions, 7) Save students to file, "
        + "8) Load students from file, 0) End the program";

        while(true){
            System.out.println(menutext);
            String choice = sc.nextLine().trim();

            switch(choice){
                case "1": //Add student
                    System.out.println("What is the name of the student?");
                    String s_name = sc.nextLine();
                    System.out.println("What is the student number of the student?");                    
                    String s_number = sc.nextLine();
                    //Had to made this dumber so now you can put texts as number just because you cannot store
                    //Number like 0092 without losing the 0 as a int
                    uni.addStudent(s_name, s_number);
                    break;

                case "2": //List students
                    uni.listStudents();
                    break;

                case "3": //Add course completition for student
                uni.listStudents();
                //Variables
                int s_index = -1;
                int grade = -1;
              
                while(true){
                    System.out.println("Which student?");
                   
                    try{ //Error catching if user puts non-int in student.index
                        s_index = Integer.parseInt(sc.nextLine());
                        //I used ChatGPT to help me with the index stuff
                        if (s_index >= 0 && s_index < uni.getStudent().size()) { 
                            break;  
                        } else {
                            System.out.println("Invalid student index. Please try again.");
                        } 
                    }
                    catch(Exception e){
                        System.out.println("Wrong input value");
                    }
                }
                
                System.out.println("What is the name of the course?");
                String course = sc.nextLine();
                
                while(true){
                    System.out.println("What is the grade of the course?");
                    try{ //Error catching if user puts non-int in grade
                        grade = Integer.parseInt(sc.nextLine()); 
                        if(grade==1 || grade==2 || grade==3 || grade==4 ||grade==5){
                        break; 
                        }
                        else{
                        System.out.println("Grade can be only 1-5.");  
                        } 
                    }
                    catch(Exception e){
                        System.out.println("Wrong input value");
                    }
                }

                Student student = uni.getStudent().get(s_index);
                student.addGrade(course, grade);
                break;

                case "4": //List course completions of students
                uni.listStudents();
                int s_index2 = -1;
              
                while(true){
                    System.out.println("Which student?");
                   
                    try{ //Error catching if user puts non-int in student.index
                        s_index2 = Integer.parseInt(sc.nextLine()); 
                        break;  
                    }
                    catch(Exception e){
                        System.out.println("Wrong input value");
                    }
                }
                Student student2 = uni.getStudent().get(s_index2);
                student2.printCourses();

                break;

                case "5": //Calculate the average of course completions
                uni.listStudents();
                int s_index3 = -1;
              
                while(true){
                    System.out.println("Which student?");
                   
                    try{ //Error catching if user puts non-int in student.index
                        s_index3 = Integer.parseInt(sc.nextLine()); 
                        break;  
                    }
                    catch(Exception e){
                        System.out.println("Wrong input value");
                    }
                }
                Student student3 = uni.getStudent().get(s_index3);
                calculator.getAverageGrade(student3);
                break;

                case "6": //Calculate median of course completions
                uni.listStudents();
                int s_index4 = -1;
              
                while(true){
                    System.out.println("Which student?");
                   
                    try{ //Error catching if user puts non-int in student.index
                        s_index4 = Integer.parseInt(sc.nextLine()); 
                        break;  
                    }
                    catch(Exception e){
                        System.out.println("Wrong input value");
                    }
                }
                Student student4 = uni.getStudent().get(s_index4);
                calculator.getMedianGrade(student4);
                break;

                case "7": //Save students to file
                uni.saveFile(students, "students.ser");
                System.out.println("Students saved to file.");
                break;

                case "8": //Load students from file
                uni.loadFile("students.ser");
                uni.FromFileToList("students.ser");
                break;

                case "0": //Exit
                    System.out.println("Thank you for using the program.");
                    sc.close();
                return; 

                default: //Handle errors
                    System.out.println("Invalid option. Please try again.");
                    break;

            }

  
        }
       
    }
}
