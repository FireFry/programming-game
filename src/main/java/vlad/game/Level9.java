package vlad.game;

import vlad.game.impl.cave.Direction;
import vlad.game.impl.core.ForthPlayer.Player;
import vlad.game.impl.core.Level;

public class Level9 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player(Direction.EAST) {

            @Override
            public void play() {
                while (true) {
                    if (!canMoveStraight()) {
                        if (canMoveLeft()) {
                            turnLeft();
                        } else {
                            turnRight();
                        }
                    }
                    move();
                }
            }

        };
    }

}
