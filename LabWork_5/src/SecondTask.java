import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SecondTask {

    public static void main(String[] args) {

        List<Baggage> list = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of("baggage.txt"));

            for (String line : lines) {
                String[] parts = line.split("\\s+");
                int items = Integer.parseInt(parts[0]);
                double weight = Double.parseDouble(parts[1]);

                list.add(new Baggage(items, weight));
            }

            Baggage best = null;

            for (Baggage b1 : list) {
                boolean isBest = true;

                for (Baggage b2 : list) {
                    if (b1 == b2) continue;

                    if (b1.items <= b2.items || b1.weight <= b2.weight) {
                        isBest = false;
                        break;
                    }
                }

                if (isBest) {
                    best = b1;
                    break;
                }
            }

            if (best != null) {
                System.out.println("Є такий пасажир:");
                System.out.println("Речей: " + best.items + ", Вага: " + best.weight);
            } else {
                System.out.println("Такого пасажира немає");
            }

        } catch (IOException e) {
            System.out.println("Помилка читання файлу");
        }
    }
}
