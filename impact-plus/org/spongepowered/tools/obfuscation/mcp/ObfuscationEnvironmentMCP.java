/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.mcp;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.mapping.IMappingProvider;
import org.spongepowered.tools.obfuscation.mapping.IMappingWriter;
import org.spongepowered.tools.obfuscation.mapping.mcp.MappingProviderSrg;
import org.spongepowered.tools.obfuscation.mapping.mcp.MappingWriterSrg;

public class ObfuscationEnvironmentMCP
extends ObfuscationEnvironment {
    @Override
    protected IMappingWriter getMappingWriter(Messager lllllllllllllllllIIIIlIlllllIllI, Filer lllllllllllllllllIIIIlIlllllIIll) {
        return new MappingWriterSrg(lllllllllllllllllIIIIlIlllllIllI, lllllllllllllllllIIIIlIlllllIIll);
    }

    protected ObfuscationEnvironmentMCP(ObfuscationType lllllllllllllllllIIIIllIIIIIIIll) {
        super(lllllllllllllllllIIIIllIIIIIIIll);
        ObfuscationEnvironmentMCP lllllllllllllllllIIIIllIIIIIIIlI;
    }

    @Override
    protected IMappingProvider getMappingProvider(Messager lllllllllllllllllIIIIlIlllllllIl, Filer lllllllllllllllllIIIIlIlllllllII) {
        return new MappingProviderSrg(lllllllllllllllllIIIIlIlllllllIl, lllllllllllllllllIIIIlIlllllllII);
    }
}

