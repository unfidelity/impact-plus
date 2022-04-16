/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 */
package org.spongepowered.tools.obfuscation.mirror;

import com.google.common.base.Strings;
import javax.lang.model.element.ExecutableElement;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.mirror.MemberHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;
import org.spongepowered.tools.obfuscation.mirror.Visibility;
import org.spongepowered.tools.obfuscation.mirror.mapping.ResolvableMappingMethod;

public class MethodHandle
extends MemberHandle<MappingMethod> {
    private final /* synthetic */ ExecutableElement element;
    private final /* synthetic */ TypeHandle ownerHandle;

    public String toString() {
        MethodHandle lllIlIllIllII;
        String lllIlIlllIIIl = lllIlIllIllII.getOwner() != null ? String.valueOf(new StringBuilder().append("L").append(lllIlIllIllII.getOwner()).append(";")) : "";
        String lllIlIllIllll = Strings.nullToEmpty((String)lllIlIllIllII.getName());
        String lllIlIllIllIl = Strings.nullToEmpty((String)lllIlIllIllII.getDesc());
        return String.format("%s%s%s", lllIlIlllIIIl, lllIlIllIllll, lllIlIllIllIl);
    }

    private MethodHandle(TypeHandle lllIllIllIIIl, ExecutableElement lllIllIlIlIII, String lllIllIlIlllI, String lllIllIlIIllI) {
        super(lllIllIllIIIl != null ? lllIllIllIIIl.getName() : null, lllIllIlIlllI, lllIllIlIIllI);
        MethodHandle lllIllIllIIlI;
        lllIllIllIIlI.element = lllIllIlIlIII;
        lllIllIllIIlI.ownerHandle = lllIllIllIIIl;
    }

    @Override
    public MappingMethod asMapping(boolean lllIllIIIIlIl) {
        MethodHandle lllIllIIIIllI;
        if (lllIllIIIIlIl) {
            if (lllIllIIIIllI.ownerHandle != null) {
                return new ResolvableMappingMethod(lllIllIIIIllI.ownerHandle, lllIllIIIIllI.getName(), lllIllIIIIllI.getDesc());
            }
            return new MappingMethod(lllIllIIIIllI.getOwner(), lllIllIIIIllI.getName(), lllIllIIIIllI.getDesc());
        }
        return new MappingMethod(null, lllIllIIIIllI.getName(), lllIllIIIIllI.getDesc());
    }

    @Override
    public Visibility getVisibility() {
        MethodHandle lllIllIIlIIIl;
        return TypeUtils.getVisibility(lllIllIIlIIIl.element);
    }

    public ExecutableElement getElement() {
        MethodHandle lllIllIIlIlll;
        return lllIllIIlIlll.element;
    }

    public MethodHandle(TypeHandle lllIlllIIlIII, ExecutableElement lllIlllIIIlll) {
        lllIlllIIIllI(lllIlllIIlIII, lllIlllIIIlll, TypeUtils.getName(lllIlllIIIlll), TypeUtils.getDescriptor(lllIlllIIIlll));
        MethodHandle lllIlllIIIllI;
    }

    public boolean isImaginary() {
        MethodHandle lllIllIIlllIl;
        return lllIllIIlllIl.element == null;
    }

    public MethodHandle(TypeHandle lllIllIlllllI, String lllIllIlllIIl, String lllIllIllllII) {
        lllIllIlllIll(lllIllIlllllI, null, lllIllIlllIIl, lllIllIllllII);
        MethodHandle lllIllIlllIll;
    }
}

