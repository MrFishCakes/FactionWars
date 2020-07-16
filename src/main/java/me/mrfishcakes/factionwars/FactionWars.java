package me.mrfishcakes.factionwars;

import de.leonhard.storage.Config;
import de.leonhard.storage.LightningBuilder;
import de.leonhard.storage.internal.settings.ConfigSettings;
import de.leonhard.storage.internal.settings.ReloadSettings;
import me.mrfishcakes.factionwars.maven.LibraryLoader;
import me.mrfishcakes.factionwars.maven.MavenLibrary;
import me.mrfishcakes.factionwars.maven.Repository;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

@MavenLibrary(groupId = "com.github.JavaFactoryDev", artifactId = "LightningStorage", version = "3.1.5",
        repo = @Repository(url = "https://jitpack.io"))
public final class FactionWars extends JavaPlugin {

    private Config config;

    /**
     * Get the main {@link Config config} file for the plugin
     *
     * @return Main config file
     * @see Config
     */
    @NotNull
    public Config getMainConfig() {
        return config;
    }

    @Override
    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("Factions") == null) {
            getLogger().severe("Factions wasn't found, please ensure FactionsUUID is");
            getLogger().severe("installed on the server and is active!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        LibraryLoader.loadAll(this);
        File configFile = new File(getDataFolder(), "config.yml");
        config = LightningBuilder.fromPath("config", configFile.getAbsolutePath())
                .addInputStream(getResource("config.yml"))
                .setConfigSettings(ConfigSettings.PRESERVE_COMMENTS)
                .setReloadSettings(ReloadSettings.AUTOMATICALLY).createConfig();
    }

    @Override
    public void onDisable() {
        config = null;
    }
}
