package vlad.game.impl.app;

import vlad.game.impl.cave.Direction;

public abstract class Player {

    private Application app = null;

    void attach(Application app) {
        this.app = app;
    }

    public abstract void play();

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

    protected final void move(Direction direction) {
        app.onMoveRequested(direction);
    }

}
