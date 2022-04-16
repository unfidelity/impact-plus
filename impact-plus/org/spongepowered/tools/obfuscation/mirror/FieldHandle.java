/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 */
package org.spongepowered.tools.obfuscation.mirror;

import com.google.common.base.Strings;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.tools.obfuscation.mirror.MemberHandle;
import org.spongepowered.tools.obfuscation.mirror.TypeUtils;
import org.spongepowered.tools.obfuscation.mirror.Visibility;

public class FieldHandle
extends MemberHandle<MappingField> {
    private final /* synthetic */ boolean rawType;
    private final /* synthetic */ VariableElement element;

    public FieldHandle(TypeElement lIllIIIIIlIIIII, VariableElement lIllIIIIIIllllI) {
        lIllIIIIIlIIIlI(TypeUtils.getInternalName(lIllIIIIIlIIIII), lIllIIIIIIllllI);
        FieldHandle lIllIIIIIlIIIlI;
    }

    public VariableElement getElement() {
        FieldHandle lIlIllllIlIIIII;
        return lIlIllllIlIIIII.element;
    }

    public String toString() {
        FieldHandle lIlIllllIIIIlll;
        String lIlIllllIIIlIlI = lIlIllllIIIIlll.getOwner() != null ? String.valueOf(new StringBuilder().append("L").append(lIlIllllIIIIlll.getOwner()).append(";")) : "";
        String lIlIllllIIIlIIl = Strings.nullToEmpty((String)lIlIllllIIIIlll.getName());
        String lIlIllllIIIlIII = Strings.nullToEmpty((String)lIlIllllIIIIlll.getDesc());
        return String.format("%s%s:%s", lIlIllllIIIlIlI, lIlIllllIIIlIIl, lIlIllllIIIlIII);
    }

    public FieldHandle(String lIlIlllllIlIIlI, String lIlIlllllIIllIl, String lIlIlllllIIllII) {
        lIlIlllllIIllll(lIlIlllllIlIIlI, null, false, lIlIlllllIIllIl, lIlIlllllIIllII);
        FieldHandle lIlIlllllIIllll;
    }

    private FieldHandle(String lIlIllllIllIllI, VariableElement lIlIllllIlllIll, boolean lIlIllllIllIlII, String lIlIllllIlllIIl, String lIlIllllIlllIII) {
        super(lIlIllllIllIllI, lIlIllllIlllIIl, lIlIllllIlllIII);
        FieldHandle lIlIllllIlllllI;
        lIlIllllIlllllI.element = lIlIllllIlllIll;
        lIlIllllIlllllI.rawType = lIlIllllIllIlII;
    }

    @Override
    public Visibility getVisibility() {
        FieldHandle lIlIllllIIlllII;
        return TypeUtils.getVisibility(lIlIllllIIlllII.element);
    }

    public FieldHandle(String lIlIllllllIIIlI, VariableElement lIlIlllllIllIIl, boolean lIlIlllllIllllI) {
        lIlIllllllIIIll(lIlIllllllIIIlI, lIlIlllllIllIIl, lIlIlllllIllllI, TypeUtils.getName(lIlIlllllIllIIl), TypeUtils.getInternalName(lIlIlllllIllIIl));
        FieldHandle lIlIllllllIIIll;
    }

    public FieldHandle(String lIllIIIIIIIlIIl, VariableElement lIllIIIIIIIlIll) {
        lIllIIIIIIIllIl(lIllIIIIIIIlIIl, lIllIIIIIIIlIll, false);
        FieldHandle lIllIIIIIIIllIl;
    }

    public FieldHandle(TypeElement lIlIllllllllIlI, VariableElement lIlIlllllllllll, boolean lIlIllllllllllI) {
        lIlIlllllllllII(TypeUtils.getInternalName(lIlIllllllllIlI), lIlIlllllllllll, lIlIllllllllllI);
        FieldHandle lIlIlllllllllII;
    }

    public boolean isRawType() {
        FieldHandle lIlIllllIIlIlll;
        return lIlIllllIIlIlll.rawType;
    }

    public boolean isImaginary() {
        FieldHandle lIlIllllIlIIlll;
        return lIlIllllIlIIlll.element == null;
    }

    @Override
    public MappingField asMapping(boolean lIlIllllIIlIIII) {
        FieldHandle lIlIllllIIlIIIl;
        return new MappingField(lIlIllllIIlIIII ? lIlIllllIIlIIIl.getOwner() : null, lIlIllllIIlIIIl.getName(), lIlIllllIIlIIIl.getDesc());
    }
}

