/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.mapping.mcp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.mapping.common.MappingWriter;

public class MappingWriterSrg
extends MappingWriter {
    public MappingWriterSrg(Messager lllIlIlllIIllII, Filer lllIlIlllIIlIll) {
        super(lllIlIlllIIllII, lllIlIlllIIlIll);
        MappingWriterSrg lllIlIlllIIllIl;
    }

    protected String formatMethodMapping(IMappingConsumer.MappingSet.Pair<MappingMethod> lllIlIllIIIlllI) {
        return String.format("MD: %s %s %s %s", ((MappingMethod)lllIlIllIIIlllI.from).getName(), ((MappingMethod)lllIlIllIIIlllI.from).getDesc(), ((MappingMethod)lllIlIllIIIlllI.to).getName(), ((MappingMethod)lllIlIllIIIlllI.to).getDesc());
    }

    protected String formatFieldMapping(IMappingConsumer.MappingSet.Pair<MappingField> lllIlIllIIlIIlI) {
        return String.format("FD: %s/%s %s/%s", ((MappingField)lllIlIllIIlIIlI.from).getOwner(), ((MappingField)lllIlIllIIlIIlI.from).getName(), ((MappingField)lllIlIllIIlIIlI.to).getOwner(), ((MappingField)lllIlIllIIlIIlI.to).getName());
    }

    protected void writeFieldMappings(PrintWriter lllIlIllIlIIlll, IMappingConsumer.MappingSet<MappingField> lllIlIllIlIIllI) {
        for (IMappingConsumer.MappingSet.Pair pair : lllIlIllIlIIllI) {
            MappingWriterSrg lllIlIllIlIlIll;
            lllIlIllIlIIlll.println(lllIlIllIlIlIll.formatFieldMapping(pair));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(String lllIlIllIllllll, ObfuscationType lllIlIllIlllllI, IMappingConsumer.MappingSet<MappingField> lllIlIllIllllIl, IMappingConsumer.MappingSet<MappingMethod> lllIlIllIllIllI) {
        if (lllIlIllIllllll == null) {
            return;
        }
        PrintWriter lllIlIllIlllIll = null;
        try {
            MappingWriterSrg lllIlIlllIIIIII;
            lllIlIllIlllIll = lllIlIlllIIIIII.openFileWriter(lllIlIllIllllll, String.valueOf(new StringBuilder().append(lllIlIllIlllllI).append(" output SRGs")));
            lllIlIlllIIIIII.writeFieldMappings(lllIlIllIlllIll, lllIlIllIllllIl);
            lllIlIlllIIIIII.writeMethodMappings(lllIlIllIlllIll, lllIlIllIllIllI);
        }
        catch (IOException lllIlIlllIIIIIl) {
            lllIlIlllIIIIIl.printStackTrace();
        }
        finally {
            if (lllIlIllIlllIll != null) {
                try {
                    lllIlIllIlllIll.close();
                }
                catch (Exception exception) {}
            }
        }
    }

    protected void writeMethodMappings(PrintWriter lllIlIllIIlllII, IMappingConsumer.MappingSet<MappingMethod> lllIlIllIIllIII) {
        for (IMappingConsumer.MappingSet.Pair pair : lllIlIllIIllIII) {
            MappingWriterSrg lllIlIllIIlllIl;
            lllIlIllIIlllII.println(lllIlIllIIlllIl.formatMethodMapping(pair));
        }
    }
}

