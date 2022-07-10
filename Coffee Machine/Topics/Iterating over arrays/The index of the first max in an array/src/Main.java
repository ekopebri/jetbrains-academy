import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        int index = 0;
        int length = scanner.nextInt();
        scanner.nextLine();
        String arr = scanner.nextLine();
        String[] arr2 = arr.split(" ");
        for (int i = 0; i < length; i++) {
            int intA = Integer.parseInt(arr2[i]);
            if (intA > max) {
                max = intA;
                index = i;
            }
        }

        System.out.println(index);
    }
}