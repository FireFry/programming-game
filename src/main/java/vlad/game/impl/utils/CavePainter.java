package vlad.game.impl.utils;

import com.google.common.base.Preconditions;
import vlad.game.impl.cave.Cave;
import vlad.game.impl.cave.Cell;

/**
 * Utility class that can create a cave from its "sketch".
 * Sketches are drawn with characters. This is an example of such sketch:
 *
 * <pre>
 *     #######
 *     #P    #
 *     ##### #
 *     #  E# #
 *     # ### #
 *     #     #
 *     #######
 * </pre>
 *
 * where
 *
 * <ul>
 *     <li> 'P' means "Player"
 *     <li> '#' means "Wall"
 *     <li> 'E' means "Exit"
 *     <li> any other character means "Empty Cell"
 * </ul>
 */
public final class CavePainter {

    /** A character that represents player */
    private static final char PLAYER = 'P';

    /** A character that represents wall */
    private static final char WALL = '#';

    /** A character that represents exit */
    private static final char EXIT = 'E';

    /**
     * Creates a new cave from sketch.
     */
    public static Cave fromSketch(String... rows) {
        Preconditions.checkArgument(rows.length > 0, "Cannot create a cave from empty sketch");

        // Cave height is amount of given rows
        int height = rows.length;

        // Cave width is the length of any row
        int width = rows[0].length();

        // Check that all rows have the same length
        for (String row : rows) {
            Preconditions.checkArgument(row.length() == width, "Not all rows have the same length");
        }

        // Player position, not found yet
        int px = -1;
        int py = -1;

        // Search for the player
        boolean playerFound = false;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (rows[y].charAt(x) == PLAYER) {
                    // Make sure player was not found before
                    Preconditions.checkState(!playerFound, "Multiple players in cave");

                    // Mark player as found to make sure there is only one player in the cave
                    playerFound = true;

                    // Remember player position
                    px = x;
                    py = y;
                }
            }
        }

        // Make sure player is found.
        Preconditions.checkState(playerFound, "No player in cave");

        // Create a new empty cave.
        Cave cave = new Cave(width, height, px, py);

        // Fill the cave with cells.
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                char ch = rows[y].charAt(x);
                Cell cell = getCellForCharacter(ch);
                cave.setCell(x, y, cell);
            }
        }

        return cave;
    }

    /**
     * Given a character return a cell that it represents.
     */
    private static Cell getCellForCharacter(char ch) {
        switch (ch) {
            case WALL:
                return Cell.WALL;
            case EXIT:
                return Cell.EXIT;
            default: // (any other character)
                return Cell.EMPTY;
        }
    }

}
