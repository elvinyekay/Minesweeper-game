package entity;

import java.util.Scanner;

public class Minesweeper {

    private final Board board;

    public Minesweeper(int rows, int cols) {
        board = new Board(rows, cols);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

//        board.printMap(board.getMineMap());
//        System.out.println("================");

        board.printMap(board.getVisibleMap());
        while (true) {
            System.out.println("Enter row number: ");
            row = scanner.nextInt();

            System.out.println("Enter column number: ");
            col = scanner.nextInt();

            if (isValidCoordinate(row, col)) {
                System.out.println("Invalid row or column number");
                continue;
            }

            if (!board.processTurn(row, col)) {
                break;
            }

            board.printMap(board.getVisibleMap());

            if (isGameWin()) {
                System.out.println("Congratulations! You won!");
                break;
            }
        }
        scanner.close();
    }

    private boolean isValidCoordinate(int row, int col) {
        return row < 0 || row >= board.getRows() || col < 0 || col >= board.getColumns();
    }

    private boolean isGameWin() {
        for (int i = 0; i < board.getVisibleMap().length; i++) {
            for (int j = 0; j < board.getVisibleMap()[i].length; j++) {
                if (board.getVisibleMap()[i][j].equals("-") && !board.getMineMap()[i][j].equals("*")) {
                    return false;
                }
            }
        }
        return true;
    }

}
