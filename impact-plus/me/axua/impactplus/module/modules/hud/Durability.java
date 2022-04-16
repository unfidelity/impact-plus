/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.item.ItemStack
 */
package me.axua.impactplus.module.modules.hud;

import java.util.ArrayList;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

public class Durability
extends Module {
    public /* synthetic */ Setting.mode Mode;
    public static /* synthetic */ Durability INSTANCE;

    public int Durability(Minecraft lIIIIlIIIlIIl) {
        ItemStack lIIIIlIIIlIlI = lIIIIlIIIlIIl.thePlayer.func_184614_ca();
        return lIIIIlIIIlIlI.getMaxDamage() - lIIIIlIIIlIlI.getItemDamage();
    }

    @Override
    public void setup() {
        Durability lIIIIlIIlIIlI;
        ArrayList<String> lIIIIlIIlIIIl = new ArrayList<String>();
        lIIIIlIIlIIIl.add("Durability");
        lIIIIlIIlIIIl.add("Dura");
        lIIIIlIIlIIlI.Mode = lIIIIlIIlIIlI.registerMode("Mode", lIIIIlIIlIIIl, "Dura");
    }

    public Durability() {
        super("Durability", Module.Category.HUD);
        Durability lIIIIlIIlIllI;
        INSTANCE = lIIIIlIIlIllI;
        lIIIIlIIlIllI.setDrawn(false);
    }
}

