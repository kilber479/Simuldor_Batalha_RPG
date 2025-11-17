package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple application log manager used by the game.
 * Writes entries to a file named {@code battle_log.txt} in the working directory.
 */
public final class LogManager {

    private static final Path LOG_FILE = Path.of("battle_log.txt");
    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LogManager() { }

    
    public static synchronized void registrar(String texto) {
        String line = String.format("[%s] %s%n", LocalDateTime.now().format(TS), texto);
        try {
            // Ensure parent exists (for completeness) then append the line.
            Path parent = LOG_FILE.getParent();
            if (parent != null && !Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            Files.writeString(LOG_FILE, line, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            // Fall back to stderr so failures are visible during development.
            System.err.println("LogManager: não foi possível gravar no arquivo de log: " + e.getMessage());
            e.printStackTrace();
        }
    }
}