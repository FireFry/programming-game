package vlad.game;

import vlad.game.impl.cave.Direction;
import vlad.game.impl.core.FifthPlayer.Player;
import vlad.game.impl.core.Level;

import java.util.List;

public class Level11 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player() {

            @Override
            protected void play(List<Direction> shortestPath) {
                for (Direction direction : shortestPath) {
                    move(direction);
                }
            }

        };
    }

}
