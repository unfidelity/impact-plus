/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package me.axua.impactplus.command.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.ModuleManager;

public class DrawnCommand
extends Command {
    /* synthetic */ boolean found;

    @Override
    public void onCommand(String llllllllllllllllIlIlIIlIIlllIIll, String[] llllllllllllllllIlIlIIlIIllIllIl) throws Exception {
        DrawnCommand llllllllllllllllIlIlIIlIIllIllll;
        llllllllllllllllIlIlIIlIIllIllll.found = false;
        ModuleManager.getModules().forEach(llllllllllllllllIlIlIIlIIllIIIIl -> {
            if (llllllllllllllllIlIlIIlIIllIIIIl.getName().equalsIgnoreCase(llllllllllllllllIlIlIIlIIllIllIl[0])) {
                if (llllllllllllllllIlIlIIlIIllIIIIl.isDrawn()) {
                    llllllllllllllllIlIlIIlIIllIIIIl.setDrawn(false);
                    llllllllllllllllIlIlIIlIIllIIIll.found = true;
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIlIlIIlIIllIIIIl.getName()).append(ChatFormatting.RED).append(" is now not drawn")));
                } else if (!llllllllllllllllIlIlIIlIIllIIIIl.isDrawn()) {
                    llllllllllllllllIlIlIIlIIllIIIIl.setDrawn(true);
                    llllllllllllllllIlIlIIlIIllIIIll.found = true;
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIlIlIIlIIllIIIIl.getName()).append(ChatFormatting.GREEN).append(" is now drawn")));
                }
            }
        });
        if (!llllllllllllllllIlIlIIlIIllIllll.found && llllllllllllllllIlIlIIlIIllIllIl.length == 1) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.DARK_RED).append("Module not found!")));
        }
    }

    @Override
    public String[] getAlias() {
        return new String[]{"drawn", "visible", "d"};
    }

    @Override
    public String getSyntax() {
        return "drawn <Module>";
    }

    public DrawnCommand() {
        DrawnCommand llllllllllllllllIlIlIIlIlIIIIlII;
    }
}

