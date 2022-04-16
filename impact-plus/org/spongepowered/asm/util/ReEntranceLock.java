/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util;

public class ReEntranceLock {
    private /* synthetic */ int depth;
    private final /* synthetic */ int maxDepth;
    private /* synthetic */ boolean semaphore;

    public boolean isSet() {
        ReEntranceLock lIlIIIIIlIIIIlI;
        return lIlIIIIIlIIIIlI.semaphore;
    }

    public int getDepth() {
        ReEntranceLock lIlIIIIIlIlIlII;
        return lIlIIIIIlIlIlII.depth;
    }

    public boolean checkAndSet() {
        ReEntranceLock lIlIIIIIlIIIlll;
        return lIlIIIIIlIIIlll.semaphore |= lIlIIIIIlIIIlll.check();
    }

    public ReEntranceLock set() {
        ReEntranceLock lIlIIIIIlIIIlIl;
        lIlIIIIIlIIIlIl.semaphore = true;
        return lIlIIIIIlIIIlIl;
    }

    public ReEntranceLock pop() {
        ReEntranceLock lIlIIIIIlIIllIl;
        if (lIlIIIIIlIIllIl.depth == 0) {
            throw new IllegalStateException("ReEntranceLock pop() with zero depth");
        }
        --lIlIIIIIlIIllIl.depth;
        return lIlIIIIIlIIllIl;
    }

    public ReEntranceLock(int lIlIIIIIlIllIll) {
        ReEntranceLock lIlIIIIIlIllIlI;
        lIlIIIIIlIllIlI.depth = 0;
        lIlIIIIIlIllIlI.semaphore = false;
        lIlIIIIIlIllIlI.maxDepth = lIlIIIIIlIllIll;
    }

    public int getMaxDepth() {
        ReEntranceLock lIlIIIIIlIlIllI;
        return lIlIIIIIlIlIllI.maxDepth;
    }

    public boolean check() {
        ReEntranceLock lIlIIIIIlIIlIll;
        return lIlIIIIIlIIlIll.depth > lIlIIIIIlIIlIll.maxDepth;
    }

    public ReEntranceLock clear() {
        ReEntranceLock lIlIIIIIIlllllI;
        lIlIIIIIIlllllI.semaphore = false;
        return lIlIIIIIIlllllI;
    }

    public ReEntranceLock push() {
        ReEntranceLock lIlIIIIIlIlIIII;
        ++lIlIIIIIlIlIIII.depth;
        lIlIIIIIlIlIIII.checkAndSet();
        return lIlIIIIIlIlIIII;
    }
}

