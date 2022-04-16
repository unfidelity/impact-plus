/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

public final class Handle {
    final /* synthetic */ boolean itf;
    final /* synthetic */ int tag;
    final /* synthetic */ String name;
    final /* synthetic */ String owner;
    final /* synthetic */ String desc;

    @Deprecated
    public Handle(int llllllllllllllllIIllIIIlIlllIIlI, String llllllllllllllllIIllIIIlIlllIllI, String llllllllllllllllIIllIIIlIlllIlIl, String llllllllllllllllIIllIIIlIlllIlII) {
        llllllllllllllllIIllIIIlIllllIII(llllllllllllllllIIllIIIlIlllIIlI, llllllllllllllllIIllIIIlIlllIllI, llllllllllllllllIIllIIIlIlllIlIl, llllllllllllllllIIllIIIlIlllIlII, llllllllllllllllIIllIIIlIlllIIlI == 9);
        Handle llllllllllllllllIIllIIIlIllllIII;
    }

    public String toString() {
        Handle llllllllllllllllIIllIIIlIIllllll;
        return String.valueOf(new StringBuilder().append(llllllllllllllllIIllIIIlIIllllll.owner).append('.').append(llllllllllllllllIIllIIIlIIllllll.name).append(llllllllllllllllIIllIIIlIIllllll.desc).append(" (").append(llllllllllllllllIIllIIIlIIllllll.tag).append(llllllllllllllllIIllIIIlIIllllll.itf ? " itf" : "").append(')'));
    }

    public int getTag() {
        Handle llllllllllllllllIIllIIIlIlIllIll;
        return llllllllllllllllIIllIIIlIlIllIll.tag;
    }

    public String getDesc() {
        Handle llllllllllllllllIIllIIIlIlIlIIIl;
        return llllllllllllllllIIllIIIlIlIlIIIl.desc;
    }

    public String getOwner() {
        Handle llllllllllllllllIIllIIIlIlIllIII;
        return llllllllllllllllIIllIIIlIlIllIII.owner;
    }

    public boolean isInterface() {
        Handle llllllllllllllllIIllIIIlIlIIlllI;
        return llllllllllllllllIIllIIIlIlIIlllI.itf;
    }

    public String getName() {
        Handle llllllllllllllllIIllIIIlIlIlIlII;
        return llllllllllllllllIIllIIIlIlIlIlII.name;
    }

    public int hashCode() {
        Handle llllllllllllllllIIllIIIlIlIIIIll;
        return llllllllllllllllIIllIIIlIlIIIIll.tag + (llllllllllllllllIIllIIIlIlIIIIll.itf ? 64 : 0) + llllllllllllllllIIllIIIlIlIIIIll.owner.hashCode() * llllllllllllllllIIllIIIlIlIIIIll.name.hashCode() * llllllllllllllllIIllIIIlIlIIIIll.desc.hashCode();
    }

    public boolean equals(Object llllllllllllllllIIllIIIlIlIIlIIl) {
        Handle llllllllllllllllIIllIIIlIlIIlIlI;
        if (llllllllllllllllIIllIIIlIlIIlIIl == llllllllllllllllIIllIIIlIlIIlIlI) {
            return true;
        }
        if (!(llllllllllllllllIIllIIIlIlIIlIIl instanceof Handle)) {
            return false;
        }
        Handle llllllllllllllllIIllIIIlIlIIlIII = (Handle)llllllllllllllllIIllIIIlIlIIlIIl;
        return llllllllllllllllIIllIIIlIlIIlIlI.tag == llllllllllllllllIIllIIIlIlIIlIII.tag && llllllllllllllllIIllIIIlIlIIlIlI.itf == llllllllllllllllIIllIIIlIlIIlIII.itf && llllllllllllllllIIllIIIlIlIIlIlI.owner.equals(llllllllllllllllIIllIIIlIlIIlIII.owner) && llllllllllllllllIIllIIIlIlIIlIlI.name.equals(llllllllllllllllIIllIIIlIlIIlIII.name) && llllllllllllllllIIllIIIlIlIIlIlI.desc.equals(llllllllllllllllIIllIIIlIlIIlIII.desc);
    }

    public Handle(int llllllllllllllllIIllIIIlIllIIIIl, String llllllllllllllllIIllIIIlIllIIllI, String llllllllllllllllIIllIIIlIlIlllll, String llllllllllllllllIIllIIIlIlIllllI, boolean llllllllllllllllIIllIIIlIllIIIll) {
        Handle llllllllllllllllIIllIIIlIllIIIlI;
        llllllllllllllllIIllIIIlIllIIIlI.tag = llllllllllllllllIIllIIIlIllIIIIl;
        llllllllllllllllIIllIIIlIllIIIlI.owner = llllllllllllllllIIllIIIlIllIIllI;
        llllllllllllllllIIllIIIlIllIIIlI.name = llllllllllllllllIIllIIIlIlIlllll;
        llllllllllllllllIIllIIIlIllIIIlI.desc = llllllllllllllllIIllIIIlIlIllllI;
        llllllllllllllllIIllIIIlIllIIIlI.itf = llllllllllllllllIIllIIIlIllIIIll;
    }
}

