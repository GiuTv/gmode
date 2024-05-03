package org.giutv.gmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.giutv.gmode.utils.CommandManager;
import org.giutv.gmode.utils.Utils;

import static org.giutv.gmode.commands.methods.getconf;

public class gmspcommand extends CommandManager {

    public gmspcommand() {
        super("gmsp", false);
    }
    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission(getconf("gmsp.perms"))) {
            if (args.length != 0 && p.hasPermission(getconf("gmsp.tootherperms"))) {
                Player target = Bukkit.getPlayer(args[0]);
                p.sendMessage(Utils.color(getconf("gmsp.messagetoother")).replace("{target}", target.getName()));
                methods.gmsp(target);
            }
            else {
                p.sendMessage(Utils.color(getconf("gmsp.message")));
                methods.gmsp(p);
            }

        }
        else {
            p.sendMessage(Utils.color(getconf("gmsp.nopermission")));
        }

        return false;
    }
}
