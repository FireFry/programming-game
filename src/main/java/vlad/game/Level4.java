package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.Player2;

public class Level4 implements Level<Player2> {

    @Override
    public Player2 createPlayer() {
        return new Player2() {

            @Override
            public void play() {
                moveEast(3);
                moveSouth(2);
                moveEast(1);
                moveSouth(2);
                moveWest(3);
            }

        };
    }

}
