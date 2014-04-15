package uk.me.viv.test;

import java.io.File;
import java.util.Collection;

import uk.me.viv.test.talker.Greeter;
import net.xeoh.plugins.base.PluginManager;
import net.xeoh.plugins.base.impl.PluginManagerFactory;
import net.xeoh.plugins.base.util.PluginManagerUtil;

public class Main {
	public static void main(String[] args) {
		PluginManager pm = PluginManagerFactory.createPluginManager();
		pm.addPluginsFrom(new File("plugins/").toURI());

		// Load all plugins of a type
		Collection<Greeter> greeters = new PluginManagerUtil(pm).getPlugins(Greeter.class);
		for ( Greeter greeter : greeters ) {
			System.out.println(greeter.sayHello());
		}

		// Load a single plugin
		Greeter plugin = pm.getPlugin(Greeter.class);
		System.out.println(plugin.sayHello());
	}
}
