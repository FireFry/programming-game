package vlad.game.impl.game;

import vlad.game.impl.app.GameController;
import vlad.game.impl.app.Level;
import vlad.game.impl.cave.Cave;

public abstract class Game {

    private final GameController gameController;

    protected Game(int id, Level level) {
        this.gameController = new GameController(id, createCave(), level.createPlayer());
    }

    protected abstract Cave createCave();

    public final void play() {
        gameController.start();
    }

    public boolean isPassed() {
        return gameController.isPassed();
    }
}
