package vlad.game;

import vlad.game.impl.core.FirstPlayer.Player;
import vlad.game.impl.core.Level;

/**
 * Well done! You passed to the level 2!
 */
public class Level2 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player() {

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
