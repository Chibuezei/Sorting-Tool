package sorting;

import java.util.*;

public class SortWord {
    private static final Scanner scanner = new Scanner(System.in);
    static List<String> words;

    public static void run(String mode) {
        words = new ArrayList<>();
        while (scanner.hasNext()) {
            String word = scanner.next();
            words.add(word);
        }
        if (mode.equals("natural")) sortWordNaturally();
        else sortWordByCount();
    }

    private static void sortWordNaturally() {
        words.sort(Comparator.comparing(String::length));
        System.out.printf("Total words: %d.\n", words.size());
        System.out.print("Sorted data: ");
        for (String word : words) {
            System.out.print(word + " ");
        }
    }

    private static void sortWordByCount() {
        Collections.sort(words);
        words.sort((s1, s2) -> {
            if (Collections.frequency(words, s1) > Collections.frequency(words, s2)) {
                return 1;
            }
            if (Collections.frequency(words, s2) > Collections.frequency(words, s1)) {
                return -1;
            }
            return 0;
        });
        Set<String> lines = new LinkedHashSet<>(words);
        long times;
        double percentage;
        System.out.printf("Total words: %d.\n", words.size());
        for (String word : lines) {
            times = Collections.frequency(words, word);
            percentage = (double) (times) / words.size() * 100;
            System.out.printf("%s: %d time(s), %d.", word, times, Math.round(percentage));
            System.out.print("%\n");

        }


    }

}
