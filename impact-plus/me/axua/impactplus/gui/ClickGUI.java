/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.util.ResourceLocation
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.gui;

import java.io.IOException;
import java.util.ArrayList;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.gui.Component;
import me.axua.impactplus.gui.Frame;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ClickGUI
extends GuiScreen {
    public static /* synthetic */ ArrayList<Frame> frames;

    public boolean doesGuiPauseGame() {
        return false;
    }

    public void drawScreen(int lIllIllllIlIIIl, int lIllIllllIlIIII, float lIllIllllIlIlII) {
        ClickGUI lIllIllllIlIIlI;
        ScaledResolution lIllIllllIlIIll = new ScaledResolution(lIllIllllIlIIlI.mc);
        for (Frame lIllIllllIllIII : frames) {
            lIllIllllIllIII.renderFrame(lIllIllllIlIIlI.fontRendererObj);
            lIllIllllIllIII.updatePosition(lIllIllllIlIIIl, lIllIllllIlIIII);
            for (Component lIllIllllIllIIl : lIllIllllIllIII.getComponents()) {
                lIllIllllIllIIl.updateComponent(lIllIllllIlIIIl, lIllIllllIlIIII);
            }
        }
        GL11.glPushMatrix();
        GL11.glTranslated((double)(lIllIllllIlIIll.getScaledWidth() - 2), (double)(lIllIllllIlIIll.getScaledHeight() - 2), (double)0.0);
        GL11.glScaled((double)1.0, (double)1.0, (double)1.0);
        ImpactPlus.CustomFont.drawStringWithShadow("Axua on top!", -ImpactPlus.CustomFont.getStringWidth("Axua on top!"), -ImpactPlus.CustomFont.FONT_HEIGHT, Rainbow.getColor().getRGB());
        GL11.glPopMatrix();
    }

    public void onGuiClosed() {
        if (OpenGlHelper.shadersSupported) {
            ClickGUI lIllIlllIIIlIIl;
            lIllIlllIIIlIIl.mc.entityRenderer.stopUseShader();
        }
    }

    public ClickGUI() {
        ClickGUI lIllIlllllIllll;
        frames = new ArrayList();
        int lIllIlllllIlllI = 155;
        int lIllIlllllIllIl = 5;
        for (Module.Category lIllIllllllIIII : Module.Category.values()) {
            if (lIllIllllllIIII == Module.Category.HUD) continue;
            Frame lIllIllllllIIIl = new Frame(lIllIllllllIIII);
            lIllIllllllIIIl.setX(lIllIlllllIlllI);
            lIllIllllllIIIl.setY(lIllIlllllIllIl);
            frames.add(lIllIllllllIIIl);
            lIllIlllllIlllI += lIllIllllllIIIl.getWidth() + 4;
        }
    }

    public void initGui() {
        if (ClickGuiModule.blur.getValue() && OpenGlHelper.shadersSupported) {
            ClickGUI lIllIlllllIIIlI;
            lIllIlllllIIIlI.mc.entityRenderer.loadShader(new ResourceLocation("minecraft", "shaders/post/blur.json"));
        }
    }

    protected void mouseClicked(int lIllIlllIlllllI, int lIllIlllIlllIlI, int lIllIlllIlllIIl) throws IOException {
        for (Frame lIllIllllIIIIII : frames) {
            if (lIllIllllIIIIII.isWithinHeader(lIllIlllIlllllI, lIllIlllIlllIlI) && lIllIlllIlllIIl == 0) {
                lIllIllllIIIIII.setDrag(true);
                lIllIllllIIIIII.dragX = lIllIlllIlllllI - lIllIllllIIIIII.getX();
                lIllIllllIIIIII.dragY = lIllIlllIlllIlI - lIllIllllIIIIII.getY();
            }
            if (lIllIllllIIIIII.isWithinHeader(lIllIlllIlllllI, lIllIlllIlllIlI) && lIllIlllIlllIIl == 1) {
                lIllIllllIIIIII.setOpen(!lIllIllllIIIIII.isOpen());
            }
            if (lIllIllllIIIIII.isWithinHeader(lIllIlllIlllllI, lIllIlllIlllIlI) && lIllIlllIlllIIl == 2) {
                int lIllIllllIIIIll = 5;
                int lIllIllllIIIIlI = 155;
                lIllIllllIIIIII.setY(lIllIllllIIIIll);
                if (lIllIllllIIIIII.category == Module.Category.COMBAT) {
                    lIllIllllIIIIII.setX(lIllIllllIIIIlI);
                }
                if (lIllIllllIIIIII.category == Module.Category.PLAYER) {
                    lIllIllllIIIIII.setX(lIllIllllIIIIlI + lIllIllllIIIIII.getWidth() + 4);
                }
                if (lIllIllllIIIIII.category == Module.Category.MOVEMENT) {
                    lIllIllllIIIIII.setX(lIllIllllIIIIlI + (lIllIllllIIIIII.getWidth() + 4) * 2);
                }
                if (lIllIllllIIIIII.category == Module.Category.MISC) {
                    lIllIllllIIIIII.setX(lIllIllllIIIIlI + (lIllIllllIIIIII.getWidth() + 4) * 3);
                }
                if (lIllIllllIIIIII.category == Module.Category.CHAT) {
                    lIllIllllIIIIII.setX(lIllIllllIIIIlI + (lIllIllllIIIIII.getWidth() + 4) * 4);
                }
                if (lIllIllllIIIIII.category == Module.Category.RENDER) {
                    lIllIllllIIIIII.setX(lIllIllllIIIIlI + (lIllIllllIIIIII.getWidth() + 4) * 5);
                }
                if (lIllIllllIIIIII.category == Module.Category.CLIENT) {
                    lIllIllllIIIIII.setX(lIllIllllIIIIlI + (lIllIllllIIIIII.getWidth() + 4) * 6);
                }
            }
            if (!lIllIllllIIIIII.isOpen() || lIllIllllIIIIII.getComponents().isEmpty()) continue;
            for (Component lIllIllllIIIIIl : lIllIllllIIIIII.getComponents()) {
                lIllIllllIIIIIl.mouseClicked(lIllIlllIlllllI, lIllIlllIlllIlI, lIllIlllIlllIIl);
            }
        }
    }

    protected void mouseReleased(int lIllIlllIIlIIll, int lIllIlllIIlIIlI, int lIllIlllIIlIIIl) {
        for (Frame lIllIlllIIllIlI : frames) {
            lIllIlllIIllIlI.setDrag(false);
        }
        for (Frame lIllIlllIIllIII : frames) {
            if (!lIllIlllIIllIII.isOpen() || lIllIlllIIllIII.getComponents().isEmpty()) continue;
            for (Component lIllIlllIIllIIl : lIllIlllIIllIII.getComponents()) {
                lIllIlllIIllIIl.mouseReleased(lIllIlllIIlIIll, lIllIlllIIlIIlI, lIllIlllIIlIIIl);
            }
        }
    }

    protected void keyTyped(char lIllIlllIlIlIlI, int lIllIlllIlIIllI) {
        for (Frame lIllIlllIlIllII : frames) {
            if (!lIllIlllIlIllII.isOpen() || lIllIlllIlIIllI == 1 || lIllIlllIlIllII.getComponents().isEmpty()) continue;
            for (Component lIllIlllIlIllIl : lIllIlllIlIllII.getComponents()) {
                lIllIlllIlIllIl.keyTyped(lIllIlllIlIlIlI, lIllIlllIlIIllI);
            }
        }
        if (lIllIlllIlIIllI == 1) {
            ClickGUI lIllIlllIlIlIll;
            lIllIlllIlIlIll.mc.displayGuiScreen((GuiScreen)null);
        }
    }
}

