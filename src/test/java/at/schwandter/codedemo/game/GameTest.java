package at.schwandter.codedemo.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    Board board;
    Game game;

    @BeforeEach
    void setUp() {
        board = new Board(3);
        game = new Game(board);
    }

    @Test
    void playerXWon() {
        game.playerSet(1, 1);
        game.playerSet(3, 1);
        game.playerSet(1, 2);
        game.playerSet(3, 2);
        game.playerSet(1, 3);
        assertTrue(game.playerWon(Player.X));
    }

    @Test
    void nextPlayer() {
        assertEquals(Player.X, game.getCurrentPlayer());
        game.nextPlayer();
        assertEquals(Player.O, game.getCurrentPlayer());
        game.nextPlayer();
        assertEquals(Player.X, game.getCurrentPlayer());
    }
}
