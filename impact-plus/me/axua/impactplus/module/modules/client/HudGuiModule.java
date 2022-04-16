/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package me.axua.impactplus.module.modules.client;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.module.Module;
import net.minecraft.client.gui.GuiScreen;

public class HudGuiModule
extends Module {
    public /* synthetic */ HudGuiModule INSTANCE;

    public HudGuiModule() {
        super("HudEditor", Module.Category.CLIENT, "Opens the HudEditor");
        HudGuiModule lIIIIIlIlIlll;
        lIIIIIlIlIlll.setBind(41);
        lIIIIIlIlIlll.INSTANCE = lIIIIIlIlIlll;
    }

    @Override
    public void onEnable() {
        HudGuiModule lIIIIIlIIIlIl;
        mc.displayGuiScreen((GuiScreen)ImpactPlus.getInstance().hudGui);
        lIIIIIlIIIlIl.disable();
    }
}

