package vlad.game;

import vlad.game.impl.app.Level;
import vlad.game.impl.app.Player3;
import vlad.game.impl.app.Player4;

public class Level7 implements Level<Player4> {

    @Override
    public Player4 createPlayer() {
        return new Player4() {

            @Override
            public void play() {
                while (true) {
                    if (canMoveStraight()) {
                        move();
                    } else if (canMoveLeft()) {
                        turnLeft();
                        move();
                    } else if (canMoveRight()) {
                        turnRight();
                        move();
                    }
                }
            }

        };
    }

}
