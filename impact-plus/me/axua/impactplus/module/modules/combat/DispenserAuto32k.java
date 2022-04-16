/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.block.BlockAir
 *  net.minecraft.block.BlockLiquid
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.combat;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.blocks.BlockInteractionHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraft.network.play.client.CPacketPlayerTryUseItemOnBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class DispenserAuto32k
extends Module {
    private /* synthetic */ int swordSlot;
    private /* synthetic */ BlockPos placeTarget;
    private /* synthetic */ int redstoneSlot;
    private /* synthetic */ int hopperSlot;
    private /* synthetic */ boolean isSneaking;
    private /* synthetic */ int stage;
    public /* synthetic */ Setting.b oneatatime;
    private /* synthetic */ int obiSlot2;
    private /* synthetic */ int dispenserSlot;
    private /* synthetic */ int obiSlot;
    private static final /* synthetic */ DecimalFormat df;
    private /* synthetic */ int shulkerSlot;

    private boolean isSuperWeapon(ItemStack llIlIIlllIIllI) {
        if (llIlIIlllIIllI == null) {
            return false;
        }
        if (llIlIIlllIIllI.getTagCompound() == null) {
            return false;
        }
        if (llIlIIlllIIllI.getEnchantmentTagList().getTagType() == 0) {
            return false;
        }
        NBTTagList llIlIIlllIlIII = (NBTTagList)llIlIIlllIIllI.getTagCompound().getTag("ench");
        for (int llIlIIlllIIlll = 0; llIlIIlllIIlll < llIlIIlllIlIII.tagCount(); ++llIlIIlllIIlll) {
            NBTTagCompound llIlIIlllIlIll = llIlIIlllIlIII.getCompoundTagAt(llIlIIlllIIlll);
            if (llIlIIlllIlIll.getInteger("id") != 16) continue;
            int llIlIIlllIllII = llIlIIlllIlIll.getInteger("lvl");
            if (llIlIIlllIllII < 16) break;
            return true;
        }
        return false;
    }

    @Override
    public void onUpdate() {
        DispenserAuto32k llIlIIlllllIll;
        if (llIlIIlllllIll.stage == 0) {
            DispenserAuto32k.mc.thePlayer.inventory.currentItem = llIlIIlllllIll.obiSlot;
            llIlIIlllllIll.placeBlock(new BlockPos((Vec3i)llIlIIlllllIll.placeTarget), EnumFacing.DOWN);
            DispenserAuto32k.mc.thePlayer.inventory.currentItem = llIlIIlllllIll.dispenserSlot;
            llIlIIlllllIll.placeBlock(new BlockPos((Vec3i)llIlIIlllllIll.placeTarget.add(0, 1, 0)), EnumFacing.DOWN);
            DispenserAuto32k.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)DispenserAuto32k.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
            llIlIIlllllIll.isSneaking = false;
            DispenserAuto32k.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerTryUseItemOnBlock(llIlIIlllllIll.placeTarget.add(0, 1, 0), EnumFacing.DOWN, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
            llIlIIlllllIll.stage = 1;
            return;
        }
        if (llIlIIlllllIll.stage == 1) {
            if (!(DispenserAuto32k.mc.currentScreen instanceof GuiContainer)) {
                return;
            }
            DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, 1, llIlIIlllllIll.shulkerSlot, ClickType.SWAP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
            DispenserAuto32k.mc.thePlayer.closeScreen();
            DispenserAuto32k.mc.thePlayer.inventory.currentItem = llIlIIlllllIll.redstoneSlot;
            llIlIIlllllIll.placeBlock(new BlockPos((Vec3i)llIlIIlllllIll.placeTarget.add(0, 2, 0)), EnumFacing.DOWN);
            llIlIIlllllIll.stage = 2;
            return;
        }
        if (llIlIIlllllIll.stage == 2) {
            Block llIlIIlllllllI = DispenserAuto32k.mc.theWorld.getBlockState(llIlIIlllllIll.placeTarget.offset(DispenserAuto32k.mc.thePlayer.getHorizontalFacing().getOpposite()).up()).getBlock();
            if (llIlIIlllllllI instanceof BlockAir || llIlIIlllllllI instanceof BlockLiquid) {
                return;
            }
            DispenserAuto32k.mc.thePlayer.inventory.currentItem = llIlIIlllllIll.hopperSlot;
            llIlIIlllllIll.placeBlock(new BlockPos((Vec3i)llIlIIlllllIll.placeTarget.offset(DispenserAuto32k.mc.thePlayer.getHorizontalFacing().getOpposite())), DispenserAuto32k.mc.thePlayer.getHorizontalFacing());
            DispenserAuto32k.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)DispenserAuto32k.mc.thePlayer, CPacketEntityAction.Action.STOP_SNEAKING));
            llIlIIlllllIll.isSneaking = false;
            DispenserAuto32k.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketPlayerTryUseItemOnBlock(llIlIIlllllIll.placeTarget.offset(DispenserAuto32k.mc.thePlayer.getHorizontalFacing().getOpposite()), EnumFacing.DOWN, EnumHand.MAIN_HAND, 0.0f, 0.0f, 0.0f));
            DispenserAuto32k.mc.thePlayer.inventory.currentItem = llIlIIlllllIll.shulkerSlot;
            llIlIIlllllIll.stage = 3;
            return;
        }
        if (llIlIIlllllIll.stage == 3) {
            if (!(DispenserAuto32k.mc.currentScreen instanceof GuiContainer)) {
                return;
            }
            if (((GuiContainer)DispenserAuto32k.mc.currentScreen).inventorySlots.getSlot(0).getStack().func_190926_b()) {
                return;
            }
            DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, 0, DispenserAuto32k.mc.thePlayer.inventory.currentItem, ClickType.SWAP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
            llIlIIlllllIll.stage = llIlIIlllllIll.oneatatime.getValue() ? 4 : 5;
            return;
        }
        if (llIlIIlllllIll.stage == 4) {
            if (!(DispenserAuto32k.mc.currentScreen instanceof GuiContainer)) {
                return;
            }
            if (llIlIIlllllIll.obiSlot == 0) {
                llIlIIlllllIll.obiSlot2 = 32;
            } else if (llIlIIlllllIll.obiSlot == 1) {
                llIlIIlllllIll.obiSlot2 = 33;
            } else if (llIlIIlllllIll.obiSlot == 2) {
                llIlIIlllllIll.obiSlot2 = 34;
            } else if (llIlIIlllllIll.obiSlot == 3) {
                llIlIIlllllIll.obiSlot2 = 35;
            } else if (llIlIIlllllIll.obiSlot == 4) {
                llIlIIlllllIll.obiSlot2 = 36;
            } else if (llIlIIlllllIll.obiSlot == 5) {
                llIlIIlllllIll.obiSlot2 = 37;
            } else if (llIlIIlllllIll.obiSlot == 6) {
                llIlIIlllllIll.obiSlot2 = 38;
            } else if (llIlIIlllllIll.obiSlot == 7) {
                llIlIIlllllIll.obiSlot2 = 39;
            } else if (llIlIIlllllIll.obiSlot == 8) {
                llIlIIlllllIll.obiSlot2 = 40;
            }
            DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, llIlIIlllllIll.obiSlot2, 0, ClickType.PICKUP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
            DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, 1, 1, ClickType.PICKUP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
            DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, 2, 1, ClickType.PICKUP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
            DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, 3, 1, ClickType.PICKUP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
            DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, 4, 1, ClickType.PICKUP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
            DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, llIlIIlllllIll.obiSlot2, 0, ClickType.PICKUP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
            llIlIIlllllIll.stage = 5;
            return;
        }
        if (llIlIIlllllIll.stage == 5) {
            llIlIIlllllIll.disable();
        }
        if (llIlIIlllllIll.stage == 6) {
            ItemStack llIlIIllllllIl = DispenserAuto32k.mc.thePlayer.inventory.getStackInSlot(llIlIIlllllIll.swordSlot);
            if (llIlIIllllllIl.getItem() != Items.diamond_sword || llIlIIllllllIl.getItem() != Items.stone_sword || llIlIIllllllIl.getItem() != Items.golden_sword || llIlIIllllllIl.getItem() != Items.iron_sword || llIlIIllllllIl.getItem() != Items.wooden_sword) {
                Command.sendClientMessage("EMPTY");
                return;
            }
            if (!llIlIIlllllIll.isSuperWeapon(llIlIIllllllIl)) {
                Command.sendClientMessage("isSuperWeapon");
                DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, llIlIIlllllIll.swordSlot, 0, ClickType.THROW, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
                DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, 0, 0, ClickType.PICKUP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
                DispenserAuto32k.mc.playerController.func_187098_a(DispenserAuto32k.mc.thePlayer.openContainer.windowId, llIlIIlllllIll.swordSlot, 0, ClickType.PICKUP, (EntityPlayer)DispenserAuto32k.mc.thePlayer);
                llIlIIlllllIll.swordSlot = -1;
            }
            llIlIIlllllIll.stage = 5;
        }
    }

    @Override
    public void setup() {
        DispenserAuto32k llIlIlIIIlIlIl;
        llIlIlIIIlIlIl.oneatatime = llIlIlIIIlIlIl.registerB("OneAtATime", true);
    }

    static {
        df = new DecimalFormat("#.#");
    }

    public DispenserAuto32k() {
        super("DispenserAuto32k", Module.Category.COMBAT, "DispenserAuto32k");
        DispenserAuto32k llIlIlIIIllIII;
    }

    private void placeBlock(BlockPos llIlIIllIIllIl, EnumFacing llIlIIllIIIllI) {
        DispenserAuto32k llIlIIllIIlIII;
        BlockPos llIlIIllIIlIll = llIlIIllIIllIl.offset(llIlIIllIIIllI);
        EnumFacing llIlIIllIIlIlI = llIlIIllIIIllI.getOpposite();
        if (!llIlIIllIIlIII.isSneaking) {
            DispenserAuto32k.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketEntityAction((Entity)DispenserAuto32k.mc.thePlayer, CPacketEntityAction.Action.START_SNEAKING));
            llIlIIllIIlIII.isSneaking = true;
        }
        Vec3d llIlIIllIIlIIl = new Vec3d((Vec3i)llIlIIllIIlIll).addVector(0.5, 0.5, 0.5).add(new Vec3d(llIlIIllIIlIlI.getDirectionVec()).func_186678_a(0.5));
        BlockInteractionHelper.faceVectorPacketInstant(llIlIIllIIlIIl);
        DispenserAuto32k.mc.playerController.func_187099_a(DispenserAuto32k.mc.thePlayer, DispenserAuto32k.mc.theWorld, llIlIIllIIlIll, llIlIIllIIlIlI, llIlIIllIIlIIl, EnumHand.MAIN_HAND);
        DispenserAuto32k.mc.thePlayer.func_184609_a(EnumHand.MAIN_HAND);
    }

    @Override
    public void onEnable() {
        DispenserAuto32k llIlIlIIIIIlIl;
        if (DispenserAuto32k.mc.thePlayer == null) {
            llIlIlIIIIIlIl.disable();
        }
        df.setRoundingMode(RoundingMode.CEILING);
        llIlIlIIIIIlIl.placeTarget = null;
        llIlIlIIIIIlIl.obiSlot = -1;
        llIlIlIIIIIlIl.dispenserSlot = -1;
        llIlIlIIIIIlIl.shulkerSlot = -1;
        llIlIlIIIIIlIl.redstoneSlot = -1;
        llIlIlIIIIIlIl.hopperSlot = -1;
        llIlIlIIIIIlIl.swordSlot = -1;
        llIlIlIIIIIlIl.isSneaking = false;
        for (int llIlIlIIIIIllI = 0; llIlIlIIIIIllI < 9 && (llIlIlIIIIIlIl.obiSlot == -1 || llIlIlIIIIIlIl.dispenserSlot == -1 || llIlIlIIIIIlIl.shulkerSlot == -1 || llIlIlIIIIIlIl.redstoneSlot == -1 || llIlIlIIIIIlIl.hopperSlot == -1); ++llIlIlIIIIIllI) {
            ItemStack llIlIlIIIIlIII = DispenserAuto32k.mc.thePlayer.inventory.getStackInSlot(llIlIlIIIIIllI);
            if (llIlIlIIIIlIII == ItemStack.field_190927_a || !(llIlIlIIIIlIII.getItem() instanceof ItemBlock)) continue;
            Block llIlIlIIIIIlll = ((ItemBlock)llIlIlIIIIlIII.getItem()).getBlock();
            if (llIlIlIIIIIlll == Blocks.hopper) {
                llIlIlIIIIIlIl.hopperSlot = llIlIlIIIIIllI;
                continue;
            }
            if (BlockInteractionHelper.shulkerList.contains(llIlIlIIIIIlll)) {
                llIlIlIIIIIlIl.shulkerSlot = llIlIlIIIIIllI;
                continue;
            }
            if (llIlIlIIIIIlll == Blocks.obsidian) {
                llIlIlIIIIIlIl.obiSlot = llIlIlIIIIIllI;
                continue;
            }
            if (llIlIlIIIIIlll == Blocks.dispenser) {
                llIlIlIIIIIlIl.dispenserSlot = llIlIlIIIIIllI;
                continue;
            }
            if (llIlIlIIIIIlll != Blocks.redstone_block) continue;
            llIlIlIIIIIlIl.redstoneSlot = llIlIlIIIIIllI;
        }
        if (llIlIlIIIIIlIl.obiSlot == -1) {
            Command.sendClientMessage("[Auto32k] Obsisian missing, disabling.");
            llIlIlIIIIIlIl.disable();
            return;
        }
        if (llIlIlIIIIIlIl.dispenserSlot == -1) {
            Command.sendClientMessage("[Auto32k] Dispenser missing, disabling.");
            llIlIlIIIIIlIl.disable();
            return;
        }
        if (llIlIlIIIIIlIl.shulkerSlot == -1) {
            Command.sendClientMessage("[Auto32k] Shulker missing, disabling.");
            llIlIlIIIIIlIl.disable();
            return;
        }
        if (llIlIlIIIIIlIl.redstoneSlot == -1) {
            Command.sendClientMessage("[Auto32k] Redstone Block missing, disabling.");
            llIlIlIIIIIlIl.disable();
            return;
        }
        if (llIlIlIIIIIlIl.hopperSlot == -1) {
            Command.sendClientMessage("[Auto32k] Hopper missing, disabling.");
            llIlIlIIIIIlIl.disable();
            return;
        }
        if (DispenserAuto32k.mc.objectMouseOver == null || DispenserAuto32k.mc.objectMouseOver.getBlockPos() == null || DispenserAuto32k.mc.objectMouseOver.getBlockPos().up() == null) {
            Command.sendClientMessage("[Auto32k] Not a valid place target, disabling.");
            llIlIlIIIIIlIl.disable();
            return;
        }
        llIlIlIIIIIlIl.placeTarget = DispenserAuto32k.mc.objectMouseOver.getBlockPos().up();
        Command.sendClientMessage(String.valueOf(new StringBuilder().append("[Auto32k] Place Target: ").append(llIlIlIIIIIlIl.placeTarget.getX()).append(" ").append(llIlIlIIIIIlIl.placeTarget.getY()).append(" ").append(llIlIlIIIIIlIl.placeTarget.getZ()).append(" Distance: ").append(df.format(DispenserAuto32k.mc.thePlayer.getPositionVector().distanceTo(new Vec3d((Vec3i)llIlIlIIIIIlIl.placeTarget))))));
        llIlIlIIIIIlIl.stage = 0;
    }
}

