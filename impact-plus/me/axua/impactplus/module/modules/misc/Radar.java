/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 */
package me.axua.impactplus.module.modules.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import me.axua.impactplus.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Radar
extends Module {
    /* synthetic */ List<Entity> players;
    /* synthetic */ List<Entity> knownPlayers;

    public Radar() {
        super("Radar", Module.Category.MISC);
        Radar llllllllllllllllIIIlIIlIlIIlIlll;
        llllllllllllllllIIIlIIlIlIIlIlll.knownPlayers = new ArrayList<Entity>();
    }

    @Override
    public void onUpdate() {
        Radar llllllllllllllllIIIlIIlIIlIlllll;
        if (Radar.mc.thePlayer == null) {
            return;
        }
        llllllllllllllllIIIlIIlIIlIlllll.players = Radar.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIIIlIIlIIIlllllI -> llllllllllllllllIIIlIIlIIIlllllI instanceof EntityPlayer).collect(Collectors.toList());
        try {
            for (Entity llllllllllllllllIIIlIIlIIllIIIIl : llllllllllllllllIIIlIIlIIlIlllll.players) {
                int llllllllllllllllIIIlIIlIIllllIIl;
                if (!(llllllllllllllllIIIlIIlIIllIIIIl instanceof EntityPlayer) || llllllllllllllllIIIlIIlIIlIlllll.knownPlayers.contains(llllllllllllllllIIIlIIlIIllIIIIl)) continue;
                if (mc.getNetHandler() == null || mc.getNetHandler().getPlayerInfo(llllllllllllllllIIIlIIlIIllIIIIl.getName()) == null) {
                    int llllllllllllllllIIIlIIlIIllllIlI = -1;
                } else {
                    llllllllllllllllIIIlIIlIIllllIIl = mc.getNetHandler().getPlayerInfo(llllllllllllllllIIIlIIlIIllIIIIl.getName()).getResponseTime();
                }
                String llllllllllllllllIIIlIIlIIllllIII = llllllllllllllllIIIlIIlIIllIIIIl.getName();
                int llllllllllllllllIIIlIIlIIlllIlll = Math.round(((EntityPlayer)llllllllllllllllIIIlIIlIIllIIIIl).getHealth() + ((EntityPlayer)llllllllllllllllIIIlIIlIIllIIIIl).getAbsorptionAmount());
                String llllllllllllllllIIIlIIlIIlllIllI = String.valueOf(new StringBuilder().append("").append(llllllllllllllllIIIlIIlIIlllIlll));
                InventoryPlayer llllllllllllllllIIIlIIlIIlllIlIl = ((EntityPlayer)llllllllllllllllIIIlIIlIIllIIIIl).inventory;
                ItemStack llllllllllllllllIIIlIIlIIlllIlII = ((EntityPlayer)llllllllllllllllIIIlIIlIIllIIIIl).func_184614_ca();
                ItemStack llllllllllllllllIIIlIIlIIlllIIll = llllllllllllllllIIIlIIlIIlllIlIl.armorItemInSlot(0);
                ItemStack llllllllllllllllIIIlIIlIIlllIIlI = llllllllllllllllIIIlIIlIIlllIlIl.armorItemInSlot(1);
                ItemStack llllllllllllllllIIIlIIlIIlllIIIl = llllllllllllllllIIIlIIlIIlllIlIl.armorItemInSlot(2);
                ItemStack llllllllllllllllIIIlIIlIIlllIIII = llllllllllllllllIIIlIIlIIlllIlIl.armorItemInSlot(3);
                ItemStack llllllllllllllllIIIlIIlIIllIllll = ((EntityPlayer)llllllllllllllllIIIlIIlIIllIIIIl).func_184592_cb();
                String llllllllllllllllIIIlIIlIIllIlllI = String.valueOf(new StringBuilder().append("").append(llllllllllllllllIIIlIIlIIllllIIl));
                String llllllllllllllllIIIlIIlIIllIllIl = llllllllllllllllIIIlIIlIIlllIlII.getItem().getItemStackDisplayName(llllllllllllllllIIIlIIlIIlllIlII);
                String llllllllllllllllIIIlIIlIIllIllII = llllllllllllllllIIIlIIlIIllIllll.getItem().getItemStackDisplayName(llllllllllllllllIIIlIIlIIllIllll);
                String llllllllllllllllIIIlIIlIIllIlIll = llllllllllllllllIIIlIIlIIlllIIII.getItem().getItemStackDisplayName(llllllllllllllllIIIlIIlIIlllIIII);
                String llllllllllllllllIIIlIIlIIllIlIlI = llllllllllllllllIIIlIIlIIlllIIIl.getItem().getItemStackDisplayName(llllllllllllllllIIIlIIlIIlllIIIl);
                String llllllllllllllllIIIlIIlIIllIlIIl = llllllllllllllllIIIlIIlIIlllIIlI.getItem().getItemStackDisplayName(llllllllllllllllIIIlIIlIIlllIIlI);
                String llllllllllllllllIIIlIIlIIllIlIII = llllllllllllllllIIIlIIlIIlllIIll.getItem().getItemStackDisplayName(llllllllllllllllIIIlIIlIIlllIIll);
                String llllllllllllllllIIIlIIlIIllIIlll = llllllllllllllllIIIlIIlIIllIllIl.replaceAll(" ", "_");
                String llllllllllllllllIIIlIIlIIllIIllI = llllllllllllllllIIIlIIlIIllIllII.replaceAll(" ", "_");
                String llllllllllllllllIIIlIIlIIllIIlIl = llllllllllllllllIIIlIIlIIllIlIll.replaceAll(" ", "_");
                String llllllllllllllllIIIlIIlIIllIIlII = llllllllllllllllIIIlIIlIIllIlIlI.replaceAll(" ", "_");
                String llllllllllllllllIIIlIIlIIllIIIll = llllllllllllllllIIIlIIlIIllIlIIl.replaceAll(" ", "_");
                String llllllllllllllllIIIlIIlIIllIIIlI = llllllllllllllllIIIlIIlIIllIlIII.replaceAll(" ", "_");
                if (llllllllllllllllIIIlIIlIIlllIIIl.getItem() == Items.field_185160_cR || ((EntityPlayer)llllllllllllllllIIIlIIlIIllIIIIl).getPosition().getY() > 10 || llllllllllllllllIIIlIIlIIlllIIII.getItem() == Items.field_190931_a && llllllllllllllllIIIlIIlIIlllIIIl.getItem() == Items.field_190931_a && llllllllllllllllIIIlIIlIIlllIIlI.getItem() == Items.field_190931_a && llllllllllllllllIIIlIIlIIlllIIll.getItem() == Items.field_190931_a) {
                    return;
                }
                llllllllllllllllIIIlIIlIIlIlllll.knownPlayers.add(llllllllllllllllIIIlIIlIIllIIIIl);
            }
        }
        catch (Exception llllllllllllllllIIIlIIlIIlIlllIl) {
            // empty catch block
        }
        try {
            for (Entity llllllllllllllllIIIlIIlIIllIIIII : llllllllllllllllIIIlIIlIIlIlllll.knownPlayers) {
                if (!(llllllllllllllllIIIlIIlIIllIIIII instanceof EntityPlayer) || llllllllllllllllIIIlIIlIIllIIIII.getName().equalsIgnoreCase(Radar.mc.thePlayer.getName()) || llllllllllllllllIIIlIIlIIlIlllll.players.contains(llllllllllllllllIIIlIIlIIllIIIII)) continue;
                llllllllllllllllIIIlIIlIIlIlllll.knownPlayers.remove(llllllllllllllllIIIlIIlIIllIIIII);
            }
        }
        catch (Exception llllllllllllllllIIIlIIlIIlIlllIl) {
            // empty catch block
        }
    }

    @Override
    public void onDisable() {
        Radar llllllllllllllllIIIlIIlIIlIIIIIl;
        llllllllllllllllIIIlIIlIIlIIIIIl.knownPlayers.clear();
    }
}

