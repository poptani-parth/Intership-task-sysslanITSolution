//CSV-based inventory management system

import java.io.*;
import java.util.*;

// Product Class
class Product {
    int id;
    String name;
    int quantity;
    double price;

    Product(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    String toCSV() {
        return id + "," + name + "," + quantity + "," + price;
    }

    void display() {
        System.out.println(id + " | " + name + " | Qty: " + quantity + " | Price: " + price);
    }
}

// Main Class
public class Task_19 {
    static final String FILE_NAME = "inventory.csv";

    // Load from CSV
    static ArrayList<Product> loadData() {
        ArrayList<Product> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int qty = Integer.parseInt(data[2]);
                double price = Double.parseDouble(data[3]);

                list.add(new Product(id, name, qty, price));
            }

            br.close();
        } catch (Exception e) {
            // file may not exist initially
        }

        return list;
    }

    // Save to CSV
    static void saveData(ArrayList<Product> list) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            // header
            bw.write("ID,Name,Quantity,Price");
            bw.newLine();

            for (Product p : list) {
                bw.write(p.toCSV());
                bw.newLine();
            }

            bw.close();
            System.out.println("Data saved to CSV!");
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = loadData();

        int choice;

        do {
            System.out.println("\n--- Inventory Management (CSV) ---");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Quantity");
            System.out.println("5. Save to CSV");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    products.add(new Product(id, name, qty, price));
                    System.out.println("Product added!");
                    break;

                case 2:
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        for (Product p : products) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Product p : products) {
                        if (p.id == searchId) {
                            p.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    boolean updated = false;

                    for (Product p : products) {
                        if (p.id == updateId) {
                            System.out.print("Enter new quantity: ");
                            p.quantity = sc.nextInt();
                            updated = true;
                            System.out.println("Quantity updated!");
                        }
                    }

                    if (!updated) {
                        System.out.println("Product not found.");
                    }
                    break;

                case 5:
                    saveData(products);
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