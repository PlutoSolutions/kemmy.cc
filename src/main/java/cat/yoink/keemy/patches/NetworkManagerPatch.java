package cat.yoink.keemy.patches;

import net.minecraft.network.NetworkManager;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NetworkManager.class)
public class NetworkManagerPatch {
    // TODO: 2/3/2021 add packet events
}
