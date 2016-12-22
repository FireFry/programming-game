package vlad.proggame.game;

public interface Level<P extends Player> {

    P createPlayer();

}
