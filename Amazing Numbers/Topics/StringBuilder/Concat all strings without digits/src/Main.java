import java.util.Scanner;

class ConcatenateStringsProblem {

    public static String concatenateStringsWithoutDigits(String[] strings) {
        StringBuilder newString = new StringBuilder("");
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length(); j++) {
                if (!isNumeric(strings[i].charAt(j))) {
                    newString.append(strings[i].charAt(j));
                }
            }
        }

        return newString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("\\s+");
        String result = concatenateStringsWithoutDigits(strings);
        System.out.println(result);
    }

    public static boolean isNumeric(char c) {
        try {
            Integer.parseInt(String.valueOf(c));
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}