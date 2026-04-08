// Task -8 : Build a personal expense tracker with file storage

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Task_8 {
    static final String fileName = "expenses.txt";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do{
            System.out.println("\n !-- Personal Expenses Tracker -- !");
            System.out.println("1. Add Expense");
            System.out.println("2. view Expense");
            System.out.println("3. Total Expense");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input! Enter a number.");
                sc.next(); // clear wrong input
                continue;
            }
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Expense amount : ");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Expense Category : ");
                    String category = sc.nextLine();
                    addExpense(amount, category);
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    totalExpenses();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }while(choice != 4);
        sc.close();
    }
    public static void addExpense(double amount, String category){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            LocalDate now = LocalDate.now();
            writer.write(now + "," + amount + "," + category);
            System.out.print("Expenses add successfully ✔");
            writer.newLine();
        }catch (Exception e){
            System.out.print("Error to add expenses : " + e.getMessage());
        }
    }
    public static void viewExpenses(){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            System.out.print("!-- Expenses list --!\n");
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                System.out.print("\nDate : "+ data[0]+
                        " || Amount : " + data[1] + " ||  Category : " + data[2]
                );
            }
        }catch (IOException e){
            System.out.print("Expenses not found!");
        }
    }
    public static void totalExpenses(){
        double totalExpense = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.split(",");
                totalExpense += Double.parseDouble(data[1]);
            }
            System.out.println("Total Expense : " + totalExpense);
        }catch (IOException e){
            System.out.print("Error to reading file.");
        }
    }

}
