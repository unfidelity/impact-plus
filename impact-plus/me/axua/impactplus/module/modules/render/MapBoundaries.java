/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.MathHelper
 */
package me.axua.impactplus.module.modules.render;

import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.render.KamiTessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;

public class MapBoundaries
extends Module {
    public /* synthetic */ Setting.i green;
    public /* synthetic */ Setting.i blue;
    public /* synthetic */ Setting.i red;
    public /* synthetic */ Setting.b rainbow;

    public MapBoundaries() {
        super("MapBoundaries", Module.Category.RENDER, "MapBoundaries");
        MapBoundaries lllIlIIIlIIlIl;
    }

    @Override
    public void onWorldRender(RenderEvent lllIIlllllIlII) {
        MapBoundaries lllIIlllllIlIl;
        Minecraft lllIIlllllIIll = Minecraft.getMinecraft();
        float lllIIlllllIIlI = lllIIlllllIlII.getPartialTicks();
        EntityPlayerSP lllIIlllllIIIl = lllIIlllllIIll.thePlayer;
        double lllIIlllllIIII = lllIIlllllIIIl.lastTickPosX + (lllIIlllllIIIl.posX - lllIIlllllIIIl.lastTickPosX) * (double)lllIIlllllIIlI;
        double lllIIllllIllll = lllIIlllllIIIl.lastTickPosY + (lllIIlllllIIIl.posY - lllIIlllllIIIl.lastTickPosY) * (double)lllIIlllllIIlI;
        double lllIIllllIlllI = lllIIlllllIIIl.lastTickPosZ + (lllIIlllllIIIl.posZ - lllIIlllllIIIl.lastTickPosZ) * (double)lllIIlllllIIlI;
        int lllIIllllIllIl = MathHelper.floor_double((double)((lllIIlllllIIII + 64.0) / 128.0)) * 128;
        int lllIIllllIllII = MathHelper.floor_double((double)((lllIIllllIlllI + 64.0) / 128.0)) * 128;
        double lllIIllllIlIll = (double)(lllIIllllIllIl - 64) - lllIIlllllIIll.getRenderManager().viewerPosX;
        double lllIIllllIlIlI = (double)(lllIIllllIllII - 64) - lllIIlllllIIll.getRenderManager().viewerPosZ;
        AxisAlignedBB lllIIllllIlIIl = new AxisAlignedBB(lllIIllllIlIll, -lllIIlllllIIll.getRenderManager().viewerPosY, lllIIllllIlIlI, lllIIllllIlIll + 128.0, 256.0 - lllIIlllllIIll.getRenderManager().viewerPosY, lllIIllllIlIlI + 128.0);
        KamiTessellator.prepare(1);
        if (lllIIlllllIlIl.rainbow.getValue()) {
            KamiTessellator.drawLines(KamiTessellator.getBufferBuilder(), (float)lllIIllllIlIll, (float)(-lllIIlllllIIll.getRenderManager().viewerPosY), (float)lllIIllllIlIlI, 128.0f, 255.0f, 128.0f, Rainbow.getColor().getRed(), Rainbow.getColor().getGreen(), Rainbow.getColor().getBlue(), 255, 63);
        } else {
            KamiTessellator.drawLines(KamiTessellator.getBufferBuilder(), (float)lllIIllllIlIll, (float)(-lllIIlllllIIll.getRenderManager().viewerPosY), (float)lllIIllllIlIlI, 128.0f, 255.0f, 128.0f, lllIIlllllIlIl.red.getValue(), lllIIlllllIlIl.green.getValue(), lllIIlllllIlIl.blue.getValue(), 255, 63);
        }
        KamiTessellator.release();
    }

    @Override
    public void setup() {
        MapBoundaries lllIlIIIIlIllI;
        lllIlIIIIlIllI.red = lllIlIIIIlIllI.registerI("Red", 0, 0, 255);
        lllIlIIIIlIllI.green = lllIlIIIIlIllI.registerI("Green", 0, 0, 255);
        lllIlIIIIlIllI.blue = lllIlIIIIlIllI.registerI("Blue", 0, 0, 255);
        lllIlIIIIlIllI.rainbow = lllIlIIIIlIllI.registerB("Rainbow", true);
    }
}

