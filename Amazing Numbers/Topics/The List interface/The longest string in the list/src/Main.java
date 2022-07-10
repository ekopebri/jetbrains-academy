import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        // write your code here
        String longestString = getLongestString(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, longestString);
        }
    }

    private static String getLongestString(List<String> list) {
        String longest = "";
        for (String value : list) {
            if (value.length() > longest.length())
                longest = value;
        }
        return longest;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}