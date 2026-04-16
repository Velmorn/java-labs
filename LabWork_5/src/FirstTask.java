import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FirstTask {

    public static void main(String[] args) {
        try {
            String text = Files.readString(Path.of("text.txt"));

            String[] sentences = text.split("(?<=[.!?])");

            List<String> questions = new ArrayList<>();
            List<String> exclamations = new ArrayList<>();

            for (String sentence : sentences) {
                sentence = sentence.trim();

                if (sentence.endsWith("?")) {
                    questions.add(sentence);
                } else if (sentence.endsWith("!")) {
                    exclamations.add(sentence);
                }
            }

            System.out.println("Питальні речення:");
            questions.forEach(System.out::println);

            System.out.println("\nОкличні речення:");
            exclamations.forEach(System.out::println);

        } catch (IOException e) {
            System.out.println("Помилка читання файлу");
        }
    }
}
