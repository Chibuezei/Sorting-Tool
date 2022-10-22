package sorting;

import java.util.*;

public class SortLine {
    private static final Scanner scanner = new Scanner(System.in);
    static List<String> lines;

    public static void run(String mode) {
        lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);

        }
        if (mode.equals("natural")) sortLineNaturally();
        else sortLineByCount();
    }

    private static void sortLineNaturally() {
        lines.sort(Comparator.comparing(String::length));
        System.out.printf("Total words: %d.\n", lines.size());
        System.out.println("Sorted data: ");
        for (String word : lines) {
            System.out.println(word + " ");
        }
    }

    private static void sortLineByCount() {
        Collections.sort(lines);
        lines.sort(Comparator.comparingInt(s -> Collections.frequency(lines, s)));
        Set<String> sortedLines = new LinkedHashSet<>(lines);
        long times;
        double percentage;
        System.out.printf("Total lines: %d.\n", SortLine.lines.size());
        for (String line : sortedLines) {
            times = Collections.frequency(lines, line);
            percentage = (double) (times) / lines.size() * 100;
            System.out.printf("%s: %d time(s), %d.", line, times, Math.round(percentage));
            System.out.print("%\n");
        }

    }

}
