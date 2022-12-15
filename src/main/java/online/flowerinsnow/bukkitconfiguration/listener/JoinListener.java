package online.flowerinsnow.bukkitconfiguration.listener;

import online.flowerinsnow.bukkitconfiguration.config.Config;
import online.flowerinsnow.bukkitconfiguration.config.MessageConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    @SuppressWarnings("DataFlowIssue")
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (Config.Join.VIP_LIST.getOrDefault().contains(e.getPlayer().getUniqueId().toString())) { // 是VIP
            if (Config.Join.CUSTOM_MESSAGE_VIP.getOrDefault()) {
                e.setJoinMessage(null);
                MessageConfig.Vip.JOIN.broadcast(e.getPlayer().getName());
                MessageConfig.Vip.WELCOME.send(e.getPlayer());
            }
        } else {
            if (Config.Join.CUSTOM_MESSAGE.getOrDefault()) {
                e.setJoinMessage(null);
                MessageConfig.JOIN.broadcast(e.getPlayer().getName());
            }
        }
    }
}
