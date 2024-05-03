package org.giutv.gmode;

import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.giutv.gmode.commands.*;
import org.giutv.gmode.utils.FileManager;

public final class Gmode extends JavaPlugin {

    private FileManager configFile;

    @Getter
    private static Gmode instance;

    @Override
    public void onEnable() {
        instance = this;

        this.configFile = new FileManager(this, "config.yml");
        saveDefaultConfig();

        loadCommands();
        loadlisteners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private void loadCommands() {
        new gmacommand(this);
        new gmscommand(this);
        new gmspcommand(this);
        new gmccommand(this);
        new gmodecommand(this);
        saveDefaultConfig();
    }

    private void loadlisteners() {
        PluginManager pm = getServer().getPluginManager();
        // pm.registerEvents(new PlayerListeners(), this);
    }
}
