package vlad.proggame.game.cave;

import com.google.common.base.Preconditions;

public class Cave {
    private final CellsGrid cells;
    private int playerX;
    private int playerY;

    public Cave(CellsGrid cells, int initialPlayerX, int initialPlayerY) {
        this.cells = cells;
        setPlayerPosition(initialPlayerX, initialPlayerY);
    }

    private void setPlayerPosition(int x, int y) {
        Preconditions.checkArgument(!cells.getCell(x, y).blocksMovement(), "Cannot put player at (%d, %d)", x, y);
        this.playerX = x;
        this.playerY = y;
    }

    public static CaveBuilder builder(int width, int height) {
        return new CaveBuilder(width, height);
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
            cells.setCell(x, y, cell);
        }

        public Cave build() {
            return new Cave(cells, playerX, playerY);
        }
    }
}
