package at.schwandter.codedemo.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    Board board;
    Game game;

    @BeforeEach
    public void setUp() {
        board = new Board(3);
        game = new Game(board);
    }

    @Test
    void playerXWon() {
        game.playerSet(Player.X, 0, 0);
        game.playerSet(Player.O, 2, 0);
        game.playerSet(Player.X, 0, 1);
        game.playerSet(Player.O, 2, 1);
        game.playerSet(Player.X, 0, 2);
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
