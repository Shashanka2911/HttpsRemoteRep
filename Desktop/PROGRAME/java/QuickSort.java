public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3, 6, 8, 10, 1, 2, 1};
        
        System.out.println("Original array:");
        printArray(array);

        quicksort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        printArray(array);
    }

    public static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quicksort(arr, low, partitionIndex - 1);
            quicksort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
