package me.TheRealPolpy.SwapPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

	private static Main plugin;

	public static Main getPlugin() {
		return plugin;
	}

	@Override
	public void onEnable() {
		// startup
		// reloads inc. plugins
		// when sp is run is going to look for the executor in the other class

		getCommand("sp").setExecutor(new CommandsandSubcommands());
		getCommand("givemypos").setExecutor(new GivePos());
		// getCommand("GameStart").setExecutor(new Gamestart());
		// a classe corre quando tu escreves estes comandos.

	}

	@Override
	public void onDisable() {
		// shutdown
		// reloads inc. plugins

	}

	public int taskID;
	public int time;

	public void setTimer(int amount) {
		time = amount;
	}
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (label.equalsIgnoreCase("gamestart")) {
			if (args.length == 2) {

				Player player2 = Bukkit.getPlayer(args[0]);
				int timerINT = Integer.parseInt(args[1]);

				// devia fazer um settime perguntar aqui em baixo tenho que dar reset tambem
				time = timerINT;

				setTimer(time);
				Bukkit.broadcastMessage("Player1: " + ChatColor.AQUA + "" + ChatColor.BOLD + p.getDisplayName()
						+ ChatColor.RESET + "" + " |  Player 2: " + ChatColor.AQUA + "" + ChatColor.BOLD
						+ player2.getDisplayName() + ChatColor.RESET + "" + " with the time: " + time + " seconds between swaps!");

				//Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "Running!");
				taskID = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {

					@Override
					public void run() {

						if (time == 0) {
							Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + "SWAPPING!!!!!");

							Location loc1 = p.getLocation();
							Location loc2 = player2.getLocation();

							if ((player2 != null) && player2.isOnline()) {
								player2.teleport(loc1);
							}
							if ((p != null) && p.isOnline()) {
								p.teleport(loc2);

							}
							time = timerINT; // needs to be the same (reseting the timer)d
						}
						
						else if (time == 180)
						{
							Bukkit.broadcastMessage(ChatColor.GREEN + "3 minutes remaining!!");
						}
						else if (time == 60)
						{
							Bukkit.broadcastMessage(ChatColor.YELLOW + "1 minute remaining!!");
							
						}
						else if (time <= 30)
						{
							if (time % 10 ==0)
							{
								Bukkit.broadcastMessage(ChatColor.GOLD +  "" + time + " seconds remaining!!");
							}
							if (time <10)
							{
								Bukkit.broadcastMessage(ChatColor.DARK_RED+ "" + time + " seconds remaining!!");
							}
						}
						
						
						time = time - 1;

					}
				}, 0L, 20L); // 20 ticks - 1 second

				Bukkit.broadcastMessage(ChatColor.AQUA + "" + ChatColor.BOLD + "GAME IS ON!");
				return true;
				
			} else {
				
				Bukkit.broadcastMessage(
						ChatColor.AQUA + "" + "/gamestart <Player that you want to Challenge> <time (300 = 5 mins)>");
				return false;
			}
			
		} else {

			p.sendMessage(ChatColor.RED + "Wrong sintax");
			return false;
		}

	}

}
