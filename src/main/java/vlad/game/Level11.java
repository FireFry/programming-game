package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.PlayerE;
import vlad.game.impl.cave.Direction;

import java.util.List;

public class Level11 implements Level<PlayerE> {

    @Override
    public PlayerE createPlayer() {
        return new PlayerE() {

            @Override
            protected void play(List<Direction> shortestPath) {
                for (Direction direction : shortestPath) {
                    move(direction);
                }
            }

        };
    }

}
