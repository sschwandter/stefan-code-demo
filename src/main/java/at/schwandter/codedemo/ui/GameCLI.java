/*
 * Command line interface for the game
 */
package at.schwandter.codedemo.ui;

import at.schwandter.codedemo.game.Board;
import at.schwandter.codedemo.game.EntryAlreadySetException;
import at.schwandter.codedemo.game.Game;
import at.schwandter.codedemo.game.Player;

import java.util.Scanner;

public class GameCLI {

    Board board;
    Game game;

    public GameCLI() {
        board = new Board(3);
        game = new Game(board);
    }

    public static void main(String[] args) {

        GameCLI gameCLI = new GameCLI();
        gameCLI.runGame();
    }

    public void drawBoard(Board board) {
        for (int row = 0; row < 3; row++) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < 3; col++) {
                var entry = board.getEntry(row, col);
                String symbol = entry.isPresent() ? entry.get().toString() : " ";
                line.append(symbol).append(" ");
            }
            System.out.println(line);
        }
    }

    private void runGame() {
        Scanner in = new Scanner(System.in);
        while (!game.finished()) {
            takeTurn(in, game.getCurrentPlayer());
        }
    }

    private void takeTurn(Scanner in, Player player) {
        while (true) {
            var location = getUserInput(player, in);
            trySetPiece(location);
            break;
        }
        if (game.playerWon(player)) {
            System.out.println("Player won: " + player);
        }
    }

    private Location getUserInput(Player player, Scanner in) {
        System.out.println("Player " + player + ", enter row (1-3)");
        int row = in.nextInt();
        System.out.println("Player " + player + ", enter column (1-3)");
        int col = in.nextInt();
        return new Location(row, col);
    }

    private void trySetPiece(Location location) {
        try {
            game.playerSet(location.row, location.col);
        } catch (EntryAlreadySetException e) {
            System.out.println("This field was already set, try another one");
        } finally {
            this.drawBoard(board);
        }
    }
    private class Location {
        final int row;
        final int col;

        private Location(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
