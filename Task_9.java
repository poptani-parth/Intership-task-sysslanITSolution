import java.util.ArrayList;
import java.util.Scanner;

// Contact Class
class Contact {
    String name;
    String phone;

    // Constructor
    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Display Method
    void display() {
        System.out.println("Name: " + name + ", Phone: " + phone);
    }
}

// Main Class
public class Task_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n--- Contact Management System ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add Contact
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    contacts.add(new Contact(name, phone));
                    System.out.println("Contact added successfully!");
                    break;

                case 2:
                    // View Contacts
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        System.out.println("\nContact List:");
                        for (Contact c : contacts) {
                            c.display();
                        }
                    }
                    break;

                case 3:
                    // Search Contact
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();
                    boolean found = false;

                    for (Contact c : contacts) {
                        if (c.name.equalsIgnoreCase(searchName)) {
                            c.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    // Delete Contact
                    System.out.print("Enter name to delete: ");
                    String deleteName = sc.nextLine();
                    boolean removed = false;

                    for (int i = 0; i < contacts.size(); i++) {
                        if (contacts.get(i).name.equalsIgnoreCase(deleteName)) {
                            contacts.remove(i);
                            removed = true;
                            System.out.println("Contact deleted.");
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}