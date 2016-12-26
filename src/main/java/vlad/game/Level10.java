package vlad.game;

import vlad.game.impl.cave.Direction;
import vlad.game.impl.core.ForthPlayer.Player;
import vlad.game.impl.core.Level;

/**
 * Unbelievable! You passed the previous level! Did you enjoy your solution?
 * How many lines of code would it take if you put down instructions for each individual movement?
 * Lets now teach our player to find exit of any maze!
 */
public class Level10 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player(Direction.EAST) {

            /**
             * Available instructions:
             * canMoveStraight();
             * move();
             * canMoveLeft();
             * turnLeft();
             * canMoveRight();
             * turnRight();
             */
            @Override
            public void play() {
                // Same here, apply the same reasoning to each movement in a loop
                while (true) {
                    // Did you know that you can get out of any maze just by keeping your hand in contact with the wall?
                    // You don't believe me, ha? Here is a link, check it by yourself:
                    // https://en.wikipedia.org/wiki/Maze_solving_algorithm#Wall_follower
                    //
                    // You can apply this knowledge to pass this level.
                    // Imagine you've put your left hand on the wall.
                    // You make a step.
                    //
                    // If there is no longer a wall to the left, you turn left and make a step.
                    // Now your left hand is on the wall again (think why?).
                    //
                    // If you're suddenly facing a wall, you turn right and now the wall is on the left!
                    //
                    // Try applying this simple rules to create a universal algorithm to get out of any maze.

                }
            }

        };
    }

}
