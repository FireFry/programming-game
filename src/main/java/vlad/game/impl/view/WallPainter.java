package vlad.game.impl.view;

import java.awt.*;

public class WallPainter implements Painter {

    private static final Color COLOR = new Color(100, 100, 100);

    @Override
    public void draw(Graphics2D g, int x0, int y0, int width, int height) {
        g.setColor(COLOR);
        g.fillRect(x0, y0, width, height);
    }

}
