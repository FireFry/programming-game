package vlad.game.impl.core;

public interface Level<P extends AbstractPlayer> {

    P createPlayer();

}
