package at.schwandter.codedemo.game.ui;

import at.schwandter.codedemo.game.Board;
import at.schwandter.codedemo.game.Player;
import at.schwandter.codedemo.ui.GameCLI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameCLITest {

    Board board;
    GameCLI gameCLI;

    @BeforeEach
    public void setUp() {
        board = new Board(3);
        gameCLI = new GameCLI();
    }

    @Test
    void drawBoard() {
        board.setEntry(Player.X, 0, 0);
        board.setEntry(Player.O, 1, 0);
        board.setEntry(Player.X, 2, 0);
        board.setEntry(Player.O, 0, 1);
        board.setEntry(Player.X, 1, 1);
        gameCLI.drawBoard(board);
    }
}
