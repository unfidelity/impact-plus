/*
 * Decompiled with CFR 0.152.
 */
package org.spongepowered.tools.obfuscation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.spongepowered.tools.obfuscation.ObfuscationType;

public class ObfuscationData<T>
implements Iterable<ObfuscationType> {
    private final /* synthetic */ Map<ObfuscationType, T> data;
    private final /* synthetic */ T defaultValue;

    public void put(ObfuscationType lllllllllllllllIlllIIllIIllIIIlI, T lllllllllllllllIlllIIllIIllIIIIl) {
        ObfuscationData lllllllllllllllIlllIIllIIllIIIll;
        lllllllllllllllIlllIIllIIllIIIll.data.put(lllllllllllllllIlllIIllIIllIIIlI, lllllllllllllllIlllIIllIIllIIIIl);
    }

    public ObfuscationData() {
        lllllllllllllllIlllIIllIIlllIllI(null);
        ObfuscationData<Object> lllllllllllllllIlllIIllIIlllIllI;
    }

    private String listValues() {
        ObfuscationData lllllllllllllllIlllIIllIIIlllIll;
        StringBuilder lllllllllllllllIlllIIllIIIllllll = new StringBuilder();
        boolean lllllllllllllllIlllIIllIIIllllIl = false;
        for (ObfuscationType lllllllllllllllIlllIIllIIlIIIIll : lllllllllllllllIlllIIllIIIlllIll.data.keySet()) {
            if (lllllllllllllllIlllIIllIIIllllIl) {
                lllllllllllllllIlllIIllIIIllllll.append(',');
            }
            lllllllllllllllIlllIIllIIIllllll.append(lllllllllllllllIlllIIllIIlIIIIll.getKey()).append('=').append(lllllllllllllllIlllIIllIIIlllIll.data.get(lllllllllllllllIlllIIllIIlIIIIll));
            lllllllllllllllIlllIIllIIIllllIl = true;
        }
        return String.valueOf(lllllllllllllllIlllIIllIIIllllll);
    }

    public String toString() {
        ObfuscationData lllllllllllllllIlllIIllIIlIIllIl;
        return String.format("ObfuscationData[%s,DEFAULT=%s]", lllllllllllllllIlllIIllIIlIIllIl.listValues(), lllllllllllllllIlllIIllIIlIIllIl.defaultValue);
    }

    public ObfuscationData(T lllllllllllllllIlllIIllIIlllIIII) {
        ObfuscationData lllllllllllllllIlllIIllIIlllIIIl;
        lllllllllllllllIlllIIllIIlllIIIl.data = new HashMap<ObfuscationType, T>();
        lllllllllllllllIlllIIllIIlllIIIl.defaultValue = lllllllllllllllIlllIIllIIlllIIII;
    }

    public T get(ObfuscationType lllllllllllllllIlllIIllIIlIlIIll) {
        ObfuscationData lllllllllllllllIlllIIllIIlIlIlll;
        T lllllllllllllllIlllIIllIIlIlIlIl = lllllllllllllllIlllIIllIIlIlIlll.data.get(lllllllllllllllIlllIIllIIlIlIIll);
        return lllllllllllllllIlllIIllIIlIlIlIl != null ? lllllllllllllllIlllIIllIIlIlIlIl : lllllllllllllllIlllIIllIIlIlIlll.defaultValue;
    }

    @Override
    public Iterator<ObfuscationType> iterator() {
        ObfuscationData lllllllllllllllIlllIIllIIlIIllll;
        return lllllllllllllllIlllIIllIIlIIllll.data.keySet().iterator();
    }

    public boolean isEmpty() {
        ObfuscationData lllllllllllllllIlllIIllIIlIlllII;
        return lllllllllllllllIlllIIllIIlIlllII.data.isEmpty();
    }

    public String values() {
        ObfuscationData lllllllllllllllIlllIIllIIlIIlIlI;
        return String.valueOf(new StringBuilder().append("[").append(lllllllllllllllIlllIIllIIlIIlIlI.listValues()).append("]"));
    }

    @Deprecated
    public void add(ObfuscationType lllllllllllllllIlllIIllIIllIlIll, T lllllllllllllllIlllIIllIIllIIlll) {
        ObfuscationData lllllllllllllllIlllIIllIIllIllII;
        lllllllllllllllIlllIIllIIllIllII.put(lllllllllllllllIlllIIllIIllIlIll, lllllllllllllllIlllIIllIIllIIlll);
    }
}

