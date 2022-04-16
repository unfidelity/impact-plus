/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 */
package me.axua.impactplus.module.modules.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class DonkeyDupeHelper
extends Module {
    public /* synthetic */ Setting.mode Mode;
    public /* synthetic */ List<UUID> donkeys;
    /* synthetic */ int slot;

    @Override
    public void onUpdate() {
        DonkeyDupeHelper llllllIIIlllIlI;
        if (llllllIIIlllIlI.Mode.getValue().equalsIgnoreCase("AutoTame")) {
            llllllIIIlllIlI.slot = -1;
            Entity llllllIIlIIIlll = DonkeyDupeHelper.mc.theWorld.loadedEntityList.stream().filter(lllllIllllIlIII -> lllllIllllIlIII instanceof EntityDonkey).filter(lllllIllllIlIll -> !((EntityDonkey)lllllIllllIlIll).isTame()).filter(lllllIllllIlllI -> !((EntityDonkey)lllllIllllIlllI).isChild()).filter(lllllIlllllIIIl -> DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(lllllIlllllIIIl) < 6.0f).min(Comparator.comparing(lllllIlllllIlII -> Float.valueOf(DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(lllllIlllllIlII)))).orElse(null);
            Entity llllllIIlIIIllI = DonkeyDupeHelper.mc.theWorld.loadedEntityList.stream().filter(lllllIlllllIlll -> lllllIlllllIlll instanceof EntityDonkey).filter(lllllIllllllIlI -> !((EntityDonkey)lllllIllllllIlI).isChild()).filter(lllllIlllllllII -> DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(lllllIlllllllII) < 6.0f).min(Comparator.comparing(llllllIIIIIIIII -> Float.valueOf(DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(llllllIIIIIIIII)))).orElse(null);
            if (llllllIIlIIIlll != null && !llllllIIlIIIlll.func_184207_aI() && !((EntityDonkey)llllllIIlIIIlll).isTame()) {
                for (int llllllIIlIIlIII = 0; llllllIIlIIlIII < 9; ++llllllIIlIIlIII) {
                    ItemStack llllllIIlIIlIIl = DonkeyDupeHelper.mc.thePlayer.inventory.getStackInSlot(llllllIIlIIlIII);
                    if (llllllIIlIIlIIl.getItem() != Items.field_190931_a) continue;
                    llllllIIIlllIlI.slot = llllllIIlIIlIII;
                }
                if (llllllIIIlllIlI.slot == -1) {
                    Command.sendClientMessage("No empty slots in hotbar");
                    llllllIIIlllIlI.disable();
                    return;
                }
                DonkeyDupeHelper.mc.thePlayer.inventory.currentItem = llllllIIIlllIlI.slot;
                DonkeyDupeHelper.mc.playerController.func_187097_a((EntityPlayer)DonkeyDupeHelper.mc.thePlayer, llllllIIlIIIlll, EnumHand.MAIN_HAND);
            }
            if (llllllIIlIIIllI != null && llllllIIlIIIllI.func_184207_aI() && ((EntityDonkey)llllllIIlIIIllI).isTame()) {
                Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = true;
                Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = false;
            }
            if (llllllIIlIIIllI == null && llllllIIlIIIlll == null && DonkeyDupeHelper.mc.thePlayer.func_184218_aH()) {
                Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = true;
                Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = false;
            }
        } else if (llllllIIIlllIlI.Mode.getValue().equalsIgnoreCase("AutoBreed")) {
            llllllIIIlllIlI.slot = -1;
            Entity llllllIIlIIIIlI = DonkeyDupeHelper.mc.theWorld.loadedEntityList.stream().filter(llllllIIIIIIIll -> llllllIIIIIIIll instanceof EntityDonkey).filter(llllllIIIIIIlIl -> ((EntityDonkey)llllllIIIIIIlIl).isTame()).filter(llllllIIIIIlIII -> !((EntityDonkey)llllllIIIIIlIII).isChild()).filter(llllllIIIIIllIl -> {
                DonkeyDupeHelper llllllIIIIIllII;
                return !llllllIIIIIllII.donkeys.contains(llllllIIIIIllIl.getUniqueID());
            }).filter(llllllIIIIlIIlI -> DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(llllllIIIIlIIlI) < 6.0f).min(Comparator.comparing(llllllIIIIlIlII -> Float.valueOf(DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(llllllIIIIlIlII)))).orElse(null);
            List llllllIIlIIIIIl = DonkeyDupeHelper.mc.theWorld.loadedEntityList.stream().filter(llllllIIIIlIlll -> llllllIIIIlIlll instanceof EntityDonkey).collect(Collectors.toList());
            for (Entity llllllIIlIIIlIl : llllllIIlIIIIIl) {
                if (!(llllllIIlIIIlIl instanceof EntityDonkey) || !((EntityDonkey)llllllIIlIIIlIl).isInLove()) continue;
                if (llllllIIIlllIlI.donkeys.contains(llllllIIlIIIlIl.getUniqueID())) {
                    return;
                }
                llllllIIIlllIlI.donkeys.add(llllllIIlIIIlIl.getUniqueID());
            }
            if (llllllIIlIIIIlI != null && !llllllIIlIIIIlI.func_184207_aI() && ((EntityDonkey)llllllIIlIIIIlI).isTame()) {
                if (llllllIIIlllIlI.donkeys.contains(llllllIIlIIIIlI.getUniqueID())) {
                    Command.sendClientMessage("Contains");
                    return;
                }
                for (int llllllIIlIIIIll = 0; llllllIIlIIIIll < 9; ++llllllIIlIIIIll) {
                    ItemStack llllllIIlIIIlII = DonkeyDupeHelper.mc.thePlayer.inventory.getStackInSlot(llllllIIlIIIIll);
                    if (llllllIIlIIIlII.getItem() != Items.golden_apple || !llllllIIlIIIlII.hasEffect()) continue;
                    llllllIIIlllIlI.slot = llllllIIlIIIIll;
                }
                if (llllllIIIlllIlI.slot == -1) {
                    Command.sendClientMessage("No egaps in hotbar");
                    llllllIIIlllIlI.disable();
                    return;
                }
                DonkeyDupeHelper.mc.thePlayer.inventory.currentItem = llllllIIIlllIlI.slot;
                DonkeyDupeHelper.mc.playerController.func_187097_a((EntityPlayer)DonkeyDupeHelper.mc.thePlayer, llllllIIlIIIIlI, EnumHand.MAIN_HAND);
                if (DonkeyDupeHelper.mc.thePlayer.func_184218_aH()) {
                    Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = true;
                    Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = false;
                    return;
                }
                llllllIIIlllIlI.donkeys.add(llllllIIlIIIIlI.getUniqueID());
            }
            if (DonkeyDupeHelper.mc.thePlayer.func_184218_aH()) {
                Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = true;
                Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = false;
            }
        } else if (llllllIIIlllIlI.Mode.getValue().equalsIgnoreCase("AutoGrow")) {
            if (DonkeyDupeHelper.mc.thePlayer.func_184218_aH()) {
                Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = true;
                Minecraft.getMinecraft().gameSettings.keyBindForward.pressed = false;
            }
            llllllIIIlllIlI.slot = -1;
            Entity llllllIIIlllllI = DonkeyDupeHelper.mc.theWorld.loadedEntityList.stream().filter(llllllIIIIllIlI -> llllllIIIIllIlI instanceof EntityDonkey).filter(llllllIIIIlllIl -> ((EntityDonkey)llllllIIIIlllIl).isChild()).filter(llllllIIIlIIIII -> DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(llllllIIIlIIIII) < 6.0f).min(Comparator.comparing(llllllIIIlIIIll -> Float.valueOf(DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(llllllIIIlIIIll)))).orElse(null);
            if (llllllIIIlllllI != null) {
                for (int llllllIIIllllll = 0; llllllIIIllllll < 9; ++llllllIIIllllll) {
                    ItemStack llllllIIlIIIIII = DonkeyDupeHelper.mc.thePlayer.inventory.getStackInSlot(llllllIIIllllll);
                    if (llllllIIlIIIIII.getItem() != Items.golden_apple || !llllllIIlIIIIII.hasEffect()) continue;
                    llllllIIIlllIlI.slot = llllllIIIllllll;
                }
                if (llllllIIIlllIlI.slot == -1) {
                    Command.sendClientMessage("No egaps in hotbar");
                    llllllIIIlllIlI.disable();
                    return;
                }
                DonkeyDupeHelper.mc.thePlayer.inventory.currentItem = llllllIIIlllIlI.slot;
                DonkeyDupeHelper.mc.playerController.func_187097_a((EntityPlayer)DonkeyDupeHelper.mc.thePlayer, llllllIIIlllllI, EnumHand.MAIN_HAND);
            }
        } else if (llllllIIIlllIlI.Mode.getValue().equalsIgnoreCase("AutoHurt")) {
            if (DonkeyDupeHelper.mc.thePlayer.ticksExisted % 15 != 0) {
                return;
            }
            if (DonkeyDupeHelper.mc.thePlayer.func_184218_aH()) {
                return;
            }
            llllllIIIlllIlI.slot = -1;
            Entity llllllIIIlllIll = DonkeyDupeHelper.mc.theWorld.loadedEntityList.stream().filter(llllllIIIlIIlll -> llllllIIIlIIlll instanceof EntityDonkey).filter(llllllIIIlIlIlI -> ((EntityDonkey)llllllIIIlIlIlI).getHealth() + ((EntityDonkey)llllllIIIlIlIlI).getAbsorptionAmount() > 1.0f).filter(llllllIIIlIllIl -> ((EntityDonkey)llllllIIIlIllIl).func_190695_dh()).filter(llllllIIIlIllll -> DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(llllllIIIlIllll) < 6.0f).min(Comparator.comparing(llllllIIIllIIlI -> Float.valueOf(DonkeyDupeHelper.mc.thePlayer.getDistanceToEntity(llllllIIIllIIlI)))).orElse(null);
            if (llllllIIIlllIll != null) {
                for (int llllllIIIllllII = 0; llllllIIIllllII < 9; ++llllllIIIllllII) {
                    ItemStack llllllIIIllllIl = DonkeyDupeHelper.mc.thePlayer.inventory.getStackInSlot(llllllIIIllllII);
                    if (llllllIIIllllIl.getItem() != Items.field_190931_a) continue;
                    llllllIIIlllIlI.slot = llllllIIIllllII;
                }
                if (llllllIIIlllIlI.slot == -1) {
                    Command.sendClientMessage("No empty slots in hotbar");
                    llllllIIIlllIlI.disable();
                    return;
                }
                DonkeyDupeHelper.mc.playerController.attackEntity((EntityPlayer)DonkeyDupeHelper.mc.thePlayer, llllllIIIlllIll);
                DonkeyDupeHelper.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
            }
        }
    }

    public DonkeyDupeHelper() {
        super("DonkeyDupeHelper", Module.Category.MISC);
        DonkeyDupeHelper llllllIIlIllIII;
        llllllIIlIllIII.donkeys = new ArrayList<UUID>();
    }

    @Override
    public void setup() {
        DonkeyDupeHelper llllllIIlIlIlIl;
        ArrayList<String> llllllIIlIlIlII = new ArrayList<String>();
        llllllIIlIlIlII.add("AutoTame");
        llllllIIlIlIlII.add("AutoBreed");
        llllllIIlIlIlII.add("AutoGrow");
        llllllIIlIlIlII.add("AutoHurt");
        llllllIIlIlIlIl.Mode = llllllIIlIlIlIl.registerMode("Mode", llllllIIlIlIlII, "AutoTame");
    }

    @Override
    public void onDisable() {
        DonkeyDupeHelper llllllIIlIlIIII;
        llllllIIlIlIIII.donkeys.clear();
    }
}

