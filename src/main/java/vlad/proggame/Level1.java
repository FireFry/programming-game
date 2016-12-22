package vlad.proggame;

import vlad.proggame.game.Level;
import vlad.proggame.game.SimplePlayer;

public class Level1 implements Level<SimplePlayer> {
    public SimplePlayer createPlayer() {
        return new SimplePlayer() {

            @Override
            public void play() {
                // Add player movements after this line
                // moveEast();
            }

        };
    }
}
