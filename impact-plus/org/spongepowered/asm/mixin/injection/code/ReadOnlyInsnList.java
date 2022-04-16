/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.code;

import java.util.ListIterator;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;

class ReadOnlyInsnList
extends InsnList {
    private /* synthetic */ InsnList insnList;

    @Override
    public final void resetLabels() {
        ReadOnlyInsnList lllllllllllllllllIlIIllllllllIIl;
        lllllllllllllllllIlIIllllllllIIl.insnList.resetLabels();
    }

    @Override
    public AbstractInsnNode[] toArray() {
        ReadOnlyInsnList lllllllllllllllllIlIlIIIIIIlllll;
        return lllllllllllllllllIlIlIIIIIIlllll.insnList.toArray();
    }

    @Override
    public boolean contains(AbstractInsnNode lllllllllllllllllIlIlIIIIIIIlIlI) {
        ReadOnlyInsnList lllllllllllllllllIlIlIIIIIIIlIll;
        return lllllllllllllllllIlIlIIIIIIIlIll.insnList.contains(lllllllllllllllllIlIlIIIIIIIlIlI);
    }

    @Override
    public int size() {
        ReadOnlyInsnList lllllllllllllllllIlIlIIIIIIlllII;
        return lllllllllllllllllIlIlIIIIIIlllII.insnList.size();
    }

    public ReadOnlyInsnList(InsnList lllllllllllllllllIlIlIIIIlIIIIII) {
        ReadOnlyInsnList lllllllllllllllllIlIlIIIIlIIIIIl;
        lllllllllllllllllIlIlIIIIlIIIIIl.insnList = lllllllllllllllllIlIlIIIIlIIIIII;
    }

    @Override
    public final void insert(InsnList lllllllllllllllllIlIlIIIIIllIIII) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<AbstractInsnNode> iterator() {
        ReadOnlyInsnList lllllllllllllllllIlIlIIIIIIIIIlI;
        return lllllllllllllllllIlIlIIIIIIIIIlI.insnList.iterator();
    }

    @Override
    public final void add(InsnList lllllllllllllllllIlIlIIIIIllIlII) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void insert(AbstractInsnNode lllllllllllllllllIlIlIIIIIllIIlI) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractInsnNode get(int lllllllllllllllllIlIlIIIIIIlIIII) {
        ReadOnlyInsnList lllllllllllllllllIlIlIIIIIIlIIll;
        return lllllllllllllllllIlIlIIIIIIlIIll.insnList.get(lllllllllllllllllIlIlIIIIIIlIIII);
    }

    @Override
    public ListIterator<AbstractInsnNode> iterator(int lllllllllllllllllIlIIllllllllIll) {
        ReadOnlyInsnList lllllllllllllllllIlIIlllllllllII;
        return lllllllllllllllllIlIIlllllllllII.insnList.iterator(lllllllllllllllllIlIIllllllllIll);
    }

    @Override
    public final void set(AbstractInsnNode lllllllllllllllllIlIlIIIIIlllIIl, AbstractInsnNode lllllllllllllllllIlIlIIIIIlllIII) {
        throw new UnsupportedOperationException();
    }

    void dispose() {
        lllllllllllllllllIlIlIIIIIllllII.insnList = null;
    }

    @Override
    public AbstractInsnNode getLast() {
        ReadOnlyInsnList lllllllllllllllllIlIlIIIIIIlIllI;
        return lllllllllllllllllIlIlIIIIIIlIllI.insnList.getLast();
    }

    @Override
    public final void insertBefore(AbstractInsnNode lllllllllllllllllIlIlIIIIIlIlIII, AbstractInsnNode lllllllllllllllllIlIlIIIIIlIIlll) {
        throw new UnsupportedOperationException();
    }

    @Override
    public AbstractInsnNode getFirst() {
        ReadOnlyInsnList lllllllllllllllllIlIlIIIIIIllIlI;
        return lllllllllllllllllIlIlIIIIIIllIlI.insnList.getFirst();
    }

    @Override
    public final void insert(AbstractInsnNode lllllllllllllllllIlIlIIIIIlIlIll, InsnList lllllllllllllllllIlIlIIIIIlIlIlI) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void insert(AbstractInsnNode lllllllllllllllllIlIlIIIIIlIlllI, AbstractInsnNode lllllllllllllllllIlIlIIIIIlIllIl) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void add(AbstractInsnNode lllllllllllllllllIlIlIIIIIllIllI) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void insertBefore(AbstractInsnNode lllllllllllllllllIlIlIIIIIlIIlIl, InsnList lllllllllllllllllIlIlIIIIIlIIlII) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(AbstractInsnNode lllllllllllllllllIlIlIIIIIIIIllI) {
        ReadOnlyInsnList lllllllllllllllllIlIlIIIIIIIIlll;
        return lllllllllllllllllIlIlIIIIIIIIlll.insnList.indexOf(lllllllllllllllllIlIlIIIIIIIIllI);
    }

    @Override
    public final void remove(AbstractInsnNode lllllllllllllllllIlIlIIIIIlIIIlI) {
        throw new UnsupportedOperationException();
    }
}

