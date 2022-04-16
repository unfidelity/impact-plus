/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 */
package me.axua.impactplus.command;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.ArrayList;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.command.commands.AutoEzCommand;
import me.axua.impactplus.command.commands.BindCommand;
import me.axua.impactplus.command.commands.BrownCommand;
import me.axua.impactplus.command.commands.CmdsCommand;
import me.axua.impactplus.command.commands.ConfigCommand;
import me.axua.impactplus.command.commands.DevCommand;
import me.axua.impactplus.command.commands.DrawnCommand;
import me.axua.impactplus.command.commands.FixCommand;
import me.axua.impactplus.command.commands.FriendCommand;
import me.axua.impactplus.command.commands.ModsCommand;
import me.axua.impactplus.command.commands.OpenFolderCommand;
import me.axua.impactplus.command.commands.PrefixCommand;
import me.axua.impactplus.command.commands.RainbowSpeedCommand;
import me.axua.impactplus.command.commands.SetCommand;
import me.axua.impactplus.command.commands.ToggleCommand;

public class CommandManager {
    /* synthetic */ boolean b;
    private static /* synthetic */ ArrayList<Command> commands;

    public static ArrayList<Command> getCommands() {
        return commands;
    }

    public void callCommand(String lllllllllllllllIllllIllIIIIlIllI) {
        CommandManager lllllllllllllllIllllIllIIIIlllll;
        String[] lllllllllllllllIllllIllIIIIlllII = lllllllllllllllIllllIllIIIIlIllI.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        String lllllllllllllllIllllIllIIIIllIlI = lllllllllllllllIllllIllIIIIlllII[0];
        String lllllllllllllllIllllIllIIIIllIIl = lllllllllllllllIllllIllIIIIlIllI.substring(lllllllllllllllIllllIllIIIIllIlI.length()).trim();
        lllllllllllllllIllllIllIIIIlllll.b = false;
        commands.forEach(lllllllllllllllIllllIlIllllllIIl -> {
            for (String lllllllllllllllIllllIlIlllllllIl : lllllllllllllllIllllIlIllllllIIl.getAlias()) {
                if (!lllllllllllllllIllllIlIlllllllIl.equalsIgnoreCase(lllllllllllllllIllllIllIIIIllIlI)) continue;
                lllllllllllllllIllllIlIlllllllII.b = true;
                try {
                    lllllllllllllllIllllIlIllllllIIl.onCommand(lllllllllllllllIllllIllIIIIllIIl, lllllllllllllllIllllIllIIIIllIIl.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"));
                }
                catch (Exception lllllllllllllllIllllIlIllllllllI) {
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.DARK_RED).append(lllllllllllllllIllllIlIllllllIIl.getSyntax())));
                }
            }
        });
        if (!lllllllllllllllIllllIllIIIIlllll.b) {
            Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.DARK_RED).append("Unknown command!")));
        }
    }

    public CommandManager() {
        CommandManager lllllllllllllllIllllIllIIIlIllll;
    }

    public static void addCommand(Command lllllllllllllllIllllIllIIIlIIlll) {
        commands.add(lllllllllllllllIllllIllIIIlIIlll);
    }

    public static void initCommands() {
        commands = new ArrayList();
        CommandManager.addCommand(new BindCommand());
        CommandManager.addCommand(new ToggleCommand());
        CommandManager.addCommand(new DrawnCommand());
        CommandManager.addCommand(new SetCommand());
        CommandManager.addCommand(new CmdsCommand());
        CommandManager.addCommand(new ModsCommand());
        CommandManager.addCommand(new PrefixCommand());
        CommandManager.addCommand(new FriendCommand());
        CommandManager.addCommand(new RainbowSpeedCommand());
        CommandManager.addCommand(new ConfigCommand());
        CommandManager.addCommand(new OpenFolderCommand());
        CommandManager.addCommand(new DevCommand());
        CommandManager.addCommand(new FixCommand());
        CommandManager.addCommand(new BrownCommand());
        CommandManager.addCommand(new AutoEzCommand());
    }
}

