/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.ContainerPlayer
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemStack
 */
package me.axua.impactplus.module.modules.combat;

import me.axua.impactplus.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class AutoTotem
extends Module {
    public AutoTotem() {
        super("AutoTotem", Module.Category.COMBAT, "AutoTotem");
        AutoTotem lIlIIlIlIIlI;
    }

    @Override
    public void onLivingEvent() {
        for (int lIlIIlIIllII = 0; lIlIIlIIllII < Minecraft.getMinecraft().thePlayer.inventory.mainInventory.size(); ++lIlIIlIIllII) {
            AutoTotem lIlIIlIIlIlI;
            if (Minecraft.getMinecraft().thePlayer.inventory.mainInventory.get(lIlIIlIIllII) == ItemStack.field_190927_a || ((ItemStack)Minecraft.getMinecraft().thePlayer.inventory.mainInventory.get(lIlIIlIIllII)).getItem() != Items.field_190929_cY || Minecraft.getMinecraft().thePlayer.func_184582_a(EntityEquipmentSlot.OFFHAND).getItem() == Items.field_190929_cY) continue;
            lIlIIlIIlIlI.replaceTotem(lIlIIlIIllII);
            break;
        }
    }

    private void replaceTotem(int lIlIIlIIIIII) {
        if (Minecraft.getMinecraft().thePlayer.openContainer instanceof ContainerPlayer) {
            Minecraft.getMinecraft().playerController.func_187098_a(0, lIlIIlIIIIII < 9 ? lIlIIlIIIIII + 36 : lIlIIlIIIIII, 0, ClickType.PICKUP, (EntityPlayer)Minecraft.getMinecraft().thePlayer);
            Minecraft.getMinecraft().playerController.func_187098_a(0, 45, 0, ClickType.PICKUP, (EntityPlayer)Minecraft.getMinecraft().thePlayer);
            Minecraft.getMinecraft().playerController.func_187098_a(0, lIlIIlIIIIII < 9 ? lIlIIlIIIIII + 36 : lIlIIlIIIIII, 0, ClickType.PICKUP, (EntityPlayer)Minecraft.getMinecraft().thePlayer);
        }
    }
}

