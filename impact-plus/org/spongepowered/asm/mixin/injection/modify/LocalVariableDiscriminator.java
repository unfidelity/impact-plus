/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.mixin.injection.modify;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.LocalVariableNode;
import org.spongepowered.asm.mixin.injection.modify.InvalidImplicitDiscriminatorException;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.Locals;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.SignaturePrinter;

public class LocalVariableDiscriminator {
    private final /* synthetic */ int ordinal;
    private final /* synthetic */ int index;
    private final /* synthetic */ boolean print;
    private final /* synthetic */ Set<String> names;
    private final /* synthetic */ boolean argsOnly;

    private int findImplicitLocal(Context lllllllllllllllIllllllIIllllIlll) {
        int lllllllllllllllIllllllIIllllIlIl = 0;
        int lllllllllllllllIllllllIIllllIlII = 0;
        for (int lllllllllllllllIllllllIIlllllIlI = lllllllllllllllIllllllIIllllIlll.baseArgIndex; lllllllllllllllIllllllIIlllllIlI < lllllllllllllllIllllllIIllllIlll.locals.length; ++lllllllllllllllIllllllIIlllllIlI) {
            Context.Local lllllllllllllllIllllllIIllllllII = lllllllllllllllIllllllIIllllIlll.locals[lllllllllllllllIllllllIIlllllIlI];
            if (lllllllllllllllIllllllIIllllllII == null || !lllllllllllllllIllllllIIllllllII.type.equals(lllllllllllllllIllllllIIllllIlll.returnType)) continue;
            ++lllllllllllllllIllllllIIllllIlII;
            lllllllllllllllIllllllIIllllIlIl = lllllllllllllllIllllllIIlllllIlI;
        }
        if (lllllllllllllllIllllllIIllllIlII == 1) {
            return lllllllllllllllIllllllIIllllIlIl;
        }
        throw new InvalidImplicitDiscriminatorException(String.valueOf(new StringBuilder().append("Found ").append(lllllllllllllllIllllllIIllllIlII).append(" candidate variables but exactly 1 is required.")));
    }

    protected boolean isImplicit(Context lllllllllllllllIllllllIlIIlIIIIl) {
        LocalVariableDiscriminator lllllllllllllllIllllllIlIIlIIIll;
        return lllllllllllllllIllllllIlIIlIIIll.ordinal < 0 && lllllllllllllllIllllllIlIIlIIIll.index < lllllllllllllllIllllllIlIIlIIIIl.baseArgIndex && lllllllllllllllIllllllIlIIlIIIll.names.isEmpty();
    }

    public int findLocal(Type lllllllllllllllIllllllIlIIIIlllI, boolean lllllllllllllllIllllllIlIIIlIIlI, Target lllllllllllllllIllllllIlIIIIllII, AbstractInsnNode lllllllllllllllIllllllIlIIIlIIII) {
        try {
            LocalVariableDiscriminator lllllllllllllllIllllllIlIIIlIlII;
            return lllllllllllllllIllllllIlIIIlIlII.findLocal(new Context(lllllllllllllllIllllllIlIIIIlllI, lllllllllllllllIllllllIlIIIlIIlI, lllllllllllllllIllllllIlIIIIllII, lllllllllllllllIllllllIlIIIlIIII));
        }
        catch (InvalidImplicitDiscriminatorException lllllllllllllllIllllllIlIIIlIlIl) {
            return -2;
        }
    }

    public static LocalVariableDiscriminator parse(AnnotationNode lllllllllllllllIllllllIIlIllIlIl) {
        boolean lllllllllllllllIllllllIIlIlllllI = Annotations.getValue(lllllllllllllllIllllllIIlIllIlIl, "argsOnly", Boolean.FALSE);
        int lllllllllllllllIllllllIIlIllllII = Annotations.getValue(lllllllllllllllIllllllIIlIllIlIl, "ordinal", -1);
        int lllllllllllllllIllllllIIlIlllIll = Annotations.getValue(lllllllllllllllIllllllIIlIllIlIl, "index", -1);
        boolean lllllllllllllllIllllllIIlIlllIIl = Annotations.getValue(lllllllllllllllIllllllIIlIllIlIl, "print", Boolean.FALSE);
        HashSet<String> lllllllllllllllIllllllIIlIlllIII = new HashSet<String>();
        List lllllllllllllllIllllllIIlIllIllI = Annotations.getValue(lllllllllllllllIllllllIIlIllIlIl, "name", (List)null);
        if (lllllllllllllllIllllllIIlIllIllI != null) {
            lllllllllllllllIllllllIIlIlllIII.addAll(lllllllllllllllIllllllIIlIllIllI);
        }
        return new LocalVariableDiscriminator(lllllllllllllllIllllllIIlIlllllI, lllllllllllllllIllllllIIlIllllII, lllllllllllllllIllllllIIlIlllIll, lllllllllllllllIllllllIIlIlllIII, lllllllllllllllIllllllIIlIlllIIl);
    }

    public int findLocal(Context lllllllllllllllIllllllIlIIIIIlII) {
        LocalVariableDiscriminator lllllllllllllllIllllllIlIIIIIlll;
        if (lllllllllllllllIllllllIlIIIIIlll.isImplicit(lllllllllllllllIllllllIlIIIIIlII)) {
            return lllllllllllllllIllllllIlIIIIIlll.findImplicitLocal(lllllllllllllllIllllllIlIIIIIlII);
        }
        return lllllllllllllllIllllllIlIIIIIlll.findExplicitLocal(lllllllllllllllIllllllIlIIIIIlII);
    }

    public Set<String> getNames() {
        LocalVariableDiscriminator lllllllllllllllIllllllIlIIllllll;
        return lllllllllllllllIllllllIlIIllllll.names;
    }

    private int findExplicitLocal(Context lllllllllllllllIllllllIIllIlIlII) {
        for (int lllllllllllllllIllllllIIllIlIlll = lllllllllllllllIllllllIIllIlIlII.baseArgIndex; lllllllllllllllIllllllIIllIlIlll < lllllllllllllllIllllllIIllIlIlII.locals.length; ++lllllllllllllllIllllllIIllIlIlll) {
            LocalVariableDiscriminator lllllllllllllllIllllllIIllIlIlIl;
            Context.Local lllllllllllllllIllllllIIllIllIIl = lllllllllllllllIllllllIIllIlIlII.locals[lllllllllllllllIllllllIIllIlIlll];
            if (lllllllllllllllIllllllIIllIllIIl == null || !lllllllllllllllIllllllIIllIllIIl.type.equals(lllllllllllllllIllllllIIllIlIlII.returnType) || !(lllllllllllllllIllllllIIllIlIlIl.ordinal > -1 ? lllllllllllllllIllllllIIllIlIlIl.ordinal == lllllllllllllllIllllllIIllIllIIl.ord : (lllllllllllllllIllllllIIllIlIlIl.index >= lllllllllllllllIllllllIIllIlIlII.baseArgIndex ? lllllllllllllllIllllllIIllIlIlIl.index == lllllllllllllllIllllllIIllIlIlll : lllllllllllllllIllllllIIllIlIlIl.names.contains(lllllllllllllllIllllllIIllIllIIl.name)))) continue;
            return lllllllllllllllIllllllIIllIlIlll;
        }
        return -1;
    }

    public boolean hasNames() {
        LocalVariableDiscriminator lllllllllllllllIllllllIlIIllIlll;
        return !lllllllllllllllIllllllIlIIllIlll.names.isEmpty();
    }

    public boolean printLVT() {
        LocalVariableDiscriminator lllllllllllllllIllllllIlIIllIIIl;
        return lllllllllllllllIllllllIlIIllIIIl.print;
    }

    public LocalVariableDiscriminator(boolean lllllllllllllllIllllllIlIlIlIIll, int lllllllllllllllIllllllIlIlIlIIlI, int lllllllllllllllIllllllIlIlIlIIIl, Set<String> lllllllllllllllIllllllIlIlIlIIII, boolean lllllllllllllllIllllllIlIlIlIlIl) {
        LocalVariableDiscriminator lllllllllllllllIllllllIlIlIlIlII;
        lllllllllllllllIllllllIlIlIlIlII.argsOnly = lllllllllllllllIllllllIlIlIlIIll;
        lllllllllllllllIllllllIlIlIlIlII.ordinal = lllllllllllllllIllllllIlIlIlIIlI;
        lllllllllllllllIllllllIlIlIlIlII.index = lllllllllllllllIllllllIlIlIlIIIl;
        lllllllllllllllIllllllIlIlIlIlII.names = Collections.unmodifiableSet(lllllllllllllllIllllllIlIlIlIIII);
        lllllllllllllllIllllllIlIlIlIlII.print = lllllllllllllllIllllllIlIlIlIlIl;
    }

    public boolean isArgsOnly() {
        LocalVariableDiscriminator lllllllllllllllIllllllIlIlIIllIl;
        return lllllllllllllllIllllllIlIlIIllIl.argsOnly;
    }

    public int getOrdinal() {
        LocalVariableDiscriminator lllllllllllllllIllllllIlIlIIlIlI;
        return lllllllllllllllIllllllIlIlIIlIlI.ordinal;
    }

    public int getIndex() {
        LocalVariableDiscriminator lllllllllllllllIllllllIlIlIIIIll;
        return lllllllllllllllIllllllIlIlIIIIll.index;
    }

    public static class Context
    implements PrettyPrinter.IPrettyPrintable {
        private final /* synthetic */ boolean isStatic;
        final /* synthetic */ Target target;
        final /* synthetic */ Local[] locals;
        final /* synthetic */ Type returnType;
        final /* synthetic */ AbstractInsnNode node;
        final /* synthetic */ int baseArgIndex;

        public Context(Type lllllllllllllllllllIllllllIllIll, boolean lllllllllllllllllllIllllllIlllll, Target lllllllllllllllllllIllllllIllIIl, AbstractInsnNode lllllllllllllllllllIllllllIlllIl) {
            Context lllllllllllllllllllIllllllIlllII;
            lllllllllllllllllllIllllllIlllII.isStatic = Bytecode.methodIsStatic(lllllllllllllllllllIllllllIllIIl.method);
            lllllllllllllllllllIllllllIlllII.returnType = lllllllllllllllllllIllllllIllIll;
            lllllllllllllllllllIllllllIlllII.target = lllllllllllllllllllIllllllIllIIl;
            lllllllllllllllllllIllllllIlllII.node = lllllllllllllllllllIllllllIlllIl;
            lllllllllllllllllllIllllllIlllII.baseArgIndex = lllllllllllllllllllIllllllIlllII.isStatic ? 0 : 1;
            lllllllllllllllllllIllllllIlllII.locals = lllllllllllllllllllIllllllIlllII.initLocals(lllllllllllllllllllIllllllIllIIl, lllllllllllllllllllIllllllIlllll, lllllllllllllllllllIllllllIlllIl);
            lllllllllllllllllllIllllllIlllII.initOrdinals();
        }

        private void initOrdinals() {
            Context lllllllllllllllllllIlllllIllIlll;
            HashMap<Type, Integer> lllllllllllllllllllIlllllIlllIII = new HashMap<Type, Integer>();
            for (int lllllllllllllllllllIlllllIlllIlI = 0; lllllllllllllllllllIlllllIlllIlI < lllllllllllllllllllIlllllIllIlll.locals.length; ++lllllllllllllllllllIlllllIlllIlI) {
                Integer lllllllllllllllllllIlllllIlllIll = 0;
                if (lllllllllllllllllllIlllllIllIlll.locals[lllllllllllllllllllIlllllIlllIlI] == null) continue;
                lllllllllllllllllllIlllllIlllIll = (Integer)lllllllllllllllllllIlllllIlllIII.get(lllllllllllllllllllIlllllIllIlll.locals[lllllllllllllllllllIlllllIlllIlI].type);
                lllllllllllllllllllIlllllIlllIll = lllllllllllllllllllIlllllIlllIll == null ? 0 : lllllllllllllllllllIlllllIlllIll + 1;
                lllllllllllllllllllIlllllIlllIII.put(lllllllllllllllllllIlllllIllIlll.locals[lllllllllllllllllllIlllllIlllIlI].type, lllllllllllllllllllIlllllIlllIll);
                lllllllllllllllllllIlllllIllIlll.locals[lllllllllllllllllllIlllllIlllIlI].ord = lllllllllllllllllllIlllllIlllIll;
            }
        }

        private Local[] initLocals(Target lllllllllllllllllllIllllllIIIlIl, boolean lllllllllllllllllllIllllllIIIlII, AbstractInsnNode lllllllllllllllllllIllllllIIIIll) {
            Context lllllllllllllllllllIllllllIIIllI;
            LocalVariableNode[] lllllllllllllllllllIllllllIIlllI;
            if (!lllllllllllllllllllIllllllIIIlII && (lllllllllllllllllllIllllllIIlllI = Locals.getLocalsAt(lllllllllllllllllllIllllllIIIlIl.classNode, lllllllllllllllllllIllllllIIIlIl.method, lllllllllllllllllllIllllllIIIIll)) != null) {
                Local[] lllllllllllllllllllIllllllIIllll = new Local[lllllllllllllllllllIllllllIIlllI.length];
                for (int lllllllllllllllllllIllllllIlIIII = 0; lllllllllllllllllllIllllllIlIIII < lllllllllllllllllllIllllllIIlllI.length; ++lllllllllllllllllllIllllllIlIIII) {
                    if (lllllllllllllllllllIllllllIIlllI[lllllllllllllllllllIllllllIlIIII] == null) continue;
                    lllllllllllllllllllIllllllIIllll[lllllllllllllllllllIllllllIlIIII] = lllllllllllllllllllIllllllIIIllI.new Local(lllllllllllllllllllIllllllIIlllI[lllllllllllllllllllIllllllIlIIII].name, Type.getType(lllllllllllllllllllIllllllIIlllI[lllllllllllllllllllIllllllIlIIII].desc));
                }
                return lllllllllllllllllllIllllllIIllll;
            }
            Local[] lllllllllllllllllllIllllllIIIlll = new Local[lllllllllllllllllllIllllllIIIllI.baseArgIndex + lllllllllllllllllllIllllllIIIlIl.arguments.length];
            if (!lllllllllllllllllllIllllllIIIllI.isStatic) {
                lllllllllllllllllllIllllllIIIlll[0] = lllllllllllllllllllIllllllIIIllI.new Local("this", Type.getType(lllllllllllllllllllIllllllIIIlIl.classNode.name));
            }
            for (int lllllllllllllllllllIllllllIIllII = lllllllllllllllllllIllllllIIIllI.baseArgIndex; lllllllllllllllllllIllllllIIllII < lllllllllllllllllllIllllllIIIlll.length; ++lllllllllllllllllllIllllllIIllII) {
                Type lllllllllllllllllllIllllllIIllIl = lllllllllllllllllllIllllllIIIlIl.arguments[lllllllllllllllllllIllllllIIllII - lllllllllllllllllllIllllllIIIllI.baseArgIndex];
                lllllllllllllllllllIllllllIIIlll[lllllllllllllllllllIllllllIIllII] = lllllllllllllllllllIllllllIIIllI.new Local(String.valueOf(new StringBuilder().append("arg").append(lllllllllllllllllllIllllllIIllII)), lllllllllllllllllllIllllllIIllIl);
            }
            return lllllllllllllllllllIllllllIIIlll;
        }

        @Override
        public void print(PrettyPrinter lllllllllllllllllllIlllllIlIIIlI) {
            Context lllllllllllllllllllIlllllIlIIIIl;
            lllllllllllllllllllIlllllIlIIIlI.add("%5s  %7s  %30s  %-50s  %s", "INDEX", "ORDINAL", "TYPE", "NAME", "CANDIDATE");
            for (int lllllllllllllllllllIlllllIlIIlII = lllllllllllllllllllIlllllIlIIIIl.baseArgIndex; lllllllllllllllllllIlllllIlIIlII < lllllllllllllllllllIlllllIlIIIIl.locals.length; ++lllllllllllllllllllIlllllIlIIlII) {
                Local lllllllllllllllllllIlllllIlIIlIl = lllllllllllllllllllIlllllIlIIIIl.locals[lllllllllllllllllllIlllllIlIIlII];
                if (lllllllllllllllllllIlllllIlIIlIl != null) {
                    Type lllllllllllllllllllIlllllIlIlIll = lllllllllllllllllllIlllllIlIIlIl.type;
                    String lllllllllllllllllllIlllllIlIlIlI = lllllllllllllllllllIlllllIlIIlIl.name;
                    int lllllllllllllllllllIlllllIlIlIIl = lllllllllllllllllllIlllllIlIIlIl.ord;
                    String lllllllllllllllllllIlllllIlIlIII = lllllllllllllllllllIlllllIlIIIIl.returnType.equals(lllllllllllllllllllIlllllIlIlIll) ? "YES" : "-";
                    lllllllllllllllllllIlllllIlIIIlI.add("[%3d]    [%3d]  %30s  %-50s  %s", lllllllllllllllllllIlllllIlIIlII, lllllllllllllllllllIlllllIlIlIIl, SignaturePrinter.getTypeName(lllllllllllllllllllIlllllIlIlIll, false), lllllllllllllllllllIlllllIlIlIlI, lllllllllllllllllllIlllllIlIlIII);
                    continue;
                }
                if (lllllllllllllllllllIlllllIlIIlII <= 0) continue;
                Local lllllllllllllllllllIlllllIlIIlll = lllllllllllllllllllIlllllIlIIIIl.locals[lllllllllllllllllllIlllllIlIIlII - 1];
                boolean lllllllllllllllllllIlllllIlIIllI = lllllllllllllllllllIlllllIlIIlll != null && lllllllllllllllllllIlllllIlIIlll.type != null && lllllllllllllllllllIlllllIlIIlll.type.getSize() > 1;
                lllllllllllllllllllIlllllIlIIIlI.add("[%3d]           %30s", lllllllllllllllllllIlllllIlIIlII, lllllllllllllllllllIlllllIlIIllI ? "<top>" : "-");
            }
        }

        public class Local {
            /* synthetic */ int ord;
            /* synthetic */ String name;
            /* synthetic */ Type type;

            public String toString() {
                Local llIIIlIIlIIlIll;
                return String.format("Local[ordinal=%d, name=%s, type=%s]", llIIIlIIlIIlIll.ord, llIIIlIIlIIlIll.name, llIIIlIIlIIlIll.type);
            }

            public Local(String llIIIlIIlIlIIll, Type llIIIlIIlIlIIlI) {
                Local llIIIlIIlIlIlIl;
                llIIIlIIlIlIlIl.ord = 0;
                llIIIlIIlIlIlIl.name = llIIIlIIlIlIIll;
                llIIIlIIlIlIlIl.type = llIIIlIIlIlIIlI;
            }
        }
    }
}

