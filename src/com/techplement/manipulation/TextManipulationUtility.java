package com.techplement.manipulation;

import java.util.Scanner;

public class TextManipulationUtility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        
        System.out.println("Select operation:");
        System.out.println("1. Concatenate at the start");
        System.out.println("2. Concatenate at the end");
        System.out.println("3. Extract substring");
        System.out.println("4. Replace characters");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                System.out.print("Enter the string to concatenate at the start: ");
                String strToConcatStart = scanner.nextLine();
                System.out.println("Concatenated text: " + concatenateAtStart(text, strToConcatStart));
                break;
            case 2:
                System.out.print("Enter the string to concatenate at the end: ");
                String strToConcatEnd = scanner.nextLine();
                System.out.println("Concatenated text: " + concatenateAtEnd(text, strToConcatEnd));
                break;
            case 3:
                System.out.print("Enter the substring start index: ");
                int startIndex = scanner.nextInt();
                System.out.print("Enter the substring end index: ");
                int endIndex = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Extracted substring: " + extractSubstring(text, startIndex, endIndex));
                break;
            case 4:
                System.out.print("Enter the character to replace: ");
                char oldChar = scanner.nextLine().charAt(0);
                System.out.print("Enter the replacement character: ");
                char newChar = scanner.nextLine().charAt(0);
                System.out.println("Text with replaced characters: " + replaceCharacters(text, oldChar, newChar));
                break;
            default:
                System.out.println("Invalid choice.");
        }
        
        scanner.close();
    }
    
    // Method to concatenate a string at the start
    public static String concatenateAtStart(String str, String strToConcat) {
        return strToConcat + str;
    }
    
    // Method to concatenate a string at the end
    public static String concatenateAtEnd(String str, String strToConcat) {
        return str + strToConcat;
    }
    
    // Method to extract a substring from a given string
    public static String extractSubstring(String str, int startIndex, int endIndex) {
        return str.substring(startIndex, endIndex);
    }
    
    // Method to replace all occurrences of a character with another character in a string
    public static String replaceCharacters(String str, char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }
}
