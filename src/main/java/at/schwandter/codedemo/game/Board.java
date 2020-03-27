package at.schwandter.codedemo.game;

import java.util.Optional;

public class Board {

    private final Player[][] boardEntries;
    private final int size;

    public Board(int size) {
        boardEntries = new Player[size][size];
        this.size = size;
    }

    public Optional<Player> getEntry(int row, int col) {
        return Optional.ofNullable(boardEntries[row][col]);
    }

    public void setEntry(Player entry, int row, int col) {
        if (boardEntries[row][col] != null) throw new EntryAlreadySetException();
        boardEntries[row][col] = entry;
    }

    public boolean fullRow(Player player) {
        for (Player[] row : boardEntries) {
            int count = 0;
            for (Player p : row) {
                if (player.equals(p))
                    count++;
            }
            if (count == 3)
                return true;
        }
        return false;
    }

    public boolean fullColumn(Player player) {
        for (int col = 0; col < 3; col++) {
            int count = 0;
            for (int row = 0; row < 3; row++) {
                if (player.equals(boardEntries[row][col]))
                    count++;
            }
            if (count == 3)
                return true;
        }
        return false;
    }

    public boolean fullDiagonal(Player player) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (player.equals(boardEntries[i][i]))
                count++;

        }
        if (count == 3) return true;
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (player.equals(boardEntries[i][2 - i]))
                count++;

        }
        return count == 3;
    }
}
