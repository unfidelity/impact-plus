/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.material.Material
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.RayTraceResult
 *  net.minecraft.util.math.RayTraceResult$Type
 */
package me.axua.impactplus.module.modules.render;

import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.combat.CrystalAura;
import me.axua.impactplus.module.modules.player.PacketMine;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

public class BlockHighlight
extends Module {
    /* synthetic */ Setting.b box;
    /* synthetic */ Setting.i g;
    /* synthetic */ Setting.b boundingbox;
    /* synthetic */ Setting.i a2;
    /* synthetic */ CrystalAura mod2;
    /* synthetic */ Setting.i b;
    /* synthetic */ Setting.b rainbow;
    /* synthetic */ Setting.i w;
    /* synthetic */ Setting.i r;
    /* synthetic */ PacketMine mod;
    /* synthetic */ Setting.i a;

    public BlockHighlight() {
        super("BlockHighlight", Module.Category.RENDER, "Highlights the block you're looking at");
        BlockHighlight lIlllIIIllIIIlI;
        lIlllIIIllIIIlI.mod = (PacketMine)ModuleManager.getModuleByName("PacketMine");
        lIlllIIIllIIIlI.mod2 = (CrystalAura)ModuleManager.getModuleByName("CrystalAura");
    }

    @Override
    public void onWorldRender(RenderEvent lIlllIIIlIlIlIl) {
        BlockPos lIlllIIIlIllIII;
        IBlockState lIlllIIIlIlIlll;
        Minecraft lIlllIIIlIlIlII = Minecraft.getMinecraft();
        RayTraceResult lIlllIIIlIlIIll = lIlllIIIlIlIlII.objectMouseOver;
        if (lIlllIIIlIlIIll == null) {
            return;
        }
        if (lIlllIIIlIlIIll.typeOfHit == RayTraceResult.Type.BLOCK && (lIlllIIIlIlIlll = lIlllIIIlIlIlII.theWorld.getBlockState(lIlllIIIlIllIII = lIlllIIIlIlIIll.getBlockPos())).func_185904_a() != Material.air && lIlllIIIlIlIlII.theWorld.getWorldBorder().contains(lIlllIIIlIllIII)) {
            BlockHighlight lIlllIIIlIlIllI;
            if (lIlllIIIlIlIllI.mod.packetpos() != null && lIlllIIIlIlIllI.mod.packetpos().toString().equals(lIlllIIIlIllIII.toString())) {
                return;
            }
            if (lIlllIIIlIlIllI.mod2.crypos() != null && lIlllIIIlIlIllI.mod2.crypos().toString().equals(lIlllIIIlIllIII.toString())) {
                return;
            }
            if (lIlllIIIlIlIllI.box.getValue()) {
                Tessellator.prepare(7);
                if (lIlllIIIlIlIllI.rainbow.getValue()) {
                    Tessellator.drawBox(lIlllIIIlIllIII, Rainbow.getColor().getRed(), Rainbow.getColor().getGreen(), Rainbow.getColor().getBlue(), lIlllIIIlIlIllI.a2.getValue(), 63);
                } else {
                    Tessellator.drawBox(lIlllIIIlIllIII, lIlllIIIlIlIllI.r.getValue(), lIlllIIIlIlIllI.g.getValue(), lIlllIIIlIlIllI.b.getValue(), lIlllIIIlIlIllI.a2.getValue(), 63);
                }
                Tessellator.release();
            }
            if (lIlllIIIlIlIllI.boundingbox.getValue()) {
                ImpactPlusTessellator.prepare(7);
                if (lIlllIIIlIlIllI.rainbow.getValue()) {
                    ImpactPlusTessellator.drawBoundingBoxBlockPos(lIlllIIIlIllIII, lIlllIIIlIlIllI.w.getValue(), Rainbow.getColor().getRed(), Rainbow.getColor().getGreen(), Rainbow.getColor().getBlue(), lIlllIIIlIlIllI.a.getValue());
                } else {
                    ImpactPlusTessellator.drawBoundingBoxBlockPos(lIlllIIIlIllIII, lIlllIIIlIlIllI.w.getValue(), lIlllIIIlIlIllI.r.getValue(), lIlllIIIlIlIllI.g.getValue(), lIlllIIIlIlIllI.b.getValue(), lIlllIIIlIlIllI.a.getValue());
                }
                ImpactPlusTessellator.release();
            }
        }
    }

    @Override
    public void setup() {
        BlockHighlight lIlllIIIlIllllI;
        lIlllIIIlIllllI.box = lIlllIIIlIllllI.registerB("Box", false);
        lIlllIIIlIllllI.boundingbox = lIlllIIIlIllllI.registerB("BoundingBox", true);
        lIlllIIIlIllllI.rainbow = lIlllIIIlIllllI.registerB("Rainbow", true);
        lIlllIIIlIllllI.r = lIlllIIIlIllllI.registerI("Red", 255, 0, 255);
        lIlllIIIlIllllI.g = lIlllIIIlIllllI.registerI("Green", 255, 0, 255);
        lIlllIIIlIllllI.b = lIlllIIIlIllllI.registerI("Blue", 255, 0, 255);
        lIlllIIIlIllllI.a2 = lIlllIIIlIllllI.registerI("Alpha", 30, 0, 255);
        lIlllIIIlIllllI.a = lIlllIIIlIllllI.registerI("BoundingBoxAlpha", 255, 0, 255);
        lIlllIIIlIllllI.w = lIlllIIIlIllllI.registerI("Width", 2, 1, 10);
    }
}

