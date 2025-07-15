// HeapSortJobApplicants.java
// Implements Heap Sort for job applicants' salary demands
public class HeapSortJobApplicants {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }
    public static void main(String[] args) {
        int[] salaries = {35000, 42000, 30000, 50000, 38000};
        heapSort(salaries);
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
        System.out.println();
    }
} 