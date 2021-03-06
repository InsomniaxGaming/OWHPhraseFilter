package info.insomniax.phrasefilter.permissions;

import info.insomniax.phrasefilter.core.OWHPhraseFilter;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.command.CommandSender;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Permissions {
	
	static String BASE_NODE = "owhphrasefilter";
	OWHPhraseFilter myPlugin;
	private static Permission permission = null;
	
	public Permissions(OWHPhraseFilter instance)
	{
		myPlugin = instance;
	}
	
	public boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = myPlugin.getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
	
	public boolean has(CommandSender sender, String node)
	{
		return permission.has(sender, node);
	}
	
	public static String getBaseNode()
	{
		return BASE_NODE;
	}
}
