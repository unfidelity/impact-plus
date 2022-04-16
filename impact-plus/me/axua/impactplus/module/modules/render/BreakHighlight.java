/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.play.server.SPacketBlockBreakAnim
 *  net.minecraft.util.math.BlockPos
 */
package me.axua.impactplus.module.modules.render;

import java.util.ArrayList;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.network.play.server.SPacketBlockBreakAnim;
import net.minecraft.util.math.BlockPos;

public class BreakHighlight
extends Module {
    /* synthetic */ int obbygreen;
    /* synthetic */ Setting.i obbyr;
    private /* synthetic */ ArrayList<BlockPos> BlocksBeingBroken;
    /* synthetic */ Setting.i obbyb;
    /* synthetic */ Setting.b obbyrainbow;
    /* synthetic */ int obbyblue;
    /* synthetic */ Setting.i w;
    /* synthetic */ Setting.i a;
    @EventHandler
    private /* synthetic */ Listener<PacketEvent.Receive> recvListener;
    /* synthetic */ Setting.i obbyg;
    /* synthetic */ int obbyred;

    @Override
    public void setup() {
        BreakHighlight llllllllllllllllIIIllIlIIIlIlIIl;
        llllllllllllllllIIIllIlIIIlIlIIl.obbyrainbow = llllllllllllllllIIIllIlIIIlIlIIl.registerB("BedrockRainbow", false);
        llllllllllllllllIIIllIlIIIlIlIIl.obbyr = llllllllllllllllIIIllIlIIIlIlIIl.registerI("BedrockRed", 0, 0, 255);
        llllllllllllllllIIIllIlIIIlIlIIl.obbyg = llllllllllllllllIIIllIlIIIlIlIIl.registerI("BedrockGreen", 255, 0, 255);
        llllllllllllllllIIIllIlIIIlIlIIl.obbyb = llllllllllllllllIIIllIlIIIlIlIIl.registerI("BedrockBlue", 0, 0, 255);
        llllllllllllllllIIIllIlIIIlIlIIl.a = llllllllllllllllIIIllIlIIIlIlIIl.registerI("Alpha", 26, 26, 255);
        llllllllllllllllIIIllIlIIIlIlIIl.w = llllllllllllllllIIIllIlIIIlIlIIl.registerI("Width", 1, 1, 5);
    }

    @Override
    public void onDisable() {
        BreakHighlight llllllllllllllllIIIllIlIIIlIIIIl;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)llllllllllllllllIIIllIlIIIlIIIIl);
    }

    @Override
    public void onEnable() {
        BreakHighlight llllllllllllllllIIIllIlIIIlIIllI;
        llllllllllllllllIIIllIlIIIlIIllI.BlocksBeingBroken.clear();
        ImpactPlus.EVENT_BUS.subscribe((Object)llllllllllllllllIIIllIlIIIlIIllI);
    }

    public void drawboundingBox(BlockPos llllllllllllllllIIIllIIllllIllll, int llllllllllllllllIIIllIIllllIlIII, int llllllllllllllllIIIllIIllllIIlll, int llllllllllllllllIIIllIIllllIIllI, int llllllllllllllllIIIllIIllllIlIll, int llllllllllllllllIIIllIIllllIIlII) {
        ImpactPlusTessellator.prepare(7);
        ImpactPlusTessellator.drawBoundingBoxBlockPos(llllllllllllllllIIIllIIllllIllll, llllllllllllllllIIIllIIllllIlIII, llllllllllllllllIIIllIIllllIIlll, llllllllllllllllIIIllIIllllIIllI, llllllllllllllllIIIllIIllllIlIll, llllllllllllllllIIIllIIllllIIlII);
        ImpactPlusTessellator.release();
    }

    public BreakHighlight() {
        super("BreakHighlight", Module.Category.RENDER);
        BreakHighlight llllllllllllllllIIIllIlIIIlIllIl;
        llllllllllllllllIIIllIlIIIlIllIl.BlocksBeingBroken = new ArrayList();
        llllllllllllllllIIIllIlIIIlIllIl.recvListener = new Listener<PacketEvent.Receive>(llllllllllllllllIIIllIIlllIIIIlI -> {
            if (llllllllllllllllIIIllIIlllIIIIlI.getPacket() instanceof SPacketBlockBreakAnim) {
                BreakHighlight llllllllllllllllIIIllIIlllIIIIll;
                SPacketBlockBreakAnim llllllllllllllllIIIllIIlllIIIlll = (SPacketBlockBreakAnim)llllllllllllllllIIIllIIlllIIIIlI.getPacket();
                if (!llllllllllllllllIIIllIIlllIIIIll.BlocksBeingBroken.contains(llllllllllllllllIIIllIIlllIIIlll.getPosition()) && llllllllllllllllIIIllIIlllIIIlll.getProgress() > 0 && llllllllllllllllIIIllIIlllIIIlll.getProgress() <= 10) {
                    llllllllllllllllIIIllIIlllIIIIll.BlocksBeingBroken = new ArrayList();
                    llllllllllllllllIIIllIIlllIIIIll.BlocksBeingBroken.add(llllllllllllllllIIIllIIlllIIIlll.getPosition());
                } else if (llllllllllllllllIIIllIIlllIIIlll.getProgress() <= 0 || llllllllllllllllIIIllIIlllIIIlll.getProgress() > 10) {
                    llllllllllllllllIIIllIIlllIIIIll.BlocksBeingBroken.remove(llllllllllllllllIIIllIIlllIIIlll.getPosition());
                }
            }
        }, new Predicate[0]);
    }

    public void drawBox(BlockPos llllllllllllllllIIIllIlIIIIIlIIl, int llllllllllllllllIIIllIlIIIIIIlll, int llllllllllllllllIIIllIlIIIIIIlIl, int llllllllllllllllIIIllIIlllllllIl, int llllllllllllllllIIIllIIllllllIll) {
        Tessellator.prepare(7);
        Tessellator.drawBox(llllllllllllllllIIIllIlIIIIIlIIl, llllllllllllllllIIIllIlIIIIIIlll, llllllllllllllllIIIllIlIIIIIIlIl, llllllllllllllllIIIllIIlllllllIl, llllllllllllllllIIIllIIllllllIll, 63);
        Tessellator.release();
    }

    @Override
    public void onWorldRender(RenderEvent llllllllllllllllIIIllIlIIIIlllII) {
        BreakHighlight llllllllllllllllIIIllIlIIIIlllIl;
        llllllllllllllllIIIllIlIIIIlllIl.obbyred = 0;
        llllllllllllllllIIIllIlIIIIlllIl.obbygreen = 0;
        llllllllllllllllIIIllIlIIIIlllIl.obbyblue = 0;
        if (llllllllllllllllIIIllIlIIIIlllIl.obbyrainbow.getValue()) {
            llllllllllllllllIIIllIlIIIIlllIl.obbyred = Rainbow.getColor().getRed();
            llllllllllllllllIIIllIlIIIIlllIl.obbygreen = Rainbow.getColor().getGreen();
            llllllllllllllllIIIllIlIIIIlllIl.obbyblue = Rainbow.getColor().getBlue();
        } else {
            llllllllllllllllIIIllIlIIIIlllIl.obbyred = llllllllllllllllIIIllIlIIIIlllIl.obbyr.getValue();
            llllllllllllllllIIIllIlIIIIlllIl.obbygreen = llllllllllllllllIIIllIlIIIIlllIl.obbyg.getValue();
            llllllllllllllllIIIllIlIIIIlllIl.obbyblue = llllllllllllllllIIIllIlIIIIlllIl.obbyb.getValue();
        }
        if (BreakHighlight.mc.thePlayer == null || llllllllllllllllIIIllIlIIIIlllIl.BlocksBeingBroken == null) {
            return;
        }
        if (llllllllllllllllIIIllIlIIIIlllIl.BlocksBeingBroken.isEmpty()) {
            return;
        }
        llllllllllllllllIIIllIlIIIIlllIl.BlocksBeingBroken.forEach(llllllllllllllllIIIllIIlllIllIIl -> {
            BreakHighlight llllllllllllllllIIIllIIlllIlIlll;
            llllllllllllllllIIIllIIlllIlIlll.drawBox((BlockPos)llllllllllllllllIIIllIIlllIllIIl, llllllllllllllllIIIllIIlllIlIlll.obbyred, llllllllllllllllIIIllIIlllIlIlll.obbygreen, llllllllllllllllIIIllIIlllIlIlll.obbyblue, llllllllllllllllIIIllIIlllIlIlll.a.getValue());
            llllllllllllllllIIIllIIlllIlIlll.drawboundingBox((BlockPos)llllllllllllllllIIIllIIlllIllIIl, llllllllllllllllIIIllIIlllIlIlll.w.getValue(), llllllllllllllllIIIllIIlllIlIlll.obbyred, llllllllllllllllIIIllIIlllIlIlll.obbygreen, llllllllllllllllIIIllIIlllIlIlll.obbyblue, 255);
        });
    }
}

