/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.struct;

import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.LineNumberNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.util.Bytecode;

public class SourceMap {
    private final /* synthetic */ String sourceFile;
    private static final /* synthetic */ String DEFAULT_STRATUM;
    private static final /* synthetic */ String NEWLINE;
    private final /* synthetic */ Map<String, Stratum> strata;
    private /* synthetic */ int nextLineOffset;
    private /* synthetic */ String defaultStratum;

    public File addFile(String llllllllllllllllIlIIllllIIlIIlll, ClassNode llllllllllllllllIlIIllllIIlIlIIl) {
        SourceMap llllllllllllllllIlIIllllIIlIlIll;
        return llllllllllllllllIlIIllllIIlIlIll.addFile(llllllllllllllllIlIIllllIIlIIlll, llllllllllllllllIlIIllllIIlIlIIl.sourceFile, String.valueOf(new StringBuilder().append(llllllllllllllllIlIIllllIIlIlIIl.name).append(".java")), Bytecode.getMaxLineNumber(llllllllllllllllIlIIllllIIlIlIIl, 500, 50));
    }

    public String getPseudoGeneratedSourceFile() {
        SourceMap llllllllllllllllIlIIllllIIllIllI;
        return llllllllllllllllIlIIllllIIllIllI.sourceFile.replace(".java", "$mixin.java");
    }

    public File addFile(String llllllllllllllllIlIIllllIIIlIIIl, String llllllllllllllllIlIIllllIIIlIIII, String llllllllllllllllIlIIllllIIIIllll, int llllllllllllllllIlIIllllIIIIIlll) {
        SourceMap llllllllllllllllIlIIllllIIIlIIlI;
        Stratum llllllllllllllllIlIIllllIIIIllIl = llllllllllllllllIlIIllllIIIlIIlI.strata.get(llllllllllllllllIlIIllllIIIlIIIl);
        if (llllllllllllllllIlIIllllIIIIllIl == null) {
            llllllllllllllllIlIIllllIIIIllIl = new Stratum(llllllllllllllllIlIIllllIIIlIIIl);
            llllllllllllllllIlIIllllIIIlIIlI.strata.put(llllllllllllllllIlIIllllIIIlIIIl, llllllllllllllllIlIIllllIIIIllIl);
        }
        File llllllllllllllllIlIIllllIIIIllII = llllllllllllllllIlIIllllIIIIllIl.addFile(llllllllllllllllIlIIllllIIIlIIlI.nextLineOffset, llllllllllllllllIlIIllllIIIIIlll, llllllllllllllllIlIIllllIIIlIIII, llllllllllllllllIlIIllllIIIIllll);
        llllllllllllllllIlIIllllIIIlIIlI.nextLineOffset += llllllllllllllllIlIIllllIIIIIlll;
        return llllllllllllllllIlIIllllIIIIllII;
    }

    public String toString() {
        SourceMap llllllllllllllllIlIIllllIIIIIIlI;
        StringBuilder llllllllllllllllIlIIllllIIIIIIIl = new StringBuilder();
        llllllllllllllllIlIIllllIIIIIIlI.appendTo(llllllllllllllllIlIIllllIIIIIIIl);
        return String.valueOf(llllllllllllllllIlIIllllIIIIIIIl);
    }

    public String getSourceFile() {
        SourceMap llllllllllllllllIlIIllllIIlllIII;
        return llllllllllllllllIlIIllllIIlllIII.sourceFile;
    }

    public SourceMap(String llllllllllllllllIlIIllllIIlllIll) {
        SourceMap llllllllllllllllIlIIllllIIlllllI;
        llllllllllllllllIlIIllllIIlllllI.strata = new LinkedHashMap<String, Stratum>();
        llllllllllllllllIlIIllllIIlllllI.nextLineOffset = 1;
        llllllllllllllllIlIIllllIIlllllI.defaultStratum = "Mixin";
        llllllllllllllllIlIIllllIIlllllI.sourceFile = llllllllllllllllIlIIllllIIlllIll;
    }

    public File addFile(ClassNode llllllllllllllllIlIIllllIIllIIIl) {
        SourceMap llllllllllllllllIlIIllllIIllIIlI;
        return llllllllllllllllIlIIllllIIllIIlI.addFile(llllllllllllllllIlIIllllIIllIIlI.defaultStratum, llllllllllllllllIlIIllllIIllIIIl);
    }

    private void appendTo(StringBuilder llllllllllllllllIlIIlllIlllllIII) {
        SourceMap llllllllllllllllIlIIlllIllllIlll;
        llllllllllllllllIlIIlllIlllllIII.append("SMAP").append("\n");
        llllllllllllllllIlIIlllIlllllIII.append(llllllllllllllllIlIIlllIllllIlll.getSourceFile()).append("\n");
        llllllllllllllllIlIIlllIlllllIII.append(llllllllllllllllIlIIlllIllllIlll.defaultStratum).append("\n");
        for (Stratum llllllllllllllllIlIIlllIlllllIlI : llllllllllllllllIlIIlllIllllIlll.strata.values()) {
            llllllllllllllllIlIIlllIlllllIlI.appendTo(llllllllllllllllIlIIlllIlllllIII);
        }
        llllllllllllllllIlIIlllIlllllIII.append("*E").append("\n");
    }

    public File addFile(String llllllllllllllllIlIIllllIIIlllII, String llllllllllllllllIlIIllllIIIllIll, int llllllllllllllllIlIIllllIIIllIlI) {
        SourceMap llllllllllllllllIlIIllllIIIlllIl;
        return llllllllllllllllIlIIllllIIIlllIl.addFile(llllllllllllllllIlIIllllIIIlllIl.defaultStratum, llllllllllllllllIlIIllllIIIlllII, llllllllllllllllIlIIllllIIIllIll, llllllllllllllllIlIIllllIIIllIlI);
    }

    static {
        NEWLINE = "\n";
        DEFAULT_STRATUM = "Mixin";
    }

    public static class File {
        public final /* synthetic */ String sourceFileName;
        public final /* synthetic */ int lineOffset;
        public final /* synthetic */ int size;
        public final /* synthetic */ String sourceFilePath;
        public final /* synthetic */ int id;

        void appendFile(StringBuilder llIlllIlIIIII) {
            File llIlllIlIIIIl;
            if (llIlllIlIIIIl.sourceFilePath != null) {
                llIlllIlIIIII.append("+ ").append(llIlllIlIIIIl.id).append(" ").append(llIlllIlIIIIl.sourceFileName).append("\n");
                llIlllIlIIIII.append(llIlllIlIIIIl.sourceFilePath).append("\n");
            } else {
                llIlllIlIIIII.append(llIlllIlIIIIl.id).append(" ").append(llIlllIlIIIIl.sourceFileName).append("\n");
            }
        }

        public File(int llIllllIlIlIl, int llIllllIlIlII, int llIllllIlIIll, String llIllllIIllIl) {
            llIllllIlIIIl(llIllllIlIlIl, llIllllIlIlII, llIllllIlIIll, llIllllIIllIl, null);
            File llIllllIlIIIl;
        }

        public void appendLines(StringBuilder llIlllIIllIII) {
            File llIlllIIllIll;
            llIlllIIllIII.append("1#").append(llIlllIIllIll.id).append(",").append(llIlllIIllIll.size).append(":").append(llIlllIIllIll.lineOffset).append("\n");
        }

        public void applyOffset(ClassNode llIlllIllIIlI) {
            for (MethodNode llIlllIllIllI : llIlllIllIIlI.methods) {
                File llIlllIllIIll;
                llIlllIllIIll.applyOffset(llIlllIllIllI);
            }
        }

        public void applyOffset(MethodNode llIlllIlIIllI) {
            ListIterator<AbstractInsnNode> llIlllIlIlIlI = llIlllIlIIllI.instructions.iterator();
            while (llIlllIlIlIlI.hasNext()) {
                File llIlllIlIlIIl;
                AbstractInsnNode llIlllIlIlIll = (AbstractInsnNode)llIlllIlIlIlI.next();
                if (!(llIlllIlIlIll instanceof LineNumberNode)) continue;
                ((LineNumberNode)llIlllIlIlIll).line += llIlllIlIlIIl.lineOffset - 1;
            }
        }

        public File(int llIlllIllllll, int llIllllIIIlII, int llIlllIllllIl, String llIllllIIIIlI, String llIllllIIIIIl) {
            File llIllllIIIIII;
            llIllllIIIIII.id = llIlllIllllll;
            llIllllIIIIII.lineOffset = llIllllIIIlII;
            llIllllIIIIII.size = llIlllIllllIl;
            llIllllIIIIII.sourceFileName = llIllllIIIIlI;
            llIllllIIIIII.sourceFilePath = llIllllIIIIIl;
        }
    }

    static class Stratum {
        public final /* synthetic */ String name;
        private static final /* synthetic */ String LINES_MARK;
        private static final /* synthetic */ String STRATUM_MARK;
        private static final /* synthetic */ String FILE_MARK;
        private final /* synthetic */ Map<String, File> files;

        public File addFile(int lllllllllllllllIllllIlIllIIlllll, int lllllllllllllllIllllIlIllIIllllI, String lllllllllllllllIllllIlIllIIlllIl, String lllllllllllllllIllllIlIllIIlllII) {
            Stratum lllllllllllllllIllllIlIllIlIIIII;
            File lllllllllllllllIllllIlIllIlIIIIl = lllllllllllllllIllllIlIllIlIIIII.files.get(lllllllllllllllIllllIlIllIIlllII);
            if (lllllllllllllllIllllIlIllIlIIIIl == null) {
                lllllllllllllllIllllIlIllIlIIIIl = new File(lllllllllllllllIllllIlIllIlIIIII.files.size() + 1, lllllllllllllllIllllIlIllIIlllll, lllllllllllllllIllllIlIllIIllllI, lllllllllllllllIllllIlIllIIlllIl, lllllllllllllllIllllIlIllIIlllII);
                lllllllllllllllIllllIlIllIlIIIII.files.put(lllllllllllllllIllllIlIllIIlllII, lllllllllllllllIllllIlIllIlIIIIl);
            }
            return lllllllllllllllIllllIlIllIlIIIIl;
        }

        public Stratum(String lllllllllllllllIllllIlIllIllIIIl) {
            Stratum lllllllllllllllIllllIlIllIllIlIl;
            lllllllllllllllIllllIlIllIllIlIl.files = new LinkedHashMap<String, File>();
            lllllllllllllllIllllIlIllIllIlIl.name = lllllllllllllllIllllIlIllIllIIIl;
        }

        void appendTo(StringBuilder lllllllllllllllIllllIlIllIIlIIIl) {
            Stratum lllllllllllllllIllllIlIllIIlIIlI;
            lllllllllllllllIllllIlIllIIlIIIl.append("*S").append(" ").append(lllllllllllllllIllllIlIllIIlIIlI.name).append("\n");
            lllllllllllllllIllllIlIllIIlIIIl.append("*F").append("\n");
            for (File lllllllllllllllIllllIlIllIIlIllI : lllllllllllllllIllllIlIllIIlIIlI.files.values()) {
                lllllllllllllllIllllIlIllIIlIllI.appendFile(lllllllllllllllIllllIlIllIIlIIIl);
            }
            lllllllllllllllIllllIlIllIIlIIIl.append("*L").append("\n");
            for (File lllllllllllllllIllllIlIllIIlIlIl : lllllllllllllllIllllIlIllIIlIIlI.files.values()) {
                lllllllllllllllIllllIlIllIIlIlIl.appendLines(lllllllllllllllIllllIlIllIIlIIIl);
            }
        }

        static {
            STRATUM_MARK = "*S";
            LINES_MARK = "*L";
            FILE_MARK = "*F";
        }
    }
}

