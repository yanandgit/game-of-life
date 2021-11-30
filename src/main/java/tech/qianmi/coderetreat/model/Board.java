package tech.qianmi.coderetreat.model;

public class Board implements IBoard {

    private int rows;

    private int columns;

    private Cell[][] cells;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;

        this.cells = new Cell[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                this.cells[row][column] = Cell.ofDead(row, column);
            }
        }
    }

    @Override
    public Cell[][] getAllCells() {
        return this.cells;
    }

    @Override
    public Cell getBottomOn(Cell baseCell) {
        int column = baseCell.getColumn() + 1;
        if (column > this.columns - 1)
            return null;
        return this.cells[baseCell.getRow()][column];
    }

    @Override
    public Cell getCell(int row, int column) {
        return this.cells[row][column];
    }

    @Override
    public int getColumns() {
        return this.columns;
    }

    @Override
    public Cell getLeftBottomOn(Cell baseCell) {
        int row = baseCell.getRow() - 1;
        int column = baseCell.getColumn() + 1;
        if (row < 0 || column > this.columns - 1)
            return null;
        return this.cells[row][column];
    }

    @Override
    public Cell getLeftOn(Cell baseCell) {
        int row = baseCell.getRow() - 1;
        int column = baseCell.getColumn();
        if (row < 0)
            return null;
        return this.cells[row][column];
    }

    @Override
    public Cell getLeftTopOn(Cell baseCell) {
        int row = baseCell.getRow() - 1;
        int column = baseCell.getColumn() - 1;
        if (row < 0 || column < 0)
            return null;
        return this.cells[row][column];
    }

    @Override
    public Cell getRightBottomOn(Cell baseCell) {
        int row = baseCell.getRow() + 1;
        int column = baseCell.getColumn() + 1;
        if (row > this.rows - 1 || column > this.columns - 1)
            return null;
        return this.cells[row][column];
    }

    @Override
    public Cell getRightOn(Cell baseCell) {
        int row = baseCell.getRow() + 1;
        int column = baseCell.getColumn();
        if (row > this.rows - 1)
            return null;
        return this.cells[row][column];
    }

    @Override
    public Cell getRightTopOn(Cell baseCell) {
        int row = baseCell.getRow() + 1;
        int column = baseCell.getColumn() - 1;
        if (row > this.rows - 1 || column < 0)
            return null;
        return this.cells[row][column];
    }

    @Override
    public int getRows() {
        return this.rows;
    }

    @Override
    public Cell getTopOn(Cell baseCell) {
        int row = baseCell.getRow();
        int column = baseCell.getColumn() - 1;
        if (column < 0)
            return null;
        return this.cells[row][column];
    }

    @Override
    public void setCell(Cell cell) {
        this.cells[cell.getRow()][cell.getColumn()] = cell;
    }
    
}
