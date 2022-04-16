/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.entity.Entity
 */
package me.axua.impactplus.module.modules.chat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.List;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.misc.Notifications;
import me.axua.impactplus.setting.Setting;
import net.minecraft.entity.Entity;

public class VisualRange
extends Module {
    private /* synthetic */ List<String> peopletoremove;
    private /* synthetic */ List<String> peopleinarea;
    public /* synthetic */ Setting.b notfication;

    @Override
    public void onUpdate() {
        VisualRange llIIIIIIlIllll;
        if (VisualRange.mc.theWorld == null | VisualRange.mc.thePlayer == null) {
            return;
        }
        ArrayList<String> llIIIIIIlIlllI = new ArrayList<String>();
        List llIIIIIIlIllIl = VisualRange.mc.theWorld.playerEntities;
        for (Entity llIIIIIIllIIll : llIIIIIIlIllIl) {
            if (llIIIIIIllIIll.getName().equals(VisualRange.mc.thePlayer.getName())) continue;
            llIIIIIIlIlllI.add(llIIIIIIllIIll.getName());
        }
        if (llIIIIIIlIlllI.size() > 0) {
            for (String llIIIIIIllIIlI : llIIIIIIlIlllI) {
                if (llIIIIIIlIllll.peopleinarea.contains(llIIIIIIllIIlI)) continue;
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.DARK_AQUA).append(llIIIIIIllIIlI).append(ChatFormatting.GREEN).append(" just entered visual range")));
                if (llIIIIIIlIllll.notfication.getValue()) {
                    Notifications.sendNotification(String.valueOf(new StringBuilder().append(llIIIIIIllIIlI).append(" just entered visual range")), TrayIcon.MessageType.INFO);
                }
                llIIIIIIlIllll.peopleinarea.add(llIIIIIIllIIlI);
            }
        }
        if (llIIIIIIlIllll.peopleinarea.size() > 0) {
            for (String llIIIIIIllIIIl : llIIIIIIlIllll.peopleinarea) {
                if (llIIIIIIlIlllI.contains(llIIIIIIllIIIl)) continue;
                llIIIIIIlIllll.peopletoremove.add(llIIIIIIllIIIl);
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.DARK_AQUA).append(llIIIIIIllIIIl).append(ChatFormatting.RED).append(" just left visual range")));
                if (!llIIIIIIlIllll.notfication.getValue()) continue;
                Notifications.sendNotification(String.valueOf(new StringBuilder().append(llIIIIIIllIIIl).append(" just left visual range")), TrayIcon.MessageType.INFO);
            }
            if (llIIIIIIlIllll.peopletoremove.size() > 0) {
                for (String llIIIIIIllIIII : llIIIIIIlIllll.peopletoremove) {
                    llIIIIIIlIllll.peopleinarea.remove(llIIIIIIllIIII);
                }
                llIIIIIIlIllll.peopletoremove.clear();
            }
        }
    }

    @Override
    public void onEnable() {
        llIIIIIIllllII.peopleinarea = new ArrayList<String>();
        llIIIIIIllllII.peopletoremove = new ArrayList<String>();
    }

    @Override
    public void onDisable() {
        VisualRange llIIIIIIlllIlI;
        llIIIIIIlllIlI.peopleinarea.clear();
        llIIIIIIlllIlI.peopletoremove.clear();
    }

    public VisualRange() {
        super("VisualRange", Module.Category.CHAT, "Sends a client side message when someone enters your render distance");
        VisualRange llIIIIIlIIIIll;
    }

    @Override
    public void setup() {
        VisualRange llIIIIIlIIIIII;
        llIIIIIlIIIIII.notfication = llIIIIIlIIIIII.registerB("Notfication", false);
    }
}

