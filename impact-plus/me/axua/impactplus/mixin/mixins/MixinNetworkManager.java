/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.netty.channel.ChannelHandlerContext
 *  net.minecraft.network.NetworkManager
 *  net.minecraft.network.Packet
 */
package me.axua.impactplus.mixin.mixins;

import io.netty.channel.ChannelHandlerContext;
import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.PacketEvent;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetworkManager.class})
public class MixinNetworkManager {
    @Inject(method={"channelRead0"}, at={@At(value="HEAD")}, cancellable=true)
    private void onChannelRead(ChannelHandlerContext llIIlllIIIIIIII, Packet<?> llIIllIllllllII, CallbackInfo llIIllIlllllIll) {
        PacketEvent.Receive llIIllIllllllIl = new PacketEvent.Receive(llIIllIllllllII);
        ImpactPlus.EVENT_BUS.post(llIIllIllllllIl);
        if (llIIllIllllllIl.isCancelled()) {
            llIIllIlllllIll.cancel();
        }
    }

    @Inject(method={"sendPacket(Lnet/minecraft/network/Packet;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onSendPacket(Packet<?> llIIlllIIIIIlll, CallbackInfo llIIlllIIIIlIIl) {
        PacketEvent.Send llIIlllIIIIlIII = new PacketEvent.Send(llIIlllIIIIIlll);
        ImpactPlus.EVENT_BUS.post(llIIlllIIIIlIII);
        if (llIIlllIIIIlIII.isCancelled()) {
            llIIlllIIIIlIIl.cancel();
        }
    }

    public MixinNetworkManager() {
        MixinNetworkManager llIIlllIIIlIIII;
    }
}

