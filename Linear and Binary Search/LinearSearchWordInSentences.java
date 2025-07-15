// LinearSearchWordInSentences.java
// Finds the first sentence containing a specific word using linear search
public class LinearSearchWordInSentences {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) return sentence;
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] sentences = {"The sky is blue.", "Java is fun.", "I love programming."};
        String word = "Java";
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Sentence: " + result);
    }
} 