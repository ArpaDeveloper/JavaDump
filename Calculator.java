package main;

//Imports
import java.util.ArrayList;
import java.util.Collections;

public class Calculator {

    //Method to get the average grade (You could use doable for more accurate rounding)
    public float getAverageGrade(Student s){
        //Variables
        ArrayList<Grade> studies = s.getGrades();
        int sum = 0;

        if (studies.isEmpty()) {
            return 0;
        } 
        else {
            for (Grade grade : studies) {
                sum += grade.getGrade();
            }
        }
        float average = (float) sum / studies.size(); 
        System.out.println("Average is "+average);
        return average;
    }
    
    //Method to get the median grade
    public float getMedianGrade(Student s){
        ArrayList<Grade> studies = s.getGrades();

        if (studies.isEmpty()) {
            return 0;
        } 
        //Lets make copy to not change the order
        ArrayList<Grade> sortedstudies = new ArrayList<>(studies);

        //The collections was ChatGPT idea that I implemented by the help of ChatGPT
        Collections.sort(sortedstudies, (g1, g2) -> Integer.compare(g1.getGrade(), g2.getGrade()));
        int size = sortedstudies.size();

        float median;
        if (size % 2 == 1) { //Odd number
            median = sortedstudies.get(size / 2).getGrade();
            System.out.println("Median is "+median);
            return median;
        } else { //Even number
            int middle1 = size / 2 - 1;
            int middle2 = size / 2;
            median = (float) ((sortedstudies.get(middle1).getGrade() + sortedstudies.get(middle2).getGrade()) / 2.0);
            System.out.println("Median is "+median);
            return median;
        }
    }

}
