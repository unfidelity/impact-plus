/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.util;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.analysis.Analyzer;
import org.spongepowered.asm.lib.tree.analysis.BasicValue;
import org.spongepowered.asm.lib.tree.analysis.Frame;
import org.spongepowered.asm.lib.tree.analysis.SimpleVerifier;
import org.spongepowered.asm.lib.util.CheckAnnotationAdapter;
import org.spongepowered.asm.lib.util.CheckFieldAdapter;
import org.spongepowered.asm.lib.util.CheckMethodAdapter;
import org.spongepowered.asm.lib.util.Textifier;
import org.spongepowered.asm.lib.util.TraceMethodVisitor;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class CheckClassAdapter
extends ClassVisitor {
    private /* synthetic */ int version;
    private /* synthetic */ boolean source;
    private /* synthetic */ boolean start;
    private /* synthetic */ Map<Label, Integer> labels;
    private /* synthetic */ boolean checkDataFlow;
    private /* synthetic */ boolean end;
    private /* synthetic */ boolean outer;

    static void printAnalyzerResult(MethodNode llllllllllllllllllIIIlllIIIIllll, Analyzer<BasicValue> llllllllllllllllllIIIlllIIIIlllI, PrintWriter llllllllllllllllllIIIlllIIIIIlll) {
        Frame<BasicValue>[] llllllllllllllllllIIIlllIIIIllII = llllllllllllllllllIIIlllIIIIlllI.getFrames();
        Textifier llllllllllllllllllIIIlllIIIIlIll = new Textifier();
        TraceMethodVisitor llllllllllllllllllIIIlllIIIIlIlI = new TraceMethodVisitor(llllllllllllllllllIIIlllIIIIlIll);
        llllllllllllllllllIIIlllIIIIIlll.println(String.valueOf(new StringBuilder().append(llllllllllllllllllIIIlllIIIIllll.name).append(llllllllllllllllllIIIlllIIIIllll.desc)));
        for (int llllllllllllllllllIIIlllIIIlIIIl = 0; llllllllllllllllllIIIlllIIIlIIIl < llllllllllllllllllIIIlllIIIIllll.instructions.size(); ++llllllllllllllllllIIIlllIIIlIIIl) {
            llllllllllllllllllIIIlllIIIIllll.instructions.get(llllllllllllllllllIIIlllIIIlIIIl).accept(llllllllllllllllllIIIlllIIIIlIlI);
            StringBuilder llllllllllllllllllIIIlllIIIlIIll = new StringBuilder();
            Frame<BasicValue> llllllllllllllllllIIIlllIIIlIIlI = llllllllllllllllllIIIlllIIIIllII[llllllllllllllllllIIIlllIIIlIIIl];
            if (llllllllllllllllllIIIlllIIIlIIlI == null) {
                llllllllllllllllllIIIlllIIIlIIll.append('?');
            } else {
                for (int llllllllllllllllllIIIlllIIIlIlIl = 0; llllllllllllllllllIIIlllIIIlIlIl < llllllllllllllllllIIIlllIIIlIIlI.getLocals(); ++llllllllllllllllllIIIlllIIIlIlIl) {
                    llllllllllllllllllIIIlllIIIlIIll.append(CheckClassAdapter.getShortName(llllllllllllllllllIIIlllIIIlIIlI.getLocal(llllllllllllllllllIIIlllIIIlIlIl).toString())).append(' ');
                }
                llllllllllllllllllIIIlllIIIlIIll.append(" : ");
                for (int llllllllllllllllllIIIlllIIIlIlII = 0; llllllllllllllllllIIIlllIIIlIlII < llllllllllllllllllIIIlllIIIlIIlI.getStackSize(); ++llllllllllllllllllIIIlllIIIlIlII) {
                    llllllllllllllllllIIIlllIIIlIIll.append(CheckClassAdapter.getShortName(llllllllllllllllllIIIlllIIIlIIlI.getStack(llllllllllllllllllIIIlllIIIlIlII).toString())).append(' ');
                }
            }
            while (llllllllllllllllllIIIlllIIIlIIll.length() < llllllllllllllllllIIIlllIIIIllll.maxStack + llllllllllllllllllIIIlllIIIIllll.maxLocals + 1) {
                llllllllllllllllllIIIlllIIIlIIll.append(' ');
            }
            llllllllllllllllllIIIlllIIIIIlll.print(Integer.toString(llllllllllllllllllIIIlllIIIlIIIl + 100000).substring(1));
            llllllllllllllllllIIIlllIIIIIlll.print(String.valueOf(new StringBuilder().append(" ").append((Object)llllllllllllllllllIIIlllIIIlIIll).append(" : ").append(llllllllllllllllllIIIlllIIIIlIll.text.get(llllllllllllllllllIIIlllIIIIlIll.text.size() - 1))));
        }
        for (int llllllllllllllllllIIIlllIIIlIIII = 0; llllllllllllllllllIIIlllIIIlIIII < llllllllllllllllllIIIlllIIIIllll.tryCatchBlocks.size(); ++llllllllllllllllllIIIlllIIIlIIII) {
            llllllllllllllllllIIIlllIIIIllll.tryCatchBlocks.get(llllllllllllllllllIIIlllIIIlIIII).accept(llllllllllllllllllIIIlllIIIIlIlI);
            llllllllllllllllllIIIlllIIIIIlll.print(String.valueOf(new StringBuilder().append(" ").append(llllllllllllllllllIIIlllIIIIlIll.text.get(llllllllllllllllllIIIlllIIIIlIll.text.size() - 1))));
        }
        llllllllllllllllllIIIlllIIIIIlll.println();
    }

    protected CheckClassAdapter(int llllllllllllllllllIIIllIlllIIIlI, ClassVisitor llllllllllllllllllIIIllIllIlllIl, boolean llllllllllllllllllIIIllIllIlllII) {
        super(llllllllllllllllllIIIllIlllIIIlI, llllllllllllllllllIIIllIllIlllIl);
        CheckClassAdapter llllllllllllllllllIIIllIlllIIIll;
        llllllllllllllllllIIIllIlllIIIll.labels = new HashMap<Label, Integer>();
        llllllllllllllllllIIIllIlllIIIll.checkDataFlow = llllllllllllllllllIIIllIllIlllII;
    }

    @Override
    public AnnotationVisitor visitAnnotation(String llllllllllllllllllIIIllIIIllIllI, boolean llllllllllllllllllIIIllIIIllIlIl) {
        CheckClassAdapter llllllllllllllllllIIIllIIIlllIII;
        llllllllllllllllllIIIllIIIlllIII.checkState();
        CheckMethodAdapter.checkDesc(llllllllllllllllllIIIllIIIllIllI, false);
        return new CheckAnnotationAdapter(super.visitAnnotation(llllllllllllllllllIIIllIIIllIllI, llllllllllllllllllIIIllIIIllIlIl));
    }

    private static int checkIdentifier(String llllllllllllllllllIIIlIllIIlIIIl, int llllllllllllllllllIIIlIllIIIlllI) {
        if (!Character.isJavaIdentifierStart(CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIIlIIIl, llllllllllllllllllIIIlIllIIIlllI))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllllllIIIlIllIIlIIIl).append(": identifier expected at index ").append(llllllllllllllllllIIIlIllIIIlllI)));
        }
        ++llllllllllllllllllIIIlIllIIIlllI;
        while (Character.isJavaIdentifierPart(CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIIlIIIl, llllllllllllllllllIIIlIllIIIlllI))) {
            ++llllllllllllllllllIIIlIllIIIlllI;
        }
        return llllllllllllllllllIIIlIllIIIlllI;
    }

    private static int checkFieldTypeSignature(String llllllllllllllllllIIIlIllIllIllI, int llllllllllllllllllIIIlIllIllIlIl) {
        switch (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIllIllI, llllllllllllllllllIIIlIllIllIlIl)) {
            case 'L': {
                return CheckClassAdapter.checkClassTypeSignature(llllllllllllllllllIIIlIllIllIllI, llllllllllllllllllIIIlIllIllIlIl);
            }
            case '[': {
                return CheckClassAdapter.checkTypeSignature(llllllllllllllllllIIIlIllIllIllI, llllllllllllllllllIIIlIllIllIlIl + 1);
            }
        }
        return CheckClassAdapter.checkTypeVariableSignature(llllllllllllllllllIIIlIllIllIllI, llllllllllllllllllIIIlIllIllIlIl);
    }

    @Override
    public FieldVisitor visitField(int llllllllllllllllllIIIllIlIIIlIII, String llllllllllllllllllIIIllIlIIIIlll, String llllllllllllllllllIIIllIlIIIIllI, String llllllllllllllllllIIIllIlIIIIlIl, Object llllllllllllllllllIIIllIlIIIIIll) {
        CheckClassAdapter llllllllllllllllllIIIllIlIIIlIIl;
        llllllllllllllllllIIIllIlIIIlIIl.checkState();
        CheckClassAdapter.checkAccess(llllllllllllllllllIIIllIlIIIlIII, 413919);
        CheckMethodAdapter.checkUnqualifiedName(llllllllllllllllllIIIllIlIIIlIIl.version, llllllllllllllllllIIIllIlIIIIlll, "field name");
        CheckMethodAdapter.checkDesc(llllllllllllllllllIIIllIlIIIIllI, false);
        if (llllllllllllllllllIIIllIlIIIIlIl != null) {
            CheckClassAdapter.checkFieldSignature(llllllllllllllllllIIIllIlIIIIlIl);
        }
        if (llllllllllllllllllIIIllIlIIIIIll != null) {
            CheckMethodAdapter.checkConstant(llllllllllllllllllIIIllIlIIIIIll);
        }
        FieldVisitor llllllllllllllllllIIIllIlIIIlIlI = super.visitField(llllllllllllllllllIIIllIlIIIlIII, llllllllllllllllllIIIllIlIIIIlll, llllllllllllllllllIIIllIlIIIIllI, llllllllllllllllllIIIllIlIIIIlIl, llllllllllllllllllIIIllIlIIIIIll);
        return new CheckFieldAdapter(llllllllllllllllllIIIllIlIIIlIlI);
    }

    public CheckClassAdapter(ClassVisitor llllllllllllllllllIIIllIlllIlIIl, boolean llllllllllllllllllIIIllIlllIlIII) {
        llllllllllllllllllIIIllIlllIllIl(327680, llllllllllllllllllIIIllIlllIlIIl, llllllllllllllllllIIIllIlllIlIII);
        CheckClassAdapter llllllllllllllllllIIIllIlllIllIl;
        if (llllllllllllllllllIIIllIlllIllIl.getClass() != CheckClassAdapter.class) {
            throw new IllegalStateException();
        }
    }

    public static void checkClassSignature(String llllllllllllllllllIIIlIllllIIIll) {
        int llllllllllllllllllIIIlIllllIIlII = 0;
        if (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllllIIIll, 0) == '<') {
            llllllllllllllllllIIIlIllllIIlII = CheckClassAdapter.checkFormalTypeParameters(llllllllllllllllllIIIlIllllIIIll, llllllllllllllllllIIIlIllllIIlII);
        }
        llllllllllllllllllIIIlIllllIIlII = CheckClassAdapter.checkClassTypeSignature(llllllllllllllllllIIIlIllllIIIll, llllllllllllllllllIIIlIllllIIlII);
        while (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllllIIIll, llllllllllllllllllIIIlIllllIIlII) == 'L') {
            llllllllllllllllllIIIlIllllIIlII = CheckClassAdapter.checkClassTypeSignature(llllllllllllllllllIIIlIllllIIIll, llllllllllllllllllIIIlIllllIIlII);
        }
        if (llllllllllllllllllIIIlIllllIIlII != llllllllllllllllllIIIlIllllIIIll.length()) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllllllIIIlIllllIIIll).append(": error at index ").append(llllllllllllllllllIIIlIllllIIlII)));
        }
    }

    private static int checkFormalTypeParameter(String llllllllllllllllllIIIlIllIlllllI, int llllllllllllllllllIIIlIllIllllIl) {
        llllllllllllllllllIIIlIllIllllIl = CheckClassAdapter.checkIdentifier(llllllllllllllllllIIIlIllIlllllI, llllllllllllllllllIIIlIllIllllIl);
        if ("L[T".indexOf(CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIlllllI, llllllllllllllllllIIIlIllIllllIl = CheckClassAdapter.checkChar(':', llllllllllllllllllIIIlIllIlllllI, llllllllllllllllllIIIlIllIllllIl))) != -1) {
            llllllllllllllllllIIIlIllIllllIl = CheckClassAdapter.checkFieldTypeSignature(llllllllllllllllllIIIlIllIlllllI, llllllllllllllllllIIIlIllIllllIl);
        }
        while (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIlllllI, llllllllllllllllllIIIlIllIllllIl) == ':') {
            llllllllllllllllllIIIlIllIllllIl = CheckClassAdapter.checkFieldTypeSignature(llllllllllllllllllIIIlIllIlllllI, llllllllllllllllllIIIlIllIllllIl + 1);
        }
        return llllllllllllllllllIIIlIllIllllIl;
    }

    private static int checkFormalTypeParameters(String llllllllllllllllllIIIlIlllIIIIlI, int llllllllllllllllllIIIlIlllIIIIll) {
        llllllllllllllllllIIIlIlllIIIIll = CheckClassAdapter.checkChar('<', llllllllllllllllllIIIlIlllIIIIlI, llllllllllllllllllIIIlIlllIIIIll);
        llllllllllllllllllIIIlIlllIIIIll = CheckClassAdapter.checkFormalTypeParameter(llllllllllllllllllIIIlIlllIIIIlI, llllllllllllllllllIIIlIlllIIIIll);
        while (CheckClassAdapter.getChar(llllllllllllllllllIIIlIlllIIIIlI, llllllllllllllllllIIIlIlllIIIIll) != '>') {
            llllllllllllllllllIIIlIlllIIIIll = CheckClassAdapter.checkFormalTypeParameter(llllllllllllllllllIIIlIlllIIIIlI, llllllllllllllllllIIIlIlllIIIIll);
        }
        return llllllllllllllllllIIIlIlllIIIIll + 1;
    }

    public CheckClassAdapter(ClassVisitor llllllllllllllllllIIIllIllllIIIl) {
        llllllllllllllllllIIIllIllllIIlI(llllllllllllllllllIIIllIllllIIIl, true);
        CheckClassAdapter llllllllllllllllllIIIllIllllIIlI;
    }

    static void checkAccess(int llllllllllllllllllIIIlIllllIlllI, int llllllllllllllllllIIIlIllllIllIl) {
        int llllllllllllllllllIIIlIllllIllll;
        int llllllllllllllllllIIIlIlllllIIIl;
        if ((llllllllllllllllllIIIlIllllIlllI & ~llllllllllllllllllIIIlIllllIllIl) != 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid access flags: ").append(llllllllllllllllllIIIlIllllIlllI)));
        }
        int llllllllllllllllllIIIlIlllllIIll = (llllllllllllllllllIIIlIllllIlllI & 1) == 0 ? 0 : 1;
        int llllllllllllllllllIIIlIlllllIIlI = (llllllllllllllllllIIIlIllllIlllI & 2) == 0 ? 0 : 1;
        int n = llllllllllllllllllIIIlIlllllIIIl = (llllllllllllllllllIIIlIllllIlllI & 4) == 0 ? 0 : 1;
        if (llllllllllllllllllIIIlIlllllIIll + llllllllllllllllllIIIlIlllllIIlI + llllllllllllllllllIIIlIlllllIIIl > 1) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("public private and protected are mutually exclusive: ").append(llllllllllllllllllIIIlIllllIlllI)));
        }
        int llllllllllllllllllIIIlIlllllIIII = (llllllllllllllllllIIIlIllllIlllI & 0x10) == 0 ? 0 : 1;
        int n2 = llllllllllllllllllIIIlIllllIllll = (llllllllllllllllllIIIlIllllIlllI & 0x400) == 0 ? 0 : 1;
        if (llllllllllllllllllIIIlIlllllIIII + llllllllllllllllllIIIlIllllIllll > 1) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("final and abstract are mutually exclusive: ").append(llllllllllllllllllIIIlIllllIlllI)));
        }
    }

    @Override
    public void visitOuterClass(String llllllllllllllllllIIIllIlIlIllII, String llllllllllllllllllIIIllIlIlIllll, String llllllllllllllllllIIIllIlIlIlIlI) {
        CheckClassAdapter llllllllllllllllllIIIllIlIllIIIl;
        llllllllllllllllllIIIllIlIllIIIl.checkState();
        if (llllllllllllllllllIIIllIlIllIIIl.outer) {
            throw new IllegalStateException("visitOuterClass can be called only once.");
        }
        llllllllllllllllllIIIllIlIllIIIl.outer = true;
        if (llllllllllllllllllIIIllIlIlIllII == null) {
            throw new IllegalArgumentException("Illegal outer class owner");
        }
        if (llllllllllllllllllIIIllIlIlIlIlI != null) {
            CheckMethodAdapter.checkMethodDesc(llllllllllllllllllIIIllIlIlIlIlI);
        }
        super.visitOuterClass(llllllllllllllllllIIIllIlIlIllII, llllllllllllllllllIIIllIlIlIllll, llllllllllllllllllIIIllIlIlIlIlI);
    }

    private static String getShortName(String llllllllllllllllllIIIllIlllllIIl) {
        int llllllllllllllllllIIIllIlllllIll = llllllllllllllllllIIIllIlllllIIl.lastIndexOf(47);
        int llllllllllllllllllIIIllIlllllIlI = llllllllllllllllllIIIllIlllllIIl.length();
        if (llllllllllllllllllIIIllIlllllIIl.charAt(llllllllllllllllllIIIllIlllllIlI - 1) == ';') {
            --llllllllllllllllllIIIllIlllllIlI;
        }
        return llllllllllllllllllIIIllIlllllIll == -1 ? llllllllllllllllllIIIllIlllllIIl : llllllllllllllllllIIIllIlllllIIl.substring(llllllllllllllllllIIIllIlllllIll + 1, llllllllllllllllllIIIllIlllllIlI);
    }

    private static int checkTypeArguments(String llllllllllllllllllIIIlIllIlIlIlI, int llllllllllllllllllIIIlIllIlIlIll) {
        llllllllllllllllllIIIlIllIlIlIll = CheckClassAdapter.checkChar('<', llllllllllllllllllIIIlIllIlIlIlI, llllllllllllllllllIIIlIllIlIlIll);
        llllllllllllllllllIIIlIllIlIlIll = CheckClassAdapter.checkTypeArgument(llllllllllllllllllIIIlIllIlIlIlI, llllllllllllllllllIIIlIllIlIlIll);
        while (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIlIlIlI, llllllllllllllllllIIIlIllIlIlIll) != '>') {
            llllllllllllllllllIIIlIllIlIlIll = CheckClassAdapter.checkTypeArgument(llllllllllllllllllIIIlIllIlIlIlI, llllllllllllllllllIIIlIllIlIlIll);
        }
        return llllllllllllllllllIIIlIllIlIlIll + 1;
    }

    public static void checkFieldSignature(String llllllllllllllllllIIIlIlllIllIIl) {
        int llllllllllllllllllIIIlIlllIllIII = CheckClassAdapter.checkFieldTypeSignature(llllllllllllllllllIIIlIlllIllIIl, 0);
        if (llllllllllllllllllIIIlIlllIllIII != llllllllllllllllllIIIlIlllIllIIl.length()) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllllllIIIlIlllIllIIl).append(": error at index ").append(llllllllllllllllllIIIlIlllIllIII)));
        }
    }

    @Override
    public void visitEnd() {
        CheckClassAdapter llllllllllllllllllIIIllIIIIIIlII;
        llllllllllllllllllIIIllIIIIIIlII.checkState();
        llllllllllllllllllIIIllIIIIIIlII.end = true;
        super.visitEnd();
    }

    @Override
    public void visit(int llllllllllllllllllIIIllIllIIlIlI, int llllllllllllllllllIIIllIllIlIIII, String llllllllllllllllllIIIllIllIIllll, String llllllllllllllllllIIIllIllIIIlll, String llllllllllllllllllIIIllIllIIllIl, String[] llllllllllllllllllIIIllIllIIllII) {
        CheckClassAdapter llllllllllllllllllIIIllIllIIlIll;
        if (llllllllllllllllllIIIllIllIIlIll.start) {
            throw new IllegalStateException("visit must be called only once");
        }
        llllllllllllllllllIIIllIllIIlIll.start = true;
        llllllllllllllllllIIIllIllIIlIll.checkState();
        CheckClassAdapter.checkAccess(llllllllllllllllllIIIllIllIlIIII, 423473);
        if (llllllllllllllllllIIIllIllIIllll == null || !llllllllllllllllllIIIllIllIIllll.endsWith("package-info")) {
            CheckMethodAdapter.checkInternalName(llllllllllllllllllIIIllIllIIllll, "class name");
        }
        if ("java/lang/Object".equals(llllllllllllllllllIIIllIllIIllll)) {
            if (llllllllllllllllllIIIllIllIIllIl != null) {
                throw new IllegalArgumentException("The super class name of the Object class must be 'null'");
            }
        } else {
            CheckMethodAdapter.checkInternalName(llllllllllllllllllIIIllIllIIllIl, "super class name");
        }
        if (llllllllllllllllllIIIllIllIIIlll != null) {
            CheckClassAdapter.checkClassSignature(llllllllllllllllllIIIllIllIIIlll);
        }
        if ((llllllllllllllllllIIIllIllIlIIII & 0x200) != 0 && !"java/lang/Object".equals(llllllllllllllllllIIIllIllIIllIl)) {
            throw new IllegalArgumentException("The super class name of interfaces must be 'java/lang/Object'");
        }
        if (llllllllllllllllllIIIllIllIIllII != null) {
            for (int llllllllllllllllllIIIllIllIlIIll = 0; llllllllllllllllllIIIllIllIlIIll < llllllllllllllllllIIIllIllIIllII.length; ++llllllllllllllllllIIIllIllIlIIll) {
                CheckMethodAdapter.checkInternalName(llllllllllllllllllIIIllIllIIllII[llllllllllllllllllIIIllIllIlIIll], String.valueOf(new StringBuilder().append("interface name at index ").append(llllllllllllllllllIIIllIllIlIIll)));
            }
        }
        llllllllllllllllllIIIllIllIIlIll.version = llllllllllllllllllIIIllIllIIlIlI;
        super.visit(llllllllllllllllllIIIllIllIIlIlI, llllllllllllllllllIIIllIllIlIIII, llllllllllllllllllIIIllIllIIllll, llllllllllllllllllIIIllIllIIIlll, llllllllllllllllllIIIllIllIIllIl, llllllllllllllllllIIIllIllIIllII);
    }

    private static int checkTypeSignature(String llllllllllllllllllIIIlIllIIlIlIl, int llllllllllllllllllIIIlIllIIlIlII) {
        switch (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIIlIlIl, llllllllllllllllllIIIlIllIIlIlII)) {
            case 'B': 
            case 'C': 
            case 'D': 
            case 'F': 
            case 'I': 
            case 'J': 
            case 'S': 
            case 'Z': {
                return llllllllllllllllllIIIlIllIIlIlII + 1;
            }
        }
        return CheckClassAdapter.checkFieldTypeSignature(llllllllllllllllllIIIlIllIIlIlIl, llllllllllllllllllIIIlIllIIlIlII);
    }

    private static int checkChar(char llllllllllllllllllIIIlIllIIIIlll, String llllllllllllllllllIIIlIllIIIlIIl, int llllllllllllllllllIIIlIllIIIlIII) {
        if (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIIIlIIl, llllllllllllllllllIIIlIllIIIlIII) == llllllllllllllllllIIIlIllIIIIlll) {
            return llllllllllllllllllIIIlIllIIIlIII + 1;
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllllllIIIlIllIIIlIIl).append(": '").append(llllllllllllllllllIIIlIllIIIIlll).append("' expected at index ").append(llllllllllllllllllIIIlIllIIIlIII)));
    }

    private static int checkTypeVariableSignature(String llllllllllllllllllIIIlIllIIllIll, int llllllllllllllllllIIIlIllIIllIlI) {
        llllllllllllllllllIIIlIllIIllIlI = CheckClassAdapter.checkChar('T', llllllllllllllllllIIIlIllIIllIll, llllllllllllllllllIIIlIllIIllIlI);
        llllllllllllllllllIIIlIllIIllIlI = CheckClassAdapter.checkIdentifier(llllllllllllllllllIIIlIllIIllIll, llllllllllllllllllIIIlIllIIllIlI);
        return CheckClassAdapter.checkChar(';', llllllllllllllllllIIIlIllIIllIll, llllllllllllllllllIIIlIllIIllIlI);
    }

    private static char getChar(String llllllllllllllllllIIIlIllIIIIIlI, int llllllllllllllllllIIIlIlIlllllll) {
        return llllllllllllllllllIIIlIlIlllllll < llllllllllllllllllIIIlIllIIIIIlI.length() ? llllllllllllllllllIIIlIllIIIIIlI.charAt(llllllllllllllllllIIIlIlIlllllll) : (char)'\u0000';
    }

    @Override
    public void visitAttribute(Attribute llllllllllllllllllIIIllIIIIIIlll) {
        CheckClassAdapter llllllllllllllllllIIIllIIIIIlIII;
        llllllllllllllllllIIIllIIIIIlIII.checkState();
        if (llllllllllllllllllIIIllIIIIIIlll == null) {
            throw new IllegalArgumentException("Invalid attribute (must not be null)");
        }
        super.visitAttribute(llllllllllllllllllIIIllIIIIIIlll);
    }

    public static void verify(ClassReader llllllllllllllllllIIIlllIIllllIl, ClassLoader llllllllllllllllllIIIlllIIllIlII, boolean llllllllllllllllllIIIlllIIllIIll, PrintWriter llllllllllllllllllIIIlllIIlllIlI) {
        ClassNode llllllllllllllllllIIIlllIIlllIIl = new ClassNode();
        llllllllllllllllllIIIlllIIllllIl.accept(new CheckClassAdapter(llllllllllllllllllIIIlllIIlllIIl, false), 2);
        Type llllllllllllllllllIIIlllIIlllIII = llllllllllllllllllIIIlllIIlllIIl.superName == null ? null : Type.getObjectType(llllllllllllllllllIIIlllIIlllIIl.superName);
        List<MethodNode> llllllllllllllllllIIIlllIIllIlll = llllllllllllllllllIIIlllIIlllIIl.methods;
        ArrayList<Type> llllllllllllllllllIIIlllIIllIllI = new ArrayList<Type>();
        Iterator<String> llllllllllllllllllIIIlllIlIIIIll = llllllllllllllllllIIIlllIIlllIIl.interfaces.iterator();
        while (llllllllllllllllllIIIlllIlIIIIll.hasNext()) {
            llllllllllllllllllIIIlllIIllIllI.add(Type.getObjectType(llllllllllllllllllIIIlllIlIIIIll.next()));
        }
        for (int llllllllllllllllllIIIlllIIlllllI = 0; llllllllllllllllllIIIlllIIlllllI < llllllllllllllllllIIIlllIIllIlll.size(); ++llllllllllllllllllIIIlllIIlllllI) {
            MethodNode llllllllllllllllllIIIlllIlIIIIIl = llllllllllllllllllIIIlllIIllIlll.get(llllllllllllllllllIIIlllIIlllllI);
            SimpleVerifier llllllllllllllllllIIIlllIlIIIIII = new SimpleVerifier(Type.getObjectType(llllllllllllllllllIIIlllIIlllIIl.name), llllllllllllllllllIIIlllIIlllIII, llllllllllllllllllIIIlllIIllIllI, (llllllllllllllllllIIIlllIIlllIIl.access & 0x200) != 0);
            Analyzer<BasicValue> llllllllllllllllllIIIlllIIllllll = new Analyzer<BasicValue>(llllllllllllllllllIIIlllIlIIIIII);
            if (llllllllllllllllllIIIlllIIllIlII != null) {
                llllllllllllllllllIIIlllIlIIIIII.setClassLoader(llllllllllllllllllIIIlllIIllIlII);
            }
            try {
                llllllllllllllllllIIIlllIIllllll.analyze(llllllllllllllllllIIIlllIIlllIIl.name, llllllllllllllllllIIIlllIlIIIIIl);
                if (!llllllllllllllllllIIIlllIIllIIll) {
                    continue;
                }
            }
            catch (Exception llllllllllllllllllIIIlllIlIIIIlI) {
                llllllllllllllllllIIIlllIlIIIIlI.printStackTrace(llllllllllllllllllIIIlllIIlllIlI);
            }
            CheckClassAdapter.printAnalyzerResult(llllllllllllllllllIIIlllIlIIIIIl, llllllllllllllllllIIIlllIIllllll, llllllllllllllllllIIIlllIIlllIlI);
        }
        llllllllllllllllllIIIlllIIlllIlI.flush();
    }

    @Override
    public void visitSource(String llllllllllllllllllIIIllIlIllIlll, String llllllllllllllllllIIIllIlIlllIIl) {
        CheckClassAdapter llllllllllllllllllIIIllIlIlllIII;
        llllllllllllllllllIIIllIlIlllIII.checkState();
        if (llllllllllllllllllIIIllIlIlllIII.source) {
            throw new IllegalStateException("visitSource can be called only once.");
        }
        llllllllllllllllllIIIllIlIlllIII.source = true;
        super.visitSource(llllllllllllllllllIIIllIlIllIlll, llllllllllllllllllIIIllIlIlllIIl);
    }

    private static int checkClassTypeSignature(String llllllllllllllllllIIIlIllIllIIlI, int llllllllllllllllllIIIlIllIlIllll) {
        llllllllllllllllllIIIlIllIlIllll = CheckClassAdapter.checkChar('L', llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll);
        llllllllllllllllllIIIlIllIlIllll = CheckClassAdapter.checkIdentifier(llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll);
        while (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll) == '/') {
            llllllllllllllllllIIIlIllIlIllll = CheckClassAdapter.checkIdentifier(llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll + 1);
        }
        if (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll) == '<') {
            llllllllllllllllllIIIlIllIlIllll = CheckClassAdapter.checkTypeArguments(llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll);
        }
        while (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll) == '.') {
            if (CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll = CheckClassAdapter.checkIdentifier(llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll + 1)) != '<') continue;
            llllllllllllllllllIIIlIllIlIllll = CheckClassAdapter.checkTypeArguments(llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll);
        }
        return CheckClassAdapter.checkChar(';', llllllllllllllllllIIIlIllIllIIlI, llllllllllllllllllIIIlIllIlIllll);
    }

    public static void main(String[] llllllllllllllllllIIIlllIlIlIIlI) throws Exception {
        ClassReader llllllllllllllllllIIIlllIlIlIIll;
        if (llllllllllllllllllIIIlllIlIlIIlI.length != 1) {
            System.err.println("Verifies the given class.");
            System.err.println("Usage: CheckClassAdapter <fully qualified class name or class file name>");
            return;
        }
        if (llllllllllllllllllIIIlllIlIlIIlI[0].endsWith(".class")) {
            ClassReader llllllllllllllllllIIIlllIlIlIlIl = new ClassReader(new FileInputStream(llllllllllllllllllIIIlllIlIlIIlI[0]));
        } else {
            llllllllllllllllllIIIlllIlIlIIll = new ClassReader(llllllllllllllllllIIIlllIlIlIIlI[0]);
        }
        CheckClassAdapter.verify(llllllllllllllllllIIIlllIlIlIIll, false, new PrintWriter(System.err));
    }

    @Override
    public MethodVisitor visitMethod(int llllllllllllllllllIIIllIIllIIlII, String llllllllllllllllllIIIllIIllIIIlI, String llllllllllllllllllIIIllIIlIlIIlI, String llllllllllllllllllIIIllIIlIllllI, String[] llllllllllllllllllIIIllIIlIIlllI) {
        CheckMethodAdapter llllllllllllllllllIIIllIIlIllIlI;
        CheckClassAdapter llllllllllllllllllIIIllIIllIIllI;
        llllllllllllllllllIIIllIIllIIllI.checkState();
        CheckClassAdapter.checkAccess(llllllllllllllllllIIIllIIllIIlII, 400895);
        if (!"<init>".equals(llllllllllllllllllIIIllIIllIIIlI) && !"<clinit>".equals(llllllllllllllllllIIIllIIllIIIlI)) {
            CheckMethodAdapter.checkMethodIdentifier(llllllllllllllllllIIIllIIllIIllI.version, llllllllllllllllllIIIllIIllIIIlI, "method name");
        }
        CheckMethodAdapter.checkMethodDesc(llllllllllllllllllIIIllIIlIlIIlI);
        if (llllllllllllllllllIIIllIIlIllllI != null) {
            CheckClassAdapter.checkMethodSignature(llllllllllllllllllIIIllIIlIllllI);
        }
        if (llllllllllllllllllIIIllIIlIIlllI != null) {
            for (int llllllllllllllllllIIIllIIllIlIII = 0; llllllllllllllllllIIIllIIllIlIII < llllllllllllllllllIIIllIIlIIlllI.length; ++llllllllllllllllllIIIllIIllIlIII) {
                CheckMethodAdapter.checkInternalName(llllllllllllllllllIIIllIIlIIlllI[llllllllllllllllllIIIllIIllIlIII], String.valueOf(new StringBuilder().append("exception name at index ").append(llllllllllllllllllIIIllIIllIlIII)));
            }
        }
        if (llllllllllllllllllIIIllIIllIIllI.checkDataFlow) {
            CheckMethodAdapter llllllllllllllllllIIIllIIllIIlll = new CheckMethodAdapter(llllllllllllllllllIIIllIIllIIlII, llllllllllllllllllIIIllIIllIIIlI, llllllllllllllllllIIIllIIlIlIIlI, super.visitMethod(llllllllllllllllllIIIllIIllIIlII, llllllllllllllllllIIIllIIllIIIlI, llllllllllllllllllIIIllIIlIlIIlI, llllllllllllllllllIIIllIIlIllllI, llllllllllllllllllIIIllIIlIIlllI), llllllllllllllllllIIIllIIllIIllI.labels);
        } else {
            llllllllllllllllllIIIllIIlIllIlI = new CheckMethodAdapter(super.visitMethod(llllllllllllllllllIIIllIIllIIlII, llllllllllllllllllIIIllIIllIIIlI, llllllllllllllllllIIIllIIlIlIIlI, llllllllllllllllllIIIllIIlIllllI, llllllllllllllllllIIIllIIlIIlllI), llllllllllllllllllIIIllIIllIIllI.labels);
        }
        llllllllllllllllllIIIllIIlIllIlI.version = llllllllllllllllllIIIllIIllIIllI.version;
        return llllllllllllllllllIIIllIIlIllIlI;
    }

    public static void checkMethodSignature(String llllllllllllllllllIIIlIlllIlllll) {
        int llllllllllllllllllIIIlIlllIllllI = 0;
        if (CheckClassAdapter.getChar(llllllllllllllllllIIIlIlllIlllll, 0) == '<') {
            llllllllllllllllllIIIlIlllIllllI = CheckClassAdapter.checkFormalTypeParameters(llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI);
        }
        llllllllllllllllllIIIlIlllIllllI = CheckClassAdapter.checkChar('(', llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI);
        while ("ZCBSIFJDL[T".indexOf(CheckClassAdapter.getChar(llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI)) != -1) {
            llllllllllllllllllIIIlIlllIllllI = CheckClassAdapter.checkTypeSignature(llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI);
        }
        llllllllllllllllllIIIlIlllIllllI = CheckClassAdapter.getChar(llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI = CheckClassAdapter.checkChar(')', llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI)) == 'V' ? ++llllllllllllllllllIIIlIlllIllllI : CheckClassAdapter.checkTypeSignature(llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI);
        while (CheckClassAdapter.getChar(llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI) == '^') {
            if (CheckClassAdapter.getChar(llllllllllllllllllIIIlIlllIlllll, ++llllllllllllllllllIIIlIlllIllllI) == 'L') {
                llllllllllllllllllIIIlIlllIllllI = CheckClassAdapter.checkClassTypeSignature(llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI);
                continue;
            }
            llllllllllllllllllIIIlIlllIllllI = CheckClassAdapter.checkTypeVariableSignature(llllllllllllllllllIIIlIlllIlllll, llllllllllllllllllIIIlIlllIllllI);
        }
        if (llllllllllllllllllIIIlIlllIllllI != llllllllllllllllllIIIlIlllIlllll.length()) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(llllllllllllllllllIIIlIlllIlllll).append(": error at index ").append(llllllllllllllllllIIIlIlllIllllI)));
        }
    }

    @Override
    public void visitInnerClass(String llllllllllllllllllIIIllIlIlIIIIl, String llllllllllllllllllIIIllIlIIllIll, String llllllllllllllllllIIIllIlIIlllll, int llllllllllllllllllIIIllIlIIllllI) {
        CheckClassAdapter llllllllllllllllllIIIllIlIlIIIlI;
        llllllllllllllllllIIIllIlIlIIIlI.checkState();
        CheckMethodAdapter.checkInternalName(llllllllllllllllllIIIllIlIlIIIIl, "class name");
        if (llllllllllllllllllIIIllIlIIllIll != null) {
            CheckMethodAdapter.checkInternalName(llllllllllllllllllIIIllIlIIllIll, "outer class name");
        }
        if (llllllllllllllllllIIIllIlIIlllll != null) {
            int llllllllllllllllllIIIllIlIlIIIll;
            for (llllllllllllllllllIIIllIlIlIIIll = 0; llllllllllllllllllIIIllIlIlIIIll < llllllllllllllllllIIIllIlIIlllll.length() && Character.isDigit(llllllllllllllllllIIIllIlIIlllll.charAt(llllllllllllllllllIIIllIlIlIIIll)); ++llllllllllllllllllIIIllIlIlIIIll) {
            }
            if (llllllllllllllllllIIIllIlIlIIIll == 0 || llllllllllllllllllIIIllIlIlIIIll < llllllllllllllllllIIIllIlIIlllll.length()) {
                CheckMethodAdapter.checkIdentifier(llllllllllllllllllIIIllIlIIlllll, llllllllllllllllllIIIllIlIlIIIll, -1, "inner class name");
            }
        }
        CheckClassAdapter.checkAccess(llllllllllllllllllIIIllIlIIllllI, 30239);
        super.visitInnerClass(llllllllllllllllllIIIllIlIlIIIIl, llllllllllllllllllIIIllIlIIllIll, llllllllllllllllllIIIllIlIIlllll, llllllllllllllllllIIIllIlIIllllI);
    }

    static void checkTypeRefAndPath(int llllllllllllllllllIIIlIlllIIlllI, TypePath llllllllllllllllllIIIlIlllIIlIlI) {
        int llllllllllllllllllIIIlIlllIIllII = 0;
        switch (llllllllllllllllllIIIlIlllIIlllI >>> 24) {
            case 0: 
            case 1: 
            case 22: {
                llllllllllllllllllIIIlIlllIIllII = -65536;
                break;
            }
            case 19: 
            case 20: 
            case 21: 
            case 64: 
            case 65: 
            case 67: 
            case 68: 
            case 69: 
            case 70: {
                llllllllllllllllllIIIlIlllIIllII = -16777216;
                break;
            }
            case 16: 
            case 17: 
            case 18: 
            case 23: 
            case 66: {
                llllllllllllllllllIIIlIlllIIllII = -256;
                break;
            }
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: {
                llllllllllllllllllIIIlIlllIIllII = -16776961;
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type reference sort 0x").append(Integer.toHexString(llllllllllllllllllIIIlIlllIIlllI >>> 24))));
            }
        }
        if ((llllllllllllllllllIIIlIlllIIlllI & ~llllllllllllllllllIIIlIlllIIllII) != 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type reference 0x").append(Integer.toHexString(llllllllllllllllllIIIlIlllIIlllI))));
        }
        if (llllllllllllllllllIIIlIlllIIlIlI != null) {
            for (int llllllllllllllllllIIIlIlllIIllll = 0; llllllllllllllllllIIIlIlllIIllll < llllllllllllllllllIIIlIlllIIlIlI.getLength(); ++llllllllllllllllllIIIlIlllIIllll) {
                int llllllllllllllllllIIIlIlllIlIIII = llllllllllllllllllIIIlIlllIIlIlI.getStep(llllllllllllllllllIIIlIlllIIllll);
                if (llllllllllllllllllIIIlIlllIlIIII != 0 && llllllllllllllllllIIIlIlllIlIIII != 1 && llllllllllllllllllIIIlIlllIlIIII != 3 && llllllllllllllllllIIIlIlllIlIIII != 2) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type path step ").append(llllllllllllllllllIIIlIlllIIllll).append(" in ").append(llllllllllllllllllIIIlIlllIIlIlI)));
                }
                if (llllllllllllllllllIIIlIlllIlIIII == 3 || llllllllllllllllllIIIlIlllIIlIlI.getStepArgument(llllllllllllllllllIIIlIlllIIllll) == 0) continue;
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type path step argument for step ").append(llllllllllllllllllIIIlIlllIIllll).append(" in ").append(llllllllllllllllllIIIlIlllIIlIlI)));
            }
        }
    }

    @Override
    public AnnotationVisitor visitTypeAnnotation(int llllllllllllllllllIIIllIIIIlIlll, TypePath llllllllllllllllllIIIllIIIIlIllI, String llllllllllllllllllIIIllIIIIllIll, boolean llllllllllllllllllIIIllIIIIlIIlI) {
        CheckClassAdapter llllllllllllllllllIIIllIIIIllllI;
        llllllllllllllllllIIIllIIIIllllI.checkState();
        int llllllllllllllllllIIIllIIIIllIIl = llllllllllllllllllIIIllIIIIlIlll >>> 24;
        if (llllllllllllllllllIIIllIIIIllIIl != 0 && llllllllllllllllllIIIllIIIIllIIl != 17 && llllllllllllllllllIIIllIIIIllIIl != 16) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Invalid type reference sort 0x").append(Integer.toHexString(llllllllllllllllllIIIllIIIIllIIl))));
        }
        CheckClassAdapter.checkTypeRefAndPath(llllllllllllllllllIIIllIIIIlIlll, llllllllllllllllllIIIllIIIIlIllI);
        CheckMethodAdapter.checkDesc(llllllllllllllllllIIIllIIIIllIll, false);
        return new CheckAnnotationAdapter(super.visitTypeAnnotation(llllllllllllllllllIIIllIIIIlIlll, llllllllllllllllllIIIllIIIIlIllI, llllllllllllllllllIIIllIIIIllIll, llllllllllllllllllIIIllIIIIlIIlI));
    }

    public static void verify(ClassReader llllllllllllllllllIIIlllIIlIIIlI, boolean llllllllllllllllllIIIlllIIlIIIIl, PrintWriter llllllllllllllllllIIIlllIIlIIIll) {
        CheckClassAdapter.verify(llllllllllllllllllIIIlllIIlIIIlI, null, llllllllllllllllllIIIlllIIlIIIIl, llllllllllllllllllIIIlllIIlIIIll);
    }

    private static int checkTypeArgument(String llllllllllllllllllIIIlIllIlIIIlI, int llllllllllllllllllIIIlIllIlIIlII) {
        char llllllllllllllllllIIIlIllIlIIIll = CheckClassAdapter.getChar(llllllllllllllllllIIIlIllIlIIIlI, llllllllllllllllllIIIlIllIlIIlII);
        if (llllllllllllllllllIIIlIllIlIIIll == '*') {
            return llllllllllllllllllIIIlIllIlIIlII + 1;
        }
        if (llllllllllllllllllIIIlIllIlIIIll == '+' || llllllllllllllllllIIIlIllIlIIIll == '-') {
            ++llllllllllllllllllIIIlIllIlIIlII;
        }
        return CheckClassAdapter.checkFieldTypeSignature(llllllllllllllllllIIIlIllIlIIIlI, llllllllllllllllllIIIlIllIlIIlII);
    }

    private void checkState() {
        CheckClassAdapter llllllllllllllllllIIIlIlllllllll;
        if (!llllllllllllllllllIIIlIlllllllll.start) {
            throw new IllegalStateException("Cannot visit member before visit has been called.");
        }
        if (llllllllllllllllllIIIlIlllllllll.end) {
            throw new IllegalStateException("Cannot visit member after visitEnd has been called.");
        }
    }
}

