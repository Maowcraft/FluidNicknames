package maowcraft.fluidnicknames.command;

import maowcraft.fluidnicknames.util.NicknameUtil;
import maowcraft.fluidnicknames.util.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandNickname implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Permissions.FLUIDNICKNAMES_NICKNAME)) {
                if (args.length != 0) {
                    String nickname = ChatColor.translateAlternateColorCodes('&', args[0] + "&r");
                    NicknameUtil.setNickname(player, nickname);
                    player.sendMessage(ChatColor.AQUA + "[FluidNicknames] " + ChatColor.RESET + "Your nickname has been set to " + nickname + ".");
                } else {
                    NicknameUtil.setNickname(player, player.getName());
                    player.sendMessage(ChatColor.AQUA + "[FluidNicknames] " + ChatColor.RESET + "Your nickname has been reset.");
                }
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "You lack the permission to use this command.");
                return false;
            }
        }
        return false;
    }
}
