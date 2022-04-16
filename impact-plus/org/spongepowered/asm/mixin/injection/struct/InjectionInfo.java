/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Strings
 */
package org.spongepowered.asm.mixin.injection.struct;

import com.google.common.base.Strings;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.Dynamic;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.code.ISliceContext;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.code.InjectorTarget;
import org.spongepowered.asm.mixin.injection.code.MethodSlice;
import org.spongepowered.asm.mixin.injection.code.MethodSlices;
import org.spongepowered.asm.mixin.injection.struct.CallbackInjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes;
import org.spongepowered.asm.mixin.injection.struct.InjectorGroupInfo;
import org.spongepowered.asm.mixin.injection.struct.InvalidMemberDescriptorException;
import org.spongepowered.asm.mixin.injection.struct.MemberInfo;
import org.spongepowered.asm.mixin.injection.struct.ModifyArgInjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.ModifyArgsInjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.ModifyConstantInjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.ModifyVariableInjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.RedirectInjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.throwables.InjectionError;
import org.spongepowered.asm.mixin.injection.throwables.InvalidInjectionException;
import org.spongepowered.asm.mixin.refmap.IMixinContext;
import org.spongepowered.asm.mixin.struct.SpecialMethodInfo;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.mixin.transformer.meta.MixinMerged;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;

public abstract class InjectionInfo
extends SpecialMethodInfo
implements ISliceContext {
    protected final /* synthetic */ String atKey;
    private /* synthetic */ int requiredCallbackCount;
    protected final /* synthetic */ boolean isStatic;
    private /* synthetic */ int injectedCallbackCount;
    protected final /* synthetic */ List<InjectionPoint> injectionPoints;
    protected final /* synthetic */ MethodSlices slices;
    protected final /* synthetic */ Map<Target, List<InjectionNodes.InjectionNode>> targetNodes;
    private /* synthetic */ int expectedCallbackCount;
    private final /* synthetic */ List<MethodNode> injectedMethods;
    protected /* synthetic */ InjectorGroupInfo group;
    protected final /* synthetic */ Deque<MethodNode> targets;
    protected /* synthetic */ Injector injector;
    private /* synthetic */ int maxCallbackCount;

    public Collection<MethodNode> getTargets() {
        InjectionInfo llIIIlIIllllIIl;
        return llIIIlIIllllIIl.targets;
    }

    public void addCallbackInvocation(MethodNode llIIIlIIlIllIll) {
        InjectionInfo llIIIlIIlIlllII;
        ++llIIIlIIlIlllII.injectedCallbackCount;
    }

    protected List<AnnotationNode> readInjectionPoints(String llIIIlIllIIIllI) {
        InjectionInfo llIIIlIllIIlIlI;
        List<AnnotationNode> llIIIlIllIIlIII = Annotations.getValue(llIIIlIllIIlIlI.annotation, llIIIlIllIIlIlI.atKey, false);
        if (llIIIlIllIIlIII == null) {
            throw new InvalidInjectionException(llIIIlIllIIlIlI, String.format("%s annotation on %s is missing '%s' value(s)", llIIIlIllIIIllI, llIIIlIllIIlIlI.method.name, llIIIlIllIIlIlI.atKey));
        }
        return llIIIlIllIIlIII;
    }

    public static AnnotationNode getInjectorAnnotation(IMixinInfo llIIIIllIlIIlll, MethodNode llIIIIllIlIIlIl) {
        AnnotationNode llIIIIllIlIlIIl = null;
        try {
            llIIIIllIlIlIIl = Annotations.getSingleVisible(llIIIIllIlIIlIl, Inject.class, ModifyArg.class, ModifyArgs.class, Redirect.class, ModifyVariable.class, ModifyConstant.class);
        }
        catch (IllegalArgumentException llIIIIllIlIllll) {
            throw new InvalidMixinException(llIIIIllIlIIlll, String.format("Error parsing annotations on %s in %s: %s", llIIIIllIlIIlIl.name, llIIIIllIlIIlll.getClassName(), llIIIIllIlIllll.getMessage()));
        }
        return llIIIIllIlIlIIl;
    }

    private void checkTarget(MethodNode llIIIIllllIIIIl) {
        InjectionInfo llIIIIllllIIlll;
        AnnotationNode llIIIIllllIIlIl = Annotations.getVisible(llIIIIllllIIIIl, MixinMerged.class);
        if (llIIIIllllIIlIl == null) {
            return;
        }
        String llIIIIllllIIlII = (String)Annotations.getValue(llIIIIllllIIlIl, "mixin");
        int llIIIIllllIIIll = (Integer)Annotations.getValue(llIIIIllllIIlIl, "priority");
        if (llIIIIllllIIIll >= llIIIIllllIIlll.mixin.getPriority() && !llIIIIllllIIlII.equals(llIIIIllllIIlll.mixin.getClassName())) {
            throw new InvalidInjectionException(llIIIIllllIIlll, String.format("%s cannot inject into %s::%s%s merged by %s with priority %d", llIIIIllllIIlll, llIIIIllllIIlll.classNode.name, llIIIIllllIIIIl.name, llIIIIllllIIIIl.desc, llIIIIllllIIlII, llIIIIllllIIIll));
        }
        if (Annotations.getVisible(llIIIIllllIIIIl, Final.class) != null) {
            throw new InvalidInjectionException(llIIIIllllIIlll, String.format("%s cannot inject into @Final method %s::%s%s merged by %s", llIIIIllllIIlll, llIIIIllllIIlll.classNode.name, llIIIIllllIIIIl.name, llIIIIllllIIIIl.desc, llIIIIllllIIlII));
        }
    }

    @Override
    public MethodSlice getSlice(String llIIIlIIlllIlII) {
        InjectionInfo llIIIlIIlllIIll;
        return llIIIlIIlllIIll.slices.get(llIIIlIIlllIIll.getSliceId(llIIIlIIlllIlII));
    }

    protected String getDynamicInfo() {
        InjectionInfo llIIIIlllIlIlIl;
        AnnotationNode llIIIIlllIllIII = Annotations.getInvisible(llIIIIlllIlIlIl.method, Dynamic.class);
        String llIIIIlllIlIlll = Strings.nullToEmpty((String)((String)Annotations.getValue(llIIIIlllIllIII)));
        Type llIIIIlllIlIllI = (Type)Annotations.getValue(llIIIIlllIllIII, "mixin");
        if (llIIIIlllIlIllI != null) {
            llIIIIlllIlIlll = String.format("{%s} %s", llIIIIlllIlIllI.getClassName(), llIIIIlllIlIlll).trim();
        }
        return llIIIIlllIlIlll.length() > 0 ? String.format(" Method is @Dynamic(%s)", llIIIIlllIlIlll) : "";
    }

    protected String getDescription() {
        return "Callback method";
    }

    public void notifyInjected(Target llIIIlIIlllllll) {
    }

    protected Set<MemberInfo> parseTargets(String llIIIlIllIlIlll) {
        InjectionInfo llIIIlIllIllIII;
        List<String> llIIIlIllIlIllI = Annotations.getValue(llIIIlIllIllIII.annotation, "method", false);
        if (llIIIlIllIlIllI == null) {
            throw new InvalidInjectionException(llIIIlIllIllIII, String.format("%s annotation on %s is missing method name", llIIIlIllIlIlll, llIIIlIllIllIII.method.name));
        }
        LinkedHashSet<MemberInfo> llIIIlIllIlIlIl = new LinkedHashSet<MemberInfo>();
        for (String llIIIlIllIllIIl : llIIIlIllIlIllI) {
            try {
                MemberInfo llIIIlIllIllIll = MemberInfo.parseAndValidate(llIIIlIllIllIIl, llIIIlIllIllIII.mixin);
                if (llIIIlIllIllIll.owner != null && !llIIIlIllIllIll.owner.equals(llIIIlIllIllIII.mixin.getTargetClassRef())) {
                    throw new InvalidInjectionException(llIIIlIllIllIII, String.format("%s annotation on %s specifies a target class '%s', which is not supported", llIIIlIllIlIlll, llIIIlIllIllIII.method.name, llIIIlIllIllIll.owner));
                }
                llIIIlIllIlIlIl.add(llIIIlIllIllIll);
            }
            catch (InvalidMemberDescriptorException llIIIlIllIllIlI) {
                throw new InvalidInjectionException(llIIIlIllIllIII, String.format("%s annotation on %s, has invalid target descriptor: \"%s\". %s", llIIIlIllIlIlll, llIIIlIllIllIII.method.name, llIIIlIllIllIIl, llIIIlIllIllIII.mixin.getReferenceMapper().getStatus()));
            }
        }
        return llIIIlIllIlIlIl;
    }

    private static String namesOf(Collection<MemberInfo> llIIIIllIIIIlIl) {
        int llIIIIllIIIlIII = 0;
        int llIIIIllIIIIlll = llIIIIllIIIIlIl.size();
        StringBuilder llIIIIllIIIIllI = new StringBuilder();
        for (MemberInfo llIIIIllIIIlIlI : llIIIIllIIIIlIl) {
            if (llIIIIllIIIlIII > 0) {
                if (llIIIIllIIIlIII == llIIIIllIIIIlll - 1) {
                    llIIIIllIIIIllI.append(" or ");
                } else {
                    llIIIIllIIIIllI.append(", ");
                }
            }
            llIIIIllIIIIllI.append('\'').append(llIIIIllIIIlIlI.name).append('\'');
            ++llIIIIllIIIlIII;
        }
        return String.valueOf(llIIIIllIIIIllI);
    }

    public void inject() {
        InjectionInfo llIIIlIlIIlIIIl;
        for (Map.Entry<Target, List<InjectionNodes.InjectionNode>> llIIIlIlIIlIIlI : llIIIlIlIIlIIIl.targetNodes.entrySet()) {
            llIIIlIlIIlIIIl.injector.inject(llIIIlIlIIlIIlI.getKey(), llIIIlIlIIlIIlI.getValue());
        }
        llIIIlIlIIlIIIl.targets.clear();
    }

    public void postInject() {
        InjectionInfo llIIIlIlIIIlIII;
        for (MethodNode llIIIlIlIIIlIIl : llIIIlIlIIIlIII.injectedMethods) {
            llIIIlIlIIIlIII.classNode.methods.add(llIIIlIlIIIlIIl);
        }
        String llIIIlIlIIIIlll = llIIIlIlIIIlIII.getDescription();
        String llIIIlIlIIIIllI = llIIIlIlIIIlIII.mixin.getReferenceMapper().getStatus();
        String llIIIlIlIIIIlIl = llIIIlIlIIIlIII.getDynamicInfo();
        if (llIIIlIlIIIlIII.mixin.getEnvironment().getOption(MixinEnvironment.Option.DEBUG_INJECTORS) && llIIIlIlIIIlIII.injectedCallbackCount < llIIIlIlIIIlIII.expectedCallbackCount) {
            throw new InvalidInjectionException(llIIIlIlIIIlIII, String.format("Injection validation failed: %s %s%s in %s expected %d invocation(s) but %d succeeded. %s%s", llIIIlIlIIIIlll, llIIIlIlIIIlIII.method.name, llIIIlIlIIIlIII.method.desc, llIIIlIlIIIlIII.mixin, llIIIlIlIIIlIII.expectedCallbackCount, llIIIlIlIIIlIII.injectedCallbackCount, llIIIlIlIIIIllI, llIIIlIlIIIIlIl));
        }
        if (llIIIlIlIIIlIII.injectedCallbackCount < llIIIlIlIIIlIII.requiredCallbackCount) {
            throw new InjectionError(String.format("Critical injection failure: %s %s%s in %s failed injection check, (%d/%d) succeeded. %s%s", llIIIlIlIIIIlll, llIIIlIlIIIlIII.method.name, llIIIlIlIIIlIII.method.desc, llIIIlIlIIIlIII.mixin, llIIIlIlIIIlIII.injectedCallbackCount, llIIIlIlIIIlIII.requiredCallbackCount, llIIIlIlIIIIllI, llIIIlIlIIIIlIl));
        }
        if (llIIIlIlIIIlIII.injectedCallbackCount > llIIIlIlIIIlIII.maxCallbackCount) {
            throw new InjectionError(String.format("Critical injection failure: %s %s%s in %s failed injection check, %d succeeded of %d allowed.%s", llIIIlIlIIIIlll, llIIIlIlIIIlIII.method.name, llIIIlIlIIIlIII.method.desc, llIIIlIlIIIlIII.mixin, llIIIlIlIIIlIII.injectedCallbackCount, llIIIlIlIIIlIII.maxCallbackCount, llIIIlIlIIIIlIl));
        }
    }

    protected InjectionInfo(MixinTargetContext llIIIlIllllIlII, MethodNode llIIIlIllllIIll, AnnotationNode llIIIlIllllIIlI, String llIIIlIllllIIIl) {
        super(llIIIlIllllIlII, llIIIlIllllIIll, llIIIlIllllIIlI);
        InjectionInfo llIIIlIllllIIII;
        llIIIlIllllIIII.targets = new ArrayDeque<MethodNode>();
        llIIIlIllllIIII.injectionPoints = new ArrayList<InjectionPoint>();
        llIIIlIllllIIII.targetNodes = new LinkedHashMap<Target, List<InjectionNodes.InjectionNode>>();
        llIIIlIllllIIII.injectedMethods = new ArrayList<MethodNode>(0);
        llIIIlIllllIIII.expectedCallbackCount = 1;
        llIIIlIllllIIII.requiredCallbackCount = 0;
        llIIIlIllllIIII.maxCallbackCount = Integer.MAX_VALUE;
        llIIIlIllllIIII.injectedCallbackCount = 0;
        llIIIlIllllIIII.isStatic = Bytecode.methodIsStatic(llIIIlIllllIIll);
        llIIIlIllllIIII.slices = MethodSlices.parse(llIIIlIllllIIII);
        llIIIlIllllIIII.atKey = llIIIlIllllIIIl;
        llIIIlIllllIIII.readAnnotation();
    }

    protected void parseInjectionPoints(List<AnnotationNode> llIIIlIlIllllll) {
        InjectionInfo llIIIlIllIIIIII;
        llIIIlIllIIIIII.injectionPoints.addAll(InjectionPoint.parse((IMixinContext)llIIIlIllIIIIII.mixin, llIIIlIllIIIIII.method, llIIIlIllIIIIII.annotation, llIIIlIlIllllll));
    }

    private void findMethods(Set<MemberInfo> llIIIlIIIIIIlIl, String llIIIlIIIIIlIlI) {
        InjectionInfo llIIIlIIIIIIlll;
        llIIIlIIIIIIlll.targets.clear();
        int llIIIlIIIIIlIIl = llIIIlIIIIIIlll.mixin.getEnvironment().getOption(MixinEnvironment.Option.REFMAP_REMAP) ? 2 : 1;
        for (MemberInfo llIIIlIIIIlIlIl : llIIIlIIIIIIlIl) {
            int llIIIlIIIIllIlI = 0;
            for (int llIIIlIIIIlIlll = 0; llIIIlIIIIlIlll < llIIIlIIIIIlIIl && llIIIlIIIIllIlI < 1; ++llIIIlIIIIlIlll) {
                int llIIIlIIIIlllII = 0;
                for (MethodNode llIIIlIIIIllllI : llIIIlIIIIIIlll.classNode.methods) {
                    boolean llIIIlIIIlIIIII;
                    if (!llIIIlIIIIlIlIl.matches(llIIIlIIIIllllI.name, llIIIlIIIIllllI.desc, llIIIlIIIIlllII)) continue;
                    boolean bl = llIIIlIIIlIIIII = Annotations.getVisible(llIIIlIIIIllllI, MixinMerged.class) != null;
                    if (llIIIlIIIIlIlIl.matchAll && (Bytecode.methodIsStatic(llIIIlIIIIllllI) != llIIIlIIIIIIlll.isStatic || llIIIlIIIIllllI == llIIIlIIIIIIlll.method || llIIIlIIIlIIIII)) continue;
                    llIIIlIIIIIIlll.checkTarget(llIIIlIIIIllllI);
                    llIIIlIIIIIIlll.targets.add(llIIIlIIIIllllI);
                    ++llIIIlIIIIlllII;
                    ++llIIIlIIIIllIlI;
                }
                llIIIlIIIIlIlIl = llIIIlIIIIlIlIl.transform(null);
            }
        }
        if (llIIIlIIIIIIlll.targets.size() == 0) {
            throw new InvalidInjectionException(llIIIlIIIIIIlll, String.format("%s annotation on %s could not find any targets matching %s in the target class %s. %s%s", llIIIlIIIIIlIlI, llIIIlIIIIIIlll.method.name, InjectionInfo.namesOf(llIIIlIIIIIIlIl), llIIIlIIIIIIlll.mixin.getTarget(), llIIIlIIIIIIlll.mixin.getReferenceMapper().getStatus(), llIIIlIIIIIIlll.getDynamicInfo()));
        }
    }

    protected void parseRequirements() {
        Integer llIIIlIlIlllIII;
        InjectionInfo llIIIlIlIllIllI;
        llIIIlIlIllIllI.group = llIIIlIlIllIllI.mixin.getInjectorGroups().parseGroup(llIIIlIlIllIllI.method, llIIIlIlIllIllI.mixin.getDefaultInjectorGroup()).add(llIIIlIlIllIllI);
        Integer llIIIlIlIlllIIl = (Integer)Annotations.getValue(llIIIlIlIllIllI.annotation, "expect");
        if (llIIIlIlIlllIIl != null) {
            llIIIlIlIllIllI.expectedCallbackCount = llIIIlIlIlllIIl;
        }
        if ((llIIIlIlIlllIII = (Integer)Annotations.getValue(llIIIlIlIllIllI.annotation, "require")) != null && llIIIlIlIlllIII > -1) {
            llIIIlIlIllIllI.requiredCallbackCount = llIIIlIlIlllIII;
        } else if (llIIIlIlIllIllI.group.isDefault()) {
            llIIIlIlIllIllI.requiredCallbackCount = llIIIlIlIllIllI.mixin.getDefaultRequiredInjections();
        }
        Integer llIIIlIlIllIlll = (Integer)Annotations.getValue(llIIIlIlIllIllI.annotation, "allow");
        if (llIIIlIlIllIlll != null) {
            llIIIlIlIllIllI.maxCallbackCount = Math.max(Math.max(llIIIlIlIllIllI.requiredCallbackCount, 1), llIIIlIlIllIlll);
        }
    }

    protected abstract Injector parseInjector(AnnotationNode var1);

    public int getInjectedCallbackCount() {
        InjectionInfo llIIIlIIllIllIl;
        return llIIIlIIllIllIl.injectedCallbackCount;
    }

    protected void readAnnotation() {
        InjectionInfo llIIIlIlllIlIII;
        if (llIIIlIlllIlIII.annotation == null) {
            return;
        }
        String llIIIlIlllIIlll = String.valueOf(new StringBuilder().append("@").append(Bytecode.getSimpleName(llIIIlIlllIlIII.annotation)));
        List<AnnotationNode> llIIIlIlllIIllI = llIIIlIlllIlIII.readInjectionPoints(llIIIlIlllIIlll);
        llIIIlIlllIlIII.findMethods(llIIIlIlllIlIII.parseTargets(llIIIlIlllIIlll), llIIIlIlllIIlll);
        llIIIlIlllIlIII.parseInjectionPoints(llIIIlIlllIIllI);
        llIIIlIlllIlIII.parseRequirements();
        llIIIlIlllIlIII.injector = llIIIlIlllIlIII.parseInjector(llIIIlIlllIlIII.annotation);
    }

    public void prepare() {
        InjectionInfo llIIIlIlIlIIIlI;
        llIIIlIlIlIIIlI.targetNodes.clear();
        for (MethodNode llIIIlIlIlIIIll : llIIIlIlIlIIIlI.targets) {
            Target llIIIlIlIlIIlll = llIIIlIlIlIIIlI.mixin.getTargetMethod(llIIIlIlIlIIIll);
            InjectorTarget llIIIlIlIlIIlIl = new InjectorTarget(llIIIlIlIlIIIlI, llIIIlIlIlIIlll);
            llIIIlIlIlIIIlI.targetNodes.put(llIIIlIlIlIIlll, llIIIlIlIlIIIlI.injector.find(llIIIlIlIlIIlIl, llIIIlIlIlIIIlI.injectionPoints));
            llIIIlIlIlIIlIl.dispose();
        }
    }

    protected InjectionInfo(MixinTargetContext llIIIllIIIIIIIl, MethodNode llIIIlIllllllII, AnnotationNode llIIIlIllllllll) {
        llIIIlIlllllllI(llIIIllIIIIIIIl, llIIIlIllllllII, llIIIlIllllllll, "at");
        InjectionInfo llIIIlIlllllllI;
    }

    public String getSliceId(String llIIIlIIlllIIII) {
        return "";
    }

    public boolean isValid() {
        InjectionInfo llIIIlIlIllIIIl;
        return llIIIlIlIllIIIl.targets.size() > 0 && llIIIlIlIllIIIl.injectionPoints.size() > 0;
    }

    public String toString() {
        InjectionInfo llIIIlIIlllllII;
        return InjectionInfo.describeInjector(llIIIlIIlllllII.mixin, llIIIlIIlllllII.annotation, llIIIlIIlllllII.method);
    }

    public MethodNode addMethod(int llIIIlIIllIIllI, String llIIIlIIllIIlIl, String llIIIlIIlIlllll) {
        InjectionInfo llIIIlIIllIIIlI;
        MethodNode llIIIlIIllIIIll = new MethodNode(327680, llIIIlIIllIIllI | 0x1000, llIIIlIIllIIlIl, llIIIlIIlIlllll, null, null);
        llIIIlIIllIIIlI.injectedMethods.add(llIIIlIIllIIIll);
        return llIIIlIIllIIIll;
    }

    static String describeInjector(IMixinContext llIIIIllIIlIIll, AnnotationNode llIIIIllIIlIIlI, MethodNode llIIIIllIIlIlII) {
        return String.format("%s->@%s::%s%s", llIIIIllIIlIIll.toString(), Bytecode.getSimpleName(llIIIIllIIlIIlI), llIIIIllIIlIlII.name, llIIIIllIIlIlII.desc);
    }

    public static String getInjectorPrefix(AnnotationNode llIIIIllIIllIlI) {
        if (llIIIIllIIllIlI != null) {
            if (llIIIIllIIllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(ModifyArg.class.getSimpleName()).append(";")))) {
                return "modify";
            }
            if (llIIIIllIIllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(ModifyArgs.class.getSimpleName()).append(";")))) {
                return "args";
            }
            if (llIIIIllIIllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(Redirect.class.getSimpleName()).append(";")))) {
                return "redirect";
            }
            if (llIIIIllIIllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(ModifyVariable.class.getSimpleName()).append(";")))) {
                return "localvar";
            }
            if (llIIIIllIIllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(ModifyConstant.class.getSimpleName()).append(";")))) {
                return "constant";
            }
        }
        return "handler";
    }

    public static InjectionInfo parse(MixinTargetContext llIIIIllIlllIII, MethodNode llIIIIllIllllII) {
        AnnotationNode llIIIIllIlllIlI = InjectionInfo.getInjectorAnnotation(llIIIIllIlllIII.getMixin(), llIIIIllIllllII);
        if (llIIIIllIlllIlI == null) {
            return null;
        }
        if (llIIIIllIlllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(Inject.class.getSimpleName()).append(";")))) {
            return new CallbackInjectionInfo(llIIIIllIlllIII, llIIIIllIllllII, llIIIIllIlllIlI);
        }
        if (llIIIIllIlllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(ModifyArg.class.getSimpleName()).append(";")))) {
            return new ModifyArgInjectionInfo(llIIIIllIlllIII, llIIIIllIllllII, llIIIIllIlllIlI);
        }
        if (llIIIIllIlllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(ModifyArgs.class.getSimpleName()).append(";")))) {
            return new ModifyArgsInjectionInfo(llIIIIllIlllIII, llIIIIllIllllII, llIIIIllIlllIlI);
        }
        if (llIIIIllIlllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(Redirect.class.getSimpleName()).append(";")))) {
            return new RedirectInjectionInfo(llIIIIllIlllIII, llIIIIllIllllII, llIIIIllIlllIlI);
        }
        if (llIIIIllIlllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(ModifyVariable.class.getSimpleName()).append(";")))) {
            return new ModifyVariableInjectionInfo(llIIIIllIlllIII, llIIIIllIllllII, llIIIIllIlllIlI);
        }
        if (llIIIIllIlllIlI.desc.endsWith(String.valueOf(new StringBuilder().append(ModifyConstant.class.getSimpleName()).append(";")))) {
            return new ModifyConstantInjectionInfo(llIIIIllIlllIII, llIIIIllIllllII, llIIIIllIlllIlI);
        }
        return null;
    }
}

