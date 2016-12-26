package vlad.game.impl.core;

import com.google.common.base.Throwables;
import vlad.game.impl.cave.Cave;
import vlad.game.impl.cave.Cell;
import vlad.game.impl.cave.Direction;
import vlad.game.impl.view.ExitPainter;
import vlad.game.impl.view.PlayerPainter;
import vlad.game.impl.view.WallPainter;

import javax.swing.*;
import java.awt.*;

public class GameController {

    private static final int CELL_WIDTH = 50;
    private static final int CELL_HEIGHT = 50;

    private static final Color BG_COLOR = new Color(200, 200, 200);

    private static final int SLEEP_TIME_FACTOR = 4000;
    private static final int LONG_SLEEP_TIME = 1000;

    private final int id;
    private final Cave cave;
    private final Player player;

    private final JFrame frame;
    private final JPanel panel;

    private final PlayerPainter playerPainter = new PlayerPainter();
    private final WallPainter wallPainter = new WallPainter();
    private final ExitPainter exitPainter = new ExitPainter();

    public GameController(int id, Cave cave, Player player) {
        this.id = id;
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
                    GameController.this.paint((Graphics2D) g);
                }
                if (isVisible()) {
                    frame.repaint();
                }
            }
        };
        frame.add(panel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        player.attach(this);
    }

    public void start() {
        log("Game %d stated", id);
        frame.setVisible(true);
        try {
            sleep(LONG_SLEEP_TIME);
            player.play();
            while (true) {
                sleep(LONG_SLEEP_TIME);
            }
        } catch (GameOverError ignored) {
            // Game over
        } finally {
            sleep(LONG_SLEEP_TIME);
            if (cave.isGameOver()) {
                log("Level %d is completed!", id);
            } else {
                log("Level %d is not passed", id);
                log("Game over!");
            }
            frame.setVisible(false);
        }
    }

    private void log(String format, Object... params) {
        System.out.println(String.format(format, params));
    }

    public void onMoveRequested(Direction direction) {
        log("Player moves towards %s", direction);
        synchronized (cave) {
            cave.movePlayer(direction);
        }
        sleep(SLEEP_TIME_FACTOR / (cave.getWidth() + cave.getHeight()));
        synchronized (cave) {
            if (cave.isGameOver()) {
                throw new GameOverError();
            }
        }
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
                Cell cell = cave.getCell(x, y);
                switch (cell) {
                    case WALL:
                        wallPainter.draw(g, x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                        break;
                    case EXIT:
                        exitPainter.draw(g, x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                        break;
                }
                if (cave.isPlayerPosition(x, y)) {
                    playerPainter.draw(g, x * CELL_WIDTH, y * CELL_HEIGHT, CELL_WIDTH, CELL_HEIGHT);
                }
            }
        }
    }

    private int getCaveWidthPx() {
        return cave.getWidth() * CELL_WIDTH;
    }

    private int getCaveHeightPx() {
        return cave.getHeight() * CELL_HEIGHT;
    }

    public boolean isPassed() {
        return cave.isGameOver();
    }

    public Cave getCave() {
        return cave;
    }

    private static final class GameOverError extends Error {}

}
