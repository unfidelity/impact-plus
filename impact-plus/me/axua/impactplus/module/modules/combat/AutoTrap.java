/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockEnderChest
 *  net.minecraft.block.BlockObsidian
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 */
package me.axua.impactplus.module.modules.combat;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.combat.Surround;
import me.axua.impactplus.setting.Setting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEnderChest;
import net.minecraft.block.BlockObsidian;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class AutoTrap
extends Module {
    /* synthetic */ Setting.i bpt;
    /* synthetic */ Setting.b rotate;
    /* synthetic */ Setting.d range;
    /* synthetic */ int blocksPlaced;
    /* synthetic */ Setting.b ec;

    @Override
    public void onEnable() {
        if (AutoTrap.mc.thePlayer == null) {
            AutoTrap llllllllllllllllllIlIIIlllIIlIll;
            llllllllllllllllllIlIIIlllIIlIll.disable();
        }
    }

    private boolean shouldPlace(BlockPos llllllllllllllllllIlIIIlllIIIIll) {
        AutoTrap llllllllllllllllllIlIIIllIlllllI;
        List llllllllllllllllllIlIIIlllIIIIlI = AutoTrap.mc.theWorld.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(llllllllllllllllllIlIIIlllIIIIll)).stream().filter(llllllllllllllllllIlIIIllIllIIII -> !(llllllllllllllllllIlIIIllIllIIII instanceof EntityItem)).filter(llllllllllllllllllIlIIIllIllIllI -> !(llllllllllllllllllIlIIIllIllIllI instanceof EntityXPOrb)).collect(Collectors.toList());
        boolean llllllllllllllllllIlIIIlllIIIIIl = llllllllllllllllllIlIIIlllIIIIlI.isEmpty();
        boolean llllllllllllllllllIlIIIlllIIIIII = AutoTrap.mc.theWorld.getBlockState(llllllllllllllllllIlIIIlllIIIIll).func_185904_a().isReplaceable();
        boolean llllllllllllllllllIlIIIllIllllll = llllllllllllllllllIlIIIllIlllllI.blocksPlaced < llllllllllllllllllIlIIIllIlllllI.bpt.getValue();
        return llllllllllllllllllIlIIIlllIIIIIl && llllllllllllllllllIlIIIlllIIIIII && llllllllllllllllllIlIIIllIllllll;
    }

    @Override
    public void setup() {
        AutoTrap llllllllllllllllllIlIIIlllIlIIlI;
        llllllllllllllllllIlIIIlllIlIIlI.rotate = llllllllllllllllllIlIIIlllIlIIlI.registerB("Rotate", true);
        llllllllllllllllllIlIIIlllIlIIlI.ec = llllllllllllllllllIlIIIlllIlIIlI.registerB("UseEchests", false);
        llllllllllllllllllIlIIIlllIlIIlI.range = llllllllllllllllllIlIIIlllIlIIlI.registerD("Range", 5.0, 0.0, 10.0);
        llllllllllllllllllIlIIIlllIlIIlI.bpt = llllllllllllllllllIlIIIlllIlIIlI.registerI("BlocksPerTick", 8, 1, 15);
    }

    @Override
    public void onUpdate() {
        AutoTrap llllllllllllllllllIlIIIlllIIllll;
        AutoTrap.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllllIlIIIlIIIlllII -> llllllllllllllllllIlIIIlIIIlllII instanceof EntityPlayer).filter(llllllllllllllllllIlIIIlIIIlllll -> {
            AutoTrap llllllllllllllllllIlIIIlIIlIIIlI;
            return (double)AutoTrap.mc.thePlayer.getDistanceToEntity(llllllllllllllllllIlIIIlIIIlllll) <= llllllllllllllllllIlIIIlIIlIIIlI.range.getValue();
        }).filter(llllllllllllllllllIlIIIlIIlIIlIl -> llllllllllllllllllIlIIIlIIlIIlIl != AutoTrap.mc.thePlayer).filter(llllllllllllllllllIlIIIlIIlIllIl -> !Friends.isFriend(llllllllllllllllllIlIIIlIIlIllIl.getName())).sorted(Comparator.comparing(llllllllllllllllllIlIIIlIIllIIIl -> Float.valueOf(AutoTrap.mc.thePlayer.getDistanceToEntity(llllllllllllllllllIlIIIlIIllIIIl)))).forEach(llllllllllllllllllIlIIIlIllIIIII -> {
            AutoTrap llllllllllllllllllIlIIIlIlIIlIll;
            Vec3d llllllllllllllllllIlIIIlIlIlllll = Surround.getInterpolatedPos(llllllllllllllllllIlIIIlIllIIIII, mc.func_184121_ak());
            BlockPos llllllllllllllllllIlIIIlIlIllllI = new BlockPos(llllllllllllllllllIlIIIlIlIlllll);
            BlockPos llllllllllllllllllIlIIIlIlIlllII = llllllllllllllllllIlIIIlIlIllllI.add(1, 0, 0);
            BlockPos llllllllllllllllllIlIIIlIlIllIll = llllllllllllllllllIlIIIlIlIllllI.add(-1, 0, 0);
            BlockPos llllllllllllllllllIlIIIlIlIllIlI = llllllllllllllllllIlIIIlIlIllllI.add(0, 0, 1);
            BlockPos llllllllllllllllllIlIIIlIlIllIII = llllllllllllllllllIlIIIlIlIllllI.add(0, 0, -1);
            BlockPos llllllllllllllllllIlIIIlIlIlIllI = llllllllllllllllllIlIIIlIlIllllI.add(0, 2, 0);
            BlockPos llllllllllllllllllIlIIIlIlIlIlIl = llllllllllllllllllIlIIIlIlIlllII.up();
            BlockPos llllllllllllllllllIlIIIlIlIlIlII = llllllllllllllllllIlIIIlIlIllIll.up();
            BlockPos llllllllllllllllllIlIIIlIlIlIIll = llllllllllllllllllIlIIIlIlIllIlI.up();
            BlockPos llllllllllllllllllIlIIIlIlIlIIlI = llllllllllllllllllIlIIIlIlIllIII.up();
            BlockPos llllllllllllllllllIlIIIlIlIlIIIl = llllllllllllllllllIlIIIlIlIlIlIl.up();
            BlockPos llllllllllllllllllIlIIIlIlIlIIII = llllllllllllllllllIlIIIlIlIlIlII.up();
            BlockPos llllllllllllllllllIlIIIlIlIIllll = llllllllllllllllllIlIIIlIlIlIIll.up();
            BlockPos llllllllllllllllllIlIIIlIlIIlllI = llllllllllllllllllIlIIIlIlIlIIlI.up();
            int llllllllllllllllllIlIIIlIlIIllIl = -1;
            for (int llllllllllllllllllIlIIIlIllIIIlI = 0; llllllllllllllllllIlIIIlIllIIIlI < 9; ++llllllllllllllllllIlIIIlIllIIIlI) {
                ItemStack llllllllllllllllllIlIIIlIllIIlII = AutoTrap.mc.thePlayer.inventory.getStackInSlot(llllllllllllllllllIlIIIlIllIIIlI);
                if (llllllllllllllllllIlIIIlIllIIlII == ItemStack.field_190927_a || !(llllllllllllllllllIlIIIlIllIIlII.getItem() instanceof ItemBlock)) continue;
                Block llllllllllllllllllIlIIIlIllIIIll = ((ItemBlock)llllllllllllllllllIlIIIlIllIIlII.getItem()).getBlock();
                if (!llllllllllllllllllIlIIIlIlIIlIll.ec.getValue() ? !(llllllllllllllllllIlIIIlIllIIIll instanceof BlockObsidian) : !(llllllllllllllllllIlIIIlIllIIIll instanceof BlockObsidian) && !(llllllllllllllllllIlIIIlIllIIIll instanceof BlockEnderChest)) continue;
                llllllllllllllllllIlIIIlIlIIllIl = llllllllllllllllllIlIIIlIllIIIlI;
                break;
            }
            if (llllllllllllllllllIlIIIlIlIIllIl == -1) {
                return;
            }
            int llllllllllllllllllIlIIIlIlIIllII = AutoTrap.mc.thePlayer.inventory.currentItem;
            AutoTrap.mc.thePlayer.inventory.currentItem = llllllllllllllllllIlIIIlIlIIllIl;
            llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced = 0;
            if (llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced > llllllllllllllllllIlIIIlIlIIlIll.bpt.getValue()) {
                llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced = 0;
                return;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIlllII)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIlllII, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIllIll)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIllIll, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIllIlI)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIllIlI, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIllIII)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIllIII, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIlIlIl)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIlIlIl, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIlIlII)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIlIlII, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIlIIll)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIlIIll, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIlIIlI)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIlIIlI, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIlIIIl)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIlIIIl, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIlIIII)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIlIIII, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIIllll)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIIllll, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIIlllI)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIIlllI, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            if (llllllllllllllllllIlIIIlIlIIlIll.shouldPlace(llllllllllllllllllIlIIIlIlIlIllI)) {
                Surround.placeBlockScaffold(llllllllllllllllllIlIIIlIlIlIllI, llllllllllllllllllIlIIIlIlIIlIll.rotate.getValue());
                ++llllllllllllllllllIlIIIlIlIIlIll.blocksPlaced;
            }
            AutoTrap.mc.thePlayer.inventory.currentItem = llllllllllllllllllIlIIIlIlIIllII;
        });
    }

    public AutoTrap() {
        super("AutoTrap", Module.Category.COMBAT, "Traps nearby players");
        AutoTrap llllllllllllllllllIlIIIlllIlIlIl;
    }
}

