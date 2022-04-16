/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.hud.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.hud.Fps;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class FpsComponent
extends HudComponent<Fps> {
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ Minecraft mc;
    /* synthetic */ int fort;
    /* synthetic */ HudColours mod;

    public FpsComponent() {
        super("Fps", 2, 32, Fps.INSTANCE);
        FpsComponent lllllllllllllllllIIllIllIllIllII;
        lllllllllllllllllIIllIllIllIllII.mc = Minecraft.getMinecraft();
        lllllllllllllllllIIllIllIllIllII.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        lllllllllllllllllIIllIllIllIllII.Rainbow1 = Rainbow.getbruh();
    }

    @Override
    public void render() {
        Color lllllllllllllllllIIllIllIllIIllI;
        FpsComponent lllllllllllllllllIIllIllIllIIlll;
        super.render();
        if (lllllllllllllllllIIllIllIllIIlll.mod.rainbow.getValue()) {
            Color lllllllllllllllllIIllIllIllIlIII = Rainbow.getColorWithOpacity(255);
        } else {
            lllllllllllllllllIIllIllIllIIllI = new Color(lllllllllllllllllIIllIllIllIIlll.mod.red.getValue(), lllllllllllllllllIIllIllIllIIlll.mod.green.getValue(), lllllllllllllllllIIllIllIllIIlll.mod.blue.getValue(), 255);
        }
        String lllllllllllllllllIIllIllIllIIlIl = String.valueOf(new StringBuilder().append("FPS ").append(ChatFormatting.getByName((String)lllllllllllllllllIIllIllIllIIlll.mod.color.getValue())).append(Minecraft.getDebugFPS()));
        lllllllllllllllllIIllIllIllIIlll.fort = lllllllllllllllllIIllIllIllIIlll.y < 1 ? 1 : lllllllllllllllllIIllIllIllIIlll.y;
        if (lllllllllllllllllIIllIllIllIIlll.fort > 355) {
            lllllllllllllllllIIllIllIllIIlll.fort = lllllllllllllllllIIllIllIllIIlll.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(lllllllllllllllllIIllIllIllIIlIl, lllllllllllllllllIIllIllIllIIlll.x, lllllllllllllllllIIllIllIllIIlll.y - 2, lllllllllllllllllIIllIllIllIIlll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllllllllllllllllIIllIllIllIIlll.Rainbow1.GetRainbowColorAt(lllllllllllllllllIIllIllIllIIlll.fort) : lllllllllllllllllIIllIllIllIIllI.getRGB());
            lllllllllllllllllIIllIllIllIIlll.width = (int)ImpactPlus.CustomFont.getStringWidth(lllllllllllllllllIIllIllIllIIlIl) + 2;
        } else {
            lllllllllllllllllIIllIllIllIIlll.mc.fontRendererObj.drawStringWithShadow(lllllllllllllllllIIllIllIllIIlIl, (float)lllllllllllllllllIIllIllIllIIlll.x, (float)lllllllllllllllllIIllIllIllIIlll.y, lllllllllllllllllIIllIllIllIIlll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllllllllllllllllIIllIllIllIIlll.Rainbow1.GetRainbowColorAt(lllllllllllllllllIIllIllIllIIlll.fort) : lllllllllllllllllIIllIllIllIIllI.getRGB());
            lllllllllllllllllIIllIllIllIIlll.width = lllllllllllllllllIIllIllIllIIlll.mc.fontRendererObj.getStringWidth(lllllllllllllllllIIllIllIllIIlIl);
        }
    }
}

