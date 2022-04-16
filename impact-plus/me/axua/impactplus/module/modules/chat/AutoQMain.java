/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.Vec3i
 */
package me.axua.impactplus.module.modules.chat;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.util.Timer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3i;

public class AutoQMain
extends Module {
    private /* synthetic */ Timer _Timer;

    private boolean shouldSendMessage(EntityPlayer llllllllllllllllIlllIlIIlllIIlII) {
        String llllllllllllllllIlllIlIIlllIIIll = mc.getCurrentServerData() != null ? AutoQMain.mc.getCurrentServerData().serverIP : "Singleplayer";
        boolean llllllllllllllllIlllIlIIlllIIIlI = llllllllllllllllIlllIlIIlllIIIll.equalsIgnoreCase("2b2t.org");
        boolean llllllllllllllllIlllIlIIlllIIIIl = llllllllllllllllIlllIlIIlllIIlII.dimension == 1;
        boolean llllllllllllllllIlllIlIIlllIIIII = llllllllllllllllIlllIlIIlllIIlII.getPosition().equals((Object)new Vec3i(0, 240, 0));
        return llllllllllllllllIlllIlIIlllIIIIl && llllllllllllllllIlllIlIIlllIIIII && llllllllllllllllIlllIlIIlllIIIlI;
    }

    @Override
    public void onEnable() {
        llllllllllllllllIlllIlIlIIIIIIII._Timer = new Timer();
    }

    @Override
    public void onUpdate() {
        AutoQMain llllllllllllllllIlllIlIIlllllIIl;
        if (llllllllllllllllIlllIlIIlllllIIl._Timer.passed(30000.0)) {
            if (llllllllllllllllIlllIlIIlllllIIl.shouldSendMessage((EntityPlayer)AutoQMain.mc.thePlayer)) {
                AutoQMain.mc.thePlayer.sendChatMessage("/queue main");
                Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GOLD).append("/queue main")));
            }
            llllllllllllllllIlllIlIIlllllIIl._Timer.reset();
        }
    }

    public AutoQMain() {
        super("AutoQMain", Module.Category.CHAT);
        AutoQMain llllllllllllllllIlllIlIlIIIIIlII;
        llllllllllllllllIlllIlIlIIIIIlII._Timer = new Timer();
    }
}

