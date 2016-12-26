package vlad.game.impl.game;

import vlad.game.Level4;
import vlad.game.impl.utils.CavePainter;
import vlad.game.impl.cave.Cave;

public class Game4 extends Game {

    public Game4() {
        super(4, new Level4());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.fromSketch(
                "#######",
                "#P    #",
                "#### ##",
                "#     #",
                "# #####",
                "#     #",
                "##### #",
                "#E  # #",
                "###   #",
                "#######");
    }

}
