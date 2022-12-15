package online.flowerinsnow.bukkitconfiguration;

import cc.carm.lib.configuration.core.source.ConfigurationProvider;
import cc.carm.lib.mineconfiguration.bukkit.MineConfiguration;
import online.flowerinsnow.bukkitconfiguration.config.Config;
import online.flowerinsnow.bukkitconfiguration.config.MessageConfig;
import online.flowerinsnow.bukkitconfiguration.listener.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitConfiguration extends JavaPlugin {
    private static BukkitConfiguration instance;

    private static ConfigurationProvider<?> configProvider;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        loadConfiguration();

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    /**
     * 加载配置文件
     */
    public static void loadConfiguration() {
        configProvider = MineConfiguration.from(instance, "config.yml");
        configProvider.initialize(Config.class);

        ConfigurationProvider<?> messageProvider = MineConfiguration.from(instance, "messages.yml");
        messageProvider.initialize(MessageConfig.class);
    }

    public static void saveConfiguration() {
        try {
            configProvider.save();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static BukkitConfiguration getInstance() {
        return instance;
    }
}
