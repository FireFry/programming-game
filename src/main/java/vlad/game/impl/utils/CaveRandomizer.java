package vlad.game.impl.utils;

import vlad.game.impl.cave.Cave;
import vlad.game.impl.cave.Cell;

import java.util.Random;

public class CaveRandomizer {

    public static Cave random(int width, int height) {
        Random random = new Random();
        int px = random.nextInt(width);
        int py = random.nextInt(height);
        Cave cave = new Cave(width, height, px, py);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (x != px || y != py) {
                    cave.setCell(x, y, random.nextBoolean() ? Cell.WALL : Cell.EMPTY);
                }
            }
        }
        cave.setCell(random.nextInt(width), random.nextInt(height), Cell.EXIT);
        return cave;
    }

}
