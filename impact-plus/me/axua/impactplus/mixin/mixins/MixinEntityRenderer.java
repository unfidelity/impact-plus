/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Predicate
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.renderer.EntityRenderer
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 */
package me.axua.impactplus.mixin.mixins;

import com.google.common.base.Predicate;
import java.util.ArrayList;
import java.util.List;
import me.axua.impactplus.module.ModuleManager;
import me.axua.impactplus.module.modules.player.NoEntityTrace;
import me.axua.impactplus.module.modules.render.NoRender;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={EntityRenderer.class})
public class MixinEntityRenderer {
    @Inject(method={"hurtCameraEffect"}, at={@At(value="HEAD")}, cancellable=true)
    public void hurtCameraEffect(float lllllllllllllllllIIIIIIIIlIIIIlI, CallbackInfo lllllllllllllllllIIIIIIIIlIIIIII) {
        if (ModuleManager.isModuleEnabled("NoRender") && ((NoRender)ModuleManager.getModuleByName((String)"NoRender")).hurtCam.getValue()) {
            lllllllllllllllllIIIIIIIIlIIIIII.cancel();
        }
    }

    public MixinEntityRenderer() {
        MixinEntityRenderer lllllllllllllllllIIIIIIIIlIlIIll;
    }

    @Redirect(method={"getMouseOver"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/multiplayer/WorldClient;getEntitiesInAABBexcluding(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/AxisAlignedBB;Lcom/google/common/base/Predicate;)Ljava/util/List;"))
    public List<Entity> getEntitiesInAABBexcluding(WorldClient lllllllllllllllllIIIIIIIIlIIlIII, Entity lllllllllllllllllIIIIIIIIlIIlIll, AxisAlignedBB lllllllllllllllllIIIIIIIIlIIlIlI, Predicate lllllllllllllllllIIIIIIIIlIIIlIl) {
        if (NoEntityTrace.shouldBlock()) {
            return new ArrayList<Entity>();
        }
        return lllllllllllllllllIIIIIIIIlIIlIII.getEntitiesInAABBexcluding(lllllllllllllllllIIIIIIIIlIIlIll, lllllllllllllllllIIIIIIIIlIIlIlI, lllllllllllllllllIIIIIIIIlIIIlIl);
    }
}

