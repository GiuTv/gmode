package org.giutv.gmode.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.giutv.gmode.Gmode;

@SuppressWarnings("all")
public abstract class CommandManager implements CommandExecutor {
    private Gmode plugin = Gmode.getInstance();
    String command;
    String permissions;
    boolean useConsole;

        private final FileConfiguration config = Gmode.getInstance().getConfig();

    public CommandManager(String command, boolean useConsole){
        this.command = command;

        this.useConsole = useConsole;

        Gmode.getInstance().getCommand(command).setExecutor(this);
    }

    public abstract boolean execute(CommandSender sender, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!useConsole && !(sender instanceof Player)) {
            Bukkit.getLogger().warning("You can't execute this command from console.");
            return true;
        }

        execute(sender, args);

        return true;
    }
}