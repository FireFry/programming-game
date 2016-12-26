package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.Player1;

public class Level2 implements Level<Player1> {

    @Override
    public Player1 createPlayer() {
        return new Player1() {

            @Override
            public void play() {
                moveEast();
                moveSouth();
                moveEast();
                moveEast();
                moveNorth();
                moveEast();
            }

        };
    }

}
