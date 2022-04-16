/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib;

import org.spongepowered.asm.lib.AnnotationVisitor;
import org.spongepowered.asm.lib.AnnotationWriter;
import org.spongepowered.asm.lib.Attribute;
import org.spongepowered.asm.lib.ByteVector;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.FieldWriter;
import org.spongepowered.asm.lib.Handle;
import org.spongepowered.asm.lib.Item;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.MethodWriter;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.TypePath;

public class ClassWriter
extends ClassVisitor {
    static final /* synthetic */ int IMETH;
    private /* synthetic */ int innerClassesCount;
    static final /* synthetic */ int LONG;
    static final /* synthetic */ int TYPE_INSN;
    final /* synthetic */ Item key3;
    static final /* synthetic */ int IINC_INSN;
    private /* synthetic */ short typeCount;
    static final /* synthetic */ int HANDLE_BASE;
    /* synthetic */ FieldWriter lastField;
    /* synthetic */ String thisName;
    static final /* synthetic */ int TYPE_NORMAL;
    final /* synthetic */ Item key2;
    static final /* synthetic */ int INT;
    /* synthetic */ MethodWriter lastMethod;
    static final /* synthetic */ int BSM;
    private /* synthetic */ int signature;
    static final /* synthetic */ int LOOK_INSN;
    private /* synthetic */ AnnotationWriter ianns;
    static final /* synthetic */ int NAME_TYPE;
    static final /* synthetic */ int TABL_INSN;
    private /* synthetic */ AnnotationWriter tanns;
    static final /* synthetic */ int FIELDORMETH_INSN;
    static final /* synthetic */ int METH;
    /* synthetic */ ByteVector bootstrapMethods;
    static final /* synthetic */ int FIELD;
    static final /* synthetic */ int UTF8;
    static final /* synthetic */ int SBYTE_INSN;
    static final /* synthetic */ int F_INSERT;
    /* synthetic */ int index;
    /* synthetic */ Item[] items;
    static final /* synthetic */ int MANA_INSN;
    static final /* synthetic */ byte[] TYPE;
    static final /* synthetic */ int DOUBLE;
    static final /* synthetic */ int MTYPE;
    /* synthetic */ FieldWriter firstField;
    static final /* synthetic */ int TO_ACC_SYNTHETIC;
    static final /* synthetic */ int SHORT_INSN;
    private /* synthetic */ int access;
    public static final /* synthetic */ int COMPUTE_MAXS;
    private /* synthetic */ int compute;
    /* synthetic */ Item[] typeTable;
    /* synthetic */ ClassReader cr;
    static final /* synthetic */ int LABELW_INSN;
    private /* synthetic */ int name;
    static final /* synthetic */ int LABEL_INSN;
    /* synthetic */ MethodWriter firstMethod;
    static final /* synthetic */ int ITFMETH_INSN;
    static final /* synthetic */ int INDYMETH_INSN;
    static final /* synthetic */ int TYPE_MERGED;
    static final /* synthetic */ int STR;
    static final /* synthetic */ int LDCW_INSN;
    private /* synthetic */ int sourceFile;
    /* synthetic */ int version;
    static final /* synthetic */ int VAR_INSN;
    private /* synthetic */ AnnotationWriter itanns;
    private /* synthetic */ int interfaceCount;
    private /* synthetic */ int enclosingMethod;
    static final /* synthetic */ int ASM_LABEL_INSN;
    final /* synthetic */ Item key4;
    static final /* synthetic */ int INDY;
    /* synthetic */ int bootstrapMethodsCount;
    static final /* synthetic */ int LDC_INSN;
    static final /* synthetic */ int ACC_SYNTHETIC_ATTRIBUTE;
    /* synthetic */ int threshold;
    private /* synthetic */ int superName;
    private /* synthetic */ int[] interfaces;
    public static final /* synthetic */ int COMPUTE_FRAMES;
    /* synthetic */ boolean hasAsmInsns;
    static final /* synthetic */ int FLOAT;
    private /* synthetic */ Attribute attrs;
    private /* synthetic */ ByteVector sourceDebug;
    static final /* synthetic */ int WIDE_INSN;
    static final /* synthetic */ int TYPE_UNINIT;
    final /* synthetic */ ByteVector pool;
    static final /* synthetic */ int NOARG_INSN;
    private /* synthetic */ ByteVector innerClasses;
    private /* synthetic */ AnnotationWriter anns;
    private /* synthetic */ int enclosingMethodOwner;
    static final /* synthetic */ int HANDLE;
    final /* synthetic */ Item key;
    static final /* synthetic */ int CLASS;
    static final /* synthetic */ int IMPLVAR_INSN;

    /*
     * WARNING - void declaration
     */
    protected String getCommonSuperClass(String llIIIIlllIllII, String llIIIIlllIIlIl) {
        void llIIIIlllIlIIl;
        Class llIIIIlllIlIlI;
        ClassWriter llIIIIlllIllIl;
        ClassLoader llIIIIlllIlIII = llIIIIlllIllIl.getClass().getClassLoader();
        try {
            Class<?> llIIIIllllIIII = Class.forName(llIIIIlllIllII.replace('/', '.'), false, llIIIIlllIlIII);
            Class<?> llIIIIlllIllll = Class.forName(llIIIIlllIIlIl.replace('/', '.'), false, llIIIIlllIlIII);
        }
        catch (Exception llIIIIlllIlllI) {
            throw new RuntimeException(llIIIIlllIlllI.toString());
        }
        if (llIIIIlllIlIlI.isAssignableFrom((Class<?>)llIIIIlllIlIIl)) {
            return llIIIIlllIllII;
        }
        if (llIIIIlllIlIIl.isAssignableFrom(llIIIIlllIlIlI)) {
            return llIIIIlllIIlIl;
        }
        if (llIIIIlllIlIlI.isInterface() || llIIIIlllIlIIl.isInterface()) {
            return "java/lang/Object";
        }
        while (!(llIIIIlllIlIlI = llIIIIlllIlIlI.getSuperclass()).isAssignableFrom((Class<?>)llIIIIlllIlIIl)) {
        }
        return llIIIIlllIlIlI.getName().replace('.', '/');
    }

    Item newNameTypeItem(String llIIIlIIlIlIll, String llIIIlIIlIlIlI) {
        ClassWriter llIIIlIIlIllII;
        llIIIlIIlIllII.key2.set(12, llIIIlIIlIlIll, llIIIlIIlIlIlI, null);
        Item llIIIlIIlIllIl = llIIIlIIlIllII.get(llIIIlIIlIllII.key2);
        if (llIIIlIIlIllIl == null) {
            llIIIlIIlIllII.put122(12, llIIIlIIlIllII.newUTF8(llIIIlIIlIlIll), llIIIlIIlIllII.newUTF8(llIIIlIIlIlIlI));
            llIIIlIIlIllIl = new Item(llIIIlIIlIllII.index++, llIIIlIIlIllII.key2);
            llIIIlIIlIllII.put(llIIIlIIlIllIl);
        }
        return llIIIlIIlIllIl;
    }

    private Item addType(Item llIIIlIIIIlllI) {
        ClassWriter llIIIlIIIIllII;
        llIIIlIIIIllII.typeCount = (short)(llIIIlIIIIllII.typeCount + 1);
        Item llIIIlIIIIllIl = new Item(llIIIlIIIIllII.typeCount, llIIIlIIIIllII.key);
        llIIIlIIIIllII.put(llIIIlIIIIllIl);
        if (llIIIlIIIIllII.typeTable == null) {
            llIIIlIIIIllII.typeTable = new Item[16];
        }
        if (llIIIlIIIIllII.typeCount == llIIIlIIIIllII.typeTable.length) {
            Item[] llIIIlIIIlIIII = new Item[2 * llIIIlIIIIllII.typeTable.length];
            System.arraycopy(llIIIlIIIIllII.typeTable, 0, llIIIlIIIlIIII, 0, llIIIlIIIIllII.typeTable.length);
            llIIIlIIIIllII.typeTable = llIIIlIIIlIIII;
        }
        llIIIlIIIIllII.typeTable[llIIIlIIIIllII.typeCount] = llIIIlIIIIllIl;
        return llIIIlIIIIllIl;
    }

    public final AnnotationVisitor visitAnnotation(String llIIllIIllIIll, boolean llIIllIIllIIlI) {
        ClassWriter llIIllIIllIlII;
        ByteVector llIIllIIllIIIl = new ByteVector();
        llIIllIIllIIIl.putShort(llIIllIIllIlII.newUTF8(llIIllIIllIIll)).putShort(0);
        AnnotationWriter llIIllIIllIIII = new AnnotationWriter(llIIllIIllIlII, true, llIIllIIllIIIl, llIIllIIllIIIl, 2);
        if (llIIllIIllIIlI) {
            llIIllIIllIIII.next = llIIllIIllIlII.anns;
            llIIllIIllIlII.anns = llIIllIIllIIII;
        } else {
            llIIllIIllIIII.next = llIIllIIllIlII.ianns;
            llIIllIIllIlII.ianns = llIIllIIllIIII;
        }
        return llIIllIIllIIII;
    }

    @Deprecated
    public int newHandle(int llIIlIIlIlIlIl, String llIIlIIlIllIIl, String llIIlIIlIllIII, String llIIlIIlIlIlll) {
        ClassWriter llIIlIIlIllIll;
        return llIIlIIlIllIll.newHandle(llIIlIIlIlIlIl, llIIlIIlIllIIl, llIIlIIlIllIII, llIIlIIlIlIlll, llIIlIIlIlIlIl == 9);
    }

    Item newInteger(int llIIIllIIIIIII) {
        ClassWriter llIIIlIlllllIl;
        llIIIlIlllllIl.key.set(llIIIllIIIIIII);
        Item llIIIlIlllllll = llIIIlIlllllIl.get(llIIIlIlllllIl.key);
        if (llIIIlIlllllll == null) {
            llIIIlIlllllIl.pool.putByte(3).putInt(llIIIllIIIIIII);
            llIIIlIlllllll = new Item(llIIIlIlllllIl.index++, llIIIlIlllllIl.key);
            llIIIlIlllllIl.put(llIIIlIlllllll);
        }
        return llIIIlIlllllll;
    }

    public int newNameType(String llIIIlIIlllIIl, String llIIIlIIllIlIl) {
        ClassWriter llIIIlIIlllIlI;
        return llIIIlIIlllIlI.newNameTypeItem((String)llIIIlIIlllIIl, (String)llIIIlIIllIlIl).index;
    }

    public final void visit(int llIIllIlIlIlIl, int llIIllIlIllIll, String llIIllIlIlIIll, String llIIllIlIllIIl, String llIIllIlIlIIIl, String[] llIIllIlIlIIII) {
        ClassWriter llIIllIlIlIllI;
        llIIllIlIlIllI.version = llIIllIlIlIlIl;
        llIIllIlIlIllI.access = llIIllIlIllIll;
        llIIllIlIlIllI.name = llIIllIlIlIllI.newClass(llIIllIlIlIIll);
        llIIllIlIlIllI.thisName = llIIllIlIlIIll;
        if (llIIllIlIllIIl != null) {
            llIIllIlIlIllI.signature = llIIllIlIlIllI.newUTF8(llIIllIlIllIIl);
        }
        int n = llIIllIlIlIllI.superName = llIIllIlIlIIIl == null ? 0 : llIIllIlIlIllI.newClass(llIIllIlIlIIIl);
        if (llIIllIlIlIIII != null && llIIllIlIlIIII.length > 0) {
            llIIllIlIlIllI.interfaceCount = llIIllIlIlIIII.length;
            llIIllIlIlIllI.interfaces = new int[llIIllIlIlIllI.interfaceCount];
            for (int llIIllIlIllllI = 0; llIIllIlIllllI < llIIllIlIlIllI.interfaceCount; ++llIIllIlIllllI) {
                llIIllIlIlIllI.interfaces[llIIllIlIllllI] = llIIllIlIlIllI.newClass(llIIllIlIlIIII[llIIllIlIllllI]);
            }
        }
    }

    int addUninitializedType(String llIIIlIIIlIllI, int llIIIlIIIllIIl) {
        ClassWriter llIIIlIIIllIll;
        llIIIlIIIllIll.key.type = 31;
        llIIIlIIIllIll.key.intVal = llIIIlIIIllIIl;
        llIIIlIIIllIll.key.strVal1 = llIIIlIIIlIllI;
        llIIIlIIIllIll.key.hashCode = Integer.MAX_VALUE & 31 + llIIIlIIIlIllI.hashCode() + llIIIlIIIllIIl;
        Item llIIIlIIIllIII = llIIIlIIIllIll.get(llIIIlIIIllIll.key);
        if (llIIIlIIIllIII == null) {
            llIIIlIIIllIII = llIIIlIIIllIll.addType(llIIIlIIIllIll.key);
        }
        return llIIIlIIIllIII.index;
    }

    public int newUTF8(String llIIlIlIIlIlIl) {
        ClassWriter llIIlIlIIllIIl;
        llIIlIlIIllIIl.key.set(1, llIIlIlIIlIlIl, null, null);
        Item llIIlIlIIlIlll = llIIlIlIIllIIl.get(llIIlIlIIllIIl.key);
        if (llIIlIlIIlIlll == null) {
            llIIlIlIIllIIl.pool.putByte(1).putUTF8(llIIlIlIIlIlIl);
            llIIlIlIIlIlll = new Item(llIIlIlIIllIIl.index++, llIIlIlIIllIIl.key);
            llIIlIlIIllIIl.put(llIIlIlIIlIlll);
        }
        return llIIlIlIIlIlll.index;
    }

    public final void visitSource(String llIIllIlIIlIlI, String llIIllIlIIlIIl) {
        if (llIIllIlIIlIlI != null) {
            ClassWriter llIIllIlIIlIII;
            llIIllIlIIlIII.sourceFile = llIIllIlIIlIII.newUTF8(llIIllIlIIlIlI);
        }
        if (llIIllIlIIlIIl != null) {
            llIIllIlIIlIII.sourceDebug = new ByteVector().encodeUTF8(llIIllIlIIlIIl, 0, Integer.MAX_VALUE);
        }
    }

    public int newMethod(String llIIIllIIlIIIl, String llIIIllIIIllll, String llIIIllIIIlIII, boolean llIIIllIIIllII) {
        ClassWriter llIIIllIIlIIll;
        return llIIIllIIlIIll.newMethodItem((String)llIIIllIIlIIIl, (String)llIIIllIIIllll, (String)llIIIllIIIlIII, (boolean)llIIIllIIIllII).index;
    }

    public byte[] toByteArray() {
        ClassWriter llIIlIllIIIIll;
        if (llIIlIllIIIIll.index > 65535) {
            throw new RuntimeException("Class file too large!");
        }
        int llIIlIllIIlIll = 24 + 2 * llIIlIllIIIIll.interfaceCount;
        int llIIlIllIIlIlI = 0;
        FieldWriter llIIlIllIIlIIl = llIIlIllIIIIll.firstField;
        while (llIIlIllIIlIIl != null) {
            ++llIIlIllIIlIlI;
            llIIlIllIIlIll += llIIlIllIIlIIl.getSize();
            llIIlIllIIlIIl = (FieldWriter)llIIlIllIIlIIl.fv;
        }
        int llIIlIllIIlIII = 0;
        MethodWriter llIIlIllIIIlll = llIIlIllIIIIll.firstMethod;
        while (llIIlIllIIIlll != null) {
            ++llIIlIllIIlIII;
            llIIlIllIIlIll += llIIlIllIIIlll.getSize();
            llIIlIllIIIlll = (MethodWriter)llIIlIllIIIlll.mv;
        }
        int llIIlIllIIIllI = 0;
        if (llIIlIllIIIIll.bootstrapMethods != null) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 8 + llIIlIllIIIIll.bootstrapMethods.length;
            llIIlIllIIIIll.newUTF8("BootstrapMethods");
        }
        if (llIIlIllIIIIll.signature != 0) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 8;
            llIIlIllIIIIll.newUTF8("Signature");
        }
        if (llIIlIllIIIIll.sourceFile != 0) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 8;
            llIIlIllIIIIll.newUTF8("SourceFile");
        }
        if (llIIlIllIIIIll.sourceDebug != null) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += llIIlIllIIIIll.sourceDebug.length + 6;
            llIIlIllIIIIll.newUTF8("SourceDebugExtension");
        }
        if (llIIlIllIIIIll.enclosingMethodOwner != 0) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 10;
            llIIlIllIIIIll.newUTF8("EnclosingMethod");
        }
        if ((llIIlIllIIIIll.access & 0x20000) != 0) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 6;
            llIIlIllIIIIll.newUTF8("Deprecated");
        }
        if ((llIIlIllIIIIll.access & 0x1000) != 0 && ((llIIlIllIIIIll.version & 0xFFFF) < 49 || (llIIlIllIIIIll.access & 0x40000) != 0)) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 6;
            llIIlIllIIIIll.newUTF8("Synthetic");
        }
        if (llIIlIllIIIIll.innerClasses != null) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 8 + llIIlIllIIIIll.innerClasses.length;
            llIIlIllIIIIll.newUTF8("InnerClasses");
        }
        if (llIIlIllIIIIll.anns != null) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 8 + llIIlIllIIIIll.anns.getSize();
            llIIlIllIIIIll.newUTF8("RuntimeVisibleAnnotations");
        }
        if (llIIlIllIIIIll.ianns != null) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 8 + llIIlIllIIIIll.ianns.getSize();
            llIIlIllIIIIll.newUTF8("RuntimeInvisibleAnnotations");
        }
        if (llIIlIllIIIIll.tanns != null) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 8 + llIIlIllIIIIll.tanns.getSize();
            llIIlIllIIIIll.newUTF8("RuntimeVisibleTypeAnnotations");
        }
        if (llIIlIllIIIIll.itanns != null) {
            ++llIIlIllIIIllI;
            llIIlIllIIlIll += 8 + llIIlIllIIIIll.itanns.getSize();
            llIIlIllIIIIll.newUTF8("RuntimeInvisibleTypeAnnotations");
        }
        if (llIIlIllIIIIll.attrs != null) {
            llIIlIllIIIllI += llIIlIllIIIIll.attrs.getCount();
            llIIlIllIIlIll += llIIlIllIIIIll.attrs.getSize(llIIlIllIIIIll, null, 0, -1, -1);
        }
        ByteVector llIIlIllIIIlIl = new ByteVector(llIIlIllIIlIll += llIIlIllIIIIll.pool.length);
        llIIlIllIIIlIl.putInt(-889275714).putInt(llIIlIllIIIIll.version);
        llIIlIllIIIlIl.putShort(llIIlIllIIIIll.index).putByteArray(llIIlIllIIIIll.pool.data, 0, llIIlIllIIIIll.pool.length);
        int llIIlIllIIIlII = 0x60000 | (llIIlIllIIIIll.access & 0x40000) / 64;
        llIIlIllIIIlIl.putShort(llIIlIllIIIIll.access & ~llIIlIllIIIlII).putShort(llIIlIllIIIIll.name).putShort(llIIlIllIIIIll.superName);
        llIIlIllIIIlIl.putShort(llIIlIllIIIIll.interfaceCount);
        for (int llIIlIllIIlllI = 0; llIIlIllIIlllI < llIIlIllIIIIll.interfaceCount; ++llIIlIllIIlllI) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.interfaces[llIIlIllIIlllI]);
        }
        llIIlIllIIIlIl.putShort(llIIlIllIIlIlI);
        llIIlIllIIlIIl = llIIlIllIIIIll.firstField;
        while (llIIlIllIIlIIl != null) {
            llIIlIllIIlIIl.put(llIIlIllIIIlIl);
            llIIlIllIIlIIl = (FieldWriter)llIIlIllIIlIIl.fv;
        }
        llIIlIllIIIlIl.putShort(llIIlIllIIlIII);
        llIIlIllIIIlll = llIIlIllIIIIll.firstMethod;
        while (llIIlIllIIIlll != null) {
            llIIlIllIIIlll.put(llIIlIllIIIlIl);
            llIIlIllIIIlll = (MethodWriter)llIIlIllIIIlll.mv;
        }
        llIIlIllIIIlIl.putShort(llIIlIllIIIllI);
        if (llIIlIllIIIIll.bootstrapMethods != null) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("BootstrapMethods"));
            llIIlIllIIIlIl.putInt(llIIlIllIIIIll.bootstrapMethods.length + 2).putShort(llIIlIllIIIIll.bootstrapMethodsCount);
            llIIlIllIIIlIl.putByteArray(llIIlIllIIIIll.bootstrapMethods.data, 0, llIIlIllIIIIll.bootstrapMethods.length);
        }
        if (llIIlIllIIIIll.signature != 0) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("Signature")).putInt(2).putShort(llIIlIllIIIIll.signature);
        }
        if (llIIlIllIIIIll.sourceFile != 0) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("SourceFile")).putInt(2).putShort(llIIlIllIIIIll.sourceFile);
        }
        if (llIIlIllIIIIll.sourceDebug != null) {
            int llIIlIllIIllIl = llIIlIllIIIIll.sourceDebug.length;
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("SourceDebugExtension")).putInt(llIIlIllIIllIl);
            llIIlIllIIIlIl.putByteArray(llIIlIllIIIIll.sourceDebug.data, 0, llIIlIllIIllIl);
        }
        if (llIIlIllIIIIll.enclosingMethodOwner != 0) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("EnclosingMethod")).putInt(4);
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.enclosingMethodOwner).putShort(llIIlIllIIIIll.enclosingMethod);
        }
        if ((llIIlIllIIIIll.access & 0x20000) != 0) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("Deprecated")).putInt(0);
        }
        if ((llIIlIllIIIIll.access & 0x1000) != 0 && ((llIIlIllIIIIll.version & 0xFFFF) < 49 || (llIIlIllIIIIll.access & 0x40000) != 0)) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("Synthetic")).putInt(0);
        }
        if (llIIlIllIIIIll.innerClasses != null) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("InnerClasses"));
            llIIlIllIIIlIl.putInt(llIIlIllIIIIll.innerClasses.length + 2).putShort(llIIlIllIIIIll.innerClassesCount);
            llIIlIllIIIlIl.putByteArray(llIIlIllIIIIll.innerClasses.data, 0, llIIlIllIIIIll.innerClasses.length);
        }
        if (llIIlIllIIIIll.anns != null) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("RuntimeVisibleAnnotations"));
            llIIlIllIIIIll.anns.put(llIIlIllIIIlIl);
        }
        if (llIIlIllIIIIll.ianns != null) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("RuntimeInvisibleAnnotations"));
            llIIlIllIIIIll.ianns.put(llIIlIllIIIlIl);
        }
        if (llIIlIllIIIIll.tanns != null) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("RuntimeVisibleTypeAnnotations"));
            llIIlIllIIIIll.tanns.put(llIIlIllIIIlIl);
        }
        if (llIIlIllIIIIll.itanns != null) {
            llIIlIllIIIlIl.putShort(llIIlIllIIIIll.newUTF8("RuntimeInvisibleTypeAnnotations"));
            llIIlIllIIIIll.itanns.put(llIIlIllIIIlIl);
        }
        if (llIIlIllIIIIll.attrs != null) {
            llIIlIllIIIIll.attrs.put(llIIlIllIIIIll, null, 0, -1, -1, llIIlIllIIIlIl);
        }
        if (llIIlIllIIIIll.hasAsmInsns) {
            llIIlIllIIIIll.anns = null;
            llIIlIllIIIIll.ianns = null;
            llIIlIllIIIIll.attrs = null;
            llIIlIllIIIIll.innerClassesCount = 0;
            llIIlIllIIIIll.innerClasses = null;
            llIIlIllIIIIll.firstField = null;
            llIIlIllIIIIll.lastField = null;
            llIIlIllIIIIll.firstMethod = null;
            llIIlIllIIIIll.lastMethod = null;
            llIIlIllIIIIll.compute = 1;
            llIIlIllIIIIll.hasAsmInsns = false;
            new ClassReader(llIIlIllIIIlIl.data).accept(llIIlIllIIIIll, 264);
            return llIIlIllIIIIll.toByteArray();
        }
        return llIIlIllIIIlIl.data;
    }

    private Item get(Item llIIIIllIlllII) {
        ClassWriter llIIIIllIllIlI;
        Item llIIIIllIllIll = llIIIIllIllIlI.items[llIIIIllIlllII.hashCode % llIIIIllIllIlI.items.length];
        while (!(llIIIIllIllIll == null || llIIIIllIllIll.type == llIIIIllIlllII.type && llIIIIllIlllII.isEqualTo(llIIIIllIllIll))) {
            llIIIIllIllIll = llIIIIllIllIll.next;
        }
        return llIIIIllIllIll;
    }

    Item newConstItem(Object llIIlIlIlIIllI) {
        ClassWriter llIIlIlIlIlIIl;
        if (llIIlIlIlIIllI instanceof Integer) {
            int llIIlIlIllIlII = (Integer)llIIlIlIlIIllI;
            return llIIlIlIlIlIIl.newInteger(llIIlIlIllIlII);
        }
        if (llIIlIlIlIIllI instanceof Byte) {
            int llIIlIlIllIIll = ((Byte)llIIlIlIlIIllI).intValue();
            return llIIlIlIlIlIIl.newInteger(llIIlIlIllIIll);
        }
        if (llIIlIlIlIIllI instanceof Character) {
            char llIIlIlIllIIlI = ((Character)llIIlIlIlIIllI).charValue();
            return llIIlIlIlIlIIl.newInteger(llIIlIlIllIIlI);
        }
        if (llIIlIlIlIIllI instanceof Short) {
            int llIIlIlIllIIIl = ((Short)llIIlIlIlIIllI).intValue();
            return llIIlIlIlIlIIl.newInteger(llIIlIlIllIIIl);
        }
        if (llIIlIlIlIIllI instanceof Boolean) {
            int llIIlIlIllIIII = (Boolean)llIIlIlIlIIllI != false ? 1 : 0;
            return llIIlIlIlIlIIl.newInteger(llIIlIlIllIIII);
        }
        if (llIIlIlIlIIllI instanceof Float) {
            float llIIlIlIlIllll = ((Float)llIIlIlIlIIllI).floatValue();
            return llIIlIlIlIlIIl.newFloat(llIIlIlIlIllll);
        }
        if (llIIlIlIlIIllI instanceof Long) {
            long llIIlIlIlIlllI = (Long)llIIlIlIlIIllI;
            return llIIlIlIlIlIIl.newLong(llIIlIlIlIlllI);
        }
        if (llIIlIlIlIIllI instanceof Double) {
            double llIIlIlIlIllIl = (Double)llIIlIlIlIIllI;
            return llIIlIlIlIlIIl.newDouble(llIIlIlIlIllIl);
        }
        if (llIIlIlIlIIllI instanceof String) {
            return llIIlIlIlIlIIl.newString((String)llIIlIlIlIIllI);
        }
        if (llIIlIlIlIIllI instanceof Type) {
            Type llIIlIlIlIllII = (Type)llIIlIlIlIIllI;
            int llIIlIlIlIlIll = llIIlIlIlIllII.getSort();
            if (llIIlIlIlIlIll == 10) {
                return llIIlIlIlIlIIl.newClassItem(llIIlIlIlIllII.getInternalName());
            }
            if (llIIlIlIlIlIll == 11) {
                return llIIlIlIlIlIIl.newMethodTypeItem(llIIlIlIlIllII.getDescriptor());
            }
            return llIIlIlIlIlIIl.newClassItem(llIIlIlIlIllII.getDescriptor());
        }
        if (llIIlIlIlIIllI instanceof Handle) {
            Handle llIIlIlIlIlIlI = (Handle)llIIlIlIlIIllI;
            return llIIlIlIlIlIIl.newHandleItem(llIIlIlIlIlIlI.tag, llIIlIlIlIlIlI.owner, llIIlIlIlIlIlI.name, llIIlIlIlIlIlI.desc, llIIlIlIlIlIlI.itf);
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("value ").append(llIIlIlIlIIllI)));
    }

    public int newField(String llIIIlllIIlIll, String llIIIlllIIIllI, String llIIIlllIIlIIl) {
        ClassWriter llIIIlllIIlIII;
        return llIIIlllIIlIII.newFieldItem((String)llIIIlllIIlIll, (String)llIIIlllIIIllI, (String)llIIIlllIIlIIl).index;
    }

    public final void visitInnerClass(String llIIllIIIIIIlI, String llIIllIIIIIlll, String llIIllIIIIIIII, int llIIlIllllllll) {
        ClassWriter llIIllIIIIIIll;
        if (llIIllIIIIIIll.innerClasses == null) {
            llIIllIIIIIIll.innerClasses = new ByteVector();
        }
        Item llIIllIIIIIlII = llIIllIIIIIIll.newClassItem(llIIllIIIIIIlI);
        if (llIIllIIIIIlII.intVal == 0) {
            ++llIIllIIIIIIll.innerClassesCount;
            llIIllIIIIIIll.innerClasses.putShort(llIIllIIIIIlII.index);
            llIIllIIIIIIll.innerClasses.putShort(llIIllIIIIIlll == null ? 0 : llIIllIIIIIIll.newClass(llIIllIIIIIlll));
            llIIllIIIIIIll.innerClasses.putShort(llIIllIIIIIIII == null ? 0 : llIIllIIIIIIll.newUTF8(llIIllIIIIIIII));
            llIIllIIIIIIll.innerClasses.putShort(llIIlIllllllll);
            llIIllIIIIIlII.intVal = llIIllIIIIIIll.innerClassesCount;
        }
    }

    private Item newString(String llIIIlIIllllll) {
        ClassWriter llIIIlIlIIIIll;
        llIIIlIlIIIIll.key2.set(8, llIIIlIIllllll, null, null);
        Item llIIIlIlIIIIIl = llIIIlIlIIIIll.get(llIIIlIlIIIIll.key2);
        if (llIIIlIlIIIIIl == null) {
            llIIIlIlIIIIll.pool.put12(8, llIIIlIlIIIIll.newUTF8(llIIIlIIllllll));
            llIIIlIlIIIIIl = new Item(llIIIlIlIIIIll.index++, llIIIlIlIIIIll.key2);
            llIIIlIlIIIIll.put(llIIIlIlIIIIIl);
        }
        return llIIIlIlIIIIIl;
    }

    static {
        ACC_SYNTHETIC_ATTRIBUTE = 262144;
        ASM_LABEL_INSN = 18;
        FLOAT = 4;
        TO_ACC_SYNTHETIC = 64;
        INDYMETH_INSN = 8;
        LOOK_INSN = 15;
        ITFMETH_INSN = 7;
        F_INSERT = 256;
        LDC_INSN = 11;
        INT = 3;
        INDY = 18;
        CLASS = 7;
        NAME_TYPE = 12;
        TABL_INSN = 14;
        LONG = 5;
        HANDLE = 15;
        COMPUTE_MAXS = 1;
        UTF8 = 1;
        SHORT_INSN = 2;
        VAR_INSN = 3;
        TYPE_UNINIT = 31;
        STR = 8;
        TYPE_MERGED = 32;
        HANDLE_BASE = 20;
        SBYTE_INSN = 1;
        NOARG_INSN = 0;
        WIDE_INSN = 17;
        FIELD = 9;
        IMETH = 11;
        BSM = 33;
        FIELDORMETH_INSN = 6;
        LABEL_INSN = 9;
        IINC_INSN = 13;
        DOUBLE = 6;
        LDCW_INSN = 12;
        LABELW_INSN = 10;
        TYPE_NORMAL = 30;
        MTYPE = 16;
        IMPLVAR_INSN = 4;
        TYPE_INSN = 5;
        COMPUTE_FRAMES = 2;
        METH = 10;
        MANA_INSN = 16;
        byte[] llIIIIlIIlllll = new byte[220];
        String llIIIIlIIllllI = "AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKSSSSSSSSSSSSSSSSSS";
        for (int llIIIIlIlIIIII = 0; llIIIIlIlIIIII < llIIIIlIIlllll.length; ++llIIIIlIlIIIII) {
            llIIIIlIIlllll[llIIIIlIlIIIII] = (byte)(llIIIIlIIllllI.charAt(llIIIIlIlIIIII) - 65);
        }
        TYPE = llIIIIlIIlllll;
    }

    int addType(String llIIIlIIlIIIIl) {
        ClassWriter llIIIlIIlIIlIl;
        llIIIlIIlIIlIl.key.set(30, llIIIlIIlIIIIl, null, null);
        Item llIIIlIIlIIIll = llIIIlIIlIIlIl.get(llIIIlIIlIIlIl.key);
        if (llIIIlIIlIIIll == null) {
            llIIIlIIlIIIll = llIIIlIIlIIlIl.addType(llIIIlIIlIIlIl.key);
        }
        return llIIIlIIlIIIll.index;
    }

    public int newMethodType(String llIIlIIlllIllI) {
        ClassWriter llIIlIIllllIIl;
        return llIIlIIllllIIl.newMethodTypeItem((String)llIIlIIlllIllI).index;
    }

    public final AnnotationVisitor visitTypeAnnotation(int llIIllIIIllIll, TypePath llIIllIIIllIlI, String llIIllIIIllIIl, boolean llIIllIIIlllll) {
        ClassWriter llIIllIIIlllII;
        ByteVector llIIllIIIllllI = new ByteVector();
        AnnotationWriter.putTarget(llIIllIIIllIll, llIIllIIIllIlI, llIIllIIIllllI);
        llIIllIIIllllI.putShort(llIIllIIIlllII.newUTF8(llIIllIIIllIIl)).putShort(0);
        AnnotationWriter llIIllIIIlllIl = new AnnotationWriter(llIIllIIIlllII, true, llIIllIIIllllI, llIIllIIIllllI, llIIllIIIllllI.length - 2);
        if (llIIllIIIlllll) {
            llIIllIIIlllIl.next = llIIllIIIlllII.tanns;
            llIIllIIIlllII.tanns = llIIllIIIlllIl;
        } else {
            llIIllIIIlllIl.next = llIIllIIIlllII.itanns;
            llIIllIIIlllII.itanns = llIIllIIIlllIl;
        }
        return llIIllIIIlllIl;
    }

    public final void visitAttribute(Attribute llIIllIIIlIIlI) {
        ClassWriter llIIllIIIlIIll;
        llIIllIIIlIIlI.next = llIIllIIIlIIll.attrs;
        llIIllIIIlIIll.attrs = llIIllIIIlIIlI;
    }

    Item newLong(long llIIIlIlIlIIIl) {
        ClassWriter llIIIlIlIlIIlI;
        llIIIlIlIlIIlI.key.set(llIIIlIlIlIIIl);
        Item llIIIlIlIlIIll = llIIIlIlIlIIlI.get(llIIIlIlIlIIlI.key);
        if (llIIIlIlIlIIll == null) {
            llIIIlIlIlIIlI.pool.putByte(5).putLong(llIIIlIlIlIIIl);
            llIIIlIlIlIIll = new Item(llIIIlIlIlIIlI.index, llIIIlIlIlIIlI.key);
            llIIIlIlIlIIlI.index += 2;
            llIIIlIlIlIIlI.put(llIIIlIlIlIIll);
        }
        return llIIIlIlIlIIll;
    }

    private void put122(int llIIIIlIllIllI, int llIIIIlIllIlIl, int llIIIIlIllIlII) {
        ClassWriter llIIIIlIllIlll;
        llIIIIlIllIlll.pool.put12(llIIIIlIllIllI, llIIIIlIllIlIl).putShort(llIIIIlIllIlII);
    }

    Item newFieldItem(String llIIIlllIllIIl, String llIIIlllIlIIll, String llIIIlllIlIlll) {
        ClassWriter llIIIlllIlIlIl;
        llIIIlllIlIlIl.key3.set(9, llIIIlllIllIIl, llIIIlllIlIIll, llIIIlllIlIlll);
        Item llIIIlllIlIllI = llIIIlllIlIlIl.get(llIIIlllIlIlIl.key3);
        if (llIIIlllIlIllI == null) {
            llIIIlllIlIlIl.put122(9, llIIIlllIlIlIl.newClass(llIIIlllIllIIl), llIIIlllIlIlIl.newNameType(llIIIlllIlIIll, llIIIlllIlIlll));
            llIIIlllIlIllI = new Item(llIIIlllIlIlIl.index++, llIIIlllIlIlIl.key3);
            llIIIlllIlIlIl.put(llIIIlllIlIllI);
        }
        return llIIIlllIlIllI;
    }

    public int newHandle(int llIIlIIlIIlIlI, String llIIlIIlIIIIll, String llIIlIIlIIlIII, String llIIlIIlIIIIIl, boolean llIIlIIlIIIllI) {
        ClassWriter llIIlIIlIIIlIl;
        return llIIlIIlIIIlIl.newHandleItem((int)llIIlIIlIIlIlI, (String)llIIlIIlIIIIll, (String)llIIlIIlIIlIII, (String)llIIlIIlIIIIIl, (boolean)llIIlIIlIIIllI).index;
    }

    public final void visitEnd() {
    }

    Item newClassItem(String llIIlIlIIIllll) {
        ClassWriter llIIlIlIIIllIl;
        llIIlIlIIIllIl.key2.set(7, llIIlIlIIIllll, null, null);
        Item llIIlIlIIIlllI = llIIlIlIIIllIl.get(llIIlIlIIIllIl.key2);
        if (llIIlIlIIIlllI == null) {
            llIIlIlIIIllIl.pool.put12(7, llIIlIlIIIllIl.newUTF8(llIIlIlIIIllll));
            llIIlIlIIIlllI = new Item(llIIlIlIIIllIl.index++, llIIlIlIIIllIl.key2);
            llIIlIlIIIllIl.put(llIIlIlIIIlllI);
        }
        return llIIlIlIIIlllI;
    }

    Item newHandleItem(int llIIlIIllIllIl, String llIIlIIllIllII, String llIIlIIllIIlII, String llIIlIIllIlIlI, boolean llIIlIIllIIIlI) {
        ClassWriter llIIlIIllIlllI;
        llIIlIIllIlllI.key4.set(20 + llIIlIIllIllIl, llIIlIIllIllII, llIIlIIllIIlII, llIIlIIllIlIlI);
        Item llIIlIIllIlIII = llIIlIIllIlllI.get(llIIlIIllIlllI.key4);
        if (llIIlIIllIlIII == null) {
            if (llIIlIIllIllIl <= 4) {
                llIIlIIllIlllI.put112(15, llIIlIIllIllIl, llIIlIIllIlllI.newField(llIIlIIllIllII, llIIlIIllIIlII, llIIlIIllIlIlI));
            } else {
                llIIlIIllIlllI.put112(15, llIIlIIllIllIl, llIIlIIllIlllI.newMethod(llIIlIIllIllII, llIIlIIllIIlII, llIIlIIllIlIlI, llIIlIIllIIIlI));
            }
            llIIlIIllIlIII = new Item(llIIlIIllIlllI.index++, llIIlIIllIlllI.key4);
            llIIlIIllIlllI.put(llIIlIIllIlIII);
        }
        return llIIlIIllIlIII;
    }

    public ClassWriter(ClassReader llIIllIllIlIll, int llIIllIllIIlll) {
        llIIllIllIlIIl(llIIllIllIIlll);
        ClassWriter llIIllIllIlIIl;
        llIIllIllIlIll.copyPool(llIIllIllIlIIl);
        llIIllIllIlIIl.cr = llIIllIllIlIll;
    }

    private void put(Item llIIIIllIIIIll) {
        ClassWriter llIIIIllIIIlll;
        if (llIIIIllIIIlll.index + llIIIIllIIIlll.typeCount > llIIIIllIIIlll.threshold) {
            int llIIIIllIIlIlI = llIIIIllIIIlll.items.length;
            int llIIIIllIIlIIl = llIIIIllIIlIlI * 2 + 1;
            Item[] llIIIIllIIlIII = new Item[llIIIIllIIlIIl];
            for (int llIIIIllIIlIll = llIIIIllIIlIlI - 1; llIIIIllIIlIll >= 0; --llIIIIllIIlIll) {
                Item llIIIIllIIllII = llIIIIllIIIlll.items[llIIIIllIIlIll];
                while (llIIIIllIIllII != null) {
                    int llIIIIllIIlllI = llIIIIllIIllII.hashCode % llIIIIllIIlIII.length;
                    Item llIIIIllIIllIl = llIIIIllIIllII.next;
                    llIIIIllIIllII.next = llIIIIllIIlIII[llIIIIllIIlllI];
                    llIIIIllIIlIII[llIIIIllIIlllI] = llIIIIllIIllII;
                    llIIIIllIIllII = llIIIIllIIllIl;
                }
            }
            llIIIIllIIIlll.items = llIIIIllIIlIII;
            llIIIIllIIIlll.threshold = (int)((double)llIIIIllIIlIIl * 0.75);
        }
        int llIIIIllIIIlIl = llIIIIllIIIIll.hashCode % llIIIIllIIIlll.items.length;
        llIIIIllIIIIll.next = llIIIIllIIIlll.items[llIIIIllIIIlIl];
        llIIIIllIIIlll.items[llIIIIllIIIlIl] = llIIIIllIIIIll;
    }

    Item newMethodTypeItem(String llIIlIlIIIIIII) {
        ClassWriter llIIlIlIIIIIIl;
        llIIlIlIIIIIIl.key2.set(16, llIIlIlIIIIIII, null, null);
        Item llIIlIIlllllll = llIIlIlIIIIIIl.get(llIIlIlIIIIIIl.key2);
        if (llIIlIIlllllll == null) {
            llIIlIlIIIIIIl.pool.put12(16, llIIlIlIIIIIIl.newUTF8(llIIlIlIIIIIII));
            llIIlIIlllllll = new Item(llIIlIlIIIIIIl.index++, llIIlIlIIIIIIl.key2);
            llIIlIlIIIIIIl.put(llIIlIIlllllll);
        }
        return llIIlIIlllllll;
    }

    int getMergedType(int llIIIlIIIIIIII, int llIIIIlllllIll) {
        ClassWriter llIIIlIIIIIIIl;
        llIIIlIIIIIIIl.key2.type = 32;
        llIIIlIIIIIIIl.key2.longVal = (long)llIIIlIIIIIIII | (long)llIIIIlllllIll << 32;
        llIIIlIIIIIIIl.key2.hashCode = Integer.MAX_VALUE & 32 + llIIIlIIIIIIII + llIIIIlllllIll;
        Item llIIIIlllllllI = llIIIlIIIIIIIl.get(llIIIlIIIIIIIl.key2);
        if (llIIIIlllllllI == null) {
            String llIIIlIIIIIIll = llIIIlIIIIIIIl.typeTable[llIIIlIIIIIIII].strVal1;
            String llIIIlIIIIIIlI = llIIIlIIIIIIIl.typeTable[llIIIIlllllIll].strVal1;
            llIIIlIIIIIIIl.key2.intVal = llIIIlIIIIIIIl.addType(llIIIlIIIIIIIl.getCommonSuperClass(llIIIlIIIIIIll, llIIIlIIIIIIlI));
            llIIIIlllllllI = new Item(0, llIIIlIIIIIIIl.key2);
            llIIIlIIIIIIIl.put(llIIIIlllllllI);
        }
        return llIIIIlllllllI.intVal;
    }

    public int newConst(Object llIIlIlIIlllll) {
        ClassWriter llIIlIlIlIIIII;
        return llIIlIlIlIIIII.newConstItem((Object)llIIlIlIIlllll).index;
    }

    public int newInvokeDynamic(String llIIIlllllIIlI, String llIIIlllllIlll, Handle llIIIllllIllll, Object ... llIIIllllIllIl) {
        ClassWriter llIIIllllllIIl;
        return llIIIllllllIIl.newInvokeDynamicItem((String)llIIIlllllIIlI, (String)llIIIlllllIlll, (Handle)llIIIllllIllll, (Object[])llIIIllllIllIl).index;
    }

    Item newFloat(float llIIIlIlIllllI) {
        ClassWriter llIIIlIllIIIlI;
        llIIIlIllIIIlI.key.set(llIIIlIlIllllI);
        Item llIIIlIllIIIII = llIIIlIllIIIlI.get(llIIIlIllIIIlI.key);
        if (llIIIlIllIIIII == null) {
            llIIIlIllIIIlI.pool.putByte(4).putInt(llIIIlIllIIIlI.key.intVal);
            llIIIlIllIIIII = new Item(llIIIlIllIIIlI.index++, llIIIlIllIIIlI.key);
            llIIIlIllIIIlI.put(llIIIlIllIIIII);
        }
        return llIIIlIllIIIII;
    }

    public final MethodVisitor visitMethod(int llIIlIlllIIlII, String llIIlIllIlllIl, String llIIlIlllIIIlI, String llIIlIlllIIIIl, String[] llIIlIllIllIlI) {
        ClassWriter llIIlIllIlllll;
        return new MethodWriter(llIIlIllIlllll, llIIlIlllIIlII, llIIlIllIlllIl, llIIlIlllIIIlI, llIIlIlllIIIIl, llIIlIllIllIlI, llIIlIllIlllll.compute);
    }

    private void put112(int llIIIIlIlIIllI, int llIIIIlIlIlIIl, int llIIIIlIlIIlII) {
        ClassWriter llIIIIlIlIIlll;
        llIIIIlIlIIlll.pool.put11(llIIIIlIlIIllI, llIIIIlIlIlIIl).putShort(llIIIIlIlIIlII);
    }

    public final FieldVisitor visitField(int llIIlIllllIllI, String llIIlIllllIlIl, String llIIlIlllIlllI, String llIIlIllllIIll, Object llIIlIllllIIlI) {
        ClassWriter llIIlIllllIlll;
        return new FieldWriter(llIIlIllllIlll, llIIlIllllIllI, llIIlIllllIlIl, llIIlIlllIlllI, llIIlIllllIIll, llIIlIllllIIlI);
    }

    Item newInvokeDynamicItem(String llIIlIIIlIlIII, String llIIlIIIlIIlll, Handle llIIlIIIIllIII, Object ... llIIlIIIlIIlIl) {
        int llIIlIIIIlllIl;
        ClassWriter llIIlIIIlIlIlI;
        ByteVector llIIlIIIlIIlII = llIIlIIIlIlIlI.bootstrapMethods;
        if (llIIlIIIlIIlII == null) {
            llIIlIIIlIIlII = llIIlIIIlIlIlI.bootstrapMethods = new ByteVector();
        }
        int llIIlIIIlIIIll = llIIlIIIlIIlII.length;
        int llIIlIIIlIIIlI = llIIlIIIIllIII.hashCode();
        llIIlIIIlIIlII.putShort(llIIlIIIlIlIlI.newHandle(llIIlIIIIllIII.tag, llIIlIIIIllIII.owner, llIIlIIIIllIII.name, llIIlIIIIllIII.desc, llIIlIIIIllIII.isInterface()));
        int llIIlIIIlIIIIl = llIIlIIIlIIlIl.length;
        llIIlIIIlIIlII.putShort(llIIlIIIlIIIIl);
        for (int llIIlIIIllIIII = 0; llIIlIIIllIIII < llIIlIIIlIIIIl; ++llIIlIIIllIIII) {
            Object llIIlIIIllIIIl = llIIlIIIlIIlIl[llIIlIIIllIIII];
            llIIlIIIlIIIlI ^= llIIlIIIllIIIl.hashCode();
            llIIlIIIlIIlII.putShort(llIIlIIIlIlIlI.newConst(llIIlIIIllIIIl));
        }
        byte[] llIIlIIIlIIIII = llIIlIIIlIIlII.data;
        int llIIlIIIIlllll = 2 + llIIlIIIlIIIIl << 1;
        Item llIIlIIIIllllI = llIIlIIIlIlIlI.items[(llIIlIIIlIIIlI &= Integer.MAX_VALUE) % llIIlIIIlIlIlI.items.length];
        block1: while (llIIlIIIIllllI != null) {
            if (llIIlIIIIllllI.type != 33 || llIIlIIIIllllI.hashCode != llIIlIIIlIIIlI) {
                llIIlIIIIllllI = llIIlIIIIllllI.next;
                continue;
            }
            int llIIlIIIlIllIl = llIIlIIIIllllI.intVal;
            for (int llIIlIIIlIlllI = 0; llIIlIIIlIlllI < llIIlIIIIlllll; ++llIIlIIIlIlllI) {
                if (llIIlIIIlIIIII[llIIlIIIlIIIll + llIIlIIIlIlllI] == llIIlIIIlIIIII[llIIlIIIlIllIl + llIIlIIIlIlllI]) continue;
                llIIlIIIIllllI = llIIlIIIIllllI.next;
                continue block1;
            }
        }
        if (llIIlIIIIllllI != null) {
            int llIIlIIIlIllII = llIIlIIIIllllI.index;
            llIIlIIIlIIlII.length = llIIlIIIlIIIll;
        } else {
            llIIlIIIIlllIl = llIIlIIIlIlIlI.bootstrapMethodsCount++;
            llIIlIIIIllllI = new Item(llIIlIIIIlllIl);
            llIIlIIIIllllI.set(llIIlIIIlIIIll, llIIlIIIlIIIlI);
            llIIlIIIlIlIlI.put(llIIlIIIIllllI);
        }
        llIIlIIIlIlIlI.key3.set(llIIlIIIlIlIII, llIIlIIIlIIlll, llIIlIIIIlllIl);
        llIIlIIIIllllI = llIIlIIIlIlIlI.get(llIIlIIIlIlIlI.key3);
        if (llIIlIIIIllllI == null) {
            llIIlIIIlIlIlI.put122(18, llIIlIIIIlllIl, llIIlIIIlIlIlI.newNameType(llIIlIIIlIlIII, llIIlIIIlIIlll));
            llIIlIIIIllllI = new Item(llIIlIIIlIlIlI.index++, llIIlIIIlIlIlI.key3);
            llIIlIIIlIlIlI.put(llIIlIIIIllllI);
        }
        return llIIlIIIIllllI;
    }

    Item newMethodItem(String llIIIllIlIllll, String llIIIllIlIlllI, String llIIIllIlIllIl, boolean llIIIllIlIIlIl) {
        ClassWriter llIIIllIlIlIIl;
        int llIIIllIlIlIll = llIIIllIlIIlIl ? 11 : 10;
        llIIIllIlIlIIl.key3.set(llIIIllIlIlIll, llIIIllIlIllll, llIIIllIlIlllI, llIIIllIlIllIl);
        Item llIIIllIlIlIlI = llIIIllIlIlIIl.get(llIIIllIlIlIIl.key3);
        if (llIIIllIlIlIlI == null) {
            llIIIllIlIlIIl.put122(llIIIllIlIlIll, llIIIllIlIlIIl.newClass(llIIIllIlIllll), llIIIllIlIlIIl.newNameType(llIIIllIlIlllI, llIIIllIlIllIl));
            llIIIllIlIlIlI = new Item(llIIIllIlIlIIl.index++, llIIIllIlIlIIl.key3);
            llIIIllIlIlIIl.put(llIIIllIlIlIlI);
        }
        return llIIIllIlIlIlI;
    }

    public final void visitOuterClass(String llIIllIlIIIIII, String llIIllIIllllll, String llIIllIIlllllI) {
        ClassWriter llIIllIlIIIIIl;
        llIIllIlIIIIIl.enclosingMethodOwner = llIIllIlIIIIIl.newClass(llIIllIlIIIIII);
        if (llIIllIIllllll != null && llIIllIIlllllI != null) {
            llIIllIlIIIIIl.enclosingMethod = llIIllIlIIIIIl.newNameType(llIIllIIllllll, llIIllIIlllllI);
        }
    }

    public int newClass(String llIIlIlIIIIlIl) {
        ClassWriter llIIlIlIIIIllI;
        return llIIlIlIIIIllI.newClassItem((String)llIIlIlIIIIlIl).index;
    }

    Item newDouble(double llIIIlIlIIlIII) {
        ClassWriter llIIIlIlIIlIIl;
        llIIIlIlIIlIIl.key.set(llIIIlIlIIlIII);
        Item llIIIlIlIIlIlI = llIIIlIlIIlIIl.get(llIIIlIlIIlIIl.key);
        if (llIIIlIlIIlIlI == null) {
            llIIIlIlIIlIIl.pool.putByte(6).putLong(llIIIlIlIIlIIl.key.longVal);
            llIIIlIlIIlIlI = new Item(llIIIlIlIIlIIl.index, llIIIlIlIIlIIl.key);
            llIIIlIlIIlIIl.index += 2;
            llIIIlIlIIlIIl.put(llIIIlIlIIlIlI);
        }
        return llIIIlIlIIlIlI;
    }

    public ClassWriter(int llIIllIlllIIII) {
        super(327680);
        ClassWriter llIIllIlllIIIl;
        llIIllIlllIIIl.index = 1;
        llIIllIlllIIIl.pool = new ByteVector();
        llIIllIlllIIIl.items = new Item[256];
        llIIllIlllIIIl.threshold = (int)(0.75 * (double)llIIllIlllIIIl.items.length);
        llIIllIlllIIIl.key = new Item();
        llIIllIlllIIIl.key2 = new Item();
        llIIllIlllIIIl.key3 = new Item();
        llIIllIlllIIIl.key4 = new Item();
        llIIllIlllIIIl.compute = (llIIllIlllIIII & 2) != 0 ? 0 : ((llIIllIlllIIII & 1) != 0 ? 2 : 3);
    }
}

