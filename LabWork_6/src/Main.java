import entity.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Manufacturer intel = new Manufacturer("Intel", "USA");
        Manufacturer amd = new Manufacturer("AMD", "USA");

        Component cpu1 = new CPU("i5", 200, intel, 6, 12, 2.5);
        Component cpu2 = new CPU("i5", 200, intel, 6, 12, 2.5); // дублікат
        Component cpu3 = new CPU("Ryzen 5", 180, amd, 6, 12, 3.2);

        Component gpu1 = new GPU("RTX 3060", 350, new Manufacturer("Nvidia", "USA"), 12, 1700);
        Component gpu2 = new GPU("RTX 3060", 350, new Manufacturer("Nvidia", "USA"), 12, 1700); // дублікат

        List<Component> list = new ArrayList<>();

        list.add(cpu1);
        list.add(cpu2);
        list.add(cpu3);
        list.add(gpu1);
        list.add(gpu2);

        System.out.println("ArrayList (з дублікатами):");
        list.forEach(Component::info);

        Set<Component> uniqueSet = new HashSet<>(list);

        System.out.println("\nHashSet (унікальні):");
        uniqueSet.forEach(Component::info);

        Collections.sort(list);

        System.out.println("\nВідсортований список (за ціною):");
        list.forEach(Component::info);

        Set<Component> sortedSet = new TreeSet<>(list);

        System.out.println("\nTreeSet (унікальні + відсортовані):");
        sortedSet.forEach(Component::info);

        Map<String, Component> map = new HashMap<>();

        for (Component c : list) {
            map.put(c.getName(), c);
        }

        System.out.println("\nMap (name → component):");
        for (String key : map.keySet()) {
            System.out.println(key + " -> ");
            map.get(key).info();
        }
    }
}
