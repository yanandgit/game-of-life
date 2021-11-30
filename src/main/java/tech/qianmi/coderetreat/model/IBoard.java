package tech.qianmi.coderetreat.model;

public interface IBoard {
    
    int getRows();

    int getColumns();

    Cell[][] getAllCells();

    Cell getCell(int row, int column);

    Cell getTopOn(Cell baseCell);

    Cell getRightOn(Cell baseCell);

    Cell getBottomOn(Cell baseCell);

    Cell getLeftOn(Cell baseCell);

    Cell getLeftTopOn(Cell baseCell);

    Cell getRightTopOn(Cell baseCell);

    Cell getLeftBottomOn(Cell baseCell);
    
    Cell getRightBottomOn(Cell baseCell);

    void setCell(Cell cell);

}
