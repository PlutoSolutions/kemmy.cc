package cat.yoink.keemy.module;

import cat.yoink.keemy.forge.Reference;
import cat.yoink.keemy.traits.Nameable;

public interface Module extends Nameable, Reference {
    ModuleCategory getCategory();

    int getKeybind();

    void setKeybind(int keybind);

    boolean getState();

    void setState(boolean state);

    String getArrayText();
}
