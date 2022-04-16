/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface Constant {
    public String stringValue() default "";

    public double doubleValue() default 0.0;

    public boolean log() default false;

    public int ordinal() default -1;

    public String slice() default "";

    public float floatValue() default 0.0f;

    public boolean nullValue() default false;

    public Condition[] expandZeroConditions() default {};

    public Class<?> classValue() default Object.class;

    public int intValue() default 0;

    public long longValue() default 0L;

    public static enum Condition {
        LESS_THAN_ZERO(155, 156),
        LESS_THAN_OR_EQUAL_TO_ZERO(158, 157),
        GREATER_THAN_OR_EQUAL_TO_ZERO(LESS_THAN_ZERO),
        GREATER_THAN_ZERO(LESS_THAN_OR_EQUAL_TO_ZERO);

        private final /* synthetic */ Condition equivalence;
        private final /* synthetic */ int[] opcodes;

        private Condition(Condition lllllllllllllllllllIllllIlIIIIll) {
            lllllllllllllllllllIllllIlIIIIlI(lllllllllllllllllllIllllIlIIIIll, lllllllllllllllllllIllllIlIIIIll.opcodes);
            Condition lllllllllllllllllllIllllIlIIIIlI;
        }

        public int[] getOpcodes() {
            Condition lllllllllllllllllllIllllIIlIllIl;
            return lllllllllllllllllllIllllIIlIllIl.opcodes;
        }

        public Condition getEquivalentCondition() {
            Condition lllllllllllllllllllIllllIIllIIII;
            return lllllllllllllllllllIllllIIllIIII.equivalence;
        }

        private Condition(Condition lllllllllllllllllllIllllIIlllIII, int ... lllllllllllllllllllIllllIIllIIlI) {
            Condition lllllllllllllllllllIllllIIlllIIl;
            lllllllllllllllllllIllllIIlllIIl.equivalence = lllllllllllllllllllIllllIIlllIII != null ? lllllllllllllllllllIllllIIlllIII : lllllllllllllllllllIllllIIlllIIl;
            lllllllllllllllllllIllllIIlllIIl.opcodes = lllllllllllllllllllIllllIIllIIlI;
        }

        private Condition(int ... lllllllllllllllllllIllllIlIIlIIl) {
            lllllllllllllllllllIllllIlIIllII(null, lllllllllllllllllllIllllIlIIlIIl);
            Condition lllllllllllllllllllIllllIlIIllII;
        }
    }
}

