/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.ModuleManager;
import org.lwjgl.input.Keyboard;

public class BindCommand
extends Command {
    public BindCommand() {
        BindCommand lIIIllIlIlIII;
    }

    @Override
    public String getSyntax() {
        return "bind <Module> <Key>";
    }

    @Override
    public void onCommand(String lIIIllIlIIIIl, String[] lIIIllIlIIIII) throws Exception {
        int lIIIllIIlllll = Keyboard.getKeyIndex((String)lIIIllIlIIIII[1].toUpperCase());
        ModuleManager.getModules().forEach(lIIIllIIlIlII -> {
            if (lIIIllIlIIIII[0].equalsIgnoreCase(lIIIllIIlIlII.getName())) {
                lIIIllIIlIlII.setBind(lIIIllIIlllll);
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(lIIIllIlIIIII[0]).append(" bound to ").append(lIIIllIlIIIII[1].toUpperCase())));
            }
        });
    }

    @Override
    public String[] getAlias() {
        return new String[]{"bind", "b"};
    }
}

