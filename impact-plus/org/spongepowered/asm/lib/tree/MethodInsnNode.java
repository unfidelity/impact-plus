/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.Map;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class MethodInsnNode
extends AbstractInsnNode {
    public /* synthetic */ String owner;
    public /* synthetic */ String name;
    public /* synthetic */ String desc;
    public /* synthetic */ boolean itf;

    @Override
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> llllllllllllllllIIlllIlIlllIllII) {
        MethodInsnNode llllllllllllllllIIlllIlIlllIllIl;
        return new MethodInsnNode(llllllllllllllllIIlllIlIlllIllIl.opcode, llllllllllllllllIIlllIlIlllIllIl.owner, llllllllllllllllIIlllIlIlllIllIl.name, llllllllllllllllIIlllIlIlllIllIl.desc, llllllllllllllllIIlllIlIlllIllIl.itf);
    }

    @Override
    public void accept(MethodVisitor llllllllllllllllIIlllIlIllllIIll) {
        MethodInsnNode llllllllllllllllIIlllIlIllllIIlI;
        llllllllllllllllIIlllIlIllllIIll.visitMethodInsn(llllllllllllllllIIlllIlIllllIIlI.opcode, llllllllllllllllIIlllIlIllllIIlI.owner, llllllllllllllllIIlllIlIllllIIlI.name, llllllllllllllllIIlllIlIllllIIlI.desc, llllllllllllllllIIlllIlIllllIIlI.itf);
        llllllllllllllllIIlllIlIllllIIlI.acceptAnnotations(llllllllllllllllIIlllIlIllllIIll);
    }

    public MethodInsnNode(int llllllllllllllllIIlllIllIIIIlllI, String llllllllllllllllIIlllIllIIIIllII, String llllllllllllllllIIlllIllIIIlIIll, String llllllllllllllllIIlllIllIIIIlIIl, boolean llllllllllllllllIIlllIllIIIIIlll) {
        super(llllllllllllllllIIlllIllIIIIlllI);
        MethodInsnNode llllllllllllllllIIlllIllIIIlIllI;
        llllllllllllllllIIlllIllIIIlIllI.owner = llllllllllllllllIIlllIllIIIIllII;
        llllllllllllllllIIlllIllIIIlIllI.name = llllllllllllllllIIlllIllIIIlIIll;
        llllllllllllllllIIlllIllIIIlIllI.desc = llllllllllllllllIIlllIllIIIIlIIl;
        llllllllllllllllIIlllIllIIIlIllI.itf = llllllllllllllllIIlllIllIIIIIlll;
    }

    @Override
    public int getType() {
        return 5;
    }

    @Deprecated
    public MethodInsnNode(int llllllllllllllllIIlllIllIIllIlIl, String llllllllllllllllIIlllIllIIlIlIII, String llllllllllllllllIIlllIllIIlIIlll, String llllllllllllllllIIlllIllIIlIIlIl) {
        llllllllllllllllIIlllIllIIlIllIl(llllllllllllllllIIlllIllIIllIlIl, llllllllllllllllIIlllIllIIlIlIII, llllllllllllllllIIlllIllIIlIIlll, llllllllllllllllIIlllIllIIlIIlIl, llllllllllllllllIIlllIllIIllIlIl == 185);
        MethodInsnNode llllllllllllllllIIlllIllIIlIllIl;
    }

    public void setOpcode(int llllllllllllllllIIlllIlIlllllIII) {
        llllllllllllllllIIlllIlIllllllIl.opcode = llllllllllllllllIIlllIlIlllllIII;
    }
}

