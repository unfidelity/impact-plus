/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 */
package org.spongepowered.asm.mixin.injection.code;

import com.google.common.base.Strings;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.IInjectionPointContext;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.code.ISliceContext;
import org.spongepowered.asm.mixin.injection.code.ReadOnlyInsnList;
import org.spongepowered.asm.mixin.injection.throwables.InjectionError;
import org.spongepowered.asm.mixin.injection.throwables.InvalidSliceException;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;

public final class MethodSlice {
    private final /* synthetic */ ISliceContext owner;
    private final /* synthetic */ String id;
    private final /* synthetic */ InjectionPoint to;
    private final /* synthetic */ InjectionPoint from;
    private final /* synthetic */ String name;

    private String describe(String llllllllllllllllIIlIllIlIIIIIlII) {
        MethodSlice llllllllllllllllIIlIllIlIIIIIlIl;
        return MethodSlice.describeSlice(llllllllllllllllIIlIllIlIIIIIlII, llllllllllllllllIIlIllIlIIIIIlIl.owner);
    }

    public ReadOnlyInsnList getSlice(MethodNode llllllllllllllllIIlIllIlIIllIIll) {
        int llllllllllllllllIIlIllIlIIllIIII;
        MethodSlice llllllllllllllllIIlIllIlIIlIllll;
        int llllllllllllllllIIlIllIlIIllIIlI = llllllllllllllllIIlIllIlIIllIIll.instructions.size() - 1;
        int llllllllllllllllIIlIllIlIIllIIIl = llllllllllllllllIIlIllIlIIlIllll.find(llllllllllllllllIIlIllIlIIllIIll, llllllllllllllllIIlIllIlIIlIllll.from, 0, String.valueOf(new StringBuilder().append(llllllllllllllllIIlIllIlIIlIllll.name).append("(from)")));
        if (llllllllllllllllIIlIllIlIIllIIIl > (llllllllllllllllIIlIllIlIIllIIII = llllllllllllllllIIlIllIlIIlIllll.find(llllllllllllllllIIlIllIlIIllIIll, llllllllllllllllIIlIllIlIIlIllll.to, llllllllllllllllIIlIllIlIIllIIlI, String.valueOf(new StringBuilder().append(llllllllllllllllIIlIllIlIIlIllll.name).append("(to)"))))) {
            throw new InvalidSliceException(llllllllllllllllIIlIllIlIIlIllll.owner, String.format("%s is negative size. Range(%d -> %d)", llllllllllllllllIIlIllIlIIlIllll.describe(), llllllllllllllllIIlIllIlIIllIIIl, llllllllllllllllIIlIllIlIIllIIII));
        }
        if (llllllllllllllllIIlIllIlIIllIIIl < 0 || llllllllllllllllIIlIllIlIIllIIII < 0 || llllllllllllllllIIlIllIlIIllIIIl > llllllllllllllllIIlIllIlIIllIIlI || llllllllllllllllIIlIllIlIIllIIII > llllllllllllllllIIlIllIlIIllIIlI) {
            throw new InjectionError(String.valueOf(new StringBuilder().append("Unexpected critical error in ").append(llllllllllllllllIIlIllIlIIlIllll).append(": out of bounds start=").append(llllllllllllllllIIlIllIlIIllIIIl).append(" end=").append(llllllllllllllllIIlIllIlIIllIIII).append(" lim=").append(llllllllllllllllIIlIllIlIIllIIlI)));
        }
        if (llllllllllllllllIIlIllIlIIllIIIl == 0 && llllllllllllllllIIlIllIlIIllIIII == llllllllllllllllIIlIllIlIIllIIlI) {
            return new ReadOnlyInsnList(llllllllllllllllIIlIllIlIIllIIll.instructions);
        }
        return new InsnListSlice(llllllllllllllllIIlIllIlIIllIIll.instructions, llllllllllllllllIIlIllIlIIllIIIl, llllllllllllllllIIlIllIlIIllIIII);
    }

    private int find(MethodNode llllllllllllllllIIlIllIlIIlIIIII, InjectionPoint llllllllllllllllIIlIllIlIIIlIllI, int llllllllllllllllIIlIllIlIIIllllI, String llllllllllllllllIIlIllIlIIIlIlII) {
        if (llllllllllllllllIIlIllIlIIIlIllI == null) {
            return llllllllllllllllIIlIllIlIIIllllI;
        }
        LinkedList<AbstractInsnNode> llllllllllllllllIIlIllIlIIIlllII = new LinkedList<AbstractInsnNode>();
        ReadOnlyInsnList llllllllllllllllIIlIllIlIIIllIll = new ReadOnlyInsnList(llllllllllllllllIIlIllIlIIlIIIII.instructions);
        boolean llllllllllllllllIIlIllIlIIIllIlI = llllllllllllllllIIlIllIlIIIlIllI.find(llllllllllllllllIIlIllIlIIlIIIII.desc, llllllllllllllllIIlIllIlIIIllIll, llllllllllllllllIIlIllIlIIIlllII);
        InjectionPoint.Selector llllllllllllllllIIlIllIlIIIllIIl = llllllllllllllllIIlIllIlIIIlIllI.getSelector();
        if (llllllllllllllllIIlIllIlIIIlllII.size() != 1 && llllllllllllllllIIlIllIlIIIllIIl == InjectionPoint.Selector.ONE) {
            MethodSlice llllllllllllllllIIlIllIlIIlIIIIl;
            throw new InvalidSliceException(llllllllllllllllIIlIllIlIIlIIIIl.owner, String.format("%s requires 1 result but found %d", llllllllllllllllIIlIllIlIIlIIIIl.describe(llllllllllllllllIIlIllIlIIIlIlII), llllllllllllllllIIlIllIlIIIlllII.size()));
        }
        if (!llllllllllllllllIIlIllIlIIIllIlI) {
            return llllllllllllllllIIlIllIlIIIllllI;
        }
        return llllllllllllllllIIlIllIlIIlIIIII.instructions.indexOf(llllllllllllllllIIlIllIlIIIllIIl == InjectionPoint.Selector.FIRST ? (AbstractInsnNode)llllllllllllllllIIlIllIlIIIlllII.getFirst() : (AbstractInsnNode)llllllllllllllllIIlIllIlIIIlllII.getLast());
    }

    public String getId() {
        MethodSlice llllllllllllllllIIlIllIlIIlllIll;
        return llllllllllllllllIIlIllIlIIlllIll.id;
    }

    public static MethodSlice parse(ISliceContext llllllllllllllllIIlIllIIlllIIllI, Slice llllllllllllllllIIlIllIIlllIIlIl) {
        String llllllllllllllllIIlIllIIlllIlIll = llllllllllllllllIIlIllIIlllIIlIl.id();
        At llllllllllllllllIIlIllIIlllIlIlI = llllllllllllllllIIlIllIIlllIIlIl.from();
        At llllllllllllllllIIlIllIIlllIlIIl = llllllllllllllllIIlIllIIlllIIlIl.to();
        InjectionPoint llllllllllllllllIIlIllIIlllIlIII = llllllllllllllllIIlIllIIlllIlIlI != null ? InjectionPoint.parse((IInjectionPointContext)llllllllllllllllIIlIllIIlllIIllI, llllllllllllllllIIlIllIIlllIlIlI) : null;
        InjectionPoint llllllllllllllllIIlIllIIlllIIlll = llllllllllllllllIIlIllIIlllIlIIl != null ? InjectionPoint.parse((IInjectionPointContext)llllllllllllllllIIlIllIIlllIIllI, llllllllllllllllIIlIllIIlllIlIIl) : null;
        return new MethodSlice(llllllllllllllllIIlIllIIlllIIllI, llllllllllllllllIIlIllIIlllIlIll, llllllllllllllllIIlIllIIlllIlIII, llllllllllllllllIIlIllIIlllIIlll);
    }

    public static MethodSlice parse(ISliceContext llllllllllllllllIIlIllIIllIlIIIl, AnnotationNode llllllllllllllllIIlIllIIllIlIIII) {
        String llllllllllllllllIIlIllIIllIlIllI = (String)Annotations.getValue(llllllllllllllllIIlIllIIllIlIIII, "id");
        AnnotationNode llllllllllllllllIIlIllIIllIlIlIl = (AnnotationNode)Annotations.getValue(llllllllllllllllIIlIllIIllIlIIII, "from");
        AnnotationNode llllllllllllllllIIlIllIIllIlIlII = (AnnotationNode)Annotations.getValue(llllllllllllllllIIlIllIIllIlIIII, "to");
        InjectionPoint llllllllllllllllIIlIllIIllIlIIll = llllllllllllllllIIlIllIIllIlIlIl != null ? InjectionPoint.parse((IInjectionPointContext)llllllllllllllllIIlIllIIllIlIIIl, llllllllllllllllIIlIllIIllIlIlIl) : null;
        InjectionPoint llllllllllllllllIIlIllIIllIlIIlI = llllllllllllllllIIlIllIIllIlIlII != null ? InjectionPoint.parse((IInjectionPointContext)llllllllllllllllIIlIllIIllIlIIIl, llllllllllllllllIIlIllIIllIlIlII) : null;
        return new MethodSlice(llllllllllllllllIIlIllIIllIlIIIl, llllllllllllllllIIlIllIIllIlIllI, llllllllllllllllIIlIllIIllIlIIll, llllllllllllllllIIlIllIIllIlIIlI);
    }

    private MethodSlice(ISliceContext llllllllllllllllIIlIllIlIlIIIlIl, String llllllllllllllllIIlIllIlIIllllll, InjectionPoint llllllllllllllllIIlIllIlIIlllllI, InjectionPoint llllllllllllllllIIlIllIlIlIIIIlI) {
        MethodSlice llllllllllllllllIIlIllIlIlIIIIIl;
        if (llllllllllllllllIIlIllIlIIlllllI == null && llllllllllllllllIIlIllIlIlIIIIlI == null) {
            throw new InvalidSliceException(llllllllllllllllIIlIllIlIlIIIlIl, String.format("%s is redundant. No 'from' or 'to' value specified", llllllllllllllllIIlIllIlIlIIIIIl));
        }
        llllllllllllllllIIlIllIlIlIIIIIl.owner = llllllllllllllllIIlIllIlIlIIIlIl;
        llllllllllllllllIIlIllIlIlIIIIIl.id = Strings.nullToEmpty((String)llllllllllllllllIIlIllIlIIllllll);
        llllllllllllllllIIlIllIlIlIIIIIl.from = llllllllllllllllIIlIllIlIIlllllI;
        llllllllllllllllIIlIllIlIlIIIIIl.to = llllllllllllllllIIlIllIlIlIIIIlI;
        llllllllllllllllIIlIllIlIlIIIIIl.name = MethodSlice.getSliceName(llllllllllllllllIIlIllIlIIllllll);
    }

    public String toString() {
        MethodSlice llllllllllllllllIIlIllIlIIIIlllI;
        return llllllllllllllllIIlIllIlIIIIlllI.describe();
    }

    private String describe() {
        MethodSlice llllllllllllllllIIlIllIlIIIIlIlI;
        return llllllllllllllllIIlIllIlIIIIlIlI.describe(llllllllllllllllIIlIllIlIIIIlIlI.name);
    }

    private static String describeSlice(String llllllllllllllllIIlIllIIllllllll, ISliceContext llllllllllllllllIIlIllIIlllllllI) {
        String llllllllllllllllIIlIllIIllllllIl = Bytecode.getSimpleName(llllllllllllllllIIlIllIIlllllllI.getAnnotation());
        MethodNode llllllllllllllllIIlIllIIllllllII = llllllllllllllllIIlIllIIlllllllI.getMethod();
        return String.format("%s->%s(%s)::%s%s", llllllllllllllllIIlIllIIlllllllI.getContext(), llllllllllllllllIIlIllIIllllllIl, llllllllllllllllIIlIllIIllllllll, llllllllllllllllIIlIllIIllllllII.name, llllllllllllllllIIlIllIIllllllII.desc);
    }

    private static String getSliceName(String llllllllllllllllIIlIllIIllllIlIl) {
        return String.format("@Slice[%s]", Strings.nullToEmpty((String)llllllllllllllllIIlIllIIllllIlIl));
    }

    static final class InsnListSlice
    extends ReadOnlyInsnList {
        private final /* synthetic */ int start;
        private final /* synthetic */ int end;

        @Override
        public ListIterator<AbstractInsnNode> iterator(int lllIlllllIllIIl) {
            InsnListSlice lllIlllllIllIlI;
            return new SliceIterator(super.iterator(lllIlllllIllIlI.start + lllIlllllIllIIl), lllIlllllIllIlI.start, lllIlllllIllIlI.end, lllIlllllIllIlI.start + lllIlllllIllIIl);
        }

        @Override
        public ListIterator<AbstractInsnNode> iterator() {
            InsnListSlice lllIlllllIllllI;
            return lllIlllllIllllI.iterator(0);
        }

        public int realIndexOf(AbstractInsnNode lllIllllIlIIIIl) {
            InsnListSlice lllIllllIlIIlII;
            return super.indexOf(lllIllllIlIIIIl);
        }

        @Override
        public int size() {
            InsnListSlice lllIlllllIIlIll;
            return lllIlllllIIlIll.end - lllIlllllIIlIll.start + 1;
        }

        protected InsnListSlice(InsnList lllIllllllIIllI, int lllIllllllIIIIl, int lllIllllllIIIII) {
            super(lllIllllllIIllI);
            InsnListSlice lllIllllllIIlll;
            lllIllllllIIlll.start = lllIllllllIIIIl;
            lllIllllllIIlll.end = lllIllllllIIIII;
        }

        @Override
        public int indexOf(AbstractInsnNode lllIllllIlIlIll) {
            InsnListSlice lllIllllIlIlIIl;
            int lllIllllIlIlIlI = super.indexOf(lllIllllIlIlIll);
            return lllIllllIlIlIlI >= lllIllllIlIlIIl.start && lllIllllIlIlIlI <= lllIllllIlIlIIl.end ? lllIllllIlIlIlI - lllIllllIlIlIIl.start : -1;
        }

        @Override
        public AbstractInsnNode getLast() {
            InsnListSlice lllIlllllIIIllI;
            return super.get(lllIlllllIIIllI.end);
        }

        @Override
        public boolean contains(AbstractInsnNode lllIllllIllIllI) {
            InsnListSlice lllIllllIllIlIl;
            for (AbstractInsnNode lllIllllIlllIII : lllIllllIllIlIl.toArray()) {
                if (lllIllllIlllIII != lllIllllIllIllI) continue;
                return true;
            }
            return false;
        }

        @Override
        public AbstractInsnNode[] toArray() {
            InsnListSlice lllIlllllIlIIII;
            AbstractInsnNode[] lllIlllllIlIIlI = super.toArray();
            AbstractInsnNode[] lllIlllllIlIIIl = new AbstractInsnNode[lllIlllllIlIIII.size()];
            System.arraycopy(lllIlllllIlIIlI, lllIlllllIlIIII.start, lllIlllllIlIIIl, 0, lllIlllllIlIIIl.length);
            return lllIlllllIlIIIl;
        }

        @Override
        public AbstractInsnNode get(int lllIllllIllllll) {
            InsnListSlice lllIlllllIIIIII;
            return super.get(lllIlllllIIIIII.start + lllIllllIllllll);
        }

        @Override
        public AbstractInsnNode getFirst() {
            InsnListSlice lllIlllllIIlIII;
            return super.get(lllIlllllIIlIII.start);
        }

        static class SliceIterator
        implements ListIterator<AbstractInsnNode> {
            private /* synthetic */ int end;
            private /* synthetic */ int index;
            private final /* synthetic */ ListIterator<AbstractInsnNode> iter;
            private /* synthetic */ int start;

            @Override
            public int nextIndex() {
                SliceIterator lIIlIIIIlIlIlIl;
                return lIIlIIIIlIlIlIl.index - lIIlIIIIlIlIlIl.start;
            }

            @Override
            public void add(AbstractInsnNode lIIlIIIIlIIllIl) {
                throw new UnsupportedOperationException("Cannot add insn using slice");
            }

            @Override
            public AbstractInsnNode next() {
                SliceIterator lIIlIIIIlIlllll;
                if (lIIlIIIIlIlllll.index > lIIlIIIIlIlllll.end) {
                    throw new NoSuchElementException();
                }
                ++lIIlIIIIlIlllll.index;
                return lIIlIIIIlIlllll.iter.next();
            }

            @Override
            public int previousIndex() {
                SliceIterator lIIlIIIIlIlIIll;
                return lIIlIIIIlIlIIll.index - lIIlIIIIlIlIIll.start - 1;
            }

            @Override
            public boolean hasPrevious() {
                SliceIterator lIIlIIIIlIlllII;
                return lIIlIIIIlIlllII.index > lIIlIIIIlIlllII.start;
            }

            @Override
            public AbstractInsnNode previous() {
                SliceIterator lIIlIIIIlIllIII;
                if (lIIlIIIIlIllIII.index <= lIIlIIIIlIllIII.start) {
                    throw new NoSuchElementException();
                }
                --lIIlIIIIlIllIII.index;
                return lIIlIIIIlIllIII.iter.previous();
            }

            public SliceIterator(ListIterator<AbstractInsnNode> lIIlIIIIllIllII, int lIIlIIIIllIIllI, int lIIlIIIIllIIlIl, int lIIlIIIIllIlIIl) {
                SliceIterator lIIlIIIIllIllIl;
                lIIlIIIIllIllIl.iter = lIIlIIIIllIllII;
                lIIlIIIIllIllIl.start = lIIlIIIIllIIllI;
                lIIlIIIIllIllIl.end = lIIlIIIIllIIlIl;
                lIIlIIIIllIllIl.index = lIIlIIIIllIlIIl;
            }

            @Override
            public boolean hasNext() {
                SliceIterator lIIlIIIIllIIIIl;
                return lIIlIIIIllIIIIl.index <= lIIlIIIIllIIIIl.end && lIIlIIIIllIIIIl.iter.hasNext();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove insn from slice");
            }

            @Override
            public void set(AbstractInsnNode lIIlIIIIlIIllll) {
                throw new UnsupportedOperationException("Cannot set insn using slice");
            }
        }
    }
}

