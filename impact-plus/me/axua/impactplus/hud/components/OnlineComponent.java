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
import me.axua.impactplus.module.modules.hud.Online;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;

public class OnlineComponent
extends HudComponent<Online> {
    /* synthetic */ Minecraft mc;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ int fort;
    /* synthetic */ HudColours mod;

    @Override
    public void render() {
        Color llllllllllllllllIllIlIIlIlllIIlI;
        OnlineComponent llllllllllllllllIllIlIIlIlllIIll;
        super.render();
        if (llllllllllllllllIllIlIIlIlllIIll.mod.rainbow.getValue()) {
            Color llllllllllllllllIllIlIIlIlllIlIl = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIllIlIIlIlllIIlI = new Color(llllllllllllllllIllIlIIlIlllIIll.mod.red.getValue(), llllllllllllllllIllIlIIlIlllIIll.mod.green.getValue(), llllllllllllllllIllIlIIlIlllIIll.mod.blue.getValue(), 255);
        }
        String llllllllllllllllIllIlIIlIllIllll = String.valueOf(new StringBuilder().append("Online ").append(ChatFormatting.getByName((String)llllllllllllllllIllIlIIlIlllIIll.mod.color.getValue())).append(llllllllllllllllIllIlIIlIlllIIll.mc.thePlayer.sendQueue.getPlayerInfoMap().size()));
        llllllllllllllllIllIlIIlIlllIIll.fort = llllllllllllllllIllIlIIlIlllIIll.y < 1 ? 1 : llllllllllllllllIllIlIIlIlllIIll.y;
        if (llllllllllllllllIllIlIIlIlllIIll.fort > 355) {
            llllllllllllllllIllIlIIlIlllIIll.fort = llllllllllllllllIllIlIIlIlllIIll.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIllIlIIlIllIllll, llllllllllllllllIllIlIIlIlllIIll.x, llllllllllllllllIllIlIIlIlllIIll.y - 2, llllllllllllllllIllIlIIlIlllIIll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIIlIlllIIll.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIIlIlllIIll.fort) : llllllllllllllllIllIlIIlIlllIIlI.getRGB());
            llllllllllllllllIllIlIIlIlllIIll.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIllIlIIlIllIllll) + 2;
        } else {
            llllllllllllllllIllIlIIlIlllIIll.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIllIlIIlIllIllll, (float)llllllllllllllllIllIlIIlIlllIIll.x, (float)llllllllllllllllIllIlIIlIlllIIll.y, llllllllllllllllIllIlIIlIlllIIll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIllIlIIlIlllIIll.Rainbow1.GetRainbowColorAt(llllllllllllllllIllIlIIlIlllIIll.fort) : llllllllllllllllIllIlIIlIlllIIlI.getRGB());
            llllllllllllllllIllIlIIlIlllIIll.width = llllllllllllllllIllIlIIlIlllIIll.mc.fontRendererObj.getStringWidth(llllllllllllllllIllIlIIlIllIllll);
        }
    }

    public OnlineComponent() {
        super("Online", 2, 82, Online.INSTANCE);
        OnlineComponent llllllllllllllllIllIlIIllIlIIIII;
        llllllllllllllllIllIlIIllIlIIIII.mc = Minecraft.getMinecraft();
        llllllllllllllllIllIlIIllIlIIIII.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIllIlIIllIlIIIII.Rainbow1 = Rainbow.getbruh();
    }
}

