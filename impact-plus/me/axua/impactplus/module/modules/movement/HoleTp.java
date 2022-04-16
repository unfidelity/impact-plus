/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.movement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.combat.Surround;
import me.axua.impactplus.setting.Setting;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class HoleTp
extends Module {
    public /* synthetic */ Setting.mode Mode;
    private /* synthetic */ List<BlockPos> safeHoles;
    public /* synthetic */ Setting.b tpup;
    private final /* synthetic */ BlockPos[] surroundOffset;

    @Override
    public void setup() {
        HoleTp lllllllllllllllIllIlllllllIIIllI;
        ArrayList<String> lllllllllllllllIllIlllllllIIIlll = new ArrayList<String>();
        lllllllllllllllIllIlllllllIIIlll.add("TP");
        lllllllllllllllIllIlllllllIIIlll.add("Baritone");
        lllllllllllllllIllIlllllllIIIllI.tpup = lllllllllllllllIllIlllllllIIIllI.registerB("TpUp", false);
        lllllllllllllllIllIlllllllIIIllI.Mode = lllllllllllllllIllIlllllllIIIllI.registerMode("Mode", lllllllllllllllIllIlllllllIIIlll, "TP");
    }

    public void setPositionPacket(double lllllllllllllllIllIlllllIllIlIII, double lllllllllllllllIllIlllllIllIIIlI, double lllllllllllllllIllIlllllIllIIIIl, boolean lllllllllllllllIllIlllllIllIIIII, boolean lllllllllllllllIllIlllllIllIIlII) {
        HoleTp.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayer.Position(lllllllllllllllIllIlllllIllIlIII, lllllllllllllllIllIlllllIllIIIlI, lllllllllllllllIllIlllllIllIIIIl, lllllllllllllllIllIlllllIllIIIII));
        if (lllllllllllllllIllIlllllIllIIlII) {
            HoleTp.mc.thePlayer.setPosition(lllllllllllllllIllIlllllIllIlIII, lllllllllllllllIllIlllllIllIIIlI, lllllllllllllllIllIlllllIllIIIIl);
        }
    }

    public HoleTp() {
        super("HoleTp", Module.Category.MOVEMENT, "HoleTp");
        HoleTp lllllllllllllllIllIlllllllIIlIll;
        lllllllllllllllIllIlllllllIIlIll.surroundOffset = new BlockPos[]{new BlockPos(0, -1, 0), new BlockPos(0, 0, -1), new BlockPos(1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(-1, 0, 0)};
    }

    public List<BlockPos> getSphere(BlockPos lllllllllllllllIllIllllllIIIlIlI, float lllllllllllllllIllIlllllIlllllll, int lllllllllllllllIllIllllllIIIlIII, boolean lllllllllllllllIllIlllllIlllllIl, boolean lllllllllllllllIllIllllllIIIIllI, int lllllllllllllllIllIllllllIIIIlIl) {
        ArrayList<BlockPos> lllllllllllllllIllIllllllIIIIlII = new ArrayList<BlockPos>();
        int lllllllllllllllIllIllllllIIIIIll = lllllllllllllllIllIllllllIIIlIlI.getX();
        int lllllllllllllllIllIllllllIIIIIlI = lllllllllllllllIllIllllllIIIlIlI.getY();
        int lllllllllllllllIllIllllllIIIIIIl = lllllllllllllllIllIllllllIIIlIlI.getZ();
        int lllllllllllllllIllIllllllIIIllII = lllllllllllllllIllIllllllIIIIIll - (int)lllllllllllllllIllIlllllIlllllll;
        while ((float)lllllllllllllllIllIllllllIIIllII <= (float)lllllllllllllllIllIllllllIIIIIll + lllllllllllllllIllIlllllIlllllll) {
            int lllllllllllllllIllIllllllIIIllIl = lllllllllllllllIllIllllllIIIIIIl - (int)lllllllllllllllIllIlllllIlllllll;
            while ((float)lllllllllllllllIllIllllllIIIllIl <= (float)lllllllllllllllIllIllllllIIIIIIl + lllllllllllllllIllIlllllIlllllll) {
                int lllllllllllllllIllIllllllIIIlllI = lllllllllllllllIllIllllllIIIIllI ? lllllllllllllllIllIllllllIIIIIlI - (int)lllllllllllllllIllIlllllIlllllll : lllllllllllllllIllIllllllIIIIIlI;
                while (true) {
                    float f = lllllllllllllllIllIllllllIIIlllI;
                    float f2 = lllllllllllllllIllIllllllIIIIllI ? (float)lllllllllllllllIllIllllllIIIIIlI + lllllllllllllllIllIlllllIlllllll : (float)(lllllllllllllllIllIllllllIIIIIlI + lllllllllllllllIllIllllllIIIlIII);
                    if (!(f < f2)) break;
                    double lllllllllllllllIllIllllllIIIllll = (lllllllllllllllIllIllllllIIIIIll - lllllllllllllllIllIllllllIIIllII) * (lllllllllllllllIllIllllllIIIIIll - lllllllllllllllIllIllllllIIIllII) + (lllllllllllllllIllIllllllIIIIIIl - lllllllllllllllIllIllllllIIIllIl) * (lllllllllllllllIllIllllllIIIIIIl - lllllllllllllllIllIllllllIIIllIl) + (lllllllllllllllIllIllllllIIIIllI ? (lllllllllllllllIllIllllllIIIIIlI - lllllllllllllllIllIllllllIIIlllI) * (lllllllllllllllIllIllllllIIIIIlI - lllllllllllllllIllIllllllIIIlllI) : 0);
                    if (!(!(lllllllllllllllIllIllllllIIIllll < (double)(lllllllllllllllIllIlllllIlllllll * lllllllllllllllIllIlllllIlllllll)) || lllllllllllllllIllIlllllIlllllIl && lllllllllllllllIllIllllllIIIllll < (double)((lllllllllllllllIllIlllllIlllllll - 1.0f) * (lllllllllllllllIllIlllllIlllllll - 1.0f)))) {
                        BlockPos lllllllllllllllIllIllllllIIlIIII = new BlockPos(lllllllllllllllIllIllllllIIIllII, lllllllllllllllIllIllllllIIIlllI + lllllllllllllllIllIllllllIIIIlIl, lllllllllllllllIllIllllllIIIllIl);
                        lllllllllllllllIllIllllllIIIIlII.add(lllllllllllllllIllIllllllIIlIIII);
                    }
                    ++lllllllllllllllIllIllllllIIIlllI;
                }
                ++lllllllllllllllIllIllllllIIIllIl;
            }
            ++lllllllllllllllIllIllllllIIIllII;
        }
        return lllllllllllllllIllIllllllIIIIlII;
    }

    public List<BlockPos> getSortedHoles() {
        HoleTp lllllllllllllllIllIlllllIllIllll;
        lllllllllllllllIllIlllllIllIllll.safeHoles.sort(Comparator.comparingDouble(lllllllllllllllIllIlllllIlIlllIl -> HoleTp.mc.thePlayer.getDistanceSq(lllllllllllllllIllIlllllIlIlllIl)));
        return lllllllllllllllIllIlllllIllIllll.safeHoles;
    }

    @Override
    public void onEnable() {
        HoleTp lllllllllllllllIllIllllllIllIIIl;
        Vec3d lllllllllllllllIllIllllllIllIIII = Surround.getInterpolatedPos((Entity)HoleTp.mc.thePlayer, 0.0f);
        BlockPos lllllllllllllllIllIllllllIlIllll = new BlockPos(lllllllllllllllIllIllllllIllIIII);
        if (lllllllllllllllIllIllllllIllIIIl.safeHoles == null) {
            lllllllllllllllIllIllllllIllIIIl.safeHoles = new ArrayList<BlockPos>();
        } else {
            lllllllllllllllIllIllllllIllIIIl.safeHoles.clear();
        }
        int lllllllllllllllIllIllllllIlIlllI = (int)Math.ceil(15.0);
        List<BlockPos> lllllllllllllllIllIllllllIlIllIl = lllllllllllllllIllIllllllIllIIIl.getSphere(HoleTp.getPlayerPos(), lllllllllllllllIllIllllllIlIlllI, lllllllllllllllIllIllllllIlIlllI, false, true, 0);
        for (BlockPos lllllllllllllllIllIllllllIllIlII : lllllllllllllllIllIllllllIlIllIl) {
            if (lllllllllllllllIllIllllllIlIllll.toString().equals(lllllllllllllllIllIllllllIllIlII.toString()) || !HoleTp.mc.theWorld.getBlockState(lllllllllllllllIllIllllllIllIlII).getBlock().equals(Blocks.air) || !lllllllllllllllIllIllllllIllIIIl.tpup.getValue() && lllllllllllllllIllIllllllIllIIIl.Mode.getValue().equalsIgnoreCase("TP") && lllllllllllllllIllIllllllIllIlII.getY() > lllllllllllllllIllIllllllIlIllll.getY() || !HoleTp.mc.theWorld.getBlockState(lllllllllllllllIllIllllllIllIlII.add(0, 1, 0)).getBlock().equals(Blocks.air) || !HoleTp.mc.theWorld.getBlockState(lllllllllllllllIllIllllllIllIlII.add(0, 2, 0)).getBlock().equals(Blocks.air)) continue;
            boolean lllllllllllllllIllIllllllIllIlIl = true;
            for (BlockPos lllllllllllllllIllIllllllIllIllI : lllllllllllllllIllIllllllIllIIIl.surroundOffset) {
                Block lllllllllllllllIllIllllllIllIlll = HoleTp.mc.theWorld.getBlockState(lllllllllllllllIllIllllllIllIlII.add((Vec3i)lllllllllllllllIllIllllllIllIllI)).getBlock();
                if (lllllllllllllllIllIllllllIllIlll == Blocks.bedrock || lllllllllllllllIllIllllllIllIlll == Blocks.obsidian || lllllllllllllllIllIllllllIllIlll == Blocks.ender_chest || lllllllllllllllIllIllllllIllIlll == Blocks.anvil) continue;
                lllllllllllllllIllIllllllIllIlIl = false;
                break;
            }
            if (!lllllllllllllllIllIllllllIllIlIl) continue;
            lllllllllllllllIllIllllllIllIIIl.safeHoles.add(lllllllllllllllIllIllllllIllIlII);
        }
        if (lllllllllllllllIllIllllllIllIIIl.Mode.getValue().equalsIgnoreCase("TP")) {
            BlockPos lllllllllllllllIllIllllllIllIIll;
            if (!lllllllllllllllIllIllllllIllIIIl.getSortedHoles().isEmpty() && HoleTp.mc.thePlayer.getDistanceSq(lllllllllllllllIllIllllllIllIIll = lllllllllllllllIllIllllllIllIIIl.getSortedHoles().get(0)) <= 15.0) {
                lllllllllllllllIllIllllllIllIIIl.setPositionPacket((double)lllllllllllllllIllIllllllIllIIll.getX() + 0.5, HoleTp.mc.thePlayer.posY, (double)lllllllllllllllIllIllllllIllIIll.getZ() + 0.5, false, true);
            }
        } else if (!lllllllllllllllIllIllllllIllIIIl.getSortedHoles().isEmpty()) {
            BlockPos lllllllllllllllIllIllllllIllIIlI = lllllllllllllllIllIllllllIllIIIl.getSortedHoles().get(0);
            HoleTp.mc.thePlayer.sendChatMessage(String.valueOf(new StringBuilder().append("#goto ").append((float)lllllllllllllllIllIllllllIllIIlI.getX()).append(" ").append((float)lllllllllllllllIllIllllllIllIIlI.getY()).append(" ").append((float)lllllllllllllllIllIllllllIllIIlI.getZ())));
        }
        lllllllllllllllIllIllllllIllIIIl.disable();
    }

    public static BlockPos getPlayerPos() {
        return new BlockPos(Math.floor(HoleTp.mc.thePlayer.posX), Math.floor(HoleTp.mc.thePlayer.posY), Math.floor(HoleTp.mc.thePlayer.posZ));
    }
}

