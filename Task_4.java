//Task 4: Generate a secure random password based on user preferences.

import java.util.Random;
import java.util.Scanner;
public class Task_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // Character sets
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*";

        String allChars = "";

        // User preferences
        System.out.print("Enter password length: ");
        int length = sc.nextInt();

        System.out.print("Include uppercase letters? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            allChars += upper;
        }

        System.out.print("Include lowercase letters? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            allChars += lower;
        }

        System.out.print("Include numbers? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            allChars += numbers;
        }

        System.out.print("Include symbols? (yes/no): ");
        if (sc.next().equalsIgnoreCase("yes")) {
            allChars += symbols;
        }


        // Check if no option selected
        if (allChars.isEmpty()) {
            System.out.println("Error: Select at least one character type!");
            return;
        }
        // Generate password
        String password = "";

        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(allChars.length());
            password += allChars.charAt(index);
        }
        // Output
        System.out.println("\nGenerated Password: " + password);

        sc.close();

    }
}
