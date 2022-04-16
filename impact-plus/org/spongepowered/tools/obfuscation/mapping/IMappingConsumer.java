/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Objects
 */
package org.spongepowered.tools.obfuscation.mapping;

import com.google.common.base.Objects;
import java.util.LinkedHashSet;
import org.spongepowered.asm.obfuscation.mapping.IMapping;
import org.spongepowered.asm.obfuscation.mapping.common.MappingField;
import org.spongepowered.asm.obfuscation.mapping.common.MappingMethod;
import org.spongepowered.tools.obfuscation.ObfuscationType;

public interface IMappingConsumer {
    public MappingSet<MappingField> getFieldMappings(ObfuscationType var1);

    public void clear();

    public void addFieldMapping(ObfuscationType var1, MappingField var2, MappingField var3);

    public MappingSet<MappingMethod> getMethodMappings(ObfuscationType var1);

    public void addMethodMapping(ObfuscationType var1, MappingMethod var2, MappingMethod var3);

    public static class MappingSet<TMapping extends IMapping<TMapping>>
    extends LinkedHashSet<Pair<TMapping>> {
        private static final /* synthetic */ long serialVersionUID = 1L;

        public MappingSet() {
            MappingSet llIIIllIIIIlIII;
        }

        public static class Pair<TMapping extends IMapping<TMapping>> {
            public final /* synthetic */ TMapping from;
            public final /* synthetic */ TMapping to;

            public Pair(TMapping lllIIlIIllllIl, TMapping lllIIlIIllllll) {
                Pair lllIIlIlIIIIIl;
                lllIIlIlIIIIIl.from = lllIIlIIllllIl;
                lllIIlIlIIIIIl.to = lllIIlIIllllll;
            }

            public boolean equals(Object lllIIlIIllIlII) {
                Pair lllIIlIIlllIII;
                if (!(lllIIlIIllIlII instanceof Pair)) {
                    return false;
                }
                Pair lllIIlIIllIllI = (Pair)lllIIlIIllIlII;
                return Objects.equal(lllIIlIIlllIII.from, lllIIlIIllIllI.from) && Objects.equal(lllIIlIIlllIII.to, lllIIlIIllIllI.to);
            }

            public int hashCode() {
                Pair lllIIlIIllIIIl;
                return Objects.hashCode((Object[])new Object[]{lllIIlIIllIIIl.from, lllIIlIIllIIIl.to});
            }

            public String toString() {
                Pair lllIIlIIlIlllI;
                return String.format("%s -> %s", lllIIlIIlIlllI.from, lllIIlIIlIlllI.to);
            }
        }
    }
}

