package util;

import java.io.FileWriter;

public class LogManager {

    public static void registrar(String texto) {
        try (FileWriter fw = new FileWriter("battle_log.txt", true)) {
            fw.write(texto + "\n");
        } catch (Exception ignored) {}
    }
}
