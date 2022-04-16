/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.util.math.Vec3d
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.render;

import java.util.ArrayList;
import java.util.function.Consumer;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.axua.impactplus.util.Pair;
import me.axua.impactplus.util.rainbow.Rainbow;
import me.axua.impactplus.util.rainbow.Tessellator;
import me.axua.impactplus.util.render.ImpactPlusTessellator;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class CityEsp
extends Module {
    /* synthetic */ Setting.i obbyb;
    /* synthetic */ int obbyblue;
    public /* synthetic */ Setting.b gnewversion;
    /* synthetic */ Setting.i a;
    /* synthetic */ int obbygreen;
    /* synthetic */ int obbyred;
    /* synthetic */ Setting.i obbyg;
    private static final /* synthetic */ BlockPos[] surroundOffset;
    /* synthetic */ Setting.i obbyr;
    /* synthetic */ Setting.b obbyrainbow;
    /* synthetic */ ArrayList<Pair<EntityPlayer, ArrayList<BlockPos>>> players;
    /* synthetic */ Setting.i w;

    private void drawBox(BlockPos lllllllllllllllIllIllIlllllllIII, int lllllllllllllllIllIllIllllllllII, int lllllllllllllllIllIllIllllllIllI, int lllllllllllllllIllIllIllllllIlIl, int lllllllllllllllIllIllIllllllIlII) {
        Tessellator.prepare(7);
        Tessellator.drawBox(lllllllllllllllIllIllIlllllllIII, lllllllllllllllIllIllIllllllllII, lllllllllllllllIllIllIllllllIllI, lllllllllllllllIllIllIllllllIlIl, lllllllllllllllIllIllIllllllIlII, 63);
        Tessellator.release();
    }

    private boolean canPlaceCrystal(BlockPos lllllllllllllllIllIllIllllIlIIIl) {
        CityEsp lllllllllllllllIllIllIllllIIllIl;
        BlockPos lllllllllllllllIllIllIllllIlIIII = lllllllllllllllIllIllIllllIlIIIl.add(0, 1, 0);
        BlockPos lllllllllllllllIllIllIllllIIllll = lllllllllllllllIllIllIllllIlIIIl.add(0, 2, 0);
        BlockPos lllllllllllllllIllIllIllllIIlllI = lllllllllllllllIllIllIllllIlIIIl.add(0, -1, 0);
        if (lllllllllllllllIllIllIllllIIllIl.gnewversion.getValue()) {
            return CityEsp.mc.theWorld.getBlockState(lllllllllllllllIllIllIllllIlIIIl).getBlock() == Blocks.obsidian && (CityEsp.mc.theWorld.getBlockState(lllllllllllllllIllIllIllllIIlllI).getBlock() == Blocks.obsidian || CityEsp.mc.theWorld.getBlockState(lllllllllllllllIllIllIllllIIlllI).getBlock() == Blocks.bedrock);
        }
        return (CityEsp.mc.theWorld.getBlockState(lllllllllllllllIllIllIllllIlIIIl).getBlock() == Blocks.bedrock || CityEsp.mc.theWorld.getBlockState(lllllllllllllllIllIllIllllIlIIIl).getBlock() == Blocks.obsidian) && CityEsp.mc.theWorld.getBlockState(lllllllllllllllIllIllIllllIlIIII).getBlock() == Blocks.air && CityEsp.mc.theWorld.getBlockState(lllllllllllllllIllIllIllllIIllll).getBlock() == Blocks.air && CityEsp.mc.theWorld.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(lllllllllllllllIllIllIllllIlIIII)).isEmpty() && CityEsp.mc.theWorld.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(lllllllllllllllIllIllIllllIIllll)).isEmpty();
    }

    @Override
    public void onUpdate() {
        CityEsp lllllllllllllllIllIlllIIIIIIlIII;
        if (lllllllllllllllIllIlllIIIIIIlIII.players == null) {
            lllllllllllllllIllIlllIIIIIIlIII.players = new ArrayList();
        } else {
            lllllllllllllllIllIlllIIIIIIlIII.players.clear();
        }
        CityEsp.mc.theWorld.playerEntities.stream().filter(lllllllllllllllIllIllIlllIlIIlIl -> lllllllllllllllIllIllIlllIlIIlIl != CityEsp.mc.thePlayer).filter(lllllllllllllllIllIllIlllIlIlIIl -> !Friends.isFriend(lllllllllllllllIllIllIlllIlIlIIl.getName())).forEach(lllllllllllllllIllIllIlllIllIIlI -> {
            CityEsp lllllllllllllllIllIllIlllIllIIII;
            ArrayList<BlockPos> lllllllllllllllIllIllIlllIllIIIl = new ArrayList<BlockPos>();
            for (int lllllllllllllllIllIllIlllIllIlII = 0; lllllllllllllllIllIllIlllIllIlII < 4; ++lllllllllllllllIllIllIlllIllIlII) {
                BlockPos lllllllllllllllIllIllIlllIllIllI = CityEsp.GetPositionVectorBlockPos((Entity)lllllllllllllllIllIllIlllIllIIlI, surroundOffset[lllllllllllllllIllIllIlllIllIlII]);
                if (Minecraft.getMinecraft().theWorld.getBlockState(lllllllllllllllIllIllIlllIllIllI).getBlock() != Blocks.obsidian) continue;
                boolean lllllllllllllllIllIllIlllIllIlIl = false;
                switch (lllllllllllllllIllIllIlllIllIlII) {
                    case 0: {
                        if (lllllllllllllllIllIllIlllIllIIII.gnewversion.getValue()) {
                            lllllllllllllllIllIllIlllIllIlIl = lllllllllllllllIllIllIlllIllIIII.canPlaceCrystal(lllllllllllllllIllIllIlllIllIllI);
                            break;
                        }
                        lllllllllllllllIllIllIlllIllIlIl = lllllllllllllllIllIllIlllIllIIII.canPlaceCrystal(lllllllllllllllIllIllIlllIllIllI.north(1).down());
                        break;
                    }
                    case 1: {
                        if (lllllllllllllllIllIllIlllIllIIII.gnewversion.getValue()) {
                            lllllllllllllllIllIllIlllIllIlIl = lllllllllllllllIllIllIlllIllIIII.canPlaceCrystal(lllllllllllllllIllIllIlllIllIllI);
                            break;
                        }
                        lllllllllllllllIllIllIlllIllIlIl = lllllllllllllllIllIllIlllIllIIII.canPlaceCrystal(lllllllllllllllIllIllIlllIllIllI.east(1).down());
                        break;
                    }
                    case 2: {
                        if (lllllllllllllllIllIllIlllIllIIII.gnewversion.getValue()) {
                            lllllllllllllllIllIllIlllIllIlIl = lllllllllllllllIllIllIlllIllIIII.canPlaceCrystal(lllllllllllllllIllIllIlllIllIllI);
                            break;
                        }
                        lllllllllllllllIllIllIlllIllIlIl = lllllllllllllllIllIllIlllIllIIII.canPlaceCrystal(lllllllllllllllIllIllIlllIllIllI.south(1).down());
                        break;
                    }
                    case 3: {
                        lllllllllllllllIllIllIlllIllIlIl = lllllllllllllllIllIllIlllIllIIII.gnewversion.getValue() ? lllllllllllllllIllIllIlllIllIIII.canPlaceCrystal(lllllllllllllllIllIllIlllIllIllI) : lllllllllllllllIllIllIlllIllIIII.canPlaceCrystal(lllllllllllllllIllIllIlllIllIllI.west(1).down());
                    }
                }
                if (!lllllllllllllllIllIllIlllIllIlIl) continue;
                lllllllllllllllIllIllIlllIllIIIl.add(lllllllllllllllIllIllIlllIllIllI);
            }
            if (!lllllllllllllllIllIllIlllIllIIIl.isEmpty()) {
                lllllllllllllllIllIllIlllIllIIII.players.add(new Pair((EntityPlayer)lllllllllllllllIllIllIlllIllIIlI, lllllllllllllllIllIllIlllIllIIIl));
            }
        });
    }

    public static BlockPos GetPositionVectorBlockPos(Entity lllllllllllllllIllIllIllllIllIlI, BlockPos lllllllllllllllIllIllIllllIllIIl) {
        if (lllllllllllllllIllIllIllllIllIIl == null) {
            return null;
        }
        Vec3d lllllllllllllllIllIllIllllIllIll = lllllllllllllllIllIllIllllIllIlI.getPositionVector();
        if (lllllllllllllllIllIllIllllIllIIl == null) {
            return new BlockPos(lllllllllllllllIllIllIllllIllIll.xCoord, lllllllllllllllIllIllIllllIllIll.yCoord, lllllllllllllllIllIllIllllIllIll.zCoord);
        }
        return new BlockPos(lllllllllllllllIllIllIllllIllIll.xCoord, lllllllllllllllIllIllIllllIllIll.yCoord, lllllllllllllllIllIllIllllIllIll.zCoord).add((Vec3i)lllllllllllllllIllIllIllllIllIIl);
    }

    public CityEsp() {
        super("CityEsp", Module.Category.RENDER);
        CityEsp lllllllllllllllIllIlllIIIIIIllll;
        lllllllllllllllIllIlllIIIIIIllll.players = new ArrayList();
    }

    static {
        surroundOffset = new BlockPos[]{new BlockPos(0, 0, -1), new BlockPos(1, 0, 0), new BlockPos(0, 0, 1), new BlockPos(-1, 0, 0)};
    }

    @Override
    public void onWorldRender(RenderEvent lllllllllllllllIllIlllIIIIIIIlIl) {
        CityEsp lllllllllllllllIllIlllIIIIIIIllI;
        lllllllllllllllIllIlllIIIIIIIllI.obbyred = 0;
        lllllllllllllllIllIlllIIIIIIIllI.obbygreen = 0;
        lllllllllllllllIllIlllIIIIIIIllI.obbyblue = 0;
        if (lllllllllllllllIllIlllIIIIIIIllI.obbyrainbow.getValue()) {
            lllllllllllllllIllIlllIIIIIIIllI.obbyred = Rainbow.getColor().getRed();
            lllllllllllllllIllIlllIIIIIIIllI.obbygreen = Rainbow.getColor().getGreen();
            lllllllllllllllIllIlllIIIIIIIllI.obbyblue = Rainbow.getColor().getBlue();
        } else {
            lllllllllllllllIllIlllIIIIIIIllI.obbyred = lllllllllllllllIllIlllIIIIIIIllI.obbyr.getValue();
            lllllllllllllllIllIlllIIIIIIIllI.obbygreen = lllllllllllllllIllIlllIIIIIIIllI.obbyg.getValue();
            lllllllllllllllIllIlllIIIIIIIllI.obbyblue = lllllllllllllllIllIlllIIIIIIIllI.obbyb.getValue();
        }
        if (CityEsp.mc.thePlayer == null || lllllllllllllllIllIlllIIIIIIIllI.players == null) {
            return;
        }
        if (lllllllllllllllIllIlllIIIIIIIllI.players.isEmpty()) {
            return;
        }
        lllllllllllllllIllIlllIIIIIIIllI.players.forEach((Consumer<Pair<EntityPlayer, ArrayList<BlockPos>>>)((Consumer<Pair>)lllllllllllllllIllIllIllllIIIlIl -> {
            CityEsp lllllllllllllllIllIllIllllIIIllI;
            ((ArrayList)lllllllllllllllIllIllIllllIIIlIl.getValue()).forEach(lllllllllllllllIllIllIlllIllllll -> {
                CityEsp lllllllllllllllIllIllIllllIIIIII;
                lllllllllllllllIllIllIllllIIIIII.drawBox((BlockPos)lllllllllllllllIllIllIlllIllllll, lllllllllllllllIllIllIllllIIIIII.obbyred, lllllllllllllllIllIllIllllIIIIII.obbygreen, lllllllllllllllIllIllIllllIIIIII.obbyblue, lllllllllllllllIllIllIllllIIIIII.a.getValue());
                lllllllllllllllIllIllIllllIIIIII.drawboundingBox((BlockPos)lllllllllllllllIllIllIlllIllllll, lllllllllllllllIllIllIllllIIIIII.w.getValue(), lllllllllllllllIllIllIllllIIIIII.obbyred, lllllllllllllllIllIllIllllIIIIII.obbygreen, lllllllllllllllIllIllIllllIIIIII.obbyblue, 255);
            });
        }));
    }

    private void drawboundingBox(BlockPos lllllllllllllllIllIllIlllllIIllI, int lllllllllllllllIllIllIlllllIlIll, int lllllllllllllllIllIllIlllllIlIlI, int lllllllllllllllIllIllIlllllIIIll, int lllllllllllllllIllIllIlllllIIIlI, int lllllllllllllllIllIllIlllllIIlll) {
        ImpactPlusTessellator.prepare(7);
        ImpactPlusTessellator.drawBoundingBoxBlockPos(lllllllllllllllIllIllIlllllIIllI, lllllllllllllllIllIllIlllllIlIll, lllllllllllllllIllIllIlllllIlIlI, lllllllllllllllIllIllIlllllIIIll, lllllllllllllllIllIllIlllllIIIlI, lllllllllllllllIllIllIlllllIIlll);
        ImpactPlusTessellator.release();
    }

    @Override
    public void setup() {
        CityEsp lllllllllllllllIllIlllIIIIIIlIll;
        lllllllllllllllIllIlllIIIIIIlIll.gnewversion = lllllllllllllllIllIlllIIIIIIlIll.registerB("1.13+", false);
        lllllllllllllllIllIlllIIIIIIlIll.obbyrainbow = lllllllllllllllIllIlllIIIIIIlIll.registerB("Rainbow", false);
        lllllllllllllllIllIlllIIIIIIlIll.obbyr = lllllllllllllllIllIlllIIIIIIlIll.registerI("Red", 255, 0, 255);
        lllllllllllllllIllIlllIIIIIIlIll.obbyg = lllllllllllllllIllIlllIIIIIIlIll.registerI("Green", 0, 0, 255);
        lllllllllllllllIllIlllIIIIIIlIll.obbyb = lllllllllllllllIllIlllIIIIIIlIll.registerI("Blue", 255, 0, 255);
        lllllllllllllllIllIlllIIIIIIlIll.a = lllllllllllllllIllIlllIIIIIIlIll.registerI("Alpha", 26, 26, 255);
        lllllllllllllllIllIlllIIIIIIlIll.w = lllllllllllllllIllIlllIIIIIIlIll.registerI("Width", 1, 1, 5);
    }
}

