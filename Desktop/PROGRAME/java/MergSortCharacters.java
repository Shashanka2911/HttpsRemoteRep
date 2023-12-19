import java.util.Scanner;

public class MergSortCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of characters: ");
        int n = scanner.nextInt();

        char[] characters = new char[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter character " + (i + 1) + ": ");
            characters[i] = scanner.next().charAt(0);
        }
        mergeSort(characters, 0, n - 1);
        System.out.println("\nCharacters in alphabetical order:");
        for (char character : characters) {
            System.out.print(character + " ");
        }
    }

    public static void mergeSort(char[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(char[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        char[] leftArray = new char[n1];
        char[] rightArray = new char[n2];
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[middle + 1 + j];
        }
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

