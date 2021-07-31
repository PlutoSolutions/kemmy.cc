package cat.yoink.keemy.module.impl.keemy;

import cat.yoink.keemy.gui.MainGui;
import cat.yoink.keemy.module.AbstractModule;
import cat.yoink.keemy.module.ModuleCategory;
import org.lwjgl.input.Keyboard;

@AbstractModule.Manifest(name = "ClickGUI", category = ModuleCategory.KEEMY, keybind = Keyboard.KEY_RSHIFT)
public class ClickGUI extends AbstractModule {
    @Override
    protected void onEnable() {
       mc.displayGuiScreen(MainGui.getInstance());
    }
}
