/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.EnumHand
 */
package me.axua.impactplus.module.modules.combat;

import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumHand;

public class Aura32k
extends Module {
    public /* synthetic */ Setting.i range;
    public /* synthetic */ Setting.i delay;
    public /* synthetic */ Setting.b playersOnly;
    private /* synthetic */ int hasWaited;

    private boolean isSuperWeapon(ItemStack lllllllllllllllIllllIIIIIIIIllIl) {
        if (lllllllllllllllIllllIIIIIIIIllIl == null) {
            return false;
        }
        if (lllllllllllllllIllllIIIIIIIIllIl.getTagCompound() == null) {
            return false;
        }
        if (lllllllllllllllIllllIIIIIIIIllIl.getEnchantmentTagList().getTagType() == 0) {
            return false;
        }
        NBTTagList lllllllllllllllIllllIIIIIIIIlIll = (NBTTagList)lllllllllllllllIllllIIIIIIIIllIl.getTagCompound().getTag("ench");
        for (int lllllllllllllllIllllIIIIIIIIlIIl = 0; lllllllllllllllIllllIIIIIIIIlIIl < lllllllllllllllIllllIIIIIIIIlIll.tagCount(); ++lllllllllllllllIllllIIIIIIIIlIIl) {
            NBTTagCompound lllllllllllllllIllllIIIIIIIlIIIl = lllllllllllllllIllllIIIIIIIIlIll.getCompoundTagAt(lllllllllllllllIllllIIIIIIIIlIIl);
            if (lllllllllllllllIllllIIIIIIIlIIIl.getInteger("id") != 16) continue;
            int lllllllllllllllIllllIIIIIIIlIIll = lllllllllllllllIllllIIIIIIIlIIIl.getInteger("lvl");
            if (lllllllllllllllIllllIIIIIIIlIIll < 16) break;
            return true;
        }
        return false;
    }

    public Aura32k() {
        super("32kAura", Module.Category.COMBAT, "32kAura");
        Aura32k lllllllllllllllIllllIIIIIIlllIIl;
    }

    @Override
    public void onUpdate() {
        Aura32k lllllllllllllllIllllIIIIIIlIlIll;
        if (!lllllllllllllllIllllIIIIIIlIlIll.isEnabled() || Aura32k.mc.thePlayer.isDead || Aura32k.mc.theWorld == null) {
            return;
        }
        if (lllllllllllllllIllllIIIIIIlIlIll.hasWaited < lllllllllllllllIllllIIIIIIlIlIll.delay.getValue()) {
            ++lllllllllllllllIllllIIIIIIlIlIll.hasWaited;
            return;
        }
        lllllllllllllllIllllIIIIIIlIlIll.hasWaited = 0;
        for (Entity lllllllllllllllIllllIIIIIIlIllll : Aura32k.mc.theWorld.loadedEntityList) {
            if (!(lllllllllllllllIllllIIIIIIlIllll instanceof EntityLivingBase) || lllllllllllllllIllllIIIIIIlIllll == Aura32k.mc.thePlayer || Aura32k.mc.thePlayer.getDistanceToEntity(lllllllllllllllIllllIIIIIIlIllll) > (float)lllllllllllllllIllllIIIIIIlIlIll.range.getValue() || ((EntityLivingBase)lllllllllllllllIllllIIIIIIlIllll).getHealth() <= 0.0f || !(lllllllllllllllIllllIIIIIIlIllll instanceof EntityPlayer) && lllllllllllllllIllllIIIIIIlIlIll.playersOnly.getValue() || !lllllllllllllllIllllIIIIIIlIlIll.isSuperWeapon(Aura32k.mc.thePlayer.func_184614_ca()) || Friends.isFriend(lllllllllllllllIllllIIIIIIlIllll.getName())) continue;
            Aura32k.mc.playerController.attackEntity((EntityPlayer)Aura32k.mc.thePlayer, lllllllllllllllIllllIIIIIIlIllll);
            Aura32k.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
        }
    }

    @Override
    public void setup() {
        Aura32k lllllllllllllllIllllIIIIIIllIlll;
        lllllllllllllllIllllIIIIIIllIlll.playersOnly = lllllllllllllllIllllIIIIIIllIlll.registerB("PlayersOnly", true);
        lllllllllllllllIllllIIIIIIllIlll.range = lllllllllllllllIllllIIIIIIllIlll.registerI("HitRange", 15, 0, 100);
        lllllllllllllllIllllIIIIIIllIlll.delay = lllllllllllllllIllllIIIIIIllIlll.registerI("TickDelay", -2000, -2000, 2000);
    }
}

