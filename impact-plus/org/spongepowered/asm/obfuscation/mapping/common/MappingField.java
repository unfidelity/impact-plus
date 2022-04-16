/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Objects
 *  com.google.common.base.Strings
 */
package org.spongepowered.asm.obfuscation.mapping.common;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import org.spongepowered.asm.obfuscation.mapping.IMapping;

public class MappingField
implements IMapping<MappingField> {
    private final /* synthetic */ String desc;
    private final /* synthetic */ String name;
    private final /* synthetic */ String owner;

    public String toString() {
        MappingField lllIllllIllIlI;
        return String.format("L%s;%s:%s", lllIllllIllIlI.getOwner(), lllIllllIllIlI.getName(), Strings.nullToEmpty((String)lllIllllIllIlI.getDesc()));
    }

    @Override
    public MappingField move(String lllIlllllllIIl) {
        MappingField lllIlllllllIII;
        return new MappingField(lllIlllllllIIl, lllIlllllllIII.getName(), lllIlllllllIII.getDesc());
    }

    @Override
    public IMapping.Type getType() {
        return IMapping.Type.FIELD;
    }

    @Override
    public String serialise() {
        MappingField lllIllllIlllIl;
        return lllIllllIlllIl.toString();
    }

    @Override
    public MappingField getSuper() {
        return null;
    }

    public boolean equals(Object lllIlllllIIIIl) {
        MappingField lllIlllllIIIlI;
        if (lllIlllllIIIlI == lllIlllllIIIIl) {
            return true;
        }
        if (lllIlllllIIIIl instanceof MappingField) {
            return Objects.equal((Object)lllIlllllIIIlI.toString(), (Object)((MappingField)lllIlllllIIIIl).toString());
        }
        return false;
    }

    public MappingField(String llllIIIIIllllI, String llllIIIIIlllIl) {
        llllIIIIIlllII(llllIIIIIllllI, llllIIIIIlllIl, null);
        MappingField llllIIIIIlllII;
    }

    @Override
    public MappingField copy() {
        MappingField lllIlllllIlIIl;
        return new MappingField(lllIlllllIlIIl.getOwner(), lllIlllllIlIIl.getName(), lllIlllllIlIIl.getDesc());
    }

    @Override
    public final String getSimpleName() {
        MappingField llllIIIIIIIlIl;
        return llllIIIIIIIlIl.name;
    }

    @Override
    public MappingField transform(String lllIlllllIlIll) {
        MappingField lllIlllllIllII;
        return new MappingField(lllIlllllIllII.getOwner(), lllIlllllIllII.getName(), lllIlllllIlIll);
    }

    @Override
    public final String getOwner() {
        MappingField llllIIIIIIIIIl;
        return llllIIIIIIIIIl.owner;
    }

    @Override
    public String getName() {
        MappingField llllIIIIIIIlll;
        return llllIIIIIIIlll.name;
    }

    @Override
    public final String getDesc() {
        MappingField lllIlllllllllI;
        return lllIlllllllllI.desc;
    }

    public int hashCode() {
        MappingField lllIlllllIIllI;
        return Objects.hashCode((Object[])new Object[]{lllIlllllIIllI.toString()});
    }

    public MappingField(String llllIIIIIlIlII, String llllIIIIIIllll, String llllIIIIIlIIlI) {
        MappingField llllIIIIIlIIIl;
        llllIIIIIlIIIl.owner = llllIIIIIlIlII;
        llllIIIIIlIIIl.name = llllIIIIIIllll;
        llllIIIIIlIIIl.desc = llllIIIIIlIIlI;
    }

    @Override
    public MappingField remap(String lllIllllllIIIl) {
        MappingField lllIllllllIIlI;
        return new MappingField(lllIllllllIIlI.getOwner(), lllIllllllIIIl, lllIllllllIIlI.getDesc());
    }
}

