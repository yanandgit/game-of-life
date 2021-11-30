package tech.qianmi.coderetreat.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import tech.qianmi.coderetreat.model.Board;
import tech.qianmi.coderetreat.model.Cell;
import tech.qianmi.coderetreat.model.IBoard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RefresherTest {
    
    private static final Cell LIVE_CENTER = Cell.ofLive(1, 1);

    private static final Cell DEAD_CENTER = Cell.ofDead(1, 1);

    private IRefresher underTest = new Refresher();

    private IBoard board = null;

    @BeforeEach
    void setup() {
        board = new Board(3, 3);
    }

    @Test
    void refresh_whenCenterLiveAndAroundLive1_thenCenterDie() {
        board.setCell(LIVE_CENTER);
        board.setCell(Cell.ofLive(0, 0));

        IBoard actual = underTest.refresh(board);

        assertFalse(actual.getCell(1, 1).isLive());
    }

    @Test
    void refresh_whenCenterLiveAndAroundLive2_thenCenterStasis() {
        board.setCell(LIVE_CENTER);
        board.setCell(Cell.ofLive(0, 0));
        board.setCell(Cell.ofLive(0, 1));

        IBoard actual = underTest.refresh(board);

        assertTrue(actual.getCell(1, 1).isLive());
    }

    @Test
    void refresh_whenCenterLiveAndAroundLive3_thenCenterStasis() {
        board.setCell(LIVE_CENTER);
        board.setCell(Cell.ofLive(0, 0));
        board.setCell(Cell.ofLive(0, 1));
        board.setCell(Cell.ofLive(0, 2));

        IBoard actual = underTest.refresh(board);

        assertTrue(actual.getCell(1, 1).isLive());
    }

    @Test
    void refresh_whenCenterLiveAndAroundLive4_thenCenterDie() {
        board.setCell(LIVE_CENTER);
        board.setCell(Cell.ofLive(0, 0));
        board.setCell(Cell.ofLive(0, 1));
        board.setCell(Cell.ofLive(0, 2));
        board.setCell(Cell.ofLive(1, 0));

        IBoard actual = underTest.refresh(board);

        assertFalse(actual.getCell(1, 1).isLive());
    }

    @Test
    void refresh_whenCenterDeadAndAroundLive1_thenCenterDie() {
        board.setCell(DEAD_CENTER);
        board.setCell(Cell.ofLive(0, 0));

        IBoard actual = underTest.refresh(board);

        assertFalse(actual.getCell(1, 1).isLive());
    }

    @Test
    void refresh_whenCenterDeadAndAroundLive2_thenCenterDie() {
        board.setCell(DEAD_CENTER);
        board.setCell(Cell.ofLive(0, 0));
        board.setCell(Cell.ofLive(0, 1));

        IBoard actual = underTest.refresh(board);

        assertFalse(actual.getCell(1, 1).isLive());
    }

    @Test
    void refresh_whenCenterDeadAndAroundLive3_thenCenterReproduction() {
        board.setCell(DEAD_CENTER);
        board.setCell(Cell.ofLive(0, 0));
        board.setCell(Cell.ofLive(0, 1));
        board.setCell(Cell.ofLive(0, 2));

        IBoard actual = underTest.refresh(board);

        assertTrue(actual.getCell(1, 1).isLive());
    }

    @Test
    void refresh_whenCenterDeadAndAroundLive4_thenCenterDie() {
        board.setCell(DEAD_CENTER);
        board.setCell(Cell.ofLive(0, 0));
        board.setCell(Cell.ofLive(0, 1));
        board.setCell(Cell.ofLive(0, 2));
        board.setCell(Cell.ofLive(1, 0));

        IBoard actual = underTest.refresh(board);

        assertFalse(actual.getCell(1, 1).isLive());
    }
}
