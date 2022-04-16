/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.Item
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.blocks.WorldUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class AutoWither
extends Module {
    public /* synthetic */ Setting.d delay;
    private /* synthetic */ Timer _Timer;
    public /* synthetic */ Setting.b auto;
    private /* synthetic */ int rotation;
    private /* synthetic */ BlockPos pos;
    /* synthetic */ int once;

    @Override
    public void onEnable() {
        lIllIIIlIlIlIII.once = 0;
    }

    public AutoWither() {
        super("AutoWither", Module.Category.MISC, "To turn of the auto setting turn of the auto setting!!!!!!!!");
        AutoWither lIllIIIlIlIlllI;
        lIllIIIlIlIlllI._Timer = new Timer();
    }

    public boolean witherBoxIntersects(BlockPos lIllIIIIIlllIIl, int lIllIIIIIllllII) {
        Vec3d lIllIIIIIlllIll = new Vec3d((Vec3i)lIllIIIIIlllIIl);
        AxisAlignedBB lIllIIIIIlllIlI = lIllIIIIIllllII == 0 ? new AxisAlignedBB(lIllIIIIIlllIll.addVector(-1.0, 0.0, 0.0), lIllIIIIIlllIll.addVector(2.0, 3.0, 1.0)) : new AxisAlignedBB(lIllIIIIIlllIll.addVector(0.0, 0.0, -1.0), lIllIIIIIlllIll.addVector(1.0, 3.0, 2.0));
        for (Entity lIllIIIIIllllll : AutoWither.mc.theWorld.loadedEntityList) {
            if (!(lIllIIIIIllllll instanceof EntityLivingBase) || !lIllIIIIIlllIlI.intersectsWith(lIllIIIIIllllll.getEntityBoundingBox())) continue;
            return true;
        }
        return false;
    }

    public void update() {
        AutoWither lIllIIIIlIllllI;
        BlockPos lIllIIIIlIlllIl = AutoWither.mc.thePlayer.getPosition();
        for (int lIllIIIIllIIIIl = -2; lIllIIIIllIIIIl <= 2; ++lIllIIIIllIIIIl) {
            for (int lIllIIIIllIIIlI = -2; lIllIIIIllIIIlI <= 1; ++lIllIIIIllIIIlI) {
                for (int lIllIIIIllIIIll = -2; lIllIIIIllIIIll <= 2; ++lIllIIIIllIIIll) {
                    for (int lIllIIIIllIIlII = 0; lIllIIIIllIIlII <= 1; ++lIllIIIIllIIlII) {
                        BlockPos lIllIIIIllIIlIl = lIllIIIIlIlllIl.add(lIllIIIIllIIIIl, lIllIIIIllIIIlI, lIllIIIIllIIIll);
                        if (lIllIIIIlIllllI.witherBoxIntersects(lIllIIIIllIIlIl, lIllIIIIllIIlII) || !lIllIIIIlIllllI.isAreaEmpty(lIllIIIIllIIlIl, lIllIIIIllIIlII) || !WorldUtils.canPlaceBlock(lIllIIIIllIIlIl)) continue;
                        lIllIIIIlIllllI.pos = lIllIIIIllIIlIl;
                        lIllIIIIlIllllI.rotation = lIllIIIIllIIlII;
                    }
                }
            }
        }
        int lIllIIIIlIlllII = -1;
        int lIllIIIIlIllIll = -1;
        for (int lIllIIIIllIIIII = 0; lIllIIIIllIIIII < 9; ++lIllIIIIllIIIII) {
            if (AutoWither.mc.thePlayer.inventory.getStackInSlot(lIllIIIIllIIIII).getItem() == Item.getItemFromBlock((Block)Blocks.soul_sand)) {
                lIllIIIIlIlllII = lIllIIIIllIIIII;
                continue;
            }
            if (AutoWither.mc.thePlayer.inventory.getStackInSlot(lIllIIIIllIIIII).getItem() != Items.skull) continue;
            lIllIIIIlIllIll = lIllIIIIllIIIII;
        }
        if (lIllIIIIlIlllII == -1) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("No Soul Sand in hotbar")));
            lIllIIIIlIllllI.disable();
            return;
        }
        if (lIllIIIIlIllIll == -1) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("No Wither Skulls in hotbar")));
            lIllIIIIlIllllI.disable();
            return;
        }
        LinkedHashMap<BlockPos, Integer> lIllIIIIlIllIlI = new LinkedHashMap<BlockPos, Integer>();
        lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos, lIllIIIIlIlllII);
        lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(0, 1, 0), lIllIIIIlIlllII);
        lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(0, 2, 0), lIllIIIIlIllIll);
        if (lIllIIIIlIllllI.rotation == 0) {
            lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(-1, 1, 0), lIllIIIIlIlllII);
            lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(1, 1, 0), lIllIIIIlIlllII);
            lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(-1, 2, 0), lIllIIIIlIllIll);
            lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(1, 2, 0), lIllIIIIlIllIll);
        } else {
            lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(0, 1, -1), lIllIIIIlIlllII);
            lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(0, 1, 1), lIllIIIIlIlllII);
            lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(0, 2, -1), lIllIIIIlIllIll);
            lIllIIIIlIllIlI.put(lIllIIIIlIllllI.pos.add(0, 2, 1), lIllIIIIlIllIll);
        }
        for (Map.Entry lIllIIIIlIlllll : lIllIIIIlIllIlI.entrySet()) {
            if (WorldUtils.placeBlock((BlockPos)lIllIIIIlIlllll.getKey(), (Integer)lIllIIIIlIlllll.getValue(), false, false)) continue;
        }
        lIllIIIIlIllllI.disable();
    }

    @Override
    public void onUpdate() {
        AutoWither lIllIIIlIIIllIl;
        if (lIllIIIlIIIllIl.auto.getValue()) {
            lIllIIIlIIIllIl.update();
            lIllIIIlIIIllIl._Timer.cancel();
            lIllIIIlIIIllIl._Timer = new Timer();
            lIllIIIlIIIllIl._Timer.schedule(new TimerTask(){
                {
                    1 llllllllllllIll;
                }

                @Override
                public void run() {
                    1 lllllllllllIlll;
                    if (lllllllllllIlll.AutoWither.this.isEnabled()) {
                        lllllllllllIlll.AutoWither.this.disable();
                    } else {
                        lllllllllllIlll.AutoWither.this.enable();
                    }
                }
            }, (long)(lIllIIIlIIIllIl.delay.getValue() * 1000.0));
        } else {
            lIllIIIlIIIllIl.update();
        }
    }

    public boolean isAreaEmpty(BlockPos lIllIIIIlIIlIll, int lIllIIIIlIIlIII) {
        for (int lIllIIIIlIIllIl = -1; lIllIIIIlIIllIl <= 1; ++lIllIIIIlIIllIl) {
            for (int lIllIIIIlIIlllI = 0; lIllIIIIlIIlllI <= 2; ++lIllIIIIlIIlllI) {
                if (lIllIIIIlIIlIII == 0 && AutoWither.mc.theWorld.getBlockState(lIllIIIIlIIlIll.add(lIllIIIIlIIllIl, lIllIIIIlIIlllI, 0)).getBlock() != Blocks.air) {
                    return false;
                }
                if (AutoWither.mc.theWorld.getBlockState(lIllIIIIlIIlIll.add(0, lIllIIIIlIIlllI, lIllIIIIlIIllIl)).getBlock() == Blocks.air) continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public void setup() {
        AutoWither lIllIIIlIlIllII;
        lIllIIIlIlIllII.auto = lIllIIIlIlIllII.registerB("Auto", true);
        lIllIIIlIlIllII.delay = lIllIIIlIlIllII.registerD("Delay", 0.5, 0.1, 3.0);
    }
}

