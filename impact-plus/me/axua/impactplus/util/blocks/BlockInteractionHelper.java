/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Rotation
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.util.blocks;

import java.util.Arrays;
import java.util.List;
import me.axua.impactplus.util.Wrapper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class BlockInteractionHelper {
    public static final /* synthetic */ List<Block> shulkerList;

    private static Vec3d getEyesPos() {
        return new Vec3d(Wrapper.getPlayer().posX, Wrapper.getPlayer().posY + (double)Wrapper.getPlayer().getEyeHeight(), Wrapper.getPlayer().posZ);
    }

    private static float[] getLegitRotations(Vec3d lIIlllIIIlllIll) {
        Vec3d lIIlllIIIlllIlI = BlockInteractionHelper.getEyesPos();
        double lIIlllIIIlllIII = lIIlllIIIlllIll.xCoord - lIIlllIIIlllIlI.xCoord;
        double lIIlllIIIllIllI = lIIlllIIIlllIll.yCoord - lIIlllIIIlllIlI.yCoord;
        double lIIlllIIIllIlII = lIIlllIIIlllIll.zCoord - lIIlllIIIlllIlI.zCoord;
        double lIIlllIIIllIIlI = Math.sqrt(lIIlllIIIlllIII * lIIlllIIIlllIII + lIIlllIIIllIlII * lIIlllIIIllIlII);
        float lIIlllIIIllIIIl = (float)Math.toDegrees(Math.atan2(lIIlllIIIllIlII, lIIlllIIIlllIII)) - 90.0f;
        float lIIlllIIIlIllll = (float)(-Math.toDegrees(Math.atan2(lIIlllIIIllIllI, lIIlllIIIllIIlI)));
        return new float[]{Wrapper.getPlayer().rotationYaw + MathHelper.wrapAngleTo180_float((float)(lIIlllIIIllIIIl - Wrapper.getPlayer().rotationYaw)), Wrapper.getPlayer().rotationPitch + MathHelper.wrapAngleTo180_float((float)(lIIlllIIIlIllll - Wrapper.getPlayer().rotationPitch))};
    }

    public static boolean canBeClicked(BlockPos lIIlllIIIIlIlIl) {
        return BlockInteractionHelper.getBlock(lIIlllIIIIlIlIl).canCollideCheck(BlockInteractionHelper.getState(lIIlllIIIIlIlIl), false);
    }

    private static IBlockState getState(BlockPos lIIlllIIIIIIIIl) {
        return Wrapper.getWorld().getBlockState(lIIlllIIIIIIIIl);
    }

    static {
        shulkerList = Arrays.asList(Blocks.field_190977_dl, Blocks.field_190978_dm, Blocks.field_190979_dn, Blocks.field_190980_do, Blocks.field_190981_dp, Blocks.field_190982_dq, Blocks.field_190983_dr, Blocks.field_190984_ds, Blocks.field_190985_dt, Blocks.field_190986_du, Blocks.field_190987_dv, Blocks.field_190988_dw, Blocks.field_190989_dx, Blocks.field_190990_dy, Blocks.field_190991_dz, Blocks.field_190975_dA);
    }

    public BlockInteractionHelper() {
        BlockInteractionHelper lIIlllIIllIlIlI;
    }

    private static Block getBlock(BlockPos lIIlllIIIIIllIl) {
        return BlockInteractionHelper.getState(lIIlllIIIIIllIl).getBlock();
    }

    public static void faceVectorPacketInstant(Vec3d lIIlllIIIIllIIl) {
        float[] lIIlllIIIIllIlI = BlockInteractionHelper.getLegitRotations(lIIlllIIIIllIIl);
        Wrapper.getPlayer().sendQueue.addToSendQueue((Packet)new CPacketPlayer.Rotation(lIIlllIIIIllIlI[0], lIIlllIIIIllIlI[1], Wrapper.getPlayer().onGround));
    }
}

