/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.obfuscation.mapping.mcp;

import org.spongepowered.asm.obfuscation.mapping.common.MappingField;

public class MappingFieldSrg
extends MappingField {
    private final /* synthetic */ String srg;

    private static String getOwnerFromSrg(String llllllllllllllllIlIIlIIllIIlIIIl) {
        if (llllllllllllllllIlIIlIIllIIlIIIl == null) {
            return null;
        }
        int llllllllllllllllIlIIlIIllIIlIIlI = llllllllllllllllIlIIlIIllIIlIIIl.lastIndexOf(47);
        return llllllllllllllllIlIIlIIllIIlIIlI > -1 ? llllllllllllllllIlIIlIIllIIlIIIl.substring(0, llllllllllllllllIlIIlIIllIIlIIlI) : null;
    }

    public MappingFieldSrg(String llllllllllllllllIlIIlIIllIlIIlIl) {
        super(MappingFieldSrg.getOwnerFromSrg(llllllllllllllllIlIIlIIllIlIIlIl), MappingFieldSrg.getNameFromSrg(llllllllllllllllIlIIlIIllIlIIlIl), null);
        MappingFieldSrg llllllllllllllllIlIIlIIllIlIlIII;
        llllllllllllllllIlIIlIIllIlIlIII.srg = llllllllllllllllIlIIlIIllIlIIlIl;
    }

    private static String getNameFromSrg(String llllllllllllllllIlIIlIIllIIlIlll) {
        if (llllllllllllllllIlIIlIIllIIlIlll == null) {
            return null;
        }
        int llllllllllllllllIlIIlIIllIIllIII = llllllllllllllllIlIIlIIllIIlIlll.lastIndexOf(47);
        return llllllllllllllllIlIIlIIllIIllIII > -1 ? llllllllllllllllIlIIlIIllIIlIlll.substring(llllllllllllllllIlIIlIIllIIllIII + 1) : llllllllllllllllIlIIlIIllIIlIlll;
    }

    @Override
    public String serialise() {
        MappingFieldSrg llllllllllllllllIlIIlIIllIIlllII;
        return llllllllllllllllIlIIlIIllIIlllII.srg;
    }

    public MappingFieldSrg(MappingField llllllllllllllllIlIIlIIllIlIIIIl) {
        super(llllllllllllllllIlIIlIIllIlIIIIl.getOwner(), llllllllllllllllIlIIlIIllIlIIIIl.getName(), null);
        MappingFieldSrg llllllllllllllllIlIIlIIllIlIIIlI;
        llllllllllllllllIlIIlIIllIlIIIlI.srg = String.valueOf(new StringBuilder().append(llllllllllllllllIlIIlIIllIlIIIIl.getOwner()).append("/").append(llllllllllllllllIlIIlIIllIlIIIIl.getName()));
    }
}

