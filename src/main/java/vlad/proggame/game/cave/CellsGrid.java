package vlad.proggame.game.cave;

import com.google.common.base.Preconditions;

public class CellsGrid {
    private final int width;
    private final int height;
    private final Cell[][] cells;

    public CellsGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = createArrayOfEmptyCells(width, height);
    }

    private static Cell[][] createArrayOfEmptyCells(int width, int height) {
        Cell[][] array = new Cell[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                array[x][y] = EmptyCell.INSTANCE;
            }
        }
        return array;
    }

    public Cell get(int x, int y) {
        return containsPosition(x, y) ? cells[x][y] : Wall.INSTANCE;
    }

    public void set(int x, int y, Cell cell) {
        Preconditions.checkArgument(containsPosition(x, y), "position (%d, %d) is outside of this grid", x, y);
        Preconditions.checkNotNull(cell, "cell is null");
        cells[x][y] = cell;
    }

    public boolean containsPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
