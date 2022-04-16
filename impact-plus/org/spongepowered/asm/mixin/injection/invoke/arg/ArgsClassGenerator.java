/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.BiMap
 *  com.google.common.collect.HashBiMap
 */
package org.spongepowered.asm.mixin.injection.invoke.arg;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.HashMap;
import java.util.Map;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.Label;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.util.CheckClassAdapter;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import org.spongepowered.asm.mixin.transformer.ext.IClassGenerator;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.SignaturePrinter;
import org.spongepowered.asm.util.asm.MethodVisitorEx;

public final class ArgsClassGenerator
implements IClassGenerator {
    private final /* synthetic */ BiMap<String, String> classNames;
    private final /* synthetic */ Map<String, byte[]> classBytes;
    private static final /* synthetic */ String SET;
    private static final /* synthetic */ String ACE_CTOR_DESC;
    private static final /* synthetic */ String ACE;
    private static final /* synthetic */ String NPE_CTOR_DESC;
    private static final /* synthetic */ String NPE;
    private static final /* synthetic */ String AIOOBE_CTOR_DESC;
    private static final /* synthetic */ String OBJECT;
    private static final /* synthetic */ String CLASS_NAME_BASE;
    private static final /* synthetic */ String AIOOBE;
    private static final /* synthetic */ String SETALL;
    private static final /* synthetic */ String SET_DESC;
    private static final /* synthetic */ String CTOR_DESC;
    private static final /* synthetic */ String SETALL_DESC;
    private static final /* synthetic */ String OBJECT_ARRAY;
    private /* synthetic */ int nextIndex;
    public static final /* synthetic */ String GETTER_PREFIX;
    public static final /* synthetic */ String ARGS_REF;
    public static final /* synthetic */ String ARGS_NAME;
    private static final /* synthetic */ String VALUES_FIELD;

    @Override
    public byte[] generate(String llllllllllllllllIIlIlIlllIlllIlI) {
        ArgsClassGenerator llllllllllllllllIIlIlIlllIllllIl;
        return llllllllllllllllIIlIlIlllIllllIl.getBytes(llllllllllllllllIIlIlIlllIlllIlI);
    }

    private void generateMultiSetter(String llllllllllllllllIIlIlIllIIIIlIIl, String llllllllllllllllIIlIlIllIIIIlIII, Type[] llllllllllllllllIIlIlIllIIIIIlll, ClassVisitor llllllllllllllllIIlIlIlIllllllll) {
        MethodVisitorEx llllllllllllllllIIlIlIllIIIIIlIl = new MethodVisitorEx(llllllllllllllllIIlIlIlIllllllll.visitMethod(1, "setAll", "([Ljava/lang/Object;)V", null, null));
        llllllllllllllllIIlIlIllIIIIIlIl.visitCode();
        Label llllllllllllllllIIlIlIllIIIIIlII = new Label();
        Label llllllllllllllllIIlIlIllIIIIIIll = new Label();
        int llllllllllllllllIIlIlIllIIIIIIlI = 6;
        llllllllllllllllIIlIlIllIIIIIlIl.visitVarInsn(25, 1);
        llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(190);
        llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(89);
        llllllllllllllllIIlIlIllIIIIIlIl.visitConstant((byte)llllllllllllllllIIlIlIllIIIIIlll.length);
        llllllllllllllllIIlIlIllIIIIIlIl.visitJumpInsn(159, llllllllllllllllIIlIlIllIIIIIlII);
        llllllllllllllllIIlIlIllIIIIIlIl.visitTypeInsn(187, "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentCountException");
        llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(89);
        llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(93);
        llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(88);
        llllllllllllllllIIlIlIllIIIIIlIl.visitConstant((byte)llllllllllllllllIIlIlIllIIIIIlll.length);
        llllllllllllllllIIlIlIllIIIIIlIl.visitLdcInsn(ArgsClassGenerator.getSignature(llllllllllllllllIIlIlIllIIIIIlll));
        llllllllllllllllIIlIlIllIIIIIlIl.visitMethodInsn(183, "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentCountException", "<init>", "(IILjava/lang/String;)V", false);
        llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(191);
        llllllllllllllllIIlIlIllIIIIIlIl.visitLabel(llllllllllllllllIIlIlIllIIIIIlII);
        llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(87);
        llllllllllllllllIIlIlIllIIIIIlIl.visitVarInsn(25, 0);
        llllllllllllllllIIlIlIllIIIIIlIl.visitFieldInsn(180, llllllllllllllllIIlIlIllIIIIlIIl, "values", "[Ljava/lang/Object;");
        for (byte llllllllllllllllIIlIlIllIIIIlIll = 0; llllllllllllllllIIlIlIllIIIIlIll < llllllllllllllllIIlIlIllIIIIIlll.length; llllllllllllllllIIlIlIllIIIIlIll = (byte)(llllllllllllllllIIlIlIllIIIIlIll + 1)) {
            llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(89);
            llllllllllllllllIIlIlIllIIIIIlIl.visitConstant(llllllllllllllllIIlIlIllIIIIlIll);
            llllllllllllllllIIlIlIllIIIIIlIl.visitVarInsn(25, 1);
            llllllllllllllllIIlIlIllIIIIIlIl.visitConstant(llllllllllllllllIIlIlIllIIIIlIll);
            llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(50);
            String llllllllllllllllIIlIlIllIIIIllII = Bytecode.getBoxingType(llllllllllllllllIIlIlIllIIIIIlll[llllllllllllllllIIlIlIllIIIIlIll]);
            llllllllllllllllIIlIlIllIIIIIlIl.visitTypeInsn(192, llllllllllllllllIIlIlIllIIIIllII != null ? llllllllllllllllIIlIlIllIIIIllII : llllllllllllllllIIlIlIllIIIIIlll[llllllllllllllllIIlIlIllIIIIlIll].getInternalName());
            if (llllllllllllllllIIlIlIllIIIIllII != null) {
                llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(89);
                llllllllllllllllIIlIlIllIIIIIlIl.visitJumpInsn(198, llllllllllllllllIIlIlIllIIIIIIll);
                llllllllllllllllIIlIlIllIIIIIIlI = 7;
            }
            llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(83);
        }
        llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(177);
        llllllllllllllllIIlIlIllIIIIIlIl.visitLabel(llllllllllllllllIIlIlIllIIIIIIll);
        ArgsClassGenerator.throwNPE(llllllllllllllllIIlIlIllIIIIIlIl, "Argument with primitive type cannot be set to NULL");
        llllllllllllllllIIlIlIllIIIIIlIl.visitInsn(177);
        llllllllllllllllIIlIlIllIIIIIlIl.visitMaxs(llllllllllllllllIIlIlIllIIIIIIlI, 2);
        llllllllllllllllIIlIlIllIIIIIlIl.visitEnd();
    }

    static {
        CTOR_DESC = "([Ljava/lang/Object;)V";
        SET = "set";
        SETALL_DESC = "([Ljava/lang/Object;)V";
        CLASS_NAME_BASE = "org.spongepowered.asm.synthetic.args.Args$";
        SETALL = "setAll";
        NPE = "java/lang/NullPointerException";
        OBJECT = "java/lang/Object";
        VALUES_FIELD = "values";
        AIOOBE = "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentIndexOutOfBoundsException";
        AIOOBE_CTOR_DESC = "(I)V";
        GETTER_PREFIX = "$";
        NPE_CTOR_DESC = "(Ljava/lang/String;)V";
        OBJECT_ARRAY = "[Ljava/lang/Object;";
        ACE_CTOR_DESC = "(IILjava/lang/String;)V";
        SET_DESC = "(ILjava/lang/Object;)V";
        ACE = "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentCountException";
        ARGS_NAME = Args.class.getName();
        ARGS_REF = ARGS_NAME.replace('.', '/');
    }

    private void generateCtor(String llllllllllllllllIIlIlIlllIIlIlIl, String llllllllllllllllIIlIlIlllIIlIlII, Type[] llllllllllllllllIIlIlIlllIIlIIll, ClassVisitor llllllllllllllllIIlIlIlllIIlIIII) {
        MethodVisitor llllllllllllllllIIlIlIlllIIlIIIl = llllllllllllllllIIlIlIlllIIlIIII.visitMethod(2, "<init>", "([Ljava/lang/Object;)V", null, null);
        llllllllllllllllIIlIlIlllIIlIIIl.visitCode();
        llllllllllllllllIIlIlIlllIIlIIIl.visitVarInsn(25, 0);
        llllllllllllllllIIlIlIlllIIlIIIl.visitVarInsn(25, 1);
        llllllllllllllllIIlIlIlllIIlIIIl.visitMethodInsn(183, ARGS_REF, "<init>", "([Ljava/lang/Object;)V", false);
        llllllllllllllllIIlIlIlllIIlIIIl.visitInsn(177);
        llllllllllllllllIIlIlIlllIIlIIIl.visitMaxs(2, 2);
        llllllllllllllllIIlIlIlllIIlIIIl.visitEnd();
    }

    private void generateToString(String llllllllllllllllIIlIlIlllIIIlIlI, String llllllllllllllllIIlIlIlllIIIlIIl, Type[] llllllllllllllllIIlIlIlllIIIIlIl, ClassVisitor llllllllllllllllIIlIlIlllIIIIlll) {
        MethodVisitor llllllllllllllllIIlIlIlllIIIIllI = llllllllllllllllIIlIlIlllIIIIlll.visitMethod(1, "toString", "()Ljava/lang/String;", null, null);
        llllllllllllllllIIlIlIlllIIIIllI.visitCode();
        llllllllllllllllIIlIlIlllIIIIllI.visitLdcInsn(String.valueOf(new StringBuilder().append("Args").append(ArgsClassGenerator.getSignature(llllllllllllllllIIlIlIlllIIIIlIl))));
        llllllllllllllllIIlIlIlllIIIIllI.visitInsn(176);
        llllllllllllllllIIlIlIlllIIIIllI.visitMaxs(1, 1);
        llllllllllllllllIIlIlIlllIIIIllI.visitEnd();
    }

    public ArgsClassGenerator() {
        ArgsClassGenerator llllllllllllllllIIlIlIllllIIllll;
        llllllllllllllllIIlIlIllllIIllll.nextIndex = 1;
        llllllllllllllllIIlIlIllllIIllll.classNames = HashBiMap.create();
        llllllllllllllllIIlIlIllllIIllll.classBytes = new HashMap<String, byte[]>();
    }

    private byte[] generateClass(String llllllllllllllllIIlIlIlllIIllllI, String llllllllllllllllIIlIlIlllIIlllIl) {
        ArgsClassGenerator llllllllllllllllIIlIlIlllIIlllll;
        String llllllllllllllllIIlIlIlllIlIIIll = llllllllllllllllIIlIlIlllIIllllI.replace('.', '/');
        Type[] llllllllllllllllIIlIlIlllIlIIIlI = Type.getArgumentTypes(llllllllllllllllIIlIlIlllIIlllIl);
        ClassWriter llllllllllllllllIIlIlIlllIlIIIIl = new ClassWriter(2);
        ClassVisitor llllllllllllllllIIlIlIlllIlIIIII = llllllllllllllllIIlIlIlllIlIIIIl;
        if (MixinEnvironment.getCurrentEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERIFY)) {
            llllllllllllllllIIlIlIlllIlIIIII = new CheckClassAdapter(llllllllllllllllIIlIlIlllIlIIIIl);
        }
        llllllllllllllllIIlIlIlllIlIIIII.visit(50, 4129, llllllllllllllllIIlIlIlllIlIIIll, null, ARGS_REF, null);
        llllllllllllllllIIlIlIlllIlIIIII.visitSource(String.valueOf(new StringBuilder().append(llllllllllllllllIIlIlIlllIIllllI.substring(llllllllllllllllIIlIlIlllIIllllI.lastIndexOf(46) + 1)).append(".java")), null);
        llllllllllllllllIIlIlIlllIIlllll.generateCtor(llllllllllllllllIIlIlIlllIlIIIll, llllllllllllllllIIlIlIlllIIlllIl, llllllllllllllllIIlIlIlllIlIIIlI, llllllllllllllllIIlIlIlllIlIIIII);
        llllllllllllllllIIlIlIlllIIlllll.generateToString(llllllllllllllllIIlIlIlllIlIIIll, llllllllllllllllIIlIlIlllIIlllIl, llllllllllllllllIIlIlIlllIlIIIlI, llllllllllllllllIIlIlIlllIlIIIII);
        llllllllllllllllIIlIlIlllIIlllll.generateFactory(llllllllllllllllIIlIlIlllIlIIIll, llllllllllllllllIIlIlIlllIIlllIl, llllllllllllllllIIlIlIlllIlIIIlI, llllllllllllllllIIlIlIlllIlIIIII);
        llllllllllllllllIIlIlIlllIIlllll.generateSetters(llllllllllllllllIIlIlIlllIlIIIll, llllllllllllllllIIlIlIlllIIlllIl, llllllllllllllllIIlIlIlllIlIIIlI, llllllllllllllllIIlIlIlllIlIIIII);
        llllllllllllllllIIlIlIlllIIlllll.generateGetters(llllllllllllllllIIlIlIlllIlIIIll, llllllllllllllllIIlIlIlllIIlllIl, llllllllllllllllIIlIlIlllIlIIIlI, llllllllllllllllIIlIlIlllIlIIIII);
        llllllllllllllllIIlIlIlllIlIIIII.visitEnd();
        return llllllllllllllllIIlIlIlllIlIIIIl.toByteArray();
    }

    private static String getSignature(Type[] llllllllllllllllIIlIlIlIllIIllll) {
        return new SignaturePrinter("", null, llllllllllllllllIIlIlIlIllIIllll).setFullyQualified(true).getFormattedArgs();
    }

    private static void box(MethodVisitor llllllllllllllllIIlIlIlIlllIIlll, Type llllllllllllllllIIlIlIlIlllIIllI) {
        String llllllllllllllllIIlIlIlIlllIIlIl = Bytecode.getBoxingType(llllllllllllllllIIlIlIlIlllIIllI);
        if (llllllllllllllllIIlIlIlIlllIIlIl != null) {
            String llllllllllllllllIIlIlIlIlllIlIII = String.format("(%s)L%s;", llllllllllllllllIIlIlIlIlllIIllI.getDescriptor(), llllllllllllllllIIlIlIlIlllIIlIl);
            llllllllllllllllIIlIlIlIlllIIlll.visitMethodInsn(184, llllllllllllllllIIlIlIlIlllIIlIl, "valueOf", llllllllllllllllIIlIlIlIlllIlIII, false);
        }
    }

    private static void throwAIOOBE(MethodVisitorEx llllllllllllllllIIlIlIlIlllIlllI, int llllllllllllllllIIlIlIlIlllIllIl) {
        llllllllllllllllIIlIlIlIlllIlllI.visitTypeInsn(187, "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentIndexOutOfBoundsException");
        llllllllllllllllIIlIlIlIlllIlllI.visitInsn(89);
        llllllllllllllllIIlIlIlIlllIlllI.visitVarInsn(21, llllllllllllllllIIlIlIlIlllIllIl);
        llllllllllllllllIIlIlIlIlllIlllI.visitMethodInsn(183, "org/spongepowered/asm/mixin/injection/invoke/arg/ArgumentIndexOutOfBoundsException", "<init>", "(I)V", false);
        llllllllllllllllIIlIlIlIlllIlllI.visitInsn(191);
    }

    public String getClassName(String llllllllllllllllIIlIlIllllIIlIlI) {
        ArgsClassGenerator llllllllllllllllIIlIlIllllIIlIll;
        if (!llllllllllllllllIIlIlIllllIIlIlI.endsWith(")V")) {
            throw new IllegalArgumentException("Invalid @ModifyArgs method descriptor");
        }
        String llllllllllllllllIIlIlIllllIIlIIl = (String)llllllllllllllllIIlIlIllllIIlIll.classNames.get((Object)llllllllllllllllIIlIlIllllIIlIlI);
        if (llllllllllllllllIIlIlIllllIIlIIl == null) {
            llllllllllllllllIIlIlIllllIIlIIl = String.format("%s%d", "org.spongepowered.asm.synthetic.args.Args$", llllllllllllllllIIlIlIllllIIlIll.nextIndex++);
            llllllllllllllllIIlIlIllllIIlIll.classNames.put((Object)llllllllllllllllIIlIlIllllIIlIlI, (Object)llllllllllllllllIIlIlIllllIIlIIl);
        }
        return llllllllllllllllIIlIlIllllIIlIIl;
    }

    private void generateSetters(String llllllllllllllllIIlIlIllIIllllIl, String llllllllllllllllIIlIlIllIIllllII, Type[] llllllllllllllllIIlIlIllIIlllIll, ClassVisitor llllllllllllllllIIlIlIllIIlllIlI) {
        ArgsClassGenerator llllllllllllllllIIlIlIllIIlllIIl;
        llllllllllllllllIIlIlIllIIlllIIl.generateIndexedSetter(llllllllllllllllIIlIlIllIIllllIl, llllllllllllllllIIlIlIllIIllllII, llllllllllllllllIIlIlIllIIlllIll, llllllllllllllllIIlIlIllIIlllIlI);
        llllllllllllllllIIlIlIllIIlllIIl.generateMultiSetter(llllllllllllllllIIlIlIllIIllllIl, llllllllllllllllIIlIlIllIIllllII, llllllllllllllllIIlIlIllIIlllIll, llllllllllllllllIIlIlIllIIlllIlI);
    }

    public String getClassRef(String llllllllllllllllIIlIlIllllIIIIlI) {
        ArgsClassGenerator llllllllllllllllIIlIlIllllIIIIIl;
        return llllllllllllllllIIlIlIllllIIIIIl.getClassName(llllllllllllllllIIlIlIllllIIIIlI).replace('.', '/');
    }

    public byte[] getBytes(String llllllllllllllllIIlIlIlllIllIIII) {
        ArgsClassGenerator llllllllllllllllIIlIlIlllIllIlII;
        byte[] llllllllllllllllIIlIlIlllIllIIlI = llllllllllllllllIIlIlIlllIllIlII.classBytes.get(llllllllllllllllIIlIlIlllIllIIII);
        if (llllllllllllllllIIlIlIlllIllIIlI == null) {
            String llllllllllllllllIIlIlIlllIllIlIl = (String)llllllllllllllllIIlIlIlllIllIlII.classNames.inverse().get((Object)llllllllllllllllIIlIlIlllIllIIII);
            if (llllllllllllllllIIlIlIlllIllIlIl == null) {
                return null;
            }
            llllllllllllllllIIlIlIlllIllIIlI = llllllllllllllllIIlIlIlllIllIlII.generateClass(llllllllllllllllIIlIlIlllIllIIII, llllllllllllllllIIlIlIlllIllIlIl);
            llllllllllllllllIIlIlIlllIllIlII.classBytes.put(llllllllllllllllIIlIlIlllIllIIII, llllllllllllllllIIlIlIlllIllIIlI);
        }
        return llllllllllllllllIIlIlIlllIllIIlI;
    }

    private void generateIndexedSetter(String llllllllllllllllIIlIlIllIIlIIllI, String llllllllllllllllIIlIlIllIIlIIlIl, Type[] llllllllllllllllIIlIlIllIIIlllIl, ClassVisitor llllllllllllllllIIlIlIllIIlIIIll) {
        MethodVisitorEx llllllllllllllllIIlIlIllIIlIIIlI = new MethodVisitorEx(llllllllllllllllIIlIlIllIIlIIIll.visitMethod(1, "set", "(ILjava/lang/Object;)V", null, null));
        llllllllllllllllIIlIlIllIIlIIIlI.visitCode();
        Label llllllllllllllllIIlIlIllIIlIIIIl = new Label();
        Label llllllllllllllllIIlIlIllIIlIIIII = new Label();
        Label[] llllllllllllllllIIlIlIllIIIlllll = new Label[llllllllllllllllIIlIlIllIIIlllIl.length];
        for (int llllllllllllllllIIlIlIllIIlIlIll = 0; llllllllllllllllIIlIlIllIIlIlIll < llllllllllllllllIIlIlIllIIIlllll.length; ++llllllllllllllllIIlIlIllIIlIlIll) {
            llllllllllllllllIIlIlIllIIIlllll[llllllllllllllllIIlIlIllIIlIlIll] = new Label();
        }
        llllllllllllllllIIlIlIllIIlIIIlI.visitVarInsn(25, 0);
        llllllllllllllllIIlIlIllIIlIIIlI.visitFieldInsn(180, llllllllllllllllIIlIlIllIIlIIllI, "values", "[Ljava/lang/Object;");
        for (byte llllllllllllllllIIlIlIllIIlIlIlI = 0; llllllllllllllllIIlIlIllIIlIlIlI < llllllllllllllllIIlIlIllIIIlllIl.length; llllllllllllllllIIlIlIllIIlIlIlI = (byte)(llllllllllllllllIIlIlIllIIlIlIlI + 1)) {
            llllllllllllllllIIlIlIllIIlIIIlI.visitVarInsn(21, 1);
            llllllllllllllllIIlIlIllIIlIIIlI.visitConstant(llllllllllllllllIIlIlIllIIlIlIlI);
            llllllllllllllllIIlIlIllIIlIIIlI.visitJumpInsn(159, llllllllllllllllIIlIlIllIIIlllll[llllllllllllllllIIlIlIllIIlIlIlI]);
        }
        ArgsClassGenerator.throwAIOOBE(llllllllllllllllIIlIlIllIIlIIIlI, 1);
        for (int llllllllllllllllIIlIlIllIIlIlIII = 0; llllllllllllllllIIlIlIllIIlIlIII < llllllllllllllllIIlIlIllIIIlllIl.length; ++llllllllllllllllIIlIlIllIIlIlIII) {
            String llllllllllllllllIIlIlIllIIlIlIIl = Bytecode.getBoxingType(llllllllllllllllIIlIlIllIIIlllIl[llllllllllllllllIIlIlIllIIlIlIII]);
            llllllllllllllllIIlIlIllIIlIIIlI.visitLabel(llllllllllllllllIIlIlIllIIIlllll[llllllllllllllllIIlIlIllIIlIlIII]);
            llllllllllllllllIIlIlIllIIlIIIlI.visitVarInsn(21, 1);
            llllllllllllllllIIlIlIllIIlIIIlI.visitVarInsn(25, 2);
            llllllllllllllllIIlIlIllIIlIIIlI.visitTypeInsn(192, llllllllllllllllIIlIlIllIIlIlIIl != null ? llllllllllllllllIIlIlIllIIlIlIIl : llllllllllllllllIIlIlIllIIIlllIl[llllllllllllllllIIlIlIllIIlIlIII].getInternalName());
            llllllllllllllllIIlIlIllIIlIIIlI.visitJumpInsn(167, llllllllllllllllIIlIlIllIIlIlIIl != null ? llllllllllllllllIIlIlIllIIlIIIII : llllllllllllllllIIlIlIllIIlIIIIl);
        }
        llllllllllllllllIIlIlIllIIlIIIlI.visitLabel(llllllllllllllllIIlIlIllIIlIIIII);
        llllllllllllllllIIlIlIllIIlIIIlI.visitInsn(89);
        llllllllllllllllIIlIlIllIIlIIIlI.visitJumpInsn(199, llllllllllllllllIIlIlIllIIlIIIIl);
        ArgsClassGenerator.throwNPE(llllllllllllllllIIlIlIllIIlIIIlI, "Argument with primitive type cannot be set to NULL");
        llllllllllllllllIIlIlIllIIlIIIlI.visitLabel(llllllllllllllllIIlIlIllIIlIIIIl);
        llllllllllllllllIIlIlIllIIlIIIlI.visitInsn(83);
        llllllllllllllllIIlIlIllIIlIIIlI.visitInsn(177);
        llllllllllllllllIIlIlIllIIlIIIlI.visitMaxs(6, 3);
        llllllllllllllllIIlIlIllIIlIIIlI.visitEnd();
    }

    private static void throwNPE(MethodVisitorEx llllllllllllllllIIlIlIlIllllIlII, String llllllllllllllllIIlIlIlIllllIlIl) {
        llllllllllllllllIIlIlIlIllllIlII.visitTypeInsn(187, "java/lang/NullPointerException");
        llllllllllllllllIIlIlIlIllllIlII.visitInsn(89);
        llllllllllllllllIIlIlIlIllllIlII.visitLdcInsn(llllllllllllllllIIlIlIlIllllIlIl);
        llllllllllllllllIIlIlIlIllllIlII.visitMethodInsn(183, "java/lang/NullPointerException", "<init>", "(Ljava/lang/String;)V", false);
        llllllllllllllllIIlIlIlIllllIlII.visitInsn(191);
    }

    private void generateFactory(String llllllllllllllllIIlIlIllIllIlllI, String llllllllllllllllIIlIlIllIlllIlII, Type[] llllllllllllllllIIlIlIllIlllIIll, ClassVisitor llllllllllllllllIIlIlIllIlllIIlI) {
        String llllllllllllllllIIlIlIllIlllIIIl = Bytecode.changeDescriptorReturnType(llllllllllllllllIIlIlIllIlllIlII, String.valueOf(new StringBuilder().append("L").append(llllllllllllllllIIlIlIllIllIlllI).append(";")));
        MethodVisitorEx llllllllllllllllIIlIlIllIlllIIII = new MethodVisitorEx(llllllllllllllllIIlIlIllIlllIIlI.visitMethod(9, "of", llllllllllllllllIIlIlIllIlllIIIl, null, null));
        llllllllllllllllIIlIlIllIlllIIII.visitCode();
        llllllllllllllllIIlIlIllIlllIIII.visitTypeInsn(187, llllllllllllllllIIlIlIllIllIlllI);
        llllllllllllllllIIlIlIllIlllIIII.visitInsn(89);
        llllllllllllllllIIlIlIllIlllIIII.visitConstant((byte)llllllllllllllllIIlIlIllIlllIIll.length);
        llllllllllllllllIIlIlIllIlllIIII.visitTypeInsn(189, "java/lang/Object");
        byte llllllllllllllllIIlIlIllIllIllll = 0;
        for (Type llllllllllllllllIIlIlIllIlllIlll : llllllllllllllllIIlIlIllIlllIIll) {
            llllllllllllllllIIlIlIllIlllIIII.visitInsn(89);
            llllllllllllllllIIlIlIllIlllIIII.visitConstant(llllllllllllllllIIlIlIllIllIllll);
            byte by = llllllllllllllllIIlIlIllIllIllll;
            llllllllllllllllIIlIlIllIllIllll = (byte)(llllllllllllllllIIlIlIllIllIllll + 1);
            llllllllllllllllIIlIlIllIlllIIII.visitVarInsn(llllllllllllllllIIlIlIllIlllIlll.getOpcode(21), by);
            ArgsClassGenerator.box(llllllllllllllllIIlIlIllIlllIIII, llllllllllllllllIIlIlIllIlllIlll);
            llllllllllllllllIIlIlIllIlllIIII.visitInsn(83);
        }
        llllllllllllllllIIlIlIllIlllIIII.visitMethodInsn(183, llllllllllllllllIIlIlIllIllIlllI, "<init>", "([Ljava/lang/Object;)V", false);
        llllllllllllllllIIlIlIllIlllIIII.visitInsn(176);
        llllllllllllllllIIlIlIllIlllIIII.visitMaxs(6, Bytecode.getArgsSize(llllllllllllllllIIlIlIllIlllIIll));
        llllllllllllllllIIlIlIllIlllIIII.visitEnd();
    }

    private static void unbox(MethodVisitor llllllllllllllllIIlIlIlIllIllIIl, Type llllllllllllllllIIlIlIlIllIllIII) {
        String llllllllllllllllIIlIlIlIllIlIlll = Bytecode.getBoxingType(llllllllllllllllIIlIlIlIllIllIII);
        if (llllllllllllllllIIlIlIlIllIlIlll != null) {
            String llllllllllllllllIIlIlIlIllIllIll = Bytecode.getUnboxingMethod(llllllllllllllllIIlIlIlIllIllIII);
            String llllllllllllllllIIlIlIlIllIllIlI = String.valueOf(new StringBuilder().append("()").append(llllllllllllllllIIlIlIlIllIllIII.getDescriptor()));
            llllllllllllllllIIlIlIlIllIllIIl.visitTypeInsn(192, llllllllllllllllIIlIlIlIllIlIlll);
            llllllllllllllllIIlIlIlIllIllIIl.visitMethodInsn(182, llllllllllllllllIIlIlIlIllIlIlll, llllllllllllllllIIlIlIlIllIllIll, llllllllllllllllIIlIlIlIllIllIlI, false);
        } else {
            llllllllllllllllIIlIlIlIllIllIIl.visitTypeInsn(192, llllllllllllllllIIlIlIlIllIllIII.getInternalName());
        }
    }

    private void generateGetters(String llllllllllllllllIIlIlIllIlIlIIll, String llllllllllllllllIIlIlIllIlIlIIlI, Type[] llllllllllllllllIIlIlIllIlIlIIIl, ClassVisitor llllllllllllllllIIlIlIllIlIIllII) {
        byte llllllllllllllllIIlIlIllIlIIllll = 0;
        for (Type llllllllllllllllIIlIlIllIlIlIlIl : llllllllllllllllIIlIlIllIlIlIIIl) {
            String llllllllllllllllIIlIlIllIlIllIII = String.valueOf(new StringBuilder().append("$").append(llllllllllllllllIIlIlIllIlIIllll));
            String llllllllllllllllIIlIlIllIlIlIlll = String.valueOf(new StringBuilder().append("()").append(llllllllllllllllIIlIlIllIlIlIlIl.getDescriptor()));
            MethodVisitorEx llllllllllllllllIIlIlIllIlIlIllI = new MethodVisitorEx(llllllllllllllllIIlIlIllIlIIllII.visitMethod(1, llllllllllllllllIIlIlIllIlIllIII, llllllllllllllllIIlIlIllIlIlIlll, null, null));
            llllllllllllllllIIlIlIllIlIlIllI.visitCode();
            llllllllllllllllIIlIlIllIlIlIllI.visitVarInsn(25, 0);
            llllllllllllllllIIlIlIllIlIlIllI.visitFieldInsn(180, llllllllllllllllIIlIlIllIlIlIIll, "values", "[Ljava/lang/Object;");
            llllllllllllllllIIlIlIllIlIlIllI.visitConstant(llllllllllllllllIIlIlIllIlIIllll);
            llllllllllllllllIIlIlIllIlIlIllI.visitInsn(50);
            ArgsClassGenerator.unbox(llllllllllllllllIIlIlIllIlIlIllI, llllllllllllllllIIlIlIllIlIlIlIl);
            llllllllllllllllIIlIlIllIlIlIllI.visitInsn(llllllllllllllllIIlIlIllIlIlIlIl.getOpcode(172));
            llllllllllllllllIIlIlIllIlIlIllI.visitMaxs(2, 1);
            llllllllllllllllIIlIlIllIlIlIllI.visitEnd();
            llllllllllllllllIIlIlIllIlIIllll = (byte)(llllllllllllllllIIlIlIllIlIIllll + 1);
        }
    }
}

