/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 */
package org.spongepowered.tools.obfuscation.mirror;

import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mirror.AnnotationHandle;
import org.spongepowered.tools.obfuscation.mirror.FieldHandle;
import org.spongepowered.tools.obfuscation.mirror.MethodHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeReference;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;
import org.spongepowered.tools.obfuscation.mirror.mapping.ResolvableMappingMethod;

public class TypeHandle {
    private /* synthetic */ TypeReference reference;
    private final /* synthetic */ TypeElement element;
    private final /* synthetic */ String name;
    private final /* synthetic */ PackageElement pkg;

    public final MethodHandle findMethod(String lllllllllllll, String llllllllllllI) {
        TypeHandle lIIIIIIIIIIIII;
        return lIIIIIIIIIIIII.findMethod(lllllllllllll, llllllllllllI, true);
    }

    public <T extends Element> List<T> getEnclosedElements(ElementKind ... lIIIIIlIIIlIIl) {
        TypeHandle lIIIIIlIIIlIlI;
        return TypeHandle.getEnclosedElements(lIIIIIlIIIlIlI.getTargetElement(), lIIIIIlIIIlIIl);
    }

    public final TypeElement getElement() {
        TypeHandle lIIIIIlIlIlIIl;
        return lIIIIIlIlIlIIl.element;
    }

    public List<TypeHandle> getInterfaces() {
        TypeHandle lIIIIIIllIIIll;
        if (lIIIIIIllIIIll.getTargetElement() == null) {
            return Collections.emptyList();
        }
        ImmutableList.Builder lIIIIIIllIIlII = ImmutableList.builder();
        for (TypeMirror typeMirror : lIIIIIIllIIIll.getTargetElement().getInterfaces()) {
            lIIIIIIllIIlII.add((Object)new TypeHandle((DeclaredType)typeMirror));
        }
        return lIIIIIIllIIlII.build();
    }

    public final List<? extends Element> getEnclosedElements() {
        TypeHandle lIIIIIlIIIllll;
        return TypeHandle.getEnclosedElements(lIIIIIlIIIllll.getTargetElement());
    }

    public boolean isPublic() {
        TypeHandle lIIIIIIlIllllI;
        return lIIIIIIlIllllI.getTargetElement() != null && lIIIIIIlIllllI.getTargetElement().getModifiers().contains((Object)Modifier.PUBLIC);
    }

    public AnnotationHandle getAnnotation(Class<? extends Annotation> lIIIIIlIIlIIIl) {
        TypeHandle lIIIIIlIIlIIlI;
        return AnnotationHandle.of(lIIIIIlIIlIIlI.getTargetElement(), lIIIIIlIIlIIIl);
    }

    public MappingMethod getMappingMethod(String lIIIIIIlIIlllI, String lIIIIIIlIIllIl) {
        TypeHandle lIIIIIIlIIllll;
        return new ResolvableMappingMethod(lIIIIIIlIIllll, lIIIIIIlIIlllI, lIIIIIIlIIllIl);
    }

    public TypeHandle(DeclaredType lIIIIIlIlllllI) {
        lIIIIIllIIIIIl((TypeElement)lIIIIIlIlllllI.asElement());
        TypeHandle lIIIIIllIIIIIl;
    }

    public final MethodHandle findMethod(ExecutableElement lIIIIIIIIIllll) {
        TypeHandle lIIIIIIIIIlllI;
        return lIIIIIIIIIlllI.findMethod(lIIIIIIIIIllll, true);
    }

    public final PackageElement getPackage() {
        TypeHandle lIIIIIlIlIllll;
        return lIIIIIlIlIllll.pkg;
    }

    public String findDescriptor(MemberInfo lIIIIIIlIIIIlI) {
        String lIIIIIIlIIIlII = lIIIIIIlIIIIlI.desc;
        if (lIIIIIIlIIIlII == null) {
            TypeHandle lIIIIIIlIIIllI;
            for (ExecutableElement lIIIIIIlIIIlll : lIIIIIIlIIIllI.getEnclosedElements(ElementKind.METHOD)) {
                if (!lIIIIIIlIIIlll.getSimpleName().toString().equals(lIIIIIIlIIIIlI.name)) continue;
                lIIIIIIlIIIlII = TypeUtils.getDescriptor(lIIIIIIlIIIlll);
                break;
            }
        }
        return lIIIIIIlIIIlII;
    }

    public FieldHandle findField(String lIIIIIIIIllIII, String lIIIIIIIIlllII, boolean lIIIIIIIIlIllI) {
        TypeHandle lIIIIIIIIllllI;
        String lIIIIIIIIllIlI = TypeUtils.stripGenerics(lIIIIIIIIlllII);
        for (VariableElement lIIIIIIIIlllll : lIIIIIIIIllllI.getEnclosedElements(ElementKind.FIELD)) {
            if (TypeHandle.compareElement(lIIIIIIIIlllll, lIIIIIIIIllIII, lIIIIIIIIlllII, lIIIIIIIIlIllI)) {
                return new FieldHandle(lIIIIIIIIllllI.getTargetElement(), lIIIIIIIIlllll);
            }
            if (!TypeHandle.compareElement(lIIIIIIIIlllll, lIIIIIIIIllIII, lIIIIIIIIllIlI, lIIIIIIIIlIllI)) continue;
            return new FieldHandle(lIIIIIIIIllllI.getTargetElement(), lIIIIIIIIlllll, true);
        }
        return null;
    }

    protected static List<? extends Element> getEnclosedElements(TypeElement llllllIlIIllI) {
        return llllllIlIIllI != null ? llllllIlIIllI.getEnclosedElements() : Collections.emptyList();
    }

    public TypeMirror getType() {
        TypeHandle lIIIIIIlllllII;
        return lIIIIIIlllllII.getTargetElement() != null ? lIIIIIIlllllII.getTargetElement().asType() : null;
    }

    public final String getName() {
        TypeHandle lIIIIIlIlllIIl;
        return lIIIIIlIlllIIl.name;
    }

    public TypeHandle(TypeElement lIIIIIllIIIlll) {
        TypeHandle lIIIIIllIIlIIl;
        lIIIIIllIIlIIl.pkg = TypeUtils.getPackage(lIIIIIllIIIlll);
        lIIIIIllIIlIIl.name = TypeUtils.getInternalName(lIIIIIllIIIlll);
        lIIIIIllIIlIIl.element = lIIIIIllIIIlll;
    }

    public final FieldHandle findField(String lIIIIIIIlIlIII, String lIIIIIIIlIIlll) {
        TypeHandle lIIIIIIIlIllII;
        return lIIIIIIIlIllII.findField(lIIIIIIIlIlIII, lIIIIIIIlIIlll, true);
    }

    protected static boolean compareElement(Element lllllllIIIllI, String lllllllIIIlIl, String lllllllIIIlII, boolean lllllllIIIlll) {
        try {
            String lllllllIIllll = lllllllIIIllI.getSimpleName().toString();
            String lllllllIIlllI = TypeUtils.getJavaSignature(lllllllIIIllI);
            String lllllllIIllIl = TypeUtils.stripGenerics(lllllllIIlllI);
            boolean lllllllIIllII = lllllllIIIlll ? lllllllIIIlIl.equals(lllllllIIllll) : lllllllIIIlIl.equalsIgnoreCase(lllllllIIllll);
            return lllllllIIllII && (lllllllIIIlII.length() == 0 || lllllllIIIlII.equals(lllllllIIlllI) || lllllllIIIlII.equals(lllllllIIllIl));
        }
        catch (NullPointerException lllllllIIlIll) {
            return false;
        }
    }

    protected TypeElement getTargetElement() {
        TypeHandle lIIIIIlIIllIll;
        return lIIIIIlIIllIll.element;
    }

    public boolean isSimulated() {
        return false;
    }

    public final FieldHandle findField(VariableElement lIIIIIIIlllIIl) {
        TypeHandle lIIIIIIIllllII;
        return lIIIIIIIllllII.findField(lIIIIIIIlllIIl, true);
    }

    public TypeHandle(PackageElement lIIIIIllIllIII, String lIIIIIllIllIlI) {
        TypeHandle lIIIIIllIlllII;
        lIIIIIllIlllII.name = lIIIIIllIllIlI.replace('.', '/');
        lIIIIIllIlllII.pkg = lIIIIIllIllIII;
        lIIIIIllIlllII.element = null;
    }

    public TypeHandle getSuperclass() {
        TypeHandle lIIIIIIlllIIll;
        TypeElement lIIIIIIlllIIlI = lIIIIIIlllIIll.getTargetElement();
        if (lIIIIIIlllIIlI == null) {
            return null;
        }
        TypeMirror lIIIIIIlllIIII = lIIIIIIlllIIlI.getSuperclass();
        if (lIIIIIIlllIIII == null || lIIIIIIlllIIII.getKind() == TypeKind.NONE) {
            return null;
        }
        return new TypeHandle((DeclaredType)lIIIIIIlllIIII);
    }

    public final MethodHandle findMethod(ExecutableElement lIIIIIIIIIlIII, boolean lIIIIIIIIIIlll) {
        TypeHandle lIIIIIIIIIIllI;
        return lIIIIIIIIIIllI.findMethod(lIIIIIIIIIlIII.getSimpleName().toString(), TypeUtils.getJavaSignature(lIIIIIIIIIlIII), lIIIIIIIIIIlll);
    }

    public final String toString() {
        TypeHandle lIIIIIlIlllIll;
        return lIIIIIlIlllIll.name.replace('/', '.');
    }

    public boolean isImaginary() {
        TypeHandle lIIIIIIlIllIll;
        return lIIIIIIlIllIll.getTargetElement() == null;
    }

    public MethodHandle findMethod(String lllllllllIlII, String llllllllIlllI, boolean llllllllIllIl) {
        TypeHandle lllllllllIIII;
        String lllllllllIIIl = TypeUtils.stripGenerics(llllllllIlllI);
        return TypeHandle.findMethod(lllllllllIIII, lllllllllIlII, llllllllIlllI, lllllllllIIIl, llllllllIllIl);
    }

    protected static <T extends Element> List<T> getEnclosedElements(TypeElement llllllIllIIll, ElementKind ... llllllIllIIlI) {
        if (llllllIllIIlI == null || llllllIllIIlI.length < 1) {
            return TypeHandle.getEnclosedElements(llllllIllIIll);
        }
        if (llllllIllIIll == null) {
            return Collections.emptyList();
        }
        ImmutableList.Builder llllllIllIIIl = ImmutableList.builder();
        block0: for (Element element : llllllIllIIll.getEnclosedElements()) {
            for (ElementKind llllllIllIlIl : llllllIllIIlI) {
                if (element.getKind() != llllllIllIlIl) continue;
                llllllIllIIIl.add((Object)element);
                continue block0;
            }
        }
        return llllllIllIIIl.build();
    }

    public final FieldHandle findField(VariableElement lIIIIIIIllIlII, boolean lIIIIIIIllIIll) {
        TypeHandle lIIIIIIIllIIlI;
        return lIIIIIIIllIIlI.findField(lIIIIIIIllIlII.getSimpleName().toString(), TypeUtils.getTypeName(lIIIIIIIllIlII.asType()), lIIIIIIIllIIll);
    }

    public final TypeReference getReference() {
        TypeHandle lIIIIIIlIlIlll;
        if (lIIIIIIlIlIlll.reference == null) {
            lIIIIIIlIlIlll.reference = new TypeReference(lIIIIIIlIlIlll);
        }
        return lIIIIIIlIlIlll.reference;
    }

    protected static MethodHandle findMethod(TypeHandle lllllllIllllI, String lllllllIlllIl, String llllllllIIIIl, String lllllllIllIll, boolean lllllllIlllll) {
        for (ExecutableElement llllllllIIlII : TypeHandle.getEnclosedElements(lllllllIllllI.getTargetElement(), ElementKind.CONSTRUCTOR, ElementKind.METHOD)) {
            if (!TypeHandle.compareElement(llllllllIIlII, lllllllIlllIl, llllllllIIIIl, lllllllIlllll) && !TypeHandle.compareElement(llllllllIIlII, lllllllIlllIl, lllllllIllIll, lllllllIlllll)) continue;
            return new MethodHandle(lllllllIllllI, llllllllIIlII);
        }
        return null;
    }
}

