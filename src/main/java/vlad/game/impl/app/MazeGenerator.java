package vlad.game.impl.app;

import vlad.game.impl.cave.Cave;
import vlad.game.impl.cave.Cell;
import vlad.game.impl.cave.Direction;

import java.util.Random;

public final class MazeGenerator {

    private final int width;
    private final int height;
    private final Random random;

    private Cave cave = null;

    public MazeGenerator(int width, int height, Random random) {
        this.width = width;
        this.height = height;
        this.random = random;
    }

    public Cave generate() {
        if (cave != null) {
            return cave;
        }
        cave = new Cave(width, height, 0, 0);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x != cave.getPlayerX() || y != cave.getPlayerY()) {
                    cave.setCell(x, y, Cell.WALL);
                }
            }
        }
        visit(cave.getPlayerX(), cave.getPlayerY());
        ExitLoop:
        for (int y = height - 1; y >= 0; y--) {
            for (int x = width - 1; x >= 0; x--) {
                if (cave.getCell(x, y) == Cell.EMPTY && !(x == cave.getPlayerX() && y == cave.getPlayerY())) {
                    cave.setCell(x, y, Cell.EXIT);
                    break ExitLoop;
                }
            }
        }
        return cave;
    }

    private void visit(int x, int y) {
        for (int t = 0; t < 10; t++) {
            Direction direction = Direction.values()[random.nextInt(Direction.values().length)];
            int cx = x + direction.dx;
            int cy = y + direction.dy;
            if (cave.hasCell(cx, cy) && cave.getCell(cx, cy) == Cell.WALL) {
                int notWalls = 0;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (dx != 0 || dy != 0) {
                            if (cave.getCell(cx + dx, cy + dy) != Cell.WALL) {
                                notWalls++;
                            }
                        }
                    }
                }
                if (notWalls <= 2) {
                    cave.setCell(cx, cy, Cell.EMPTY);
                    visit(cx, cy);
                }
            }
        }
    }

}
