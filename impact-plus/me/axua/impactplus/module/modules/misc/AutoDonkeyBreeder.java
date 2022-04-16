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

import java.util.Comparator;
import me.axua.impactplus.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class AutoDonkeyBreeder
extends Module {
    /* synthetic */ int egapslot;
    /* synthetic */ int emptyslot;

    public AutoDonkeyBreeder() {
        super("AutoDonkeyBreeder", Module.Category.MISC);
        AutoDonkeyBreeder lllllllllllllllllIlIlllIlIIlllIl;
    }

    @Override
    public void onUpdate() {
        Entity lllllllllllllllllIlIlllIlIIlIIll = AutoDonkeyBreeder.mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllllIlIlllIIllIIlIl -> lllllllllllllllllIlIlllIIllIIlIl instanceof EntityDonkey).filter(lllllllllllllllllIlIlllIIllIIlll -> !((EntityDonkey)lllllllllllllllllIlIlllIIllIIlll).isTame()).filter(lllllllllllllllllIlIlllIIllIlIll -> !((EntityDonkey)lllllllllllllllllIlIlllIIllIlIll).isChild()).filter(lllllllllllllllllIlIlllIIllIllIl -> AutoDonkeyBreeder.mc.thePlayer.getDistanceToEntity(lllllllllllllllllIlIlllIIllIllIl) < 10.0f).min(Comparator.comparing(lllllllllllllllllIlIlllIIlllIIIl -> Float.valueOf(AutoDonkeyBreeder.mc.thePlayer.getDistanceToEntity(lllllllllllllllllIlIlllIIlllIIIl)))).orElse(null);
        Entity lllllllllllllllllIlIlllIlIIlIIlI = AutoDonkeyBreeder.mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllllIlIlllIIlllIIll -> lllllllllllllllllIlIlllIIlllIIll instanceof EntityDonkey).filter(lllllllllllllllllIlIlllIIlllIllI -> !((EntityDonkey)lllllllllllllllllIlIlllIIlllIllI).isChild()).filter(lllllllllllllllllIlIlllIIllllIIl -> AutoDonkeyBreeder.mc.thePlayer.getDistanceToEntity(lllllllllllllllllIlIlllIIllllIIl) < 10.0f).min(Comparator.comparing(lllllllllllllllllIlIlllIIlllllIl -> Float.valueOf(AutoDonkeyBreeder.mc.thePlayer.getDistanceToEntity(lllllllllllllllllIlIlllIIlllllIl)))).orElse(null);
        Entity lllllllllllllllllIlIlllIlIIlIIIl = AutoDonkeyBreeder.mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllllIlIlllIlIIIIIII -> lllllllllllllllllIlIlllIlIIIIIII instanceof EntityDonkey).filter(lllllllllllllllllIlIlllIlIIIIIll -> ((EntityDonkey)lllllllllllllllllIlIlllIlIIIIIll).isChild()).filter(lllllllllllllllllIlIlllIlIIIIlIl -> AutoDonkeyBreeder.mc.thePlayer.getDistanceToEntity(lllllllllllllllllIlIlllIlIIIIlIl) < 10.0f).min(Comparator.comparing(lllllllllllllllllIlIlllIlIIIlIII -> Float.valueOf(AutoDonkeyBreeder.mc.thePlayer.getDistanceToEntity(lllllllllllllllllIlIlllIlIIIlIII)))).orElse(null);
        if (lllllllllllllllllIlIlllIlIIlIIll != null && !lllllllllllllllllIlIlllIlIIlIIll.func_184207_aI() && !((EntityDonkey)lllllllllllllllllIlIlllIlIIlIIll).isTame()) {
            AutoDonkeyBreeder lllllllllllllllllIlIlllIlIIlIIII;
            for (int lllllllllllllllllIlIlllIlIIlIlIl = 0; lllllllllllllllllIlIlllIlIIlIlIl < 9; ++lllllllllllllllllIlIlllIlIIlIlIl) {
                ItemStack lllllllllllllllllIlIlllIlIIlIllI = AutoDonkeyBreeder.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllllIlIlllIlIIlIlIl);
                if (lllllllllllllllllIlIlllIlIIlIllI.getItem() != Items.field_190931_a) continue;
                lllllllllllllllllIlIlllIlIIlIIII.emptyslot = lllllllllllllllllIlIlllIlIIlIlIl;
            }
            AutoDonkeyBreeder.mc.thePlayer.inventory.currentItem = lllllllllllllllllIlIlllIlIIlIIII.emptyslot;
            AutoDonkeyBreeder.mc.playerController.func_187097_a((EntityPlayer)AutoDonkeyBreeder.mc.thePlayer, lllllllllllllllllIlIlllIlIIlIIll, EnumHand.MAIN_HAND);
        }
        if (lllllllllllllllllIlIlllIlIIlIIlI != null && lllllllllllllllllIlIlllIlIIlIIlI.func_184207_aI() && ((EntityDonkey)lllllllllllllllllIlIlllIlIIlIIlI).isTame()) {
            Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = true;
            Minecraft.getMinecraft().gameSettings.keyBindSneak.pressed = false;
        }
    }
}

