package vlad.game.impl.core;

import vlad.game.impl.cave.Cell;
import vlad.game.impl.cave.Direction;

public class ThirdPlayer {

    public abstract static class Player extends AbstractPlayer {

        protected final void runNorth() {
            run(Direction.NORTH);
        }

        protected final void runEast() {
            run(Direction.EAST);
        }

        protected final void runSouth() {
            run(Direction.SOUTH);
        }

        protected final void runWest() {
            run(Direction.WEST);
        }

        private void run(Direction direction) {
            while (cave.getCell(cave.getPlayerX() + direction.dx, cave.getPlayerY() + direction.dy) != Cell.WALL) {
                app.onMoveRequested(direction);
            }
        }

    }

}
