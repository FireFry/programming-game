package vlad.game.impl.core;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import vlad.game.impl.cave.Cell;
import vlad.game.impl.cave.Direction;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Player5 extends Player {

    @Override
    void attach(GameController app) {
        super.attach(app);
    }

    @Override
    public final void play() {
        boolean[][] visited = new boolean[cave.getWidth()][cave.getHeight()];
        Queue<Step> queue = new LinkedList<>();
        visited[cave.getPlayerX()][cave.getPlayerY()] = true;
        queue.add(new Step(null, cave.getPlayerX(), cave.getPlayerY(), null));
        List<Direction> shortestPath = null;
        while (!queue.isEmpty()) {
            Step step = queue.poll();
            if (cave.getCell(step.x, step.y) == Cell.EXIT) {
                List<Direction> backwardPath = new ArrayList<>();
                while (step.direction != null) {
                    backwardPath.add(step.direction);
                    step = step.prev;
                }
                shortestPath = Lists.reverse(backwardPath);
                break;
            }
            for (Direction direction : Direction.values()) {
                int nx = step.x + direction.dx;
                int ny = step.y + direction.dy;
                if (cave.getCell(nx, ny) != Cell.WALL && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Step(step, nx, ny, direction));
                }
            }
        }
        Preconditions.checkState(shortestPath != null);
        play(shortestPath);
    }

    protected abstract void play(List<Direction> shortestPath);

    protected final void move(Direction direction) {
        app.onMoveRequested(direction);
    }

    private static final class Step {
        private final Step prev;
        private final int x;
        private final int y;
        private final Direction direction;

        private Step(Step prev, int x, int y, Direction direction) {
            this.prev = prev;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }
}
