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
import java.text.DecimalFormat;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.hud.Tps;
import me.axua.impactplus.util.TpsUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class TpsComponent
extends HudComponent<Tps> {
    /* synthetic */ int fort;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ Minecraft mc;
    /* synthetic */ DecimalFormat decimalFormat;
    /* synthetic */ HudColours mod;

    @Override
    public void render() {
        Color lIlIIIlllllIIl;
        TpsComponent lIlIIIlllllIlI;
        super.render();
        if (lIlIIIlllllIlI.mod.rainbow.getValue()) {
            Color lIlIIIlllllIll = Rainbow.getColorWithOpacity(255);
        } else {
            lIlIIIlllllIIl = new Color(lIlIIIlllllIlI.mod.red.getValue(), lIlIIIlllllIlI.mod.green.getValue(), lIlIIIlllllIlI.mod.blue.getValue(), 255);
        }
        String lIlIIIlllllIII = String.valueOf(new StringBuilder().append("TPS ").append(ChatFormatting.getByName((String)lIlIIIlllllIlI.mod.color.getValue())).append(lIlIIIlllllIlI.decimalFormat.format(TpsUtils.getTickRate())));
        lIlIIIlllllIlI.fort = lIlIIIlllllIlI.y < 1 ? 1 : lIlIIIlllllIlI.y;
        if (lIlIIIlllllIlI.fort > 355) {
            lIlIIIlllllIlI.fort = lIlIIIlllllIlI.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(lIlIIIlllllIII, lIlIIIlllllIlI.x, lIlIIIlllllIlI.y - 2, lIlIIIlllllIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lIlIIIlllllIlI.Rainbow1.GetRainbowColorAt(lIlIIIlllllIlI.fort) : lIlIIIlllllIIl.getRGB());
            lIlIIIlllllIlI.width = (int)ImpactPlus.CustomFont.getStringWidth(lIlIIIlllllIII) + 2;
        } else {
            lIlIIIlllllIlI.mc.fontRendererObj.drawStringWithShadow(lIlIIIlllllIII, (float)lIlIIIlllllIlI.x, (float)lIlIIIlllllIlI.y, lIlIIIlllllIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lIlIIIlllllIlI.Rainbow1.GetRainbowColorAt(lIlIIIlllllIlI.fort) : lIlIIIlllllIIl.getRGB());
            lIlIIIlllllIlI.width = lIlIIIlllllIlI.mc.fontRendererObj.getStringWidth(lIlIIIlllllIII);
        }
    }

    public TpsComponent() {
        super("Tps", 2, 42, Tps.INSTANCE);
        TpsComponent lIlIIlIIIIIIII;
        lIlIIlIIIIIIII.mc = Minecraft.getMinecraft();
        lIlIIlIIIIIIII.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        lIlIIlIIIIIIII.decimalFormat = new DecimalFormat("##.#");
        lIlIIlIIIIIIII.Rainbow1 = Rainbow.getbruh();
    }
}

