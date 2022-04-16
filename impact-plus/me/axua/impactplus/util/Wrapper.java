/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.Style
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraft.util.text.event.HoverEvent
 *  net.minecraft.util.text.event.HoverEvent$Action
 *  net.minecraft.world.World
 *  org.lwjgl.input.Keyboard
 */
package me.axua.impactplus.util;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.awt.Color;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.EventProcessor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import org.lwjgl.input.Keyboard;

public class Wrapper {
    private static /* synthetic */ String prefix;
    public static final /* synthetic */ Minecraft mc;
    public static final /* synthetic */ ImpactPlus mod;

    public static Color getRainbow() {
        return EventProcessor.INSTANCE.c;
    }

    public static void sendClientMessage(String llllllllllllllllllllIlIllIIlIIIl) {
        if (Wrapper.mc.thePlayer == null) {
            return;
        }
        ITextComponent llllllllllllllllllllIlIllIIlIIlI = new TextComponentString(String.valueOf(new StringBuilder().append(prefix).append(ChatFormatting.GRAY).append(llllllllllllllllllllIlIllIIlIIIl))).setChatStyle(new Style().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (ITextComponent)new TextComponentString("ImpactPlus"))));
        Wrapper.mc.ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(llllllllllllllllllllIlIllIIlIIlI, 5936);
    }

    public static Color getRainbow(int llllllllllllllllllllIlIllIIIllIl) {
        return new Color(EventProcessor.INSTANCE.c.getRed(), EventProcessor.INSTANCE.c.getGreen(), EventProcessor.INSTANCE.c.getBlue(), llllllllllllllllllllIlIllIIIllIl);
    }

    static {
        mc = Minecraft.getMinecraft();
        mod = ImpactPlus.getInstance();
        prefix = String.valueOf(new StringBuilder().append(ChatFormatting.DARK_GRAY).append("[").append(ChatFormatting.BLUE).append("Impact+").append(ChatFormatting.DARK_GRAY).append("] "));
    }

    public Wrapper() {
        Wrapper llllllllllllllllllllIlIllIIllIlI;
    }

    public static World getWorld() {
        return Wrapper.getMinecraft().theWorld;
    }

    public static void sendErrorMessage(String llllllllllllllllllllIlIllIIlIllI) {
        if (Wrapper.mc.thePlayer == null) {
            return;
        }
    }

    public static int getKey(String llllllllllllllllllllIlIllIIllIII) {
        return Keyboard.getKeyIndex((String)llllllllllllllllllllIlIllIIllIII.toUpperCase());
    }

    public static Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    public static EntityPlayerSP getPlayer() {
        return Wrapper.getMinecraft().thePlayer;
    }
}

