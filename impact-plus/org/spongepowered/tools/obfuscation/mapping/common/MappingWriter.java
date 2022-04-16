/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.mapping.common;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import org.spongepowered.tools.obfuscation.mapping.IMappingWriter;

public abstract class MappingWriter
implements IMappingWriter {
    private final /* synthetic */ Messager messager;
    private final /* synthetic */ Filer filer;

    protected PrintWriter openFileWriter(String llllllllllllllllIlIllIllIlllIlII, String llllllllllllllllIlIllIllIlllIlll) throws IOException {
        MappingWriter llllllllllllllllIlIllIllIllllIIl;
        if (llllllllllllllllIlIllIllIlllIlII.matches("^.*[\\\\/:].*$")) {
            File llllllllllllllllIlIllIllIllllIlI = new File(llllllllllllllllIlIllIllIlllIlII);
            llllllllllllllllIlIllIllIllllIlI.getParentFile().mkdirs();
            llllllllllllllllIlIllIllIllllIIl.messager.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append("Writing ").append(llllllllllllllllIlIllIllIlllIlll).append(" to ").append(llllllllllllllllIlIllIllIllllIlI.getAbsolutePath())));
            return new PrintWriter(llllllllllllllllIlIllIllIllllIlI);
        }
        FileObject llllllllllllllllIlIllIllIlllIllI = llllllllllllllllIlIllIllIllllIIl.filer.createResource(StandardLocation.CLASS_OUTPUT, "", llllllllllllllllIlIllIllIlllIlII, new Element[0]);
        llllllllllllllllIlIllIllIllllIIl.messager.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append("Writing ").append(llllllllllllllllIlIllIllIlllIlll).append(" to ").append(new File(llllllllllllllllIlIllIllIlllIllI.toUri()).getAbsolutePath())));
        return new PrintWriter(llllllllllllllllIlIllIllIlllIllI.openWriter());
    }

    public MappingWriter(Messager llllllllllllllllIlIllIlllIIIIIII, Filer llllllllllllllllIlIllIlllIIIIIlI) {
        MappingWriter llllllllllllllllIlIllIlllIIIIIIl;
        llllllllllllllllIlIllIlllIIIIIIl.messager = llllllllllllllllIlIllIlllIIIIIII;
        llllllllllllllllIlIllIlllIIIIIIl.filer = llllllllllllllllIlIllIlllIIIIIlI;
    }
}

