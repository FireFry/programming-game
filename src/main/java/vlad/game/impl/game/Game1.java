package vlad.game.impl.game;

import vlad.game.Level1;
import vlad.game.impl.utils.CavePainter;
import vlad.game.impl.cave.Cave;

public class Game1 extends Game {

    public Game1() {
        super(1, new Level1());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.fromSketch(
                "#######",
                "#P...E#",
                "#######");
    }

}
