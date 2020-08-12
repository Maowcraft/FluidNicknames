package maowcraft.fluidnicknames.util.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {
    private static File file;
    private static FileConfiguration cfg;

    public static void setup() {
        file = new File("plugins/FluidNicknames/", "nicknames.cfg");
        if (!file.exists()) {
            try {
                boolean fileCreated = file.createNewFile();
                if (!fileCreated) {
                    System.err.println("Couldn't create nicknames file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        reload();
    }

    public static void save() {
        try {
            cfg.save(file);
        } catch (IOException e) {
            System.err.println("Couldn't save nicknames file.");
        }
    }

    public static void reload() {
        cfg = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getConfig() {
        return cfg;
    }
}
