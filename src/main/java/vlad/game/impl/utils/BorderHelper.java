package vlad.game.impl.utils;

import com.google.common.base.Preconditions;
import vlad.game.impl.cave.Cave;

/**
 * Utility class that helps to surround existing cave with additional border of walls.
 */
public final class BorderHelper {

    /**
     * Shortcut for {@code withBorder(cave, 1)}
     *
     * @see BorderHelper#withBorder(Cave, int)
     */
    public static Cave withBorder(Cave cave) {
        return withBorder(cave, 1);
    }

    /**
     * Creates a copy of the given cave that is surrounded with border of wall blocks.
     *
     * <p>For example given the following cave and thickness 1:
     *
     * <pre>
     *     P.#.E
     *     #...#
     * </pre>
     *
     * the result of this method will be:
     *
     * <pre>
     *     #######
     *     #P.#.E#
     *     ##...##
     *     #######
     * </pre>
     */
    public static Cave withBorder(Cave cave, int thickness) {
        Preconditions.checkNotNull(cave);
        Preconditions.checkArgument(thickness >= 0);

        // Add thickness two times, because walls are added to each size of the cave
        int newWidth = cave.getWidth() + thickness * 2;
        int newHeight = cave.getHeight() + thickness * 2;

        // Player position is shifted by thickness
        int newPlayerX = cave.getPlayerX() + thickness;
        int newPlayerY = cave.getPlayerY() + thickness;

        Cave newCave = new Cave(newWidth, newHeight, newPlayerX, newPlayerY);
        for (int x = 0; x < newCave.getWidth(); x++) {
            for (int y = 0; y < newCave.getHeight(); y++) {
                // Position in the given cave that corresponds to (x, y) in new cave
                int oldX = x - thickness;
                int oldY = y - thickness;

                // Copy cell from given cave
                // If (oldX, oldY) position is outside of the cave, getCell method will return WALL
                newCave.setCell(x, y, cave.getCell(oldX, oldY));
            }
        }
        return newCave;
    }

}
