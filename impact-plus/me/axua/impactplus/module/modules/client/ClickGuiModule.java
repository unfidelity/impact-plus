/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package me.axua.impactplus.module.modules.client;

import java.util.ArrayList;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.client.gui.GuiScreen;

public class ClickGuiModule
extends Module {
    public static /* synthetic */ Setting.mode modulealign;
    public static /* synthetic */ Setting.b rainbow;
    public static /* synthetic */ Setting.b shownumbers;
    public /* synthetic */ ClickGuiModule INSTANCE;
    public static /* synthetic */ Setting.i red;
    public static /* synthetic */ Setting.b description;
    public static /* synthetic */ Setting.mode titlealign;
    public static /* synthetic */ Setting.b customfont;
    public static /* synthetic */ Setting.i blue;
    public static /* synthetic */ Setting.b blur;
    public static /* synthetic */ Setting.i green;

    @Override
    public void setup() {
        ClickGuiModule lllllllllllllllllIIIIllIIllllIlI;
        ArrayList<String> lllllllllllllllllIIIIllIIlllllII = new ArrayList<String>();
        lllllllllllllllllIIIIllIIlllllII.add("Left");
        lllllllllllllllllIIIIllIIlllllII.add("Middle");
        ArrayList<String> lllllllllllllllllIIIIllIIllllIll = new ArrayList<String>();
        lllllllllllllllllIIIIllIIllllIll.add("Left");
        lllllllllllllllllIIIIllIIllllIll.add("Middle");
        rainbow = lllllllllllllllllIIIIllIIllllIlI.registerB("Rainbow", true);
        red = lllllllllllllllllIIIIllIIllllIlI.registerI("Red", 85, 0, 255);
        green = lllllllllllllllllIIIIllIIllllIlI.registerI("Green", 0, 0, 255);
        blue = lllllllllllllllllIIIIllIIllllIlI.registerI("Blue", 255, 0, 255);
        titlealign = lllllllllllllllllIIIIllIIllllIlI.registerMode("TitleAlign", lllllllllllllllllIIIIllIIlllllII, "Left");
        modulealign = lllllllllllllllllIIIIllIIllllIlI.registerMode("ModuleAlign", lllllllllllllllllIIIIllIIlllllII, "Left");
        customfont = lllllllllllllllllIIIIllIIllllIlI.registerB("CustomFont", true);
        description = lllllllllllllllllIIIIllIIllllIlI.registerB("Description", true);
        shownumbers = lllllllllllllllllIIIIllIIllllIlI.registerB("ShowNumbers", true);
        blur = lllllllllllllllllIIIIllIIllllIlI.registerB("Blur", true);
    }

    @Override
    public void onEnable() {
        ClickGuiModule lllllllllllllllllIIIIllIIlllIllI;
        mc.displayGuiScreen((GuiScreen)ImpactPlus.getInstance().clickGui);
        lllllllllllllllllIIIIllIIlllIllI.disable();
    }

    public ClickGuiModule() {
        super("ClickGUI", Module.Category.CLIENT, "Opens the ClickGUI");
        ClickGuiModule lllllllllllllllllIIIIllIlIIIIIlI;
        lllllllllllllllllIIIIllIlIIIIIlI.setBind(25);
        lllllllllllllllllIIIIllIlIIIIIlI.INSTANCE = lllllllllllllllllIIIIllIlIIIIIlI;
    }
}

