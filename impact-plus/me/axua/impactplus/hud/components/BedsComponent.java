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
import me.axua.impactplus.module.modules.hud.Beds;
import me.axua.impactplus.util.font.FontUtils;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class BedsComponent
extends HudComponent<Beds> {
    /* synthetic */ String text;
    /* synthetic */ int beds;
    /* synthetic */ Beds mod2;
    /* synthetic */ Minecraft mc;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ int fort;
    /* synthetic */ HudColours mod;

    public BedsComponent() {
        super("Beds", 572, 438, Beds.INSTANCE);
        BedsComponent llllIIIIIIlIll;
        llllIIIIIIlIll.mc = Minecraft.getMinecraft();
        llllIIIIIIlIll.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllIIIIIIlIll.mod2 = (Beds)ModuleManager.getModuleByName("Beds");
        llllIIIIIIlIll.Rainbow1 = Rainbow.getbruh();
    }

    @Override
    public void render() {
        Color lllIlllIIllIlI;
        BedsComponent lllIlllIIllIIl;
        super.render();
        if (lllIlllIIllIIl.mod.rainbow.getValue()) {
            Color lllIlllIIllllI = Rainbow.getColorWithOpacity(255);
        } else {
            lllIlllIIllIlI = new Color(lllIlllIIllIIl.mod.red.getValue(), lllIlllIIllIIl.mod.green.getValue(), lllIlllIIllIIl.mod.blue.getValue(), 255);
        }
        lllIlllIIllIIl.beds = 0;
        lllIlllIIllIIl.beds = lllIlllIIllIIl.mc.thePlayer.inventory.mainInventory.stream().filter(lllIlllIIlIlII -> lllIlllIIlIlII.getItem() == Items.bed).mapToInt(ItemStack::func_190916_E).sum();
        if (lllIlllIIllIIl.mc.thePlayer.func_184592_cb().getItem() == Items.bed) {
            ++lllIlllIIllIIl.beds;
        }
        lllIlllIIllIIl.text = lllIlllIIllIIl.mod2.Mode.getValue().equalsIgnoreCase("Item") ? String.valueOf(new StringBuilder().append("").append(ChatFormatting.getByName((String)lllIlllIIllIIl.mod.color.getValue())).append(lllIlllIIllIIl.beds)) : String.valueOf(new StringBuilder().append("Beds ").append(ChatFormatting.getByName((String)lllIlllIIllIIl.mod.color.getValue())).append(lllIlllIIllIIl.beds));
        lllIlllIIllIIl.fort = lllIlllIIllIIl.y < 1 ? 1 : lllIlllIIllIIl.y;
        if (lllIlllIIllIIl.fort > 355) {
            lllIlllIIllIIl.fort = lllIlllIIllIIl.y - 355;
        }
        if (ClickGuiModule.customfont.getValue()) {
            if (lllIlllIIllIIl.mod2.Mode.getValue().equalsIgnoreCase("Item")) {
                ImpactPlus.CustomFont.drawStringWithShadow(lllIlllIIllIIl.text, lllIlllIIllIIl.x + 17, (float)(lllIlllIIllIIl.y + 8) - ImpactPlus.CustomFont.getStringHeight(lllIlllIIllIIl.text) / 2.0f, lllIlllIIllIIl.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllIlllIIllIIl.Rainbow1.GetRainbowColorAt(lllIlllIIllIIl.fort) : lllIlllIIllIlI.getRGB());
                lllIlllIIllIIl.width = (int)ImpactPlus.CustomFont.getStringWidth(lllIlllIIllIIl.text) + 19;
            } else {
                ImpactPlus.CustomFont.drawStringWithShadow(lllIlllIIllIIl.text, lllIlllIIllIIl.x, lllIlllIIllIIl.y - 2, lllIlllIIllIIl.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllIlllIIllIIl.Rainbow1.GetRainbowColorAt(lllIlllIIllIIl.fort) : lllIlllIIllIlI.getRGB());
                lllIlllIIllIIl.width = (int)ImpactPlus.CustomFont.getStringWidth(lllIlllIIllIIl.text) + 2;
            }
        } else if (lllIlllIIllIIl.mod2.Mode.getValue().equalsIgnoreCase("Item")) {
            lllIlllIIllIIl.mc.fontRendererObj.drawStringWithShadow(lllIlllIIllIIl.text, (float)(lllIlllIIllIIl.x + 17), (float)(lllIlllIIllIIl.y + 9 - FontUtils.getFontHeight(false, lllIlllIIllIIl.text) / 2), lllIlllIIllIIl.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllIlllIIllIIl.Rainbow1.GetRainbowColorAt(lllIlllIIllIIl.fort) : lllIlllIIllIlI.getRGB());
            lllIlllIIllIIl.width = lllIlllIIllIIl.mc.fontRendererObj.getStringWidth(lllIlllIIllIIl.text) + 19;
        } else {
            lllIlllIIllIIl.mc.fontRendererObj.drawStringWithShadow(lllIlllIIllIIl.text, (float)lllIlllIIllIIl.x, (float)lllIlllIIllIIl.y, lllIlllIIllIIl.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? lllIlllIIllIIl.Rainbow1.GetRainbowColorAt(lllIlllIIllIIl.fort) : lllIlllIIllIlI.getRGB());
            lllIlllIIllIIl.width = lllIlllIIllIIl.mc.fontRendererObj.getStringWidth(lllIlllIIllIIl.text);
        }
        if (lllIlllIIllIIl.mod2.Mode.getValue().equalsIgnoreCase("Item")) {
            ItemStack lllIlllIIlllII;
            if (lllIlllIIllIIl.beds == 0) {
                ItemStack lllIlllIIlllIl = new ItemStack(Items.bed);
            } else {
                lllIlllIIlllII = new ItemStack(Items.bed, lllIlllIIllIIl.beds);
            }
            RenderHelper.enableGUIStandardItemLighting();
            lllIlllIIllIIl.mc.getRenderItem().renderItemAndEffectIntoGUI(lllIlllIIlllII, lllIlllIIllIIl.x, lllIlllIIllIIl.y);
            RenderHelper.disableStandardItemLighting();
            lllIlllIIllIIl.height = 18;
        } else {
            lllIlllIIllIIl.height = 9;
        }
    }
}

