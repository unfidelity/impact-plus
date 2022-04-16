/*
 * Decompiled with CFR 0.152.
 */
package net.jodah.typetools;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import sun.misc.Unsafe;

public final class TypeResolver {
    private static /* synthetic */ Method GET_CONSTANT_POOL_SIZE;
    private static /* synthetic */ Method GET_CONSTANT_POOL;
    private static final /* synthetic */ Map<Class<?>, Class<?>> PRIMITIVE_WRAPPERS;
    private static /* synthetic */ boolean RESOLVES_LAMBDAS;
    private static final /* synthetic */ Double JAVA_VERSION;
    private static /* synthetic */ Method GET_CONSTANT_POOL_METHOD_AT;
    private static final /* synthetic */ Map<Class<?>, Reference<Map<TypeVariable<?>, Type>>> TYPE_VARIABLE_CACHE;
    private static final /* synthetic */ Map<String, Method> OBJECT_METHODS;
    private static volatile /* synthetic */ boolean CACHE_ENABLED;

    /*
     * WARNING - void declaration
     */
    private static Member getMemberRef(Class<?> lllllllllllllllllIlIlllllIIlIIll) {
        try {
            Object lllllllllllllllllIlIlllllIIllIlI = GET_CONSTANT_POOL.invoke(lllllllllllllllllIlIlllllIIlIIll, new Object[0]);
        }
        catch (Exception lllllllllllllllllIlIlllllIIllIIl) {
            return null;
        }
        Member lllllllllllllllllIlIlllllIIlIlII = null;
        for (int lllllllllllllllllIlIlllllIIlIlll = TypeResolver.getConstantPoolSize(lllllllllllllllllIlIlllllIIlIlIl) - 1; lllllllllllllllllIlIlllllIIlIlll >= 0; --lllllllllllllllllIlIlllllIIlIlll) {
            void lllllllllllllllllIlIlllllIIlIlIl;
            Member lllllllllllllllllIlIlllllIIllIII = TypeResolver.getConstantPoolMethodAt(lllllllllllllllllIlIlllllIIlIlIl, lllllllllllllllllIlIlllllIIlIlll);
            if (lllllllllllllllllIlIlllllIIllIII == null || lllllllllllllllllIlIlllllIIllIII instanceof Constructor && lllllllllllllllllIlIlllllIIllIII.getDeclaringClass().getName().equals("java.lang.invoke.SerializedLambda") || lllllllllllllllllIlIlllllIIllIII.getDeclaringClass().isAssignableFrom(lllllllllllllllllIlIlllllIIlIIll)) continue;
            lllllllllllllllllIlIlllllIIlIlII = lllllllllllllllllIlIlllllIIllIII;
            if (!(lllllllllllllllllIlIlllllIIllIII instanceof Method) || !TypeResolver.isAutoBoxingMethod((Method)lllllllllllllllllIlIlllllIIllIII)) break;
        }
        return lllllllllllllllllIlIlllllIIlIlII;
    }

    private static Map<TypeVariable<?>, Type> getTypeVariableMap(Class<?> lllllllllllllllllIllIIIIIllIlIIl, Class<?> lllllllllllllllllIllIIIIIllIIIIl) {
        Map<TypeVariable<?>, Type> lllllllllllllllllIllIIIIIllIIlII;
        Reference<Map<TypeVariable<?>, Type>> lllllllllllllllllIllIIIIIllIIllI = TYPE_VARIABLE_CACHE.get(lllllllllllllllllIllIIIIIllIlIIl);
        Map<TypeVariable<?>, Type> map = lllllllllllllllllIllIIIIIllIIlII = lllllllllllllllllIllIIIIIllIIllI != null ? lllllllllllllllllIllIIIIIllIIllI.get() : null;
        if (lllllllllllllllllIllIIIIIllIIlII == null) {
            Class<?> lllllllllllllllllIllIIIIIllIlIlI;
            lllllllllllllllllIllIIIIIllIIlII = new HashMap();
            if (lllllllllllllllllIllIIIIIllIIIIl != null) {
                TypeResolver.populateLambdaArgs(lllllllllllllllllIllIIIIIllIIIIl, lllllllllllllllllIllIIIIIllIlIIl, lllllllllllllllllIllIIIIIllIIlII);
            }
            TypeResolver.populateSuperTypeArgs(lllllllllllllllllIllIIIIIllIlIIl.getGenericInterfaces(), lllllllllllllllllIllIIIIIllIIlII, lllllllllllllllllIllIIIIIllIIIIl != null);
            Type lllllllllllllllllIllIIIIIllIllII = lllllllllllllllllIllIIIIIllIlIIl.getGenericSuperclass();
            for (lllllllllllllllllIllIIIIIllIlIlI = lllllllllllllllllIllIIIIIllIlIIl.getSuperclass(); lllllllllllllllllIllIIIIIllIlIlI != null && !Object.class.equals(lllllllllllllllllIllIIIIIllIlIlI); lllllllllllllllllIllIIIIIllIlIlI = lllllllllllllllllIllIIIIIllIlIlI.getSuperclass()) {
                if (lllllllllllllllllIllIIIIIllIllII instanceof ParameterizedType) {
                    TypeResolver.populateTypeArgs((ParameterizedType)lllllllllllllllllIllIIIIIllIllII, lllllllllllllllllIllIIIIIllIIlII, false);
                }
                TypeResolver.populateSuperTypeArgs(lllllllllllllllllIllIIIIIllIlIlI.getGenericInterfaces(), lllllllllllllllllIllIIIIIllIIlII, false);
                lllllllllllllllllIllIIIIIllIllII = lllllllllllllllllIllIIIIIllIlIlI.getGenericSuperclass();
            }
            lllllllllllllllllIllIIIIIllIlIlI = lllllllllllllllllIllIIIIIllIlIIl;
            while (lllllllllllllllllIllIIIIIllIlIlI.isMemberClass()) {
                lllllllllllllllllIllIIIIIllIllII = lllllllllllllllllIllIIIIIllIlIlI.getGenericSuperclass();
                if (lllllllllllllllllIllIIIIIllIllII instanceof ParameterizedType) {
                    TypeResolver.populateTypeArgs((ParameterizedType)lllllllllllllllllIllIIIIIllIllII, lllllllllllllllllIllIIIIIllIIlII, lllllllllllllllllIllIIIIIllIIIIl != null);
                }
                lllllllllllllllllIllIIIIIllIlIlI = lllllllllllllllllIllIIIIIllIlIlI.getEnclosingClass();
            }
            if (CACHE_ENABLED) {
                TYPE_VARIABLE_CACHE.put(lllllllllllllllllIllIIIIIllIlIIl, new WeakReference(lllllllllllllllllIllIIIIIllIIlII));
            }
        }
        return lllllllllllllllllIllIIIIIllIIlII;
    }

    public static Class<?>[] resolveRawArguments(Type lllllllllllllllllIllIIIIllIIIllI, Class<?> lllllllllllllllllIllIIIIllIIIlIl) {
        Class[] lllllllllllllllllIllIIIIllIIlIIl;
        block5: {
            Class lllllllllllllllllIllIIIIllIIIlll;
            block6: {
                block4: {
                    lllllllllllllllllIllIIIIllIIlIIl = null;
                    lllllllllllllllllIllIIIIllIIIlll = null;
                    if (RESOLVES_LAMBDAS && lllllllllllllllllIllIIIIllIIIlIl.isSynthetic()) {
                        Class lllllllllllllllllIllIIIIllIlIIIl;
                        Class clazz = lllllllllllllllllIllIIIIllIIIllI instanceof ParameterizedType && ((ParameterizedType)lllllllllllllllllIllIIIIllIIIllI).getRawType() instanceof Class ? (Class)((ParameterizedType)lllllllllllllllllIllIIIIllIIIllI).getRawType() : (lllllllllllllllllIllIIIIllIlIIIl = lllllllllllllllllIllIIIIllIIIllI instanceof Class ? (Class)lllllllllllllllllIllIIIIllIIIllI : null);
                        if (lllllllllllllllllIllIIIIllIlIIIl != null && lllllllllllllllllIllIIIIllIlIIIl.isInterface()) {
                            lllllllllllllllllIllIIIIllIIIlll = lllllllllllllllllIllIIIIllIlIIIl;
                        }
                    }
                    if (!(lllllllllllllllllIllIIIIllIIIllI instanceof ParameterizedType)) break block4;
                    ParameterizedType lllllllllllllllllIllIIIIllIIllll = (ParameterizedType)lllllllllllllllllIllIIIIllIIIllI;
                    Type[] lllllllllllllllllIllIIIIllIIlllI = lllllllllllllllllIllIIIIllIIllll.getActualTypeArguments();
                    lllllllllllllllllIllIIIIllIIlIIl = new Class[lllllllllllllllllIllIIIIllIIlllI.length];
                    for (int lllllllllllllllllIllIIIIllIlIIII = 0; lllllllllllllllllIllIIIIllIlIIII < lllllllllllllllllIllIIIIllIIlllI.length; ++lllllllllllllllllIllIIIIllIlIIII) {
                        lllllllllllllllllIllIIIIllIIlIIl[lllllllllllllllllIllIIIIllIlIIII] = TypeResolver.resolveRawClass(lllllllllllllllllIllIIIIllIIlllI[lllllllllllllllllIllIIIIllIlIIII], lllllllllllllllllIllIIIIllIIIlIl, lllllllllllllllllIllIIIIllIIIlll);
                    }
                    break block5;
                }
                if (!(lllllllllllllllllIllIIIIllIIIllI instanceof TypeVariable)) break block6;
                lllllllllllllllllIllIIIIllIIlIIl = new Class[]{TypeResolver.resolveRawClass(lllllllllllllllllIllIIIIllIIIllI, lllllllllllllllllIllIIIIllIIIlIl, lllllllllllllllllIllIIIIllIIIlll)};
                break block5;
            }
            if (!(lllllllllllllllllIllIIIIllIIIllI instanceof Class)) break block5;
            TypeVariable<Class<T>>[] lllllllllllllllllIllIIIIllIIllII = ((Class)lllllllllllllllllIllIIIIllIIIllI).getTypeParameters();
            lllllllllllllllllIllIIIIllIIlIIl = new Class[lllllllllllllllllIllIIIIllIIllII.length];
            for (int lllllllllllllllllIllIIIIllIIllIl = 0; lllllllllllllllllIllIIIIllIIllIl < lllllllllllllllllIllIIIIllIIllII.length; ++lllllllllllllllllIllIIIIllIIllIl) {
                lllllllllllllllllIllIIIIllIIlIIl[lllllllllllllllllIllIIIIllIIllIl] = TypeResolver.resolveRawClass(lllllllllllllllllIllIIIIllIIllII[lllllllllllllllllIllIIIIllIIllIl], lllllllllllllllllIllIIIIllIIIlIl, lllllllllllllllllIllIIIIllIIIlll);
            }
        }
        return lllllllllllllllllIllIIIIllIIlIIl;
    }

    private static int getConstantPoolSize(Object lllllllllllllllllIlIllllIlllIllI) {
        try {
            return (Integer)GET_CONSTANT_POOL_SIZE.invoke(lllllllllllllllllIlIllllIlllIllI, new Object[0]);
        }
        catch (Exception lllllllllllllllllIlIllllIllllIII) {
            return 0;
        }
    }

    private TypeResolver() {
        TypeResolver lllllllllllllllllIllIIIIlllIllll;
    }

    private static Class<?> wrapPrimitives(Class<?> lllllllllllllllllIlIllllIllllIll) {
        return lllllllllllllllllIlIllllIllllIll.isPrimitive() ? PRIMITIVE_WRAPPERS.get(lllllllllllllllllIlIllllIllllIll) : lllllllllllllllllIlIllllIllllIll;
    }

    private static boolean isAutoBoxingMethod(Method lllllllllllllllllIlIlllllIIIIlII) {
        Class<?>[] lllllllllllllllllIlIlllllIIIIIll = lllllllllllllllllIlIlllllIIIIlII.getParameterTypes();
        return lllllllllllllllllIlIlllllIIIIlII.getName().equals("valueOf") && lllllllllllllllllIlIlllllIIIIIll.length == 1 && lllllllllllllllllIlIlllllIIIIIll[0].isPrimitive() && TypeResolver.wrapPrimitives(lllllllllllllllllIlIlllllIIIIIll[0]).equals(lllllllllllllllllIlIlllllIIIIlII.getDeclaringClass());
    }

    static {
        TYPE_VARIABLE_CACHE = Collections.synchronizedMap(new WeakHashMap());
        CACHE_ENABLED = true;
        OBJECT_METHODS = new HashMap<String, Method>();
        JAVA_VERSION = Double.parseDouble(System.getProperty("java.specification.version", "0"));
        try {
            Unsafe lllllllllllllllllIlIllllIlIIIlll = AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>(){

                @Override
                public Unsafe run() throws Exception {
                    Field llllllllllllllllIlIllIIlIlIlllIl = Unsafe.class.getDeclaredField("theUnsafe");
                    llllllllllllllllIlIllIIlIlIlllIl.setAccessible(true);
                    return (Unsafe)llllllllllllllllIlIllIIlIlIlllIl.get(null);
                }
                {
                    1 llllllllllllllllIlIllIIlIllIIIII;
                }
            });
            GET_CONSTANT_POOL = Class.class.getDeclaredMethod("getConstantPool", new Class[0]);
            String lllllllllllllllllIlIllllIlIIIllI = JAVA_VERSION < 9.0 ? "sun.reflect.ConstantPool" : "jdk.internal.reflect.ConstantPool";
            Class<?> lllllllllllllllllIlIllllIlIIIlIl = Class.forName(lllllllllllllllllIlIllllIlIIIllI);
            GET_CONSTANT_POOL_SIZE = lllllllllllllllllIlIllllIlIIIlIl.getDeclaredMethod("getSize", new Class[0]);
            GET_CONSTANT_POOL_METHOD_AT = lllllllllllllllllIlIllllIlIIIlIl.getDeclaredMethod("getMethodAt", Integer.TYPE);
            Field lllllllllllllllllIlIllllIlIIIlII = AccessibleObject.class.getDeclaredField("override");
            long lllllllllllllllllIlIllllIlIIIIll = lllllllllllllllllIlIllllIlIIIlll.objectFieldOffset(lllllllllllllllllIlIllllIlIIIlII);
            lllllllllllllllllIlIllllIlIIIlll.putBoolean((Object)GET_CONSTANT_POOL, lllllllllllllllllIlIllllIlIIIIll, true);
            lllllllllllllllllIlIllllIlIIIlll.putBoolean((Object)GET_CONSTANT_POOL_SIZE, lllllllllllllllllIlIllllIlIIIIll, true);
            lllllllllllllllllIlIllllIlIIIlll.putBoolean((Object)GET_CONSTANT_POOL_METHOD_AT, lllllllllllllllllIlIllllIlIIIIll, true);
            Object lllllllllllllllllIlIllllIlIIIIlI = GET_CONSTANT_POOL.invoke(Object.class, new Object[0]);
            GET_CONSTANT_POOL_SIZE.invoke(lllllllllllllllllIlIllllIlIIIIlI, new Object[0]);
            for (Method lllllllllllllllllIlIllllIlIIlIII : Object.class.getDeclaredMethods()) {
                OBJECT_METHODS.put(lllllllllllllllllIlIllllIlIIlIII.getName(), lllllllllllllllllIlIllllIlIIlIII);
            }
            RESOLVES_LAMBDAS = true;
        }
        catch (Exception lllllllllllllllllIlIllllIlIIIlll) {
            // empty catch block
        }
        HashMap<Class<Object>, Class<Void>> lllllllllllllllllIlIllllIlIIIIIl = new HashMap<Class<Object>, Class<Void>>();
        lllllllllllllllllIlIllllIlIIIIIl.put(Boolean.TYPE, Boolean.class);
        lllllllllllllllllIlIllllIlIIIIIl.put(Byte.TYPE, Byte.class);
        lllllllllllllllllIlIllllIlIIIIIl.put(Character.TYPE, Character.class);
        lllllllllllllllllIlIllllIlIIIIIl.put(Double.TYPE, Double.class);
        lllllllllllllllllIlIllllIlIIIIIl.put(Float.TYPE, Float.class);
        lllllllllllllllllIlIllllIlIIIIIl.put(Integer.TYPE, Integer.class);
        lllllllllllllllllIlIllllIlIIIIIl.put(Long.TYPE, Long.class);
        lllllllllllllllllIlIllllIlIIIIIl.put(Short.TYPE, Short.class);
        lllllllllllllllllIlIllllIlIIIIIl.put(Void.TYPE, Void.class);
        PRIMITIVE_WRAPPERS = Collections.unmodifiableMap(lllllllllllllllllIlIllllIlIIIIIl);
    }

    private static void populateTypeArgs(ParameterizedType lllllllllllllllllIllIIIIIIIIllll, Map<TypeVariable<?>, Type> lllllllllllllllllIllIIIIIIIIlllI, boolean lllllllllllllllllIllIIIIIIIIllIl) {
        if (lllllllllllllllllIllIIIIIIIIllll.getRawType() instanceof Class) {
            Type lllllllllllllllllIllIIIIIIlIIIlI;
            TypeVariable<Class<T>>[] lllllllllllllllllIllIIIIIIIlIlll = ((Class)lllllllllllllllllIllIIIIIIIIllll.getRawType()).getTypeParameters();
            Type[] lllllllllllllllllIllIIIIIIIlIlIl = lllllllllllllllllIllIIIIIIIIllll.getActualTypeArguments();
            if (lllllllllllllllllIllIIIIIIIIllll.getOwnerType() != null && (lllllllllllllllllIllIIIIIIlIIIlI = lllllllllllllllllIllIIIIIIIIllll.getOwnerType()) instanceof ParameterizedType) {
                TypeResolver.populateTypeArgs((ParameterizedType)lllllllllllllllllIllIIIIIIlIIIlI, lllllllllllllllllIllIIIIIIIIlllI, lllllllllllllllllIllIIIIIIIIllIl);
            }
            for (int lllllllllllllllllIllIIIIIIIllIII = 0; lllllllllllllllllIllIIIIIIIllIII < lllllllllllllllllIllIIIIIIIlIlIl.length; ++lllllllllllllllllIllIIIIIIIllIII) {
                Type lllllllllllllllllIllIIIIIIlIIIIl;
                TypeVariable lllllllllllllllllIllIIIIIIIllIlI = lllllllllllllllllIllIIIIIIIlIlll[lllllllllllllllllIllIIIIIIIllIII];
                Type lllllllllllllllllIllIIIIIIIllIIl = lllllllllllllllllIllIIIIIIIlIlIl[lllllllllllllllllIllIIIIIIIllIII];
                if (lllllllllllllllllIllIIIIIIIllIIl instanceof Class) {
                    lllllllllllllllllIllIIIIIIIIlllI.put(lllllllllllllllllIllIIIIIIIllIlI, lllllllllllllllllIllIIIIIIIllIIl);
                    continue;
                }
                if (lllllllllllllllllIllIIIIIIIllIIl instanceof GenericArrayType) {
                    lllllllllllllllllIllIIIIIIIIlllI.put(lllllllllllllllllIllIIIIIIIllIlI, lllllllllllllllllIllIIIIIIIllIIl);
                    continue;
                }
                if (lllllllllllllllllIllIIIIIIIllIIl instanceof ParameterizedType) {
                    lllllllllllllllllIllIIIIIIIIlllI.put(lllllllllllllllllIllIIIIIIIllIlI, lllllllllllllllllIllIIIIIIIllIIl);
                    continue;
                }
                if (!(lllllllllllllllllIllIIIIIIIllIIl instanceof TypeVariable)) continue;
                TypeVariable lllllllllllllllllIllIIIIIIIllllI = (TypeVariable)lllllllllllllllllIllIIIIIIIllIIl;
                if (lllllllllllllllllIllIIIIIIIIllIl && (lllllllllllllllllIllIIIIIIlIIIIl = lllllllllllllllllIllIIIIIIIIlllI.get(lllllllllllllllllIllIIIIIIIllIlI)) != null) {
                    lllllllllllllllllIllIIIIIIIIlllI.put(lllllllllllllllllIllIIIIIIIllllI, lllllllllllllllllIllIIIIIIlIIIIl);
                    continue;
                }
                Type lllllllllllllllllIllIIIIIIIlllII = lllllllllllllllllIllIIIIIIIIlllI.get(lllllllllllllllllIllIIIIIIIllllI);
                if (lllllllllllllllllIllIIIIIIIlllII == null) {
                    lllllllllllllllllIllIIIIIIIlllII = TypeResolver.resolveBound(lllllllllllllllllIllIIIIIIIllllI);
                }
                lllllllllllllllllIllIIIIIIIIlllI.put(lllllllllllllllllIllIIIIIIIllIlI, lllllllllllllllllIllIIIIIIIlllII);
            }
        }
    }

    public static Type resolveGenericType(Class<?> lllllllllllllllllIllIIIIlIIllIll, Type lllllllllllllllllIllIIIIlIIllIlI) {
        Type lllllllllllllllllIllIIIIlIlIIIII;
        Type lllllllllllllllllIllIIIIlIIlllII;
        Class lllllllllllllllllIllIIIIlIIlllIl;
        if (lllllllllllllllllIllIIIIlIIllIlI instanceof ParameterizedType) {
            Class lllllllllllllllllIllIIIIlIlIIIll = (Class)((ParameterizedType)lllllllllllllllllIllIIIIlIIllIlI).getRawType();
        } else {
            lllllllllllllllllIllIIIIlIIlllIl = (Class)lllllllllllllllllIllIIIIlIIllIlI;
        }
        if (lllllllllllllllllIllIIIIlIIllIll.equals(lllllllllllllllllIllIIIIlIIlllIl)) {
            return lllllllllllllllllIllIIIIlIIllIlI;
        }
        if (lllllllllllllllllIllIIIIlIIllIll.isInterface()) {
            for (Type lllllllllllllllllIllIIIIlIlIIIIl : lllllllllllllllllIllIIIIlIIlllIl.getGenericInterfaces()) {
                Type lllllllllllllllllIllIIIIlIlIIIlI;
                if (lllllllllllllllllIllIIIIlIlIIIIl == null || lllllllllllllllllIllIIIIlIlIIIIl.equals(Object.class) || (lllllllllllllllllIllIIIIlIlIIIlI = TypeResolver.resolveGenericType(lllllllllllllllllIllIIIIlIIllIll, lllllllllllllllllIllIIIIlIlIIIIl)) == null) continue;
                return lllllllllllllllllIllIIIIlIlIIIlI;
            }
        }
        if ((lllllllllllllllllIllIIIIlIIlllII = lllllllllllllllllIllIIIIlIIlllIl.getGenericSuperclass()) != null && !lllllllllllllllllIllIIIIlIIlllII.equals(Object.class) && (lllllllllllllllllIllIIIIlIlIIIII = TypeResolver.resolveGenericType(lllllllllllllllllIllIIIIlIIllIll, lllllllllllllllllIllIIIIlIIlllII)) != null) {
            return lllllllllllllllllIllIIIIlIlIIIII;
        }
        return null;
    }

    public static Class<?> resolveRawArgument(Type lllllllllllllllllIllIIIIlllIIlII, Class<?> lllllllllllllllllIllIIIIlllIIIII) {
        Class<?>[] lllllllllllllllllIllIIIIlllIIIlI = TypeResolver.resolveRawArguments(lllllllllllllllllIllIIIIlllIIlII, lllllllllllllllllIllIIIIlllIIIII);
        if (lllllllllllllllllIllIIIIlllIIIlI == null) {
            return Unknown.class;
        }
        if (lllllllllllllllllIllIIIIlllIIIlI.length != 1) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Expected 1 argument for generic type ").append(lllllllllllllllllIllIIIIlllIIlII).append(" but found ").append(lllllllllllllllllIllIIIIlllIIIlI.length)));
        }
        return lllllllllllllllllIllIIIIlllIIIlI[0];
    }

    public static void enableCache() {
        CACHE_ENABLED = true;
    }

    private static boolean isDefaultMethod(Method lllllllllllllllllIlIlllllIlIllIl) {
        return JAVA_VERSION >= 1.8 && lllllllllllllllllIlIlllllIlIllIl.isDefault();
    }

    public static void disableCache() {
        TYPE_VARIABLE_CACHE.clear();
        CACHE_ENABLED = false;
    }

    public static Type resolveBound(TypeVariable<?> lllllllllllllllllIlIlllllllIllII) {
        Type[] lllllllllllllllllIlIlllllllIlllI = lllllllllllllllllIlIlllllllIllII.getBounds();
        if (lllllllllllllllllIlIlllllllIlllI.length == 0) {
            return Unknown.class;
        }
        Type lllllllllllllllllIlIlllllllIllIl = lllllllllllllllllIlIlllllllIlllI[0];
        if (lllllllllllllllllIlIlllllllIllIl instanceof TypeVariable) {
            lllllllllllllllllIlIlllllllIllIl = TypeResolver.resolveBound((TypeVariable)lllllllllllllllllIlIlllllllIllIl);
        }
        return lllllllllllllllllIlIlllllllIllIl == Object.class ? Unknown.class : lllllllllllllllllIlIlllllllIllIl;
    }

    public static <T, S extends T> Class<?> resolveRawArgument(Class<T> lllllllllllllllllIllIIIIlllIlIll, Class<S> lllllllllllllllllIllIIIIlllIlIlI) {
        return TypeResolver.resolveRawArgument(TypeResolver.resolveGenericType(lllllllllllllllllIllIIIIlllIlIll, lllllllllllllllllIllIIIIlllIlIlI), lllllllllllllllllIllIIIIlllIlIlI);
    }

    private static void populateLambdaArgs(Class<?> lllllllllllllllllIlIlllllIlllllI, Class<?> lllllllllllllllllIlIlllllIllllIl, Map<TypeVariable<?>, Type> lllllllllllllllllIlIlllllIllllII) {
        if (RESOLVES_LAMBDAS) {
            for (Method lllllllllllllllllIlIllllllIIIIlI : lllllllllllllllllIlIlllllIlllllI.getMethods()) {
                Method lllllllllllllllllIlIllllllIIlIIl;
                if (TypeResolver.isDefaultMethod(lllllllllllllllllIlIllllllIIIIlI) || Modifier.isStatic(lllllllllllllllllIlIllllllIIIIlI.getModifiers()) || lllllllllllllllllIlIllllllIIIIlI.isBridge() || (lllllllllllllllllIlIllllllIIlIIl = OBJECT_METHODS.get(lllllllllllllllllIlIllllllIIIIlI.getName())) != null && Arrays.equals(lllllllllllllllllIlIllllllIIIIlI.getTypeParameters(), lllllllllllllllllIlIllllllIIlIIl.getTypeParameters())) continue;
                Type lllllllllllllllllIlIllllllIIlIII = lllllllllllllllllIlIllllllIIIIlI.getGenericReturnType();
                Type[] lllllllllllllllllIlIllllllIIIlll = lllllllllllllllllIlIllllllIIIIlI.getGenericParameterTypes();
                Member lllllllllllllllllIlIllllllIIIllI = TypeResolver.getMemberRef(lllllllllllllllllIlIlllllIllllIl);
                if (lllllllllllllllllIlIllllllIIIllI == null) {
                    return;
                }
                if (lllllllllllllllllIlIllllllIIlIII instanceof TypeVariable) {
                    Class<Object> lllllllllllllllllIlIllllllIIllII = lllllllllllllllllIlIllllllIIIllI instanceof Method ? ((Method)lllllllllllllllllIlIllllllIIIllI).getReturnType() : ((Constructor)lllllllllllllllllIlIllllllIIIllI).getDeclaringClass();
                    if (!(lllllllllllllllllIlIllllllIIllII = TypeResolver.wrapPrimitives(lllllllllllllllllIlIllllllIIllII)).equals(Void.class)) {
                        lllllllllllllllllIlIlllllIllllII.put((TypeVariable)lllllllllllllllllIlIllllllIIlIII, lllllllllllllllllIlIllllllIIllII);
                    }
                }
                Class<?>[] lllllllllllllllllIlIllllllIIIlIl = lllllllllllllllllIlIllllllIIIllI instanceof Method ? ((Method)lllllllllllllllllIlIllllllIIIllI).getParameterTypes() : ((Constructor)lllllllllllllllllIlIllllllIIIllI).getParameterTypes();
                int lllllllllllllllllIlIllllllIIIlII = 0;
                if (lllllllllllllllllIlIllllllIIIlll.length > 0 && lllllllllllllllllIlIllllllIIIlll[0] instanceof TypeVariable && lllllllllllllllllIlIllllllIIIlll.length == lllllllllllllllllIlIllllllIIIlIl.length + 1) {
                    Class<?> lllllllllllllllllIlIllllllIIlIll = lllllllllllllllllIlIllllllIIIllI.getDeclaringClass();
                    lllllllllllllllllIlIlllllIllllII.put((TypeVariable)lllllllllllllllllIlIllllllIIIlll[0], lllllllllllllllllIlIllllllIIlIll);
                    lllllllllllllllllIlIllllllIIIlII = 1;
                }
                int lllllllllllllllllIlIllllllIIIIll = 0;
                if (lllllllllllllllllIlIllllllIIIlll.length < lllllllllllllllllIlIllllllIIIlIl.length) {
                    lllllllllllllllllIlIllllllIIIIll = lllllllllllllllllIlIllllllIIIlIl.length - lllllllllllllllllIlIllllllIIIlll.length;
                }
                int lllllllllllllllllIlIllllllIIlIlI = 0;
                while (lllllllllllllllllIlIllllllIIlIlI + lllllllllllllllllIlIllllllIIIIll < lllllllllllllllllIlIllllllIIIlIl.length) {
                    if (lllllllllllllllllIlIllllllIIIlll[lllllllllllllllllIlIllllllIIlIlI] instanceof TypeVariable) {
                        lllllllllllllllllIlIlllllIllllII.put((TypeVariable)lllllllllllllllllIlIllllllIIIlll[lllllllllllllllllIlIllllllIIlIlI + lllllllllllllllllIlIllllllIIIlII], TypeResolver.wrapPrimitives(lllllllllllllllllIlIllllllIIIlIl[lllllllllllllllllIlIllllllIIlIlI + lllllllllllllllllIlIllllllIIIIll]));
                    }
                    ++lllllllllllllllllIlIllllllIIlIlI;
                }
                return;
            }
        }
    }

    private static void populateSuperTypeArgs(Type[] lllllllllllllllllIllIIIIIlIIllII, Map<TypeVariable<?>, Type> lllllllllllllllllIllIIIIIlIIlIll, boolean lllllllllllllllllIllIIIIIlIIlIlI) {
        for (Type lllllllllllllllllIllIIIIIlIlIIII : lllllllllllllllllIllIIIIIlIIllII) {
            if (lllllllllllllllllIllIIIIIlIlIIII instanceof ParameterizedType) {
                Type lllllllllllllllllIllIIIIIlIlIIIl;
                ParameterizedType lllllllllllllllllIllIIIIIlIlIIlI = (ParameterizedType)lllllllllllllllllIllIIIIIlIlIIII;
                if (!lllllllllllllllllIllIIIIIlIIlIlI) {
                    TypeResolver.populateTypeArgs(lllllllllllllllllIllIIIIIlIlIIlI, lllllllllllllllllIllIIIIIlIIlIll, lllllllllllllllllIllIIIIIlIIlIlI);
                }
                if ((lllllllllllllllllIllIIIIIlIlIIIl = lllllllllllllllllIllIIIIIlIlIIlI.getRawType()) instanceof Class) {
                    TypeResolver.populateSuperTypeArgs(((Class)lllllllllllllllllIllIIIIIlIlIIIl).getGenericInterfaces(), lllllllllllllllllIllIIIIIlIIlIll, lllllllllllllllllIllIIIIIlIIlIlI);
                }
                if (!lllllllllllllllllIllIIIIIlIIlIlI) continue;
                TypeResolver.populateTypeArgs(lllllllllllllllllIllIIIIIlIlIIlI, lllllllllllllllllIllIIIIIlIIlIll, lllllllllllllllllIllIIIIIlIIlIlI);
                continue;
            }
            if (!(lllllllllllllllllIllIIIIIlIlIIII instanceof Class)) continue;
            TypeResolver.populateSuperTypeArgs(((Class)lllllllllllllllllIllIIIIIlIlIIII).getGenericInterfaces(), lllllllllllllllllIllIIIIIlIIlIll, lllllllllllllllllIllIIIIIlIIlIlI);
        }
    }

    public static Class<?> resolveRawClass(Type lllllllllllllllllIllIIIIlIIIllll, Class<?> lllllllllllllllllIllIIIIlIIlIIII) {
        return TypeResolver.resolveRawClass(lllllllllllllllllIllIIIIlIIIllll, lllllllllllllllllIllIIIIlIIlIIII, null);
    }

    private static Class<?> resolveRawClass(Type lllllllllllllllllIllIIIIlIIIIIlI, Class<?> lllllllllllllllllIllIIIIlIIIIIIl, Class<?> lllllllllllllllllIllIIIIlIIIIIII) {
        if (lllllllllllllllllIllIIIIlIIIIIlI instanceof Class) {
            return (Class)lllllllllllllllllIllIIIIlIIIIIlI;
        }
        if (lllllllllllllllllIllIIIIlIIIIIlI instanceof ParameterizedType) {
            return TypeResolver.resolveRawClass(((ParameterizedType)lllllllllllllllllIllIIIIlIIIIIlI).getRawType(), lllllllllllllllllIllIIIIlIIIIIIl, lllllllllllllllllIllIIIIlIIIIIII);
        }
        if (lllllllllllllllllIllIIIIlIIIIIlI instanceof GenericArrayType) {
            GenericArrayType lllllllllllllllllIllIIIIlIIIlIII = (GenericArrayType)lllllllllllllllllIllIIIIlIIIIIlI;
            Class<?> lllllllllllllllllIllIIIIlIIIIlll = TypeResolver.resolveRawClass(lllllllllllllllllIllIIIIlIIIlIII.getGenericComponentType(), lllllllllllllllllIllIIIIlIIIIIIl, lllllllllllllllllIllIIIIlIIIIIII);
            return Array.newInstance(lllllllllllllllllIllIIIIlIIIIlll, 0).getClass();
        }
        if (lllllllllllllllllIllIIIIlIIIIIlI instanceof TypeVariable) {
            TypeVariable lllllllllllllllllIllIIIIlIIIIllI = (TypeVariable)lllllllllllllllllIllIIIIlIIIIIlI;
            lllllllllllllllllIllIIIIlIIIIIlI = TypeResolver.getTypeVariableMap(lllllllllllllllllIllIIIIlIIIIIIl, lllllllllllllllllIllIIIIlIIIIIII).get(lllllllllllllllllIllIIIIlIIIIllI);
            lllllllllllllllllIllIIIIlIIIIIlI = lllllllllllllllllIllIIIIlIIIIIlI == null ? TypeResolver.resolveBound(lllllllllllllllllIllIIIIlIIIIllI) : TypeResolver.resolveRawClass(lllllllllllllllllIllIIIIlIIIIIlI, lllllllllllllllllIllIIIIlIIIIIIl, lllllllllllllllllIllIIIIlIIIIIII);
        }
        return lllllllllllllllllIllIIIIlIIIIIlI instanceof Class ? (Class)lllllllllllllllllIllIIIIlIIIIIlI : Unknown.class;
    }

    public static <T, S extends T> Class<?>[] resolveRawArguments(Class<T> lllllllllllllllllIllIIIIllIllIlI, Class<S> lllllllllllllllllIllIIIIllIllIIl) {
        return TypeResolver.resolveRawArguments(TypeResolver.resolveGenericType(lllllllllllllllllIllIIIIllIllIlI, lllllllllllllllllIllIIIIllIllIIl), lllllllllllllllllIllIIIIllIllIIl);
    }

    private static Member getConstantPoolMethodAt(Object lllllllllllllllllIlIllllIllIllIl, int lllllllllllllllllIlIllllIllIlIlI) {
        try {
            return (Member)GET_CONSTANT_POOL_METHOD_AT.invoke(lllllllllllllllllIlIllllIllIllIl, lllllllllllllllllIlIllllIllIlIlI);
        }
        catch (Exception lllllllllllllllllIlIllllIllIlllI) {
            return null;
        }
    }

    public static final class Unknown {
        private Unknown() {
            Unknown lllllllllllllllllIllIlIIlIlIllIl;
        }
    }
}

