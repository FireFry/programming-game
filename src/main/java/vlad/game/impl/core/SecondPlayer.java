package vlad.game.impl.core;

import vlad.game.impl.cave.Direction;

public class SecondPlayer {

    public abstract static class Player extends AbstractPlayer {

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

}
