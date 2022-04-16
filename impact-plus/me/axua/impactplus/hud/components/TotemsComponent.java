/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 */
package me.axua.impactplus.hud.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.client.ClickGuiModule;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.hud.Totems;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class TotemsComponent
extends HudComponent<Totems> {
    /* synthetic */ int fort;
    /* synthetic */ int totems;
    /* synthetic */ String text;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ Totems mod2;
    /* synthetic */ Minecraft mc;
    /* synthetic */ HudColours mod;

    @Override
    public void render() {
        Color llllllllllllllllllIIIIIIIIlIIIII;
        TotemsComponent llllllllllllllllllIIIIIIIIIlllll;
        super.render();
        if (llllllllllllllllllIIIIIIIIIlllll.mod.rainbow.getValue()) {
            Color llllllllllllllllllIIIIIIIIlIIlll = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllllIIIIIIIIlIIIII = new Color(llllllllllllllllllIIIIIIIIIlllll.mod.red.getValue(), llllllllllllllllllIIIIIIIIIlllll.mod.green.getValue(), llllllllllllllllllIIIIIIIIIlllll.mod.blue.getValue(), 255);
        }
        llllllllllllllllllIIIIIIIIIlllll.totems = 0;
        llllllllllllllllllIIIIIIIIIlllll.totems = llllllllllllllllllIIIIIIIIIlllll.mc.thePlayer.inventory.mainInventory.stream().filter(llllllllllllllllllIIIIIIIIIlIIIl -> llllllllllllllllllIIIIIIIIIlIIIl.getItem() == Items.field_190929_cY).mapToInt(ItemStack::func_190916_E).sum();
        if (llllllllllllllllllIIIIIIIIIlllll.mc.thePlayer.func_184592_cb().getItem() == Items.field_190929_cY) {
            ++llllllllllllllllllIIIIIIIIIlllll.totems;
        }
        llllllllllllllllllIIIIIIIIIlllll.text = llllllllllllllllllIIIIIIIIIlllll.mod2.Mode.getValue().equalsIgnoreCase("Item") ? String.valueOf(new StringBuilder().append("").append(ChatFormatting.getByName((String)llllllllllllllllllIIIIIIIIIlllll.mod.color.getValue())).append(llllllllllllllllllIIIIIIIIIlllll.totems)) : String.valueOf(new StringBuilder().append("Totems ").append(ChatFormatting.getByName((String)llllllllllllllllllIIIIIIIIIlllll.mod.color.getValue())).append(llllllllllllllllllIIIIIIIIIlllll.totems));
        llllllllllllllllllIIIIIIIIIlllll.fort = llllllllllllllllllIIIIIIIIIlllll.y < 1 ? 1 : llllllllllllllllllIIIIIIIIIlllll.y;
        if (llllllllllllllllllIIIIIIIIIlllll.fort > 355) {
            llllllllllllllllllIIIIIIIIIlllll.fort = llllllllllllllllllIIIIIIIIIlllll.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            if (llllllllllllllllllIIIIIIIIIlllll.mod2.Mode.getValue().equalsIgnoreCase("Item")) {
                ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllllIIIIIIIIIlllll.text, llllllllllllllllllIIIIIIIIIlllll.x + 15, (float)(llllllllllllllllllIIIIIIIIIlllll.y + 8) - ImpactPlus.CustomFont.getStringHeight(llllllllllllllllllIIIIIIIIIlllll.text) / 2.0f, llllllllllllllllllIIIIIIIIIlllll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllllIIIIIIIIIlllll.Rainbow1.GetRainbowColorAt(llllllllllllllllllIIIIIIIIIlllll.fort) : llllllllllllllllllIIIIIIIIlIIIII.getRGB());
                llllllllllllllllllIIIIIIIIIlllll.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllllIIIIIIIIIlllll.text) + 17;
            } else {
                ImpactPlus.CustomFont.drawStringWithShadow(llllllllllllllllllIIIIIIIIIlllll.text, llllllllllllllllllIIIIIIIIIlllll.x, llllllllllllllllllIIIIIIIIIlllll.y - 2, llllllllllllllllllIIIIIIIIIlllll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllllIIIIIIIIIlllll.Rainbow1.GetRainbowColorAt(llllllllllllllllllIIIIIIIIIlllll.fort) : llllllllllllllllllIIIIIIIIlIIIII.getRGB());
                llllllllllllllllllIIIIIIIIIlllll.width = (int)ImpactPlus.CustomFont.getStringWidth(llllllllllllllllllIIIIIIIIIlllll.text) + 2;
            }
        } else if (llllllllllllllllllIIIIIIIIIlllll.mod2.Mode.getValue().equalsIgnoreCase("Item")) {
            llllllllllllllllllIIIIIIIIIlllll.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllllIIIIIIIIIlllll.text, (float)(llllllllllllllllllIIIIIIIIIlllll.x + 15), (float)(llllllllllllllllllIIIIIIIIIlllll.y + 9 - FontUtils.getFontHeight(false, llllllllllllllllllIIIIIIIIIlllll.text) / 2), llllllllllllllllllIIIIIIIIIlllll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllllIIIIIIIIIlllll.Rainbow1.GetRainbowColorAt(llllllllllllllllllIIIIIIIIIlllll.fort) : llllllllllllllllllIIIIIIIIlIIIII.getRGB());
            llllllllllllllllllIIIIIIIIIlllll.width = llllllllllllllllllIIIIIIIIIlllll.mc.fontRendererObj.getStringWidth(llllllllllllllllllIIIIIIIIIlllll.text) + 17;
        } else {
            llllllllllllllllllIIIIIIIIIlllll.mc.fontRendererObj.drawStringWithShadow(llllllllllllllllllIIIIIIIIIlllll.text, (float)llllllllllllllllllIIIIIIIIIlllll.x, (float)llllllllllllllllllIIIIIIIIIlllll.y, llllllllllllllllllIIIIIIIIIlllll.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllllIIIIIIIIIlllll.Rainbow1.GetRainbowColorAt(llllllllllllllllllIIIIIIIIIlllll.fort) : llllllllllllllllllIIIIIIIIlIIIII.getRGB());
            llllllllllllllllllIIIIIIIIIlllll.width = llllllllllllllllllIIIIIIIIIlllll.mc.fontRendererObj.getStringWidth(llllllllllllllllllIIIIIIIIIlllll.text);
        }
        if (llllllllllllllllllIIIIIIIIIlllll.mod2.Mode.getValue().equalsIgnoreCase("Item")) {
            ItemStack llllllllllllllllllIIIIIIIIlIIlII;
            if (llllllllllllllllllIIIIIIIIIlllll.totems == 0) {
                ItemStack llllllllllllllllllIIIIIIIIlIIlIl = new ItemStack(Items.field_190929_cY);
            } else {
                llllllllllllllllllIIIIIIIIlIIlII = new ItemStack(Items.field_190929_cY, llllllllllllllllllIIIIIIIIIlllll.totems);
            }
            RenderHelper.enableGUIStandardItemLighting();
            llllllllllllllllllIIIIIIIIIlllll.mc.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllllllIIIIIIIIlIIlII, llllllllllllllllllIIIIIIIIIlllll.x - 1, llllllllllllllllllIIIIIIIIIlllll.y);
            RenderHelper.disableStandardItemLighting();
            llllllllllllllllllIIIIIIIIIlllll.height = 18;
        } else {
            llllllllllllllllllIIIIIIIIIlllll.height = 9;
        }
    }

    public TotemsComponent() {
        super("Totems", 572, 448, Totems.INSTANCE);
        TotemsComponent llllllllllllllllllIIIIIIIIllIIlI;
        llllllllllllllllllIIIIIIIIllIIlI.mc = Minecraft.getMinecraft();
        llllllllllllllllllIIIIIIIIllIIlI.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllllIIIIIIIIllIIlI.mod2 = (Totems)ModuleManager.getModuleByName("Totems");
        llllllllllllllllllIIIIIIIIllIIlI.Rainbow1 = Rainbow.getbruh();
    }
}

