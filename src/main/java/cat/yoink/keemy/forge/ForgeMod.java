package cat.yoink.keemy.forge;

import cat.yoink.keemy.Client;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_NAME, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public final class ForgeMod {
    @Mod.EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        Runtime.getRuntime().addShutdownHook(new Thread(Client.INSTANCE::stop));
        Client.INSTANCE.start();
        MinecraftForge.EVENT_BUS.register(EventHandler.INSTANCE);
    }
}