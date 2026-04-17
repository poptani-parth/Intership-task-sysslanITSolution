//Encrypt and decrypt text files using basic algorithms.

import java.util.Scanner;
import java.io.*;

public class Task_7 {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);
        Task_7 obj = new Task_7();
        System.out.print("Enter File name : ");
        String fileName = sc.nextLine();
        System.out.print("Enter Key(Numbers) : ");
        int key = sc.nextInt();

        try{
            BufferedReader reader = new BufferedReader(new  FileReader(fileName));
            StringBuilder content = new StringBuilder();
            String line;

            while((line = reader.readLine()) != null){
                content.append(line).append("\n");
            }
            reader.close();
            String En = obj.Encrypt(content.toString(), key);

            BufferedWriter writer = new BufferedWriter(new FileWriter("Encrypted.txt"));
            writer.write(En);
            writer.close();

            String Dec = obj.Decrypt(En, key);
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("Decrypted.txt"));
            writer1.write(Dec);
            writer1.close();

            System.out.println("File Encrypted and Decrypted Completed..! " +
                    "Checkout Encrypted.txt and Decrypted.txt files.");
        } catch (Exception e) {
            System.out.println("Error! " + e.getMessage());
        }

    }
    public String Encrypt(String str, int key) {
        String result = "";
        for (char c : str.toCharArray()) {
            result += (char)(c+key);
        }
        return result;
    }
    public String Decrypt(String str, int key) {
        String result = "";
        for (char c : str.toCharArray()) {
            result += (char)(c-key);
        }
        return result;
    }
}
