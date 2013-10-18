package info.insomniax.phrasefilter.suspects;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Suspects extends Timer{
	
	public static List<String> SUSPECTS = new ArrayList<String>();

	public void addSuspect(String iDontWantToUseTheWordSuspectEverAgain)
	{
		SUSPECTS.add(iDontWantToUseTheWordSuspectEverAgain); // Add player to list of players joined in last 10 seconds
		this.schedule(new Suspect(iDontWantToUseTheWordSuspectEverAgain),10000); // Schedule a task to remove the player from the list in 10 seconds
	}
	
	class Suspect extends TimerTask{
		
		String name;
		
		public Suspect(String name)
		{
			this.name = name;
		}

		@Override
		public void run()
		{
			SUSPECTS.remove(name);
		}	
	}
}
