package vlad.proggame.game;

import com.google.common.base.Preconditions;
import vlad.proggame.game.cave.Cave;
import vlad.proggame.game.cave.EmptyCell;
import vlad.proggame.game.cave.Exit;
import vlad.proggame.game.cave.Wall;

public class CaveSketch {

    public final static char PLAYER = 'P';
    public final static char EXIT = 'E';
    public final static char WALL = '#';
    public final static char EMPTY_CELL = '.';

    public static Cave.CaveBuilder draw(String... rows) {
        Preconditions.checkArgument(rows.length > 0, "Empty rows array");
        int height = rows.length;
        int width = rows[0].length();
        for (int i = 1; i < height; i++) {
            Preconditions.checkArgument(rows[i].length() == width, "Inconsistent width");
        }
        Cave.CaveBuilder caveBuilder = Cave.builder(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                char ch = rows[y].charAt(x);
                switch (ch) {
                    case 'P':
                        caveBuilder.setPlayerPosition(x, y);
                        break;
                    case '#':
                        caveBuilder.setCell(x, y, Wall.INSTANCE);
                        break;
                    case '.':
                        caveBuilder.setCell(x, y, EmptyCell.INSTANCE);
                        break;
                    case 'E':
                        caveBuilder.setCell(x, y, Exit.INSTANCE);
                        break;
                    default:
                        throw new IllegalArgumentException("Unrecognized char: '" + ch + "'");
                }
            }
        }
        return caveBuilder;
    }

}
