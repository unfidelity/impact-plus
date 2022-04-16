/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGameOver
 */
package me.axua.impactplus.module.modules.chat;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.events.GuiScreenDisplayedEvent;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.client.gui.GuiGameOver;

public class DeathCoords
extends Module {
    @EventHandler
    private /* synthetic */ Listener<GuiScreenDisplayedEvent> listener;
    /* synthetic */ Setting.b chat;

    @Override
    public void onEnable() {
        DeathCoords lllIllllIIIlIII;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllIllllIIIlIII);
    }

    private String GetDimensionName() {
        switch (DeathCoords.mc.thePlayer.dimension) {
            case -1: {
                return "Nether";
            }
            case 0: {
                return "Overworld";
            }
            case 1: {
                return "End";
            }
        }
        return "Void";
    }

    @Override
    public void onDisable() {
        DeathCoords lllIllllIIIIlIl;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllIllllIIIIlIl);
    }

    public DeathCoords() {
        super("DeathCoords", Module.Category.CHAT);
        DeathCoords lllIllllIIIlllI;
        lllIllllIIIlllI.listener = new Listener<GuiScreenDisplayedEvent>(lllIlllIlllIlIl -> {
            if (lllIlllIlllIlIl.getScreen() instanceof GuiGameOver) {
                DeathCoords lllIlllIlllIllI;
                String lllIlllIllllIIl;
                String string = lllIlllIllllIIl = mc.getCurrentServerData() != null ? DeathCoords.mc.getCurrentServerData().serverIP : "Singleplayer";
                if (lllIlllIlllIllI.chat.getValue()) {
                    Command.sendClientMessage(String.format("You died at x%d y%d z%d", (int)DeathCoords.mc.thePlayer.posX, (int)DeathCoords.mc.thePlayer.posY, (int)DeathCoords.mc.thePlayer.posZ));
                }
                try {
                    BufferedWriter lllIlllIlllllIl = new BufferedWriter(new FileWriter("Impact+\\DeathCoords.txt", true));
                    Calendar lllIlllIlllllII = Calendar.getInstance();
                    SimpleDateFormat lllIlllIllllIll = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    lllIlllIlllllIl.write(String.format("You died at x%s, y%s, z%s on %s in the %s at [%s]", (int)DeathCoords.mc.thePlayer.posX, (int)DeathCoords.mc.thePlayer.posY, (int)DeathCoords.mc.thePlayer.posZ, lllIlllIllllIIl, lllIlllIlllIllI.GetDimensionName(), lllIlllIllllIll.format(lllIlllIlllllII.getTime())));
                    lllIlllIlllllIl.newLine();
                    lllIlllIlllllIl.close();
                }
                catch (IOException lllIlllIllllIlI) {
                    lllIlllIllllIlI.printStackTrace();
                }
            }
        }, new Predicate[0]);
    }

    @Override
    public void setup() {
        DeathCoords lllIllllIIIlIll;
        lllIllllIIIlIll.chat = lllIllllIIIlIll.registerB("Chat", true);
    }
}

