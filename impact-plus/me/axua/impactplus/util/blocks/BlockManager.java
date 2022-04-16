/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.util.blocks;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;

public class BlockManager {
    private static /* synthetic */ BlockPos _currBlock;
    private static /* synthetic */ boolean _started;
    private static /* synthetic */ Minecraft mc;

    public static boolean GetState() {
        if (_currBlock != null) {
            return BlockManager.IsDoneBreaking(BlockManager.mc.theWorld.getBlockState(_currBlock));
        }
        return false;
    }

    static {
        mc = Minecraft.getMinecraft();
        _currBlock = null;
        _started = false;
    }

    public static void SetCurrentBlock(BlockPos lllIIIlIllIlIII) {
        _currBlock = lllIIIlIllIlIII;
        _started = false;
    }

    private static boolean IsDoneBreaking(IBlockState lllIIIlIllIIlII) {
        return lllIIIlIllIIlII.getBlock() == Blocks.bedrock || lllIIIlIllIIlII.getBlock() == Blocks.air || lllIIIlIllIIlII.getBlock() instanceof BlockLiquid;
    }

    public BlockManager() {
        BlockManager lllIIIlIllIlIll;
    }

    public static BlockPos GetCurrBlock() {
        return _currBlock;
    }

    public static boolean Update(float lllIIIlIlIlllIl, boolean lllIIIlIlIllIII) {
        RayTraceResult lllIIIlIlIllllI;
        if (_currBlock == null) {
            return false;
        }
        IBlockState lllIIIlIlIllIll = BlockManager.mc.theWorld.getBlockState(_currBlock);
        if (BlockManager.IsDoneBreaking(lllIIIlIlIllIll) || BlockManager.mc.thePlayer.getDistanceSq(_currBlock) > Math.pow(lllIIIlIlIlllIl, lllIIIlIlIlllIl)) {
            _currBlock = null;
            return false;
        }
        BlockManager.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
        EnumFacing lllIIIlIlIllIlI = EnumFacing.UP;
        if (lllIIIlIlIllIII && (lllIIIlIlIllllI = BlockManager.mc.theWorld.rayTraceBlocks(new Vec3d(BlockManager.mc.thePlayer.posX, BlockManager.mc.thePlayer.posY + (double)BlockManager.mc.thePlayer.getEyeHeight(), BlockManager.mc.thePlayer.posZ), new Vec3d((double)_currBlock.getX() + 0.5, (double)_currBlock.getY() - 0.5, (double)_currBlock.getZ() + 0.5))) != null && lllIIIlIlIllllI.sideHit != null) {
            lllIIIlIlIllIlI = lllIIIlIlIllllI.sideHit;
        }
        if (!_started) {
            _started = true;
            BlockManager.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, _currBlock, lllIIIlIlIllIlI));
        } else {
            BlockManager.mc.playerController.onPlayerDamageBlock(_currBlock, lllIIIlIlIllIlI);
        }
        return true;
    }
}

