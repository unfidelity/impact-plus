/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation.mirror;

import java.io.Serializable;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import org.spongepowered.tools.obfuscation.mirror.TypeHandle;

public class TypeReference
implements Serializable,
Comparable<TypeReference> {
    private static final /* synthetic */ long serialVersionUID = 1L;
    private final /* synthetic */ String name;
    private transient /* synthetic */ TypeHandle handle;

    public boolean equals(Object lllllllllllllllIlllIIlllllIIIIlI) {
        TypeReference lllllllllllllllIlllIIlllllIIIlII;
        return lllllllllllllllIlllIIlllllIIIIlI instanceof TypeReference && lllllllllllllllIlllIIlllllIIIlII.compareTo((TypeReference)lllllllllllllllIlllIIlllllIIIIlI) == 0;
    }

    public TypeReference(String lllllllllllllllIlllIIlllllllIIlI) {
        TypeReference lllllllllllllllIlllIIlllllllIlIl;
        lllllllllllllllIlllIIlllllllIlIl.name = lllllllllllllllIlllIIlllllllIIlI;
    }

    public String toString() {
        TypeReference lllllllllllllllIlllIIlllllIllIIl;
        return String.format("TypeReference[%s]", lllllllllllllllIlllIIlllllIllIIl.name);
    }

    public TypeReference(TypeHandle lllllllllllllllIlllIIllllllllIII) {
        TypeReference lllllllllllllllIlllIIllllllllIIl;
        lllllllllllllllIlllIIllllllllIIl.name = lllllllllllllllIlllIIllllllllIII.getName();
        lllllllllllllllIlllIIllllllllIIl.handle = lllllllllllllllIlllIIllllllllIII;
    }

    public String getClassName() {
        TypeReference lllllllllllllllIlllIIllllllIllIl;
        return lllllllllllllllIlllIIllllllIllIl.name.replace('/', '.');
    }

    public TypeHandle getHandle(ProcessingEnvironment lllllllllllllllIlllIIllllllIIIlI) {
        TypeReference lllllllllllllllIlllIIllllllIIIIl;
        if (lllllllllllllllIlllIIllllllIIIIl.handle == null) {
            TypeElement lllllllllllllllIlllIIllllllIIlIl = lllllllllllllllIlllIIllllllIIIlI.getElementUtils().getTypeElement(lllllllllllllllIlllIIllllllIIIIl.getClassName());
            try {
                lllllllllllllllIlllIIllllllIIIIl.handle = new TypeHandle(lllllllllllllllIlllIIllllllIIlIl);
            }
            catch (Exception lllllllllllllllIlllIIllllllIIllI) {
                lllllllllllllllIlllIIllllllIIllI.printStackTrace();
            }
        }
        return lllllllllllllllIlllIIllllllIIIIl.handle;
    }

    public int hashCode() {
        TypeReference lllllllllllllllIlllIIllllIlllIlI;
        return lllllllllllllllIlllIIllllIlllIlI.name.hashCode();
    }

    @Override
    public int compareTo(TypeReference lllllllllllllllIlllIIlllllIIlIll) {
        TypeReference lllllllllllllllIlllIIlllllIIllIl;
        return lllllllllllllllIlllIIlllllIIlIll == null ? -1 : lllllllllllllllIlllIIlllllIIllIl.name.compareTo(lllllllllllllllIlllIIlllllIIlIll.name);
    }

    public String getName() {
        TypeReference lllllllllllllllIlllIIlllllllIIII;
        return lllllllllllllllIlllIIlllllllIIII.name;
    }
}

