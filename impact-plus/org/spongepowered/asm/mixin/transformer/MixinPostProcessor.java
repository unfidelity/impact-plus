/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.ClassVisitor;
import org.spongepowered.asm.lib.FieldVisitor;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.MixinConfig;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.throwables.MixinTransformerError;
import org.spongepowered.asm.transformers.MixinClassWriter;
import org.spongepowered.asm.transformers.TreeTransformer;
import org.spongepowered.asm.util.Bytecode;

class MixinPostProcessor
extends TreeTransformer
implements MixinConfig.IListener {
    private final /* synthetic */ Map<String, MixinInfo> accessorMixins;
    private final /* synthetic */ Set<String> loadable;
    private final /* synthetic */ Set<String> syntheticInnerClasses;

    private static ClassInfo.Method getAccessorMethod(MixinInfo llllllllllllllllIlIlIIIlIIllIIll, MethodNode llllllllllllllllIlIlIIIlIIllIllI, ClassInfo llllllllllllllllIlIlIIIlIIllIIIl) throws MixinTransformerError {
        ClassInfo.Method llllllllllllllllIlIlIIIlIIllIlII = llllllllllllllllIlIlIIIlIIllIIll.getClassInfo().findMethod(llllllllllllllllIlIlIIIlIIllIllI, 10);
        if (!llllllllllllllllIlIlIIIlIIllIlII.isRenamed()) {
            throw new MixinTransformerError(String.valueOf(new StringBuilder().append("Unexpected state: ").append(llllllllllllllllIlIlIIIlIIllIIll).append(" loaded before ").append(llllllllllllllllIlIlIIIlIIllIIIl).append(" was conformed")));
        }
        return llllllllllllllllIlIlIIIlIIllIlII;
    }

    private byte[] processSyntheticInner(byte[] llllllllllllllllIlIlIIIlIllIIIII) {
        MixinPostProcessor llllllllllllllllIlIlIIIlIllIIllI;
        ClassReader llllllllllllllllIlIlIIIlIllIIlII = new ClassReader(llllllllllllllllIlIlIIIlIllIIIII);
        MixinClassWriter llllllllllllllllIlIlIIIlIllIIIll = new MixinClassWriter(llllllllllllllllIlIlIIIlIllIIlII, 0);
        ClassVisitor llllllllllllllllIlIlIIIlIllIIIlI = new ClassVisitor(327680, llllllllllllllllIlIlIIIlIllIIIll){

            @Override
            public FieldVisitor visitField(int llllllllllllllllIIllIllIllIllIlI, String llllllllllllllllIIllIllIllIlllll, String llllllllllllllllIIllIllIllIllllI, String llllllllllllllllIIllIllIllIlllIl, Object llllllllllllllllIIllIllIllIlIllI) {
                1 llllllllllllllllIIllIllIllIllIll;
                if ((llllllllllllllllIIllIllIllIllIlI & 6) == 0) {
                    llllllllllllllllIIllIllIllIllIlI |= 1;
                }
                return super.visitField(llllllllllllllllIIllIllIllIllIlI, llllllllllllllllIIllIllIllIlllll, llllllllllllllllIIllIllIllIllllI, llllllllllllllllIIllIllIllIlllIl, llllllllllllllllIIllIllIllIlIllI);
            }

            @Override
            public void visit(int llllllllllllllllIIllIllIlllIllIl, int llllllllllllllllIIllIllIlllIllII, String llllllllllllllllIIllIllIllllIIlI, String llllllllllllllllIIllIllIllllIIIl, String llllllllllllllllIIllIllIllllIIII, String[] llllllllllllllllIIllIllIlllIlIII) {
                1 llllllllllllllllIIllIllIllllIlIl;
                super.visit(llllllllllllllllIIllIllIlllIllIl, llllllllllllllllIIllIllIlllIllII | 1, llllllllllllllllIIllIllIllllIIlI, llllllllllllllllIIllIllIllllIIIl, llllllllllllllllIIllIllIllllIIII, llllllllllllllllIIllIllIlllIlIII);
            }
            {
                1 llllllllllllllllIIllIlllIIIIIlII;
                super(llllllllllllllllIIllIlllIIIIIIlI, llllllllllllllllIIllIllIllllllIl);
            }

            @Override
            public MethodVisitor visitMethod(int llllllllllllllllIIllIllIllIIlIII, String llllllllllllllllIIllIllIllIIllIl, String llllllllllllllllIIllIllIllIIIllI, String llllllllllllllllIIllIllIllIIlIll, String[] llllllllllllllllIIllIllIllIIIlII) {
                1 llllllllllllllllIIllIllIllIIllll;
                if ((llllllllllllllllIIllIllIllIIlIII & 6) == 0) {
                    llllllllllllllllIIllIllIllIIlIII |= 1;
                }
                return super.visitMethod(llllllllllllllllIIllIllIllIIlIII, llllllllllllllllIIllIllIllIIllIl, llllllllllllllllIIllIllIllIIIllI, llllllllllllllllIIllIllIllIIlIll, llllllllllllllllIIllIllIllIIIlII);
            }
        };
        llllllllllllllllIlIlIIIlIllIIlII.accept(llllllllllllllllIlIlIIIlIllIIIlI, 8);
        return llllllllllllllllIlIlIIIlIllIIIll.toByteArray();
    }

    @Override
    public boolean isDelegationExcluded() {
        return true;
    }

    @Override
    public void onPrepare(MixinInfo llllllllllllllllIlIlIIIllIllIlIl) {
        MixinPostProcessor llllllllllllllllIlIlIIIllIllIllI;
        String llllllllllllllllIlIlIIIllIllIlll = llllllllllllllllIlIlIIIllIllIlIl.getClassName();
        if (llllllllllllllllIlIlIIIllIllIlIl.isLoadable()) {
            llllllllllllllllIlIlIIIllIllIllI.registerLoadable(llllllllllllllllIlIlIIIllIllIlll);
        }
        if (llllllllllllllllIlIlIIIllIllIlIl.isAccessor()) {
            llllllllllllllllIlIlIIIllIllIllI.registerAccessor(llllllllllllllllIlIlIIIllIllIlIl);
        }
    }

    void registerSyntheticInner(String llllllllllllllllIlIlIIIllIlIIlll) {
        MixinPostProcessor llllllllllllllllIlIlIIIllIlIlIIl;
        llllllllllllllllIlIlIIIllIlIlIIl.syntheticInnerClasses.add(llllllllllllllllIlIlIIIllIlIIlll);
    }

    void registerAccessor(MixinInfo llllllllllllllllIlIlIIIllIIIllII) {
        MixinPostProcessor llllllllllllllllIlIlIIIllIIIllIl;
        llllllllllllllllIlIlIIIllIIIllIl.registerLoadable(llllllllllllllllIlIlIIIllIIIllII.getClassName());
        llllllllllllllllIlIlIIIllIIIllIl.accessorMixins.put(llllllllllllllllIlIlIIIllIIIllII.getClassName(), llllllllllllllllIlIlIIIllIIIllII);
    }

    @Override
    public byte[] transformClassBytes(String llllllllllllllllIlIlIIIlIlllIIlI, String llllllllllllllllIlIlIIIlIllIlllI, byte[] llllllllllllllllIlIlIIIlIllIllIl) {
        MixinPostProcessor llllllllllllllllIlIlIIIlIllIllll;
        if (llllllllllllllllIlIlIIIlIllIllll.syntheticInnerClasses.contains(llllllllllllllllIlIlIIIlIllIlllI)) {
            return llllllllllllllllIlIlIIIlIllIllll.processSyntheticInner(llllllllllllllllIlIlIIIlIllIllIl);
        }
        if (llllllllllllllllIlIlIIIlIllIllll.accessorMixins.containsKey(llllllllllllllllIlIlIIIlIllIlllI)) {
            MixinInfo llllllllllllllllIlIlIIIlIlllIlII = llllllllllllllllIlIlIIIlIllIllll.accessorMixins.get(llllllllllllllllIlIlIIIlIllIlllI);
            return llllllllllllllllIlIlIIIlIllIllll.processAccessor(llllllllllllllllIlIlIIIlIllIllIl, llllllllllllllllIlIlIIIlIlllIlII);
        }
        return llllllllllllllllIlIlIIIlIllIllIl;
    }

    @Override
    public String getName() {
        MixinPostProcessor llllllllllllllllIlIlIIIlIllllIll;
        return llllllllllllllllIlIlIIIlIllllIll.getClass().getName();
    }

    private byte[] processAccessor(byte[] llllllllllllllllIlIlIIIlIlIIIlIl, MixinInfo llllllllllllllllIlIlIIIlIlIIlIlI) {
        if (!MixinEnvironment.getCompatibilityLevel().isAtLeast(MixinEnvironment.CompatibilityLevel.JAVA_8)) {
            return llllllllllllllllIlIlIIIlIlIIIlIl;
        }
        boolean llllllllllllllllIlIlIIIlIlIIlIIl = false;
        MixinInfo.MixinClassNode llllllllllllllllIlIlIIIlIlIIlIII = llllllllllllllllIlIlIIIlIlIIlIlI.getClassNode(0);
        ClassInfo llllllllllllllllIlIlIIIlIlIIIlll = llllllllllllllllIlIlIIIlIlIIlIlI.getTargets().get(0);
        for (MixinInfo.MixinMethodNode llllllllllllllllIlIlIIIlIlIlIIII : llllllllllllllllIlIlIIIlIlIIlIII.mixinMethods) {
            if (!Bytecode.hasFlag(llllllllllllllllIlIlIIIlIlIlIIII, 8)) continue;
            AnnotationNode llllllllllllllllIlIlIIIlIlIIllll = llllllllllllllllIlIlIIIlIlIlIIII.getVisibleAnnotation(Accessor.class);
            AnnotationNode llllllllllllllllIlIlIIIlIlIIlllI = llllllllllllllllIlIlIIIlIlIlIIII.getVisibleAnnotation(Invoker.class);
            if (llllllllllllllllIlIlIIIlIlIIllll == null && llllllllllllllllIlIlIIIlIlIIlllI == null) continue;
            ClassInfo.Method llllllllllllllllIlIlIIIlIlIlIIIl = MixinPostProcessor.getAccessorMethod(llllllllllllllllIlIlIIIlIlIIlIlI, llllllllllllllllIlIlIIIlIlIlIIII, llllllllllllllllIlIlIIIlIlIIIlll);
            MixinPostProcessor.createProxy(llllllllllllllllIlIlIIIlIlIlIIII, llllllllllllllllIlIlIIIlIlIIIlll, llllllllllllllllIlIlIIIlIlIlIIIl);
            llllllllllllllllIlIlIIIlIlIIlIIl = true;
        }
        if (llllllllllllllllIlIlIIIlIlIIlIIl) {
            MixinPostProcessor llllllllllllllllIlIlIIIlIlIIllII;
            return llllllllllllllllIlIlIIIlIlIIllII.writeClass(llllllllllllllllIlIlIIIlIlIIlIII);
        }
        return llllllllllllllllIlIlIIIlIlIIIlIl;
    }

    void registerLoadable(String llllllllllllllllIlIlIIIllIIllIII) {
        MixinPostProcessor llllllllllllllllIlIlIIIllIIlIlll;
        llllllllllllllllIlIlIIIllIIlIlll.loadable.add(llllllllllllllllIlIlIIIllIIllIII);
    }

    MixinPostProcessor() {
        MixinPostProcessor llllllllllllllllIlIlIIIlllIlIlll;
        llllllllllllllllIlIlIIIlllIlIlll.syntheticInnerClasses = new HashSet<String>();
        llllllllllllllllIlIlIIIlllIlIlll.accessorMixins = new HashMap<String, MixinInfo>();
        llllllllllllllllIlIlIIIlllIlIlll.loadable = new HashSet<String>();
    }

    @Override
    public void onInit(MixinInfo llllllllllllllllIlIlIIIlllIIIIIl) {
        for (String llllllllllllllllIlIlIIIlllIIIlIl : llllllllllllllllIlIlIIIlllIIIIIl.getSyntheticInnerClasses()) {
            MixinPostProcessor llllllllllllllllIlIlIIIlllIIIIll;
            llllllllllllllllIlIlIIIlllIIIIll.registerSyntheticInner(llllllllllllllllIlIlIIIlllIIIlIl.replace('/', '.'));
        }
    }

    private static void createProxy(MethodNode llllllllllllllllIlIlIIIlIIlIlIlI, ClassInfo llllllllllllllllIlIlIIIlIIlIlIIl, ClassInfo.Method llllllllllllllllIlIlIIIlIIlIIIll) {
        llllllllllllllllIlIlIIIlIIlIlIlI.instructions.clear();
        Type[] llllllllllllllllIlIlIIIlIIlIIlll = Type.getArgumentTypes(llllllllllllllllIlIlIIIlIIlIlIlI.desc);
        Type llllllllllllllllIlIlIIIlIIlIIllI = Type.getReturnType(llllllllllllllllIlIlIIIlIIlIlIlI.desc);
        Bytecode.loadArgs(llllllllllllllllIlIlIIIlIIlIIlll, llllllllllllllllIlIlIIIlIIlIlIlI.instructions, 0);
        llllllllllllllllIlIlIIIlIIlIlIlI.instructions.add(new MethodInsnNode(184, llllllllllllllllIlIlIIIlIIlIlIIl.getName(), llllllllllllllllIlIlIIIlIIlIIIll.getName(), llllllllllllllllIlIlIIIlIIlIlIlI.desc, false));
        llllllllllllllllIlIlIIIlIIlIlIlI.instructions.add(new InsnNode(llllllllllllllllIlIlIIIlIIlIIllI.getOpcode(172)));
        llllllllllllllllIlIlIIIlIIlIlIlI.maxStack = Bytecode.getFirstNonArgLocalIndex(llllllllllllllllIlIlIIIlIIlIIlll, false);
        llllllllllllllllIlIlIIIlIIlIlIlI.maxLocals = 0;
    }

    boolean canTransform(String llllllllllllllllIlIlIIIllIIIIIIl) {
        MixinPostProcessor llllllllllllllllIlIlIIIllIIIIIlI;
        return llllllllllllllllIlIlIIIllIIIIIlI.syntheticInnerClasses.contains(llllllllllllllllIlIlIIIllIIIIIIl) || llllllllllllllllIlIlIIIllIIIIIlI.loadable.contains(llllllllllllllllIlIlIIIllIIIIIIl);
    }
}

