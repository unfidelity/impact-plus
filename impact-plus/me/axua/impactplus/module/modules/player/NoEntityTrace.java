/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemPickaxe
 */
package me.axua.impactplus.module.modules.player;

import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.item.ItemPickaxe;

public class NoEntityTrace
extends Module {
    private static /* synthetic */ NoEntityTrace INSTANCE;
    private /* synthetic */ Setting.b pickaxe;

    public static boolean shouldBlock() {
        if (INSTANCE.isDisabled()) {
            return false;
        }
        return !NoEntityTrace.INSTANCE.pickaxe.getValue() || NoEntityTrace.mc.thePlayer.func_184614_ca().getItem() instanceof ItemPickaxe;
    }

    public NoEntityTrace() {
        super("NoEntityTrace", Module.Category.PLAYER, "Attacks nearby players");
        NoEntityTrace llllllllllllllllllIlllIllllllllI;
        INSTANCE = llllllllllllllllllIlllIllllllllI;
    }

    @Override
    public void setup() {
        NoEntityTrace llllllllllllllllllIlllIllllllIlI;
        llllllllllllllllllIlllIllllllIlI.pickaxe = llllllllllllllllllIlllIllllllIlI.registerB("PickaxeOnly", true);
    }
}

