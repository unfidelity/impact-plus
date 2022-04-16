/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemTool
 */
package me.axua.impactplus.module.modules.player;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class AntiToolBreak
extends Module {
    public /* synthetic */ Setting.i dura;
    /* synthetic */ int badslot2;
    /* synthetic */ int badslot3;
    /* synthetic */ ItemStack stack123;
    /* synthetic */ int badslot;

    @Override
    public void onEnable() {
        llllllllllllllllIIlIlIIIllIIIIll.badslot = -1;
        llllllllllllllllIIlIlIIIllIIIIll.badslot2 = -1;
        llllllllllllllllIIlIlIIIllIIIIll.badslot3 = -1;
    }

    @Override
    public void setup() {
        AntiToolBreak llllllllllllllllIIlIlIIIllIIIlll;
        llllllllllllllllIIlIlIIIllIIIlll.dura = llllllllllllllllIIlIlIIIllIIIlll.registerI("Durability", 5, 1, 20);
    }

    public AntiToolBreak() {
        super("AntiToolBreak", Module.Category.PLAYER, "Moves almost broken tools out of hotbar");
        AntiToolBreak llllllllllllllllIIlIlIIIllIIlIlI;
    }

    @Override
    public void onUpdate() {
        AntiToolBreak llllllllllllllllIIlIlIIIlIlllIll;
        if (AntiToolBreak.mc.thePlayer == null) {
            return;
        }
        for (int llllllllllllllllIIlIlIIIlIlllllI = 0; llllllllllllllllIIlIlIIIlIlllllI < 9 && llllllllllllllllIIlIlIIIlIlllIll.badslot == -1; ++llllllllllllllllIIlIlIIIlIlllllI) {
            ItemStack llllllllllllllllIIlIlIIIlIllllll = AntiToolBreak.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIlIlIIIlIlllllI);
            if (llllllllllllllllIIlIlIIIlIllllll == ItemStack.field_190927_a || !(llllllllllllllllIIlIlIIIlIllllll.getItem() instanceof ItemTool)) continue;
            llllllllllllllllIIlIlIIIlIlllIll.stack123 = AntiToolBreak.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIlIlIIIlIlllllI);
            if (AntiToolBreak.dura(llllllllllllllllIIlIlIIIlIlllIll.stack123) != llllllllllllllllIIlIlIIIlIlllIll.dura.getValue()) continue;
            llllllllllllllllIIlIlIIIlIlllIll.badslot = llllllllllllllllIIlIlIIIlIlllllI;
        }
        if (llllllllllllllllIIlIlIIIlIlllIll.badslot != -1) {
            if (llllllllllllllllIIlIlIIIlIlllIll.badslot == 0) {
                llllllllllllllllIIlIlIIIlIlllIll.badslot2 = 36;
            } else if (llllllllllllllllIIlIlIIIlIlllIll.badslot == 1) {
                llllllllllllllllIIlIlIIIlIlllIll.badslot2 = 37;
            } else if (llllllllllllllllIIlIlIIIlIlllIll.badslot == 2) {
                llllllllllllllllIIlIlIIIlIlllIll.badslot2 = 38;
            } else if (llllllllllllllllIIlIlIIIlIlllIll.badslot == 3) {
                llllllllllllllllIIlIlIIIlIlllIll.badslot2 = 39;
            } else if (llllllllllllllllIIlIlIIIlIlllIll.badslot == 4) {
                llllllllllllllllIIlIlIIIlIlllIll.badslot2 = 40;
            } else if (llllllllllllllllIIlIlIIIlIlllIll.badslot == 5) {
                llllllllllllllllIIlIlIIIlIlllIll.badslot2 = 41;
            } else if (llllllllllllllllIIlIlIIIlIlllIll.badslot == 6) {
                llllllllllllllllIIlIlIIIlIlllIll.badslot2 = 42;
            } else if (llllllllllllllllIIlIlIIIlIlllIll.badslot == 7) {
                llllllllllllllllIIlIlIIIlIlllIll.badslot2 = 43;
            } else if (llllllllllllllllIIlIlIIIlIlllIll.badslot == 8) {
                llllllllllllllllIIlIlIIIlIlllIll.badslot2 = 44;
            }
            AntiToolBreak.mc.playerController.func_187098_a(AntiToolBreak.mc.thePlayer.openContainer.windowId, llllllllllllllllIIlIlIIIlIlllIll.badslot2, 0, ClickType.PICKUP, (EntityPlayer)AntiToolBreak.mc.thePlayer);
            for (int llllllllllllllllIIlIlIIIlIllllIl = 9; llllllllllllllllIIlIlIIIlIllllIl < 35; ++llllllllllllllllIIlIlIIIlIllllIl) {
                if (AntiToolBreak.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIIlIlIIIlIllllIl).getItem() != Items.field_190931_a) continue;
                AntiToolBreak.mc.playerController.func_187098_a(0, llllllllllllllllIIlIlIIIlIllllIl, 0, ClickType.PICKUP, (EntityPlayer)AntiToolBreak.mc.thePlayer);
                llllllllllllllllIIlIlIIIlIlllIll.badslot3 = llllllllllllllllIIlIlIIIlIllllIl;
            }
            if (llllllllllllllllIIlIlIIIlIlllIll.badslot3 == -1) {
                AntiToolBreak.mc.playerController.func_187098_a(0, 9, 0, ClickType.PICKUP, (EntityPlayer)AntiToolBreak.mc.thePlayer);
                AntiToolBreak.mc.playerController.func_187098_a(0, llllllllllllllllIIlIlIIIlIlllIll.badslot2, 0, ClickType.PICKUP, (EntityPlayer)AntiToolBreak.mc.thePlayer);
            }
            llllllllllllllllIIlIlIIIlIlllIll.badslot = -1;
            llllllllllllllllIIlIlIIIlIlllIll.badslot2 = -1;
            llllllllllllllllIIlIlIIIlIlllIll.badslot3 = -1;
        }
    }

    public static int dura(ItemStack llllllllllllllllIIlIlIIIlIllIllI) {
        return llllllllllllllllIIlIlIIIlIllIllI.getMaxDamage() - llllllllllllllllIIlIlIIIlIllIllI.getItemDamage();
    }
}

