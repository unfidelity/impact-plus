/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.util.text.TextComponentString
 *  net.minecraftforge.client.event.ClientChatReceivedEvent
 */
package me.axua.impactplus.module.modules.chat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatReceivedEvent;

public class ChatTimeStamps
extends Module {
    /* synthetic */ Setting.mode format;
    @EventHandler
    private /* synthetic */ Listener<ClientChatReceivedEvent> listener;
    /* synthetic */ Setting.mode color;
    /* synthetic */ Setting.mode decoration;

    @Override
    public void onDisable() {
        ChatTimeStamps lllIIIlIllllIl;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllIIIlIllllIl);
    }

    @Override
    public void onEnable() {
        ChatTimeStamps lllIIIllIIIIIl;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllIIIllIIIIIl);
    }

    public ChatTimeStamps() {
        super("ChatTimeStamps", Module.Category.CHAT);
        ChatTimeStamps lllIIIllIIlIlI;
        lllIIIllIIlIlI.listener = new Listener<ClientChatReceivedEvent>(lllIIIlIlIllIl -> {
            ChatTimeStamps lllIIIlIllIlIl;
            String lllIIIlIllIIll = lllIIIlIllIlIl.decoration.getValue().equalsIgnoreCase(" ") ? "" : lllIIIlIllIlIl.decoration.getValue().split(" ")[0];
            String lllIIIlIllIIlI = lllIIIlIllIlIl.decoration.getValue().equalsIgnoreCase(" ") ? "" : lllIIIlIllIlIl.decoration.getValue().split(" ")[1];
            lllIIIlIllIIlI = String.valueOf(new StringBuilder().append(lllIIIlIllIIlI).append(" "));
            String lllIIIlIllIIIl = lllIIIlIllIlIl.format.getValue().replace("H24", "k").replace("H12", "h");
            String lllIIIlIllIIII = new SimpleDateFormat(lllIIIlIllIIIl).format(new Date());
            TextComponentString lllIIIlIlIllll = new TextComponentString(String.valueOf(new StringBuilder().append(ChatFormatting.getByName((String)lllIIIlIllIlIl.color.getValue())).append(lllIIIlIllIIll).append(lllIIIlIllIIII).append(lllIIIlIllIIlI).append(ChatFormatting.RESET)));
            lllIIIlIlIllIl.setMessage(lllIIIlIlIllll.appendSibling(lllIIIlIlIllIl.getMessage()));
        }, new Predicate[0]);
        ArrayList<String> lllIIIllIIlIIl = new ArrayList<String>();
        lllIIIllIIlIIl.add("H24:mm");
        lllIIIllIIlIIl.add("H12:mm");
        lllIIIllIIlIIl.add("H12:mm a");
        lllIIIllIIlIIl.add("H24:mm:ss");
        lllIIIllIIlIIl.add("H12:mm:ss");
        lllIIIllIIlIIl.add("H12:mm:ss a");
        ArrayList<String> lllIIIllIIlIII = new ArrayList<String>();
        lllIIIllIIlIII.add("< >");
        lllIIIllIIlIII.add("[ ]");
        lllIIIllIIlIII.add("{ }");
        lllIIIllIIlIII.add(" ");
        ArrayList<String> lllIIIllIIIlll = new ArrayList<String>();
        lllIIIllIIIlll.add("None");
        lllIIIllIIIlll.add("White");
        lllIIIllIIIlll.add("Black");
        lllIIIllIIIlll.add("Gray");
        lllIIIllIIIlll.add("Dark Gray");
        lllIIIllIIIlll.add("Aqua");
        lllIIIllIIIlll.add("Dark Aqua");
        lllIIIllIIIlll.add("Blue");
        lllIIIllIIIlll.add("Dark Blue");
        lllIIIllIIIlll.add("Green");
        lllIIIllIIIlll.add("Dark Green");
        lllIIIllIIIlll.add("Light Purple");
        lllIIIllIIIlll.add("Dark Purple");
        lllIIIllIIIlll.add("Red");
        lllIIIllIIIlll.add("Dark Red");
        lllIIIllIIIlll.add("Yellow");
        lllIIIllIIIlll.add("Gold");
        lllIIIllIIlIlI.format = lllIIIllIIlIlI.registerMode("Format", lllIIIllIIlIIl, "H12:mm:ss a");
        lllIIIllIIlIlI.color = lllIIIllIIlIlI.registerMode("Color", lllIIIllIIIlll, "White");
        lllIIIllIIlIlI.decoration = lllIIIllIIlIlI.registerMode("Deco", lllIIIllIIlIII, "< >");
    }
}

