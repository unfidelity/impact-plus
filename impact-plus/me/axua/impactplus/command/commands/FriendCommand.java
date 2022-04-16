/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.friends.Friends;

public class FriendCommand
extends Command {
    @Override
    public void onCommand(String lllllllllllllllllIIllIIIIIIlllII, String[] lllllllllllllllllIIllIIIIIIllIII) throws Exception {
        if (lllllllllllllllllIIllIIIIIIllIII[0].equalsIgnoreCase("add")) {
            if (Friends.isFriend(lllllllllllllllllIIllIIIIIIllIII[1])) {
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(lllllllllllllllllIIllIIIIIIllIII[1]).append(" is already a friend!")));
                return;
            }
            if (!Friends.isFriend(lllllllllllllllllIIllIIIIIIllIII[1])) {
                ImpactPlus.getInstance().friends.addFriend(lllllllllllllllllIIllIIIIIIllIII[1]);
                Command.sendClientMessage(String.valueOf(new StringBuilder().append("Added ").append(lllllllllllllllllIIllIIIIIIllIII[1]).append(" to friends list")));
            }
        }
        if (lllllllllllllllllIIllIIIIIIllIII[0].equalsIgnoreCase("del") || lllllllllllllllllIIllIIIIIIllIII[0].equalsIgnoreCase("remove")) {
            if (!Friends.isFriend(lllllllllllllllllIIllIIIIIIllIII[1])) {
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(lllllllllllllllllIIllIIIIIIllIII[1]).append(" is not a friend!")));
                return;
            }
            if (Friends.isFriend(lllllllllllllllllIIllIIIIIIllIII[1])) {
                ImpactPlus.getInstance().friends.delFriend(lllllllllllllllllIIllIIIIIIllIII[1]);
                Command.sendClientMessage(String.valueOf(new StringBuilder().append("Removed ").append(lllllllllllllllllIIllIIIIIIllIII[1]).append(" from friends list")));
            }
        }
    }

    @Override
    public String[] getAlias() {
        return new String[]{"friend", "friends", "f"};
    }

    public FriendCommand() {
        FriendCommand lllllllllllllllllIIllIIIIIllIIll;
    }

    @Override
    public String getSyntax() {
        return "friend <add | del> <Name>";
    }
}

