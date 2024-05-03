package org.giutv.gmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.giutv.gmode.Gmode;
import org.giutv.gmode.utils.CommandManager;
import org.giutv.gmode.utils.Utils;

public class gmodecommand extends CommandManager {

    private final Plugin plugin = Gmode.getPlugin(Gmode.class);

    public gmodecommand(Gmode plugin) {
        super("gmode", null, false);
    }
    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        if(args.length != 0 && p.hasPermission(getconf("gmode.perms"))) {
            if(args[0].equals("help")) {
                methods.help(p);
            }

            //
            // GMA
            //

            else if(args[0].equals("gma")) {
                if (args.length == 2 && args[1] != null && p.hasPermission(getconf("gma.tootherperms"))) {
                    Player target = Bukkit.getPlayer(args[1]);
                    p.sendMessage(Utils.color(getconf("gma.messagetoother")).replace("{target}", target.getName()));
                    methods.gma(target);
                }
                else if(p.hasPermission(getconf("gma.perms"))){
                    p.sendMessage(Utils.color(getconf("gma.message")));
                    methods.gma(p);
                }
                else {
                    p.sendMessage(Utils.color(getconf("gma.nopermission")));
                }
            }


            //
            // GMC
            //

            else if(args[0].equals("gmc")) {
                if (args.length == 2 && args[1] != null && p.hasPermission(getconf("gmc.tootherperms"))) {
                    Player target = Bukkit.getPlayer(args[1]);
                    p.sendMessage(Utils.color(getconf("gmc.messagetoother")).replace("{target}", target.getName()));
                    methods.gmc(target);
                }
                // se non lo ha fatto
                else if (p.hasPermission(getconf("gmc.perms"))){
                    p.sendMessage(Utils.color(getconf("gmc.message")));
                    methods.gmc(p);
                }
                else {
                    p.sendMessage(Utils.color(getconf("gmc.nopermission")));
                }
            }

            //
            // GMS
            //

            else if(args[0].equals("gms")) {
                if (args.length == 2 && args[1] != null && p.hasPermission(getconf("gms.tootherperms"))) {
                    Player target = Bukkit.getPlayer(args[1]);
                    p.sendMessage(Utils.color(getconf("gms.messagetoother")).replace("{target}", target.getName()));
                    methods.gms(target);
                }
                // se non lo ha fatto
                else if(p.hasPermission(getconf("gms.perms"))){
                    p.sendMessage(Utils.color(getconf("gms.message")));
                    methods.gms(p);
                }
                else {
                    p.sendMessage(Utils.color(getconf("gms.nopermission")));
                }
            }

            //
            // GMSP
            //

            else if(args[0].equals("gmsp")) {
                if (args.length == 2 && args[1] != null && p.hasPermission(getconf("gmsp.tootherperms"))) {
                    Player target = Bukkit.getPlayer(args[1]);
                    p.sendMessage(Utils.color(getconf("gmsp.messagetoother")).replace("{target}", target.getName()));
                    methods.gmsp(target);
                }
                // se non lo ha fatto
                else if(p.hasPermission(getconf("gmsp.perms"))){
                    p.sendMessage(Utils.color(getconf("gmsp.message")));
                    methods.gmsp(p);
                }
                else {
                    p.sendMessage(Utils.color(getconf("gmsp.nopermission")));
                }
            }
            else if(args[0].equals("reload")) {
                plugin.reloadConfig();
                p.sendMessage(Utils.color(getconf("gmode.reload")));
            } else {
                methods.help(p);
            }

        } else {
            p.sendMessage(Utils.color(getconf("gmode.nopermission")));
        }
        return false;
    }

    public String getconf(String conf) {
        String getcons = plugin.getConfig().getString(conf);
        return getcons;
    }
}
