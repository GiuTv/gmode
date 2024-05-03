package org.giutv.gmode.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager extends YamlConfiguration {
    private final File file;

    public FileManager(JavaPlugin plugin, String name) {
        this.file = new File(plugin.getDataFolder(), name);
        if (!this.file.exists())
            plugin.saveResource(name, false);
        try {
            load(this.file);
        } catch (IOException | org.bukkit.configuration.InvalidConfigurationException ex2) {
            Exception ex = null;
            Exception e = ex;
            e.printStackTrace();
        }
    }

    public FileManager(JavaPlugin plugin, String name, boolean ignored) {
        this.file = new File(plugin.getDataFolder(), name);
        if (!this.file.exists())
            plugin.saveResource(name, false);
        try {
            load(this.file);
        } catch (IOException|org.bukkit.configuration.InvalidConfigurationException ex2) {
            Exception ex = null;
            Exception e = ex;
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            save(this.file);
        } catch (IOException e) {
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

    public String getUnColoredString(String path) {
        if (!contains(path))
            throw new NullPointerException("Path at '" + path + "' not found");
        return getString(path, null);
    }

    public String getString(String path) {
        if (!contains(path))
            throw new NullPointerException("Path at '" + path + "' not found");
        return ChatColor.translateAlternateColorCodes('&', getString(path, "&bString at path &7'&3" + path + "&7' &bnot found.").replace("{0}", "\n"));
    }

    public List<String> getStringList(String path) {
        if (!contains(path))
            throw new NullPointerException("Path at '" + path + "' not found");
        return (List<String>)super.getStringList(path).stream().map(str -> ChatColor.translateAlternateColorCodes('&', str)).collect(Collectors.toList());
    }

    public File getFile() {
        return this.file;
    }
}
