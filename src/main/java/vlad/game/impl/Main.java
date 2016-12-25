package vlad.game.impl;

import com.google.common.io.Files;
import vlad.game.impl.game.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) {
        File saves = new File(System.getProperty("user.home") + File.separator + "prgame.sav");
        int lastCompleted;
        try {
            lastCompleted = Integer.parseInt(Files.readFirstLine(saves, StandardCharsets.UTF_8));
        } catch (Exception e) {
            lastCompleted = -1;
        }
        try {
            Game[] games = new Game[]{
                    new Game1(),
                    new Game2(),
                    new Game3(),
                    new Game4(),
                    new Game5(),
                    new Game6(),
                    new Game7(),
            };
            for (int i = lastCompleted + 1; i < games.length; i++) {
                Game game = games[i];
                game.play();
                if (game.isPassed()) {
                    try {
                        Files.write(String.valueOf(i), saves, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    return;
                }
            }
            System.out.println("All levels passed!");
            // saves.deleteOnExit();
        } finally {
            System.exit(0);
        }
    }

}
