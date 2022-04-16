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
import me.axua.impactplus.module.modules.hud.Durability;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class DurabilityComponent
extends HudComponent<Durability> {
    /* synthetic */ int fort;
    /* synthetic */ HudColours mod;
    /* synthetic */ Durability mod2;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ Minecraft mc;

    public DurabilityComponent() {
        super("Durability", 2, 72, Durability.INSTANCE);
        DurabilityComponent llllllllllllllllIIlIIlllIlIlIIIl;
        llllllllllllllllIIlIIlllIlIlIIIl.mc = Minecraft.getMinecraft();
        llllllllllllllllIIlIIlllIlIlIIIl.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIIlIIlllIlIlIIIl.mod2 = (Durability)ModuleManager.getModuleByName("Durability");
        llllllllllllllllIIlIIlllIlIlIIIl.Rainbow1 = Rainbow.getbruh();
    }

    @Override
    public void render() {
        Color llllllllllllllllIIlIIlllIlIIlIll;
        DurabilityComponent llllllllllllllllIIlIIlllIlIIllII;
        super.render();
        if (llllllllllllllllIIlIIlllIlIIllII.mod.rainbow.getValue()) {
            Color llllllllllllllllIIlIIlllIlIIllIl = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIIlIIlllIlIIlIll = new Color(llllllllllllllllIIlIIlllIlIIllII.mod.red.getValue(), llllllllllllllllIIlIIlllIlIIllII.mod.green.getValue(), llllllllllllllllIIlIIlllIlIIllII.mod.blue.getValue(), 255);
        }
        String llllllllllllllllIIlIIlllIlIIlIlI = "";
        if (llllllllllllllllIIlIIlllIlIIllII.mod2.Mode.getValue().equalsIgnoreCase("Dura")) {
            llllllllllllllllIIlIIlllIlIIlIlI = String.valueOf(new StringBuilder().append("Dura ").append(ChatFormatting.getByName((String)llllllllllllllllIIlIIlllIlIIllII.mod.color.getValue())).append(llllllllllllllllIIlIIlllIlIIllII.mod2.Durability(llllllllllllllllIIlIIlllIlIIllII.mc)));
        }
        if (llllllllllllllllIIlIIlllIlIIllII.mod2.Mode.getValue().equalsIgnoreCase("Durability")) {
            llllllllllllllllIIlIIlllIlIIlIlI = String.valueOf(new StringBuilder().append("Durability ").append(ChatFormatting.getByName((String)llllllllllllllllIIlIIlllIlIIllII.mod.color.getValue())).append(llllllllllllllllIIlIIlllIlIIllII.mod2.Durability(llllllllllllllllIIlIIlllIlIIllII.mc)));
        }
        llllllllllllllllIIlIIlllIlIIllII.fort = llllllllllllllllIIlIIlllIlIIllII.y < 1 ? 1 : llllllllllllllllIIlIIlllIlIIllII.y;
        if (llllllllllllllllIIlIIlllIlIIllII.fort > 355) {
            llllllllllllllllIIlIIlllIlIIllII.fort = llllllllllllllllIIlIIlllIlIIllII.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIIlIIlllIlIIlIlI, llllllllllllllllIIlIIlllIlIIllII.x, llllllllllllllllIIlIIlllIlIIllII.y - 2, llllllllllllllllIIlIIlllIlIIllII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIlIIlllIlIIllII.Rainbow1.GetRainbowColorAt(llllllllllllllllIIlIIlllIlIIllII.fort) : llllllllllllllllIIlIIlllIlIIlIll.getRGB());
            llllllllllllllllIIlIIlllIlIIllII.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIIlIIlllIlIIlIlI) + 2;
        } else {
            llllllllllllllllIIlIIlllIlIIllII.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIIlIIlllIlIIlIlI, (float)llllllllllllllllIIlIIlllIlIIllII.x, (float)llllllllllllllllIIlIIlllIlIIllII.y, llllllllllllllllIIlIIlllIlIIllII.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIlIIlllIlIIllII.Rainbow1.GetRainbowColorAt(llllllllllllllllIIlIIlllIlIIllII.fort) : llllllllllllllllIIlIIlllIlIIlIll.getRGB());
            llllllllllllllllIIlIIlllIlIIllII.width = llllllllllllllllIIlIIlllIlIIllII.mc.fontRendererObj.getStringWidth(llllllllllllllllIIlIIlllIlIIlIlI);
        }
    }
}

