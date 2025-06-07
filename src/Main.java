import entity.Minesweeper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowSize, colSize;

        System.out.println("Welcome to Minesweeper Game!");
        System.out.println("===============================");
        System.out.println("Game Rules:");
        System.out.println("- Try to open all safe cells without hitting a mine.");
        System.out.println("- Input row and column numbers to reveal a cell.");
        System.out.println("- The number shows how many mines are around that cell.");
        System.out.println("- If you open a mine, you lose.");
        System.out.println("Good luck!");
        System.out.println("===============================");
        System.out.println("Enter board size to play:(Minimum (2-2), Maximum (10-10): ");


        while (true) {
            System.out.println("Row size: ");
            rowSize = scanner.nextInt();
            System.out.println("Column size: ");
            colSize = scanner.nextInt();
            if (rowSize <= 1 || colSize <= 1 || rowSize > 10 || colSize > 10) {
                System.out.println("Invalid row or column number!");
                System.out.println("Try again.");
                System.out.println("Enter board size to play:(Minimum (2-2), Maximum (10-10): ");

            }else {
                break;
            }
        }

        Minesweeper minesweeper = new Minesweeper(rowSize,colSize);
        minesweeper.run();

    }
}