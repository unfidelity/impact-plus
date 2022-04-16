/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayerDigging
 *  net.minecraft.network.play.client.CPacketPlayerDigging$Action
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.render.CityEsp;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.Pair;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayerDigging;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class AutoCity
extends Module {
    /* synthetic */ EntityPlayer target;
    /* synthetic */ BlockPos targetBlock;
    /* synthetic */ Setting.mode mode;
    /* synthetic */ ArrayList<Pair<EntityPlayer, ArrayList<BlockPos>>> players;
    /* synthetic */ Setting.i range;
    /* synthetic */ int hjk;
    private static final /* synthetic */ BlockPos[] surroundOffset;

    @Override
    public void onEnable() {
        AutoCity lllllllllllllllllllllIlIIllIllIl;
        if (lllllllllllllllllllllIlIIllIllIl.players == null) {
            lllllllllllllllllllllIlIIllIllIl.players = new ArrayList();
        } else {
            lllllllllllllllllllllIlIIllIllIl.players.clear();
        }
        lllllllllllllllllllllIlIIllIllIl.hjk = 0;
    }

    @Override
    public void setup() {
        AutoCity lllllllllllllllllllllIlIlllIIlIl;
        lllllllllllllllllllllIlIlllIIlIl.range = lllllllllllllllllllllIlIlllIIlIl.registerI("Range", 6, 1, 10);
    }

    @Override
    public void onUpdate() {
        boolean lllllllllllllllllllllIlIllIIIIII;
        AutoCity lllllllllllllllllllllIlIlIllllll;
        AutoCity.mc.theWorld.playerEntities.stream().filter(lllllllllllllllllllllIlIIIlIlIII -> lllllllllllllllllllllIlIIIlIlIII != AutoCity.mc.thePlayer).filter(lllllllllllllllllllllIlIIIllIlII -> !Friends.isFriend(lllllllllllllllllllllIlIIIllIlII.getName())).forEach(lllllllllllllllllllllIlIIlIIllII -> {
            AutoCity lllllllllllllllllllllIlIIlIIlIII;
            ArrayList<BlockPos> lllllllllllllllllllllIlIIlIIlIlI = new ArrayList<BlockPos>();
            for (int lllllllllllllllllllllIlIIlIlIIII = 0; lllllllllllllllllllllIlIIlIlIIII < 4; ++lllllllllllllllllllllIlIIlIlIIII) {
                BlockPos lllllllllllllllllllllIlIIlIlIlIl = AutoCity.GetPositionVectorBlockPos((Entity)lllllllllllllllllllllIlIIlIIllII, surroundOffset[lllllllllllllllllllllIlIIlIlIIII]);
                if (Minecraft.getMinecraft().theWorld.getBlockState(lllllllllllllllllllllIlIIlIlIlIl).getBlock() != Blocks.obsidian) continue;
                boolean lllllllllllllllllllllIlIIlIlIIll = false;
                CityEsp lllllllllllllllllllllIlIIlIlIIIl = (CityEsp)ModuleManager.getModuleByName("CityEsp");
                switch (lllllllllllllllllllllIlIIlIlIIII) {
                    case 0: {
                        if (lllllllllllllllllllllIlIIlIlIIIl.gnewversion.getValue()) {
                            lllllllllllllllllllllIlIIlIlIIll = lllllllllllllllllllllIlIIlIIlIII.canPlaceCrystal(lllllllllllllllllllllIlIIlIlIlIl);
                            break;
                        }
                        lllllllllllllllllllllIlIIlIlIIll = lllllllllllllllllllllIlIIlIIlIII.canPlaceCrystal(lllllllllllllllllllllIlIIlIlIlIl.north(1).down());
                        break;
                    }
                    case 1: {
                        if (lllllllllllllllllllllIlIIlIlIIIl.gnewversion.getValue()) {
                            lllllllllllllllllllllIlIIlIlIIll = lllllllllllllllllllllIlIIlIIlIII.canPlaceCrystal(lllllllllllllllllllllIlIIlIlIlIl);
                            break;
                        }
                        lllllllllllllllllllllIlIIlIlIIll = lllllllllllllllllllllIlIIlIIlIII.canPlaceCrystal(lllllllllllllllllllllIlIIlIlIlIl.east(1).down());
                        break;
                    }
                    case 2: {
                        if (lllllllllllllllllllllIlIIlIlIIIl.gnewversion.getValue()) {
                            lllllllllllllllllllllIlIIlIlIIll = lllllllllllllllllllllIlIIlIIlIII.canPlaceCrystal(lllllllllllllllllllllIlIIlIlIlIl);
                            break;
                        }
                        lllllllllllllllllllllIlIIlIlIIll = lllllllllllllllllllllIlIIlIIlIII.canPlaceCrystal(lllllllllllllllllllllIlIIlIlIlIl.south(1).down());
                        break;
                    }
                    case 3: {
                        lllllllllllllllllllllIlIIlIlIIll = lllllllllllllllllllllIlIIlIlIIIl.gnewversion.getValue() ? lllllllllllllllllllllIlIIlIIlIII.canPlaceCrystal(lllllllllllllllllllllIlIIlIlIlIl) : lllllllllllllllllllllIlIIlIIlIII.canPlaceCrystal(lllllllllllllllllllllIlIIlIlIlIl.west(1).down());
                    }
                }
                if (!lllllllllllllllllllllIlIIlIlIIll) continue;
                lllllllllllllllllllllIlIIlIIlIlI.add(lllllllllllllllllllllIlIIlIlIlIl);
            }
            if (!lllllllllllllllllllllIlIIlIIlIlI.isEmpty()) {
                lllllllllllllllllllllIlIIlIIlIII.players.add(new Pair((EntityPlayer)lllllllllllllllllllllIlIIlIIllII, lllllllllllllllllllllIlIIlIIlIlI));
            }
        });
        if (lllllllllllllllllllllIlIlIllllll.players == null) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("There is no one to city!")));
            lllllllllllllllllllllIlIlIllllll.toggle();
            return;
        }
        lllllllllllllllllllllIlIlIllllll.target = null;
        lllllllllllllllllllllIlIlIllllll.targetBlock = null;
        double lllllllllllllllllllllIlIllIIIIIl = lllllllllllllllllllllIlIlIllllll.range.getValue();
        for (Pair<EntityPlayer, ArrayList<BlockPos>> lllllllllllllllllllllIlIllIIIlIl : lllllllllllllllllllllIlIlIllllll.players) {
            for (BlockPos lllllllllllllllllllllIlIllIIIllI : lllllllllllllllllllllIlIllIIIlIl.getValue()) {
                if (lllllllllllllllllllllIlIlIllllll.targetBlock == null) {
                    lllllllllllllllllllllIlIlIllllll.target = lllllllllllllllllllllIlIllIIIlIl.getKey();
                    lllllllllllllllllllllIlIlIllllll.targetBlock = lllllllllllllllllllllIlIllIIIllI;
                    continue;
                }
                double lllllllllllllllllllllIlIllIIIlll = lllllllllllllllllllllIlIllIIIllI.func_185332_f(lllllllllllllllllllllIlIlIllllll.targetBlock.getX(), lllllllllllllllllllllIlIlIllllll.targetBlock.getY(), lllllllllllllllllllllIlIlIllllll.targetBlock.getZ());
                if (!(lllllllllllllllllllllIlIllIIIlll < lllllllllllllllllllllIlIllIIIIIl)) continue;
                lllllllllllllllllllllIlIllIIIIIl = lllllllllllllllllllllIlIllIIIlll;
                lllllllllllllllllllllIlIlIllllll.targetBlock = lllllllllllllllllllllIlIllIIIllI;
                lllllllllllllllllllllIlIlIllllll.target = lllllllllllllllllllllIlIllIIIlIl.getKey();
            }
        }
        if (lllllllllllllllllllllIlIlIllllll.targetBlock == null) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("Couldn't find any blocks to mine!")));
            lllllllllllllllllllllIlIlIllllll.toggle();
            return;
        }
        if (lllllllllllllllllllllIlIlIllllll.hjk == 0) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.LIGHT_PURPLE).append("Attempting to mine a block by your target: ").append(ChatFormatting.RED).append(lllllllllllllllllllllIlIlIllllll.target.getName())));
            lllllllllllllllllllllIlIlIllllll.hjk = 1;
        }
        boolean bl = lllllllllllllllllllllIlIllIIIIII = AutoCity.mc.thePlayer.func_184614_ca().getItem() == Items.diamond_pickaxe;
        if (!lllllllllllllllllllllIlIllIIIIII) {
            for (int lllllllllllllllllllllIlIllIIIIll = 0; lllllllllllllllllllllIlIllIIIIll < 9; ++lllllllllllllllllllllIlIllIIIIll) {
                ItemStack lllllllllllllllllllllIlIllIIIlII = AutoCity.mc.thePlayer.inventory.getStackInSlot(lllllllllllllllllllllIlIllIIIIll);
                if (lllllllllllllllllllllIlIllIIIlII.func_190926_b() || lllllllllllllllllllllIlIllIIIlII.getItem() != Items.diamond_pickaxe) continue;
                lllllllllllllllllllllIlIllIIIIII = true;
                AutoCity.mc.thePlayer.inventory.currentItem = lllllllllllllllllllllIlIllIIIIll;
                AutoCity.mc.playerController.updateController();
                break;
            }
        }
        if (!lllllllllllllllllllllIlIllIIIIII) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("No pickaxe!")));
            lllllllllllllllllllllIlIlIllllll.toggle();
            return;
        }
        AutoCity.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
        AutoCity.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.START_DESTROY_BLOCK, lllllllllllllllllllllIlIlIllllll.targetBlock, EnumFacing.UP));
        AutoCity.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerDigging(CPacketPlayerDigging.Action.STOP_DESTROY_BLOCK, lllllllllllllllllllllIlIlIllllll.targetBlock, EnumFacing.UP));
        if (AutoCity.mc.theWorld.getBlockState(lllllllllllllllllllllIlIlIllllll.targetBlock).getBlock() == Blocks.air) {
            lllllllllllllllllllllIlIlIllllll.players.clear();
            lllllllllllllllllllllIlIlIllllll.toggle();
        }
    }

    static {
        surroundOffset = new BlockPos[]{new BlockPos(0, 0, -1), new BlockPos(1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(-1, 0, 0)};
    }

    @Override
    public void onDisable() {
        AutoCity lllllllllllllllllllllIlIIllllIll;
        if (lllllllllllllllllllllIlIIllllIll.players == null) {
            lllllllllllllllllllllIlIIllllIll.players = new ArrayList();
        } else {
            lllllllllllllllllllllIlIIllllIll.players.clear();
        }
        lllllllllllllllllllllIlIIllllIll.hjk = 0;
    }

    public static BlockPos GetPositionVectorBlockPos(Entity lllllllllllllllllllllIlIlIlIllII, BlockPos lllllllllllllllllllllIlIlIlIlllI) {
        if (lllllllllllllllllllllIlIlIlIlllI == null) {
            return null;
        }
        Vec3d lllllllllllllllllllllIlIlIlIllIl = lllllllllllllllllllllIlIlIlIllII.getPositionVector();
        if (lllllllllllllllllllllIlIlIlIlllI == null) {
            return new BlockPos(lllllllllllllllllllllIlIlIlIllIl.xCoord, lllllllllllllllllllllIlIlIlIllIl.yCoord, lllllllllllllllllllllIlIlIlIllIl.zCoord);
        }
        return new BlockPos(lllllllllllllllllllllIlIlIlIllIl.xCoord, lllllllllllllllllllllIlIlIlIllIl.yCoord, lllllllllllllllllllllIlIlIlIllIl.zCoord).add((Vec3i)lllllllllllllllllllllIlIlIlIlllI);
    }

    private boolean canPlaceCrystal(BlockPos lllllllllllllllllllllIlIlIIIlIll) {
        BlockPos lllllllllllllllllllllIlIlIIIlIlI = lllllllllllllllllllllIlIlIIIlIll.add(0, 1, 0);
        BlockPos lllllllllllllllllllllIlIlIIIlIII = lllllllllllllllllllllIlIlIIIlIll.add(0, 2, 0);
        BlockPos lllllllllllllllllllllIlIlIIIIlll = lllllllllllllllllllllIlIlIIIlIll.add(0, -1, 0);
        CityEsp lllllllllllllllllllllIlIlIIIIlIl = (CityEsp)ModuleManager.getModuleByName("CityEsp");
        if (lllllllllllllllllllllIlIlIIIIlIl.gnewversion.getValue()) {
            return AutoCity.mc.theWorld.getBlockState(lllllllllllllllllllllIlIlIIIlIll).getBlock() == Blocks.obsidian && (AutoCity.mc.theWorld.getBlockState(lllllllllllllllllllllIlIlIIIIlll).getBlock() == Blocks.obsidian || AutoCity.mc.theWorld.getBlockState(lllllllllllllllllllllIlIlIIIIlll).getBlock() == Blocks.bedrock);
        }
        return (AutoCity.mc.theWorld.getBlockState(lllllllllllllllllllllIlIlIIIlIll).getBlock() == Blocks.bedrock || AutoCity.mc.theWorld.getBlockState(lllllllllllllllllllllIlIlIIIlIll).getBlock() == Blocks.obsidian) && AutoCity.mc.theWorld.getBlockState(lllllllllllllllllllllIlIlIIIlIlI).getBlock() == Blocks.air && AutoCity.mc.theWorld.getBlockState(lllllllllllllllllllllIlIlIIIlIII).getBlock() == Blocks.air && AutoCity.mc.theWorld.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(lllllllllllllllllllllIlIlIIIlIlI)).isEmpty() && AutoCity.mc.theWorld.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(lllllllllllllllllllllIlIlIIIlIII)).isEmpty();
    }

    public AutoCity() {
        super("AutoCity", Module.Category.COMBAT);
        AutoCity lllllllllllllllllllllIlIlllIllIl;
        lllllllllllllllllllllIlIlllIllIl.players = new ArrayList();
        lllllllllllllllllllllIlIlllIllIl.hjk = 0;
        lllllllllllllllllllllIlIlllIllIl.target = null;
        lllllllllllllllllllllIlIlllIllIl.targetBlock = null;
    }
}

