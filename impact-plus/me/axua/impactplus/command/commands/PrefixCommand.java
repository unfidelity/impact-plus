/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.command.Command;

public class PrefixCommand
extends Command {
    @Override
    public void onCommand(String llllllllllllllllIllIlIllllIIIlIl, String[] llllllllllllllllIllIlIllllIIIIll) throws Exception {
        Command.setPrefix(llllllllllllllllIllIlIllllIIIIll[0]);
        Command.sendClientMessage(String.valueOf(new StringBuilder().append("Command prefix set to ").append(Command.getPrefix())));
    }

    public PrefixCommand() {
        PrefixCommand llllllllllllllllIllIlIllllIIlIll;
    }

    @Override
    public String getSyntax() {
        return "prefix <character>";
    }

    @Override
    public String[] getAlias() {
        return new String[]{"prefix", "setprefix"};
    }
}

