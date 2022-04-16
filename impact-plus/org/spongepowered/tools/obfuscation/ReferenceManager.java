/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.lang.model.element.Element;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.mixin.refmap.ReferenceMapper;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationData;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IReferenceManager;

public class ReferenceManager
implements IReferenceManager {
    private /* synthetic */ boolean allowConflicts;
    private final /* synthetic */ String outRefMapFileName;
    private final /* synthetic */ ReferenceMapper refMapper;
    private final /* synthetic */ IMixinAnnotationProcessor ap;
    private final /* synthetic */ List<ObfuscationEnvironment> environments;

    protected void addMapping(ObfuscationType lllllllllllllllllIIlIllIIIIlIlll, String lllllllllllllllllIIlIllIIIIlIIII, String lllllllllllllllllIIlIllIIIIIllll, String lllllllllllllllllIIlIllIIIIIlllI) {
        ReferenceManager lllllllllllllllllIIlIllIIIIlIIlI;
        String lllllllllllllllllIIlIllIIIIlIIll = lllllllllllllllllIIlIllIIIIlIIlI.refMapper.addMapping(lllllllllllllllllIIlIllIIIIlIlll.getKey(), lllllllllllllllllIIlIllIIIIlIIII, lllllllllllllllllIIlIllIIIIIllll, lllllllllllllllllIIlIllIIIIIlllI);
        if (lllllllllllllllllIIlIllIIIIlIlll.isDefault()) {
            lllllllllllllllllIIlIllIIIIlIIlI.refMapper.addMapping(null, lllllllllllllllllIIlIllIIIIlIIII, lllllllllllllllllIIlIllIIIIIllll, lllllllllllllllllIIlIllIIIIIlllI);
        }
        if (!lllllllllllllllllIIlIllIIIIlIIlI.allowConflicts && lllllllllllllllllIIlIllIIIIlIIll != null && !lllllllllllllllllIIlIllIIIIlIIll.equals(lllllllllllllllllIIlIllIIIIIlllI)) {
            throw new ReferenceConflictException(lllllllllllllllllIIlIllIIIIlIIll, lllllllllllllllllIIlIllIIIIIlllI);
        }
    }

    @Override
    public void addMethodMapping(String lllllllllllllllllIIlIllIIlllIIIl, String lllllllllllllllllIIlIllIIlllIIII, ObfuscationData<MappingMethod> lllllllllllllllllIIlIllIIllIllll) {
        ReferenceManager lllllllllllllllllIIlIllIIllIlllI;
        for (ObfuscationEnvironment lllllllllllllllllIIlIllIIlllIIll : lllllllllllllllllIIlIllIIllIlllI.environments) {
            MappingMethod lllllllllllllllllIIlIllIIlllIlII = lllllllllllllllllIIlIllIIllIllll.get(lllllllllllllllllIIlIllIIlllIIll.getType());
            if (lllllllllllllllllIIlIllIIlllIlII == null) continue;
            MemberInfo lllllllllllllllllIIlIllIIlllIlIl = new MemberInfo(lllllllllllllllllIIlIllIIlllIlII);
            lllllllllllllllllIIlIllIIllIlllI.addMapping(lllllllllllllllllIIlIllIIlllIIll.getType(), lllllllllllllllllIIlIllIIlllIIIl, lllllllllllllllllIIlIllIIlllIIII, lllllllllllllllllIIlIllIIlllIlIl.toString());
        }
    }

    @Override
    public void write() {
        ReferenceManager lllllllllllllllllIIlIllIlIIlIlII;
        if (lllllllllllllllllIIlIllIlIIlIlII.outRefMapFileName == null) {
            return;
        }
        PrintWriter lllllllllllllllllIIlIllIlIIlIIll = null;
        try {
            lllllllllllllllllIIlIllIlIIlIIll = lllllllllllllllllIIlIllIlIIlIlII.newWriter(lllllllllllllllllIIlIllIlIIlIlII.outRefMapFileName, "refmap");
            lllllllllllllllllIIlIllIlIIlIlII.refMapper.write(lllllllllllllllllIIlIllIlIIlIIll);
        }
        catch (IOException lllllllllllllllllIIlIllIlIIlIlIl) {
            lllllllllllllllllIIlIllIlIIlIlIl.printStackTrace();
        }
        finally {
            if (lllllllllllllllllIIlIllIlIIlIIll != null) {
                try {
                    lllllllllllllllllIIlIllIlIIlIIll.close();
                }
                catch (Exception exception) {}
            }
        }
    }

    @Override
    public ReferenceMapper getMapper() {
        ReferenceManager lllllllllllllllllIIlIllIIlllllll;
        return lllllllllllllllllIIlIllIIlllllll.refMapper;
    }

    @Override
    public boolean getAllowConflicts() {
        ReferenceManager lllllllllllllllllIIlIllIlIlIIIlI;
        return lllllllllllllllllIIlIllIlIlIIIlI.allowConflicts;
    }

    public ReferenceManager(IMixinAnnotationProcessor lllllllllllllllllIIlIllIlIlIlIII, List<ObfuscationEnvironment> lllllllllllllllllIIlIllIlIlIIlII) {
        ReferenceManager lllllllllllllllllIIlIllIlIlIlIIl;
        lllllllllllllllllIIlIllIlIlIlIIl.refMapper = new ReferenceMapper();
        lllllllllllllllllIIlIllIlIlIlIIl.ap = lllllllllllllllllIIlIllIlIlIlIII;
        lllllllllllllllllIIlIllIlIlIlIIl.environments = lllllllllllllllllIIlIllIlIlIIlII;
        lllllllllllllllllIIlIllIlIlIlIIl.outRefMapFileName = lllllllllllllllllIIlIllIlIlIlIIl.ap.getOption("outRefMapFile");
    }

    @Override
    public void addClassMapping(String lllllllllllllllllIIlIllIIIlIIlII, String lllllllllllllllllIIlIllIIIlIIlll, ObfuscationData<String> lllllllllllllllllIIlIllIIIlIIllI) {
        ReferenceManager lllllllllllllllllIIlIllIIIlIlIIl;
        for (ObfuscationEnvironment lllllllllllllllllIIlIllIIIlIlIlI : lllllllllllllllllIIlIllIIIlIlIIl.environments) {
            String lllllllllllllllllIIlIllIIIlIlIll = lllllllllllllllllIIlIllIIIlIIllI.get(lllllllllllllllllIIlIllIIIlIlIlI.getType());
            if (lllllllllllllllllIIlIllIIIlIlIll == null) continue;
            lllllllllllllllllIIlIllIIIlIlIIl.addMapping(lllllllllllllllllIIlIllIIIlIlIlI.getType(), lllllllllllllllllIIlIllIIIlIIlII, lllllllllllllllllIIlIllIIIlIIlll, lllllllllllllllllIIlIllIIIlIlIll);
        }
    }

    @Override
    public void addMethodMapping(String lllllllllllllllllIIlIllIIlIlIlII, String lllllllllllllllllIIlIllIIlIllIII, MemberInfo lllllllllllllllllIIlIllIIlIlIlll, ObfuscationData<MappingMethod> lllllllllllllllllIIlIllIIlIlIllI) {
        ReferenceManager lllllllllllllllllIIlIllIIlIlIlIl;
        for (ObfuscationEnvironment lllllllllllllllllIIlIllIIlIllIll : lllllllllllllllllIIlIllIIlIlIlIl.environments) {
            MappingMethod lllllllllllllllllIIlIllIIlIlllII = lllllllllllllllllIIlIllIIlIlIllI.get(lllllllllllllllllIIlIllIIlIllIll.getType());
            if (lllllllllllllllllIIlIllIIlIlllII == null) continue;
            MemberInfo lllllllllllllllllIIlIllIIlIlllIl = lllllllllllllllllIIlIllIIlIlIlll.remapUsing(lllllllllllllllllIIlIllIIlIlllII, true);
            lllllllllllllllllIIlIllIIlIlIlIl.addMapping(lllllllllllllllllIIlIllIIlIllIll.getType(), lllllllllllllllllIIlIllIIlIlIlII, lllllllllllllllllIIlIllIIlIllIII, lllllllllllllllllIIlIllIIlIlllIl.toString());
        }
    }

    @Override
    public void setAllowConflicts(boolean lllllllllllllllllIIlIllIlIIllIll) {
        lllllllllllllllllIIlIllIlIIllllI.allowConflicts = lllllllllllllllllIIlIllIlIIllIll;
    }

    @Override
    public void addFieldMapping(String lllllllllllllllllIIlIllIIIllllll, String lllllllllllllllllIIlIllIIIlllIIl, MemberInfo lllllllllllllllllIIlIllIIIlllIII, ObfuscationData<MappingField> lllllllllllllllllIIlIllIIIllllII) {
        ReferenceManager lllllllllllllllllIIlIllIIIlllIll;
        for (ObfuscationEnvironment lllllllllllllllllIIlIllIIlIIIIIl : lllllllllllllllllIIlIllIIIlllIll.environments) {
            MappingField lllllllllllllllllIIlIllIIlIIIIlI = lllllllllllllllllIIlIllIIIllllII.get(lllllllllllllllllIIlIllIIlIIIIIl.getType());
            if (lllllllllllllllllIIlIllIIlIIIIlI == null) continue;
            MemberInfo lllllllllllllllllIIlIllIIlIIIIll = MemberInfo.fromMapping(lllllllllllllllllIIlIllIIlIIIIlI.transform(lllllllllllllllllIIlIllIIlIIIIIl.remapDescriptor(lllllllllllllllllIIlIllIIIlllIII.desc)));
            lllllllllllllllllIIlIllIIIlllIll.addMapping(lllllllllllllllllIIlIllIIlIIIIIl.getType(), lllllllllllllllllIIlIllIIIllllll, lllllllllllllllllIIlIllIIIlllIIl, lllllllllllllllllIIlIllIIlIIIIll.toString());
        }
    }

    private PrintWriter newWriter(String lllllllllllllllllIIlIllIlIIIIIll, String lllllllllllllllllIIlIllIlIIIIllI) throws IOException {
        ReferenceManager lllllllllllllllllIIlIllIlIIIlIII;
        if (lllllllllllllllllIIlIllIlIIIIIll.matches("^.*[\\\\/:].*$")) {
            File lllllllllllllllllIIlIllIlIIIlIIl = new File(lllllllllllllllllIIlIllIlIIIIIll);
            lllllllllllllllllIIlIllIlIIIlIIl.getParentFile().mkdirs();
            lllllllllllllllllIIlIllIlIIIlIII.ap.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append("Writing ").append(lllllllllllllllllIIlIllIlIIIIllI).append(" to ").append(lllllllllllllllllIIlIllIlIIIlIIl.getAbsolutePath())));
            return new PrintWriter(lllllllllllllllllIIlIllIlIIIlIIl);
        }
        FileObject lllllllllllllllllIIlIllIlIIIIlIl = lllllllllllllllllIIlIllIlIIIlIII.ap.getProcessingEnvironment().getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", lllllllllllllllllIIlIllIlIIIIIll, new Element[0]);
        lllllllllllllllllIIlIllIlIIIlIII.ap.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append("Writing ").append(lllllllllllllllllIIlIllIlIIIIllI).append(" to ").append(new File(lllllllllllllllllIIlIllIlIIIIlIl.toUri()).getAbsolutePath())));
        return new PrintWriter(lllllllllllllllllIIlIllIlIIIIlIl.openWriter());
    }

    public static class ReferenceConflictException
    extends RuntimeException {
        private final /* synthetic */ String newReference;
        private static final /* synthetic */ long serialVersionUID = 1L;
        private final /* synthetic */ String oldReference;

        public ReferenceConflictException(String llllllllllllllllIIllIIllllIIllll, String llllllllllllllllIIllIIllllIIlllI) {
            ReferenceConflictException llllllllllllllllIIllIIllllIlIIII;
            llllllllllllllllIIllIIllllIlIIII.oldReference = llllllllllllllllIIllIIllllIIllll;
            llllllllllllllllIIllIIllllIlIIII.newReference = llllllllllllllllIIllIIllllIIlllI;
        }

        public String getOld() {
            ReferenceConflictException llllllllllllllllIIllIIllllIIllII;
            return llllllllllllllllIIllIIllllIIllII.oldReference;
        }

        public String getNew() {
            ReferenceConflictException llllllllllllllllIIllIIllllIIlIII;
            return llllllllllllllllIIllIIllllIIlIII.newReference;
        }
    }
}

