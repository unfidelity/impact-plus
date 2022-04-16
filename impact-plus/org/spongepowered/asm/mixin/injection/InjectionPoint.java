/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Joiner
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.ImmutableList$Builder
 *  org.apache.logging.log4j.LogManager
 */
package org.spongepowered.asm.mixin.injection;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.spongepowered.asm.lib.tree.AbstractInsnNode;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.InsnList;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.IInjectionPointContext;
import org.spongepowered.asm.mixin.injection.modify.AfterStoreLocal;
import org.spongepowered.asm.mixin.injection.modify.BeforeLoadLocal;
import org.spongepowered.asm.mixin.injection.points.AfterInvoke;
import org.spongepowered.asm.mixin.injection.points.BeforeConstant;
import org.spongepowered.asm.mixin.injection.points.BeforeFieldAccess;
import org.spongepowered.asm.mixin.injection.points.BeforeFinalReturn;
import org.spongepowered.asm.mixin.injection.points.BeforeInvoke;
import org.spongepowered.asm.mixin.injection.points.BeforeNew;
import org.spongepowered.asm.mixin.injection.points.BeforeReturn;
import org.spongepowered.asm.mixin.injection.points.BeforeStringInvoke;
import org.spongepowered.asm.mixin.injection.points.JumpInsnPoint;
import org.spongepowered.asm.mixin.injection.points.MethodHead;
import org.spongepowered.asm.mixin.injection.struct.InjectionPointData;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;

public abstract class InjectionPoint {
    private static /* synthetic */ Map<String, Class<? extends InjectionPoint>> types;
    private final /* synthetic */ Selector selector;
    private final /* synthetic */ String slice;
    public static final /* synthetic */ int DEFAULT_ALLOWED_SHIFT_BY;
    public static final /* synthetic */ int MAX_ALLOWED_SHIFT_BY;
    private final /* synthetic */ String id;

    private static void validateByValue(IMixinContext llllllllllllllllIlllllIIllIIIlll, MethodNode llllllllllllllllIlllllIIlIIlIlIl, AnnotationNode llllllllllllllllIlllllIIlIllllll, InjectionPoint llllllllllllllllIlllllIIlIIIllIl, int llllllllllllllllIlllllIIlIlllIll) {
        MixinEnvironment llllllllllllllllIlllllIIlIlIlIII = llllllllllllllllIlllllIIllIIIlll.getMixin().getConfig().getEnvironment();
        ShiftByViolationBehaviour llllllllllllllllIlllllIIlIlIIlII = llllllllllllllllIlllllIIlIlIlIII.getOption(MixinEnvironment.Option.SHIFT_BY_VIOLATION_BEHAVIOUR, ShiftByViolationBehaviour.WARN);
        if (llllllllllllllllIlllllIIlIlIIlII == ShiftByViolationBehaviour.IGNORE) {
            return;
        }
        int llllllllllllllllIlllllIIlIlIIIII = 0;
        if (llllllllllllllllIlllllIIllIIIlll instanceof MixinTargetContext) {
            llllllllllllllllIlllllIIlIlIIIII = ((MixinTargetContext)llllllllllllllllIlllllIIllIIIlll).getMaxShiftByValue();
        }
        if (llllllllllllllllIlllllIIlIlllIll <= llllllllllllllllIlllllIIlIlIIIII) {
            return;
        }
        String llllllllllllllllIlllllIIlIIlllII = String.format("@%s(%s) Shift.BY=%d on %s::%s exceeds the maximum allowed value %d.", Bytecode.getSimpleName(llllllllllllllllIlllllIIlIllllll), llllllllllllllllIlllllIIlIIIllIl, llllllllllllllllIlllllIIlIlllIll, llllllllllllllllIlllllIIllIIIlll, llllllllllllllllIlllllIIlIIlIlIl.name, llllllllllllllllIlllllIIlIlIIIII);
        if (llllllllllllllllIlllllIIlIlIIlII == ShiftByViolationBehaviour.WARN) {
            LogManager.getLogger((String)"mixin").warn("{} Increase the value of maxShiftBy to suppress this warning.", new Object[]{llllllllllllllllIlllllIIlIIlllII});
            return;
        }
        throw new InvalidInjectionException(llllllllllllllllIlllllIIllIIIlll, llllllllllllllllIlllllIIlIIlllII);
    }

    protected String getAtCode() {
        InjectionPoint llllllllllllllllIlllllIIIllIlIlI;
        AtCode llllllllllllllllIlllllIIIllIlIll = llllllllllllllllIlllllIIIllIlIlI.getClass().getAnnotation(AtCode.class);
        return llllllllllllllllIlllllIIIllIlIll == null ? llllllllllllllllIlllllIIIllIlIlI.getClass().getName() : llllllllllllllllIlllllIIIllIlIll.value();
    }

    public static InjectionPoint parse(IInjectionPointContext llllllllllllllllIlllllllIlllIIll, At llllllllllllllllIlllllllIlllIlIl) {
        return InjectionPoint.parse(llllllllllllllllIlllllllIlllIIll.getContext(), llllllllllllllllIlllllllIlllIIll.getMethod(), llllllllllllllllIlllllllIlllIIll.getAnnotation(), llllllllllllllllIlllllllIlllIlIl.value(), llllllllllllllllIlllllllIlllIlIl.shift(), llllllllllllllllIlllllllIlllIlIl.by(), Arrays.asList(llllllllllllllllIlllllllIlllIlIl.args()), llllllllllllllllIlllllllIlllIlIl.target(), llllllllllllllllIlllllllIlllIlIl.slice(), llllllllllllllllIlllllllIlllIlIl.ordinal(), llllllllllllllllIlllllllIlllIlIl.opcode(), llllllllllllllllIlllllllIlllIlIl.id());
    }

    public static List<InjectionPoint> parse(IMixinContext llllllllllllllllIllllllllIIIllIl, MethodNode llllllllllllllllIllllllllIIIlIll, AnnotationNode llllllllllllllllIllllllllIIlIIIl, List<AnnotationNode> llllllllllllllllIllllllllIIIIlll) {
        ImmutableList.Builder llllllllllllllllIllllllllIIIllll = ImmutableList.builder();
        for (AnnotationNode llllllllllllllllIllllllllIIlIlIl : llllllllllllllllIllllllllIIIIlll) {
            InjectionPoint llllllllllllllllIllllllllIIllIIl = InjectionPoint.parse(llllllllllllllllIllllllllIIIllIl, llllllllllllllllIllllllllIIIlIll, llllllllllllllllIllllllllIIlIIIl, llllllllllllllllIllllllllIIlIlIl);
            if (llllllllllllllllIllllllllIIllIIl == null) continue;
            llllllllllllllllIllllllllIIIllll.add((Object)llllllllllllllllIllllllllIIllIIl);
        }
        return llllllllllllllllIllllllllIIIllll.build();
    }

    public String getId() {
        InjectionPoint llllllllllllllllIllllllllllllIII;
        return llllllllllllllllIllllllllllllIII.id;
    }

    public static InjectionPoint or(InjectionPoint ... llllllllllllllllIlllllllllIlIlll) {
        return new Union(llllllllllllllllIlllllllllIlIlll);
    }

    public static List<InjectionPoint> parse(IInjectionPointContext llllllllllllllllIllllllllIllIllI, List<AnnotationNode> llllllllllllllllIllllllllIllIlII) {
        return InjectionPoint.parse(llllllllllllllllIllllllllIllIllI.getContext(), llllllllllllllllIllllllllIllIllI.getMethod(), llllllllllllllllIllllllllIllIllI.getAnnotation(), llllllllllllllllIllllllllIllIlII);
    }

    public static InjectionPoint parse(IMixinContext llllllllllllllllIlllllllIllIIIII, MethodNode llllllllllllllllIlllllllIlIllllI, AnnotationNode llllllllllllllllIlllllllIllIIlII, At llllllllllllllllIlllllllIlIllIlI) {
        return InjectionPoint.parse(llllllllllllllllIlllllllIllIIIII, llllllllllllllllIlllllllIlIllllI, llllllllllllllllIlllllllIllIIlII, llllllllllllllllIlllllllIlIllIlI.value(), llllllllllllllllIlllllllIlIllIlI.shift(), llllllllllllllllIlllllllIlIllIlI.by(), Arrays.asList(llllllllllllllllIlllllllIlIllIlI.args()), llllllllllllllllIlllllllIlIllIlI.target(), llllllllllllllllIlllllllIlIllIlI.slice(), llllllllllllllllIlllllllIlIllIlI.ordinal(), llllllllllllllllIlllllllIlIllIlI.opcode(), llllllllllllllllIlllllllIlIllIlI.id());
    }

    public static InjectionPoint parse(IInjectionPointContext llllllllllllllllIlllllllIlIIllII, AnnotationNode llllllllllllllllIlllllllIlIIlIlI) {
        return InjectionPoint.parse(llllllllllllllllIlllllllIlIIllII.getContext(), llllllllllllllllIlllllllIlIIllII.getMethod(), llllllllllllllllIlllllllIlIIllII.getAnnotation(), llllllllllllllllIlllllllIlIIlIlI);
    }

    protected InjectionPoint() {
        lllllllllllllllllIIIIIIIIIIlIIlI("", Selector.DEFAULT, null);
        InjectionPoint lllllllllllllllllIIIIIIIIIIlIIlI;
    }

    public Selector getSelector() {
        InjectionPoint llllllllllllllllIllllllllllllIlI;
        return llllllllllllllllIllllllllllllIlI.selector;
    }

    public InjectionPoint(String lllllllllllllllllIIIIIIIIIIIIIlI, Selector lllllllllllllllllIIIIIIIIIIIIIIl, String lllllllllllllllllIIIIIIIIIIIIlII) {
        InjectionPoint lllllllllllllllllIIIIIIIIIIIIIll;
        lllllllllllllllllIIIIIIIIIIIIIll.slice = lllllllllllllllllIIIIIIIIIIIIIlI;
        lllllllllllllllllIIIIIIIIIIIIIll.selector = lllllllllllllllllIIIIIIIIIIIIIIl;
        lllllllllllllllllIIIIIIIIIIIIIll.id = lllllllllllllllllIIIIIIIIIIIIlII;
    }

    protected static AbstractInsnNode nextNode(InsnList llllllllllllllllIllllllllllIIllI, AbstractInsnNode llllllllllllllllIllllllllllIlIlI) {
        int llllllllllllllllIllllllllllIlIII = llllllllllllllllIllllllllllIIllI.indexOf(llllllllllllllllIllllllllllIlIlI) + 1;
        if (llllllllllllllllIllllllllllIlIII > 0 && llllllllllllllllIllllllllllIlIII < llllllllllllllllIllllllllllIIllI.size()) {
            return llllllllllllllllIllllllllllIIllI.get(llllllllllllllllIllllllllllIlIII);
        }
        return llllllllllllllllIllllllllllIlIlI;
    }

    protected InjectionPoint(InjectionPointData lllllllllllllllllIIIIIIIIIIIlllI) {
        lllllllllllllllllIIIIIIIIIIIllIl(lllllllllllllllllIIIIIIIIIIIlllI.getSlice(), lllllllllllllllllIIIIIIIIIIIlllI.getSelector(), lllllllllllllllllIIIIIIIIIIIlllI.getId());
        InjectionPoint lllllllllllllllllIIIIIIIIIIIllIl;
    }

    public static InjectionPoint before(InjectionPoint llllllllllllllllIlllllllllIIlIll) {
        return new Shift(llllllllllllllllIlllllllllIIlIll, -1);
    }

    public static InjectionPoint and(InjectionPoint ... llllllllllllllllIlllllllllIllllI) {
        return new Intersection(llllllllllllllllIlllllllllIllllI);
    }

    public abstract boolean find(String var1, InsnList var2, Collection<AbstractInsnNode> var3);

    private static Class<? extends InjectionPoint> findClass(IMixinContext llllllllllllllllIllllllIIIlIlIll, InjectionPointData llllllllllllllllIllllllIIIllIIll) {
        String llllllllllllllllIllllllIIIllIIII = llllllllllllllllIllllllIIIllIIll.getType();
        Class<InjectionPoint> llllllllllllllllIllllllIIIlIlllI = types.get(llllllllllllllllIllllllIIIllIIII);
        if (llllllllllllllllIllllllIIIlIlllI == null) {
            if (llllllllllllllllIllllllIIIllIIII.matches("^([A-Za-z_][A-Za-z0-9_]*\\.)+[A-Za-z_][A-Za-z0-9_]*$")) {
                try {
                    llllllllllllllllIllllllIIIlIlllI = Class.forName(llllllllllllllllIllllllIIIllIIII);
                    types.put(llllllllllllllllIllllllIIIllIIII, llllllllllllllllIllllllIIIlIlllI);
                }
                catch (Exception llllllllllllllllIllllllIIIlllIII) {
                    throw new InvalidInjectionException(llllllllllllllllIllllllIIIlIlIll, String.valueOf(new StringBuilder().append(llllllllllllllllIllllllIIIllIIll).append(" could not be loaded or is not a valid InjectionPoint")), (Throwable)llllllllllllllllIllllllIIIlllIII);
                }
            } else {
                throw new InvalidInjectionException(llllllllllllllllIllllllIIIlIlIll, String.valueOf(new StringBuilder().append(llllllllllllllllIllllllIIIllIIll).append(" is not a valid injection point specifier")));
            }
        }
        return llllllllllllllllIllllllIIIlIlllI;
    }

    public static InjectionPoint parse(IMixinContext llllllllllllllllIllllllIlIIlIllI, MethodNode llllllllllllllllIllllllIlIIlIlII, AnnotationNode llllllllllllllllIllllllIlIllIlIl, String llllllllllllllllIllllllIlIIlIIII, At.Shift llllllllllllllllIllllllIlIlIlllI, int llllllllllllllllIllllllIlIlIlIll, List<String> llllllllllllllllIllllllIlIIIlIII, String llllllllllllllllIllllllIlIlIlIIl, String llllllllllllllllIllllllIlIIIIllI, int llllllllllllllllIllllllIlIlIIIIl, int llllllllllllllllIllllllIlIIIIIll, String llllllllllllllllIllllllIlIIIIIIl) {
        InjectionPointData llllllllllllllllIllllllIlIIllIll = new InjectionPointData(llllllllllllllllIllllllIlIIlIllI, llllllllllllllllIllllllIlIIlIlII, llllllllllllllllIllllllIlIllIlIl, llllllllllllllllIllllllIlIIlIIII, llllllllllllllllIllllllIlIIIlIII, llllllllllllllllIllllllIlIlIlIIl, llllllllllllllllIllllllIlIIIIllI, llllllllllllllllIllllllIlIlIIIIl, llllllllllllllllIllllllIlIIIIIll, llllllllllllllllIllllllIlIIIIIIl);
        Class<? extends InjectionPoint> llllllllllllllllIllllllIlIIllIIl = InjectionPoint.findClass(llllllllllllllllIllllllIlIIlIllI, llllllllllllllllIllllllIlIIllIll);
        InjectionPoint llllllllllllllllIllllllIlIIllIII = InjectionPoint.create(llllllllllllllllIllllllIlIIlIllI, llllllllllllllllIllllllIlIIllIll, llllllllllllllllIllllllIlIIllIIl);
        return InjectionPoint.shift(llllllllllllllllIllllllIlIIlIllI, llllllllllllllllIllllllIlIIlIlII, llllllllllllllllIllllllIlIllIlIl, llllllllllllllllIllllllIlIIllIII, llllllllllllllllIllllllIlIlIlllI, llllllllllllllllIllllllIlIlIlIll);
    }

    public static InjectionPoint parse(IMixinContext llllllllllllllllIlllllllIIIIlIlI, MethodNode llllllllllllllllIlllllllIIIIlIII, AnnotationNode llllllllllllllllIlllllllIIIllIIl, AnnotationNode llllllllllllllllIlllllllIIIIIIIl) {
        String llllllllllllllllIlllllllIIIlIlIl = (String)Annotations.getValue(llllllllllllllllIlllllllIIIIIIIl, "value");
        List llllllllllllllllIlllllllIIIlIlII = (List)Annotations.getValue(llllllllllllllllIlllllllIIIIIIIl, "args");
        String llllllllllllllllIlllllllIIIlIIlI = Annotations.getValue(llllllllllllllllIlllllllIIIIIIIl, "target", "");
        String llllllllllllllllIlllllllIIIlIIIl = Annotations.getValue(llllllllllllllllIlllllllIIIIIIIl, "slice", "");
        At.Shift llllllllllllllllIlllllllIIIlIIII = Annotations.getValue(llllllllllllllllIlllllllIIIIIIIl, "shift", At.Shift.class, At.Shift.NONE);
        int llllllllllllllllIlllllllIIIIllll = Annotations.getValue(llllllllllllllllIlllllllIIIIIIIl, "by", 0);
        int llllllllllllllllIlllllllIIIIlllI = Annotations.getValue(llllllllllllllllIlllllllIIIIIIIl, "ordinal", -1);
        int llllllllllllllllIlllllllIIIIllIl = Annotations.getValue(llllllllllllllllIlllllllIIIIIIIl, "opcode", 0);
        String llllllllllllllllIlllllllIIIIllII = (String)Annotations.getValue(llllllllllllllllIlllllllIIIIIIIl, "id");
        if (llllllllllllllllIlllllllIIIlIlII == null) {
            llllllllllllllllIlllllllIIIlIlII = ImmutableList.of();
        }
        return InjectionPoint.parse(llllllllllllllllIlllllllIIIIlIlI, llllllllllllllllIlllllllIIIIlIII, llllllllllllllllIlllllllIIIllIIl, llllllllllllllllIlllllllIIIlIlIl, llllllllllllllllIlllllllIIIlIIII, llllllllllllllllIlllllllIIIIllll, llllllllllllllllIlllllllIIIlIlII, llllllllllllllllIlllllllIIIlIIlI, llllllllllllllllIlllllllIIIlIIIl, llllllllllllllllIlllllllIIIIlllI, llllllllllllllllIlllllllIIIIllIl, llllllllllllllllIlllllllIIIIllII);
    }

    private static InjectionPoint shift(IMixinContext llllllllllllllllIlllllIlIlllIIlI, MethodNode llllllllllllllllIlllllIlIlIlIlII, AnnotationNode llllllllllllllllIlllllIlIllIllIl, InjectionPoint llllllllllllllllIlllllIlIlIIlllI, At.Shift llllllllllllllllIlllllIlIllIIlIl, int llllllllllllllllIlllllIlIlIIlIlI) {
        if (llllllllllllllllIlllllIlIlIIlllI != null) {
            if (llllllllllllllllIlllllIlIllIIlIl == At.Shift.BEFORE) {
                return InjectionPoint.before(llllllllllllllllIlllllIlIlIIlllI);
            }
            if (llllllllllllllllIlllllIlIllIIlIl == At.Shift.AFTER) {
                return InjectionPoint.after(llllllllllllllllIlllllIlIlIIlllI);
            }
            if (llllllllllllllllIlllllIlIllIIlIl == At.Shift.BY) {
                InjectionPoint.validateByValue(llllllllllllllllIlllllIlIlllIIlI, llllllllllllllllIlllllIlIlIlIlII, llllllllllllllllIlllllIlIllIllIl, llllllllllllllllIlllllIlIlIIlllI, llllllllllllllllIlllllIlIlIIlIlI);
                return InjectionPoint.shift(llllllllllllllllIlllllIlIlIIlllI, llllllllllllllllIlllllIlIlIIlIlI);
            }
        }
        return llllllllllllllllIlllllIlIlIIlllI;
    }

    public String toString() {
        InjectionPoint llllllllllllllllIlllllllllllIlIl;
        return String.format("@At(\"%s\")", llllllllllllllllIlllllllllllIlIl.getAtCode());
    }

    public static InjectionPoint after(InjectionPoint llllllllllllllllIlllllllllIlIIII) {
        return new Shift(llllllllllllllllIlllllllllIlIIII, 1);
    }

    public static InjectionPoint shift(InjectionPoint llllllllllllllllIlllllllllIIIIII, int llllllllllllllllIllllllllIllllII) {
        return new Shift(llllllllllllllllIlllllllllIIIIII, llllllllllllllllIllllllllIllllII);
    }

    private static InjectionPoint create(IMixinContext llllllllllllllllIlllllIlllIIllIl, InjectionPointData llllllllllllllllIlllllIlllIIlIll, Class<? extends InjectionPoint> llllllllllllllllIlllllIlllIIlIIl) {
        Constructor<? extends InjectionPoint> llllllllllllllllIlllllIlllIIIlll = null;
        try {
            llllllllllllllllIlllllIlllIIIlll = llllllllllllllllIlllllIlllIIlIIl.getDeclaredConstructor(InjectionPointData.class);
            llllllllllllllllIlllllIlllIIIlll.setAccessible(true);
        }
        catch (NoSuchMethodException llllllllllllllllIlllllIlllIllIlI) {
            throw new InvalidInjectionException(llllllllllllllllIlllllIlllIIllIl, String.valueOf(new StringBuilder().append(llllllllllllllllIlllllIlllIIlIIl.getName()).append(" must contain a constructor which accepts an InjectionPointData")), (Throwable)llllllllllllllllIlllllIlllIllIlI);
        }
        InjectionPoint llllllllllllllllIlllllIlllIIIllI = null;
        try {
            llllllllllllllllIlllllIlllIIIllI = llllllllllllllllIlllllIlllIIIlll.newInstance(llllllllllllllllIlllllIlllIIlIll);
        }
        catch (Exception llllllllllllllllIlllllIlllIlIIII) {
            throw new InvalidInjectionException(llllllllllllllllIlllllIlllIIllIl, String.valueOf(new StringBuilder().append("Error whilst instancing injection point ").append(llllllllllllllllIlllllIlllIIlIIl.getName()).append(" for ").append(llllllllllllllllIlllllIlllIIlIll.getAt())), (Throwable)llllllllllllllllIlllllIlllIlIIII);
        }
        return llllllllllllllllIlllllIlllIIIllI;
    }

    public String getSlice() {
        InjectionPoint llllllllllllllllIllllllllllllllI;
        return llllllllllllllllIllllllllllllllI.slice;
    }

    public static void register(Class<? extends InjectionPoint> llllllllllllllllIlllllIIIIIlIlII) {
        AtCode llllllllllllllllIlllllIIIIIlIlll = llllllllllllllllIlllllIIIIIlIlII.getAnnotation(AtCode.class);
        if (llllllllllllllllIlllllIIIIIlIlll == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("Injection point class ").append(llllllllllllllllIlllllIIIIIlIlII).append(" is not annotated with @AtCode")));
        }
        Class<? extends InjectionPoint> llllllllllllllllIlllllIIIIIlIlIl = types.get(llllllllllllllllIlllllIIIIIlIlll.value());
        if (llllllllllllllllIlllllIIIIIlIlIl != null && !llllllllllllllllIlllllIIIIIlIlIl.equals(llllllllllllllllIlllllIIIIIlIlII)) {
            LogManager.getLogger((String)"mixin").debug("Overriding InjectionPoint {} with {} (previously {})", new Object[]{llllllllllllllllIlllllIIIIIlIlll.value(), llllllllllllllllIlllllIIIIIlIlII.getName(), llllllllllllllllIlllllIIIIIlIlIl.getName()});
        }
        types.put(llllllllllllllllIlllllIIIIIlIlll.value(), llllllllllllllllIlllllIIIIIlIlII);
    }

    static {
        MAX_ALLOWED_SHIFT_BY = 0;
        DEFAULT_ALLOWED_SHIFT_BY = 0;
        types = new HashMap<String, Class<? extends InjectionPoint>>();
        InjectionPoint.register(BeforeFieldAccess.class);
        InjectionPoint.register(BeforeInvoke.class);
        InjectionPoint.register(BeforeNew.class);
        InjectionPoint.register(BeforeReturn.class);
        InjectionPoint.register(BeforeStringInvoke.class);
        InjectionPoint.register(JumpInsnPoint.class);
        InjectionPoint.register(MethodHead.class);
        InjectionPoint.register(AfterInvoke.class);
        InjectionPoint.register(BeforeLoadLocal.class);
        InjectionPoint.register(AfterStoreLocal.class);
        InjectionPoint.register(BeforeFinalReturn.class);
        InjectionPoint.register(BeforeConstant.class);
    }

    static abstract class CompositeInjectionPoint
    extends InjectionPoint {
        protected final /* synthetic */ InjectionPoint[] components;

        @Override
        public String toString() {
            CompositeInjectionPoint llllIIIlllI;
            return String.valueOf(new StringBuilder().append("CompositeInjectionPoint(").append(llllIIIlllI.getClass().getSimpleName()).append(")[").append(Joiner.on((char)',').join((Object[])llllIIIlllI.components)).append("]"));
        }

        protected CompositeInjectionPoint(InjectionPoint ... llllIIlIIIl) {
            CompositeInjectionPoint llllIIlIlII;
            if (llllIIlIIIl == null || llllIIlIIIl.length < 2) {
                throw new IllegalArgumentException("Must supply two or more component injection points for composite point!");
            }
            llllIIlIlII.components = llllIIlIIIl;
        }
    }

    public static enum Selector {
        FIRST,
        LAST,
        ONE;

        public static final /* synthetic */ Selector DEFAULT;

        private Selector() {
            Selector lllllllllllllllIlllIllllIlIIlllI;
        }

        static {
            DEFAULT = FIRST;
        }
    }

    @Retention(value=RetentionPolicy.RUNTIME)
    @Target(value={ElementType.TYPE})
    public static @interface AtCode {
        public String value();
    }

    static final class Intersection
    extends CompositeInjectionPoint {
        public Intersection(InjectionPoint ... llIlIlIIIIlIIlI) {
            super(llIlIlIIIIlIIlI);
            Intersection llIlIlIIIIlIIll;
        }

        @Override
        public boolean find(String llIlIIllllllllI, InsnList llIlIIlllllllIl, Collection<AbstractInsnNode> llIlIIlllllllII) {
            Intersection llIlIIlllllllll;
            boolean llIlIIllllllIll = false;
            ArrayList[] llIlIIllllllIlI = (ArrayList[])Array.newInstance(ArrayList.class, llIlIIlllllllll.components.length);
            for (int llIlIlIIIIIIlII = 0; llIlIlIIIIIIlII < llIlIIlllllllll.components.length; ++llIlIlIIIIIIlII) {
                llIlIIllllllIlI[llIlIlIIIIIIlII] = new ArrayList();
                llIlIIlllllllll.components[llIlIlIIIIIIlII].find(llIlIIllllllllI, llIlIIlllllllIl, llIlIIllllllIlI[llIlIlIIIIIIlII]);
            }
            ArrayList llIlIIllllllIIl = llIlIIllllllIlI[0];
            for (int llIlIlIIIIIIIII = 0; llIlIlIIIIIIIII < llIlIIllllllIIl.size(); ++llIlIlIIIIIIIII) {
                AbstractInsnNode llIlIlIIIIIIIlI = (AbstractInsnNode)llIlIIllllllIIl.get(llIlIlIIIIIIIII);
                boolean llIlIlIIIIIIIIl = true;
                for (int llIlIlIIIIIIIll = 1; llIlIlIIIIIIIll < llIlIIllllllIlI.length && llIlIIllllllIlI[llIlIlIIIIIIIll].contains(llIlIlIIIIIIIlI); ++llIlIlIIIIIIIll) {
                }
                if (!llIlIlIIIIIIIIl) continue;
                llIlIIlllllllII.add(llIlIlIIIIIIIlI);
                llIlIIllllllIll = true;
            }
            return llIlIIllllllIll;
        }
    }

    static final class Union
    extends CompositeInjectionPoint {
        @Override
        public boolean find(String lllllllllllllllllIIlIlIIIllIllII, InsnList lllllllllllllllllIIlIlIIIllIlIlI, Collection<AbstractInsnNode> lllllllllllllllllIIlIlIIIlllIIIl) {
            Union lllllllllllllllllIIlIlIIIllIlllI;
            LinkedHashSet<AbstractInsnNode> lllllllllllllllllIIlIlIIIllIllll = new LinkedHashSet<AbstractInsnNode>();
            for (int lllllllllllllllllIIlIlIIIllllIlI = 0; lllllllllllllllllIIlIlIIIllllIlI < lllllllllllllllllIIlIlIIIllIlllI.components.length; ++lllllllllllllllllIIlIlIIIllllIlI) {
                lllllllllllllllllIIlIlIIIllIlllI.components[lllllllllllllllllIIlIlIIIllllIlI].find(lllllllllllllllllIIlIlIIIllIllII, lllllllllllllllllIIlIlIIIllIlIlI, lllllllllllllllllIIlIlIIIllIllll);
            }
            lllllllllllllllllIIlIlIIIlllIIIl.addAll(lllllllllllllllllIIlIlIIIllIllll);
            return lllllllllllllllllIIlIlIIIllIllll.size() > 0;
        }

        public Union(InjectionPoint ... lllllllllllllllllIIlIlIIlIIlIlll) {
            super(lllllllllllllllllIIlIlIIlIIlIlll);
            Union lllllllllllllllllIIlIlIIlIIllIll;
        }
    }

    static enum ShiftByViolationBehaviour {
        IGNORE,
        WARN,
        ERROR;


        private ShiftByViolationBehaviour() {
            ShiftByViolationBehaviour llllllllllllllllIlIIllIllIIlIlll;
        }
    }

    static final class Shift
    extends InjectionPoint {
        private final /* synthetic */ int shift;
        private final /* synthetic */ InjectionPoint input;

        public Shift(InjectionPoint llllllllllllllllIlllIIlIllIIIllI, int llllllllllllllllIlllIIlIllIIIlIl) {
            Shift llllllllllllllllIlllIIlIllIIIlll;
            if (llllllllllllllllIlllIIlIllIIIllI == null) {
                throw new IllegalArgumentException("Must supply an input injection point for SHIFT");
            }
            llllllllllllllllIlllIIlIllIIIlll.input = llllllllllllllllIlllIIlIllIIIllI;
            llllllllllllllllIlllIIlIllIIIlll.shift = llllllllllllllllIlllIIlIllIIIlIl;
        }

        @Override
        public boolean find(String llllllllllllllllIlllIIlIlIIllllI, InsnList llllllllllllllllIlllIIlIlIIllIll, Collection<AbstractInsnNode> llllllllllllllllIlllIIlIlIIllIIl) {
            Shift llllllllllllllllIlllIIlIlIlIIlll;
            List<Object> llllllllllllllllIlllIIlIlIlIIIlI = llllllllllllllllIlllIIlIlIIllIIl instanceof List ? (List<Object>)llllllllllllllllIlllIIlIlIIllIIl : new ArrayList<AbstractInsnNode>(llllllllllllllllIlllIIlIlIIllIIl);
            llllllllllllllllIlllIIlIlIlIIlll.input.find(llllllllllllllllIlllIIlIlIIllllI, llllllllllllllllIlllIIlIlIIllIll, llllllllllllllllIlllIIlIlIIllIIl);
            for (int llllllllllllllllIlllIIlIlIlIlllI = 0; llllllllllllllllIlllIIlIlIlIlllI < llllllllllllllllIlllIIlIlIlIIIlI.size(); ++llllllllllllllllIlllIIlIlIlIlllI) {
                llllllllllllllllIlllIIlIlIlIIIlI.set(llllllllllllllllIlllIIlIlIlIlllI, llllllllllllllllIlllIIlIlIIllIll.get(llllllllllllllllIlllIIlIlIIllIll.indexOf((AbstractInsnNode)llllllllllllllllIlllIIlIlIlIIIlI.get(llllllllllllllllIlllIIlIlIlIlllI)) + llllllllllllllllIlllIIlIlIlIIlll.shift));
            }
            if (llllllllllllllllIlllIIlIlIIllIIl != llllllllllllllllIlllIIlIlIlIIIlI) {
                llllllllllllllllIlllIIlIlIIllIIl.clear();
                llllllllllllllllIlllIIlIlIIllIIl.addAll((Collection<AbstractInsnNode>)llllllllllllllllIlllIIlIlIlIIIlI);
            }
            return llllllllllllllllIlllIIlIlIIllIIl.size() > 0;
        }

        @Override
        public String toString() {
            Shift llllllllllllllllIlllIIlIlIllllll;
            return String.valueOf(new StringBuilder().append("InjectionPoint(").append(llllllllllllllllIlllIIlIlIllllll.getClass().getSimpleName()).append(")[").append(llllllllllllllllIlllIIlIlIllllll.input).append("]"));
        }
    }
}

