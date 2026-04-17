import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task_12 {

    static final String FILE_NAME = "log.txt";

    // Method to write log with timestamp
    static void writeLog(String message) {
        try {
            FileWriter fw = new FileWriter(FILE_NAME, true); // append mode
            BufferedWriter bw = new BufferedWriter(fw);

            // Current date and time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            String timeStamp = now.format(format);

            bw.write("[" + timeStamp + "] " + message);
            bw.newLine();

            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing log.");
        }
    }

    // Method to read log file
    static void readLogs() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            System.out.println("\n--- Log File Content ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } catch (IOException e) {
            System.out.println("No logs found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Log File Generator ---");
            System.out.println("1. Write Log");
            System.out.println("2. View Logs");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter log message: ");
                    String msg = sc.nextLine();
                    writeLog(msg);
                    System.out.println("Log saved!");
                    break;

                case 2:
                    readLogs();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}