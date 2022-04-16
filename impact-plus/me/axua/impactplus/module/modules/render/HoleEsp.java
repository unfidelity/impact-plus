/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.entity.Entity
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.render;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.combat.Surround;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class HoleEsp
extends Module {
    /* synthetic */ int bedgreen;
    /* synthetic */ Setting.mode mode;
    /* synthetic */ int obbygreen;
    private /* synthetic */ ConcurrentHashMap<BlockPos, Boolean> safeHoles;
    /* synthetic */ Setting.b ignoreown;
    /* synthetic */ Setting.i renderdis;
    /* synthetic */ Setting.i obbyg;
    /* synthetic */ Setting.b obbyrainbow;
    private final /* synthetic */ BlockPos[] surroundOffset;
    /* synthetic */ Setting.i bedr;
    /* synthetic */ Setting.b bedrainbow;
    /* synthetic */ Setting.i obbyb;
    /* synthetic */ int obbyred;
    /* synthetic */ Setting.i a;
    /* synthetic */ Setting.mode hmode;
    /* synthetic */ int bedblue;
    /* synthetic */ int bedred;
    /* synthetic */ Setting.i bedb;
    /* synthetic */ Setting.i w;
    /* synthetic */ int obbyblue;
    /* synthetic */ Setting.i bedg;
    /* synthetic */ Setting.i obbyr;

    @Override
    public void setup() {
        HoleEsp lIIllIlIIIIlllI;
        ArrayList<String> lIIllIlIIIIllII = new ArrayList<String>();
        lIIllIlIIIIllII.add("Flat");
        lIIllIlIIIIllII.add("Tiny");
        lIIllIlIIIIllII.add("Quarter");
        lIIllIlIIIIllII.add("Half");
        lIIllIlIIIIllII.add("Full");
        ArrayList<String> lIIllIlIIIIlIIl = new ArrayList<String>();
        lIIllIlIIIIlIIl.add("Box");
        lIIllIlIIIIlIIl.add("BoundingBox");
        lIIllIlIIIIlIIl.add("Both");
        lIIllIlIIIIlllI.mode = lIIllIlIIIIlllI.registerMode("Mode", lIIllIlIIIIllII, "Flat");
        lIIllIlIIIIlllI.hmode = lIIllIlIIIIlllI.registerMode("RenderType", lIIllIlIIIIlIIl, "Both");
        lIIllIlIIIIlllI.obbyrainbow = lIIllIlIIIIlllI.registerB("ObsidianRainbow", false);
        lIIllIlIIIIlllI.obbyr = lIIllIlIIIIlllI.registerI("ObsidianRed", 255, 0, 255);
        lIIllIlIIIIlllI.obbyg = lIIllIlIIIIlllI.registerI("ObsidianGreen", 0, 0, 255);
        lIIllIlIIIIlllI.obbyb = lIIllIlIIIIlllI.registerI("ObsidianBlue", 0, 0, 255);
        lIIllIlIIIIlllI.bedrainbow = lIIllIlIIIIlllI.registerB("BedrockRainbow", false);
        lIIllIlIIIIlllI.bedr = lIIllIlIIIIlllI.registerI("BedrockRed", 0, 0, 255);
        lIIllIlIIIIlllI.bedg = lIIllIlIIIIlllI.registerI("BedrockGreen", 255, 0, 255);
        lIIllIlIIIIlllI.bedb = lIIllIlIIIIlllI.registerI("BedrockBlue", 0, 0, 255);
        lIIllIlIIIIlllI.a = lIIllIlIIIIlllI.registerI("Alpha", 26, 26, 255);
        lIIllIlIIIIlllI.w = lIIllIlIIIIlllI.registerI("Width", 1, 1, 5);
        lIIllIlIIIIlllI.renderdis = lIIllIlIIIIlllI.registerI("RenderDistance", 6, 0, 15);
        lIIllIlIIIIlllI.ignoreown = lIIllIlIIIIlllI.registerB("IgnoreOwnHole", false);
    }

    public void drawBox(BlockPos lIIllIIIllIIIll, int lIIllIIIllIIIlI, int lIIllIIIllIIlll, int lIIllIIIllIIllI, int lIIllIIIlIlllll) {
        HoleEsp lIIllIIIllIIlII;
        Tessellator.prepare(7);
        if (lIIllIIIllIIlII.mode.getValue().equalsIgnoreCase("Flat")) {
            Tessellator.drawBox(lIIllIIIllIIIll, lIIllIIIllIIIlI, lIIllIIIllIIlll, lIIllIIIllIIllI, lIIllIIIlIlllll, 1);
        } else if (lIIllIIIllIIlII.mode.getValue().equalsIgnoreCase("Full")) {
            Tessellator.drawBox(lIIllIIIllIIIll, lIIllIIIllIIIlI, lIIllIIIllIIlll, lIIllIIIllIIllI, lIIllIIIlIlllll, 63);
        } else if (lIIllIIIllIIlII.mode.getValue().equalsIgnoreCase("Half")) {
            Tessellator.drawHalfBox(lIIllIIIllIIIll, lIIllIIIllIIIlI, lIIllIIIllIIlll, lIIllIIIllIIllI, lIIllIIIlIlllll, 63);
        } else if (lIIllIIIllIIlII.mode.getValue().equalsIgnoreCase("Tiny")) {
            Tessellator.drawTinyBox(lIIllIIIllIIIll, lIIllIIIllIIIlI, lIIllIIIllIIlll, lIIllIIIllIIllI, lIIllIIIlIlllll, 63);
        } else if (lIIllIIIllIIlII.mode.getValue().equalsIgnoreCase("Quarter")) {
            Tessellator.drawQuarterBox(lIIllIIIllIIIll, lIIllIIIllIIIlI, lIIllIIIllIIlll, lIIllIIIllIIllI, lIIllIIIlIlllll, 63);
        }
        Tessellator.release();
    }

    @Override
    public void onUpdate() {
        HoleEsp lIIllIIlIlllIIl;
        Vec3d lIIllIIlIlllIII = Surround.getInterpolatedPos((Entity)HoleEsp.mc.thePlayer, 0.0f);
        BlockPos lIIllIIlIllIlll = new BlockPos(lIIllIIlIlllIII);
        if (lIIllIIlIlllIIl.safeHoles == null) {
            lIIllIIlIlllIIl.safeHoles = new ConcurrentHashMap();
        } else {
            lIIllIIlIlllIIl.safeHoles.clear();
        }
        int lIIllIIlIllIllI = (int)Math.ceil(lIIllIIlIlllIIl.renderdis.getValue());
        List<BlockPos> lIIllIIlIllIlIl = lIIllIIlIlllIIl.getSphere(HoleEsp.getPlayerPos(), lIIllIIlIllIllI, lIIllIIlIllIllI, false, true, 0);
        for (BlockPos lIIllIIlIlllIlI : lIIllIIlIllIlIl) {
            if (lIIllIIlIlllIIl.ignoreown.getValue() && lIIllIIlIllIlll.toString().equals(lIIllIIlIlllIlI.toString()) || !HoleEsp.mc.theWorld.getBlockState(lIIllIIlIlllIlI).getBlock().equals(Blocks.air) || !HoleEsp.mc.theWorld.getBlockState(lIIllIIlIlllIlI.add(0, 1, 0)).getBlock().equals(Blocks.air) || !HoleEsp.mc.theWorld.getBlockState(lIIllIIlIlllIlI.add(0, 2, 0)).getBlock().equals(Blocks.air)) continue;
            boolean lIIllIIlIllllII = true;
            boolean lIIllIIlIlllIll = true;
            for (BlockPos lIIllIIlIllllIl : lIIllIIlIlllIIl.surroundOffset) {
                Block lIIllIIlIlllllI = HoleEsp.mc.theWorld.getBlockState(lIIllIIlIlllIlI.add((Vec3i)lIIllIIlIllllIl)).getBlock();
                if (lIIllIIlIlllllI != Blocks.bedrock) {
                    lIIllIIlIlllIll = false;
                }
                if (lIIllIIlIlllllI == Blocks.bedrock || lIIllIIlIlllllI == Blocks.obsidian || lIIllIIlIlllllI == Blocks.ender_chest || lIIllIIlIlllllI == Blocks.anvil) continue;
                lIIllIIlIllllII = false;
                break;
            }
            if (!lIIllIIlIllllII) continue;
            lIIllIIlIlllIIl.safeHoles.put(lIIllIIlIlllIlI, lIIllIIlIlllIll);
        }
    }

    @Override
    public void onWorldRender(RenderEvent lIIllIIlIIlIlll) {
        HoleEsp lIIllIIlIIlIllI;
        lIIllIIlIIlIllI.obbyred = 0;
        lIIllIIlIIlIllI.obbygreen = 0;
        lIIllIIlIIlIllI.obbyblue = 0;
        lIIllIIlIIlIllI.bedred = 0;
        lIIllIIlIIlIllI.bedgreen = 0;
        lIIllIIlIIlIllI.bedblue = 0;
        if (lIIllIIlIIlIllI.obbyrainbow.getValue()) {
            lIIllIIlIIlIllI.obbyred = Rainbow.getColor().getRed();
            lIIllIIlIIlIllI.obbygreen = Rainbow.getColor().getGreen();
            lIIllIIlIIlIllI.obbyblue = Rainbow.getColor().getBlue();
        } else {
            lIIllIIlIIlIllI.obbyred = lIIllIIlIIlIllI.obbyr.getValue();
            lIIllIIlIIlIllI.obbygreen = lIIllIIlIIlIllI.obbyg.getValue();
            lIIllIIlIIlIllI.obbyblue = lIIllIIlIIlIllI.obbyb.getValue();
        }
        if (lIIllIIlIIlIllI.bedrainbow.getValue()) {
            lIIllIIlIIlIllI.bedred = Rainbow.getColor().getRed();
            lIIllIIlIIlIllI.bedgreen = Rainbow.getColor().getGreen();
            lIIllIIlIIlIllI.bedblue = Rainbow.getColor().getBlue();
        } else {
            lIIllIIlIIlIllI.bedred = lIIllIIlIIlIllI.bedr.getValue();
            lIIllIIlIIlIllI.bedgreen = lIIllIIlIIlIllI.bedg.getValue();
            lIIllIIlIIlIllI.bedblue = lIIllIIlIIlIllI.bedb.getValue();
        }
        if (HoleEsp.mc.thePlayer == null || lIIllIIlIIlIllI.safeHoles == null) {
            return;
        }
        if (lIIllIIlIIlIllI.safeHoles.isEmpty()) {
            return;
        }
        lIIllIIlIIlIllI.safeHoles.forEach((lIIlIllllIlIlIl, lIIlIllllIlIlII) -> {
            HoleEsp lIIlIllllIllIIl;
            if (lIIlIllllIlIlII.booleanValue()) {
                if (lIIlIllllIllIIl.hmode.getValue().equalsIgnoreCase("both") || lIIlIllllIllIIl.hmode.getValue().equalsIgnoreCase("box")) {
                    lIIlIllllIllIIl.drawBox((BlockPos)lIIlIllllIlIlIl, lIIlIllllIllIIl.bedred, lIIlIllllIllIIl.bedgreen, lIIlIllllIllIIl.bedblue, lIIlIllllIllIIl.a.getValue());
                }
                if (lIIlIllllIllIIl.hmode.getValue().equalsIgnoreCase("both") || lIIlIllllIllIIl.hmode.getValue().equalsIgnoreCase("BoundingBox")) {
                    lIIlIllllIllIIl.drawboundingBox((BlockPos)lIIlIllllIlIlIl, lIIlIllllIllIIl.w.getValue(), lIIlIllllIllIIl.bedred, lIIlIllllIllIIl.bedgreen, lIIlIllllIllIIl.bedblue, 255);
                }
            } else {
                if (lIIlIllllIllIIl.hmode.getValue().equalsIgnoreCase("both") || lIIlIllllIllIIl.hmode.getValue().equalsIgnoreCase("box")) {
                    lIIlIllllIllIIl.drawBox((BlockPos)lIIlIllllIlIlIl, lIIlIllllIllIIl.obbyred, lIIlIllllIllIIl.obbygreen, lIIlIllllIllIIl.obbyblue, lIIlIllllIllIIl.a.getValue());
                }
                if (lIIlIllllIllIIl.hmode.getValue().equalsIgnoreCase("both") || lIIlIllllIllIIl.hmode.getValue().equalsIgnoreCase("BoundingBox")) {
                    lIIlIllllIllIIl.drawboundingBox((BlockPos)lIIlIllllIlIlIl, lIIlIllllIllIIl.w.getValue(), lIIlIllllIllIIl.obbyred, lIIlIllllIllIIl.obbygreen, lIIlIllllIllIIl.obbyblue, 255);
                }
            }
        });
    }

    public void drawboundingBox(BlockPos lIIllIIIlIIllII, int lIIllIIIlIIlIll, int lIIllIIIlIIIIll, int lIIllIIIlIIlIIl, int lIIllIIIlIIIIIl, int lIIllIIIlIIIIII) {
        HoleEsp lIIllIIIlIIllIl;
        ImpactPlusTessellator.prepare(7);
        if (lIIllIIIlIIllIl.mode.getValue().equalsIgnoreCase("Flat")) {
            ImpactPlusTessellator.drawBoundingBoxBottomBlockPos(lIIllIIIlIIllII, lIIllIIIlIIlIll, lIIllIIIlIIIIll, lIIllIIIlIIlIIl, lIIllIIIlIIIIIl, lIIllIIIlIIIIII);
        } else if (lIIllIIIlIIllIl.mode.getValue().equalsIgnoreCase("Full")) {
            ImpactPlusTessellator.drawBoundingBoxBlockPos(lIIllIIIlIIllII, lIIllIIIlIIlIll, lIIllIIIlIIIIll, lIIllIIIlIIlIIl, lIIllIIIlIIIIIl, lIIllIIIlIIIIII);
        } else if (lIIllIIIlIIllIl.mode.getValue().equalsIgnoreCase("Half")) {
            ImpactPlusTessellator.drawhalfBoundingBoxBlockPos(lIIllIIIlIIllII, lIIllIIIlIIlIll, lIIllIIIlIIIIll, lIIllIIIlIIlIIl, lIIllIIIlIIIIIl, lIIllIIIlIIIIII);
        } else if (lIIllIIIlIIllIl.mode.getValue().equalsIgnoreCase("Tiny")) {
            ImpactPlusTessellator.drawTinyBoundingBoxBlockPos(lIIllIIIlIIllII, lIIllIIIlIIlIll, lIIllIIIlIIIIll, lIIllIIIlIIlIIl, lIIllIIIlIIIIIl, lIIllIIIlIIIIII);
        } else if (lIIllIIIlIIllIl.mode.getValue().equalsIgnoreCase("Quarter")) {
            ImpactPlusTessellator.drawQuarterBoundingBoxBlockPos(lIIllIIIlIIllII, lIIllIIIlIIlIll, lIIllIIIlIIIIll, lIIllIIIlIIlIIl, lIIllIIIlIIIIIl, lIIllIIIlIIIIII);
        }
        ImpactPlusTessellator.release();
    }

    public HoleEsp() {
        super("HoleEsp", Module.Category.RENDER);
        HoleEsp lIIllIlIIllIllI;
        lIIllIlIIllIllI.surroundOffset = new BlockPos[]{new BlockPos(0, -1, 0), new BlockPos(0, 0, -1), new BlockPos(1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(-1, 0, 0)};
    }

    public static BlockPos getPlayerPos() {
        return new BlockPos(Math.floor(HoleEsp.mc.thePlayer.posX), Math.floor(HoleEsp.mc.thePlayer.posY), Math.floor(HoleEsp.mc.thePlayer.posZ));
    }

    public List<BlockPos> getSphere(BlockPos lIIlIlllllllIll, float lIIlIlllllllIIl, int lIIlIllllllIlll, boolean lIIlIllllllIllI, boolean lIIllIIIIIIIlII, int lIIlIllllllIlII) {
        ArrayList<BlockPos> lIIllIIIIIIIIIl = new ArrayList<BlockPos>();
        int lIIllIIIIIIIIII = lIIlIlllllllIll.getX();
        int lIIlIllllllllll = lIIlIlllllllIll.getY();
        int lIIlIllllllllIl = lIIlIlllllllIll.getZ();
        int lIIllIIIIIlIIII = lIIllIIIIIIIIII - (int)lIIlIlllllllIIl;
        while ((float)lIIllIIIIIlIIII <= (float)lIIllIIIIIIIIII + lIIlIlllllllIIl) {
            int lIIllIIIIIlIIlI = lIIlIllllllllIl - (int)lIIlIlllllllIIl;
            while ((float)lIIllIIIIIlIIlI <= (float)lIIlIllllllllIl + lIIlIlllllllIIl) {
                int lIIllIIIIIlIlII = lIIllIIIIIIIlII ? lIIlIllllllllll - (int)lIIlIlllllllIIl : lIIlIllllllllll;
                while (true) {
                    float f = lIIllIIIIIlIlII;
                    float f2 = lIIllIIIIIIIlII ? (float)lIIlIllllllllll + lIIlIlllllllIIl : (float)(lIIlIllllllllll + lIIlIllllllIlll);
                    if (!(f < f2)) break;
                    double lIIllIIIIIlIllI = (lIIllIIIIIIIIII - lIIllIIIIIlIIII) * (lIIllIIIIIIIIII - lIIllIIIIIlIIII) + (lIIlIllllllllIl - lIIllIIIIIlIIlI) * (lIIlIllllllllIl - lIIllIIIIIlIIlI) + (lIIllIIIIIIIlII ? (lIIlIllllllllll - lIIllIIIIIlIlII) * (lIIlIllllllllll - lIIllIIIIIlIlII) : 0);
                    if (!(!(lIIllIIIIIlIllI < (double)(lIIlIlllllllIIl * lIIlIlllllllIIl)) || lIIlIllllllIllI && lIIllIIIIIlIllI < (double)((lIIlIlllllllIIl - 1.0f) * (lIIlIlllllllIIl - 1.0f)))) {
                        BlockPos lIIllIIIIIllIII = new BlockPos(lIIllIIIIIlIIII, lIIllIIIIIlIlII + lIIlIllllllIlII, lIIllIIIIIlIIlI);
                        lIIllIIIIIIIIIl.add(lIIllIIIIIllIII);
                    }
                    ++lIIllIIIIIlIlII;
                }
                ++lIIllIIIIIlIIlI;
            }
            ++lIIllIIIIIlIIII;
        }
        return lIIllIIIIIIIIIl;
    }
}

