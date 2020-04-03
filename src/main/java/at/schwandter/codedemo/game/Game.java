/**
 * Contains game rules
 */
package at.schwandter.codedemo.game;

public class Game {

    final Board board;
    private Player currentPlayer;

    public Game(Board board) {
        this.board = board;
        this.currentPlayer = Player.X;
    }

    public boolean playerWon(Player player) {
        return board.fullRow(player) || board.fullColumn(player) || board.fullDiagonal(player);
    }

    public void playerSet(int row, int col) {
        board.setEntry(getCurrentPlayer(), internalIndex(row), internalIndex(col));
        nextPlayer();
    }

    public boolean finished() {
        return playerWon(Player.X) || playerWon(Player.O);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    void nextPlayer() {
        currentPlayer = (getCurrentPlayer().equals(Player.X)) ? Player.O : Player.X;
    }

    private int internalIndex(int row) {
        return row - 1;
    }
}
