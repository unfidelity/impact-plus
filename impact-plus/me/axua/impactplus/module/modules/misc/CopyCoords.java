/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.module.modules.misc;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import net.minecraft.client.Minecraft;

public class CopyCoords
extends Module {
    /* synthetic */ String server;

    public CopyCoords() {
        super("CopyCoords", Module.Category.MISC);
        CopyCoords llIIlIIlIIlII;
    }

    @Override
    public void onEnable() {
        CopyCoords llIIlIIIlIIlI;
        Minecraft llIIlIIIllIIl = Minecraft.getMinecraft();
        int llIIlIIIllIII = (int)llIIlIIIllIIl.thePlayer.posX;
        int llIIlIIIlIlll = (int)llIIlIIIllIIl.thePlayer.posY;
        int llIIlIIIlIllI = (int)llIIlIIIllIIl.thePlayer.posZ;
        String llIIlIIIlIlIl = llIIlIIIlIIlI.server = String.valueOf(new StringBuilder().append("x").append(llIIlIIIllIII).append(", y").append(llIIlIIIlIlll).append(", z").append(llIIlIIIlIllI));
        StringSelection llIIlIIIlIlII = new StringSelection(llIIlIIIlIlIl);
        Clipboard llIIlIIIlIIll = Toolkit.getDefaultToolkit().getSystemClipboard();
        llIIlIIIlIIll.setContents(llIIlIIIlIlII, null);
        Command.sendClientMessage(String.valueOf(new StringBuilder().append("Copied '").append(llIIlIIIlIIlI.server).append("' to clipboard.")));
        llIIlIIIlIIlI.disable();
    }
}

