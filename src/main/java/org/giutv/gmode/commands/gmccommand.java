package org.giutv.gmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.giutv.gmode.Gmode;
import org.giutv.gmode.utils.CommandManager;
import org.giutv.gmode.utils.Utils;

public class gmccommand extends CommandManager {

    private final Plugin plugin = Gmode.getPlugin(Gmode.class);

    public gmccommand() {
        super("gmc",  false);
    }
    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission(getconf("gmc.perms"))) {
            if (args.length != 0 && p.hasPermission(getconf("gmc.tootherperms"))) {
                Player target = Bukkit.getPlayer(args[0]);
                p.sendMessage(Utils.color(getconf("gmc.messagetoother")).replace("{target}", target.getName()));
                methods.gmc(target);
            }
            else {
                p.sendMessage(Utils.color(getconf("gmc.message")));
                methods.gmc(p);
            }

        }
        else {
            p.sendMessage(Utils.color(getconf("gmc.nopermission")));
        }

        return false;
    }

    public String getconf(String conf) {
        return plugin.getConfig().getString(conf);
    }
}
