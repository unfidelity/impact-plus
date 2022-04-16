/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.module;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.List;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.RenderEvent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.setting.Setting;
import net.minecraft.client.Minecraft;

public class Module {
    protected static final /* synthetic */ Minecraft mc;
    /* synthetic */ String description;
    /* synthetic */ boolean drawn;
    /* synthetic */ boolean enabled;
    /* synthetic */ String name;
    /* synthetic */ int bind;
    /* synthetic */ Category category;

    public void setDrawn(boolean llllllllllllllllIllIlIlIlllIIIll) {
        llllllllllllllllIllIlIlIlllIIIlI.drawn = llllllllllllllllIllIlIlIlllIIIll;
    }

    public Category getCategory() {
        Module llllllllllllllllIllIlIllIllllIIl;
        return llllllllllllllllIllIlIllIllllIIl.category;
    }

    public boolean isDisabled() {
        Module llllllllllllllllIllIlIllIlIIllIl;
        return !llllllllllllllllIllIlIllIlIIllIl.isEnabled();
    }

    protected Setting.mode registerMode(String llllllllllllllllIllIlIlIllllllIl, List<String> llllllllllllllllIllIlIllIIIIIlIl, String llllllllllllllllIllIlIllIIIIIIll) {
        Module llllllllllllllllIllIlIlIllllllll;
        Setting.mode llllllllllllllllIllIlIllIIIIIIIl = new Setting.mode(llllllllllllllllIllIlIlIllllllIl, llllllllllllllllIllIlIlIllllllll, llllllllllllllllIllIlIllIIIIIlIl, llllllllllllllllIllIlIllIIIIIIll);
        ImpactPlus.getInstance().settingsManager.addSetting(llllllllllllllllIllIlIllIIIIIIIl);
        return llllllllllllllllIllIlIllIIIIIIIl;
    }

    public void setName(String llllllllllllllllIllIlIllIlllllII) {
        llllllllllllllllIllIlIllIlllllll.name = llllllllllllllllIllIlIllIlllllII;
    }

    protected Setting.i registerI(String llllllllllllllllIllIlIllIIllllll, int llllllllllllllllIllIlIllIlIIIlII, int llllllllllllllllIllIlIllIlIIIIll, int llllllllllllllllIllIlIllIIllllII) {
        Module llllllllllllllllIllIlIllIlIIIllI;
        Setting.i llllllllllllllllIllIlIllIlIIIIIl = new Setting.i(llllllllllllllllIllIlIllIIllllll, llllllllllllllllIllIlIllIlIIIllI, llllllllllllllllIllIlIllIlIIIlII, llllllllllllllllIllIlIllIlIIIIll, llllllllllllllllIllIlIllIIllllII);
        ImpactPlus.getInstance().settingsManager.addSetting(llllllllllllllllIllIlIllIlIIIIIl);
        return llllllllllllllllIllIlIllIlIIIIIl;
    }

    public boolean isEnabled() {
        Module llllllllllllllllIllIlIllIlIlllll;
        return llllllllllllllllIllIlIllIlIlllll.enabled;
    }

    protected void onEnable() {
    }

    public String getHudInfo() {
        return "";
    }

    public String getName() {
        Module llllllllllllllllIllIlIlllIIIIIlI;
        return llllllllllllllllIllIlIlllIIIIIlI.name;
    }

    public void setCategory(Category llllllllllllllllIllIlIllIlllIlIl) {
        llllllllllllllllIllIlIllIlllIllI.category = llllllllllllllllIllIlIllIlllIlIl;
    }

    public void toggle() {
        Module llllllllllllllllIllIlIllIlIlIIII;
        if (llllllllllllllllIllIlIllIlIlIIII.isEnabled()) {
            llllllllllllllllIllIlIllIlIlIIII.disable();
        } else if (!llllllllllllllllIllIlIllIlIlIIII.isEnabled()) {
            llllllllllllllllIllIlIllIlIlIIII.enable();
        }
    }

    protected void onDisable() {
    }

    public Module(String llllllllllllllllIllIlIlllIIIIlll, Category llllllllllllllllIllIlIlllIIIlIlI, String llllllllllllllllIllIlIlllIIIlIIl) {
        Module llllllllllllllllIllIlIlllIIIllII;
        llllllllllllllllIllIlIlllIIIllII.name = llllllllllllllllIllIlIlllIIIIlll;
        llllllllllllllllIllIlIlllIIIllII.category = llllllllllllllllIllIlIlllIIIlIlI;
        llllllllllllllllIllIlIlllIIIllII.bind = 0;
        llllllllllllllllIllIlIlllIIIllII.enabled = false;
        llllllllllllllllIllIlIlllIIIllII.drawn = true;
        llllllllllllllllIllIlIlllIIIllII.description = llllllllllllllllIllIlIlllIIIlIIl;
        llllllllllllllllIllIlIlllIIIllII.setup();
    }

    protected Setting.s registerS(String llllllllllllllllIllIlIllIIIlIlII, String llllllllllllllllIllIlIllIIIlIIll) {
        Module llllllllllllllllIllIlIllIIIlIIIl;
        Setting.s llllllllllllllllIllIlIllIIIlIIlI = new Setting.s(llllllllllllllllIllIlIllIIIlIlII, llllllllllllllllIllIlIllIIIlIIIl, llllllllllllllllIllIlIllIIIlIIll);
        ImpactPlus.getInstance().settingsManager.addSetting(llllllllllllllllIllIlIllIIIlIIlI);
        return llllllllllllllllIllIlIllIIIlIIlI;
    }

    public void CoolonUpdate() {
    }

    protected Setting.b registerB(String llllllllllllllllIllIlIllIIIlllll, boolean llllllllllllllllIllIlIllIIlIIIlI) {
        Module llllllllllllllllIllIlIllIIlIIlII;
        Setting.b llllllllllllllllIllIlIllIIlIIIIl = new Setting.b(llllllllllllllllIllIlIllIIIlllll, llllllllllllllllIllIlIllIIlIIlII, llllllllllllllllIllIlIllIIlIIIlI);
        ImpactPlus.getInstance().settingsManager.addSetting(llllllllllllllllIllIlIllIIlIIIIl);
        return llllllllllllllllIllIlIllIIlIIIIl;
    }

    public void setDescription(String llllllllllllllllIllIlIlIllIlIlll) {
        llllllllllllllllIllIlIlIllIlIllI.description = llllllllllllllllIllIlIlIllIlIlll;
    }

    public void setup() {
    }

    static {
        mc = Minecraft.getMinecraft();
    }

    public void setEnabled(boolean llllllllllllllllIllIlIllIlIllIll) {
        llllllllllllllllIllIlIllIlIllIlI.enabled = llllllllllllllllIllIlIllIlIllIll;
    }

    public void setBind(int llllllllllllllllIllIlIllIllIlIlI) {
        llllllllllllllllIllIlIllIllIllIl.bind = llllllllllllllllIllIlIllIllIlIlI;
    }

    public void disable() {
        Module llllllllllllllllIllIlIllIlIlIlII;
        llllllllllllllllIllIlIllIlIlIlII.setEnabled(false);
        if (ModuleManager.isModuleEnabled("ToggleMsgs") && !llllllllllllllllIllIlIllIlIlIlII.getName().equalsIgnoreCase("ClickGUI")) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIllIlIllIlIlIlII.getName()).append(ChatFormatting.RED).append(" disabled!")));
        }
        llllllllllllllllIllIlIllIlIlIlII.onDisable();
    }

    public void enable() {
        Module llllllllllllllllIllIlIllIlIlIllI;
        llllllllllllllllIllIlIllIlIlIllI.setEnabled(true);
        if (ModuleManager.isModuleEnabled("ToggleMsgs") && !llllllllllllllllIllIlIllIlIlIllI.getName().equalsIgnoreCase("ClickGUI")) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIllIlIllIlIlIllI.getName()).append(ChatFormatting.GREEN).append(" enabled!")));
        }
        llllllllllllllllIllIlIllIlIlIllI.onEnable();
    }

    public String getDescription() {
        Module llllllllllllllllIllIlIlIllIlllII;
        return llllllllllllllllIllIlIlIllIlllII.description;
    }

    public void onUpdate() {
    }

    public boolean isDrawn() {
        Module llllllllllllllllIllIlIlIlllIlIIl;
        return llllllllllllllllIllIlIlIlllIlIIl.drawn;
    }

    public void onWorldRender(RenderEvent llllllllllllllllIllIlIllIllIIIlI) {
    }

    public void onRender() {
    }

    public int getBind() {
        Module llllllllllllllllIllIlIllIlllIIII;
        return llllllllllllllllIllIlIllIlllIIII.bind;
    }

    public void onLivingEvent() {
    }

    protected Setting.d registerD(String llllllllllllllllIllIlIllIIllIIll, double llllllllllllllllIllIlIllIIlIllII, double llllllllllllllllIllIlIllIIlIlIll, double llllllllllllllllIllIlIllIIllIIII) {
        Module llllllllllllllllIllIlIllIIlIlllI;
        Setting.d llllllllllllllllIllIlIllIIlIllll = new Setting.d(llllllllllllllllIllIlIllIIllIIll, llllllllllllllllIllIlIllIIlIlllI, llllllllllllllllIllIlIllIIlIllII, llllllllllllllllIllIlIllIIlIlIll, llllllllllllllllIllIlIllIIllIIII);
        ImpactPlus.getInstance().settingsManager.addSetting(llllllllllllllllIllIlIllIIlIllll);
        return llllllllllllllllIllIlIllIIlIllll;
    }

    public Module(String llllllllllllllllIllIlIlllIIlIlIl, Category llllllllllllllllIllIlIlllIIlIlII) {
        Module llllllllllllllllIllIlIlllIIlIIll;
        llllllllllllllllIllIlIlllIIlIIll.name = llllllllllllllllIllIlIlllIIlIlIl;
        llllllllllllllllIllIlIlllIIlIIll.category = llllllllllllllllIllIlIlllIIlIlII;
        llllllllllllllllIllIlIlllIIlIIll.bind = 0;
        llllllllllllllllIllIlIlllIIlIIll.enabled = false;
        llllllllllllllllIllIlIlllIIlIIll.drawn = true;
        llllllllllllllllIllIlIlllIIlIIll.description = "No description";
        llllllllllllllllIllIlIlllIIlIIll.setup();
    }

    public static enum Category {
        COMBAT,
        PLAYER,
        MOVEMENT,
        MISC,
        CHAT,
        RENDER,
        CLIENT,
        HUD;


        private Category() {
            Category llllllllllllllllllIllIIIIIllIlII;
        }
    }
}

