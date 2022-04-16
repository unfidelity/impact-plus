/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemStack
 */
package me.axua.impactplus.module.modules.player;

import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemStack;

public class ElytraSwap
extends Module {
    @Override
    public void onEnable() {
        if (ElytraSwap.mc.thePlayer != null) {
            ElytraSwap lllllllllllllllllIIIIlIIIIIlIlII;
            InventoryPlayer lllllllllllllllllIIIIlIIIIIlllIl = ElytraSwap.mc.thePlayer.inventory;
            ItemStack lllllllllllllllllIIIIlIIIIIllIlI = lllllllllllllllllIIIIlIIIIIlllIl.armorItemInSlot(2);
            String lllllllllllllllllIIIIlIIIIIllIII = lllllllllllllllllIIIIlIIIIIllIlI.getItem().getItemStackDisplayName(lllllllllllllllllIIIIlIIIIIllIlI);
            if (lllllllllllllllllIIIIlIIIIIllIII.equals("Air")) {
                int lllllllllllllllllIIIIlIIIIllIIll = 0;
                int lllllllllllllllllIIIIlIIIIllIIII = 0;
                for (int lllllllllllllllllIIIIlIIIIllIllI = 9; lllllllllllllllllIIIIlIIIIllIllI < 45; ++lllllllllllllllllIIIIlIIIIllIllI) {
                    if (ElytraSwap.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllllIIIIlIIIIllIllI).getItem() != Items.field_185160_cR) continue;
                    lllllllllllllllllIIIIlIIIIllIIll = lllllllllllllllllIIIIlIIIIllIllI;
                    break;
                }
                if (lllllllllllllllllIIIIlIIIIllIIll != 0) {
                    Command.sendClientMessage("Equipping Elytra");
                    ElytraSwap.mc.playerController.func_187098_a(0, lllllllllllllllllIIIIlIIIIllIIll, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                    ElytraSwap.mc.playerController.func_187098_a(0, 6, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                }
                if (lllllllllllllllllIIIIlIIIIllIIll == 0) {
                    for (int lllllllllllllllllIIIIlIIIIllIlII = 9; lllllllllllllllllIIIIlIIIIllIlII < 45; ++lllllllllllllllllIIIIlIIIIllIlII) {
                        if (ElytraSwap.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllllIIIIlIIIIllIlII).getItem() != Items.diamond_chestplate) continue;
                        lllllllllllllllllIIIIlIIIIllIIII = lllllllllllllllllIIIIlIIIIllIlII;
                        break;
                    }
                    if (lllllllllllllllllIIIIlIIIIllIIII != 0) {
                        Command.sendClientMessage("Equipping Chestplate");
                        ElytraSwap.mc.playerController.func_187098_a(0, lllllllllllllllllIIIIlIIIIllIIII, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                        ElytraSwap.mc.playerController.func_187098_a(0, 6, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                    }
                }
                if (lllllllllllllllllIIIIlIIIIllIIII == 0 && lllllllllllllllllIIIIlIIIIllIIll == 0) {
                    Command.sendClientMessage("You do not have an Elytra or a Chestplate in your inventory. Doing nothing");
                }
                lllllllllllllllllIIIIlIIIIIlIlII.disable();
            }
            if (lllllllllllllllllIIIIlIIIIIllIII.equals("Elytra")) {
                int lllllllllllllllllIIIIlIIIIlIlIII = 0;
                for (int lllllllllllllllllIIIIlIIIIlIlllI = 9; lllllllllllllllllIIIIlIIIIlIlllI < 45; ++lllllllllllllllllIIIIlIIIIlIlllI) {
                    if (ElytraSwap.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllllIIIIlIIIIlIlllI).getItem() != Items.diamond_chestplate) continue;
                    lllllllllllllllllIIIIlIIIIlIlIII = lllllllllllllllllIIIIlIIIIlIlllI;
                    break;
                }
                if (lllllllllllllllllIIIIlIIIIlIlIII != 0) {
                    int lllllllllllllllllIIIIlIIIIlIlIlI = 0;
                    Command.sendClientMessage("Equipping Chestplate");
                    ElytraSwap.mc.playerController.func_187098_a(0, lllllllllllllllllIIIIlIIIIlIlIII, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                    ElytraSwap.mc.playerController.func_187098_a(0, 6, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                    for (int lllllllllllllllllIIIIlIIIIlIllII = 9; lllllllllllllllllIIIIlIIIIlIllII < 45; ++lllllllllllllllllIIIIlIIIIlIllII) {
                        if (ElytraSwap.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllllIIIIlIIIIlIllII).getItem() != Items.field_190931_a) continue;
                        lllllllllllllllllIIIIlIIIIlIlIlI = lllllllllllllllllIIIIlIIIIlIllII;
                        break;
                    }
                    ElytraSwap.mc.playerController.func_187098_a(0, lllllllllllllllllIIIIlIIIIlIlIlI, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                }
                if (lllllllllllllllllIIIIlIIIIlIlIII == 0) {
                    Command.sendClientMessage("You do not have a Chestplate in your inventory. Keeping Elytra equipped");
                }
                lllllllllllllllllIIIIlIIIIIlIlII.disable();
            }
            if (lllllllllllllllllIIIIlIIIIIllIII.equals("Diamond Chestplate")) {
                int lllllllllllllllllIIIIlIIIIIlllll = 0;
                for (int lllllllllllllllllIIIIlIIIIlIIllI = 9; lllllllllllllllllIIIIlIIIIlIIllI < 45; ++lllllllllllllllllIIIIlIIIIlIIllI) {
                    if (ElytraSwap.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllllIIIIlIIIIlIIllI).getItem() != Items.field_185160_cR) continue;
                    lllllllllllllllllIIIIlIIIIIlllll = lllllllllllllllllIIIIlIIIIlIIllI;
                    break;
                }
                if (lllllllllllllllllIIIIlIIIIIlllll != 0) {
                    int lllllllllllllllllIIIIlIIIIlIIIlI = 0;
                    Command.sendClientMessage("Equipping Elytra");
                    ElytraSwap.mc.playerController.func_187098_a(0, lllllllllllllllllIIIIlIIIIIlllll, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                    ElytraSwap.mc.playerController.func_187098_a(0, 6, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                    for (int lllllllllllllllllIIIIlIIIIlIIlII = 9; lllllllllllllllllIIIIlIIIIlIIlII < 45; ++lllllllllllllllllIIIIlIIIIlIIlII) {
                        if (ElytraSwap.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllllIIIIlIIIIlIIlII).getItem() != Items.field_190931_a) continue;
                        lllllllllllllllllIIIIlIIIIlIIIlI = lllllllllllllllllIIIIlIIIIlIIlII;
                        break;
                    }
                    ElytraSwap.mc.playerController.func_187098_a(0, lllllllllllllllllIIIIlIIIIlIIIlI, 0, ClickType.PICKUP, (EntityPlayer)ElytraSwap.mc.thePlayer);
                }
                if (lllllllllllllllllIIIIlIIIIIlllll == 0) {
                    Command.sendClientMessage("You do not have a Elytra in your inventory. Keeping Chestplate equipped");
                }
                lllllllllllllllllIIIIlIIIIIlIlII.disable();
            }
        }
    }

    public ElytraSwap() {
        super("ElytraSwap", Module.Category.PLAYER);
        ElytraSwap lllllllllllllllllIIIIlIIIlllIlIl;
    }
}

