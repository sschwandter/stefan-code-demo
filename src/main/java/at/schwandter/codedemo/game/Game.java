package at.schwandter.codedemo.game;

public class Game {

    final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public boolean playerWon(Player player) {
        return board.fullRow(player) || board.fullColumn(player) || board.fullDiagonal(player);
    }

    public void playerSet(Player player, int row, int col) {
        board.setEntry(player, row, col);
    }

    public boolean finished() {
        return playerWon(Player.X) || playerWon(Player.O);
    }
}
