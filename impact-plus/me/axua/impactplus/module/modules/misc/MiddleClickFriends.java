/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.gameevent.InputEvent$MouseInputEvent
 *  org.lwjgl.input.Mouse
 */
package me.axua.impactplus.module.modules.misc;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.function.Predicate;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.command.Command;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.zero.alpine.listener.EventHandler;
import me.zero.alpine.listener.Listener;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Mouse;

public class MiddleClickFriends
extends Module {
    @EventHandler
    private /* synthetic */ Listener<InputEvent.MouseInputEvent> listener;

    @Override
    public void onEnable() {
        MiddleClickFriends lllllllllllllllllIIlllIIlIIlIIlI;
        ImpactPlus.EVENT_BUS.subscribe((Object)lllllllllllllllllIIlllIIlIIlIIlI);
    }

    public MiddleClickFriends() {
        super("MCF", Module.Category.MISC, "Middle click players to add / remove them as a friend");
        MiddleClickFriends lllllllllllllllllIIlllIIlIIlIllI;
        lllllllllllllllllIIlllIIlIIlIllI.listener = new Listener<InputEvent.MouseInputEvent>(lllllllllllllllllIIlllIIlIIIlIlI -> {
            if (MiddleClickFriends.mc.objectMouseOver.typeOfHit.equals((Object)RayTraceResult.Type.ENTITY) && MiddleClickFriends.mc.objectMouseOver.entityHit instanceof EntityPlayer && Mouse.getEventButton() == 2) {
                Friends cfr_ignored_0 = ImpactPlus.getInstance().friends;
                if (Friends.isFriend(MiddleClickFriends.mc.objectMouseOver.entityHit.getName())) {
                    ImpactPlus.getInstance().friends.delFriend(MiddleClickFriends.mc.objectMouseOver.entityHit.getName());
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("Removed ").append(MiddleClickFriends.mc.objectMouseOver.entityHit.getName()).append(" from friends list")));
                } else {
                    ImpactPlus.getInstance().friends.addFriend(MiddleClickFriends.mc.objectMouseOver.entityHit.getName());
                    Command.sendClientMessage(String.valueOf(new StringBuilder().append(ChatFormatting.GREEN).append("Added ").append(MiddleClickFriends.mc.objectMouseOver.entityHit.getName()).append(" to friends list")));
                }
            }
        }, new Predicate[0]);
        lllllllllllllllllIIlllIIlIIlIllI.setDrawn(false);
    }

    @Override
    public void onDisable() {
        MiddleClickFriends lllllllllllllllllIIlllIIlIIIllll;
        ImpactPlus.EVENT_BUS.unsubscribe((Object)lllllllllllllllllIIlllIIlIIIllll);
    }
}

