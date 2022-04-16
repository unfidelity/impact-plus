/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.IClassTransformer
 */
package org.spongepowered.asm.service.mojang;

import javax.annotation.Resource;
import net.minecraft.launchwrapper.IClassTransformer;
import org.spongepowered.asm.service.ILegacyClassTransformer;

class LegacyTransformerHandle
implements ILegacyClassTransformer {
    private final /* synthetic */ IClassTransformer transformer;

    @Override
    public boolean isDelegationExcluded() {
        LegacyTransformerHandle lllllllllllllllIlllIllllIllIIlII;
        return lllllllllllllllIlllIllllIllIIlII.transformer.getClass().getAnnotation(Resource.class) != null;
    }

    @Override
    public byte[] transformClassBytes(String lllllllllllllllIlllIllllIlIllIlI, String lllllllllllllllIlllIllllIlIllIIl, byte[] lllllllllllllllIlllIllllIlIlllII) {
        LegacyTransformerHandle lllllllllllllllIlllIllllIlIlllll;
        return lllllllllllllllIlllIllllIlIlllll.transformer.transform(lllllllllllllllIlllIllllIlIllIlI, lllllllllllllllIlllIllllIlIllIIl, lllllllllllllllIlllIllllIlIlllII);
    }

    LegacyTransformerHandle(IClassTransformer lllllllllllllllIlllIllllIllIlIlI) {
        LegacyTransformerHandle lllllllllllllllIlllIllllIllIlIll;
        lllllllllllllllIlllIllllIllIlIll.transformer = lllllllllllllllIlllIllllIllIlIlI;
    }

    @Override
    public String getName() {
        LegacyTransformerHandle lllllllllllllllIlllIllllIllIlIII;
        return lllllllllllllllIlllIllllIllIlIII.transformer.getClass().getName();
    }
}

