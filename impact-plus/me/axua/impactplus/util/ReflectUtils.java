/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.lang3.reflect.MethodUtils
 */
package me.axua.impactplus.util;

import java.lang.reflect.Field;
import java.util.Arrays;
import org.apache.commons.lang3.reflect.MethodUtils;

public class ReflectUtils {
    public static Field getField(Class<?> lllllllllllllllllllIIllllIIlIlIl, String ... lllllllllllllllllllIIllllIIIlIlI) {
        int lllllllllllllllllllIIllllIIlIIIl = lllllllllllllllllllIIllllIIIlIlI.length;
        for (int lllllllllllllllllllIIllllIIIlllI = 0; lllllllllllllllllllIIllllIIIlllI < lllllllllllllllllllIIllllIIlIIIl; ++lllllllllllllllllllIIllllIIIlllI) {
            String lllllllllllllllllllIIllllIIlIlll = lllllllllllllllllllIIllllIIIlIlI[lllllllllllllllllllIIllllIIIlllI];
            try {
                Field lllllllllllllllllllIIllllIIlllIl = Field.class.getDeclaredField("modifiers");
                lllllllllllllllllllIIllllIIlllIl.setAccessible(true);
                Field lllllllllllllllllllIIllllIIllIll = lllllllllllllllllllIIllllIIlIlIl.getDeclaredField(lllllllllllllllllllIIllllIIlIlll);
                lllllllllllllllllllIIllllIIllIll.setAccessible(true);
                lllllllllllllllllllIIllllIIlllIl.setInt(lllllllllllllllllllIIllllIIllIll, lllllllllllllllllllIIllllIIllIll.getModifiers() & 0xFFFFFFEF);
                return lllllllllllllllllllIIllllIIllIll;
            }
            catch (Exception lllllllllllllllllllIIllllIIllIIl) {
                continue;
            }
        }
        System.out.println(String.valueOf(new StringBuilder().append("Invalid Fields: ").append(Arrays.asList(lllllllllllllllllllIIllllIIIlIlI)).append(" For Class: ").append(lllllllllllllllllllIIllllIIlIlIl.getName())));
        return null;
    }

    public static Object callMethod(Object lllllllllllllllllllIIlllIllIllIl, Object[] lllllllllllllllllllIIlllIllIIlll, String ... lllllllllllllllllllIIlllIllIlIll) {
        int lllllllllllllllllllIIlllIllIlIlI = lllllllllllllllllllIIlllIllIlIll.length;
        for (int lllllllllllllllllllIIlllIllIlIIl = 0; lllllllllllllllllllIIlllIllIlIIl < lllllllllllllllllllIIlllIllIlIlI; ++lllllllllllllllllllIIlllIllIlIIl) {
            String lllllllllllllllllllIIlllIllIlllI = lllllllllllllllllllIIlllIllIlIll[lllllllllllllllllllIIlllIllIlIIl];
            try {
                return MethodUtils.invokeMethod((Object)lllllllllllllllllllIIlllIllIllIl, (boolean)true, (String)lllllllllllllllllllIIlllIllIlllI, (Object[])lllllllllllllllllllIIlllIllIIlll);
            }
            catch (Exception lllllllllllllllllllIIlllIllIllll) {
                continue;
            }
        }
        System.out.println(String.valueOf(new StringBuilder().append("Invalid Method: ").append(Arrays.asList(lllllllllllllllllllIIlllIllIlIll))));
        return null;
    }

    public ReflectUtils() {
        ReflectUtils lllllllllllllllllllIIllllIlllllI;
    }
}

