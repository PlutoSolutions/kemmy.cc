package cat.yoink.keemy.gui;

import cat.yoink.keemy.Client;
import cat.yoink.keemy.module.ModuleCategory;
import cat.yoink.keemy.traits.Gui;
import cat.yoink.keemy.util.GuiUtil;
import cat.yoink.keemy.util.font.FontManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class MainPanel implements Gui {
    private final List<Gui> categoryButtons = new ArrayList<>();
    private int x, y, w, h;

    public MainPanel(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        ModuleCategory[] values = ModuleCategory.values();
        for (int i = 0, valuesLength = values.length; i < valuesLength; i++) {
            ModuleCategory category = values[i];
            categoryButtons.add(new CategoryButton(category, x, i * 20 + 50, w / 4, 15));
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        GuiUtil.drawRect(x, y, w / 4, h, new Color(0xA9060606, true));
        GuiUtil.drawRect(x + w / 4, y, w / 4 * 3, h, new Color(0x060606));

        FontManager.getInstance().getFontRenderer("ClickGuiTitle").drawCenteredString(Client.INSTANCE.getName().toUpperCase(Locale.ROOT),
                x + (w / 4f) / 2, y + 7, -1);

        for (Gui button : categoryButtons) {
            button.drawScreen(mouseX, mouseY, partialTicks);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (Gui button : categoryButtons) {
            button.mouseClicked(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        for (Gui button : categoryButtons) {
            button.mouseReleased(mouseX, mouseY, state);
        }
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        for (Gui button : categoryButtons) {
            button.keyTyped(typedChar, keyCode);
        }
    }

    @Override
    public void onGuiClosed() {
        for (Gui button : categoryButtons) {
            button.onGuiClosed();
        }
    }
}
