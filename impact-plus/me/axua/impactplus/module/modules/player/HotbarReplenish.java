/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.ItemBlock
 *  net.minecraft.item.ItemStack
 */
package me.axua.impactplus.module.modules.player;

import java.util.HashMap;
import java.util.Map;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class HotbarReplenish
extends Module {
    public /* synthetic */ Setting.i tickDelay;
    private /* synthetic */ int delayStep;
    public /* synthetic */ Setting.i threshold;

    private static Map<Integer, ItemStack> getInventorySlots(int llIIllllllIllll, int llIIllllllIlllI) {
        HashMap<Integer, ItemStack> llIIllllllIllIl = new HashMap<Integer, ItemStack>();
        while (llIIllllllIllll <= llIIllllllIlllI) {
            llIIllllllIllIl.put(llIIllllllIllll, (ItemStack)HotbarReplenish.mc.thePlayer.inventoryContainer.getInventory().get(llIIllllllIllll));
            ++llIIllllllIllll;
        }
        return llIIllllllIllIl;
    }

    @Override
    public void onUpdate() {
        HotbarReplenish llIIllllllIIIIl;
        if (HotbarReplenish.mc.thePlayer == null) {
            return;
        }
        if (HotbarReplenish.mc.currentScreen instanceof GuiContainer) {
            return;
        }
        if (llIIllllllIIIIl.delayStep < llIIllllllIIIIl.tickDelay.getValue()) {
            ++llIIllllllIIIIl.delayStep;
            return;
        }
        llIIllllllIIIIl.delayStep = 0;
        Pair<Integer, Integer> llIIllllllIIlII = llIIllllllIIIIl.findReplenishableHotbarSlot();
        if (llIIllllllIIlII == null) {
            return;
        }
        int llIIllllllIIIll = llIIllllllIIlII.getKey();
        int llIIllllllIIIlI = llIIllllllIIlII.getValue();
        HotbarReplenish.mc.playerController.func_187098_a(0, llIIllllllIIIll, 0, ClickType.PICKUP, (EntityPlayer)HotbarReplenish.mc.thePlayer);
        HotbarReplenish.mc.playerController.func_187098_a(0, llIIllllllIIIlI, 0, ClickType.PICKUP, (EntityPlayer)HotbarReplenish.mc.thePlayer);
        HotbarReplenish.mc.playerController.func_187098_a(0, llIIllllllIIIll, 0, ClickType.PICKUP, (EntityPlayer)HotbarReplenish.mc.thePlayer);
    }

    private static Map<Integer, ItemStack> getHotbar() {
        return HotbarReplenish.getInventorySlots(36, 44);
    }

    private Pair<Integer, Integer> findReplenishableHotbarSlot() {
        Pair<Integer, Integer> llIIlllllIlIIll = null;
        for (Map.Entry<Integer, ItemStack> llIIlllllIlIlIl : HotbarReplenish.getHotbar().entrySet()) {
            int llIIlllllIlIllI;
            HotbarReplenish llIIlllllIlIIlI;
            ItemStack llIIlllllIlIlll = llIIlllllIlIlIl.getValue();
            if (llIIlllllIlIlll.func_190926_b() || llIIlllllIlIlll.getItem() == Items.field_190931_a || !llIIlllllIlIlll.isStackable() || llIIlllllIlIlll.stackSize >= llIIlllllIlIlll.getMaxStackSize() || llIIlllllIlIlll.stackSize > llIIlllllIlIIlI.threshold.getValue() || (llIIlllllIlIllI = llIIlllllIlIIlI.findCompatibleInventorySlot(llIIlllllIlIlll)) == -1) continue;
            llIIlllllIlIIll = new Pair<Integer, Integer>(llIIlllllIlIllI, llIIlllllIlIlIl.getKey());
        }
        return llIIlllllIlIIll;
    }

    private int findCompatibleInventorySlot(ItemStack llIIllllIllllII) {
        int llIIllllIllllll = -1;
        int llIIllllIlllllI = 999;
        for (Map.Entry<Integer, ItemStack> llIIlllllIIIIlI : HotbarReplenish.getInventory().entrySet()) {
            int llIIlllllIIIIll;
            HotbarReplenish llIIllllIllllIl;
            ItemStack llIIlllllIIIlII = llIIlllllIIIIlI.getValue();
            if (llIIlllllIIIlII.field_190928_g || llIIlllllIIIlII.getItem() == Items.field_190931_a || !llIIllllIllllIl.isCompatibleStacks(llIIllllIllllII, llIIlllllIIIlII) || llIIllllIlllllI <= (llIIlllllIIIIll = ((ItemStack)HotbarReplenish.mc.thePlayer.inventoryContainer.getInventory().get((int)llIIlllllIIIIlI.getKey().intValue())).stackSize)) continue;
            llIIllllIlllllI = llIIlllllIIIIll;
            llIIllllIllllll = llIIlllllIIIIlI.getKey();
        }
        return llIIllllIllllll;
    }

    @Override
    public void setup() {
        HotbarReplenish llIIlllllllIlII;
        llIIlllllllIlII.threshold = llIIlllllllIlII.registerI("Threshold", 10, 1, 63);
        llIIlllllllIlII.tickDelay = llIIlllllllIlII.registerI("TickDelay", 10, 1, 10);
    }

    public HotbarReplenish() {
        super("HotbarReplenish", Module.Category.PLAYER, "AutoLog when someone is holding a 32k near you");
        HotbarReplenish llIIlllllllIllI;
        llIIlllllllIllI.delayStep = 0;
    }

    private static Map<Integer, ItemStack> getInventory() {
        return HotbarReplenish.getInventorySlots(9, 35);
    }

    private boolean isCompatibleStacks(ItemStack llIIllllIlIllII, ItemStack llIIllllIlIllIl) {
        if (!llIIllllIlIllII.getItem().equals(llIIllllIlIllIl.getItem())) {
            return false;
        }
        if (llIIllllIlIllII.getItem() instanceof ItemBlock && llIIllllIlIllIl.getItem() instanceof ItemBlock) {
            Block llIIllllIllIIIl = ((ItemBlock)llIIllllIlIllII.getItem()).getBlock();
            Block llIIllllIllIIII = ((ItemBlock)llIIllllIlIllIl.getItem()).getBlock();
            if (!llIIllllIllIIIl.blockMaterial.equals(llIIllllIllIIII.blockMaterial)) {
                return false;
            }
        }
        if (!llIIllllIlIllII.getDisplayName().equals(llIIllllIlIllIl.getDisplayName())) {
            return false;
        }
        return llIIllllIlIllII.getItemDamage() == llIIllllIlIllIl.getItemDamage();
    }
}

