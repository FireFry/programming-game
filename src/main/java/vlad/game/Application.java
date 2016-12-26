package vlad.game;

import com.google.common.base.Preconditions;
import vlad.game.impl.game.*;
import vlad.game.impl.persistence.Persistence;

import java.io.File;

/**
 * Application entrance point. Run it to test your algorithms.
 */
public class Application {

    /** Array of games */
    private static final Game[] GAMES = {
            new Game1(),
            new Game2(),
            new Game3(),
            new Game4(),
            new Game5(),
            new Game6(),
            new Game7(),
            new Game8(),
            new Game9(),
            new Game10(),
            new Game11(),
    };

    public static void main(String[] args) {
        try {
            new Application().start();
        } finally {
            System.exit(0);
        }
    }

    private void start() {
        Persistence persistence = createPersistence();
        int lastCompleted = persistence.readLastCompletedLevel();
        for (int level = lastCompleted + 1; level < GAMES.length; level++) {
            Game game = GAMES[level];
            game.play();
            Preconditions.checkState(game.isPassed(), "Game is not passed");
            persistence.writeLastCompletedLevel(level);
        }
        System.out.println("All levels passed!");
        persistence.delete();
    }

    private Persistence createPersistence() {
        File homeFolder = new File(System.getProperty("user.home"));
        File savesFile = new File(homeFolder, "programming-game.save");
        return new Persistence(savesFile);
    }

}
