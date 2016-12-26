package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.SecondPlayer.Player;

/**
 * Hm... This cave is a bit larger than the previous one.
 * Suddenly your hero grew stronger! Now he can make multiple steps by only one instruction.
 * Just specify the amount of steps you want him to make as an argument to the familiar methods.
 */
public class Level3 implements Level<Player> {

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
