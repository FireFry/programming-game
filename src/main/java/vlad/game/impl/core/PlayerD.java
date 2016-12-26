package vlad.game.impl.core;

import vlad.game.impl.cave.Cell;
import vlad.game.impl.cave.Direction;

public abstract class PlayerD extends Player {

    private Direction direction;

    public PlayerD(Direction initialDirection) {
        direction = initialDirection;
    }

    protected final boolean canMoveStraight() {
        return canMove(direction);
    }

    protected final boolean canMoveLeft() {
        return canMove(left(direction));
    }

    protected final boolean canMoveRight() {
        return canMove(right(direction));
    }

    protected final void turnLeft() {
        direction = left(direction);
    }

    protected final void turnRight() {
        direction = right(direction);
    }

    protected final void move() {
        app.onMoveRequested(direction);
    }

    private boolean canMove(Direction direction) {
        return cave.getCell(cave.getPlayerX() + direction.dx, cave.getPlayerY() + direction.dy) != Cell.WALL;
    }

    private Direction left(Direction direction) {
        switch (direction) {
            case EAST:
                return Direction.NORTH;
            case NORTH:
                return Direction.WEST;
            case WEST:
                return Direction.SOUTH;
            case SOUTH:
                return Direction.EAST;
            default:
                throw new AssertionError();
        }
    }

    private Direction right(Direction direction) {
        switch (direction) {
            case EAST:
                return Direction.SOUTH;
            case NORTH:
                return Direction.EAST;
            case WEST:
                return Direction.NORTH;
            case SOUTH:
                return Direction.WEST;
            default:
                throw new AssertionError();
        }
    }

}
