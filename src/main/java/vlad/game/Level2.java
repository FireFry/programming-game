package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.PlayerA;

/**
 * Well done! You passed to the level 2!
 */
public class Level2 implements Level<PlayerA> {

    @Override
    public PlayerA createPlayer() {
        return new PlayerA() {

            /**
             * Available instructions:
             * moveNorth();
             * moveEast();
             * moveSouth();
             * moveWest();
             */
            @Override
            public void play() {
                // Add your instructions after this line:
                moveEast();

            }

        };
    }

}
