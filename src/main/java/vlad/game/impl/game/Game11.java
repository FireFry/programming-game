package vlad.game.impl.game;

import vlad.game.Level11;
import vlad.game.impl.cave.Cave;
import vlad.game.impl.utils.BorderHelper;
import vlad.game.impl.utils.MazeGenerator;

import java.util.Random;

public class Game11 extends Game {

    public Game11() {
        super(11, new Level11());
    }

    @Override
    protected Cave createCave() {
        return BorderHelper.withBorder(new MazeGenerator(new Random(249682468), 50, 50, 8).generate());
    }

}
