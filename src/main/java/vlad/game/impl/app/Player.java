package vlad.game.impl.app;

import vlad.game.impl.cave.Cave;

public abstract class Player {

    GameController app = null;
    Cave cave;

    void attach(GameController app) {
        this.app = app;
        this.cave = app.getCave();
    }

    public abstract void play();

}
