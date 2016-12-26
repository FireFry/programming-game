package vlad.game;

import vlad.game.impl.core.Level;
import vlad.game.impl.core.PlayerD;
import vlad.game.impl.cave.Direction;

public class Level10 implements Level<PlayerD> {

    @Override
    public PlayerD createPlayer() {
        return new PlayerD(Direction.EAST) {

            @Override
            public void play() {
                while (true) {
                    if (canMoveLeft()) {
                        turnLeft();
                    } else if (!canMoveStraight()) {
                        turnRight();
                    }
                    move();
                }
            }

        };
    }

}
