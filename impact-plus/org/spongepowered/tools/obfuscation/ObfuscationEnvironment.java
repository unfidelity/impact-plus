/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.io.File;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.asm.util.ObfuscationUtil;
import org.spongepowered.tools.obfuscation.ObfuscationType;
import org.spongepowered.tools.obfuscation.interfaces.IMixinAnnotationProcessor;
import org.spongepowered.tools.obfuscation.interfaces.IObfuscationEnvironment;
import org.spongepowered.tools.obfuscation.mapping.IMappingConsumer;
import org.spongepowered.tools.obfuscation.mapping.IMappingProvider;
import org.spongepowered.tools.obfuscation.mapping.IMappingWriter;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

public abstract class ObfuscationEnvironment
implements IObfuscationEnvironment {
    protected final /* synthetic */ IMixinAnnotationProcessor ap;
    protected final /* synthetic */ IMappingWriter mappingWriter;
    protected final /* synthetic */ IMappingProvider mappingProvider;
    private /* synthetic */ boolean initDone;
    protected final /* synthetic */ ObfuscationType type;
    protected final /* synthetic */ List<String> inFileNames;
    protected final /* synthetic */ String outFileName;
    protected final /* synthetic */ RemapperProxy remapper;

    @Override
    public MappingField getObfField(MemberInfo llllllllllllllllllIlIlIlIllIIIlI) {
        ObfuscationEnvironment llllllllllllllllllIlIlIlIllIIIIl;
        return llllllllllllllllllIlIlIlIllIIIIl.getObfField(llllllllllllllllllIlIlIlIllIIIlI.asFieldMapping(), true);
    }

    @Override
    public String getObfClass(String llllllllllllllllllIlIlIlIlIIIIlI) {
        ObfuscationEnvironment llllllllllllllllllIlIlIlIlIIIlIl;
        if (!llllllllllllllllllIlIlIlIlIIIlIl.initMappings()) {
            return null;
        }
        return llllllllllllllllllIlIlIlIlIIIlIl.mappingProvider.getClassMapping(llllllllllllllllllIlIlIlIlIIIIlI);
    }

    protected ObfuscationEnvironment(ObfuscationType llllllllllllllllllIlIlIlllIIIllI) {
        ObfuscationEnvironment llllllllllllllllllIlIlIlllIIlIIl;
        llllllllllllllllllIlIlIlllIIlIIl.remapper = llllllllllllllllllIlIlIlllIIlIIl.new RemapperProxy();
        llllllllllllllllllIlIlIlllIIlIIl.type = llllllllllllllllllIlIlIlllIIIllI;
        llllllllllllllllllIlIlIlllIIlIIl.ap = llllllllllllllllllIlIlIlllIIIllI.getAnnotationProcessor();
        llllllllllllllllllIlIlIlllIIlIIl.inFileNames = llllllllllllllllllIlIlIlllIIIllI.getInputFileNames();
        llllllllllllllllllIlIlIlllIIlIIl.outFileName = llllllllllllllllllIlIlIlllIIIllI.getOutputFileName();
        llllllllllllllllllIlIlIlllIIlIIl.mappingProvider = llllllllllllllllllIlIlIlllIIlIIl.getMappingProvider(llllllllllllllllllIlIlIlllIIlIIl.ap, llllllllllllllllllIlIlIlllIIlIIl.ap.getProcessingEnvironment().getFiler());
        llllllllllllllllllIlIlIlllIIlIIl.mappingWriter = llllllllllllllllllIlIlIlllIIlIIl.getMappingWriter(llllllllllllllllllIlIlIlllIIlIIl.ap, llllllllllllllllllIlIlIlllIIlIIl.ap.getProcessingEnvironment().getFiler());
    }

    public String toString() {
        ObfuscationEnvironment llllllllllllllllllIlIlIlllIIIIll;
        return llllllllllllllllllIlIlIlllIIIIll.type.toString();
    }

    @Override
    public String remapDescriptor(String llllllllllllllllllIlIlIlIllIIllI) {
        ObfuscationEnvironment llllllllllllllllllIlIlIlIllIIlll;
        return ObfuscationUtil.mapDescriptor(llllllllllllllllllIlIlIlIllIIllI, llllllllllllllllllIlIlIlIllIIlll.remapper);
    }

    protected abstract IMappingProvider getMappingProvider(Messager var1, Filer var2);

    @Override
    public MappingField getObfField(MappingField llllllllllllllllllIlIlIlIlIIlIll, boolean llllllllllllllllllIlIlIlIlIIlIlI) {
        String llllllllllllllllllIlIlIlIlIIllIl;
        ObfuscationEnvironment llllllllllllllllllIlIlIlIlIIllII;
        if (!llllllllllllllllllIlIlIlIlIIllII.initMappings()) {
            return null;
        }
        MappingField llllllllllllllllllIlIlIlIlIIlllI = llllllllllllllllllIlIlIlIlIIllII.mappingProvider.getFieldMapping(llllllllllllllllllIlIlIlIlIIlIll);
        if (llllllllllllllllllIlIlIlIlIIlllI == null) {
            if (llllllllllllllllllIlIlIlIlIIlIlI) {
                return null;
            }
            llllllllllllllllllIlIlIlIlIIlllI = llllllllllllllllllIlIlIlIlIIlIll;
        }
        if ((llllllllllllllllllIlIlIlIlIIllIl = llllllllllllllllllIlIlIlIlIIllII.getObfClass(llllllllllllllllllIlIlIlIlIIlllI.getOwner())) == null || llllllllllllllllllIlIlIlIlIIllIl.equals(llllllllllllllllllIlIlIlIlIIlIll.getOwner()) || llllllllllllllllllIlIlIlIlIIllIl.equals(llllllllllllllllllIlIlIlIlIIlllI.getOwner())) {
            return llllllllllllllllllIlIlIlIlIIlllI != llllllllllllllllllIlIlIlIlIIlIll ? llllllllllllllllllIlIlIlIlIIlllI : null;
        }
        return llllllllllllllllllIlIlIlIlIIlllI.move(llllllllllllllllllIlIlIlIlIIllIl);
    }

    private boolean initMappings() {
        ObfuscationEnvironment llllllllllllllllllIlIlIllIllIlll;
        if (!llllllllllllllllllIlIlIllIllIlll.initDone) {
            llllllllllllllllllIlIlIllIllIlll.initDone = true;
            if (llllllllllllllllllIlIlIllIllIlll.inFileNames == null) {
                llllllllllllllllllIlIlIllIllIlll.ap.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("The ").append(llllllllllllllllllIlIlIllIllIlll.type.getConfig().getInputFileOption()).append(" argument was not supplied, obfuscation processing will not occur")));
                return false;
            }
            int llllllllllllllllllIlIlIllIlllIIl = 0;
            for (String llllllllllllllllllIlIlIllIlllIlI : llllllllllllllllllIlIlIllIllIlll.inFileNames) {
                File llllllllllllllllllIlIlIllIlllIll = new File(llllllllllllllllllIlIlIllIlllIlI);
                try {
                    if (!llllllllllllllllllIlIlIllIlllIll.isFile()) continue;
                    llllllllllllllllllIlIlIllIllIlll.ap.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append("Loading ").append(llllllllllllllllllIlIlIllIllIlll.type).append(" mappings from ").append(llllllllllllllllllIlIlIllIlllIll.getAbsolutePath())));
                    llllllllllllllllllIlIlIllIllIlll.mappingProvider.read(llllllllllllllllllIlIlIllIlllIll);
                    ++llllllllllllllllllIlIlIllIlllIIl;
                }
                catch (Exception llllllllllllllllllIlIlIllIllllII) {
                    llllllllllllllllllIlIlIllIllllII.printStackTrace();
                }
            }
            if (llllllllllllllllllIlIlIllIlllIIl < 1) {
                llllllllllllllllllIlIlIllIllIlll.ap.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append("No valid input files for ").append(llllllllllllllllllIlIlIllIllIlll.type).append(" could be read, processing may not be sucessful.")));
                llllllllllllllllllIlIlIllIllIlll.mappingProvider.clear();
            }
        }
        return !llllllllllllllllllIlIlIllIllIlll.mappingProvider.isEmpty();
    }

    @Override
    public MappingField getObfField(MappingField llllllllllllllllllIlIlIlIlIllIlI) {
        ObfuscationEnvironment llllllllllllllllllIlIlIlIlIllIll;
        return llllllllllllllllllIlIlIlIlIllIll.getObfField(llllllllllllllllllIlIlIlIlIllIlI, true);
    }

    @Override
    public MemberInfo remapDescriptor(MemberInfo llllllllllllllllllIlIlIlIlllIIlI) {
        String llllllllllllllllllIlIlIlIllllIIl;
        String llllllllllllllllllIlIlIlIlllIlII;
        ObfuscationEnvironment llllllllllllllllllIlIlIlIllllIII;
        String llllllllllllllllllIlIlIlIllllIlI;
        boolean llllllllllllllllllIlIlIlIlllIllI = false;
        String llllllllllllllllllIlIlIlIlllIlIl = llllllllllllllllllIlIlIlIlllIIlI.owner;
        if (llllllllllllllllllIlIlIlIlllIlIl != null && (llllllllllllllllllIlIlIlIllllIlI = llllllllllllllllllIlIlIlIllllIII.remapper.map(llllllllllllllllllIlIlIlIlllIlIl)) != null) {
            llllllllllllllllllIlIlIlIlllIlIl = llllllllllllllllllIlIlIlIllllIlI;
            llllllllllllllllllIlIlIlIlllIllI = true;
        }
        if ((llllllllllllllllllIlIlIlIlllIlII = llllllllllllllllllIlIlIlIlllIIlI.desc) != null && !(llllllllllllllllllIlIlIlIllllIIl = ObfuscationUtil.mapDescriptor(llllllllllllllllllIlIlIlIlllIIlI.desc, llllllllllllllllllIlIlIlIllllIII.remapper)).equals(llllllllllllllllllIlIlIlIlllIIlI.desc)) {
            llllllllllllllllllIlIlIlIlllIlII = llllllllllllllllllIlIlIlIllllIIl;
            llllllllllllllllllIlIlIlIlllIllI = true;
        }
        return llllllllllllllllllIlIlIlIlllIllI ? new MemberInfo(llllllllllllllllllIlIlIlIlllIIlI.name, llllllllllllllllllIlIlIlIlllIlIl, llllllllllllllllllIlIlIlIlllIlII, llllllllllllllllllIlIlIlIlllIIlI.matchAll) : null;
    }

    @Override
    public void writeMappings(Collection<IMappingConsumer> llllllllllllllllllIlIlIlIIlllIIl) {
        ObfuscationEnvironment llllllllllllllllllIlIlIlIIlllIlI;
        IMappingConsumer.MappingSet<MappingField> llllllllllllllllllIlIlIlIIlllIII = new IMappingConsumer.MappingSet<MappingField>();
        IMappingConsumer.MappingSet<MappingMethod> llllllllllllllllllIlIlIlIIllIlll = new IMappingConsumer.MappingSet<MappingMethod>();
        for (IMappingConsumer llllllllllllllllllIlIlIlIIlllIll : llllllllllllllllllIlIlIlIIlllIIl) {
            llllllllllllllllllIlIlIlIIlllIII.addAll(llllllllllllllllllIlIlIlIIlllIll.getFieldMappings(llllllllllllllllllIlIlIlIIlllIlI.type));
            llllllllllllllllllIlIlIlIIllIlll.addAll(llllllllllllllllllIlIlIlIIlllIll.getMethodMappings(llllllllllllllllllIlIlIlIIlllIlI.type));
        }
        llllllllllllllllllIlIlIlIIlllIlI.mappingWriter.write(llllllllllllllllllIlIlIlIIlllIlI.outFileName, llllllllllllllllllIlIlIlIIlllIlI.type, llllllllllllllllllIlIlIlIIlllIII, llllllllllllllllllIlIlIlIIllIlll);
    }

    @Override
    public MappingMethod getObfMethod(MappingMethod llllllllllllllllllIlIlIllIIlIlll) {
        ObfuscationEnvironment llllllllllllllllllIlIlIllIIllIlI;
        return llllllllllllllllllIlIlIllIIllIlI.getObfMethod(llllllllllllllllllIlIlIllIIlIlll, true);
    }

    public ObfuscationType getType() {
        ObfuscationEnvironment llllllllllllllllllIlIlIllIllIIII;
        return llllllllllllllllllIlIlIllIllIIII.type;
    }

    protected abstract IMappingWriter getMappingWriter(Messager var1, Filer var2);

    @Override
    public MappingMethod getObfMethod(MemberInfo llllllllllllllllllIlIlIllIlIIlll) {
        ObfuscationEnvironment llllllllllllllllllIlIlIllIlIIIlI;
        MappingMethod llllllllllllllllllIlIlIllIlIIllI = llllllllllllllllllIlIlIllIlIIIlI.getObfMethod(llllllllllllllllllIlIlIllIlIIlll.asMethodMapping());
        if (llllllllllllllllllIlIlIllIlIIllI != null || !llllllllllllllllllIlIlIllIlIIlll.isFullyQualified()) {
            return llllllllllllllllllIlIlIllIlIIllI;
        }
        TypeHandle llllllllllllllllllIlIlIllIlIIlIl = llllllllllllllllllIlIlIllIlIIIlI.ap.getTypeProvider().getTypeHandle(llllllllllllllllllIlIlIllIlIIlll.owner);
        if (llllllllllllllllllIlIlIllIlIIlIl == null || llllllllllllllllllIlIlIllIlIIlIl.isImaginary()) {
            return null;
        }
        TypeMirror llllllllllllllllllIlIlIllIlIIlII = llllllllllllllllllIlIlIllIlIIlIl.getElement().getSuperclass();
        if (llllllllllllllllllIlIlIllIlIIlII.getKind() != TypeKind.DECLARED) {
            return null;
        }
        String llllllllllllllllllIlIlIllIlIIIll = ((TypeElement)((DeclaredType)llllllllllllllllllIlIlIllIlIIlII).asElement()).getQualifiedName().toString();
        return llllllllllllllllllIlIlIllIlIIIlI.getObfMethod(new MemberInfo(llllllllllllllllllIlIlIllIlIIlll.name, llllllllllllllllllIlIlIllIlIIIll.replace('.', '/'), llllllllllllllllllIlIlIllIlIIlll.desc, llllllllllllllllllIlIlIllIlIIlll.matchAll));
    }

    @Override
    public MappingMethod getObfMethod(MappingMethod llllllllllllllllllIlIlIllIIIlIIl, boolean llllllllllllllllllIlIlIllIIIlIII) {
        ObfuscationEnvironment llllllllllllllllllIlIlIllIIIlIlI;
        if (llllllllllllllllllIlIlIllIIIlIlI.initMappings()) {
            String llllllllllllllllllIlIlIllIIIllII;
            boolean llllllllllllllllllIlIlIllIIIlllI = true;
            Object llllllllllllllllllIlIlIllIIIllIl = null;
            for (MappingMethod llllllllllllllllllIlIlIllIIIllll = llllllllllllllllllIlIlIllIIIlIIl; llllllllllllllllllIlIlIllIIIllll != null && llllllllllllllllllIlIlIllIIIllIl == null; llllllllllllllllllIlIlIllIIIllll = llllllllllllllllllIlIlIllIIIllll.getSuper()) {
                llllllllllllllllllIlIlIllIIIllIl = llllllllllllllllllIlIlIllIIIlIlI.mappingProvider.getMethodMapping(llllllllllllllllllIlIlIllIIIllll);
            }
            if (llllllllllllllllllIlIlIllIIIllIl == null) {
                if (llllllllllllllllllIlIlIllIIIlIII) {
                    return null;
                }
                llllllllllllllllllIlIlIllIIIllIl = llllllllllllllllllIlIlIllIIIlIIl.copy();
                llllllllllllllllllIlIlIllIIIlllI = false;
            }
            if ((llllllllllllllllllIlIlIllIIIllII = llllllllllllllllllIlIlIllIIIlIlI.getObfClass(((MappingMethod)llllllllllllllllllIlIlIllIIIllIl).getOwner())) == null || llllllllllllllllllIlIlIllIIIllII.equals(llllllllllllllllllIlIlIllIIIlIIl.getOwner()) || llllllllllllllllllIlIlIllIIIllII.equals(((MappingMethod)llllllllllllllllllIlIlIllIIIllIl).getOwner())) {
                return llllllllllllllllllIlIlIllIIIlllI ? llllllllllllllllllIlIlIllIIIllIl : null;
            }
            if (llllllllllllllllllIlIlIllIIIlllI) {
                return ((MappingMethod)llllllllllllllllllIlIlIllIIIllIl).move(llllllllllllllllllIlIlIllIIIllII);
            }
            String llllllllllllllllllIlIlIllIIIlIll = ObfuscationUtil.mapDescriptor(((MappingMethod)llllllllllllllllllIlIlIllIIIllIl).getDesc(), llllllllllllllllllIlIlIllIIIlIlI.remapper);
            return new MappingMethod(llllllllllllllllllIlIlIllIIIllII, ((MappingMethod)llllllllllllllllllIlIlIllIIIllIl).getSimpleName(), llllllllllllllllllIlIlIllIIIlIll);
        }
        return null;
    }

    final class RemapperProxy
    implements ObfuscationUtil.IClassRemapper {
        RemapperProxy() {
            RemapperProxy lllllllllllllllllllIllIIIIllIlIl;
        }

        @Override
        public String unmap(String lllllllllllllllllllIllIIIIlIlIII) {
            RemapperProxy lllllllllllllllllllIllIIIIlIIlll;
            if (lllllllllllllllllllIllIIIIlIIlll.ObfuscationEnvironment.this.mappingProvider == null) {
                return null;
            }
            return lllllllllllllllllllIllIIIIlIIlll.ObfuscationEnvironment.this.mappingProvider.getClassMapping(lllllllllllllllllllIllIIIIlIlIII);
        }

        @Override
        public String map(String lllllllllllllllllllIllIIIIlIllII) {
            RemapperProxy lllllllllllllllllllIllIIIIlIllIl;
            if (lllllllllllllllllllIllIIIIlIllIl.ObfuscationEnvironment.this.mappingProvider == null) {
                return null;
            }
            return lllllllllllllllllllIllIIIIlIllIl.ObfuscationEnvironment.this.mappingProvider.getClassMapping(lllllllllllllllllllIllIIIIlIllII);
        }
    }
}

