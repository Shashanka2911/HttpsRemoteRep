public class BinarySearch1 {
    public static void main(String[] args) {
        // Given sequence
        int[] sequence = {12, 33, 42, 51, 66, 73, 87, 99, 101};

        // Element to search
        int searchElement = 66;

        // Perform binary search
        int result = binarySearch(sequence, searchElement);

        // Display the result
        if (result != -1) {
            System.out.println("Element " + searchElement + " found at index " + result);
        } else {
            System.out.println("Element " + searchElement + " not found in the sequence.");
        }
    }

    // Binary search function
    private static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] == key) {
                return mid; // Found, return the index
            } else if (array[mid] < key) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        return -1; // Not found
    }
}