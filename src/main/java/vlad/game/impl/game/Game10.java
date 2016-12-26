package vlad.game.impl.game;

import vlad.game.Level10;
import vlad.game.impl.utils.BorderHelper;
import vlad.game.impl.utils.MazeGenerator;
import vlad.game.impl.cave.Cave;

import java.util.Random;

public class Game10 extends Game {

    public Game10() {
        super(10, new Level10());
    }

    @Override
    protected Cave createCave() {
        return BorderHelper.withBorder(new MazeGenerator(new Random(571753753), 10, 10, 10).generate());
    }

}
