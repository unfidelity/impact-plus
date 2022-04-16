/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Objects
 */
package org.spongepowered.asm.obfuscation.mapping.common;

import com.google.common.base.Objects;
import org.spongepowered.asm.obfuscation.mapping.IMapping;

public class MappingMethod
implements IMapping<MappingMethod> {
    private final /* synthetic */ String desc;
    private final /* synthetic */ String name;
    private final /* synthetic */ String owner;

    @Override
    public IMapping.Type getType() {
        return IMapping.Type.METHOD;
    }

    @Override
    public String getName() {
        MappingMethod llllllllllllllllIlIllIlIlllIlIIl;
        if (llllllllllllllllIlIllIlIlllIlIIl.name == null) {
            return null;
        }
        return String.valueOf(new StringBuilder().append(llllllllllllllllIlIllIlIlllIlIIl.owner != null ? String.valueOf(new StringBuilder().append(llllllllllllllllIlIllIlIlllIlIIl.owner).append("/")) : "").append(llllllllllllllllIlIllIlIlllIlIIl.name));
    }

    public MappingMethod addPrefix(String llllllllllllllllIlIllIlIlIIIllII) {
        MappingMethod llllllllllllllllIlIllIlIlIIlIIll;
        String llllllllllllllllIlIllIlIlIIIllll = llllllllllllllllIlIllIlIlIIlIIll.getSimpleName();
        if (llllllllllllllllIlIllIlIlIIIllll == null || llllllllllllllllIlIllIlIlIIIllll.startsWith(llllllllllllllllIlIllIlIlIIIllII)) {
            return llllllllllllllllIlIllIlIlIIlIIll;
        }
        return new MappingMethod(llllllllllllllllIlIllIlIlIIlIIll.getOwner(), String.valueOf(new StringBuilder().append(llllllllllllllllIlIllIlIlIIIllII).append(llllllllllllllllIlIllIlIlIIIllll)), llllllllllllllllIlIllIlIlIIlIIll.getDesc());
    }

    private static String getOwnerFromName(String llllllllllllllllIlIllIlIIlIIIIII) {
        if (llllllllllllllllIlIllIlIIlIIIIII == null) {
            return null;
        }
        int llllllllllllllllIlIllIlIIIlllIll = llllllllllllllllIlIllIlIIlIIIIII.lastIndexOf(47);
        return llllllllllllllllIlIllIlIIIlllIll > -1 ? llllllllllllllllIlIllIlIIlIIIIII.substring(0, llllllllllllllllIlIllIlIIIlllIll) : null;
    }

    @Override
    public MappingMethod transform(String llllllllllllllllIlIllIlIlIlIIlII) {
        MappingMethod llllllllllllllllIlIllIlIlIlIIlIl;
        return new MappingMethod(llllllllllllllllIlIllIlIlIlIIlIl.getOwner(), llllllllllllllllIlIllIlIlIlIIlIl.getSimpleName(), llllllllllllllllIlIllIlIlIlIIlII);
    }

    public MappingMethod(String llllllllllllllllIlIllIlIlllIlllI, String llllllllllllllllIlIllIlIlllIllIl, String llllllllllllllllIlIllIlIllllIIII) {
        MappingMethod llllllllllllllllIlIllIlIlllIllll;
        llllllllllllllllIlIllIlIlllIllll.owner = llllllllllllllllIlIllIlIlllIlllI;
        llllllllllllllllIlIllIlIlllIllll.name = llllllllllllllllIlIllIlIlllIllIl;
        llllllllllllllllIlIllIlIlllIllll.desc = llllllllllllllllIlIllIlIllllIIII;
    }

    public MappingMethod(String llllllllllllllllIlIllIllIIIIIIlI, String llllllllllllllllIlIllIllIIIIIlII) {
        llllllllllllllllIlIllIllIIIIlIll(MappingMethod.getOwnerFromName(llllllllllllllllIlIllIllIIIIIIlI), MappingMethod.getBaseName(llllllllllllllllIlIllIllIIIIIIlI), llllllllllllllllIlIllIllIIIIIlII);
        MappingMethod llllllllllllllllIlIllIllIIIIlIll;
    }

    public boolean isConstructor() {
        MappingMethod llllllllllllllllIlIllIlIllIIIlll;
        return "<init>".equals(llllllllllllllllIlIllIlIllIIIlll.name);
    }

    public String toString() {
        MappingMethod llllllllllllllllIlIllIlIIllIIIlI;
        String llllllllllllllllIlIllIlIIllIIlII = llllllllllllllllIlIllIlIIllIIIlI.getDesc();
        return String.format("%s%s%s", llllllllllllllllIlIllIlIIllIIIlI.getName(), llllllllllllllllIlIllIlIIllIIlII != null ? " " : "", llllllllllllllllIlIllIlIIllIIlII != null ? llllllllllllllllIlIllIlIIllIIlII : "");
    }

    @Override
    public MappingMethod copy() {
        MappingMethod llllllllllllllllIlIllIlIlIIlllIl;
        return new MappingMethod(llllllllllllllllIlIllIlIlIIlllIl.getOwner(), llllllllllllllllIlIllIlIlIIlllIl.getSimpleName(), llllllllllllllllIlIllIlIlIIlllIl.getDesc());
    }

    private static String getBaseName(String llllllllllllllllIlIllIlIIlIlIIIl) {
        if (llllllllllllllllIlIllIlIIlIlIIIl == null) {
            return null;
        }
        int llllllllllllllllIlIllIlIIlIIllll = llllllllllllllllIlIllIlIIlIlIIIl.lastIndexOf(47);
        return llllllllllllllllIlIllIlIIlIIllll > -1 ? llllllllllllllllIlIllIlIIlIlIIIl.substring(llllllllllllllllIlIllIlIIlIIllll + 1) : llllllllllllllllIlIllIlIIlIlIIIl;
    }

    @Override
    public MappingMethod getSuper() {
        return null;
    }

    @Override
    public String getDesc() {
        MappingMethod llllllllllllllllIlIllIlIllIlIIIl;
        return llllllllllllllllIlIllIlIllIlIIIl.desc;
    }

    public boolean equals(Object llllllllllllllllIlIllIlIIllllIlI) {
        MappingMethod llllllllllllllllIlIllIlIIllllIIl;
        if (llllllllllllllllIlIllIlIIllllIIl == llllllllllllllllIlIllIlIIllllIlI) {
            return true;
        }
        if (llllllllllllllllIlIllIlIIllllIlI instanceof MappingMethod) {
            return Objects.equal((Object)llllllllllllllllIlIllIlIIllllIIl.name, (Object)((MappingMethod)llllllllllllllllIlIllIlIIllllIlI).name) && Objects.equal((Object)llllllllllllllllIlIllIlIIllllIIl.desc, (Object)((MappingMethod)llllllllllllllllIlIllIlIIllllIlI).desc);
        }
        return false;
    }

    public int hashCode() {
        MappingMethod llllllllllllllllIlIllIlIlIIIIlII;
        return Objects.hashCode((Object[])new Object[]{llllllllllllllllIlIllIlIlIIIIlII.getName(), llllllllllllllllIlIllIlIlIIIIlII.getDesc()});
    }

    @Override
    public String getSimpleName() {
        MappingMethod llllllllllllllllIlIllIlIllIlllll;
        return llllllllllllllllIlIllIlIllIlllll.name;
    }

    @Override
    public String getOwner() {
        MappingMethod llllllllllllllllIlIllIlIllIllIlI;
        return llllllllllllllllIlIllIlIllIllIlI.owner;
    }

    @Override
    public MappingMethod move(String llllllllllllllllIlIllIlIlIllllIl) {
        MappingMethod llllllllllllllllIlIllIlIllIIIIII;
        return new MappingMethod(llllllllllllllllIlIllIlIlIllllIl, llllllllllllllllIlIllIlIllIIIIII.getSimpleName(), llllllllllllllllIlIllIlIllIIIIII.getDesc());
    }

    @Override
    public String serialise() {
        MappingMethod llllllllllllllllIlIllIlIIllIllIl;
        return llllllllllllllllIlIllIlIIllIllIl.toString();
    }

    @Override
    public MappingMethod remap(String llllllllllllllllIlIllIlIlIlIlllI) {
        MappingMethod llllllllllllllllIlIllIlIlIllIIlI;
        return new MappingMethod(llllllllllllllllIlIllIlIlIllIIlI.getOwner(), llllllllllllllllIlIllIlIlIlIlllI, llllllllllllllllIlIllIlIlIllIIlI.getDesc());
    }
}

