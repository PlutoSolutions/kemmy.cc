package cat.yoink.keemy.util.font;

import cat.yoink.keemy.forge.Reference;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class FontManager extends ArrayList<MCFontRenderer> implements Reference {
    private static final FontManager instance = new FontManager();
    private MCFontRenderer currentFont;
    private boolean customFont = true;

    private FontManager() {
        add(new MCFontRenderer("Main", fontFromTTF(new ResourceLocation("font/tt-norms-pro-black.ttf"), Font.PLAIN, 16), true, true));

        setCurrentFont(get(0));
    }

    public Font fontFromTTF(ResourceLocation fontLocation, int fontType, float fontSize) {
        Font output = null;
        try {
            output = Font.createFont(fontType, mc.getResourceManager().getResource(fontLocation).getInputStream());
            output = output.deriveFont(fontSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public Font fontFromTTF(File fontLocation, float fontSize, int fontType) {
        Font output = null;
        try {
            output = Font.createFont(fontType, fontLocation);
            output = output.deriveFont(fontSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public MCFontRenderer getFontRenderer(String name) {
        return stream().filter(renderer -> renderer.getName().equals(name)).findAny().orElse(null);
    }

    public void setCurrentFont(MCFontRenderer currentFont) {
        this.currentFont = currentFont;
    }

    public boolean isUsingCustomFont() {
        return customFont;
    }

    public void setCustomFont(boolean customFont) {
        this.customFont = customFont;
    }

    public MCFontRenderer getCurrentFont() {
        return currentFont;
    }

    public static FontManager getInstance() {
        return instance;
    }
}
