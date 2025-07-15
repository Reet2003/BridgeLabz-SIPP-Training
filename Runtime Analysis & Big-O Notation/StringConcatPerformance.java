// StringConcatPerformance.java
// Compares String, StringBuilder, and StringBuffer for concatenating a million strings
public class StringConcatPerformance {
    public static void main(String[] args) {
        int N = 1000000;
        String s = "hello";
        long start, time;
        // String
        start = System.nanoTime();
        String str = "";
        for (int i = 0; i < N; i++) str += s;
        time = System.nanoTime() - start;
        System.out.printf("String: %.2f ms\n", time/1e6);
        // StringBuilder
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder(N * s.length());
        for (int i = 0; i < N; i++) sb.append(s);
        time = System.nanoTime() - start;
        System.out.printf("StringBuilder: %.2f ms\n", time/1e6);
        // StringBuffer
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer(N * s.length());
        for (int i = 0; i < N; i++) sbf.append(s);
        time = System.nanoTime() - start;
        System.out.printf("StringBuffer: %.2f ms\n", time/1e6);
    }
} 