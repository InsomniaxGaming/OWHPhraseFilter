package info.insomniax.phrasefilter.core;

import info.insomniax.phrasefilter.listeners.ChatListener;
import info.insomniax.phrasefilter.listeners.JoinListener;

import org.bukkit.plugin.java.JavaPlugin;

public class OWHPhraseFilter extends JavaPlugin{
	
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new JoinListener(), this);
		getServer().getPluginManager().registerEvents(new ChatListener(), this);
	}
	
	public void onDisable(){}
}
