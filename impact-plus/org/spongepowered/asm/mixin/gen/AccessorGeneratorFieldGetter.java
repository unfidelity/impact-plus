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

public class AccessorGeneratorFieldGetter
extends AccessorGeneratorField {
    public AccessorGeneratorFieldGetter(AccessorInfo llllllllllllllllIIlIIlIlIlllIIII) {
        super(llllllllllllllllIIlIIlIlIlllIIII);
        AccessorGeneratorFieldGetter llllllllllllllllIIlIIlIlIlllIIll;
    }

    @Override
    public MethodNode generate() {
        AccessorGeneratorFieldGetter llllllllllllllllIIlIIlIlIllIllII;
        MethodNode llllllllllllllllIIlIIlIlIllIlIll = llllllllllllllllIIlIIlIlIllIllII.createMethod(llllllllllllllllIIlIIlIlIllIllII.targetType.getSize(), llllllllllllllllIIlIIlIlIllIllII.targetType.getSize());
        if (llllllllllllllllIIlIIlIlIllIllII.isInstanceField) {
            llllllllllllllllIIlIIlIlIllIlIll.instructions.add(new VarInsnNode(25, 0));
        }
        int llllllllllllllllIIlIIlIlIllIlIlI = llllllllllllllllIIlIIlIlIllIllII.isInstanceField ? 180 : 178;
        llllllllllllllllIIlIIlIlIllIlIll.instructions.add(new FieldInsnNode(llllllllllllllllIIlIIlIlIllIlIlI, llllllllllllllllIIlIIlIlIllIllII.info.getClassNode().name, llllllllllllllllIIlIIlIlIllIllII.targetField.name, llllllllllllllllIIlIIlIlIllIllII.targetField.desc));
        llllllllllllllllIIlIIlIlIllIlIll.instructions.add(new InsnNode(llllllllllllllllIIlIIlIlIllIllII.targetType.getOpcode(172)));
        return llllllllllllllllIIlIIlIlIllIlIll;
    }
}

