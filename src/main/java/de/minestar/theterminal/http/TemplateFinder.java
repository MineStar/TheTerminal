package de.minestar.theterminal.http;

import com.bukkit.gemo.BukkitHTTP.HTTPEvent;
import com.bukkit.gemo.BukkitHTTP.Page;

import de.minestar.theterminal.http.pages.tplDoChat;
import de.minestar.theterminal.http.pages.tplGetChat;
import de.minestar.theterminal.http.pages.tplLogin;

public class TemplateFinder {
    public static Page findTemplate(Page page, HTTPEvent event) {
        if (event.fileName.equalsIgnoreCase("getChat.html")) {
            tplGetChat.execTemplate(page, event);
        } else if (event.fileName.equalsIgnoreCase("doChat.html")) {
            tplDoChat.execTemplate(page, event);
        } else if (event.fileName.equalsIgnoreCase("login.html")) {
            tplLogin.execTemplate(page, event);
        }
        return page;
    }
}
