import java.util.Scanner;

// Student Class
class Student1 {
    int rollNo;
    String name;
    double marks1, marks2, marks3;
    double total, percentage;
    char grade;

    // Input method
    void input() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll No: ");
        rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Marks (3 subjects): ");
        marks1 = sc.nextDouble();
        marks2 = sc.nextDouble();
        marks3 = sc.nextDouble();

        calculate();
    }

    // Calculate total, percentage, grade
    void calculate() {
        total = marks1 + marks2 + marks3;
        percentage = total / 3;

        if (percentage >= 80)
            grade = 'A';
        else if (percentage >= 60)
            grade = 'B';
        else if (percentage >= 40)
            grade = 'C';
        else
            grade = 'F';
    }

    // Display formatted report
    void display() {
        System.out.println("\n========== STUDENT REPORT ==========");
        System.out.printf("%-15s: %d\n", "Roll No", rollNo);
        System.out.printf("%-15s: %s\n", "Name", name);
        System.out.println("------------------------------------");
        System.out.printf("%-15s: %.2f\n", "Marks 1", marks1);
        System.out.printf("%-15s: %.2f\n", "Marks 2", marks2);
        System.out.printf("%-15s: %.2f\n", "Marks 3", marks3);
        System.out.println("------------------------------------");
        System.out.printf("%-15s: %.2f\n", "Total", total);
        System.out.printf("%-15s: %.2f%%\n", "Percentage", percentage);
        System.out.printf("%-15s: %c\n", "Grade", grade);
        System.out.println("====================================");
    }
}

// Main Class
public class Task_15 {
    public static void main(String[] args) {
        Student1 s = new Student1();

        s.input();
        s.display();
    }
}