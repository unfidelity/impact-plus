/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.MathHelper
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
import me.axua.impactplus.module.modules.hud.Bps;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.MathHelper;

public class BpsComponent
extends HudComponent<Bps> {
    /* synthetic */ HudColours mod;
    /* synthetic */ Minecraft mc;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ DecimalFormat decimalFormat;
    /* synthetic */ int fort;

    public BpsComponent() {
        super("Bps", 2, 52, Bps.INSTANCE);
        BpsComponent llllllllllllllllIIlllIIIlIlllIll;
        llllllllllllllllIIlllIIIlIlllIll.mc = Minecraft.getMinecraft();
        llllllllllllllllIIlllIIIlIlllIll.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIIlllIIIlIlllIll.decimalFormat = new DecimalFormat("0.0");
        llllllllllllllllIIlllIIIlIlllIll.Rainbow1 = Rainbow.getbruh();
    }

    @Override
    public void render() {
        Color llllllllllllllllIIlllIIIlIllIIlI;
        BpsComponent llllllllllllllllIIlllIIIlIllIIll;
        super.render();
        if (llllllllllllllllIIlllIIIlIllIIll.mod.rainbow.getValue()) {
            Color llllllllllllllllIIlllIIIlIllIlII = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIIlllIIIlIllIIlI = new Color(llllllllllllllllIIlllIIIlIllIIll.mod.red.getValue(), llllllllllllllllIIlllIIIlIllIIll.mod.green.getValue(), llllllllllllllllIIlllIIIlIllIIll.mod.blue.getValue(), 255);
        }
        double llllllllllllllllIIlllIIIlIllIIIl = llllllllllllllllIIlllIIIlIllIIll.mc.thePlayer.posX - llllllllllllllllIIlllIIIlIllIIll.mc.thePlayer.prevPosX;
        double llllllllllllllllIIlllIIIlIllIIII = llllllllllllllllIIlllIIIlIllIIll.mc.thePlayer.posZ - llllllllllllllllIIlllIIIlIllIIll.mc.thePlayer.prevPosZ;
        float llllllllllllllllIIlllIIIlIlIllll = llllllllllllllllIIlllIIIlIllIIll.mc.timer.field_194149_e / 1000.0f;
        String llllllllllllllllIIlllIIIlIlIlllI = String.valueOf(new StringBuilder().append("BPS ").append(ChatFormatting.getByName((String)llllllllllllllllIIlllIIIlIllIIll.mod.color.getValue())).append(llllllllllllllllIIlllIIIlIllIIll.decimalFormat.format(MathHelper.sqrt_double((double)(llllllllllllllllIIlllIIIlIllIIIl * llllllllllllllllIIlllIIIlIllIIIl + llllllllllllllllIIlllIIIlIllIIII * llllllllllllllllIIlllIIIlIllIIII)) / llllllllllllllllIIlllIIIlIlIllll)));
        llllllllllllllllIIlllIIIlIllIIll.fort = llllllllllllllllIIlllIIIlIllIIll.y < 1 ? 1 : llllllllllllllllIIlllIIIlIllIIll.y;
        if (llllllllllllllllIIlllIIIlIllIIll.fort > 355) {
            llllllllllllllllIIlllIIIlIllIIll.fort = llllllllllllllllIIlllIIIlIllIIll.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIIlllIIIlIlIlllI, llllllllllllllllIIlllIIIlIllIIll.x, llllllllllllllllIIlllIIIlIllIIll.y - 2, llllllllllllllllIIlllIIIlIllIIll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIlllIIIlIllIIll.Rainbow1.GetRainbowColorAt(llllllllllllllllIIlllIIIlIllIIll.fort) : llllllllllllllllIIlllIIIlIllIIlI.getRGB());
            llllllllllllllllIIlllIIIlIllIIll.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIIlllIIIlIlIlllI) + 2;
        } else {
            llllllllllllllllIIlllIIIlIllIIll.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIIlllIIIlIlIlllI, (float)llllllllllllllllIIlllIIIlIllIIll.x, (float)llllllllllllllllIIlllIIIlIllIIll.y, llllllllllllllllIIlllIIIlIllIIll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIlllIIIlIllIIll.Rainbow1.GetRainbowColorAt(llllllllllllllllIIlllIIIlIllIIll.fort) : llllllllllllllllIIlllIIIlIllIIlI.getRGB());
            llllllllllllllllIIlllIIIlIllIIll.width = llllllllllllllllIIlllIIIlIllIIll.mc.fontRendererObj.getStringWidth(llllllllllllllllIIlllIIIlIlIlllI);
        }
    }
}

