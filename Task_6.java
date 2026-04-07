//Analyze password strength using validation rules

import java.util.Scanner;

public class Task_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Your Password: ");
        String password = input.nextLine();

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        String symbols = "!@#$%^&*";

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {hasUppercase = true;}
            else if (Character.isLowerCase(ch)) {hasLowercase = true;}
            else if (Character.isDigit(ch)) {hasNumber = true;}
            else if (symbols.contains(String.valueOf(ch))) {hasSpecial = true;}
        }

        if (hasUppercase && hasLowercase && hasNumber && hasSpecial && password.length() >= 8) {
            System.out.println("Password is very strong");
        } else if (hasUppercase && hasLowercase && hasNumber && hasSpecial) {
            System.out.println("Password is strong");
        }else if (hasUppercase && hasLowercase && hasNumber) {
            System.out.println("Password is medium");
        }else{
            System.out.println("Password is week");
        }

        System.out.println("Password Analysis : " +
                "\n\t Password Length >=8 : "+ (password.length()>=8)+
                "\n\t Use Uppercase : " + hasUppercase +
                "\n\t Use Lowercase : " + hasLowercase +
                "\n\t Use Number : " + hasNumber +
                "\n\t Use Special : " + hasSpecial
        );

    }
}
