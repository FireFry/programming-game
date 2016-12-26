package vlad.game.impl.game;

import vlad.game.Level6;
import vlad.game.impl.utils.CavePainter;
import vlad.game.impl.cave.Cave;

public class Game6 extends Game {

    public Game6() {
        super(6, new Level6());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.fromSketch(
                "########",
                "#      #",
                "# #    #",
                "# P   ##",
                "#   E  #",
                "#      #",
                "#  #   #",
                "#     ##",
                "########");
    }

}
