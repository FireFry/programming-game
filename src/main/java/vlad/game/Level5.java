package vlad.game;

import vlad.game.impl.app.Level;
import vlad.game.impl.app.Player2;
import vlad.game.impl.app.Player3;

public class Level5 implements Level<Player3> {

    @Override
    public Player3 createPlayer() {
        return new Player3() {

            @Override
            public void play() {
                slideEast();
                slideSouth();
                slideWest();
                slideNorth();
            }

        };
    }

}
