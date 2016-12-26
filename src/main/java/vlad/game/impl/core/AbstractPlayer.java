package vlad.game.impl.core;

import vlad.game.impl.cave.Cave;

public abstract class AbstractPlayer {

    GameController app = null;
    Cave cave;

    void attach(GameController app) {
        this.app = app;
        this.cave = app.getCave();
    }

    public abstract void play();

}
