package sorting;

import java.util.*;

public class SortLong {
    private static final Scanner scanner = new Scanner(System.in);
    static List<Long> numbers;

    public static void run(String mode) {
        numbers = new ArrayList<>();
        while (scanner.hasNextLong()) {
            long number = scanner.nextLong();
            numbers.add(number);
        }
        if (mode.equals("natural")) sortLongNaturally();
        else sortLongByCount();
    }

    public static void sortLongNaturally() {
        Collections.sort(numbers);
        System.out.printf("Total numbers: %d.\n", numbers.size());
        System.out.print("Sorted data: ");
        for (long number : numbers) {
            System.out.print(number + " ");
        }

    }

    public static void sortLongByCount() {
        System.out.printf("Total numbers: %d.\n", numbers.size());
        Collections.sort(numbers);
//        System.out.println(numbers);
        numbers.sort((n1, n2) -> {
            if (Collections.frequency(numbers, n1) > Collections.frequency(numbers, n2)) {
                return 1;
            }
            if (Collections.frequency(numbers, n2) > Collections.frequency(numbers, n1)) {
                return -1;
            }
            return 0;
        });
//        System.out.println(numbers);
        Set<Long> set = new LinkedHashSet<>(numbers);

//        System.out.println(numbers);
        long times;
        double percentage;
        for (long number : set) {
            times = Collections.frequency(numbers, number);
            percentage = (double) (times) / numbers.size() * 100;
            System.out.printf("%s: %d time(s), %d", number, times, Math.round(percentage));
            System.out.print("%\n");
        }

    }


}
