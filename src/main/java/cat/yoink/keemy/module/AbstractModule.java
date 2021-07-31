package cat.yoink.keemy.module;

import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.input.Keyboard;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public abstract class AbstractModule implements Module {
    private final String name;
    private final ModuleCategory category;
    private int keybind;
    private boolean state;

    protected AbstractModule() {
        Manifest manifest = getClass().getAnnotation(Manifest.class);
        this.name = manifest.name();
        this.category = manifest.category();
        this.keybind = manifest.keybind();
        this.state = manifest.state();
    }

    protected void onEnable() {}
    protected void onDisable() {}

    @Override
    public final String getName() {
        return name;
    }

    @Override
    public final ModuleCategory getCategory() {
        return category;
    }

    @Override
    public final int getKeybind() {
        return keybind;
    }

    @Override
    public final void setKeybind(int keybind) {
        this.keybind = keybind;
    }

    @Override
    public final boolean getState() {
        return state;
    }

    @Override
    public final void setState(boolean state) {
        if (this.state == state) return;
        this.state = state;
        if (state) {
            if (nullCheck()) onEnable();
            MinecraftForge.EVENT_BUS.register(this);
        } else {
            if (nullCheck()) onDisable();
            MinecraftForge.EVENT_BUS.unregister(this);
        }
    }

    @Override
    public String getArrayText() {
        return null;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface Manifest {
        String name();

        ModuleCategory category();

        int keybind() default Keyboard.KEY_NONE;

        boolean state() default false;
    }
}
