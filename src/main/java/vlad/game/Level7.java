package vlad.game;

import vlad.game.impl.app.Level;
import vlad.game.impl.app.Player4;
import vlad.game.impl.cave.Direction;

public class Level7 implements Level<Player4> {

    @Override
    public Player4 createPlayer() {
        return new Player4(Direction.EAST) {

            @Override
            public void play() {
                move();
                turnRight();
                move();
                turnLeft();
                move();
                move();
                turnLeft();
                move();
            }

        };
    }

}
