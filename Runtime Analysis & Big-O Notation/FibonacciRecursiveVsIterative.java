// FibonacciRecursiveVsIterative.java
// Compares recursive and iterative Fibonacci computation
public class FibonacciRecursiveVsIterative {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        int[] testN = {10, 30};
        for (int n : testN) {
            long start = System.nanoTime();
            int rec = fibonacciRecursive(n);
            long recTime = System.nanoTime() - start;
            start = System.nanoTime();
            int iter = fibonacciIterative(n);
            long iterTime = System.nanoTime() - start;
            System.out.printf("N=%d | Recursive: %d (%.2f ms) | Iterative: %d (%.2f ms)\n", n, rec, recTime/1e6, iter, iterTime/1e6);
        }
    }
} 