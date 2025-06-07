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
        System.out.println("Enter board size to play: ");
        System.out.println("Row size: ");
        rowSize = scanner.nextInt();
        System.out.println("Column size: ");
        colSize = scanner.nextInt();


        Minesweeper minesweeper = new Minesweeper(rowSize,colSize);
        minesweeper.run();
    }
}