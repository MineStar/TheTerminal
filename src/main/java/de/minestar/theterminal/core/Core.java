package de.minestar.theterminal.core;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import com.bukkit.gemo.BukkitHTTP.HTTPCore;
import com.bukkit.gemo.BukkitHTTP.HTTPPlugin;

import de.minestar.minestarlibrary.AbstractCore;
import de.minestar.minestarlibrary.utils.ConsoleUtils;
import de.minestar.theterminal.http.TerminalHTTP;
import de.minestar.theterminal.listener.ChatListener;
import de.minestar.theterminal.manager.ChatManager;

public class Core extends AbstractCore {

    // STATIC VARS
    private static Core INSTANCE;
    private static String NAME;

    // LISTENER
    private Listener chatListener;

    // MANAGER
    private ChatManager chatManager;

    // WEBSERVER
    private static HTTPPlugin thisHTTP;

    public Core() {
        this("The Terminal");
        Core.INSTANCE = this;
    }

    public Core(String name) {
        super(name);
        Core.NAME = name;
    }
    @Override
    protected boolean createManager() {
        this.chatManager = new ChatManager();
        return true;
    }

    @Override
    protected boolean createListener() {
        this.chatListener = new ChatListener(this.chatManager);
        return true;
    }

    @Override
    protected boolean registerEvents(PluginManager pm) {
        pm.registerEvents(this.chatListener, this);
        return true;
    }

    @Override
    protected boolean commonEnable() {
        // CREATE DIR
        this.getDataFolder().mkdirs();

        // CREATE WEBFOLDER
        File webFolder = new File(this.getDataFolder(), "web");
        webFolder.mkdirs();

        // CREATE NEEDED HTML-FILES
        this.createHTMLFiles(webFolder);

        // GET BUKKIT HTTP
        Plugin httpPlugin = Bukkit.getPluginManager().getPlugin("BukkitHTTP");
        if (httpPlugin != null) {
            HTTPCore http = (HTTPCore) httpPlugin;
            thisHTTP = new TerminalHTTP("terminal", "The Terminal", "TheTerminal/web", true);
            thisHTTP.setOwn404Page(false);
            http.registerPlugin(thisHTTP);
            return true;
        } else {
            ConsoleUtils.printError(Core.NAME, "BukkitHTTP not found!");
            return false;
        }
    }

    private void createHTMLFiles(File webFolder) {
        this.createFile(new File(webFolder, "getChat.html"));
        this.createFile(new File(webFolder, "doChat.html"));
        this.createFile(new File(webFolder, "index.html"));
    }

    private void createFile(File file) {
        if (file.exists())
            return;

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Core getInstance() {
        return Core.INSTANCE;
    }

    /**
     * @return the chatManager
     */
    public ChatManager getChatManager() {
        return chatManager;
    }
}
