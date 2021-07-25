package me.shreyasayyengar.sittingpandas;

import me.shreyasayyengar.sittingpandas.NMS.NMSUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SittingPandas extends JavaPlugin {

    private static SittingPandas instance;

    @Override
    public void onEnable() {
        SittingPandas.instance = this;
        NMSUtil.setupNMS();
        getLogger().info(ChatColor.GOLD + "Loaded with no errors!");

        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
    }

    @Override
    public void onDisable() {
        getLogger().warning("Shutting down...");
    }

    public static SittingPandas getInstance() {
        return instance;
    }

}
