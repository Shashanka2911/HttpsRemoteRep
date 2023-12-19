import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    String address;
    double cgpa;

    public Student(String name, int rollNumber, String address, double cgpa) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.address = address;
        this.cgpa = cgpa;
    }
}

public class SelectionSortStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Roll Number: ");
            int rollNumber = scanner.nextInt();
            System.out.print("Address: ");
            String address = scanner.next();
            System.out.print("CGPA: ");
            double cgpa = scanner.nextDouble();

            students[i] = new Student(name, rollNumber, address, cgpa);
        }

        // Perform selection sort based on CGPA
        selectionSort(students);

        // Display sorted student details
        System.out.println("\nStudents sorted by CGPA (non-decreasing order):");
        for (Student student : students) {
            System.out.println("Name: " + student.name + ", Roll Number: " + student.rollNumber
                    + ", Address: " + student.address + ", CGPA: " + student.cgpa);
        }
    }

    public static void selectionSort(Student[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                // Compare CGPA for selection sort
                if (arr[j].cgpa < arr[minIndex].cgpa) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            Student temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
