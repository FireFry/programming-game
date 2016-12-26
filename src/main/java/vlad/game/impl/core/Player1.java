package vlad.game.impl.core;

import vlad.game.impl.cave.Direction;

public abstract class Player1 extends Player {

    protected final void moveNorth() {
        move(Direction.NORTH);
    }

    protected final void moveEast() {
        move(Direction.EAST);
    }

    protected final void moveSouth() {
        move(Direction.SOUTH);
    }

    protected final void moveWest() {
        move(Direction.WEST);
    }

    private void move(Direction direction) {
        app.onMoveRequested(direction);
    }

}
