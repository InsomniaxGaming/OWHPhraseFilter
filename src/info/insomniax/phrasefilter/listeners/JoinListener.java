package info.insomniax.phrasefilter.listeners;

import info.insomniax.phrasefilter.core.OWHPhraseFilter;
import info.insomniax.phrasefilter.suspects.Suspects;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener{
	
	Suspects suspects = new Suspects();
	
	public JoinListener(){}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		// when a player joins, add them to the list of suspects
		suspects.addSuspect(e.getPlayer().getName());
	}	

}
