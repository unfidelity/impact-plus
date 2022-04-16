/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Maps
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.network.play.server.SPacketPlayerListItem
 *  net.minecraft.network.play.server.SPacketPlayerListItem$Action
 */
package me.axua.impactplus.mixin.mixins;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.network.play.server.SPacketPlayerListItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={NetHandlerPlayClient.class})
public abstract class MixinNetHandlerPlayClient {
    @Shadow
    private final /* synthetic */ Map<UUID, NetworkPlayerInfo> playerInfoMap;

    public MixinNetHandlerPlayClient() {
        MixinNetHandlerPlayClient llllllllllllllllIlllIIIllIIlllll;
        llllllllllllllllIlllIIIllIIlllll.playerInfoMap = Maps.newHashMap();
    }

    @Inject(method={"Lnet/minecraft/client/network/NetHandlerPlayClient;handlePlayerListItem(Lnet/minecraft/network/play/server/SPacketPlayerListItem;)V"}, at={@At(value="HEAD")})
    public void preHandlePlayerListItem(SPacketPlayerListItem llllllllllllllllIlllIIIllIIlIllI, CallbackInfo llllllllllllllllIlllIIIllIIlIlll) {
        try {
            if (llllllllllllllllIlllIIIllIIlIllI.func_179767_a().size() <= 1) {
                if (llllllllllllllllIlllIIIllIIlIllI.func_179768_b() == SPacketPlayerListItem.Action.ADD_PLAYER) {
                    llllllllllllllllIlllIIIllIIlIllI.func_179767_a().forEach(llllllllllllllllIlllIIIllIIIIllI -> {
                        if (llllllllllllllllIlllIIIllIIIIllI.getProfile().getId().equals(Minecraft.getMinecraft().thePlayer.getGameProfile().getId()) || llllllllllllllllIlllIIIllIIIIllI.getProfile().getName() != null) {
                            // empty if block
                        }
                    });
                } else if (llllllllllllllllIlllIIIllIIlIllI.func_179768_b() == SPacketPlayerListItem.Action.REMOVE_PLAYER) {
                    llllllllllllllllIlllIIIllIIlIllI.func_179767_a().forEach(llllllllllllllllIlllIIIllIIlIIll -> {
                        if (llllllllllllllllIlllIIIllIIlIIll.getProfile().getId() == null || !llllllllllllllllIlllIIIllIIlIIll.getProfile().getId().equals(Minecraft.getMinecraft().thePlayer.getGameProfile().getId())) {
                            // empty if block
                        }
                    });
                }
            }
        }
        catch (Exception llllllllllllllllIlllIIIllIIlIlIl) {
            // empty catch block
        }
    }
}

