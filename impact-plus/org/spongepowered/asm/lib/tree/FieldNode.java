/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;

public class FieldNode
extends FieldVisitor {
    public /* synthetic */ Object value;
    public /* synthetic */ String desc;
    public /* synthetic */ List<AnnotationNode> visibleAnnotations;
    public /* synthetic */ List<TypeAnnotationNode> invisibleTypeAnnotations;
    public /* synthetic */ List<AnnotationNode> invisibleAnnotations;
    public /* synthetic */ String signature;
    public /* synthetic */ List<TypeAnnotationNode> visibleTypeAnnotations;
    public /* synthetic */ int access;
    public /* synthetic */ String name;
    public /* synthetic */ List<Attribute> attrs;

    public AnnotationVisitor visitAnnotation(String llIIllllIIIII, boolean llIIllllIIIll) {
        FieldNode llIIllllIIIIl;
        AnnotationNode llIIllllIIIlI = new AnnotationNode(llIIllllIIIII);
        if (llIIllllIIIll) {
            if (llIIllllIIIIl.visibleAnnotations == null) {
                llIIllllIIIIl.visibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            llIIllllIIIIl.visibleAnnotations.add(llIIllllIIIlI);
        } else {
            if (llIIllllIIIIl.invisibleAnnotations == null) {
                llIIllllIIIIl.invisibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            llIIllllIIIIl.invisibleAnnotations.add(llIIllllIIIlI);
        }
        return llIIllllIIIlI;
    }

    public void check(int llIIllIllllll) {
        if (llIIllIllllll == 262144) {
            FieldNode llIIlllIIIIlI;
            if (llIIlllIIIIlI.visibleTypeAnnotations != null && llIIlllIIIIlI.visibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (llIIlllIIIIlI.invisibleTypeAnnotations != null && llIIlllIIIIlI.invisibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
        }
    }

    public void visitAttribute(Attribute llIIlllIIlIII) {
        FieldNode llIIlllIIlIIl;
        if (llIIlllIIlIIl.attrs == null) {
            llIIlllIIlIIl.attrs = new ArrayList<Attribute>(1);
        }
        llIIlllIIlIIl.attrs.add(llIIlllIIlIII);
    }

    public void accept(ClassVisitor llIIllIlIlllI) {
        int llIIllIllIIIl;
        FieldNode llIIllIllIlII;
        FieldVisitor llIIllIllIIlI = llIIllIlIlllI.visitField(llIIllIllIlII.access, llIIllIllIlII.name, llIIllIllIlII.desc, llIIllIllIlII.signature, llIIllIllIlII.value);
        if (llIIllIllIIlI == null) {
            return;
        }
        int llIIllIllIIII = llIIllIllIlII.visibleAnnotations == null ? 0 : llIIllIllIlII.visibleAnnotations.size();
        for (llIIllIllIIIl = 0; llIIllIllIIIl < llIIllIllIIII; ++llIIllIllIIIl) {
            AnnotationNode llIIllIlllIII = llIIllIllIlII.visibleAnnotations.get(llIIllIllIIIl);
            llIIllIlllIII.accept(llIIllIllIIlI.visitAnnotation(llIIllIlllIII.desc, true));
        }
        llIIllIllIIII = llIIllIllIlII.invisibleAnnotations == null ? 0 : llIIllIllIlII.invisibleAnnotations.size();
        for (llIIllIllIIIl = 0; llIIllIllIIIl < llIIllIllIIII; ++llIIllIllIIIl) {
            AnnotationNode llIIllIllIlll = llIIllIllIlII.invisibleAnnotations.get(llIIllIllIIIl);
            llIIllIllIlll.accept(llIIllIllIIlI.visitAnnotation(llIIllIllIlll.desc, false));
        }
        llIIllIllIIII = llIIllIllIlII.visibleTypeAnnotations == null ? 0 : llIIllIllIlII.visibleTypeAnnotations.size();
        for (llIIllIllIIIl = 0; llIIllIllIIIl < llIIllIllIIII; ++llIIllIllIIIl) {
            TypeAnnotationNode llIIllIllIllI = llIIllIllIlII.visibleTypeAnnotations.get(llIIllIllIIIl);
            llIIllIllIllI.accept(llIIllIllIIlI.visitTypeAnnotation(llIIllIllIllI.typeRef, llIIllIllIllI.typePath, llIIllIllIllI.desc, true));
        }
        llIIllIllIIII = llIIllIllIlII.invisibleTypeAnnotations == null ? 0 : llIIllIllIlII.invisibleTypeAnnotations.size();
        for (llIIllIllIIIl = 0; llIIllIllIIIl < llIIllIllIIII; ++llIIllIllIIIl) {
            TypeAnnotationNode llIIllIllIlIl = llIIllIllIlII.invisibleTypeAnnotations.get(llIIllIllIIIl);
            llIIllIllIlIl.accept(llIIllIllIIlI.visitTypeAnnotation(llIIllIllIlIl.typeRef, llIIllIllIlIl.typePath, llIIllIllIlIl.desc, false));
        }
        llIIllIllIIII = llIIllIllIlII.attrs == null ? 0 : llIIllIllIlII.attrs.size();
        for (llIIllIllIIIl = 0; llIIllIllIIIl < llIIllIllIIII; ++llIIllIllIIIl) {
            llIIllIllIIlI.visitAttribute(llIIllIllIlII.attrs.get(llIIllIllIIIl));
        }
        llIIllIllIIlI.visitEnd();
    }

    public FieldNode(int llIlIIIIIlIIl, String llIlIIIIIlIII, String llIlIIIIIIIIl, String llIlIIIIIIllI, Object llIlIIIIIIlIl) {
        llIlIIIIIlIlI(327680, llIlIIIIIlIIl, llIlIIIIIlIII, llIlIIIIIIIIl, llIlIIIIIIllI, llIlIIIIIIlIl);
        FieldNode llIlIIIIIlIlI;
        if (llIlIIIIIlIlI.getClass() != FieldNode.class) {
            throw new IllegalStateException();
        }
    }

    public void visitEnd() {
    }

    public AnnotationVisitor visitTypeAnnotation(int llIIlllIlIIII, TypePath llIIlllIIllll, String llIIlllIlIlII, boolean llIIlllIlIIll) {
        FieldNode llIIlllIlIlll;
        TypeAnnotationNode llIIlllIlIIlI = new TypeAnnotationNode(llIIlllIlIIII, llIIlllIIllll, llIIlllIlIlII);
        if (llIIlllIlIIll) {
            if (llIIlllIlIlll.visibleTypeAnnotations == null) {
                llIIlllIlIlll.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            llIIlllIlIlll.visibleTypeAnnotations.add(llIIlllIlIIlI);
        } else {
            if (llIIlllIlIlll.invisibleTypeAnnotations == null) {
                llIIlllIlIlll.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            llIIlllIlIlll.invisibleTypeAnnotations.add(llIIlllIlIIlI);
        }
        return llIIlllIlIIlI;
    }

    public FieldNode(int llIIlllllIllI, int llIIllllIlllI, String llIIlllllIlII, String llIIlllllIIll, String llIIllllIlIll, Object llIIllllIlIlI) {
        super(llIIlllllIllI);
        FieldNode llIIlllllIIII;
        llIIlllllIIII.access = llIIllllIlllI;
        llIIlllllIIII.name = llIIlllllIlII;
        llIIlllllIIII.desc = llIIlllllIIll;
        llIIlllllIIII.signature = llIIllllIlIll;
        llIIlllllIIII.value = llIIllllIlIlI;
    }
}

