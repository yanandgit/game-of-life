package tech.qianmi.coderetreat.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Cell {

    private int row;

    private int column;

    private boolean live;

    public static Cell ofLive(int row, int column) {
        return new Cell(row, column, true);
    }

    public static Cell ofDead(int row, int column) {
        return new Cell(row, column, false);
    }
}
