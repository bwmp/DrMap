package org.acornmc.drmap;

import org.acornmc.drmap.command.CommandDrmap;
import org.acornmc.drmap.configuration.Config;
import org.acornmc.drmap.configuration.Lang;
import org.acornmc.drmap.listener.BukkitListener;
import org.acornmc.drmap.picture.PictureManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class DrMap extends JavaPlugin {

    private static DrMap instance;

    public DrMap() {
        instance = this;
    }

    public static DrMap getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        Config.reload(this);
        Lang.reload(this);

        PictureManager.INSTANCE.loadPictures();
        getServer().getPluginManager().registerEvents(new BukkitListener(this), this);
        getCommand("drmap").setExecutor(new CommandDrmap(this));
    }
}
