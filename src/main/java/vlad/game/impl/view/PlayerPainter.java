package vlad.game.impl.view;

import java.awt.*;

public class PlayerPainter implements Painter {

    private static final Color COLOR = new Color(24, 65, 159);
    private static final float SCALE_FACTOR = 0.8f;

    @Override
    public void draw(Graphics2D g, int x0, int y0, int width, int height) {
        g.setColor(COLOR);
        g.fillOval(x0 + Math.round(width * (1f - SCALE_FACTOR) / 2f),
                y0 + Math.round(height * (1f - SCALE_FACTOR) / 2f),
                Math.round(width * SCALE_FACTOR),
                Math.round(height * SCALE_FACTOR));
    }

}
