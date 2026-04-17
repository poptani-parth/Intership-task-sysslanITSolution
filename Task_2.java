//Create a temperature converter (Celsius ↔ Fahrenheit).
// formula for converting --> F = (C × 9/5) + 32

import java.util.Scanner;
public class Task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();
        if(celsius < 0){
            System.out.println("Invalid input");
        } else{
            double fahrenheit = celsius * 1.8 + 32;
            System.out.println("Fahrenheit: " + fahrenheit);
        }
        sc.close();
    }
}
