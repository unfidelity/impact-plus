/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 */
package org.spongepowered.asm.mixin.injection.points;

import com.google.common.base.Strings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.TypeInsnNode;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;

@InjectionPoint.AtCode(value="NEW")
public class BeforeNew
extends InjectionPoint {
    private final /* synthetic */ int ordinal;
    private final /* synthetic */ String target;
    private final /* synthetic */ String desc;

    private boolean matchesOwner(TypeInsnNode llllllllllllllllllllIIlIlllIIllI) {
        BeforeNew llllllllllllllllllllIIlIlllIIlll;
        return llllllllllllllllllllIIlIlllIIlll.target == null || llllllllllllllllllllIIlIlllIIlll.target.equals(llllllllllllllllllllIIlIlllIIllI.desc);
    }

    public BeforeNew(InjectionPointData llllllllllllllllllllIIllllllIlIl) {
        super(llllllllllllllllllllIIllllllIlIl);
        BeforeNew llllllllllllllllllllIlIIIIIIIIlI;
        llllllllllllllllllllIlIIIIIIIIlI.ordinal = llllllllllllllllllllIIllllllIlIl.getOrdinal();
        String llllllllllllllllllllIIllllllllIl = Strings.emptyToNull((String)llllllllllllllllllllIIllllllIlIl.get("class", llllllllllllllllllllIIllllllIlIl.get("target", "")).replace('.', '/'));
        MemberInfo llllllllllllllllllllIIlllllllIll = MemberInfo.parseAndValidate(llllllllllllllllllllIIllllllllIl, llllllllllllllllllllIIllllllIlIl.getContext());
        llllllllllllllllllllIlIIIIIIIIlI.target = llllllllllllllllllllIIlllllllIll.toCtorType();
        llllllllllllllllllllIlIIIIIIIIlI.desc = llllllllllllllllllllIIlllllllIll.toCtorDesc();
    }

    public boolean hasDescriptor() {
        BeforeNew llllllllllllllllllllIIllllIlIlll;
        return llllllllllllllllllllIIllllIlIlll.desc != null;
    }

    @Override
    public boolean find(String llllllllllllllllllllIIllIlllllIl, InsnList llllllllllllllllllllIIllIllIIIll, Collection<AbstractInsnNode> llllllllllllllllllllIIllIlIlllll) {
        BeforeNew llllllllllllllllllllIIllIllllllI;
        boolean llllllllllllllllllllIIllIlllIlIl = false;
        int llllllllllllllllllllIIllIlllIIIl = 0;
        ArrayList llllllllllllllllllllIIllIllIlllI = new ArrayList();
        Collection<Object> llllllllllllllllllllIIllIllIllII = llllllllllllllllllllIIllIllllllI.desc != null ? llllllllllllllllllllIIllIllIlllI : llllllllllllllllllllIIllIlIlllll;
        ListIterator<AbstractInsnNode> llllllllllllllllllllIIllIllIlIlI = llllllllllllllllllllIIllIllIIIll.iterator();
        while (llllllllllllllllllllIIllIllIlIlI.hasNext()) {
            AbstractInsnNode llllllllllllllllllllIIlllIIIIIII = llllllllllllllllllllIIllIllIlIlI.next();
            if (!(llllllllllllllllllllIIlllIIIIIII instanceof TypeInsnNode) || llllllllllllllllllllIIlllIIIIIII.getOpcode() != 187 || !llllllllllllllllllllIIllIllllllI.matchesOwner((TypeInsnNode)llllllllllllllllllllIIlllIIIIIII)) continue;
            if (llllllllllllllllllllIIllIllllllI.ordinal == -1 || llllllllllllllllllllIIllIllllllI.ordinal == llllllllllllllllllllIIllIlllIIIl) {
                llllllllllllllllllllIIllIllIllII.add(llllllllllllllllllllIIlllIIIIIII);
                llllllllllllllllllllIIllIlllIlIl = llllllllllllllllllllIIllIllllllI.desc == null;
            }
            ++llllllllllllllllllllIIllIlllIIIl;
        }
        if (llllllllllllllllllllIIllIllllllI.desc != null) {
            for (TypeInsnNode llllllllllllllllllllIIllIlllllll : llllllllllllllllllllIIllIllIlllI) {
                if (!llllllllllllllllllllIIllIllllllI.findCtor(llllllllllllllllllllIIllIllIIIll, llllllllllllllllllllIIllIlllllll)) continue;
                llllllllllllllllllllIIllIlIlllll.add(llllllllllllllllllllIIllIlllllll);
                llllllllllllllllllllIIllIlllIlIl = true;
            }
        }
        return llllllllllllllllllllIIllIlllIlIl;
    }

    protected boolean findCtor(InsnList llllllllllllllllllllIIlIlllllIII, TypeInsnNode llllllllllllllllllllIIlIlllllIll) {
        int llllllllllllllllllllIIlIlllllIlI = llllllllllllllllllllIIlIlllllIII.indexOf(llllllllllllllllllllIIlIlllllIll);
        ListIterator<AbstractInsnNode> llllllllllllllllllllIIlIlllllllI = llllllllllllllllllllIIlIlllllIII.iterator(llllllllllllllllllllIIlIlllllIlI);
        while (llllllllllllllllllllIIlIlllllllI.hasNext()) {
            BeforeNew llllllllllllllllllllIIlIllllllIl;
            AbstractInsnNode llllllllllllllllllllIIllIIIIIIII = (AbstractInsnNode)llllllllllllllllllllIIlIlllllllI.next();
            if (!(llllllllllllllllllllIIllIIIIIIII instanceof MethodInsnNode) || llllllllllllllllllllIIllIIIIIIII.getOpcode() != 183) continue;
            MethodInsnNode llllllllllllllllllllIIllIIIIIIlI = (MethodInsnNode)llllllllllllllllllllIIllIIIIIIII;
            if (!"<init>".equals(llllllllllllllllllllIIllIIIIIIlI.name) || !llllllllllllllllllllIIllIIIIIIlI.owner.equals(llllllllllllllllllllIIlIlllllIll.desc) || !llllllllllllllllllllIIllIIIIIIlI.desc.equals(llllllllllllllllllllIIlIllllllIl.desc)) continue;
            return true;
        }
        return false;
    }
}

