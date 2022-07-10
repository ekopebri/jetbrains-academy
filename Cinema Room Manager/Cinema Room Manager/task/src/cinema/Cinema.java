package cinema;

import java.util.*;

public class Cinema {
    
    private static final Scanner scanner = new Scanner(System.in);

    private static int[][] datas;
    private static int ticketSold = 0;
    private static int totalSeat = 0;
    private static int totalIncome = 0;
    private static int totalPrice = 0;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();

        datas = new int[rows][seats];

        calculateMaxPossibilityIncome();

        initCinemas();

        menu();
    }

    private static int calculateIncome(int chooseRow) {
        int price;
        int total = datas.length * datas[0].length;
        if ( total > 60) {
            double front = Math.floor(((double) datas.length) / 2);
            if (chooseRow <= front) {
                price = 10;
            } else {
                price = 8;
            }
        } else {
            price = 10;
        }

        return price;
    }

    private static boolean selectSeat(int rows, int seat) {
        if (rows > datas.length || seat > datas[0].length) {
            System.out.println("\nWrong input!\n");
            return false;
        } else if (datas[rows-1][seat-1] == 1) {
            System.out.println("\nThat ticket has already been purchased!\n");
            return false;
        } else {
            datas[rows-1][seat-1] = 1;
            return true;
        }
    }

    private static void calculateMaxPossibilityIncome() {
        int total = datas.length * datas[0].length;
        if ( total > 60) {
            double front = Math.floor(((double) datas.length) / 2);
            double back = Math.ceil(((double) datas.length) / 2);

            totalPrice = ((int)front * 10 * datas[0].length) + ((int)back * 8 * datas[0].length);
        } else {
            totalPrice = 10 * total;
        }
    }

    private static void initCinemas() {
        for (int[] data : datas) {
            Arrays.fill(data, 0);
        }
        totalSeat = datas.length * datas[0].length;
    }
    private static void printCinema() {
        System.out.println("\nCinema:");
        for (int i = 0; i < datas.length; i++) {
            if (i == 0) {
                for (int j = 0; j <= datas[i].length; j++) {
                    if (j == 0) {
                        System.out.print("  ");
                    } else {
                        System.out.print(j + " ");
                    }
                }
                System.out.println();
            }

            System.out.print((i+1) + " ");
            for (int j = 0; j < datas[i].length; j++) {
                System.out.print(datas[i][j] == 0 ? "S " : "B ");
            }

            System.out.println();
        }

        menu();
    }

    private static void buyTicket() {
        System.out.println("\nEnter a row number:");
        int chooseRow = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int chooseSeat = scanner.nextInt();

        boolean isAdded = selectSeat(chooseRow, chooseSeat);

        if (isAdded) {
            int price = calculateIncome(chooseRow);

            totalIncome += price;
            ticketSold += 1;

            printTicketPrice(price);

            menu();
        } else {
            buyTicket();
        }

    }

    private static void printTicketPrice(int price) {
        System.out.println("\nTicket price: $" + price);
    }

    private static void menu() {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int choosenMenu = scanner.nextInt();
        if (choosenMenu == 1) {
            printCinema();
        } else if (choosenMenu == 2) {
            buyTicket();
        } else if (choosenMenu == 3) {
            showStatistic();
        }
    }

    private static void showStatistic() {
        float percentage = ((float) ticketSold / (float) totalSeat) * 100;
        System.out.printf("%nNumber of purchased tickets: %d", ticketSold);
        System.out.printf("%nPercentage: %.2f%%", percentage);
        System.out.printf("%nCurrent income: $%d", totalIncome);
        System.out.printf("%nTotal income: $%d%n", totalPrice);

        menu();
    }
}