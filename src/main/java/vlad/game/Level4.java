package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.SecondPlayer.Player;

/**
 * Very impressive! The caves indeed become trickier. Let's see if you can pass this one...
 */
public class Level4 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player() {

            /**
             * Available instructions:
             * moveNorth(steps);
             * moveEast(steps);
             * moveSouth(steps);
             * moveWest(steps);
             */
            @Override
            public void play() {
                // Add your instructions after this line:
                moveEast(3);

            }

        };
    }

}
