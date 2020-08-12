package maowcraft.fluidnicknames.event;

import maowcraft.fluidnicknames.util.NicknameUtil;
import maowcraft.fluidnicknames.util.config.Config;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerEvents implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if (event.getPlayer().hasPermission("nickname.use")) {
            Player player = event.getPlayer();
            NicknameUtil.setNickname(player, Config.getConfig().getString("players." + player.getUniqueId() + ".nickname"));
        }
    }
}
