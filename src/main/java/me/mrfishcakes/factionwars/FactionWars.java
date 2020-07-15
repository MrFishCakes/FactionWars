package me.mrfishcakes.factionwars;

import me.mrfishcakes.factionwars.maven.LibraryLoader;
import me.mrfishcakes.factionwars.maven.MavenLibrary;
import me.mrfishcakes.factionwars.maven.Repository;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@MavenLibrary(groupId = "com.github.JavaFactoryDev", artifactId = "LightningStorage", version = "3.1.5",
        repo = @Repository(url = "https://jitpack.io"))
public final class FactionWars extends JavaPlugin {

    private static FactionWars instance;

    public static FactionWars getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("Factions") == null) {
            getLogger().severe("Factions wasn't found, please ensure FactionsUUID is");
            getLogger().severe("installed on the server and is active!");
            return;
        }

        instance = this;
        LibraryLoader.loadAll(this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
