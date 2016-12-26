package vlad.game.impl.game;

import vlad.game.impl.core.GameController;
import vlad.game.impl.core.Level;
import vlad.game.impl.cave.Cave;

/**
 * Abstract superclass for all games.
 */
public abstract class Game {

    private final GameController gameController;

    protected Game(int id, Level level) {
        this.gameController = new GameController(id, createCave(), level.createPlayer());
    }

    protected abstract Cave createCave();

    public final void play() {
        gameController.start();
    }

    public final boolean isPassed() {
        return gameController.isPassed();
    }
}
