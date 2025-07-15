// InsertionSortEmployeeIDs.java
// Implements Insertion Sort for employee IDs
public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static void main(String[] args) {
        int[] ids = {105, 102, 110, 101, 108};
        insertionSort(ids);
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
} 