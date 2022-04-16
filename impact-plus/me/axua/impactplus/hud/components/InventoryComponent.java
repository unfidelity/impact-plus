/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 */
package me.axua.impactplus.hud.components;

import java.awt.Color;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.modules.hud.Inventory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class InventoryComponent
extends HudComponent<Inventory> {
    /* synthetic */ Minecraft mc;

    public InventoryComponent() {
        super("Inventory", 572, 457, Inventory.INSTANCE);
        InventoryComponent lIIIlllIIIIIlIl;
        lIIIlllIIIIIlIl.mc = Minecraft.getMinecraft();
    }

    @Override
    public void render() {
        InventoryComponent lIIIlllIIIIIIIl;
        super.render();
        Gui.drawRect((int)lIIIlllIIIIIIIl.x, (int)lIIIlllIIIIIIIl.y, (int)(lIIIlllIIIIIIIl.x + 146), (int)(lIIIlllIIIIIIIl.y + 50), (int)new Color(0, 0, 0, 130).getRGB());
        lIIIlllIIIIIIIl.drawInventory(lIIIlllIIIIIIIl.x, lIIIlllIIIIIIIl.y);
        lIIIlllIIIIIIIl.width = 146;
        lIIIlllIIIIIIIl.height = 50;
    }

    public void drawInventory(int lIIIllIllIlIlIl, int lIIIllIllIlIIll) {
        GlStateManager.clear((int)256);
        NonNullList lIIIllIllIllIIl = Minecraft.getMinecraft().thePlayer.inventory.mainInventory;
        int lIIIllIlllIIIlI = lIIIllIllIllIIl.size();
        for (int lIIIllIlllIIIIl = 9; lIIIllIlllIIIIl < lIIIllIlllIIIlI; ++lIIIllIlllIIIIl) {
            InventoryComponent lIIIllIllIlllll;
            int lIIIllIlllIIlIl = lIIIllIllIlIlIl + 1 + lIIIllIlllIIIIl % 9 * 16;
            int lIIIllIlllIIlII = lIIIllIllIlIIll + 1 + (lIIIllIlllIIIIl / 9 - 1) * 16;
            RenderHelper.enableGUIStandardItemLighting();
            lIIIllIllIlllll.mc.getRenderItem().renderItemAndEffectIntoGUI((ItemStack)lIIIllIllIllIIl.get(lIIIllIlllIIIIl), lIIIllIlllIIlIl, lIIIllIlllIIlII);
            lIIIllIllIlllll.mc.getRenderItem().renderItemOverlays(lIIIllIllIlllll.mc.fontRendererObj, (ItemStack)lIIIllIllIllIIl.get(lIIIllIlllIIIIl), lIIIllIlllIIlIl, lIIIllIlllIIlII);
            RenderHelper.disableStandardItemLighting();
        }
    }
}

