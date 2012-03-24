package de.minestar.theterminal.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.minestar.theterminal.utils.ChatEvent;
import de.minestar.theterminal.utils.EventType;

public class ChatManager {
    private List<ChatEvent> chatList = Collections.synchronizedList(new ArrayList<ChatEvent>());

    public void addGameChat(String playerName, String displayName, String message) {
        chatList.add(new ChatEvent(playerName, displayName, message.replace("\"", "''"), EventType.GAME_CHAT));
    }

    public void addJoin(String playerName) {
        chatList.add(new ChatEvent("", "", playerName + " joined the game.", EventType.JOINQUIT));
    }

    public void addQuit(String playerName) {
        chatList.add(new ChatEvent("", "", playerName + " left the game.", EventType.JOINQUIT));
    }

    public void addKick(String playerName) {
        chatList.add(new ChatEvent("", "", playerName + " was kicked.", EventType.JOINQUIT));
    }

    public void addWebChat(String playerName, String message) {
        chatList.add(new ChatEvent("[WEB] " + playerName, "[WEB] " + playerName, message.replace("\"", "''"), EventType.WEB_CHAT));
    }

    public ArrayList<ChatEvent> getMessagesAfter(long time) {
        ArrayList<ChatEvent> list = new ArrayList<ChatEvent>();
        for (int i = this.chatList.size() - 1; i >= 0; i--) {
            if (this.chatList.get(i).isYounger(time)) {
                list.add(this.chatList.get(i));
            }
        }
        return list;
    }

    public ArrayList<ChatEvent> getMessagesBefore(long time) {
        ArrayList<ChatEvent> list = new ArrayList<ChatEvent>();
        for (int i = this.chatList.size() - 1; i >= 0; i--) {
            if (this.chatList.get(i).isOlder(time)) {
                list.add(this.chatList.get(i));
            }
        }
        return list;
    }
}
