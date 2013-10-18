package info.insomniax.phrasefilter.listeners;

import info.insomniax.phrasefilter.suspects.Suspects;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener{

	public ChatListener(){}
	

	
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
}
