package vlad.game.impl.cave;

/**
 * Cave cell can be one of the following kind.
 */
public enum Cell {
    /**
     * Empty cell is available for player to stand in.
     */
    EMPTY,

    /**
     * A solid cell that blocks player movement.
     */
    WALL,

    /**
     * Exit from cave. Enter this cell to win the game.
     */
    EXIT,
}
