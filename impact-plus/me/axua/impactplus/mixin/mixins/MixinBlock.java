/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.block.Block
 *  net.minecraft.util.BlockRenderLayer
 */
package me.axua.impactplus.mixin.mixins;

import net.minecraft.block.Block;
import net.minecraft.util.BlockRenderLayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={Block.class})
public abstract class MixinBlock {
    @Shadow
    public abstract String getLocalizedName();

    public MixinBlock() {
        MixinBlock llllllllllllllllIlllIIllllllllll;
    }

    @Inject(method={"getRenderLayer"}, at={@At(value="HEAD")})
    public void preGetRenderLayer(CallbackInfoReturnable<BlockRenderLayer> llllllllllllllllIlllIIlllllllIll) {
        MixinBlock llllllllllllllllIlllIIllllllllII;
        if (llllllllllllllllIlllIIllllllllII.getLocalizedName().equalsIgnoreCase("hmmm")) {
            // empty if block
        }
    }
}

