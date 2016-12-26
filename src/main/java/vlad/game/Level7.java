package vlad.game;

import vlad.game.impl.cave.Direction;
import vlad.game.impl.core.ForthPlayer.Player;
import vlad.game.impl.core.Level;

/**
 * Ok, it seems that our hero calmed down.
 * While running he lost his compass and forgot all of the directions.
 * Now he can move towards the direction he is facing and also change his direction by turning left and right.
 * Try and see if you still can control him.
 */
public class Level7 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player(Direction.EAST) { // <- his initial direction

            /**
             * Available instructions:
             * move();
             * turnLeft();
             * turnRight();
             */
            @Override
            public void play() {
                // Add your instructions after this line:
                move();

            }

        };
    }

}
