package org.giutv.gmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.giutv.gmode.Gmode;
import org.giutv.gmode.utils.CommandManager;
import org.giutv.gmode.utils.Utils;

public class gmodecommand extends CommandManager {

    private final Plugin plugin = Gmode.getPlugin(Gmode.class);

    public gmodecommand() {
        super("gmode", false);
    }
    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length != 0 && p.hasPermission(getconf("gmode.perms"))) {
            String arg = args[0];
            switch (arg) {
                case "help":
                    methods.help(p);

                case "gma":
                    if (args.length == 2 && args[1] != null && p.hasPermission(getconf("gma.tootherperms"))) {
                        Player target = Bukkit.getPlayer(args[1]);
                        p.sendMessage(Utils.color(getconf("gma.messagetoother")).replace("{target}", target.getName()));
                        methods.gma(target);
                    } else if (p.hasPermission(getconf("gma.perms"))) {
                        p.sendMessage(Utils.color(getconf("gma.message")));
                        methods.gma(p);
                    } else {
                        p.sendMessage(Utils.color(getconf("gma.nopermission")));
                    }


                case "gmc":
                    if (args.length == 2 && args[1] != null && p.hasPermission(getconf("gmc.tootherperms"))) {
                        Player target = Bukkit.getPlayer(args[1]);
                        p.sendMessage(Utils.color(getconf("gmc.messagetoother")).replace("{target}", target.getName()));
                        methods.gmc(target);
                    } else if (p.hasPermission(getconf("gmc.perms"))) {
                        p.sendMessage(Utils.color(getconf("gmc.message")));
                        methods.gmc(p);
                    } else {
                        p.sendMessage(Utils.color(getconf("gmc.nopermission")));
                    }
                case "gms":
                    if (args.length == 2 && args[1] != null && p.hasPermission(getconf("gms.tootherperms"))) {
                        Player target = Bukkit.getPlayer(args[1]);
                        p.sendMessage(Utils.color(getconf("gms.messagetoother")).replace("{target}", target.getName()));
                        methods.gms(target);
                    } else if (p.hasPermission(getconf("gms.perms"))) {
                        p.sendMessage(Utils.color(getconf("gms.message")));
                        methods.gms(p);
                    } else {
                        p.sendMessage(Utils.color(getconf("gms.nopermission")));
                    }

                case "gmsp":
                    if (args.length == 2 && args[1] != null && p.hasPermission(getconf("gmsp.tootherperms"))) {
                        Player target = Bukkit.getPlayer(args[1]);
                        p.sendMessage(Utils.color(getconf("gmsp.messagetoother")).replace("{target}", target.getName()));
                        methods.gmsp(target);
                    } else if (p.hasPermission(getconf("gmsp.perms"))) {
                        p.sendMessage(Utils.color(getconf("gmsp.message")));
                        methods.gmsp(p);
                    } else {
                        p.sendMessage(Utils.color(getconf("gmsp.nopermission")));
                    }
                case "reload":
                    plugin.reloadConfig();
                    p.sendMessage(Utils.color(getconf("gmode.reload")));
                default:
                    methods.help(p);
            }
        } else {
            p.sendMessage(Utils.color(getconf("gmode.nopermission")));
        }
        return false;
    }


    public String getconf(String conf) {
        return plugin.getConfig().getString(conf);
    }
}
