package vlad.game.impl;

import com.google.common.base.Preconditions;

public class Cave {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    private int px;
    private int py;

    private boolean gameOver = false;

    public Cave(int width, int height, int px, int py) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                cells[x][y] = Cell.EMPTY;
            }
        }
        setPlayerPosition(px, py);
    }

    private void setPlayerPosition(int x, int y) {
        Preconditions.checkArgument(isValidPosition(x, y));
        Preconditions.checkState(cells[x][y] != Cell.WALL);
        px = x;
        py = y;
    }

    private boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void movePlayer(Direction d) {
        if (gameOver) {
            return;
        }
        int x = px + d.dx;
        int y = py + d.dy;
        Cell cell = getCellSafe(x, y);
        if (cell == Cell.WALL) {
            return;
        }
        setPlayerPosition(x, y);
        if (cell == Cell.EXIT) {
            gameOver = true;
        }
    }

    public void setCell(int x, int y, Cell cell) {
        cells[x][y] = cell;
    }

    public Cell getCellSafe(int x, int y) {
        return isValidPosition(x, y) ? cells[x][y] : Cell.WALL;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPlayerX() {
        return px;
    }

    public int getPlayerY() {
        return py;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
