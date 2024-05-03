package org.giutv.gmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.giutv.gmode.Gmode;
import org.giutv.gmode.utils.BukkitPlugin;
import org.giutv.gmode.utils.Utils;

public class methods {

    private static final Plugin plugin = Gmode.getPlugin(Gmode.class);

    public static void gmc(Player target) {
        target.setGameMode(GameMode.CREATIVE);
    }

    public static void gms(Player target) {
        target.setGameMode(GameMode.SURVIVAL);
    }

    public static void gmsp(Player target) {
        target.setGameMode(GameMode.SPECTATOR);
    }

    public static void gma(Player target) {
        target.setGameMode(GameMode.ADVENTURE);
    }

    public static void help(Player p) {
        p.sendMessage(Utils.color(getconf("gmode.help.title")));
        p.sendMessage(Utils.color(getconf("gmode.help.gmchelp")));
        p.sendMessage(Utils.color(getconf("gmode.help.gmshelp")));
        p.sendMessage(Utils.color(getconf("gmode.help.gmahelp")));
        p.sendMessage(Utils.color(getconf("gmode.help.gmsphelp")));
        p.sendMessage(Utils.color(getconf("gmode.help.gmreloadhelp")));
        p.sendMessage(Utils.color(getconf("gmode.help.gmhelp")));
    }

    public static String getconf(String conf) {
        String getcons = plugin.getConfig().getString(conf);
        return getcons;
    }

}
