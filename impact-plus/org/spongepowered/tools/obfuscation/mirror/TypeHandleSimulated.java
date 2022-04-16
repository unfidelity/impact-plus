/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.mirror;

import java.lang.annotation.Annotation;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.asm.util.SignaturePrinter;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.FieldHandle;
import org.spongepowered.tools.obfuscation.mirror.MethodHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;

public class TypeHandleSimulated
extends TypeHandle {
    private final /* synthetic */ TypeElement simulatedType;

    public TypeHandleSimulated(String lllllllllllllllllIIllIIlIlIllIIl, TypeMirror lllllllllllllllllIIllIIlIlIllIII) {
        lllllllllllllllllIIllIIlIlIllIlI(TypeUtils.getPackage(lllllllllllllllllIIllIIlIlIllIII), lllllllllllllllllIIllIIlIlIllIIl, lllllllllllllllllIIllIIlIlIllIII);
        TypeHandleSimulated lllllllllllllllllIIllIIlIlIllIlI;
    }

    private static MethodHandle findMethodRecursive(TypeHandle lllllllllllllllllIIllIIlIIIIlIlI, String lllllllllllllllllIIllIIlIIIlIIIl, String lllllllllllllllllIIllIIlIIIIlIII, String lllllllllllllllllIIllIIlIIIIllll, boolean lllllllllllllllllIIllIIlIIIIIllI) {
        TypeElement lllllllllllllllllIIllIIlIIIIllIl = lllllllllllllllllIIllIIlIIIIlIlI.getTargetElement();
        if (lllllllllllllllllIIllIIlIIIIllIl == null) {
            return null;
        }
        MethodHandle lllllllllllllllllIIllIIlIIIIllII = TypeHandle.findMethod(lllllllllllllllllIIllIIlIIIIlIlI, lllllllllllllllllIIllIIlIIIlIIIl, lllllllllllllllllIIllIIlIIIIlIII, lllllllllllllllllIIllIIlIIIIllll, lllllllllllllllllIIllIIlIIIIIllI);
        if (lllllllllllllllllIIllIIlIIIIllII != null) {
            return lllllllllllllllllIIllIIlIIIIllII;
        }
        for (TypeMirror typeMirror : lllllllllllllllllIIllIIlIIIIllIl.getInterfaces()) {
            lllllllllllllllllIIllIIlIIIIllII = TypeHandleSimulated.findMethodRecursive(typeMirror, lllllllllllllllllIIllIIlIIIlIIIl, lllllllllllllllllIIllIIlIIIIlIII, lllllllllllllllllIIllIIlIIIIllll, lllllllllllllllllIIllIIlIIIIIllI);
            if (lllllllllllllllllIIllIIlIIIIllII == null) continue;
            return lllllllllllllllllIIllIIlIIIIllII;
        }
        TypeMirror lllllllllllllllllIIllIIlIIIIlIll = lllllllllllllllllIIllIIlIIIIllIl.getSuperclass();
        if (lllllllllllllllllIIllIIlIIIIlIll == null || lllllllllllllllllIIllIIlIIIIlIll.getKind() == TypeKind.NONE) {
            return null;
        }
        return TypeHandleSimulated.findMethodRecursive(lllllllllllllllllIIllIIlIIIIlIll, lllllllllllllllllIIllIIlIIIlIIIl, lllllllllllllllllIIllIIlIIIIlIII, lllllllllllllllllIIllIIlIIIIllll, lllllllllllllllllIIllIIlIIIIIllI);
    }

    @Override
    public String findDescriptor(MemberInfo lllllllllllllllllIIllIIlIIllllll) {
        return lllllllllllllllllIIllIIlIIllllll != null ? lllllllllllllllllIIllIIlIIllllll.desc : null;
    }

    @Override
    public boolean isPublic() {
        return true;
    }

    public TypeHandleSimulated(PackageElement lllllllllllllllllIIllIIlIlIIlllI, String lllllllllllllllllIIllIIlIlIIllIl, TypeMirror lllllllllllllllllIIllIIlIlIIllII) {
        super(lllllllllllllllllIIllIIlIlIIlllI, lllllllllllllllllIIllIIlIlIIllIl);
        TypeHandleSimulated lllllllllllllllllIIllIIlIlIIllll;
        lllllllllllllllllIIllIIlIlIIllll.simulatedType = (TypeElement)((DeclaredType)lllllllllllllllllIIllIIlIlIIllII).asElement();
    }

    @Override
    protected TypeElement getTargetElement() {
        TypeHandleSimulated lllllllllllllllllIIllIIlIlIIlIIl;
        return lllllllllllllllllIIllIIlIlIIlIIl.simulatedType;
    }

    @Override
    public FieldHandle findField(String lllllllllllllllllIIllIIlIIlllIII, String lllllllllllllllllIIllIIlIIllIlll, boolean lllllllllllllllllIIllIIlIIlllIIl) {
        return new FieldHandle(null, lllllllllllllllllIIllIIlIIlllIII, lllllllllllllllllIIllIIlIIllIlll);
    }

    @Override
    public MethodHandle findMethod(String lllllllllllllllllIIllIIlIIllIIII, String lllllllllllllllllIIllIIlIIllIIlI, boolean lllllllllllllllllIIllIIlIIllIIIl) {
        return new MethodHandle(null, lllllllllllllllllIIllIIlIIllIIII, lllllllllllllllllIIllIIlIIllIIlI);
    }

    @Override
    public boolean isSimulated() {
        return true;
    }

    @Override
    public TypeHandle getSuperclass() {
        return null;
    }

    @Override
    public MappingMethod getMappingMethod(String lllllllllllllllllIIllIIlIIlIIIIl, String lllllllllllllllllIIllIIlIIlIIIII) {
        String lllllllllllllllllIIllIIlIIlIIlII;
        TypeHandleSimulated lllllllllllllllllIIllIIlIIlIlIII;
        String lllllllllllllllllIIllIIlIIlIIlIl = new SignaturePrinter(lllllllllllllllllIIllIIlIIlIIIIl, lllllllllllllllllIIllIIlIIlIIIII).setFullyQualified(true).toDescriptor();
        MethodHandle lllllllllllllllllIIllIIlIIlIIIll = TypeHandleSimulated.findMethodRecursive(lllllllllllllllllIIllIIlIIlIlIII, lllllllllllllllllIIllIIlIIlIIIIl, lllllllllllllllllIIllIIlIIlIIlIl, lllllllllllllllllIIllIIlIIlIIlII = TypeUtils.stripGenerics(lllllllllllllllllIIllIIlIIlIIlIl), true);
        return lllllllllllllllllIIllIIlIIlIIIll != null ? lllllllllllllllllIIllIIlIIlIIIll.asMapping(true) : super.getMappingMethod(lllllllllllllllllIIllIIlIIlIIIIl, lllllllllllllllllIIllIIlIIlIIIII);
    }

    @Override
    public AnnotationHandle getAnnotation(Class<? extends Annotation> lllllllllllllllllIIllIIlIlIIIlII) {
        return null;
    }

    private static MethodHandle findMethodRecursive(TypeMirror lllllllllllllllllIIllIIIllllIlIl, String lllllllllllllllllIIllIIIllllIlII, String lllllllllllllllllIIllIIIlllllIIl, String lllllllllllllllllIIllIIIlllllIII, boolean lllllllllllllllllIIllIIIllllIlll) {
        if (!(lllllllllllllllllIIllIIIllllIlIl instanceof DeclaredType)) {
            return null;
        }
        TypeElement lllllllllllllllllIIllIIIllllIllI = (TypeElement)((DeclaredType)lllllllllllllllllIIllIIIllllIlIl).asElement();
        return TypeHandleSimulated.findMethodRecursive(new TypeHandle(lllllllllllllllllIIllIIIllllIllI), lllllllllllllllllIIllIIIllllIlII, lllllllllllllllllIIllIIIlllllIIl, lllllllllllllllllIIllIIIlllllIII, lllllllllllllllllIIllIIIllllIlll);
    }

    @Override
    public boolean isImaginary() {
        return false;
    }
}

