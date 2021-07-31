package cat.yoink.keemy.util;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GuiUtil {
    public static void drawRect(int x, int y, int w, int h, Color c) {
        drawRect(x, y, w, h, c.getRGB());
    }

    public static void drawRect(int x, int y, int w, int h, int c) {
        Gui.drawRect(x, y, x + w, y + h, c);
    }

    public static void drawRectWithOutline(int x, int y, int w, int h, Color c, Color oC) {
        drawRect(x, y, w, h, c);
        drawRect(x, y, w, 1, oC);
        drawRect(x, y, 1, h, oC);
        drawRect(x + w - 1, y, 1, h, oC);
        drawRect(x, y + h - 1, w, 1, oC);
    }

    public static void drawGradient(int x, int y, int w, int h, Color tlC, Color trC, Color blC, Color brC) {
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        GlStateManager.shadeModel(7425);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_COLOR);
        bufferbuilder.pos(x + w, y, 0).color(trC.getRed(), trC.getGreen(), trC.getBlue(), trC.getAlpha()).endVertex(); // Top right
        bufferbuilder.pos(x, y, 0).color(tlC.getRed(), tlC.getGreen(), tlC.getBlue(), tlC.getAlpha()).endVertex(); // Top left
        bufferbuilder.pos(x, y + h, 0).color(blC.getRed(), blC.getGreen(), blC.getBlue(), blC.getAlpha()).endVertex(); // Bottom left
        bufferbuilder.pos(x + w, y + h, 0).color(brC.getRed(), brC.getGreen(), brC.getBlue(), brC.getAlpha()).endVertex(); // Bottom right
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public static boolean isHover(int x, int y, int w, int h, int mX, int mY) {
        return mX > x && mX < x + w && mY > y && mY < y + h;
    }

    public static void drawCircle(double x, double y, int radius, int sides) {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        Tessellator.getInstance().getBuffer().begin(GL11.GL_TRIANGLE_FAN, DefaultVertexFormats.POSITION);
        Tessellator.getInstance().getBuffer().pos(x, y, 0).endVertex();

        for (int i = 0; i <= sides; i++) {
            double angle = (Math.PI * 2 * i / sides) + Math.toRadians(180);
            Tessellator.getInstance().getBuffer().pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0).endVertex();
        }
        Tessellator.getInstance().draw();

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }

    public static void drawSmoothRect(int x, int y, int w, int h, int smoothness, int color) {
        drawRect(x + smoothness, y, w - smoothness * 2, h, color);
        drawRect(x, y + smoothness, w, h - smoothness * 2, color);
        drawCircle(x + smoothness, y + smoothness, smoothness, smoothness * 2);
        drawCircle(x + w - smoothness, y + smoothness, smoothness, smoothness * 2);
        drawCircle(x + smoothness, y + h - smoothness, smoothness, smoothness * 2);
        drawCircle(x + w - smoothness, y + h - smoothness, smoothness, smoothness * 2);
    }
}
