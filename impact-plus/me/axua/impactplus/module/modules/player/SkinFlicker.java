/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.player.EnumPlayerModelParts
 */
package me.axua.impactplus.module.modules.player;

import java.util.ArrayList;
import java.util.Random;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.entity.player.EnumPlayerModelParts;

public class SkinFlicker
extends Module {
    private /* synthetic */ Random r;
    public /* synthetic */ Setting.mode Mode;
    private /* synthetic */ int len;
    public /* synthetic */ Setting.i Slowness;
    private static final /* synthetic */ EnumPlayerModelParts[] PARTS_HORIZONTAL;
    private static final /* synthetic */ EnumPlayerModelParts[] PARTS_VERTICAL;

    static {
        PARTS_HORIZONTAL = new EnumPlayerModelParts[]{EnumPlayerModelParts.LEFT_SLEEVE, EnumPlayerModelParts.JACKET, EnumPlayerModelParts.HAT, EnumPlayerModelParts.LEFT_PANTS_LEG, EnumPlayerModelParts.RIGHT_PANTS_LEG, EnumPlayerModelParts.RIGHT_SLEEVE};
        PARTS_VERTICAL = new EnumPlayerModelParts[]{EnumPlayerModelParts.HAT, EnumPlayerModelParts.JACKET, EnumPlayerModelParts.LEFT_SLEEVE, EnumPlayerModelParts.RIGHT_SLEEVE, EnumPlayerModelParts.LEFT_PANTS_LEG, EnumPlayerModelParts.RIGHT_PANTS_LEG};
    }

    @Override
    public void setup() {
        SkinFlicker lllllllllllllllllIIlllIIIIIIIllI;
        ArrayList<String> lllllllllllllllllIIlllIIIIIIIlll = new ArrayList<String>();
        lllllllllllllllllIIlllIIIIIIIlll.add("Horizontal");
        lllllllllllllllllIIlllIIIIIIIlll.add("Vertical");
        lllllllllllllllllIIlllIIIIIIIlll.add("Random");
        lllllllllllllllllIIlllIIIIIIIllI.Mode = lllllllllllllllllIIlllIIIIIIIllI.registerMode("Mode", lllllllllllllllllIIlllIIIIIIIlll, "Vertical");
        lllllllllllllllllIIlllIIIIIIIllI.Slowness = lllllllllllllllllIIlllIIIIIIIllI.registerI("Slowness", 2, 1, 5);
    }

    public SkinFlicker() {
        super("SkinFlicker", Module.Category.PLAYER, "SkinFlicker");
        SkinFlicker lllllllllllllllllIIlllIIIIIIllII;
        lllllllllllllllllIIlllIIIIIIllII.r = new Random();
        lllllllllllllllllIIlllIIIIIIllII.len = EnumPlayerModelParts.values().length;
    }

    @Override
    public void onUpdate() {
        SkinFlicker lllllllllllllllllIIllIllllllllII;
        switch (lllllllllllllllllIIllIllllllllII.Mode.getValue()) {
            case "Random": {
                if (SkinFlicker.mc.thePlayer.ticksExisted % lllllllllllllllllIIllIllllllllII.Slowness.getValue() != 0) {
                    return;
                }
                SkinFlicker.mc.gameSettings.switchModelPartEnabled(EnumPlayerModelParts.values()[lllllllllllllllllIIllIllllllllII.r.nextInt(lllllllllllllllllIIllIllllllllII.len)]);
                break;
            }
            case "Vertical": 
            case "Horizontal": {
                int lllllllllllllllllIIllIllllllllll = SkinFlicker.mc.thePlayer.ticksExisted / lllllllllllllllllIIllIllllllllII.Slowness.getValue() % (PARTS_HORIZONTAL.length * 2);
                boolean lllllllllllllllllIIllIlllllllllI = false;
                if (lllllllllllllllllIIllIllllllllll >= PARTS_HORIZONTAL.length) {
                    lllllllllllllllllIIllIlllllllllI = true;
                    lllllllllllllllllIIllIllllllllll -= PARTS_HORIZONTAL.length;
                }
                SkinFlicker.mc.gameSettings.setModelPartEnabled(lllllllllllllllllIIllIllllllllII.Mode.getValue().equals("Vertical") ? PARTS_VERTICAL[lllllllllllllllllIIllIllllllllll] : PARTS_HORIZONTAL[lllllllllllllllllIIllIllllllllll], lllllllllllllllllIIllIlllllllllI);
            }
        }
    }

    @Override
    public void onDisable() {
        for (int lllllllllllllllllIIllIllllllIllI = 0; lllllllllllllllllIIllIllllllIllI < EnumPlayerModelParts.values().length - 1; ++lllllllllllllllllIIllIllllllIllI) {
            SkinFlicker.mc.gameSettings.setModelPartEnabled(PARTS_VERTICAL[lllllllllllllllllIIllIllllllIllI], true);
        }
    }
}

