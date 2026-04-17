//Task 3: Calculate student grade averages using arrays.

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subject : ");
        int subject = sc.nextInt();
        double[] marks = new double[subject];
        double sum = 0;
        boolean hasFailure = false;
        char grade;

        //get marks from the user
        for(int i = 0; i < subject; i++){
            System.out.print("Enter marks for subject " + (i+1) + ": ");
            marks[i] = sc.nextDouble();
            sum += marks[i];
            if (marks[i] < 34) {
                hasFailure = true;
            }
        }

        // calculate average
        double average = sum / subject;

        //grade calculation
        if (hasFailure || average <= 33) {
            grade = 'F';
            System.out.println("Average marks is " + average);
            System.out.println("Result : Fail");
        }else{
            if(average >=90) {
                grade = 'A';
            } else if (average >= 75){
                grade = 'B';
            }else if (average >= 60){
                grade = 'C';
            }else{
                grade = 'D';
            }

            System.out.println("Average marks is " + average);
            System.out.println("Result : Pass");
        }

        System.out.println("Grade : " + grade);
        sc.close();

    }
}
