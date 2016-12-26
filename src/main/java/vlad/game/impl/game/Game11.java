package vlad.game.impl.game;

import vlad.game.Level11;
import vlad.game.impl.app.BorderHelper;
import vlad.game.impl.app.MazeGenerator;
import vlad.game.impl.cave.Cave;

import java.util.Random;

public class Game11 extends Game {

    public Game11() {
        super(11, new Level11());
    }

    @Override
    protected Cave createCave() {
        return BorderHelper.withBorder(new MazeGenerator(50, 50, new Random(249682468)).generate());
    }

}
