import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code heret
        int position = scanner.nextInt();
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                System.out.print(input[position - 1]);
            } else {
                System.out.print(" " + input[i - 1]);
            }
        }
    }
}