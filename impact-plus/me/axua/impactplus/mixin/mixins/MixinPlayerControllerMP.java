/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.BlockPos
 */
package me.axua.impactplus.mixin.mixins;

import me.axua.impactplus.ImpactPlus;
import me.axua.impactplus.event.events.DamageBlockEvent;
import me.axua.impactplus.module.ModuleManager;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={PlayerControllerMP.class})
public abstract class MixinPlayerControllerMP {
    @Inject(method={"onPlayerDamageBlock"}, at={@At(value="HEAD")})
    private void onPlayerDamageBlock(BlockPos lllllIIIIIlIlI, EnumFacing lllllIIIIIlIIl, CallbackInfoReturnable<Boolean> lllllIIIIIIlll) {
        if (ModuleManager.isModuleEnabled("PacketMine")) {
            DamageBlockEvent lllllIIIIIllIl = new DamageBlockEvent(lllllIIIIIlIlI, lllllIIIIIlIIl);
            ImpactPlus.EVENT_BUS.post(lllllIIIIIllIl);
        }
    }

    public MixinPlayerControllerMP() {
        MixinPlayerControllerMP lllllIIIIlIIlI;
    }
}

