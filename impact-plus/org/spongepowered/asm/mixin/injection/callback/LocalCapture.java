/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.callback;

public enum LocalCapture {
    NO_CAPTURE(false, false),
    PRINT(false, true),
    CAPTURE_FAILSOFT,
    CAPTURE_FAILHARD,
    CAPTURE_FAILEXCEPTION;

    private final /* synthetic */ boolean printLocals;
    private final /* synthetic */ boolean captureLocals;

    boolean isPrintLocals() {
        LocalCapture lllllllllllllllllIIlllIlIIIllIll;
        return lllllllllllllllllIIlllIlIIIllIll.printLocals;
    }

    private LocalCapture(boolean lllllllllllllllllIIlllIlIIlIlIII, boolean lllllllllllllllllIIlllIlIlIIIlll) {
        LocalCapture lllllllllllllllllIIlllIlIlIIlIll;
        lllllllllllllllllIIlllIlIlIIlIll.captureLocals = lllllllllllllllllIIlllIlIIlIlIII;
        lllllllllllllllllIIlllIlIlIIlIll.printLocals = lllllllllllllllllIIlllIlIlIIIlll;
    }

    boolean isCaptureLocals() {
        LocalCapture lllllllllllllllllIIlllIlIIIlllll;
        return lllllllllllllllllIIlllIlIIIlllll.captureLocals;
    }

    private LocalCapture() {
        lllllllllllllllllIIlllIlIlIlllII(true, false);
        LocalCapture lllllllllllllllllIIlllIlIlIlllII;
    }
}

