// DataStructureSearchComparison.java
// Compares Array, HashSet, and TreeSet for searching elements
import java.util.*;

public class DataStructureSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000};
        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = i;
            int target = n - 1;
            // Array search
            long start = System.nanoTime();
            for (int i = 0; i < n; i++) {
                if (arr[i] == target) break;
            }
            long arrayTime = System.nanoTime() - start;
            // HashSet search
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) set.add(i);
            start = System.nanoTime();
            set.contains(target);
            long hashSetTime = System.nanoTime() - start;
            // TreeSet search
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) treeSet.add(i);
            start = System.nanoTime();
            treeSet.contains(target);
            long treeSetTime = System.nanoTime() - start;
            System.out.printf("N=%d | Array: %.2f ms | HashSet: %.2f ms | TreeSet: %.2f ms\n", n, arrayTime/1e6, hashSetTime/1e6, treeSetTime/1e6);
        }
    }
} 