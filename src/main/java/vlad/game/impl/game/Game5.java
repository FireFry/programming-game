package vlad.game.impl.game;

import vlad.game.Level5;
import vlad.game.impl.utils.CavePainter;
import vlad.game.impl.cave.Cave;

public class Game5 extends Game {

    public Game5() {
        super(5, new Level5());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.fromSketch(
                "#######",
                "#     #",
                "# E   #",
                "#P    #",
                "#     #",
                "##    #",
                "#######");
    }

}
