package tictactoe;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    private static int[][] cells = new int[][] {
        {-3, -3, -3},
        {-3, -3, -3},
        {-3, -3, -3},
    };

    private static int[][] possibleWin = new int[][]{
            {0, 1, 2},
            {0, 3, 6},
            {0, 4, 8},
            {1, 4, 7},
            {2, 4, 6},
            {2, 5, 8},
            {3, 4, 5},
            {6, 7, 8}
    };

    private static Map<Integer, String> maps = new HashMap<>(){{
        put(-1, "X");
        put(-2, "O");
        put(-3, " ");
    }};

    private static int currentPlay = -1;

    public static void main(String[] args) {
        printNewGame();
        enterCoordinates();
    }

    private static int countCell = 0;

    private static void enterCoordinates() {
        try {
            System.out.print("Enter the coordinates: ");
            int row = scanner.nextInt();
            int column = scanner.nextInt();

            int cell = cells[row-1][column-1];

            if (cell == -3 && countCell < 9) {
                cells[row-1][column-1] = currentPlay;
                countCell++;
                fillPossibleWin(row, column);
                printNewGame();
                if (win()) {
                    System.out.printf("%s wins%n", maps.get(currentPlay));
                    return;
                }
                currentPlay = currentPlay == -1 ? -2 : -1;
                enterCoordinates();
            } else {
                if (countCell > 9) {
                    return;
                }
                System.out.println("This cell is occupied! Choose another one!");
                enterCoordinates();
            }
        } catch (InputMismatchException exception) {
            System.out.println("You should enter numbers!");
            enterCoordinates();
            return;
        } catch (IndexOutOfBoundsException exception) {
            System.out.println("Coordinates should be from 1 to 3!");
            enterCoordinates();
            return;
        }
    }

    private static void printNewGame() {
        System.out.println("---------");
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (j == 0) {
                    System.out.printf("| %s ", maps.get(cells[i][j]));
                } else if (j == 2) {
                    System.out.printf("%s | %n", maps.get(cells[i][j]));
                } else {
                    System.out.printf("%s ", maps.get(cells[i][j]));
                }
            }
        }
        System.out.println("---------");
    }

    private static boolean win() {
        for (int i = 0; i < possibleWin.length; i++) {
            for (int j = 0; j < possibleWin[i].length; j++) {
                if (Arrays.stream(possibleWin[i]).allMatch(v -> v == currentPlay)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void fillPossibleWin(int row, int column) {
        // Create map here
        int[][] possibleData = new int[][]{
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };
        for (int i = 0; i < possibleWin.length; i++) {
            for (int j = 0; j < possibleWin[i].length; j++) {
                if (possibleWin[i][j] == possibleData[row-1][column-1]) {
                    possibleWin[i][j] = currentPlay;
                }
            }
        }
    }

}
