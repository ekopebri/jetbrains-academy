package numbers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Amazing Numbers!");

        System.out.print("\nSupported requests:\n" + "- enter a natural number to know its properties;\n"
                + "- enter two natural numbers to obtain the properties of the list:\n"
                + "  * the first parameter represents a starting number;\n"
                + "  * the second parameter shows how many consecutive numbers are to be printed;\n"
                + "- two natural numbers and properties to search for;\n"
                + "- a property preceded by minus must not be present in numbers;\n"
                + "- separate the parameters with one space;\n" + "- enter 0 to exit.\n");

        menu();
    }

    private static void menu() {
        try {
            System.out.print("\nEnter a request: ");
            List<String> input = readStringAsArrays();
            if (isNumeric(input.get(0)) && Long.parseLong(input.get(0)) < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                menu();
            } else if (isNumeric(input.get(0)) && Long.parseLong(input.get(0)) > 0) {
                if (input.size() == 2 && isNumeric(input.get(1))) {
                    if (Long.parseLong(input.get(1)) < 0) {
                        System.out.printf("The second parameter should be a natural number.");
                    } else {
                        printListProperties(Long.parseLong(input.get(0)), Long.parseLong(input.get(1)));
                    }
                } else if (input.size() > 2 && isNumeric(input.get(1))) {
                    search(input);
                } else {
                    oneNumberPrint(Long.parseLong(input.get(0)));
                }
                menu();
            } else if (Long.parseLong(input.get(0)) == 0) {
                return;
            }
        } catch (InputMismatchException exception) {
            System.out.println("\nThe first parameter should be a natural number or zero.");
            menu();
        }
    }

    private static void search(List<String> input) {
        List<String> filters = new ArrayList<>();
        for (int i = 2; i < input.size(); i++) {
            if (!filters.contains(input.get(i)))
                filters.add(input.get(i));
        }

        if (NumberProperty.isWrong(filters)) {
            System.out.println("The request contains mutually exclusive properties: " + filters);
            System.out.println("There are no numbers with these properties.");
            return;
        }

        int countWrongFilter = checkWrongFilter(filters);

        if (countWrongFilter > 0) {
            if (countWrongFilter == 1) {
                System.out.println("The property " + filters + " is wrong.");
            } else {
                System.out.println("The properties " + filters + " are wrong.");
            }
            NumberProperty.printAvailableProperties();
            return;
        }

        Long start = Long.parseLong(String.valueOf(input.get(0)));
        Long max = Long.parseLong(String.valueOf(input.get(1)));

        while (max > 0) {
            NumberObject numberObject = new NumberObject();
            numberObject.setValue(start);
            numberObject.setProperties();
            if (containsAllWords(numberObject.toString(), filters)) {
                System.out.println(numberObject);
                max--;
            }
            start++;
        }
    }

    private static ArrayList<String> readStringAsArrays() {
        return Arrays
                .stream(Main.scanner.nextLine().split("\\s+"))
                .map(String::new)
                .collect(Collectors.toCollection(ArrayList::new));

    }

    private static void oneNumberPrint(long number) {
        NumberObject object = new NumberObject();
        object.setValue(number);
        object.setProperties();
        object.printProperties();
    }

    private static void printListProperties(long number, long count) {
        for (int i = 0; i < count; i++) {
            NumberObject object = new NumberObject();
            object.setValue(number++);
            object.setProperties();
            System.out.println(object);
        }
    }

    private static boolean isNumeric(String inp) {
        try {
            Long.parseLong(inp);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean containsAllWords(String word, List<String> keywords) {
        for (String k : keywords) {
            if (k.contains("-")) {
                if (word.contains(k.replace("-", "").toLowerCase())) {
                    return false;
                }
            } else {
                if (!word.contains(k.toLowerCase())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int checkWrongFilter(List<String> filters) {
        int count = 0;

        for (String filter : filters) {
            if (NumberProperty.contains(filter.replace("-", "")) == null) {
                count++;
            }
        }

        return count;
    }
}
