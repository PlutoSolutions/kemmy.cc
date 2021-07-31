package cat.yoink.keemy.gui;

import cat.yoink.keemy.module.ModuleCategory;
import cat.yoink.keemy.traits.Gui;
import cat.yoink.keemy.util.GuiUtil;
import cat.yoink.keemy.util.Timer;
import cat.yoink.keemy.util.font.FontManager;
import cat.yoink.keemy.util.font.MCFontRenderer;

import java.awt.*;

public class CategoryButton implements Gui {
    private final ModuleCategory category;
    private int x, y, w, h;
    private boolean selected;

    public CategoryButton(ModuleCategory category, int x, int y, int w, int h) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        if (selected) GuiUtil.drawSmoothRect(x + 5, y + 2, w - 10, h - 4, 4, new Color(0x3e3e3e).getRGB());

        MCFontRenderer fontRenderer = FontManager.getInstance().getFontRenderer("ClickGuiCategory");
        fontRenderer.drawString(category.getName(), x + 12, y + 5, -1);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {

    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {

    }

    @Override
    public void keyTyped(char typedChar, int keyCode) {

    }

    @Override
    public void onGuiClosed() {

    }
}
