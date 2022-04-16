/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;

public class FixCommand
extends Command {
    @Override
    public String[] getAlias() {
        return new String[]{"fix"};
    }

    @Override
    public void onCommand(String llllIlIIlIlIIlI, String[] llllIlIIlIlIIIl) throws Exception {
        try {
            for (Module llllIlIIlIlIlIl : ModuleManager.getModules()) {
                llllIlIIlIlIlIl.disable();
            }
            ImpactPlus.getInstance().configUtils.loadMods();
            Command.sendClientMessage("Fixed");
        }
        catch (Exception llllIlIIlIlIlII) {
            Command.sendClientMessage("Error");
            llllIlIIlIlIlII.printStackTrace();
        }
    }

    @Override
    public String getSyntax() {
        return "fixed thing";
    }

    public FixCommand() {
        FixCommand llllIlIIlIllIlI;
    }
}

