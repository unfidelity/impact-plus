/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.transformer;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.struct.MemberRef;
import org.spongepowered.asm.mixin.transformer.ClassInfo;

abstract class ClassContext {
    private final /* synthetic */ Set<ClassInfo.Method> upgradedMethods;

    protected void upgradeMethodRef(MethodNode lllIlIllIlllIl, MemberRef lllIlIllIlIlIl, ClassInfo.Method lllIlIllIlIlII) {
        ClassContext lllIlIllIlllll;
        if (lllIlIllIlIlIl.getOpcode() != 183) {
            return;
        }
        if (lllIlIllIlllll.upgradedMethods.contains(lllIlIllIlIlII)) {
            lllIlIllIlIlIl.setOpcode(182);
        }
    }

    ClassContext() {
        ClassContext lllIllIIllIIIl;
        lllIllIIllIIIl.upgradedMethods = new HashSet<ClassInfo.Method>();
    }

    abstract ClassInfo getClassInfo();

    protected void upgradeMethods() {
        ClassContext lllIllIIIlIlll;
        for (MethodNode lllIllIIIllIII : lllIllIIIlIlll.getClassNode().methods) {
            lllIllIIIlIlll.upgradeMethod(lllIllIIIllIII);
        }
    }

    private void upgradeMethod(MethodNode lllIlIllllIlll) {
        ListIterator<AbstractInsnNode> lllIlIlllllIll = lllIlIllllIlll.instructions.iterator();
        while (lllIlIlllllIll.hasNext()) {
            ClassContext lllIlIllllIllI;
            MemberRef.Method lllIlIllllllII;
            AbstractInsnNode lllIlIllllllIl = (AbstractInsnNode)lllIlIlllllIll.next();
            if (!(lllIlIllllllIl instanceof MethodInsnNode) || !((MemberRef)(lllIlIllllllII = new MemberRef.Method((MethodInsnNode)lllIlIllllllIl))).getOwner().equals(lllIlIllllIllI.getClassRef())) continue;
            ClassInfo.Method lllIlIlllllllI = lllIlIllllIllI.getClassInfo().findMethod(((MemberRef)lllIlIllllllII).getName(), ((MemberRef)lllIlIllllllII).getDesc(), 10);
            lllIlIllllIllI.upgradeMethodRef(lllIlIllllIlll, lllIlIllllllII, lllIlIlllllllI);
        }
    }

    void addUpgradedMethod(MethodNode lllIllIIlIIllI) {
        ClassContext lllIllIIlIIIll;
        ClassInfo.Method lllIllIIlIIlIl = lllIllIIlIIIll.getClassInfo().findMethod(lllIllIIlIIllI);
        if (lllIllIIlIIlIl == null) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("Meta method for ").append(lllIllIIlIIllI.name).append(" not located in ").append(lllIllIIlIIIll)));
        }
        lllIllIIlIIIll.upgradedMethods.add(lllIllIIlIIlIl);
    }

    abstract String getClassRef();

    abstract ClassNode getClassNode();
}

