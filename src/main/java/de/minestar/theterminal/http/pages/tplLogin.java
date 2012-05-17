package de.minestar.theterminal.http.pages;

import com.bukkit.gemo.BukkitHTTP.HTTPEvent;
import com.bukkit.gemo.BukkitHTTP.Page;

public class tplLogin extends TemplatePage {
    public static void execTemplate(Page page, HTTPEvent event) {
        System.out.println("Cookies:");
        int i = 0;
        for (String str : event.cookies) {
            System.out.println("#" + (++i) + " : " + str);
        }
    }
}
