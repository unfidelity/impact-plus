/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;

public class SetCommand
extends Command {
    @Override
    public String getSyntax() {
        return "set <Module> <Setting> <Value>";
    }

    @Override
    public String[] getAlias() {
        return new String[]{"set"};
    }

    @Override
    public void onCommand(String lIllIlIllllIIll, String[] lIllIlIllllIIlI) throws Exception {
        for (Module lIllIlIllllIlIl : ModuleManager.getModules()) {
            if (!lIllIlIllllIlIl.getName().equalsIgnoreCase(lIllIlIllllIIlI[0])) continue;
        }
    }

    public SetCommand() {
        SetCommand lIllIlIllllllII;
    }
}

