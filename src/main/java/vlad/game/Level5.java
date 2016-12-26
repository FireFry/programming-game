package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.Player3;

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
