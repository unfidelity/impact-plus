/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.ByteVector;
import org.spongepowered.asm.lib.Edge;
import org.spongepowered.asm.lib.Frame;
import org.spongepowered.asm.lib.MethodWriter;

public class Label {
    public /* synthetic */ Object info;
    /* synthetic */ Label next;
    /* synthetic */ int status;
    /* synthetic */ int inputStackTop;
    static final /* synthetic */ int JSR;
    static final /* synthetic */ int TARGET;
    /* synthetic */ Edge successors;
    /* synthetic */ int line;
    static final /* synthetic */ int STORE;
    static final /* synthetic */ int PUSHED;
    /* synthetic */ int outputStackMax;
    static final /* synthetic */ int VISITED2;
    static final /* synthetic */ int RESIZED;
    static final /* synthetic */ int DEBUG;
    static final /* synthetic */ int REACHABLE;
    /* synthetic */ Label successor;
    private /* synthetic */ int referenceCount;
    static final /* synthetic */ int VISITED;
    /* synthetic */ Frame frame;
    /* synthetic */ int position;
    private /* synthetic */ int[] srcAndRefPositions;
    static final /* synthetic */ int RESOLVED;
    static final /* synthetic */ int RET;
    static final /* synthetic */ int SUBROUTINE;

    static {
        PUSHED = 8;
        SUBROUTINE = 512;
        RET = 256;
        RESOLVED = 2;
        REACHABLE = 64;
        VISITED2 = 2048;
        DEBUG = 1;
        STORE = 32;
        JSR = 128;
        VISITED = 1024;
        RESIZED = 4;
        TARGET = 16;
    }

    public String toString() {
        Label llllllllllllllllIllIIlIlIllIIllI;
        return String.valueOf(new StringBuilder().append("L").append(System.identityHashCode(llllllllllllllllIllIIlIlIllIIllI)));
    }

    public Label() {
        Label llllllllllllllllIllIIlIlllIlIIlI;
    }

    boolean inSubroutine(long llllllllllllllllIllIIlIllIIlIIlI) {
        Label llllllllllllllllIllIIlIllIIlIIIl;
        if ((llllllllllllllllIllIIlIllIIlIIIl.status & 0x400) != 0) {
            return (llllllllllllllllIllIIlIllIIlIIIl.srcAndRefPositions[(int)(llllllllllllllllIllIIlIllIIlIIlI >>> 32)] & (int)llllllllllllllllIllIIlIllIIlIIlI) != 0;
        }
        return false;
    }

    boolean inSameSubroutine(Label llllllllllllllllIllIIlIllIIIlIII) {
        Label llllllllllllllllIllIIlIllIIIlIIl;
        if ((llllllllllllllllIllIIlIllIIIlIIl.status & 0x400) == 0 || (llllllllllllllllIllIIlIllIIIlIII.status & 0x400) == 0) {
            return false;
        }
        for (int llllllllllllllllIllIIlIllIIIllII = 0; llllllllllllllllIllIIlIllIIIllII < llllllllllllllllIllIIlIllIIIlIIl.srcAndRefPositions.length; ++llllllllllllllllIllIIlIllIIIllII) {
            if ((llllllllllllllllIllIIlIllIIIlIIl.srcAndRefPositions[llllllllllllllllIllIIlIllIIIllII] & llllllllllllllllIllIIlIllIIIlIII.srcAndRefPositions[llllllllllllllllIllIIlIllIIIllII]) == 0) continue;
            return true;
        }
        return false;
    }

    Label getFirst() {
        Label llllllllllllllllIllIIlIllIIlIllI;
        return llllllllllllllllIllIIlIllIIlIllI.frame == null ? llllllllllllllllIllIIlIllIIlIllI : llllllllllllllllIllIIlIllIIlIllI.frame.owner;
    }

    void visitSubroutine(Label llllllllllllllllIllIIlIlIlllIIlI, long llllllllllllllllIllIIlIlIlllIIIl, int llllllllllllllllIllIIlIlIllIlIll) {
        Label llllllllllllllllIllIIlIlIlllIIll;
        Label llllllllllllllllIllIIlIlIllIllll = llllllllllllllllIllIIlIlIlllIIll;
        while (llllllllllllllllIllIIlIlIllIllll != null) {
            Label llllllllllllllllIllIIlIlIlllIlIl = llllllllllllllllIllIIlIlIllIllll;
            llllllllllllllllIllIIlIlIllIllll = llllllllllllllllIllIIlIlIlllIlIl.next;
            llllllllllllllllIllIIlIlIlllIlIl.next = null;
            if (llllllllllllllllIllIIlIlIlllIIlI != null) {
                if ((llllllllllllllllIllIIlIlIlllIlIl.status & 0x800) != 0) continue;
                llllllllllllllllIllIIlIlIlllIlIl.status |= 0x800;
                if ((llllllllllllllllIllIIlIlIlllIlIl.status & 0x100) != 0 && !llllllllllllllllIllIIlIlIlllIlIl.inSameSubroutine(llllllllllllllllIllIIlIlIlllIIlI)) {
                    Edge llllllllllllllllIllIIlIlIlllIllI = new Edge();
                    llllllllllllllllIllIIlIlIlllIllI.info = llllllllllllllllIllIIlIlIlllIlIl.inputStackTop;
                    llllllllllllllllIllIIlIlIlllIllI.successor = llllllllllllllllIllIIlIlIlllIIlI.successors.successor;
                    llllllllllllllllIllIIlIlIlllIllI.next = llllllllllllllllIllIIlIlIlllIlIl.successors;
                    llllllllllllllllIllIIlIlIlllIlIl.successors = llllllllllllllllIllIIlIlIlllIllI;
                }
            } else {
                if (llllllllllllllllIllIIlIlIlllIlIl.inSubroutine(llllllllllllllllIllIIlIlIlllIIIl)) continue;
                llllllllllllllllIllIIlIlIlllIlIl.addToSubroutine(llllllllllllllllIllIIlIlIlllIIIl, llllllllllllllllIllIIlIlIllIlIll);
            }
            Edge llllllllllllllllIllIIlIlIlllIlII = llllllllllllllllIllIIlIlIlllIlIl.successors;
            while (llllllllllllllllIllIIlIlIlllIlII != null) {
                if (((llllllllllllllllIllIIlIlIlllIlIl.status & 0x80) == 0 || llllllllllllllllIllIIlIlIlllIlII != llllllllllllllllIllIIlIlIlllIlIl.successors.next) && llllllllllllllllIllIIlIlIlllIlII.successor.next == null) {
                    llllllllllllllllIllIIlIlIlllIlII.successor.next = llllllllllllllllIllIIlIlIllIllll;
                    llllllllllllllllIllIIlIlIllIllll = llllllllllllllllIllIIlIlIlllIlII.successor;
                }
                llllllllllllllllIllIIlIlIlllIlII = llllllllllllllllIllIIlIlIlllIlII.next;
            }
        }
    }

    void addToSubroutine(long llllllllllllllllIllIIlIllIIIIIlI, int llllllllllllllllIllIIlIlIllllllI) {
        Label llllllllllllllllIllIIlIllIIIIIll;
        if ((llllllllllllllllIllIIlIllIIIIIll.status & 0x400) == 0) {
            llllllllllllllllIllIIlIllIIIIIll.status |= 0x400;
            llllllllllllllllIllIIlIllIIIIIll.srcAndRefPositions = new int[llllllllllllllllIllIIlIlIllllllI / 32 + 1];
        }
        int n = (int)(llllllllllllllllIllIIlIllIIIIIlI >>> 32);
        llllllllllllllllIllIIlIllIIIIIll.srcAndRefPositions[n] = llllllllllllllllIllIIlIllIIIIIll.srcAndRefPositions[n] | (int)llllllllllllllllIllIIlIllIIIIIlI;
    }

    void put(MethodWriter llllllllllllllllIllIIlIlllIIlIIl, ByteVector llllllllllllllllIllIIlIlllIIlIII, int llllllllllllllllIllIIlIlllIIIlll, boolean llllllllllllllllIllIIlIlllIIIllI) {
        Label llllllllllllllllIllIIlIlllIIIlIl;
        if ((llllllllllllllllIllIIlIlllIIIlIl.status & 2) == 0) {
            if (llllllllllllllllIllIIlIlllIIIllI) {
                llllllllllllllllIllIIlIlllIIIlIl.addReference(-1 - llllllllllllllllIllIIlIlllIIIlll, llllllllllllllllIllIIlIlllIIlIII.length);
                llllllllllllllllIllIIlIlllIIlIII.putInt(-1);
            } else {
                llllllllllllllllIllIIlIlllIIIlIl.addReference(llllllllllllllllIllIIlIlllIIIlll, llllllllllllllllIllIIlIlllIIlIII.length);
                llllllllllllllllIllIIlIlllIIlIII.putShort(-1);
            }
        } else if (llllllllllllllllIllIIlIlllIIIllI) {
            llllllllllllllllIllIIlIlllIIlIII.putInt(llllllllllllllllIllIIlIlllIIIlIl.position - llllllllllllllllIllIIlIlllIIIlll);
        } else {
            llllllllllllllllIllIIlIlllIIlIII.putShort(llllllllllllllllIllIIlIlllIIIlIl.position - llllllllllllllllIllIIlIlllIIIlll);
        }
    }

    boolean resolve(MethodWriter llllllllllllllllIllIIlIllIlIIllI, int llllllllllllllllIllIIlIllIlIIlIl, byte[] llllllllllllllllIllIIlIllIIlllll) {
        Label llllllllllllllllIllIIlIllIlIIIIl;
        boolean llllllllllllllllIllIIlIllIlIIIll = false;
        llllllllllllllllIllIIlIllIlIIIIl.status |= 2;
        llllllllllllllllIllIIlIllIlIIIIl.position = llllllllllllllllIllIIlIllIlIIlIl;
        int llllllllllllllllIllIIlIllIlIIIlI = 0;
        while (llllllllllllllllIllIIlIllIlIIIlI < llllllllllllllllIllIIlIllIlIIIIl.referenceCount) {
            int llllllllllllllllIllIIlIllIlIlIlI = llllllllllllllllIllIIlIllIlIIIIl.srcAndRefPositions[llllllllllllllllIllIIlIllIlIIIlI++];
            int llllllllllllllllIllIIlIllIlIlIIl = llllllllllllllllIllIIlIllIlIIIIl.srcAndRefPositions[llllllllllllllllIllIIlIllIlIIIlI++];
            if (llllllllllllllllIllIIlIllIlIlIlI >= 0) {
                int llllllllllllllllIllIIlIllIlIlIll = llllllllllllllllIllIIlIllIlIIlIl - llllllllllllllllIllIIlIllIlIlIlI;
                if (llllllllllllllllIllIIlIllIlIlIll < Short.MIN_VALUE || llllllllllllllllIllIIlIllIlIlIll > Short.MAX_VALUE) {
                    int llllllllllllllllIllIIlIllIlIllII = llllllllllllllllIllIIlIllIIlllll[llllllllllllllllIllIIlIllIlIlIIl - 1] & 0xFF;
                    llllllllllllllllIllIIlIllIIlllll[llllllllllllllllIllIIlIllIlIlIIl - 1] = llllllllllllllllIllIIlIllIlIllII <= 168 ? (byte)(llllllllllllllllIllIIlIllIlIllII + 49) : (byte)(llllllllllllllllIllIIlIllIlIllII + 20);
                    llllllllllllllllIllIIlIllIlIIIll = true;
                }
                llllllllllllllllIllIIlIllIIlllll[llllllllllllllllIllIIlIllIlIlIIl++] = (byte)(llllllllllllllllIllIIlIllIlIlIll >>> 8);
                llllllllllllllllIllIIlIllIIlllll[llllllllllllllllIllIIlIllIlIlIIl] = (byte)llllllllllllllllIllIIlIllIlIlIll;
                continue;
            }
            int llllllllllllllllIllIIlIllIlIlIII = llllllllllllllllIllIIlIllIlIIlIl + llllllllllllllllIllIIlIllIlIlIlI + 1;
            llllllllllllllllIllIIlIllIIlllll[llllllllllllllllIllIIlIllIlIlIIl++] = (byte)(llllllllllllllllIllIIlIllIlIlIII >>> 24);
            llllllllllllllllIllIIlIllIIlllll[llllllllllllllllIllIIlIllIlIlIIl++] = (byte)(llllllllllllllllIllIIlIllIlIlIII >>> 16);
            llllllllllllllllIllIIlIllIIlllll[llllllllllllllllIllIIlIllIlIlIIl++] = (byte)(llllllllllllllllIllIIlIllIlIlIII >>> 8);
            llllllllllllllllIllIIlIllIIlllll[llllllllllllllllIllIIlIllIlIlIIl] = (byte)llllllllllllllllIllIIlIllIlIlIII;
        }
        return llllllllllllllllIllIIlIllIlIIIll;
    }

    private void addReference(int llllllllllllllllIllIIlIllIlllIII, int llllllllllllllllIllIIlIllIlllIlI) {
        Label llllllllllllllllIllIIlIllIllllII;
        if (llllllllllllllllIllIIlIllIllllII.srcAndRefPositions == null) {
            llllllllllllllllIllIIlIllIllllII.srcAndRefPositions = new int[6];
        }
        if (llllllllllllllllIllIIlIllIllllII.referenceCount >= llllllllllllllllIllIIlIllIllllII.srcAndRefPositions.length) {
            int[] llllllllllllllllIllIIlIllIllllIl = new int[llllllllllllllllIllIIlIllIllllII.srcAndRefPositions.length + 6];
            System.arraycopy(llllllllllllllllIllIIlIllIllllII.srcAndRefPositions, 0, llllllllllllllllIllIIlIllIllllIl, 0, llllllllllllllllIllIIlIllIllllII.srcAndRefPositions.length);
            llllllllllllllllIllIIlIllIllllII.srcAndRefPositions = llllllllllllllllIllIIlIllIllllIl;
        }
        llllllllllllllllIllIIlIllIllllII.srcAndRefPositions[llllllllllllllllIllIIlIllIllllII.referenceCount++] = llllllllllllllllIllIIlIllIlllIII;
        llllllllllllllllIllIIlIllIllllII.srcAndRefPositions[llllllllllllllllIllIIlIllIllllII.referenceCount++] = llllllllllllllllIllIIlIllIlllIlI;
    }

    public int getOffset() {
        Label llllllllllllllllIllIIlIlllIlIIII;
        if ((llllllllllllllllIllIIlIlllIlIIII.status & 2) == 0) {
            throw new IllegalStateException("Label offset position has not been resolved yet");
        }
        return llllllllllllllllIllIIlIlllIlIIII.position;
    }
}

