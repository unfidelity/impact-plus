/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 */
package me.axua.impactplus.module.modules.movement;

import java.util.Comparator;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AutoWasp
extends Module {
    public /* synthetic */ Setting.b OnlyElytra;
    public /* synthetic */ Setting.i BedBombModeh;
    public /* synthetic */ Setting.b BedBombMode;
    public /* synthetic */ Setting.b TargetFriends;
    /* synthetic */ EntityPlayer l_Player;

    public EntityPlayer getcloseplayer() {
        return AutoWasp.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIIllllllllIllIlI -> llllllllllllllllIIllllllllIllIlI instanceof EntityPlayer).filter(llllllllllllllllIIllllllllIlllIl -> llllllllllllllllIIllllllllIlllIl != AutoWasp.mc.thePlayer).min(Comparator.comparing(llllllllllllllllIIlllllllllIIIIl -> Float.valueOf(AutoWasp.mc.thePlayer.getDistanceToEntity(llllllllllllllllIIlllllllllIIIIl)))).orElse(null);
    }

    public AutoWasp() {
        super("AutoWasp", Module.Category.MOVEMENT);
        AutoWasp llllllllllllllllIIllllllllllIllI;
        llllllllllllllllIIllllllllllIllI.l_Player = null;
    }

    @Override
    public void onEnable() {
        AutoWasp llllllllllllllllIIllllllllllIIIl;
        if (AutoWasp.mc.thePlayer == null) {
            llllllllllllllllIIllllllllllIIIl.toggle();
        }
        llllllllllllllllIIllllllllllIIIl.l_Player = llllllllllllllllIIllllllllllIIIl.getcloseplayer();
    }

    @Override
    public void onUpdate() {
        AutoWasp llllllllllllllllIIlllllllllIIllI;
        if (llllllllllllllllIIlllllllllIIllI.l_Player == null) {
            llllllllllllllllIIlllllllllIIllI.l_Player = llllllllllllllllIIlllllllllIIllI.getcloseplayer();
        }
        if (llllllllllllllllIIlllllllllIIllI.l_Player == null) {
            return;
        }
        if (llllllllllllllllIIlllllllllIIllI.l_Player.isDead || llllllllllllllllIIlllllllllIIllI.l_Player.getHealth() + llllllllllllllllIIlllllllllIIllI.l_Player.getAbsorptionAmount() <= 0.0f) {
            llllllllllllllllIIlllllllllIIllI.l_Player = null;
            return;
        }
        if (!llllllllllllllllIIlllllllllIIllI.TargetFriends.getValue() && Friends.isFriend(llllllllllllllllIIlllllllllIIllI.l_Player.getName())) {
            llllllllllllllllIIlllllllllIIllI.l_Player = null;
            return;
        }
        InventoryPlayer llllllllllllllllIIlllllllllIlIII = llllllllllllllllIIlllllllllIIllI.l_Player.inventory;
        ItemStack llllllllllllllllIIlllllllllIIlll = llllllllllllllllIIlllllllllIlIII.armorItemInSlot(2);
        if (llllllllllllllllIIlllllllllIIllI.OnlyElytra.getValue() && llllllllllllllllIIlllllllllIIlll.getItem() != Items.field_185160_cR) {
            llllllllllllllllIIlllllllllIIllI.l_Player = null;
            return;
        }
        if (llllllllllllllllIIlllllllllIIllI.BedBombMode.getValue()) {
            AutoWasp.mc.thePlayer.setPosition(llllllllllllllllIIlllllllllIIllI.l_Player.posX, llllllllllllllllIIlllllllllIIllI.l_Player.posY - (double)llllllllllllllllIIlllllllllIIllI.BedBombModeh.getValue(), llllllllllllllllIIlllllllllIIllI.l_Player.posZ);
        } else {
            AutoWasp.mc.thePlayer.setPosition(llllllllllllllllIIlllllllllIIllI.l_Player.posX, llllllllllllllllIIlllllllllIIllI.l_Player.posY, llllllllllllllllIIlllllllllIIllI.l_Player.posZ);
        }
    }

    @Override
    public void setup() {
        AutoWasp llllllllllllllllIIllllllllllIlII;
        llllllllllllllllIIllllllllllIlII.TargetFriends = llllllllllllllllIIllllllllllIlII.registerB("TargetFriends", false);
        llllllllllllllllIIllllllllllIlII.OnlyElytra = llllllllllllllllIIllllllllllIlII.registerB("OnlyElytra", true);
        llllllllllllllllIIllllllllllIlII.BedBombMode = llllllllllllllllIIllllllllllIlII.registerB("BedBomb", false);
        llllllllllllllllIIllllllllllIlII.BedBombModeh = llllllllllllllllIIllllllllllIlII.registerI("BedBombHeight", 6, 1, 10);
    }

    @Override
    public void onDisable() {
        llllllllllllllllIIlllllllllIllIl.l_Player = null;
    }
}

