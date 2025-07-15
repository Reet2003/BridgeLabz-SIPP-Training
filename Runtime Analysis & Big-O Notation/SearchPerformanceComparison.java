// SearchPerformanceComparison.java
// Compares Linear Search and Binary Search performance on large datasets
import java.util.*;

public class SearchPerformanceComparison {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i;
            int target = n - 1;
            long start = System.nanoTime();
            linearSearch(arr, target);
            long linearTime = System.nanoTime() - start;
            Arrays.sort(arr);
            start = System.nanoTime();
            binarySearch(arr, target);
            long binaryTime = System.nanoTime() - start;
            System.out.printf("N=%d | Linear: %.4f ms | Binary: %.4f ms\n", n, linearTime/1e6, binaryTime/1e6);
        }
    }
} 