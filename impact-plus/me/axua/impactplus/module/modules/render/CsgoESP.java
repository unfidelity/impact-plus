/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityAgeable
 *  net.minecraft.entity.EnumCreatureType
 *  net.minecraft.entity.item.EntityEnderCrystal
 *  net.minecraft.entity.item.EntityExpBottle
 *  net.minecraft.entity.item.EntityItem
 *  net.minecraft.entity.item.EntityXPOrb
 *  net.minecraft.entity.monster.EntityIronGolem
 *  net.minecraft.entity.passive.EntityAmbientCreature
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.passive.EntitySquid
 *  net.minecraft.entity.passive.EntityTameable
 *  net.minecraft.entity.passive.EntityWolf
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.module.modules.render;

import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class CsgoESP
extends Module {
    /* synthetic */ Setting.b monsters;
    /* synthetic */ Setting.b items;
    /* synthetic */ Setting.b passive;
    /* synthetic */ Setting.b crystals;
    /* synthetic */ Setting.b xpBottles;
    /* synthetic */ Setting.b players;
    /* synthetic */ Setting.b orbs;

    public static boolean isMonster(Entity lllllllllllllllllIlIIllIIIIllIII) {
        return lllllllllllllllllIlIIllIIIIllIII.isCreatureType(EnumCreatureType.MONSTER, false);
    }

    public CsgoESP() {
        super("CsgoESP", Module.Category.RENDER);
        CsgoESP lllllllllllllllllIlIIllIIlIlIIII;
    }

    @Override
    public void onWorldRender(RenderEvent lllllllllllllllllIlIIllIIIlIIIlI) {
        CsgoESP lllllllllllllllllIlIIllIIIlIIIll;
        if (CsgoESP.mc.getRenderManager().options == null) {
            return;
        }
        boolean lllllllllllllllllIlIIllIIIlIIIIl = CsgoESP.mc.getRenderManager().options.thirdPersonView == 2;
        float lllllllllllllllllIlIIllIIIlIIIII = CsgoESP.mc.getRenderManager().playerViewY;
        CsgoESP.mc.theWorld.loadedEntityList.stream().filter(lllllllllllllllllIlIIlIlIllllllI -> CsgoESP.mc.thePlayer != lllllllllllllllllIlIIlIlIllllllI).forEach(lllllllllllllllllIlIIlIllIIIlIII -> {
            CsgoESP lllllllllllllllllIlIIlIllIIIIllI;
            Tessellator.prepareGL();
            GlStateManager.pushMatrix();
            Vec3d lllllllllllllllllIlIIlIllIIIIlll = ImpactPlusTessellator.getInterpolatedPos(lllllllllllllllllIlIIlIllIIIlIII, mc.func_184121_ak());
            GlStateManager.translate((double)(lllllllllllllllllIlIIlIllIIIIlll.xCoord - CsgoESP.mc.getRenderManager().renderPosX), (double)(lllllllllllllllllIlIIlIllIIIIlll.yCoord - CsgoESP.mc.getRenderManager().renderPosY), (double)(lllllllllllllllllIlIIlIllIIIIlll.zCoord - CsgoESP.mc.getRenderManager().renderPosZ));
            GlStateManager.func_187432_a((float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(-lllllllllllllllllIlIIllIIIlIIIII), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.rotate((float)(lllllllllllllllllIlIIllIIIlIIIIl ? -1 : 1), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.5f);
            GL11.glLineWidth((float)3.0f);
            GL11.glEnable((int)2848);
            if (lllllllllllllllllIlIIlIllIIIlIII instanceof EntityPlayer && lllllllllllllllllIlIIlIllIIIIllI.players.getValue()) {
                if (Friends.isFriend(lllllllllllllllllIlIIlIllIIIlIII.getName())) {
                    GL11.glColor4f((float)0.0f, (float)1.0f, (float)1.0f, (float)0.5f);
                } else {
                    GL11.glColor4f((float)1.0f, (float)0.0f, (float)0.0f, (float)0.5f);
                }
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glEnd();
            }
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)0.5f);
            if (CsgoESP.isPassive(lllllllllllllllllIlIIlIllIIIlIII) && lllllllllllllllllIlIIlIllIIIIllI.passive.getValue()) {
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glEnd();
            }
            if (CsgoESP.isMonster(lllllllllllllllllIlIIlIllIIIlIII) && lllllllllllllllllIlIIlIllIIIIllI.monsters.getValue()) {
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glEnd();
            }
            if (lllllllllllllllllIlIIlIllIIIlIII instanceof EntityItem && lllllllllllllllllIlIIlIllIIIIllI.items.getValue()) {
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glEnd();
            }
            if (lllllllllllllllllIlIIlIllIIIlIII instanceof EntityExpBottle && lllllllllllllllllIlIIlIllIIIIllI.xpBottles.getValue()) {
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f), (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)0.0);
                GL11.glVertex2d((double)lllllllllllllllllIlIIlIllIIIlIII.width, (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glEnd();
            }
            if (lllllllllllllllllIlIIlIllIIIlIII instanceof EntityEnderCrystal && lllllllllllllllllIlIIlIllIIIIllI.crystals.getValue()) {
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f / 2.0f), (double)0.0);
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glEnd();
            }
            if (lllllllllllllllllIlIIlIllIIIlIII instanceof EntityXPOrb && lllllllllllllllllIlIIlIllIIIIllI.orbs.getValue()) {
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f / 2.0f), (double)0.0);
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(-lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)lllllllllllllllllIlIIlIllIIIlIII.height);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f * 2.0f));
                GL11.glEnd();
                GL11.glBegin((int)2);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 3.0f * 2.0f / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)0.0);
                GL11.glVertex2d((double)(lllllllllllllllllIlIIlIllIIIlIII.width / 2.0f), (double)(lllllllllllllllllIlIIlIllIIIlIII.height / 3.0f));
                GL11.glEnd();
            }
            Tessellator.releaseGL();
            GlStateManager.popMatrix();
        });
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    @Override
    public void setup() {
        CsgoESP lllllllllllllllllIlIIllIIIlllIIl;
        lllllllllllllllllIlIIllIIIlllIIl.players = lllllllllllllllllIlIIllIIIlllIIl.registerB("Players", true);
        lllllllllllllllllIlIIllIIIlllIIl.passive = lllllllllllllllllIlIIllIIIlllIIl.registerB("Passive", false);
        lllllllllllllllllIlIIllIIIlllIIl.monsters = lllllllllllllllllIlIIllIIIlllIIl.registerB("Monsters", false);
        lllllllllllllllllIlIIllIIIlllIIl.items = lllllllllllllllllIlIIllIIIlllIIl.registerB("Items", false);
        lllllllllllllllllIlIIllIIIlllIIl.crystals = lllllllllllllllllIlIIllIIIlllIIl.registerB("Crystals", false);
        lllllllllllllllllIlIIllIIIlllIIl.xpBottles = lllllllllllllllllIlIIllIIIlllIIl.registerB("XpBottles", false);
        lllllllllllllllllIlIIllIIIlllIIl.orbs = lllllllllllllllllIlIIllIIIlllIIl.registerB("XpOrbs", false);
    }

    public static boolean isPassive(Entity lllllllllllllllllIlIIllIIIIllIll) {
        if (lllllllllllllllllIlIIllIIIIllIll instanceof EntityWolf && ((EntityWolf)lllllllllllllllllIlIIllIIIIllIll).isAngry()) {
            return false;
        }
        if (lllllllllllllllllIlIIllIIIIllIll instanceof EntityAnimal || lllllllllllllllllIlIIllIIIIllIll instanceof EntityAgeable || lllllllllllllllllIlIIllIIIIllIll instanceof EntityTameable || lllllllllllllllllIlIIllIIIIllIll instanceof EntityAmbientCreature || lllllllllllllllllIlIIllIIIIllIll instanceof EntitySquid) {
            return true;
        }
        return lllllllllllllllllIlIIllIIIIllIll instanceof EntityIronGolem && ((EntityIronGolem)lllllllllllllllllIlIIllIIIIllIll).getAITarget() == null;
    }
}

