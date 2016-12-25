package vlad.game.impl.app;

import vlad.game.impl.cave.Cave;
import vlad.game.impl.cave.Cell;

public class BorderHelper {

    public static Cave withBorder(Cave cave) {
        return withBorder(cave, 1, 1);
    }

    public static Cave withBorder(Cave cave, int bx, int by) {
        Cave borderedCave = new Cave(cave.getWidth() + bx * 2, cave.getHeight() + by * 2, cave.getPlayerX() + bx, cave.getPlayerY() + by);
        for (int x = 0; x < borderedCave.getWidth(); x++) {
            for (int y = 0; y < borderedCave.getHeight(); y++) {
                int cx = x - bx;
                int cy = y - by;
                if (cx >= 0 && cx < cave.getWidth() && cy >= 0 && cy < cave.getHeight()) {
                    borderedCave.setCell(x, y, cave.getCell(cx, cy));
                } else {
                    borderedCave.setCell(x, y, Cell.WALL);
                }
            }
        }
        return borderedCave;
    }

}
