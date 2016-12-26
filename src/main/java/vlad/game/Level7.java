package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.PlayerD;
import vlad.game.impl.cave.Direction;

/**
 * Ok, it seems that our hero calmed down.
 * While running he lost his compass and forgot all of the directions.
 * Now he can move straight and turn left/right.
 * Try and see if you still can control him.
 */
public class Level7 implements Level<PlayerD> {

    @Override
    public PlayerD createPlayer() {
        return new PlayerD(Direction.EAST) { // <- his initial direction

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
