/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package me.axua.impactplus.command.commands;

import com.google.common.base.Strings;
import com.mojang.realmsclient.gui.ChatFormatting;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.util.Wrapper;

public class ToggleCommand
extends Command {
    @Override
    public String[] getAlias() {
        return new String[]{"toggle", "t"};
    }

    public ToggleCommand() {
        ToggleCommand llllllllllllllllIIlIIllIIIIllIll;
    }

    @Override
    public String getSyntax() {
        return "toggle <Module>";
    }

    @Override
    public void onCommand(String llllllllllllllllIIlIIlIlllllllIl, String[] llllllllllllllllIIlIIlIllllllIII) throws Exception {
        if (llllllllllllllllIIlIIlIllllllIII.length < 1 || Strings.isNullOrEmpty((String)llllllllllllllllIIlIIlIllllllIII[0])) {
            ToggleCommand llllllllllllllllIIlIIlIllllllIIl;
            Wrapper.sendErrorMessage(llllllllllllllllIIlIIlIllllllIIl.getSyntax());
            return;
        }
        ModuleManager cfr_ignored_0 = Wrapper.mod.moduleManager;
        Module llllllllllllllllIIlIIlIllllllIlI = ModuleManager.getModuleByName(llllllllllllllllIIlIIlIllllllIII[0]);
        if (llllllllllllllllIIlIIlIllllllIlI == null) {
            Wrapper.sendErrorMessage(String.valueOf(new StringBuilder().append("Unknown Module: ").append(llllllllllllllllIIlIIlIllllllIII[0])));
            return;
        }
        llllllllllllllllIIlIIlIllllllIlI.toggle();
        ModuleManager cfr_ignored_1 = Wrapper.mod.moduleManager;
        if (!ModuleManager.isModuleEnabled("ToggleMessages")) {
            Command.sendClientMessage(llllllllllllllllIIlIIlIllllllIlI.isEnabled() ? String.valueOf(new StringBuilder().append(llllllllllllllllIIlIIlIllllllIlI.getName()).append(ChatFormatting.GREEN).append(" enabled")) : String.valueOf(new StringBuilder().append(llllllllllllllllIIlIIlIllllllIlI.getName()).append(ChatFormatting.RED).append(" disabled")));
        }
    }
}

