/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.transformers;

import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.service.ILegacyClassTransformer;
import org.spongepowered.asm.transformers.MixinClassWriter;

public abstract class TreeTransformer
implements ILegacyClassTransformer {
    private /* synthetic */ ClassNode classNode;
    private /* synthetic */ ClassReader classReader;

    protected final ClassNode readClass(byte[] llllllllllllllllllIlIllIllllllll) {
        TreeTransformer llllllllllllllllllIlIlllIIIIIIII;
        return llllllllllllllllllIlIlllIIIIIIII.readClass(llllllllllllllllllIlIllIllllllll, true);
    }

    public TreeTransformer() {
        TreeTransformer llllllllllllllllllIlIlllIIIIIlII;
    }

    protected final ClassNode readClass(byte[] llllllllllllllllllIlIllIlllIIIll, boolean llllllllllllllllllIlIllIlllIIIlI) {
        ClassReader llllllllllllllllllIlIllIlllIIIIl = new ClassReader(llllllllllllllllllIlIllIlllIIIll);
        if (llllllllllllllllllIlIllIlllIIIlI) {
            llllllllllllllllllIlIllIllIlllll.classReader = llllllllllllllllllIlIllIlllIIIIl;
        }
        ClassNode llllllllllllllllllIlIllIlllIIIII = new ClassNode();
        llllllllllllllllllIlIllIlllIIIIl.accept(llllllllllllllllllIlIllIlllIIIII, 8);
        return llllllllllllllllllIlIllIlllIIIII;
    }

    protected final byte[] writeClass(ClassNode llllllllllllllllllIlIllIlIlIllll) {
        TreeTransformer llllllllllllllllllIlIllIlIlIllIl;
        if (llllllllllllllllllIlIllIlIlIllIl.classReader != null && llllllllllllllllllIlIllIlIlIllIl.classNode == llllllllllllllllllIlIllIlIlIllll) {
            llllllllllllllllllIlIllIlIlIllIl.classNode = null;
            MixinClassWriter llllllllllllllllllIlIllIlIllIIIl = new MixinClassWriter(llllllllllllllllllIlIllIlIlIllIl.classReader, 3);
            llllllllllllllllllIlIllIlIlIllIl.classReader = null;
            llllllllllllllllllIlIllIlIlIllll.accept(llllllllllllllllllIlIllIlIllIIIl);
            return llllllllllllllllllIlIllIlIllIIIl.toByteArray();
        }
        llllllllllllllllllIlIllIlIlIllIl.classNode = null;
        MixinClassWriter llllllllllllllllllIlIllIlIlIlllI = new MixinClassWriter(3);
        llllllllllllllllllIlIllIlIlIllll.accept(llllllllllllllllllIlIllIlIlIlllI);
        return llllllllllllllllllIlIllIlIlIlllI.toByteArray();
    }
}

