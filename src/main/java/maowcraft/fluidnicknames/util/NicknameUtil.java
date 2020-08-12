package maowcraft.fluidnicknames.util;

import maowcraft.fluidnicknames.util.config.Config;
import org.bukkit.entity.Player;

public class NicknameUtil {
    public static void setNickname(Player player, String nickname) {
        player.setDisplayName(nickname);
        player.setPlayerListName(nickname);
        Config.getConfig().set("players." + player.getUniqueId() + ".nickname", nickname);
        Config.save();
    }
}
