// CSV data processor for summaries and analytics

import java.io.*;
import java.util.*;

public class Task_16 {

    public static void main(String[] args) {
        String fileName = "data.csv";

        int count = 0;
        double total = 0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            // Skip header
            br.readLine();

            System.out.println("\n--- CSV Records ---");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String name = data[0];
                double marks = Double.parseDouble(data[1]);

                System.out.println("Name: " + name + ", Marks: " + marks);

                total += marks;
                count++;

                if (marks > max) {
                    max = marks;
                    topStudent = name;
                }

                if (marks < min) {
                    min = marks;
                    lowStudent = name;
                }
            }

            br.close();

            // Analytics
            double average = total / count;

            System.out.println("\n--- Summary ---");
            System.out.println("Total Students: " + count);
            System.out.println("Average Marks: " + average);
            System.out.println("Highest Marks: " + max + " (" + topStudent + ")");
            System.out.println("Lowest Marks: " + min + " (" + lowStudent + ")");

        } catch (Exception e) {
            System.out.println("Error reading CSV file.");
        }
    }
}