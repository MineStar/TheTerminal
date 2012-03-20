package de.minestar.theterminal.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import com.bukkit.gemo.BukkitHTTP.HTTPCore;
import com.bukkit.gemo.BukkitHTTP.HTTPPlugin;

import de.minestar.minestarlibrary.AbstractCore;
import de.minestar.minestarlibrary.utils.ConsoleUtils;
import de.minestar.theterminal.http.TerminalHTTP;

public class Core extends AbstractCore {

    private static String NAME;

    // WEBSERVER
    private static HTTPPlugin thisHTTP;

    public Core() {
        this("The Terminal");
    }

    public Core(String name) {
        NAME = name;
    }

    @Override
    protected boolean commonEnable() {

        // CREATE DIR
        this.getDataFolder().mkdirs();

        // GET BUKKIT HTTP
        Plugin httpPlugin = Bukkit.getPluginManager().getPlugin("BukkitHTTP");
        if (httpPlugin != null) {
            HTTPCore http = (HTTPCore) httpPlugin;
            thisHTTP = new TerminalHTTP("terminal", "The Terminal", "TheTerminal/web", true);
            thisHTTP.setOwn404Page(true);
            http.registerPlugin(thisHTTP);
            return true;
        } else {
            ConsoleUtils.printError(NAME, "BukkitHTTP not found!");
            return false;
        }
    }
}
