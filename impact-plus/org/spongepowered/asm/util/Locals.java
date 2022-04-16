/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FrameNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.LabelNode;
import org.spongepowered.asm.lib.tree.LineNumberNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.lib.tree.analysis.Analyzer;
import org.spongepowered.asm.lib.tree.analysis.AnalyzerException;
import org.spongepowered.asm.lib.tree.analysis.BasicValue;
import org.spongepowered.asm.lib.tree.analysis.Frame;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.util.asm.MixinVerifier;
import org.spongepowered.asm.util.throwables.LVTGeneratorException;

public final class Locals {
    private static final /* synthetic */ Map<String, List<LocalVariableNode>> calculatedLocalVariables;

    public static void loadLocals(Type[] llllllllllllllllIlIIllIIlllIIIll, InsnList llllllllllllllllIlIIllIIlllIIIlI, int llllllllllllllllIlIIllIIlllIIlIl, int llllllllllllllllIlIIllIIlllIIIII) {
        while (llllllllllllllllIlIIllIIlllIIlIl < llllllllllllllllIlIIllIIlllIIIll.length && llllllllllllllllIlIIllIIlllIIIII > 0) {
            if (llllllllllllllllIlIIllIIlllIIIll[llllllllllllllllIlIIllIIlllIIlIl] != null) {
                llllllllllllllllIlIIllIIlllIIIlI.add(new VarInsnNode(llllllllllllllllIlIIllIIlllIIIll[llllllllllllllllIlIIllIIlllIIlIl].getOpcode(21), llllllllllllllllIlIIllIIlllIIlIl));
                --llllllllllllllllIlIIllIIlllIIIII;
            }
            ++llllllllllllllllIlIIllIIlllIIlIl;
        }
    }

    static {
        calculatedLocalVariables = new HashMap<String, List<LocalVariableNode>>();
    }

    private static LocalVariableNode getLocalVariableAt(ClassNode llllllllllllllllIlIIllIIlIIIIIll, MethodNode llllllllllllllllIlIIllIIIlllllII, int llllllllllllllllIlIIllIIIllllIll, int llllllllllllllllIlIIllIIIllllIlI) {
        LocalVariableNode llllllllllllllllIlIIllIIIlllllll = null;
        LocalVariableNode llllllllllllllllIlIIllIIIllllllI = null;
        for (LocalVariableNode llllllllllllllllIlIIllIIlIIIIlIl : Locals.getLocalVariableTable(llllllllllllllllIlIIllIIlIIIIIll, llllllllllllllllIlIIllIIIlllllII)) {
            if (llllllllllllllllIlIIllIIlIIIIlIl.index != llllllllllllllllIlIIllIIIllllIlI) continue;
            if (Locals.isOpcodeInRange(llllllllllllllllIlIIllIIIlllllII.instructions, llllllllllllllllIlIIllIIlIIIIlIl, llllllllllllllllIlIIllIIIllllIll)) {
                llllllllllllllllIlIIllIIIlllllll = llllllllllllllllIlIIllIIlIIIIlIl;
                continue;
            }
            if (llllllllllllllllIlIIllIIIlllllll != null) continue;
            llllllllllllllllIlIIllIIIllllllI = llllllllllllllllIlIIllIIlIIIIlIl;
        }
        if (llllllllllllllllIlIIllIIIlllllll == null && !llllllllllllllllIlIIllIIIlllllII.localVariables.isEmpty()) {
            for (LocalVariableNode llllllllllllllllIlIIllIIlIIIIlII : Locals.getGeneratedLocalVariableTable(llllllllllllllllIlIIllIIlIIIIIll, llllllllllllllllIlIIllIIIlllllII)) {
                if (llllllllllllllllIlIIllIIlIIIIlII.index != llllllllllllllllIlIIllIIIllllIlI || !Locals.isOpcodeInRange(llllllllllllllllIlIIllIIIlllllII.instructions, llllllllllllllllIlIIllIIlIIIIlII, llllllllllllllllIlIIllIIIllllIll)) continue;
                llllllllllllllllIlIIllIIIlllllll = llllllllllllllllIlIIllIIlIIIIlII;
            }
        }
        return llllllllllllllllIlIIllIIIlllllll != null ? llllllllllllllllIlIIllIIIlllllll : llllllllllllllllIlIIllIIIllllllI;
    }

    private Locals() {
        Locals llllllllllllllllIlIIllIIlllIllIl;
    }

    public static List<LocalVariableNode> getLocalVariableTable(ClassNode llllllllllllllllIlIIllIIIllIlIII, MethodNode llllllllllllllllIlIIllIIIllIlIIl) {
        if (llllllllllllllllIlIIllIIIllIlIIl.localVariables.isEmpty()) {
            return Locals.getGeneratedLocalVariableTable(llllllllllllllllIlIIllIIIllIlIII, llllllllllllllllIlIIllIIIllIlIIl);
        }
        return llllllllllllllllIlIIllIIIllIlIIl.localVariables;
    }

    private static AbstractInsnNode nextNode(InsnList llllllllllllllllIlIIllIIIIIlIlIl, AbstractInsnNode llllllllllllllllIlIIllIIIIIlIIIl) {
        int llllllllllllllllIlIIllIIIIIlIIll = llllllllllllllllIlIIllIIIIIlIlIl.indexOf(llllllllllllllllIlIIllIIIIIlIIIl) + 1;
        if (llllllllllllllllIlIIllIIIIIlIIll > 0 && llllllllllllllllIlIIllIIIIIlIIll < llllllllllllllllIlIIllIIIIIlIlIl.size()) {
            return llllllllllllllllIlIIllIIIIIlIlIl.get(llllllllllllllllIlIIllIIIIIlIIll);
        }
        return llllllllllllllllIlIIllIIIIIlIIIl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static LocalVariableNode[] getLocalsAt(ClassNode llllllllllllllllIlIIllIIlIlllIll, MethodNode llllllllllllllllIlIIllIIlIlIlllI, AbstractInsnNode llllllllllllllllIlIIllIIlIlllIIl) {
        for (int llllllllllllllllIlIIllIIllIIlIIl = 0; llllllllllllllllIlIIllIIllIIlIIl < 3 && (llllllllllllllllIlIIllIIlIlllIIl instanceof LabelNode || llllllllllllllllIlIIllIIlIlllIIl instanceof LineNumberNode); ++llllllllllllllllIlIIllIIllIIlIIl) {
            llllllllllllllllIlIIllIIlIlllIIl = Locals.nextNode(llllllllllllllllIlIIllIIlIlIlllI.instructions, llllllllllllllllIlIIllIIlIlllIIl);
        }
        ClassInfo llllllllllllllllIlIIllIIlIlllIII = ClassInfo.forName(llllllllllllllllIlIIllIIlIlllIll.name);
        if (llllllllllllllllIlIIllIIlIlllIII == null) {
            throw new LVTGeneratorException(String.valueOf(new StringBuilder().append("Could not load class metadata for ").append(llllllllllllllllIlIIllIIlIlllIll.name).append(" generating LVT for ").append(llllllllllllllllIlIIllIIlIlIlllI.name)));
        }
        ClassInfo.Method llllllllllllllllIlIIllIIlIllIlll = llllllllllllllllIlIIllIIlIlllIII.findMethod(llllllllllllllllIlIIllIIlIlIlllI);
        if (llllllllllllllllIlIIllIIlIllIlll == null) {
            throw new LVTGeneratorException(String.valueOf(new StringBuilder().append("Could not locate method metadata for ").append(llllllllllllllllIlIIllIIlIlIlllI.name).append(" generating LVT in ").append(llllllllllllllllIlIIllIIlIlllIll.name)));
        }
        List<ClassInfo.FrameData> llllllllllllllllIlIIllIIlIllIllI = llllllllllllllllIlIIllIIlIllIlll.getFrames();
        LocalVariableNode[] llllllllllllllllIlIIllIIlIllIlIl = new LocalVariableNode[llllllllllllllllIlIIllIIlIlIlllI.maxLocals];
        int llllllllllllllllIlIIllIIlIllIlII = 0;
        int llllllllllllllllIlIIllIIlIllIIll = 0;
        if ((llllllllllllllllIlIIllIIlIlIlllI.access & 8) == 0) {
            llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIlIllIlII++] = new LocalVariableNode("this", llllllllllllllllIlIIllIIlIlllIll.name, null, null, null, 0);
        }
        for (Type llllllllllllllllIlIIllIIllIIlIII : Type.getArgumentTypes(llllllllllllllllIlIIllIIlIlIlllI.desc)) {
            llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIlIllIlII] = new LocalVariableNode(String.valueOf(new StringBuilder().append("arg").append(llllllllllllllllIlIIllIIlIllIIll++)), llllllllllllllllIlIIllIIllIIlIII.toString(), null, null, null, llllllllllllllllIlIIllIIlIllIlII);
            llllllllllllllllIlIIllIIlIllIlII += llllllllllllllllIlIIllIIllIIlIII.getSize();
        }
        int llllllllllllllllIlIIllIIlIllIIlI = llllllllllllllllIlIIllIIlIllIlII;
        int llllllllllllllllIlIIllIIlIllIIIl = -1;
        int llllllllllllllllIlIIllIIlIllIIII = 0;
        ListIterator<AbstractInsnNode> llllllllllllllllIlIIllIIlIllllIl = llllllllllllllllIlIIllIIlIlIlllI.instructions.iterator();
        while (llllllllllllllllIlIIllIIlIllllIl.hasNext()) {
            AbstractInsnNode llllllllllllllllIlIIllIIlIlllllI = (AbstractInsnNode)llllllllllllllllIlIIllIIlIllllIl.next();
            if (llllllllllllllllIlIIllIIlIlllllI instanceof FrameNode) {
                FrameNode llllllllllllllllIlIIllIIllIIIIIl = (FrameNode)llllllllllllllllIlIIllIIlIlllllI;
                ClassInfo.FrameData llllllllllllllllIlIIllIIllIIIIII = ++llllllllllllllllIlIIllIIlIllIIIl < llllllllllllllllIlIIllIIlIllIllI.size() ? llllllllllllllllIlIIllIIlIllIllI.get(llllllllllllllllIlIIllIIlIllIIIl) : null;
                llllllllllllllllIlIIllIIlIllIIII = llllllllllllllllIlIIllIIllIIIIII != null && llllllllllllllllIlIIllIIllIIIIII.type == 0 ? Math.min(llllllllllllllllIlIIllIIlIllIIII, llllllllllllllllIlIIllIIllIIIIII.locals) : llllllllllllllllIlIIllIIllIIIIIl.local.size();
                int llllllllllllllllIlIIllIIllIIIIll = 0;
                int llllllllllllllllIlIIllIIllIIIIlI = 0;
                while (llllllllllllllllIlIIllIIllIIIIlI < llllllllllllllllIlIIllIIlIllIlIl.length) {
                    Object llllllllllllllllIlIIllIIllIIIlII;
                    Object object = llllllllllllllllIlIIllIIllIIIlII = llllllllllllllllIlIIllIIllIIIIll < llllllllllllllllIlIIllIIllIIIIIl.local.size() ? llllllllllllllllIlIIllIIllIIIIIl.local.get(llllllllllllllllIlIIllIIllIIIIll) : null;
                    if (llllllllllllllllIlIIllIIllIIIlII instanceof String) {
                        llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIllIIIIlI] = Locals.getLocalVariableAt(llllllllllllllllIlIIllIIlIlllIll, llllllllllllllllIlIIllIIlIlIlllI, llllllllllllllllIlIIllIIlIlllIIl, llllllllllllllllIlIIllIIllIIIIlI);
                    } else if (llllllllllllllllIlIIllIIllIIIlII instanceof Integer) {
                        boolean llllllllllllllllIlIIllIIllIIIlIl;
                        boolean llllllllllllllllIlIIllIIllIIIlll = llllllllllllllllIlIIllIIllIIIlII == Opcodes.UNINITIALIZED_THIS || llllllllllllllllIlIIllIIllIIIlII == Opcodes.NULL;
                        boolean llllllllllllllllIlIIllIIllIIIllI = llllllllllllllllIlIIllIIllIIIlII == Opcodes.INTEGER || llllllllllllllllIlIIllIIllIIIlII == Opcodes.FLOAT;
                        boolean bl = llllllllllllllllIlIIllIIllIIIlIl = llllllllllllllllIlIIllIIllIIIlII == Opcodes.DOUBLE || llllllllllllllllIlIIllIIllIIIlII == Opcodes.LONG;
                        if (llllllllllllllllIlIIllIIllIIIlII != Opcodes.TOP) {
                            if (llllllllllllllllIlIIllIIllIIIlll) {
                                llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIllIIIIlI] = null;
                            } else {
                                if (!llllllllllllllllIlIIllIIllIIIllI && !llllllllllllllllIlIIllIIllIIIlIl) throw new LVTGeneratorException(String.valueOf(new StringBuilder().append("Unrecognised locals opcode ").append(llllllllllllllllIlIIllIIllIIIlII).append(" in locals array at position ").append(llllllllllllllllIlIIllIIllIIIIll).append(" in ").append(llllllllllllllllIlIIllIIlIlllIll.name).append(".").append(llllllllllllllllIlIIllIIlIlIlllI.name).append(llllllllllllllllIlIIllIIlIlIlllI.desc)));
                                llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIllIIIIlI] = Locals.getLocalVariableAt(llllllllllllllllIlIIllIIlIlllIll, llllllllllllllllIlIIllIIlIlIlllI, llllllllllllllllIlIIllIIlIlllIIl, llllllllllllllllIlIIllIIllIIIIlI);
                                if (llllllllllllllllIlIIllIIllIIIlIl) {
                                    llllllllllllllllIlIIllIIlIllIlIl[++llllllllllllllllIlIIllIIllIIIIlI] = null;
                                }
                            }
                        }
                    } else {
                        if (llllllllllllllllIlIIllIIllIIIlII != null) throw new LVTGeneratorException(String.valueOf(new StringBuilder().append("Invalid value ").append(llllllllllllllllIlIIllIIllIIIlII).append(" in locals array at position ").append(llllllllllllllllIlIIllIIllIIIIll).append(" in ").append(llllllllllllllllIlIIllIIlIlllIll.name).append(".").append(llllllllllllllllIlIIllIIlIlIlllI.name).append(llllllllllllllllIlIIllIIlIlIlllI.desc)));
                        if (llllllllllllllllIlIIllIIllIIIIlI >= llllllllllllllllIlIIllIIlIllIIlI && llllllllllllllllIlIIllIIllIIIIlI >= llllllllllllllllIlIIllIIlIllIIII && llllllllllllllllIlIIllIIlIllIIII > 0) {
                            llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIllIIIIlI] = null;
                        }
                    }
                    ++llllllllllllllllIlIIllIIllIIIIlI;
                    ++llllllllllllllllIlIIllIIllIIIIll;
                }
            } else if (llllllllllllllllIlIIllIIlIlllllI instanceof VarInsnNode) {
                VarInsnNode llllllllllllllllIlIIllIIlIllllll = (VarInsnNode)llllllllllllllllIlIIllIIlIlllllI;
                llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIlIllllll.var] = Locals.getLocalVariableAt(llllllllllllllllIlIIllIIlIlllIll, llllllllllllllllIlIIllIIlIlIlllI, llllllllllllllllIlIIllIIlIlllIIl, llllllllllllllllIlIIllIIlIllllll.var);
            }
            if (llllllllllllllllIlIIllIIlIlllllI != llllllllllllllllIlIIllIIlIlllIIl) continue;
            break;
        }
        for (int llllllllllllllllIlIIllIIlIllllII = 0; llllllllllllllllIlIIllIIlIllllII < llllllllllllllllIlIIllIIlIllIlIl.length; ++llllllllllllllllIlIIllIIlIllllII) {
            if (llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIlIllllII] == null || llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIlIllllII].desc != null) continue;
            llllllllllllllllIlIIllIIlIllIlIl[llllllllllllllllIlIIllIIlIllllII] = null;
        }
        return llllllllllllllllIlIIllIIlIllIlIl;
    }

    public static LocalVariableNode getLocalVariableAt(ClassNode llllllllllllllllIlIIllIIlIIlIlIl, MethodNode llllllllllllllllIlIIllIIlIIlIlII, AbstractInsnNode llllllllllllllllIlIIllIIlIIlIIll, int llllllllllllllllIlIIllIIlIIlIIlI) {
        return Locals.getLocalVariableAt(llllllllllllllllIlIIllIIlIIlIlIl, llllllllllllllllIlIIllIIlIIlIlII, llllllllllllllllIlIIllIIlIIlIlII.instructions.indexOf(llllllllllllllllIlIIllIIlIIlIIll), llllllllllllllllIlIIllIIlIIlIIlI);
    }

    private static boolean isOpcodeInRange(InsnList llllllllllllllllIlIIllIIIllIllll, LocalVariableNode llllllllllllllllIlIIllIIIllIlllI, int llllllllllllllllIlIIllIIIlllIIII) {
        return llllllllllllllllIlIIllIIIllIllll.indexOf(llllllllllllllllIlIIllIIIllIlllI.start) < llllllllllllllllIlIIllIIIlllIIII && llllllllllllllllIlIIllIIIllIllll.indexOf(llllllllllllllllIlIIllIIIllIlllI.end) > llllllllllllllllIlIIllIIIlllIIII;
    }

    public static List<LocalVariableNode> generateLocalVariableTable(ClassNode llllllllllllllllIlIIllIIIIllllIl, MethodNode llllllllllllllllIlIIllIIIIllllII) {
        ArrayList<Type> llllllllllllllllIlIIllIIIIlllIll = null;
        if (llllllllllllllllIlIIllIIIIllllIl.interfaces != null) {
            llllllllllllllllIlIIllIIIIlllIll = new ArrayList<Type>();
            for (String llllllllllllllllIlIIllIIIlIIlIII : llllllllllllllllIlIIllIIIIllllIl.interfaces) {
                llllllllllllllllIlIIllIIIIlllIll.add(Type.getObjectType(llllllllllllllllIlIIllIIIlIIlIII));
            }
        }
        Type llllllllllllllllIlIIllIIIIlllIlI = null;
        if (llllllllllllllllIlIIllIIIIllllIl.superName != null) {
            llllllllllllllllIlIIllIIIIlllIlI = Type.getObjectType(llllllllllllllllIlIIllIIIIllllIl.superName);
        }
        Analyzer<BasicValue> llllllllllllllllIlIIllIIIIlllIIl = new Analyzer<BasicValue>(new MixinVerifier(Type.getObjectType(llllllllllllllllIlIIllIIIIllllIl.name), llllllllllllllllIlIIllIIIIlllIlI, llllllllllllllllIlIIllIIIIlllIll, false));
        try {
            llllllllllllllllIlIIllIIIIlllIIl.analyze(llllllllllllllllIlIIllIIIIllllIl.name, llllllllllllllllIlIIllIIIIllllII);
        }
        catch (AnalyzerException llllllllllllllllIlIIllIIIlIIIlll) {
            llllllllllllllllIlIIllIIIlIIIlll.printStackTrace();
        }
        Frame<BasicValue>[] llllllllllllllllIlIIllIIIIlllIII = llllllllllllllllIlIIllIIIIlllIIl.getFrames();
        int llllllllllllllllIlIIllIIIIllIlll = llllllllllllllllIlIIllIIIIllllII.instructions.size();
        ArrayList<LocalVariableNode> llllllllllllllllIlIIllIIIIllIllI = new ArrayList<LocalVariableNode>();
        LocalVariableNode[] llllllllllllllllIlIIllIIIIllIlIl = new LocalVariableNode[llllllllllllllllIlIIllIIIIllllII.maxLocals];
        BasicValue[] llllllllllllllllIlIIllIIIIllIlII = new BasicValue[llllllllllllllllIlIIllIIIIllllII.maxLocals];
        LabelNode[] llllllllllllllllIlIIllIIIIllIIll = new LabelNode[llllllllllllllllIlIIllIIIIllIlll];
        String[] llllllllllllllllIlIIllIIIIllIIlI = new String[llllllllllllllllIlIIllIIIIllllII.maxLocals];
        for (int llllllllllllllllIlIIllIIIlIIIIII = 0; llllllllllllllllIlIIllIIIlIIIIII < llllllllllllllllIlIIllIIIIllIlll; ++llllllllllllllllIlIIllIIIlIIIIII) {
            Frame<BasicValue> llllllllllllllllIlIIllIIIlIIIIlI = llllllllllllllllIlIIllIIIIlllIII[llllllllllllllllIlIIllIIIlIIIIII];
            if (llllllllllllllllIlIIllIIIlIIIIlI == null) continue;
            LabelNode llllllllllllllllIlIIllIIIlIIIIIl = null;
            for (int llllllllllllllllIlIIllIIIlIIIIll = 0; llllllllllllllllIlIIllIIIlIIIIll < llllllllllllllllIlIIllIIIlIIIIlI.getLocals(); ++llllllllllllllllIlIIllIIIlIIIIll) {
                BasicValue llllllllllllllllIlIIllIIIlIIIlII = llllllllllllllllIlIIllIIIlIIIIlI.getLocal(llllllllllllllllIlIIllIIIlIIIIll);
                if (llllllllllllllllIlIIllIIIlIIIlII == null && llllllllllllllllIlIIllIIIIllIlII[llllllllllllllllIlIIllIIIlIIIIll] == null || llllllllllllllllIlIIllIIIlIIIlII != null && llllllllllllllllIlIIllIIIlIIIlII.equals(llllllllllllllllIlIIllIIIIllIlII[llllllllllllllllIlIIllIIIlIIIIll])) continue;
                if (llllllllllllllllIlIIllIIIlIIIIIl == null) {
                    AbstractInsnNode llllllllllllllllIlIIllIIIlIIIllI = llllllllllllllllIlIIllIIIIllllII.instructions.get(llllllllllllllllIlIIllIIIlIIIIII);
                    if (llllllllllllllllIlIIllIIIlIIIllI instanceof LabelNode) {
                        llllllllllllllllIlIIllIIIlIIIIIl = (LabelNode)llllllllllllllllIlIIllIIIlIIIllI;
                    } else {
                        llllllllllllllllIlIIllIIIIllIIll[llllllllllllllllIlIIllIIIlIIIIII] = llllllllllllllllIlIIllIIIlIIIIIl = new LabelNode();
                    }
                }
                if (llllllllllllllllIlIIllIIIlIIIlII == null && llllllllllllllllIlIIllIIIIllIlII[llllllllllllllllIlIIllIIIlIIIIll] != null) {
                    llllllllllllllllIlIIllIIIIllIllI.add(llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIlIIIIll]);
                    llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIlIIIIll].end = llllllllllllllllIlIIllIIIlIIIIIl;
                    llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIlIIIIll] = null;
                } else if (llllllllllllllllIlIIllIIIlIIIlII != null) {
                    if (llllllllllllllllIlIIllIIIIllIlII[llllllllllllllllIlIIllIIIlIIIIll] != null) {
                        llllllllllllllllIlIIllIIIIllIllI.add(llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIlIIIIll]);
                        llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIlIIIIll].end = llllllllllllllllIlIIllIIIlIIIIIl;
                        llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIlIIIIll] = null;
                    }
                    String llllllllllllllllIlIIllIIIlIIIlIl = llllllllllllllllIlIIllIIIlIIIlII.getType() != null ? llllllllllllllllIlIIllIIIlIIIlII.getType().getDescriptor() : llllllllllllllllIlIIllIIIIllIIlI[llllllllllllllllIlIIllIIIlIIIIll];
                    llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIlIIIIll] = new LocalVariableNode(String.valueOf(new StringBuilder().append("var").append(llllllllllllllllIlIIllIIIlIIIIll)), llllllllllllllllIlIIllIIIlIIIlIl, null, llllllllllllllllIlIIllIIIlIIIIIl, null, llllllllllllllllIlIIllIIIlIIIIll);
                    if (llllllllllllllllIlIIllIIIlIIIlIl != null) {
                        llllllllllllllllIlIIllIIIIllIIlI[llllllllllllllllIlIIllIIIlIIIIll] = llllllllllllllllIlIIllIIIlIIIlIl;
                    }
                }
                llllllllllllllllIlIIllIIIIllIlII[llllllllllllllllIlIIllIIIlIIIIll] = llllllllllllllllIlIIllIIIlIIIlII;
            }
        }
        LabelNode llllllllllllllllIlIIllIIIIllIIIl = null;
        for (int llllllllllllllllIlIIllIIIIllllll = 0; llllllllllllllllIlIIllIIIIllllll < llllllllllllllllIlIIllIIIIllIlIl.length; ++llllllllllllllllIlIIllIIIIllllll) {
            if (llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIIllllll] == null) continue;
            if (llllllllllllllllIlIIllIIIIllIIIl == null) {
                llllllllllllllllIlIIllIIIIllIIIl = new LabelNode();
                llllllllllllllllIlIIllIIIIllllII.instructions.add(llllllllllllllllIlIIllIIIIllIIIl);
            }
            llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIIllllll].end = llllllllllllllllIlIIllIIIIllIIIl;
            llllllllllllllllIlIIllIIIIllIllI.add(llllllllllllllllIlIIllIIIIllIlIl[llllllllllllllllIlIIllIIIIllllll]);
        }
        for (int llllllllllllllllIlIIllIIIIlllllI = llllllllllllllllIlIIllIIIIllIlll - 1; llllllllllllllllIlIIllIIIIlllllI >= 0; --llllllllllllllllIlIIllIIIIlllllI) {
            if (llllllllllllllllIlIIllIIIIllIIll[llllllllllllllllIlIIllIIIIlllllI] == null) continue;
            llllllllllllllllIlIIllIIIIllllII.instructions.insert(llllllllllllllllIlIIllIIIIllllII.instructions.get(llllllllllllllllIlIIllIIIIlllllI), llllllllllllllllIlIIllIIIIllIIll[llllllllllllllllIlIIllIIIIlllllI]);
        }
        return llllllllllllllllIlIIllIIIIllIllI;
    }

    public static List<LocalVariableNode> getGeneratedLocalVariableTable(ClassNode llllllllllllllllIlIIllIIIllIIIlI, MethodNode llllllllllllllllIlIIllIIIllIIIIl) {
        String llllllllllllllllIlIIllIIIllIIIII = String.format("%s.%s%s", llllllllllllllllIlIIllIIIllIIIlI.name, llllllllllllllllIlIIllIIIllIIIIl.name, llllllllllllllllIlIIllIIIllIIIIl.desc);
        List<LocalVariableNode> llllllllllllllllIlIIllIIIlIlllll = calculatedLocalVariables.get(llllllllllllllllIlIIllIIIllIIIII);
        if (llllllllllllllllIlIIllIIIlIlllll != null) {
            return llllllllllllllllIlIIllIIIlIlllll;
        }
        llllllllllllllllIlIIllIIIlIlllll = Locals.generateLocalVariableTable(llllllllllllllllIlIIllIIIllIIIlI, llllllllllllllllIlIIllIIIllIIIIl);
        calculatedLocalVariables.put(llllllllllllllllIlIIllIIIllIIIII, llllllllllllllllIlIIllIIIlIlllll);
        return llllllllllllllllIlIIllIIIlIlllll;
    }
}

