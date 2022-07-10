import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        ArrayList<Integer> listA = readArrayList(scanner);
        Integer element = scanner.nextInt();

        ArrayList<Integer> listB = listA;
        Integer closestNumber = listB.stream().map(v -> Math.abs(v - element)).reduce(Integer.MAX_VALUE, (t, e) -> {
            if (e < t) {
                return e;
            }
            return t;
        });

        Collections.sort(listA);

        for (Integer value : listA) {
            if (Math.abs(value - element) == closestNumber) {
                System.out.printf("%d ", value);
            }
        }

    }

    private static ArrayList<Integer> readArrayList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}