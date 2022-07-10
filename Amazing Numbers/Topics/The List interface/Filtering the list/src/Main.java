import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = readArrayAsList(scanner);
        List<Integer> newList = list.stream().filter(v -> list.indexOf(v) % 2 != 0).collect(Collectors.toList());

        boolean isDesc = list.get(0) > list.get(list.size() - 1);
        Collections.sort(newList, (o1, o2) -> isDesc ? Math.abs(o1) - Math.abs(o2) : Math.abs(o2) - Math.abs(o1));

        newList.forEach(v -> System.out.printf("%d ", v));
    }

    private static ArrayList<Integer> readArrayAsList(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}