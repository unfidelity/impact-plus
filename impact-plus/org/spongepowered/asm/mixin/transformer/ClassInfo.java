/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableSet
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FieldInsnNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.FrameNode;
import org.spongepowered.asm.lib.tree.MethodInsnNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.transformer.MethodMapper;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.ClassSignature;
import org.spongepowered.asm.util.perf.Profiler;

public final class ClassInfo {
    private /* synthetic */ ClassInfo superClass;
    private final /* synthetic */ int access;
    public static final /* synthetic */ int INCLUDE_STATIC;
    private final /* synthetic */ Set<Method> methods;
    private /* synthetic */ ClassInfo outerClass;
    private /* synthetic */ ClassSignature signature;
    private final /* synthetic */ String superName;
    private final /* synthetic */ boolean isMixin;
    private final /* synthetic */ boolean isProbablyStatic;
    public static final /* synthetic */ int INCLUDE_ALL;
    private static final /* synthetic */ Map<String, ClassInfo> cache;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ boolean isInterface;
    private static final /* synthetic */ String JAVA_LANG_OBJECT;
    private final /* synthetic */ String name;
    private final /* synthetic */ Set<MixinInfo> mixins;
    private final /* synthetic */ MixinInfo mixin;
    private static final /* synthetic */ Profiler profiler;
    private final /* synthetic */ String outerName;
    private final /* synthetic */ Map<ClassInfo, ClassInfo> correspondingTypes;
    private final /* synthetic */ Set<Field> fields;
    public static final /* synthetic */ int INCLUDE_PRIVATE;
    private static final /* synthetic */ ClassInfo OBJECT;
    private final /* synthetic */ MethodMapper methodMapper;
    private final /* synthetic */ Set<String> interfaces;

    public Method findMethodInHierarchy(MethodNode lllllllllllllllIlllIlIlIIIlIIIll, SearchType lllllllllllllllIlllIlIlIIIlIIIlI, int lllllllllllllllIlllIlIlIIIlIIIIl) {
        ClassInfo lllllllllllllllIlllIlIlIIIlIIlII;
        return lllllllllllllllIlllIlIlIIIlIIlII.findMethodInHierarchy(lllllllllllllllIlllIlIlIIIlIIIll.name, lllllllllllllllIlllIlIlIIIlIIIll.desc, lllllllllllllllIlllIlIlIIIlIIIlI, Traversal.NONE, lllllllllllllllIlllIlIlIIIlIIIIl);
    }

    public static ClassInfo getCommonSuperClassOrInterface(String lllllllllllllllIlllIlIIIIlIIlllI, String lllllllllllllllIlllIlIIIIlIIlIlI) {
        if (lllllllllllllllIlllIlIIIIlIIlllI == null || lllllllllllllllIlllIlIIIIlIIlIlI == null) {
            return OBJECT;
        }
        return ClassInfo.getCommonSuperClassOrInterface(ClassInfo.forName(lllllllllllllllIlllIlIIIIlIIlllI), ClassInfo.forName(lllllllllllllllIlllIlIIIIlIIlIlI));
    }

    public static ClassInfo getCommonSuperClass(Type lllllllllllllllIlllIlIIIIllIlIlI, Type lllllllllllllllIlllIlIIIIllIlIII) {
        if (lllllllllllllllIlllIlIIIIllIlIlI == null || lllllllllllllllIlllIlIIIIllIlIII == null || lllllllllllllllIlllIlIIIIllIlIlI.getSort() != 10 || lllllllllllllllIlllIlIIIIllIlIII.getSort() != 10) {
            return OBJECT;
        }
        return ClassInfo.getCommonSuperClass(ClassInfo.forType(lllllllllllllllIlllIlIIIIllIlIlI), ClassInfo.forType(lllllllllllllllIlllIlIIIIllIlIII));
    }

    public static ClassInfo forType(Type lllllllllllllllIlllIlIIIlIIlIlII) {
        if (lllllllllllllllIlllIlIIIlIIlIlII.getSort() == 9) {
            return ClassInfo.forType(lllllllllllllllIlllIlIIIlIIlIlII.getElementType());
        }
        if (lllllllllllllllIlllIlIIIlIIlIlII.getSort() < 9) {
            return null;
        }
        return ClassInfo.forName(lllllllllllllllIlllIlIIIlIIlIlII.getClassName().replace('.', '/'));
    }

    ClassInfo findCorrespondingType(ClassInfo lllllllllllllllIlllIlIlIIlIlIIII) {
        ClassInfo lllllllllllllllIlllIlIlIIlIIlllI;
        if (lllllllllllllllIlllIlIlIIlIlIIII == null || !lllllllllllllllIlllIlIlIIlIlIIII.isMixin || lllllllllllllllIlllIlIlIIlIIlllI.isMixin) {
            return null;
        }
        ClassInfo lllllllllllllllIlllIlIlIIlIIllll = lllllllllllllllIlllIlIlIIlIIlllI.correspondingTypes.get(lllllllllllllllIlllIlIlIIlIlIIII);
        if (lllllllllllllllIlllIlIlIIlIIllll == null) {
            lllllllllllllllIlllIlIlIIlIIllll = lllllllllllllllIlllIlIlIIlIIlllI.findSuperTypeForMixin(lllllllllllllllIlllIlIlIIlIlIIII);
            lllllllllllllllIlllIlIlIIlIIlllI.correspondingTypes.put(lllllllllllllllIlllIlIlIIlIlIIII, lllllllllllllllIlllIlIlIIlIIllll);
        }
        return lllllllllllllllIlllIlIlIIlIIllll;
    }

    public static ClassInfo getCommonSuperClassOrInterface(Type lllllllllllllllIlllIlIIIIlIIIIII, Type lllllllllllllllIlllIlIIIIIllllll) {
        if (lllllllllllllllIlllIlIIIIlIIIIII == null || lllllllllllllllIlllIlIIIIIllllll == null || lllllllllllllllIlllIlIIIIlIIIIII.getSort() != 10 || lllllllllllllllIlllIlIIIIIllllll.getSort() != 10) {
            return OBJECT;
        }
        return ClassInfo.getCommonSuperClassOrInterface(ClassInfo.forType(lllllllllllllllIlllIlIIIIlIIIIII), ClassInfo.forType(lllllllllllllllIlllIlIIIIIllllll));
    }

    void addMixin(MixinInfo lllllllllllllllIlllIlIllIIllIIIl) {
        ClassInfo lllllllllllllllIlllIlIllIIllIIII;
        if (lllllllllllllllIlllIlIllIIllIIII.isMixin) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Cannot add target ").append(lllllllllllllllIlllIlIllIIllIIII.name).append(" for ").append(lllllllllllllllIlllIlIllIIllIIIl.getClassName()).append(" because the target is a mixin")));
        }
        lllllllllllllllIlllIlIllIIllIIII.mixins.add(lllllllllllllllIlllIlIllIIllIIIl);
    }

    public Method findMethod(MethodInsnNode lllllllllllllllIlllIlIIlIlIIIIll) {
        ClassInfo lllllllllllllllIlllIlIIlIlIIIIlI;
        return lllllllllllllllIlllIlIIlIlIIIIlI.findMethod(lllllllllllllllIlllIlIIlIlIIIIll.name, lllllllllllllllIlllIlIIlIlIIIIll.desc, 0);
    }

    public static ClassInfo getCommonSuperClassOrInterface(ClassInfo lllllllllllllllIlllIlIIIIIlllIlI, ClassInfo lllllllllllllllIlllIlIIIIIlllIIl) {
        return ClassInfo.getCommonSuperClass(lllllllllllllllIlllIlIIIIIlllIlI, lllllllllllllllIlllIlIIIIIlllIIl, true);
    }

    public String toString() {
        ClassInfo lllllllllllllllIlllIlIllIIIlIIlI;
        return lllllllllllllllIlllIlIllIIIlIIlI.name;
    }

    public String getOuterName() {
        ClassInfo lllllllllllllllIlllIlIlIllllllII;
        return lllllllllllllllIlllIlIlIllllllII.outerName;
    }

    public boolean isSynthetic() {
        ClassInfo lllllllllllllllIlllIlIllIIlIIIII;
        return (lllllllllllllllIlllIlIllIIlIIIII.access & 0x1000) != 0;
    }

    public boolean isInterface() {
        ClassInfo lllllllllllllllIlllIlIllIIIlIlll;
        return lllllllllllllllIlllIlIllIIIlIlll.isInterface;
    }

    public boolean isPublic() {
        ClassInfo lllllllllllllllIlllIlIllIIlIIlll;
        return (lllllllllllllllIlllIlIllIIlIIlll.access & 1) != 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private ClassInfo(ClassNode lllllllllllllllIlllIlIllIlIlIIll) {
        ClassInfo lllllllllllllllIlllIlIllIlIlIIIl;
        lllllllllllllllIlllIlIllIlIlIIIl.mixins = new HashSet<MixinInfo>();
        lllllllllllllllIlllIlIllIlIlIIIl.correspondingTypes = new HashMap<ClassInfo, ClassInfo>();
        Profiler.Section lllllllllllllllIlllIlIllIlIlIIlI = profiler.begin(1, "class.meta");
        try {
            lllllllllllllllIlllIlIllIlIlIIIl.name = lllllllllllllllIlllIlIllIlIlIIll.name;
            lllllllllllllllIlllIlIllIlIlIIIl.superName = lllllllllllllllIlllIlIllIlIlIIll.superName != null ? lllllllllllllllIlllIlIllIlIlIIll.superName : "java/lang/Object";
            lllllllllllllllIlllIlIllIlIlIIIl.methods = new HashSet<Method>();
            lllllllllllllllIlllIlIllIlIlIIIl.fields = new HashSet<Field>();
            lllllllllllllllIlllIlIllIlIlIIIl.isInterface = (lllllllllllllllIlllIlIllIlIlIIll.access & 0x200) != 0;
            lllllllllllllllIlllIlIllIlIlIIIl.interfaces = new HashSet<String>();
            lllllllllllllllIlllIlIllIlIlIIIl.access = lllllllllllllllIlllIlIllIlIlIIll.access;
            lllllllllllllllIlllIlIllIlIlIIIl.isMixin = lllllllllllllllIlllIlIllIlIlIIll instanceof MixinInfo.MixinClassNode;
            lllllllllllllllIlllIlIllIlIlIIIl.mixin = lllllllllllllllIlllIlIllIlIlIIIl.isMixin ? ((MixinInfo.MixinClassNode)lllllllllllllllIlllIlIllIlIlIIll).getMixin() : null;
            lllllllllllllllIlllIlIllIlIlIIIl.interfaces.addAll(lllllllllllllllIlllIlIllIlIlIIll.interfaces);
            for (MethodNode lllllllllllllllIlllIlIllIlIllIII : lllllllllllllllIlllIlIllIlIlIIll.methods) {
                lllllllllllllllIlllIlIllIlIlIIIl.addMethod(lllllllllllllllIlllIlIllIlIllIII, lllllllllllllllIlllIlIllIlIlIIIl.isMixin);
            }
            boolean lllllllllllllllIlllIlIllIlIlIllI = true;
            String lllllllllllllllIlllIlIllIlIlIlIl = lllllllllllllllIlllIlIllIlIlIIll.outerClass;
            for (FieldNode lllllllllllllllIlllIlIllIlIlIlll : lllllllllllllllIlllIlIllIlIlIIll.fields) {
                if ((lllllllllllllllIlllIlIllIlIlIlll.access & 0x1000) != 0 && lllllllllllllllIlllIlIllIlIlIlll.name.startsWith("this$")) {
                    lllllllllllllllIlllIlIllIlIlIllI = false;
                    if (lllllllllllllllIlllIlIllIlIlIlIl == null && (lllllllllllllllIlllIlIllIlIlIlIl = lllllllllllllllIlllIlIllIlIlIlll.desc) != null && lllllllllllllllIlllIlIllIlIlIlIl.startsWith("L")) {
                        lllllllllllllllIlllIlIllIlIlIlIl = lllllllllllllllIlllIlIllIlIlIlIl.substring(1, lllllllllllllllIlllIlIllIlIlIlIl.length() - 1);
                    }
                }
                lllllllllllllllIlllIlIllIlIlIIIl.fields.add(lllllllllllllllIlllIlIllIlIlIIIl.new Field(lllllllllllllllIlllIlIllIlIlIlll, lllllllllllllllIlllIlIllIlIlIIIl.isMixin));
            }
            lllllllllllllllIlllIlIllIlIlIIIl.isProbablyStatic = lllllllllllllllIlllIlIllIlIlIllI;
            lllllllllllllllIlllIlIllIlIlIIIl.outerName = lllllllllllllllIlllIlIllIlIlIlIl;
            lllllllllllllllIlllIlIllIlIlIIIl.methodMapper = new MethodMapper(MixinEnvironment.getCurrentEnvironment(), lllllllllllllllIlllIlIllIlIlIIIl);
            lllllllllllllllIlllIlIllIlIlIIIl.signature = ClassSignature.ofLazy(lllllllllllllllIlllIlIllIlIlIIll);
        }
        finally {
            lllllllllllllllIlllIlIllIlIlIIlI.end();
        }
    }

    static {
        INCLUDE_PRIVATE = 2;
        INCLUDE_STATIC = 8;
        INCLUDE_ALL = 10;
        JAVA_LANG_OBJECT = "java/lang/Object";
        logger = LogManager.getLogger((String)"mixin");
        profiler = MixinEnvironment.getProfiler();
        cache = new HashMap<String, ClassInfo>();
        OBJECT = new ClassInfo();
        cache.put("java/lang/Object", OBJECT);
    }

    private <M extends Member> M findMember(String lllllllllllllllIlllIlIIIllIIIIll, String lllllllllllllllIlllIlIIIllIIllIl, int lllllllllllllllIlllIlIIIlIllllll, Member.Type lllllllllllllllIlllIlIIIllIIlIIl) {
        ClassInfo lllllllllllllllIlllIlIIIllIlIIII;
        Set<Member> lllllllllllllllIlllIlIIIllIIIlll = lllllllllllllllIlllIlIIIllIIlIIl == Member.Type.METHOD ? lllllllllllllllIlllIlIIIllIlIIII.methods : lllllllllllllllIlllIlIIIllIlIIII.fields;
        for (Member lllllllllllllllIlllIlIIIllIlIIlI : lllllllllllllllIlllIlIIIllIIIlll) {
            if (!lllllllllllllllIlllIlIIIllIlIIlI.equals(lllllllllllllllIlllIlIIIllIIIIll, lllllllllllllllIlllIlIIIllIIllIl) || !lllllllllllllllIlllIlIIIllIlIIlI.matchesFlags(lllllllllllllllIlllIlIIIlIllllll)) continue;
            return (M)lllllllllllllllIlllIlIIIllIlIIlI;
        }
        return null;
    }

    public boolean isProbablyStatic() {
        ClassInfo lllllllllllllllIlllIlIllIIIlllIl;
        return lllllllllllllllIlllIlIllIIIlllIl.isProbablyStatic;
    }

    public String getClassName() {
        ClassInfo lllllllllllllllIlllIlIllIIIIIlIl;
        return lllllllllllllllIlllIlIllIIIIIlIl.name.replace('/', '.');
    }

    public Field findField(FieldNode lllllllllllllllIlllIlIIlIIIllIlI) {
        ClassInfo lllllllllllllllIlllIlIIlIIIlllIl;
        return lllllllllllllllIlllIlIIlIIIlllIl.findField(lllllllllllllllIlllIlIIlIIIllIlI.name, lllllllllllllllIlllIlIIlIIIllIlI.desc, lllllllllllllllIlllIlIIlIIIllIlI.access);
    }

    public static ClassInfo forName(String lllllllllllllllIlllIlIIIlIlIIlII) {
        ClassInfo lllllllllllllllIlllIlIIIlIlIIlIl = cache.get(lllllllllllllllIlllIlIIIlIlIIlII = lllllllllllllllIlllIlIIIlIlIIlII.replace('.', '/'));
        if (lllllllllllllllIlllIlIIIlIlIIlIl == null) {
            try {
                ClassNode lllllllllllllllIlllIlIIIlIlIlIII = MixinService.getService().getBytecodeProvider().getClassNode(lllllllllllllllIlllIlIIIlIlIIlII);
                lllllllllllllllIlllIlIIIlIlIIlIl = new ClassInfo(lllllllllllllllIlllIlIIIlIlIlIII);
            }
            catch (Exception lllllllllllllllIlllIlIIIlIlIIlll) {
                logger.catching(Level.TRACE, (Throwable)lllllllllllllllIlllIlIIIlIlIIlll);
                logger.warn("Error loading class: {} ({}: {})", new Object[]{lllllllllllllllIlllIlIIIlIlIIlII, lllllllllllllllIlllIlIIIlIlIIlll.getClass().getName(), lllllllllllllllIlllIlIIIlIlIIlll.getMessage()});
            }
            cache.put(lllllllllllllllIlllIlIIIlIlIIlII, lllllllllllllllIlllIlIIIlIlIIlIl);
            logger.trace("Added class metadata for {} to metadata cache", new Object[]{lllllllllllllllIlllIlIIIlIlIIlII});
        }
        return lllllllllllllllIlllIlIIIlIlIIlIl;
    }

    public Method findMethod(MethodInsnNode lllllllllllllllIlllIlIIlIIlllIIl, int lllllllllllllllIlllIlIIlIIlllIII) {
        ClassInfo lllllllllllllllIlllIlIIlIIllllIl;
        return lllllllllllllllIlllIlIIlIIllllIl.findMethod(lllllllllllllllIlllIlIIlIIlllIIl.name, lllllllllllllllIlllIlIIlIIlllIIl.desc, lllllllllllllllIlllIlIIlIIlllIII);
    }

    public int getAccess() {
        ClassInfo lllllllllllllllIlllIlIllIIIIlIll;
        return lllllllllllllllIlllIlIllIIIIlIll.access;
    }

    public ClassInfo findSuperClass(String lllllllllllllllIlllIlIlIlIIllIIl, Traversal lllllllllllllllIlllIlIlIlIIlIlIl) {
        ClassInfo lllllllllllllllIlllIlIlIlIIlIlll;
        return lllllllllllllllIlllIlIlIlIIlIlll.findSuperClass(lllllllllllllllIlllIlIlIlIIllIIl, lllllllllllllllIlllIlIlIlIIlIlIl, false, new HashSet<String>());
    }

    public boolean hasSuperClass(ClassInfo lllllllllllllllIlllIlIlIlIlIlIlI, Traversal lllllllllllllllIlllIlIlIlIlIIlIl, boolean lllllllllllllllIlllIlIlIlIlIlIII) {
        ClassInfo lllllllllllllllIlllIlIlIlIlIIlll;
        if (OBJECT == lllllllllllllllIlllIlIlIlIlIlIlI) {
            return true;
        }
        return lllllllllllllllIlllIlIlIlIlIIlll.findSuperClass(lllllllllllllllIlllIlIlIlIlIlIlI.name, lllllllllllllllIlllIlIlIlIlIIlIl, lllllllllllllllIlllIlIlIlIlIlIII) != null;
    }

    public Set<Method> getMethods() {
        ClassInfo lllllllllllllllIlllIlIlIlllIllIl;
        return Collections.unmodifiableSet(lllllllllllllllIlllIlIlIlllIllIl.methods);
    }

    public Method findMethodInHierarchy(String lllllllllllllllIlllIlIlIIIIIIIlI, String lllllllllllllllIlllIlIIlllllllIl, SearchType lllllllllllllllIlllIlIIlllllllII) {
        ClassInfo lllllllllllllllIlllIlIlIIIIIIIll;
        return lllllllllllllllIlllIlIlIIIIIIIll.findMethodInHierarchy(lllllllllllllllIlllIlIlIIIIIIIlI, lllllllllllllllIlllIlIIlllllllIl, lllllllllllllllIlllIlIIlllllllII, Traversal.NONE);
    }

    public Field findFieldInHierarchy(FieldInsnNode lllllllllllllllIlllIlIIllIllIlll, SearchType lllllllllllllllIlllIlIIllIllIllI, int lllllllllllllllIlllIlIIllIllIlIl) {
        ClassInfo lllllllllllllllIlllIlIIllIlllIII;
        return lllllllllllllllIlllIlIIllIlllIII.findFieldInHierarchy(lllllllllllllllIlllIlIIllIllIlll.name, lllllllllllllllIlllIlIIllIllIlll.desc, lllllllllllllllIlllIlIIllIllIllI, Traversal.NONE, lllllllllllllllIlllIlIIllIllIlIl);
    }

    public ClassSignature getSignature() {
        ClassInfo lllllllllllllllIlllIlIlIllllIllI;
        return lllllllllllllllIlllIlIlIllllIllI.signature.wake();
    }

    public Field findFieldInHierarchy(FieldNode lllllllllllllllIlllIlIIlllIIlIII, SearchType lllllllllllllllIlllIlIIlllIIIlll, int lllllllllllllllIlllIlIIlllIIIllI) {
        ClassInfo lllllllllllllllIlllIlIIlllIIlIIl;
        return lllllllllllllllIlllIlIIlllIIlIIl.findFieldInHierarchy(lllllllllllllllIlllIlIIlllIIlIII.name, lllllllllllllllIlllIlIIlllIIlIII.desc, lllllllllllllllIlllIlIIlllIIIlll, Traversal.NONE, lllllllllllllllIlllIlIIlllIIIllI);
    }

    private ClassInfo findSuperTypeForMixin(ClassInfo lllllllllllllllIlllIlIlIIlIIIIIl) {
        for (ClassInfo lllllllllllllllIlllIlIlIIlIIIIll = lllllllllllllllIlllIlIlIIlIIIlIl; lllllllllllllllIlllIlIlIIlIIIIll != null && lllllllllllllllIlllIlIlIIlIIIIll != OBJECT; lllllllllllllllIlllIlIlIIlIIIIll = lllllllllllllllIlllIlIlIIlIIIIll.getSuperClass()) {
            for (MixinInfo lllllllllllllllIlllIlIlIIlIIIllI : lllllllllllllllIlllIlIlIIlIIIIll.mixins) {
                if (!lllllllllllllllIlllIlIlIIlIIIllI.getClassInfo().equals(lllllllllllllllIlllIlIlIIlIIIIIl)) continue;
                return lllllllllllllllIlllIlIlIIlIIIIll;
            }
        }
        return null;
    }

    public Method findMethodInHierarchy(MethodInsnNode lllllllllllllllIlllIlIlIIIIllIII, SearchType lllllllllllllllIlllIlIlIIIIlIlII) {
        ClassInfo lllllllllllllllIlllIlIlIIIIlIllI;
        return lllllllllllllllIlllIlIlIIIIlIllI.findMethodInHierarchy(lllllllllllllllIlllIlIlIIIIllIII.name, lllllllllllllllIlllIlIlIIIIllIII.desc, lllllllllllllllIlllIlIlIIIIlIlII, Traversal.NONE);
    }

    public boolean isInner() {
        ClassInfo lllllllllllllllIlllIlIllIIIllIlI;
        return lllllllllllllllIlllIlIllIIIllIlI.outerName != null;
    }

    public int hashCode() {
        ClassInfo lllllllllllllllIlllIlIIIlIllIIlI;
        return lllllllllllllllIlllIlIIIlIllIIlI.name.hashCode();
    }

    public Set<String> getInterfaces() {
        ClassInfo lllllllllllllllIlllIlIllIIIlIlII;
        return Collections.unmodifiableSet(lllllllllllllllIlllIlIllIIIlIlII.interfaces);
    }

    public Method findMethodInHierarchy(String lllllllllllllllIlllIlIIlllllIlIl, String lllllllllllllllIlllIlIIllllIllll, SearchType lllllllllllllllIlllIlIIlllllIIll, Traversal lllllllllllllllIlllIlIIllllIllIl) {
        ClassInfo lllllllllllllllIlllIlIIlllllIllI;
        return lllllllllllllllIlllIlIIlllllIllI.findMethodInHierarchy(lllllllllllllllIlllIlIIlllllIlIl, lllllllllllllllIlllIlIIllllIllll, lllllllllllllllIlllIlIIlllllIIll, lllllllllllllllIlllIlIIllllIllIl, 0);
    }

    public boolean hasSuperClass(ClassInfo lllllllllllllllIlllIlIlIlIllIlII, Traversal lllllllllllllllIlllIlIlIlIllIIll) {
        ClassInfo lllllllllllllllIlllIlIlIlIllIlIl;
        return lllllllllllllllIlllIlIlIlIllIlIl.hasSuperClass(lllllllllllllllIlllIlIlIlIllIlII, lllllllllllllllIlllIlIlIlIllIIll, false);
    }

    private static ClassInfo getCommonSuperClass(ClassInfo lllllllllllllllIlllIlIIIIIllIlIl, ClassInfo lllllllllllllllIlllIlIIIIIllIIIl, boolean lllllllllllllllIlllIlIIIIIllIIll) {
        if (lllllllllllllllIlllIlIIIIIllIlIl.hasSuperClass(lllllllllllllllIlllIlIIIIIllIIIl, Traversal.NONE, lllllllllllllllIlllIlIIIIIllIIll)) {
            return lllllllllllllllIlllIlIIIIIllIIIl;
        }
        if (lllllllllllllllIlllIlIIIIIllIIIl.hasSuperClass(lllllllllllllllIlllIlIIIIIllIlIl, Traversal.NONE, lllllllllllllllIlllIlIIIIIllIIll)) {
            return lllllllllllllllIlllIlIIIIIllIlIl;
        }
        if (lllllllllllllllIlllIlIIIIIllIlIl.isInterface() || lllllllllllllllIlllIlIIIIIllIIIl.isInterface()) {
            return OBJECT;
        }
        do {
            if ((lllllllllllllllIlllIlIIIIIllIlIl = lllllllllllllllIlllIlIIIIIllIlIl.getSuperClass()) != null) continue;
            return OBJECT;
        } while (!lllllllllllllllIlllIlIIIIIllIIIl.hasSuperClass(lllllllllllllllIlllIlIIIIIllIlIl, Traversal.NONE, lllllllllllllllIlllIlIIIIIllIIll));
        return lllllllllllllllIlllIlIIIIIllIlIl;
    }

    public static ClassInfo getCommonSuperClass(String lllllllllllllllIlllIlIIIlIIIIlIl, String lllllllllllllllIlllIlIIIlIIIIIll) {
        if (lllllllllllllllIlllIlIIIlIIIIlIl == null || lllllllllllllllIlllIlIIIlIIIIIll == null) {
            return OBJECT;
        }
        return ClassInfo.getCommonSuperClass(ClassInfo.forName(lllllllllllllllIlllIlIIIlIIIIlIl), ClassInfo.forName(lllllllllllllllIlllIlIIIlIIIIIll));
    }

    private ClassInfo findInterface(String lllllllllllllllIlllIlIlIIlIllIIl) {
        ClassInfo lllllllllllllllIlllIlIlIIlIlllII;
        for (String lllllllllllllllIlllIlIlIIlIlllIl : lllllllllllllllIlllIlIlIIlIlllII.getInterfaces()) {
            ClassInfo lllllllllllllllIlllIlIlIIlIlllll = ClassInfo.forName(lllllllllllllllIlllIlIlIIlIlllIl);
            if (lllllllllllllllIlllIlIlIIlIllIIl.equals(lllllllllllllllIlllIlIlIIlIlllIl)) {
                return lllllllllllllllIlllIlIlIIlIlllll;
            }
            ClassInfo lllllllllllllllIlllIlIlIIlIllllI = lllllllllllllllIlllIlIlIIlIlllll.findInterface(lllllllllllllllIlllIlIlIIlIllIIl);
            if (lllllllllllllllIlllIlIlIIlIllllI == null) continue;
            return lllllllllllllllIlllIlIlIIlIllllI;
        }
        return null;
    }

    public boolean isMixin() {
        ClassInfo lllllllllllllllIlllIlIllIIlIlIIl;
        return lllllllllllllllIlllIlIllIIlIlIIl.isMixin;
    }

    public boolean hasSuperClass(ClassInfo lllllllllllllllIlllIlIlIlIlllIIl) {
        ClassInfo lllllllllllllllIlllIlIlIlIlllIlI;
        return lllllllllllllllIlllIlIlIlIlllIlI.hasSuperClass(lllllllllllllllIlllIlIlIlIlllIIl, Traversal.NONE, false);
    }

    public String getSuperName() {
        ClassInfo lllllllllllllllIlllIlIllIIIIIIll;
        return lllllllllllllllIlllIlIllIIIIIIll.superName;
    }

    void addInterface(String lllllllllllllllIlllIlIllIlIIIllI) {
        ClassInfo lllllllllllllllIlllIlIllIlIIIlIl;
        lllllllllllllllIlllIlIllIlIIIlIl.interfaces.add(lllllllllllllllIlllIlIllIlIIIllI);
        lllllllllllllllIlllIlIllIlIIIlIl.getSignature().addInterface(lllllllllllllllIlllIlIllIlIIIllI);
    }

    private ClassInfo addMethodsRecursive(Set<Method> lllllllllllllllIlllIlIlIllIlIlII, boolean lllllllllllllllIlllIlIlIllIlIIII) {
        ClassInfo lllllllllllllllIlllIlIlIllIlIIlI;
        if (lllllllllllllllIlllIlIlIllIlIIlI.isInterface) {
            for (Method lllllllllllllllIlllIlIlIllIllIII : lllllllllllllllIlllIlIlIllIlIIlI.methods) {
                if (!lllllllllllllllIlllIlIlIllIllIII.isAbstract()) {
                    lllllllllllllllIlllIlIlIllIlIlII.remove(lllllllllllllllIlllIlIlIllIllIII);
                }
                lllllllllllllllIlllIlIlIllIlIlII.add(lllllllllllllllIlllIlIlIllIllIII);
            }
        } else if (!lllllllllllllllIlllIlIlIllIlIIlI.isMixin && lllllllllllllllIlllIlIlIllIlIIII) {
            for (MixinInfo lllllllllllllllIlllIlIlIllIlIlll : lllllllllllllllIlllIlIlIllIlIIlI.mixins) {
                lllllllllllllllIlllIlIlIllIlIlll.getClassInfo().addMethodsRecursive(lllllllllllllllIlllIlIlIllIlIlII, lllllllllllllllIlllIlIlIllIlIIII);
            }
        }
        for (String lllllllllllllllIlllIlIlIllIlIllI : lllllllllllllllIlllIlIlIllIlIIlI.interfaces) {
            ClassInfo.forName(lllllllllllllllIlllIlIlIllIlIllI).addMethodsRecursive(lllllllllllllllIlllIlIlIllIlIlII, lllllllllllllllIlllIlIlIllIlIIII);
        }
        return lllllllllllllllIlllIlIlIllIlIIlI.getSuperClass();
    }

    public boolean hasSuperClass(String lllllllllllllllIlllIlIlIllIIIIII, Traversal lllllllllllllllIlllIlIlIllIIIIlI) {
        ClassInfo lllllllllllllllIlllIlIlIllIIIIIl;
        if ("java/lang/Object".equals(lllllllllllllllIlllIlIlIllIIIIII)) {
            return true;
        }
        return lllllllllllllllIlllIlIlIllIIIIIl.findSuperClass(lllllllllllllllIlllIlIlIllIIIIII, lllllllllllllllIlllIlIlIllIIIIlI) != null;
    }

    static ClassInfo fromClassNode(ClassNode lllllllllllllllIlllIlIIIlIlIllll) {
        ClassInfo lllllllllllllllIlllIlIIIlIlIlllI = cache.get(lllllllllllllllIlllIlIIIlIlIllll.name);
        if (lllllllllllllllIlllIlIIIlIlIlllI == null) {
            lllllllllllllllIlllIlIIIlIlIlllI = new ClassInfo(lllllllllllllllIlllIlIIIlIlIllll);
            cache.put(lllllllllllllllIlllIlIIIlIlIllll.name, lllllllllllllllIlllIlIIIlIlIlllI);
        }
        return lllllllllllllllIlllIlIIIlIlIlllI;
    }

    private <M extends Member> M findInHierarchy(String lllllllllllllllIlllIlIIlIllIIllI, String lllllllllllllllIlllIlIIlIllIIlIl, SearchType lllllllllllllllIlllIlIIlIllIIlII, Traversal lllllllllllllllIlllIlIIlIllIIIll, int lllllllllllllllIlllIlIIlIllIIIlI, Member.Type lllllllllllllllIlllIlIIlIllIlIIl) {
        ClassInfo lllllllllllllllIlllIlIIlIllIlIII;
        ClassInfo lllllllllllllllIlllIlIIlIllIIlll;
        if (lllllllllllllllIlllIlIIlIllIIlII == SearchType.ALL_CLASSES) {
            M lllllllllllllllIlllIlIIlIlllIlIl = lllllllllllllllIlllIlIIlIllIIlll.findMember(lllllllllllllllIlllIlIIlIllIIllI, lllllllllllllllIlllIlIIlIllIIlIl, lllllllllllllllIlllIlIIlIllIIIlI, lllllllllllllllIlllIlIIlIllIlIIl);
            if (lllllllllllllllIlllIlIIlIlllIlIl != null) {
                return lllllllllllllllIlllIlIIlIlllIlIl;
            }
            if (lllllllllllllllIlllIlIIlIllIIIll.canTraverse()) {
                for (MixinInfo lllllllllllllllIlllIlIIlIlllIllI : lllllllllllllllIlllIlIIlIllIIlll.mixins) {
                    M lllllllllllllllIlllIlIIlIlllIlll = lllllllllllllllIlllIlIIlIlllIllI.getClassInfo().findMember(lllllllllllllllIlllIlIIlIllIIllI, lllllllllllllllIlllIlIIlIllIIlIl, lllllllllllllllIlllIlIIlIllIIIlI, lllllllllllllllIlllIlIIlIllIlIIl);
                    if (lllllllllllllllIlllIlIIlIlllIlll == null) continue;
                    return lllllllllllllllIlllIlIIlIllIIlll.cloneMember(lllllllllllllllIlllIlIIlIlllIlll);
                }
            }
        }
        if ((lllllllllllllllIlllIlIIlIllIlIII = lllllllllllllllIlllIlIIlIllIIlll.getSuperClass()) != null) {
            for (ClassInfo lllllllllllllllIlllIlIIlIlllIIll : lllllllllllllllIlllIlIIlIllIlIII.getTargets()) {
                M lllllllllllllllIlllIlIIlIlllIlII = lllllllllllllllIlllIlIIlIlllIIll.findInHierarchy(lllllllllllllllIlllIlIIlIllIIllI, lllllllllllllllIlllIlIIlIllIIlIl, SearchType.ALL_CLASSES, lllllllllllllllIlllIlIIlIllIIIll.next(), lllllllllllllllIlllIlIIlIllIIIlI & 0xFFFFFFFD, lllllllllllllllIlllIlIIlIllIlIIl);
                if (lllllllllllllllIlllIlIIlIlllIlII == null) continue;
                return lllllllllllllllIlllIlIIlIlllIlII;
            }
        }
        if (lllllllllllllllIlllIlIIlIllIlIIl == Member.Type.METHOD && (lllllllllllllllIlllIlIIlIllIIlll.isInterface || MixinEnvironment.getCompatibilityLevel().supportsMethodsInInterfaces())) {
            for (String lllllllllllllllIlllIlIIlIlllIIII : lllllllllllllllIlllIlIIlIllIIlll.interfaces) {
                ClassInfo lllllllllllllllIlllIlIIlIlllIIlI = ClassInfo.forName(lllllllllllllllIlllIlIIlIlllIIII);
                if (lllllllllllllllIlllIlIIlIlllIIlI == null) {
                    logger.debug("Failed to resolve declared interface {} on {}", new Object[]{lllllllllllllllIlllIlIIlIlllIIII, lllllllllllllllIlllIlIIlIllIIlll.name});
                    continue;
                }
                M lllllllllllllllIlllIlIIlIlllIIIl = lllllllllllllllIlllIlIIlIlllIIlI.findInHierarchy(lllllllllllllllIlllIlIIlIllIIllI, lllllllllllllllIlllIlIIlIllIIlIl, SearchType.ALL_CLASSES, lllllllllllllllIlllIlIIlIllIIIll.next(), lllllllllllllllIlllIlIIlIllIIIlI & 0xFFFFFFFD, lllllllllllllllIlllIlIIlIllIlIIl);
                if (lllllllllllllllIlllIlIIlIlllIIIl == null) continue;
                return (M)(lllllllllllllllIlllIlIIlIllIIlll.isInterface ? lllllllllllllllIlllIlIIlIlllIIIl : lllllllllllllllIlllIlIIlIllIIlll.new InterfaceMethod((Member)lllllllllllllllIlllIlIIlIlllIIIl));
            }
        }
        return null;
    }

    public ClassInfo getOuterClass() {
        ClassInfo lllllllllllllllIlllIlIlIlllllIIl;
        if (lllllllllllllllIlllIlIlIlllllIIl.outerClass == null && lllllllllllllllIlllIlIlIlllllIIl.outerName != null) {
            lllllllllllllllIlllIlIlIlllllIIl.outerClass = ClassInfo.forName(lllllllllllllllIlllIlIlIlllllIIl.outerName);
        }
        return lllllllllllllllIlllIlIlIlllllIIl.outerClass;
    }

    public Field findFieldInHierarchy(FieldNode lllllllllllllllIlllIlIIlllIlIllI, SearchType lllllllllllllllIlllIlIIlllIlIIlI) {
        ClassInfo lllllllllllllllIlllIlIIlllIlIlII;
        return lllllllllllllllIlllIlIIlllIlIlII.findFieldInHierarchy(lllllllllllllllIlllIlIIlllIlIllI.name, lllllllllllllllIlllIlIIlllIlIllI.desc, lllllllllllllllIlllIlIIlllIlIIlI, Traversal.NONE);
    }

    private void addMethod(MethodNode lllllllllllllllIlllIlIllIIlllIIl, boolean lllllllllllllllIlllIlIllIIlllIII) {
        if (!lllllllllllllllIlllIlIllIIlllIIl.name.startsWith("<")) {
            ClassInfo lllllllllllllllIlllIlIllIIlllIlI;
            lllllllllllllllIlllIlIllIIlllIlI.methods.add(lllllllllllllllIlllIlIllIIlllIlI.new Method(lllllllllllllllIlllIlIllIIlllIIl, lllllllllllllllIlllIlIllIIlllIII));
        }
    }

    public ClassInfo findSuperClass(String lllllllllllllllIlllIlIlIlIIllllI) {
        ClassInfo lllllllllllllllIlllIlIlIlIlIIIIl;
        return lllllllllllllllIlllIlIlIlIlIIIIl.findSuperClass(lllllllllllllllIlllIlIlIlIIllllI, Traversal.NONE);
    }

    public ClassInfo findSuperClass(String lllllllllllllllIlllIlIlIlIIIllll, Traversal lllllllllllllllIlllIlIlIlIIIlllI, boolean lllllllllllllllIlllIlIlIlIIIlIIl) {
        ClassInfo lllllllllllllllIlllIlIlIlIIIllII;
        if (ClassInfo.OBJECT.name.equals(lllllllllllllllIlllIlIlIlIIIllll)) {
            return null;
        }
        return lllllllllllllllIlllIlIlIlIIIllII.findSuperClass(lllllllllllllllIlllIlIlIlIIIllll, lllllllllllllllIlllIlIlIlIIIlllI, lllllllllllllllIlllIlIlIlIIIlIIl, new HashSet<String>());
    }

    public ClassInfo getSuperClass() {
        ClassInfo lllllllllllllllIlllIlIlIllllllll;
        if (lllllllllllllllIlllIlIlIllllllll.superClass == null && lllllllllllllllIlllIlIlIllllllll.superName != null) {
            lllllllllllllllIlllIlIlIllllllll.superClass = ClassInfo.forName(lllllllllllllllIlllIlIlIllllllll.superName);
        }
        return lllllllllllllllIlllIlIlIllllllll.superClass;
    }

    private <M extends Member> M cloneMember(M lllllllllllllllIlllIlIIlIlIlIllI) {
        ClassInfo lllllllllllllllIlllIlIIlIlIllIIl;
        if (lllllllllllllllIlllIlIIlIlIlIllI instanceof Method) {
            return (M)lllllllllllllllIlllIlIIlIlIllIIl.new Method(lllllllllllllllIlllIlIIlIlIlIllI);
        }
        return (M)lllllllllllllllIlllIlIIlIlIllIIl.new Field(lllllllllllllllIlllIlIIlIlIlIllI);
    }

    public Field findField(String lllllllllllllllIlllIlIIIlllllIII, String lllllllllllllllIlllIlIIIllllIlll, int lllllllllllllllIlllIlIIIlllllIlI) {
        ClassInfo lllllllllllllllIlllIlIIIlllllIIl;
        return (Field)lllllllllllllllIlllIlIIIlllllIIl.findMember(lllllllllllllllIlllIlIIIlllllIII, lllllllllllllllIlllIlIIIllllIlll, lllllllllllllllIlllIlIIIlllllIlI, Member.Type.FIELD);
    }

    public boolean hasMixinInHierarchy() {
        ClassInfo lllllllllllllllIlllIlIlIIIlllIIl;
        if (!lllllllllllllllIlllIlIlIIIlllIIl.isMixin) {
            return false;
        }
        for (ClassInfo lllllllllllllllIlllIlIlIIIlllIlI = lllllllllllllllIlllIlIlIIIlllIIl.getSuperClass(); lllllllllllllllIlllIlIlIIIlllIlI != null && lllllllllllllllIlllIlIlIIIlllIlI != OBJECT; lllllllllllllllIlllIlIlIIIlllIlI = lllllllllllllllIlllIlIlIIIlllIlI.getSuperClass()) {
            if (!lllllllllllllllIlllIlIlIIIlllIlI.isMixin) continue;
            return true;
        }
        return false;
    }

    public Method findMethodInHierarchy(String lllllllllllllllIlllIlIIlllIlllll, String lllllllllllllllIlllIlIIlllIllllI, SearchType lllllllllllllllIlllIlIIlllIlllIl, Traversal lllllllllllllllIlllIlIIlllIlllII, int lllllllllllllllIlllIlIIllllIIIIl) {
        ClassInfo lllllllllllllllIlllIlIIllllIIIII;
        return (Method)lllllllllllllllIlllIlIIllllIIIII.findInHierarchy(lllllllllllllllIlllIlIIlllIlllll, lllllllllllllllIlllIlIIlllIllllI, lllllllllllllllIlllIlIIlllIlllIl, lllllllllllllllIlllIlIIlllIlllII, lllllllllllllllIlllIlIIllllIIIIl, Member.Type.METHOD);
    }

    public Method findMethod(MethodNode lllllllllllllllIlllIlIIlIlIIlIll, int lllllllllllllllIlllIlIIlIlIIlIlI) {
        ClassInfo lllllllllllllllIlllIlIIlIlIIllII;
        return lllllllllllllllIlllIlIIlIlIIllII.findMethod(lllllllllllllllIlllIlIIlIlIIlIll.name, lllllllllllllllIlllIlIIlIlIIlIll.desc, lllllllllllllllIlllIlIIlIlIIlIlI);
    }

    public Method findMethod(MethodNode lllllllllllllllIlllIlIIlIlIlIIII) {
        ClassInfo lllllllllllllllIlllIlIIlIlIlIIll;
        return lllllllllllllllIlllIlIIlIlIlIIll.findMethod(lllllllllllllllIlllIlIIlIlIlIIII.name, lllllllllllllllIlllIlIIlIlIlIIII.desc, lllllllllllllllIlllIlIIlIlIlIIII.access);
    }

    public Field findFieldInHierarchy(String lllllllllllllllIlllIlIIllIlIlIll, String lllllllllllllllIlllIlIIllIlIIllI, SearchType lllllllllllllllIlllIlIIllIlIlIIl) {
        ClassInfo lllllllllllllllIlllIlIIllIlIllII;
        return lllllllllllllllIlllIlIIllIlIllII.findFieldInHierarchy(lllllllllllllllIlllIlIIllIlIlIll, lllllllllllllllIlllIlIIllIlIIllI, lllllllllllllllIlllIlIIllIlIlIIl, Traversal.NONE);
    }

    public Method findMethodInHierarchy(MethodInsnNode lllllllllllllllIlllIlIlIIIIIlllI, SearchType lllllllllllllllIlllIlIlIIIIIllIl, int lllllllllllllllIlllIlIlIIIIIllII) {
        ClassInfo lllllllllllllllIlllIlIlIIIIIlIll;
        return lllllllllllllllIlllIlIlIIIIIlIll.findMethodInHierarchy(lllllllllllllllIlllIlIlIIIIIlllI.name, lllllllllllllllIlllIlIlIIIIIlllI.desc, lllllllllllllllIlllIlIlIIIIIllIl, Traversal.NONE, lllllllllllllllIlllIlIlIIIIIllII);
    }

    public Field findFieldInHierarchy(FieldInsnNode lllllllllllllllIlllIlIIlllIIIIIl, SearchType lllllllllllllllIlllIlIIllIllllIl) {
        ClassInfo lllllllllllllllIlllIlIIlllIIIIlI;
        return lllllllllllllllIlllIlIIlllIIIIlI.findFieldInHierarchy(lllllllllllllllIlllIlIIlllIIIIIl.name, lllllllllllllllIlllIlIIlllIIIIIl.desc, lllllllllllllllIlllIlIIllIllllIl, Traversal.NONE);
    }

    public Field findField(FieldInsnNode lllllllllllllllIlllIlIIlIIIlIIlI, int lllllllllllllllIlllIlIIlIIIlIIII) {
        ClassInfo lllllllllllllllIlllIlIIlIIIlIlII;
        return lllllllllllllllIlllIlIIlIIIlIlII.findField(lllllllllllllllIlllIlIIlIIIlIIlI.name, lllllllllllllllIlllIlIIlIIIlIIlI.desc, lllllllllllllllIlllIlIIlIIIlIIII);
    }

    public Set<MixinInfo> getMixins() {
        ClassInfo lllllllllllllllIlllIlIllIIlIllII;
        return Collections.unmodifiableSet(lllllllllllllllIlllIlIllIIlIllII.mixins);
    }

    public Set<Method> getInterfaceMethods(boolean lllllllllllllllIlllIlIlIlllIIIIl) {
        ClassInfo lllllllllllllllIlllIlIlIlllIIllI;
        HashSet<Method> lllllllllllllllIlllIlIlIlllIIlII = new HashSet<Method>();
        if (!lllllllllllllllIlllIlIlIlllIIllI.isInterface) {
            for (ClassInfo lllllllllllllllIlllIlIlIlllIIIll = lllllllllllllllIlllIlIlIlllIIllI.addMethodsRecursive(lllllllllllllllIlllIlIlIlllIIlII, lllllllllllllllIlllIlIlIlllIIIIl); lllllllllllllllIlllIlIlIlllIIIll != null && lllllllllllllllIlllIlIlIlllIIIll != OBJECT; lllllllllllllllIlllIlIlIlllIIIll = lllllllllllllllIlllIlIlIlllIIIll.addMethodsRecursive(lllllllllllllllIlllIlIlIlllIIlII, lllllllllllllllIlllIlIlIlllIIIIl)) {
            }
        }
        Iterator lllllllllllllllIlllIlIlIlllIIlll = lllllllllllllllIlllIlIlIlllIIlII.iterator();
        while (lllllllllllllllIlllIlIlIlllIIlll.hasNext()) {
            if (((Method)lllllllllllllllIlllIlIlIlllIIlll.next()).isAbstract()) continue;
            lllllllllllllllIlllIlIlIlllIIlll.remove();
        }
        return Collections.unmodifiableSet(lllllllllllllllIlllIlIlIlllIIlII);
    }

    public boolean equals(Object lllllllllllllllIlllIlIIIlIllIlll) {
        ClassInfo lllllllllllllllIlllIlIIIlIllIllI;
        if (!(lllllllllllllllIlllIlIIIlIllIlll instanceof ClassInfo)) {
            return false;
        }
        return ((ClassInfo)lllllllllllllllIlllIlIIIlIllIlll).name.equals(lllllllllllllllIlllIlIIIlIllIllI.name);
    }

    public boolean isAbstract() {
        ClassInfo lllllllllllllllIlllIlIllIIlIIlII;
        return (lllllllllllllllIlllIlIllIIlIIlII.access & 0x400) != 0;
    }

    private ClassInfo findSuperClass(String lllllllllllllllIlllIlIlIIllIllll, Traversal lllllllllllllllIlllIlIlIIlllIlII, boolean lllllllllllllllIlllIlIlIIlllIIll, Set<String> lllllllllllllllIlllIlIlIIlllIIlI) {
        ClassInfo lllllllllllllllIlllIlIlIIllllIll;
        ClassInfo lllllllllllllllIlllIlIlIIlllIIII;
        ClassInfo lllllllllllllllIlllIlIlIIlllIIIl = lllllllllllllllIlllIlIlIIlllIIII.getSuperClass();
        if (lllllllllllllllIlllIlIlIIlllIIIl != null) {
            for (ClassInfo lllllllllllllllIlllIlIlIIlllllII : lllllllllllllllIlllIlIlIIlllIIIl.getTargets()) {
                if (lllllllllllllllIlllIlIlIIllIllll.equals(lllllllllllllllIlllIlIlIIlllllII.getName())) {
                    return lllllllllllllllIlllIlIlIIlllIIIl;
                }
                ClassInfo lllllllllllllllIlllIlIlIIlllllIl = lllllllllllllllIlllIlIlIIlllllII.findSuperClass(lllllllllllllllIlllIlIlIIllIllll, lllllllllllllllIlllIlIlIIlllIlII.next(), lllllllllllllllIlllIlIlIIlllIIll, lllllllllllllllIlllIlIlIIlllIIlI);
                if (lllllllllllllllIlllIlIlIIlllllIl == null) continue;
                return lllllllllllllllIlllIlIlIIlllllIl;
            }
        }
        if (lllllllllllllllIlllIlIlIIlllIIll && (lllllllllllllllIlllIlIlIIllllIll = lllllllllllllllIlllIlIlIIlllIIII.findInterface(lllllllllllllllIlllIlIlIIllIllll)) != null) {
            return lllllllllllllllIlllIlIlIIllllIll;
        }
        if (lllllllllllllllIlllIlIlIIlllIlII.canTraverse()) {
            for (MixinInfo lllllllllllllllIlllIlIlIIlllIlll : lllllllllllllllIlllIlIlIIlllIIII.mixins) {
                String lllllllllllllllIlllIlIlIIllllIlI = lllllllllllllllIlllIlIlIIlllIlll.getClassName();
                if (lllllllllllllllIlllIlIlIIlllIIlI.contains(lllllllllllllllIlllIlIlIIllllIlI)) continue;
                lllllllllllllllIlllIlIlIIlllIIlI.add(lllllllllllllllIlllIlIlIIllllIlI);
                ClassInfo lllllllllllllllIlllIlIlIIllllIIl = lllllllllllllllIlllIlIlIIlllIlll.getClassInfo();
                if (lllllllllllllllIlllIlIlIIllIllll.equals(lllllllllllllllIlllIlIlIIllllIIl.getName())) {
                    return lllllllllllllllIlllIlIlIIllllIIl;
                }
                ClassInfo lllllllllllllllIlllIlIlIIllllIII = lllllllllllllllIlllIlIlIIllllIIl.findSuperClass(lllllllllllllllIlllIlIlIIllIllll, Traversal.ALL, lllllllllllllllIlllIlIlIIlllIIll, lllllllllllllllIlllIlIlIIlllIIlI);
                if (lllllllllllllllIlllIlIlIIllllIII == null) continue;
                return lllllllllllllllIlllIlIlIIllllIII;
            }
        }
        return null;
    }

    public Field findFieldInHierarchy(String lllllllllllllllIlllIlIIllIIIlIII, String lllllllllllllllIlllIlIIllIIIllIl, SearchType lllllllllllllllIlllIlIIllIIIIllI, Traversal lllllllllllllllIlllIlIIllIIIlIll, int lllllllllllllllIlllIlIIllIIIIlII) {
        ClassInfo lllllllllllllllIlllIlIIllIIIllll;
        return (Field)lllllllllllllllIlllIlIIllIIIllll.findInHierarchy(lllllllllllllllIlllIlIIllIIIlIII, lllllllllllllllIlllIlIIllIIIllIl, lllllllllllllllIlllIlIIllIIIIllI, lllllllllllllllIlllIlIIllIIIlIll, lllllllllllllllIlllIlIIllIIIIlII, Member.Type.FIELD);
    }

    public boolean hasSuperClass(String lllllllllllllllIlllIlIlIllIIlIII) {
        ClassInfo lllllllllllllllIlllIlIlIllIIlIll;
        return lllllllllllllllIlllIlIlIllIIlIll.hasSuperClass(lllllllllllllllIlllIlIlIllIIlIII, Traversal.NONE);
    }

    public Field findFieldInHierarchy(String lllllllllllllllIlllIlIIllIIllllI, String lllllllllllllllIlllIlIIllIIllIII, SearchType lllllllllllllllIlllIlIIllIIlllII, Traversal lllllllllllllllIlllIlIIllIIlIllI) {
        ClassInfo lllllllllllllllIlllIlIIllIIllIlI;
        return lllllllllllllllIlllIlIIllIIllIlI.findFieldInHierarchy(lllllllllllllllIlllIlIIllIIllllI, lllllllllllllllIlllIlIIllIIllIII, lllllllllllllllIlllIlIIllIIlllII, lllllllllllllllIlllIlIIllIIlIllI, 0);
    }

    public String getName() {
        ClassInfo lllllllllllllllIlllIlIllIIIIlIIl;
        return lllllllllllllllIlllIlIllIIIIlIIl.name;
    }

    public MethodMapper getMethodMapper() {
        ClassInfo lllllllllllllllIlllIlIllIIIIlllI;
        return lllllllllllllllIlllIlIllIIIIlllI.methodMapper;
    }

    public Method findMethod(String lllllllllllllllIlllIlIIlIIllIIlI, String lllllllllllllllIlllIlIIlIIlIlIIl, int lllllllllllllllIlllIlIIlIIlIllll) {
        ClassInfo lllllllllllllllIlllIlIIlIIllIIll;
        return (Method)lllllllllllllllIlllIlIIlIIllIIll.findMember(lllllllllllllllIlllIlIIlIIllIIlI, lllllllllllllllIlllIlIIlIIlIlIIl, lllllllllllllllIlllIlIIlIIlIllll, Member.Type.METHOD);
    }

    public Method findMethodInHierarchy(MethodNode lllllllllllllllIlllIlIlIIIlIlIlI, SearchType lllllllllllllllIlllIlIlIIIlIlIIl) {
        ClassInfo lllllllllllllllIlllIlIlIIIlIlIll;
        return lllllllllllllllIlllIlIlIIIlIlIll.findMethodInHierarchy(lllllllllllllllIlllIlIlIIIlIlIlI.name, lllllllllllllllIlllIlIlIIIlIlIlI.desc, lllllllllllllllIlllIlIlIIIlIlIIl, Traversal.NONE);
    }

    public boolean hasMixinTargetInHierarchy() {
        ClassInfo lllllllllllllllIlllIlIlIIIllIIll;
        if (lllllllllllllllIlllIlIlIIIllIIll.isMixin) {
            return false;
        }
        for (ClassInfo lllllllllllllllIlllIlIlIIIllIlII = lllllllllllllllIlllIlIlIIIllIIll.getSuperClass(); lllllllllllllllIlllIlIlIIIllIlII != null && lllllllllllllllIlllIlIlIIIllIlII != OBJECT; lllllllllllllllIlllIlIlIIIllIlII = lllllllllllllllIlllIlIlIIIllIlII.getSuperClass()) {
            if (lllllllllllllllIlllIlIlIIIllIlII.mixins.size() <= 0) continue;
            return true;
        }
        return false;
    }

    List<ClassInfo> getTargets() {
        ClassInfo lllllllllllllllIlllIlIlIllllIIlI;
        if (lllllllllllllllIlllIlIlIllllIIlI.mixin != null) {
            ArrayList<ClassInfo> lllllllllllllllIlllIlIlIllllIIll = new ArrayList<ClassInfo>();
            lllllllllllllllIlllIlIlIllllIIll.add(lllllllllllllllIlllIlIlIllllIIlI);
            lllllllllllllllIlllIlIlIllllIIll.addAll(lllllllllllllllIlllIlIlIllllIIlI.mixin.getTargets());
            return lllllllllllllllIlllIlIlIllllIIll;
        }
        return ImmutableList.of((Object)lllllllllllllllIlllIlIlIllllIIlI);
    }

    private ClassInfo() {
        ClassInfo lllllllllllllllIlllIlIllIllIIIIl;
        lllllllllllllllIlllIlIllIllIIIIl.mixins = new HashSet<MixinInfo>();
        lllllllllllllllIlllIlIllIllIIIIl.correspondingTypes = new HashMap<ClassInfo, ClassInfo>();
        lllllllllllllllIlllIlIllIllIIIIl.name = "java/lang/Object";
        lllllllllllllllIlllIlIllIllIIIIl.superName = null;
        lllllllllllllllIlllIlIllIllIIIIl.outerName = null;
        lllllllllllllllIlllIlIllIllIIIIl.isProbablyStatic = true;
        lllllllllllllllIlllIlIllIllIIIIl.methods = ImmutableSet.of((Object)lllllllllllllllIlllIlIllIllIIIIl.new Method("getClass", "()Ljava/lang/Class;"), (Object)lllllllllllllllIlllIlIllIllIIIIl.new Method("hashCode", "()I"), (Object)lllllllllllllllIlllIlIllIllIIIIl.new Method("equals", "(Ljava/lang/Object;)Z"), (Object)lllllllllllllllIlllIlIllIllIIIIl.new Method("clone", "()Ljava/lang/Object;"), (Object)lllllllllllllllIlllIlIllIllIIIIl.new Method("toString", "()Ljava/lang/String;"), (Object)lllllllllllllllIlllIlIllIllIIIIl.new Method("notify", "()V"), (Object[])new Method[]{lllllllllllllllIlllIlIllIllIIIIl.new Method("notifyAll", "()V"), lllllllllllllllIlllIlIllIllIIIIl.new Method("wait", "(J)V"), lllllllllllllllIlllIlIllIllIIIIl.new Method("wait", "(JI)V"), lllllllllllllllIlllIlIllIllIIIIl.new Method("wait", "()V"), lllllllllllllllIlllIlIllIllIIIIl.new Method("finalize", "()V")});
        lllllllllllllllIlllIlIllIllIIIIl.fields = Collections.emptySet();
        lllllllllllllllIlllIlIllIllIIIIl.isInterface = false;
        lllllllllllllllIlllIlIllIllIIIIl.interfaces = Collections.emptySet();
        lllllllllllllllIlllIlIllIllIIIIl.access = 1;
        lllllllllllllllIlllIlIllIllIIIIl.isMixin = false;
        lllllllllllllllIlllIlIllIllIIIIl.mixin = null;
        lllllllllllllllIlllIlIllIllIIIIl.methodMapper = null;
    }

    void addMethod(MethodNode lllllllllllllllIlllIlIllIIlllllI) {
        ClassInfo lllllllllllllllIlllIlIllIIllllll;
        lllllllllllllllIlllIlIllIIllllll.addMethod(lllllllllllllllIlllIlIllIIlllllI, true);
    }

    private static ClassInfo getCommonSuperClass(ClassInfo lllllllllllllllIlllIlIIIIlIlllIl, ClassInfo lllllllllllllllIlllIlIIIIlIlllII) {
        return ClassInfo.getCommonSuperClass(lllllllllllllllIlllIlIIIIlIlllIl, lllllllllllllllIlllIlIIIIlIlllII, false);
    }

    public static enum Traversal {
        NONE(null, false, SearchType.SUPER_CLASSES_ONLY),
        ALL(null, true, SearchType.ALL_CLASSES),
        IMMEDIATE(NONE, true, SearchType.SUPER_CLASSES_ONLY),
        SUPER(ALL, false, SearchType.SUPER_CLASSES_ONLY);

        private final /* synthetic */ boolean traverse;
        private final /* synthetic */ Traversal next;
        private final /* synthetic */ SearchType searchType;

        private Traversal(Traversal llllllllllllllllIIlllIIIIIlIlllI, boolean llllllllllllllllIIlllIIIIIlIllIl, SearchType llllllllllllllllIIlllIIIIIllIIlI) {
            Traversal llllllllllllllllIIlllIIIIIllIIIl;
            llllllllllllllllIIlllIIIIIllIIIl.next = llllllllllllllllIIlllIIIIIlIlllI != null ? llllllllllllllllIIlllIIIIIlIlllI : llllllllllllllllIIlllIIIIIllIIIl;
            llllllllllllllllIIlllIIIIIllIIIl.traverse = llllllllllllllllIIlllIIIIIlIllIl;
            llllllllllllllllIIlllIIIIIllIIIl.searchType = llllllllllllllllIIlllIIIIIllIIlI;
        }

        public boolean canTraverse() {
            Traversal llllllllllllllllIIlllIIIIIlIIlll;
            return llllllllllllllllIIlllIIIIIlIIlll.traverse;
        }

        public SearchType getSearchType() {
            Traversal llllllllllllllllIIlllIIIIIlIIIll;
            return llllllllllllllllIIlllIIIIIlIIIll.searchType;
        }

        public Traversal next() {
            Traversal llllllllllllllllIIlllIIIIIlIlIIl;
            return llllllllllllllllIIlllIIIIIlIlIIl.next;
        }
    }

    public static class FrameData {
        public final /* synthetic */ int index;
        private static final /* synthetic */ String[] FRAMETYPES;
        public final /* synthetic */ int locals;
        public final /* synthetic */ int type;

        public String toString() {
            FrameData llllllllllllllllIIIIIIIIlIllllll;
            return String.format("FrameData[index=%d, type=%s, locals=%d]", llllllllllllllllIIIIIIIIlIllllll.index, FRAMETYPES[llllllllllllllllIIIIIIIIlIllllll.type + 1], llllllllllllllllIIIIIIIIlIllllll.locals);
        }

        static {
            FRAMETYPES = new String[]{"NEW", "FULL", "APPEND", "CHOP", "SAME", "SAME1"};
        }

        FrameData(int llllllllllllllllIIIIIIIIllIIllII, int llllllllllllllllIIIIIIIIllIIlIll, int llllllllllllllllIIIIIIIIllIIlllI) {
            FrameData llllllllllllllllIIIIIIIIllIIllIl;
            llllllllllllllllIIIIIIIIllIIllIl.index = llllllllllllllllIIIIIIIIllIIllII;
            llllllllllllllllIIIIIIIIllIIllIl.type = llllllllllllllllIIIIIIIIllIIlIll;
            llllllllllllllllIIIIIIIIllIIllIl.locals = llllllllllllllllIIIIIIIIllIIlllI;
        }

        FrameData(int llllllllllllllllIIIIIIIIllIIIIlI, FrameNode llllllllllllllllIIIIIIIIllIIIlII) {
            FrameData llllllllllllllllIIIIIIIIllIIIllI;
            llllllllllllllllIIIIIIIIllIIIllI.index = llllllllllllllllIIIIIIIIllIIIIlI;
            llllllllllllllllIIIIIIIIllIIIllI.type = llllllllllllllllIIIIIIIIllIIIlII.type;
            llllllllllllllllIIIIIIIIllIIIllI.locals = llllllllllllllllIIIIIIIIllIIIlII.local != null ? llllllllllllllllIIIIIIIIllIIIlII.local.size() : 0;
        }
    }

    class Field
    extends Member {
        @Override
        public boolean equals(Object lIlIlllIIIIIIlI) {
            Field lIlIlllIIIIIlIl;
            if (!(lIlIlllIIIIIIlI instanceof Field)) {
                return false;
            }
            return super.equals(lIlIlllIIIIIIlI);
        }

        @Override
        public ClassInfo getOwner() {
            Field lIlIlllIIIIlIIl;
            return lIlIlllIIIIlIIl.ClassInfo.this;
        }

        @Override
        protected String getDisplayFormat() {
            return "%s:%s";
        }

        public Field(FieldNode lIlIlllIIllIIll, boolean lIlIlllIIllIIlI) {
            Field lIlIlllIIllIIIl;
            super(Member.Type.FIELD, lIlIlllIIllIIll.name, lIlIlllIIllIIll.desc, lIlIlllIIllIIll.access, lIlIlllIIllIIlI);
            lIlIlllIIllIIIl.setUnique(Annotations.getVisible(lIlIlllIIllIIll, Unique.class) != null);
            if (Annotations.getVisible(lIlIlllIIllIIll, Shadow.class) != null) {
                boolean lIlIlllIIllIlll = Annotations.getVisible(lIlIlllIIllIIll, Final.class) != null;
                boolean lIlIlllIIllIllI = Annotations.getVisible(lIlIlllIIllIIll, Mutable.class) != null;
                lIlIlllIIllIIIl.setDecoratedFinal(lIlIlllIIllIlll, lIlIlllIIllIllI);
            }
        }

        public Field(String lIlIlllIIlIIlII, String lIlIlllIIIllllI, int lIlIlllIIIlllIl) {
            Field lIlIlllIIlIIllI;
            super(Member.Type.FIELD, lIlIlllIIlIIlII, lIlIlllIIIllllI, lIlIlllIIIlllIl, false);
        }

        public Field(Member lIlIlllIlIIlIlI) {
            Field lIlIlllIlIIllII;
            super(lIlIlllIlIIlIlI);
        }

        public Field(FieldNode lIlIlllIlIIIIIl) {
            lIlIlllIlIIIIll(lIlIlllIlIIIIIl, false);
            Field lIlIlllIlIIIIll;
        }

        public Field(String lIlIlllIIIlIlII, String lIlIlllIIIIllIl, int lIlIlllIIIlIIlI, boolean lIlIlllIIIIlIll) {
            Field lIlIlllIIIlIllI;
            super(Member.Type.FIELD, lIlIlllIIIlIlII, lIlIlllIIIIllIl, lIlIlllIIIlIIlI, lIlIlllIIIIlIll);
        }
    }

    public class InterfaceMethod
    extends Method {
        private final /* synthetic */ ClassInfo owner;

        @Override
        public ClassInfo getImplementor() {
            InterfaceMethod lllllllllllllllIllllIlIIIlIlIIII;
            return lllllllllllllllIllllIlIIIlIlIIII.ClassInfo.this;
        }

        @Override
        public ClassInfo getOwner() {
            InterfaceMethod lllllllllllllllIllllIlIIIlIlIIll;
            return lllllllllllllllIllllIlIIIlIlIIll.owner;
        }

        public InterfaceMethod(Member lllllllllllllllIllllIlIIIlIllIIl) {
            InterfaceMethod lllllllllllllllIllllIlIIIlIllIll;
            super(lllllllllllllllIllllIlIIIlIllIIl);
            lllllllllllllllIllllIlIIIlIllIll.owner = lllllllllllllllIllllIlIIIlIllIIl.getOwner();
        }
    }

    static abstract class Member {
        private /* synthetic */ String currentName;
        private /* synthetic */ boolean unique;
        private final /* synthetic */ int modifiers;
        private /* synthetic */ boolean decoratedMutable;
        private final /* synthetic */ boolean isInjected;
        private final /* synthetic */ String memberName;
        private final /* synthetic */ String memberDesc;
        private final /* synthetic */ Type type;
        private /* synthetic */ String currentDesc;
        private /* synthetic */ boolean decoratedFinal;

        public String remapTo(String lllIIIllIIlIlll) {
            lllIIIllIIllIII.currentDesc = lllIIIllIIlIlll;
            return lllIIIllIIlIlll;
        }

        protected Member(Type lllIIlIIIIIIlIl, String lllIIlIIIIIIlII, String lllIIlIIIIIIIll, int lllIIIlllllllIl) {
            lllIIlIIIIIIllI(lllIIlIIIIIIlIl, lllIIlIIIIIIlII, lllIIlIIIIIIIll, lllIIIlllllllIl, false);
            Member lllIIlIIIIIIllI;
        }

        public boolean equals(Object lllIIIllIIIlIIl) {
            Member lllIIIllIIIIlll;
            if (!(lllIIIllIIIlIIl instanceof Member)) {
                return false;
            }
            Member lllIIIllIIIlIII = (Member)lllIIIllIIIlIIl;
            return !(!lllIIIllIIIlIII.memberName.equals(lllIIIllIIIIlll.memberName) && !lllIIIllIIIlIII.currentName.equals(lllIIIllIIIIlll.currentName) || !lllIIIllIIIlIII.memberDesc.equals(lllIIIllIIIIlll.memberDesc) && !lllIIIllIIIlIII.currentDesc.equals(lllIIIllIIIIlll.currentDesc));
        }

        public boolean isUnique() {
            Member lllIIIlllIIIlIl;
            return lllIIIlllIIIlIl.unique;
        }

        public ClassInfo getImplementor() {
            Member lllIIIllIlIIlll;
            return lllIIIllIlIIlll.getOwner();
        }

        public boolean isInjected() {
            Member lllIIIlllIlllIl;
            return lllIIIlllIlllIl.isInjected;
        }

        protected String getDisplayFormat() {
            return "%s%s";
        }

        public abstract ClassInfo getOwner();

        public boolean equals(String lllIIIllIIIllll, String lllIIIllIIIlllI) {
            Member lllIIIllIIlIIll;
            return !(!lllIIIllIIlIIll.memberName.equals(lllIIIllIIIllll) && !lllIIIllIIlIIll.currentName.equals(lllIIIllIIIllll) || !lllIIIllIIlIIll.memberDesc.equals(lllIIIllIIIlllI) && !lllIIIllIIlIIll.currentDesc.equals(lllIIIllIIIlllI));
        }

        public void setUnique(boolean lllIIIlllIIIIII) {
            lllIIIllIllllll.unique = lllIIIlllIIIIII;
        }

        public int hashCode() {
            Member lllIIIllIIIIIll;
            return lllIIIllIIIIIll.toString().hashCode();
        }

        protected Member(Type lllIIIlllllIlIl, String lllIIIlllllIlII, String lllIIIlllllIIll, int lllIIIlllllIIlI, boolean lllIIIlllllIIIl) {
            Member lllIIIlllllIllI;
            lllIIIlllllIllI.type = lllIIIlllllIlIl;
            lllIIIlllllIllI.memberName = lllIIIlllllIlII;
            lllIIIlllllIllI.memberDesc = lllIIIlllllIIll;
            lllIIIlllllIllI.isInjected = lllIIIlllllIIIl;
            lllIIIlllllIllI.currentName = lllIIIlllllIlII;
            lllIIIlllllIllI.currentDesc = lllIIIlllllIIll;
            lllIIIlllllIllI.modifiers = lllIIIlllllIIlI;
        }

        public String getOriginalDesc() {
            Member lllIIIllllIIIll;
            return lllIIIllllIIIll.memberDesc;
        }

        public boolean isStatic() {
            Member lllIIIlllIlIIIl;
            return (lllIIIlllIlIIIl.modifiers & 8) != 0;
        }

        protected Member(Member lllIIlIIIIIllII) {
            lllIIlIIIIIllIl(lllIIlIIIIIllII.type, lllIIlIIIIIllII.memberName, lllIIlIIIIIllII.memberDesc, lllIIlIIIIIllII.modifiers, lllIIlIIIIIllII.isInjected);
            Member lllIIlIIIIIllIl;
            lllIIlIIIIIllIl.currentName = lllIIlIIIIIllII.currentName;
            lllIIlIIIIIllIl.currentDesc = lllIIlIIIIIllII.currentDesc;
            lllIIlIIIIIllIl.unique = lllIIlIIIIIllII.unique;
        }

        public boolean isRenamed() {
            Member lllIIIlllIllIIl;
            return !lllIIIlllIllIIl.currentName.equals(lllIIIlllIllIIl.memberName);
        }

        public void setDecoratedFinal(boolean lllIIIllIllIIII, boolean lllIIIllIlIllll) {
            lllIIIllIllIlII.decoratedFinal = lllIIIllIllIIII;
            lllIIIllIllIlII.decoratedMutable = lllIIIllIlIllll;
        }

        public String getName() {
            Member lllIIIllllIIlIl;
            return lllIIIllllIIlIl.currentName;
        }

        public String getDesc() {
            Member lllIIIlllIlllll;
            return lllIIIlllIlllll.currentDesc;
        }

        public boolean isPrivate() {
            Member lllIIIlllIlIlII;
            return (lllIIIlllIlIlII.modifiers & 2) != 0;
        }

        public int getAccess() {
            Member lllIIIllIlIIIll;
            return lllIIIllIlIIIll.modifiers;
        }

        public boolean isRemapped() {
            Member lllIIIlllIlIllI;
            return !lllIIIlllIlIllI.currentDesc.equals(lllIIIlllIlIllI.memberDesc);
        }

        public boolean isFinal() {
            Member lllIIIlllIIlIll;
            return (lllIIIlllIIlIll.modifiers & 0x10) != 0;
        }

        public String getOriginalName() {
            Member lllIIIllllIlIIl;
            return lllIIIllllIlIIl.memberName;
        }

        public String toString() {
            Member lllIIIllIIIIIII;
            return String.format(lllIIIllIIIIIII.getDisplayFormat(), lllIIIllIIIIIII.memberName, lllIIIllIIIIIII.memberDesc);
        }

        public boolean isAbstract() {
            Member lllIIIlllIIlllI;
            return (lllIIIlllIIlllI.modifiers & 0x400) != 0;
        }

        public boolean isDecoratedFinal() {
            Member lllIIIllIlllIll;
            return lllIIIllIlllIll.decoratedFinal;
        }

        public boolean isDecoratedMutable() {
            Member lllIIIllIlllIIl;
            return lllIIIllIlllIIl.decoratedMutable;
        }

        public String renameTo(String lllIIIllIIlllIl) {
            lllIIIllIlIIIII.currentName = lllIIIllIIlllIl;
            return lllIIIllIIlllIl;
        }

        public boolean isSynthetic() {
            Member lllIIIlllIIIlll;
            return (lllIIIlllIIIlll.modifiers & 0x1000) != 0;
        }

        public boolean matchesFlags(int lllIIIllIlIlIll) {
            Member lllIIIllIlIllII;
            return ((~lllIIIllIlIllII.modifiers | lllIIIllIlIlIll & 2) & 2) != 0 && ((~lllIIIllIlIllII.modifiers | lllIIIllIlIlIll & 8) & 8) != 0;
        }

        static enum Type {
            METHOD,
            FIELD;


            private Type() {
                Type llIIIIllIllllIl;
            }
        }
    }

    public class Method
    extends Member {
        private final /* synthetic */ List<FrameData> frames;
        private /* synthetic */ boolean isAccessor;

        public List<FrameData> getFrames() {
            Method llllllllllllllllIlIlIlIIlIlIIIll;
            return llllllllllllllllIlIlIlIIlIlIIIll.frames;
        }

        public Method(String llllllllllllllllIlIlIlIIlIllIlIl, String llllllllllllllllIlIlIlIIlIlllIlI, int llllllllllllllllIlIlIlIIlIlllIIl, boolean llllllllllllllllIlIlIlIIlIlllIII) {
            Method llllllllllllllllIlIlIlIIlIllllIl;
            super(Member.Type.METHOD, llllllllllllllllIlIlIlIIlIllIlIl, llllllllllllllllIlIlIlIIlIlllIlI, llllllllllllllllIlIlIlIIlIlllIIl, llllllllllllllllIlIlIlIIlIlllIII);
            llllllllllllllllIlIlIlIIlIllllIl.frames = null;
        }

        public Method(String llllllllllllllllIlIlIlIIllIllIII, String llllllllllllllllIlIlIlIIllIlIlll) {
            Method llllllllllllllllIlIlIlIIllIlIllI;
            super(Member.Type.METHOD, llllllllllllllllIlIlIlIIllIllIII, llllllllllllllllIlIlIlIIllIlIlll, 1, false);
            llllllllllllllllIlIlIlIIllIlIllI.frames = null;
        }

        public Method(String llllllllllllllllIlIlIlIIllIIIllI, String llllllllllllllllIlIlIlIIllIIlIlI, int llllllllllllllllIlIlIlIIllIIlIIl) {
            Method llllllllllllllllIlIlIlIIllIIllIl;
            super(Member.Type.METHOD, llllllllllllllllIlIlIlIIllIIIllI, llllllllllllllllIlIlIlIIllIIlIlI, llllllllllllllllIlIlIlIIllIIlIIl, false);
            llllllllllllllllIlIlIlIIllIIllIl.frames = null;
        }

        @Override
        public boolean equals(Object llllllllllllllllIlIlIlIIlIIllIII) {
            Method llllllllllllllllIlIlIlIIlIIlIlll;
            if (!(llllllllllllllllIlIlIlIIlIIllIII instanceof Method)) {
                return false;
            }
            return super.equals(llllllllllllllllIlIlIlIIlIIllIII);
        }

        @Override
        public ClassInfo getOwner() {
            Method llllllllllllllllIlIlIlIIlIIlllll;
            return llllllllllllllllIlIlIlIIlIIlllll.ClassInfo.this;
        }

        private List<FrameData> gatherFrames(MethodNode llllllllllllllllIlIlIlIIlIlIlIII) {
            ArrayList<FrameData> llllllllllllllllIlIlIlIIlIlIlIIl = new ArrayList<FrameData>();
            ListIterator<AbstractInsnNode> llllllllllllllllIlIlIlIIlIlIllII = llllllllllllllllIlIlIlIIlIlIlIII.instructions.iterator();
            while (llllllllllllllllIlIlIlIIlIlIllII.hasNext()) {
                AbstractInsnNode llllllllllllllllIlIlIlIIlIlIllIl = (AbstractInsnNode)llllllllllllllllIlIlIlIIlIlIllII.next();
                if (!(llllllllllllllllIlIlIlIIlIlIllIl instanceof FrameNode)) continue;
                llllllllllllllllIlIlIlIIlIlIlIIl.add(new FrameData(llllllllllllllllIlIlIlIIlIlIlIII.instructions.indexOf(llllllllllllllllIlIlIlIIlIlIllIl), (FrameNode)llllllllllllllllIlIlIlIIlIlIllIl));
            }
            return llllllllllllllllIlIlIlIIlIlIlIIl;
        }

        public Method(MethodNode llllllllllllllllIlIlIlIIlllIIIII, boolean llllllllllllllllIlIlIlIIlllIIIll) {
            Method llllllllllllllllIlIlIlIIlllIIllI;
            super(Member.Type.METHOD, llllllllllllllllIlIlIlIIlllIIIII.name, llllllllllllllllIlIlIlIIlllIIIII.desc, llllllllllllllllIlIlIlIIlllIIIII.access, llllllllllllllllIlIlIlIIlllIIIll);
            llllllllllllllllIlIlIlIIlllIIllI.frames = llllllllllllllllIlIlIlIIlllIIllI.gatherFrames(llllllllllllllllIlIlIlIIlllIIIII);
            llllllllllllllllIlIlIlIIlllIIllI.setUnique(Annotations.getVisible(llllllllllllllllIlIlIlIIlllIIIII, Unique.class) != null);
            llllllllllllllllIlIlIlIIlllIIllI.isAccessor = Annotations.getSingleVisible(llllllllllllllllIlIlIlIIlllIIIII, Accessor.class, Invoker.class) != null;
        }

        public Method(Member llllllllllllllllIlIlIlIIllllIlll) {
            Method llllllllllllllllIlIlIlIIllllIllI;
            super(llllllllllllllllIlIlIlIIllllIlll);
            llllllllllllllllIlIlIlIIllllIllI.frames = llllllllllllllllIlIlIlIIllllIlll instanceof Method ? ((Method)llllllllllllllllIlIlIlIIllllIlll).frames : null;
        }

        public Method(MethodNode llllllllllllllllIlIlIlIIlllIlllI) {
            llllllllllllllllIlIlIlIIllllIIII(llllllllllllllllIlIlIlIIlllIlllI, false);
            Method llllllllllllllllIlIlIlIIllllIIII;
            llllllllllllllllIlIlIlIIllllIIII.setUnique(Annotations.getVisible(llllllllllllllllIlIlIlIIlllIlllI, Unique.class) != null);
            llllllllllllllllIlIlIlIIllllIIII.isAccessor = Annotations.getSingleVisible(llllllllllllllllIlIlIlIIlllIlllI, Accessor.class, Invoker.class) != null;
        }

        public boolean isAccessor() {
            Method llllllllllllllllIlIlIlIIlIIlllIl;
            return llllllllllllllllIlIlIlIIlIIlllIl.isAccessor;
        }
    }

    public static enum SearchType {
        ALL_CLASSES,
        SUPER_CLASSES_ONLY;


        private SearchType() {
            SearchType llllllllllllllllIIllIllllIllIlII;
        }
    }
}

