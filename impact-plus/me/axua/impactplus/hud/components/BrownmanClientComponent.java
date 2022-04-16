/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 */
package me.axua.impactplus.hud.components;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.axua.impactplus.hud.HudComponent;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.hud.BrownmanClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class BrownmanClientComponent
extends HudComponent<BrownmanClient> {
    /* synthetic */ Minecraft mc;
    /* synthetic */ BrownmanClient mod2;

    public BrownmanClientComponent() {
        super("BrownmanClient", 2, 152, BrownmanClient.INSTANCE);
        BrownmanClientComponent llllllllllllllllIIIIIIlIlIIIIIlI;
        llllllllllllllllIIIIIIlIlIIIIIlI.mc = Minecraft.getMinecraft();
        llllllllllllllllIIIIIIlIlIIIIIlI.mod2 = (BrownmanClient)ModuleManager.getModuleByName("BrownmanClient");
    }

    @Override
    public void render() {
        BrownmanClientComponent llllllllllllllllIIIIIIlIlIIIIIII;
        super.render();
        Gui.drawRect((int)llllllllllllllllIIIIIIlIlIIIIIII.x, (int)llllllllllllllllIIIIIIlIlIIIIIII.y, (int)(llllllllllllllllIIIIIIlIlIIIIIII.x + 172), (int)(llllllllllllllllIIIIIIlIlIIIIIII.y + 12), (int)-10740224);
        if (llllllllllllllllIIIIIIlIlIIIIIII.mod2.Mode.getValue().equals("2019")) {
            llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.BOLD).append("\uff42\uff52\uff4f\uff57\uff4e\uff4d\uff41\uff4e ")), (float)(llllllllllllllllIIIIIIlIlIIIIIII.x + 1), (float)(llllllllllllllllIIIIIIlIlIIIIIII.y + 2), -1);
            llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawString(String.valueOf(new StringBuilder().append(ChatFormatting.BOLD).append("client-b2019.2.0")), llllllllllllllllIIIIIIlIlIIIIIII.x + 57, llllllllllllllllIIIIIIlIlIIIIIII.y + 3, -12632257);
            llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawString(String.valueOf(new StringBuilder().append(ChatFormatting.BOLD).append("client-b2019.2.0")), llllllllllllllllIIIIIIlIlIIIIIII.x + 56, llllllllllllllllIIIIIIlIlIIIIIII.y + 2, -1);
        } else {
            llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawStringWithShadow(String.valueOf(new StringBuilder().append(ChatFormatting.BOLD).append("\uff42\uff52\uff4f\uff57\uff4e\uff4d\uff41\uff4e ")), (float)(llllllllllllllllIIIIIIlIlIIIIIII.x + 1), (float)(llllllllllllllllIIIIIIlIlIIIIIII.y + 2), -1);
            llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawString(String.valueOf(new StringBuilder().append(ChatFormatting.BOLD).append("client-b2020.3.0")), llllllllllllllllIIIIIIlIlIIIIIII.x + 57, llllllllllllllllIIIIIIlIlIIIIIII.y + 3, -12632257);
            llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawString(String.valueOf(new StringBuilder().append(ChatFormatting.BOLD).append("client-b2020.3.0")), llllllllllllllllIIIIIIlIlIIIIIII.x + 56, llllllllllllllllIIIIIIlIlIIIIIII.y + 2, -1);
        }
        llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawStringWithShadow("handtooltip", (float)(llllllllllllllllIIIIIIlIlIIIIIII.x + 1), (float)(llllllllllllllllIIIIIIlIlIIIIIII.y + 16), -16711936);
        if (llllllllllllllllIIIIIIlIlIIIIIII.mod2.Mode.getValue().equals("2019")) {
            llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawStringWithShadow("peekbypass [drop]", (float)(llllllllllllllllIIIIIIlIlIIIIIII.x + 1), (float)(llllllllllllllllIIIIIIlIlIIIIIII.y + 26), -16711936);
        }
        if (llllllllllllllllIIIIIIlIlIIIIIII.mod2.Mode.getValue().equals("2019")) {
            llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawStringWithShadow("packetafk", (float)(llllllllllllllllIIIIIIlIlIIIIIII.x + 1), (float)(llllllllllllllllIIIIIIlIlIIIIIII.y + 36), -16711936);
        } else {
            llllllllllllllllIIIIIIlIlIIIIIII.mc.fontRendererObj.drawStringWithShadow("packetafk", (float)(llllllllllllllllIIIIIIlIlIIIIIII.x + 1), (float)(llllllllllllllllIIIIIIlIlIIIIIII.y + 26), -16711936);
        }
        llllllllllllllllIIIIIIlIlIIIIIII.width = 172;
        llllllllllllllllIIIIIIlIlIIIIIII.height = llllllllllllllllIIIIIIlIlIIIIIII.mod2.Mode.getValue().equals("2019") ? 46 : 36;
    }
}

