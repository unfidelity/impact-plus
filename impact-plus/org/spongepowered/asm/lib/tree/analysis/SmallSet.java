/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.lib.tree.analysis;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
class SmallSet<E>
extends AbstractSet<E>
implements Iterator<E> {
    /* synthetic */ E e1;
    /* synthetic */ E e2;

    static final <T> Set<T> emptySet() {
        return new SmallSet<Object>(null, null);
    }

    @Override
    public boolean hasNext() {
        SmallSet lllllllllllllllllIIllIlllIIIlIll;
        return lllllllllllllllllIIllIlllIIIlIll.e1 != null;
    }

    @Override
    public Iterator<E> iterator() {
        SmallSet lllllllllllllllllIIllIlllIIlIIlI;
        return new SmallSet<E>(lllllllllllllllllIIllIlllIIlIIlI.e1, lllllllllllllllllIIllIlllIIlIIlI.e2);
    }

    @Override
    public int size() {
        SmallSet lllllllllllllllllIIllIlllIIIllll;
        return lllllllllllllllllIIllIlllIIIllll.e1 == null ? 0 : (lllllllllllllllllIIllIlllIIIllll.e2 == null ? 1 : 2);
    }

    @Override
    public E next() {
        SmallSet lllllllllllllllllIIllIlllIIIlIII;
        if (lllllllllllllllllIIllIlllIIIlIII.e1 == null) {
            throw new NoSuchElementException();
        }
        E lllllllllllllllllIIllIlllIIIIlll = lllllllllllllllllIIllIlllIIIlIII.e1;
        lllllllllllllllllIIllIlllIIIlIII.e1 = lllllllllllllllllIIllIlllIIIlIII.e2;
        lllllllllllllllllIIllIlllIIIlIII.e2 = null;
        return lllllllllllllllllIIllIlllIIIIlll;
    }

    SmallSet(E lllllllllllllllllIIllIlllIIlIlIl, E lllllllllllllllllIIllIlllIIlIlll) {
        SmallSet lllllllllllllllllIIllIlllIIlIllI;
        lllllllllllllllllIIllIlllIIlIllI.e1 = lllllllllllllllllIIllIlllIIlIlIl;
        lllllllllllllllllIIllIlllIIlIllI.e2 = lllllllllllllllllIIllIlllIIlIlll;
    }

    Set<E> union(SmallSet<E> lllllllllllllllllIIllIllIlllllll) {
        SmallSet lllllllllllllllllIIllIlllIIIIIII;
        if (lllllllllllllllllIIllIllIlllllll.e1 == lllllllllllllllllIIllIlllIIIIIII.e1 && lllllllllllllllllIIllIllIlllllll.e2 == lllllllllllllllllIIllIlllIIIIIII.e2 || lllllllllllllllllIIllIllIlllllll.e1 == lllllllllllllllllIIllIlllIIIIIII.e2 && lllllllllllllllllIIllIllIlllllll.e2 == lllllllllllllllllIIllIlllIIIIIII.e1) {
            return lllllllllllllllllIIllIlllIIIIIII;
        }
        if (lllllllllllllllllIIllIllIlllllll.e1 == null) {
            return lllllllllllllllllIIllIlllIIIIIII;
        }
        if (lllllllllllllllllIIllIlllIIIIIII.e1 == null) {
            return lllllllllllllllllIIllIllIlllllll;
        }
        if (lllllllllllllllllIIllIllIlllllll.e2 == null) {
            if (lllllllllllllllllIIllIlllIIIIIII.e2 == null) {
                return new SmallSet<E>(lllllllllllllllllIIllIlllIIIIIII.e1, lllllllllllllllllIIllIllIlllllll.e1);
            }
            if (lllllllllllllllllIIllIllIlllllll.e1 == lllllllllllllllllIIllIlllIIIIIII.e1 || lllllllllllllllllIIllIllIlllllll.e1 == lllllllllllllllllIIllIlllIIIIIII.e2) {
                return lllllllllllllllllIIllIlllIIIIIII;
            }
        }
        if (lllllllllllllllllIIllIlllIIIIIII.e2 == null && (lllllllllllllllllIIllIlllIIIIIII.e1 == lllllllllllllllllIIllIllIlllllll.e1 || lllllllllllllllllIIllIlllIIIIIII.e1 == lllllllllllllllllIIllIllIlllllll.e2)) {
            return lllllllllllllllllIIllIllIlllllll;
        }
        HashSet<E> lllllllllllllllllIIllIllIllllllI = new HashSet<E>(4);
        lllllllllllllllllIIllIllIllllllI.add(lllllllllllllllllIIllIlllIIIIIII.e1);
        if (lllllllllllllllllIIllIlllIIIIIII.e2 != null) {
            lllllllllllllllllIIllIllIllllllI.add(lllllllllllllllllIIllIlllIIIIIII.e2);
        }
        lllllllllllllllllIIllIllIllllllI.add(lllllllllllllllllIIllIllIlllllll.e1);
        if (lllllllllllllllllIIllIllIlllllll.e2 != null) {
            lllllllllllllllllIIllIllIllllllI.add(lllllllllllllllllIIllIllIlllllll.e2);
        }
        return lllllllllllllllllIIllIllIllllllI;
    }

    @Override
    public void remove() {
    }
}

