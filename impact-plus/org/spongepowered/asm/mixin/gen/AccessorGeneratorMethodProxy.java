/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.gen;

import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.InsnNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.lib.tree.VarInsnNode;
import org.spongepowered.asm.mixin.gen.AccessorGenerator;
import org.spongepowered.asm.mixin.gen.AccessorInfo;
import org.spongepowered.asm.util.Bytecode;

public class AccessorGeneratorMethodProxy
extends AccessorGenerator {
    private final /* synthetic */ MethodNode targetMethod;
    private final /* synthetic */ Type[] argTypes;
    private final /* synthetic */ boolean isInstanceMethod;
    private final /* synthetic */ Type returnType;

    public AccessorGeneratorMethodProxy(AccessorInfo lIllllIIII) {
        super(lIllllIIII);
        AccessorGeneratorMethodProxy lIllllIIIl;
        lIllllIIIl.targetMethod = lIllllIIII.getTargetMethod();
        lIllllIIIl.argTypes = lIllllIIII.getArgTypes();
        lIllllIIIl.returnType = lIllllIIII.getReturnType();
        lIllllIIIl.isInstanceMethod = !Bytecode.hasFlag(lIllllIIIl.targetMethod, 8);
    }

    @Override
    public MethodNode generate() {
        AccessorGeneratorMethodProxy lIllIlIlII;
        int lIllIlIIlI = Bytecode.getArgsSize(lIllIlIlII.argTypes) + lIllIlIlII.returnType.getSize() + (lIllIlIlII.isInstanceMethod ? 1 : 0);
        MethodNode lIllIlIIIl = lIllIlIlII.createMethod(lIllIlIIlI, lIllIlIIlI);
        if (lIllIlIlII.isInstanceMethod) {
            lIllIlIIIl.instructions.add(new VarInsnNode(25, 0));
        }
        Bytecode.loadArgs(lIllIlIlII.argTypes, lIllIlIIIl.instructions, lIllIlIlII.isInstanceMethod ? 1 : 0);
        boolean lIllIlIIII = Bytecode.hasFlag(lIllIlIlII.targetMethod, 2);
        int lIllIIllll = lIllIlIlII.isInstanceMethod ? (lIllIlIIII ? 183 : 182) : 184;
        lIllIlIIIl.instructions.add(new MethodInsnNode(lIllIIllll, lIllIlIlII.info.getClassNode().name, lIllIlIlII.targetMethod.name, lIllIlIlII.targetMethod.desc, false));
        lIllIlIIIl.instructions.add(new InsnNode(lIllIlIlII.returnType.getOpcode(172)));
        return lIllIlIIIl;
    }
}

