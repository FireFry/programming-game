package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.PlayerB;

/**
 * Very impressive! The caves indeed become trickier. Let's see if you can pass this one...
 */
public class Level4 implements Level<PlayerB> {

    @Override
    public PlayerB createPlayer() {
        return new PlayerB() {

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
