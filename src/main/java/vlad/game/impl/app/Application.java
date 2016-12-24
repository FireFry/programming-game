package vlad.game.impl.app;

import com.google.common.base.Throwables;
import vlad.game.impl.cave.Cave;
import vlad.game.impl.cave.Cell;
import vlad.game.impl.cave.Direction;

import javax.swing.*;
import java.awt.*;

public class Application {

    private static final int CELL_WIDTH = 50;
    private static final int CELL_HEIGHT = 50;

    private static final int PLAYER_WIDTH = 30;
    private static final int PLAYER_HEIGHT = 30;

    private static final Color BG_COLOR = new Color(200, 200, 200);
    private static final Color WALL_COLOR = new Color(100, 100, 100);
    private static final Color EXIT_COLOR = new Color(50, 255, 50);
    private static final Color PLAYER_COLOR = new Color(24, 65, 159);

    private static final int SLEEP_TIME = 500;

    private final Cave cave;
    private final Player player;

    private final JFrame frame;
    private final JPanel panel;

    public Application(Cave cave, Player player) {
        this.cave = cave;
        this.player = player;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int maxScreenWidth = Math.round(screenSize.width * 0.8f);
        int maxScreenHeight = Math.round(screenSize.height * 0.8f);

        int maxCaveWidth = getCaveWidthPx();
        int maxCaveHeight = getCaveHeightPx();

        float scale = Math.min(1f, Math.min(1f * maxScreenWidth / maxCaveWidth, 1f * maxScreenHeight / maxCaveHeight));
        Dimension preferredSize = new Dimension(Math.round(maxCaveWidth * scale), Math.round(maxCaveHeight * scale));

        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return preferredSize;
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                synchronized (cave) {
                    Application.this.paint((Graphics2D) g);
                }
                frame.repaint();
            }
        };
        frame.add(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        player.attach(this);
    }

    public void start() {
        frame.setVisible(true);
        player.play();
    }

    public void onMoveRequested(Direction direction) {
        synchronized (cave) {
            cave.movePlayer(direction);
        }
        sleep(SLEEP_TIME);
    }

    private void sleep(long sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw Throwables.propagate(e);
        }
    }

    private void paint(Graphics2D g) {
        g.scale(1d * panel.getWidth() / getCaveWidthPx(), 1d * panel.getHeight() / getCaveHeightPx());
        g.setBackground(BG_COLOR);
        g.clearRect(0, 0, getCaveWidthPx(), getCaveHeightPx());
        for (int x = 0; x < cave.getWidth(); x++) {
            for (int y = 0; y < cave.getHeight(); y++) {
                Cell cell = cave.getCellSafe(x, y);
                switch (cell) {
                    case WALL:
                        g.setColor(WALL_COLOR);
                        g.fillRect(x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                        break;

                    case EXIT:
                        g.setColor(EXIT_COLOR);
                        g.fillRect(x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                        break;
                }
            }
        }
        int px = cave.getPlayerX();
        int py = cave.getPlayerY();
        g.setColor(PLAYER_COLOR);
        g.fillOval(
                px * CELL_WIDTH + (CELL_WIDTH - PLAYER_WIDTH) / 2,
                py * CELL_HEIGHT + (CELL_HEIGHT - PLAYER_HEIGHT) / 2,
                PLAYER_WIDTH,
                PLAYER_HEIGHT);
    }

    private int getCaveWidthPx() {
        return cave.getWidth() * CELL_WIDTH;
    }

    private int getCaveHeightPx() {
        return cave.getHeight() * CELL_HEIGHT;
    }

}
