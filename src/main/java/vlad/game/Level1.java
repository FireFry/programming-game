package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.PlayerA;

/**
 * Hello, this is your first challenge.
 * In this game you control a player by writing Java code.
 * The player has been lost in a mysterious cave.
 * You need to help him find the exit.
 *
 * You can control the player by adding new instruction into the play() method of Player's body.
 * To watch the player movement inside the cave run {@link Application}.
 */
public class Level1 implements Level<PlayerA> {

    /**
     * This method creates a player to challenge the first level of the game.
     */
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
