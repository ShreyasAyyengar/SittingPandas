package me.shreyasayyengar.sittingpandas.NMS;

import me.shreyasayyengar.sittingpandas.SittingPandas;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class NMSUtil {

    private static NMS nms;

    public static void setupNMS() {
        String version = null;

        try {
            version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
        } catch (ArrayIndexOutOfBoundsException e) {
            Bukkit.getLogger().severe(ChatColor.RED + "Something went wrong when loading SittingPandas");
            Bukkit.getScheduler().cancelTasks(SittingPandas.getInstance());
            Bukkit.getPluginManager().disablePlugin(SittingPandas.getInstance());
        }

        switch (version) {
            case "v1_14_R1":
                nms = new NMS_v1_14_R1();
                Bukkit.getLogger().info(ChatColor.YELLOW + "Detected version " + version);
                break;
            case "v1_15_R1":
                nms = new NMS_v1_15_R1();
                Bukkit.getLogger().info(ChatColor.YELLOW + "Detected version " + version);
                break;
            case "v1_16_R1":
                nms = new NMS_v1_16_R1();
                Bukkit.getLogger().info(ChatColor.YELLOW + "Detected version " + version);
                break;
            case "v1_16_R2":
                nms = new NMS_v1_16_R2();
                Bukkit.getLogger().info(ChatColor.YELLOW + "Detected version " + version);
                break;
            case "v1_16_R3":
                nms = new NMS_v1_16_R3();
                Bukkit.getLogger().info(ChatColor.YELLOW + "Detected version " + version);
                break;
            case "v1_17_R1":
                nms = new NMS_v1_17_R1();
                Bukkit.getLogger().info(ChatColor.YELLOW + "Detected version " + version);
                break;
            default:
                Bukkit.getLogger().severe( "Your current version " + version + " is not supported yet!");
                Bukkit.getLogger().severe("Shutting down...");
                Bukkit.getScheduler().cancelTasks(SittingPandas.getInstance());
                Bukkit.getPluginManager().disablePlugin(SittingPandas.getInstance());
                break;
        }
    }

    public static NMS getNMS() {
        return nms;
    }
}
