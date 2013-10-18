package info.insomniax.phrasefilter.core;

import info.insomniax.phrasefilter.suspects.Suspects;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class OWHPhraseFilter extends JavaPlugin implements org.bukkit.event.Listener{
	
	String peskyMessageStart = "connected with a";
	String peskyMessageEnd = "using MineChat";
	
	Suspects suspects = null;
	
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		suspects = new Suspects();
	}
	
	public void onDisable(){}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void playerChat(AsyncPlayerChatEvent event)
	{	
		// Check if this message starts and ends with the horrid MineChat spam. This avoids having to check every single type of device (iphone, ipod, etc..).
		if(event.getMessage().startsWith(peskyMessageStart) && event.getMessage().endsWith(peskyMessageEnd))
		{
			if(Suspects.SUSPECTS.contains(event.getPlayer().getName())) // Check if the player is in our list
			{
				event.setCancelled(true); // No spam today, stupid app!
			}
		}		
	}
	
	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		// when a player joins, add them to the list of suspects
		suspects.addSuspect(e.getPlayer().getName());
	}	
}
