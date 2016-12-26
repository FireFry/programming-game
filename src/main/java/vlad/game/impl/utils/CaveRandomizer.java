package vlad.game.impl.utils;

import vlad.game.impl.cave.Cave;
import vlad.game.impl.cave.Cell;

import java.util.Random;

/**
 * Utility that creates caves with randomly generated cells.
 */
public final class CaveRandomizer {

    /**
     * Given a random number generator creates and randomly fills a cave that has provided size.
     */
    public static Cave random(Random random, int width, int height) {
        // Player position in cave
        int px = random.nextInt(width);
        int py = random.nextInt(height);

        // Create new empty cave
        Cave cave = new Cave(width, height, px, py);

        // Iterate thought each cell
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // If this cell is not occupied by player
                if (x != px || y != py) {
                    // Randomly choose either wall or empty cell and put it into (x, y) position
                    cave.setCell(x, y, random.nextBoolean() ? Cell.WALL : Cell.EMPTY);
                }
            }
        }
        return cave;
    }

}
