/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer.ext.extensions;

import org.spongepowered.asm.lib.util.CheckClassAdapter;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.mixin.transformer.ext.IExtension;
import org.spongepowered.asm.mixin.transformer.ext.ITargetClassContext;
import org.spongepowered.asm.transformers.MixinClassWriter;

public class ExtensionCheckClass
implements IExtension {
    @Override
    public void export(MixinEnvironment lllllllllllllllllllIIlIllIIllIIl, String lllllllllllllllllllIIlIllIIllIII, boolean lllllllllllllllllllIIlIllIIlIlll, byte[] lllllllllllllllllllIIlIllIIlIllI) {
    }

    @Override
    public boolean checkActive(MixinEnvironment lllllllllllllllllllIIlIllIllIIII) {
        return lllllllllllllllllllIIlIllIllIIII.getOption(MixinEnvironment.Option.DEBUG_VERIFY);
    }

    public ExtensionCheckClass() {
        ExtensionCheckClass lllllllllllllllllllIIlIllIlllIll;
    }

    @Override
    public void postApply(ITargetClassContext lllllllllllllllllllIIlIllIIlllll) {
        try {
            lllllllllllllllllllIIlIllIIlllll.getClassNode().accept(new CheckClassAdapter(new MixinClassWriter(2)));
        }
        catch (RuntimeException lllllllllllllllllllIIlIllIlIIIll) {
            throw new ValidationFailedException(lllllllllllllllllllIIlIllIlIIIll.getMessage(), lllllllllllllllllllIIlIllIlIIIll);
        }
    }

    @Override
    public void preApply(ITargetClassContext lllllllllllllllllllIIlIllIlIlllI) {
    }

    public static class ValidationFailedException
    extends MixinException {
        private static final /* synthetic */ long serialVersionUID = 1L;

        public ValidationFailedException(String llllllllllllllllIllIllIIIIlllIlI) {
            super(llllllllllllllllIllIllIIIIlllIlI);
            ValidationFailedException llllllllllllllllIllIllIIIIlllIIl;
        }

        public ValidationFailedException(Throwable llllllllllllllllIllIllIIIIllIlII) {
            super(llllllllllllllllIllIllIIIIllIlII);
            ValidationFailedException llllllllllllllllIllIllIIIIllIIll;
        }

        public ValidationFailedException(String llllllllllllllllIllIllIIIIllllll, Throwable llllllllllllllllIllIllIIIlIIIIIl) {
            super(llllllllllllllllIllIllIIIIllllll, llllllllllllllllIllIllIIIlIIIIIl);
            ValidationFailedException llllllllllllllllIllIllIIIlIIIIll;
        }
    }
}

