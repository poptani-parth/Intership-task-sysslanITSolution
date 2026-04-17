import java.io.*;
import java.util.*;

// Expense Class
class Expense {
    String category;
    double amount;

    Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    String toFileString() {
        return category + "," + amount;
    }

    void display() {
        System.out.println(category + " -> " + amount);
    }
}

// Main Class
public class Task_20 {

    static final String FILE_NAME = "expenses.txt";

    // Load expenses from file
    static ArrayList<Expense> loadData() {
        ArrayList<Expense> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                list.add(new Expense(data[0], Double.parseDouble(data[1])));
            }

            br.close();
        } catch (Exception e) {
            // file may not exist initially
        }

        return list;
    }

    // Save expenses to file
    static void saveData(ArrayList<Expense> list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Expense e : list) {
                bw.write(e.toFileString());
                bw.newLine();
            }

            bw.close();
            System.out.println("Data saved!");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Total calculation
    static void totalExpense(ArrayList<Expense> list) {
        double total = 0;
        for (Expense e : list) {
            total += e.amount;
        }
        System.out.println("Total Expense: " + total);
    }

    // Category-wise summary
    static void categorySummary(ArrayList<Expense> list) {
        HashMap<String, Double> map = new HashMap<>();

        for (Expense e : list) {
            map.put(e.category, map.getOrDefault(e.category, 0.0) + e.amount);
        }

        System.out.println("\n--- Category Summary ---");
        for (String key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = loadData();

        int choice;

        do {
            System.out.println("\n--- Personal Expense Manager ---");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Expense");
            System.out.println("4. Category Summary");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Category: ");
                    String cat = sc.nextLine();
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();

                    expenses.add(new Expense(cat, amt));
                    System.out.println("Expense added!");
                    break;

                case 2:
                    for (Expense e : expenses) {
                        e.display();
                    }
                    break;

                case 3:
                    totalExpense(expenses);
                    break;

                case 4:
                    categorySummary(expenses);
                    break;

                case 5:
                    saveData(expenses);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}