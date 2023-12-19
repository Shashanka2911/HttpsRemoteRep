import java.util.Scanner;

public class PersonSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of persons
        System.out.print("Enter the number of persons: ");
        int numPersons = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Arrays to store person details
        String[] names = new String[numPersons];
        int[] ages = new int[numPersons];
        String[] cities = new String[numPersons];

        // Input details for each person
        for (int i = 0; i < numPersons; i++) {
            System.out.println("\nEnter details for Person " + (i + 1) + ":");
            System.out.print("Name: ");
            names[i] = scanner.nextLine();
            System.out.print("Age: ");
            ages[i] = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("City: ");
            cities[i] = scanner.nextLine();
        }

        // Input name to search
        System.out.print("\nEnter the name to search: ");
        String searchName = scanner.nextLine();

        // Perform linear search
        int foundIndex = linearSearch(names, searchName);

        // Display the result
        if (foundIndex != -1) {
            System.out.println("\nPerson found at index " + foundIndex + ":");
            System.out.println("Name: " + names[foundIndex]);
            System.out.println("Age: " + ages[foundIndex]);
            System.out.println("City: " + cities[foundIndex]);
        } else {
            System.out.println("\nPerson with name '" + searchName + "' not found.");
        }

        scanner.close();
    }

    // Linear search function
    private static int linearSearch(String[] array, String key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(key)) {
                return i; // Found, return the index
            }
        }
        return -1; // Not found
    }
}