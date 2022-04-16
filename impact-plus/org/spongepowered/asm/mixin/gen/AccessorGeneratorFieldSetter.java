/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.gen;

import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.gen.AccessorGeneratorField;
import org.spongepowered.asm.mixin.gen.AccessorInfo;

public class AccessorGeneratorFieldSetter
extends AccessorGeneratorField {
    public AccessorGeneratorFieldSetter(AccessorInfo llllllllllllllllIlIllllIllllllII) {
        super(llllllllllllllllIlIllllIllllllII);
        AccessorGeneratorFieldSetter llllllllllllllllIlIllllIlllllllI;
    }

    @Override
    public MethodNode generate() {
        AccessorGeneratorFieldSetter llllllllllllllllIlIllllIllIIllIl;
        int llllllllllllllllIlIllllIllIlIIlI = llllllllllllllllIlIllllIllIIllIl.isInstanceField ? 1 : 0;
        int llllllllllllllllIlIllllIllIlIIIl = llllllllllllllllIlIllllIllIlIIlI + llllllllllllllllIlIllllIllIIllIl.targetType.getSize();
        int llllllllllllllllIlIllllIllIlIIII = llllllllllllllllIlIllllIllIlIIlI + llllllllllllllllIlIllllIllIIllIl.targetType.getSize();
        MethodNode llllllllllllllllIlIllllIllIIllll = llllllllllllllllIlIllllIllIIllIl.createMethod(llllllllllllllllIlIllllIllIlIIIl, llllllllllllllllIlIllllIllIlIIII);
        if (llllllllllllllllIlIllllIllIIllIl.isInstanceField) {
            llllllllllllllllIlIllllIllIIllll.instructions.add(new VarInsnNode(25, 0));
        }
        llllllllllllllllIlIllllIllIIllll.instructions.add(new VarInsnNode(llllllllllllllllIlIllllIllIIllIl.targetType.getOpcode(21), llllllllllllllllIlIllllIllIlIIlI));
        int llllllllllllllllIlIllllIllIIlllI = llllllllllllllllIlIllllIllIIllIl.isInstanceField ? 181 : 179;
        llllllllllllllllIlIllllIllIIllll.instructions.add(new FieldInsnNode(llllllllllllllllIlIllllIllIIlllI, llllllllllllllllIlIllllIllIIllIl.info.getClassNode().name, llllllllllllllllIlIllllIllIIllIl.targetField.name, llllllllllllllllIlIllllIllIIllIl.targetField.desc));
        llllllllllllllllIlIllllIllIIllll.instructions.add(new InsnNode(177));
        return llllllllllllllllIlIllllIllIIllll;
    }
}

