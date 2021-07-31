package cat.yoink.keemy.gui;

import cat.yoink.keemy.traits.Gui;
import cat.yoink.keemy.util.font.FontManager;
import cat.yoink.keemy.util.font.MCFontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public final class MainGui extends GuiScreen implements Gui {
    private static final MainGui INSTANCE = new MainGui();
    private final Gui panel;

    private MainGui() {
        FontManager.getInstance().add(new MCFontRenderer("ClickGuiTitle", FontManager.getInstance().fontFromTTF(new ResourceLocation("font/tt-norms-pro-black.ttf"), Font.PLAIN, 30), true, true));
        FontManager.getInstance().add(new MCFontRenderer("ClickGuiCategory", FontManager.getInstance().fontFromTTF(new ResourceLocation("font/interval-next-semi-bold.ttf"), Font.PLAIN, 16), true, true));

        panel = new MainPanel(10, 10, 400, 300);
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        panel.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        panel.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        panel.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    public void keyTyped(char typedChar, int keyCode) {
        panel.keyTyped(typedChar, keyCode);
        if (keyCode == Keyboard.KEY_ESCAPE) mc.displayGuiScreen(null);
    }

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();
    }

    public static MainGui getInstance() {
        return INSTANCE;
    }
}
