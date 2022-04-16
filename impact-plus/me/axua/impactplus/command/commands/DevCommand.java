/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.command.Command;
import net.minecraft.client.Minecraft;

public class DevCommand
extends Command {
    @Override
    public void onCommand(String llIlIIllllIIll, String[] llIlIIllllIIlI) throws Exception {
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/time set day");
        Minecraft.getMinecraft().thePlayer.sendChatMessage("/weather clear");
    }

    public DevCommand() {
        DevCommand llIlIIllllIlll;
    }

    @Override
    public String getSyntax() {
        return "-dev";
    }

    @Override
    public String[] getAlias() {
        return new String[]{"dev"};
    }
}

