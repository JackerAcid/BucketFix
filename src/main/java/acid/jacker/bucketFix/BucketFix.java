package acid.jacker.bucketFix;

import io.papermc.paper.event.player.PlayerArmSwingEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.java.JavaPlugin;

public final class BucketFix extends JavaPlugin implements Listener {
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
        switch (player.getInventory().getItem(hand).getType()) {
            case BUCKET:
            case WATER_BUCKET:
            case LAVA_BUCKET:
                break;
            default:
                return;
        }
        player.updateInventory();
    }
}
