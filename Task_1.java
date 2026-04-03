// Task 1: Display a 3×3 number grid using arrays and check if a number exists

import java.util.Scanner;
import java.io.*;

public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] gridArray = {
                {10,20,30},
                {40,50,60},
                {60,70,80},
        };

        //display grid
        System.out.println("Display Grid : ");
        for(int i = 0; i < gridArray.length; i++) {
            for(int j = 0; j < gridArray[i].length; j++) {
                System.out.print(gridArray[i][j] + " ");
            }
            System.out.println();
        }

        //Take value from the user
        System.out.print("Enter number for search : ");
        int search = sc.nextInt();

        boolean found = false; // if number is found then result is true otherwise false
        for(int i = 0; i < gridArray.length; i++) {
            for(int j = 0; j < gridArray[i].length; j++) {
                if(gridArray[i][j] == search) {
                    found = true;
                }
            }
        }
        if(!found) {
            System.out.println("Invalid Search");
        }else {
            System.out.println("Found");
        }
        sc.close();
    }
}