/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.inventory.GuiInventory
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.enchantment.EnchantmentHelper
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Enchantments
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemStack
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.hud.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.hudgui.HudGui;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.chat.TotemPopCounter;
import me.axua.impactplus.module.modules.client.HudColours;
import me.axua.impactplus.module.modules.hud.Closest;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.SalRainbowUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ClosestComponent
extends HudComponent<Closest> {
    /* synthetic */ Closest mod2;
    /* synthetic */ Minecraft mc;
    /* synthetic */ HudColours mod;
    /* synthetic */ int secoffset;
    /* synthetic */ int popoffset;
    private /* synthetic */ SalRainbowUtil Rainbow1;
    /* synthetic */ TotemPopCounter mod3;
    /* synthetic */ int nameoffset;
    /* synthetic */ EntityPlayer l_Player;
    /* synthetic */ int popoffsetfinal;
    /* synthetic */ int secoffsetfinal;
    /* synthetic */ int nameoffsetfinal;

    public ClosestComponent() {
        super("Closest", 675, 290, Closest.INSTANCE);
        ClosestComponent llllllllllllllllIllIIIIlIllIIIlI;
        llllllllllllllllIllIIIIlIllIIIlI.mc = Minecraft.getMinecraft();
        llllllllllllllllIllIIIIlIllIIIlI.mod = (HudColours)ModuleManager.getModuleByName("HudColours");
        llllllllllllllllIllIIIIlIllIIIlI.mod2 = (Closest)ModuleManager.getModuleByName("Closest");
        llllllllllllllllIllIIIIlIllIIIlI.mod3 = (TotemPopCounter)ModuleManager.getModuleByName("TotemPopCounter");
        llllllllllllllllIllIIIIlIllIIIlI.Rainbow1 = Rainbow.getbruh();
    }

    @Override
    public void render() {
        String llllllllllllllllIllIIIIIIIIIlllI;
        Color llllllllllllllllIllIIIIIIIIlIlll;
        ClosestComponent llllllllllllllllIlIlllllllIlIIlI;
        super.render();
        if (llllllllllllllllIlIlllllllIlIIlI.mod.rainbow.getValue()) {
            Color llllllllllllllllIllIIIIIIlIIIlII = Rainbow.getColorWithOpacity(255);
        } else {
            llllllllllllllllIllIIIIIIIIlIlll = new Color(llllllllllllllllIlIlllllllIlIIlI.mod.red.getValue(), llllllllllllllllIlIlllllllIlIIlI.mod.green.getValue(), llllllllllllllllIlIlllllllIlIIlI.mod.blue.getValue(), 255);
        }
        llllllllllllllllIlIlllllllIlIIlI.nameoffset = 2;
        llllllllllllllllIlIlllllllIlIIlI.secoffset = 11;
        llllllllllllllllIlIlllllllIlIIlI.popoffset = 83;
        llllllllllllllllIlIlllllllIlIIlI.nameoffsetfinal = llllllllllllllllIlIlllllllIlIIlI.nameoffset + llllllllllllllllIlIlllllllIlIIlI.y;
        llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal = llllllllllllllllIlIlllllllIlIIlI.secoffset + llllllllllllllllIlIlllllllIlIIlI.y;
        llllllllllllllllIlIlllllllIlIIlI.popoffsetfinal = llllllllllllllllIlIlllllllIlIIlI.popoffset + llllllllllllllllIlIlllllllIlIIlI.y;
        if (llllllllllllllllIlIlllllllIlIIlI.nameoffsetfinal < 1) {
            llllllllllllllllIlIlllllllIlIIlI.nameoffsetfinal = 1;
        }
        if (llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal < 1) {
            llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal = 1;
        }
        if (llllllllllllllllIlIlllllllIlIIlI.popoffsetfinal < 1) {
            llllllllllllllllIlIlllllllIlIIlI.popoffsetfinal = 1;
        }
        if (llllllllllllllllIlIlllllllIlIIlI.nameoffsetfinal > 355) {
            llllllllllllllllIlIlllllllIlIIlI.nameoffsetfinal = llllllllllllllllIlIlllllllIlIIlI.nameoffset + llllllllllllllllIlIlllllllIlIIlI.y - 355;
        }
        if (llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal > 355) {
            llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal = llllllllllllllllIlIlllllllIlIIlI.secoffset + llllllllllllllllIlIlllllllIlIIlI.y - 355;
        }
        if (llllllllllllllllIlIlllllllIlIIlI.popoffsetfinal > 355) {
            llllllllllllllllIlIlllllllIlIIlI.popoffsetfinal = llllllllllllllllIlIlllllllIlIIlI.popoffset + llllllllllllllllIlIlllllllIlIIlI.y - 355;
        }
        llllllllllllllllIlIlllllllIlIIlI.width = 145;
        llllllllllllllllIlIlllllllIlIIlI.height = 99;
        llllllllllllllllIlIlllllllIlIIlI.l_Player = null;
        llllllllllllllllIlIlllllllIlIIlI.l_Player = llllllllllllllllIlIlllllllIlIIlI.mod2.ExcludeFriends.getValue() ? (EntityPlayer)llllllllllllllllIlIlllllllIlIIlI.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIlIlllllIlIIllll -> llllllllllllllllIlIlllllIlIIllll instanceof EntityPlayer).filter(llllllllllllllllIlIlllllIlIllIIl -> {
            ClosestComponent llllllllllllllllIlIlllllIlIllIll;
            return llllllllllllllllIlIlllllIlIllIIl != llllllllllllllllIlIlllllIlIllIll.mc.thePlayer;
        }).filter(llllllllllllllllIlIlllllIllIIlII -> !Friends.isFriend(llllllllllllllllIlIlllllIllIIlII.getName())).min(Comparator.comparing(llllllllllllllllIlIlllllIllIllIl -> {
            ClosestComponent llllllllllllllllIlIlllllIllIllll;
            return Float.valueOf(llllllllllllllllIlIlllllIllIllll.mc.thePlayer.getDistanceToEntity(llllllllllllllllIlIlllllIllIllIl));
        })).orElse(null) : (EntityPlayer)llllllllllllllllIlIlllllllIlIIlI.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIlIlllllIlllIlll -> llllllllllllllllIlIlllllIlllIlll instanceof EntityPlayer).filter(llllllllllllllllIlIlllllIlllllII -> {
            ClosestComponent llllllllllllllllIlIllllllIIIIlII;
            return llllllllllllllllIlIlllllIlllllII != llllllllllllllllIlIllllllIIIIlII.mc.thePlayer;
        }).min(Comparator.comparing(llllllllllllllllIlIllllllIIIlIll -> {
            ClosestComponent llllllllllllllllIlIllllllIIIllII;
            return Float.valueOf(llllllllllllllllIlIllllllIIIllII.mc.thePlayer.getDistanceToEntity(llllllllllllllllIlIllllllIIIlIll));
        })).orElse(null);
        if (llllllllllllllllIlIlllllllIlIIlI.mc.currentScreen instanceof HudGui) {
            llllllllllllllllIlIlllllllIlIIlI.l_Player = llllllllllllllllIlIlllllllIlIIlI.mc.thePlayer;
        }
        if (llllllllllllllllIlIlllllllIlIIlI.l_Player == null) {
            return;
        }
        Gui.drawRect((int)llllllllllllllllIlIlllllllIlIIlI.x, (int)llllllllllllllllIlIlllllllIlIIlI.y, (int)(llllllllllllllllIlIlllllllIlIIlI.x + 145), (int)(llllllllllllllllIlIlllllllIlIIlI.y + 99), (int)new Color(0, 0, 0, 130).getRGB());
        int llllllllllllllllIllIIIIIIIIlIllI = -1;
        llllllllllllllllIllIIIIIIIIlIllI = llllllllllllllllIlIlllllllIlIIlI.mc.getNetHandler() == null || llllllllllllllllIlIlllllllIlIIlI.mc.getNetHandler().getPlayerInfo(llllllllllllllllIlIlllllllIlIIlI.l_Player.getName()) == null ? -1 : llllllllllllllllIlIlllllllIlIIlI.mc.getNetHandler().getPlayerInfo(llllllllllllllllIlIlllllllIlIIlI.l_Player.getName()).getResponseTime();
        String llllllllllllllllIllIIIIIIIIlIlII = llllllllllllllllIlIlllllllIlIIlI.l_Player.getName();
        int llllllllllllllllIllIIIIIIIIlIIlI = (int)llllllllllllllllIlIlllllllIlIIlI.mc.thePlayer.getDistanceToEntity((Entity)llllllllllllllllIlIlllllllIlIIlI.l_Player);
        int llllllllllllllllIllIIIIIIIIlIIII = llllllllllllllllIlIlllllllIlIIlI.mod3.getpoppedfagezkys(llllllllllllllllIllIIIIIIIIlIlII);
        if (llllllllllllllllIllIIIIIIIIlIIII == 9999) {
            String llllllllllllllllIllIIIIIIlIIIIll = "0";
        } else {
            llllllllllllllllIllIIIIIIIIIlllI = String.valueOf(new StringBuilder().append("").append(llllllllllllllllIllIIIIIIIIlIIII));
        }
        InventoryPlayer llllllllllllllllIllIIIIIIIIIllII = llllllllllllllllIlIlllllllIlIIlI.l_Player.inventory;
        ItemStack llllllllllllllllIllIIIIIIIIIlIlI = llllllllllllllllIlIlllllllIlIIlI.l_Player.func_184614_ca();
        ItemStack llllllllllllllllIllIIIIIIIIIlIIl = llllllllllllllllIllIIIIIIIIIllII.armorItemInSlot(0);
        ItemStack llllllllllllllllIllIIIIIIIIIIllI = llllllllllllllllIllIIIIIIIIIllII.armorItemInSlot(1);
        ItemStack llllllllllllllllIllIIIIIIIIIIlII = llllllllllllllllIllIIIIIIIIIllII.armorItemInSlot(2);
        ItemStack llllllllllllllllIllIIIIIIIIIIIlI = llllllllllllllllIllIIIIIIIIIllII.armorItemInSlot(3);
        ItemStack llllllllllllllllIllIIIIIIIIIIIII = llllllllllllllllIlIlllllllIlIIlI.l_Player.func_184592_cb();
        GlStateManager.color((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        try {
            GuiInventory.drawEntityOnScreen((int)(llllllllllllllllIlIlllllllIlIIlI.x + 18), (int)(llllllllllllllllIlIlllllllIlIIlI.y + 58), (int)27, (float)1.0f, (float)13.0f, (EntityLivingBase)llllllllllllllllIlIlllllllIlIIlI.l_Player);
        }
        catch (Exception llllllllllllllllIlIlllllllIIIIlI) {
            // empty catch block
        }
        ImpactPlus.CustomFont2.drawStringWithShadow(llllllllllllllllIllIIIIIIIIlIlII, llllllllllllllllIlIlllllllIlIIlI.x + 38, llllllllllllllllIlIlllllllIlIIlI.y, llllllllllllllllIlIlllllllIlIIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIlllllllIlIIlI.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIlllllllIlIIlI.nameoffsetfinal) : llllllllllllllllIllIIIIIIIIlIlll.getRGB());
        if (Friends.isFriend(llllllllllllllllIllIIIIIIIIlIlII)) {
            ImpactPlus.CustomFont.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.AQUA).append("Friend").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIllI).append("ms").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIIlI).append("m")), llllllllllllllllIlIlllllllIlIIlI.x + 38, llllllllllllllllIlIlllllllIlIIlI.y + 11, llllllllllllllllIlIlllllllIlIIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIlllllllIlIIlI.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal) : llllllllllllllllIllIIIIIIIIlIlll.getRGB());
        } else if (llllllllllllllllIllIIIIIIIIIIIlI.getItem() == Items.diamond_helmet && llllllllllllllllIllIIIIIIIIIIlII.getItem() == Items.diamond_chestplate && llllllllllllllllIllIIIIIIIIIIllI.getItem() == Items.diamond_leggings && llllllllllllllllIllIIIIIIIIIlIIl.getItem() == Items.diamond_boots) {
            ImpactPlus.CustomFont.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("Threat").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIllI).append("ms").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIIlI).append("m")), llllllllllllllllIlIlllllllIlIIlI.x + 38, llllllllllllllllIlIlllllllIlIIlI.y + 11, llllllllllllllllIlIlllllllIlIIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIlllllllIlIIlI.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal) : llllllllllllllllIllIIIIIIIIlIlll.getRGB());
        } else if (llllllllllllllllIllIIIIIIIIIIIlI.getItem() == Items.diamond_helmet && llllllllllllllllIllIIIIIIIIIIlII.getItem() == Items.field_185160_cR && llllllllllllllllIllIIIIIIIIIIllI.getItem() == Items.diamond_leggings && llllllllllllllllIllIIIIIIIIIlIIl.getItem() == Items.diamond_boots) {
            ImpactPlus.CustomFont.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.YELLOW).append("Wasp").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIllI).append("ms").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIIlI).append("m")), llllllllllllllllIlIlllllllIlIIlI.x + 38, llllllllllllllllIlIlllllllIlIIlI.y + 11, llllllllllllllllIlIlllllllIlIIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIlllllllIlIIlI.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal) : llllllllllllllllIllIIIIIIIIlIlll.getRGB());
        } else if (llllllllllllllllIllIIIIIIIIIIIlI.getItem() == Items.field_190931_a && llllllllllllllllIllIIIIIIIIIIlII.getItem() == Items.field_190931_a && llllllllllllllllIllIIIIIIIIIIllI.getItem() == Items.field_190931_a && llllllllllllllllIllIIIIIIIIIlIIl.getItem() == Items.field_190931_a) {
            ImpactPlus.CustomFont.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.GREEN).append("Naked").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIllI).append("ms").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIIlI).append("m")), llllllllllllllllIlIlllllllIlIIlI.x + 38, llllllllllllllllIlIlllllllIlIIlI.y + 11, llllllllllllllllIlIlllllllIlIIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIlllllllIlIIlI.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal) : llllllllllllllllIllIIIIIIIIlIlll.getRGB());
        } else {
            ImpactPlus.CustomFont.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.LIGHT_PURPLE).append("NewFag").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIllI).append("ms").append(ChatFormatting.RESET).append(" | ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlIIlI).append("m")), llllllllllllllllIlIlllllllIlIIlI.x + 38, llllllllllllllllIlIlllllllIlIIlI.y + 11, llllllllllllllllIlIlllllllIlIIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIlllllllIlIIlI.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIlllllllIlIIlI.secoffsetfinal) : llllllllllllllllIllIIIIIIIIlIlll.getRGB());
        }
        float llllllllllllllllIlIllllllllllllI = llllllllllllllllIlIlllllllIlIIlI.l_Player.getHealth() / 20.0f * 145.0f;
        float llllllllllllllllIlIlllllllllllII = llllllllllllllllIlIlllllllIlIIlI.l_Player.getAbsorptionAmount() / 16.0f * 116.0f;
        int llllllllllllllllIlIllllllllllIll = 0;
        int llllllllllllllllIlIlllllllllIllI = -11141121;
        if (llllllllllllllllIlIllllllllllllI <= 145.0f) {
            llllllllllllllllIlIllllllllllIll = -11141291;
        }
        if ((double)llllllllllllllllIlIllllllllllllI <= 130.5) {
            llllllllllllllllIlIllllllllllIll = -16733696;
        }
        if (llllllllllllllllIlIllllllllllllI <= 116.0f) {
            llllllllllllllllIlIllllllllllIll = -171;
        }
        if (llllllllllllllllIlIllllllllllllI <= 87.0f) {
            llllllllllllllllIlIllllllllllIll = -22016;
        }
        if (llllllllllllllllIlIllllllllllllI <= 58.0f) {
            llllllllllllllllIlIllllllllllIll = -43691;
        }
        if ((double)llllllllllllllllIlIllllllllllllI <= 36.25) {
            llllllllllllllllIlIllllllllllIll = -5636096;
        }
        Gui.drawRect((int)llllllllllllllllIlIlllllllIlIIlI.x, (int)(llllllllllllllllIlIlllllllIlIIlI.y + 95), (int)(llllllllllllllllIlIlllllllIlIIlI.x + (int)llllllllllllllllIlIlllllllllllII), (int)(llllllllllllllllIlIlllllllIlIIlI.y + 97), (int)llllllllllllllllIlIlllllllllIllI);
        Gui.drawRect((int)llllllllllllllllIlIlllllllIlIIlI.x, (int)(llllllllllllllllIlIlllllllIlIIlI.y + 97), (int)(llllllllllllllllIlIlllllllIlIIlI.x + (int)llllllllllllllllIlIllllllllllllI), (int)(llllllllllllllllIlIlllllllIlIIlI.y + 99), (int)llllllllllllllllIlIllllllllllIll);
        ImpactPlus.CustomFont.drawStringWithShadow(String.valueOf(new StringBuilder().append("Pops ").append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIIlllI)), llllllllllllllllIlIlllllllIlIIlI.x + 2, llllllllllllllllIlIlllllllIlIIlI.y + 83, llllllllllllllllIlIlllllllIlIIlI.mod.rainbowmode.getValue().equalsIgnoreCase("Good") ? llllllllllllllllIlIlllllllIlIIlI.Rainbow1.GetRainbowColorAt(llllllllllllllllIlIlllllllIlIIlI.popoffsetfinal) : llllllllllllllllIllIIIIIIIIlIlll.getRGB());
        int llllllllllllllllIlIlllllllllIlII = 0;
        ArrayList<ItemStack> llllllllllllllllIlIlllllllllIIlI = new ArrayList<ItemStack>();
        for (ItemStack llllllllllllllllIllIIIIIIlIIIIIl : llllllllllllllllIlIlllllllIlIIlI.l_Player.func_184193_aE()) {
            llllllllllllllllIlIlllllllllIIlI.add(llllllllllllllllIllIIIIIIlIIIIIl);
        }
        Collections.reverse(llllllllllllllllIlIlllllllllIIlI);
        for (ItemStack llllllllllllllllIllIIIIIIIlllIll : llllllllllllllllIlIlllllllllIIlI) {
            int llllllllllllllllIllIIIIIIIllllll = llllllllllllllllIlIlllllllIlIIlI.y + 24;
            int llllllllllllllllIllIIIIIIIllllIl = llllllllllllllllIlIlllllllIlIIlI.x + llllllllllllllllIlIlllllllllIlII + 36;
            RenderHelper.enableGUIStandardItemLighting();
            llllllllllllllllIlIlllllllIlIIlI.mc.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllllIllIIIIIIIlllIll, llllllllllllllllIllIIIIIIIllllIl, llllllllllllllllIllIIIIIIIllllll);
            llllllllllllllllIlIlllllllIlIIlI.mc.getRenderItem().renderItemOverlays(llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj, llllllllllllllllIllIIIIIIIlllIll, llllllllllllllllIllIIIIIIIllllIl, llllllllllllllllIllIIIIIIIllllll);
            RenderHelper.disableStandardItemLighting();
            llllllllllllllllIlIlllllllllIlII += 18;
        }
        int llllllllllllllllIlIlllllllllIIII = llllllllllllllllIlIlllllllIlIIlI.y + 24;
        int llllllllllllllllIlIllllllllIlllI = llllllllllllllllIlIlllllllIlIIlI.x + 108;
        RenderHelper.enableGUIStandardItemLighting();
        llllllllllllllllIlIlllllllIlIIlI.mc.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllllIllIIIIIIIIIlIlI, llllllllllllllllIlIllllllllIlllI, llllllllllllllllIlIlllllllllIIII);
        llllllllllllllllIlIlllllllIlIIlI.mc.getRenderItem().renderItemOverlays(llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj, llllllllllllllllIllIIIIIIIIIlIlI, llllllllllllllllIlIllllllllIlllI, llllllllllllllllIlIlllllllllIIII);
        RenderHelper.disableStandardItemLighting();
        ItemStack llllllllllllllllIlIllllllllIllIl = llllllllllllllllIlIlllllllIlIIlI.l_Player.func_184592_cb();
        int llllllllllllllllIlIllllllllIllII = llllllllllllllllIlIlllllllIlIIlI.y + 24;
        int llllllllllllllllIlIllllllllIlIll = llllllllllllllllIlIlllllllIlIIlI.x + 126;
        RenderHelper.enableGUIStandardItemLighting();
        llllllllllllllllIlIlllllllIlIIlI.mc.getRenderItem().renderItemAndEffectIntoGUI(llllllllllllllllIlIllllllllIllIl, llllllllllllllllIlIllllllllIlIll, llllllllllllllllIlIllllllllIllII);
        llllllllllllllllIlIlllllllIlIIlI.mc.getRenderItem().renderItemOverlays(llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj, llllllllllllllllIlIllllllllIllIl, llllllllllllllllIlIllllllllIlIll, llllllllllllllllIlIllllllllIllII);
        RenderHelper.disableStandardItemLighting();
        EnchantEntry[] llllllllllllllllIlIllllllllIlIlI = new EnchantEntry[]{new EnchantEntry(Enchantments.protection, "Pro"), new EnchantEntry(Enchantments.field_185297_d, "Bla"), new EnchantEntry(Enchantments.fireProtection, "Fpr"), new EnchantEntry(Enchantments.projectileProtection, "Ppr"), new EnchantEntry(Enchantments.field_185307_s, "Unb"), new EnchantEntry(Enchantments.field_185296_A, "Men"), new EnchantEntry(Enchantments.field_185299_g, "Aqu"), new EnchantEntry(Enchantments.field_185298_f, "Res"), new EnchantEntry(Enchantments.featherFalling, "Fea"), new EnchantEntry(Enchantments.field_185300_i, "Dep"), new EnchantEntry(Enchantments.field_185301_j, "Fro"), new EnchantEntry(Enchantments.thorns, "Thr"), new EnchantEntry(Enchantments.field_185302_k, "Sha"), new EnchantEntry(Enchantments.fireAspect, "Fia"), new EnchantEntry(Enchantments.knockback, "Knb"), new EnchantEntry(Enchantments.field_185309_u, "Pow"), new EnchantEntry(Enchantments.field_190941_k, "Bin"), new EnchantEntry(Enchantments.field_185303_l, "Smi"), new EnchantEntry(Enchantments.baneOfArthropods, "Ban"), new EnchantEntry(Enchantments.field_185304_p, "Loo"), new EnchantEntry(Enchantments.field_191530_r, "Swe"), new EnchantEntry(Enchantments.field_185305_q, "Eff"), new EnchantEntry(Enchantments.field_185306_r, "Sil"), new EnchantEntry(Enchantments.field_185308_t, "For"), new EnchantEntry(Enchantments.field_185311_w, "Fla"), new EnchantEntry(Enchantments.luckOfTheSea, "Luc"), new EnchantEntry(Enchantments.lure, "Lur"), new EnchantEntry(Enchantments.field_185310_v, "Pun"), new EnchantEntry(Enchantments.field_190940_C, "Van")};
        int llllllllllllllllIlIllllllllIlIIl = 0;
        int llllllllllllllllIlIllllllllIlIII = 0;
        int llllllllllllllllIlIllllllllIIlll = 0;
        int llllllllllllllllIlIllllllllIIlIl = 0;
        int llllllllllllllllIlIllllllllIIIlI = 0;
        int llllllllllllllllIlIllllllllIIIIl = 0;
        EnchantEntry[] llllllllllllllllIlIlllllllIlllll = llllllllllllllllIlIllllllllIlIlI;
        int llllllllllllllllIlIlllllllIlllIl = llllllllllllllllIlIllllllllIlIlI.length;
        for (int llllllllllllllllIllIIIIIIIllIllI = 0; llllllllllllllllIllIIIIIIIllIllI < llllllllllllllllIlIlllllllIlllIl; ++llllllllllllllllIllIIIIIIIllIllI) {
            EnchantEntry llllllllllllllllIllIIIIIIIlllIIl = llllllllllllllllIlIlllllllIlllll[llllllllllllllllIllIIIIIIIllIllI];
            int llllllllllllllllIllIIIIIIIlllIII = EnchantmentHelper.getEnchantmentLevel((Enchantment)llllllllllllllllIllIIIIIIIlllIIl.getEnchant(), (ItemStack)llllllllllllllllIllIIIIIIIIIIIlI);
            String llllllllllllllllIllIIIIIIIllIlll = String.valueOf(new StringBuilder().append("").append(llllllllllllllllIllIIIIIIIlllIII));
            if (llllllllllllllllIllIIIIIIIlllIII <= 0) continue;
            GL11.glPushMatrix();
            GL11.glTranslated((double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.x) + 38), (double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.y) + 48 + llllllllllllllllIlIllllllllIlIIl), (double)0.0);
            GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
            if (llllllllllllllllIllIIIIIIIlllIIl.getName().equals("Van")) {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append(llllllllllllllllIllIIIIIIIlllIIl.getName()).append(" ").append(llllllllllllllllIllIIIIIIIllIlll)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            } else {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIlllIIl.getName()).append(" ").append(llllllllllllllllIllIIIIIIIllIlll)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            }
            llllllllllllllllIlIllllllllIlIIl += 5;
            GL11.glPopMatrix();
        }
        llllllllllllllllIlIlllllllIlllll = llllllllllllllllIlIllllllllIlIlI;
        int llllllllllllllllIlIlllllllIllIll = llllllllllllllllIlIllllllllIlIlI.length;
        for (int llllllllllllllllIllIIIIIIIllIIIl = 0; llllllllllllllllIllIIIIIIIllIIIl < llllllllllllllllIlIlllllllIllIll; ++llllllllllllllllIllIIIIIIIllIIIl) {
            EnchantEntry llllllllllllllllIllIIIIIIIllIlIl = llllllllllllllllIlIlllllllIlllll[llllllllllllllllIllIIIIIIIllIIIl];
            int llllllllllllllllIllIIIIIIIllIlII = EnchantmentHelper.getEnchantmentLevel((Enchantment)llllllllllllllllIllIIIIIIIllIlIl.getEnchant(), (ItemStack)llllllllllllllllIllIIIIIIIIIIlII);
            String llllllllllllllllIllIIIIIIIllIIlI = String.valueOf(new StringBuilder().append("").append(llllllllllllllllIllIIIIIIIllIlII));
            if (llllllllllllllllIllIIIIIIIllIlII <= 0) continue;
            GL11.glPushMatrix();
            GL11.glTranslated((double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.x) + 56), (double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.y) + 48 + llllllllllllllllIlIllllllllIlIII), (double)0.0);
            GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
            if (llllllllllllllllIllIIIIIIIllIlIl.getName().equals("Van")) {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append(llllllllllllllllIllIIIIIIIllIlIl.getName()).append(" ").append(llllllllllllllllIllIIIIIIIllIIlI)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            } else {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIllIlIl.getName()).append(" ").append(llllllllllllllllIllIIIIIIIllIIlI)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            }
            llllllllllllllllIlIllllllllIlIII += 5;
            GL11.glPopMatrix();
        }
        llllllllllllllllIlIlllllllIlllll = llllllllllllllllIlIllllllllIlIlI;
        int llllllllllllllllIlIlllllllIllIlI = llllllllllllllllIlIllllllllIlIlI.length;
        for (int llllllllllllllllIllIIIIIIIlIlIIl = 0; llllllllllllllllIllIIIIIIIlIlIIl < llllllllllllllllIlIlllllllIllIlI; ++llllllllllllllllIllIIIIIIIlIlIIl) {
            EnchantEntry llllllllllllllllIllIIIIIIIlIllll = llllllllllllllllIlIlllllllIlllll[llllllllllllllllIllIIIIIIIlIlIIl];
            int llllllllllllllllIllIIIIIIIlIllIl = EnchantmentHelper.getEnchantmentLevel((Enchantment)llllllllllllllllIllIIIIIIIlIllll.getEnchant(), (ItemStack)llllllllllllllllIllIIIIIIIIIIllI);
            String llllllllllllllllIllIIIIIIIlIlIll = String.valueOf(new StringBuilder().append("").append(llllllllllllllllIllIIIIIIIlIllIl));
            if (llllllllllllllllIllIIIIIIIlIllIl <= 0) continue;
            GL11.glPushMatrix();
            GL11.glTranslated((double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.x) + 74), (double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.y) + 48 + llllllllllllllllIlIllllllllIIlll), (double)0.0);
            GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
            if (llllllllllllllllIllIIIIIIIlIllll.getName().equals("Van")) {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append(llllllllllllllllIllIIIIIIIlIllll.getName()).append(" ").append(llllllllllllllllIllIIIIIIIlIlIll)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            } else {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIlIllll.getName()).append(" ").append(llllllllllllllllIllIIIIIIIlIlIll)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            }
            llllllllllllllllIlIllllllllIIlll += 5;
            GL11.glPopMatrix();
        }
        llllllllllllllllIlIlllllllIlllll = llllllllllllllllIlIllllllllIlIlI;
        int llllllllllllllllIlIlllllllIllIII = llllllllllllllllIlIllllllllIlIlI.length;
        for (int llllllllllllllllIllIIIIIIIlIIIIl = 0; llllllllllllllllIllIIIIIIIlIIIIl < llllllllllllllllIlIlllllllIllIII; ++llllllllllllllllIllIIIIIIIlIIIIl) {
            EnchantEntry llllllllllllllllIllIIIIIIIlIIlll = llllllllllllllllIlIlllllllIlllll[llllllllllllllllIllIIIIIIIlIIIIl];
            int llllllllllllllllIllIIIIIIIlIIlIl = EnchantmentHelper.getEnchantmentLevel((Enchantment)llllllllllllllllIllIIIIIIIlIIlll.getEnchant(), (ItemStack)llllllllllllllllIllIIIIIIIIIlIIl);
            String llllllllllllllllIllIIIIIIIlIIIlI = String.valueOf(new StringBuilder().append("").append(llllllllllllllllIllIIIIIIIlIIlIl));
            if (llllllllllllllllIllIIIIIIIlIIlIl <= 0) continue;
            GL11.glPushMatrix();
            GL11.glTranslated((double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.x) + 92), (double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.y) + 48 + llllllllllllllllIlIllllllllIIlIl), (double)0.0);
            GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
            if (llllllllllllllllIllIIIIIIIlIIlll.getName().equals("Van")) {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append(llllllllllllllllIllIIIIIIIlIIlll.getName()).append(" ").append(llllllllllllllllIllIIIIIIIlIIIlI)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            } else {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIlIIlll.getName()).append(" ").append(llllllllllllllllIllIIIIIIIlIIIlI)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            }
            llllllllllllllllIlIllllllllIIlIl += 5;
            GL11.glPopMatrix();
        }
        llllllllllllllllIlIlllllllIlllll = llllllllllllllllIlIllllllllIlIlI;
        int llllllllllllllllIlIlllllllIlIllI = llllllllllllllllIlIllllllllIlIlI.length;
        for (int llllllllllllllllIllIIIIIIIIlllIl = 0; llllllllllllllllIllIIIIIIIIlllIl < llllllllllllllllIlIlllllllIlIllI; ++llllllllllllllllIllIIIIIIIIlllIl) {
            EnchantEntry llllllllllllllllIllIIIIIIIlIIIII = llllllllllllllllIlIlllllllIlllll[llllllllllllllllIllIIIIIIIIlllIl];
            int llllllllllllllllIllIIIIIIIIlllll = EnchantmentHelper.getEnchantmentLevel((Enchantment)llllllllllllllllIllIIIIIIIlIIIII.getEnchant(), (ItemStack)llllllllllllllllIllIIIIIIIIIlIlI);
            String llllllllllllllllIllIIIIIIIIllllI = String.valueOf(new StringBuilder().append("").append(llllllllllllllllIllIIIIIIIIlllll));
            if (llllllllllllllllIllIIIIIIIIlllll <= 0) continue;
            GL11.glPushMatrix();
            GL11.glTranslated((double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.x) + 110), (double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.y) + 48 + llllllllllllllllIlIllllllllIIIlI), (double)0.0);
            GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
            if (llllllllllllllllIllIIIIIIIlIIIII.getName().equals("Van")) {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append(llllllllllllllllIllIIIIIIIlIIIII.getName()).append(" ").append(llllllllllllllllIllIIIIIIIIllllI)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            } else {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIlIIIII.getName()).append(" ").append(llllllllllllllllIllIIIIIIIIllllI)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            }
            llllllllllllllllIlIllllllllIIIlI += 5;
            GL11.glPopMatrix();
        }
        llllllllllllllllIlIlllllllIlllll = llllllllllllllllIlIllllllllIlIlI;
        int llllllllllllllllIlIlllllllIlIlII = llllllllllllllllIlIllllllllIlIlI.length;
        for (int llllllllllllllllIllIIIIIIIIllIIl = 0; llllllllllllllllIllIIIIIIIIllIIl < llllllllllllllllIlIlllllllIlIlII; ++llllllllllllllllIllIIIIIIIIllIIl) {
            EnchantEntry llllllllllllllllIllIIIIIIIIlllII = llllllllllllllllIlIlllllllIlllll[llllllllllllllllIllIIIIIIIIllIIl];
            int llllllllllllllllIllIIIIIIIIllIll = EnchantmentHelper.getEnchantmentLevel((Enchantment)llllllllllllllllIllIIIIIIIIlllII.getEnchant(), (ItemStack)llllllllllllllllIllIIIIIIIIIIIII);
            String llllllllllllllllIllIIIIIIIIllIlI = String.valueOf(new StringBuilder().append("").append(llllllllllllllllIllIIIIIIIIllIll));
            if (llllllllllllllllIllIIIIIIIIllIll <= 0) continue;
            GL11.glPushMatrix();
            GL11.glTranslated((double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.x) + 128), (double)((int)((float)llllllllllllllllIlIlllllllIlIIlI.y) + 48 + llllllllllllllllIlIllllllllIIIIl), (double)0.0);
            GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
            if (llllllllllllllllIllIIIIIIIIlllII.getName().equals("Van")) {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append(llllllllllllllllIllIIIIIIIIlllII.getName()).append(" ").append(llllllllllllllllIllIIIIIIIIllIlI)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            } else {
                llllllllllllllllIlIlllllllIlIIlI.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)llllllllllllllllIlIlllllllIlIIlI.mod.color.getValue())).append(llllllllllllllllIllIIIIIIIIlllII.getName()).append(" ").append(llllllllllllllllIllIIIIIIIIllIlI)), 0.0f, (float)(-Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT), -1);
            }
            llllllllllllllllIlIllllllllIIIIl += 5;
            GL11.glPopMatrix();
        }
    }

    public static class EnchantEntry {
        private /* synthetic */ String name;
        private /* synthetic */ Enchantment enchant;

        public EnchantEntry(Enchantment llllllllllllllllIlIIlllllIIllIlI, String llllllllllllllllIlIIlllllIIllIIl) {
            EnchantEntry llllllllllllllllIlIIlllllIlIIIlI;
            llllllllllllllllIlIIlllllIlIIIlI.enchant = llllllllllllllllIlIIlllllIIllIlI;
            llllllllllllllllIlIIlllllIlIIIlI.name = llllllllllllllllIlIIlllllIIllIIl;
        }

        public String getName() {
            EnchantEntry llllllllllllllllIlIIlllllIIIlIll;
            return llllllllllllllllIlIIlllllIIIlIll.name;
        }

        public Enchantment getEnchant() {
            EnchantEntry llllllllllllllllIlIIlllllIIlIIlI;
            return llllllllllllllllIlIIlllllIIlIIlI.enchant;
        }
    }
}

