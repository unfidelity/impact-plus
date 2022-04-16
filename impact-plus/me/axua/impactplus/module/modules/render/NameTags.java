/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraft.enchantment.Enchantment
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.item.ItemAir
 *  net.minecraft.item.ItemArmor
 *  net.minecraft.item.ItemElytra
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.item.ItemTool
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.text.TextFormatting
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.module.modules.render;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.MathUtil;
import me.axua.impactplus.util.rainbow.Rainbow;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemElytra;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.opengl.GL11;

public class NameTags
extends Module {
    /* synthetic */ int obbyblue;
    /* synthetic */ int obbyred;
    public /* synthetic */ Setting.d scaling;
    /* synthetic */ int obbygreen;
    public /* synthetic */ Setting.b armor;
    /* synthetic */ int a;
    public /* synthetic */ Setting.i r;
    public /* synthetic */ Setting.b durability;
    public /* synthetic */ Setting.b rainbow;
    public /* synthetic */ Setting.b itemname;
    public /* synthetic */ Setting.b health;
    public /* synthetic */ Setting.b gamemode;
    public /* synthetic */ Setting.b ping;
    public /* synthetic */ Setting.i g;
    public /* synthetic */ Setting.b colorOutline;
    public /* synthetic */ Setting.i b;

    private void renderNameTag(EntityPlayer lllllllllllllllllIIlIIIlIIIIIllI, double lllllllllllllllllIIlIIIlIIIlIIll, double lllllllllllllllllIIlIIIlIIIIIlII, double lllllllllllllllllIIlIIIlIIIlIIIl, float lllllllllllllllllIIlIIIlIIIlIIII) {
        NameTags lllllllllllllllllIIlIIIlIIIIIlll;
        double lllllllllllllllllIIlIIIlIIIIllll = lllllllllllllllllIIlIIIlIIIIIlII;
        lllllllllllllllllIIlIIIlIIIIllll += lllllllllllllllllIIlIIIlIIIIIllI.isSneaking() ? 0.5 : 0.7;
        Entity lllllllllllllllllIIlIIIlIIIIlllI = mc.getRenderViewEntity();
        double lllllllllllllllllIIlIIIlIIIIllIl = lllllllllllllllllIIlIIIlIIIIlllI.posX;
        double lllllllllllllllllIIlIIIlIIIIllII = lllllllllllllllllIIlIIIlIIIIlllI.posY;
        double lllllllllllllllllIIlIIIlIIIIlIll = lllllllllllllllllIIlIIIlIIIIlllI.posZ;
        lllllllllllllllllIIlIIIlIIIIlllI.posX = lllllllllllllllllIIlIIIlIIIIIlll.interpolate(lllllllllllllllllIIlIIIlIIIIlllI.prevPosX, lllllllllllllllllIIlIIIlIIIIlllI.posX, lllllllllllllllllIIlIIIlIIIlIIII);
        lllllllllllllllllIIlIIIlIIIIlllI.posY = lllllllllllllllllIIlIIIlIIIIIlll.interpolate(lllllllllllllllllIIlIIIlIIIIlllI.prevPosY, lllllllllllllllllIIlIIIlIIIIlllI.posY, lllllllllllllllllIIlIIIlIIIlIIII);
        lllllllllllllllllIIlIIIlIIIIlllI.posZ = lllllllllllllllllIIlIIIlIIIIIlll.interpolate(lllllllllllllllllIIlIIIlIIIIlllI.prevPosZ, lllllllllllllllllIIlIIIlIIIIlllI.posZ, lllllllllllllllllIIlIIIlIIIlIIII);
        double lllllllllllllllllIIlIIIlIIIIlIlI = lllllllllllllllllIIlIIIlIIIIlllI.getDistance(lllllllllllllllllIIlIIIlIIIlIIll + NameTags.mc.getRenderManager().viewerPosX, lllllllllllllllllIIlIIIlIIIIIlII + NameTags.mc.getRenderManager().viewerPosY, lllllllllllllllllIIlIIIlIIIlIIIl + NameTags.mc.getRenderManager().viewerPosZ);
        int lllllllllllllllllIIlIIIlIIIIlIIl = (int)(ImpactPlus.CustomFont3.getStringWidth(lllllllllllllllllIIlIIIlIIIIIlll.getDisplayName(lllllllllllllllllIIlIIIlIIIIIllI)) / 2.0f);
        double lllllllllllllllllIIlIIIlIIIIlIII = 0.0018 + lllllllllllllllllIIlIIIlIIIIIlll.scaling.getValue() * 0.001 * lllllllllllllllllIIlIIIlIIIIlIlI;
        if (lllllllllllllllllIIlIIIlIIIIlIlI <= 8.0) {
            lllllllllllllllllIIlIIIlIIIIlIII = 0.0245;
        }
        GlStateManager.pushMatrix();
        RenderHelper.enableStandardItemLighting();
        GlStateManager.enablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)-1500000.0f);
        GlStateManager.disableLighting();
        GlStateManager.translate((float)((float)lllllllllllllllllIIlIIIlIIIlIIll), (float)((float)lllllllllllllllllIIlIIIlIIIIllll + 1.4f), (float)((float)lllllllllllllllllIIlIIIlIIIlIIIl));
        GlStateManager.rotate((float)(-NameTags.mc.getRenderManager().playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.rotate((float)NameTags.mc.getRenderManager().playerViewX, (float)(NameTags.mc.gameSettings.thirdPersonView == 2 ? -1.0f : 1.0f), (float)0.0f, (float)0.0f);
        GlStateManager.scale((double)(-lllllllllllllllllIIlIIIlIIIIlIII), (double)(-lllllllllllllllllIIlIIIlIIIIlIII), (double)lllllllllllllllllIIlIIIlIIIIlIII);
        GlStateManager.disableDepth();
        GlStateManager.depthMask((boolean)false);
        GL11.glDisable((int)2929);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        NameTags.drawBorderedRect(-lllllllllllllllllIIlIIIlIIIIlIIl - 2, -(ImpactPlus.CustomFont3.FONT_HEIGHT * 2 + 2), (float)lllllllllllllllllIIlIIIlIIIIlIIl + 2.0f, 1.5, 1.0, new Color(0, 0, 0, 130).getRGB(), lllllllllllllllllIIlIIIlIIIIIlll.colorOutline.getValue() ? new Color(lllllllllllllllllIIlIIIlIIIIIlll.obbyred, lllllllllllllllllIIlIIIlIIIIIlll.obbygreen, lllllllllllllllllIIlIIIlIIIIIlll.obbyblue, lllllllllllllllllIIlIIIlIIIIIlll.a).getRGB() : 0);
        GlStateManager.func_187432_a((float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glColor4f((float)1.0f, (float)10.0f, (float)1.0f, (float)1.0f);
        ImpactPlus.CustomFont3.drawString(lllllllllllllllllIIlIIIlIIIIIlll.getDisplayName(lllllllllllllllllIIlIIIlIIIIIllI), -lllllllllllllllllIIlIIIlIIIIlIIl, -(ImpactPlus.CustomFont3.FONT_HEIGHT * 2) - 2, lllllllllllllllllIIlIIIlIIIIIlll.getDisplayColour(lllllllllllllllllIIlIIIlIIIIIllI));
        GlStateManager.func_187432_a((float)0.0f, (float)0.0f, (float)0.0f);
        if (lllllllllllllllllIIlIIIlIIIIIlll.armor.getValue()) {
            int lllllllllllllllllIIlIIIlIIIllIII;
            GlStateManager.pushMatrix();
            int lllllllllllllllllIIlIIIlIIIllIIl = 0;
            if (lllllllllllllllllIIlIIIlIIIIIllI.func_184614_ca().getItem() != null && lllllllllllllllllIIlIIIlIIIIIllI.func_184592_cb().getItem() == null || lllllllllllllllllIIlIIIlIIIIIllI.func_184614_ca().getItem() == null && lllllllllllllllllIIlIIIlIIIIIllI.func_184592_cb().getItem() != null) {
                lllllllllllllllllIIlIIIlIIIllIIl = -4;
            } else if (lllllllllllllllllIIlIIIlIIIIIllI.func_184614_ca().getItem() != null && lllllllllllllllllIIlIIIlIIIIIllI.func_184592_cb().getItem() != null) {
                lllllllllllllllllIIlIIIlIIIllIIl = -8;
            }
            for (lllllllllllllllllIIlIIIlIIIllIII = 3; lllllllllllllllllIIlIIIlIIIllIII >= 0; --lllllllllllllllllIIlIIIlIIIllIII) {
                ItemStack lllllllllllllllllIIlIIIlIIIlllll = (ItemStack)lllllllllllllllllIIlIIIlIIIIIllI.inventory.armorInventory.get(lllllllllllllllllIIlIIIlIIIllIII);
                if (lllllllllllllllllIIlIIIlIIIlllll == null || lllllllllllllllllIIlIIIlIIIlllll.getItem() == Items.field_190931_a) continue;
                lllllllllllllllllIIlIIIlIIIllIIl -= 8;
            }
            ArrayList<ItemStack> lllllllllllllllllIIlIIIlIIIlIlll = new ArrayList<ItemStack>();
            if (lllllllllllllllllIIlIIIlIIIIIllI.inventory.armorInventory != null) {
                for (ItemStack lllllllllllllllllIIlIIIlIIIllllI : lllllllllllllllllIIlIIIlIIIIIllI.inventory.armorInventory) {
                    if (lllllllllllllllllIIlIIIlIIIllllI == null || lllllllllllllllllIIlIIIlIIIllllI.getItem().equals(Items.field_190931_a)) continue;
                    lllllllllllllllllIIlIIIlIIIlIlll.add(lllllllllllllllllIIlIIIlIIIllllI);
                }
            }
            ArrayList<ItemStack> lllllllllllllllllIIlIIIlIIIlIllI = new ArrayList<ItemStack>();
            lllllllllllllllllIIlIIIlIIIlIllI.addAll((Collection<ItemStack>)lllllllllllllllllIIlIIIlIIIIIllI.inventory.armorInventory);
            if (lllllllllllllllllIIlIIIlIIIIIllI.func_184614_ca() != null) {
                lllllllllllllllllIIlIIIlIIIlIllI.add(lllllllllllllllllIIlIIIlIIIIIllI.func_184614_ca().copy());
            }
            if (lllllllllllllllllIIlIIIlIIIIIllI.func_184592_cb() != null) {
                lllllllllllllllllIIlIIIlIIIlIllI.add(lllllllllllllllllIIlIIIlIIIIIllI.func_184592_cb().copy());
            }
            if (lllllllllllllllllIIlIIIlIIIIIllI.func_184614_ca() != null) {
                lllllllllllllllllIIlIIIlIIIllIIl -= 8;
                ItemStack lllllllllllllllllIIlIIIlIIIlllIl = lllllllllllllllllIIlIIIlIIIIIllI.func_184614_ca().copy();
                if (!lllllllllllllllllIIlIIIlIIIlllIl.getItem().equals(Items.field_190931_a)) {
                    lllllllllllllllllIIlIIIlIIIIIlll.renderItemStack(lllllllllllllllllIIlIIIlIIIlIllI, lllllllllllllllllIIlIIIlIIIlllIl, lllllllllllllllllIIlIIIlIIIllIIl, -(lllllllllllllllllIIlIIIlIIIIIlll.getEnchantSpace(lllllllllllllllllIIlIIIlIIIlIllI) + 26) + 26 + 10);
                    lllllllllllllllllIIlIIIlIIIllIIl = lllllllllllllllllIIlIIIlIIIlIlll.isEmpty() ? (lllllllllllllllllIIlIIIlIIIllIIl += 22) : (lllllllllllllllllIIlIIIlIIIllIIl += 16);
                }
            }
            for (lllllllllllllllllIIlIIIlIIIllIII = lllllllllllllllllIIlIIIlIIIlIlll.size() - 1; lllllllllllllllllIIlIIIlIIIllIII >= 0; --lllllllllllllllllIIlIIIlIIIllIII) {
                ItemStack lllllllllllllllllIIlIIIlIIIlllII;
                ItemStack lllllllllllllllllIIlIIIlIIIllIll = (ItemStack)lllllllllllllllllIIlIIIlIIIlIlll.get(lllllllllllllllllIIlIIIlIIIllIII);
                if (lllllllllllllllllIIlIIIlIIIllIll == null || (lllllllllllllllllIIlIIIlIIIlllII = lllllllllllllllllIIlIIIlIIIllIll.copy()).getItem().equals(Items.field_190931_a)) continue;
                if (lllllllllllllllllIIlIIIlIIIlllII.getItem() instanceof ItemTool || lllllllllllllllllIIlIIIlIIIlllII.getItem() instanceof ItemArmor || lllllllllllllllllIIlIIIlIIIlllII.getItem().equals(Items.field_185160_cR)) {
                    lllllllllllllllllIIlIIIlIIIIIlll.renderItemStack(lllllllllllllllllIIlIIIlIIIlIllI, lllllllllllllllllIIlIIIlIIIlllII, lllllllllllllllllIIlIIIlIIIllIIl, -(lllllllllllllllllIIlIIIlIIIIIlll.getEnchantSpace(lllllllllllllllllIIlIIIlIIIlIllI) + 26) + 26 + 10);
                }
                if (lllllllllllllllllIIlIIIlIIIlIlll.get(0) == lllllllllllllllllIIlIIIlIIIllIll) {
                    lllllllllllllllllIIlIIIlIIIllIIl += 24;
                    continue;
                }
                lllllllllllllllllIIlIIIlIIIllIIl += 16;
            }
            if (lllllllllllllllllIIlIIIlIIIIIllI.func_184592_cb() != null) {
                lllllllllllllllllIIlIIIlIIIllIIl -= 8;
                ItemStack lllllllllllllllllIIlIIIlIIIllIlI = lllllllllllllllllIIlIIIlIIIIIllI.func_184592_cb().copy();
                if (!lllllllllllllllllIIlIIIlIIIllIlI.getItem().equals(Items.field_190931_a)) {
                    lllllllllllllllllIIlIIIlIIIIIlll.renderItemStack(lllllllllllllllllIIlIIIlIIIlIllI, lllllllllllllllllIIlIIIlIIIllIlI, lllllllllllllllllIIlIIIlIIIllIIl, -(lllllllllllllllllIIlIIIlIIIIIlll.getEnchantSpace(lllllllllllllllllIIlIIIlIIIlIllI) + 26) + 26 + 10);
                    lllllllllllllllllIIlIIIlIIIllIIl += 16;
                }
            }
            GlStateManager.popMatrix();
        }
        lllllllllllllllllIIlIIIlIIIIlllI.posX = lllllllllllllllllIIlIIIlIIIIllIl;
        lllllllllllllllllIIlIIIlIIIIlllI.posY = lllllllllllllllllIIlIIIlIIIIllII;
        lllllllllllllllllIIlIIIlIIIIlllI.posZ = lllllllllllllllllIIlIIIlIIIIlIll;
        GlStateManager.enableDepth();
        GlStateManager.enableLighting();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.disablePolygonOffset();
        GlStateManager.doPolygonOffset((float)1.0f, (float)1500000.0f);
        GlStateManager.popMatrix();
    }

    public static void disableGL2D() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    private int getDisplayColour(EntityPlayer lllllllllllllllllIIlIIIIIllIIIII) {
        int lllllllllllllllllIIlIIIIIlIlllll = -1;
        if (Friends.isFriend(lllllllllllllllllIIlIIIIIllIIIII.getName())) {
            return 4251856;
        }
        if (lllllllllllllllllIIlIIIIIllIIIII.isInvisible()) {
            lllllllllllllllllIIlIIIIIlIlllll = -3593216;
        } else if (lllllllllllllllllIIlIIIIIllIIIII.isSneaking()) {
            lllllllllllllllllIIlIIIIIlIlllll = -3593216;
        }
        return lllllllllllllllllIIlIIIIIlIlllll;
    }

    public int getPing(EntityPlayer lllllllllllllllllIIlIIIIlIllllll) {
        int lllllllllllllllllIIlIIIIllIIIIII = 0;
        try {
            lllllllllllllllllIIlIIIIllIIIIII = (int)MathUtil.clamp(mc.getNetHandler().getPlayerInfo(lllllllllllllllllIIlIIIIlIllllll.getUniqueID()).getResponseTime(), 0.0f, 300.0f);
        }
        catch (NullPointerException lllllllllllllllllIIlIIIIlIllllIl) {
            // empty catch block
        }
        return lllllllllllllllllIIlIIIIllIIIIII;
    }

    @Override
    public void setup() {
        NameTags lllllllllllllllllIIlIIIlIlIIlIll;
        lllllllllllllllllIIlIIIlIlIIlIll.armor = lllllllllllllllllIIlIIIlIlIIlIll.registerB("Armor", true);
        lllllllllllllllllIIlIIIlIlIIlIll.health = lllllllllllllllllIIlIIIlIlIIlIll.registerB("Health", true);
        lllllllllllllllllIIlIIIlIlIIlIll.ping = lllllllllllllllllIIlIIIlIlIIlIll.registerB("Ping", true);
        lllllllllllllllllIIlIIIlIlIIlIll.gamemode = lllllllllllllllllIIlIIIlIlIIlIll.registerB("Gamemode", true);
        lllllllllllllllllIIlIIIlIlIIlIll.durability = lllllllllllllllllIIlIIIlIlIIlIll.registerB("Durability", true);
        lllllllllllllllllIIlIIIlIlIIlIll.itemname = lllllllllllllllllIIlIIIlIlIIlIll.registerB("ItemName", true);
        lllllllllllllllllIIlIIIlIlIIlIll.scaling = lllllllllllllllllIIlIIIlIlIIlIll.registerD("Scaling", 3.5, 1.0, 5.0);
        lllllllllllllllllIIlIIIlIlIIlIll.colorOutline = lllllllllllllllllIIlIIIlIlIIlIll.registerB("Color Outline", false);
        lllllllllllllllllIIlIIIlIlIIlIll.rainbow = lllllllllllllllllIIlIIIlIlIIlIll.registerB("Rainbow", true);
        lllllllllllllllllIIlIIIlIlIIlIll.r = lllllllllllllllllIIlIIIlIlIIlIll.registerI("Red", 255, 0, 255);
        lllllllllllllllllIIlIIIlIlIIlIll.g = lllllllllllllllllIIlIIIlIlIIlIll.registerI("Green", 0, 0, 255);
        lllllllllllllllllIIlIIIlIlIIlIll.b = lllllllllllllllllIIlIIIlIlIIlIll.registerI("Blue", 0, 0, 255);
    }

    public int getColor() {
        int lllllllllllllllllIIlIIIIIllIIlIl = 4251856;
        return lllllllllllllllllIIlIIIIIllIIlIl;
    }

    private double interpolate(double lllllllllllllllllIIlIIIIIlIlIlIl, double lllllllllllllllllIIlIIIIIlIlIlll, float lllllllllllllllllIIlIIIIIlIlIllI) {
        return lllllllllllllllllIIlIIIIIlIlIlIl + (lllllllllllllllllIIlIIIIIlIlIlll - lllllllllllllllllIIlIIIIIlIlIlIl) * (double)lllllllllllllllllIIlIIIIIlIlIllI;
    }

    private void renderEnchantmentText(ItemStack lllllllllllllllllIIlIIIIlIIlIllI, int lllllllllllllllllIIlIIIIlIIlIlIl, int lllllllllllllllllIIlIIIIlIIlIlII) {
        NBTTagList lllllllllllllllllIIlIIIIlIIllIII;
        NameTags lllllllllllllllllIIlIIIIlIIlIIlI;
        int lllllllllllllllllIIlIIIIlIIlIIll = lllllllllllllllllIIlIIIIlIIlIlII;
        if ((lllllllllllllllllIIlIIIIlIIlIllI.getItem() instanceof ItemArmor || lllllllllllllllllIIlIIIIlIIlIllI.getItem() instanceof ItemSword || lllllllllllllllllIIlIIIIlIIlIllI.getItem() instanceof ItemTool || lllllllllllllllllIIlIIIIlIIlIllI.getItem() instanceof ItemElytra) && lllllllllllllllllIIlIIIIlIIlIIlI.durability.getValue()) {
            int lllllllllllllllllIIlIIIIlIIllllI = (int)(((float)lllllllllllllllllIIlIIIIlIIlIllI.getMaxDamage() - (float)lllllllllllllllllIIlIIIIlIIlIllI.getItemDamage()) / (float)lllllllllllllllllIIlIIIIlIIlIllI.getMaxDamage() * 100.0f);
            ImpactPlus.CustomFont3.drawString(String.valueOf(lllllllllllllllllIIlIIIIlIIllllI), lllllllllllllllllIIlIIIIlIIlIlIl * 2, lllllllllllllllllIIlIIIIlIIlIlII - 10 - 4, lllllllllllllllllIIlIIIIlIIlIllI.getItem().getRGBDurabilityForDisplay(lllllllllllllllllIIlIIIIlIIlIllI));
        }
        if (lllllllllllllllllIIlIIIIlIIlIllI.getItem() != null && !(lllllllllllllllllIIlIIIIlIIlIllI.getItem() instanceof ItemAir) && (lllllllllllllllllIIlIIIIlIIllIII = lllllllllllllllllIIlIIIIlIIlIllI.getEnchantmentTagList()) != null) {
            for (int lllllllllllllllllIIlIIIIlIIllIIl = 0; lllllllllllllllllIIlIIIIlIIllIIl < lllllllllllllllllIIlIIIIlIIllIII.tagCount(); ++lllllllllllllllllIIlIIIIlIIllIIl) {
                String lllllllllllllllllIIlIIIIlIIlllIl;
                short lllllllllllllllllIIlIIIIlIIlllII = lllllllllllllllllIIlIIIIlIIllIII.getCompoundTagAt(lllllllllllllllllIIlIIIIlIIllIIl).getShort("id");
                short lllllllllllllllllIIlIIIIlIIllIll = lllllllllllllllllIIlIIIIlIIllIII.getCompoundTagAt(lllllllllllllllllIIlIIIIlIIllIIl).getShort("lvl");
                Enchantment lllllllllllllllllIIlIIIIlIIllIlI = Enchantment.func_185262_c((int)lllllllllllllllllIIlIIIIlIIlllII);
                if (lllllllllllllllllIIlIIIIlIIllIlI == null) continue;
                String string = lllllllllllllllllIIlIIIIlIIlllIl = lllllllllllllllllIIlIIIIlIIllIlI.func_190936_d() ? lllllllllllllllllIIlIIIIlIIllIlI.getTranslatedName((int)lllllllllllllllllIIlIIIIlIIllIll).substring(11).substring(0, 1).toLowerCase() : lllllllllllllllllIIlIIIIlIIllIlI.getTranslatedName((int)lllllllllllllllllIIlIIIIlIIllIll).substring(0, 3).toLowerCase();
                if (!String.valueOf(lllllllllllllllllIIlIIIIlIIllIll).equalsIgnoreCase("1") && !lllllllllllllllllIIlIIIIlIIllIlI.func_190936_d()) {
                    lllllllllllllllllIIlIIIIlIIlllIl = String.valueOf(new StringBuilder().append(lllllllllllllllllIIlIIIIlIIllIlI.getTranslatedName((int)lllllllllllllllllIIlIIIIlIIllIll).substring(0, 2).toLowerCase()).append(String.valueOf(lllllllllllllllllIIlIIIIlIIllIll)));
                } else if (String.valueOf(lllllllllllllllllIIlIIIIlIIllIll).equalsIgnoreCase("1") && !lllllllllllllllllIIlIIIIlIIllIlI.func_190936_d()) {
                    lllllllllllllllllIIlIIIIlIIlllIl = lllllllllllllllllIIlIIIIlIIllIlI.getTranslatedName((int)lllllllllllllllllIIlIIIIlIIllIll).substring(0, 3).toLowerCase();
                }
                if (lllllllllllllllllIIlIIIIlIIllIlI.func_190936_d()) {
                    lllllllllllllllllIIlIIIIlIIlllIl = String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("Van"));
                }
                lllllllllllllllllIIlIIIIlIIlllIl = String.valueOf(new StringBuilder().append(lllllllllllllllllIIlIIIIlIIlllIl.substring(0, 1).toUpperCase()).append(lllllllllllllllllIIlIIIIlIIlllIl.substring(1)));
                ImpactPlus.CustomFont3.drawString(lllllllllllllllllIIlIIIIlIIlllIl, lllllllllllllllllIIlIIIIlIIlIlIl * 2, lllllllllllllllllIIlIIIIlIIlIIll, -1);
                lllllllllllllllllIIlIIIIlIIlIIll += 14;
            }
        }
        if (lllllllllllllllllIIlIIIIlIIlIllI.getItem() == Items.golden_apple && lllllllllllllllllIIlIIIIlIIlIllI.hasEffect()) {
            ImpactPlus.CustomFont3.drawString("God", lllllllllllllllllIIlIIIIlIIlIlIl * 2, lllllllllllllllllIIlIIIIlIIlIIll, -6416384);
        }
    }

    public static void drawBorderedRect(double lllllllllllllllllIIlIIIIlllIIlIl, double lllllllllllllllllIIlIIIIlllIIlII, double lllllllllllllllllIIlIIIIlllIlIlI, double lllllllllllllllllIIlIIIIlllIlIIl, double lllllllllllllllllIIlIIIIlllIIIIl, int lllllllllllllllllIIlIIIIlllIIlll, int lllllllllllllllllIIlIIIIllIlllll) {
        NameTags.enableGL2D();
        NameTags.fakeGuiRect(lllllllllllllllllIIlIIIIlllIIlIl + lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIIlII + lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIlIlI - lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIlIIl - lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIIlll);
        NameTags.fakeGuiRect(lllllllllllllllllIIlIIIIlllIIlIl + lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIIlII, lllllllllllllllllIIlIIIIlllIlIlI - lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIIlII + lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIllIlllll);
        NameTags.fakeGuiRect(lllllllllllllllllIIlIIIIlllIIlIl, lllllllllllllllllIIlIIIIlllIIlII, lllllllllllllllllIIlIIIIlllIIlIl + lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIlIIl, lllllllllllllllllIIlIIIIllIlllll);
        NameTags.fakeGuiRect(lllllllllllllllllIIlIIIIlllIlIlI - lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIIlII, lllllllllllllllllIIlIIIIlllIlIlI, lllllllllllllllllIIlIIIIlllIlIIl, lllllllllllllllllIIlIIIIllIlllll);
        NameTags.fakeGuiRect(lllllllllllllllllIIlIIIIlllIIlIl + lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIlIIl - lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIlIlI - lllllllllllllllllIIlIIIIlllIIIIl, lllllllllllllllllIIlIIIIlllIlIIl, lllllllllllllllllIIlIIIIllIlllll);
        NameTags.disableGL2D();
    }

    public static void enableGL2D() {
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }

    public int getEnchantSpace(ArrayList<ItemStack> lllllllllllllllllIIlIIIIllIlIlII) {
        int lllllllllllllllllIIlIIIIllIlIlIl = 0;
        for (ItemStack lllllllllllllllllIIlIIIIllIllIII : lllllllllllllllllIIlIIIIllIlIlII) {
            NBTTagList lllllllllllllllllIIlIIIIllIllIIl = lllllllllllllllllIIlIIIIllIllIII.getEnchantmentTagList();
            if (lllllllllllllllllIIlIIIIllIllIIl == null || lllllllllllllllllIIlIIIIllIllIIl.tagCount() <= lllllllllllllllllIIlIIIIllIlIlIl) continue;
            lllllllllllllllllIIlIIIIllIlIlIl = lllllllllllllllllIIlIIIIllIllIIl.tagCount();
        }
        return lllllllllllllllllIIlIIIIllIlIlIl * 18;
    }

    public static void fakeGuiRect(double lllllllllllllllllIIlIIIIIlIIIlIl, double lllllllllllllllllIIlIIIIIIlllIIl, double lllllllllllllllllIIlIIIIIIlllIII, double lllllllllllllllllIIlIIIIIlIIIIlI, int lllllllllllllllllIIlIIIIIIllIllI) {
        if (lllllllllllllllllIIlIIIIIlIIIlIl < lllllllllllllllllIIlIIIIIIlllIII) {
            double lllllllllllllllllIIlIIIIIlIIIlll = lllllllllllllllllIIlIIIIIlIIIlIl;
            lllllllllllllllllIIlIIIIIlIIIlIl = lllllllllllllllllIIlIIIIIIlllIII;
            lllllllllllllllllIIlIIIIIIlllIII = lllllllllllllllllIIlIIIIIlIIIlll;
        }
        if (lllllllllllllllllIIlIIIIIIlllIIl < lllllllllllllllllIIlIIIIIlIIIIlI) {
            double lllllllllllllllllIIlIIIIIlIIIllI = lllllllllllllllllIIlIIIIIIlllIIl;
            lllllllllllllllllIIlIIIIIIlllIIl = lllllllllllllllllIIlIIIIIlIIIIlI;
            lllllllllllllllllIIlIIIIIlIIIIlI = lllllllllllllllllIIlIIIIIlIIIllI;
        }
        float lllllllllllllllllIIlIIIIIlIIIIII = (float)(lllllllllllllllllIIlIIIIIIllIllI >> 24 & 0xFF) / 255.0f;
        float lllllllllllllllllIIlIIIIIIllllll = (float)(lllllllllllllllllIIlIIIIIIllIllI >> 16 & 0xFF) / 255.0f;
        float lllllllllllllllllIIlIIIIIIlllllI = (float)(lllllllllllllllllIIlIIIIIIllIllI >> 8 & 0xFF) / 255.0f;
        float lllllllllllllllllIIlIIIIIIllllIl = (float)(lllllllllllllllllIIlIIIIIIllIllI & 0xFF) / 255.0f;
        Tessellator lllllllllllllllllIIlIIIIIIllllII = Tessellator.getInstance();
        BufferBuilder lllllllllllllllllIIlIIIIIIlllIll = lllllllllllllllllIIlIIIIIIllllII.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.color((float)lllllllllllllllllIIlIIIIIIllllll, (float)lllllllllllllllllIIlIIIIIIlllllI, (float)lllllllllllllllllIIlIIIIIIllllIl, (float)lllllllllllllllllIIlIIIIIlIIIIII);
        lllllllllllllllllIIlIIIIIIlllIll.begin(7, DefaultVertexFormats.POSITION);
        lllllllllllllllllIIlIIIIIIlllIll.pos(lllllllllllllllllIIlIIIIIlIIIlIl, lllllllllllllllllIIlIIIIIlIIIIlI, 0.0).endVertex();
        lllllllllllllllllIIlIIIIIIlllIll.pos(lllllllllllllllllIIlIIIIIIlllIII, lllllllllllllllllIIlIIIIIlIIIIlI, 0.0).endVertex();
        lllllllllllllllllIIlIIIIIIlllIll.pos(lllllllllllllllllIIlIIIIIIlllIII, lllllllllllllllllIIlIIIIIIlllIIl, 0.0).endVertex();
        lllllllllllllllllIIlIIIIIIlllIll.pos(lllllllllllllllllIIlIIIIIlIIIlIl, lllllllllllllllllIIlIIIIIIlllIIl, 0.0).endVertex();
        lllllllllllllllllIIlIIIIIIllllII.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    private void renderItemStack(ArrayList<ItemStack> lllllllllllllllllIIlIIIIlIllIlIl, ItemStack lllllllllllllllllIIlIIIIlIllIlII, int lllllllllllllllllIIlIIIIlIllIIll, int lllllllllllllllllIIlIIIIlIllIIlI) {
        NameTags lllllllllllllllllIIlIIIIlIllIllI;
        int lllllllllllllllllIIlIIIIlIllIIIl = 2 - lllllllllllllllllIIlIIIIlIllIllI.getEnchantSpace(lllllllllllllllllIIlIIIIlIllIlIl) - 24;
        int lllllllllllllllllIIlIIIIlIllIIII = 2 - lllllllllllllllllIIlIIIIlIllIllI.getEnchantSpace(lllllllllllllllllIIlIIIIlIllIlIl) / 2 - 14;
        if (lllllllllllllllllIIlIIIIlIllIIII >= -26) {
            lllllllllllllllllIIlIIIIlIllIIII = -26;
        }
        if (lllllllllllllllllIIlIIIIlIllIIIl >= -50) {
            lllllllllllllllllIIlIIIIlIllIIIl = -50;
        }
        GlStateManager.pushMatrix();
        GlStateManager.depthMask((boolean)true);
        GlStateManager.clear((int)256);
        RenderHelper.enableStandardItemLighting();
        NameTags.mc.getRenderItem().zLevel = -150.0f;
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        GlStateManager.disableLighting();
        GlStateManager.disableDepth();
        GlStateManager.disableAlpha();
        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.enableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableAlpha();
        GlStateManager.enableLighting();
        GlStateManager.enableDepth();
        mc.getRenderItem().renderItemAndEffectIntoGUI(lllllllllllllllllIIlIIIIlIllIlII, lllllllllllllllllIIlIIIIlIllIIll, lllllllllllllllllIIlIIIIlIllIIII);
        mc.getRenderItem().renderItemOverlays(NameTags.mc.fontRendererObj, lllllllllllllllllIIlIIIIlIllIlII, lllllllllllllllllIIlIIIIlIllIIll, lllllllllllllllllIIlIIIIlIllIIII);
        NameTags.mc.getRenderItem().zLevel = 0.0f;
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableCull();
        GlStateManager.enableAlpha();
        GlStateManager.disableBlend();
        GlStateManager.disableLighting();
        GlStateManager.scale((float)0.5f, (float)0.5f, (float)0.5f);
        GlStateManager.disableDepth();
        lllllllllllllllllIIlIIIIlIllIllI.renderEnchantmentText(lllllllllllllllllIIlIIIIlIllIlII, lllllllllllllllllIIlIIIIlIllIIll, lllllllllllllllllIIlIIIIlIllIIIl);
        GlStateManager.enableDepth();
        GlStateManager.scale((float)2.0f, (float)2.0f, (float)2.0f);
        GlStateManager.popMatrix();
    }

    private String getDisplayName(EntityPlayer lllllllllllllllllIIlIIIIIllIllll) {
        float lllllllllllllllllIIlIIIIIlllIIlI;
        int lllllllllllllllllIIlIIIIIlllIIIl;
        TextFormatting lllllllllllllllllIIlIIIIIlllIlll;
        NameTags lllllllllllllllllIIlIIIIIlllIIII;
        String lllllllllllllllllIIlIIIIIlllIllI = lllllllllllllllllIIlIIIIIllIllll.getDisplayName().getFormattedText();
        if (!lllllllllllllllllIIlIIIIIlllIIII.health.getValue()) {
            return lllllllllllllllllIIlIIIIIlllIllI;
        }
        float lllllllllllllllllIIlIIIIIlllIlIl = lllllllllllllllllIIlIIIIIllIllll.getHealth() + lllllllllllllllllIIlIIIIIllIllll.getAbsorptionAmount();
        if (lllllllllllllllllIIlIIIIIlllIlIl <= 0.0f) {
            lllllllllllllllllIIlIIIIIlllIlIl = 1.0f;
        }
        if (lllllllllllllllllIIlIIIIIlllIlIl > 18.0f) {
            TextFormatting lllllllllllllllllIIlIIIIIllllllI = TextFormatting.GREEN;
        } else if (lllllllllllllllllIIlIIIIIlllIlIl > 16.0f) {
            TextFormatting lllllllllllllllllIIlIIIIIlllllIl = TextFormatting.DARK_GREEN;
        } else if (lllllllllllllllllIIlIIIIIlllIlIl > 12.0f) {
            TextFormatting lllllllllllllllllIIlIIIIIlllllII = TextFormatting.YELLOW;
        } else if (lllllllllllllllllIIlIIIIIlllIlIl > 8.0f) {
            TextFormatting lllllllllllllllllIIlIIIIIllllIll = TextFormatting.GOLD;
        } else if (lllllllllllllllllIIlIIIIIlllIlIl > 5.0f) {
            TextFormatting lllllllllllllllllIIlIIIIIllllIlI = TextFormatting.RED;
        } else {
            lllllllllllllllllIIlIIIIIlllIlll = TextFormatting.DARK_RED;
        }
        String lllllllllllllllllIIlIIIIIlllIlII = "";
        String lllllllllllllllllIIlIIIIIlllIIll = "";
        if (lllllllllllllllllIIlIIIIIlllIIII.gamemode.getValue()) {
            lllllllllllllllllIIlIIIIIlllIlII = String.valueOf(new StringBuilder().append(lllllllllllllllllIIlIIIIIlllIlII).append(" [").append(lllllllllllllllllIIlIIIIIlllIIII.getGMText(lllllllllllllllllIIlIIIIIllIllll)).append("]"));
        }
        if (lllllllllllllllllIIlIIIIIlllIIII.ping.getValue()) {
            lllllllllllllllllIIlIIIIIlllIIll = String.valueOf(new StringBuilder().append(lllllllllllllllllIIlIIIIIlllIIll).append(" ").append(String.valueOf(lllllllllllllllllIIlIIIIIlllIIII.getPing(lllllllllllllllllIIlIIIIIllIllll))).append("ms"));
        }
        if ((lllllllllllllllllIIlIIIIIlllIIIl = (int)Math.ceil(lllllllllllllllllIIlIIIIIlllIIlI = lllllllllllllllllIIlIIIIIllIllll.getHealth() + lllllllllllllllllIIlIIIIIllIllll.getAbsorptionAmount())) <= 0) {
            lllllllllllllllllIIlIIIIIlllIIIl = 1;
        }
        lllllllllllllllllIIlIIIIIlllIllI = String.valueOf(new StringBuilder().append(lllllllllllllllllIIlIIIIIlllIllI).append(lllllllllllllllllIIlIIIIIlllIlII).append(lllllllllllllllllIIlIIIIIlllIIll).append(lllllllllllllllllIIlIIIIIlllIlll).append(" ").append(String.valueOf(lllllllllllllllllIIlIIIIIlllIIIl)));
        return lllllllllllllllllIIlIIIIIlllIllI;
    }

    public NameTags() {
        super("NameTags", Module.Category.RENDER);
        NameTags lllllllllllllllllIIlIIIlIlIIlllI;
    }

    @Override
    public void onWorldRender(RenderEvent lllllllllllllllllIIlIIIlIIlllIlI) {
        NameTags lllllllllllllllllIIlIIIlIIlllIll;
        lllllllllllllllllIIlIIIlIIlllIll.obbyred = 0;
        lllllllllllllllllIIlIIIlIIlllIll.obbygreen = 0;
        lllllllllllllllllIIlIIIlIIlllIll.obbyblue = 0;
        lllllllllllllllllIIlIIIlIIlllIll.obbyblue = 0;
        if (lllllllllllllllllIIlIIIlIIlllIll.rainbow.getValue()) {
            lllllllllllllllllIIlIIIlIIlllIll.obbyred = Rainbow.getColor().getRed();
            lllllllllllllllllIIlIIIlIIlllIll.obbygreen = Rainbow.getColor().getGreen();
            lllllllllllllllllIIlIIIlIIlllIll.obbyblue = Rainbow.getColor().getBlue();
            lllllllllllllllllIIlIIIlIIlllIll.a = 255;
        } else {
            lllllllllllllllllIIlIIIlIIlllIll.obbyred = lllllllllllllllllIIlIIIlIIlllIll.r.getValue();
            lllllllllllllllllIIlIIIlIIlllIll.obbygreen = lllllllllllllllllIIlIIIlIIlllIll.g.getValue();
            lllllllllllllllllIIlIIIlIIlllIll.obbyblue = lllllllllllllllllIIlIIIlIIlllIll.b.getValue();
            lllllllllllllllllIIlIIIlIIlllIll.a = 255;
        }
        for (Object lllllllllllllllllIIlIIIlIIlllllI : NameTags.mc.theWorld.playerEntities) {
            Entity lllllllllllllllllIIlIIIlIIllllll = (Entity)lllllllllllllllllIIlIIIlIIlllllI;
            if (!(lllllllllllllllllIIlIIIlIIllllll instanceof EntityPlayer) || !lllllllllllllllllIIlIIIlIIllllll.isEntityAlive()) continue;
            double lllllllllllllllllIIlIIIlIlIIIIlI = lllllllllllllllllIIlIIIlIIlllIll.interpolate(lllllllllllllllllIIlIIIlIIllllll.lastTickPosX, lllllllllllllllllIIlIIIlIIllllll.posX, lllllllllllllllllIIlIIIlIIlllIlI.getPartialTicks()) - NameTags.mc.getRenderManager().renderPosX;
            double lllllllllllllllllIIlIIIlIlIIIIIl = lllllllllllllllllIIlIIIlIIlllIll.interpolate(lllllllllllllllllIIlIIIlIIllllll.lastTickPosY, lllllllllllllllllIIlIIIlIIllllll.posY, lllllllllllllllllIIlIIIlIIlllIlI.getPartialTicks()) - NameTags.mc.getRenderManager().renderPosY;
            double lllllllllllllllllIIlIIIlIlIIIIII = lllllllllllllllllIIlIIIlIIlllIll.interpolate(lllllllllllllllllIIlIIIlIIllllll.lastTickPosZ, lllllllllllllllllIIlIIIlIIllllll.posZ, lllllllllllllllllIIlIIIlIIlllIlI.getPartialTicks()) - NameTags.mc.getRenderManager().renderPosZ;
            if (NameTags.mc.thePlayer == lllllllllllllllllIIlIIIlIIllllll) continue;
            lllllllllllllllllIIlIIIlIIlllIll.renderNameTag((EntityPlayer)lllllllllllllllllIIlIIIlIIllllll, lllllllllllllllllIIlIIIlIlIIIIlI, lllllllllllllllllIIlIIIlIlIIIIIl, lllllllllllllllllIIlIIIlIlIIIIII, lllllllllllllllllIIlIIIlIIlllIlI.getPartialTicks());
        }
    }

    public String getGMText(EntityPlayer lllllllllllllllllIIlIIIIllIIIlll) {
        if (lllllllllllllllllIIlIIIIllIIIlll.func_184812_l_()) {
            return "C";
        }
        if (lllllllllllllllllIIlIIIIllIIIlll.isSpectator()) {
            return "I";
        }
        if (!lllllllllllllllllIIlIIIIllIIIlll.isAllowEdit() && !lllllllllllllllllIIlIIIIllIIIlll.isSpectator()) {
            return "A";
        }
        if (!lllllllllllllllllIIlIIIIllIIIlll.func_184812_l_() && !lllllllllllllllllIIlIIIIllIIIlll.isSpectator() && lllllllllllllllllIIlIIIIllIIIlll.isAllowEdit()) {
            return "S";
        }
        return "";
    }

    public int getHighestEncY(ArrayList<ItemStack> lllllllllllllllllIIlIIIIllIIllII) {
        NameTags lllllllllllllllllIIlIIIIllIIlIll;
        return lllllllllllllllllIIlIIIIllIIlIll.getEnchantSpace(lllllllllllllllllIIlIIIIllIIllII);
    }
}

