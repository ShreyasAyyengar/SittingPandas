package me.shreyasayyengar.sittingpandas;

import me.shreyasayyengar.sittingpandas.NMS.NMSUtil;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

public class InteractEvent implements Listener {

    @EventHandler
    private void onInteract(PlayerInteractAtEntityEvent e) {
        Player player = e.getPlayer();

        if (e.getHand() == EquipmentSlot.HAND) {
            if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {

                if (e.getRightClicked().getType() == EntityType.PANDA) {
                    Panda panda = (Panda) e.getRightClicked();
                    NMSUtil.getNMS().applyDataWatcher(panda);
                }
            }
        }
    }
}
