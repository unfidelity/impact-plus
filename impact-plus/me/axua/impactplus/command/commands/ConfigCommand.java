/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.ShutDownHook;
import me.axua.impactplus.command.Command;

public class ConfigCommand
extends Command {
    public ConfigCommand() {
        ConfigCommand llllllllllllllllIlIlllIllllllIlI;
    }

    @Override
    public String getSyntax() {
        return "saveconfig";
    }

    @Override
    public String[] getAlias() {
        return new String[]{"saveconfig", "savecfg"};
    }

    @Override
    public void onCommand(String llllllllllllllllIlIlllIlllllIlIl, String[] llllllllllllllllIlIlllIlllllIlII) throws Exception {
        ShutDownHook.saveConfig();
        Command.sendClientMessage("Config saved");
    }
}

