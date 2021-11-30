package tech.qianmi.coderetreat.ui;

import tech.qianmi.coderetreat.model.Cell;
import tech.qianmi.coderetreat.model.IBoard;

public class Printers {
    
    public static void printBoard(IBoard board) {
        int rows = board.getRows();
        int columns = board.getColumns();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell cell = board.getCell(row, column);
                if (cell.isLive())
                    System.out.print("  ");
                else
                    System.out.print("██");

            }
            System.out.println();
        }
    }

    public static void cleanLines(int lines) {
        for (int line = 0; line < lines; line++) {
            System.out.print("\r\b");
        }
    }
}
