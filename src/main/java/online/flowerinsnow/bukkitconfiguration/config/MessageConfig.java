package online.flowerinsnow.bukkitconfiguration.config;

import cc.carm.lib.configuration.core.ConfigurationRoot;
import cc.carm.lib.mineconfiguration.bukkit.value.ConfiguredMessageList;

public class MessageConfig extends ConfigurationRoot {
    public static final ConfiguredMessageList<String> JOIN = ConfiguredMessageList.asStrings()
            .defaults("&6欢迎&e%(player)&6加入服务器").params("player").build();

    public static class Vip extends ConfigurationRoot {
        public static final ConfiguredMessageList<String> JOIN = ConfiguredMessageList.asStrings()
                .defaults("&6欢迎&aVIP &e%(player)&6加入服务器").params("player").build();

        public static final ConfiguredMessageList<String> WELCOME = ConfiguredMessageList
                .ofStrings("&6欢迎回来！尊贵的&aVIP");
    }
}
