/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraft.util.text.event.HoverEvent$Action
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.command.Command;
import me.axua.impactplus.command.CommandManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.HoverEvent;

public class CmdsCommand
extends Command {
    @Override
    public String[] getAlias() {
        return new String[]{"commands", "cmds"};
    }

    public CmdsCommand() {
        CmdsCommand llllllllllllllllllIlIllIIlIlIIII;
    }

    @Override
    public void onCommand(String llllllllllllllllllIlIllIIIlIlIlI, String[] llllllllllllllllllIlIllIIIlIlIIl) throws Exception {
        int llllllllllllllllllIlIllIIIlIlIII = CommandManager.getCommands().size();
        TextComponentString llllllllllllllllllIlIllIIIlIIlll = new TextComponentString("\u00a77Commands: ");
        for (int llllllllllllllllllIlIllIIIlIllII = 0; llllllllllllllllllIlIllIIIlIllII < llllllllllllllllllIlIllIIIlIlIII; ++llllllllllllllllllIlIllIIIlIllII) {
            Command llllllllllllllllllIlIllIIIlIllIl = CommandManager.getCommands().get(llllllllllllllllllIlIllIIIlIllII);
            if (llllllllllllllllllIlIllIIIlIllIl == null) continue;
            llllllllllllllllllIlIllIIIlIIlll.appendSibling(new TextComponentString(String.valueOf(new StringBuilder().append(llllllllllllllllllIlIllIIIlIllIl.getAlias()[0]).append(llllllllllllllllllIlIllIIIlIllII == llllllllllllllllllIlIllIIIlIlIII - 1 ? "" : ", "))).setChatStyle(new Style().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString(llllllllllllllllllIlIllIIIlIllIl.getSyntax())))));
        }
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((ITextComponent)llllllllllllllllllIlIllIIIlIIlll);
    }

    @Override
    public String getSyntax() {
        return "commands";
    }
}

