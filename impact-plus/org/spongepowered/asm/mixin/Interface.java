/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE})
@Retention(value=RetentionPolicy.CLASS)
public @interface Interface {
    public Remap remap() default Remap.ALL;

    public Class<?> iface();

    public String prefix();

    public boolean unique() default false;

    public static enum Remap {
        ALL,
        FORCE(true),
        ONLY_PREFIXED,
        NONE;

        private final /* synthetic */ boolean forceRemap;

        private Remap(boolean lllllllllllllllIllIlIllllllllIIl) {
            Remap lllllllllllllllIllIlIlllllllllII;
            lllllllllllllllIllIlIlllllllllII.forceRemap = lllllllllllllllIllIlIllllllllIIl;
        }

        public boolean forceRemap() {
            Remap lllllllllllllllIllIlIlllllllIllI;
            return lllllllllllllllIllIlIlllllllIllI.forceRemap;
        }

        private Remap() {
            lllllllllllllllIllIllIIIIIIIIllI(false);
            Remap lllllllllllllllIllIllIIIIIIIIllI;
        }
    }
}

