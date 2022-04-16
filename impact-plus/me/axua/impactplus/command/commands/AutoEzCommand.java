/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.modules.chat.AutoEz;

public class AutoEzCommand
extends Command {
    @Override
    public void onCommand(String llIIIllIlIIlIII, String[] llIIIllIlIIIlIl) throws Exception {
        String llIIIllIlIIIllI = llIIIllIlIIIlIl[1].replace("_", " ");
        if (llIIIllIlIIIlIl[0].equalsIgnoreCase("add")) {
            if (!AutoEz.getAutoEzMessages().contains(llIIIllIlIIIllI)) {
                AutoEz.addAutoEzMessage(llIIIllIlIIIllI);
                Command.sendClientMessage(String.valueOf(new StringBuilder().append("Added AutoEZ message: ").append(llIIIllIlIIIllI)));
            } else {
                Command.sendClientMessage(String.valueOf(new StringBuilder().append("AutoEZ list doesn't contain ").append(llIIIllIlIIIllI)));
            }
        } else if (llIIIllIlIIIlIl[0].equalsIgnoreCase("del") || llIIIllIlIIIlIl[0].equalsIgnoreCase("remove")) {
            AutoEz.getAutoEzMessages().remove(llIIIllIlIIIllI);
            Command.sendClientMessage(String.valueOf(new StringBuilder().append("Removed AutoEZ message: ").append(llIIIllIlIIIllI)));
        }
    }

    @Override
    public String getSyntax() {
        return "autoez <add | del> <message> (use \"{name}\" for the player's name, use \"_\" for spaces)";
    }

    public AutoEzCommand() {
        AutoEzCommand llIIIllIlIIlllI;
    }

    @Override
    public String[] getAlias() {
        return new String[]{"autoez"};
    }
}

