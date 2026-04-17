// Student record system with file-based persistence

import java.io.*;
import java.util.*;

// Student Class
class Student implements Serializable {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

// Main Class
public class Task_10 {
    static final String FILE_NAME = "students.dat";

    // Write data to file
    static void saveToFile(ArrayList<Student> list) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(list);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    // Read data from file
    static ArrayList<Student> loadFromFile() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            list = (ArrayList<Student>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            // file may not exist first time
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = loadFromFile();

        int choice;

        do {
            System.out.println("\n--- Student Record System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Add Student
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    students.add(new Student(id, name, marks));
                    saveToFile(students);
                    System.out.println("Student added and saved!");
                    break;

                case 2:
                    // View Students
                    if (students.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        for (Student s : students) {
                            s.display();
                        }
                    }
                    break;

                case 3:
                    // Search Student
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    boolean found = false;

                    for (Student s : students) {
                        if (s.id == searchId) {
                            s.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Delete Student
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean removed = false;

                    Iterator<Student> it = students.iterator();
                    while (it.hasNext()) {
                        Student s = it.next();
                        if (s.id == deleteId) {
                            it.remove();
                            removed = true;
                            break;
                        }
                    }

                    if (removed) {
                        saveToFile(students);
                        System.out.println("Student deleted.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}