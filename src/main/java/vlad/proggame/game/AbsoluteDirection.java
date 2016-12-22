package vlad.proggame.game;

public enum AbsoluteDirection {
    NORTH(1, 0),
    WEST(-1, 0),
    SOUTH(1, 0),
    EAST(-1, 0);

    private final int dx;
    private final int dy;

    AbsoluteDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
