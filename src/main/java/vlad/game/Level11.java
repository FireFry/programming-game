package vlad.game;

import vlad.game.impl.app.Level;
import vlad.game.impl.app.Player5;
import vlad.game.impl.cave.Direction;

import java.util.List;

public class Level11 implements Level<Player5> {

    @Override
    public Player5 createPlayer() {
        return new Player5() {

            @Override
            protected void play(List<Direction> shortestPath) {
                for (Direction direction : shortestPath) {
                    move(direction);
                }
            }

        };
    }

}
