import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        List<String> arrays = new ArrayList<>();
        while (scanner.hasNext()) {
            arrays.add(scanner.next());
        }

        for (int i = arrays.size() - 1; i >= 0; i--) {
            System.out.println(arrays.get(i));
        }
    }
}