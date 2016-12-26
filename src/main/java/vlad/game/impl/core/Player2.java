package vlad.game.impl.core;

import vlad.game.impl.cave.Direction;

public abstract class Player2 extends Player {

    protected final void moveNorth(int steps) {
        move(Direction.NORTH, steps);
    }

    protected final void moveEast(int steps) {
        move(Direction.EAST, steps);
    }

    protected final void moveSouth(int steps) {
        move(Direction.SOUTH, steps);
    }

    protected final void moveWest(int steps) {
        move(Direction.WEST, steps);
    }

    private void move(Direction direction, int steps) {
        for (int i = 0; i < steps; i++) {
            app.onMoveRequested(direction);
        }
    }

}
