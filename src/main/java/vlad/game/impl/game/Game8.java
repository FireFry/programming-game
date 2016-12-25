package vlad.game.impl.game;

import vlad.game.Level8;
import vlad.game.impl.app.CavePainter;
import vlad.game.impl.cave.Cave;

public class Game8 extends Game {

    public Game8() {
        super(8, new Level8());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.paint(
                "######",
                "#...P#",
                "#.####",
                "#...##",
                "###..#",
                "#E.#.#",
                "##...#",
                "######");
    }

}
