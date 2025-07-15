// BinarySearchFirstLastOccurrence.java
// Finds the first and last occurrence of a target element in a sorted array using binary search
public class BinarySearchFirstLastOccurrence {
    public static int[] findFirstLast(int[] arr, int target) {
        int first = -1, last = -1;
        int left = 0, right = arr.length - 1;
        // Find first occurrence
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        left = 0; right = arr.length - 1;
        // Find last occurrence
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        int[] arr = {2, 4, 4, 4, 8, 10};
        int target = 4;
        int[] result = findFirstLast(arr, target);
        System.out.println("First: " + result[0] + ", Last: " + result[1]);
    }
} 