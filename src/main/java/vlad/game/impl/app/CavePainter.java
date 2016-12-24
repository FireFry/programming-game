package vlad.game.impl.app;

import com.google.common.base.Preconditions;
import vlad.game.impl.cave.Cave;
import vlad.game.impl.cave.Cell;

public class CavePainter {

    public static Cave paint(String... rows) {
        int height = rows.length;
        int width = rows[0].length();
        boolean playerFound = false;
        int px = -1;
        int py = -1;
        for (int y = 0; y < height; y++) {
            Preconditions.checkArgument(rows[y].length() == width);
            for (int x = 0; x < width; x++) {
                if (rows[y].charAt(x) == 'P') {
                    Preconditions.checkState(!playerFound);
                    playerFound = true;
                    px = x;
                    py = y;
                }
            }
        }
        Preconditions.checkState(playerFound);
        Cave cave = new Cave(width, height, px, py);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Cell cell;
                switch (rows[y].charAt(x)) {
                    case '#':
                        cell = Cell.WALL;
                        break;
                    case 'E':
                        cell = Cell.EXIT;
                        break;
                    default:
                        cell = Cell.EMPTY;
                }
                cave.setCell(x, y, cell);
            }
        }
        return cave;
    }

}
