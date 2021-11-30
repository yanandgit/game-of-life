package tech.qianmi.coderetreat.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

    private static final Cell CENTER = Cell.ofLive(1, 1);

    private static final Cell LEFT_TOP = Cell.ofLive(0, 0);

    private IBoard board;

    @BeforeEach
    public void setUp() {
        board = new Board(3, 3);
    }

	@Test
	void getAllCells_whenBoardInitialize_thenReturnAllCells() {
        Cell[][] cells = board.getAllCells();
        assertEquals(9, board.getRows() * board.getColumns());
        assertEquals(3, cells.length);
        assertEquals(3, cells[0].length);
	}

    @Test
	void getLeftOn_whenCellOnCenter_thenReturnLeft() {
        Cell actual = board.getLeftOn(CENTER);
        assertEquals(0, actual.getRow());
        assertEquals(1, actual.getColumn());
	}

    @Test
	void getLeftOn_whenCellOnLeftTop_thenReturnNull() {
        Cell actual = board.getLeftOn(LEFT_TOP);
        assertNull(actual);
	}

    @Test
	void getLeftTopOn_whenCellOnCenter_thenReturnLeftTop() {
        Cell actual = board.getLeftTopOn(CENTER);
        assertEquals(0, actual.getRow());
        assertEquals(0, actual.getColumn());
	}

    @Test
	void getLeftTopOn_whenCellOnLeftTop_thenReturnNull() {
        Cell actual = board.getLeftTopOn(LEFT_TOP);
        assertNull(actual);
	}

    @Test
	void getLeftBottomOn_whenCellOnCenter_thenReturnLeftBottomOn() {
        Cell actual = board.getLeftBottomOn(CENTER);
        assertEquals(0, actual.getRow());
        assertEquals(2, actual.getColumn());
	}

    @Test
	void getLeftBottomOn_whenCellOnLeftTop_thenReturnNull() {
        Cell actual = board.getLeftBottomOn(LEFT_TOP);
        assertNull(actual);
	}

    @Test
	void getTopOn_whenCellOnCenter_thenReturnTop() {
        Cell actual = board.getTopOn(CENTER);
        assertEquals(1, actual.getRow());
        assertEquals(0, actual.getColumn());
	}

    @Test
	void getBottomOn_whenCellOnCenter_thenReturnBottom() {
        Cell actual = board.getBottomOn(CENTER);
        assertEquals(1, actual.getRow());
        assertEquals(2, actual.getColumn());
	}

    @Test
	void getRightOn_whenCellOnCenter_thenReturnRight() {
        Cell actual = board.getRightOn(CENTER);
        assertEquals(2, actual.getRow());
        assertEquals(1, actual.getColumn());
	}

    @Test
	void getRightTopOn_whenCellOnCenter_thenReturnRightTop() {
        Cell actual = board.getRightTopOn(CENTER);
        assertEquals(2, actual.getRow());
        assertEquals(0, actual.getColumn());
	}

    @Test
	void getRightBottomOn_whenCellOnCenter_thenReturnRightBottom() {
        Cell actual = board.getRightBottomOn(CENTER);
        assertEquals(2, actual.getRow());
        assertEquals(2, actual.getColumn());
	}

}
