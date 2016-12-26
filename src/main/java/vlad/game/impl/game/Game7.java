package vlad.game.impl.game;

import vlad.game.Level7;
import vlad.game.impl.utils.CavePainter;
import vlad.game.impl.cave.Cave;

public class Game7 extends Game {

    public Game7() {
        super(7, new Level7());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.fromSketch(
                "######",
                "#P.#E#",
                "##...#",
                "######");
    }

}
