package org.giutv.gmode.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
public class FileManager extends YamlConfiguration {

    public FileManager(JavaPlugin plugin, String name) {
        File file = new File(plugin.getDataFolder(), name);
        if (!file.exists())
            plugin.saveResource(name, false);
        try {
            load(file);
        } catch (IOException | NullPointerException | org.bukkit.configuration.InvalidConfigurationException ex2) {
            Exception e = null;
            e.printStackTrace();
        }
    }

    public int getInt(String path) {
        if (!contains(path))
            throw new NullPointerException("Path at '" + path + "' not found");
        return getInt(path, 0);
    }

    public double getDouble(String path) {
        if (!contains(path))
            throw new NullPointerException("Path at '" + path + "' not found");
        return getDouble(path, 0.0D);
    }

    public boolean getBoolean(String path) {
        if (!contains(path))
            throw new NullPointerException("Path at '" + path + "' not found");
        return getBoolean(path, false);
    }

    public String getString(String path) {
        if (!contains(path))
            throw new NullPointerException("Path at '" + path + "' not found");
        return ChatColor.translateAlternateColorCodes('&', getString(path, "&bString at path &7'&3" + path + "&7' &bnot found.").replace("{0}", "\n"));
    }

}
