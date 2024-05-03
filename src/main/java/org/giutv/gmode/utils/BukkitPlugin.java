package org.giutv.gmode.utils;

import org.giutv.gmode.Gmode;

public class BukkitPlugin
{

    private static final Gmode instance = Gmode.getInstance();

    public static String getVersion() {
        return instance.getDescription().getVersion();
    }

}
