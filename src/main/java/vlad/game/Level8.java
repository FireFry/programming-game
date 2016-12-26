package vlad.game;

import vlad.game.impl.cave.Direction;
import vlad.game.impl.core.ForthPlayer.Player;
import vlad.game.impl.core.Level;

public class Level8 implements Level<Player> {

    @Override
    public Player createPlayer() {
        return new Player(Direction.WEST) {

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
