package com.icurety.nicknames;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class NameRegistry {

    private static Map<String, String> names = new HashMap<String, String>();

    private static void setNames(Player player, String newName) {
        player.setCustomName(newName);
        player.setCustomNameVisible(true);
        player.setPlayerListName(newName);
        player.setDisplayName(newName);
    }

    public static void updatePlayerWithSavedName(Player player) {
        if(names.containsKey(player.getUniqueId().toString()))
        {
            setNames(player, names.get(player.getUniqueId().toString()));
        }
    }

    public static void saveName(Player player, String newName) {
        names.put(player.getUniqueId().toString(), newName);
        setNames(player, newName);
    }

    public static void clearName(Player player) {
        if(names.containsKey(player.getUniqueId().toString()))
        {
            names.remove(player.getUniqueId().toString());
            player.setCustomName(player.getName());
            player.setCustomNameVisible(false);
            player.setPlayerListName(player.getName());
            player.setDisplayName(player.getName());
        }
    }

    public static Map<String, String> getNames() {
        return names;
    }

    public static void loadNames(Map<String, String> savedNames) {
        names.clear();
        for(String uuid : savedNames.keySet())
            names.put(uuid, savedNames.get(uuid));
    }
}
