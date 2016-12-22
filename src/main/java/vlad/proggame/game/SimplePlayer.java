package vlad.proggame.game;

public abstract class SimplePlayer implements Player {

    public final void moveNorth() {
        move(AbsoluteDirection.NORTH);
    }

    public final void moveWest() {
        move(AbsoluteDirection.WEST);
    }

    public final void moveSouth() {
        move(AbsoluteDirection.SOUTH);
    }

    public final void moveEast() {
        move(AbsoluteDirection.EAST);
    }

    private void move(AbsoluteDirection direction) {

    }

}
