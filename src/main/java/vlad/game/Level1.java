package vlad.game;

import vlad.game.impl.core.FirstPlayer.Player;
import vlad.game.impl.core.Level;

/**
 * Hello, this is your first challenge.
 * In this game you control a player by writing Java code.
 * The player has been lost in a mysterious cave.
 * You need to help him find the exit.
 *
 * You can control the player by adding new instruction into the play() method of Player's body.
 * To watch the player movement inside the cave run {@link Application}.
 */
public class Level1 implements Level<Player> {

    /**
     * This method creates a player to challenge the first level of the game.
     */
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
