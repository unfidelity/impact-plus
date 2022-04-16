/*
 * Decompiled with CFR 0.152.
 */
package me.axua.impactplus.command.commands;

import java.awt.Desktop;
import java.io.File;
import me.axua.impactplus.command.Command;

public class OpenFolderCommand
extends Command {
    @Override
    public void onCommand(String lllllllllllllllllIIlIlIlIIllIIlI, String[] lllllllllllllllllIIlIlIlIIllIIIl) throws Exception {
        try {
            Desktop.getDesktop().open(new File("Impact+"));
        }
        catch (Exception lllllllllllllllllIIlIlIlIIllIlII) {
            OpenFolderCommand.sendClientMessage(String.valueOf(new StringBuilder().append("Error: ").append(lllllllllllllllllIIlIlIlIIllIlII.getMessage())));
        }
    }

    @Override
    public String[] getAlias() {
        return new String[]{"openfolder", "folder"};
    }

    public OpenFolderCommand() {
        OpenFolderCommand lllllllllllllllllIIlIlIlIlIIIIII;
    }

    @Override
    public String getSyntax() {
        return "openfolder";
    }
}

