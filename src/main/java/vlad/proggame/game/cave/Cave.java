package vlad.proggame.game.cave;

import com.google.common.base.Preconditions;

public class Cave {
    private final CellsGrid cells;
    private int playerX;
    private int playerY;
    private boolean gameOver = false;

    public Cave(CellsGrid cells, int initialPlayerX, int initialPlayerY) {
        this.cells = cells;
        setPlayerPosition(initialPlayerX, initialPlayerY);
    }

    private void setPlayerPosition(int x, int y) {
        Preconditions.checkArgument(!cells.get(x, y).blocksMovement(), "Cannot put player at (%d, %d)", x, y);
        this.playerX = x;
        this.playerY = y;
    }

    public void movePlayer(int dx, int dy) {
        if (gameOver) {
            return;
        }
        Cell cell = cells.get(dx, dy);
        if (cell.blocksMovement()) {
            return;
        }
        playerX += dx;
        playerY += dy;
        cell.onPlayerEntered(this);
    }

    public static CaveBuilder builder(int width, int height) {
        return new CaveBuilder(width, height);
    }

    void onExitEntered() {
        win();
    }

    private void win() {
        gameOver = true;
    }

    public static class CaveBuilder {
        private final CellsGrid cells;
        private int playerX;
        private int playerY;

        private CaveBuilder(int width, int height) {
            this.cells = new CellsGrid(width, height);
        }

        public CaveBuilder setPlayerPosition(int x, int y) {
            this.playerX = x;
            this.playerY = y;
            return this;
        }

        public void setCell(int x, int y, Cell cell) {
            cells.set(x, y, cell);
        }

        public Cave build() {
            return new Cave(cells, playerX, playerY);
        }
    }
}
