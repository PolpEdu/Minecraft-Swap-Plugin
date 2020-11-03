package me.TheRealPolpy.SwapPlugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class GivePos implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// player
		Player p = (Player) sender; // p é o sender (o player que enviou)

		if (sender instanceof Player) {
			sender.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Faz /Gamestart e o nome do Player para começar o jogo.");
			return true;

		} else {
			
			sender.sendMessage("Console, SwapPlugin is on, but to issue this command you must be a player giiiirl.");
			return true;
		}
	}

}
