package vlad.game.impl.game;

import vlad.game.Level8;
import vlad.game.impl.cave.Cave;
import vlad.game.impl.utils.CavePainter;

public class Game8 extends Game {

    public Game8() {
        super(8, new Level8());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.fromSketch(
                "######",
                "#   P#",
                "# ####",
                "#   ##",
                "###  #",
                "#E # #",
                "##   #",
                "######");
    }

}
