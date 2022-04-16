/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.EnumFacing
 */
package me.axua.impactplus.hud.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.hud.Direction;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;

public class DirectionComponent
extends HudComponent<Direction> {
    /* synthetic */ HudColours mod;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ int fort;
    /* synthetic */ Minecraft mc;

    private String dir() {
        DirectionComponent llllllllllllllllIIlllIIlIIIIIIIl;
        Entity llllllllllllllllIIlllIIlIIIIIIII = llllllllllllllllIIlllIIlIIIIIIIl.mc.getRenderViewEntity();
        EnumFacing llllllllllllllllIIlllIIIllllllll = llllllllllllllllIIlllIIlIIIIIIII.getHorizontalFacing();
        String llllllllllllllllIIlllIIIlllllllI = "Invalid";
        switch (llllllllllllllllIIlllIIIllllllll) {
            case NORTH: {
                llllllllllllllllIIlllIIIlllllllI = String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIIlllIIlIIIIIIIl.mod.color.getValue())).append("North ").append(ChatFormatting.RESET).append("[").append(ChatFormatting.getByName((String)llllllllllllllllIIlllIIlIIIIIIIl.mod.color.getValue())).append("-Z").append(ChatFormatting.RESET).append("]"));
                break;
            }
            case SOUTH: {
                llllllllllllllllIIlllIIIlllllllI = String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIIlllIIlIIIIIIIl.mod.color.getValue())).append("South ").append(ChatFormatting.RESET).append("[").append(ChatFormatting.getByName((String)llllllllllllllllIIlllIIlIIIIIIIl.mod.color.getValue())).append("+Z").append(ChatFormatting.RESET).append("]"));
                break;
            }
            case WEST: {
                llllllllllllllllIIlllIIIlllllllI = String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIIlllIIlIIIIIIIl.mod.color.getValue())).append("West ").append(ChatFormatting.RESET).append("[").append(ChatFormatting.getByName((String)llllllllllllllllIIlllIIlIIIIIIIl.mod.color.getValue())).append("-X").append(ChatFormatting.RESET).append("]"));
                break;
            }
            case EAST: {
                llllllllllllllllIIlllIIIlllllllI = String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIIlllIIlIIIIIIIl.mod.color.getValue())).append("East ").append(ChatFormatting.RESET).append("[").append(ChatFormatting.getByName((String)llllllllllllllllIIlllIIlIIIIIIIl.mod.color.getValue())).append("+X").append(ChatFormatting.RESET).append("]"));
            }
        }
        return llllllllllllllllIIlllIIIlllllllI;
    }

    public DirectionComponent() {
        super("Direction", 2, 468, Direction.INSTANCE);
        DirectionComponent llllllllllllllllIIlllIIlIIIIlllI;
        llllllllllllllllIIlllIIlIIIIlllI.mc = Minecraft.getMinecraft();
        llllllllllllllllIIlllIIlIIIIlllI.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIIlllIIlIIIIlllI.Rainbow1 = Rainbow.getbruh();
    }

    @Override
    public void render() {
        Color llllllllllllllllIIlllIIlIIIIlIII;
        DirectionComponent llllllllllllllllIIlllIIlIIIIIlll;
        super.render();
        if (llllllllllllllllIIlllIIlIIIIIlll.mod.rainbow.getValue()) {
            Color llllllllllllllllIIlllIIlIIIIlIlI = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIIlllIIlIIIIlIII = new Color(llllllllllllllllIIlllIIlIIIIIlll.mod.red.getValue(), llllllllllllllllIIlllIIlIIIIIlll.mod.green.getValue(), llllllllllllllllIIlllIIlIIIIIlll.mod.blue.getValue(), 255);
        }
        llllllllllllllllIIlllIIlIIIIIlll.fort = llllllllllllllllIIlllIIlIIIIIlll.y < 1 ? 1 : llllllllllllllllIIlllIIlIIIIIlll.y;
        if (llllllllllllllllIIlllIIlIIIIIlll.fort > 355) {
            llllllllllllllllIIlllIIlIIIIIlll.fort = llllllllllllllllIIlllIIlIIIIIlll.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllIIlllIIlIIIIIlll.dir(), llllllllllllllllIIlllIIlIIIIIlll.x, llllllllllllllllIIlllIIlIIIIIlll.y - 2, llllllllllllllllIIlllIIlIIIIIlll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIlllIIlIIIIIlll.Rainbow1.GetRainbowColorAt(llllllllllllllllIIlllIIlIIIIIlll.fort) : llllllllllllllllIIlllIIlIIIIlIII.getRGB());
            llllllllllllllllIIlllIIlIIIIIlll.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllIIlllIIlIIIIIlll.dir()) + 2;
        } else {
            llllllllllllllllIIlllIIlIIIIIlll.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllIIlllIIlIIIIIlll.dir(), (float)llllllllllllllllIIlllIIlIIIIIlll.x, (float)llllllllllllllllIIlllIIlIIIIIlll.y, llllllllllllllllIIlllIIlIIIIIlll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIIlllIIlIIIIIlll.Rainbow1.GetRainbowColorAt(llllllllllllllllIIlllIIlIIIIIlll.fort) : llllllllllllllllIIlllIIlIIIIlIII.getRGB());
            llllllllllllllllIIlllIIlIIIIIlll.width = llllllllllllllllIIlllIIlIIIIIlll.mc.fontRendererObj.getStringWidth(llllllllllllllllIIlllIIlIIIIIlll.dir());
        }
    }
}

