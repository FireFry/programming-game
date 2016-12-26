package vlad.game;

import vlad.game.impl.cave.Direction;
import vlad.game.impl.core.FifthPlayer.Player;
import vlad.game.impl.core.Level;

import java.util.List;

/**
 * Wow! You reached you last level, and it is enormous.
 * Luckily your during this journey your player learned how to quickly find a way out of any maze.
 * So this time he knows the way. Your task is to simply follow it.
 */
public class Level11 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player() {

            /**
             * Available instructions:
             * move(direction);
             */
            @Override
            protected void play(List<Direction> shortestPath) {
                // You are given a list of directions you need to follow to exit the maze.
                // Just refresh your knowledge on how to iterate through lists and follow the given path.

            }

        };
    }

}
