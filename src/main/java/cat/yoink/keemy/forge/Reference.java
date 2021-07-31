package cat.yoink.keemy.forge;

import net.minecraft.client.Minecraft;

public interface Reference {
    String MOD_NAME = "keemy.cc";
    String MOD_ID = "keemy";
    String MOD_VERSION = "1";

    Minecraft mc = Minecraft.getMinecraft();

    default boolean nullCheck() {
        return mc.player != null && mc.world != null;
    }
}
