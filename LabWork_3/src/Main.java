public static void main(String[] args) {

    if (args.length == 0) {
        System.out.println("Передайте рядок як аргумент командного рядка.");
        return;
    }

    String input = String.join(" ", args);

    System.out.println("Введений рядок: " + input);

    String[] words = input.trim().split("\\s+");

    int wordCount = words.length;
    System.out.println("Кількість слів: " + wordCount);

    int totalCharsWithoutSpaces = 0;

    System.out.println("\nСлова і кількість символів у них:");
    for (String word : words) {
        int length = word.length();
        totalCharsWithoutSpaces += length;
        System.out.println(word + " -> " + length);
    }

    int totalCharsWithSpaces = input.length();

    System.out.println("\nЗагальна кількість символів:");
    System.out.println("Без пробілів: " + totalCharsWithoutSpaces);
    System.out.println("З пробілами: " + totalCharsWithSpaces);
}
