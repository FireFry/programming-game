package vlad.game.impl.app;

import vlad.game.impl.cave.Cell;
import vlad.game.impl.cave.Direction;

public abstract class Player3 extends Player {

    protected final void slideNorth() {
        slide(Direction.NORTH);
    }

    protected final void slideEast() {
        slide(Direction.EAST);
    }

    protected final void slideSouth() {
        slide(Direction.SOUTH);
    }

    protected final void slideWest() {
        slide(Direction.WEST);
    }

    private void slide(Direction direction) {
        while (cave.getCell(cave.getPlayerX() + direction.dx, cave.getPlayerY() + direction.dy) != Cell.WALL) {
            app.onMoveRequested(direction);
        }
    }

}
