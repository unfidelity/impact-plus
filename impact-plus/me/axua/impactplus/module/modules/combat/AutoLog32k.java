/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketChatMessage
 *  net.minecraft.network.play.server.SPacketDisconnect
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package me.axua.impactplus.module.modules.combat;

import com.mojang.realmsclient.gui.ChatFormatting;
import java.util.Objects;
import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.Module;
import me.axua.impactplus.setting.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketChatMessage;
import net.minecraft.network.play.server.SPacketDisconnect;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class AutoLog32k
extends Module {
    public /* synthetic */ Setting.i Distance;
    public /* synthetic */ Setting.b Friends11;
    public /* synthetic */ Setting.b PublicAnnonuce;
    public static final /* synthetic */ Minecraft mc;

    public AutoLog32k() {
        super("32kAutoLog", Module.Category.COMBAT, "AutoLog when someone is holding a 32k near you");
        AutoLog32k llllllllllllllllIIIIIllIlIIIIIlI;
    }

    private boolean is32k(EntityPlayer llllllllllllllllIIIIIllIIllllIII, ItemStack llllllllllllllllIIIIIllIIlllIlll) {
        NBTTagList llllllllllllllllIIIIIllIIllllIlI;
        if (llllllllllllllllIIIIIllIIlllIlll.getItem() instanceof ItemSword && (llllllllllllllllIIIIIllIIllllIlI = llllllllllllllllIIIIIllIIlllIlll.getEnchantmentTagList()) != null) {
            for (int llllllllllllllllIIIIIllIIllllIll = 0; llllllllllllllllIIIIIllIIllllIll < llllllllllllllllIIIIIllIIllllIlI.tagCount(); ++llllllllllllllllIIIIIllIIllllIll) {
                if (llllllllllllllllIIIIIllIIllllIlI.getCompoundTagAt(llllllllllllllllIIIIIllIIllllIll).getShort("lvl") < Short.MAX_VALUE) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void setup() {
        AutoLog32k llllllllllllllllIIIIIllIlIIIIIII;
        llllllllllllllllIIIIIllIlIIIIIII.PublicAnnonuce = llllllllllllllllIIIIIllIlIIIIIII.registerB("PublicAnnonuce", true);
        llllllllllllllllIIIIIllIlIIIIIII.Friends11 = llllllllllllllllIIIIIllIlIIIIIII.registerB("LogToFriends", false);
        llllllllllllllllIIIIIllIlIIIIIII.Distance = llllllllllllllllIIIIIllIlIIIIIII.registerI("Distance", 10, 1, 30);
    }

    @Override
    public void onLivingEvent() {
        for (EntityPlayer llllllllllllllllIIIIIllIIllIlllI : AutoLog32k.mc.theWorld.playerEntities) {
            AutoLog32k llllllllllllllllIIIIIllIIllIllIl;
            int llllllllllllllllIIIIIllIIllIllll = (int)AutoLog32k.mc.thePlayer.getDistanceToEntity((Entity)llllllllllllllllIIIIIllIIllIlllI);
            if (llllllllllllllllIIIIIllIIllIlllI.equals((Object)AutoLog32k.mc.thePlayer) || !llllllllllllllllIIIIIllIIllIllIl.is32k(llllllllllllllllIIIIIllIIllIlllI, llllllllllllllllIIIIIllIIllIlllI.field_184831_bT)) continue;
            if (llllllllllllllllIIIIIllIIllIllIl.Friends11.getValue()) {
                if (llllllllllllllllIIIIIllIIllIllll >= llllllllllllllllIIIIIllIIllIllIl.Distance.getValue()) continue;
                if (llllllllllllllllIIIIIllIIllIllIl.PublicAnnonuce.getValue()) {
                    AutoLog32k.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketChatMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIIIIIllIIllIlllI.getName()).append(" just tried to 32k me! Disconnecting lol"))));
                }
                Objects.requireNonNull(Minecraft.getMinecraft().getNetHandler()).handleDisconnect(new SPacketDisconnect((ITextComponent)new TextComponentString(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("[32k Detect] ").append(llllllllllllllllIIIIIllIIllIlllI.getName()).append(" just tried to 32k you.")))));
                continue;
            }
            if (Friends.isFriend(llllllllllllllllIIIIIllIIllIlllI.getName()) || llllllllllllllllIIIIIllIIllIllll >= llllllllllllllllIIIIIllIIllIllIl.Distance.getValue()) continue;
            if (llllllllllllllllIIIIIllIIllIllIl.PublicAnnonuce.getValue()) {
                AutoLog32k.mc.thePlayer.sendQueue.addToSendQueue((Packet)new CPacketChatMessage(String.valueOf(new StringBuilder().append(llllllllllllllllIIIIIllIIllIlllI.getName()).append(" just tried to 32k me! Disconnecting..."))));
            }
            Objects.requireNonNull(Minecraft.getMinecraft().getNetHandler()).handleDisconnect(new SPacketDisconnect((ITextComponent)new TextComponentString(String.valueOf(new StringBuilder().append(ChatFormatting.RED).append("[32k Detect] ").append(llllllllllllllllIIIIIllIIllIlllI.getName()).append(" just tried to 32k you.")))));
        }
    }

    static {
        mc = Minecraft.getMinecraft();
    }
}

