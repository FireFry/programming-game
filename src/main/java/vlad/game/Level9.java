package vlad.game;

import vlad.game.impl.cave.Direction;
import vlad.game.impl.core.ForthPlayer.Player;
import vlad.game.impl.core.Level;

/**
 * Man, this is too much! You aren't going to put all of these instructions by hands, are you?
 * Lets be smarter on this one. As you can see the path doesn't spit into multiple branches.
 * All you really need to is just follow it.
 */
public class Level9 implements Level<Player> {

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
                // Lets apply the same algorithm on each step inside this unlimited loop
                while (true) {
                    // All you need to do is just to follow the path.
                    // Can you think about your actions if you want to follow a path in the real life?
                    // I'll give you a hint.
                    //
                    // If you can move straight, you just want to move straight.
                    // If you're facing a wall, and therefore cannot move straight,
                    // you might want to check if you can move left or right.
                    // I guarantee that you will find that you can move in one of these directions.
                    //
                    // Pay attention to the new instructions and write a short program to follow the path.

                }
            }

        };
    }

}
