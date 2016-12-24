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
                    move(Direction.values()[random.nextInt(Direction.values().length)]);
                }
            }
        };
        new Application(CaveRandomizer.random(10, 10), player).start();
    }

}
