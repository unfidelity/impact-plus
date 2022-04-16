/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package me.axua.impactplus.command;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public abstract class Command {
    public static /* synthetic */ String prefix;
    static /* synthetic */ Minecraft mc;
    public static /* synthetic */ ChatFormatting cf;
    public static /* synthetic */ boolean MsgWaterMark;

    public static void sendClientMessage(String lllllllllllllllllIIllIllIIIIIllI) {
        if (MsgWaterMark) {
            Command.mc.thePlayer.addChatMessage((ITextComponent)new TextComponentString(String.valueOf(new StringBuilder().append("\u00a78[\u00a79Impact+\u00a78] ").append(cf).append(lllllllllllllllllIIllIllIIIIIllI))));
        } else {
            Command.mc.thePlayer.addChatMessage((ITextComponent)new TextComponentString(String.valueOf(new StringBuilder().append(cf).append(lllllllllllllllllIIllIllIIIIIllI))));
        }
    }

    public static char SECTIONSIGN() {
        return '\u00a7';
    }

    public Command() {
        Command lllllllllllllllllIIllIllIIIIlIII;
    }

    public static void sendRawMessage(String lllllllllllllllllIIllIllIIIIIIlI) {
        Command.mc.thePlayer.addChatMessage((ITextComponent)new TextComponentString(lllllllllllllllllIIllIllIIIIIIlI));
    }

    public abstract void onCommand(String var1, String[] var2) throws Exception;

    public static void setPrefix(String lllllllllllllllllIIllIllIIIIIIII) {
        prefix = lllllllllllllllllIIllIllIIIIIIII;
    }

    public static String getPrefix() {
        return prefix;
    }

    public abstract String getSyntax();

    public abstract String[] getAlias();

    static {
        mc = Minecraft.getMinecraft();
        prefix = "-";
        MsgWaterMark = true;
        cf = ChatFormatting.WHITE;
    }
}

