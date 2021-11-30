package tech.qianmi.coderetreat.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import tech.qianmi.coderetreat.model.Board;
import tech.qianmi.coderetreat.model.Cell;
import tech.qianmi.coderetreat.model.IBoard;

public class Refresher implements IRefresher {

    private static Map<Integer, Function<Cell, Cell>> cellConverters = new HashMap<>();

    static {
        cellConverters.put(0, (cell) -> Cell.ofDead(cell.getRow(), cell.getColumn()));
        cellConverters.put(1, (cell) -> Cell.ofDead(cell.getRow(), cell.getColumn()));
        cellConverters.put(2, (cell) -> Cell.ofDead(cell.getRow(), cell.getColumn()));
        cellConverters.put(3, (cell) -> Cell.ofLive(cell.getRow(), cell.getColumn()));
        cellConverters.put(4, (cell) -> Cell.ofDead(cell.getRow(), cell.getColumn()));
        cellConverters.put(5, (cell) -> Cell.ofDead(cell.getRow(), cell.getColumn()));
        cellConverters.put(6, (cell) -> Cell.ofDead(cell.getRow(), cell.getColumn()));
        cellConverters.put(7, (cell) -> Cell.ofDead(cell.getRow(), cell.getColumn()));
        cellConverters.put(8, (cell) -> Cell.ofDead(cell.getRow(), cell.getColumn()));
    }

    @Override
    public IBoard refresh(IBoard board) {
        int rows = board.getRows();
        int columns = board.getColumns();
        IBoard copyBoard = new Board(rows, columns);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell cell = board.getCell(row, column);

                AtomicInteger livingCells = new AtomicInteger();

                Optional.ofNullable(board.getTopOn(cell)).filter(Cell::isLive).ifPresent((c) -> livingCells.incrementAndGet());
                Optional.ofNullable(board.getRightOn(cell)).filter(Cell::isLive).ifPresent((c) -> livingCells.incrementAndGet());
                Optional.ofNullable(board.getBottomOn(cell)).filter(Cell::isLive).ifPresent((c) -> livingCells.incrementAndGet());
                Optional.ofNullable(board.getLeftOn(cell)).filter(Cell::isLive).ifPresent((c) -> livingCells.incrementAndGet());
                Optional.ofNullable(board.getLeftTopOn(cell)).filter(Cell::isLive).ifPresent((c) -> livingCells.incrementAndGet());
                Optional.ofNullable(board.getRightTopOn(cell)).filter(Cell::isLive).ifPresent((c) -> livingCells.incrementAndGet());
                Optional.ofNullable(board.getRightBottomOn(cell)).filter(Cell::isLive).ifPresent((c) -> livingCells.incrementAndGet());
                Optional.ofNullable(board.getLeftBottomOn(cell)).filter(Cell::isLive).ifPresent((c) -> livingCells.incrementAndGet());

                if (cell.isLive()) {
                    if (livingCells.get() < 2) {
                        Cell copyCell = Cell.ofDead(cell.getRow(), cell.getColumn());
                        copyBoard.setCell(copyCell);
                    } else if (livingCells.get() == 2 || livingCells.get() == 3) {
                        Cell copyCell = Cell.ofLive(cell.getRow(), cell.getColumn());
                        copyBoard.setCell(copyCell);
                    } else {
                        Cell copyCell = Cell.ofDead(cell.getRow(), cell.getColumn());
                        copyBoard.setCell(copyCell);
                    }
                } else {
                    if (livingCells.get() == 3) {
                        Cell copyCell = Cell.ofLive(cell.getRow(), cell.getColumn());
                        copyBoard.setCell(copyCell);
                    } else {
                        Cell copyCell = Cell.ofDead(cell.getRow(), cell.getColumn());
                        copyBoard.setCell(copyCell);
                    }
                }

                /*
                Cell copyCell = cellConverters.get(livingCells.get()).apply(cell);
                copyBoard.setCell(copyCell);*/

                /*if (livingCells.get() < 2 || livingCells.get() > 3) {
                    Cell copyCell = Cell.ofDead(cell.getRow(), cell.getColumn());
                    copyBoard.setCell(copyCell);
                } else {
                    Cell copyCell = Cell.ofLive(cell.getRow(), cell.getColumn());
                    copyBoard.setCell(copyCell);
                }*/
            }
        }

        return copyBoard;
    }
    
}
