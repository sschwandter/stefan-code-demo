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

    public void playerSet(Player player, int row, int col) {
        board.setEntry(player, row, col);
    }

    public void nextPlayer() {
        currentPlayer = (getCurrentPlayer().equals(Player.X)) ? Player.O : Player.X;
    }

    public boolean finished() {
        return playerWon(Player.X) || playerWon(Player.O);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
