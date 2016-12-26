package vlad.game.impl.cave;

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

        this.px = px;
        this.py = py;
    }

    private void setPlayerPosition(int x, int y) {
        Preconditions.checkArgument(hasCell(x, y));
        Preconditions.checkState(cells[x][y] != Cell.WALL);
        this.px = x;
        this.py = y;
    }

    public boolean hasCell(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }

    public void movePlayer(Direction d) {
        if (gameOver) {
            return;
        }
        int x = px + d.dx;
        int y = py + d.dy;
        Cell cell = getCell(x, y);
        if (cell == Cell.WALL) {
            return;
        }
        setPlayerPosition(x, y);
        if (cell == Cell.EXIT) {
            gameOver = true;
        }
    }

    public void setCell(int x, int y, Cell cell) {
        Preconditions.checkState(!(cell == Cell.WALL && px == x && py == y));
        cells[x][y] = cell;
    }

    public Cell getCell(int x, int y) {
        return hasCell(x, y) ? cells[x][y] : Cell.WALL;
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

    public boolean isPlayerPosition(int x, int y) {
        return px == x && py == y;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
