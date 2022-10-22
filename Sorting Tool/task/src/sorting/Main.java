package sorting;

import java.util.*;

public class Main {

    public static void main(final String[] args) {
        String dataType = "word";
        String sortingType = "natural";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-sortingType")) {
                sortingType = args[i + 1];
            }
            if (args[i].equals("-dataType")) {
                dataType = args[i + 1];
            }
        }
        switch (dataType) {
            case "long" -> SortLong.run(sortingType);
            case "line" -> SortLine.run(sortingType);
            default -> SortWord.run(sortingType);
        }
    }

}

