/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface At {
    public int by() default 0;

    public Shift shift() default Shift.NONE;

    public int ordinal() default -1;

    public String id() default "";

    public boolean remap() default true;

    public String value();

    public String[] args() default {};

    public int opcode() default -1;

    public String target() default "";

    public String slice() default "";

    public static enum Shift {
        NONE,
        BEFORE,
        AFTER,
        BY;


        private Shift() {
            Shift lIIlIlIIlllllI;
        }
    }
}

