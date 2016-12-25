package vlad.game;

import vlad.game.impl.app.Level;
import vlad.game.impl.app.Player2;

public class Level3 implements Level<Player2> {

    @Override
    public Player2 createPlayer() {
        return new Player2() {

            @Override
            public void play() {
                moveEast(4);
                moveSouth(4);
                moveWest(4);
                moveNorth(2);
                moveEast(2);
            }

        };
    }

}
