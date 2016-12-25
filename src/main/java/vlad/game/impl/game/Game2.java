package vlad.game.impl.game;

import vlad.game.Level2;
import vlad.game.impl.app.CavePainter;
import vlad.game.impl.cave.Cave;

public class Game2 extends Game {

    public Game2() {
        super(2, new Level2());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.paint(
                "#######",
                "#P.#.E#",
                "##...##",
                "#######");
    }

}