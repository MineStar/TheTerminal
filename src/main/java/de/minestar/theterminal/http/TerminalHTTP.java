package de.minestar.theterminal.http;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.bukkit.gemo.BukkitHTTP.HTTPEvent;
import com.bukkit.gemo.BukkitHTTP.HTTPPlugin;
import com.bukkit.gemo.BukkitHTTP.Page;

import de.minestar.theterminal.http.pages.StringObject;

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
    // HANDLE 404 PAGE
    //
    // /////////////////////
    @Override
    public void handle404Page(Page page, HTTPEvent event) {
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
            if (param.size() < 3)
                return null;

            String pw = getUserPassword(param.get("username"));
            if (pw.split(":")[0] == null || pw.split(":")[1] == null)
                return null;

            if (!Crypt.SHA1(pw.split(":")[1] + param.get("password")).contentEquals(pw.split(":")[0]))
                return null;

            String username = "";
            if (username == null)
                return null;

            return "Username=" + username;
        } catch (Exception e) {
            return null;
        }
    }

    // /////////////////////
    //
    // LOGIN FAILED
    //
    // /////////////////////
    @Override
    public void handleWrongLogin(Page page, HTTPEvent event) {
        StringObject gameList = new StringObject();
        page.replaceText("%LISTOFGAMES%", gameList.str);
        page.replaceText("%MESSAGE%", "<font color=\"red\"><b>Login failed!</b></font><br /><br />");
    }

    // /////////////////////
    //
    // GET CONTAO PASSWORD
    //
    // /////////////////////
    public static String getUserPassword(String username) {
        String query = "SELECT `password` FROM `tl_member` WHERE `username`='" + username + "'";
        ResultSet result = null;
        try {
            result = null;// CoKCore.mySQL.sqlQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            while (result != null && result.next()) {
                return result.getString("password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
