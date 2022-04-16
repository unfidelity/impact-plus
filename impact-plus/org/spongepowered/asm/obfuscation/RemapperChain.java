/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.obfuscation;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.mixin.extensibility.IRemapper;

public class RemapperChain
implements IRemapper {
    private final /* synthetic */ List<IRemapper> remappers;

    @Override
    public String map(String lllllllllllllllIlllIlllIIIlIlllI) {
        RemapperChain lllllllllllllllIlllIlllIIIlIllIl;
        for (IRemapper lllllllllllllllIlllIlllIIIllIIII : lllllllllllllllIlllIlllIIIlIllIl.remappers) {
            String lllllllllllllllIlllIlllIIIllIIIl = lllllllllllllllIlllIlllIIIllIIII.map(lllllllllllllllIlllIlllIIIlIlllI);
            if (lllllllllllllllIlllIlllIIIllIIIl == null || lllllllllllllllIlllIlllIIIllIIIl.equals(lllllllllllllllIlllIlllIIIlIlllI)) continue;
            lllllllllllllllIlllIlllIIIlIlllI = lllllllllllllllIlllIlllIIIllIIIl;
        }
        return lllllllllllllllIlllIlllIIIlIlllI;
    }

    public RemapperChain() {
        RemapperChain lllllllllllllllIlllIlllIIllIlIII;
        lllllllllllllllIlllIlllIIllIlIII.remappers = new ArrayList<IRemapper>();
    }

    public String toString() {
        RemapperChain lllllllllllllllIlllIlllIIllIIlIl;
        return String.format("RemapperChain[%d]", lllllllllllllllIlllIlllIIllIIlIl.remappers.size());
    }

    @Override
    public String mapDesc(String lllllllllllllllIlllIlllIIIIlIIlI) {
        RemapperChain lllllllllllllllIlllIlllIIIIlIIIl;
        for (IRemapper lllllllllllllllIlllIlllIIIIlIlII : lllllllllllllllIlllIlllIIIIlIIIl.remappers) {
            String lllllllllllllllIlllIlllIIIIlIlIl = lllllllllllllllIlllIlllIIIIlIlII.mapDesc(lllllllllllllllIlllIlllIIIIlIIlI);
            if (lllllllllllllllIlllIlllIIIIlIlIl == null || lllllllllllllllIlllIlllIIIIlIlIl.equals(lllllllllllllllIlllIlllIIIIlIIlI)) continue;
            lllllllllllllllIlllIlllIIIIlIIlI = lllllllllllllllIlllIlllIIIIlIlIl;
        }
        return lllllllllllllllIlllIlllIIIIlIIlI;
    }

    @Override
    public String mapMethodName(String lllllllllllllllIlllIlllIIlIlIlII, String lllllllllllllllIlllIlllIIlIIllll, String lllllllllllllllIlllIlllIIlIlIIlI) {
        RemapperChain lllllllllllllllIlllIlllIIlIlIIIl;
        for (IRemapper lllllllllllllllIlllIlllIIlIlIllI : lllllllllllllllIlllIlllIIlIlIIIl.remappers) {
            String lllllllllllllllIlllIlllIIlIlIlll = lllllllllllllllIlllIlllIIlIlIllI.mapMethodName(lllllllllllllllIlllIlllIIlIlIlII, lllllllllllllllIlllIlllIIlIIllll, lllllllllllllllIlllIlllIIlIlIIlI);
            if (lllllllllllllllIlllIlllIIlIlIlll == null || lllllllllllllllIlllIlllIIlIlIlll.equals(lllllllllllllllIlllIlllIIlIIllll)) continue;
            lllllllllllllllIlllIlllIIlIIllll = lllllllllllllllIlllIlllIIlIlIlll;
        }
        return lllllllllllllllIlllIlllIIlIIllll;
    }

    public RemapperChain add(IRemapper lllllllllllllllIlllIlllIIllIIIIl) {
        RemapperChain lllllllllllllllIlllIlllIIllIIIlI;
        lllllllllllllllIlllIlllIIllIIIlI.remappers.add(lllllllllllllllIlllIlllIIllIIIIl);
        return lllllllllllllllIlllIlllIIllIIIlI;
    }

    @Override
    public String mapFieldName(String lllllllllllllllIlllIlllIIlIIIIII, String lllllllllllllllIlllIlllIIIllllll, String lllllllllllllllIlllIlllIIIlllllI) {
        RemapperChain lllllllllllllllIlllIlllIIlIIIIIl;
        for (IRemapper lllllllllllllllIlllIlllIIlIIIIlI : lllllllllllllllIlllIlllIIlIIIIIl.remappers) {
            String lllllllllllllllIlllIlllIIlIIIIll = lllllllllllllllIlllIlllIIlIIIIlI.mapFieldName(lllllllllllllllIlllIlllIIlIIIIII, lllllllllllllllIlllIlllIIIllllll, lllllllllllllllIlllIlllIIIlllllI);
            if (lllllllllllllllIlllIlllIIlIIIIll == null || lllllllllllllllIlllIlllIIlIIIIll.equals(lllllllllllllllIlllIlllIIIllllll)) continue;
            lllllllllllllllIlllIlllIIIllllll = lllllllllllllllIlllIlllIIlIIIIll;
        }
        return lllllllllllllllIlllIlllIIIllllll;
    }

    @Override
    public String unmap(String lllllllllllllllIlllIlllIIIIllllI) {
        RemapperChain lllllllllllllllIlllIlllIIIlIIIIl;
        for (IRemapper lllllllllllllllIlllIlllIIIlIIIlI : lllllllllllllllIlllIlllIIIlIIIIl.remappers) {
            String lllllllllllllllIlllIlllIIIlIIIll = lllllllllllllllIlllIlllIIIlIIIlI.unmap(lllllllllllllllIlllIlllIIIIllllI);
            if (lllllllllllllllIlllIlllIIIlIIIll == null || lllllllllllllllIlllIlllIIIlIIIll.equals(lllllllllllllllIlllIlllIIIIllllI)) continue;
            lllllllllllllllIlllIlllIIIIllllI = lllllllllllllllIlllIlllIIIlIIIll;
        }
        return lllllllllllllllIlllIlllIIIIllllI;
    }

    @Override
    public String unmapDesc(String lllllllllllllllIlllIlllIIIIIIIlI) {
        RemapperChain lllllllllllllllIlllIlllIIIIIIIll;
        for (IRemapper lllllllllllllllIlllIlllIIIIIIllI : lllllllllllllllIlllIlllIIIIIIIll.remappers) {
            String lllllllllllllllIlllIlllIIIIIIlll = lllllllllllllllIlllIlllIIIIIIllI.unmapDesc(lllllllllllllllIlllIlllIIIIIIIlI);
            if (lllllllllllllllIlllIlllIIIIIIlll == null || lllllllllllllllIlllIlllIIIIIIlll.equals(lllllllllllllllIlllIlllIIIIIIIlI)) continue;
            lllllllllllllllIlllIlllIIIIIIIlI = lllllllllllllllIlllIlllIIIIIIlll;
        }
        return lllllllllllllllIlllIlllIIIIIIIlI;
    }
}

