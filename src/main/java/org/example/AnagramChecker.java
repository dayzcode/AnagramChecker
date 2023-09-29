package org.example;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class AnagramChecker {
    // Define constants for data file, cache, and logger
    private static final String DATA_FILE = "anagram_data.txt";
    private static final Set<String> cache = new HashSet<>();
    private static final Logger logger = Logger.getLogger("AnagramChecker");

    public static void main(String[] args) {
        // Create a scanner to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their username
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        // Prompt the user for the first text value
        System.out.print("Enter the first text value: ");
        String text1 = scanner.nextLine();

        // Prompt the user for the second text value
        System.out.print("Enter the second text value: ");
        String text2 = scanner.nextLine();

        // Initialize logging for recording events
        initLogging();

        // Validate input values for spaces or numbers
        if (!isValidInput(text1) || !isValidInput(text2)) {
            // Log a warning and print an error message
            logger.log(Level.WARNING, "Input values contain spaces or numbers. Request rejected.");
            System.out.println("Input values must not contain spaces or numbers.");
            return;
        }

        // Check if the request is already in the cache
        String request = username + "|" + text1 + "|" + text2;
        if (cache.contains(request)) {
            // Log a message and print a message indicating the result is in cache
            logger.log(Level.INFO, "Result already in cache.");
            System.out.println("Result already in cache.");
        } else {
            // Check if the two text values are anagrams
            boolean areAnagrams = areAnagrams(text1, text2);

            // Display the results
            if (areAnagrams) {
                // Log and print a message indicating the two text values are anagrams
                logger.log(Level.INFO, "The two text values are anagrams.");
                System.out.println("The two text values are anagrams.");
            } else {
                // Log and print a message indicating the two text values are not anagrams
                logger.log(Level.INFO, "The two text values are not anagrams.");
                System.out.println("The two text values are not anagrams.");
            }

            // Update the cache with the new request
            cache.add(request);

            // Write the request and result to an external file
            writeToFile(username, text1, text2, areAnagrams);
        }

        // Close the scanner to release resources
        scanner.close();
    }

    // Method to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and convert to lowercase for case-insensitive comparison
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        // Check if the lengths of the two strings are equal
        if (str1.length() != str2.length()) {
            return false;
        }

        // Convert the strings to character arrays
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        // Sort the character arrays
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Compare the sorted arrays to check for anagrams
        return Arrays.equals(charArray1, charArray2);
    }

    // Method to validate input values for spaces or numbers
    public static boolean isValidInput(String input) {
        // Reject input values containing spaces or numbers
        return !input.contains(" ") && !input.matches(".*\\d+.*");
    }

    // Method to write request and result to an external file
    public static void writeToFile(String username, String text1, String text2, boolean areAnagrams) {
        try (FileWriter writer = new FileWriter(DATA_FILE, true);
             BufferedWriter bufferWriter = new BufferedWriter(writer)) {
            // Write the request and result to the data file
            bufferWriter.write(username + "|" + text1 + "|" + text2 + "|" + areAnagrams);
            bufferWriter.newLine();
        } catch (IOException e) {
            // Log an error message and print an error message if writing fails
            logger.log(Level.SEVERE, "Error writing to the data file: " + e.getMessage());
            System.out.println("Error writing to the data file: " + e.getMessage());
        }
    }

    // Method to initialize logging for recording events
    private static void initLogging() {
        // Create a console handler for logging
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.INFO);

        try {
            // Create a file handler for logging, append to existing log
            FileHandler fileHandler = new FileHandler("anagram_log.txt", true);
            fileHandler.setLevel(Level.INFO);

            // Add the handlers to the logger
            logger.addHandler(consoleHandler);
            logger.addHandler(fileHandler);

            // Set the logging level for the logger
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            // Print an error message if initializing logging fails
            System.out.println("Error initializing logging: " + e.getMessage());
        }
    }
}
