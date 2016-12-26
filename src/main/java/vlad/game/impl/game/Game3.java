package vlad.game.impl.game;

import vlad.game.Level3;
import vlad.game.impl.utils.CavePainter;
import vlad.game.impl.cave.Cave;

public class Game3 extends Game {

    public Game3() {
        super(3, new Level3());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.fromSketch(
                "#######",
                "#P....#",
                "#####.#",
                "#..E#.#",
                "#.###.#",
                "#.....#",
                "#######");
    }

}
