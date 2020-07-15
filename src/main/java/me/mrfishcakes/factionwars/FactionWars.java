package me.mrfishcakes.factionwars;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FactionWars extends JavaPlugin {

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("Factions") == null) {
            getLogger().severe("Factions wasn't found, please ensure FactionsUUID is");
            getLogger().severe("installed on the server and is active!");
            return;
        }
    }

    @Override
    public void onDisable() {

    }
}
