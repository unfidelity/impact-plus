/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 */
package me.axua.impactplus.module.modules.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class SmartOffhand
extends Module {
    /* synthetic */ int crystals;
    /* synthetic */ Setting.mode itemSetting;
    /* synthetic */ Item item;
    /* synthetic */ Setting.i health;
    /* synthetic */ boolean returnI;
    /* synthetic */ boolean moving;
    /* synthetic */ Setting.b crystalCheck;
    public /* synthetic */ int totems;

    @Override
    public void onUpdate() {
        SmartOffhand lIlllllllIlIlll;
        lIlllllllIlIlll.item = lIlllllllIlIlll.itemSetting.getValue().equalsIgnoreCase("Gapple") ? Items.golden_apple : Items.field_185158_cP;
        if (SmartOffhand.mc.currentScreen instanceof GuiContainer) {
            return;
        }
        if (lIlllllllIlIlll.returnI) {
            int lIlllllllIlllll = -1;
            for (int lIllllllllIIIII = 0; lIllllllllIIIII < 45; ++lIllllllllIIIII) {
                if (!SmartOffhand.mc.thePlayer.inventory.getStackInSlot(lIllllllllIIIII).func_190926_b()) continue;
                lIlllllllIlllll = lIllllllllIIIII;
                break;
            }
            if (lIlllllllIlllll == -1) {
                return;
            }
            SmartOffhand.mc.playerController.func_187098_a(0, lIlllllllIlllll < 9 ? lIlllllllIlllll + 36 : lIlllllllIlllll, 0, ClickType.PICKUP, (EntityPlayer)SmartOffhand.mc.thePlayer);
            lIlllllllIlIlll.returnI = false;
        }
        lIlllllllIlIlll.totems = SmartOffhand.mc.thePlayer.inventory.mainInventory.stream().filter(lIllllllIlllIIl -> lIllllllIlllIIl.getItem() == Items.field_190929_cY).mapToInt(ItemStack::func_190916_E).sum();
        lIlllllllIlIlll.crystals = SmartOffhand.mc.thePlayer.inventory.mainInventory.stream().filter(lIllllllIllllII -> lIllllllIllllII.getItem() == Items.field_185158_cP).mapToInt(ItemStack::func_190916_E).sum();
        if (lIlllllllIlIlll.shouldTotem() && SmartOffhand.mc.thePlayer.func_184592_cb().getItem() == Items.field_190929_cY) {
            ++lIlllllllIlIlll.totems;
        } else if (!lIlllllllIlIlll.shouldTotem() && SmartOffhand.mc.thePlayer.func_184592_cb().getItem() == lIlllllllIlIlll.item) {
            lIlllllllIlIlll.crystals += SmartOffhand.mc.thePlayer.func_184592_cb().func_190916_E();
        } else {
            if (lIlllllllIlIlll.moving) {
                SmartOffhand.mc.playerController.func_187098_a(0, 45, 0, ClickType.PICKUP, (EntityPlayer)SmartOffhand.mc.thePlayer);
                lIlllllllIlIlll.moving = false;
                lIlllllllIlIlll.returnI = true;
                return;
            }
            if (SmartOffhand.mc.thePlayer.inventory.getItemStack().func_190926_b()) {
                if (!lIlllllllIlIlll.shouldTotem() && SmartOffhand.mc.thePlayer.func_184592_cb().getItem() == lIlllllllIlIlll.item) {
                    return;
                }
                if (lIlllllllIlIlll.shouldTotem() && SmartOffhand.mc.thePlayer.func_184592_cb().getItem() == Items.field_190929_cY) {
                    return;
                }
                if (!lIlllllllIlIlll.shouldTotem()) {
                    if (lIlllllllIlIlll.crystals == 0) {
                        return;
                    }
                    int lIlllllllIlllIl = -1;
                    for (int lIlllllllIllllI = 0; lIlllllllIllllI < 45; ++lIlllllllIllllI) {
                        if (SmartOffhand.mc.thePlayer.inventory.getStackInSlot(lIlllllllIllllI).getItem() != lIlllllllIlIlll.item) continue;
                        lIlllllllIlllIl = lIlllllllIllllI;
                        break;
                    }
                    if (lIlllllllIlllIl == -1) {
                        return;
                    }
                    SmartOffhand.mc.playerController.func_187098_a(0, lIlllllllIlllIl < 9 ? lIlllllllIlllIl + 36 : lIlllllllIlllIl, 0, ClickType.PICKUP, (EntityPlayer)SmartOffhand.mc.thePlayer);
                    lIlllllllIlIlll.moving = true;
                } else {
                    if (lIlllllllIlIlll.totems == 0) {
                        return;
                    }
                    int lIlllllllIllIll = -1;
                    for (int lIlllllllIlllII = 0; lIlllllllIlllII < 45; ++lIlllllllIlllII) {
                        if (SmartOffhand.mc.thePlayer.inventory.getStackInSlot(lIlllllllIlllII).getItem() != Items.field_190929_cY) continue;
                        lIlllllllIllIll = lIlllllllIlllII;
                        break;
                    }
                    if (lIlllllllIllIll == -1) {
                        return;
                    }
                    SmartOffhand.mc.playerController.func_187098_a(0, lIlllllllIllIll < 9 ? lIlllllllIllIll + 36 : lIlllllllIllIll, 0, ClickType.PICKUP, (EntityPlayer)SmartOffhand.mc.thePlayer);
                    lIlllllllIlIlll.moving = true;
                }
            } else {
                int lIlllllllIllIIl = -1;
                for (int lIlllllllIllIlI = 0; lIlllllllIllIlI < 45; ++lIlllllllIllIlI) {
                    if (!SmartOffhand.mc.thePlayer.inventory.getStackInSlot(lIlllllllIllIlI).func_190926_b()) continue;
                    lIlllllllIllIIl = lIlllllllIllIlI;
                    break;
                }
                if (lIlllllllIllIIl == -1) {
                    return;
                }
                SmartOffhand.mc.playerController.func_187098_a(0, lIlllllllIllIIl < 9 ? lIlllllllIllIIl + 36 : lIlllllllIllIIl, 0, ClickType.PICKUP, (EntityPlayer)SmartOffhand.mc.thePlayer);
            }
        }
    }

    public SmartOffhand() {
        super("SmartOffhand", Module.Category.COMBAT);
        SmartOffhand lIllllllllIlIll;
        lIllllllllIlIll.moving = false;
        lIllllllllIlIll.returnI = false;
    }

    private boolean shouldTotem() {
        boolean lIlllllllIIllll;
        SmartOffhand lIlllllllIlIIIl;
        boolean lIlllllllIlIIII = SmartOffhand.mc.thePlayer.getHealth() + SmartOffhand.mc.thePlayer.getAbsorptionAmount() <= (float)lIlllllllIlIIIl.health.getValue();
        boolean bl = lIlllllllIIllll = !lIlllllllIlIIIl.isCrystalsAABBEmpty();
        if (lIlllllllIlIIIl.crystalCheck.getValue()) {
            return lIlllllllIlIIII || lIlllllllIIllll;
        }
        return lIlllllllIlIIII;
    }

    @Override
    public void setup() {
        SmartOffhand lIllllllllIIlll;
        ArrayList<String> lIllllllllIIllI = new ArrayList<String>();
        lIllllllllIIllI.add("Crystal");
        lIllllllllIIllI.add("Gapple");
        lIllllllllIIlll.health = lIllllllllIIlll.registerI("Health", 15, 1, 36);
        lIllllllllIIlll.crystalCheck = lIllllllllIIlll.registerB("CrystalCheck", false);
        lIllllllllIIlll.itemSetting = lIllllllllIIlll.registerMode("Item", lIllllllllIIllI, "Crystal");
    }

    private boolean isEmpty(BlockPos lIlllllllIIlIII) {
        List lIlllllllIIIlll = SmartOffhand.mc.theWorld.getEntitiesWithinAABBExcludingEntity(null, new AxisAlignedBB(lIlllllllIIlIII)).stream().filter(lIlllllllIIIIII -> lIlllllllIIIIII instanceof EntityEnderCrystal).collect(Collectors.toList());
        return lIlllllllIIIlll.isEmpty();
    }

    private boolean isCrystalsAABBEmpty() {
        SmartOffhand lIlllllllIIIIll;
        return lIlllllllIIIIll.isEmpty(SmartOffhand.mc.thePlayer.getPosition().add(1, 0, 0)) && lIlllllllIIIIll.isEmpty(SmartOffhand.mc.thePlayer.getPosition().add(-1, 0, 0)) && lIlllllllIIIIll.isEmpty(SmartOffhand.mc.thePlayer.getPosition().add(0, 0, 1)) && lIlllllllIIIIll.isEmpty(SmartOffhand.mc.thePlayer.getPosition().add(0, 0, -1)) && lIlllllllIIIIll.isEmpty(SmartOffhand.mc.thePlayer.getPosition());
    }
}

