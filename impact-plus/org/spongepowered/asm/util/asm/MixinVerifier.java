/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.asm.util.asm;

import java.util.List;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.analysis.SimpleVerifier;
import org.spongepowered.asm.mixin.transformer.ClassInfo;

public class MixinVerifier
extends SimpleVerifier {
    private /* synthetic */ Type currentClass;
    private /* synthetic */ Type currentSuperClass;
    private /* synthetic */ List<Type> currentClassInterfaces;
    private /* synthetic */ boolean isInterface;

    @Override
    protected Type getSuperClass(Type lllllllllllllllllllIIIlIIllIIIll) {
        MixinVerifier lllllllllllllllllllIIIlIIllIIlII;
        if (lllllllllllllllllllIIIlIIllIIlII.currentClass != null && lllllllllllllllllllIIIlIIllIIIll.equals(lllllllllllllllllllIIIlIIllIIlII.currentClass)) {
            return lllllllllllllllllllIIIlIIllIIlII.currentSuperClass;
        }
        ClassInfo lllllllllllllllllllIIIlIIllIIlIl = ClassInfo.forType(lllllllllllllllllllIIIlIIllIIIll).getSuperClass();
        return lllllllllllllllllllIIIlIIllIIlIl == null ? null : Type.getType(String.valueOf(new StringBuilder().append("L").append(lllllllllllllllllllIIIlIIllIIlIl.getName()).append(";")));
    }

    @Override
    protected boolean isAssignableFrom(Type lllllllllllllllllllIIIlIIlIlIlIl, Type lllllllllllllllllllIIIlIIlIlIlII) {
        MixinVerifier lllllllllllllllllllIIIlIIlIllIlI;
        if (lllllllllllllllllllIIIlIIlIlIlIl.equals(lllllllllllllllllllIIIlIIlIlIlII)) {
            return true;
        }
        if (lllllllllllllllllllIIIlIIlIllIlI.currentClass != null && lllllllllllllllllllIIIlIIlIlIlIl.equals(lllllllllllllllllllIIIlIIlIllIlI.currentClass)) {
            if (lllllllllllllllllllIIIlIIlIllIlI.getSuperClass(lllllllllllllllllllIIIlIIlIlIlII) == null) {
                return false;
            }
            if (lllllllllllllllllllIIIlIIlIllIlI.isInterface) {
                return lllllllllllllllllllIIIlIIlIlIlII.getSort() == 10 || lllllllllllllllllllIIIlIIlIlIlII.getSort() == 9;
            }
            return lllllllllllllllllllIIIlIIlIllIlI.isAssignableFrom(lllllllllllllllllllIIIlIIlIlIlIl, lllllllllllllllllllIIIlIIlIllIlI.getSuperClass(lllllllllllllllllllIIIlIIlIlIlII));
        }
        if (lllllllllllllllllllIIIlIIlIllIlI.currentClass != null && lllllllllllllllllllIIIlIIlIlIlII.equals(lllllllllllllllllllIIIlIIlIllIlI.currentClass)) {
            if (lllllllllllllllllllIIIlIIlIllIlI.isAssignableFrom(lllllllllllllllllllIIIlIIlIlIlIl, lllllllllllllllllllIIIlIIlIllIlI.currentSuperClass)) {
                return true;
            }
            if (lllllllllllllllllllIIIlIIlIllIlI.currentClassInterfaces != null) {
                for (int lllllllllllllllllllIIIlIIlIllIll = 0; lllllllllllllllllllIIIlIIlIllIll < lllllllllllllllllllIIIlIIlIllIlI.currentClassInterfaces.size(); ++lllllllllllllllllllIIIlIIlIllIll) {
                    Type lllllllllllllllllllIIIlIIlIlllII = lllllllllllllllllllIIIlIIlIllIlI.currentClassInterfaces.get(lllllllllllllllllllIIIlIIlIllIll);
                    if (!lllllllllllllllllllIIIlIIlIllIlI.isAssignableFrom(lllllllllllllllllllIIIlIIlIlIlIl, lllllllllllllllllllIIIlIIlIlllII)) continue;
                    return true;
                }
            }
            return false;
        }
        ClassInfo lllllllllllllllllllIIIlIIlIlIlll = ClassInfo.forType(lllllllllllllllllllIIIlIIlIlIlIl);
        if (lllllllllllllllllllIIIlIIlIlIlll == null) {
            return false;
        }
        if (lllllllllllllllllllIIIlIIlIlIlll.isInterface()) {
            lllllllllllllllllllIIIlIIlIlIlll = ClassInfo.forName("java/lang/Object");
        }
        return ClassInfo.forType(lllllllllllllllllllIIIlIIlIlIlII).hasSuperClass(lllllllllllllllllllIIIlIIlIlIlll);
    }

    @Override
    protected boolean isInterface(Type lllllllllllllllllllIIIlIIllIllIl) {
        MixinVerifier lllllllllllllllllllIIIlIIllIlllI;
        if (lllllllllllllllllllIIIlIIllIlllI.currentClass != null && lllllllllllllllllllIIIlIIllIllIl.equals(lllllllllllllllllllIIIlIIllIlllI.currentClass)) {
            return lllllllllllllllllllIIIlIIllIlllI.isInterface;
        }
        return ClassInfo.forType(lllllllllllllllllllIIIlIIllIllIl).isInterface();
    }

    public MixinVerifier(Type lllllllllllllllllllIIIlIIlllllII, Type lllllllllllllllllllIIIlIIllllIlI, List<Type> lllllllllllllllllllIIIlIIllllIII, boolean lllllllllllllllllllIIIlIlIIIIIlI) {
        super(lllllllllllllllllllIIIlIIlllllII, lllllllllllllllllllIIIlIIllllIlI, lllllllllllllllllllIIIlIIllllIII, lllllllllllllllllllIIIlIlIIIIIlI);
        MixinVerifier lllllllllllllllllllIIIlIlIIIlIll;
        lllllllllllllllllllIIIlIlIIIlIll.currentClass = lllllllllllllllllllIIIlIIlllllII;
        lllllllllllllllllllIIIlIlIIIlIll.currentSuperClass = lllllllllllllllllllIIIlIIllllIlI;
        lllllllllllllllllllIIIlIlIIIlIll.currentClassInterfaces = lllllllllllllllllllIIIlIIllllIII;
        lllllllllllllllllllIIIlIlIIIlIll.isInterface = lllllllllllllllllllIIIlIlIIIIIlI;
    }
}

