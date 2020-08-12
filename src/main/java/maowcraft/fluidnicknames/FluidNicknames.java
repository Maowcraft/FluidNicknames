package maowcraft.fluidnicknames;

import maowcraft.fluidnicknames.command.CommandNickname;
import maowcraft.fluidnicknames.event.PlayerEvents;
import maowcraft.fluidnicknames.util.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

@SuppressWarnings("unused")
public final class FluidNicknames extends JavaPlugin {
    @Override
    public void onEnable() {
        registerEvents();

        Objects.requireNonNull(this.getCommand("nickname")).setExecutor(new CommandNickname());
        Objects.requireNonNull(this.getCommand("reload")).setExecutor((CommandSender sender, Command command, String label, String[] args) -> {
            Config.reload();
            return true;
        });

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        Config.setup();
        Config.getConfig().options().copyDefaults(true);
    }

    @Override
    public void onDisable() {
        Config.save();
    }

    private void registerEvents() {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new PlayerEvents(), this);
    }
}
