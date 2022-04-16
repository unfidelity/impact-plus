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
package me.axua.impactplus.hudgui;

import java.io.IOException;
import java.util.ArrayList;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.hudgui.Component;
import me.axua.impactplus.hudgui.Frame;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class HudGui
extends GuiScreen {
    public static /* synthetic */ ArrayList<Frame> frames;

    protected void mouseReleased(int llIlIllIlIIlIlI, int llIlIllIlIIllII, int llIlIllIlIIlIll) {
        for (Frame llIlIllIlIlIIlI : frames) {
            llIlIllIlIlIIlI.setDrag(false);
        }
        for (Frame llIlIllIlIlIIII : frames) {
            if (!llIlIllIlIlIIII.isOpen() || llIlIllIlIlIIII.getComponents().isEmpty()) continue;
            for (Component llIlIllIlIlIIIl : llIlIllIlIlIIII.getComponents()) {
                llIlIllIlIlIIIl.mouseReleased(llIlIllIlIIlIlI, llIlIllIlIIllII, llIlIllIlIIlIll);
            }
        }
        for (HudComponent llIlIllIlIIllll : ImpactPlus.getInstance().hudComponentManager.getComponents()) {
            llIlIllIlIIllll.mouseReleased(llIlIllIlIIlIlI, llIlIllIlIIllII, llIlIllIlIIlIll);
        }
    }

    protected void mouseClicked(int llIlIllIlllIllI, int llIlIllIlllIIlI, int llIlIllIlllIlII) throws IOException {
        for (Frame llIlIllIllllIIl : frames) {
            if (llIlIllIllllIIl.isWithinHeader(llIlIllIlllIllI, llIlIllIlllIIlI) && llIlIllIlllIlII == 0) {
                llIlIllIllllIIl.setDrag(true);
                llIlIllIllllIIl.dragX = llIlIllIlllIllI - llIlIllIllllIIl.getX();
                llIlIllIllllIIl.dragY = llIlIllIlllIIlI - llIlIllIllllIIl.getY();
            }
            if (llIlIllIllllIIl.isWithinHeader(llIlIllIlllIllI, llIlIllIlllIIlI) && llIlIllIlllIlII == 1) {
                llIlIllIllllIIl.setOpen(!llIlIllIllllIIl.isOpen());
            }
            if (llIlIllIllllIIl.isWithinHeader(llIlIllIlllIllI, llIlIllIlllIIlI) && llIlIllIlllIlII == 2) {
                int llIlIllIlllllII = 5;
                int llIlIllIllllIll = 437;
                llIlIllIllllIIl.setY(llIlIllIlllllII);
                if (llIlIllIllllIIl.category == Module.Category.HUD) {
                    llIlIllIllllIIl.setX(llIlIllIllllIll);
                }
            }
            if (!llIlIllIllllIIl.isOpen() || llIlIllIllllIIl.getComponents().isEmpty()) continue;
            for (Component llIlIllIllllIlI : llIlIllIllllIIl.getComponents()) {
                llIlIllIllllIlI.mouseClicked(llIlIllIlllIllI, llIlIllIlllIIlI, llIlIllIlllIlII);
            }
        }
        for (HudComponent llIlIllIllllIII : ImpactPlus.getInstance().hudComponentManager.getComponents()) {
            llIlIllIllllIII.mouseClicked(llIlIllIlllIllI, llIlIllIlllIIlI, llIlIllIlllIlII);
        }
    }

    public void initGui() {
        if (ClickGuiModule.blur.getValue() && OpenGlHelper.shadersSupported) {
            HudGui llIlIlllIIlllII;
            llIlIlllIIlllII.mc.entityRenderer.loadShader(new ResourceLocation("minecraft", "shaders/post/blur.json"));
        }
    }

    public void drawScreen(int llIlIlllIIIllll, int llIlIlllIIIlllI, float llIlIlllIIIllIl) {
        HudGui llIlIlllIIlIIII;
        ScaledResolution llIlIlllIIIllII = new ScaledResolution(llIlIlllIIlIIII.mc);
        for (Frame llIlIlllIIlIIlI : frames) {
            llIlIlllIIlIIlI.renderFrame(llIlIlllIIlIIII.fontRendererObj);
            llIlIlllIIlIIlI.updatePosition(llIlIlllIIIllll, llIlIlllIIIlllI);
            for (Component llIlIlllIIlIIll : llIlIlllIIlIIlI.getComponents()) {
                llIlIlllIIlIIll.updateComponent(llIlIlllIIIllll, llIlIlllIIIlllI);
            }
        }
        for (HudComponent llIlIlllIIlIIIl : ImpactPlus.getInstance().hudComponentManager.getComponents()) {
            llIlIlllIIlIIIl.renderInGui(llIlIlllIIIllll, llIlIlllIIIlllI);
        }
        GL11.glPushMatrix();
        GL11.glTranslated((double)(llIlIlllIIIllII.getScaledWidth() - 2), (double)(llIlIlllIIIllII.getScaledHeight() - 2), (double)0.0);
        GL11.glScaled((double)1.0, (double)1.0, (double)1.0);
        ImpactPlus.CustomFont.drawStringWithShadow("Axua on top!", -ImpactPlus.CustomFont.getStringWidth("Axua on top!"), -ImpactPlus.CustomFont.FONT_HEIGHT, Rainbow.getColor().getRGB());
        GL11.glPopMatrix();
    }

    public void onGuiClosed() {
        HudGui llIlIllIIlllllI;
        for (HudComponent llIlIllIIllllll : ImpactPlus.getInstance().hudComponentManager.getComponents()) {
            llIlIllIIllllll.onGuiClosed();
        }
        if (OpenGlHelper.shadersSupported) {
            llIlIllIIlllllI.mc.entityRenderer.stopUseShader();
        }
        super.onGuiClosed();
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    protected void keyTyped(char llIlIllIlIlllll, int llIlIllIlIllllI) {
        for (Frame llIlIllIllIIlII : frames) {
            if (!llIlIllIllIIlII.isOpen() || llIlIllIlIllllI == 1 || llIlIllIllIIlII.getComponents().isEmpty()) continue;
            for (Component llIlIllIllIIlIl : llIlIllIllIIlII.getComponents()) {
                llIlIllIllIIlIl.keyTyped(llIlIllIlIlllll, llIlIllIlIllllI);
            }
        }
        if (llIlIllIlIllllI == 1) {
            HudGui llIlIllIllIIIII;
            llIlIllIllIIIII.mc.displayGuiScreen((GuiScreen)null);
        }
    }

    public HudGui() {
        HudGui llIlIlllIlIIllI;
        frames = new ArrayList();
        int llIlIlllIlIIlIl = 437;
        int llIlIlllIlIIlII = 5;
        Frame llIlIlllIlIIIll = new Frame(Module.Category.HUD);
        llIlIlllIlIIIll.setX(llIlIlllIlIIlIl);
        llIlIlllIlIIIll.setY(llIlIlllIlIIlII);
        frames.add(llIlIlllIlIIIll);
        llIlIlllIlIIlIl += llIlIlllIlIIIll.getWidth() + 4;
    }
}

