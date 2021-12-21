package tech.qianmi.coderetreat.action;

import tech.qianmi.coderetreat.model.Board;
import tech.qianmi.coderetreat.model.Cell;
import tech.qianmi.coderetreat.model.IBoard;

import java.util.stream.Stream;

public class Refresher implements IRefresher {

    @Override
    public IBoard refresh(IBoard board) {
        int rows = board.getRows();
        int columns = board.getColumns();
        IBoard copyBoard = new Board(rows, columns);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell cell = board.getCell(row, column);

                long liveCount = Stream.of(board.getTopOn(cell), board.getRightOn(cell),
                                board.getBottomOn(cell), board.getLeftOn(cell),
                                board.getLeftTopOn(cell), board.getRightTopOn(cell),
                                board.getRightBottomOn(cell), board.getLeftBottomOn(cell))
                        .filter(c -> c != null && c.isLive())
                        .count();

                Cell copyCell = liveCount == 2 && cell.isLive() || liveCount == 3 ?
                        Cell.ofLive(cell.getRow(), cell.getColumn())
                        : Cell.ofDead(cell.getRow(), cell.getColumn());
                copyBoard.setCell(copyCell);
            }
        }

        return copyBoard;
    }

}
