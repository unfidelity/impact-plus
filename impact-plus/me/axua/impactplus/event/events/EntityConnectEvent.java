/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.realmsclient.dto.PlayerInfo
 */
package me.axua.impactplus.event.events;

import com.mojang.authlib.GameProfile;
import com.mojang.realmsclient.dto.PlayerInfo;
import java.util.Objects;
import me.axua.impactplus.event.ImpactPlusEvent;

public class EntityConnectEvent
extends ImpactPlusEvent {
    private final /* synthetic */ PlayerInfo playerInfo;
    private final /* synthetic */ GameProfile profile;

    public PlayerInfo getPlayerInfo() {
        EntityConnectEvent llllllllllllllllIllIIIIlllIIIIIl;
        return llllllllllllllllIllIIIIlllIIIIIl.playerInfo;
    }

    public GameProfile getProfile() {
        EntityConnectEvent llllllllllllllllIllIIIIllIlllllI;
        return llllllllllllllllIllIIIIllIlllllI.profile;
    }

    public EntityConnectEvent(PlayerInfo llllllllllllllllIllIIIIlllIIIlII, GameProfile llllllllllllllllIllIIIIlllIIIIll) {
        EntityConnectEvent llllllllllllllllIllIIIIlllIIIlIl;
        Objects.requireNonNull(llllllllllllllllIllIIIIlllIIIIll);
        llllllllllllllllIllIIIIlllIIIlIl.playerInfo = llllllllllllllllIllIIIIlllIIIlII;
        llllllllllllllllIllIIIIlllIIIlIl.profile = llllllllllllllllIllIIIIlllIIIIll;
    }

    public static class Leave
    extends EntityConnectEvent {
        public Leave(PlayerInfo lllllllllllllllllllIlllIIIlIIllI, GameProfile lllllllllllllllllllIlllIIIlIIlIl) {
            super(lllllllllllllllllllIlllIIIlIIllI, lllllllllllllllllllIlllIIIlIIlIl);
            Leave lllllllllllllllllllIlllIIIlIIlll;
        }
    }

    public static class Join
    extends EntityConnectEvent {
        public Join(PlayerInfo llllllllllllllllIIlIIllIIllIlIII, GameProfile llllllllllllllllIIlIIllIIllIIlll) {
            super(llllllllllllllllIIlIIllIIllIlIII, llllllllllllllllIIlIIllIIllIIlll);
            Join llllllllllllllllIIlIIllIIllIlIIl;
        }
    }
}

