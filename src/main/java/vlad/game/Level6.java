package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.ThirdPlayer.Player;

/**
 * Incredible! You are so good at this!
 * However, this level is much harder than the previous one.
 */
public class Level6 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player() {

            /**
             * Available instructions:
             * runNorth();
             * runEast();
             * runSouth();
             * runWest();
             */
            @Override
            public void play() {
                // Add your instructions after this line:
                runNorth();

            }

        };
    }

}
