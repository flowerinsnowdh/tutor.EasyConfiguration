package online.flowerinsnow.bukkitconfiguration.config;

import cc.carm.lib.configuration.core.ConfigurationRoot;
import cc.carm.lib.configuration.core.annotation.ConfigPath;
import cc.carm.lib.configuration.core.annotation.HeaderComment;
import cc.carm.lib.configuration.core.value.type.ConfiguredList;
import cc.carm.lib.configuration.core.value.type.ConfiguredValue;

public class Config extends ConfigurationRoot {
    /*
    # 版本，勿动
    version: 1
    join:
      # 自定义进入消息
      custom-message: true
      # VIP自定义进入消息
      custom_message_vip: true
     */

    @HeaderComment("版本，勿动")
    public static final ConfiguredValue<Integer> VERSION = ConfiguredValue.of(Integer.class, 1);

    public static class Join extends ConfigurationRoot {
        @HeaderComment("自定义进入消息")
        public static final ConfiguredValue<Boolean> CUSTOM_MESSAGE = ConfiguredValue.of(Boolean.class, true);
        @HeaderComment("VIP自定义进入消息")
        @ConfigPath("custom_message_vip")
        public static final ConfiguredValue<Boolean> CUSTOM_MESSAGE_VIP = ConfiguredValue.of(Boolean.class, true);

        public static final ConfiguredList<String> VIP_LIST = ConfiguredList.builder(String.class)
                .fromString().defaults("d73a11c3-da45-4e31-ab77-35f454755fc0").build();
    }
}
