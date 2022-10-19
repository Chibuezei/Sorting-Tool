package sorting;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(final String[] args) {
        String dataType = "word";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-sortIntegers")) {
                sortIntegers();
                return;
            }
            if (args[i].equals("-dataType")) {
                dataType = args[i + 1];
            }
        }
        switch (dataType) {
            case "long" -> sortLong();
            case "line" -> sortLine();
            default -> sortWord();
        }
    }

    private static void sortWord() {
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.next();
            words.add(line);
        }

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() > s2.length()) {
                    return 1;
                }
                if (s2.length() > s1.length()) {
                    return -1;
                }
                return 0;
            }
        });
        String longest = words.get(words.size() - 1);
        long times = Collections.frequency(words, longest);
        double percentage = (double) (times) / words.size() * 100;
        System.out.printf("Total words: %d.\n", words.size());
        System.out.printf("The longest word: %s (%d time(s), %d).", longest, times, Math.round(percentage));
    }

    private static void sortLine() {
        List<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lines.add(line);
        }

        Collections.sort(lines, (s1, s2) -> {
            if (s1.length() > s2.length()) {
                return 1;
            }
            if (s2.length() > s1.length()) {
                return -1;
            }
            return 0;
        });
        String longest = lines.get(lines.size() - 1);
        long times = Collections.frequency(lines, longest);
        double percentage = (double) times / lines.size() * 100;
        System.out.printf("Total lines: %d.\n", lines.size());
        System.out.printf("The longest line:\n%s\n(%d time(s), %d).", longest, times, Math.round(percentage));
    }

    public static void sortIntegers() {
        List<Long> numbers = new ArrayList<>();
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            numbers.add(number);
        }
        Collections.sort(numbers);
        System.out.printf("Total numbers: %d.\n", numbers.size());
        System.out.print("Sorted data: ");
        for (long number : numbers) {
            System.out.print(number + " ");
        }

    }

    public static void sortLong() {
        List<Long> numbers = new ArrayList<>();
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            numbers.add(number);
        }

        long greatest = Collections.max(numbers);
        long times = Collections.frequency(numbers, greatest);
        double percentage = (double) (times) / numbers.size() * 100;
        System.out.printf("Total numbers: %d.\n", numbers.size());
        System.out.printf("The greatest number: %s (%d time(s), %d).", greatest, times, Math.round(percentage));

    }
}

