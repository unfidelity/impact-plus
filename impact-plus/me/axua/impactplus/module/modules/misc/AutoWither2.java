/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.module.modules.misc;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.blocks.WorldUtils;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class AutoWither2
extends Module {
    private /* synthetic */ Timer _Timer;
    /* synthetic */ Setting.b auto;
    /* synthetic */ Setting.b render;
    /* synthetic */ Map<BlockPos, Block> mapOne;
    /* synthetic */ Setting.i delay;

    public boolean isEntitiesEmpty(BlockPos llllllllllllllllIlllIlIlIIlIlIll) {
        List llllllllllllllllIlllIlIlIIlIllll = AutoWither2.mc.theWorld.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(llllllllllllllllIlllIlIlIIlIlIll)).stream().filter(llllllllllllllllIlllIlIIlllllIlI -> !(llllllllllllllllIlllIlIIlllllIlI instanceof EntityItem)).filter(llllllllllllllllIlllIlIIllllllll -> !(llllllllllllllllIlllIlIIllllllll instanceof EntityXPOrb)).collect(Collectors.toList());
        return llllllllllllllllIlllIlIlIIlIllll.isEmpty();
    }

    @Override
    public void setup() {
        AutoWither2 llllllllllllllllIlllIlIllllllIll;
        llllllllllllllllIlllIlIllllllIll.auto = llllllllllllllllIlllIlIllllllIll.registerB("Auto", false);
        llllllllllllllllIlllIlIllllllIll.render = llllllllllllllllIlllIlIllllllIll.registerB("Render", false);
        llllllllllllllllIlllIlIllllllIll.delay = llllllllllllllllIlllIlIllllllIll.registerI("Delay", 5, 3, 20);
    }

    @Override
    public void onUpdate() {
        AutoWither2 llllllllllllllllIlllIlIlllllIIlI;
        if (AutoWither2.mc.thePlayer.ticksExisted % llllllllllllllllIlllIlIlllllIIlI.delay.getValue() == 0) {
            if (llllllllllllllllIlllIlIlllllIIlI.mapOne.isEmpty()) {
                llllllllllllllllIlllIlIlllllIIlI.update(0);
            } else {
                llllllllllllllllIlllIlIlllllIIlI.update(1);
            }
        }
    }

    public void update(int llllllllllllllllIlllIlIllllIIIII) {
        AutoWither2 llllllllllllllllIlllIlIllllIIIIl;
        if (llllllllllllllllIlllIlIllllIIIIl.loop(llllllllllllllllIlllIlIllllIIIII) || llllllllllllllllIlllIlIllllIIIII == 1) {
            AtomicInteger llllllllllllllllIlllIlIllllIIlll = new AtomicInteger();
            llllllllllllllllIlllIlIllllIIIIl.mapOne.forEach((llllllllllllllllIlllIlIIlIllIIII, llllllllllllllllIlllIlIIlIllIlIl) -> {
                AutoWither2 llllllllllllllllIlllIlIIlIlllIIl;
                if (AutoWither2.mc.thePlayer.getDistance((double)llllllllllllllllIlllIlIIlIllIIII.getX(), (double)llllllllllllllllIlllIlIIlIllIIII.getY(), (double)llllllllllllllllIlllIlIIlIllIIII.getZ()) >= 7.0 || !llllllllllllllllIlllIlIIlIlllIIl.isEntitiesEmpty((BlockPos)llllllllllllllllIlllIlIIlIllIIII)) {
                    llllllllllllllllIlllIlIllllIIlll.getAndIncrement();
                }
            });
            if (llllllllllllllllIlllIlIllllIIlll.get() > 0) {
                llllllllllllllllIlllIlIllllIIIIl.mapOne.clear();
                return;
            }
            int llllllllllllllllIlllIlIllllIIllI = -1;
            int llllllllllllllllIlllIlIllllIIlIl = -1;
            for (int llllllllllllllllIlllIlIllllIlIII = 0; llllllllllllllllIlllIlIllllIlIII < 9; ++llllllllllllllllIlllIlIllllIlIII) {
                if (AutoWither2.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIlllIlIllllIlIII).getItem() == Item.getItemFromBlock((Block)Blocks.soul_sand)) {
                    llllllllllllllllIlllIlIllllIIllI = llllllllllllllllIlllIlIllllIlIII;
                    continue;
                }
                if (AutoWither2.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllIlllIlIllllIlIII).getItem() != Items.skull) continue;
                llllllllllllllllIlllIlIllllIIlIl = llllllllllllllllIlllIlIllllIlIII;
            }
            if (llllllllllllllllIlllIlIllllIIllI == -1 || llllllllllllllllIlllIlIllllIIlIl == -1) {
                return;
            }
            int llllllllllllllllIlllIlIllllIIlII = llllllllllllllllIlllIlIllllIIllI;
            int llllllllllllllllIlllIlIllllIIIll = llllllllllllllllIlllIlIllllIIlIl;
            llllllllllllllllIlllIlIllllIIIIl.mapOne.forEach((llllllllllllllllIlllIlIIllIIllII, llllllllllllllllIlllIlIIllIIlIlI) -> {
                if (AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIIllIIllII).getBlock() != llllllllllllllllIlllIlIIllIIlIlI) {
                    if (llllllllllllllllIlllIlIIllIIlIlI == Blocks.soul_sand && !WorldUtils.placeBlock(llllllllllllllllIlllIlIIllIIllII, llllllllllllllllIlllIlIllllIIlII, false, false)) {
                        return;
                    }
                    if (llllllllllllllllIlllIlIIllIIlIlI == Blocks.skull && !WorldUtils.placeBlock(llllllllllllllllIlllIlIIllIIllII, llllllllllllllllIlllIlIllllIIIll, false, false)) {
                        return;
                    }
                }
            });
            AtomicInteger llllllllllllllllIlllIlIllllIIIlI = new AtomicInteger();
            llllllllllllllllIlllIlIllllIIIIl.mapOne.forEach((llllllllllllllllIlllIlIIllIlllll, llllllllllllllllIlllIlIIllIllllI) -> {
                AutoWither2 llllllllllllllllIlllIlIIllIlllIl;
                if (AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIIllIlllll).getBlock() != Blocks.air || !llllllllllllllllIlllIlIIllIlllIl.isEntitiesEmpty((BlockPos)llllllllllllllllIlllIlIIllIlllll)) {
                    llllllllllllllllIlllIlIllllIIIlI.getAndIncrement();
                }
            });
            if (llllllllllllllllIlllIlIllllIIIlI.get() == 0) {
                llllllllllllllllIlllIlIllllIIIIl.mapOne.clear();
            } else {
                llllllllllllllllIlllIlIllllIIIIl._Timer.cancel();
                llllllllllllllllIlllIlIllllIIIIl._Timer = new Timer();
                llllllllllllllllIlllIlIllllIIIIl._Timer.schedule(new TimerTask(){

                    @Override
                    public void run() {
                        1 lllllllllllllllllIIIlIIlIIllIlII;
                        lllllllllllllllllIIIlIIlIIllIlII.AutoWither2.this.update(1);
                    }
                    {
                        1 lllllllllllllllllIIIlIIlIIlllIlI;
                    }
                }, 200L);
            }
        }
    }

    public void drawBox(BlockPos llllllllllllllllIlllIlIlIlIllIIl, int llllllllllllllllIlllIlIlIlIllIII, int llllllllllllllllIlllIlIlIlIlllII, int llllllllllllllllIlllIlIlIlIlIlII, int llllllllllllllllIlllIlIlIlIllIlI) {
        Tessellator.prepare(7);
        Tessellator.drawBox(llllllllllllllllIlllIlIlIlIllIIl, llllllllllllllllIlllIlIlIlIllIII, llllllllllllllllIlllIlIlIlIlllII, llllllllllllllllIlllIlIlIlIlIlII, llllllllllllllllIlllIlIlIlIllIlI, 63);
        Tessellator.release();
    }

    public Vec3d getInterpolatedPos(Entity llllllllllllllllIlllIlIlIIlIIIIl, float llllllllllllllllIlllIlIlIIlIIIll) {
        AutoWither2 llllllllllllllllIlllIlIlIIlIIIlI;
        return new Vec3d(llllllllllllllllIlllIlIlIIlIIIIl.lastTickPosX, llllllllllllllllIlllIlIlIIlIIIIl.lastTickPosY, llllllllllllllllIlllIlIlIIlIIIIl.lastTickPosZ).add(llllllllllllllllIlllIlIlIIlIIIlI.getInterpolatedAmount(llllllllllllllllIlllIlIlIIlIIIIl, llllllllllllllllIlllIlIlIIlIIIll));
    }

    public AutoWither2() {
        super("AutoWither2", Module.Category.MISC);
        AutoWither2 llllllllllllllllIlllIlIlllllllIl;
        llllllllllllllllIlllIlIlllllllIl.mapOne = new LinkedHashMap<BlockPos, Block>();
        llllllllllllllllIlllIlIlllllllIl._Timer = new Timer();
    }

    public Vec3d getInterpolatedAmount(Entity llllllllllllllllIlllIlIlIIIllIlI, double llllllllllllllllIlllIlIlIIIllIIl) {
        AutoWither2 llllllllllllllllIlllIlIlIIIllIll;
        return llllllllllllllllIlllIlIlIIIllIll.getInterpolatedAmount(llllllllllllllllIlllIlIlIIIllIlI, llllllllllllllllIlllIlIlIIIllIIl, llllllllllllllllIlllIlIlIIIllIIl, llllllllllllllllIlllIlIlIIIllIIl);
    }

    @Override
    public void onDisable() {
        AutoWither2 llllllllllllllllIlllIlIlllllIlII;
        llllllllllllllllIlllIlIlllllIlII.mapOne.clear();
    }

    public boolean loop(int llllllllllllllllIlllIlIllIIllllI) {
        AutoWither2 llllllllllllllllIlllIlIllIIlllll;
        if (llllllllllllllllIlllIlIllIIllllI == 1) {
            return false;
        }
        llllllllllllllllIlllIlIllIIlllll.mapOne.clear();
        Vec3d llllllllllllllllIlllIlIllIIlllII = llllllllllllllllIlllIlIllIIlllll.getInterpolatedPos((Entity)AutoWither2.mc.thePlayer, mc.func_184121_ak());
        BlockPos llllllllllllllllIlllIlIllIIllIlI = new BlockPos(llllllllllllllllIlllIlIllIIlllII);
        for (int llllllllllllllllIlllIlIllIlIIIIl = -2; llllllllllllllllIlllIlIllIlIIIIl < 3; ++llllllllllllllllIlllIlIllIlIIIIl) {
            for (int llllllllllllllllIlllIlIllIlIIIlI = -1; llllllllllllllllIlllIlIllIlIIIlI < 1; ++llllllllllllllllIlllIlIllIlIIIlI) {
                for (int llllllllllllllllIlllIlIllIlIIIll = -2; llllllllllllllllIlllIlIllIlIIIll < 3; ++llllllllllllllllIlllIlIllIlIIIll) {
                    BlockPos llllllllllllllllIlllIlIllIlIllII = llllllllllllllllIlllIlIllIIllIlI.add(llllllllllllllllIlllIlIllIlIIIIl, llllllllllllllllIlllIlIllIlIIIlI, llllllllllllllllIlllIlIllIlIIIll);
                    BlockPos llllllllllllllllIlllIlIllIlIlIll = llllllllllllllllIlllIlIllIlIllII.add(-1, 0, 0);
                    BlockPos llllllllllllllllIlllIlIllIlIlIlI = llllllllllllllllIlllIlIllIlIllII.add(1, 0, 0);
                    BlockPos llllllllllllllllIlllIlIllIlIlIIl = llllllllllllllllIlllIlIllIlIllII.add(-1, 1, 0);
                    BlockPos llllllllllllllllIlllIlIllIlIlIII = llllllllllllllllIlllIlIllIlIllII.add(0, 1, 0);
                    BlockPos llllllllllllllllIlllIlIllIlIIlll = llllllllllllllllIlllIlIllIlIllII.add(1, 1, 0);
                    BlockPos llllllllllllllllIlllIlIllIlIIllI = llllllllllllllllIlllIlIllIlIllII.add(-1, 2, 0);
                    BlockPos llllllllllllllllIlllIlIllIlIIlIl = llllllllllllllllIlllIlIllIlIllII.add(0, 2, 0);
                    BlockPos llllllllllllllllIlllIlIllIlIIlII = llllllllllllllllIlllIlIllIlIllII.add(1, 2, 0);
                    if (AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIlIll).getBlock() != Blocks.air || AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIllII).getBlock() != Blocks.air && AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIllII).getBlock() != Blocks.soul_sand || AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIlIlI).getBlock() != Blocks.air || AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIlIIl).getBlock() != Blocks.air && AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIlIIl).getBlock() != Blocks.soul_sand || AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIlIII).getBlock() != Blocks.air && AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIlIII).getBlock() != Blocks.soul_sand || AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIIlll).getBlock() != Blocks.air && AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIIlll).getBlock() != Blocks.soul_sand || AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIIllI).getBlock() != Blocks.air && AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIIllI).getBlock() != Blocks.skull || AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIIlIl).getBlock() != Blocks.air && AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIIlIl).getBlock() != Blocks.skull || AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIIlII).getBlock() != Blocks.air && AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIllIlIIlII).getBlock() != Blocks.skull || !llllllllllllllllIlllIlIllIIlllll.isEntitiesEmpty(llllllllllllllllIlllIlIllIlIlIll) || !llllllllllllllllIlllIlIllIIlllll.isEntitiesEmpty(llllllllllllllllIlllIlIllIlIllII) || !llllllllllllllllIlllIlIllIIlllll.isEntitiesEmpty(llllllllllllllllIlllIlIllIlIlIlI) || !llllllllllllllllIlllIlIllIIlllll.isEntitiesEmpty(llllllllllllllllIlllIlIllIlIlIIl) || !llllllllllllllllIlllIlIllIIlllll.isEntitiesEmpty(llllllllllllllllIlllIlIllIlIlIII) || !llllllllllllllllIlllIlIllIIlllll.isEntitiesEmpty(llllllllllllllllIlllIlIllIlIIlll) || !llllllllllllllllIlllIlIllIIlllll.isEntitiesEmpty(llllllllllllllllIlllIlIllIlIIllI) || !llllllllllllllllIlllIlIllIIlllll.isEntitiesEmpty(llllllllllllllllIlllIlIllIlIIlIl) || !llllllllllllllllIlllIlIllIIlllll.isEntitiesEmpty(llllllllllllllllIlllIlIllIlIIlII)) continue;
                    llllllllllllllllIlllIlIllIIlllll.mapOne.put(llllllllllllllllIlllIlIllIlIlIll, Blocks.air);
                    llllllllllllllllIlllIlIllIIlllll.mapOne.put(llllllllllllllllIlllIlIllIlIllII, Blocks.soul_sand);
                    llllllllllllllllIlllIlIllIIlllll.mapOne.put(llllllllllllllllIlllIlIllIlIlIlI, Blocks.air);
                    llllllllllllllllIlllIlIllIIlllll.mapOne.put(llllllllllllllllIlllIlIllIlIlIIl, Blocks.soul_sand);
                    llllllllllllllllIlllIlIllIIlllll.mapOne.put(llllllllllllllllIlllIlIllIlIlIII, Blocks.soul_sand);
                    llllllllllllllllIlllIlIllIIlllll.mapOne.put(llllllllllllllllIlllIlIllIlIIlll, Blocks.soul_sand);
                    llllllllllllllllIlllIlIllIIlllll.mapOne.put(llllllllllllllllIlllIlIllIlIIllI, (Block)Blocks.skull);
                    llllllllllllllllIlllIlIllIIlllll.mapOne.put(llllllllllllllllIlllIlIllIlIIlIl, (Block)Blocks.skull);
                    llllllllllllllllIlllIlIllIIlllll.mapOne.put(llllllllllllllllIlllIlIllIlIIlII, (Block)Blocks.skull);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onWorldRender(RenderEvent llllllllllllllllIlllIlIlIlllIlII) {
        AutoWither2 llllllllllllllllIlllIlIlIlllIllI;
        if (llllllllllllllllIlllIlIlIlllIllI.render.getValue()) {
            if (llllllllllllllllIlllIlIlIlllIllI.mapOne == null) {
                return;
            }
            try {
                llllllllllllllllIlllIlIlIlllIllI.mapOne.forEach((llllllllllllllllIlllIlIIllllIIll, llllllllllllllllIlllIlIIllllIIlI) -> {
                    if (AutoWither2.mc.theWorld.getBlockState(llllllllllllllllIlllIlIIllllIIll).getBlock() != llllllllllllllllIlllIlIIllllIIlI) {
                        AutoWither2 llllllllllllllllIlllIlIIllllIlII;
                        llllllllllllllllIlllIlIIllllIlII.drawBox((BlockPos)llllllllllllllllIlllIlIIllllIIll, 255, 0, 0, 30);
                        llllllllllllllllIlllIlIIllllIlII.drawboundingBox((BlockPos)llllllllllllllllIlllIlIIllllIIll, 1, 255, 0, 0, 255);
                    }
                });
            }
            catch (Exception llllllllllllllllIlllIlIlIlllIIlI) {
                // empty catch block
            }
        }
    }

    @Override
    public void onEnable() {
        if (AutoWither2.mc.thePlayer == null) {
            AutoWither2 llllllllllllllllIlllIlIlllllIlll;
            llllllllllllllllIlllIlIlllllIlll.disable();
        }
    }

    public void drawboundingBox(BlockPos llllllllllllllllIlllIlIlIlIIIIIl, int llllllllllllllllIlllIlIlIlIIlIII, int llllllllllllllllIlllIlIlIIllllll, int llllllllllllllllIlllIlIlIlIIIllI, int llllllllllllllllIlllIlIlIIllllII, int llllllllllllllllIlllIlIlIIlllIll) {
        ImpactPlusTessellator.prepare(7);
        ImpactPlusTessellator.drawBoundingBoxBlockPos(llllllllllllllllIlllIlIlIlIIIIIl, llllllllllllllllIlllIlIlIlIIlIII, llllllllllllllllIlllIlIlIIllllll, llllllllllllllllIlllIlIlIlIIIllI, llllllllllllllllIlllIlIlIIllllII, llllllllllllllllIlllIlIlIIlllIll);
        ImpactPlusTessellator.release();
    }

    public Vec3d getInterpolatedAmount(Entity llllllllllllllllIlllIlIlIIIIllIl, double llllllllllllllllIlllIlIlIIIIllII, double llllllllllllllllIlllIlIlIIIIIlll, double llllllllllllllllIlllIlIlIIIIIllI) {
        return new Vec3d((llllllllllllllllIlllIlIlIIIIllIl.posX - llllllllllllllllIlllIlIlIIIIllIl.lastTickPosX) * llllllllllllllllIlllIlIlIIIIllII, (llllllllllllllllIlllIlIlIIIIllIl.posY - llllllllllllllllIlllIlIlIIIIllIl.lastTickPosY) * llllllllllllllllIlllIlIlIIIIIlll, (llllllllllllllllIlllIlIlIIIIllIl.posZ - llllllllllllllllIlllIlIlIIIIllIl.lastTickPosZ) * llllllllllllllllIlllIlIlIIIIIllI);
    }
}

