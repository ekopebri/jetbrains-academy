import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sample = scanner.nextLine();
        String[] sampleArray = sample.split(" ");
        boolean isOrder = true;

        for (int i = 1; i < sampleArray.length; i++) {
            if (sampleArray[i - 1].compareTo(sampleArray[i]) > 0) {
                isOrder = false;
            }
        }

        System.out.println(isOrder);
    }
}