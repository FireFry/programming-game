package vlad.proggame.game.caves;

import vlad.proggame.game.cave.Cave;
import vlad.proggame.game.CaveFactory;
import vlad.proggame.game.CaveSketch;

public class CaveFactory1 implements CaveFactory {

    @Override
    public Cave createCave() {
        return CaveSketch.draw(
                "#######",
                "#P...E#",
                "#######"
        ).build();
    }

}
