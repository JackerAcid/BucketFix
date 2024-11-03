package acid.jacker.bucketDisplayFix;

import io.papermc.paper.event.player.PlayerArmSwingEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class BucketDisplayFix extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }

    @EventHandler
    public void onPlayerArmSwing(PlayerArmSwingEvent event) {
        Player player = event.getPlayer();
        EquipmentSlot hand = event.getHand();
        ItemStack item = player.getInventory().getItem(hand);
        switch (item.getType()) {
            case BUCKET, WATER_BUCKET, LAVA_BUCKET, POWDER_SNOW_BUCKET:
                break;
            default:
                return;
        }
        player.updateInventory();
    }
}
