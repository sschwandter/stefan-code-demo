package at.schwandter.codedemo.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("OptionalGetWithoutIsPresent")
class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(3);
    }

    @Test
    void newBoardIsEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.getEntry(i, j).isEmpty());
            }
        }
    }

    @Test
    void outOfBoundsExceptionI() {
        assertThrows(IndexOutOfBoundsException.class, () -> board.getEntry(3, 0));
    }

    @Test
    void outOfBoundsExceptionJ() {
        assertThrows(IndexOutOfBoundsException.class, () -> board.getEntry(0, 3));
    }

    @Test
    void setEntryToXEntryIsSet() {
        board.setEntry(Player.X, 0, 0);
        assertEquals(board.getEntry(0, 0).get(), Player.X);
    }

    @Test
    void setEntryToOEntryIsSet() {
        board.setEntry(Player.O, 1, 2);
        assertEquals(board.getEntry(1, 2).get(), Player.O);
    }

    @Test
    void tryToResetEntry() {
        board.setEntry(Player.X, 0, 0);
        assertThrows(EntryAlreadySetException.class, () -> board.setEntry(Player.X, 0, 0));
    }

    @Test
    void fullRowRecognized1() {
        board.setEntry(Player.X, 0, 0);
        board.setEntry(Player.X, 0, 1);
        board.setEntry(Player.X, 0, 2);
        assertTrue(board.fullRow(Player.X));
    }

    @Test
    void fullRowRecognized2() {
        board.setEntry(Player.X, 1, 0);
        board.setEntry(Player.X, 1, 1);
        board.setEntry(Player.X, 1, 2);
        assertTrue(board.fullRow(Player.X));
    }

    @Test
    void fullRowRecognized3() {
        board.setEntry(Player.X, 2, 0);
        board.setEntry(Player.X, 2, 1);
        board.setEntry(Player.X, 2, 2);
        assertTrue(board.fullRow(Player.X));
    }

    @Test
    void fullColumnRecognized1() {
        board.setEntry(Player.X, 0, 0);
        board.setEntry(Player.X, 1, 0);
        board.setEntry(Player.X, 2, 0);
        assertTrue(board.fullColumn(Player.X));
    }

    @Test
    void fullColumnCorrectlyNotRecognized1() {
        board.setEntry(Player.X, 1, 0);
        board.setEntry(Player.X, 1, 1);
        board.setEntry(Player.X, 1, 2);
        assertFalse(board.fullColumn(Player.X));
    }

    @Test
    void fullColumnRecognized2() {
        board.setEntry(Player.X, 0, 1);
        board.setEntry(Player.X, 1, 1);
        board.setEntry(Player.X, 2, 1);
        assertTrue(board.fullColumn(Player.X));
    }

    @Test
    void fullColumnRecognized3() {
        board.setEntry(Player.X, 0, 2);
        board.setEntry(Player.X, 1, 2);
        board.setEntry(Player.X, 2, 2);
        assertTrue(board.fullColumn(Player.X));
    }

    @Test
    void fullDiagonalRecognized1() {
        board.setEntry(Player.X, 0, 0);
        board.setEntry(Player.X, 1, 1);
        board.setEntry(Player.X, 2, 2);
        assertTrue(board.fullDiagonal(Player.X));
    }

    @Test
    void fullDiagonalRecognized2() {
        board.setEntry(Player.X, 0, 2);
        board.setEntry(Player.X, 1, 1);
        board.setEntry(Player.X, 2, 0);
        assertTrue(board.fullDiagonal(Player.X));
    }

}
