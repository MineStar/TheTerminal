package de.minestar.theterminal.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import de.minestar.theterminal.manager.ChatManager;

public class ChatListener implements Listener {

    private ChatManager chatManager;

    public ChatListener(ChatManager chatManager) {
        this.chatManager = chatManager;
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerChat(PlayerChatEvent event) {
        // EVENT IS CANCELLED => RETURN
        if (event.isCancelled())
            return;

        // ADD THE EVENT
        this.chatManager.addGameChat(event.getPlayer().getName(), event.getPlayer().getDisplayName(), event.getMessage());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJoin(PlayerJoinEvent event) {
        // ADD THE EVENT
        this.chatManager.addJoin(event.getPlayer().getName());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerQuit(PlayerQuitEvent event) {
        // ADD THE EVENT
        this.chatManager.addQuit(event.getPlayer().getName());
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerKick(PlayerKickEvent event) {
        // EVENT IS CANCELLED => RETURN
        if (event.isCancelled())
            return;

        // ADD THE EVENT
        this.chatManager.addKick(event.getPlayer().getName());
    }
}
