package vlad.game.impl.utils;

import vlad.game.impl.cave.Cave;
import vlad.game.impl.cave.Cell;
import vlad.game.impl.cave.Direction;

import java.util.Random;

/**
 * Utility that generates random mazes.
 */
public final class MazeGenerator {

    /** Wall is considered good for drilling if it has an least this amount of wall cells it */
    private static final int ADJACENT_WALLS_TO_DRILL = 6;

    private final int width;
    private final int height;
    private final Random random;
    private final int attempts;

    /** Generated cave, initially absent */
    private Cave cave = null;

    public MazeGenerator(Random random, int width, int height, int attempts) {
        this.width = width;
        this.height = height;
        this.random = random;
        this.attempts = attempts;
    }

    /**
     * Creates and returns a random maze.
     */
    public Cave generate() {
        // Return the cave if it has already been generated
        if (cave != null) {
            return cave;
        }

        // Create a new empty cave with the player in top left corner
        cave = new Cave(width, height, 0, 0);

        // Put walls everywhere except where player stands
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (!cave.isPlayerPosition(x, y)) {
                    cave.setCell(x, y, Cell.WALL);
                }
            }
        }

        // Start "drilling" walls from where player stands
        drillMaze(cave.getPlayerX(), cave.getPlayerY());

        // We have "drilled" a random paths in the maze
        // Now we need to add an exit cell
        addExitCell();

        return cave;
    }

    /**
     * Given a position inside the cave this method randomly picks a neighbour wall,
     * destroys it and repeats the same inside the new empty cell.
     * As a result a structure of maze-like paths is generated.
     */
    private void drillMaze(int x, int y) {
        // Make random attempts to find and destroy neighbour wall.
        for (int t = 0; t < attempts; t++) {

            // Get random direction
            int directionsCount = Direction.values().length;
            int randomIndex = random.nextInt(directionsCount);
            Direction randomDirection = Direction.values()[randomIndex];

            // Neighbour cell position
            int nx = x + randomDirection.dx;
            int ny = y + randomDirection.dy;

            // If neighbour cell is inside cave and is occupied by wall
            if (cave.hasCell(nx, ny) && cave.getCell(nx, ny) == Cell.WALL) {
                // Count adjacent walls and make sure the amount is not too small
                if (adjacentWalls(nx, ny) >= ADJACENT_WALLS_TO_DRILL) {
                    // Destroy the wall
                    cave.setCell(nx, ny, Cell.EMPTY);
                    // Continue drilling from the new cell
                    drillMaze(nx, ny);
                }
            }
        }
    }

    /**
     * Calculates the amount of walls that are adjacent with provided position.
     */
    private int adjacentWalls(int x, int y) {
        // Initialize walls counter to zero
        int walls = 0;
        // Look at all adjacent position from (-1, -1) to (+1, +1) skipping (0, 0)
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    // If the cell is wall, increase walls counter
                    if (cave.getCell(x + dx, y + dy) == Cell.WALL) {
                        walls++;
                    }
                }
            }
        }
        return walls;
    }

    /**
     * Simply iterates through cells starting from bottom right corner and searches for an empty cell to make it exit.
     */
    private void addExitCell() {
        for (int y = height - 1; y >= 0; y--) {
            for (int x = width - 1; x >= 0; x--) {
                if (cave.getCell(x, y) == Cell.EMPTY && !cave.isPlayerPosition(x, y)) {
                    cave.setCell(x, y, Cell.EXIT);
                    return;
                }
            }
        }
    }

}
