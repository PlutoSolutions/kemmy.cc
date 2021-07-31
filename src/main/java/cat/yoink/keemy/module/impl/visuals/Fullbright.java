package cat.yoink.keemy.module.impl.visuals;

import cat.yoink.keemy.module.AbstractModule;
import cat.yoink.keemy.module.ModuleCategory;
import org.lwjgl.input.Keyboard;

@AbstractModule.Manifest(name = "Fullbright", category = ModuleCategory.VISUALS, keybind = Keyboard.KEY_P)
public final class Fullbright extends AbstractModule {
    private float oldGamma;

    @Override
    protected void onEnable() {
        oldGamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 1000;
    }

    @Override
    protected void onDisable() {
        mc.gameSettings.gammaSetting = oldGamma;
    }
}
