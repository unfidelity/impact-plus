/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.module.modules.misc;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import me.axua.impactplus.module.Module;

public class Notifications
extends Module {
    public Notifications() {
        super("Notifications", Module.Category.MISC, "Desktop notifications");
        Notifications llllllllllllllllIllIlIIIlIlIlllI;
    }

    public static void sendNotification(String llllllllllllllllIllIlIIIlIlIIllI, TrayIcon.MessageType llllllllllllllllIllIlIIIlIlIIIII) {
        SystemTray llllllllllllllllIllIlIIIlIlIIlII = SystemTray.getSystemTray();
        Image llllllllllllllllIllIlIIIlIlIIIll = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon llllllllllllllllIllIlIIIlIlIIIlI = new TrayIcon(llllllllllllllllIllIlIIIlIlIIIll, "Impact+");
        llllllllllllllllIllIlIIIlIlIIIlI.setImageAutoSize(true);
        llllllllllllllllIllIlIIIlIlIIIlI.setToolTip("Impact+");
        try {
            llllllllllllllllIllIlIIIlIlIIlII.add(llllllllllllllllIllIlIIIlIlIIIlI);
        }
        catch (AWTException llllllllllllllllIllIlIIIlIlIIlll) {
            llllllllllllllllIllIlIIIlIlIIlll.printStackTrace();
        }
        llllllllllllllllIllIlIIIlIlIIIlI.displayMessage("Impact+", llllllllllllllllIllIlIIIlIlIIllI, llllllllllllllllIllIlIIIlIlIIIII);
    }
}

