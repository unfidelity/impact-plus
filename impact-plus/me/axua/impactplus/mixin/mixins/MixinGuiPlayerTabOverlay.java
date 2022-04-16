/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiPlayerTabOverlay
 *  net.minecraft.client.network.NetworkPlayerInfo
 *  net.minecraft.scoreboard.ScorePlayerTeam
 *  net.minecraft.scoreboard.Team
 *  net.minecraft.util.text.TextFormatting
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.friends.Friends;
import me.axua.impactplus.module.ModuleManager;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.text.TextFormatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={GuiPlayerTabOverlay.class})
public class MixinGuiPlayerTabOverlay {
    @Inject(method={"getPlayerName"}, at={@At(value="HEAD")}, cancellable=true)
    public void getPlayerName(NetworkPlayerInfo llllllllllllllllllIIIIIllIlllIIl, CallbackInfoReturnable llllllllllllllllllIIIIIllIlllIll) {
        MixinGuiPlayerTabOverlay llllllllllllllllllIIIIIllIllllIl;
        llllllllllllllllllIIIIIllIlllIll.cancel();
        llllllllllllllllllIIIIIllIlllIll.setReturnValue(llllllllllllllllllIIIIIllIllllIl.getPlayerName(llllllllllllllllllIIIIIllIlllIIl));
    }

    public String getPlayerName(NetworkPlayerInfo llllllllllllllllllIIIIIllIllIlII) {
        String llllllllllllllllllIIIIIllIllIIll;
        String string = llllllllllllllllllIIIIIllIllIIll = llllllllllllllllllIIIIIllIllIlII.getDisplayName() != null ? llllllllllllllllllIIIIIllIllIlII.getDisplayName().getFormattedText() : ScorePlayerTeam.formatPlayerName((Team)llllllllllllllllllIIIIIllIllIlII.getPlayerTeam(), (String)llllllllllllllllllIIIIIllIllIlII.getGameProfile().getName());
        if (ModuleManager.isModuleEnabled("TabFriends") && Friends.isFriend(llllllllllllllllllIIIIIllIllIIll)) {
            return String.valueOf(new StringBuilder().append(TextFormatting.GREEN).append(llllllllllllllllllIIIIIllIllIIll));
        }
        return llllllllllllllllllIIIIIllIllIIll;
    }

    public MixinGuiPlayerTabOverlay() {
        MixinGuiPlayerTabOverlay llllllllllllllllllIIIIIlllIIIIlI;
    }
}

