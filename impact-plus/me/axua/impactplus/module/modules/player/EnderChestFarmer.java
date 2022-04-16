/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 */
package me.axua.impactplus.module.modules.player;

import me.axua.impactplus.module.Module;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

public class EnderChestFarmer
extends Module {
    public EnderChestFarmer() {
        super("EnderChestFarmer", Module.Category.PLAYER);
        EnderChestFarmer lIllIlIlIllI;
    }

    @Override
    public void onUpdate() {
        BlockPos lIllIlIIlIll;
        IBlockState lIllIlIIlIlI;
        Minecraft lIllIlIIlIII = Minecraft.getMinecraft();
        RayTraceResult lIllIlIIIlll = lIllIlIIlIII.objectMouseOver;
        if (lIllIlIIIlll == null) {
            return;
        }
        if (lIllIlIIIlll.typeOfHit != RayTraceResult.Type.BLOCK || (lIllIlIIlIlI = lIllIlIIlIII.theWorld.getBlockState(lIllIlIIlIll = lIllIlIIIlll.getBlockPos())).func_185904_a() == Material.air || lIllIlIIlIII.theWorld.getWorldBorder().contains(lIllIlIIlIll)) {
            // empty if block
        }
    }
}

