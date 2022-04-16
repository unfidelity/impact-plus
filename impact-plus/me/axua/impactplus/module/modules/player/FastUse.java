/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.init.Items
 */
package me.axua.impactplus.module.modules.player;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.init.Items;

public class FastUse
extends Module {
    /* synthetic */ Setting.b crystals;
    /* synthetic */ Setting.b xp;
    /* synthetic */ Setting.b all;

    @Override
    public void onUpdate() {
        FastUse llllllIllIlIllI;
        if (llllllIllIlIllI.xp.getValue() && FastUse.mc.thePlayer != null && (FastUse.mc.thePlayer.func_184614_ca().getItem() == Items.experience_bottle || FastUse.mc.thePlayer.func_184592_cb().getItem() == Items.experience_bottle)) {
            FastUse.mc.rightClickDelayTimer = 0;
        }
        if (llllllIllIlIllI.crystals.getValue() && FastUse.mc.thePlayer != null && (FastUse.mc.thePlayer.func_184614_ca().getItem() == Items.field_185158_cP || FastUse.mc.thePlayer.func_184592_cb().getItem() == Items.field_185158_cP)) {
            FastUse.mc.rightClickDelayTimer = 0;
        }
        if (llllllIllIlIllI.all.getValue()) {
            FastUse.mc.rightClickDelayTimer = 0;
        }
    }

    @Override
    public void setup() {
        FastUse llllllIlllIIIIl;
        llllllIlllIIIIl.xp = llllllIlllIIIIl.registerB("Exp", true);
        llllllIlllIIIIl.crystals = llllllIlllIIIIl.registerB("Crystals", true);
        llllllIlllIIIIl.all = llllllIlllIIIIl.registerB("Everything", false);
    }

    public FastUse() {
        super("FastUse", Module.Category.PLAYER);
        FastUse llllllIlllIlIIl;
    }
}

