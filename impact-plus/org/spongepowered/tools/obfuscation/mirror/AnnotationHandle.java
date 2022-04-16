/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 */
package org.spongepowered.tools.obfuscation.mirror;

import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

public final class AnnotationHandle {
    private final /* synthetic */ AnnotationMirror annotation;
    public static final /* synthetic */ AnnotationHandle MISSING;

    protected static <T> List<T> unwrapAnnotationValueList(List<AnnotationValue> llllllllllllllllllllIlIIllIIIlII) {
        if (llllllllllllllllllllIlIIllIIIlII == null) {
            return Collections.emptyList();
        }
        ArrayList<Object> llllllllllllllllllllIlIIllIIIlIl = new ArrayList<Object>(llllllllllllllllllllIlIIllIIIlII.size());
        for (AnnotationValue llllllllllllllllllllIlIIllIIIlll : llllllllllllllllllllIlIIllIIIlII) {
            llllllllllllllllllllIlIIllIIIlIl.add(llllllllllllllllllllIlIIllIIIlll.getValue());
        }
        return llllllllllllllllllllIlIIllIIIlIl;
    }

    public AnnotationMirror asMirror() {
        AnnotationHandle llllllllllllllllllllIlIlIIlIlIlI;
        return llllllllllllllllllllIlIlIIlIlIlI.annotation;
    }

    public <T> T getValue(String llllllllllllllllllllIlIlIIIllIII, T llllllllllllllllllllIlIlIIIllIll) {
        AnnotationHandle llllllllllllllllllllIlIlIIIlllIl;
        if (llllllllllllllllllllIlIlIIIlllIl.annotation == null) {
            return llllllllllllllllllllIlIlIIIllIll;
        }
        AnnotationValue llllllllllllllllllllIlIlIIIllIlI = llllllllllllllllllllIlIlIIIlllIl.getAnnotationValue(llllllllllllllllllllIlIlIIIllIII);
        if (llllllllllllllllllllIlIlIIIllIll instanceof Enum && llllllllllllllllllllIlIlIIIllIlI != null) {
            VariableElement llllllllllllllllllllIlIlIIIllllI = (VariableElement)llllllllllllllllllllIlIlIIIllIlI.getValue();
            if (llllllllllllllllllllIlIlIIIllllI == null) {
                return llllllllllllllllllllIlIlIIIllIll;
            }
            return (T)Enum.valueOf(llllllllllllllllllllIlIlIIIllIll.getClass(), llllllllllllllllllllIlIlIIIllllI.getSimpleName().toString());
        }
        return (T)(llllllllllllllllllllIlIlIIIllIlI != null ? llllllllllllllllllllIlIlIIIllIlI.getValue() : llllllllllllllllllllIlIlIIIllIll);
    }

    protected static AnnotationMirror getAnnotation(Element llllllllllllllllllllIlIIlIllIllI, Class<? extends Annotation> llllllllllllllllllllIlIIlIllIlIl) {
        if (llllllllllllllllllllIlIIlIllIllI == null) {
            return null;
        }
        List<? extends AnnotationMirror> llllllllllllllllllllIlIIlIllIlII = llllllllllllllllllllIlIIlIllIllI.getAnnotationMirrors();
        if (llllllllllllllllllllIlIIlIllIlII == null) {
            return null;
        }
        for (AnnotationMirror annotationMirror : llllllllllllllllllllIlIIlIllIlII) {
            TypeElement llllllllllllllllllllIlIIlIlllIII;
            Element llllllllllllllllllllIlIIlIlllIIl = annotationMirror.getAnnotationType().asElement();
            if (!(llllllllllllllllllllIlIIlIlllIIl instanceof TypeElement) || !(llllllllllllllllllllIlIIlIlllIII = (TypeElement)llllllllllllllllllllIlIIlIlllIIl).getQualifiedName().contentEquals(llllllllllllllllllllIlIIlIllIlIl.getName())) continue;
            return annotationMirror;
        }
        return null;
    }

    protected AnnotationValue getAnnotationValue(String llllllllllllllllllllIlIIllIIlllI) {
        AnnotationHandle llllllllllllllllllllIlIIllIIllll;
        for (ExecutableElement executableElement : llllllllllllllllllllIlIIllIIllll.annotation.getElementValues().keySet()) {
            if (!executableElement.getSimpleName().contentEquals(llllllllllllllllllllIlIIllIIlllI)) continue;
            return llllllllllllllllllllIlIIllIIllll.annotation.getElementValues().get(executableElement);
        }
        return null;
    }

    public List<AnnotationHandle> getAnnotationList(String llllllllllllllllllllIlIIlllIIIIl) {
        AnnotationHandle llllllllllllllllllllIlIIllIlllIl;
        Object llllllllllllllllllllIlIIlllIIIII = llllllllllllllllllllIlIIllIlllIl.getValue(llllllllllllllllllllIlIIlllIIIIl, null);
        if (llllllllllllllllllllIlIIlllIIIII == null) {
            return Collections.emptyList();
        }
        if (llllllllllllllllllllIlIIlllIIIII instanceof AnnotationMirror) {
            return ImmutableList.of((Object)AnnotationHandle.of(llllllllllllllllllllIlIIlllIIIII));
        }
        List llllllllllllllllllllIlIIllIlllll = llllllllllllllllllllIlIIlllIIIII;
        ArrayList<AnnotationHandle> llllllllllllllllllllIlIIllIllllI = new ArrayList<AnnotationHandle>(llllllllllllllllllllIlIIllIlllll.size());
        for (AnnotationValue llllllllllllllllllllIlIIlllIIIll : llllllllllllllllllllIlIIllIlllll) {
            llllllllllllllllllllIlIIllIllllI.add(new AnnotationHandle((AnnotationMirror)llllllllllllllllllllIlIIlllIIIll.getValue()));
        }
        return Collections.unmodifiableList(llllllllllllllllllllIlIIllIllllI);
    }

    public <T> T getValue() {
        AnnotationHandle llllllllllllllllllllIlIlIIIlIIll;
        return llllllllllllllllllllIlIlIIIlIIll.getValue("value", null);
    }

    public AnnotationHandle getAnnotation(String llllllllllllllllllllIlIIlllllIIl) {
        Object llllllllllllllllllllIlIIlllllllI;
        AnnotationHandle llllllllllllllllllllIlIIllllllIl;
        Object llllllllllllllllllllIlIIlllllIll = llllllllllllllllllllIlIIllllllIl.getValue(llllllllllllllllllllIlIIlllllIIl);
        if (llllllllllllllllllllIlIIlllllIll instanceof AnnotationMirror) {
            return AnnotationHandle.of((AnnotationMirror)llllllllllllllllllllIlIIlllllIll);
        }
        if (llllllllllllllllllllIlIIlllllIll instanceof AnnotationValue && (llllllllllllllllllllIlIIlllllllI = ((AnnotationValue)llllllllllllllllllllIlIIlllllIll).getValue()) instanceof AnnotationMirror) {
            return AnnotationHandle.of((AnnotationMirror)llllllllllllllllllllIlIIlllllllI);
        }
        return null;
    }

    public static AnnotationHandle of(Element llllllllllllllllllllIlIIlIlIIlll, Class<? extends Annotation> llllllllllllllllllllIlIIlIlIIlII) {
        return new AnnotationHandle(AnnotationHandle.getAnnotation(llllllllllllllllllllIlIIlIlIIlll, llllllllllllllllllllIlIIlIlIIlII));
    }

    public <T> List<T> getList(String llllllllllllllllllllIlIIlllIllII) {
        AnnotationHandle llllllllllllllllllllIlIIlllIllIl;
        List<AnnotationValue> llllllllllllllllllllIlIIlllIlllI = llllllllllllllllllllIlIIlllIllIl.getValue(llllllllllllllllllllIlIIlllIllII, Collections.emptyList());
        return AnnotationHandle.unwrapAnnotationValueList(llllllllllllllllllllIlIIlllIlllI);
    }

    public String toString() {
        AnnotationHandle llllllllllllllllllllIlIlIIlIIlIl;
        if (llllllllllllllllllllIlIlIIlIIlIl.annotation == null) {
            return "@{UnknownAnnotation}";
        }
        return String.valueOf(new StringBuilder().append("@").append((Object)llllllllllllllllllllIlIlIIlIIlIl.annotation.getAnnotationType().asElement().getSimpleName()));
    }

    public <T> T getValue(String llllllllllllllllllllIlIlIIIIlllI) {
        AnnotationHandle llllllllllllllllllllIlIlIIIIllll;
        return llllllllllllllllllllIlIlIIIIllll.getValue(llllllllllllllllllllIlIlIIIIlllI, null);
    }

    private AnnotationHandle(AnnotationMirror llllllllllllllllllllIlIlIIlIllll) {
        AnnotationHandle llllllllllllllllllllIlIlIIlIlllI;
        llllllllllllllllllllIlIlIIlIlllI.annotation = llllllllllllllllllllIlIlIIlIllll;
    }

    public <T> List<T> getList() {
        AnnotationHandle llllllllllllllllllllIlIIllllIlII;
        return llllllllllllllllllllIlIIllllIlII.getList("value");
    }

    public static AnnotationHandle of(AnnotationMirror llllllllllllllllllllIlIIlIlIlIll) {
        return new AnnotationHandle(llllllllllllllllllllIlIIlIlIlIll);
    }

    public boolean exists() {
        AnnotationHandle llllllllllllllllllllIlIlIIlIlIII;
        return llllllllllllllllllllIlIlIIlIlIII.annotation != null;
    }

    public boolean getBoolean(String llllllllllllllllllllIlIlIIIIIlll, boolean llllllllllllllllllllIlIlIIIIIllI) {
        AnnotationHandle llllllllllllllllllllIlIlIIIIlIII;
        return llllllllllllllllllllIlIlIIIIlIII.getValue(llllllllllllllllllllIlIlIIIIIlll, llllllllllllllllllllIlIlIIIIIllI);
    }

    static {
        MISSING = new AnnotationHandle(null);
    }
}

