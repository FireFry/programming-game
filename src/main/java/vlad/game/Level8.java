package vlad.game;

import vlad.game.impl.cave.Direction;
import vlad.game.impl.core.ForthPlayer.Player;
import vlad.game.impl.core.Level;

/**
 * Amazing! Nothing can stop you. You must really hate these caves.
 * Bad news! You are stuck in this cave forever. Or aren't you?
 */
public class Level8 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player(Direction.WEST) {

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
