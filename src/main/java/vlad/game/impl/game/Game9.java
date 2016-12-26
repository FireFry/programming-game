package vlad.game.impl.game;

import vlad.game.Level9;
import vlad.game.impl.utils.CavePainter;
import vlad.game.impl.cave.Cave;

public class Game9 extends Game {

    public Game9() {
        super(9, new Level9());
    }

    @Override
    protected Cave createCave() {
        return CavePainter.fromSketch(
                "##############",
                "#            #",
                "# ########## #",
                "#        ### #",
                "######## #   #",
                "#     ##E# ###",
                "# ### #### ###",
                "# ###    # ###",
                "# ###### #   #",
                "#     ## ### #",
                "##### ##  #  #",
                "#P    ###   ##",
                "##############");
    }

}
