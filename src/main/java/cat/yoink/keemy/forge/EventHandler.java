package cat.yoink.keemy.forge;

import cat.yoink.keemy.manager.ModuleManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public enum EventHandler {
    INSTANCE;

    @SubscribeEvent
    public void onInputKeyInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState() && Keyboard.getEventKey() != Keyboard.KEY_NONE) {
            ModuleManager.getInstance().stream().filter(module -> module.getKeybind() == Keyboard.getEventKey()).forEach(module -> module.setState(!module.getState()));
        }
    }
}
