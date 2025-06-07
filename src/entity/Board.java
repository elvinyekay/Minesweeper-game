package entity;

import java.util.Arrays;
import java.util.Random;

public class Board {
    private String[][] mineMap;
    private String[][] visibleMap;
    private final int rows;
    private final int columns;
    private final int mineCount;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.mineCount = this.rows * this.columns / 4;
        mineMap = new String[rows][columns];
        visibleMap = new String[rows][columns];

        initGameArr();
        placeMines();
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String[][] getMineMap() {
        return mineMap;
    }

    public String[][] getVisibleMap() {
        return visibleMap;
    }

    private void initGameArr() {
        for (String[] elements : visibleMap) {
            Arrays.fill(elements, "-");
        }
    }

    private void placeMines() {
        Random random = new Random();
        int minePlaced = 0;

        for (int i = 0; i < mineMap.length; i++) {
            System.arraycopy(visibleMap[i], 0, mineMap[i], 0, mineMap[i].length);
        }

        while (minePlaced < mineCount) {
            int rowNum = random.nextInt(rows);
            int colNum = random.nextInt(columns);
            if (!mineMap[rowNum][colNum].equals("*")) {
                mineMap[rowNum][colNum] = "*";
                minePlaced++;
            }
        }
    }

    void printMap(String[][] map) {
        for (String[] elem : map) {
            for (String s : elem) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    boolean processTurn(int row, int col) {
        if (mineMap[row][col].equals("*")) {
            System.out.println("Game over");
            printMap(mineMap);
            return false;
        } else {
            int count = checkMine(row, col);
            visibleMap[row][col] = String.valueOf(count);
            return true;
        }
    }

    private int checkMine(int row, int col) {
        int count = 0;

        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1},
        };

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 && newRow < this.rows && newCol >= 0 && newCol < this.columns) {
                if (this.mineMap[newRow][newCol].equals("*")) {
                    count++;
                }
            }
        }
        return count;
    }
}
