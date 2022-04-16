/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.LabelNode;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class InsnList {
    private /* synthetic */ AbstractInsnNode first;
    private /* synthetic */ int size;
    private /* synthetic */ AbstractInsnNode last;
    /* synthetic */ AbstractInsnNode[] cache;

    public void insert(AbstractInsnNode lllllllllllllllllllllIIIIlllllll, AbstractInsnNode lllllllllllllllllllllIIIIllllIlI) {
        InsnList lllllllllllllllllllllIIIlIIIIIII;
        ++lllllllllllllllllllllIIIlIIIIIII.size;
        AbstractInsnNode lllllllllllllllllllllIIIIlllllIl = lllllllllllllllllllllIIIIlllllll.next;
        if (lllllllllllllllllllllIIIIlllllIl == null) {
            lllllllllllllllllllllIIIlIIIIIII.last = lllllllllllllllllllllIIIIllllIlI;
        } else {
            lllllllllllllllllllllIIIIlllllIl.prev = lllllllllllllllllllllIIIIllllIlI;
        }
        lllllllllllllllllllllIIIIlllllll.next = lllllllllllllllllllllIIIIllllIlI;
        lllllllllllllllllllllIIIIllllIlI.next = lllllllllllllllllllllIIIIlllllIl;
        lllllllllllllllllllllIIIIllllIlI.prev = lllllllllllllllllllllIIIIlllllll;
        lllllllllllllllllllllIIIlIIIIIII.cache = null;
        lllllllllllllllllllllIIIIllllIlI.index = 0;
    }

    public InsnList() {
        InsnList lllllllllllllllllllllIIlIlIlIIll;
    }

    public void clear() {
        InsnList lllllllllllllllllllllIIIIIlIllll;
        lllllllllllllllllllllIIIIIlIllll.removeAll(false);
    }

    public ListIterator<AbstractInsnNode> iterator() {
        InsnList lllllllllllllllllllllIIIlllIIIIl;
        return lllllllllllllllllllllIIIlllIIIIl.iterator(0);
    }

    public void remove(AbstractInsnNode lllllllllllllllllllllIIIIlIIIIll) {
        InsnList lllllllllllllllllllllIIIIlIIIlII;
        --lllllllllllllllllllllIIIIlIIIlII.size;
        AbstractInsnNode lllllllllllllllllllllIIIIlIIIIlI = lllllllllllllllllllllIIIIlIIIIll.next;
        AbstractInsnNode lllllllllllllllllllllIIIIlIIIIIl = lllllllllllllllllllllIIIIlIIIIll.prev;
        if (lllllllllllllllllllllIIIIlIIIIlI == null) {
            if (lllllllllllllllllllllIIIIlIIIIIl == null) {
                lllllllllllllllllllllIIIIlIIIlII.first = null;
                lllllllllllllllllllllIIIIlIIIlII.last = null;
            } else {
                lllllllllllllllllllllIIIIlIIIIIl.next = null;
                lllllllllllllllllllllIIIIlIIIlII.last = lllllllllllllllllllllIIIIlIIIIIl;
            }
        } else if (lllllllllllllllllllllIIIIlIIIIIl == null) {
            lllllllllllllllllllllIIIIlIIIlII.first = lllllllllllllllllllllIIIIlIIIIlI;
            lllllllllllllllllllllIIIIlIIIIlI.prev = null;
        } else {
            lllllllllllllllllllllIIIIlIIIIIl.next = lllllllllllllllllllllIIIIlIIIIlI;
            lllllllllllllllllllllIIIIlIIIIlI.prev = lllllllllllllllllllllIIIIlIIIIIl;
        }
        lllllllllllllllllllllIIIIlIIIlII.cache = null;
        lllllllllllllllllllllIIIIlIIIIll.index = -1;
        lllllllllllllllllllllIIIIlIIIIll.prev = null;
        lllllllllllllllllllllIIIIlIIIIll.next = null;
    }

    public AbstractInsnNode[] toArray() {
        InsnList lllllllllllllllllllllIIIllIIIlII;
        int lllllllllllllllllllllIIIllIIlIII = 0;
        AbstractInsnNode lllllllllllllllllllllIIIllIIIlll = lllllllllllllllllllllIIIllIIIlII.first;
        AbstractInsnNode[] lllllllllllllllllllllIIIllIIIlIl = new AbstractInsnNode[lllllllllllllllllllllIIIllIIIlII.size];
        while (lllllllllllllllllllllIIIllIIIlll != null) {
            lllllllllllllllllllllIIIllIIIlIl[lllllllllllllllllllllIIIllIIlIII] = lllllllllllllllllllllIIIllIIIlll;
            lllllllllllllllllllllIIIllIIIlll.index = lllllllllllllllllllllIIIllIIlIII++;
            lllllllllllllllllllllIIIllIIIlll = lllllllllllllllllllllIIIllIIIlll.next;
        }
        return lllllllllllllllllllllIIIllIIIlIl;
    }

    public void add(InsnList lllllllllllllllllllllIIIlIIlIlll) {
        InsnList lllllllllllllllllllllIIIlIIllIII;
        if (lllllllllllllllllllllIIIlIIlIlll.size == 0) {
            return;
        }
        lllllllllllllllllllllIIIlIIllIII.size += lllllllllllllllllllllIIIlIIlIlll.size;
        if (lllllllllllllllllllllIIIlIIllIII.last == null) {
            lllllllllllllllllllllIIIlIIllIII.first = lllllllllllllllllllllIIIlIIlIlll.first;
            lllllllllllllllllllllIIIlIIllIII.last = lllllllllllllllllllllIIIlIIlIlll.last;
        } else {
            AbstractInsnNode lllllllllllllllllllllIIIlIIllIIl;
            lllllllllllllllllllllIIIlIIllIII.last.next = lllllllllllllllllllllIIIlIIllIIl = lllllllllllllllllllllIIIlIIlIlll.first;
            lllllllllllllllllllllIIIlIIllIIl.prev = lllllllllllllllllllllIIIlIIllIII.last;
            lllllllllllllllllllllIIIlIIllIII.last = lllllllllllllllllllllIIIlIIlIlll.last;
        }
        lllllllllllllllllllllIIIlIIllIII.cache = null;
        lllllllllllllllllllllIIIlIIlIlll.removeAll(false);
    }

    public void resetLabels() {
        InsnList lllllllllllllllllllllIIIIIlIlIll;
        AbstractInsnNode lllllllllllllllllllllIIIIIlIlIlI = lllllllllllllllllllllIIIIIlIlIll.first;
        while (lllllllllllllllllllllIIIIIlIlIlI != null) {
            if (lllllllllllllllllllllIIIIIlIlIlI instanceof LabelNode) {
                ((LabelNode)lllllllllllllllllllllIIIIIlIlIlI).resetLabel();
            }
            lllllllllllllllllllllIIIIIlIlIlI = lllllllllllllllllllllIIIIIlIlIlI.next;
        }
    }

    public ListIterator<AbstractInsnNode> iterator(int lllllllllllllllllllllIIIllIlIlll) {
        InsnList lllllllllllllllllllllIIIllIllIII;
        return lllllllllllllllllllllIIIllIllIII.new InsnListIterator(lllllllllllllllllllllIIIllIlIlll);
    }

    public void set(AbstractInsnNode lllllllllllllllllllllIIIlIlIllII, AbstractInsnNode lllllllllllllllllllllIIIlIlIlIll) {
        InsnList lllllllllllllllllllllIIIlIlIllIl;
        AbstractInsnNode lllllllllllllllllllllIIIlIlIlIIl;
        AbstractInsnNode lllllllllllllllllllllIIIlIlIlIlI;
        lllllllllllllllllllllIIIlIlIlIll.next = lllllllllllllllllllllIIIlIlIlIlI = lllllllllllllllllllllIIIlIlIllII.next;
        if (lllllllllllllllllllllIIIlIlIlIlI != null) {
            lllllllllllllllllllllIIIlIlIlIlI.prev = lllllllllllllllllllllIIIlIlIlIll;
        } else {
            lllllllllllllllllllllIIIlIlIllIl.last = lllllllllllllllllllllIIIlIlIlIll;
        }
        lllllllllllllllllllllIIIlIlIlIll.prev = lllllllllllllllllllllIIIlIlIlIIl = lllllllllllllllllllllIIIlIlIllII.prev;
        if (lllllllllllllllllllllIIIlIlIlIIl != null) {
            lllllllllllllllllllllIIIlIlIlIIl.next = lllllllllllllllllllllIIIlIlIlIll;
        } else {
            lllllllllllllllllllllIIIlIlIllIl.first = lllllllllllllllllllllIIIlIlIlIll;
        }
        if (lllllllllllllllllllllIIIlIlIllIl.cache != null) {
            int lllllllllllllllllllllIIIlIlIlllI = lllllllllllllllllllllIIIlIlIllII.index;
            lllllllllllllllllllllIIIlIlIllIl.cache[lllllllllllllllllllllIIIlIlIlllI] = lllllllllllllllllllllIIIlIlIlIll;
            lllllllllllllllllllllIIIlIlIlIll.index = lllllllllllllllllllllIIIlIlIlllI;
        } else {
            lllllllllllllllllllllIIIlIlIlIll.index = 0;
        }
        lllllllllllllllllllllIIIlIlIllII.index = -1;
        lllllllllllllllllllllIIIlIlIllII.prev = null;
        lllllllllllllllllllllIIIlIlIllII.next = null;
    }

    public void insertBefore(AbstractInsnNode lllllllllllllllllllllIIIIlIlIIll, InsnList lllllllllllllllllllllIIIIlIlIIlI) {
        if (lllllllllllllllllllllIIIIlIlIIlI.size == 0) {
            return;
        }
        lllllllllllllllllllllIIIIlIIlllI.size += lllllllllllllllllllllIIIIlIlIIlI.size;
        AbstractInsnNode lllllllllllllllllllllIIIIlIlIIIl = lllllllllllllllllllllIIIIlIlIIlI.first;
        AbstractInsnNode lllllllllllllllllllllIIIIlIlIIII = lllllllllllllllllllllIIIIlIlIIlI.last;
        AbstractInsnNode lllllllllllllllllllllIIIIlIIllll = lllllllllllllllllllllIIIIlIlIIll.prev;
        if (lllllllllllllllllllllIIIIlIIllll == null) {
            lllllllllllllllllllllIIIIlIIlllI.first = lllllllllllllllllllllIIIIlIlIIIl;
        } else {
            lllllllllllllllllllllIIIIlIIllll.next = lllllllllllllllllllllIIIIlIlIIIl;
        }
        lllllllllllllllllllllIIIIlIlIIll.prev = lllllllllllllllllllllIIIIlIlIIII;
        lllllllllllllllllllllIIIIlIlIIII.next = lllllllllllllllllllllIIIIlIlIIll;
        lllllllllllllllllllllIIIIlIlIIIl.prev = lllllllllllllllllllllIIIIlIIllll;
        lllllllllllllllllllllIIIIlIIlllI.cache = null;
        lllllllllllllllllllllIIIIlIlIIlI.removeAll(false);
    }

    public AbstractInsnNode getFirst() {
        InsnList lllllllllllllllllllllIIlIIllllll;
        return lllllllllllllllllllllIIlIIllllll.first;
    }

    public void add(AbstractInsnNode lllllllllllllllllllllIIIlIIlllll) {
        InsnList lllllllllllllllllllllIIIlIlIIIII;
        ++lllllllllllllllllllllIIIlIlIIIII.size;
        if (lllllllllllllllllllllIIIlIlIIIII.last == null) {
            lllllllllllllllllllllIIIlIlIIIII.first = lllllllllllllllllllllIIIlIIlllll;
            lllllllllllllllllllllIIIlIlIIIII.last = lllllllllllllllllllllIIIlIIlllll;
        } else {
            lllllllllllllllllllllIIIlIlIIIII.last.next = lllllllllllllllllllllIIIlIIlllll;
            lllllllllllllllllllllIIIlIIlllll.prev = lllllllllllllllllllllIIIlIlIIIII.last;
        }
        lllllllllllllllllllllIIIlIlIIIII.last = lllllllllllllllllllllIIIlIIlllll;
        lllllllllllllllllllllIIIlIlIIIII.cache = null;
        lllllllllllllllllllllIIIlIIlllll.index = 0;
    }

    public void accept(MethodVisitor lllllllllllllllllllllIIIlllIlIIl) {
        InsnList lllllllllllllllllllllIIIlllIllIl;
        AbstractInsnNode lllllllllllllllllllllIIIlllIlIll = lllllllllllllllllllllIIIlllIllIl.first;
        while (lllllllllllllllllllllIIIlllIlIll != null) {
            lllllllllllllllllllllIIIlllIlIll.accept(lllllllllllllllllllllIIIlllIlIIl);
            lllllllllllllllllllllIIIlllIlIll = lllllllllllllllllllllIIIlllIlIll.next;
        }
    }

    public boolean contains(AbstractInsnNode lllllllllllllllllllllIIIllllllll) {
        InsnList lllllllllllllllllllllIIlIIIIIllI;
        AbstractInsnNode lllllllllllllllllllllIIlIIIIIIlI = lllllllllllllllllllllIIlIIIIIllI.first;
        while (lllllllllllllllllllllIIlIIIIIIlI != null && lllllllllllllllllllllIIlIIIIIIlI != lllllllllllllllllllllIIIllllllll) {
            lllllllllllllllllllllIIlIIIIIIlI = lllllllllllllllllllllIIlIIIIIIlI.next;
        }
        return lllllllllllllllllllllIIlIIIIIIlI != null;
    }

    public AbstractInsnNode get(int lllllllllllllllllllllIIlIIIlIlII) {
        InsnList lllllllllllllllllllllIIlIIIllIII;
        if (lllllllllllllllllllllIIlIIIlIlII < 0 || lllllllllllllllllllllIIlIIIlIlII >= lllllllllllllllllllllIIlIIIllIII.size) {
            throw new IndexOutOfBoundsException();
        }
        if (lllllllllllllllllllllIIlIIIllIII.cache == null) {
            lllllllllllllllllllllIIlIIIllIII.cache = lllllllllllllllllllllIIlIIIllIII.toArray();
        }
        return lllllllllllllllllllllIIlIIIllIII.cache[lllllllllllllllllllllIIlIIIlIlII];
    }

    public void insertBefore(AbstractInsnNode lllllllllllllllllllllIIIIllIIIIl, AbstractInsnNode lllllllllllllllllllllIIIIlIlllII) {
        InsnList lllllllllllllllllllllIIIIllIIIlI;
        ++lllllllllllllllllllllIIIIllIIIlI.size;
        AbstractInsnNode lllllllllllllllllllllIIIIlIlllll = lllllllllllllllllllllIIIIllIIIIl.prev;
        if (lllllllllllllllllllllIIIIlIlllll == null) {
            lllllllllllllllllllllIIIIllIIIlI.first = lllllllllllllllllllllIIIIlIlllII;
        } else {
            lllllllllllllllllllllIIIIlIlllll.next = lllllllllllllllllllllIIIIlIlllII;
        }
        lllllllllllllllllllllIIIIllIIIIl.prev = lllllllllllllllllllllIIIIlIlllII;
        lllllllllllllllllllllIIIIlIlllII.next = lllllllllllllllllllllIIIIllIIIIl;
        lllllllllllllllllllllIIIIlIlllII.prev = lllllllllllllllllllllIIIIlIlllll;
        lllllllllllllllllllllIIIIllIIIlI.cache = null;
        lllllllllllllllllllllIIIIlIlllII.index = 0;
    }

    public void insert(InsnList lllllllllllllllllllllIIIlIIIIllI) {
        InsnList lllllllllllllllllllllIIIlIIIlIIl;
        if (lllllllllllllllllllllIIIlIIIIllI.size == 0) {
            return;
        }
        lllllllllllllllllllllIIIlIIIlIIl.size += lllllllllllllllllllllIIIlIIIIllI.size;
        if (lllllllllllllllllllllIIIlIIIlIIl.first == null) {
            lllllllllllllllllllllIIIlIIIlIIl.first = lllllllllllllllllllllIIIlIIIIllI.first;
            lllllllllllllllllllllIIIlIIIlIIl.last = lllllllllllllllllllllIIIlIIIIllI.last;
        } else {
            AbstractInsnNode lllllllllllllllllllllIIIlIIIlIlI;
            lllllllllllllllllllllIIIlIIIlIIl.first.prev = lllllllllllllllllllllIIIlIIIlIlI = lllllllllllllllllllllIIIlIIIIllI.last;
            lllllllllllllllllllllIIIlIIIlIlI.next = lllllllllllllllllllllIIIlIIIlIIl.first;
            lllllllllllllllllllllIIIlIIIlIIl.first = lllllllllllllllllllllIIIlIIIIllI.first;
        }
        lllllllllllllllllllllIIIlIIIlIIl.cache = null;
        lllllllllllllllllllllIIIlIIIIllI.removeAll(false);
    }

    public int size() {
        InsnList lllllllllllllllllllllIIlIlIIIlll;
        return lllllllllllllllllllllIIlIlIIIlll.size;
    }

    public void insert(AbstractInsnNode lllllllllllllllllllllIIIIlllIIIl, InsnList lllllllllllllllllllllIIIIllIlIlI) {
        if (lllllllllllllllllllllIIIIllIlIlI.size == 0) {
            return;
        }
        lllllllllllllllllllllIIIIlllIIlI.size += lllllllllllllllllllllIIIIllIlIlI.size;
        AbstractInsnNode lllllllllllllllllllllIIIIllIllll = lllllllllllllllllllllIIIIllIlIlI.first;
        AbstractInsnNode lllllllllllllllllllllIIIIllIlllI = lllllllllllllllllllllIIIIllIlIlI.last;
        AbstractInsnNode lllllllllllllllllllllIIIIllIllIl = lllllllllllllllllllllIIIIlllIIIl.next;
        if (lllllllllllllllllllllIIIIllIllIl == null) {
            lllllllllllllllllllllIIIIlllIIlI.last = lllllllllllllllllllllIIIIllIlllI;
        } else {
            lllllllllllllllllllllIIIIllIllIl.prev = lllllllllllllllllllllIIIIllIlllI;
        }
        lllllllllllllllllllllIIIIlllIIIl.next = lllllllllllllllllllllIIIIllIllll;
        lllllllllllllllllllllIIIIllIlllI.next = lllllllllllllllllllllIIIIllIllIl;
        lllllllllllllllllllllIIIIllIllll.prev = lllllllllllllllllllllIIIIlllIIIl;
        lllllllllllllllllllllIIIIlllIIlI.cache = null;
        lllllllllllllllllllllIIIIllIlIlI.removeAll(false);
    }

    public int indexOf(AbstractInsnNode lllllllllllllllllllllIIIllllIlII) {
        InsnList lllllllllllllllllllllIIIlllllIII;
        if (lllllllllllllllllllllIIIlllllIII.cache == null) {
            lllllllllllllllllllllIIIlllllIII.cache = lllllllllllllllllllllIIIlllllIII.toArray();
        }
        return lllllllllllllllllllllIIIllllIlII.index;
    }

    void removeAll(boolean lllllllllllllllllllllIIIIIllIlIl) {
        if (lllllllllllllllllllllIIIIIllIlIl) {
            InsnList lllllllllllllllllllllIIIIIllIllI;
            AbstractInsnNode lllllllllllllllllllllIIIIIllIlll = lllllllllllllllllllllIIIIIllIllI.first;
            while (lllllllllllllllllllllIIIIIllIlll != null) {
                AbstractInsnNode lllllllllllllllllllllIIIIIlllIII = lllllllllllllllllllllIIIIIllIlll.next;
                lllllllllllllllllllllIIIIIllIlll.index = -1;
                lllllllllllllllllllllIIIIIllIlll.prev = null;
                lllllllllllllllllllllIIIIIllIlll.next = null;
                lllllllllllllllllllllIIIIIllIlll = lllllllllllllllllllllIIIIIlllIII;
            }
        }
        lllllllllllllllllllllIIIIIllIllI.size = 0;
        lllllllllllllllllllllIIIIIllIllI.first = null;
        lllllllllllllllllllllIIIIIllIllI.last = null;
        lllllllllllllllllllllIIIIIllIllI.cache = null;
    }

    public AbstractInsnNode getLast() {
        InsnList lllllllllllllllllllllIIlIIlllIII;
        return lllllllllllllllllllllIIlIIlllIII.last;
    }

    public void insert(AbstractInsnNode lllllllllllllllllllllIIIlIIlIIII) {
        InsnList lllllllllllllllllllllIIIlIIIllll;
        ++lllllllllllllllllllllIIIlIIIllll.size;
        if (lllllllllllllllllllllIIIlIIIllll.first == null) {
            lllllllllllllllllllllIIIlIIIllll.first = lllllllllllllllllllllIIIlIIlIIII;
            lllllllllllllllllllllIIIlIIIllll.last = lllllllllllllllllllllIIIlIIlIIII;
        } else {
            lllllllllllllllllllllIIIlIIIllll.first.prev = lllllllllllllllllllllIIIlIIlIIII;
            lllllllllllllllllllllIIIlIIlIIII.next = lllllllllllllllllllllIIIlIIIllll.first;
        }
        lllllllllllllllllllllIIIlIIIllll.first = lllllllllllllllllllllIIIlIIlIIII;
        lllllllllllllllllllllIIIlIIIllll.cache = null;
        lllllllllllllllllllllIIIlIIlIIII.index = 0;
    }

    private final class InsnListIterator
    implements ListIterator {
        /* synthetic */ AbstractInsnNode remove;
        /* synthetic */ AbstractInsnNode next;
        /* synthetic */ AbstractInsnNode prev;

        public void remove() {
            InsnListIterator lllllllllllllllllllIlllIlllIllll;
            if (lllllllllllllllllllIlllIlllIllll.remove != null) {
                if (lllllllllllllllllllIlllIlllIllll.remove == lllllllllllllllllllIlllIlllIllll.next) {
                    lllllllllllllllllllIlllIlllIllll.next = lllllllllllllllllllIlllIlllIllll.next.next;
                } else {
                    lllllllllllllllllllIlllIlllIllll.prev = lllllllllllllllllllIlllIlllIllll.prev.prev;
                }
            } else {
                throw new IllegalStateException();
            }
            lllllllllllllllllllIlllIlllIllll.InsnList.this.remove(lllllllllllllllllllIlllIlllIllll.remove);
            lllllllllllllllllllIlllIlllIllll.remove = null;
        }

        public void add(Object lllllllllllllllllllIlllIllIllIII) {
            InsnListIterator lllllllllllllllllllIlllIllIllIll;
            if (lllllllllllllllllllIlllIllIllIll.next != null) {
                lllllllllllllllllllIlllIllIllIll.InsnList.this.insertBefore(lllllllllllllllllllIlllIllIllIll.next, (AbstractInsnNode)lllllllllllllllllllIlllIllIllIII);
            } else if (lllllllllllllllllllIlllIllIllIll.prev != null) {
                lllllllllllllllllllIlllIllIllIll.InsnList.this.insert(lllllllllllllllllllIlllIllIllIll.prev, (AbstractInsnNode)lllllllllllllllllllIlllIllIllIII);
            } else {
                lllllllllllllllllllIlllIllIllIll.InsnList.this.add((AbstractInsnNode)lllllllllllllllllllIlllIllIllIII);
            }
            lllllllllllllllllllIlllIllIllIll.prev = (AbstractInsnNode)lllllllllllllllllllIlllIllIllIII;
            lllllllllllllllllllIlllIllIllIll.remove = null;
        }

        public boolean hasPrevious() {
            InsnListIterator lllllllllllllllllllIlllIlllIlIlI;
            return lllllllllllllllllllIlllIlllIlIlI.prev != null;
        }

        InsnListIterator(int lllllllllllllllllllIllllIIIlIlIl) {
            InsnListIterator lllllllllllllllllllIllllIIIlIlII;
            if (lllllllllllllllllllIllllIIIlIlIl == lllllllllllllllllllIllllIIIlIlII.InsnList.this.size()) {
                lllllllllllllllllllIllllIIIlIlII.next = null;
                lllllllllllllllllllIllllIIIlIlII.prev = lllllllllllllllllllIllllIIIlIlII.InsnList.this.getLast();
            } else {
                lllllllllllllllllllIllllIIIlIlII.next = lllllllllllllllllllIllllIIIlIlII.InsnList.this.get(lllllllllllllllllllIllllIIIlIlIl);
                lllllllllllllllllllIllllIIIlIlII.prev = lllllllllllllllllllIllllIIIlIlII.next.prev;
            }
        }

        public boolean hasNext() {
            InsnListIterator lllllllllllllllllllIlllIllllllll;
            return lllllllllllllllllllIlllIllllllll.next != null;
        }

        public Object next() {
            AbstractInsnNode lllllllllllllllllllIlllIlllllIII;
            InsnListIterator lllllllllllllllllllIlllIllllIlll;
            if (lllllllllllllllllllIlllIllllIlll.next == null) {
                throw new NoSuchElementException();
            }
            lllllllllllllllllllIlllIllllIlll.prev = lllllllllllllllllllIlllIlllllIII = lllllllllllllllllllIlllIllllIlll.next;
            lllllllllllllllllllIlllIllllIlll.next = lllllllllllllllllllIlllIlllllIII.next;
            lllllllllllllllllllIlllIllllIlll.remove = lllllllllllllllllllIlllIlllllIII;
            return lllllllllllllllllllIlllIlllllIII;
        }

        public int nextIndex() {
            InsnListIterator lllllllllllllllllllIlllIlllIIIIl;
            if (lllllllllllllllllllIlllIlllIIIIl.next == null) {
                return lllllllllllllllllllIlllIlllIIIIl.InsnList.this.size();
            }
            if (lllllllllllllllllllIlllIlllIIIIl.InsnList.this.cache == null) {
                lllllllllllllllllllIlllIlllIIIIl.InsnList.this.cache = lllllllllllllllllllIlllIlllIIIIl.InsnList.this.toArray();
            }
            return lllllllllllllllllllIlllIlllIIIIl.next.index;
        }

        public Object previous() {
            InsnListIterator lllllllllllllllllllIlllIlllIIlIl;
            AbstractInsnNode lllllllllllllllllllIlllIlllIIllI;
            lllllllllllllllllllIlllIlllIIlIl.next = lllllllllllllllllllIlllIlllIIllI = lllllllllllllllllllIlllIlllIIlIl.prev;
            lllllllllllllllllllIlllIlllIIlIl.prev = lllllllllllllllllllIlllIlllIIllI.prev;
            lllllllllllllllllllIlllIlllIIlIl.remove = lllllllllllllllllllIlllIlllIIllI;
            return lllllllllllllllllllIlllIlllIIllI;
        }

        public int previousIndex() {
            InsnListIterator lllllllllllllllllllIlllIllIlllll;
            if (lllllllllllllllllllIlllIllIlllll.prev == null) {
                return -1;
            }
            if (lllllllllllllllllllIlllIllIlllll.InsnList.this.cache == null) {
                lllllllllllllllllllIlllIllIlllll.InsnList.this.cache = lllllllllllllllllllIlllIllIlllll.InsnList.this.toArray();
            }
            return lllllllllllllllllllIlllIllIlllll.prev.index;
        }

        public void set(Object lllllllllllllllllllIlllIllIlIIlI) {
            InsnListIterator lllllllllllllllllllIlllIllIlIlIl;
            if (lllllllllllllllllllIlllIllIlIlIl.remove != null) {
                lllllllllllllllllllIlllIllIlIlIl.InsnList.this.set(lllllllllllllllllllIlllIllIlIlIl.remove, (AbstractInsnNode)lllllllllllllllllllIlllIllIlIIlI);
                if (lllllllllllllllllllIlllIllIlIlIl.remove == lllllllllllllllllllIlllIllIlIlIl.prev) {
                    lllllllllllllllllllIlllIllIlIlIl.prev = (AbstractInsnNode)lllllllllllllllllllIlllIllIlIIlI;
                } else {
                    lllllllllllllllllllIlllIllIlIlIl.next = (AbstractInsnNode)lllllllllllllllllllIlllIllIlIIlI;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }
}

