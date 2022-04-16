/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiButton
 *  net.minecraft.client.gui.GuiMainMenu
 *  net.minecraft.client.gui.GuiMultiplayer
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.realms.RealmsBridge
 */
package me.axua.impactplus.guiscreens;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.module.ModuleManager;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.realms.RealmsBridge;

public class AntiDisconnect
extends GuiScreen {
    /* synthetic */ me.axua.impactplus.module.modules.misc.AntiDisconnect mod;
    private /* synthetic */ int disconnectCount;

    public void onGuiClosed() {
        AntiDisconnect llllllllllllllllIIIlIlllIlIIIllI;
        llllllllllllllllIIIlIlllIlIIIllI.disconnectCount = llllllllllllllllIIIlIlllIlIIIllI.mod.Count.getValue();
    }

    public void drawScreen(int llllllllllllllllIIIlIlllIIlIllIl, int llllllllllllllllIIIlIlllIIllIIII, float llllllllllllllllIIIlIlllIIlIlIll) {
        AntiDisconnect llllllllllllllllIIIlIlllIIllIIlI;
        llllllllllllllllIIIlIlllIIllIIlI.drawDefaultBackground();
        Gui.drawRect((int)((int)((float)(llllllllllllllllIIIlIlllIIllIIlI.width / 2) - ImpactPlus.CustomFont2.getStringWidth("Disconnect Confirmation") / 2.0f - 1.0f)), (int)42, (int)((int)((float)(llllllllllllllllIIIlIlllIIllIIlI.width / 2) + ImpactPlus.CustomFont2.getStringWidth("Disconnect Confirmation") - 52.0f)), (int)52, (int)new Color(0, 0, 0, 130).getRGB());
        ImpactPlus.CustomFont2.drawCenteredStringWithShadow("Disconnect Confirmation", llllllllllllllllIIIlIlllIIllIIlI.width / 2, 40.0f, -11141121);
        super.drawScreen(llllllllllllllllIIIlIlllIIlIllIl, llllllllllllllllIIIlIlllIIllIIII, llllllllllllllllIIIlIlllIIlIlIll);
    }

    public AntiDisconnect() {
        AntiDisconnect llllllllllllllllIIIlIlllIlIIllII;
        llllllllllllllllIIIlIlllIlIIllII.mod = (me.axua.impactplus.module.modules.misc.AntiDisconnect)ModuleManager.getModuleByName("AntiDisconnect");
        llllllllllllllllIIIlIlllIlIIllII.disconnectCount = llllllllllllllllIIIlIlllIlIIllII.mod.Count.getValue();
    }

    public void initGui() {
        AntiDisconnect llllllllllllllllIIIlIlllIlIIlIlI;
        super.initGui();
        llllllllllllllllIIIlIlllIlIIlIlI.disconnectCount = llllllllllllllllIIIlIlllIlIIlIlI.mod.Count.getValue();
        llllllllllllllllIIIlIlllIlIIlIlI.buttonList.add(new GuiButton(0, llllllllllllllllIIIlIlllIlIIlIlI.width / 2 - 100, 200, "Back to Game"));
        llllllllllllllllIIIlIlllIlIIlIlI.buttonList.add(new GuiButton(1, llllllllllllllllIIIlIlllIlIIlIlI.width / 2 - 100, 230, String.format(String.valueOf(new StringBuilder().append(ChatFormatting.AQUA).append("Press me %s time(s) to disconnect.")), llllllllllllllllIIIlIlllIlIIlIlI.disconnectCount)));
    }

    protected void actionPerformed(GuiButton llllllllllllllllIIIlIlllIIllllII) {
        switch (llllllllllllllllIIIlIlllIIllllII.id) {
            case 0: {
                AntiDisconnect llllllllllllllllIIIlIlllIIllllIl;
                llllllllllllllllIIIlIlllIIllllIl.mc.displayGuiScreen(null);
                llllllllllllllllIIIlIlllIIllllIl.mc.setIngameFocus();
                llllllllllllllllIIIlIlllIIllllIl.disconnectCount = llllllllllllllllIIIlIlllIIllllIl.mod.Count.getValue();
                break;
            }
            case 1: {
                AntiDisconnect llllllllllllllllIIIlIlllIIllllIl;
                if (llllllllllllllllIIIlIlllIIllllIl.disconnectCount > 1) {
                    --llllllllllllllllIIIlIlllIIllllIl.disconnectCount;
                    llllllllllllllllIIIlIlllIIllllIl.buttonList.remove(1);
                    llllllllllllllllIIIlIlllIIllllIl.buttonList.add(new GuiButton(1, llllllllllllllllIIIlIlllIIllllIl.width / 2 - 100, 230, String.format(String.valueOf(new StringBuilder().append(ChatFormatting.AQUA).append("Press me %s time(s) to disconnect.")), llllllllllllllllIIIlIlllIIllllIl.disconnectCount)));
                    break;
                }
                llllllllllllllllIIIlIlllIIllllIl.disconnectCount = llllllllllllllllIIIlIlllIIllllIl.mod.Count.getValue();
                boolean llllllllllllllllIIIlIlllIIllllll = llllllllllllllllIIIlIlllIIllllIl.mc.isIntegratedServerRunning();
                boolean llllllllllllllllIIIlIlllIIlllllI = llllllllllllllllIIIlIlllIIllllIl.mc.func_181540_al();
                llllllllllllllllIIIlIlllIIllllII.enabled = false;
                llllllllllllllllIIIlIlllIIllllIl.mc.theWorld.sendQuittingDisconnectingPacket();
                llllllllllllllllIIIlIlllIIllllIl.mc.loadWorld(null);
                if (llllllllllllllllIIIlIlllIIllllll) {
                    llllllllllllllllIIIlIlllIIllllIl.mc.displayGuiScreen((GuiScreen)new GuiMainMenu());
                    break;
                }
                if (llllllllllllllllIIIlIlllIIlllllI) {
                    RealmsBridge llllllllllllllllIIIlIlllIlIIIIII = new RealmsBridge();
                    llllllllllllllllIIIlIlllIlIIIIII.switchToRealms((GuiScreen)new GuiMainMenu());
                    break;
                }
                llllllllllllllllIIIlIlllIIllllIl.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)new GuiMainMenu()));
            }
        }
    }
}

