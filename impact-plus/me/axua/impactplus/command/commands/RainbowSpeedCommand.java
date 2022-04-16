/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package me.axua.impactplus.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.event.EventProcessor;

public class RainbowSpeedCommand
extends Command {
    @Override
    public String[] getAlias() {
        return new String[]{"rainbowspeed", "rainbow"};
    }

    public RainbowSpeedCommand() {
        RainbowSpeedCommand lllllllllllllllllllIIIlllllIlIII;
    }

    @Override
    public void onCommand(String lllllllllllllllllllIIIllllIlIIIl, String[] lllllllllllllllllllIIIllllIlIIII) throws Exception {
        if (lllllllllllllllllllIIIllllIlIIII.length == 1) {
            int lllllllllllllllllllIIIllllIlIIll = Integer.parseInt(lllllllllllllllllllIIIllllIlIIII[0]);
            if (lllllllllllllllllllIIIllllIlIIll <= 0) {
                EventProcessor.INSTANCE.setRainbowSpeed(0);
            } else {
                EventProcessor.INSTANCE.setRainbowSpeed(lllllllllllllllllllIIIllllIlIIll);
            }
            Command.sendClientMessage(String.valueOf(new StringBuilder().append("Rainbow speed set to ").append(lllllllllllllllllllIIIllllIlIIll)));
        } else {
            RainbowSpeedCommand lllllllllllllllllllIIIllllIlIIlI;
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append(lllllllllllllllllllIIIllllIlIIlI.getSyntax())));
        }
    }

    @Override
    public String getSyntax() {
        return "rainbowspeed <speed>";
    }
}

