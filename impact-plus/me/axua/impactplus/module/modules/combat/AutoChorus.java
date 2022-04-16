/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.EnumHand
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.world.World
 */
package me.axua.impactplus.module.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class AutoChorus
extends Module {
    private /* synthetic */ int chorusSlot;
    /* synthetic */ int once1;
    private /* synthetic */ boolean eating;

    public static Vec3d getInterpolatedAmount(Entity lIIIlIllIIllII, double lIIIlIllIIllIl) {
        return AutoChorus.getInterpolatedAmount(lIIIlIllIIllII, lIIIlIllIIllIl, lIIIlIllIIllIl, lIIIlIllIIllIl);
    }

    @Override
    public void onEnable() {
        lIIIllIlIIIllI.chorusSlot = -1;
        lIIIllIlIIIllI.eating = false;
        lIIIllIlIIIllI.once1 = 0;
    }

    public AutoChorus() {
        super("AutoChorus", Module.Category.COMBAT, "AutoChorus");
        AutoChorus lIIIllIlIIllIl;
    }

    private Block getBlock(int lIIIlIllIlllII, int lIIIlIlllIIIIl, int lIIIlIlllIIIII) {
        BlockPos lIIIlIllIlllll = new BlockPos(lIIIlIllIlllII, lIIIlIlllIIIIl, lIIIlIlllIIIII);
        IBlockState lIIIlIllIllllI = AutoChorus.mc.theWorld.getBlockState(lIIIlIllIlllll);
        Block lIIIlIllIlllIl = lIIIlIllIllllI.getBlock();
        return lIIIlIllIlllIl;
    }

    @Override
    public void onUpdate() {
        AutoChorus lIIIllIIIllIll;
        if (AutoChorus.mc.thePlayer.func_184613_cA()) {
            return;
        }
        for (int lIIIllIIlIIllI = 0; lIIIllIIlIIllI < 9; ++lIIIllIIlIIllI) {
            ItemStack lIIIllIIlIIlll = AutoChorus.mc.thePlayer.inventory.getStackInSlot(lIIIllIIlIIllI);
            if (lIIIllIIlIIlll.getItem() != Items.field_185161_cS) continue;
            lIIIllIIIllIll.chorusSlot = lIIIllIIlIIllI;
        }
        if (lIIIllIIIllIll.eating && !AutoChorus.mc.thePlayer.func_184587_cr()) {
            lIIIllIIIllIll.eating = false;
            lIIIllIIIllIll.once1 = 0;
            KeyBinding.setKeyBindState((int)AutoChorus.mc.gameSettings.keyBindUseItem.getKeyCode(), (boolean)false);
            return;
        }
        if (lIIIllIIIllIll.eating && lIIIllIIIllIll.chorusSlot == -1) {
            lIIIllIIIllIll.eating = false;
            lIIIllIIIllIll.once1 = 0;
            return;
        }
        Vec3d lIIIllIIIllIlI = AutoChorus.getInterpolatedPos((Entity)AutoChorus.mc.thePlayer, 0.0f);
        BlockPos lIIIllIIIllIIl = new BlockPos(lIIIllIIIllIlI).north();
        BlockPos lIIIllIIIllIII = new BlockPos(lIIIllIIIllIlI).south();
        BlockPos lIIIllIIIlIlll = new BlockPos(lIIIllIIIllIlI).east();
        BlockPos lIIIllIIIlIllI = new BlockPos(lIIIllIIIllIlI).west();
        BlockPos lIIIllIIIlIlIl = new BlockPos(lIIIllIIIllIlI).north().up();
        BlockPos lIIIllIIIlIlII = new BlockPos(lIIIllIIIllIlI).south().up();
        BlockPos lIIIllIIIlIIll = new BlockPos(lIIIllIIIllIlI).east().up();
        BlockPos lIIIllIIIlIIlI = new BlockPos(lIIIllIIIllIlI).west().up();
        BlockPos lIIIllIIIlIIIl = new BlockPos(lIIIllIIIllIlI).north().up().up().south();
        int lIIIllIIIlIIII = Block.getIdFromBlock((Block)lIIIllIIIllIll.getBlock(lIIIllIIIllIIl.getX(), lIIIllIIIllIIl.getY(), lIIIllIIIllIIl.getZ()));
        int lIIIllIIIIllll = Block.getIdFromBlock((Block)lIIIllIIIllIll.getBlock(lIIIllIIIllIII.getX(), lIIIllIIIllIII.getY(), lIIIllIIIllIII.getZ()));
        int lIIIllIIIIlllI = Block.getIdFromBlock((Block)lIIIllIIIllIll.getBlock(lIIIllIIIlIlll.getX(), lIIIllIIIlIlll.getY(), lIIIllIIIlIlll.getZ()));
        int lIIIllIIIIllIl = Block.getIdFromBlock((Block)lIIIllIIIllIll.getBlock(lIIIllIIIlIllI.getX(), lIIIllIIIlIllI.getY(), lIIIllIIIlIllI.getZ()));
        int lIIIllIIIIllII = Block.getIdFromBlock((Block)lIIIllIIIllIll.getBlock(lIIIllIIIlIlIl.getX(), lIIIllIIIlIlIl.getY(), lIIIllIIIlIlIl.getZ()));
        int lIIIllIIIIlIll = Block.getIdFromBlock((Block)lIIIllIIIllIll.getBlock(lIIIllIIIlIlII.getX(), lIIIllIIIlIlII.getY(), lIIIllIIIlIlII.getZ()));
        int lIIIllIIIIlIlI = Block.getIdFromBlock((Block)lIIIllIIIllIll.getBlock(lIIIllIIIlIIll.getX(), lIIIllIIIlIIll.getY(), lIIIllIIIlIIll.getZ()));
        int lIIIllIIIIlIIl = Block.getIdFromBlock((Block)lIIIllIIIllIll.getBlock(lIIIllIIIlIIlI.getX(), lIIIllIIIlIIlI.getY(), lIIIllIIIlIIlI.getZ()));
        int lIIIllIIIIlIII = Block.getIdFromBlock((Block)lIIIllIIIllIll.getBlock(lIIIllIIIlIIIl.getX(), lIIIllIIIlIIIl.getY(), lIIIllIIIlIIIl.getZ()));
        if ((lIIIllIIIIllII != 0 && lIIIllIIIIlIll != 0 && lIIIllIIIIlIlI != 0 && lIIIllIIIIlIIl != 0 && lIIIllIIIIlIII != 0 || lIIIllIIIlIIII != 0 && lIIIllIIIIllll != 0 && lIIIllIIIIlllI != 0 && lIIIllIIIIllIl != 0 && lIIIllIIIIlIII != 0 || lIIIllIIIlIIII != 0 && lIIIllIIIIllll != 0 && lIIIllIIIIlIlI != 0 && lIIIllIIIIlIIl != 0 && lIIIllIIIIlIII != 0 || lIIIllIIIIlllI != 0 && lIIIllIIIIllIl != 0 && lIIIllIIIIllII != 0 && lIIIllIIIIlIll != 0 && lIIIllIIIIlIII != 0) && (lIIIllIIIIllII != 10 && lIIIllIIIIlIll != 10 && lIIIllIIIIlIlI != 10 && lIIIllIIIIlIIl != 10 && lIIIllIIIIlIII != 10 || lIIIllIIIlIIII != 10 && lIIIllIIIIllll != 10 && lIIIllIIIIlllI != 10 && lIIIllIIIIllIl != 10 && lIIIllIIIIlIII != 10 || lIIIllIIIlIIII != 10 && lIIIllIIIIllll != 10 && lIIIllIIIIlIlI != 10 && lIIIllIIIIlIIl != 10 && lIIIllIIIIlIII != 10 || lIIIllIIIIlllI != 10 && lIIIllIIIIllIl != 10 && lIIIllIIIIllII != 10 && lIIIllIIIIlIll != 10 && lIIIllIIIIlIII != 10) && (lIIIllIIIIllII != 11 && lIIIllIIIIlIll != 11 && lIIIllIIIIlIlI != 11 && lIIIllIIIIlIIl != 11 && lIIIllIIIIlIII != 11 || lIIIllIIIlIIII != 11 && lIIIllIIIIllll != 11 && lIIIllIIIIlllI != 11 && lIIIllIIIIllIl != 11 && lIIIllIIIIlIII != 11 || lIIIllIIIlIIII != 11 && lIIIllIIIIllll != 11 && lIIIllIIIIlIlI != 11 && lIIIllIIIIlIIl != 11 && lIIIllIIIIlIII != 11 || lIIIllIIIIlllI != 11 && lIIIllIIIIllIl != 11 && lIIIllIIIIllII != 11 && lIIIllIIIIlIll != 11 && lIIIllIIIIlIII != 11) && (lIIIllIIIIllII != 8 && lIIIllIIIIlIll != 8 && lIIIllIIIIlIlI != 8 && lIIIllIIIIlIIl != 8 && lIIIllIIIIlIII != 8 || lIIIllIIIlIIII != 8 && lIIIllIIIIllll != 8 && lIIIllIIIIlllI != 8 && lIIIllIIIIllIl != 8 && lIIIllIIIIlIII != 8 || lIIIllIIIlIIII != 8 && lIIIllIIIIllll != 8 && lIIIllIIIIlIlI != 8 && lIIIllIIIIlIIl != 8 && lIIIllIIIIlIII != 8 || lIIIllIIIIlllI != 8 && lIIIllIIIIllIl != 8 && lIIIllIIIIllII != 8 && lIIIllIIIIlIll != 8 && lIIIllIIIIlIII != 8) && (lIIIllIIIIllII != 9 && lIIIllIIIIlIll != 9 && lIIIllIIIIlIlI != 9 && lIIIllIIIIlIIl != 9 && lIIIllIIIIlIII != 9 || lIIIllIIIlIIII != 9 && lIIIllIIIIllll != 9 && lIIIllIIIIlllI != 9 && lIIIllIIIIllIl != 9 && lIIIllIIIIlIII != 9 || lIIIllIIIlIIII != 9 && lIIIllIIIIllll != 9 && lIIIllIIIIlIlI != 9 && lIIIllIIIIlIIl != 9 && lIIIllIIIIlIII != 9 || lIIIllIIIIlllI != 9 && lIIIllIIIIllIl != 9 && lIIIllIIIIllII != 9 && lIIIllIIIIlIll != 9 && lIIIllIIIIlIII != 9)) {
            if (lIIIllIIIllIll.chorusSlot != -1) {
                AutoChorus.mc.thePlayer.inventory.currentItem = lIIIllIIIllIll.chorusSlot;
                lIIIllIIIllIll.eating = true;
                KeyBinding.setKeyBindState((int)AutoChorus.mc.gameSettings.keyBindUseItem.getKeyCode(), (boolean)true);
                AutoChorus.mc.playerController.func_187101_a((EntityPlayer)AutoChorus.mc.thePlayer, (World)AutoChorus.mc.theWorld, EnumHand.MAIN_HAND);
                for (int lIIIllIIIlllII = 0; lIIIllIIIlllII < 9; ++lIIIllIIIlllII) {
                    ItemStack lIIIllIIlIIlIl = AutoChorus.mc.thePlayer.inventory.getStackInSlot(0);
                    ItemStack lIIIllIIlIIlII = AutoChorus.mc.thePlayer.inventory.getStackInSlot(1);
                    ItemStack lIIIllIIlIIIll = AutoChorus.mc.thePlayer.inventory.getStackInSlot(2);
                    ItemStack lIIIllIIlIIIlI = AutoChorus.mc.thePlayer.inventory.getStackInSlot(3);
                    ItemStack lIIIllIIlIIIIl = AutoChorus.mc.thePlayer.inventory.getStackInSlot(4);
                    ItemStack lIIIllIIlIIIII = AutoChorus.mc.thePlayer.inventory.getStackInSlot(5);
                    ItemStack lIIIllIIIlllll = AutoChorus.mc.thePlayer.inventory.getStackInSlot(6);
                    ItemStack lIIIllIIIllllI = AutoChorus.mc.thePlayer.inventory.getStackInSlot(7);
                    ItemStack lIIIllIIIlllIl = AutoChorus.mc.thePlayer.inventory.getStackInSlot(8);
                    if (lIIIllIIlIIlIl.getItem() == Items.field_185161_cS || lIIIllIIlIIlII.getItem() == Items.field_185161_cS || lIIIllIIlIIIll.getItem() == Items.field_185161_cS || lIIIllIIlIIIlI.getItem() == Items.field_185161_cS || lIIIllIIlIIIIl.getItem() == Items.field_185161_cS || lIIIllIIlIIIII.getItem() == Items.field_185161_cS || lIIIllIIIlllll.getItem() == Items.field_185161_cS || lIIIllIIIllllI.getItem() == Items.field_185161_cS || lIIIllIIIlllIl.getItem() == Items.field_185161_cS) continue;
                    lIIIllIIIllIll.chorusSlot = -1;
                }
            } else {
                if (lIIIllIIIllIll.once1 > 0) {
                    return;
                }
                ++lIIIllIIIllIll.once1;
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("Error! No chorus in hotbar")));
            }
        } else {
            lIIIllIIIllIll.once1 = 0;
        }
    }

    public static Vec3d getInterpolatedPos(Entity lIIIlIllIlIIlI, float lIIIlIllIlIIIl) {
        return new Vec3d(lIIIlIllIlIIlI.lastTickPosX, lIIIlIllIlIIlI.lastTickPosY, lIIIlIllIlIIlI.lastTickPosZ).add(AutoChorus.getInterpolatedAmount(lIIIlIllIlIIlI, lIIIlIllIlIIIl));
    }

    public static Vec3d getInterpolatedAmount(Entity lIIIlIllIIIllI, double lIIIlIllIIIlIl, double lIIIlIllIIIlII, double lIIIlIllIIIIll) {
        return new Vec3d((lIIIlIllIIIllI.posX - lIIIlIllIIIllI.lastTickPosX) * lIIIlIllIIIlIl, (lIIIlIllIIIllI.posY - lIIIlIllIIIllI.lastTickPosY) * lIIIlIllIIIlII, (lIIIlIllIIIllI.posZ - lIIIlIllIIIllI.lastTickPosZ) * lIIIlIllIIIIll);
    }

    @Override
    public void onDisable() {
        lIIIllIlIIlIIl.chorusSlot = -1;
        lIIIllIlIIlIIl.eating = false;
        lIIIllIlIIlIIl.once1 = 0;
    }
}

