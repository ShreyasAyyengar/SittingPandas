package me.shreyasayyengar.sittingpandas.NMS;

import net.minecraft.network.syncher.DataWatcherObject;
import net.minecraft.world.entity.animal.EntityPanda;
import org.bukkit.craftbukkit.v1_17_R1.entity.CraftPanda;
import org.bukkit.entity.Panda;

import java.lang.reflect.Field;

public class NMS_v1_17_R1 implements NMS {

    @Override
    public void applyDataWatcher(Panda panda) {
        EntityPanda entityPanda = ((CraftPanda) panda).getHandle();

        try {
            Field pandaField = EntityPanda.class.getDeclaredField("cb");
            pandaField.setAccessible(true);

            DataWatcherObject<Byte> watcher = (DataWatcherObject<Byte>) pandaField.get(entityPanda);

            if (!entityPanda.fw())
                entityPanda.v(true);
            else
                entityPanda.getDataWatcher().set(watcher, (byte) 0x01);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
