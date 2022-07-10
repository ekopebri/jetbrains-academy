import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'T' || input.charAt(i) == 't') {
                if (input.charAt(i + 1) == 'h' && input.charAt(i + 2) == 'e') {
                    System.out.println(i);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}