/*
 * Decompiled with CFR 0.152.
 */
package me.zero.alpine.type;

public class Cancellable {
    private /* synthetic */ boolean cancelled;

    public final boolean isCancelled() {
        Cancellable lllllllllllllllIlllIIllIlIIIIIIl;
        return lllllllllllllllIlllIIllIlIIIIIIl.cancelled;
    }

    public final void cancel() {
        lllllllllllllllIlllIIllIlIIIlIlI.cancelled = true;
    }

    public Cancellable() {
        Cancellable lllllllllllllllIlllIIllIlIIlIIlI;
    }
}

