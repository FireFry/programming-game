package vlad.game.impl.app;

import vlad.game.impl.cave.Direction;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Player player = new Player() {
            private final Random random = new Random();

            @Override
            public void play() {
                while (true) {
                    app.onMoveRequested(Direction.values()[random.nextInt(Direction.values().length)]);
                }
            }
        };
        new GameController(0, CaveRandomizer.random(3, 3), player).start();
    }

}
