package tech.qianmi.coderetreat;

import tech.qianmi.coderetreat.action.IRefresher;
import tech.qianmi.coderetreat.action.Refresher;
import tech.qianmi.coderetreat.model.Board;
import tech.qianmi.coderetreat.model.Cell;
import tech.qianmi.coderetreat.model.IBoard;
import tech.qianmi.coderetreat.ui.Printers;

import java.util.concurrent.TimeUnit;

public class GameOfLifeApp {

	public static void main(String[] args) throws InterruptedException {
		IBoard board = new Board(32, 64);
		board.setCell(Cell.ofLive(16, 32));
		board.setCell(Cell.ofLive(17, 32));
		board.setCell(Cell.ofLive(18, 32));
		board.setCell(Cell.ofLive(18, 31));
		board.setCell(Cell.ofLive(17, 30));

		Printers.printBoard(board);
		TimeUnit.MILLISECONDS.sleep(200);
		Printers.printBorder(board.getColumns());

		IRefresher refresher = new Refresher();

		int count = 0;
		while (true) {
			if (count == 55)
				return;

			board = refresher.refresh(board);
			Printers.printBoard(board);
			TimeUnit.MILLISECONDS.sleep(200);
			Printers.printBorder(board.getColumns());

			++count;
		}
	}

}
