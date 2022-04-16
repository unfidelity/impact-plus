/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.objectweb.asm.commons.Remapper
 */
package org.spongepowered.asm.bridge;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.objectweb.asm.commons.Remapper;
import org.spongepowered.asm.mixin.extensibility.IRemapper;
import org.spongepowered.asm.util.ObfuscationUtil;

public abstract class RemapperAdapter
implements ObfuscationUtil.IClassRemapper,
IRemapper {
    protected final /* synthetic */ Remapper remapper;
    protected final /* synthetic */ Logger logger;

    public RemapperAdapter(Remapper llllllllllllllllIllIlllIllIllIII) {
        RemapperAdapter llllllllllllllllIllIlllIllIllIIl;
        llllllllllllllllIllIlllIllIllIIl.logger = LogManager.getLogger((String)"mixin");
        llllllllllllllllIllIlllIllIllIIl.remapper = llllllllllllllllIllIlllIllIllIII;
    }

    @Override
    public String unmap(String llllllllllllllllIllIlllIlIlIIIII) {
        return llllllllllllllllIllIlllIlIlIIIII;
    }

    @Override
    public String mapMethodName(String llllllllllllllllIllIlllIllIIlIlI, String llllllllllllllllIllIlllIllIIlIIl, String llllllllllllllllIllIlllIllIIlIII) {
        RemapperAdapter llllllllllllllllIllIlllIllIIIlII;
        llllllllllllllllIllIlllIllIIIlII.logger.debug("{} is remapping method {}{} for {}", new Object[]{llllllllllllllllIllIlllIllIIIlII, llllllllllllllllIllIlllIllIIlIIl, llllllllllllllllIllIlllIllIIlIII, llllllllllllllllIllIlllIllIIlIlI});
        String llllllllllllllllIllIlllIllIIIlll = llllllllllllllllIllIlllIllIIIlII.remapper.mapMethodName(llllllllllllllllIllIlllIllIIlIlI, llllllllllllllllIllIlllIllIIlIIl, llllllllllllllllIllIlllIllIIlIII);
        if (!llllllllllllllllIllIlllIllIIIlll.equals(llllllllllllllllIllIlllIllIIlIIl)) {
            return llllllllllllllllIllIlllIllIIIlll;
        }
        String llllllllllllllllIllIlllIllIIIllI = llllllllllllllllIllIlllIllIIIlII.unmap(llllllllllllllllIllIlllIllIIlIlI);
        String llllllllllllllllIllIlllIllIIIlIl = llllllllllllllllIllIlllIllIIIlII.unmapDesc(llllllllllllllllIllIlllIllIIlIII);
        llllllllllllllllIllIlllIllIIIlII.logger.debug("{} is remapping obfuscated method {}{} for {}", new Object[]{llllllllllllllllIllIlllIllIIIlII, llllllllllllllllIllIlllIllIIlIIl, llllllllllllllllIllIlllIllIIIlIl, llllllllllllllllIllIlllIllIIIllI});
        return llllllllllllllllIllIlllIllIIIlII.remapper.mapMethodName(llllllllllllllllIllIlllIllIIIllI, llllllllllllllllIllIlllIllIIlIIl, llllllllllllllllIllIlllIllIIIlIl);
    }

    @Override
    public String mapFieldName(String llllllllllllllllIllIlllIlIlIlllI, String llllllllllllllllIllIlllIlIllIlII, String llllllllllllllllIllIlllIlIlIllII) {
        RemapperAdapter llllllllllllllllIllIlllIlIlIllll;
        llllllllllllllllIllIlllIlIlIllll.logger.debug("{} is remapping field {}{} for {}", new Object[]{llllllllllllllllIllIlllIlIlIllll, llllllllllllllllIllIlllIlIllIlII, llllllllllllllllIllIlllIlIlIllII, llllllllllllllllIllIlllIlIlIlllI});
        String llllllllllllllllIllIlllIlIllIIlI = llllllllllllllllIllIlllIlIlIllll.remapper.mapFieldName(llllllllllllllllIllIlllIlIlIlllI, llllllllllllllllIllIlllIlIllIlII, llllllllllllllllIllIlllIlIlIllII);
        if (!llllllllllllllllIllIlllIlIllIIlI.equals(llllllllllllllllIllIlllIlIllIlII)) {
            return llllllllllllllllIllIlllIlIllIIlI;
        }
        String llllllllllllllllIllIlllIlIllIIIl = llllllllllllllllIllIlllIlIlIllll.unmap(llllllllllllllllIllIlllIlIlIlllI);
        String llllllllllllllllIllIlllIlIllIIII = llllllllllllllllIllIlllIlIlIllll.unmapDesc(llllllllllllllllIllIlllIlIlIllII);
        llllllllllllllllIllIlllIlIlIllll.logger.debug("{} is remapping obfuscated field {}{} for {}", new Object[]{llllllllllllllllIllIlllIlIlIllll, llllllllllllllllIllIlllIlIllIlII, llllllllllllllllIllIlllIlIllIIII, llllllllllllllllIllIlllIlIllIIIl});
        return llllllllllllllllIllIlllIlIlIllll.remapper.mapFieldName(llllllllllllllllIllIlllIlIllIIIl, llllllllllllllllIllIlllIlIllIlII, llllllllllllllllIllIlllIlIllIIII);
    }

    @Override
    public String mapDesc(String llllllllllllllllIllIlllIlIIllIll) {
        RemapperAdapter llllllllllllllllIllIlllIlIIllIlI;
        return llllllllllllllllIllIlllIlIIllIlI.remapper.mapDesc(llllllllllllllllIllIlllIlIIllIll);
    }

    @Override
    public String unmapDesc(String llllllllllllllllIllIlllIlIIlIIll) {
        RemapperAdapter llllllllllllllllIllIlllIlIIlIllI;
        return ObfuscationUtil.unmapDescriptor(llllllllllllllllIllIlllIlIIlIIll, llllllllllllllllIllIlllIlIIlIllI);
    }

    public String toString() {
        RemapperAdapter llllllllllllllllIllIlllIllIlIIll;
        return llllllllllllllllIllIlllIllIlIIll.getClass().getSimpleName();
    }

    @Override
    public String map(String llllllllllllllllIllIlllIlIlIIlIl) {
        RemapperAdapter llllllllllllllllIllIlllIlIlIIllI;
        llllllllllllllllIllIlllIlIlIIllI.logger.debug("{} is remapping class {}", new Object[]{llllllllllllllllIllIlllIlIlIIllI, llllllllllllllllIllIlllIlIlIIlIl});
        return llllllllllllllllIllIlllIlIlIIllI.remapper.map(llllllllllllllllIllIlllIlIlIIlIl);
    }
}

