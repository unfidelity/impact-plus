/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.item.EntityEnderPearl
 *  net.minecraft.util.math.Vec3d
 *  org.lwjgl.opengl.GL11
 */
package me.axua.impactplus.module.modules.render;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

public class PearlViewer
extends Module {
    public /* synthetic */ Setting.d r;
    private /* synthetic */ HashMap<UUID, List<Vec3d>> poses;
    public /* synthetic */ Setting.d b;
    public /* synthetic */ Setting.b chat;
    public /* synthetic */ Setting.d g;
    public /* synthetic */ Setting.i thickness;
    private /* synthetic */ HashMap<UUID, Double> time;
    public /* synthetic */ Setting.b render;
    public /* synthetic */ Setting.i rendertime;

    @Override
    public void setup() {
        PearlViewer llllllllllllllllIIlllllIIIllIIII;
        llllllllllllllllIIlllllIIIllIIII.chat = llllllllllllllllIIlllllIIIllIIII.registerB("Chat", true);
        llllllllllllllllIIlllllIIIllIIII.render = llllllllllllllllIIlllllIIIllIIII.registerB("Render", true);
        llllllllllllllllIIlllllIIIllIIII.rendertime = llllllllllllllllIIlllllIIIllIIII.registerI("RenderTime", 15, 0, 20);
        llllllllllllllllIIlllllIIIllIIII.thickness = llllllllllllllllIIlllllIIIllIIII.registerI("Thickness", 3, 1, 5);
        llllllllllllllllIIlllllIIIllIIII.r = llllllllllllllllIIlllllIIIllIIII.registerD("Red", 0.0, 0.0, 1.0);
        llllllllllllllllIIlllllIIIllIIII.g = llllllllllllllllIIlllllIIIllIIII.registerD("Green", 1.0, 0.0, 1.0);
        llllllllllllllllIIlllllIIIllIIII.b = llllllllllllllllIIlllllIIIllIIII.registerD("Blue", 1.0, 0.0, 1.0);
    }

    public PearlViewer() {
        super("PearlViewer", Module.Category.RENDER, "Shows Where Enderpearls Are Going");
        PearlViewer llllllllllllllllIIlllllIIIllIIll;
        llllllllllllllllIIlllllIIIllIIll.poses = new HashMap();
        llllllllllllllllIIlllllIIIllIIll.time = new HashMap();
    }

    @Override
    public void onUpdate() {
        PearlViewer llllllllllllllllIIlllllIIIlIIllI;
        for (Map.Entry<UUID, Double> llllllllllllllllIIlllllIIIlIlIlI : new HashMap<UUID, Double>(llllllllllllllllIIlllllIIIlIIllI.time).entrySet()) {
            if (llllllllllllllllIIlllllIIIlIlIlI.getValue() <= 0.0) {
                llllllllllllllllIIlllllIIIlIIllI.poses.remove(llllllllllllllllIIlllllIIIlIlIlI.getKey());
                llllllllllllllllIIlllllIIIlIIllI.time.remove(llllllllllllllllIIlllllIIIlIlIlI.getKey());
                continue;
            }
            llllllllllllllllIIlllllIIIlIIllI.time.replace(llllllllllllllllIIlllllIIIlIlIlI.getKey(), llllllllllllllllIIlllllIIIlIlIlI.getValue() - 0.05);
        }
        for (Entity llllllllllllllllIIlllllIIIlIIlll : PearlViewer.mc.theWorld.loadedEntityList) {
            if (!(llllllllllllllllIIlllllIIIlIIlll instanceof EntityEnderPearl)) continue;
            if (!llllllllllllllllIIlllllIIIlIIllI.poses.containsKey(llllllllllllllllIIlllllIIIlIIlll.getUniqueID())) {
                if (llllllllllllllllIIlllllIIIlIIllI.chat.getValue()) {
                    for (Entity llllllllllllllllIIlllllIIIlIlIIl : PearlViewer.mc.theWorld.playerEntities) {
                        if (!(llllllllllllllllIIlllllIIIlIlIIl.getDistanceToEntity(llllllllllllllllIIlllllIIIlIIlll) < 4.0f) || llllllllllllllllIIlllllIIIlIlIIl.getName() == PearlViewer.mc.thePlayer.getName()) continue;
                        Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.DARK_AQUA).append(llllllllllllllllIIlllllIIIlIlIIl.getName()).append(ChatFormatting.AQUA).append(" just threw a pearl")));
                        break;
                    }
                }
                llllllllllllllllIIlllllIIIlIIllI.poses.put(llllllllllllllllIIlllllIIIlIIlll.getUniqueID(), new ArrayList<Vec3d>(Arrays.asList(llllllllllllllllIIlllllIIIlIIlll.getPositionVector())));
                llllllllllllllllIIlllllIIIlIIllI.time.put(llllllllllllllllIIlllllIIIlIIlll.getUniqueID(), Double.valueOf(llllllllllllllllIIlllllIIIlIIllI.rendertime.getValue()));
                continue;
            }
            llllllllllllllllIIlllllIIIlIIllI.time.replace(llllllllllllllllIIlllllIIIlIIlll.getUniqueID(), Double.valueOf(llllllllllllllllIIlllllIIIlIIllI.rendertime.getValue()));
            List<Vec3d> llllllllllllllllIIlllllIIIlIlIII = llllllllllllllllIIlllllIIIlIIllI.poses.get(llllllllllllllllIIlllllIIIlIIlll.getUniqueID());
            llllllllllllllllIIlllllIIIlIlIII.add(llllllllllllllllIIlllllIIIlIIlll.getPositionVector());
        }
    }

    @Override
    public void onWorldRender(RenderEvent llllllllllllllllIIlllllIIIIlIIll) {
        PearlViewer llllllllllllllllIIlllllIIIIlIIlI;
        if (!llllllllllllllllIIlllllIIIIlIIlI.render.getValue()) {
            return;
        }
        GL11.glLineWidth((float)llllllllllllllllIIlllllIIIIlIIlI.thickness.getValue());
        for (Map.Entry<UUID, List<Vec3d>> llllllllllllllllIIlllllIIIIlIlIl : llllllllllllllllIIlllllIIIIlIIlI.poses.entrySet()) {
            if (llllllllllllllllIIlllllIIIIlIlIl.getValue().size() <= 2) continue;
            GL11.glPushMatrix();
            GL11.glDisable((int)3553);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)2848);
            GL11.glDisable((int)2929);
            PearlViewer.mc.entityRenderer.disableLightmap();
            GL11.glBegin((int)3);
            GL11.glColor3d((double)llllllllllllllllIIlllllIIIIlIIlI.r.getValue(), (double)llllllllllllllllIIlllllIIIIlIIlI.g.getValue(), (double)llllllllllllllllIIlllllIIIIlIIlI.b.getValue());
            double llllllllllllllllIIlllllIIIIllIII = PearlViewer.mc.getRenderManager().viewerPosX;
            double llllllllllllllllIIlllllIIIIlIlll = PearlViewer.mc.getRenderManager().viewerPosY;
            double llllllllllllllllIIlllllIIIIlIllI = PearlViewer.mc.getRenderManager().viewerPosZ;
            for (int llllllllllllllllIIlllllIIIIllIIl = 1; llllllllllllllllIIlllllIIIIllIIl < llllllllllllllllIIlllllIIIIlIlIl.getValue().size(); ++llllllllllllllllIIlllllIIIIllIIl) {
                GL11.glVertex3d((double)(llllllllllllllllIIlllllIIIIlIlIl.getValue().get((int)llllllllllllllllIIlllllIIIIllIIl).xCoord - llllllllllllllllIIlllllIIIIllIII), (double)(llllllllllllllllIIlllllIIIIlIlIl.getValue().get((int)llllllllllllllllIIlllllIIIIllIIl).yCoord - llllllllllllllllIIlllllIIIIlIlll), (double)(llllllllllllllllIIlllllIIIIlIlIl.getValue().get((int)llllllllllllllllIIlllllIIIIllIIl).zCoord - llllllllllllllllIIlllllIIIIlIllI));
                GL11.glVertex3d((double)(llllllllllllllllIIlllllIIIIlIlIl.getValue().get((int)(llllllllllllllllIIlllllIIIIllIIl - 1)).xCoord - llllllllllllllllIIlllllIIIIllIII), (double)(llllllllllllllllIIlllllIIIIlIlIl.getValue().get((int)(llllllllllllllllIIlllllIIIIllIIl - 1)).yCoord - llllllllllllllllIIlllllIIIIlIlll), (double)(llllllllllllllllIIlllllIIIIlIlIl.getValue().get((int)(llllllllllllllllIIlllllIIIIllIIl - 1)).zCoord - llllllllllllllllIIlllllIIIIlIllI));
            }
            GL11.glColor4d((double)1.0, (double)1.0, (double)1.0, (double)1.0);
            GL11.glEnd();
            GL11.glEnable((int)2929);
            GL11.glDisable((int)2848);
            GL11.glEnable((int)3553);
            GL11.glPopMatrix();
        }
        Tessellator.prepare(7);
        Tessellator.release();
    }
}

