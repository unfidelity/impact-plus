/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.event.ClickEvent
 *  net.minecraft.util.text.event.ClickEvent$Action
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraft.util.text.event.HoverEvent$Action
 */
package me.axua.impactplus.command.commands;

import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;

public class ModsCommand
extends Command {
    public ModsCommand() {
        ModsCommand lIIlllllIllIIII;
    }

    @Override
    public void onCommand(String lIIlllllIlIIlIl, String[] lIIlllllIlIIlII) throws Exception {
        int lIIlllllIlIIIll = ModuleManager.getModules().size();
        TextComponentString lIIlllllIlIIIlI = new TextComponentString("\u00a77Modules: \u00a7f ");
        for (int lIIlllllIlIIlll = 0; lIIlllllIlIIlll < lIIlllllIlIIIll; ++lIIlllllIlIIlll) {
            Module lIIlllllIlIlIII = ModuleManager.getModules().get(lIIlllllIlIIlll);
            if (lIIlllllIlIlIII == null) continue;
            lIIlllllIlIIIlI.appendSibling(new TextComponentString(String.valueOf(new StringBuilder().append(lIIlllllIlIlIII.isEnabled() ? "\u00a7a" : "\u00a7c").append(lIIlllllIlIlIII.getName()).append("\u00a77").append(lIIlllllIlIIlll == lIIlllllIlIIIll - 1 ? "" : ", "))).setChatStyle(new Style().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString(lIIlllllIlIlIII.getCategory().name()))).setChatClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, String.valueOf(new StringBuilder().append(Command.getPrefix()).append("toggle ").append(lIIlllllIlIlIII.getName()))))));
        }
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage((ITextComponent)lIIlllllIlIIIlI);
    }

    @Override
    public String getSyntax() {
        return "modules";
    }

    @Override
    public String[] getAlias() {
        return new String[]{"modules", "mods"};
    }
}

