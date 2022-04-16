/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.combat;

import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.util.blocks.BlockInteractionHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class SelfWeb
extends Module {
    /* synthetic */ int webSlot;

    public static Vec3d getInterpolatedPos(Entity lllllllllllllllllllllIIllllIIIII, float lllllllllllllllllllllIIlllIllllI) {
        return new Vec3d(lllllllllllllllllllllIIllllIIIII.lastTickPosX, lllllllllllllllllllllIIllllIIIII.lastTickPosY, lllllllllllllllllllllIIllllIIIII.lastTickPosZ).add(SelfWeb.getInterpolatedAmount(lllllllllllllllllllllIIllllIIIII, lllllllllllllllllllllIIlllIllllI));
    }

    private void placeBlock(BlockPos lllllllllllllllllllllIIllIlIIIll, EnumFacing lllllllllllllllllllllIIllIlIlIII) {
        BlockPos lllllllllllllllllllllIIllIlIIlll = lllllllllllllllllllllIIllIlIIIll.offset(lllllllllllllllllllllIIllIlIlIII);
        EnumFacing lllllllllllllllllllllIIllIlIIlIl = lllllllllllllllllllllIIllIlIlIII.getOpposite();
        Vec3d lllllllllllllllllllllIIllIlIIlII = new Vec3d((Vec3i)lllllllllllllllllllllIIllIlIIlll).addVector(0.5, 0.5, 0.5).add(new Vec3d(lllllllllllllllllllllIIllIlIIlIl.getDirectionVec()).func_186678_a(0.5));
        BlockInteractionHelper.faceVectorPacketInstant(lllllllllllllllllllllIIllIlIIlII);
        SelfWeb.mc.playerController.func_187099_a(SelfWeb.mc.thePlayer, SelfWeb.mc.theWorld, lllllllllllllllllllllIIllIlIIlll, lllllllllllllllllllllIIllIlIIlIl, lllllllllllllllllllllIIllIlIIlII, EnumHand.MAIN_HAND);
        SelfWeb.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
    }

    public SelfWeb() {
        super("SelfWeb", Module.Category.COMBAT, "SelfWeb");
        SelfWeb lllllllllllllllllllllIIlllllIIIl;
    }

    @Override
    public void onUpdate() {
        SelfWeb lllllllllllllllllllllIIllllIlIll;
        SelfWeb.mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllllllllIIlIlllllIl -> lllllllllllllllllllllIIlIlllllIl instanceof EntityPlayer).filter(lllllllllllllllllllllIIllIIIIIll -> lllllllllllllllllllllIIllIIIIIll != SelfWeb.mc.thePlayer).forEach(lllllllllllllllllllllIIllIIIllII -> {
            lllllllllllllllllllllIIllIIIlIlI.webSlot = -1;
            float lllllllllllllllllllllIIllIIIlIll = SelfWeb.mc.thePlayer.getDistanceToEntity(lllllllllllllllllllllIIllIIIllII);
            if (lllllllllllllllllllllIIllIIIlIll < 1.0f) {
                SelfWeb lllllllllllllllllllllIIllIIIlIlI;
                for (int lllllllllllllllllllllIIllIIlIIIl = 0; lllllllllllllllllllllIIllIIlIIIl < 9 && lllllllllllllllllllllIIllIIIlIlI.webSlot == -1; ++lllllllllllllllllllllIIllIIlIIIl) {
                    ItemStack lllllllllllllllllllllIIllIIlIIlI = SelfWeb.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllllllllIIllIIlIIIl);
                    if (lllllllllllllllllllllIIllIIlIIlI.getItem() != Items.field_185161_cS) continue;
                    lllllllllllllllllllllIIllIIIlIlI.webSlot = lllllllllllllllllllllIIllIIlIIIl;
                }
                if (lllllllllllllllllllllIIllIIIlIlI.webSlot == -1) {
                    Command.sendClientMessage("[AutoWeb] Web missing, disabling.");
                    lllllllllllllllllllllIIllIIIlIlI.disable();
                    return;
                }
                SelfWeb.mc.thePlayer.inventory.currentItem = lllllllllllllllllllllIIllIIIlIlI.webSlot;
                Vec3d lllllllllllllllllllllIIllIIlIIII = SelfWeb.getInterpolatedPos((Entity)SelfWeb.mc.thePlayer, mc.func_184121_ak());
                BlockPos lllllllllllllllllllllIIllIIIllll = new BlockPos(lllllllllllllllllllllIIllIIlIIII);
                BlockPos lllllllllllllllllllllIIllIIIlllI = lllllllllllllllllllllIIllIIIllll.add(-1, 0, 0);
                lllllllllllllllllllllIIllIIIlIlI.placeBlock(lllllllllllllllllllllIIllIIIlllI, EnumFacing.DOWN);
            }
        });
    }

    public static Vec3d getInterpolatedAmount(Entity lllllllllllllllllllllIIlllIIllII, double lllllllllllllllllllllIIlllIIlIll) {
        return SelfWeb.getInterpolatedAmount(lllllllllllllllllllllIIlllIIllII, lllllllllllllllllllllIIlllIIlIll, lllllllllllllllllllllIIlllIIlIll, lllllllllllllllllllllIIlllIIlIll);
    }

    public static Vec3d getInterpolatedAmount(Entity lllllllllllllllllllllIIlllIIIlII, double lllllllllllllllllllllIIlllIIIIlI, double lllllllllllllllllllllIIlllIIIIIl, double lllllllllllllllllllllIIllIllllll) {
        return new Vec3d((lllllllllllllllllllllIIlllIIIlII.posX - lllllllllllllllllllllIIlllIIIlII.lastTickPosX) * lllllllllllllllllllllIIlllIIIIlI, (lllllllllllllllllllllIIlllIIIlII.posY - lllllllllllllllllllllIIlllIIIlII.lastTickPosY) * lllllllllllllllllllllIIlllIIIIIl, (lllllllllllllllllllllIIlllIIIlII.posZ - lllllllllllllllllllllIIlllIIIlII.lastTickPosZ) * lllllllllllllllllllllIIllIllllll);
    }
}

