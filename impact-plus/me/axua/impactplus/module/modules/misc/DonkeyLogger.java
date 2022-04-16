/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.passive.EntityDonkey
 *  net.minecraft.entity.passive.EntityLlama
 *  net.minecraft.entity.passive.EntityMule
 */
package me.axua.impactplus.module.modules.misc;

import java.awt.TrayIcon;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.modules.misc.Notifications;
import me.axua.impactplus.setting.Setting;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMule;

public class DonkeyLogger
extends Module {
    /* synthetic */ List<Entity> Donkeys;
    /* synthetic */ List<Entity> Llamas;
    /* synthetic */ List<Entity> Mules;
    /* synthetic */ List<Entity> knownMules;
    /* synthetic */ List<Entity> knownDonkeys;
    /* synthetic */ Setting.b notification;
    /* synthetic */ List<Entity> knownLlamas;
    /* synthetic */ Setting.b logllama;
    /* synthetic */ Setting.b logmule;
    /* synthetic */ Setting.b logdonkey;

    public DonkeyLogger() {
        super("DonkeyAlert", Module.Category.MISC);
        DonkeyLogger llllllllllllllllIlIIlIllIlllIllI;
        llllllllllllllllIlIIlIllIlllIllI.knownDonkeys = new ArrayList<Entity>();
        llllllllllllllllIlIIlIllIlllIllI.knownLlamas = new ArrayList<Entity>();
        llllllllllllllllIlIIlIllIlllIllI.knownMules = new ArrayList<Entity>();
    }

    @Override
    public void onUpdate() {
        DonkeyLogger llllllllllllllllIlIIlIllIlIIllll;
        if (llllllllllllllllIlIIlIllIlIIllll.logdonkey.getValue()) {
            llllllllllllllllIlIIlIllIlIIllll.Donkeys = DonkeyLogger.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIlIIlIllIIlllIlI -> llllllllllllllllIlIIlIllIIlllIlI instanceof EntityDonkey).collect(Collectors.toList());
            try {
                for (Entity llllllllllllllllIlIIlIllIlIllIIl : llllllllllllllllIlIIlIllIlIIllll.Donkeys) {
                    if (!(llllllllllllllllIlIIlIllIlIllIIl instanceof EntityDonkey) || llllllllllllllllIlIIlIllIlIIllll.knownDonkeys.contains(llllllllllllllllIlIIlIllIlIllIIl)) continue;
                    llllllllllllllllIlIIlIllIlIIllll.knownDonkeys.add(llllllllllllllllIlIIlIllIlIllIIl);
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append("Found a ").append(llllllllllllllllIlIIlIllIlIllIIl.getName()).append(" at x").append(llllllllllllllllIlIIlIllIlIllIIl.getPosition().getX()).append(" y").append(llllllllllllllllIlIIlIllIlIllIIl.getPosition().getY()).append(" z").append(llllllllllllllllIlIIlIllIlIllIIl.getPosition().getZ())));
                    if (!llllllllllllllllIlIIlIllIlIIllll.notification.getValue()) continue;
                    Notifications.sendNotification(String.valueOf(new StringBuilder().append("Found a ").append(llllllllllllllllIlIIlIllIlIllIIl.getName()).append(" at x").append(llllllllllllllllIlIIlIllIlIllIIl.getPosition().getX()).append(" y").append(llllllllllllllllIlIIlIllIlIllIIl.getPosition().getY()).append(" z").append(llllllllllllllllIlIIlIllIlIllIIl.getPosition().getZ())), TrayIcon.MessageType.INFO);
                }
            }
            catch (Exception llllllllllllllllIlIIlIllIlIIlIll) {
                // empty catch block
            }
            try {
                for (Entity llllllllllllllllIlIIlIllIlIlIlll : llllllllllllllllIlIIlIllIlIIllll.knownDonkeys) {
                    if (!(llllllllllllllllIlIIlIllIlIlIlll instanceof EntityDonkey) || llllllllllllllllIlIIlIllIlIIllll.Donkeys.contains(llllllllllllllllIlIIlIllIlIlIlll)) continue;
                    llllllllllllllllIlIIlIllIlIIllll.knownDonkeys.remove(llllllllllllllllIlIIlIllIlIlIlll);
                }
            }
            catch (Exception llllllllllllllllIlIIlIllIlIIlIll) {
                // empty catch block
            }
        }
        if (llllllllllllllllIlIIlIllIlIIllll.logllama.getValue()) {
            llllllllllllllllIlIIlIllIlIIllll.Llamas = DonkeyLogger.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIlIIlIllIIlllllI -> llllllllllllllllIlIIlIllIIlllllI instanceof EntityLlama).collect(Collectors.toList());
            try {
                for (Entity llllllllllllllllIlIIlIllIlIlIllI : llllllllllllllllIlIIlIllIlIIllll.Llamas) {
                    if (!(llllllllllllllllIlIIlIllIlIlIllI instanceof EntityLlama) || llllllllllllllllIlIIlIllIlIIllll.knownLlamas.contains(llllllllllllllllIlIIlIllIlIlIllI)) continue;
                    llllllllllllllllIlIIlIllIlIIllll.knownLlamas.add(llllllllllllllllIlIIlIllIlIlIllI);
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append("Found a ").append(llllllllllllllllIlIIlIllIlIlIllI.getName()).append(" at x").append(llllllllllllllllIlIIlIllIlIlIllI.getPosition().getX()).append(" y").append(llllllllllllllllIlIIlIllIlIlIllI.getPosition().getY()).append(" z").append(llllllllllllllllIlIIlIllIlIlIllI.getPosition().getZ())));
                    if (!llllllllllllllllIlIIlIllIlIIllll.notification.getValue()) continue;
                    Notifications.sendNotification(String.valueOf(new StringBuilder().append("Found a ").append(llllllllllllllllIlIIlIllIlIlIllI.getName()).append(" at x").append(llllllllllllllllIlIIlIllIlIlIllI.getPosition().getX()).append(" y").append(llllllllllllllllIlIIlIllIlIlIllI.getPosition().getY()).append(" z").append(llllllllllllllllIlIIlIllIlIlIllI.getPosition().getZ())), TrayIcon.MessageType.INFO);
                }
            }
            catch (Exception llllllllllllllllIlIIlIllIlIIlIll) {
                // empty catch block
            }
            try {
                for (Entity llllllllllllllllIlIIlIllIlIlIlII : llllllllllllllllIlIIlIllIlIIllll.knownLlamas) {
                    if (!(llllllllllllllllIlIIlIllIlIlIlII instanceof EntityLlama) || llllllllllllllllIlIIlIllIlIIllll.Llamas.contains(llllllllllllllllIlIIlIllIlIlIlII)) continue;
                    llllllllllllllllIlIIlIllIlIIllll.knownLlamas.remove(llllllllllllllllIlIIlIllIlIlIlII);
                }
            }
            catch (Exception llllllllllllllllIlIIlIllIlIIlIll) {
                // empty catch block
            }
        }
        if (llllllllllllllllIlIIlIllIlIIllll.logmule.getValue()) {
            llllllllllllllllIlIIlIllIlIIllll.Mules = DonkeyLogger.mc.theWorld.loadedEntityList.stream().filter(llllllllllllllllIlIIlIllIlIIIIIl -> llllllllllllllllIlIIlIllIlIIIIIl instanceof EntityMule).collect(Collectors.toList());
            try {
                for (Entity llllllllllllllllIlIIlIllIlIlIIlI : llllllllllllllllIlIIlIllIlIIllll.Mules) {
                    if (!(llllllllllllllllIlIIlIllIlIlIIlI instanceof EntityMule) || llllllllllllllllIlIIlIllIlIIllll.knownMules.contains(llllllllllllllllIlIIlIllIlIlIIlI)) continue;
                    llllllllllllllllIlIIlIllIlIIllll.knownMules.add(llllllllllllllllIlIIlIllIlIlIIlI);
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append("Found a ").append(llllllllllllllllIlIIlIllIlIlIIlI.getName()).append(" at x").append(llllllllllllllllIlIIlIllIlIlIIlI.getPosition().getX()).append(" y").append(llllllllllllllllIlIIlIllIlIlIIlI.getPosition().getY()).append(" z").append(llllllllllllllllIlIIlIllIlIlIIlI.getPosition().getZ())));
                    if (!llllllllllllllllIlIIlIllIlIIllll.notification.getValue()) continue;
                    Notifications.sendNotification(String.valueOf(new StringBuilder().append("Found a ").append(llllllllllllllllIlIIlIllIlIlIIlI.getName()).append(" at x").append(llllllllllllllllIlIIlIllIlIlIIlI.getPosition().getX()).append(" y").append(llllllllllllllllIlIIlIllIlIlIIlI.getPosition().getY()).append(" z").append(llllllllllllllllIlIIlIllIlIlIIlI.getPosition().getZ())), TrayIcon.MessageType.INFO);
                }
            }
            catch (Exception llllllllllllllllIlIIlIllIlIIlIll) {
                // empty catch block
            }
            try {
                for (Entity llllllllllllllllIlIIlIllIlIlIIII : llllllllllllllllIlIIlIllIlIIllll.knownMules) {
                    if (!(llllllllllllllllIlIIlIllIlIlIIII instanceof EntityMule) || llllllllllllllllIlIIlIllIlIIllll.Mules.contains(llllllllllllllllIlIIlIllIlIlIIII)) continue;
                    llllllllllllllllIlIIlIllIlIIllll.knownMules.remove(llllllllllllllllIlIIlIllIlIlIIII);
                }
            }
            catch (Exception llllllllllllllllIlIIlIllIlIIlIll) {
                // empty catch block
            }
        }
    }

    @Override
    public void setup() {
        DonkeyLogger llllllllllllllllIlIIlIllIlllIIll;
        llllllllllllllllIlIIlIllIlllIIll.logdonkey = llllllllllllllllIlIIlIllIlllIIll.registerB("LogDonkeys", true);
        llllllllllllllllIlIIlIllIlllIIll.logllama = llllllllllllllllIlIIlIllIlllIIll.registerB("LogLlamas", false);
        llllllllllllllllIlIIlIllIlllIIll.logmule = llllllllllllllllIlIIlIllIlllIIll.registerB("LogMules", false);
        llllllllllllllllIlIIlIllIlllIIll.notification = llllllllllllllllIlIIlIllIlllIIll.registerB("Notificaion", false);
    }

    @Override
    public void onDisable() {
        DonkeyLogger llllllllllllllllIlIIlIllIlIIIlIl;
        llllllllllllllllIlIIlIllIlIIIlIl.knownDonkeys.clear();
        llllllllllllllllIlIIlIllIlIIIlIl.knownLlamas.clear();
        llllllllllllllllIlIIlIllIlIIIlIl.knownMules.clear();
    }
}

