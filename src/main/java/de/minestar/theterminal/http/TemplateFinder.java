package de.minestar.theterminal.http;

import com.bukkit.gemo.BukkitHTTP.HTTPEvent;
import com.bukkit.gemo.BukkitHTTP.Page;

public class TemplateFinder {
    public static Page findTemplate(Page page, HTTPEvent event) {
        if (event.fileName.equalsIgnoreCase("ERROR404.html")) {
            // tplError404.execTemplate(page, event);
        } else if (event.fileName.equalsIgnoreCase("index.html")) {
            // tplIndex.execTemplate(page, event);
            page.replaceText("%USERNAME%", event.getCookieParam("Username"));
        }

        return page;
    }
}
