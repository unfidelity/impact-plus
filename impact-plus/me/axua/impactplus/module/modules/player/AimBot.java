/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.MathHelper
 */
package me.axua.impactplus.module.modules.player;

import java.util.Comparator;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;

public class AimBot
extends Module {
    public /* synthetic */ Setting.b TargetFriends;
    public /* synthetic */ Setting.b OnlyElytra;

    @Override
    public void setup() {
        AimBot lllllllllllllllllIIlllIllIlIIlll;
        lllllllllllllllllIIlllIllIlIIlll.TargetFriends = lllllllllllllllllIIlllIllIlIIlll.registerB("TargetFriends", false);
        lllllllllllllllllIIlllIllIlIIlll.OnlyElytra = lllllllllllllllllIIlllIllIlIIlll.registerB("OnlyElytra", true);
    }

    public static void rotateClient(double lllllllllllllllllIIlllIllIIIIlIl, double lllllllllllllllllIIlllIllIIIIlII, double lllllllllllllllllIIlllIllIIIllII) {
        double lllllllllllllllllIIlllIllIIIlIll = lllllllllllllllllIIlllIllIIIIlIl - AimBot.mc.thePlayer.posX;
        double lllllllllllllllllIIlllIllIIIlIlI = lllllllllllllllllIIlllIllIIIIlII - AimBot.mc.thePlayer.posY + (double)AimBot.mc.thePlayer.getEyeHeight();
        double lllllllllllllllllIIlllIllIIIlIIl = lllllllllllllllllIIlllIllIIIllII - AimBot.mc.thePlayer.posZ;
        double lllllllllllllllllIIlllIllIIIlIII = Math.sqrt(lllllllllllllllllIIlllIllIIIlIll * lllllllllllllllllIIlllIllIIIlIll + lllllllllllllllllIIlllIllIIIlIIl * lllllllllllllllllIIlllIllIIIlIIl);
        float lllllllllllllllllIIlllIllIIIIlll = (float)Math.toDegrees(Math.atan2(lllllllllllllllllIIlllIllIIIlIIl, lllllllllllllllllIIlllIllIIIlIll)) - 90.0f;
        float lllllllllllllllllIIlllIllIIIIllI = (float)(-Math.toDegrees(Math.atan2(lllllllllllllllllIIlllIllIIIlIlI, lllllllllllllllllIIlllIllIIIlIII)));
        AimBot.mc.thePlayer.rotationYaw += MathHelper.wrapAngleTo180_float((float)(lllllllllllllllllIIlllIllIIIIlll - AimBot.mc.thePlayer.rotationYaw));
        AimBot.mc.thePlayer.rotationPitch += MathHelper.wrapAngleTo180_float((float)(lllllllllllllllllIIlllIllIIIIllI - AimBot.mc.thePlayer.rotationPitch));
    }

    @Override
    public void onUpdate() {
        EntityPlayer lllllllllllllllllIIlllIllIIlllIl = AimBot.mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllllIIlllIlIlllIlIl -> lllllllllllllllllIIlllIlIlllIlIl instanceof EntityPlayer).filter(lllllllllllllllllIIlllIlIllllIII -> lllllllllllllllllIIlllIlIllllIII != AimBot.mc.thePlayer).min(Comparator.comparing(lllllllllllllllllIIlllIlIllllIll -> Float.valueOf(AimBot.mc.thePlayer.getDistanceToEntity(lllllllllllllllllIIlllIlIllllIll)))).orElse(null);
        if (lllllllllllllllllIIlllIllIIlllIl != null) {
            AimBot lllllllllllllllllIIlllIllIIlllII;
            if (!lllllllllllllllllIIlllIllIIlllII.TargetFriends.getValue() && Friends.isFriend(lllllllllllllllllIIlllIllIIlllIl.getName())) {
                return;
            }
            InventoryPlayer lllllllllllllllllIIlllIllIlIIIIl = lllllllllllllllllIIlllIllIIlllIl.inventory;
            ItemStack lllllllllllllllllIIlllIllIlIIIII = lllllllllllllllllIIlllIllIlIIIIl.armorItemInSlot(2);
            String lllllllllllllllllIIlllIllIIlllll = lllllllllllllllllIIlllIllIlIIIII.getItem().getItemStackDisplayName(lllllllllllllllllIIlllIllIlIIIII);
            if (lllllllllllllllllIIlllIllIIlllII.OnlyElytra.getValue() && !lllllllllllllllllIIlllIllIIlllll.equals("Elytra")) {
                return;
            }
            if (AimBot.mc.thePlayer.func_184613_cA()) {
                AimBot.rotateClient(lllllllllllllllllIIlllIllIIlllIl.posX, lllllllllllllllllIIlllIllIIlllIl.posY + 0.4, lllllllllllllllllIIlllIllIIlllIl.posZ);
            } else {
                AimBot.rotateClient(lllllllllllllllllIIlllIllIIlllIl.posX, lllllllllllllllllIIlllIllIIlllIl.posY - 2.0, lllllllllllllllllIIlllIllIIlllIl.posZ);
            }
        }
    }

    public AimBot() {
        super("AimBot", Module.Category.PLAYER);
        AimBot lllllllllllllllllIIlllIllIlIlIlI;
    }
}

