package org.giutv.gmode.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.giutv.gmode.Gmode;
import org.giutv.gmode.utils.CommandManager;
import org.giutv.gmode.utils.Utils;

public class gmacommand extends CommandManager {

    private final Plugin plugin = Gmode.getPlugin(Gmode.class);

    public gmacommand() {
        super("gma", null, false);
    }
    @Override
    public boolean execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
            // se ha il permesso
            if (p.hasPermission(getconf("gma.perms"))) {
                // se ha messo il target
                    if (args.length != 0 && p.hasPermission(getconf("gma.tootherperms"))) {
                        Player target = Bukkit.getPlayer(args[0]);
                        p.sendMessage(Utils.color(getconf("gma.messagetoother")).replace("{target}", target.getName()));
                        methods.gma(target);
                    }
                // se non lo ha fatto
                else {
                    p.sendMessage(Utils.color(getconf("gma.message")));
                        methods.gma(p);
                }

            }
            // se non ha il permesso
            else {
                p.sendMessage(Utils.color(getconf("gma.nopermission")));
            }

        return false;
    }

    public String getconf(String conf) {
        return plugin.getConfig().getString(conf);
    }
}
