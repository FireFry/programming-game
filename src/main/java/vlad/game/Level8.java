package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.PlayerD;
import vlad.game.impl.cave.Direction;

public class Level8 implements Level<PlayerD> {

    @Override
    public PlayerD createPlayer() {
        return new PlayerD(Direction.WEST) {

            @Override
            public void play() {
                move();
                move();
                move();
                turnLeft();
                move();
                move();
                turnLeft();
                move();
                move();
                turnRight();
                move();
                turnLeft();
                move();
                turnRight();
                move();
                move();
                turnRight();
                move();
                move();
                turnRight();
                move();
                turnLeft();
                move();
            }

        };
    }

}
