import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.nextLine();
        String word2 = scanner.nextLine();
        System.out.println(word1.replace(" ", "")
                .equalsIgnoreCase(word2.replace(" ", "")));
    }
}