package vlad.game.impl.app;

public interface Level<P extends Player> {

    P createPlayer();

}
