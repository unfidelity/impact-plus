/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Function
 *  com.google.common.base.Preconditions
 *  com.google.common.collect.Lists
 */
package org.spongepowered.asm.util;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.MethodNode;

public final class Annotations {
    public static AnnotationNode getVisibleParameter(MethodNode llllllllllllllllIlIIIIIIllllIlII, Class<? extends Annotation> llllllllllllllllIlIIIIIIllllIllI, int llllllllllllllllIlIIIIIIllllIlIl) {
        return Annotations.getParameter(llllllllllllllllIlIIIIIIllllIlII.visibleParameterAnnotations, Type.getDescriptor(llllllllllllllllIlIIIIIIllllIllI), llllllllllllllllIlIIIIIIllllIlIl);
    }

    public static void setVisible(MethodNode llllllllllllllllIlIIIIIlIlIlIIII, Class<? extends Annotation> llllllllllllllllIlIIIIIlIlIIlIll, Object ... llllllllllllllllIlIIIIIlIlIIlIlI) {
        AnnotationNode llllllllllllllllIlIIIIIlIlIIllIl = Annotations.createNode(Type.getDescriptor(llllllllllllllllIlIIIIIlIlIIlIll), llllllllllllllllIlIIIIIlIlIIlIlI);
        llllllllllllllllIlIIIIIlIlIlIIII.visibleAnnotations = Annotations.add(llllllllllllllllIlIIIIIlIlIlIIII.visibleAnnotations, llllllllllllllllIlIIIIIlIlIIllIl);
    }

    public static AnnotationNode getVisible(MethodNode llllllllllllllllIlIIIIIlIIIllIlI, Class<? extends Annotation> llllllllllllllllIlIIIIIlIIIllIIl) {
        return Annotations.get(llllllllllllllllIlIIIIIlIIIllIlI.visibleAnnotations, Type.getDescriptor(llllllllllllllllIlIIIIIlIIIllIIl));
    }

    private static <T extends Enum<T>> T toEnumValue(Class<T> llllllllllllllllIlIIIIIIIlIlllII, String[] llllllllllllllllIlIIIIIIIlIllllI) {
        if (!llllllllllllllllIlIIIIIIIlIlllII.getName().equals(Type.getType(llllllllllllllllIlIIIIIIIlIllllI[0]).getClassName())) {
            throw new IllegalArgumentException("The supplied enum class does not match the stored enum value");
        }
        return Enum.valueOf(llllllllllllllllIlIIIIIIIlIlllII, llllllllllllllllIlIIIIIIIlIllllI[1]);
    }

    private static AnnotationNode createNode(String llllllllllllllllIlIIIIIlIIllIlll, Object ... llllllllllllllllIlIIIIIlIIllIIll) {
        AnnotationNode llllllllllllllllIlIIIIIlIIllIlIl = new AnnotationNode(llllllllllllllllIlIIIIIlIIllIlll);
        for (int llllllllllllllllIlIIIIIlIIlllIII = 0; llllllllllllllllIlIIIIIlIIlllIII < llllllllllllllllIlIIIIIlIIllIIll.length - 1; llllllllllllllllIlIIIIIlIIlllIII += 2) {
            if (!(llllllllllllllllIlIIIIIlIIllIIll[llllllllllllllllIlIIIIIlIIlllIII] instanceof String)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Annotation keys must be strings, found ").append(llllllllllllllllIlIIIIIlIIllIIll[llllllllllllllllIlIIIIIlIIlllIII].getClass().getSimpleName()).append(" with ").append(llllllllllllllllIlIIIIIlIIllIIll[llllllllllllllllIlIIIIIlIIlllIII].toString()).append(" at index ").append(llllllllllllllllIlIIIIIlIIlllIII).append(" creating ").append(llllllllllllllllIlIIIIIlIIllIlll)));
            }
            llllllllllllllllIlIIIIIlIIllIlIl.visit((String)llllllllllllllllIlIIIIIlIIllIIll[llllllllllllllllIlIIIIIlIIlllIII], llllllllllllllllIlIIIIIlIIllIIll[llllllllllllllllIlIIIIIlIIlllIII + 1]);
        }
        return llllllllllllllllIlIIIIIlIIllIlIl;
    }

    private Annotations() {
        Annotations llllllllllllllllIlIIIIIlIllIllIl;
    }

    public static AnnotationNode getParameter(List<AnnotationNode>[] llllllllllllllllIlIIIIIIlllIIIlI, String llllllllllllllllIlIIIIIIlllIIIIl, int llllllllllllllllIlIIIIIIlllIIIll) {
        if (llllllllllllllllIlIIIIIIlllIIIlI == null || llllllllllllllllIlIIIIIIlllIIIll < 0 || llllllllllllllllIlIIIIIIlllIIIll >= llllllllllllllllIlIIIIIIlllIIIlI.length) {
            return null;
        }
        return Annotations.get(llllllllllllllllIlIIIIIIlllIIIlI[llllllllllllllllIlIIIIIIlllIIIll], llllllllllllllllIlIIIIIIlllIIIIl);
    }

    public static <T> T getValue(AnnotationNode llllllllllllllllIlIIIIIIlIllIIll, String llllllllllllllllIlIIIIIIlIllIIlI, T llllllllllllllllIlIIIIIIlIllIlIl) {
        T llllllllllllllllIlIIIIIIlIllIlII = Annotations.getValue(llllllllllllllllIlIIIIIIlIllIIll, llllllllllllllllIlIIIIIIlIllIIlI);
        return llllllllllllllllIlIIIIIIlIllIlII != null ? llllllllllllllllIlIIIIIIlIllIlII : llllllllllllllllIlIIIIIIlIllIlIl;
    }

    private static List<AnnotationNode> add(List<AnnotationNode> llllllllllllllllIlIIIIIlIIlIlllI, AnnotationNode llllllllllllllllIlIIIIIlIIlIllIl) {
        if (llllllllllllllllIlIIIIIlIIlIlllI == null) {
            llllllllllllllllIlIIIIIlIIlIlllI = new ArrayList<AnnotationNode>(1);
        } else {
            llllllllllllllllIlIIIIIlIIlIlllI.remove(Annotations.get(llllllllllllllllIlIIIIIlIIlIlllI, llllllllllllllllIlIIIIIlIIlIllIl.desc));
        }
        llllllllllllllllIlIIIIIlIIlIlllI.add(llllllllllllllllIlIIIIIlIIlIllIl);
        return llllllllllllllllIlIIIIIlIIlIlllI;
    }

    public static void setInvisible(FieldNode llllllllllllllllIlIIIIIlIlIlllII, Class<? extends Annotation> llllllllllllllllIlIIIIIlIlIllIll, Object ... llllllllllllllllIlIIIIIlIlIllIlI) {
        AnnotationNode llllllllllllllllIlIIIIIlIlIllIIl = Annotations.createNode(Type.getDescriptor(llllllllllllllllIlIIIIIlIlIllIll), llllllllllllllllIlIIIIIlIlIllIlI);
        llllllllllllllllIlIIIIIlIlIlllII.invisibleAnnotations = Annotations.add(llllllllllllllllIlIIIIIlIlIlllII.invisibleAnnotations, llllllllllllllllIlIIIIIlIlIllIIl);
    }

    public static AnnotationNode getInvisible(ClassNode llllllllllllllllIlIIIIIIlllllllI, Class<? extends Annotation> llllllllllllllllIlIIIIIIllllllIl) {
        return Annotations.get(llllllllllllllllIlIIIIIIlllllllI.invisibleAnnotations, Type.getDescriptor(llllllllllllllllIlIIIIIIllllllIl));
    }

    public static <T> T getValue(AnnotationNode llllllllllllllllIlIIIIIIlIlIlIlI, String llllllllllllllllIlIIIIIIlIlIIlIl, Class<?> llllllllllllllllIlIIIIIIlIlIlIII) {
        Preconditions.checkNotNull(llllllllllllllllIlIIIIIIlIlIlIII, (Object)"annotationClass cannot be null");
        Object llllllllllllllllIlIIIIIIlIlIIlll = Annotations.getValue(llllllllllllllllIlIIIIIIlIlIlIlI, llllllllllllllllIlIIIIIIlIlIIlIl);
        if (llllllllllllllllIlIIIIIIlIlIIlll == null) {
            try {
                llllllllllllllllIlIIIIIIlIlIIlll = llllllllllllllllIlIIIIIIlIlIlIII.getDeclaredMethod(llllllllllllllllIlIIIIIIlIlIIlIl, new Class[0]).getDefaultValue();
            }
            catch (NoSuchMethodException llllllllllllllllIlIIIIIIlIlIIIlI) {
                // empty catch block
            }
        }
        return llllllllllllllllIlIIIIIIlIlIIlll;
    }

    public static <T> T getValue(AnnotationNode llllllllllllllllIlIIIIIIlIIllIll, String llllllllllllllllIlIIIIIIlIIlIlll) {
        boolean llllllllllllllllIlIIIIIIlIIllIIl = false;
        if (llllllllllllllllIlIIIIIIlIIllIll == null || llllllllllllllllIlIIIIIIlIIllIll.values == null) {
            return null;
        }
        for (Object llllllllllllllllIlIIIIIIlIIlllII : llllllllllllllllIlIIIIIIlIIllIll.values) {
            if (llllllllllllllllIlIIIIIIlIIllIIl) {
                return (T)llllllllllllllllIlIIIIIIlIIlllII;
            }
            if (!llllllllllllllllIlIIIIIIlIIlllII.equals(llllllllllllllllIlIIIIIIlIIlIlll)) continue;
            llllllllllllllllIlIIIIIIlIIllIIl = true;
        }
        return null;
    }

    public static AnnotationNode getSingleInvisible(MethodNode llllllllllllllllIlIIIIIlIIIIlIII, Class<? extends Annotation> ... llllllllllllllllIlIIIIIlIIIIIlll) {
        return Annotations.getSingle(llllllllllllllllIlIIIIIlIIIIlIII.invisibleAnnotations, llllllllllllllllIlIIIIIlIIIIIlll);
    }

    public static AnnotationNode getVisible(FieldNode llllllllllllllllIlIIIIIlIIlIIllI, Class<? extends Annotation> llllllllllllllllIlIIIIIlIIlIIlll) {
        return Annotations.get(llllllllllllllllIlIIIIIlIIlIIllI.visibleAnnotations, Type.getDescriptor(llllllllllllllllIlIIIIIlIIlIIlll));
    }

    public static AnnotationNode getVisible(ClassNode llllllllllllllllIlIIIIIlIIIIIIlI, Class<? extends Annotation> llllllllllllllllIlIIIIIlIIIIIIll) {
        return Annotations.get(llllllllllllllllIlIIIIIlIIIIIIlI.visibleAnnotations, Type.getDescriptor(llllllllllllllllIlIIIIIlIIIIIIll));
    }

    public static AnnotationNode getInvisible(FieldNode llllllllllllllllIlIIIIIlIIlIIIlI, Class<? extends Annotation> llllllllllllllllIlIIIIIlIIIlllll) {
        return Annotations.get(llllllllllllllllIlIIIIIlIIlIIIlI.invisibleAnnotations, Type.getDescriptor(llllllllllllllllIlIIIIIlIIIlllll));
    }

    public static <T extends Enum<T>> T getValue(AnnotationNode llllllllllllllllIlIIIIIIlIIIlIIl, String llllllllllllllllIlIIIIIIlIIIlIII, Class<T> llllllllllllllllIlIIIIIIlIIIIlll, T llllllllllllllllIlIIIIIIlIIIlIll) {
        String[] llllllllllllllllIlIIIIIIlIIIlIlI = (String[])Annotations.getValue(llllllllllllllllIlIIIIIIlIIIlIIl, llllllllllllllllIlIIIIIIlIIIlIII);
        if (llllllllllllllllIlIIIIIIlIIIlIlI == null) {
            return llllllllllllllllIlIIIIIIlIIIlIll;
        }
        return Annotations.toEnumValue(llllllllllllllllIlIIIIIIlIIIIlll, llllllllllllllllIlIIIIIIlIIIlIlI);
    }

    public static <T> List<T> getValue(AnnotationNode llllllllllllllllIlIIIIIIIlllllll, String llllllllllllllllIlIIIIIIIllllllI, boolean llllllllllllllllIlIIIIIIIlllllIl) {
        T llllllllllllllllIlIIIIIIIlllllII = Annotations.getValue(llllllllllllllllIlIIIIIIIlllllll, llllllllllllllllIlIIIIIIIllllllI);
        if (llllllllllllllllIlIIIIIIIlllllII instanceof List) {
            return (List)llllllllllllllllIlIIIIIIIlllllII;
        }
        if (llllllllllllllllIlIIIIIIIlllllII != null) {
            ArrayList<T> llllllllllllllllIlIIIIIIlIIIIIII = new ArrayList<T>();
            llllllllllllllllIlIIIIIIlIIIIIII.add(llllllllllllllllIlIIIIIIIlllllII);
            return llllllllllllllllIlIIIIIIlIIIIIII;
        }
        return Collections.emptyList();
    }

    public static AnnotationNode getInvisible(MethodNode llllllllllllllllIlIIIIIlIIIlIllI, Class<? extends Annotation> llllllllllllllllIlIIIIIlIIIlIIll) {
        return Annotations.get(llllllllllllllllIlIIIIIlIIIlIllI.invisibleAnnotations, Type.getDescriptor(llllllllllllllllIlIIIIIlIIIlIIll));
    }

    public static AnnotationNode getSingleVisible(MethodNode llllllllllllllllIlIIIIIlIIIIlllI, Class<? extends Annotation> ... llllllllllllllllIlIIIIIlIIIIllIl) {
        return Annotations.getSingle(llllllllllllllllIlIIIIIlIIIIlllI.visibleAnnotations, llllllllllllllllIlIIIIIlIIIIllIl);
    }

    public static <T extends Enum<T>> List<T> getValue(AnnotationNode llllllllllllllllIlIIIIIIIlllIIII, String llllllllllllllllIlIIIIIIIllIllll, boolean llllllllllllllllIlIIIIIIIllIlllI, Class<T> llllllllllllllllIlIIIIIIIllIIlll) {
        T llllllllllllllllIlIIIIIIIllIllII = Annotations.getValue(llllllllllllllllIlIIIIIIIlllIIII, llllllllllllllllIlIIIIIIIllIllll);
        if (llllllllllllllllIlIIIIIIIllIllII instanceof List) {
            ListIterator<T> llllllllllllllllIlIIIIIIIlllIIlI = ((List)llllllllllllllllIlIIIIIIIllIllII).listIterator();
            while (llllllllllllllllIlIIIIIIIlllIIlI.hasNext()) {
                llllllllllllllllIlIIIIIIIlllIIlI.set(Annotations.toEnumValue(llllllllllllllllIlIIIIIIIllIIlll, (String[])llllllllllllllllIlIIIIIIIlllIIlI.next()));
            }
            return (List)llllllllllllllllIlIIIIIIIllIllII;
        }
        if (llllllllllllllllIlIIIIIIIllIllII instanceof String[]) {
            ArrayList<T> llllllllllllllllIlIIIIIIIlllIIIl = new ArrayList<T>();
            llllllllllllllllIlIIIIIIIlllIIIl.add(Annotations.toEnumValue(llllllllllllllllIlIIIIIIIllIIlll, (String[])llllllllllllllllIlIIIIIIIllIllII));
            return llllllllllllllllIlIIIIIIIlllIIIl;
        }
        return Collections.emptyList();
    }

    private static AnnotationNode getSingle(List<AnnotationNode> llllllllllllllllIlIIIIIIllIIIllI, Class<? extends Annotation>[] llllllllllllllllIlIIIIIIllIIlIIl) {
        ArrayList<AnnotationNode> llllllllllllllllIlIIIIIIllIIlIII = new ArrayList<AnnotationNode>();
        for (Class<? extends Annotation> llllllllllllllllIlIIIIIIllIIlIll : llllllllllllllllIlIIIIIIllIIlIIl) {
            AnnotationNode llllllllllllllllIlIIIIIIllIIllII = Annotations.get(llllllllllllllllIlIIIIIIllIIIllI, Type.getDescriptor(llllllllllllllllIlIIIIIIllIIlIll));
            if (llllllllllllllllIlIIIIIIllIIllII == null) continue;
            llllllllllllllllIlIIIIIIllIIlIII.add(llllllllllllllllIlIIIIIIllIIllII);
        }
        int llllllllllllllllIlIIIIIIllIIIlll = llllllllllllllllIlIIIIIIllIIlIII.size();
        if (llllllllllllllllIlIIIIIIllIIIlll > 1) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Conflicting annotations found: ").append(Lists.transform(llllllllllllllllIlIIIIIIllIIlIII, (Function)new Function<AnnotationNode, String>(){
                {
                    1 llllllllllllllllIllIIIIlllIlIllI;
                }

                public String apply(AnnotationNode llllllllllllllllIllIIIIlllIlIIIl) {
                    return llllllllllllllllIllIIIIlllIlIIIl.desc;
                }
            }))));
        }
        return llllllllllllllllIlIIIIIIllIIIlll == 0 ? null : (AnnotationNode)llllllllllllllllIlIIIIIIllIIlIII.get(0);
    }

    public static <T> T getValue(AnnotationNode llllllllllllllllIlIIIIIIlIllllIl) {
        return Annotations.getValue(llllllllllllllllIlIIIIIIlIllllIl, "value");
    }

    public static void setInvisible(MethodNode llllllllllllllllIlIIIIIlIlIIIIII, Class<? extends Annotation> llllllllllllllllIlIIIIIlIlIIIIll, Object ... llllllllllllllllIlIIIIIlIlIIIIlI) {
        AnnotationNode llllllllllllllllIlIIIIIlIlIIIIIl = Annotations.createNode(Type.getDescriptor(llllllllllllllllIlIIIIIlIlIIIIll), llllllllllllllllIlIIIIIlIlIIIIlI);
        llllllllllllllllIlIIIIIlIlIIIIII.invisibleAnnotations = Annotations.add(llllllllllllllllIlIIIIIlIlIIIIII.invisibleAnnotations, llllllllllllllllIlIIIIIlIlIIIIIl);
    }

    public static AnnotationNode get(List<AnnotationNode> llllllllllllllllIlIIIIIIllIllIlI, String llllllllllllllllIlIIIIIIllIlIlll) {
        if (llllllllllllllllIlIIIIIIllIllIlI == null) {
            return null;
        }
        for (AnnotationNode llllllllllllllllIlIIIIIIllIllIll : llllllllllllllllIlIIIIIIllIllIlI) {
            if (!llllllllllllllllIlIIIIIIllIlIlll.equals(llllllllllllllllIlIIIIIIllIllIll.desc)) continue;
            return llllllllllllllllIlIIIIIIllIllIll;
        }
        return null;
    }

    public static AnnotationNode getInvisibleParameter(MethodNode llllllllllllllllIlIIIIIIlllIlIll, Class<? extends Annotation> llllllllllllllllIlIIIIIIlllIlIlI, int llllllllllllllllIlIIIIIIlllIllII) {
        return Annotations.getParameter(llllllllllllllllIlIIIIIIlllIlIll.invisibleParameterAnnotations, Type.getDescriptor(llllllllllllllllIlIIIIIIlllIlIlI), llllllllllllllllIlIIIIIIlllIllII);
    }

    public static void setVisible(FieldNode llllllllllllllllIlIIIIIlIllIlIII, Class<? extends Annotation> llllllllllllllllIlIIIIIlIllIIIll, Object ... llllllllllllllllIlIIIIIlIllIIllI) {
        AnnotationNode llllllllllllllllIlIIIIIlIllIIlIl = Annotations.createNode(Type.getDescriptor(llllllllllllllllIlIIIIIlIllIIIll), llllllllllllllllIlIIIIIlIllIIllI);
        llllllllllllllllIlIIIIIlIllIlIII.visibleAnnotations = Annotations.add(llllllllllllllllIlIIIIIlIllIlIII.visibleAnnotations, llllllllllllllllIlIIIIIlIllIIlIl);
    }
}

