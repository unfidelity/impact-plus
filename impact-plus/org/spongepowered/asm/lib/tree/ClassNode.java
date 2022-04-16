/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.InnerClassNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;

public class ClassNode
extends ClassVisitor {
    public /* synthetic */ int access;
    public /* synthetic */ String outerClass;
    public /* synthetic */ List<Attribute> attrs;
    public /* synthetic */ List<InnerClassNode> innerClasses;
    public /* synthetic */ List<AnnotationNode> visibleAnnotations;
    public /* synthetic */ String name;
    public /* synthetic */ String outerMethod;
    public /* synthetic */ List<FieldNode> fields;
    public /* synthetic */ String superName;
    public /* synthetic */ List<TypeAnnotationNode> visibleTypeAnnotations;
    public /* synthetic */ int version;
    public /* synthetic */ List<MethodNode> methods;
    public /* synthetic */ List<String> interfaces;
    public /* synthetic */ List<TypeAnnotationNode> invisibleTypeAnnotations;
    public /* synthetic */ String sourceFile;
    public /* synthetic */ String sourceDebug;
    public /* synthetic */ String signature;
    public /* synthetic */ List<AnnotationNode> invisibleAnnotations;
    public /* synthetic */ String outerMethodDesc;

    public void visitEnd() {
    }

    public void visitOuterClass(String lllllllllllllllllIIlIlIllIIllllI, String lllllllllllllllllIIlIlIllIIlllIl, String lllllllllllllllllIIlIlIllIlIIIII) {
        lllllllllllllllllIIlIlIllIlIIIll.outerClass = lllllllllllllllllIIlIlIllIIllllI;
        lllllllllllllllllIIlIlIllIlIIIll.outerMethod = lllllllllllllllllIIlIlIllIIlllIl;
        lllllllllllllllllIIlIlIllIlIIIll.outerMethodDesc = lllllllllllllllllIIlIlIllIlIIIII;
    }

    public void visit(int lllllllllllllllllIIlIlIllIllllIl, int lllllllllllllllllIIlIlIllIllllII, String lllllllllllllllllIIlIlIllIllIlII, String lllllllllllllllllIIlIlIllIlllIlI, String lllllllllllllllllIIlIlIllIllIIlI, String[] lllllllllllllllllIIlIlIllIlllIII) {
        lllllllllllllllllIIlIlIllIlllllI.version = lllllllllllllllllIIlIlIllIllllIl;
        lllllllllllllllllIIlIlIllIlllllI.access = lllllllllllllllllIIlIlIllIllllII;
        lllllllllllllllllIIlIlIllIlllllI.name = lllllllllllllllllIIlIlIllIllIlII;
        lllllllllllllllllIIlIlIllIlllllI.signature = lllllllllllllllllIIlIlIllIlllIlI;
        lllllllllllllllllIIlIlIllIlllllI.superName = lllllllllllllllllIIlIlIllIllIIlI;
        if (lllllllllllllllllIIlIlIllIlllIII != null) {
            ClassNode lllllllllllllllllIIlIlIllIlllllI;
            lllllllllllllllllIIlIlIllIlllllI.interfaces.addAll(Arrays.asList(lllllllllllllllllIIlIlIllIlllIII));
        }
    }

    public AnnotationVisitor visitTypeAnnotation(int lllllllllllllllllIIlIlIllIIIlIII, TypePath lllllllllllllllllIIlIlIllIIIIIIl, String lllllllllllllllllIIlIlIllIIIIllI, boolean lllllllllllllllllIIlIlIllIIIIlIl) {
        ClassNode lllllllllllllllllIIlIlIllIIIIIll;
        TypeAnnotationNode lllllllllllllllllIIlIlIllIIIIlII = new TypeAnnotationNode(lllllllllllllllllIIlIlIllIIIlIII, lllllllllllllllllIIlIlIllIIIIIIl, lllllllllllllllllIIlIlIllIIIIllI);
        if (lllllllllllllllllIIlIlIllIIIIlIl) {
            if (lllllllllllllllllIIlIlIllIIIIIll.visibleTypeAnnotations == null) {
                lllllllllllllllllIIlIlIllIIIIIll.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            lllllllllllllllllIIlIlIllIIIIIll.visibleTypeAnnotations.add(lllllllllllllllllIIlIlIllIIIIlII);
        } else {
            if (lllllllllllllllllIIlIlIllIIIIIll.invisibleTypeAnnotations == null) {
                lllllllllllllllllIIlIlIllIIIIIll.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            lllllllllllllllllIIlIlIllIIIIIll.invisibleTypeAnnotations.add(lllllllllllllllllIIlIlIllIIIIlII);
        }
        return lllllllllllllllllIIlIlIllIIIIlII;
    }

    public ClassNode(int lllllllllllllllllIIlIlIlllIIIllI) {
        super(lllllllllllllllllIIlIlIlllIIIllI);
        ClassNode lllllllllllllllllIIlIlIlllIIlIIl;
        lllllllllllllllllIIlIlIlllIIlIIl.interfaces = new ArrayList<String>();
        lllllllllllllllllIIlIlIlllIIlIIl.innerClasses = new ArrayList<InnerClassNode>();
        lllllllllllllllllIIlIlIlllIIlIIl.fields = new ArrayList<FieldNode>();
        lllllllllllllllllIIlIlIlllIIlIIl.methods = new ArrayList<MethodNode>();
    }

    public void visitAttribute(Attribute lllllllllllllllllIIlIlIlIllllIlI) {
        ClassNode lllllllllllllllllIIlIlIlIllllIIl;
        if (lllllllllllllllllIIlIlIlIllllIIl.attrs == null) {
            lllllllllllllllllIIlIlIlIllllIIl.attrs = new ArrayList<Attribute>(1);
        }
        lllllllllllllllllIIlIlIlIllllIIl.attrs.add(lllllllllllllllllIIlIlIlIllllIlI);
    }

    public void check(int lllllllllllllllllIIlIlIlIIlIlIII) {
        if (lllllllllllllllllIIlIlIlIIlIlIII == 262144) {
            ClassNode lllllllllllllllllIIlIlIlIIlIlIIl;
            if (lllllllllllllllllIIlIlIlIIlIlIIl.visibleTypeAnnotations != null && lllllllllllllllllIIlIlIlIIlIlIIl.visibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (lllllllllllllllllIIlIlIlIIlIlIIl.invisibleTypeAnnotations != null && lllllllllllllllllIIlIlIlIIlIlIIl.invisibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            for (FieldNode lllllllllllllllllIIlIlIlIIlIlIll : lllllllllllllllllIIlIlIlIIlIlIIl.fields) {
                lllllllllllllllllIIlIlIlIIlIlIll.check(lllllllllllllllllIIlIlIlIIlIlIII);
            }
            for (MethodNode lllllllllllllllllIIlIlIlIIlIlIlI : lllllllllllllllllIIlIlIlIIlIlIIl.methods) {
                lllllllllllllllllIIlIlIlIIlIlIlI.check(lllllllllllllllllIIlIlIlIIlIlIII);
            }
        }
    }

    public void accept(ClassVisitor lllllllllllllllllIIlIlIIlllIlllI) {
        int lllllllllllllllllIIlIlIIlllIlIlI;
        ClassNode lllllllllllllllllIIlIlIIlllIIllI;
        String[] lllllllllllllllllIIlIlIIlllIllII = new String[lllllllllllllllllIIlIlIIlllIIllI.interfaces.size()];
        lllllllllllllllllIIlIlIIlllIIllI.interfaces.toArray(lllllllllllllllllIIlIlIIlllIllII);
        lllllllllllllllllIIlIlIIlllIlllI.visit(lllllllllllllllllIIlIlIIlllIIllI.version, lllllllllllllllllIIlIlIIlllIIllI.access, lllllllllllllllllIIlIlIIlllIIllI.name, lllllllllllllllllIIlIlIIlllIIllI.signature, lllllllllllllllllIIlIlIIlllIIllI.superName, lllllllllllllllllIIlIlIIlllIllII);
        if (lllllllllllllllllIIlIlIIlllIIllI.sourceFile != null || lllllllllllllllllIIlIlIIlllIIllI.sourceDebug != null) {
            lllllllllllllllllIIlIlIIlllIlllI.visitSource(lllllllllllllllllIIlIlIIlllIIllI.sourceFile, lllllllllllllllllIIlIlIIlllIIllI.sourceDebug);
        }
        if (lllllllllllllllllIIlIlIIlllIIllI.outerClass != null) {
            lllllllllllllllllIIlIlIIlllIlllI.visitOuterClass(lllllllllllllllllIIlIlIIlllIIllI.outerClass, lllllllllllllllllIIlIlIIlllIIllI.outerMethod, lllllllllllllllllIIlIlIIlllIIllI.outerMethodDesc);
        }
        int lllllllllllllllllIIlIlIIlllIlIII = lllllllllllllllllIIlIlIIlllIIllI.visibleAnnotations == null ? 0 : lllllllllllllllllIIlIlIIlllIIllI.visibleAnnotations.size();
        for (lllllllllllllllllIIlIlIIlllIlIlI = 0; lllllllllllllllllIIlIlIIlllIlIlI < lllllllllllllllllIIlIlIIlllIlIII; ++lllllllllllllllllIIlIlIIlllIlIlI) {
            AnnotationNode lllllllllllllllllIIlIlIIllllIlll = lllllllllllllllllIIlIlIIlllIIllI.visibleAnnotations.get(lllllllllllllllllIIlIlIIlllIlIlI);
            lllllllllllllllllIIlIlIIllllIlll.accept(lllllllllllllllllIIlIlIIlllIlllI.visitAnnotation(lllllllllllllllllIIlIlIIllllIlll.desc, true));
        }
        lllllllllllllllllIIlIlIIlllIlIII = lllllllllllllllllIIlIlIIlllIIllI.invisibleAnnotations == null ? 0 : lllllllllllllllllIIlIlIIlllIIllI.invisibleAnnotations.size();
        for (lllllllllllllllllIIlIlIIlllIlIlI = 0; lllllllllllllllllIIlIlIIlllIlIlI < lllllllllllllllllIIlIlIIlllIlIII; ++lllllllllllllllllIIlIlIIlllIlIlI) {
            AnnotationNode lllllllllllllllllIIlIlIIllllIlIl = lllllllllllllllllIIlIlIIlllIIllI.invisibleAnnotations.get(lllllllllllllllllIIlIlIIlllIlIlI);
            lllllllllllllllllIIlIlIIllllIlIl.accept(lllllllllllllllllIIlIlIIlllIlllI.visitAnnotation(lllllllllllllllllIIlIlIIllllIlIl.desc, false));
        }
        lllllllllllllllllIIlIlIIlllIlIII = lllllllllllllllllIIlIlIIlllIIllI.visibleTypeAnnotations == null ? 0 : lllllllllllllllllIIlIlIIlllIIllI.visibleTypeAnnotations.size();
        for (lllllllllllllllllIIlIlIIlllIlIlI = 0; lllllllllllllllllIIlIlIIlllIlIlI < lllllllllllllllllIIlIlIIlllIlIII; ++lllllllllllllllllIIlIlIIlllIlIlI) {
            TypeAnnotationNode lllllllllllllllllIIlIlIIllllIIll = lllllllllllllllllIIlIlIIlllIIllI.visibleTypeAnnotations.get(lllllllllllllllllIIlIlIIlllIlIlI);
            lllllllllllllllllIIlIlIIllllIIll.accept(lllllllllllllllllIIlIlIIlllIlllI.visitTypeAnnotation(lllllllllllllllllIIlIlIIllllIIll.typeRef, lllllllllllllllllIIlIlIIllllIIll.typePath, lllllllllllllllllIIlIlIIllllIIll.desc, true));
        }
        lllllllllllllllllIIlIlIIlllIlIII = lllllllllllllllllIIlIlIIlllIIllI.invisibleTypeAnnotations == null ? 0 : lllllllllllllllllIIlIlIIlllIIllI.invisibleTypeAnnotations.size();
        for (lllllllllllllllllIIlIlIIlllIlIlI = 0; lllllllllllllllllIIlIlIIlllIlIlI < lllllllllllllllllIIlIlIIlllIlIII; ++lllllllllllllllllIIlIlIIlllIlIlI) {
            TypeAnnotationNode lllllllllllllllllIIlIlIIllllIIlI = lllllllllllllllllIIlIlIIlllIIllI.invisibleTypeAnnotations.get(lllllllllllllllllIIlIlIIlllIlIlI);
            lllllllllllllllllIIlIlIIllllIIlI.accept(lllllllllllllllllIIlIlIIlllIlllI.visitTypeAnnotation(lllllllllllllllllIIlIlIIllllIIlI.typeRef, lllllllllllllllllIIlIlIIllllIIlI.typePath, lllllllllllllllllIIlIlIIllllIIlI.desc, false));
        }
        lllllllllllllllllIIlIlIIlllIlIII = lllllllllllllllllIIlIlIIlllIIllI.attrs == null ? 0 : lllllllllllllllllIIlIlIIlllIIllI.attrs.size();
        for (lllllllllllllllllIIlIlIIlllIlIlI = 0; lllllllllllllllllIIlIlIIlllIlIlI < lllllllllllllllllIIlIlIIlllIlIII; ++lllllllllllllllllIIlIlIIlllIlIlI) {
            lllllllllllllllllIIlIlIIlllIlllI.visitAttribute(lllllllllllllllllIIlIlIIlllIIllI.attrs.get(lllllllllllllllllIIlIlIIlllIlIlI));
        }
        for (lllllllllllllllllIIlIlIIlllIlIlI = 0; lllllllllllllllllIIlIlIIlllIlIlI < lllllllllllllllllIIlIlIIlllIIllI.innerClasses.size(); ++lllllllllllllllllIIlIlIIlllIlIlI) {
            lllllllllllllllllIIlIlIIlllIIllI.innerClasses.get(lllllllllllllllllIIlIlIIlllIlIlI).accept(lllllllllllllllllIIlIlIIlllIlllI);
        }
        for (lllllllllllllllllIIlIlIIlllIlIlI = 0; lllllllllllllllllIIlIlIIlllIlIlI < lllllllllllllllllIIlIlIIlllIIllI.fields.size(); ++lllllllllllllllllIIlIlIIlllIlIlI) {
            lllllllllllllllllIIlIlIIlllIIllI.fields.get(lllllllllllllllllIIlIlIIlllIlIlI).accept(lllllllllllllllllIIlIlIIlllIlllI);
        }
        for (lllllllllllllllllIIlIlIIlllIlIlI = 0; lllllllllllllllllIIlIlIIlllIlIlI < lllllllllllllllllIIlIlIIlllIIllI.methods.size(); ++lllllllllllllllllIIlIlIIlllIlIlI) {
            lllllllllllllllllIIlIlIIlllIIllI.methods.get(lllllllllllllllllIIlIlIIlllIlIlI).accept(lllllllllllllllllIIlIlIIlllIlllI);
        }
        lllllllllllllllllIIlIlIIlllIlllI.visitEnd();
    }

    public void visitInnerClass(String lllllllllllllllllIIlIlIlIllIlIlI, String lllllllllllllllllIIlIlIlIllIllll, String lllllllllllllllllIIlIlIlIllIlllI, int lllllllllllllllllIIlIlIlIllIllIl) {
        ClassNode lllllllllllllllllIIlIlIlIllIlIll;
        InnerClassNode lllllllllllllllllIIlIlIlIllIllII = new InnerClassNode(lllllllllllllllllIIlIlIlIllIlIlI, lllllllllllllllllIIlIlIlIllIllll, lllllllllllllllllIIlIlIlIllIlllI, lllllllllllllllllIIlIlIlIllIllIl);
        lllllllllllllllllIIlIlIlIllIlIll.innerClasses.add(lllllllllllllllllIIlIlIlIllIllII);
    }

    public ClassNode() {
        lllllllllllllllllIIlIlIlllIIllIl(327680);
        ClassNode lllllllllllllllllIIlIlIlllIIllIl;
        if (lllllllllllllllllIIlIlIlllIIllIl.getClass() != ClassNode.class) {
            throw new IllegalStateException();
        }
    }

    public void visitSource(String lllllllllllllllllIIlIlIllIlIlIIl, String lllllllllllllllllIIlIlIllIlIlIll) {
        lllllllllllllllllIIlIlIllIlIllIl.sourceFile = lllllllllllllllllIIlIlIllIlIlIIl;
        lllllllllllllllllIIlIlIllIlIllIl.sourceDebug = lllllllllllllllllIIlIlIllIlIlIll;
    }

    public FieldVisitor visitField(int lllllllllllllllllIIlIlIlIlIlIllI, String lllllllllllllllllIIlIlIlIlIlllII, String lllllllllllllllllIIlIlIlIlIlIlII, String lllllllllllllllllIIlIlIlIlIllIlI, Object lllllllllllllllllIIlIlIlIlIllIIl) {
        ClassNode lllllllllllllllllIIlIlIlIlIllllI;
        FieldNode lllllllllllllllllIIlIlIlIlIllIII = new FieldNode(lllllllllllllllllIIlIlIlIlIlIllI, lllllllllllllllllIIlIlIlIlIlllII, lllllllllllllllllIIlIlIlIlIlIlII, lllllllllllllllllIIlIlIlIlIllIlI, lllllllllllllllllIIlIlIlIlIllIIl);
        lllllllllllllllllIIlIlIlIlIllllI.fields.add(lllllllllllllllllIIlIlIlIlIllIII);
        return lllllllllllllllllIIlIlIlIlIllIII;
    }

    public AnnotationVisitor visitAnnotation(String lllllllllllllllllIIlIlIllIIlIIlI, boolean lllllllllllllllllIIlIlIllIIlIIIl) {
        ClassNode lllllllllllllllllIIlIlIllIIlIIll;
        AnnotationNode lllllllllllllllllIIlIlIllIIlIlII = new AnnotationNode(lllllllllllllllllIIlIlIllIIlIIlI);
        if (lllllllllllllllllIIlIlIllIIlIIIl) {
            if (lllllllllllllllllIIlIlIllIIlIIll.visibleAnnotations == null) {
                lllllllllllllllllIIlIlIllIIlIIll.visibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            lllllllllllllllllIIlIlIllIIlIIll.visibleAnnotations.add(lllllllllllllllllIIlIlIllIIlIlII);
        } else {
            if (lllllllllllllllllIIlIlIllIIlIIll.invisibleAnnotations == null) {
                lllllllllllllllllIIlIlIllIIlIIll.invisibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            lllllllllllllllllIIlIlIllIIlIIll.invisibleAnnotations.add(lllllllllllllllllIIlIlIllIIlIlII);
        }
        return lllllllllllllllllIIlIlIllIIlIlII;
    }

    public MethodVisitor visitMethod(int lllllllllllllllllIIlIlIlIIlllllI, String lllllllllllllllllIIlIlIlIIllllIl, String lllllllllllllllllIIlIlIlIIllllII, String lllllllllllllllllIIlIlIlIlIIIlII, String[] lllllllllllllllllIIlIlIlIIlllIIl) {
        ClassNode lllllllllllllllllIIlIlIlIIllllll;
        MethodNode lllllllllllllllllIIlIlIlIlIIIIIl = new MethodNode(lllllllllllllllllIIlIlIlIIlllllI, lllllllllllllllllIIlIlIlIIllllIl, lllllllllllllllllIIlIlIlIIllllII, lllllllllllllllllIIlIlIlIlIIIlII, lllllllllllllllllIIlIlIlIIlllIIl);
        lllllllllllllllllIIlIlIlIIllllll.methods.add(lllllllllllllllllIIlIlIlIlIIIIIl);
        return lllllllllllllllllIIlIlIlIlIIIIIl;
    }
}

