package vlad.proggame.game;

import com.google.common.base.Preconditions;
import vlad.proggame.game.cave.Cave;

public abstract class Player {

    Cave cave = null;

    void enter(Cave cave) {
        Preconditions.checkState(cave == null, "Already entered");
        this.cave = cave;
        run();
    }

    abstract void run();

}
