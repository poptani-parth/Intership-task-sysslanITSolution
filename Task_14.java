import java.io.*;
import java.util.*;

// Task Class
class Task implements Serializable {
    String description;
    boolean isCompleted;

    Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    void display(int index) {
        System.out.println(index + ". " + description + " [" + (isCompleted ? "Done" : "Pending") + "]");
    }
}

// Main Class
public class Task_14 {
    static final String FILE_NAME = "tasks.dat";

    // Save tasks to file
    static void saveTasks(ArrayList<Task> tasks) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(tasks);
            oos.close();
            System.out.println("Tasks saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving tasks.");
        }
    }

    // Load tasks from file
    static ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            tasks = (ArrayList<Task>) ois.readObject();
            ois.close();
        } catch (Exception e) {
            // File may not exist first time
        }
        return tasks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Task> tasks = loadTasks();

        int choice;

        do {
            System.out.println("\n--- Daily Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Save Tasks");
            System.out.println("5. Load Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String desc = sc.nextLine();
                    tasks.add(new Task(desc));
                    System.out.println("Task added!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            tasks.get(i).display(i + 1);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task number to mark complete: ");
                    int num = sc.nextInt();
                    if (num > 0 && num <= tasks.size()) {
                        tasks.get(num - 1).isCompleted = true;
                        System.out.println("Task marked as completed!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    saveTasks(tasks);
                    break;

                case 5:
                    tasks = loadTasks();
                    System.out.println("Tasks loaded!");
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