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
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.FrameNode;
import org.spongepowered.asm.lib.tree.IincInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.IntInsnNode;
import org.spongepowered.asm.lib.tree.InvokeDynamicInsnNode;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.LineNumberNode;
import org.spongepowered.asm.lib.tree.LocalVariableAnnotationNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.lib.tree.LookupSwitchInsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MultiANewArrayInsnNode;
import org.spongepowered.asm.lib.tree.ParameterNode;
import org.spongepowered.asm.lib.tree.TableSwitchInsnNode;
import org.spongepowered.asm.lib.tree.TryCatchBlockNode;
import org.spongepowered.asm.lib.tree.TypeAnnotationNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;

public class MethodNode
extends MethodVisitor {
    public /* synthetic */ List<TypeAnnotationNode> invisibleTypeAnnotations;
    public /* synthetic */ List<LocalVariableAnnotationNode> visibleLocalVariableAnnotations;
    public /* synthetic */ List<AnnotationNode>[] invisibleParameterAnnotations;
    public /* synthetic */ Object annotationDefault;
    public /* synthetic */ List<TypeAnnotationNode> visibleTypeAnnotations;
    public /* synthetic */ List<Attribute> attrs;
    public /* synthetic */ List<ParameterNode> parameters;
    public /* synthetic */ String signature;
    public /* synthetic */ InsnList instructions;
    public /* synthetic */ int access;
    public /* synthetic */ String name;
    public /* synthetic */ List<AnnotationNode>[] visibleParameterAnnotations;
    public /* synthetic */ List<LocalVariableAnnotationNode> invisibleLocalVariableAnnotations;
    public /* synthetic */ List<TryCatchBlockNode> tryCatchBlocks;
    public /* synthetic */ List<LocalVariableNode> localVariables;
    public /* synthetic */ String desc;
    private /* synthetic */ boolean visited;
    public /* synthetic */ List<String> exceptions;
    public /* synthetic */ int maxLocals;
    public /* synthetic */ List<AnnotationNode> invisibleAnnotations;
    public /* synthetic */ int maxStack;
    public /* synthetic */ List<AnnotationNode> visibleAnnotations;

    public void visitCode() {
    }

    public void visitMaxs(int llllllllllllllllIlIlllllIIlIlllI, int llllllllllllllllIlIlllllIIllIIII) {
        llllllllllllllllIlIlllllIIllIIlI.maxStack = llllllllllllllllIlIlllllIIlIlllI;
        llllllllllllllllIlIlllllIIllIIlI.maxLocals = llllllllllllllllIlIlllllIIllIIII;
    }

    public void visitLabel(Label llllllllllllllllIllIIIIIlIlIIlII) {
        MethodNode llllllllllllllllIllIIIIIlIlIlIII;
        llllllllllllllllIllIIIIIlIlIlIII.instructions.add(llllllllllllllllIllIIIIIlIlIlIII.getLabelNode(llllllllllllllllIllIIIIIlIlIIlII));
    }

    public AnnotationVisitor visitParameterAnnotation(int llllllllllllllllIllIIIIlIIlllIll, String llllllllllllllllIllIIIIlIIlllIlI, boolean llllllllllllllllIllIIIIlIIlllIIl) {
        MethodNode llllllllllllllllIllIIIIlIlIIIIIl;
        AnnotationNode llllllllllllllllIllIIIIlIIllllIl = new AnnotationNode(llllllllllllllllIllIIIIlIIlllIlI);
        if (llllllllllllllllIllIIIIlIIlllIIl) {
            if (llllllllllllllllIllIIIIlIlIIIIIl.visibleParameterAnnotations == null) {
                int llllllllllllllllIllIIIIlIlIIIIll = Type.getArgumentTypes(llllllllllllllllIllIIIIlIlIIIIIl.desc).length;
                llllllllllllllllIllIIIIlIlIIIIIl.visibleParameterAnnotations = new List[llllllllllllllllIllIIIIlIlIIIIll];
            }
            if (llllllllllllllllIllIIIIlIlIIIIIl.visibleParameterAnnotations[llllllllllllllllIllIIIIlIIlllIll] == null) {
                llllllllllllllllIllIIIIlIlIIIIIl.visibleParameterAnnotations[llllllllllllllllIllIIIIlIIlllIll] = new ArrayList<AnnotationNode>(1);
            }
            llllllllllllllllIllIIIIlIlIIIIIl.visibleParameterAnnotations[llllllllllllllllIllIIIIlIIlllIll].add(llllllllllllllllIllIIIIlIIllllIl);
        } else {
            if (llllllllllllllllIllIIIIlIlIIIIIl.invisibleParameterAnnotations == null) {
                int llllllllllllllllIllIIIIlIlIIIIlI = Type.getArgumentTypes(llllllllllllllllIllIIIIlIlIIIIIl.desc).length;
                llllllllllllllllIllIIIIlIlIIIIIl.invisibleParameterAnnotations = new List[llllllllllllllllIllIIIIlIlIIIIlI];
            }
            if (llllllllllllllllIllIIIIlIlIIIIIl.invisibleParameterAnnotations[llllllllllllllllIllIIIIlIIlllIll] == null) {
                llllllllllllllllIllIIIIlIlIIIIIl.invisibleParameterAnnotations[llllllllllllllllIllIIIIlIIlllIll] = new ArrayList<AnnotationNode>(1);
            }
            llllllllllllllllIllIIIIlIlIIIIIl.invisibleParameterAnnotations[llllllllllllllllIllIIIIlIIlllIll].add(llllllllllllllllIllIIIIlIIllllIl);
        }
        return llllllllllllllllIllIIIIlIIllllIl;
    }

    public void visitTableSwitchInsn(int llllllllllllllllIllIIIIIIllIIIll, int llllllllllllllllIllIIIIIIlIllIll, Label llllllllllllllllIllIIIIIIllIIIII, Label ... llllllllllllllllIllIIIIIIlIlIlIl) {
        MethodNode llllllllllllllllIllIIIIIIllIIlIl;
        llllllllllllllllIllIIIIIIllIIlIl.instructions.add(new TableSwitchInsnNode(llllllllllllllllIllIIIIIIllIIIll, llllllllllllllllIllIIIIIIlIllIll, llllllllllllllllIllIIIIIIllIIlIl.getLabelNode(llllllllllllllllIllIIIIIIllIIIII), llllllllllllllllIllIIIIIIllIIlIl.getLabelNodes(llllllllllllllllIllIIIIIIlIlIlIl)));
    }

    public void visitIntInsn(int llllllllllllllllIllIIIIlIIIlIIll, int llllllllllllllllIllIIIIlIIIIllll) {
        MethodNode llllllllllllllllIllIIIIlIIIlIIIl;
        llllllllllllllllIllIIIIlIIIlIIIl.instructions.add(new IntInsnNode(llllllllllllllllIllIIIIlIIIlIIll, llllllllllllllllIllIIIIlIIIIllll));
    }

    public void visitMultiANewArrayInsn(String llllllllllllllllIllIIIIIIIlIlIlI, int llllllllllllllllIllIIIIIIIlIlIII) {
        MethodNode llllllllllllllllIllIIIIIIIlIllII;
        llllllllllllllllIllIIIIIIIlIllII.instructions.add(new MultiANewArrayInsnNode(llllllllllllllllIllIIIIIIIlIlIlI, llllllllllllllllIllIIIIIIIlIlIII));
    }

    public void visitTryCatchBlock(Label llllllllllllllllIlIlllllllIlllII, Label llllllllllllllllIlIlllllllIIIIll, Label llllllllllllllllIlIlllllllIlIlll, String llllllllllllllllIlIllllllIllllll) {
        MethodNode llllllllllllllllIlIlllllllIllllI;
        llllllllllllllllIlIlllllllIllllI.tryCatchBlocks.add(new TryCatchBlockNode(llllllllllllllllIlIlllllllIllllI.getLabelNode(llllllllllllllllIlIlllllllIlllII), llllllllllllllllIlIlllllllIllllI.getLabelNode(llllllllllllllllIlIlllllllIIIIll), llllllllllllllllIlIlllllllIllllI.getLabelNode(llllllllllllllllIlIlllllllIlIlll), llllllllllllllllIlIllllllIllllll));
    }

    public void check(int llllllllllllllllIlIllllIlIIllIlI) {
        if (llllllllllllllllIlIllllIlIIllIlI == 262144) {
            MethodNode llllllllllllllllIlIllllIlIIlllIl;
            if (llllllllllllllllIlIllllIlIIlllIl.visibleTypeAnnotations != null && llllllllllllllllIlIllllIlIIlllIl.visibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (llllllllllllllllIlIllllIlIIlllIl.invisibleTypeAnnotations != null && llllllllllllllllIlIllllIlIIlllIl.invisibleTypeAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            int llllllllllllllllIlIllllIlIIllllI = llllllllllllllllIlIllllIlIIlllIl.tryCatchBlocks == null ? 0 : llllllllllllllllIlIllllIlIIlllIl.tryCatchBlocks.size();
            for (int llllllllllllllllIlIllllIlIlIIIlI = 0; llllllllllllllllIlIllllIlIlIIIlI < llllllllllllllllIlIllllIlIIllllI; ++llllllllllllllllIlIllllIlIlIIIlI) {
                TryCatchBlockNode llllllllllllllllIlIllllIlIlIIIll = llllllllllllllllIlIllllIlIIlllIl.tryCatchBlocks.get(llllllllllllllllIlIllllIlIlIIIlI);
                if (llllllllllllllllIlIllllIlIlIIIll.visibleTypeAnnotations != null && llllllllllllllllIlIllllIlIlIIIll.visibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
                if (llllllllllllllllIlIllllIlIlIIIll.invisibleTypeAnnotations == null || llllllllllllllllIlIllllIlIlIIIll.invisibleTypeAnnotations.size() <= 0) continue;
                throw new RuntimeException();
            }
            for (int llllllllllllllllIlIllllIlIIlllll = 0; llllllllllllllllIlIllllIlIIlllll < llllllllllllllllIlIllllIlIIlllIl.instructions.size(); ++llllllllllllllllIlIllllIlIIlllll) {
                boolean llllllllllllllllIlIllllIlIlIIIIl;
                AbstractInsnNode llllllllllllllllIlIllllIlIlIIIII = llllllllllllllllIlIllllIlIIlllIl.instructions.get(llllllllllllllllIlIllllIlIIlllll);
                if (llllllllllllllllIlIllllIlIlIIIII.visibleTypeAnnotations != null && llllllllllllllllIlIllllIlIlIIIII.visibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
                if (llllllllllllllllIlIllllIlIlIIIII.invisibleTypeAnnotations != null && llllllllllllllllIlIllllIlIlIIIII.invisibleTypeAnnotations.size() > 0) {
                    throw new RuntimeException();
                }
                if (!(llllllllllllllllIlIllllIlIlIIIII instanceof MethodInsnNode) || (llllllllllllllllIlIllllIlIlIIIIl = ((MethodInsnNode)llllllllllllllllIlIllllIlIlIIIII).itf) == (llllllllllllllllIlIllllIlIlIIIII.opcode == 185)) continue;
                throw new RuntimeException();
            }
            if (llllllllllllllllIlIllllIlIIlllIl.visibleLocalVariableAnnotations != null && llllllllllllllllIlIllllIlIIlllIl.visibleLocalVariableAnnotations.size() > 0) {
                throw new RuntimeException();
            }
            if (llllllllllllllllIlIllllIlIIlllIl.invisibleLocalVariableAnnotations != null && llllllllllllllllIlIllllIlIIlllIl.invisibleLocalVariableAnnotations.size() > 0) {
                throw new RuntimeException();
            }
        }
    }

    public void visitLookupSwitchInsn(Label llllllllllllllllIllIIIIIIIlllllI, int[] llllllllllllllllIllIIIIIIlIIIlII, Label[] llllllllllllllllIllIIIIIIIlllIlI) {
        MethodNode llllllllllllllllIllIIIIIIlIIIIII;
        llllllllllllllllIllIIIIIIlIIIIII.instructions.add(new LookupSwitchInsnNode(llllllllllllllllIllIIIIIIlIIIIII.getLabelNode(llllllllllllllllIllIIIIIIIlllllI), llllllllllllllllIllIIIIIIlIIIlII, llllllllllllllllIllIIIIIIlIIIIII.getLabelNodes(llllllllllllllllIllIIIIIIIlllIlI)));
    }

    public void visitJumpInsn(int llllllllllllllllIllIIIIIlIllIlII, Label llllllllllllllllIllIIIIIlIllIlll) {
        MethodNode llllllllllllllllIllIIIIIlIlllIlI;
        llllllllllllllllIllIIIIIlIlllIlI.instructions.add(new JumpInsnNode(llllllllllllllllIllIIIIIlIllIlII, llllllllllllllllIllIIIIIlIlllIlI.getLabelNode(llllllllllllllllIllIIIIIlIllIlll)));
    }

    public AnnotationVisitor visitAnnotation(String llllllllllllllllIllIIIIlIlIllllI, boolean llllllllllllllllIllIIIIlIlIlllIl) {
        MethodNode llllllllllllllllIllIIIIlIllIIlIl;
        AnnotationNode llllllllllllllllIllIIIIlIllIIIII = new AnnotationNode(llllllllllllllllIllIIIIlIlIllllI);
        if (llllllllllllllllIllIIIIlIlIlllIl) {
            if (llllllllllllllllIllIIIIlIllIIlIl.visibleAnnotations == null) {
                llllllllllllllllIllIIIIlIllIIlIl.visibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            llllllllllllllllIllIIIIlIllIIlIl.visibleAnnotations.add(llllllllllllllllIllIIIIlIllIIIII);
        } else {
            if (llllllllllllllllIllIIIIlIllIIlIl.invisibleAnnotations == null) {
                llllllllllllllllIllIIIIlIllIIlIl.invisibleAnnotations = new ArrayList<AnnotationNode>(1);
            }
            llllllllllllllllIllIIIIlIllIIlIl.invisibleAnnotations.add(llllllllllllllllIllIIIIlIllIIIII);
        }
        return llllllllllllllllIllIIIIlIllIIIII;
    }

    public void visitTypeInsn(int llllllllllllllllIllIIIIIlllllllI, String llllllllllllllllIllIIIIIllllllIl) {
        MethodNode llllllllllllllllIllIIIIIllllllll;
        llllllllllllllllIllIIIIIllllllll.instructions.add(new TypeInsnNode(llllllllllllllllIllIIIIIlllllllI, llllllllllllllllIllIIIIIllllllIl));
    }

    public void visitParameter(String llllllllllllllllIllIIIIlIllllIll, int llllllllllllllllIllIIIIlIlllllIl) {
        MethodNode llllllllllllllllIllIIIIlIlllllII;
        if (llllllllllllllllIllIIIIlIlllllII.parameters == null) {
            llllllllllllllllIllIIIIlIlllllII.parameters = new ArrayList<ParameterNode>(5);
        }
        llllllllllllllllIllIIIIlIlllllII.parameters.add(new ParameterNode(llllllllllllllllIllIIIIlIllllIll, llllllllllllllllIllIIIIlIlllllIl));
    }

    public AnnotationVisitor visitTryCatchAnnotation(int llllllllllllllllIlIllllllIIlllll, TypePath llllllllllllllllIlIllllllIIlllIl, String llllllllllllllllIlIllllllIIlIIlI, boolean llllllllllllllllIlIllllllIIllIIl) {
        MethodNode llllllllllllllllIlIllllllIlIIIIl;
        TryCatchBlockNode llllllllllllllllIlIllllllIIlIlll = llllllllllllllllIlIllllllIlIIIIl.tryCatchBlocks.get((llllllllllllllllIlIllllllIIlllll & 0xFFFF00) >> 8);
        TypeAnnotationNode llllllllllllllllIlIllllllIIlIllI = new TypeAnnotationNode(llllllllllllllllIlIllllllIIlllll, llllllllllllllllIlIllllllIIlllIl, llllllllllllllllIlIllllllIIlIIlI);
        if (llllllllllllllllIlIllllllIIllIIl) {
            if (llllllllllllllllIlIllllllIIlIlll.visibleTypeAnnotations == null) {
                llllllllllllllllIlIllllllIIlIlll.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            llllllllllllllllIlIllllllIIlIlll.visibleTypeAnnotations.add(llllllllllllllllIlIllllllIIlIllI);
        } else {
            if (llllllllllllllllIlIllllllIIlIlll.invisibleTypeAnnotations == null) {
                llllllllllllllllIlIllllllIIlIlll.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            llllllllllllllllIlIllllllIIlIlll.invisibleTypeAnnotations.add(llllllllllllllllIlIllllllIIlIllI);
        }
        return llllllllllllllllIlIllllllIIlIllI;
    }

    public void visitVarInsn(int llllllllllllllllIllIIIIlIIIIlIlI, int llllllllllllllllIllIIIIlIIIIlIIl) {
        MethodNode llllllllllllllllIllIIIIlIIIIlIII;
        llllllllllllllllIllIIIIlIIIIlIII.instructions.add(new VarInsnNode(llllllllllllllllIllIIIIlIIIIlIlI, llllllllllllllllIllIIIIlIIIIlIIl));
    }

    protected LabelNode getLabelNode(Label llllllllllllllllIlIlllllIIlIlIII) {
        if (!(llllllllllllllllIlIlllllIIlIlIII.info instanceof LabelNode)) {
            llllllllllllllllIlIlllllIIlIlIII.info = new LabelNode();
        }
        return (LabelNode)llllllllllllllllIlIlllllIIlIlIII.info;
    }

    public void visitInsn(int llllllllllllllllIllIIIIlIIIllIlI) {
        MethodNode llllllllllllllllIllIIIIlIIIllIIl;
        llllllllllllllllIllIIIIlIIIllIIl.instructions.add(new InsnNode(llllllllllllllllIllIIIIlIIIllIlI));
    }

    public void accept(MethodVisitor llllllllllllllllIlIllllIIIIlllll) {
        int llllllllllllllllIlIllllIIIlIIIlI;
        MethodNode llllllllllllllllIlIllllIIIlIIIII;
        int llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.parameters == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.parameters.size();
        for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
            ParameterNode llllllllllllllllIlIllllIIIllIIII = llllllllllllllllIlIllllIIIlIIIII.parameters.get(llllllllllllllllIlIllllIIIlIIIlI);
            llllllllllllllllIlIllllIIIIlllll.visitParameter(llllllllllllllllIlIllllIIIllIIII.name, llllllllllllllllIlIllllIIIllIIII.access);
        }
        if (llllllllllllllllIlIllllIIIlIIIII.annotationDefault != null) {
            AnnotationVisitor llllllllllllllllIlIllllIIIlIllll = llllllllllllllllIlIllllIIIIlllll.visitAnnotationDefault();
            AnnotationNode.accept(llllllllllllllllIlIllllIIIlIllll, null, llllllllllllllllIlIllllIIIlIIIII.annotationDefault);
            if (llllllllllllllllIlIllllIIIlIllll != null) {
                llllllllllllllllIlIllllIIIlIllll.visitEnd();
            }
        }
        llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.visibleAnnotations == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.visibleAnnotations.size();
        for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
            AnnotationNode llllllllllllllllIlIllllIIIlIlllI = llllllllllllllllIlIllllIIIlIIIII.visibleAnnotations.get(llllllllllllllllIlIllllIIIlIIIlI);
            llllllllllllllllIlIllllIIIlIlllI.accept(llllllllllllllllIlIllllIIIIlllll.visitAnnotation(llllllllllllllllIlIllllIIIlIlllI.desc, true));
        }
        llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.invisibleAnnotations == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.invisibleAnnotations.size();
        for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
            AnnotationNode llllllllllllllllIlIllllIIIlIllIl = llllllllllllllllIlIllllIIIlIIIII.invisibleAnnotations.get(llllllllllllllllIlIllllIIIlIIIlI);
            llllllllllllllllIlIllllIIIlIllIl.accept(llllllllllllllllIlIllllIIIIlllll.visitAnnotation(llllllllllllllllIlIllllIIIlIllIl.desc, false));
        }
        llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.visibleTypeAnnotations == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.visibleTypeAnnotations.size();
        for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
            TypeAnnotationNode llllllllllllllllIlIllllIIIlIllII = llllllllllllllllIlIllllIIIlIIIII.visibleTypeAnnotations.get(llllllllllllllllIlIllllIIIlIIIlI);
            llllllllllllllllIlIllllIIIlIllII.accept(llllllllllllllllIlIllllIIIIlllll.visitTypeAnnotation(llllllllllllllllIlIllllIIIlIllII.typeRef, llllllllllllllllIlIllllIIIlIllII.typePath, llllllllllllllllIlIllllIIIlIllII.desc, true));
        }
        llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.invisibleTypeAnnotations == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.invisibleTypeAnnotations.size();
        for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
            TypeAnnotationNode llllllllllllllllIlIllllIIIlIlIll = llllllllllllllllIlIllllIIIlIIIII.invisibleTypeAnnotations.get(llllllllllllllllIlIllllIIIlIIIlI);
            llllllllllllllllIlIllllIIIlIlIll.accept(llllllllllllllllIlIllllIIIIlllll.visitTypeAnnotation(llllllllllllllllIlIllllIIIlIlIll.typeRef, llllllllllllllllIlIllllIIIlIlIll.typePath, llllllllllllllllIlIllllIIIlIlIll.desc, false));
        }
        llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.visibleParameterAnnotations == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.visibleParameterAnnotations.length;
        for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
            List<AnnotationNode> llllllllllllllllIlIllllIIIlIlIIl = llllllllllllllllIlIllllIIIlIIIII.visibleParameterAnnotations[llllllllllllllllIlIllllIIIlIIIlI];
            if (llllllllllllllllIlIllllIIIlIlIIl == null) continue;
            for (int llllllllllllllllIlIllllIIIlIlIII = 0; llllllllllllllllIlIllllIIIlIlIII < llllllllllllllllIlIllllIIIlIlIIl.size(); ++llllllllllllllllIlIllllIIIlIlIII) {
                AnnotationNode llllllllllllllllIlIllllIIIlIlIlI = llllllllllllllllIlIllllIIIlIlIIl.get(llllllllllllllllIlIllllIIIlIlIII);
                llllllllllllllllIlIllllIIIlIlIlI.accept(llllllllllllllllIlIllllIIIIlllll.visitParameterAnnotation(llllllllllllllllIlIllllIIIlIIIlI, llllllllllllllllIlIllllIIIlIlIlI.desc, true));
            }
        }
        llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.invisibleParameterAnnotations == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.invisibleParameterAnnotations.length;
        for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
            List<AnnotationNode> llllllllllllllllIlIllllIIIlIIllI = llllllllllllllllIlIllllIIIlIIIII.invisibleParameterAnnotations[llllllllllllllllIlIllllIIIlIIIlI];
            if (llllllllllllllllIlIllllIIIlIIllI == null) continue;
            for (int llllllllllllllllIlIllllIIIlIIlIl = 0; llllllllllllllllIlIllllIIIlIIlIl < llllllllllllllllIlIllllIIIlIIllI.size(); ++llllllllllllllllIlIllllIIIlIIlIl) {
                AnnotationNode llllllllllllllllIlIllllIIIlIIlll = llllllllllllllllIlIllllIIIlIIllI.get(llllllllllllllllIlIllllIIIlIIlIl);
                llllllllllllllllIlIllllIIIlIIlll.accept(llllllllllllllllIlIllllIIIIlllll.visitParameterAnnotation(llllllllllllllllIlIllllIIIlIIIlI, llllllllllllllllIlIllllIIIlIIlll.desc, false));
            }
        }
        if (llllllllllllllllIlIllllIIIlIIIII.visited) {
            llllllllllllllllIlIllllIIIlIIIII.instructions.resetLabels();
        }
        llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.attrs == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.attrs.size();
        for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
            llllllllllllllllIlIllllIIIIlllll.visitAttribute(llllllllllllllllIlIllllIIIlIIIII.attrs.get(llllllllllllllllIlIllllIIIlIIIlI));
        }
        if (llllllllllllllllIlIllllIIIlIIIII.instructions.size() > 0) {
            llllllllllllllllIlIllllIIIIlllll.visitCode();
            llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.tryCatchBlocks == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.tryCatchBlocks.size();
            for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
                llllllllllllllllIlIllllIIIlIIIII.tryCatchBlocks.get(llllllllllllllllIlIllllIIIlIIIlI).updateIndex(llllllllllllllllIlIllllIIIlIIIlI);
                llllllllllllllllIlIllllIIIlIIIII.tryCatchBlocks.get(llllllllllllllllIlIllllIIIlIIIlI).accept(llllllllllllllllIlIllllIIIIlllll);
            }
            llllllllllllllllIlIllllIIIlIIIII.instructions.accept(llllllllllllllllIlIllllIIIIlllll);
            llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.localVariables == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.localVariables.size();
            for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
                llllllllllllllllIlIllllIIIlIIIII.localVariables.get(llllllllllllllllIlIllllIIIlIIIlI).accept(llllllllllllllllIlIllllIIIIlllll);
            }
            llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.visibleLocalVariableAnnotations == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.visibleLocalVariableAnnotations.size();
            for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
                llllllllllllllllIlIllllIIIlIIIII.visibleLocalVariableAnnotations.get(llllllllllllllllIlIllllIIIlIIIlI).accept(llllllllllllllllIlIllllIIIIlllll, true);
            }
            llllllllllllllllIlIllllIIIlIIIIl = llllllllllllllllIlIllllIIIlIIIII.invisibleLocalVariableAnnotations == null ? 0 : llllllllllllllllIlIllllIIIlIIIII.invisibleLocalVariableAnnotations.size();
            for (llllllllllllllllIlIllllIIIlIIIlI = 0; llllllllllllllllIlIllllIIIlIIIlI < llllllllllllllllIlIllllIIIlIIIIl; ++llllllllllllllllIlIllllIIIlIIIlI) {
                llllllllllllllllIlIllllIIIlIIIII.invisibleLocalVariableAnnotations.get(llllllllllllllllIlIllllIIIlIIIlI).accept(llllllllllllllllIlIllllIIIIlllll, false);
            }
            llllllllllllllllIlIllllIIIIlllll.visitMaxs(llllllllllllllllIlIllllIIIlIIIII.maxStack, llllllllllllllllIlIllllIIIlIIIII.maxLocals);
            llllllllllllllllIlIllllIIIlIIIII.visited = true;
        }
        llllllllllllllllIlIllllIIIIlllll.visitEnd();
    }

    public void visitLdcInsn(Object llllllllllllllllIllIIIIIlIIllIII) {
        MethodNode llllllllllllllllIllIIIIIlIIllIlI;
        llllllllllllllllIllIIIIIlIIllIlI.instructions.add(new LdcInsnNode(llllllllllllllllIllIIIIIlIIllIII));
    }

    private Object[] getLabelNodes(Object[] llllllllllllllllIlIlllllIIIIlIll) {
        Object[] llllllllllllllllIlIlllllIIIIlIlI = new Object[llllllllllllllllIlIlllllIIIIlIll.length];
        for (int llllllllllllllllIlIlllllIIIIllIl = 0; llllllllllllllllIlIlllllIIIIllIl < llllllllllllllllIlIlllllIIIIlIll.length; ++llllllllllllllllIlIlllllIIIIllIl) {
            Object llllllllllllllllIlIlllllIIIIlllI = llllllllllllllllIlIlllllIIIIlIll[llllllllllllllllIlIlllllIIIIllIl];
            if (llllllllllllllllIlIlllllIIIIlllI instanceof Label) {
                MethodNode llllllllllllllllIlIlllllIIIIllII;
                llllllllllllllllIlIlllllIIIIlllI = llllllllllllllllIlIlllllIIIIllII.getLabelNode((Label)llllllllllllllllIlIlllllIIIIlllI);
            }
            llllllllllllllllIlIlllllIIIIlIlI[llllllllllllllllIlIlllllIIIIllIl] = llllllllllllllllIlIlllllIIIIlllI;
        }
        return llllllllllllllllIlIlllllIIIIlIlI;
    }

    public MethodNode(int llllllllllllllllIllIIIIllIIIlIIl, int llllllllllllllllIllIIIIllIIIlIII, String llllllllllllllllIllIIIIllIIIIlll, String llllllllllllllllIllIIIIllIIIIllI, String llllllllllllllllIllIIIIllIIIIlIl, String[] llllllllllllllllIllIIIIllIIIllII) {
        super(llllllllllllllllIllIIIIllIIIlIIl);
        boolean llllllllllllllllIllIIIIllIIIlIll;
        MethodNode llllllllllllllllIllIIIIllIIlIIlI;
        llllllllllllllllIllIIIIllIIlIIlI.access = llllllllllllllllIllIIIIllIIIlIII;
        llllllllllllllllIllIIIIllIIlIIlI.name = llllllllllllllllIllIIIIllIIIIlll;
        llllllllllllllllIllIIIIllIIlIIlI.desc = llllllllllllllllIllIIIIllIIIIllI;
        llllllllllllllllIllIIIIllIIlIIlI.signature = llllllllllllllllIllIIIIllIIIIlIl;
        llllllllllllllllIllIIIIllIIlIIlI.exceptions = new ArrayList<String>(llllllllllllllllIllIIIIllIIIllII == null ? 0 : llllllllllllllllIllIIIIllIIIllII.length);
        boolean bl = llllllllllllllllIllIIIIllIIIlIll = (llllllllllllllllIllIIIIllIIIlIII & 0x400) != 0;
        if (!llllllllllllllllIllIIIIllIIIlIll) {
            llllllllllllllllIllIIIIllIIlIIlI.localVariables = new ArrayList<LocalVariableNode>(5);
        }
        llllllllllllllllIllIIIIllIIlIIlI.tryCatchBlocks = new ArrayList<TryCatchBlockNode>();
        if (llllllllllllllllIllIIIIllIIIllII != null) {
            llllllllllllllllIllIIIIllIIlIIlI.exceptions.addAll(Arrays.asList(llllllllllllllllIllIIIIllIIIllII));
        }
        llllllllllllllllIllIIIIllIIlIIlI.instructions = new InsnList();
    }

    public AnnotationVisitor visitTypeAnnotation(int llllllllllllllllIllIIIIlIlIIlllI, TypePath llllllllllllllllIllIIIIlIlIlIIll, String llllllllllllllllIllIIIIlIlIIllII, boolean llllllllllllllllIllIIIIlIlIIlIll) {
        MethodNode llllllllllllllllIllIIIIlIlIIllll;
        TypeAnnotationNode llllllllllllllllIllIIIIlIlIlIIII = new TypeAnnotationNode(llllllllllllllllIllIIIIlIlIIlllI, llllllllllllllllIllIIIIlIlIlIIll, llllllllllllllllIllIIIIlIlIIllII);
        if (llllllllllllllllIllIIIIlIlIIlIll) {
            if (llllllllllllllllIllIIIIlIlIIllll.visibleTypeAnnotations == null) {
                llllllllllllllllIllIIIIlIlIIllll.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            llllllllllllllllIllIIIIlIlIIllll.visibleTypeAnnotations.add(llllllllllllllllIllIIIIlIlIlIIII);
        } else {
            if (llllllllllllllllIllIIIIlIlIIllll.invisibleTypeAnnotations == null) {
                llllllllllllllllIllIIIIlIlIIllll.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            llllllllllllllllIllIIIIlIlIIllll.invisibleTypeAnnotations.add(llllllllllllllllIllIIIIlIlIlIIII);
        }
        return llllllllllllllllIllIIIIlIlIlIIII;
    }

    public void visitAttribute(Attribute llllllllllllllllIllIIIIlIIllIIIl) {
        MethodNode llllllllllllllllIllIIIIlIIllIlII;
        if (llllllllllllllllIllIIIIlIIllIlII.attrs == null) {
            llllllllllllllllIllIIIIlIIllIlII.attrs = new ArrayList<Attribute>(1);
        }
        llllllllllllllllIllIIIIlIIllIlII.attrs.add(llllllllllllllllIllIIIIlIIllIIIl);
    }

    @Deprecated
    public void visitMethodInsn(int llllllllllllllllIllIIIIIlllIIlll, String llllllllllllllllIllIIIIIlllIIIIl, String llllllllllllllllIllIIIIIlllIIIII, String llllllllllllllllIllIIIIIllIlllll) {
        MethodNode llllllllllllllllIllIIIIIlllIlIII;
        if (llllllllllllllllIllIIIIIlllIlIII.api >= 327680) {
            super.visitMethodInsn(llllllllllllllllIllIIIIIlllIIlll, llllllllllllllllIllIIIIIlllIIIIl, llllllllllllllllIllIIIIIlllIIIII, llllllllllllllllIllIIIIIllIlllll);
            return;
        }
        llllllllllllllllIllIIIIIlllIlIII.instructions.add(new MethodInsnNode(llllllllllllllllIllIIIIIlllIIlll, llllllllllllllllIllIIIIIlllIIIIl, llllllllllllllllIllIIIIIlllIIIII, llllllllllllllllIllIIIIIllIlllll));
    }

    public AnnotationVisitor visitAnnotationDefault() {
        MethodNode llllllllllllllllIllIIIIlIllllIII;
        return new AnnotationNode((List<Object>)new ArrayList<Object>(0){
            {
                1 llllllllllllllllllllllllIllllIlI;
                super(llllllllllllllllllllllllIllllIII);
            }

            @Override
            public boolean add(Object llllllllllllllllllllllllIllIllIl) {
                1 llllllllllllllllllllllllIllIllII;
                llllllllllllllllllllllllIllIllII.MethodNode.this.annotationDefault = llllllllllllllllllllllllIllIllIl;
                return super.add(llllllllllllllllllllllllIllIllIl);
            }
        });
    }

    private LabelNode[] getLabelNodes(Label[] llllllllllllllllIlIlllllIIIllllI) {
        LabelNode[] llllllllllllllllIlIlllllIIlIIIII = new LabelNode[llllllllllllllllIlIlllllIIIllllI.length];
        for (int llllllllllllllllIlIlllllIIlIIIll = 0; llllllllllllllllIlIlllllIIlIIIll < llllllllllllllllIlIlllllIIIllllI.length; ++llllllllllllllllIlIlllllIIlIIIll) {
            MethodNode llllllllllllllllIlIlllllIIIlllll;
            llllllllllllllllIlIlllllIIlIIIII[llllllllllllllllIlIlllllIIlIIIll] = llllllllllllllllIlIlllllIIIlllll.getLabelNode(llllllllllllllllIlIlllllIIIllllI[llllllllllllllllIlIlllllIIlIIIll]);
        }
        return llllllllllllllllIlIlllllIIlIIIII;
    }

    public AnnotationVisitor visitInsnAnnotation(int llllllllllllllllIllIIIIIIIIIIlIl, TypePath llllllllllllllllIllIIIIIIIIIIIll, String llllllllllllllllIllIIIIIIIIIIIIl, boolean llllllllllllllllIlIlllllllllIIll) {
        MethodNode llllllllllllllllIllIIIIIIIIIIlll;
        AbstractInsnNode llllllllllllllllIlIlllllllllllIl = llllllllllllllllIllIIIIIIIIIIlll.instructions.getLast();
        while (llllllllllllllllIlIlllllllllllIl.getOpcode() == -1) {
            llllllllllllllllIlIlllllllllllIl = llllllllllllllllIlIlllllllllllIl.getPrevious();
        }
        TypeAnnotationNode llllllllllllllllIlIllllllllllIlI = new TypeAnnotationNode(llllllllllllllllIllIIIIIIIIIIlIl, llllllllllllllllIllIIIIIIIIIIIll, llllllllllllllllIllIIIIIIIIIIIIl);
        if (llllllllllllllllIlIlllllllllIIll) {
            if (llllllllllllllllIlIlllllllllllIl.visibleTypeAnnotations == null) {
                llllllllllllllllIlIlllllllllllIl.visibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            llllllllllllllllIlIlllllllllllIl.visibleTypeAnnotations.add(llllllllllllllllIlIllllllllllIlI);
        } else {
            if (llllllllllllllllIlIlllllllllllIl.invisibleTypeAnnotations == null) {
                llllllllllllllllIlIlllllllllllIl.invisibleTypeAnnotations = new ArrayList<TypeAnnotationNode>(1);
            }
            llllllllllllllllIlIlllllllllllIl.invisibleTypeAnnotations.add(llllllllllllllllIlIllllllllllIlI);
        }
        return llllllllllllllllIlIllllllllllIlI;
    }

    public MethodNode() {
        llllllllllllllllIllIIIIllIllIIll(327680);
        MethodNode llllllllllllllllIllIIIIllIllIIll;
        if (llllllllllllllllIllIIIIllIllIIll.getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public AnnotationVisitor visitLocalVariableAnnotation(int llllllllllllllllIlIlllllIlIlIIlI, TypePath llllllllllllllllIlIlllllIlIIIlIl, Label[] llllllllllllllllIlIlllllIlIIlllI, Label[] llllllllllllllllIlIlllllIlIIllII, int[] llllllllllllllllIlIlllllIlIIlIll, String llllllllllllllllIlIlllllIlIIIIIl, boolean llllllllllllllllIlIlllllIlIIIIII) {
        MethodNode llllllllllllllllIlIlllllIlIlIIll;
        LocalVariableAnnotationNode llllllllllllllllIlIlllllIlIIlIII = new LocalVariableAnnotationNode(llllllllllllllllIlIlllllIlIlIIlI, llllllllllllllllIlIlllllIlIIIlIl, llllllllllllllllIlIlllllIlIlIIll.getLabelNodes(llllllllllllllllIlIlllllIlIIlllI), llllllllllllllllIlIlllllIlIlIIll.getLabelNodes(llllllllllllllllIlIlllllIlIIllII), llllllllllllllllIlIlllllIlIIlIll, llllllllllllllllIlIlllllIlIIIIIl);
        if (llllllllllllllllIlIlllllIlIIIIII) {
            if (llllllllllllllllIlIlllllIlIlIIll.visibleLocalVariableAnnotations == null) {
                llllllllllllllllIlIlllllIlIlIIll.visibleLocalVariableAnnotations = new ArrayList<LocalVariableAnnotationNode>(1);
            }
            llllllllllllllllIlIlllllIlIlIIll.visibleLocalVariableAnnotations.add(llllllllllllllllIlIlllllIlIIlIII);
        } else {
            if (llllllllllllllllIlIlllllIlIlIIll.invisibleLocalVariableAnnotations == null) {
                llllllllllllllllIlIlllllIlIlIIll.invisibleLocalVariableAnnotations = new ArrayList<LocalVariableAnnotationNode>(1);
            }
            llllllllllllllllIlIlllllIlIlIIll.invisibleLocalVariableAnnotations.add(llllllllllllllllIlIlllllIlIIlIII);
        }
        return llllllllllllllllIlIlllllIlIIlIII;
    }

    public MethodNode(int llllllllllllllllIllIIIIllIIlllll, String llllllllllllllllIllIIIIllIlIIlII, String llllllllllllllllIllIIIIllIIlllIl, String llllllllllllllllIllIIIIllIIlllII, String[] llllllllllllllllIllIIIIllIlIIIIl) {
        llllllllllllllllIllIIIIllIlIIIII(327680, llllllllllllllllIllIIIIllIIlllll, llllllllllllllllIllIIIIllIlIIlII, llllllllllllllllIllIIIIllIIlllIl, llllllllllllllllIllIIIIllIIlllII, llllllllllllllllIllIIIIllIlIIIIl);
        MethodNode llllllllllllllllIllIIIIllIlIIIII;
        if (llllllllllllllllIllIIIIllIlIIIII.getClass() != MethodNode.class) {
            throw new IllegalStateException();
        }
    }

    public void visitFrame(int llllllllllllllllIllIIIIlIIlIIIlI, int llllllllllllllllIllIIIIlIIlIIlll, Object[] llllllllllllllllIllIIIIlIIlIIIII, int llllllllllllllllIllIIIIlIIIlllll, Object[] llllllllllllllllIllIIIIlIIlIIlII) {
        MethodNode llllllllllllllllIllIIIIlIIlIIIll;
        llllllllllllllllIllIIIIlIIlIIIll.instructions.add(new FrameNode(llllllllllllllllIllIIIIlIIlIIIlI, llllllllllllllllIllIIIIlIIlIIlll, llllllllllllllllIllIIIIlIIlIIIII == null ? null : llllllllllllllllIllIIIIlIIlIIIll.getLabelNodes(llllllllllllllllIllIIIIlIIlIIIII), llllllllllllllllIllIIIIlIIIlllll, llllllllllllllllIllIIIIlIIlIIlII == null ? null : llllllllllllllllIllIIIIlIIlIIIll.getLabelNodes(llllllllllllllllIllIIIIlIIlIIlII)));
    }

    public void visitIincInsn(int llllllllllllllllIllIIIIIIllllIll, int llllllllllllllllIllIIIIIlIIIIIII) {
        MethodNode llllllllllllllllIllIIIIIlIIIIllI;
        llllllllllllllllIllIIIIIlIIIIllI.instructions.add(new IincInsnNode(llllllllllllllllIllIIIIIIllllIll, llllllllllllllllIllIIIIIlIIIIIII));
    }

    public void visitLocalVariable(String llllllllllllllllIlIlllllIllIlllI, String llllllllllllllllIlIlllllIllllIII, String llllllllllllllllIlIlllllIllIlIlI, Label llllllllllllllllIlIlllllIlllIlIl, Label llllllllllllllllIlIlllllIlllIlII, int llllllllllllllllIlIlllllIllIIllI) {
        MethodNode llllllllllllllllIlIlllllIlllIIII;
        llllllllllllllllIlIlllllIlllIIII.localVariables.add(new LocalVariableNode(llllllllllllllllIlIlllllIllIlllI, llllllllllllllllIlIlllllIllllIII, llllllllllllllllIlIlllllIllIlIlI, llllllllllllllllIlIlllllIlllIIII.getLabelNode(llllllllllllllllIlIlllllIlllIlIl), llllllllllllllllIlIlllllIlllIIII.getLabelNode(llllllllllllllllIlIlllllIlllIlII), llllllllllllllllIlIlllllIllIIllI));
    }

    public void visitLineNumber(int llllllllllllllllIlIlllllIIllIlll, Label llllllllllllllllIlIlllllIIllIllI) {
        MethodNode llllllllllllllllIlIlllllIIlllIll;
        llllllllllllllllIlIlllllIIlllIll.instructions.add(new LineNumberNode(llllllllllllllllIlIlllllIIllIlll, llllllllllllllllIlIlllllIIlllIll.getLabelNode(llllllllllllllllIlIlllllIIllIllI)));
    }

    public void visitEnd() {
    }

    public void visitFieldInsn(int llllllllllllllllIllIIIIIllllIIIl, String llllllllllllllllIllIIIIIllllIlIl, String llllllllllllllllIllIIIIIllllIlII, String llllllllllllllllIllIIIIIlllIlllI) {
        MethodNode llllllllllllllllIllIIIIIllllIIlI;
        llllllllllllllllIllIIIIIllllIIlI.instructions.add(new FieldInsnNode(llllllllllllllllIllIIIIIllllIIIl, llllllllllllllllIllIIIIIllllIlIl, llllllllllllllllIllIIIIIllllIlII, llllllllllllllllIllIIIIIlllIlllI));
    }

    public void accept(ClassVisitor llllllllllllllllIlIllllIlIIlIIII) {
        MethodNode llllllllllllllllIlIllllIlIIlIIIl;
        String[] llllllllllllllllIlIllllIlIIIllll = new String[llllllllllllllllIlIllllIlIIlIIIl.exceptions.size()];
        llllllllllllllllIlIllllIlIIlIIIl.exceptions.toArray(llllllllllllllllIlIllllIlIIIllll);
        MethodVisitor llllllllllllllllIlIllllIlIIIlllI = llllllllllllllllIlIllllIlIIlIIII.visitMethod(llllllllllllllllIlIllllIlIIlIIIl.access, llllllllllllllllIlIllllIlIIlIIIl.name, llllllllllllllllIlIllllIlIIlIIIl.desc, llllllllllllllllIlIllllIlIIlIIIl.signature, llllllllllllllllIlIllllIlIIIllll);
        if (llllllllllllllllIlIllllIlIIIlllI != null) {
            llllllllllllllllIlIllllIlIIlIIIl.accept(llllllllllllllllIlIllllIlIIIlllI);
        }
    }

    public MethodNode(int llllllllllllllllIllIIIIllIlIllIl) {
        super(llllllllllllllllIllIIIIllIlIllIl);
        MethodNode llllllllllllllllIllIIIIllIllIIII;
        llllllllllllllllIllIIIIllIllIIII.instructions = new InsnList();
    }

    public void visitMethodInsn(int llllllllllllllllIllIIIIIllIlIIIl, String llllllllllllllllIllIIIIIllIlIllI, String llllllllllllllllIllIIIIIllIIllll, String llllllllllllllllIllIIIIIllIIlllI, boolean llllllllllllllllIllIIIIIllIlIIll) {
        MethodNode llllllllllllllllIllIIIIIllIllIII;
        if (llllllllllllllllIllIIIIIllIllIII.api < 327680) {
            super.visitMethodInsn(llllllllllllllllIllIIIIIllIlIIIl, llllllllllllllllIllIIIIIllIlIllI, llllllllllllllllIllIIIIIllIIllll, llllllllllllllllIllIIIIIllIIlllI, llllllllllllllllIllIIIIIllIlIIll);
            return;
        }
        llllllllllllllllIllIIIIIllIllIII.instructions.add(new MethodInsnNode(llllllllllllllllIllIIIIIllIlIIIl, llllllllllllllllIllIIIIIllIlIllI, llllllllllllllllIllIIIIIllIIllll, llllllllllllllllIllIIIIIllIIlllI, llllllllllllllllIllIIIIIllIlIIll));
    }

    public void visitInvokeDynamicInsn(String llllllllllllllllIllIIIIIllIIIllI, String llllllllllllllllIllIIIIIllIIIlIl, Handle llllllllllllllllIllIIIIIlIllllll, Object ... llllllllllllllllIllIIIIIllIIIIll) {
        MethodNode llllllllllllllllIllIIIIIllIIIlll;
        llllllllllllllllIllIIIIIllIIIlll.instructions.add(new InvokeDynamicInsnNode(llllllllllllllllIllIIIIIllIIIllI, llllllllllllllllIllIIIIIllIIIlIl, llllllllllllllllIllIIIIIlIllllll, llllllllllllllllIllIIIIIllIIIIll));
    }
}

