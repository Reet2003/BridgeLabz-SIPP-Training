// FileReadPerformance.java
// Compares FileReader and InputStreamReader for reading a large file
import java.io.*;

public class FileReadPerformance {
    public static void main(String[] args) throws Exception {
        String filePath = "largefile.txt"; // Set your large file path here
        // FileReader
        long start = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while (br.readLine() != null) {}
        }
        long fileReaderTime = System.nanoTime() - start;
        System.out.printf("FileReader: %.2f ms\n", fileReaderTime/1e6);
        // InputStreamReader
        start = System.nanoTime();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            while (br.readLine() != null) {}
        }
        long inputStreamReaderTime = System.nanoTime() - start;
        System.out.printf("InputStreamReader: %.2f ms\n", inputStreamReaderTime/1e6);
    }
} 