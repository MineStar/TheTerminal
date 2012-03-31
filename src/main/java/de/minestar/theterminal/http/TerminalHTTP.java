package de.minestar.theterminal.http;

import java.util.HashMap;

import com.bukkit.gemo.BukkitHTTP.HTTPEvent;
import com.bukkit.gemo.BukkitHTTP.HTTPPlugin;
import com.bukkit.gemo.BukkitHTTP.Page;

public class TerminalHTTP extends HTTPPlugin {
    // /////////////////////
    //
    // CONSTRUCTOR
    //
    // /////////////////////
    public TerminalHTTP(String rootAlias, String pluginName, String root, boolean useAuth) {
        super(rootAlias, pluginName, root, useAuth);
    }

    // /////////////////////
    //
    // HANDLE GET REQUEST
    //
    // /////////////////////
    @Override
    public void handleGetRequest(Page page, HTTPEvent event) {
        TemplateFinder.findTemplate(page, event);
    }

    // /////////////////////
    //
    // HANDLE POST REQUEST
    //
    // /////////////////////
    @Override
    public void handlePostRequest(Page page, HTTPEvent event) {
        TemplateFinder.findTemplate(page, event);
    }

    // /////////////////////
    //
    // LOGIN SUCCESSFUL
    //
    // /////////////////////
    @Override
    public String loginSuccessful(HTTPEvent event) {
        try {
            HashMap<String, String> param = event.postParameter;
            if (param == null)
                return null;

            if (param.size() < 2)
                return null;

            if (param.get("password").equalsIgnoreCase("test") && param.get("username").equalsIgnoreCase("admin")) {
                return "Username=" + "admin";
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
