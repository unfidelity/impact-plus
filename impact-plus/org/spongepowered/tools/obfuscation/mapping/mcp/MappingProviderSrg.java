/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 *  com.google.common.collect.BiMap
 *  com.google.common.io.Files
 *  com.google.common.io.LineProcessor
 */
package org.spongepowered.tools.obfuscation.mapping.mcp;

import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.asm.obfuscation.mapping.mcp.MappingFieldSrg;
import org.spongepowered.tools.obfuscation.mapping.common.MappingProvider;

public class MappingProviderSrg
extends MappingProvider {
    public MappingProviderSrg(Messager llllllllllllllllIIIIIIIlIlIIIIII, Filer llllllllllllllllIIIIIIIlIIllllll) {
        super(llllllllllllllllIIIIIIIlIlIIIIII, llllllllllllllllIIIIIIIlIIllllll);
        MappingProviderSrg llllllllllllllllIIIIIIIlIlIIIlII;
    }

    @Override
    public void read(final File llllllllllllllllIIIIIIIlIIllIIIl) throws IOException {
        MappingProviderSrg llllllllllllllllIIIIIIIlIIllIIlI;
        final BiMap llllllllllllllllIIIIIIIlIIllIllI = llllllllllllllllIIIIIIIlIIllIIlI.packageMap;
        final BiMap llllllllllllllllIIIIIIIlIIllIlIl = llllllllllllllllIIIIIIIlIIllIIlI.classMap;
        final BiMap llllllllllllllllIIIIIIIlIIllIlII = llllllllllllllllIIIIIIIlIIllIIlI.fieldMap;
        final BiMap llllllllllllllllIIIIIIIlIIllIIll = llllllllllllllllIIIIIIIlIIllIIlI.methodMap;
        Files.readLines((File)llllllllllllllllIIIIIIIlIIllIIIl, (Charset)Charset.defaultCharset(), (LineProcessor)new LineProcessor<String>(){

            public boolean processLine(String lllllllllllllllllIIlIIlIIlIIlIII) throws IOException {
                1 lllllllllllllllllIIlIIlIIlIIIlII;
                if (Strings.isNullOrEmpty((String)lllllllllllllllllIIlIIlIIlIIlIII) || lllllllllllllllllIIlIIlIIlIIlIII.startsWith("#")) {
                    return true;
                }
                String lllllllllllllllllIIlIIlIIlIIIlll = lllllllllllllllllIIlIIlIIlIIlIII.substring(0, 2);
                String[] lllllllllllllllllIIlIIlIIlIIIllI = lllllllllllllllllIIlIIlIIlIIlIII.substring(4).split(" ");
                if (lllllllllllllllllIIlIIlIIlIIIlll.equals("PK")) {
                    lllllllllllllllllIIlIIlIIlIIIlII.llllllllllllllllIIIIIIIlIIllIllI.forcePut((Object)lllllllllllllllllIIlIIlIIlIIIllI[0], (Object)lllllllllllllllllIIlIIlIIlIIIllI[1]);
                } else if (lllllllllllllllllIIlIIlIIlIIIlll.equals("CL")) {
                    lllllllllllllllllIIlIIlIIlIIIlII.llllllllllllllllIIIIIIIlIIllIlIl.forcePut((Object)lllllllllllllllllIIlIIlIIlIIIllI[0], (Object)lllllllllllllllllIIlIIlIIlIIIllI[1]);
                } else if (lllllllllllllllllIIlIIlIIlIIIlll.equals("FD")) {
                    lllllllllllllllllIIlIIlIIlIIIlII.llllllllllllllllIIIIIIIlIIllIlII.forcePut(new MappingFieldSrg(lllllllllllllllllIIlIIlIIlIIIllI[0]).copy(), new MappingFieldSrg(lllllllllllllllllIIlIIlIIlIIIllI[1]).copy());
                } else if (lllllllllllllllllIIlIIlIIlIIIlll.equals("MD")) {
                    lllllllllllllllllIIlIIlIIlIIIlII.llllllllllllllllIIIIIIIlIIllIIll.forcePut((Object)new MappingMethod(lllllllllllllllllIIlIIlIIlIIIllI[0], lllllllllllllllllIIlIIlIIlIIIllI[1]), (Object)new MappingMethod(lllllllllllllllllIIlIIlIIlIIIllI[2], lllllllllllllllllIIlIIlIIlIIIllI[3]));
                } else {
                    throw new MixinException(String.valueOf(new StringBuilder().append("Invalid SRG file: ").append(lllllllllllllllllIIlIIlIIlIIIlII.llllllllllllllllIIIIIIIlIIllIIIl)));
                }
                return true;
            }
            {
                1 lllllllllllllllllIIlIIlIIllIIlll;
            }

            public String getResult() {
                return null;
            }
        });
    }

    @Override
    public MappingField getFieldMapping(MappingField llllllllllllllllIIIIIIIlIIlIIlll) {
        MappingProviderSrg llllllllllllllllIIIIIIIlIIlIlIII;
        if (llllllllllllllllIIIIIIIlIIlIIlll.getDesc() != null) {
            llllllllllllllllIIIIIIIlIIlIIlll = new MappingFieldSrg(llllllllllllllllIIIIIIIlIIlIIlll);
        }
        return (MappingField)llllllllllllllllIIIIIIIlIIlIlIII.fieldMap.get((Object)llllllllllllllllIIIIIIIlIIlIIlll);
    }
}

