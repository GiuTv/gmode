package org.giutv.gmode;

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import org.giutv.gmode.commands.*;
import org.giutv.gmode.utils.FileManager;

public final class Gmode extends JavaPlugin {

    @Getter
    private static Gmode instance;

    @Override
    public void onEnable() {
        instance = this;

        new FileManager(this, "config.yml");
        saveDefaultConfig();

        loadCommands();
        loadlisteners();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    private void loadCommands() {
        new gmacommand();
        new gmscommand();
        new gmspcommand();
        new gmccommand();
        new gmodecommand();
        saveDefaultConfig();
    }

    private void loadlisteners() {
        // PluginManager pm = getServer().getPluginManager();
        // pm.registerEvents(new PlayerListeners(), this);
    }
}
