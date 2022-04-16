/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Joiner
 *  com.google.common.primitives.Ints
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.util;

import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.FrameNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.IntInsnNode;
import org.spongepowered.asm.lib.tree.JumpInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.LdcInsnNode;
import org.spongepowered.asm.lib.tree.LineNumberNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.lib.util.CheckClassAdapter;
import org.spongepowered.asm.lib.util.TraceClassVisitor;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Intrinsic;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.util.Constants;
import org.spongepowered.asm.util.throwables.SyntheticBridgeException;

public final class Bytecode {
    public static final /* synthetic */ int[] CONSTANTS_FLOAT;
    private static final /* synthetic */ Logger logger;
    public static final /* synthetic */ int[] CONSTANTS_DOUBLE;
    public static final /* synthetic */ int[] CONSTANTS_ALL;
    private static final /* synthetic */ String[] BOXING_TYPES;
    private static final /* synthetic */ String[] CONSTANTS_TYPES;
    public static final /* synthetic */ int[] CONSTANTS_INT;
    private static final /* synthetic */ Object[] CONSTANTS_VALUES;
    private static final /* synthetic */ Class<?>[] MERGEABLE_MIXIN_ANNOTATIONS;
    private static final /* synthetic */ String[] UNBOXING_METHODS;
    public static final /* synthetic */ int[] CONSTANTS_LONG;
    private static /* synthetic */ Pattern mergeableAnnotationPattern;

    public static String getBoxingType(Type lIlIIllIIIIIIIl) {
        return lIlIIllIIIIIIIl == null ? null : BOXING_TYPES[lIlIIllIIIIIIIl.getSort()];
    }

    public static boolean compareFlags(MethodNode lIlIIlllIIlllll, MethodNode lIlIIlllIIllllI, int lIlIIlllIlIIIII) {
        return Bytecode.hasFlag(lIlIIlllIIlllll, lIlIIlllIlIIIII) == Bytecode.hasFlag(lIlIIlllIIllllI, lIlIIlllIlIIIII);
    }

    public static int getFirstNonArgLocalIndex(MethodNode lIlIlIIlllIIllI) {
        return Bytecode.getFirstNonArgLocalIndex(Type.getArgumentTypes(lIlIlIIlllIIllI.desc), (lIlIlIIlllIIllI.access & 8) == 0);
    }

    public static String getDescriptor(Type[] lIlIlIIIIlllIIl, Type lIlIlIIIIlllIII) {
        return String.valueOf(new StringBuilder().append(Bytecode.getDescriptor(lIlIlIIIIlllIIl)).append(lIlIlIIIIlllIII.toString()));
    }

    public static void printMethodWithOpcodeIndices(MethodNode lIlIlIlIlIlllll) {
        System.err.printf("%s%s\n", lIlIlIlIlIlllll.name, lIlIlIlIlIlllll.desc);
        int lIlIlIlIlIllllI = 0;
        ListIterator<AbstractInsnNode> lIlIlIlIllIIIII = lIlIlIlIlIlllll.instructions.iterator();
        while (lIlIlIlIllIIIII.hasNext()) {
            System.err.printf("[%4d] %s\n", lIlIlIlIlIllllI++, Bytecode.describeNode((AbstractInsnNode)lIlIlIlIllIIIII.next()));
        }
    }

    public static Visibility getVisibility(MethodNode lIlIIlllIIIIlII) {
        return Bytecode.getVisibility(lIlIIlllIIIIlII.access & 7);
    }

    private static List<AnnotationNode> mergeAnnotations(List<AnnotationNode> lIlIIlIlIIIIIIl, List<AnnotationNode> lIlIIlIlIIIIlII, String lIlIIlIlIIIIIll, String lIlIIlIIllllllI) {
        try {
            if (lIlIIlIlIIIIIIl == null) {
                return lIlIIlIlIIIIlII;
            }
            if (lIlIIlIlIIIIlII == null) {
                lIlIIlIlIIIIlII = new ArrayList<AnnotationNode>();
            }
            for (AnnotationNode lIlIIlIlIIIIlll : lIlIIlIlIIIIIIl) {
                if (!Bytecode.isMergeableAnnotation(lIlIIlIlIIIIlll)) continue;
                Iterator<AnnotationNode> lIlIIlIlIIIlIII = lIlIIlIlIIIIlII.iterator();
                while (lIlIIlIlIIIlIII.hasNext()) {
                    if (!lIlIIlIlIIIlIII.next().desc.equals(lIlIIlIlIIIIlll.desc)) continue;
                    lIlIIlIlIIIlIII.remove();
                    break;
                }
                lIlIIlIlIIIIlII.add(lIlIIlIlIIIIlll);
            }
        }
        catch (Exception lIlIIlIlIIIIllI) {
            logger.warn("Exception encountered whilst merging annotations for {} {}", new Object[]{lIlIIlIlIIIIIll, lIlIIlIIllllllI});
        }
        return lIlIIlIlIIIIlII;
    }

    public static boolean hasFlag(FieldNode lIlIIlllIllIIII, int lIlIIlllIllIIlI) {
        return (lIlIIlllIllIIII.access & lIlIIlllIllIIlI) == lIlIIlllIllIIlI;
    }

    public static void setVisibility(FieldNode lIlIIllIllIlIIl, Visibility lIlIIllIllIIlII) {
        lIlIIllIllIlIIl.access = Bytecode.setVisibility(lIlIIllIllIlIIl.access, lIlIIllIllIIlII.access);
    }

    private static Visibility getVisibility(int lIlIIllIlllIlll) {
        if ((lIlIIllIlllIlll & 4) != 0) {
            return Visibility.PROTECTED;
        }
        if ((lIlIIllIlllIlll & 2) != 0) {
            return Visibility.PRIVATE;
        }
        if ((lIlIIllIlllIlll & 1) != 0) {
            return Visibility.PUBLIC;
        }
        return Visibility.PACKAGE;
    }

    public static boolean compareFlags(FieldNode lIlIIlllIIlIIIl, FieldNode lIlIIlllIIIllll, int lIlIIlllIIIllIl) {
        return Bytecode.hasFlag(lIlIIlllIIlIIIl, lIlIIlllIIIllIl) == Bytecode.hasFlag(lIlIIlllIIIllll, lIlIIlllIIIllIl);
    }

    public static void setVisibility(FieldNode lIlIIllIlIIIIll, int lIlIIllIlIIIIIl) {
        lIlIIllIlIIIIll.access = Bytecode.setVisibility(lIlIIllIlIIIIll.access, lIlIIllIlIIIIIl);
    }

    public static String getOpcodeName(int lIlIlIlIIIIlIlI) {
        return Bytecode.getOpcodeName(lIlIlIlIIIIlIlI, "UNINITIALIZED_THIS", 1);
    }

    public static void setVisibility(MethodNode lIlIIllIlIlIllI, int lIlIIllIlIlIlIl) {
        lIlIIllIlIlIllI.access = Bytecode.setVisibility(lIlIIllIlIlIllI.access, lIlIIllIlIlIlIl);
    }

    public static Type getConstantType(AbstractInsnNode lIlIIlllllIIlII) {
        if (lIlIIlllllIIlII == null) {
            return null;
        }
        if (lIlIIlllllIIlII instanceof LdcInsnNode) {
            Object lIlIIlllllIllII = ((LdcInsnNode)lIlIIlllllIIlII).cst;
            if (lIlIIlllllIllII instanceof Integer) {
                return Type.getType("I");
            }
            if (lIlIIlllllIllII instanceof Float) {
                return Type.getType("F");
            }
            if (lIlIIlllllIllII instanceof Long) {
                return Type.getType("J");
            }
            if (lIlIIlllllIllII instanceof Double) {
                return Type.getType("D");
            }
            if (lIlIIlllllIllII instanceof String) {
                return Type.getType("Ljava/lang/String;");
            }
            if (lIlIIlllllIllII instanceof Type) {
                return Type.getType("Ljava/lang/Class;");
            }
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("LdcInsnNode with invalid payload type ").append(lIlIIlllllIllII.getClass()).append(" in getConstant")));
        }
        int lIlIIlllllIIlll = Ints.indexOf((int[])CONSTANTS_ALL, (int)lIlIIlllllIIlII.getOpcode());
        return lIlIIlllllIIlll < 0 ? null : Type.getType(CONSTANTS_TYPES[lIlIIlllllIIlll]);
    }

    public static void textify(MethodNode lIlIlIllIIIIlIl, OutputStream lIlIlIllIIIlIII) {
        TraceClassVisitor lIlIlIllIIIIlll = new TraceClassVisitor(new PrintWriter(lIlIlIllIIIlIII));
        MethodVisitor lIlIlIllIIIIllI = lIlIlIllIIIIlll.visitMethod(lIlIlIllIIIIlIl.access, lIlIlIllIIIIlIl.name, lIlIlIllIIIIlIl.desc, lIlIlIllIIIIlIl.signature, lIlIlIllIIIIlIl.exceptions.toArray(new String[0]));
        lIlIlIllIIIIlIl.accept(lIlIlIllIIIIllI);
        lIlIlIllIIIIlll.visitEnd();
    }

    public static Map<LabelNode, LabelNode> cloneLabels(InsnList lIlIlIIIlllllIl) {
        HashMap<LabelNode, LabelNode> lIlIlIIIlllllII = new HashMap<LabelNode, LabelNode>();
        ListIterator<AbstractInsnNode> lIlIlIIlIIIIIII = lIlIlIIIlllllIl.iterator();
        while (lIlIlIIlIIIIIII.hasNext()) {
            AbstractInsnNode lIlIlIIlIIIIIlI = (AbstractInsnNode)lIlIlIIlIIIIIII.next();
            if (!(lIlIlIIlIIIIIlI instanceof LabelNode)) continue;
            lIlIlIIIlllllII.put((LabelNode)lIlIlIIlIIIIIlI, new LabelNode(((LabelNode)lIlIlIIlIIIIIlI).getLabel()));
        }
        return lIlIlIIIlllllII;
    }

    private static Pattern getMergeableAnnotationPattern() {
        StringBuilder lIlIIlIIlIlllII = new StringBuilder("^L(");
        for (int lIlIIlIIlIlllIl = 0; lIlIIlIIlIlllIl < MERGEABLE_MIXIN_ANNOTATIONS.length; ++lIlIIlIIlIlllIl) {
            if (lIlIIlIIlIlllIl > 0) {
                lIlIIlIIlIlllII.append('|');
            }
            lIlIIlIIlIlllII.append(MERGEABLE_MIXIN_ANNOTATIONS[lIlIIlIIlIlllIl].getName().replace('.', '/'));
        }
        return Pattern.compile(String.valueOf(lIlIIlIIlIlllII.append(");$")));
    }

    public static AbstractInsnNode findInsn(MethodNode lIlIlIlllIllIIl, int lIlIlIlllIllIll) {
        ListIterator<AbstractInsnNode> lIlIlIlllIllIlI = lIlIlIlllIllIIl.instructions.iterator();
        while (lIlIlIlllIllIlI.hasNext()) {
            AbstractInsnNode lIlIlIlllIlllIl = (AbstractInsnNode)lIlIlIlllIllIlI.next();
            if (lIlIlIlllIlllIl.getOpcode() != lIlIlIlllIllIll) continue;
            return lIlIlIlllIlllIl;
        }
        return null;
    }

    public static void mergeAnnotations(ClassNode lIlIIlIllIIlllI, ClassNode lIlIIlIllIIlIII) {
        lIlIIlIllIIlIII.visibleAnnotations = Bytecode.mergeAnnotations(lIlIIlIllIIlllI.visibleAnnotations, lIlIIlIllIIlIII.visibleAnnotations, "class", lIlIIlIllIIlllI.name);
        lIlIIlIllIIlIII.invisibleAnnotations = Bytecode.mergeAnnotations(lIlIIlIllIIlllI.invisibleAnnotations, lIlIIlIllIIlIII.invisibleAnnotations, "class", lIlIIlIllIIlllI.name);
    }

    public static void printMethod(MethodNode lIlIlIlIlIIllIl) {
        System.err.printf("%s%s\n", lIlIlIlIlIIllIl.name, lIlIlIlIlIIllIl.desc);
        ListIterator<AbstractInsnNode> lIlIlIlIlIIlllI = lIlIlIlIlIIllIl.instructions.iterator();
        while (lIlIlIlIlIIlllI.hasNext()) {
            System.err.print("  ");
            Bytecode.printNode((AbstractInsnNode)lIlIlIlIlIIlllI.next());
        }
    }

    public static String getDescriptor(Type[] lIlIlIIIlIIIIlI) {
        return String.valueOf(new StringBuilder().append("(").append(Joiner.on((String)"").join((Object[])lIlIlIIIlIIIIlI)).append(")"));
    }

    public static String getSimpleName(Class<? extends Annotation> lIlIlIIIIlIIlII) {
        return lIlIlIIIIlIIlII.getSimpleName();
    }

    public static void loadArgs(Type[] lIlIlIIlIllllII, InsnList lIlIlIIlIlllIll, int lIlIlIIlIlllIlI, int lIlIlIIlIllllIl) {
        Bytecode.loadArgs(lIlIlIIlIllllII, lIlIlIIlIlllIll, lIlIlIIlIlllIlI, lIlIlIIlIllllIl, null);
    }

    public static int getFirstNonArgLocalIndex(Type[] lIlIlIIlllIIIll, boolean lIlIlIIlllIIIII) {
        return Bytecode.getArgsSize(lIlIlIIlllIIIll) + (lIlIlIIlllIIIII ? 1 : 0);
    }

    public static boolean fieldIsStatic(FieldNode lIlIlIIlllIlIlI) {
        return (lIlIlIIlllIlIlI.access & 8) == 8;
    }

    private static String toDescriptor(Object lIlIlIIIlIIIlII) {
        if (lIlIlIIIlIIIlII instanceof String) {
            return (String)lIlIlIIIlIIIlII;
        }
        if (lIlIlIIIlIIIlII instanceof Type) {
            return lIlIlIIIlIIIlII.toString();
        }
        if (lIlIlIIIlIIIlII instanceof Class) {
            return Type.getDescriptor((Class)lIlIlIIIlIIIlII);
        }
        return lIlIlIIIlIIIlII == null ? "" : lIlIlIIIlIIIlII.toString();
    }

    public static String getOpcodeName(AbstractInsnNode lIlIlIlIIIlIlll) {
        return lIlIlIlIIIlIlll != null ? Bytecode.getOpcodeName(lIlIlIlIIIlIlll.getOpcode()) : "";
    }

    private static String getOpcodeName(int lIlIlIIllllllll, String lIlIlIIlllllllI, int lIlIlIIlllllIlI) {
        if (lIlIlIIllllllll >= lIlIlIIlllllIlI) {
            boolean lIlIlIlIIIIIIII = false;
            try {
                for (Field lIlIlIlIIIIIIIl : Opcodes.class.getDeclaredFields()) {
                    if (!lIlIlIlIIIIIIII && !lIlIlIlIIIIIIIl.getName().equals(lIlIlIIlllllllI)) continue;
                    lIlIlIlIIIIIIII = true;
                    if (lIlIlIlIIIIIIIl.getType() != Integer.TYPE || lIlIlIlIIIIIIIl.getInt(null) != lIlIlIIllllllll) continue;
                    return lIlIlIlIIIIIIIl.getName();
                }
            }
            catch (Exception lIlIlIIlllllIII) {
                // empty catch block
            }
        }
        return lIlIlIIllllllll >= 0 ? String.valueOf(lIlIlIIllllllll) : "UNKNOWN";
    }

    public static MethodInsnNode findSuperInit(MethodNode lIlIlIllIllIIII, String lIlIlIllIllIIll) {
        if (!"<init>".equals(lIlIlIllIllIIII.name)) {
            return null;
        }
        int lIlIlIllIllIIlI = 0;
        ListIterator<AbstractInsnNode> lIlIlIllIllIllI = lIlIlIllIllIIII.instructions.iterator();
        while (lIlIlIllIllIllI.hasNext()) {
            AbstractInsnNode lIlIlIllIlllIII = (AbstractInsnNode)lIlIlIllIllIllI.next();
            if (lIlIlIllIlllIII instanceof TypeInsnNode && lIlIlIllIlllIII.getOpcode() == 187) {
                ++lIlIlIllIllIIlI;
                continue;
            }
            if (!(lIlIlIllIlllIII instanceof MethodInsnNode) || lIlIlIllIlllIII.getOpcode() != 183) continue;
            MethodInsnNode lIlIlIllIlllIIl = (MethodInsnNode)lIlIlIllIlllIII;
            if (!"<init>".equals(lIlIlIllIlllIIl.name)) continue;
            if (lIlIlIllIllIIlI > 0) {
                --lIlIlIllIllIIlI;
                continue;
            }
            if (!lIlIlIllIlllIIl.owner.equals(lIlIlIllIllIIll)) continue;
            return lIlIlIllIlllIIl;
        }
        return null;
    }

    public static int getMaxLineNumber(ClassNode lIlIIllIIIllIlI, int lIlIIllIIIllIIl, int lIlIIllIIIlIlII) {
        int lIlIIllIIIlIlll = 0;
        for (MethodNode lIlIIllIIIllIll : lIlIIllIIIllIlI.methods) {
            ListIterator<AbstractInsnNode> lIlIIllIIIlllII = lIlIIllIIIllIll.instructions.iterator();
            while (lIlIIllIIIlllII.hasNext()) {
                AbstractInsnNode lIlIIllIIIllllI = (AbstractInsnNode)lIlIIllIIIlllII.next();
                if (!(lIlIIllIIIllllI instanceof LineNumberNode)) continue;
                lIlIIllIIIlIlll = Math.max(lIlIIllIIIlIlll, ((LineNumberNode)lIlIIllIIIllllI).line);
            }
        }
        return Math.max(lIlIIllIIIllIIl, lIlIIllIIIlIlll + lIlIIllIIIlIlII);
    }

    static {
        CONSTANTS_INT = new int[]{2, 3, 4, 5, 6, 7, 8};
        CONSTANTS_FLOAT = new int[]{11, 12, 13};
        CONSTANTS_DOUBLE = new int[]{14, 15};
        CONSTANTS_LONG = new int[]{9, 10};
        CONSTANTS_ALL = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        CONSTANTS_VALUES = new Object[]{null, -1, 0, 1, 2, 3, 4, 5, 0L, 1L, Float.valueOf(0.0f), Float.valueOf(1.0f), Float.valueOf(2.0f), 0.0, 1.0};
        CONSTANTS_TYPES = new String[]{null, "I", "I", "I", "I", "I", "I", "I", "J", "J", "F", "F", "F", "D", "D", "I", "I"};
        BOXING_TYPES = new String[]{null, "java/lang/Boolean", "java/lang/Character", "java/lang/Byte", "java/lang/Short", "java/lang/Integer", "java/lang/Float", "java/lang/Long", "java/lang/Double", null, null, null};
        UNBOXING_METHODS = new String[]{null, "booleanValue", "charValue", "byteValue", "shortValue", "intValue", "floatValue", "longValue", "doubleValue", null, null, null};
        MERGEABLE_MIXIN_ANNOTATIONS = new Class[]{Overwrite.class, Intrinsic.class, Final.class, Debug.class};
        mergeableAnnotationPattern = Bytecode.getMergeableAnnotationPattern();
        logger = LogManager.getLogger((String)"mixin");
    }

    public static boolean hasFlag(ClassNode lIlIIllllIlIIll, int lIlIIllllIlIIII) {
        return (lIlIIllllIlIIll.access & lIlIIllllIlIIII) == lIlIIllllIlIIII;
    }

    public static Visibility getVisibility(FieldNode lIlIIlllIIIIIIl) {
        return Bytecode.getVisibility(lIlIIlllIIIIIIl.access & 7);
    }

    public static void setVisibility(MethodNode lIlIIllIllIllll, Visibility lIlIIllIllIlllI) {
        lIlIIllIllIllll.access = Bytecode.setVisibility(lIlIIllIllIllll.access, lIlIIllIllIlllI.access);
    }

    public static String describeNode(AbstractInsnNode lIlIlIlIIlIIlII) {
        if (lIlIlIlIIlIIlII == null) {
            return String.format("   %-14s ", "null");
        }
        if (lIlIlIlIIlIIlII instanceof LabelNode) {
            return String.format("[%s]", ((LabelNode)lIlIlIlIIlIIlII).getLabel());
        }
        String lIlIlIlIIlIIlIl = String.format("   %-14s ", lIlIlIlIIlIIlII.getClass().getSimpleName().replace("Node", ""));
        if (lIlIlIlIIlIIlII instanceof JumpInsnNode) {
            lIlIlIlIIlIIlIl = String.valueOf(new StringBuilder().append(lIlIlIlIIlIIlIl).append(String.format("[%s] [%s]", Bytecode.getOpcodeName(lIlIlIlIIlIIlII), ((JumpInsnNode)lIlIlIlIIlIIlII).label.getLabel())));
        } else if (lIlIlIlIIlIIlII instanceof VarInsnNode) {
            lIlIlIlIIlIIlIl = String.valueOf(new StringBuilder().append(lIlIlIlIIlIIlIl).append(String.format("[%s] %d", Bytecode.getOpcodeName(lIlIlIlIIlIIlII), ((VarInsnNode)lIlIlIlIIlIIlII).var)));
        } else if (lIlIlIlIIlIIlII instanceof MethodInsnNode) {
            MethodInsnNode lIlIlIlIIlIlIIl = (MethodInsnNode)lIlIlIlIIlIIlII;
            lIlIlIlIIlIIlIl = String.valueOf(new StringBuilder().append(lIlIlIlIIlIIlIl).append(String.format("[%s] %s %s %s", Bytecode.getOpcodeName(lIlIlIlIIlIIlII), lIlIlIlIIlIlIIl.owner, lIlIlIlIIlIlIIl.name, lIlIlIlIIlIlIIl.desc)));
        } else if (lIlIlIlIIlIIlII instanceof FieldInsnNode) {
            FieldInsnNode lIlIlIlIIlIlIII = (FieldInsnNode)lIlIlIlIIlIIlII;
            lIlIlIlIIlIIlIl = String.valueOf(new StringBuilder().append(lIlIlIlIIlIIlIl).append(String.format("[%s] %s %s %s", Bytecode.getOpcodeName(lIlIlIlIIlIIlII), lIlIlIlIIlIlIII.owner, lIlIlIlIIlIlIII.name, lIlIlIlIIlIlIII.desc)));
        } else if (lIlIlIlIIlIIlII instanceof LineNumberNode) {
            LineNumberNode lIlIlIlIIlIIlll = (LineNumberNode)lIlIlIlIIlIIlII;
            lIlIlIlIIlIIlIl = String.valueOf(new StringBuilder().append(lIlIlIlIIlIIlIl).append(String.format("LINE=[%d] LABEL=[%s]", lIlIlIlIIlIIlll.line, lIlIlIlIIlIIlll.start.getLabel())));
        } else {
            lIlIlIlIIlIIlIl = lIlIlIlIIlIIlII instanceof LdcInsnNode ? String.valueOf(new StringBuilder().append(lIlIlIlIIlIIlIl).append(((LdcInsnNode)lIlIlIlIIlIIlII).cst)) : (lIlIlIlIIlIIlII instanceof IntInsnNode ? String.valueOf(new StringBuilder().append(lIlIlIlIIlIIlIl).append(((IntInsnNode)lIlIlIlIIlIIlII).operand)) : (lIlIlIlIIlIIlII instanceof FrameNode ? String.valueOf(new StringBuilder().append(lIlIlIlIIlIIlIl).append(String.format("[%s] ", Bytecode.getOpcodeName(((FrameNode)lIlIlIlIIlIIlII).type, "H_INVOKEINTERFACE", -1)))) : String.valueOf(new StringBuilder().append(lIlIlIlIIlIIlIl).append(String.format("[%s] ", Bytecode.getOpcodeName(lIlIlIlIIlIIlII))))));
        }
        return lIlIlIlIIlIIlIl;
    }

    public static boolean hasFlag(MethodNode lIlIIllllIIIIIl, int lIlIIlllIlllllI) {
        return (lIlIIllllIIIIIl.access & lIlIIlllIlllllI) == lIlIIlllIlllllI;
    }

    public static void textify(ClassNode lIlIlIllIIllllI, OutputStream lIlIlIllIIlllll) {
        lIlIlIllIIllllI.accept(new TraceClassVisitor(new PrintWriter(lIlIlIllIIlllll)));
    }

    public static String getSimpleName(String lIlIlIIIIIIIIIl) {
        int lIlIlIIIIIIIIlI = Math.max(lIlIlIIIIIIIIIl.lastIndexOf(47), 0);
        return lIlIlIIIIIIIIIl.substring(lIlIlIIIIIIIIlI + 1).replace(";", "");
    }

    public static void mergeAnnotations(MethodNode lIlIIlIlIllIIII, MethodNode lIlIIlIlIlIlllI) {
        lIlIIlIlIlIlllI.visibleAnnotations = Bytecode.mergeAnnotations(lIlIIlIlIllIIII.visibleAnnotations, lIlIIlIlIlIlllI.visibleAnnotations, "method", lIlIIlIlIllIIII.name);
        lIlIIlIlIlIlllI.invisibleAnnotations = Bytecode.mergeAnnotations(lIlIIlIlIllIIII.invisibleAnnotations, lIlIIlIlIlIlllI.invisibleAnnotations, "method", lIlIIlIlIllIIII.name);
    }

    private static int setVisibility(int lIlIIllIIlllllI, int lIlIIllIIlllIll) {
        return lIlIIllIIlllllI & 0xFFFFFFF8 | lIlIIllIIlllIll & 7;
    }

    public static void compareBridgeMethods(MethodNode lIlIIlIIIIIlIII, MethodNode lIlIIlIIIIIIlll) {
        ListIterator<AbstractInsnNode> lIlIIlIIIIIIlIl = lIlIIlIIIIIlIII.instructions.iterator();
        ListIterator<AbstractInsnNode> lIlIIlIIIIIIlII = lIlIIlIIIIIIlll.instructions.iterator();
        int lIlIIlIIIIIIIll = 0;
        while (lIlIIlIIIIIIlIl.hasNext() && lIlIIlIIIIIIlII.hasNext()) {
            AbstractInsnNode lIlIIlIIIIIlIll = lIlIIlIIIIIIlIl.next();
            AbstractInsnNode lIlIIlIIIIIlIIl = lIlIIlIIIIIIlII.next();
            if (!(lIlIIlIIIIIlIll instanceof LabelNode)) {
                if (lIlIIlIIIIIlIll instanceof MethodInsnNode) {
                    MethodInsnNode lIlIIlIIIIlIIIl = (MethodInsnNode)lIlIIlIIIIIlIll;
                    MethodInsnNode lIlIIlIIIIlIIII = (MethodInsnNode)lIlIIlIIIIIlIIl;
                    if (!lIlIIlIIIIlIIIl.name.equals(lIlIIlIIIIlIIII.name)) {
                        throw new SyntheticBridgeException(SyntheticBridgeException.Problem.BAD_INVOKE_NAME, lIlIIlIIIIIlIII.name, lIlIIlIIIIIlIII.desc, lIlIIlIIIIIIIll, lIlIIlIIIIIlIll, lIlIIlIIIIIlIIl);
                    }
                    if (!lIlIIlIIIIlIIIl.desc.equals(lIlIIlIIIIlIIII.desc)) {
                        throw new SyntheticBridgeException(SyntheticBridgeException.Problem.BAD_INVOKE_DESC, lIlIIlIIIIIlIII.name, lIlIIlIIIIIlIII.desc, lIlIIlIIIIIIIll, lIlIIlIIIIIlIll, lIlIIlIIIIIlIIl);
                    }
                } else {
                    if (lIlIIlIIIIIlIll.getOpcode() != lIlIIlIIIIIlIIl.getOpcode()) {
                        throw new SyntheticBridgeException(SyntheticBridgeException.Problem.BAD_INSN, lIlIIlIIIIIlIII.name, lIlIIlIIIIIlIII.desc, lIlIIlIIIIIIIll, lIlIIlIIIIIlIll, lIlIIlIIIIIlIIl);
                    }
                    if (lIlIIlIIIIIlIll instanceof VarInsnNode) {
                        VarInsnNode lIlIIlIIIIIllll = (VarInsnNode)lIlIIlIIIIIlIll;
                        VarInsnNode lIlIIlIIIIIlllI = (VarInsnNode)lIlIIlIIIIIlIIl;
                        if (lIlIIlIIIIIllll.var != lIlIIlIIIIIlllI.var) {
                            throw new SyntheticBridgeException(SyntheticBridgeException.Problem.BAD_LOAD, lIlIIlIIIIIlIII.name, lIlIIlIIIIIlIII.desc, lIlIIlIIIIIIIll, lIlIIlIIIIIlIll, lIlIIlIIIIIlIIl);
                        }
                    } else if (lIlIIlIIIIIlIll instanceof TypeInsnNode) {
                        TypeInsnNode lIlIIlIIIIIllIl = (TypeInsnNode)lIlIIlIIIIIlIll;
                        TypeInsnNode lIlIIlIIIIIllII = (TypeInsnNode)lIlIIlIIIIIlIIl;
                        if (lIlIIlIIIIIllIl.getOpcode() == 192 && !lIlIIlIIIIIllIl.desc.equals(lIlIIlIIIIIllII.desc)) {
                            throw new SyntheticBridgeException(SyntheticBridgeException.Problem.BAD_CAST, lIlIIlIIIIIlIII.name, lIlIIlIIIIIlIII.desc, lIlIIlIIIIIIIll, lIlIIlIIIIIlIll, lIlIIlIIIIIlIIl);
                        }
                    }
                }
            }
            ++lIlIIlIIIIIIIll;
        }
        if (lIlIIlIIIIIIlIl.hasNext() || lIlIIlIIIIIIlII.hasNext()) {
            throw new SyntheticBridgeException(SyntheticBridgeException.Problem.BAD_LENGTH, lIlIIlIIIIIlIII.name, lIlIIlIIIIIlIII.desc, lIlIIlIIIIIIIll, null, null);
        }
    }

    public static boolean methodIsStatic(MethodNode lIlIlIIlllIllIl) {
        return (lIlIlIIlllIllIl.access & 8) == 8;
    }

    public static Object getConstant(AbstractInsnNode lIlIIllllllIIlI) {
        if (lIlIIllllllIIlI == null) {
            return null;
        }
        if (lIlIIllllllIIlI instanceof LdcInsnNode) {
            return ((LdcInsnNode)lIlIIllllllIIlI).cst;
        }
        if (lIlIIllllllIIlI instanceof IntInsnNode) {
            int lIlIIllllllIIll = ((IntInsnNode)lIlIIllllllIIlI).operand;
            if (lIlIIllllllIIlI.getOpcode() == 16 || lIlIIllllllIIlI.getOpcode() == 17) {
                return lIlIIllllllIIll;
            }
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("IntInsnNode with invalid opcode ").append(lIlIIllllllIIlI.getOpcode()).append(" in getConstant")));
        }
        int lIlIIllllllIIIl = Ints.indexOf((int[])CONSTANTS_ALL, (int)lIlIIllllllIIlI.getOpcode());
        return lIlIIllllllIIIl < 0 ? null : CONSTANTS_VALUES[lIlIIllllllIIIl];
    }

    public static MethodNode findMethod(ClassNode lIlIlIllllIlIIl, String lIlIlIllllIlIII, String lIlIlIllllIIlII) {
        for (MethodNode lIlIlIllllIlIlI : lIlIlIllllIlIIl.methods) {
            if (!lIlIlIllllIlIlI.name.equals(lIlIlIllllIlIII) || !lIlIlIllllIlIlI.desc.equals(lIlIlIllllIIlII)) continue;
            return lIlIlIllllIlIlI;
        }
        return null;
    }

    public static void mergeAnnotations(FieldNode lIlIIlIlIlIIIII, FieldNode lIlIIlIlIIlllll) {
        lIlIIlIlIIlllll.visibleAnnotations = Bytecode.mergeAnnotations(lIlIIlIlIlIIIII.visibleAnnotations, lIlIIlIlIIlllll.visibleAnnotations, "field", lIlIIlIlIlIIIII.name);
        lIlIIlIlIIlllll.invisibleAnnotations = Bytecode.mergeAnnotations(lIlIIlIlIlIIIII.invisibleAnnotations, lIlIIlIlIIlllll.invisibleAnnotations, "field", lIlIIlIlIlIIIII.name);
    }

    public static int getArgsSize(Type[] lIlIlIIllIllIII) {
        int lIlIlIIllIlIlll = 0;
        for (Type lIlIlIIllIllIIl : lIlIlIIllIllIII) {
            lIlIlIIllIlIlll += lIlIlIIllIllIIl.getSize();
        }
        return lIlIlIIllIlIlll;
    }

    private Bytecode() {
        Bytecode lIlIlIlllllIIII;
    }

    public static void loadArgs(Type[] lIlIlIIlIIlllII, InsnList lIlIlIIlIIllIll, int lIlIlIIlIlIIIIl, int lIlIlIIlIIllIII, Type[] lIlIlIIlIIlIlll) {
        int lIlIlIIlIIllllI = lIlIlIIlIlIIIIl;
        int lIlIlIIlIIlllIl = 0;
        for (Type lIlIlIIlIlIIlII : lIlIlIIlIIlllII) {
            lIlIlIIlIIllIll.add(new VarInsnNode(lIlIlIIlIlIIlII.getOpcode(21), lIlIlIIlIIllllI));
            if (lIlIlIIlIIlIlll != null && lIlIlIIlIIlllIl < lIlIlIIlIIlIlll.length && lIlIlIIlIIlIlll[lIlIlIIlIIlllIl] != null) {
                lIlIlIIlIIllIll.add(new TypeInsnNode(192, lIlIlIIlIIlIlll[lIlIlIIlIIlllIl].getInternalName()));
            }
            if (lIlIlIIlIIllIII >= lIlIlIIlIlIIIIl && (lIlIlIIlIIllllI += lIlIlIIlIlIIlII.getSize()) >= lIlIlIIlIIllIII) {
                return;
            }
            ++lIlIlIIlIIlllIl;
        }
    }

    public static String getSimpleName(AnnotationNode lIlIlIIIIIllIll) {
        return Bytecode.getSimpleName(lIlIlIIIIIllIll.desc);
    }

    public static boolean methodHasLineNumbers(MethodNode lIlIlIIllllIIIl) {
        ListIterator<AbstractInsnNode> lIlIlIIllllIIlI = lIlIlIIllllIIIl.instructions.iterator();
        while (lIlIlIIllllIIlI.hasNext()) {
            if (!(lIlIlIIllllIIlI.next() instanceof LineNumberNode)) continue;
            return true;
        }
        return false;
    }

    public static void dumpClass(ClassNode lIlIlIlIllllIll) {
        ClassWriter lIlIlIlIlllllII = new ClassWriter(3);
        lIlIlIlIllllIll.accept(lIlIlIlIlllllII);
        Bytecode.dumpClass(lIlIlIlIlllllII.toByteArray());
    }

    public static void dumpClass(byte[] lIlIlIlIllIIlll) {
        ClassReader lIlIlIlIllIIllI = new ClassReader(lIlIlIlIllIIlll);
        CheckClassAdapter.verify(lIlIlIlIllIIllI, true, new PrintWriter(System.out));
    }

    public static String generateDescriptor(Object lIlIlIIIlIlIlII, Object ... lIlIlIIIlIlIIlI) {
        StringBuilder lIlIlIIIlIlIIIl = new StringBuilder().append('(');
        for (Object lIlIlIIIlIlIlIl : lIlIlIIIlIlIIlI) {
            lIlIlIIIlIlIIIl.append(Bytecode.toDescriptor(lIlIlIIIlIlIlIl));
        }
        return String.valueOf(lIlIlIIIlIlIIIl.append(')').append(lIlIlIIIlIlIlII != null ? Bytecode.toDescriptor(lIlIlIIIlIlIlII) : "V"));
    }

    public static String getUnboxingMethod(Type lIlIIlIlllIIlII) {
        return lIlIIlIlllIIlII == null ? null : UNBOXING_METHODS[lIlIIlIlllIIlII.getSort()];
    }

    public static void printNode(AbstractInsnNode lIlIlIlIlIIlIIl) {
        System.err.printf("%s\n", Bytecode.describeNode(lIlIlIlIlIIlIIl));
    }

    public static boolean isConstant(AbstractInsnNode lIlIIllllllllII) {
        if (lIlIIllllllllII == null) {
            return false;
        }
        return Ints.contains((int[])CONSTANTS_ALL, (int)lIlIIllllllllII.getOpcode());
    }

    public static void loadArgs(Type[] lIlIlIIllIIlIlI, InsnList lIlIlIIllIIllII, int lIlIlIIllIIlIII) {
        Bytecode.loadArgs(lIlIlIIllIIlIlI, lIlIlIIllIIllII, lIlIlIIllIIlIII, -1);
    }

    public static String changeDescriptorReturnType(String lIlIlIIIIllIIll, String lIlIlIIIIlIlllI) {
        if (lIlIlIIIIllIIll == null) {
            return null;
        }
        if (lIlIlIIIIlIlllI == null) {
            return lIlIlIIIIllIIll;
        }
        return String.valueOf(new StringBuilder().append(lIlIlIIIIllIIll.substring(0, lIlIlIIIIllIIll.lastIndexOf(41) + 1)).append(lIlIlIIIIlIlllI));
    }

    private static boolean isMergeableAnnotation(AnnotationNode lIlIIlIIllllIIl) {
        if (lIlIIlIIllllIIl.desc.startsWith(String.valueOf(new StringBuilder().append("L").append(Constants.MIXIN_PACKAGE_REF)))) {
            return mergeableAnnotationPattern.matcher(lIlIIlIIllllIIl.desc).matches();
        }
        return true;
    }

    public static final class Visibility
    extends Enum<Visibility> {
        public static final /* synthetic */ /* enum */ Visibility PRIVATE;
        private static final /* synthetic */ Visibility[] $VALUES;
        static final /* synthetic */ int MASK;
        public static final /* synthetic */ /* enum */ Visibility PACKAGE;
        final /* synthetic */ int access;
        public static final /* synthetic */ /* enum */ Visibility PROTECTED;
        public static final /* synthetic */ /* enum */ Visibility PUBLIC;

        public static Visibility valueOf(String llllIIIIIIlIIII) {
            return Enum.valueOf(Visibility.class, llllIIIIIIlIIII);
        }

        private Visibility(int llllIIIIIIIlIlI) {
            Visibility llllIIIIIIIlIll;
            llllIIIIIIIlIll.access = llllIIIIIIIlIlI;
        }

        static {
            MASK = 7;
            PRIVATE = new Visibility(2);
            PROTECTED = new Visibility(4);
            PACKAGE = new Visibility(0);
            PUBLIC = new Visibility(1);
            $VALUES = new Visibility[]{PRIVATE, PROTECTED, PACKAGE, PUBLIC};
        }

        public static Visibility[] values() {
            return (Visibility[])$VALUES.clone();
        }
    }
}

