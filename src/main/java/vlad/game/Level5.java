package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.ThirdPlayer.Player;

/**
 * Well done! Your success inspired our hero so much he suddenly broke into a run.
 * Now he is not capable of controlling his speed, only walls can stop his movement.
 * Are you still able to help him?
 */
public class Level5 implements Level<Player> {

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
