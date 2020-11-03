package me.TheRealPolpy.SwapPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandsandSubcommands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;

		if (sender instanceof Player) {

			Player player1 = Bukkit.getPlayer(args[0]);
			Player player2 = Bukkit.getPlayer(args[1]);
			
			sender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + player1.getDisplayName() + " e "+ player2.getDisplayName());
			

		} else {
			sender.sendMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "I am alive, console");
			return false;
		}

		return false;
	}
	
	


}
