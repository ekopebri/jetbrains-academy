package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static final int WATER_NEED = 200;
    private static final int MILK_NEED = 50;
    private static final int BEAN_NEED = 15;

    public static Scanner scanner = new Scanner(System.in);
    public static int[] data = {400, 540, 120, 9, 550};

    public static void main(String[] args) {
        action();
    }

    public static void action() {
        System.out.println("Write action (buy, fill, take, remaining, exit): ");
        String act = scanner.next();
        if (act.equals("buy")) {
            buy();
        } else if (act.equals("take")) {
            take();
        } else if (act.equals("fill")) {
            fill();
        } else if (act.equals("remaining")) {
            information();
        } else {
            System.out.println("SSSS");
            return;
        }

        action();
    }

    public static int getMinAmount(int[] cups) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < cups.length; i++) {
            if (cups[i] < min) {
                min = cups[i];
            }
        }

        return min;
    }

    public static void buy() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String by = scanner.next();
        int[] cups;
        if (by.equals("1")) {
            cups = new int[] { data[0] / 250, data[2] / 16 };
            if(getMinAmount(cups) > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                data[0] -= 250;
                data[2] -= 16;
                data[3] -= 1;
                data[4] += 4;
            } else {
                printError(250, 0, 16);
            }
        } else if (by.equals("2")) {
            cups = new int[] { data[0] / 350, data[1] / 75, data[2] / 20 };
            if(getMinAmount(cups) > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                data[0] -= 350;
                data[1] -= 75;
                data[2] -= 20;
                data[3] -= 1;
                data[4] += 7;
            } else {
                printError(350, 75, 20);
            }
        } else if (by.equals("3")) {
            cups = new int[] { data[0] / 200, data[1] / 100, data[2] / 12 };
            if(getMinAmount(cups) > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                data[0] -= 200;
                data[1] -= 100;
                data[2] -= 12;
                data[3] -= 1;
                data[4] += 6;
            } else {
                printError(200, 100, 12);
            }
        }
    }

    public static void printError(int water, int milk, int bean) {
        if (data[0] < water) {
            System.out.println("Sorry, not enough water!\n");
        } else if (data[1] < milk) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (data[2] < bean) {
            System.out.println("Sorry, not enough coffee beans!\n");
        }
    }

    public static void fill() {
        System.out.println("\nWrite how many ml of water you want to add: ");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int bean = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        int cup = scanner.nextInt();
        data[0] += water;
        data[1] += milk;
        data[2] += bean;
        data[3] += cup;
    }

    public static void take() {
        System.out.println("I gave you $" + data[4]);
        data[4] = 0;
    }

    public static void information() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(data[0] + " ml of water");
        System.out.println(data[1] + " ml of milk");
        System.out.println(data[2] + " g of coffee beans");
        System.out.println(data[3] + " disposable cups");
        System.out.println("$"+ data[4] +" of money\n");
    }
}
