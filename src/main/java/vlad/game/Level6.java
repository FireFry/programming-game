package vlad.game;

import vlad.game.impl.app.Level;
import vlad.game.impl.app.Player3;

public class Level6 implements Level<Player3> {

    @Override
    public Player3 createPlayer() {
        return new Player3() {

            @Override
            public void play() {
                slideEast();
                slideNorth();
                slideEast();
                slideSouth();
                slideWest();
                slideSouth();
                slideEast();
                slideNorth();
                slideWest();
            }

        };
    }

}
