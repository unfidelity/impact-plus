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

public class CopyIp
extends Module {
    /* synthetic */ String server;

    @Override
    public void onEnable() {
        CopyIp llllllllllllllllllIllIIlllIIIIll;
        Minecraft llllllllllllllllllIllIIlllIIlIll = Minecraft.getMinecraft();
        try {
            llllllllllllllllllIllIIlllIIIIll.server = llllllllllllllllllIllIIlllIIlIll.getCurrentServerData().serverIP;
        }
        catch (Exception llllllllllllllllllIllIIlllIIlllI) {
            llllllllllllllllllIllIIlllIIIIll.server = "Singleplayer";
        }
        String llllllllllllllllllIllIIlllIIlIIl = llllllllllllllllllIllIIlllIIIIll.server;
        StringSelection llllllllllllllllllIllIIlllIIIlll = new StringSelection(llllllllllllllllllIllIIlllIIlIIl);
        Clipboard llllllllllllllllllIllIIlllIIIlIl = Toolkit.getDefaultToolkit().getSystemClipboard();
        llllllllllllllllllIllIIlllIIIlIl.setContents(llllllllllllllllllIllIIlllIIIlll, null);
        Command.sendClientMessage(String.valueOf(new StringBuilder().append("Copied '").append(llllllllllllllllllIllIIlllIIIIll.server).append("' to clipboard.")));
        llllllllllllllllllIllIIlllIIIIll.disable();
    }

    public CopyIp() {
        super("CopyIp", Module.Category.MISC);
        CopyIp llllllllllllllllllIllIIlllllIIIl;
    }
}

