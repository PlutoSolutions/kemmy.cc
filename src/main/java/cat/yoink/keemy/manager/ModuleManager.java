package cat.yoink.keemy.manager;

import cat.yoink.keemy.module.Module;
import cat.yoink.keemy.module.impl.keemy.ClickGUI;
import cat.yoink.keemy.module.impl.visuals.Fullbright;

import java.util.ArrayList;
import java.util.Arrays;

public final class ModuleManager extends ArrayList<Module> {
    private static final ModuleManager instance = new ModuleManager();

    private ModuleManager() {
        addAll(Arrays.asList(new Fullbright(), new ClickGUI()));
    }

    public static ModuleManager getInstance() {
        return instance;
    }
}
