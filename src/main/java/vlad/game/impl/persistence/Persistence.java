package vlad.game.impl.persistence;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Allows to persist application state between program executions.
 */
public class Persistence {

    private final File file;

    public Persistence(File file) {
        this.file = file;
    }

    public int readLastCompletedLevel() {
        try {
            return Integer.parseInt(Files.readFirstLine(file, StandardCharsets.UTF_8));
        } catch (Exception e) {
            return -1;
        }
    }

    public void writeLastCompletedLevel(int level) {
        try {
            Files.write(String.valueOf(level), file, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        file.delete();
    }

}
