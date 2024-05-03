package org.giutv.gmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.giutv.gmode.Gmode;
import org.giutv.gmode.utils.CommandManager;
import org.giutv.gmode.utils.Utils;

public class gmspcommand extends CommandManager {

    private final Plugin plugin = Gmode.getPlugin(Gmode.class);

    public gmspcommand(Gmode plugin) {
        super("gmsp", null, false);
    }
    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        // se ha il permesso
        if (p.hasPermission(getconf("gmsp.perms"))) {
            // se ha messo il target
            if (args.length != 0 && p.hasPermission(getconf("gmsp.tootherperms"))) {
                Player target = Bukkit.getPlayer(args[0]);
                p.sendMessage(Utils.color(getconf("gmsp.messagetoother")).replace("{target}", target.getName()));
                methods.gmsp(target);
            }
            // se non lo ha fatto
            else {
                p.sendMessage(Utils.color(getconf("gmsp.message")));
                methods.gmsp(p);
            }

        }
        // se non ha il permesso
        else {
            p.sendMessage(Utils.color(getconf("gmsp.nopermission")));
        }

        return false;
    }

    public String getconf(String conf) {
        String getcons = plugin.getConfig().getString(conf);
        return getcons;
    }
}
