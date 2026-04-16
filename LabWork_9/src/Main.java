import java.io.*;
import java.util.*;

public class Main {

    private static final String FILE_NAME = "output.txt";

    public static void main(String[] args) throws Exception {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            int threadId = i;

            Thread t = new Thread(() -> writeWords(threadId));
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Запис завершено!");

        analyzeFile();
    }

    private static synchronized void writeWords(int id) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {

            for (int i = 0; i < 5; i++) {
                fw.write("Thread-" + id + "_word" + i + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void analyzeFile() {
        try {
            String content = new String(java.nio.file.Files.readAllBytes(
                    java.nio.file.Path.of(FILE_NAME)));

            String[] words = content.trim().split("\\s+");

            System.out.println("Загальна кількість слів: " + words.length);

            Map<String, Integer> freq = new HashMap<>();

            for (String word : words) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }

            System.out.println("\nЧастота слів:");
            for (String key : freq.keySet()) {
                System.out.println(key + " -> " + freq.get(key));
            }

        } catch (IOException e) {
            System.out.println("Помилка читання файлу");
        }
    }
}