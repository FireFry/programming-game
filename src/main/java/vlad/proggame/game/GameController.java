package vlad.proggame.game;

import vlad.proggame.Level1;
import vlad.proggame.game.cave.Cave;
import vlad.proggame.game.caves.CaveFactory1;

public class GameController {

    public static void main(String[] args) {
        CaveFactory1 caveFactory = new CaveFactory1();
        Level1 level = new Level1();
        Cave cave = caveFactory.createCave();
        Player player = level.createPlayer();
        player.enter(cave);
    }

}
