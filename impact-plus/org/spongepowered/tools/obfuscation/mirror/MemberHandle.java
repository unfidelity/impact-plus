/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.mirror;

import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.tools.obfuscation.mirror.Visibility;

public abstract class MemberHandle<T extends IMapping<T>> {
    private final /* synthetic */ String owner;
    private final /* synthetic */ String name;
    private final /* synthetic */ String desc;

    protected MemberHandle(String llllllllllllllllllIIlllIlllIlIll, String llllllllllllllllllIIlllIlllIlIlI, String llllllllllllllllllIIlllIlllIIlIl) {
        MemberHandle llllllllllllllllllIIlllIlllIllII;
        llllllllllllllllllIIlllIlllIllII.owner = llllllllllllllllllIIlllIlllIlIll;
        llllllllllllllllllIIlllIlllIllII.name = llllllllllllllllllIIlllIlllIlIlI;
        llllllllllllllllllIIlllIlllIllII.desc = llllllllllllllllllIIlllIlllIIlIl;
    }

    public final String getName() {
        MemberHandle llllllllllllllllllIIlllIlllIIIII;
        return llllllllllllllllllIIlllIlllIIIII.name;
    }

    public final String getDesc() {
        MemberHandle llllllllllllllllllIIlllIllIlllIl;
        return llllllllllllllllllIIlllIllIlllIl.desc;
    }

    public final String getOwner() {
        MemberHandle llllllllllllllllllIIlllIlllIIIlI;
        return llllllllllllllllllIIlllIlllIIIlI.owner;
    }

    public abstract T asMapping(boolean var1);

    public abstract Visibility getVisibility();
}

