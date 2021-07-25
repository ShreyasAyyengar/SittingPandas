package me.shreyasayyengar.sittingpandas.NMS;

import net.minecraft.server.v1_14_R1.DataWatcherObject;
import net.minecraft.server.v1_14_R1.EntityPanda;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftPanda;
import org.bukkit.entity.Panda;

import java.lang.reflect.Field;

public class NMS_v1_14_R1 implements NMS{

    @Override
    public void applyDataWatcher(Panda panda) {
        EntityPanda entityPanda = ((CraftPanda) panda).getHandle();

        try {
            Field pandaField = EntityPanda.class.getDeclaredField("bF");
            pandaField.setAccessible(true);

            DataWatcherObject<Byte> watcher = (DataWatcherObject<Byte>) pandaField.get(entityPanda);

            if (!entityPanda.dX())
                entityPanda.r(true);
            else
                entityPanda.getDataWatcher().set(watcher, (byte) 0x01);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
