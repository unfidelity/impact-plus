/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Opcodes;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.analysis.Analyzer;
import org.spongepowered.asm.lib.tree.analysis.BasicValue;
import org.spongepowered.asm.lib.tree.analysis.BasicVerifier;
import org.spongepowered.asm.lib.util.CheckAnnotationAdapter;
import org.spongepowered.asm.lib.util.CheckClassAdapter;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CheckMethodAdapter
extends MethodVisitor {
    private /* synthetic */ boolean endCode;
    private /* synthetic */ int insnCount;
    private /* synthetic */ boolean endMethod;
    private static /* synthetic */ Field labelStatusField;
    private /* synthetic */ int lastFrame;
    private /* synthetic */ boolean startCode;
    private /* synthetic */ List<Label> handlers;
    private /* synthetic */ int compressedFrames;
    public /* synthetic */ int version;
    private /* synthetic */ Set<Label> usedLabels;
    private final /* synthetic */ Map<Label, Integer> labels;
    private /* synthetic */ int expandedFrames;
    private static final /* synthetic */ int[] TYPE;
    private /* synthetic */ int access;

    @Override
    public AnnotationVisitor visitTryCatchAnnotation(int lllllllllllllllIllIlIIlIIlIIlIll, TypePath lllllllllllllllIllIlIIlIIlIlIIII, String lllllllllllllllIllIlIIlIIlIIllll, boolean lllllllllllllllIllIlIIlIIlIIlllI) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIIlIIllII;
        lllllllllllllllIllIlIIlIIlIIllII.checkStartCode();
        lllllllllllllllIllIlIIlIIlIIllII.checkEndCode();
        int lllllllllllllllIllIlIIlIIlIIllIl = lllllllllllllllIllIlIIlIIlIIlIll >>> 24;
        if (lllllllllllllllIllIlIIlIIlIIllIl != 66) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type reference sort 0x").append(Integer.toHexString(lllllllllllllllIllIlIIlIIlIIllIl))));
        }
        CheckClassAdapter.checkTypeRefAndPath(lllllllllllllllIllIlIIlIIlIIlIll, lllllllllllllllIllIlIIlIIlIlIIII);
        CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIlIIlIIllll, false);
        return new CheckAnnotationAdapter(super.visitTryCatchAnnotation(lllllllllllllllIllIlIIlIIlIIlIll, lllllllllllllllIllIlIIlIIlIlIIII, lllllllllllllllIllIlIIlIIlIIllll, lllllllllllllllIllIlIIlIIlIIlllI));
    }

    static int checkDesc(String lllllllllllllllIllIlIIIlIlIlIIll, int lllllllllllllllIllIlIIIlIlIlIIlI, boolean lllllllllllllllIllIlIIIlIlIlIlII) {
        if (lllllllllllllllIllIlIIIlIlIlIIll == null || lllllllllllllllIllIlIIIlIlIlIIlI >= lllllllllllllllIllIlIIIlIlIlIIll.length()) {
            throw new IllegalArgumentException("Invalid type descriptor (must not be null or empty)");
        }
        switch (lllllllllllllllIllIlIIIlIlIlIIll.charAt(lllllllllllllllIllIlIIIlIlIlIIlI)) {
            case 'V': {
                if (lllllllllllllllIllIlIIIlIlIlIlII) {
                    return lllllllllllllllIllIlIIIlIlIlIIlI + 1;
                }
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lllllllllllllllIllIlIIIlIlIlIIll)));
            }
            case 'B': 
            case 'C': 
            case 'D': 
            case 'F': 
            case 'I': 
            case 'J': 
            case 'S': 
            case 'Z': {
                return lllllllllllllllIllIlIIIlIlIlIIlI + 1;
            }
            case '[': {
                int lllllllllllllllIllIlIIIlIlIllIIl;
                for (lllllllllllllllIllIlIIIlIlIllIIl = lllllllllllllllIllIlIIIlIlIlIIlI + 1; lllllllllllllllIllIlIIIlIlIllIIl < lllllllllllllllIllIlIIIlIlIlIIll.length() && lllllllllllllllIllIlIIIlIlIlIIll.charAt(lllllllllllllllIllIlIIIlIlIllIIl) == '['; ++lllllllllllllllIllIlIIIlIlIllIIl) {
                }
                if (lllllllllllllllIllIlIIIlIlIllIIl < lllllllllllllllIllIlIIIlIlIlIIll.length()) {
                    return CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIIlIlIlIIll, lllllllllllllllIllIlIIIlIlIllIIl, false);
                }
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lllllllllllllllIllIlIIIlIlIlIIll)));
            }
            case 'L': {
                int lllllllllllllllIllIlIIIlIlIlIlll = lllllllllllllllIllIlIIIlIlIlIIll.indexOf(59, lllllllllllllllIllIlIIIlIlIlIIlI);
                if (lllllllllllllllIllIlIIIlIlIlIlll == -1 || lllllllllllllllIllIlIIIlIlIlIlll - lllllllllllllllIllIlIIIlIlIlIIlI < 2) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lllllllllllllllIllIlIIIlIlIlIIll)));
                }
                try {
                    CheckMethodAdapter.checkInternalName(lllllllllllllllIllIlIIIlIlIlIIll, lllllllllllllllIllIlIIIlIlIlIIlI + 1, lllllllllllllllIllIlIIIlIlIlIlll, null);
                }
                catch (IllegalArgumentException lllllllllllllllIllIlIIIlIlIllIII) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lllllllllllllllIllIlIIIlIlIlIIll)));
                }
                return lllllllllllllllIllIlIIIlIlIlIlll + 1;
            }
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lllllllllllllllIllIlIIIlIlIlIIll)));
    }

    /*
     * WARNING - void declaration
     */
    @Override
    public void visitFrame(int lllllllllllllllIllIlIIllIllIlIIl, int lllllllllllllllIllIlIIllIllIIlll, Object[] lllllllllllllllIllIlIIllIlllIlIl, int lllllllllllllllIllIlIIllIlllIIll, Object[] lllllllllllllllIllIlIIllIllIIlII) {
        void lllllllllllllllIllIlIIllIllIllIl;
        void lllllllllllllllIllIlIIllIllIlllI;
        CheckMethodAdapter lllllllllllllllIllIlIIllIllllIll;
        if (lllllllllllllllIllIlIIllIllllIll.insnCount == lllllllllllllllIllIlIIllIllllIll.lastFrame) {
            throw new IllegalStateException("At most one frame can be visited at a given code location.");
        }
        lllllllllllllllIllIlIIllIllllIll.lastFrame = lllllllllllllllIllIlIIllIllllIll.insnCount;
        switch (lllllllllllllllIllIlIIllIllIlIIl) {
            case -1: 
            case 0: {
                int lllllllllllllllIllIlIIlllIIIIlll = Integer.MAX_VALUE;
                int lllllllllllllllIllIlIIlllIIIIllI = Integer.MAX_VALUE;
                break;
            }
            case 3: {
                boolean lllllllllllllllIllIlIIlllIIIIlIl = false;
                boolean lllllllllllllllIllIlIIlllIIIIlII = false;
                break;
            }
            case 4: {
                boolean lllllllllllllllIllIlIIlllIIIIIll = false;
                boolean lllllllllllllllIllIlIIlllIIIIIlI = true;
                break;
            }
            case 1: 
            case 2: {
                int lllllllllllllllIllIlIIlllIIIIIIl = 3;
                boolean lllllllllllllllIllIlIIlllIIIIIII = false;
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid frame type ").append(lllllllllllllllIllIlIIllIllIlIIl)));
            }
        }
        if (lllllllllllllllIllIlIIllIllIIlll > lllllllllllllllIllIlIIllIllIlllI) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid nLocal=").append(lllllllllllllllIllIlIIllIllIIlll).append(" for frame type ").append(lllllllllllllllIllIlIIllIllIlIIl)));
        }
        if (lllllllllllllllIllIlIIllIlllIIll > lllllllllllllllIllIlIIllIllIllIl) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid nStack=").append(lllllllllllllllIllIlIIllIlllIIll).append(" for frame type ").append(lllllllllllllllIllIlIIllIllIlIIl)));
        }
        if (lllllllllllllllIllIlIIllIllIlIIl != 2) {
            if (lllllllllllllllIllIlIIllIllIIlll > 0 && (lllllllllllllllIllIlIIllIlllIlIl == null || lllllllllllllllIllIlIIllIlllIlIl.length < lllllllllllllllIllIlIIllIllIIlll)) {
                throw new IllegalArgumentException("Array local[] is shorter than nLocal");
            }
            for (int lllllllllllllllIllIlIIllIlllllll = 0; lllllllllllllllIllIlIIllIlllllll < lllllllllllllllIllIlIIllIllIIlll; ++lllllllllllllllIllIlIIllIlllllll) {
                lllllllllllllllIllIlIIllIllllIll.checkFrameValue(lllllllllllllllIllIlIIllIlllIlIl[lllllllllllllllIllIlIIllIlllllll]);
            }
        }
        if (lllllllllllllllIllIlIIllIlllIIll > 0 && (lllllllllllllllIllIlIIllIllIIlII == null || lllllllllllllllIllIlIIllIllIIlII.length < lllllllllllllllIllIlIIllIlllIIll)) {
            throw new IllegalArgumentException("Array stack[] is shorter than nStack");
        }
        for (int lllllllllllllllIllIlIIllIlllllIl = 0; lllllllllllllllIllIlIIllIlllllIl < lllllllllllllllIllIlIIllIlllIIll; ++lllllllllllllllIllIlIIllIlllllIl) {
            lllllllllllllllIllIlIIllIllllIll.checkFrameValue(lllllllllllllllIllIlIIllIllIIlII[lllllllllllllllIllIlIIllIlllllIl]);
        }
        if (lllllllllllllllIllIlIIllIllIlIIl == -1) {
            ++lllllllllllllllIllIlIIllIllllIll.expandedFrames;
        } else {
            ++lllllllllllllllIllIlIIllIllllIll.compressedFrames;
        }
        if (lllllllllllllllIllIlIIllIllllIll.expandedFrames > 0 && lllllllllllllllIllIlIIllIllllIll.compressedFrames > 0) {
            throw new RuntimeException("Expanded and compressed frames must not be mixed.");
        }
        super.visitFrame(lllllllllllllllIllIlIIllIllIlIIl, lllllllllllllllIllIlIIllIllIIlll, lllllllllllllllIllIlIIllIlllIlIl, lllllllllllllllIllIlIIllIlllIIll, lllllllllllllllIllIlIIllIllIIlII);
    }

    void checkFrameValue(Object lllllllllllllllIllIlIIIlllIllIlI) {
        CheckMethodAdapter lllllllllllllllIllIlIIIlllIllIll;
        if (lllllllllllllllIllIlIIIlllIllIlI == Opcodes.TOP || lllllllllllllllIllIlIIIlllIllIlI == Opcodes.INTEGER || lllllllllllllllIllIlIIIlllIllIlI == Opcodes.FLOAT || lllllllllllllllIllIlIIIlllIllIlI == Opcodes.LONG || lllllllllllllllIllIlIIIlllIllIlI == Opcodes.DOUBLE || lllllllllllllllIllIlIIIlllIllIlI == Opcodes.NULL || lllllllllllllllIllIlIIIlllIllIlI == Opcodes.UNINITIALIZED_THIS) {
            return;
        }
        if (lllllllllllllllIllIlIIIlllIllIlI instanceof String) {
            CheckMethodAdapter.checkInternalName((String)lllllllllllllllIllIlIIIlllIllIlI, "Invalid stack frame value");
            return;
        }
        if (!(lllllllllllllllIllIlIIIlllIllIlI instanceof Label)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid stack frame value: ").append(lllllllllllllllIllIlIIIlllIllIlI)));
        }
        lllllllllllllllIllIlIIIlllIllIll.usedLabels.add((Label)lllllllllllllllIllIlIIIlllIllIlI);
    }

    static void checkMethodIdentifier(int lllllllllllllllIllIlIIIllIIIIlll, String lllllllllllllllIllIlIIIllIIIlIIl, String lllllllllllllllIllIlIIIllIIIlIII) {
        if (lllllllllllllllIllIlIIIllIIIlIIl == null || lllllllllllllllIllIlIIIllIIIlIIl.length() == 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIllIIIlIII).append(" (must not be null or empty)")));
        }
        if ((lllllllllllllllIllIlIIIllIIIIlll & 0xFFFF) >= 49) {
            for (int lllllllllllllllIllIlIIIllIIIllII = 0; lllllllllllllllIllIlIIIllIIIllII < lllllllllllllllIllIlIIIllIIIlIIl.length(); ++lllllllllllllllIllIlIIIllIIIllII) {
                if (".;[/<>".indexOf(lllllllllllllllIllIlIIIllIIIlIIl.charAt(lllllllllllllllIllIlIIIllIIIllII)) == -1) continue;
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIllIIIlIII).append(" (must be a valid unqualified name): ").append(lllllllllllllllIllIlIIIllIIIlIIl)));
            }
            return;
        }
        if (!Character.isJavaIdentifierStart(lllllllllllllllIllIlIIIllIIIlIIl.charAt(0))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIllIIIlIII).append(" (must be a '<init>', '<clinit>' or a valid Java identifier): ").append(lllllllllllllllIllIlIIIllIIIlIIl)));
        }
        for (int lllllllllllllllIllIlIIIllIIIlIll = 1; lllllllllllllllIllIlIIIllIIIlIll < lllllllllllllllIllIlIIIllIIIlIIl.length(); ++lllllllllllllllIllIlIIIllIIIlIll) {
            if (Character.isJavaIdentifierPart(lllllllllllllllIllIlIIIllIIIlIIl.charAt(lllllllllllllllIllIlIIIllIIIlIll))) continue;
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIllIIIlIII).append(" (must be '<init>' or '<clinit>' or a valid Java identifier): ").append(lllllllllllllllIllIlIIIllIIIlIIl)));
        }
    }

    private void doVisitMethodInsn(int lllllllllllllllIllIlIIlIlllIIIII, String lllllllllllllllIllIlIIlIllIlllll, String lllllllllllllllIllIlIIlIllIllllI, String lllllllllllllllIllIlIIlIllIlllIl, boolean lllllllllllllllIllIlIIlIllIlllII) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIlllIIIIl;
        lllllllllllllllIllIlIIlIlllIIIIl.checkStartCode();
        lllllllllllllllIllIlIIlIlllIIIIl.checkEndCode();
        CheckMethodAdapter.checkOpcode(lllllllllllllllIllIlIIlIlllIIIII, 5);
        if (lllllllllllllllIllIlIIlIlllIIIII != 183 || !"<init>".equals(lllllllllllllllIllIlIIlIllIllllI)) {
            CheckMethodAdapter.checkMethodIdentifier(lllllllllllllllIllIlIIlIlllIIIIl.version, lllllllllllllllIllIlIIlIllIllllI, "name");
        }
        CheckMethodAdapter.checkInternalName(lllllllllllllllIllIlIIlIllIlllll, "owner");
        CheckMethodAdapter.checkMethodDesc(lllllllllllllllIllIlIIlIllIlllIl);
        if (lllllllllllllllIllIlIIlIlllIIIII == 182 && lllllllllllllllIllIlIIlIllIlllII) {
            throw new IllegalArgumentException("INVOKEVIRTUAL can't be used with interfaces");
        }
        if (lllllllllllllllIllIlIIlIlllIIIII == 185 && !lllllllllllllllIllIlIIlIllIlllII) {
            throw new IllegalArgumentException("INVOKEINTERFACE can't be used with classes");
        }
        if (lllllllllllllllIllIlIIlIlllIIIII == 183 && lllllllllllllllIllIlIIlIllIlllII && (lllllllllllllllIllIlIIlIlllIIIIl.version & 0xFFFF) < 52) {
            throw new IllegalArgumentException("INVOKESPECIAL can't be used with interfaces prior to Java 8");
        }
        if (lllllllllllllllIllIlIIlIlllIIIIl.mv != null) {
            lllllllllllllllIllIlIIlIlllIIIIl.mv.visitMethodInsn(lllllllllllllllIllIlIIlIlllIIIII, lllllllllllllllIllIlIIlIllIlllll, lllllllllllllllIllIlIIlIllIllllI, lllllllllllllllIllIlIIlIllIlllIl, lllllllllllllllIllIlIIlIllIlllII);
        }
        ++lllllllllllllllIllIlIIlIlllIIIIl.insnCount;
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int lllllllllllllllIllIlIIllllIlIllI, TypePath lllllllllllllllIllIlIIllllIIllll, String lllllllllllllllIllIlIIllllIlIlII, boolean lllllllllllllllIllIlIIllllIlIIll) {
        CheckMethodAdapter lllllllllllllllIllIlIIllllIlIlll;
        lllllllllllllllIllIlIIllllIlIlll.checkEndMethod();
        int lllllllllllllllIllIlIIllllIlIIlI = lllllllllllllllIllIlIIllllIlIllI >>> 24;
        if (lllllllllllllllIllIlIIllllIlIIlI != 1 && lllllllllllllllIllIlIIllllIlIIlI != 18 && lllllllllllllllIllIlIIllllIlIIlI != 20 && lllllllllllllllIllIlIIllllIlIIlI != 21 && lllllllllllllllIllIlIIllllIlIIlI != 22 && lllllllllllllllIllIlIIllllIlIIlI != 23) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type reference sort 0x").append(Integer.toHexString(lllllllllllllllIllIlIIllllIlIIlI))));
        }
        CheckClassAdapter.checkTypeRefAndPath(lllllllllllllllIllIlIIllllIlIllI, lllllllllllllllIllIlIIllllIIllll);
        CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIllllIlIlII, false);
        return new CheckAnnotationAdapter(super.visitTypeAnnotation(lllllllllllllllIllIlIIllllIlIllI, lllllllllllllllIllIlIIllllIIllll, lllllllllllllllIllIlIIllllIlIlII, lllllllllllllllIllIlIIllllIlIIll));
    }

    @Override
    public void visitInvokeDynamicInsn(String lllllllllllllllIllIlIIlIllIIlIII, String lllllllllllllllIllIlIIlIllIIllII, Handle lllllllllllllllIllIlIIlIllIIlIll, Object ... lllllllllllllllIllIlIIlIllIIlIlI) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIllIIlllI;
        lllllllllllllllIllIlIIlIllIIlllI.checkStartCode();
        lllllllllllllllIllIlIIlIllIIlllI.checkEndCode();
        CheckMethodAdapter.checkMethodIdentifier(lllllllllllllllIllIlIIlIllIIlllI.version, lllllllllllllllIllIlIIlIllIIlIII, "name");
        CheckMethodAdapter.checkMethodDesc(lllllllllllllllIllIlIIlIllIIllII);
        if (lllllllllllllllIllIlIIlIllIIlIll.getTag() != 6 && lllllllllllllllIllIlIIlIllIIlIll.getTag() != 8) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("invalid handle tag ").append(lllllllllllllllIllIlIIlIllIIlIll.getTag())));
        }
        for (int lllllllllllllllIllIlIIlIllIIllll = 0; lllllllllllllllIllIlIIlIllIIllll < lllllllllllllllIllIlIIlIllIIlIlI.length; ++lllllllllllllllIllIlIIlIllIIllll) {
            lllllllllllllllIllIlIIlIllIIlllI.checkLDCConstant(lllllllllllllllIllIlIIlIllIIlIlI[lllllllllllllllIllIlIIlIllIIllll]);
        }
        super.visitInvokeDynamicInsn(lllllllllllllllIllIlIIlIllIIlIII, lllllllllllllllIllIlIIlIllIIllII, lllllllllllllllIllIlIIlIllIIlIll, lllllllllllllllIllIlIIlIllIIlIlI);
        ++lllllllllllllllIllIlIIlIllIIlllI.insnCount;
    }

    @Override
    public void visitParameter(String lllllllllllllllIllIlIIllllllllll, int lllllllllllllllIllIlIlIIIIIIIIIl) {
        CheckMethodAdapter lllllllllllllllIllIlIlIIIIIIIIII;
        if (lllllllllllllllIllIlIIllllllllll != null) {
            CheckMethodAdapter.checkUnqualifiedName(lllllllllllllllIllIlIlIIIIIIIIII.version, lllllllllllllllIllIlIIllllllllll, "name");
        }
        CheckClassAdapter.checkAccess(lllllllllllllllIllIlIlIIIIIIIIIl, 36880);
        super.visitParameter(lllllllllllllllIllIlIIllllllllll, lllllllllllllllIllIlIlIIIIIIIIIl);
    }

    @Override
    public void visitAttribute(Attribute lllllllllllllllIllIlIIlllIlllIIl) {
        CheckMethodAdapter lllllllllllllllIllIlIIlllIlllIlI;
        lllllllllllllllIllIlIIlllIlllIlI.checkEndMethod();
        if (lllllllllllllllIllIlIIlllIlllIIl == null) {
            throw new IllegalArgumentException("Invalid attribute (must not be null)");
        }
        super.visitAttribute(lllllllllllllllIllIlIIlllIlllIIl);
    }

    @Override
    public void visitCode() {
        CheckMethodAdapter lllllllllllllllIllIlIIlllIllIlII;
        if ((lllllllllllllllIllIlIIlllIllIlII.access & 0x400) != 0) {
            throw new RuntimeException("Abstract methods cannot have code");
        }
        lllllllllllllllIllIlIIlllIllIlII.startCode = true;
        super.visitCode();
    }

    static void checkInternalName(String lllllllllllllllIllIlIIIlIllIlllI, int lllllllllllllllIllIlIIIlIlllIIlI, int lllllllllllllllIllIlIIIlIlllIIIl, String lllllllllllllllIllIlIIIlIllIlIll) {
        int lllllllllllllllIllIlIIIlIllIllll = lllllllllllllllIllIlIIIlIlllIIIl == -1 ? lllllllllllllllIllIlIIIlIllIlllI.length() : lllllllllllllllIllIlIIIlIlllIIIl;
        try {
            int lllllllllllllllIllIlIIIlIlllIlIl;
            int lllllllllllllllIllIlIIIlIlllIllI = lllllllllllllllIllIlIIIlIlllIIlI;
            do {
                if ((lllllllllllllllIllIlIIIlIlllIlIl = lllllllllllllllIllIlIIIlIllIlllI.indexOf(47, lllllllllllllllIllIlIIIlIlllIllI + 1)) == -1 || lllllllllllllllIllIlIIIlIlllIlIl > lllllllllllllllIllIlIIIlIllIllll) {
                    lllllllllllllllIllIlIIIlIlllIlIl = lllllllllllllllIllIlIIIlIllIllll;
                }
                CheckMethodAdapter.checkIdentifier(lllllllllllllllIllIlIIIlIllIlllI, lllllllllllllllIllIlIIIlIlllIllI, lllllllllllllllIllIlIIIlIlllIlIl, null);
                lllllllllllllllIllIlIIIlIlllIllI = lllllllllllllllIllIlIIIlIlllIlIl + 1;
            } while (lllllllllllllllIllIlIIIlIlllIlIl != lllllllllllllllIllIlIIIlIllIllll);
        }
        catch (IllegalArgumentException lllllllllllllllIllIlIIIlIlllIlII) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIlIllIlIll).append(" (must be a fully qualified class name in internal form): ").append(lllllllllllllllIllIlIIIlIllIlllI)));
        }
    }

    @Override
    public void visitLineNumber(int lllllllllllllllIllIlIIlIIIIIIIII, Label lllllllllllllllIllIlIIlIIIIIIIlI) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIIIIIIIIl;
        lllllllllllllllIllIlIIlIIIIIIIIl.checkStartCode();
        lllllllllllllllIllIlIIlIIIIIIIIl.checkEndCode();
        CheckMethodAdapter.checkUnsignedShort(lllllllllllllllIllIlIIlIIIIIIIII, "Invalid line number");
        lllllllllllllllIllIlIIlIIIIIIIIl.checkLabel(lllllllllllllllIllIlIIlIIIIIIIlI, true, "start label");
        super.visitLineNumber(lllllllllllllllIllIlIIlIIIIIIIII, lllllllllllllllIllIlIIlIIIIIIIlI);
    }

    @Override
    public void visitMaxs(int lllllllllllllllIllIlIIIlllllIIll, int lllllllllllllllIllIlIIIllllIllll) {
        CheckMethodAdapter lllllllllllllllIllIlIIIlllllIlII;
        lllllllllllllllIllIlIIIlllllIlII.checkStartCode();
        lllllllllllllllIllIlIIIlllllIlII.checkEndCode();
        lllllllllllllllIllIlIIIlllllIlII.endCode = true;
        for (Label lllllllllllllllIllIlIIIllllllIII : lllllllllllllllIllIlIIIlllllIlII.usedLabels) {
            if (lllllllllllllllIllIlIIIlllllIlII.labels.get(lllllllllllllllIllIlIIIllllllIII) != null) continue;
            throw new IllegalStateException("Undefined label used");
        }
        int lllllllllllllllIllIlIIIlllllIlIl = 0;
        while (lllllllllllllllIllIlIIIlllllIlIl < lllllllllllllllIllIlIIIlllllIlII.handlers.size()) {
            Integer lllllllllllllllIllIlIIIlllllIlll = lllllllllllllllIllIlIIIlllllIlII.labels.get(lllllllllllllllIllIlIIIlllllIlII.handlers.get(lllllllllllllllIllIlIIIlllllIlIl++));
            Integer lllllllllllllllIllIlIIIlllllIllI = lllllllllllllllIllIlIIIlllllIlII.labels.get(lllllllllllllllIllIlIIIlllllIlII.handlers.get(lllllllllllllllIllIlIIIlllllIlIl++));
            if (lllllllllllllllIllIlIIIlllllIlll == null || lllllllllllllllIllIlIIIlllllIllI == null) {
                throw new IllegalStateException("Undefined try catch block labels");
            }
            if (lllllllllllllllIllIlIIIlllllIllI > lllllllllllllllIllIlIIIlllllIlll) continue;
            throw new IllegalStateException("Emty try catch block handler range");
        }
        CheckMethodAdapter.checkUnsignedShort(lllllllllllllllIllIlIIIlllllIIll, "Invalid max stack");
        CheckMethodAdapter.checkUnsignedShort(lllllllllllllllIllIlIIIllllIllll, "Invalid max locals");
        super.visitMaxs(lllllllllllllllIllIlIIIlllllIIll, lllllllllllllllIllIlIIIllllIllll);
    }

    @Override
    public void visitEnd() {
        CheckMethodAdapter lllllllllllllllIllIlIIIllllIlIIl;
        lllllllllllllllIllIlIIIllllIlIIl.checkEndMethod();
        lllllllllllllllIllIlIIIllllIlIIl.endMethod = true;
        super.visitEnd();
    }

    @Override
    public void visitMethodInsn(int lllllllllllllllIllIlIIlIlllllIII, String lllllllllllllllIllIlIIllIIIIIIII, String lllllllllllllllIllIlIIlIllllIllI, String lllllllllllllllIllIlIIlIllllllIl, boolean lllllllllllllllIllIlIIlIllllllII) {
        CheckMethodAdapter lllllllllllllllIllIlIIllIIIIIIll;
        if (lllllllllllllllIllIlIIllIIIIIIll.api < 327680) {
            super.visitMethodInsn(lllllllllllllllIllIlIIlIlllllIII, lllllllllllllllIllIlIIllIIIIIIII, lllllllllllllllIllIlIIlIllllIllI, lllllllllllllllIllIlIIlIllllllIl, lllllllllllllllIllIlIIlIllllllII);
            return;
        }
        lllllllllllllllIllIlIIllIIIIIIll.doVisitMethodInsn(lllllllllllllllIllIlIIlIlllllIII, lllllllllllllllIllIlIIllIIIIIIII, lllllllllllllllIllIlIIlIllllIllI, lllllllllllllllIllIlIIlIllllllIl, lllllllllllllllIllIlIIlIllllllII);
    }

    static void checkDesc(String lllllllllllllllIllIlIIIlIllIIIIl, boolean lllllllllllllllIllIlIIIlIllIIIll) {
        int lllllllllllllllIllIlIIIlIllIIIlI = CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIIlIllIIIIl, 0, lllllllllllllllIllIlIIIlIllIIIll);
        if (lllllllllllllllIllIlIIIlIllIIIlI != lllllllllllllllIllIlIIIlIllIIIIl.length()) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lllllllllllllllIllIlIIIlIllIIIIl)));
        }
    }

    @Override
    public void visitJumpInsn(int lllllllllllllllIllIlIIlIlIllllll, Label lllllllllllllllIllIlIIlIlIlllIll) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIllIIIIII;
        lllllllllllllllIllIlIIlIllIIIIII.checkStartCode();
        lllllllllllllllIllIlIIlIllIIIIII.checkEndCode();
        CheckMethodAdapter.checkOpcode(lllllllllllllllIllIlIIlIlIllllll, 6);
        lllllllllllllllIllIlIIlIllIIIIII.checkLabel(lllllllllllllllIllIlIIlIlIlllIll, false, "label");
        CheckMethodAdapter.checkNonDebugLabel(lllllllllllllllIllIlIIlIlIlllIll);
        super.visitJumpInsn(lllllllllllllllIllIlIIlIlIllllll, lllllllllllllllIllIlIIlIlIlllIll);
        lllllllllllllllIllIlIIlIllIIIIII.usedLabels.add(lllllllllllllllIllIlIIlIlIlllIll);
        ++lllllllllllllllIllIlIIlIllIIIIII.insnCount;
    }

    private static void checkNonDebugLabel(Label lllllllllllllllIllIlIIIlIIllIlll) {
        Field lllllllllllllllIllIlIIIlIIllIllI = CheckMethodAdapter.getLabelStatusField();
        int lllllllllllllllIllIlIIIlIIllIlIl = 0;
        try {
            lllllllllllllllIllIlIIIlIIllIlIl = lllllllllllllllIllIlIIIlIIllIllI == null ? 0 : (Integer)lllllllllllllllIllIlIIIlIIllIllI.get(lllllllllllllllIllIlIIIlIIllIlll);
        }
        catch (IllegalAccessException lllllllllllllllIllIlIIIlIIlllIII) {
            throw new Error("Internal error");
        }
        if ((lllllllllllllllIllIlIIIlIIllIlIl & 1) != 0) {
            throw new IllegalArgumentException("Labels used for debug info cannot be reused for control flow");
        }
    }

    void checkEndMethod() {
        CheckMethodAdapter lllllllllllllllIllIlIIIllllIIIIl;
        if (lllllllllllllllIllIlIIIllllIIIIl.endMethod) {
            throw new IllegalStateException("Cannot visit elements after visitEnd has been called.");
        }
    }

    private static Field getLabelField(String lllllllllllllllIllIlIIIlIIlIlIll) {
        try {
            Field lllllllllllllllIllIlIIIlIIlIlllI = Label.class.getDeclaredField(lllllllllllllllIllIlIIIlIIlIlIll);
            lllllllllllllllIllIlIIIlIIlIlllI.setAccessible(true);
            return lllllllllllllllIllIlIIIlIIlIlllI;
        }
        catch (NoSuchFieldException lllllllllllllllIllIlIIIlIIlIllIl) {
            return null;
        }
    }

    @Override
    public void visitLabel(Label lllllllllllllllIllIlIIlIlIllIlIl) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIlIllIllI;
        lllllllllllllllIllIlIIlIlIllIllI.checkStartCode();
        lllllllllllllllIllIlIIlIlIllIllI.checkEndCode();
        lllllllllllllllIllIlIIlIlIllIllI.checkLabel(lllllllllllllllIllIlIIlIlIllIlIl, false, "label");
        if (lllllllllllllllIllIlIIlIlIllIllI.labels.get(lllllllllllllllIllIlIIlIlIllIlIl) != null) {
            throw new IllegalArgumentException("Already visited label");
        }
        lllllllllllllllIllIlIIlIlIllIllI.labels.put(lllllllllllllllIllIlIIlIlIllIlIl, lllllllllllllllIllIlIIlIlIllIllI.insnCount);
        super.visitLabel(lllllllllllllllIllIlIIlIlIllIlIl);
    }

    @Override
    public AnnotationVisitor visitAnnotationDefault() {
        CheckMethodAdapter lllllllllllllllIllIlIIllllIIlIIl;
        lllllllllllllllIllIlIIllllIIlIIl.checkEndMethod();
        return new CheckAnnotationAdapter(super.visitAnnotationDefault(), false);
    }

    @Override
    public void visitMultiANewArrayInsn(String lllllllllllllllIllIlIIlIIllllllI, int lllllllllllllllIllIlIIlIIllllIlI) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIIlllllII;
        lllllllllllllllIllIlIIlIIlllllII.checkStartCode();
        lllllllllllllllIllIlIIlIIlllllII.checkEndCode();
        CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIlIIllllllI, false);
        if (lllllllllllllllIllIlIIlIIllllllI.charAt(0) != '[') {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor (must be an array type descriptor): ").append(lllllllllllllllIllIlIIlIIllllllI)));
        }
        if (lllllllllllllllIllIlIIlIIllllIlI < 1) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid dimensions (must be greater than 0): ").append(lllllllllllllllIllIlIIlIIllllIlI)));
        }
        if (lllllllllllllllIllIlIIlIIllllIlI > lllllllllllllllIllIlIIlIIllllllI.lastIndexOf(91) + 1) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid dimensions (must not be greater than dims(desc)): ").append(lllllllllllllllIllIlIIlIIllllIlI)));
        }
        super.visitMultiANewArrayInsn(lllllllllllllllIllIlIIlIIllllllI, lllllllllllllllIllIlIIlIIllllIlI);
        ++lllllllllllllllIllIlIIlIIlllllII.insnCount;
    }

    static void checkIdentifier(String lllllllllllllllIllIlIIIllIIlIllI, int lllllllllllllllIllIlIIIllIIlIlIl, int lllllllllllllllIllIlIIIllIIllIIl, String lllllllllllllllIllIlIIIllIIlIIll) {
        if (lllllllllllllllIllIlIIIllIIlIllI == null || (lllllllllllllllIllIlIIIllIIllIIl == -1 ? lllllllllllllllIllIlIIIllIIlIllI.length() <= lllllllllllllllIllIlIIIllIIlIlIl : lllllllllllllllIllIlIIIllIIllIIl <= lllllllllllllllIllIlIIIllIIlIlIl)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIllIIlIIll).append(" (must not be null or empty)")));
        }
        if (!Character.isJavaIdentifierStart(lllllllllllllllIllIlIIIllIIlIllI.charAt(lllllllllllllllIllIlIIIllIIlIlIl))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIllIIlIIll).append(" (must be a valid Java identifier): ").append(lllllllllllllllIllIlIIIllIIlIllI)));
        }
        int lllllllllllllllIllIlIIIllIIlIlll = lllllllllllllllIllIlIIIllIIllIIl == -1 ? lllllllllllllllIllIlIIIllIIlIllI.length() : lllllllllllllllIllIlIIIllIIllIIl;
        for (int lllllllllllllllIllIlIIIllIIlllII = lllllllllllllllIllIlIIIllIIlIlIl + 1; lllllllllllllllIllIlIIIllIIlllII < lllllllllllllllIllIlIIIllIIlIlll; ++lllllllllllllllIllIlIIIllIIlllII) {
            if (Character.isJavaIdentifierPart(lllllllllllllllIllIlIIIllIIlIllI.charAt(lllllllllllllllIllIlIIIllIIlllII))) continue;
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIllIIlIIll).append(" (must be a valid Java identifier): ").append(lllllllllllllllIllIlIIIllIIlIllI)));
        }
    }

    @Override
    @Deprecated
    public void visitMethodInsn(int lllllllllllllllIllIlIIllIIIllIII, String lllllllllllllllIllIlIIllIIIlIllI, String lllllllllllllllIllIlIIllIIIlIlII, String lllllllllllllllIllIlIIllIIIllIll) {
        CheckMethodAdapter lllllllllllllllIllIlIIllIIIllIIl;
        if (lllllllllllllllIllIlIIllIIIllIIl.api >= 327680) {
            super.visitMethodInsn(lllllllllllllllIllIlIIllIIIllIII, lllllllllllllllIllIlIIllIIIlIllI, lllllllllllllllIllIlIIllIIIlIlII, lllllllllllllllIllIlIIllIIIllIll);
            return;
        }
        lllllllllllllllIllIlIIllIIIllIIl.doVisitMethodInsn(lllllllllllllllIllIlIIllIIIllIII, lllllllllllllllIllIlIIllIIIlIllI, lllllllllllllllIllIlIIllIIIlIlII, lllllllllllllllIllIlIIllIIIllIll, lllllllllllllllIllIlIIllIIIllIII == 185);
    }

    @Override
    public AnnotationVisitor visitParameterAnnotation(int lllllllllllllllIllIlIIlllIllllll, String lllllllllllllllIllIlIIlllIlllllI, boolean lllllllllllllllIllIlIIlllIllllIl) {
        CheckMethodAdapter lllllllllllllllIllIlIIllllIIIlII;
        lllllllllllllllIllIlIIllllIIIlII.checkEndMethod();
        CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIlllIlllllI, false);
        return new CheckAnnotationAdapter(super.visitParameterAnnotation(lllllllllllllllIllIlIIlllIllllll, lllllllllllllllIllIlIIlllIlllllI, lllllllllllllllIllIlIIlllIllllIl));
    }

    static void checkInternalName(String lllllllllllllllIllIlIIIlIlllllll, String lllllllllllllllIllIlIIIllIIIIIII) {
        if (lllllllllllllllIllIlIIIlIlllllll == null || lllllllllllllllIllIlIIIlIlllllll.length() == 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIllIIIIIII).append(" (must not be null or empty)")));
        }
        if (lllllllllllllllIllIlIIIlIlllllll.charAt(0) == '[') {
            CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIIlIlllllll, false);
        } else {
            CheckMethodAdapter.checkInternalName(lllllllllllllllIllIlIIIlIlllllll, 0, -1, lllllllllllllllIllIlIIIllIIIIIII);
        }
    }

    @Override
    public void visitFieldInsn(int lllllllllllllllIllIlIIllIIlllIIl, String lllllllllllllllIllIlIIllIIlllIII, String lllllllllllllllIllIlIIllIIllIlll, String lllllllllllllllIllIlIIllIIllIIIl) {
        CheckMethodAdapter lllllllllllllllIllIlIIllIIllIlIl;
        lllllllllllllllIllIlIIllIIllIlIl.checkStartCode();
        lllllllllllllllIllIlIIllIIllIlIl.checkEndCode();
        CheckMethodAdapter.checkOpcode(lllllllllllllllIllIlIIllIIlllIIl, 4);
        CheckMethodAdapter.checkInternalName(lllllllllllllllIllIlIIllIIlllIII, "owner");
        CheckMethodAdapter.checkUnqualifiedName(lllllllllllllllIllIlIIllIIllIlIl.version, lllllllllllllllIllIlIIllIIllIlll, "name");
        CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIllIIllIIIl, false);
        super.visitFieldInsn(lllllllllllllllIllIlIIllIIlllIIl, lllllllllllllllIllIlIIllIIlllIII, lllllllllllllllIllIlIIllIIllIlll, lllllllllllllllIllIlIIllIIllIIIl);
        ++lllllllllllllllIllIlIIllIIllIlIl.insnCount;
    }

    static void checkMethodDesc(String lllllllllllllllIllIlIIIlIlIIlIlI) {
        if (lllllllllllllllIllIlIIIlIlIIlIlI == null || lllllllllllllllIllIlIIIlIlIIlIlI.length() == 0) {
            throw new IllegalArgumentException("Invalid method descriptor (must not be null or empty)");
        }
        if (lllllllllllllllIllIlIIIlIlIIlIlI.charAt(0) != '(' || lllllllllllllllIllIlIIIlIlIIlIlI.length() < 3) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lllllllllllllllIllIlIIIlIlIIlIlI)));
        }
        int lllllllllllllllIllIlIIIlIlIIlIll = 1;
        if (lllllllllllllllIllIlIIIlIlIIlIlI.charAt(lllllllllllllllIllIlIIIlIlIIlIll) != ')') {
            do {
                if (lllllllllllllllIllIlIIIlIlIIlIlI.charAt(lllllllllllllllIllIlIIIlIlIIlIll) != 'V') continue;
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lllllllllllllllIllIlIIIlIlIIlIlI)));
            } while ((lllllllllllllllIllIlIIIlIlIIlIll = CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIIlIlIIlIlI, lllllllllllllllIllIlIIIlIlIIlIll, false)) < lllllllllllllllIllIlIIIlIlIIlIlI.length() && lllllllllllllllIllIlIIIlIlIIlIlI.charAt(lllllllllllllllIllIlIIIlIlIIlIll) != ')');
        }
        if ((lllllllllllllllIllIlIIIlIlIIlIll = CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIIlIlIIlIlI, lllllllllllllllIllIlIIIlIlIIlIll + 1, true)) != lllllllllllllllIllIlIIIlIlIIlIlI.length()) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid descriptor: ").append(lllllllllllllllIllIlIIIlIlIIlIlI)));
        }
    }

    @Override
    public void visitIntInsn(int lllllllllllllllIllIlIIllIlIlIllI, int lllllllllllllllIllIlIIllIlIlIlIl) {
        CheckMethodAdapter lllllllllllllllIllIlIIllIlIlIlll;
        lllllllllllllllIllIlIIllIlIlIlll.checkStartCode();
        lllllllllllllllIllIlIIllIlIlIlll.checkEndCode();
        CheckMethodAdapter.checkOpcode(lllllllllllllllIllIlIIllIlIlIllI, 1);
        switch (lllllllllllllllIllIlIIllIlIlIllI) {
            case 16: {
                CheckMethodAdapter.checkSignedByte(lllllllllllllllIllIlIIllIlIlIlIl, "Invalid operand");
                break;
            }
            case 17: {
                CheckMethodAdapter.checkSignedShort(lllllllllllllllIllIlIIllIlIlIlIl, "Invalid operand");
                break;
            }
            default: {
                if (lllllllllllllllIllIlIIllIlIlIlIl >= 4 && lllllllllllllllIllIlIIllIlIlIlIl <= 11) break;
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid operand (must be an array type code T_...): ").append(lllllllllllllllIllIlIIllIlIlIlIl)));
            }
        }
        super.visitIntInsn(lllllllllllllllIllIlIIllIlIlIllI, lllllllllllllllIllIlIIllIlIlIlIl);
        ++lllllllllllllllIllIlIIllIlIlIlll.insnCount;
    }

    void checkLDCConstant(Object lllllllllllllllIllIlIIIllIlllIII) {
        CheckMethodAdapter lllllllllllllllIllIlIIIllIllIlll;
        if (lllllllllllllllIllIlIIIllIlllIII instanceof Type) {
            int lllllllllllllllIllIlIIIllIlllIll = ((Type)lllllllllllllllIllIlIIIllIlllIII).getSort();
            if (lllllllllllllllIllIlIIIllIlllIll != 10 && lllllllllllllllIllIlIIIllIlllIll != 9 && lllllllllllllllIllIlIIIllIlllIll != 11) {
                throw new IllegalArgumentException("Illegal LDC constant value");
            }
            if (lllllllllllllllIllIlIIIllIlllIll != 11 && (lllllllllllllllIllIlIIIllIllIlll.version & 0xFFFF) < 49) {
                throw new IllegalArgumentException("ldc of a constant class requires at least version 1.5");
            }
            if (lllllllllllllllIllIlIIIllIlllIll == 11 && (lllllllllllllllIllIlIIIllIllIlll.version & 0xFFFF) < 51) {
                throw new IllegalArgumentException("ldc of a method type requires at least version 1.7");
            }
        } else if (lllllllllllllllIllIlIIIllIlllIII instanceof Handle) {
            if ((lllllllllllllllIllIlIIIllIllIlll.version & 0xFFFF) < 51) {
                throw new IllegalArgumentException("ldc of a handle requires at least version 1.7");
            }
            int lllllllllllllllIllIlIIIllIlllIlI = ((Handle)lllllllllllllllIllIlIIIllIlllIII).getTag();
            if (lllllllllllllllIllIlIIIllIlllIlI < 1 || lllllllllllllllIllIlIIIllIlllIlI > 9) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("invalid handle tag ").append(lllllllllllllllIllIlIIIllIlllIlI)));
            }
        } else {
            CheckMethodAdapter.checkConstant(lllllllllllllllIllIlIIIllIlllIII);
        }
    }

    @Override
    public void visitLdcInsn(Object lllllllllllllllIllIlIIlIlIlIllll) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIlIllIIlI;
        lllllllllllllllIllIlIIlIlIllIIlI.checkStartCode();
        lllllllllllllllIllIlIIlIlIllIIlI.checkEndCode();
        lllllllllllllllIllIlIIlIlIllIIlI.checkLDCConstant(lllllllllllllllIllIlIIlIlIlIllll);
        super.visitLdcInsn(lllllllllllllllIllIlIIlIlIlIllll);
        ++lllllllllllllllIllIlIIlIlIllIIlI.insnCount;
    }

    @Override
    public void visitTypeInsn(int lllllllllllllllIllIlIIllIlIIIlII, String lllllllllllllllIllIlIIllIlIIIIII) {
        CheckMethodAdapter lllllllllllllllIllIlIIllIlIIIIlI;
        lllllllllllllllIllIlIIllIlIIIIlI.checkStartCode();
        lllllllllllllllIllIlIIllIlIIIIlI.checkEndCode();
        CheckMethodAdapter.checkOpcode(lllllllllllllllIllIlIIllIlIIIlII, 3);
        CheckMethodAdapter.checkInternalName(lllllllllllllllIllIlIIllIlIIIIII, "type");
        if (lllllllllllllllIllIlIIllIlIIIlII == 187 && lllllllllllllllIllIlIIllIlIIIIII.charAt(0) == '[') {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("NEW cannot be used to create arrays: ").append(lllllllllllllllIllIlIIllIlIIIIII)));
        }
        super.visitTypeInsn(lllllllllllllllIllIlIIllIlIIIlII, lllllllllllllllIllIlIIllIlIIIIII);
        ++lllllllllllllllIllIlIIllIlIIIIlI.insnCount;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String lllllllllllllllIllIlIIlllllllIIl, boolean lllllllllllllllIllIlIIllllllIlll) {
        CheckMethodAdapter lllllllllllllllIllIlIIlllllllIlI;
        lllllllllllllllIllIlIIlllllllIlI.checkEndMethod();
        CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIlllllllIIl, false);
        return new CheckAnnotationAdapter(super.visitAnnotation(lllllllllllllllIllIlIIlllllllIIl, lllllllllllllllIllIlIIllllllIlll));
    }

    static void checkUnqualifiedName(int lllllllllllllllIllIlIIIllIlIllll, String lllllllllllllllIllIlIIIllIlIlIll, String lllllllllllllllIllIlIIIllIlIlIlI) {
        if ((lllllllllllllllIllIlIIIllIlIllll & 0xFFFF) < 49) {
            CheckMethodAdapter.checkIdentifier(lllllllllllllllIllIlIIIllIlIlIll, lllllllllllllllIllIlIIIllIlIlIlI);
        } else {
            for (int lllllllllllllllIllIlIIIllIllIIII = 0; lllllllllllllllIllIlIIIllIllIIII < lllllllllllllllIllIlIIIllIlIlIll.length(); ++lllllllllllllllIllIlIIIllIllIIII) {
                if (".;[/".indexOf(lllllllllllllllIllIlIIIllIlIlIll.charAt(lllllllllllllllIllIlIIIllIllIIII)) == -1) continue;
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIllIlIlIlI).append(" (must be a valid unqualified name): ").append(lllllllllllllllIllIlIIIllIlIlIll)));
            }
        }
    }

    void checkEndCode() {
        CheckMethodAdapter lllllllllllllllIllIlIIIllllIIIll;
        if (lllllllllllllllIllIlIIIllllIIIll.endCode) {
            throw new IllegalStateException("Cannot visit instructions after visitMaxs has been called.");
        }
    }

    static void checkUnsignedShort(int lllllllllllllllIllIlIIIlllIIIIll, String lllllllllllllllIllIlIIIlllIIIlII) {
        if (lllllllllllllllIllIlIIIlllIIIIll < 0 || lllllllllllllllIllIlIIIlllIIIIll > 65535) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(lllllllllllllllIllIlIIIlllIIIlII).append(" (must be an unsigned short): ").append(lllllllllllllllIllIlIIIlllIIIIll)));
        }
    }

    @Override
    public AnnotationVisitor visitInsnAnnotation(int lllllllllllllllIllIlIIlIIlllIIlI, TypePath lllllllllllllllIllIlIIlIIlllIIIl, String lllllllllllllllIllIlIIlIIlllIIII, boolean lllllllllllllllIllIlIIlIIllIllll) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIIlllIIll;
        lllllllllllllllIllIlIIlIIlllIIll.checkStartCode();
        lllllllllllllllIllIlIIlIIlllIIll.checkEndCode();
        int lllllllllllllllIllIlIIlIIllIlllI = lllllllllllllllIllIlIIlIIlllIIlI >>> 24;
        if (lllllllllllllllIllIlIIlIIllIlllI != 67 && lllllllllllllllIllIlIIlIIllIlllI != 68 && lllllllllllllllIllIlIIlIIllIlllI != 69 && lllllllllllllllIllIlIIlIIllIlllI != 70 && lllllllllllllllIllIlIIlIIllIlllI != 71 && lllllllllllllllIllIlIIlIIllIlllI != 72 && lllllllllllllllIllIlIIlIIllIlllI != 73 && lllllllllllllllIllIlIIlIIllIlllI != 74 && lllllllllllllllIllIlIIlIIllIlllI != 75) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type reference sort 0x").append(Integer.toHexString(lllllllllllllllIllIlIIlIIllIlllI))));
        }
        CheckClassAdapter.checkTypeRefAndPath(lllllllllllllllIllIlIIlIIlllIIlI, lllllllllllllllIllIlIIlIIlllIIIl);
        CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIlIIlllIIII, false);
        return new CheckAnnotationAdapter(super.visitInsnAnnotation(lllllllllllllllIllIlIIlIIlllIIlI, lllllllllllllllIllIlIIlIIlllIIIl, lllllllllllllllIllIlIIlIIlllIIII, lllllllllllllllIllIlIIlIIllIllll));
    }

    static void checkOpcode(int lllllllllllllllIllIlIIIlllIlIlll, int lllllllllllllllIllIlIIIlllIlIlII) {
        if (lllllllllllllllIllIlIIIlllIlIlll < 0 || lllllllllllllllIllIlIIIlllIlIlll > 199 || TYPE[lllllllllllllllIllIlIIIlllIlIlll] != lllllllllllllllIllIlIIIlllIlIlII) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid opcode: ").append(lllllllllllllllIllIlIIIlllIlIlll)));
        }
    }

    @Override
    public void visitLocalVariable(String lllllllllllllllIllIlIIlIIIllIIll, String lllllllllllllllIllIlIIlIIIllIIlI, String lllllllllllllllIllIlIIlIIIlllIlI, Label lllllllllllllllIllIlIIlIIIlllIIl, Label lllllllllllllllIllIlIIlIIIlllIII, int lllllllllllllllIllIlIIlIIIlIlllI) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIIIllllIl;
        lllllllllllllllIllIlIIlIIIllllIl.checkStartCode();
        lllllllllllllllIllIlIIlIIIllllIl.checkEndCode();
        CheckMethodAdapter.checkUnqualifiedName(lllllllllllllllIllIlIIlIIIllllIl.version, lllllllllllllllIllIlIIlIIIllIIll, "name");
        CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIlIIIllIIlI, false);
        lllllllllllllllIllIlIIlIIIllllIl.checkLabel(lllllllllllllllIllIlIIlIIIlllIIl, true, "start label");
        lllllllllllllllIllIlIIlIIIllllIl.checkLabel(lllllllllllllllIllIlIIlIIIlllIII, true, "end label");
        CheckMethodAdapter.checkUnsignedShort(lllllllllllllllIllIlIIlIIIlIlllI, "Invalid variable index");
        int lllllllllllllllIllIlIIlIIIllIllI = lllllllllllllllIllIlIIlIIIllllIl.labels.get(lllllllllllllllIllIlIIlIIIlllIIl);
        int lllllllllllllllIllIlIIlIIIllIlIl = lllllllllllllllIllIlIIlIIIllllIl.labels.get(lllllllllllllllIllIlIIlIIIlllIII);
        if (lllllllllllllllIllIlIIlIIIllIlIl < lllllllllllllllIllIlIIlIIIllIllI) {
            throw new IllegalArgumentException("Invalid start and end labels (end must be greater than start)");
        }
        super.visitLocalVariable(lllllllllllllllIllIlIIlIIIllIIll, lllllllllllllllIllIlIIlIIIllIIlI, lllllllllllllllIllIlIIlIIIlllIlI, lllllllllllllllIllIlIIlIIIlllIIl, lllllllllllllllIllIlIIlIIIlllIII, lllllllllllllllIllIlIIlIIIlIlllI);
    }

    static void checkConstant(Object lllllllllllllllIllIlIIIllIllllll) {
        if (!(lllllllllllllllIllIlIIIllIllllll instanceof Integer || lllllllllllllllIllIlIIIllIllllll instanceof Float || lllllllllllllllIllIlIIIllIllllll instanceof Long || lllllllllllllllIllIlIIIllIllllll instanceof Double || lllllllllllllllIllIlIIIllIllllll instanceof String)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid constant: ").append(lllllllllllllllIllIlIIIllIllllll)));
        }
    }

    @Override
    public void visitTableSwitchInsn(int lllllllllllllllIllIlIIlIlIIlllII, int lllllllllllllllIllIlIIlIlIIllIll, Label lllllllllllllllIllIlIIlIlIIlIlIl, Label ... lllllllllllllllIllIlIIlIlIIlIlII) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIlIIlllIl;
        lllllllllllllllIllIlIIlIlIIlllIl.checkStartCode();
        lllllllllllllllIllIlIIlIlIIlllIl.checkEndCode();
        if (lllllllllllllllIllIlIIlIlIIllIll < lllllllllllllllIllIlIIlIlIIlllII) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Max = ").append(lllllllllllllllIllIlIIlIlIIllIll).append(" must be greater than or equal to min = ").append(lllllllllllllllIllIlIIlIlIIlllII)));
        }
        lllllllllllllllIllIlIIlIlIIlllIl.checkLabel(lllllllllllllllIllIlIIlIlIIlIlIl, false, "default label");
        CheckMethodAdapter.checkNonDebugLabel(lllllllllllllllIllIlIIlIlIIlIlIl);
        if (lllllllllllllllIllIlIIlIlIIlIlII == null || lllllllllllllllIllIlIIlIlIIlIlII.length != lllllllllllllllIllIlIIlIlIIllIll - lllllllllllllllIllIlIIlIlIIlllII + 1) {
            throw new IllegalArgumentException("There must be max - min + 1 labels");
        }
        for (int lllllllllllllllIllIlIIlIlIIlllll = 0; lllllllllllllllIllIlIIlIlIIlllll < lllllllllllllllIllIlIIlIlIIlIlII.length; ++lllllllllllllllIllIlIIlIlIIlllll) {
            lllllllllllllllIllIlIIlIlIIlllIl.checkLabel(lllllllllllllllIllIlIIlIlIIlIlII[lllllllllllllllIllIlIIlIlIIlllll], false, String.valueOf(new StringBuilder().append("label at index ").append(lllllllllllllllIllIlIIlIlIIlllll)));
            CheckMethodAdapter.checkNonDebugLabel(lllllllllllllllIllIlIIlIlIIlIlII[lllllllllllllllIllIlIIlIlIIlllll]);
        }
        super.visitTableSwitchInsn(lllllllllllllllIllIlIIlIlIIlllII, lllllllllllllllIllIlIIlIlIIllIll, lllllllllllllllIllIlIIlIlIIlIlIl, lllllllllllllllIllIlIIlIlIIlIlII);
        for (int lllllllllllllllIllIlIIlIlIIllllI = 0; lllllllllllllllIllIlIIlIlIIllllI < lllllllllllllllIllIlIIlIlIIlIlII.length; ++lllllllllllllllIllIlIIlIlIIllllI) {
            lllllllllllllllIllIlIIlIlIIlllIl.usedLabels.add(lllllllllllllllIllIlIIlIlIIlIlII[lllllllllllllllIllIlIIlIlIIllllI]);
        }
        ++lllllllllllllllIllIlIIlIlIIlllIl.insnCount;
    }

    private static Field getLabelStatusField() {
        if (labelStatusField == null && (labelStatusField = CheckMethodAdapter.getLabelField("a")) == null) {
            labelStatusField = CheckMethodAdapter.getLabelField("status");
        }
        return labelStatusField;
    }

    protected CheckMethodAdapter(int lllllllllllllllIllIlIlIIIIIlllll, MethodVisitor lllllllllllllllIllIlIlIIIIIllllI, Map<Label, Integer> lllllllllllllllIllIlIlIIIIIlllIl) {
        super(lllllllllllllllIllIlIlIIIIIlllll, lllllllllllllllIllIlIlIIIIIllllI);
        CheckMethodAdapter lllllllllllllllIllIlIlIIIIlIIIII;
        lllllllllllllllIllIlIlIIIIlIIIII.lastFrame = -1;
        lllllllllllllllIllIlIlIIIIlIIIII.labels = lllllllllllllllIllIlIlIIIIIlllIl;
        lllllllllllllllIllIlIlIIIIlIIIII.usedLabels = new HashSet<Label>();
        lllllllllllllllIllIlIlIIIIlIIIII.handlers = new ArrayList<Label>();
    }

    static void checkSignedByte(int lllllllllllllllIllIlIIIlllIIllll, String lllllllllllllllIllIlIIIlllIIlllI) {
        if (lllllllllllllllIllIlIIIlllIIllll < -128 || lllllllllllllllIllIlIIIlllIIllll > 127) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(lllllllllllllllIllIlIIIlllIIlllI).append(" (must be a signed byte): ").append(lllllllllllllllIllIlIIIlllIIllll)));
        }
    }

    public CheckMethodAdapter(MethodVisitor lllllllllllllllIllIlIlIIIIlIlIIl, Map<Label, Integer> lllllllllllllllIllIlIlIIIIlIlIII) {
        lllllllllllllllIllIlIlIIIIlIIlll(327680, lllllllllllllllIllIlIlIIIIlIlIIl, lllllllllllllllIllIlIlIIIIlIlIII);
        CheckMethodAdapter lllllllllllllllIllIlIlIIIIlIIlll;
        if (lllllllllllllllIllIlIlIIIIlIIlll.getClass() != CheckMethodAdapter.class) {
            throw new IllegalStateException();
        }
    }

    @Override
    public void visitIincInsn(int lllllllllllllllIllIlIIlIlIlIlIlI, int lllllllllllllllIllIlIIlIlIlIIllI) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIlIlIlIll;
        lllllllllllllllIllIlIIlIlIlIlIll.checkStartCode();
        lllllllllllllllIllIlIIlIlIlIlIll.checkEndCode();
        CheckMethodAdapter.checkUnsignedShort(lllllllllllllllIllIlIIlIlIlIlIlI, "Invalid variable index");
        CheckMethodAdapter.checkSignedShort(lllllllllllllllIllIlIIlIlIlIIllI, "Invalid increment");
        super.visitIincInsn(lllllllllllllllIllIlIIlIlIlIlIlI, lllllllllllllllIllIlIIlIlIlIIllI);
        ++lllllllllllllllIllIlIIlIlIlIlIll.insnCount;
    }

    void checkLabel(Label lllllllllllllllIllIlIIIlIIllllll, boolean lllllllllllllllIllIlIIIlIIlllllI, String lllllllllllllllIllIlIIIlIIllllIl) {
        CheckMethodAdapter lllllllllllllllIllIlIIIlIlIIIlII;
        if (lllllllllllllllIllIlIIIlIIllllll == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIlIIllllIl).append(" (must not be null)")));
        }
        if (lllllllllllllllIllIlIIIlIIlllllI && lllllllllllllllIllIlIIIlIlIIIlII.labels.get(lllllllllllllllIllIlIIIlIIllllll) == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid ").append(lllllllllllllllIllIlIIIlIIllllIl).append(" (must be visited first)")));
        }
    }

    static void checkSignedShort(int lllllllllllllllIllIlIIIlllIIlIIl, String lllllllllllllllIllIlIIIlllIIlIII) {
        if (lllllllllllllllIllIlIIIlllIIlIIl < Short.MIN_VALUE || lllllllllllllllIllIlIIIlllIIlIIl > Short.MAX_VALUE) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(lllllllllllllllIllIlIIIlllIIlIII).append(" (must be a signed short): ").append(lllllllllllllllIllIlIIIlllIIlIIl)));
        }
    }

    @Override
    public AnnotationVisitor visitLocalVariableAnnotation(int lllllllllllllllIllIlIIlIIIIlIIlI, TypePath lllllllllllllllIllIlIIlIIIIllIlI, Label[] lllllllllllllllIllIlIIlIIIIllIIl, Label[] lllllllllllllllIllIlIIlIIIIIllll, int[] lllllllllllllllIllIlIIlIIIIlIlll, String lllllllllllllllIllIlIIlIIIIIllIl, boolean lllllllllllllllIllIlIIlIIIIlIlIl) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIIIIlIIll;
        lllllllllllllllIllIlIIlIIIIlIIll.checkStartCode();
        lllllllllllllllIllIlIIlIIIIlIIll.checkEndCode();
        int lllllllllllllllIllIlIIlIIIIlIlII = lllllllllllllllIllIlIIlIIIIlIIlI >>> 24;
        if (lllllllllllllllIllIlIIlIIIIlIlII != 64 && lllllllllllllllIllIlIIlIIIIlIlII != 65) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type reference sort 0x").append(Integer.toHexString(lllllllllllllllIllIlIIlIIIIlIlII))));
        }
        CheckClassAdapter.checkTypeRefAndPath(lllllllllllllllIllIlIIlIIIIlIIlI, lllllllllllllllIllIlIIlIIIIllIlI);
        CheckMethodAdapter.checkDesc(lllllllllllllllIllIlIIlIIIIIllIl, false);
        if (lllllllllllllllIllIlIIlIIIIllIIl == null || lllllllllllllllIllIlIIlIIIIIllll == null || lllllllllllllllIllIlIIlIIIIlIlll == null || lllllllllllllllIllIlIIlIIIIIllll.length != lllllllllllllllIllIlIIlIIIIllIIl.length || lllllllllllllllIllIlIIlIIIIlIlll.length != lllllllllllllllIllIlIIlIIIIllIIl.length) {
            throw new IllegalArgumentException("Invalid start, end and index arrays (must be non null and of identical length");
        }
        for (int lllllllllllllllIllIlIIlIIIIlllIl = 0; lllllllllllllllIllIlIIlIIIIlllIl < lllllllllllllllIllIlIIlIIIIllIIl.length; ++lllllllllllllllIllIlIIlIIIIlllIl) {
            lllllllllllllllIllIlIIlIIIIlIIll.checkLabel(lllllllllllllllIllIlIIlIIIIllIIl[lllllllllllllllIllIlIIlIIIIlllIl], true, "start label");
            lllllllllllllllIllIlIIlIIIIlIIll.checkLabel(lllllllllllllllIllIlIIlIIIIIllll[lllllllllllllllIllIlIIlIIIIlllIl], true, "end label");
            CheckMethodAdapter.checkUnsignedShort(lllllllllllllllIllIlIIlIIIIlIlll[lllllllllllllllIllIlIIlIIIIlllIl], "Invalid variable index");
            int lllllllllllllllIllIlIIlIIIIlllll = lllllllllllllllIllIlIIlIIIIlIIll.labels.get(lllllllllllllllIllIlIIlIIIIllIIl[lllllllllllllllIllIlIIlIIIIlllIl]);
            int lllllllllllllllIllIlIIlIIIIllllI = lllllllllllllllIllIlIIlIIIIlIIll.labels.get(lllllllllllllllIllIlIIlIIIIIllll[lllllllllllllllIllIlIIlIIIIlllIl]);
            if (lllllllllllllllIllIlIIlIIIIllllI >= lllllllllllllllIllIlIIlIIIIlllll) continue;
            throw new IllegalArgumentException("Invalid start and end labels (end must be greater than start)");
        }
        return super.visitLocalVariableAnnotation(lllllllllllllllIllIlIIlIIIIlIIlI, lllllllllllllllIllIlIIlIIIIllIlI, lllllllllllllllIllIlIIlIIIIllIIl, lllllllllllllllIllIlIIlIIIIIllll, lllllllllllllllIllIlIIlIIIIlIlll, lllllllllllllllIllIlIIlIIIIIllIl, lllllllllllllllIllIlIIlIIIIlIlIl);
    }

    public CheckMethodAdapter(int lllllllllllllllIllIlIlIIIIIIlIll, String lllllllllllllllIllIlIlIIIIIIlIlI, String lllllllllllllllIllIlIlIIIIIIllll, final MethodVisitor lllllllllllllllIllIlIlIIIIIIlIII, Map<Label, Integer> lllllllllllllllIllIlIlIIIIIIllIl) {
        lllllllllllllllIllIlIlIIIIIIllII(new MethodNode(327680, lllllllllllllllIllIlIlIIIIIIlIll, lllllllllllllllIllIlIlIIIIIIlIlI, lllllllllllllllIllIlIlIIIIIIllll, null, null){
            {
                1 lIIIIlllIIllllI;
                super(lIIIIlllIIlllII, lIIIIlllIlIllIl, lIIIIlllIIllIII, lIIIIlllIlIIllI, lIIIIlllIlIIIll, lIIIIlllIIlIlIl);
            }

            public void visitEnd() {
                1 lIIIIllIllIIlII;
                Analyzer<BasicValue> lIIIIllIllIIllI = new Analyzer<BasicValue>(new BasicVerifier());
                try {
                    lIIIIllIllIIllI.analyze("dummy", lIIIIllIllIIlII);
                }
                catch (Exception lIIIIllIllIlIlI) {
                    if (lIIIIllIllIlIlI instanceof IndexOutOfBoundsException && lIIIIllIllIIlII.maxLocals == 0 && lIIIIllIllIIlII.maxStack == 0) {
                        throw new RuntimeException("Data flow checking option requires valid, non zero maxLocals and maxStack values.");
                    }
                    lIIIIllIllIlIlI.printStackTrace();
                    StringWriter lIIIIllIllIllIl = new StringWriter();
                    PrintWriter lIIIIllIllIllII = new PrintWriter(lIIIIllIllIllIl, true);
                    CheckClassAdapter.printAnalyzerResult(lIIIIllIllIIlII, lIIIIllIllIIllI, lIIIIllIllIllII);
                    lIIIIllIllIllII.close();
                    throw new RuntimeException(String.valueOf(new StringBuilder().append(lIIIIllIllIlIlI.getMessage()).append(' ').append(lIIIIllIllIllIl.toString())));
                }
                lIIIIllIllIIlII.accept(lIIIIllIllIIlII.lllllllllllllllIllIlIlIIIIIIlIII);
            }
        }, lllllllllllllllIllIlIlIIIIIIllIl);
        CheckMethodAdapter lllllllllllllllIllIlIlIIIIIIllII;
        lllllllllllllllIllIlIlIIIIIIllII.access = lllllllllllllllIllIlIlIIIIIIlIll;
    }

    public CheckMethodAdapter(MethodVisitor lllllllllllllllIllIlIlIIIIllIIII) {
        lllllllllllllllIllIlIlIIIIllIIIl(lllllllllllllllIllIlIlIIIIllIIII, new HashMap<Label, Integer>());
        CheckMethodAdapter lllllllllllllllIllIlIlIIIIllIIIl;
    }

    @Override
    public void visitTryCatchBlock(Label lllllllllllllllIllIlIIlIIlIlllII, Label lllllllllllllllIllIlIIlIIllIIIII, Label lllllllllllllllIllIlIIlIIlIllIlI, String lllllllllllllllIllIlIIlIIlIllIIl) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIIlIlllIl;
        lllllllllllllllIllIlIIlIIlIlllIl.checkStartCode();
        lllllllllllllllIllIlIIlIIlIlllIl.checkEndCode();
        lllllllllllllllIllIlIIlIIlIlllIl.checkLabel(lllllllllllllllIllIlIIlIIlIlllII, false, "start label");
        lllllllllllllllIllIlIIlIIlIlllIl.checkLabel(lllllllllllllllIllIlIIlIIllIIIII, false, "end label");
        lllllllllllllllIllIlIIlIIlIlllIl.checkLabel(lllllllllllllllIllIlIIlIIlIllIlI, false, "handler label");
        CheckMethodAdapter.checkNonDebugLabel(lllllllllllllllIllIlIIlIIlIlllII);
        CheckMethodAdapter.checkNonDebugLabel(lllllllllllllllIllIlIIlIIllIIIII);
        CheckMethodAdapter.checkNonDebugLabel(lllllllllllllllIllIlIIlIIlIllIlI);
        if (lllllllllllllllIllIlIIlIIlIlllIl.labels.get(lllllllllllllllIllIlIIlIIlIlllII) != null || lllllllllllllllIllIlIIlIIlIlllIl.labels.get(lllllllllllllllIllIlIIlIIllIIIII) != null || lllllllllllllllIllIlIIlIIlIlllIl.labels.get(lllllllllllllllIllIlIIlIIlIllIlI) != null) {
            throw new IllegalStateException("Try catch blocks must be visited before their labels");
        }
        if (lllllllllllllllIllIlIIlIIlIllIIl != null) {
            CheckMethodAdapter.checkInternalName(lllllllllllllllIllIlIIlIIlIllIIl, "type");
        }
        super.visitTryCatchBlock(lllllllllllllllIllIlIIlIIlIlllII, lllllllllllllllIllIlIIlIIllIIIII, lllllllllllllllIllIlIIlIIlIllIlI, lllllllllllllllIllIlIIlIIlIllIIl);
        lllllllllllllllIllIlIIlIIlIlllIl.handlers.add(lllllllllllllllIllIlIIlIIlIlllII);
        lllllllllllllllIllIlIIlIIlIlllIl.handlers.add(lllllllllllllllIllIlIIlIIllIIIII);
    }

    static void checkIdentifier(String lllllllllllllllIllIlIIIllIlIIllI, String lllllllllllllllIllIlIIIllIlIIlIl) {
        CheckMethodAdapter.checkIdentifier(lllllllllllllllIllIlIIIllIlIIllI, 0, -1, lllllllllllllllIllIlIIIllIlIIlIl);
    }

    @Override
    public void visitVarInsn(int lllllllllllllllIllIlIIllIlIIlIlI, int lllllllllllllllIllIlIIllIlIIlIIl) {
        CheckMethodAdapter lllllllllllllllIllIlIIllIlIIlIll;
        lllllllllllllllIllIlIIllIlIIlIll.checkStartCode();
        lllllllllllllllIllIlIIllIlIIlIll.checkEndCode();
        CheckMethodAdapter.checkOpcode(lllllllllllllllIllIlIIllIlIIlIlI, 2);
        CheckMethodAdapter.checkUnsignedShort(lllllllllllllllIllIlIIllIlIIlIIl, "Invalid variable index");
        super.visitVarInsn(lllllllllllllllIllIlIIllIlIIlIlI, lllllllllllllllIllIlIIllIlIIlIIl);
        ++lllllllllllllllIllIlIIllIlIIlIll.insnCount;
    }

    @Override
    public void visitInsn(int lllllllllllllllIllIlIIllIlIllIll) {
        CheckMethodAdapter lllllllllllllllIllIlIIllIlIlllII;
        lllllllllllllllIllIlIIllIlIlllII.checkStartCode();
        lllllllllllllllIllIlIIllIlIlllII.checkEndCode();
        CheckMethodAdapter.checkOpcode(lllllllllllllllIllIlIIllIlIllIll, 0);
        super.visitInsn(lllllllllllllllIllIlIIllIlIllIll);
        ++lllllllllllllllIllIlIIllIlIlllII.insnCount;
    }

    void checkStartCode() {
        CheckMethodAdapter lllllllllllllllIllIlIIIllllIIllI;
        if (!lllllllllllllllIllIlIIIllllIIllI.startCode) {
            throw new IllegalStateException("Cannot visit instructions before visitCode has been called.");
        }
    }

    @Override
    public void visitLookupSwitchInsn(Label lllllllllllllllIllIlIIlIlIIIlIlI, int[] lllllllllllllllIllIlIIlIlIIIIlIl, Label[] lllllllllllllllIllIlIIlIlIIIlIII) {
        CheckMethodAdapter lllllllllllllllIllIlIIlIlIIIlIll;
        lllllllllllllllIllIlIIlIlIIIlIll.checkEndCode();
        lllllllllllllllIllIlIIlIlIIIlIll.checkStartCode();
        lllllllllllllllIllIlIIlIlIIIlIll.checkLabel(lllllllllllllllIllIlIIlIlIIIlIlI, false, "default label");
        CheckMethodAdapter.checkNonDebugLabel(lllllllllllllllIllIlIIlIlIIIlIlI);
        if (lllllllllllllllIllIlIIlIlIIIIlIl == null || lllllllllllllllIllIlIIlIlIIIlIII == null || lllllllllllllllIllIlIIlIlIIIIlIl.length != lllllllllllllllIllIlIIlIlIIIlIII.length) {
            throw new IllegalArgumentException("There must be the same number of keys and labels");
        }
        for (int lllllllllllllllIllIlIIlIlIIIllIl = 0; lllllllllllllllIllIlIIlIlIIIllIl < lllllllllllllllIllIlIIlIlIIIlIII.length; ++lllllllllllllllIllIlIIlIlIIIllIl) {
            lllllllllllllllIllIlIIlIlIIIlIll.checkLabel(lllllllllllllllIllIlIIlIlIIIlIII[lllllllllllllllIllIlIIlIlIIIllIl], false, String.valueOf(new StringBuilder().append("label at index ").append(lllllllllllllllIllIlIIlIlIIIllIl)));
            CheckMethodAdapter.checkNonDebugLabel(lllllllllllllllIllIlIIlIlIIIlIII[lllllllllllllllIllIlIIlIlIIIllIl]);
        }
        super.visitLookupSwitchInsn(lllllllllllllllIllIlIIlIlIIIlIlI, lllllllllllllllIllIlIIlIlIIIIlIl, lllllllllllllllIllIlIIlIlIIIlIII);
        lllllllllllllllIllIlIIlIlIIIlIll.usedLabels.add(lllllllllllllllIllIlIIlIlIIIlIlI);
        for (int lllllllllllllllIllIlIIlIlIIIllII = 0; lllllllllllllllIllIlIIlIlIIIllII < lllllllllllllllIllIlIIlIlIIIlIII.length; ++lllllllllllllllIllIlIIlIlIIIllII) {
            lllllllllllllllIllIlIIlIlIIIlIll.usedLabels.add(lllllllllllllllIllIlIIlIlIIIlIII[lllllllllllllllIllIlIIlIlIIIllII]);
        }
        ++lllllllllllllllIllIlIIlIlIIIlIll.insnCount;
    }

    static {
        String lllllllllllllllIllIlIIIlIIlIIllI = "BBBBBBBBBBBBBBBBCCIAADDDDDAAAAAAAAAAAAAAAAAAAABBBBBBBBDDDDDAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBJBBBBBBBBBBBBBBBBBBBBHHHHHHHHHHHHHHHHDKLBBBBBBFFFFGGGGAECEBBEEBBAMHHAA";
        TYPE = new int[lllllllllllllllIllIlIIIlIIlIIllI.length()];
        for (int lllllllllllllllIllIlIIIlIIlIIlll = 0; lllllllllllllllIllIlIIIlIIlIIlll < TYPE.length; ++lllllllllllllllIllIlIIIlIIlIIlll) {
            CheckMethodAdapter.TYPE[lllllllllllllllIllIlIIIlIIlIIlll] = lllllllllllllllIllIlIIIlIIlIIllI.charAt(lllllllllllllllIllIlIIIlIIlIIlll) - 65 - 1;
        }
    }
}

