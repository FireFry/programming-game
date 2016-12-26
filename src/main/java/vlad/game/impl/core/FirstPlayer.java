package vlad.game.impl.core;

import vlad.game.impl.cave.Direction;

public class FirstPlayer {

    public abstract static class Player extends AbstractPlayer {

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

}
