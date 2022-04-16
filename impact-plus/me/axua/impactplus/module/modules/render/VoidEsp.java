/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.util.internal.ConcurrentSet
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 */
package me.axua.impactplus.module.modules.render;

import io.netty.util.internal.ConcurrentSet;
import java.util.ArrayList;
import java.util.List;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class VoidEsp
extends Module {
    /* synthetic */ int bedred;
    /* synthetic */ Setting.i bedg;
    /* synthetic */ Setting.i bedr;
    /* synthetic */ Setting.i w;
    /* synthetic */ Setting.i bedb;
    /* synthetic */ Setting.mode hmode;
    /* synthetic */ Setting.i renderdis;
    private /* synthetic */ ConcurrentSet<BlockPos> voidHoles;
    /* synthetic */ Setting.i a;
    /* synthetic */ int bedblue;
    /* synthetic */ Setting.b bedrainbow;
    /* synthetic */ int bedgreen;

    public void drawBox(BlockPos lllllllllllllllIllIllIIlIIIIlIlI, int lllllllllllllllIllIllIIlIIIIlIIl, int lllllllllllllllIllIllIIlIIIIlIII, int lllllllllllllllIllIllIIlIIIIllII, int lllllllllllllllIllIllIIlIIIIIllI) {
        Tessellator.prepare(7);
        Tessellator.drawBox(lllllllllllllllIllIllIIlIIIIlIlI, lllllllllllllllIllIllIIlIIIIlIIl, lllllllllllllllIllIllIIlIIIIlIII, lllllllllllllllIllIllIIlIIIIllII, lllllllllllllllIllIllIIlIIIIIllI, 63);
        Tessellator.release();
    }

    public static BlockPos getPlayerPos() {
        return new BlockPos(Math.floor(VoidEsp.mc.thePlayer.posX), Math.floor(VoidEsp.mc.thePlayer.posY), Math.floor(VoidEsp.mc.thePlayer.posZ));
    }

    public void drawboundingBox(BlockPos lllllllllllllllIllIllIIIlllllllI, int lllllllllllllllIllIllIIIllllIlll, int lllllllllllllllIllIllIIIllllIllI, int lllllllllllllllIllIllIIIlllllIll, int lllllllllllllllIllIllIIIllllIlII, int lllllllllllllllIllIllIIIlllllIIl) {
        ImpactPlusTessellator.prepare(7);
        ImpactPlusTessellator.drawBoundingBoxBlockPos(lllllllllllllllIllIllIIIlllllllI, lllllllllllllllIllIllIIIllllIlll, lllllllllllllllIllIllIIIllllIllI, lllllllllllllllIllIllIIIlllllIll, lllllllllllllllIllIllIIIllllIlII, lllllllllllllllIllIllIIIlllllIIl);
        ImpactPlusTessellator.release();
    }

    public VoidEsp() {
        super("VoidEsp", Module.Category.RENDER);
        VoidEsp lllllllllllllllIllIllIIlIIlIllll;
    }

    @Override
    public void setup() {
        VoidEsp lllllllllllllllIllIllIIlIIlIlIIl;
        ArrayList<String> lllllllllllllllIllIllIIlIIlIlIlI = new ArrayList<String>();
        lllllllllllllllIllIllIIlIIlIlIlI.add("Box");
        lllllllllllllllIllIllIIlIIlIlIlI.add("BoundingBox");
        lllllllllllllllIllIllIIlIIlIlIlI.add("Both");
        lllllllllllllllIllIllIIlIIlIlIIl.hmode = lllllllllllllllIllIllIIlIIlIlIIl.registerMode("RenderType", lllllllllllllllIllIllIIlIIlIlIlI, "Both");
        lllllllllllllllIllIllIIlIIlIlIIl.bedrainbow = lllllllllllllllIllIllIIlIIlIlIIl.registerB("Rainbow", false);
        lllllllllllllllIllIllIIlIIlIlIIl.bedr = lllllllllllllllIllIllIIlIIlIlIIl.registerI("Red", 255, 0, 255);
        lllllllllllllllIllIllIIlIIlIlIIl.bedg = lllllllllllllllIllIllIIlIIlIlIIl.registerI("Green", 0, 0, 255);
        lllllllllllllllIllIllIIlIIlIlIIl.bedb = lllllllllllllllIllIllIIlIIlIlIIl.registerI("Blue", 255, 0, 255);
        lllllllllllllllIllIllIIlIIlIlIIl.a = lllllllllllllllIllIllIIlIIlIlIIl.registerI("Alpha", 26, 26, 255);
        lllllllllllllllIllIllIIlIIlIlIIl.w = lllllllllllllllIllIllIIlIIlIlIIl.registerI("Width", 1, 1, 5);
        lllllllllllllllIllIllIIlIIlIlIIl.renderdis = lllllllllllllllIllIllIIlIIlIlIIl.registerI("RenderDistance", 6, 0, 15);
    }

    @Override
    public void onWorldRender(RenderEvent lllllllllllllllIllIllIIlIIIlIlll) {
        VoidEsp lllllllllllllllIllIllIIlIIIlIllI;
        lllllllllllllllIllIllIIlIIIlIllI.bedred = 0;
        lllllllllllllllIllIllIIlIIIlIllI.bedgreen = 0;
        lllllllllllllllIllIllIIlIIIlIllI.bedblue = 0;
        if (lllllllllllllllIllIllIIlIIIlIllI.bedrainbow.getValue()) {
            lllllllllllllllIllIllIIlIIIlIllI.bedred = Rainbow.getColor().getRed();
            lllllllllllllllIllIllIIlIIIlIllI.bedgreen = Rainbow.getColor().getGreen();
            lllllllllllllllIllIllIIlIIIlIllI.bedblue = Rainbow.getColor().getBlue();
        } else {
            lllllllllllllllIllIllIIlIIIlIllI.bedred = lllllllllllllllIllIllIIlIIIlIllI.bedr.getValue();
            lllllllllllllllIllIllIIlIIIlIllI.bedgreen = lllllllllllllllIllIllIIlIIIlIllI.bedg.getValue();
            lllllllllllllllIllIllIIlIIIlIllI.bedblue = lllllllllllllllIllIllIIlIIIlIllI.bedb.getValue();
        }
        if (VoidEsp.mc.thePlayer == null || lllllllllllllllIllIllIIlIIIlIllI.voidHoles == null) {
            return;
        }
        if (lllllllllllllllIllIllIIlIIIlIllI.voidHoles.isEmpty()) {
            return;
        }
        lllllllllllllllIllIllIIlIIIlIllI.voidHoles.forEach(lllllllllllllllIllIllIIIlIllllll -> {
            VoidEsp lllllllllllllllIllIllIIIllIIIIII;
            if (lllllllllllllllIllIllIIIllIIIIII.hmode.getValue().equalsIgnoreCase("both") || lllllllllllllllIllIllIIIllIIIIII.hmode.getValue().equalsIgnoreCase("box")) {
                lllllllllllllllIllIllIIIllIIIIII.drawBox((BlockPos)lllllllllllllllIllIllIIIlIllllll, lllllllllllllllIllIllIIIllIIIIII.bedred, lllllllllllllllIllIllIIIllIIIIII.bedgreen, lllllllllllllllIllIllIIIllIIIIII.bedblue, lllllllllllllllIllIllIIIllIIIIII.a.getValue());
            }
            if (lllllllllllllllIllIllIIIllIIIIII.hmode.getValue().equalsIgnoreCase("both") || lllllllllllllllIllIllIIIllIIIIII.hmode.getValue().equalsIgnoreCase("BoundingBox")) {
                lllllllllllllllIllIllIIIllIIIIII.drawboundingBox((BlockPos)lllllllllllllllIllIllIIIlIllllll, lllllllllllllllIllIllIIIllIIIIII.w.getValue(), lllllllllllllllIllIllIIIllIIIIII.bedred, lllllllllllllllIllIllIIIllIIIIII.bedgreen, lllllllllllllllIllIllIIIllIIIIII.bedblue, 255);
            }
        });
    }

    @Override
    public void onUpdate() {
        VoidEsp lllllllllllllllIllIllIIlIIIllllI;
        if (lllllllllllllllIllIllIIlIIIllllI.voidHoles == null) {
            lllllllllllllllIllIllIIlIIIllllI.voidHoles = new ConcurrentSet();
        } else {
            lllllllllllllllIllIllIIlIIIllllI.voidHoles.clear();
        }
        int lllllllllllllllIllIllIIlIIlIIIII = (int)Math.ceil(lllllllllllllllIllIllIIlIIIllllI.renderdis.getValue());
        List<BlockPos> lllllllllllllllIllIllIIlIIIlllll = lllllllllllllllIllIllIIlIIIllllI.getSphere(VoidEsp.getPlayerPos(), lllllllllllllllIllIllIIlIIlIIIII, lllllllllllllllIllIllIIlIIlIIIII, false, true, 0);
        for (BlockPos lllllllllllllllIllIllIIlIIlIIIlI : lllllllllllllllIllIllIIlIIIlllll) {
            if (lllllllllllllllIllIllIIlIIlIIIlI.getY() != 0 || !VoidEsp.mc.theWorld.getBlockState(lllllllllllllllIllIllIIlIIlIIIlI).getBlock().equals(Blocks.air)) continue;
            lllllllllllllllIllIllIIlIIIllllI.voidHoles.add((Object)lllllllllllllllIllIllIIlIIlIIIlI);
        }
    }

    public List<BlockPos> getSphere(BlockPos lllllllllllllllIllIllIIIllIlIIll, float lllllllllllllllIllIllIIIllIlllII, int lllllllllllllllIllIllIIIllIlIIIl, boolean lllllllllllllllIllIllIIIllIllIlI, boolean lllllllllllllllIllIllIIIllIIllll, int lllllllllllllllIllIllIIIllIIlllI) {
        ArrayList<BlockPos> lllllllllllllllIllIllIIIllIlIlll = new ArrayList<BlockPos>();
        int lllllllllllllllIllIllIIIllIlIllI = lllllllllllllllIllIllIIIllIlIIll.getX();
        int lllllllllllllllIllIllIIIllIlIlIl = lllllllllllllllIllIllIIIllIlIIll.getY();
        int lllllllllllllllIllIllIIIllIlIlII = lllllllllllllllIllIllIIIllIlIIll.getZ();
        int lllllllllllllllIllIllIIIllIlllll = lllllllllllllllIllIllIIIllIlIllI - (int)lllllllllllllllIllIllIIIllIlllII;
        while ((float)lllllllllllllllIllIllIIIllIlllll <= (float)lllllllllllllllIllIllIIIllIlIllI + lllllllllllllllIllIllIIIllIlllII) {
            int lllllllllllllllIllIllIIIlllIIIII = lllllllllllllllIllIllIIIllIlIlII - (int)lllllllllllllllIllIllIIIllIlllII;
            while ((float)lllllllllllllllIllIllIIIlllIIIII <= (float)lllllllllllllllIllIllIIIllIlIlII + lllllllllllllllIllIllIIIllIlllII) {
                int lllllllllllllllIllIllIIIlllIIIIl = lllllllllllllllIllIllIIIllIIllll ? lllllllllllllllIllIllIIIllIlIlIl - (int)lllllllllllllllIllIllIIIllIlllII : lllllllllllllllIllIllIIIllIlIlIl;
                while (true) {
                    float f = lllllllllllllllIllIllIIIlllIIIIl;
                    float f2 = lllllllllllllllIllIllIIIllIIllll ? (float)lllllllllllllllIllIllIIIllIlIlIl + lllllllllllllllIllIllIIIllIlllII : (float)(lllllllllllllllIllIllIIIllIlIlIl + lllllllllllllllIllIllIIIllIlIIIl);
                    if (!(f < f2)) break;
                    double lllllllllllllllIllIllIIIlllIIIlI = (lllllllllllllllIllIllIIIllIlIllI - lllllllllllllllIllIllIIIllIlllll) * (lllllllllllllllIllIllIIIllIlIllI - lllllllllllllllIllIllIIIllIlllll) + (lllllllllllllllIllIllIIIllIlIlII - lllllllllllllllIllIllIIIlllIIIII) * (lllllllllllllllIllIllIIIllIlIlII - lllllllllllllllIllIllIIIlllIIIII) + (lllllllllllllllIllIllIIIllIIllll ? (lllllllllllllllIllIllIIIllIlIlIl - lllllllllllllllIllIllIIIlllIIIIl) * (lllllllllllllllIllIllIIIllIlIlIl - lllllllllllllllIllIllIIIlllIIIIl) : 0);
                    if (!(!(lllllllllllllllIllIllIIIlllIIIlI < (double)(lllllllllllllllIllIllIIIllIlllII * lllllllllllllllIllIllIIIllIlllII)) || lllllllllllllllIllIllIIIllIllIlI && lllllllllllllllIllIllIIIlllIIIlI < (double)((lllllllllllllllIllIllIIIllIlllII - 1.0f) * (lllllllllllllllIllIllIIIllIlllII - 1.0f)))) {
                        BlockPos lllllllllllllllIllIllIIIlllIIIll = new BlockPos(lllllllllllllllIllIllIIIllIlllll, lllllllllllllllIllIllIIIlllIIIIl + lllllllllllllllIllIllIIIllIIlllI, lllllllllllllllIllIllIIIlllIIIII);
                        lllllllllllllllIllIllIIIllIlIlll.add(lllllllllllllllIllIllIIIlllIIIll);
                    }
                    ++lllllllllllllllIllIllIIIlllIIIIl;
                }
                ++lllllllllllllllIllIllIIIlllIIIII;
            }
            ++lllllllllllllllIllIllIIIllIlllll;
        }
        return lllllllllllllllIllIllIIIllIlIlll;
    }
}

