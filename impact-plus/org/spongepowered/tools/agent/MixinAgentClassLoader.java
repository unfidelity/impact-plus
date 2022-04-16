/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.tools.agent;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.ClassWriter;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.mixin.MixinEnvironment;

class MixinAgentClassLoader
extends ClassLoader {
    private /* synthetic */ Map<Class<?>, byte[]> mixins;
    private /* synthetic */ Map<String, byte[]> targets;
    private static final /* synthetic */ Logger logger;

    void addTargetClass(String llllllllllllllllIllllIIllIIlllIl, byte[] llllllllllllllllIllllIIllIIlllll) {
        MixinAgentClassLoader llllllllllllllllIllllIIllIlIIIIl;
        llllllllllllllllIllllIIllIlIIIIl.targets.put(llllllllllllllllIllllIIllIIlllIl, llllllllllllllllIllllIIllIIlllll);
    }

    byte[] getFakeMixinBytecode(Class<?> llllllllllllllllIllllIIllIIlIllI) {
        MixinAgentClassLoader llllllllllllllllIllllIIllIIlIlll;
        return llllllllllllllllIllllIIllIIlIlll.mixins.get(llllllllllllllllIllllIIllIIlIllI);
    }

    static {
        logger = LogManager.getLogger((String)"mixin.agent");
    }

    void addMixinClass(String llllllllllllllllIllllIIllIlIlIIl) {
        logger.debug("Mixin class {} added to class loader", new Object[]{llllllllllllllllIllllIIllIlIlIIl});
        try {
            MixinAgentClassLoader llllllllllllllllIllllIIllIlIlIlI;
            byte[] llllllllllllllllIllllIIllIlIllIl = llllllllllllllllIllllIIllIlIlIlI.materialise(llllllllllllllllIllllIIllIlIlIIl);
            Class<?> llllllllllllllllIllllIIllIlIllII = llllllllllllllllIllllIIllIlIlIlI.defineClass(llllllllllllllllIllllIIllIlIlIIl, llllllllllllllllIllllIIllIlIllIl, 0, llllllllllllllllIllllIIllIlIllIl.length);
            llllllllllllllllIllllIIllIlIllII.newInstance();
            llllllllllllllllIllllIIllIlIlIlI.mixins.put(llllllllllllllllIllllIIllIlIllII, llllllllllllllllIllllIIllIlIllIl);
        }
        catch (Throwable llllllllllllllllIllllIIllIlIlIll) {
            logger.catching(llllllllllllllllIllllIIllIlIlIll);
        }
    }

    byte[] getOriginalTargetBytecode(String llllllllllllllllIllllIIllIIlIIII) {
        MixinAgentClassLoader llllllllllllllllIllllIIllIIlIIIl;
        return llllllllllllllllIllllIIllIIlIIIl.targets.get(llllllllllllllllIllllIIllIIlIIII);
    }

    private byte[] materialise(String llllllllllllllllIllllIIllIIIlIll) {
        ClassWriter llllllllllllllllIllllIIllIIIlIlI = new ClassWriter(3);
        llllllllllllllllIllllIIllIIIlIlI.visit(MixinEnvironment.getCompatibilityLevel().classVersion(), 1, llllllllllllllllIllllIIllIIIlIll.replace('.', '/'), null, Type.getInternalName(Object.class), null);
        MethodVisitor llllllllllllllllIllllIIllIIIlIIl = llllllllllllllllIllllIIllIIIlIlI.visitMethod(1, "<init>", "()V", null, null);
        llllllllllllllllIllllIIllIIIlIIl.visitCode();
        llllllllllllllllIllllIIllIIIlIIl.visitVarInsn(25, 0);
        llllllllllllllllIllllIIllIIIlIIl.visitMethodInsn(183, Type.getInternalName(Object.class), "<init>", "()V", false);
        llllllllllllllllIllllIIllIIIlIIl.visitInsn(177);
        llllllllllllllllIllllIIllIIIlIIl.visitMaxs(1, 1);
        llllllllllllllllIllllIIllIIIlIIl.visitEnd();
        llllllllllllllllIllllIIllIIIlIlI.visitEnd();
        return llllllllllllllllIllllIIllIIIlIlI.toByteArray();
    }

    MixinAgentClassLoader() {
        MixinAgentClassLoader llllllllllllllllIllllIIllIllIIll;
        llllllllllllllllIllllIIllIllIIll.mixins = new HashMap();
        llllllllllllllllIllllIIllIllIIll.targets = new HashMap<String, byte[]>();
    }
}

