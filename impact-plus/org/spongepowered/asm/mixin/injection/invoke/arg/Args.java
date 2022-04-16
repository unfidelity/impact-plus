/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.invoke.arg;

public abstract class Args {
    protected final /* synthetic */ Object[] values;

    public abstract void setAll(Object ... var1);

    protected Args(Object[] llIlIIIlIllII) {
        Args llIlIIIlIllll;
        llIlIIIlIllll.values = llIlIIIlIllII;
    }

    public int size() {
        Args llIlIIIlIlIlI;
        return llIlIIIlIlIlI.values.length;
    }

    public abstract <T> void set(int var1, T var2);

    public <T> T get(int llIlIIIlIIIll) {
        Args llIlIIIlIIlII;
        return (T)llIlIIIlIIlII.values[llIlIIIlIIIll];
    }
}

