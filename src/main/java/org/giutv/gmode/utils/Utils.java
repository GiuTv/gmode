package org.giutv.gmode.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
import org.giutv.gmode.Gmode;

@UtilityClass
public class Utils {
    public String color(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public String getMessage(String path) {
        return color(Gmode.getInstance().getConfig().getString(path));
    }
}