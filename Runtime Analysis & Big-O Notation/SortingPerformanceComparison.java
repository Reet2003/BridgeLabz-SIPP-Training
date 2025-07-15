// SortingPerformanceComparison.java
// Compares Bubble Sort, Merge Sort, and Quick Sort performance on large datasets
import java.util.*;

public class SortingPerformanceComparison {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int j = 0; j < n2; j++) R[j] = arr[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
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
    public static void main(String[] args) {
        int[] sizes = {1000, 10000}; // Bubble sort is too slow for 1,000,000
        Random rand = new Random();
        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n);
            int[] arr1 = arr.clone(), arr2 = arr.clone(), arr3 = arr.clone();
            long start = System.nanoTime();
            bubbleSort(arr1);
            long bubbleTime = System.nanoTime() - start;
            start = System.nanoTime();
            mergeSort(arr2, 0, arr2.length - 1);
            long mergeTime = System.nanoTime() - start;
            start = System.nanoTime();
            quickSort(arr3, 0, arr3.length - 1);
            long quickTime = System.nanoTime() - start;
            System.out.printf("N=%d | Bubble: %.2f ms | Merge: %.2f ms | Quick: %.2f ms\n", n, bubbleTime/1e6, mergeTime/1e6, quickTime/1e6);
        }
    }
} 