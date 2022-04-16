/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Function
 *  com.google.common.base.Functions
 *  com.google.common.collect.Lists
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.MethodVisitor;
import org.spongepowered.asm.lib.Type;
import org.spongepowered.asm.lib.tree.AnnotationNode;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.lib.tree.FieldNode;
import org.spongepowered.asm.lib.tree.InnerClassNode;
import org.spongepowered.asm.lib.tree.MethodNode;
import org.spongepowered.asm.mixin.Implements;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.extensibility.IMixinConfig;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.injection.Surrogate;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.transformer.ClassInfo;
import org.spongepowered.asm.mixin.transformer.InterfaceInfo;
import org.spongepowered.asm.mixin.transformer.MixinConfig;
import org.spongepowered.asm.mixin.transformer.MixinPreProcessorAccessor;
import org.spongepowered.asm.mixin.transformer.MixinPreProcessorInterface;
import org.spongepowered.asm.mixin.transformer.MixinPreProcessorStandard;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.mixin.transformer.TargetClassContext;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.mixin.transformer.throwables.MixinReloadException;
import org.spongepowered.asm.mixin.transformer.throwables.MixinTargetAlreadyLoadedException;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.util.Annotations;
import org.spongepowered.asm.util.Bytecode;
import org.spongepowered.asm.util.perf.Profiler;

class MixinInfo
implements Comparable<MixinInfo>,
IMixinInfo {
    private transient /* synthetic */ State state;
    private transient /* synthetic */ State pendingState;
    private final transient /* synthetic */ ClassInfo info;
    private final /* synthetic */ boolean virtual;
    private final transient /* synthetic */ Profiler profiler;
    private final transient /* synthetic */ IMixinService service;
    private final /* synthetic */ String className;
    private final transient /* synthetic */ Logger logger;
    private final transient /* synthetic */ int order;
    private final /* synthetic */ String name;
    private final transient /* synthetic */ boolean strict;
    private final transient /* synthetic */ SubType type;
    private final transient /* synthetic */ MixinEnvironment.Phase phase;
    private final /* synthetic */ List<String> targetClassNames;
    private final transient /* synthetic */ IMixinConfigPlugin plugin;
    private final transient /* synthetic */ MixinConfig parent;
    private final /* synthetic */ List<ClassInfo> targetClasses;
    private final /* synthetic */ int priority;
    private static final /* synthetic */ IMixinService classLoaderUtil;
    static /* synthetic */ int mixinOrder;

    void validate() {
        MixinInfo llllllllllllllllIlIIIllIIIlIIIIl;
        if (llllllllllllllllIlIIIllIIIlIIIIl.pendingState == null) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append("No pending validation state for ").append(llllllllllllllllIlIIIllIIIlIIIIl)));
        }
        try {
            llllllllllllllllIlIIIllIIIlIIIIl.pendingState.validate(llllllllllllllllIlIIIllIIIlIIIIl.type, llllllllllllllllIlIIIllIIIlIIIIl.targetClasses);
            llllllllllllllllIlIIIllIIIlIIIIl.state = llllllllllllllllIlIIIllIIIlIIIIl.pendingState;
        }
        finally {
            llllllllllllllllIlIIIllIIIlIIIIl.pendingState = null;
        }
    }

    MixinConfig getParent() {
        MixinInfo llllllllllllllllIlIIIlIllIlIllIl;
        return llllllllllllllllIlIIIlIllIlIllIl.parent;
    }

    private State getState() {
        MixinInfo llllllllllllllllIlIIIlIllIllIlll;
        return llllllllllllllllIlIIIlIllIllIlll.state != null ? llllllllllllllllIlIIIlIllIllIlll.state : llllllllllllllllIlIIIlIllIllIlll.pendingState;
    }

    public String toString() {
        MixinInfo llllllllllllllllIlIIIlIIllIIlllI;
        return String.format("%s:%s", llllllllllllllllIlIIIlIIllIIlllI.parent.getName(), llllllllllllllllIlIIIlIIllIIlllI.name);
    }

    private boolean shouldApplyMixin(boolean llllllllllllllllIlIIIlIllllIlIIl, String llllllllllllllllIlIIIlIllllIlIII) {
        MixinInfo llllllllllllllllIlIIIlIllllIIlIl;
        Profiler.Section llllllllllllllllIlIIIlIllllIIlll = llllllllllllllllIlIIIlIllllIIlIl.profiler.begin("plugin");
        boolean llllllllllllllllIlIIIlIllllIIllI = llllllllllllllllIlIIIlIllllIIlIl.plugin == null || llllllllllllllllIlIIIlIllllIlIIl || llllllllllllllllIlIIIlIllllIIlIl.plugin.shouldApplyMixin(llllllllllllllllIlIIIlIllllIlIII, llllllllllllllllIlIIIlIllllIIlIl.className);
        llllllllllllllllIlIIIlIllllIIlll.end();
        return llllllllllllllllIlIIIlIllllIIllI;
    }

    @Override
    public MixinClassNode getClassNode(int llllllllllllllllIlIIIlIlIllIllIl) {
        MixinInfo llllllllllllllllIlIIIlIlIllIllll;
        return llllllllllllllllIlIIIlIlIllIllll.getState().createClassNode(llllllllllllllllIlIIIlIlIllIllIl);
    }

    MixinTargetContext createContextFor(TargetClassContext llllllllllllllllIlIIIlIlIIlllIIl) {
        MixinInfo llllllllllllllllIlIIIlIlIIlllIll;
        MixinClassNode llllllllllllllllIlIIIlIlIlIIIIIl = llllllllllllllllIlIIIlIlIIlllIll.getClassNode(8);
        Profiler.Section llllllllllllllllIlIIIlIlIIllllll = llllllllllllllllIlIIIlIlIIlllIll.profiler.begin("pre");
        MixinTargetContext llllllllllllllllIlIIIlIlIIllllIl = llllllllllllllllIlIIIlIlIIlllIll.type.createPreProcessor(llllllllllllllllIlIIIlIlIlIIIIIl).prepare().createContextFor(llllllllllllllllIlIIIlIlIIlllIIl);
        llllllllllllllllIlIIIlIlIIllllll.end();
        return llllllllllllllllIlIIIlIlIIllllIl;
    }

    @Override
    public byte[] getClassBytes() {
        MixinInfo llllllllllllllllIlIIIlIllIIllllI;
        return llllllllllllllllIlIIIlIllIIllllI.getState().getClassBytes();
    }

    void reloadMixin(byte[] llllllllllllllllIlIIIlIlIIIIlIll) {
        MixinInfo llllllllllllllllIlIIIlIlIIIIllIl;
        if (llllllllllllllllIlIIIlIlIIIIllIl.pendingState != null) {
            throw new IllegalStateException("Cannot reload mixin while it is initialising");
        }
        llllllllllllllllIlIIIlIlIIIIllIl.pendingState = llllllllllllllllIlIIIlIlIIIIllIl.new Reloaded(llllllllllllllllIlIIIlIlIIIIllIl.state, llllllllllllllllIlIIIlIlIIIIlIll);
        llllllllllllllllIlIIIlIlIIIIllIl.validate();
    }

    Set<String> getSyntheticInnerClasses() {
        MixinInfo llllllllllllllllIlIIIlIlIllIIIII;
        return Collections.unmodifiableSet(llllllllllllllllIlIIIlIlIllIIIII.getState().getSyntheticInnerClasses());
    }

    public void postApply(String llllllllllllllllIlIIIlIIllIllllI, ClassNode llllllllllllllllIlIIIlIIllIlllII) {
        MixinInfo llllllllllllllllIlIIIlIIlllIIIll;
        if (llllllllllllllllIlIIIlIIlllIIIll.plugin != null) {
            Profiler.Section llllllllllllllllIlIIIlIIlllIIlII = llllllllllllllllIlIIIlIIlllIIIll.profiler.begin("plugin");
            llllllllllllllllIlIIIlIIlllIIIll.plugin.postApply(llllllllllllllllIlIIIlIIllIllllI, llllllllllllllllIlIIIlIIllIlllII, llllllllllllllllIlIIIlIIlllIIIll.className, llllllllllllllllIlIIIlIIlllIIIll);
            llllllllllllllllIlIIIlIIlllIIlII.end();
        }
        llllllllllllllllIlIIIlIIlllIIIll.parent.postApply(llllllllllllllllIlIIIlIIllIllllI, llllllllllllllllIlIIIlIIllIlllII);
    }

    Set<String> getInterfaces() {
        MixinInfo llllllllllllllllIlIIIlIlIlIlIlll;
        return llllllllllllllllIlIIIlIlIlIlIlll.getState().getInterfaces();
    }

    MixinInfo(IMixinService llllllllllllllllIlIIIllIIIllIIlI, MixinConfig llllllllllllllllIlIIIllIIIllIIIl, String llllllllllllllllIlIIIllIIIllIIII, boolean llllllllllllllllIlIIIllIIIlIlIII, IMixinConfigPlugin llllllllllllllllIlIIIllIIIlIIlll, boolean llllllllllllllllIlIIIllIIIlIIllI) {
        MixinInfo llllllllllllllllIlIIIllIIIlIllII;
        llllllllllllllllIlIIIllIIIlIllII.logger = LogManager.getLogger((String)"mixin");
        llllllllllllllllIlIIIllIIIlIllII.profiler = MixinEnvironment.getProfiler();
        llllllllllllllllIlIIIllIIIlIllII.order = mixinOrder++;
        llllllllllllllllIlIIIllIIIlIllII.service = llllllllllllllllIlIIIllIIIllIIlI;
        llllllllllllllllIlIIIllIIIlIllII.parent = llllllllllllllllIlIIIllIIIllIIIl;
        llllllllllllllllIlIIIllIIIlIllII.name = llllllllllllllllIlIIIllIIIllIIII;
        llllllllllllllllIlIIIllIIIlIllII.className = String.valueOf(new StringBuilder().append(llllllllllllllllIlIIIllIIIllIIIl.getMixinPackage()).append(llllllllllllllllIlIIIllIIIllIIII));
        llllllllllllllllIlIIIllIIIlIllII.plugin = llllllllllllllllIlIIIllIIIlIIlll;
        llllllllllllllllIlIIIllIIIlIllII.phase = llllllllllllllllIlIIIllIIIllIIIl.getEnvironment().getPhase();
        llllllllllllllllIlIIIllIIIlIllII.strict = llllllllllllllllIlIIIllIIIllIIIl.getEnvironment().getOption(MixinEnvironment.Option.DEBUG_TARGETS);
        try {
            byte[] llllllllllllllllIlIIIllIIIlllIII = llllllllllllllllIlIIIllIIIlIllII.loadMixinClass(llllllllllllllllIlIIIllIIIlIllII.className, llllllllllllllllIlIIIllIIIlIlIII);
            llllllllllllllllIlIIIllIIIlIllII.pendingState = llllllllllllllllIlIIIllIIIlIllII.new State(llllllllllllllllIlIIIllIIIlllIII);
            llllllllllllllllIlIIIllIIIlIllII.info = llllllllllllllllIlIIIllIIIlIllII.pendingState.getClassInfo();
            llllllllllllllllIlIIIllIIIlIllII.type = SubType.getTypeFor(llllllllllllllllIlIIIllIIIlIllII);
        }
        catch (InvalidMixinException llllllllllllllllIlIIIllIIIllIlll) {
            throw llllllllllllllllIlIIIllIIIllIlll;
        }
        catch (Exception llllllllllllllllIlIIIllIIIllIllI) {
            throw new InvalidMixinException((IMixinInfo)llllllllllllllllIlIIIllIIIlIllII, (Throwable)llllllllllllllllIlIIIllIIIllIllI);
        }
        if (!llllllllllllllllIlIIIllIIIlIllII.type.isLoadable()) {
            classLoaderUtil.registerInvalidClass(llllllllllllllllIlIIIllIIIlIllII.className);
        }
        try {
            llllllllllllllllIlIIIllIIIlIllII.priority = llllllllllllllllIlIIIllIIIlIllII.readPriority(llllllllllllllllIlIIIllIIIlIllII.pendingState.getClassNode());
            llllllllllllllllIlIIIllIIIlIllII.virtual = llllllllllllllllIlIIIllIIIlIllII.readPseudo(llllllllllllllllIlIIIllIIIlIllII.pendingState.getClassNode());
            llllllllllllllllIlIIIllIIIlIllII.targetClasses = llllllllllllllllIlIIIllIIIlIllII.readTargetClasses(llllllllllllllllIlIIIllIIIlIllII.pendingState.getClassNode(), llllllllllllllllIlIIIllIIIlIIllI);
            llllllllllllllllIlIIIllIIIlIllII.targetClassNames = Collections.unmodifiableList(Lists.transform(llllllllllllllllIlIIIllIIIlIllII.targetClasses, (Function)Functions.toStringFunction()));
        }
        catch (InvalidMixinException llllllllllllllllIlIIIllIIIllIlIl) {
            throw llllllllllllllllIlIIIllIIIllIlIl;
        }
        catch (Exception llllllllllllllllIlIIIllIIIllIlII) {
            throw new InvalidMixinException((IMixinInfo)llllllllllllllllIlIIIllIIIlIllII, (Throwable)llllllllllllllllIlIIIllIIIllIlII);
        }
    }

    @Override
    public boolean isDetachedSuper() {
        MixinInfo llllllllllllllllIlIIIlIllIIlllII;
        return llllllllllllllllIlIIIlIllIIlllII.getState().isDetachedSuper();
    }

    public boolean isLoadable() {
        MixinInfo llllllllllllllllIlIIIlIllIIIlIIl;
        return llllllllllllllllIlIIIlIllIIIlIIl.type.isLoadable();
    }

    private void readTargets(Collection<ClassInfo> llllllllllllllllIlIIIlIlllllIlll, Collection<String> llllllllllllllllIlIIIlIlllllIllI, boolean llllllllllllllllIlIIIlIllllllIlI, boolean llllllllllllllllIlIIIlIlllllIlII) {
        for (String llllllllllllllllIlIIIlIllllllllI : llllllllllllllllIlIIIlIlllllIllI) {
            ClassInfo llllllllllllllllIlIIIllIIIIIIIII;
            MixinInfo llllllllllllllllIlIIIlIllllllIII;
            String llllllllllllllllIlIIIlIlllllllll = llllllllllllllllIlIIIlIllllllllI.replace('/', '.');
            if (classLoaderUtil.isClassLoaded(llllllllllllllllIlIIIlIlllllllll) && !llllllllllllllllIlIIIlIllllllIII.isReloading()) {
                String llllllllllllllllIlIIIllIIIIIIIIl = String.format("Critical problem: %s target %s was already transformed.", llllllllllllllllIlIIIlIllllllIII, llllllllllllllllIlIIIlIlllllllll);
                if (llllllllllllllllIlIIIlIllllllIII.parent.isRequired()) {
                    throw new MixinTargetAlreadyLoadedException((IMixinInfo)llllllllllllllllIlIIIlIllllllIII, llllllllllllllllIlIIIllIIIIIIIIl, llllllllllllllllIlIIIlIlllllllll);
                }
                llllllllllllllllIlIIIlIllllllIII.logger.error(llllllllllllllllIlIIIllIIIIIIIIl);
            }
            if (!llllllllllllllllIlIIIlIllllllIII.shouldApplyMixin(llllllllllllllllIlIIIlIllllllIlI, llllllllllllllllIlIIIlIlllllllll) || (llllllllllllllllIlIIIllIIIIIIIII = llllllllllllllllIlIIIlIllllllIII.getTarget(llllllllllllllllIlIIIlIlllllllll, llllllllllllllllIlIIIlIlllllIlII)) == null || llllllllllllllllIlIIIlIlllllIlll.contains(llllllllllllllllIlIIIllIIIIIIIII)) continue;
            llllllllllllllllIlIIIlIlllllIlll.add(llllllllllllllllIlIIIllIIIIIIIII);
            llllllllllllllllIlIIIllIIIIIIIII.addMixin(llllllllllllllllIlIIIlIllllllIII);
        }
    }

    public boolean isUnique() {
        MixinInfo llllllllllllllllIlIIIlIllIIllIIl;
        return llllllllllllllllIlIIIlIllIIllIIl.getState().isUnique();
    }

    private ClassInfo getTarget(String llllllllllllllllIlIIIlIlllIllIll, boolean llllllllllllllllIlIIIlIlllIlIllI) throws InvalidMixinException {
        MixinInfo llllllllllllllllIlIIIlIlllIllIII;
        ClassInfo llllllllllllllllIlIIIlIlllIllIIl = ClassInfo.forName(llllllllllllllllIlIIIlIlllIllIll);
        if (llllllllllllllllIlIIIlIlllIllIIl == null) {
            if (llllllllllllllllIlIIIlIlllIllIII.isVirtual()) {
                llllllllllllllllIlIIIlIlllIllIII.logger.debug("Skipping virtual target {} for {}", new Object[]{llllllllllllllllIlIIIlIlllIllIll, llllllllllllllllIlIIIlIlllIllIII});
            } else {
                llllllllllllllllIlIIIlIlllIllIII.handleTargetError(String.format("@Mixin target %s was not found %s", llllllllllllllllIlIIIlIlllIllIll, llllllllllllllllIlIIIlIlllIllIII));
            }
            return null;
        }
        llllllllllllllllIlIIIlIlllIllIII.type.validateTarget(llllllllllllllllIlIIIlIlllIllIll, llllllllllllllllIlIIIlIlllIllIIl);
        if (llllllllllllllllIlIIIlIlllIlIllI && llllllllllllllllIlIIIlIlllIllIIl.isPublic() && !llllllllllllllllIlIIIlIlllIllIII.isVirtual()) {
            llllllllllllllllIlIIIlIlllIllIII.handleTargetError(String.format("@Mixin target %s is public in %s and should be specified in value", llllllllllllllllIlIIIlIlllIllIll, llllllllllllllllIlIIIlIlllIllIII));
        }
        return llllllllllllllllIlIIIlIlllIllIIl;
    }

    @Override
    public MixinEnvironment.Phase getPhase() {
        MixinInfo llllllllllllllllIlIIIlIlIllllIlI;
        return llllllllllllllllIlIIIlIlIllllIlI.phase;
    }

    @Override
    public int compareTo(MixinInfo llllllllllllllllIlIIIlIlIIIIIIlI) {
        MixinInfo llllllllllllllllIlIIIlIlIIIIIIll;
        if (llllllllllllllllIlIIIlIlIIIIIIlI == null) {
            return 0;
        }
        if (llllllllllllllllIlIIIlIlIIIIIIlI.priority == llllllllllllllllIlIIIlIlIIIIIIll.priority) {
            return llllllllllllllllIlIIIlIlIIIIIIll.order - llllllllllllllllIlIIIlIlIIIIIIlI.order;
        }
        return llllllllllllllllIlIIIlIlIIIIIIll.priority - llllllllllllllllIlIIIlIlIIIIIIlI.priority;
    }

    @Override
    public String getClassRef() {
        MixinInfo llllllllllllllllIlIIIlIllIlIIIIl;
        return llllllllllllllllIlIIIlIllIlIIIIl.getClassInfo().getName();
    }

    public boolean isVirtual() {
        MixinInfo llllllllllllllllIlIIIlIllIIlIlIl;
        return llllllllllllllllIlIIIlIllIIlIlIl.virtual;
    }

    static {
        classLoaderUtil = MixinService.getService();
        mixinOrder = 0;
    }

    @Override
    public IMixinConfig getConfig() {
        MixinInfo llllllllllllllllIlIIIlIllIllIIIl;
        return llllllllllllllllIlIIIlIllIllIIIl.parent;
    }

    Set<String> getInnerClasses() {
        MixinInfo llllllllllllllllIlIIIlIlIlIlllIl;
        return Collections.unmodifiableSet(llllllllllllllllIlIIIlIlIlIlllIl.getState().getInnerClasses());
    }

    @Override
    public String getName() {
        MixinInfo llllllllllllllllIlIIIlIllIlIIlll;
        return llllllllllllllllIlIIIlIllIlIIlll.name;
    }

    private byte[] loadMixinClass(String llllllllllllllllIlIIIlIlIIIlllll, boolean llllllllllllllllIlIIIlIlIIIllllI) throws ClassNotFoundException {
        MixinInfo llllllllllllllllIlIIIlIlIIlIIlII;
        byte[] llllllllllllllllIlIIIlIlIIlIIIIl = null;
        try {
            llllllllllllllllIlIIIlIlIIlIIIIl = llllllllllllllllIlIIIlIlIIlIIlII.service.getBytecodeProvider().getClassBytes(llllllllllllllllIlIIIlIlIIIlllll, llllllllllllllllIlIIIlIlIIIllllI);
        }
        catch (ClassNotFoundException llllllllllllllllIlIIIlIlIIlIIllI) {
            throw new ClassNotFoundException(String.format("The specified mixin '%s' was not found", llllllllllllllllIlIIIlIlIIIlllll));
        }
        catch (IOException llllllllllllllllIlIIIlIlIIlIIlIl) {
            llllllllllllllllIlIIIlIlIIlIIlII.logger.warn("Failed to load mixin %s, the specified mixin will not be applied", new Object[]{llllllllllllllllIlIIIlIlIIIlllll});
            throw new InvalidMixinException(llllllllllllllllIlIIIlIlIIlIIlII, "An error was encountered whilst loading the mixin class", (Throwable)llllllllllllllllIlIIIlIlIIlIIlIl);
        }
        return llllllllllllllllIlIIIlIlIIlIIIIl;
    }

    protected int readPriority(ClassNode llllllllllllllllIlIIIlIlllIIlIII) {
        MixinInfo llllllllllllllllIlIIIlIlllIIlIIl;
        if (llllllllllllllllIlIIIlIlllIIlIII == null) {
            return llllllllllllllllIlIIIlIlllIIlIIl.parent.getDefaultMixinPriority();
        }
        AnnotationNode llllllllllllllllIlIIIlIlllIIIllI = Annotations.getInvisible(llllllllllllllllIlIIIlIlllIIlIII, Mixin.class);
        if (llllllllllllllllIlIIIlIlllIIIllI == null) {
            throw new InvalidMixinException((IMixinInfo)llllllllllllllllIlIIIlIlllIIlIIl, String.format("The mixin '%s' is missing an @Mixin annotation", llllllllllllllllIlIIIlIlllIIlIIl.className));
        }
        Integer llllllllllllllllIlIIIlIlllIIIlII = (Integer)Annotations.getValue(llllllllllllllllIlIIIlIlllIIIllI, "priority");
        return llllllllllllllllIlIIIlIlllIIIlII == null ? llllllllllllllllIlIIIlIlllIIlIIl.parent.getDefaultMixinPriority() : llllllllllllllllIlIIIlIlllIIIlII.intValue();
    }

    ClassInfo getClassInfo() {
        MixinInfo llllllllllllllllIlIIIlIllIllIIll;
        return llllllllllllllllIlIIIlIllIllIIll.info;
    }

    private boolean isReloading() {
        MixinInfo llllllllllllllllIlIIIlIllIlllIIl;
        return llllllllllllllllIlIIIlIllIlllIIl.pendingState instanceof Reloaded;
    }

    private void handleTargetError(String llllllllllllllllIlIIIlIlllIIllll) {
        MixinInfo llllllllllllllllIlIIIlIlllIlIIII;
        if (llllllllllllllllIlIIIlIlllIlIIII.strict) {
            llllllllllllllllIlIIIlIlllIlIIII.logger.error(llllllllllllllllIlIIIlIlllIIllll);
            throw new InvalidMixinException((IMixinInfo)llllllllllllllllIlIIIlIlllIlIIII, llllllllllllllllIlIIIlIlllIIllll);
        }
        llllllllllllllllIlIIIlIlllIlIIII.logger.warn(llllllllllllllllIlIIIlIlllIIllll);
    }

    protected List<ClassInfo> readTargetClasses(MixinClassNode llllllllllllllllIlIIIllIIIIlIIII, boolean llllllllllllllllIlIIIllIIIIlIllI) {
        MixinInfo llllllllllllllllIlIIIllIIIIllIII;
        if (llllllllllllllllIlIIIllIIIIlIIII == null) {
            return Collections.emptyList();
        }
        AnnotationNode llllllllllllllllIlIIIllIIIIlIlIl = Annotations.getInvisible(llllllllllllllllIlIIIllIIIIlIIII, Mixin.class);
        if (llllllllllllllllIlIIIllIIIIlIlIl == null) {
            throw new InvalidMixinException((IMixinInfo)llllllllllllllllIlIIIllIIIIllIII, String.format("The mixin '%s' is missing an @Mixin annotation", llllllllllllllllIlIIIllIIIIllIII.className));
        }
        ArrayList<ClassInfo> llllllllllllllllIlIIIllIIIIlIlII = new ArrayList<ClassInfo>();
        List llllllllllllllllIlIIIllIIIIlIIll = (List)Annotations.getValue(llllllllllllllllIlIIIllIIIIlIlIl, "value");
        List llllllllllllllllIlIIIllIIIIlIIlI = (List)Annotations.getValue(llllllllllllllllIlIIIllIIIIlIlIl, "targets");
        if (llllllllllllllllIlIIIllIIIIlIIll != null) {
            llllllllllllllllIlIIIllIIIIllIII.readTargets(llllllllllllllllIlIIIllIIIIlIlII, Lists.transform((List)llllllllllllllllIlIIIllIIIIlIIll, (Function)new Function<Type, String>(){

                public String apply(Type lllIIIIlIIIIIl) {
                    return lllIIIIlIIIIIl.getClassName();
                }
                {
                    1 lllIIIIlIIIlll;
                }
            }), llllllllllllllllIlIIIllIIIIlIllI, false);
        }
        if (llllllllllllllllIlIIIllIIIIlIIlI != null) {
            llllllllllllllllIlIIIllIIIIllIII.readTargets(llllllllllllllllIlIIIllIIIIlIlII, Lists.transform((List)llllllllllllllllIlIIIllIIIIlIIlI, (Function)new Function<String, String>(){
                {
                    2 lllIlIIlIIIll;
                }

                public String apply(String lllIlIIIlllII) {
                    2 lllIlIIIlllIl;
                    return lllIlIIIlllIl.MixinInfo.this.getParent().remapClassName(lllIlIIIlllIl.MixinInfo.this.getClassRef(), lllIlIIIlllII);
                }
            }), llllllllllllllllIlIIIllIIIIlIllI, true);
        }
        return llllllllllllllllIlIIIllIIIIlIlII;
    }

    public Level getLoggingLevel() {
        MixinInfo llllllllllllllllIlIIIlIllIIIIIlI;
        return llllllllllllllllIlIIIlIllIIIIIlI.parent.getLoggingLevel();
    }

    @Override
    public String getClassName() {
        MixinInfo llllllllllllllllIlIIIlIllIlIIlII;
        return llllllllllllllllIlIIIlIllIlIIlII.className;
    }

    public void preApply(String llllllllllllllllIlIIIlIIlllIllII, ClassNode llllllllllllllllIlIIIlIIllllIIII) {
        MixinInfo llllllllllllllllIlIIIlIIlllIlllI;
        if (llllllllllllllllIlIIIlIIlllIlllI.plugin != null) {
            Profiler.Section llllllllllllllllIlIIIlIIllllIllI = llllllllllllllllIlIIIlIIlllIlllI.profiler.begin("plugin");
            llllllllllllllllIlIIIlIIlllIlllI.plugin.preApply(llllllllllllllllIlIIIlIIlllIllII, llllllllllllllllIlIIIlIIllllIIII, llllllllllllllllIlIIIlIIlllIlllI.className, llllllllllllllllIlIIIlIIlllIlllI);
            llllllllllllllllIlIIIlIIllllIllI.end();
        }
    }

    @Override
    public List<String> getTargetClasses() {
        MixinInfo llllllllllllllllIlIIIlIlIllIIllI;
        return llllllllllllllllIlIIIlIlIllIIllI.targetClassNames;
    }

    protected boolean readPseudo(ClassNode llllllllllllllllIlIIIlIllIllllIl) {
        return Annotations.getInvisible(llllllllllllllllIlIIIlIllIllllIl, Pseudo.class) != null;
    }

    List<InterfaceInfo> getSoftImplements() {
        MixinInfo llllllllllllllllIlIIIlIlIllIIIll;
        return Collections.unmodifiableList(llllllllllllllllIlIIIlIlIllIIIll.getState().getSoftImplements());
    }

    List<ClassInfo> getTargets() {
        MixinInfo llllllllllllllllIlIIIlIlIlIllIIl;
        return Collections.unmodifiableList(llllllllllllllllIlIIIlIlIlIllIIl.targetClasses);
    }

    public boolean isAccessor() {
        MixinInfo llllllllllllllllIlIIIlIllIIIllll;
        return llllllllllllllllIlIIIlIllIIIllll.type instanceof SubType.Accessor;
    }

    @Override
    public int getPriority() {
        MixinInfo llllllllllllllllIlIIIlIllIlIlIlI;
        return llllllllllllllllIlIIIlIllIlIlIlI.priority;
    }

    class MixinMethodNode
    extends MethodNode {
        private final /* synthetic */ String originalName;

        public boolean isInjector() {
            MixinMethodNode lIlIIIIllIIIllI;
            return lIlIIIIllIIIllI.getInjectorAnnotation() != null || lIlIIIIllIIIllI.isSurrogate();
        }

        public MixinMethodNode(int lIlIIIIlllIIlIl, String lIlIIIIllIlllIl, String lIlIIIIllIlllII, String lIlIIIIllIllIll, String[] lIlIIIIllIllIlI) {
            MixinMethodNode lIlIIIIlllIIIII;
            super(327680, lIlIIIIlllIIlIl, lIlIIIIllIlllIl, lIlIIIIllIlllII, lIlIIIIllIllIll, lIlIIIIllIllIlI);
            lIlIIIIlllIIIII.originalName = lIlIIIIllIlllIl;
        }

        public String getOriginalName() {
            MixinMethodNode lIlIIIIllIIllII;
            return lIlIIIIllIIllII.originalName;
        }

        public IMixinInfo getOwner() {
            MixinMethodNode lIlIIIIlIllIlII;
            return lIlIIIIlIllIlII.MixinInfo.this;
        }

        public AnnotationNode getVisibleAnnotation(Class<? extends Annotation> lIlIIIIlIlllIIl) {
            MixinMethodNode lIlIIIIlIlllIlI;
            return Annotations.getVisible(lIlIIIIlIlllIlI, lIlIIIIlIlllIIl);
        }

        public boolean isSurrogate() {
            MixinMethodNode lIlIIIIllIIIIll;
            return lIlIIIIllIIIIll.getVisibleAnnotation(Surrogate.class) != null;
        }

        public boolean isSynthetic() {
            MixinMethodNode lIlIIIIlIllllll;
            return Bytecode.hasFlag(lIlIIIIlIllllll, 4096);
        }

        public AnnotationNode getInjectorAnnotation() {
            MixinMethodNode lIlIIIIlIllIllI;
            return InjectionInfo.getInjectorAnnotation(lIlIIIIlIllIllI.MixinInfo.this, lIlIIIIlIllIllI);
        }

        public String toString() {
            MixinMethodNode lIlIIIIllIlIIll;
            return String.format("%s%s", lIlIIIIllIlIIll.originalName, lIlIIIIllIlIIll.desc);
        }
    }

    class State {
        protected /* synthetic */ MixinClassNode classNode;
        protected final /* synthetic */ Set<String> innerClasses;
        protected final /* synthetic */ Set<String> syntheticInnerClasses;
        private /* synthetic */ boolean detachedSuper;
        private final /* synthetic */ ClassInfo classInfo;
        protected final /* synthetic */ List<InterfaceInfo> softImplements;
        protected final /* synthetic */ Set<String> interfaces;
        private /* synthetic */ byte[] mixinBytes;
        private /* synthetic */ boolean unique;

        void readInnerClasses() {
            State lllllllllllllllllIIIIlIlIlIlIlIl;
            for (InnerClassNode lllllllllllllllllIIIIlIlIlIlIlll : lllllllllllllllllIIIIlIlIlIlIlIl.classNode.innerClasses) {
                ClassInfo lllllllllllllllllIIIIlIlIlIllIII = ClassInfo.forName(lllllllllllllllllIIIIlIlIlIlIlll.name);
                if ((lllllllllllllllllIIIIlIlIlIlIlll.outerName == null || !lllllllllllllllllIIIIlIlIlIlIlll.outerName.equals(lllllllllllllllllIIIIlIlIlIlIlIl.classInfo.getName())) && !lllllllllllllllllIIIIlIlIlIlIlll.name.startsWith(String.valueOf(new StringBuilder().append(lllllllllllllllllIIIIlIlIlIlIlIl.classNode.name).append("$")))) continue;
                if (lllllllllllllllllIIIIlIlIlIllIII.isProbablyStatic() && lllllllllllllllllIIIIlIlIlIllIII.isSynthetic()) {
                    lllllllllllllllllIIIIlIlIlIlIlIl.syntheticInnerClasses.add(lllllllllllllllllIIIIlIlIlIlIlll.name);
                    continue;
                }
                lllllllllllllllllIIIIlIlIlIlIlIl.innerClasses.add(lllllllllllllllllIIIIlIlIlIlIlll.name);
            }
        }

        protected void validateChanges(SubType lllllllllllllllllIIIIlIlIlIIlllI, List<ClassInfo> lllllllllllllllllIIIIlIlIlIIllIl) {
            State lllllllllllllllllIIIIlIlIlIIllII;
            lllllllllllllllllIIIIlIlIlIIlllI.createPreProcessor(lllllllllllllllllIIIIlIlIlIIllII.classNode).prepare();
        }

        MixinClassNode createClassNode(int lllllllllllllllllIIIIlIllIllIIIl) {
            State lllllllllllllllllIIIIlIllIllIIlI;
            MixinClassNode lllllllllllllllllIIIIlIllIllIlII = new MixinClassNode(lllllllllllllllllIIIIlIllIllIIlI.MixinInfo.this);
            ClassReader lllllllllllllllllIIIIlIllIllIIll = new ClassReader(lllllllllllllllllIIIIlIllIllIIlI.mixinBytes);
            lllllllllllllllllIIIIlIllIllIIll.accept(lllllllllllllllllIIIIlIllIllIlII, lllllllllllllllllIIIIlIllIllIIIl);
            return lllllllllllllllllIIIIlIllIllIlII;
        }

        private void validateRemappables(List<ClassInfo> lllllllllllllllllIIIIlIllIIIIIII) {
            if (lllllllllllllllllIIIIlIllIIIIIII.size() > 1) {
                State lllllllllllllllllIIIIlIllIIIIIll;
                for (FieldNode lllllllllllllllllIIIIlIllIIIIllI : lllllllllllllllllIIIIlIllIIIIIll.classNode.fields) {
                    lllllllllllllllllIIIIlIllIIIIIll.validateRemappable(Shadow.class, lllllllllllllllllIIIIlIllIIIIllI.name, Annotations.getVisible(lllllllllllllllllIIIIlIllIIIIllI, Shadow.class));
                }
                for (MethodNode lllllllllllllllllIIIIlIllIIIIlII : lllllllllllllllllIIIIlIllIIIIIll.classNode.methods) {
                    lllllllllllllllllIIIIlIllIIIIIll.validateRemappable(Shadow.class, lllllllllllllllllIIIIlIllIIIIlII.name, Annotations.getVisible(lllllllllllllllllIIIIlIllIIIIlII, Shadow.class));
                    AnnotationNode lllllllllllllllllIIIIlIllIIIIlIl = Annotations.getVisible(lllllllllllllllllIIIIlIllIIIIlII, Overwrite.class);
                    if (lllllllllllllllllIIIIlIllIIIIlIl == null || (lllllllllllllllllIIIIlIllIIIIlII.access & 8) != 0 && (lllllllllllllllllIIIIlIllIIIIlII.access & 1) != 0) continue;
                    throw new InvalidMixinException((IMixinInfo)lllllllllllllllllIIIIlIllIIIIIll.MixinInfo.this, String.valueOf(new StringBuilder().append("Found @Overwrite annotation on ").append(lllllllllllllllllIIIIlIllIIIIlII.name).append(" in ").append(lllllllllllllllllIIIIlIllIIIIIll.MixinInfo.this)));
                }
            }
        }

        MixinClassNode getClassNode() {
            State lllllllllllllllllIIIIlIlllIIlllI;
            return lllllllllllllllllIIIIlIlllIIlllI.classNode;
        }

        private void validateInner() {
            State lllllllllllllllllIIIIlIllIIllIll;
            if (!lllllllllllllllllIIIIlIllIIllIll.classInfo.isProbablyStatic()) {
                throw new InvalidMixinException((IMixinInfo)lllllllllllllllllIIIIlIllIIllIll.MixinInfo.this, "Inner class mixin must be declared static");
            }
        }

        void validate(SubType lllllllllllllllllIIIIlIllIlIIllI, List<ClassInfo> lllllllllllllllllIIIIlIllIlIIlIl) {
            State lllllllllllllllllIIIIlIllIlIIIll;
            MixinPreProcessorStandard lllllllllllllllllIIIIlIllIlIIlII = lllllllllllllllllIIIIlIllIlIIllI.createPreProcessor(lllllllllllllllllIIIIlIllIlIIIll.getClassNode()).prepare();
            for (ClassInfo lllllllllllllllllIIIIlIllIlIlIII : lllllllllllllllllIIIIlIllIlIIlIl) {
                lllllllllllllllllIIIIlIllIlIIlII.conform(lllllllllllllllllIIIIlIllIlIlIII);
            }
            lllllllllllllllllIIIIlIllIlIIllI.validate(lllllllllllllllllIIIIlIllIlIIIll, lllllllllllllllllIIIIlIllIlIIlIl);
            lllllllllllllllllIIIIlIllIlIIIll.detachedSuper = lllllllllllllllllIIIIlIllIlIIllI.isDetachedSuper();
            lllllllllllllllllIIIIlIllIlIIIll.unique = Annotations.getVisible(lllllllllllllllllIIIIlIllIlIIIll.getClassNode(), Unique.class) != null;
            lllllllllllllllllIIIIlIllIlIIIll.validateInner();
            lllllllllllllllllIIIIlIllIlIIIll.validateClassVersion();
            lllllllllllllllllIIIIlIllIlIIIll.validateRemappables(lllllllllllllllllIIIIlIllIlIIlIl);
            lllllllllllllllllIIIIlIllIlIIIll.readImplementations(lllllllllllllllllIIIIlIllIlIIllI);
            lllllllllllllllllIIIIlIllIlIIIll.readInnerClasses();
            lllllllllllllllllIIIIlIllIlIIIll.validateChanges(lllllllllllllllllIIIIlIllIlIIllI, lllllllllllllllllIIIIlIllIlIIlIl);
            lllllllllllllllllIIIIlIllIlIIIll.complete();
        }

        State(byte[] lllllllllllllllllIIIIlIlllIlllIl, ClassInfo lllllllllllllllllIIIIlIlllIlllII) {
            State lllllllllllllllllIIIIlIllllIIIll;
            lllllllllllllllllIIIIlIllllIIIll.interfaces = new HashSet<String>();
            lllllllllllllllllIIIIlIllllIIIll.softImplements = new ArrayList<InterfaceInfo>();
            lllllllllllllllllIIIIlIllllIIIll.syntheticInnerClasses = new HashSet<String>();
            lllllllllllllllllIIIIlIllllIIIll.innerClasses = new HashSet<String>();
            lllllllllllllllllIIIIlIllllIIIll.mixinBytes = lllllllllllllllllIIIIlIlllIlllIl;
            lllllllllllllllllIIIIlIllllIIIll.connect();
            lllllllllllllllllIIIIlIllllIIIll.classInfo = lllllllllllllllllIIIIlIlllIlllII != null ? lllllllllllllllllIIIIlIlllIlllII : ClassInfo.fromClassNode(lllllllllllllllllIIIIlIllllIIIll.getClassNode());
        }

        void readImplementations(SubType lllllllllllllllllIIIIlIlIllIIllI) {
            State lllllllllllllllllIIIIlIlIllIIlll;
            lllllllllllllllllIIIIlIlIllIIlll.interfaces.addAll(lllllllllllllllllIIIIlIlIllIIlll.classNode.interfaces);
            lllllllllllllllllIIIIlIlIllIIlll.interfaces.addAll(lllllllllllllllllIIIIlIlIllIIllI.getInterfaces());
            AnnotationNode lllllllllllllllllIIIIlIlIllIIlIl = Annotations.getInvisible(lllllllllllllllllIIIIlIlIllIIlll.classNode, Implements.class);
            if (lllllllllllllllllIIIIlIlIllIIlIl == null) {
                return;
            }
            List lllllllllllllllllIIIIlIlIllIIlII = (List)Annotations.getValue(lllllllllllllllllIIIIlIlIllIIlIl);
            if (lllllllllllllllllIIIIlIlIllIIlII == null) {
                return;
            }
            for (AnnotationNode lllllllllllllllllIIIIlIlIllIlIII : lllllllllllllllllIIIIlIlIllIIlII) {
                InterfaceInfo lllllllllllllllllIIIIlIlIllIlIIl = InterfaceInfo.fromAnnotation(lllllllllllllllllIIIIlIlIllIIlll.MixinInfo.this, lllllllllllllllllIIIIlIlIllIlIII);
                lllllllllllllllllIIIIlIlIllIIlll.softImplements.add(lllllllllllllllllIIIIlIlIllIlIIl);
                lllllllllllllllllIIIIlIlIllIIlll.interfaces.add(lllllllllllllllllIIIIlIlIllIlIIl.getInternalName());
                if (lllllllllllllllllIIIIlIlIllIIlll instanceof Reloaded) continue;
                lllllllllllllllllIIIIlIlIllIIlll.classInfo.addInterface(lllllllllllllllllIIIIlIlIllIlIIl.getInternalName());
            }
        }

        byte[] getClassBytes() {
            State lllllllllllllllllIIIIlIlllIlIIIl;
            return lllllllllllllllllIIIIlIlllIlIIIl.mixinBytes;
        }

        Set<String> getInnerClasses() {
            State lllllllllllllllllIIIIlIllIlllllI;
            return lllllllllllllllllIIIIlIllIlllllI.innerClasses;
        }

        boolean isDetachedSuper() {
            State lllllllllllllllllIIIIlIlllIIlIlI;
            return lllllllllllllllllIIIIlIlllIIlIlI.detachedSuper;
        }

        Set<String> getSyntheticInnerClasses() {
            State lllllllllllllllllIIIIlIlllIIIIIl;
            return lllllllllllllllllIIIIlIlllIIIIIl.syntheticInnerClasses;
        }

        private void validateClassVersion() {
            State lllllllllllllllllIIIIlIllIIlIIlI;
            if (lllllllllllllllllIIIIlIllIIlIIlI.classNode.version > MixinEnvironment.getCompatibilityLevel().classVersion()) {
                String lllllllllllllllllIIIIlIllIIlIIll = ".";
                for (MixinEnvironment.CompatibilityLevel lllllllllllllllllIIIIlIllIIlIlII : MixinEnvironment.CompatibilityLevel.values()) {
                    if (lllllllllllllllllIIIIlIllIIlIlII.classVersion() < lllllllllllllllllIIIIlIllIIlIIlI.classNode.version) continue;
                    lllllllllllllllllIIIIlIllIIlIIll = String.format(". Mixin requires compatibility level %s or above.", lllllllllllllllllIIIIlIllIIlIlII.name());
                }
                throw new InvalidMixinException((IMixinInfo)lllllllllllllllllIIIIlIllIIlIIlI.MixinInfo.this, String.valueOf(new StringBuilder().append("Unsupported mixin class version ").append(lllllllllllllllllIIIIlIllIIlIIlI.classNode.version).append(lllllllllllllllllIIIIlIllIIlIIll)));
            }
        }

        private void complete() {
            lllllllllllllllllIIIIlIlllIlIlll.classNode = null;
        }

        List<? extends InterfaceInfo> getSoftImplements() {
            State lllllllllllllllllIIIIlIlllIIIlII;
            return lllllllllllllllllIIIIlIlllIIIlII.softImplements;
        }

        private void connect() {
            State lllllllllllllllllIIIIlIlllIllIlI;
            lllllllllllllllllIIIIlIlllIllIlI.classNode = lllllllllllllllllIIIIlIlllIllIlI.createClassNode(0);
        }

        boolean isUnique() {
            State lllllllllllllllllIIIIlIlllIIIlll;
            return lllllllllllllllllIIIIlIlllIIIlll.unique;
        }

        private void validateRemappable(Class<Shadow> lllllllllllllllllIIIIlIlIlllIIll, String lllllllllllllllllIIIIlIlIlllIIlI, AnnotationNode lllllllllllllllllIIIIlIlIlllIlIl) {
            if (lllllllllllllllllIIIIlIlIlllIlIl != null && Annotations.getValue(lllllllllllllllllIIIIlIlIlllIlIl, "remap", Boolean.TRUE).booleanValue()) {
                State lllllllllllllllllIIIIlIlIllllIII;
                throw new InvalidMixinException((IMixinInfo)lllllllllllllllllIIIIlIlIllllIII.MixinInfo.this, String.valueOf(new StringBuilder().append("Found a remappable @").append(lllllllllllllllllIIIIlIlIlllIIll.getSimpleName()).append(" annotation on ").append(lllllllllllllllllIIIIlIlIlllIIlI).append(" in ").append(lllllllllllllllllIIIIlIlIllllIII)));
            }
        }

        State(byte[] lllllllllllllllllIIIIlIllllIlIll) {
            lllllllllllllllllIIIIlIllllIlIlI(lllllllllllllllllIIIIlIllllIlIll, null);
            State lllllllllllllllllIIIIlIllllIlIlI;
        }

        Set<String> getInterfaces() {
            State lllllllllllllllllIIIIlIllIlllIll;
            return lllllllllllllllllIIIIlIllIlllIll.interfaces;
        }

        ClassInfo getClassInfo() {
            State lllllllllllllllllIIIIlIlllIlIlII;
            return lllllllllllllllllIIIIlIlllIlIlII.classInfo;
        }
    }

    class MixinClassNode
    extends ClassNode {
        public final /* synthetic */ List<MixinMethodNode> mixinMethods;

        public MixinClassNode(MixinInfo lllllllllllllllllIIllIllIIlIlllI) {
            lllllllllllllllllIIllIllIIlIllIl(327680);
            MixinClassNode lllllllllllllllllIIllIllIIlIllIl;
        }

        public MixinInfo getMixin() {
            MixinClassNode lllllllllllllllllIIllIllIIlIIIIl;
            return lllllllllllllllllIIllIllIIlIIIIl.MixinInfo.this;
        }

        public MixinClassNode(int lllllllllllllllllIIllIllIIlIIllI) {
            MixinClassNode lllllllllllllllllIIllIllIIlIlIII;
            super(lllllllllllllllllIIllIllIIlIIllI);
            lllllllllllllllllIIllIllIIlIlIII.mixinMethods = lllllllllllllllllIIllIllIIlIlIII.methods;
        }

        @Override
        public MethodVisitor visitMethod(int lllllllllllllllllIIllIllIIIlIIII, String lllllllllllllllllIIllIllIIIIllll, String lllllllllllllllllIIllIllIIIIlllI, String lllllllllllllllllIIllIllIIIlIlII, String[] lllllllllllllllllIIllIllIIIIllII) {
            MixinClassNode lllllllllllllllllIIllIllIIIllIII;
            MixinMethodNode lllllllllllllllllIIllIllIIIlIIlI = new MixinMethodNode(lllllllllllllllllIIllIllIIIlIIII, lllllllllllllllllIIllIllIIIIllll, lllllllllllllllllIIllIllIIIIlllI, lllllllllllllllllIIllIllIIIlIlII, lllllllllllllllllIIllIllIIIIllII);
            lllllllllllllllllIIllIllIIIllIII.methods.add(lllllllllllllllllIIllIllIIIlIIlI);
            return lllllllllllllllllIIllIllIIIlIIlI;
        }
    }

    class Reloaded
    extends State {
        private final /* synthetic */ State previous;

        @Override
        protected void validateChanges(SubType lllIlIlIlIllIlI, List<ClassInfo> lllIlIlIlIllIIl) {
            Reloaded lllIlIlIlIllIll;
            if (!lllIlIlIlIllIll.syntheticInnerClasses.equals(lllIlIlIlIllIll.previous.syntheticInnerClasses)) {
                throw new MixinReloadException(lllIlIlIlIllIll.MixinInfo.this, "Cannot change inner classes");
            }
            if (!lllIlIlIlIllIll.interfaces.equals(lllIlIlIlIllIll.previous.interfaces)) {
                throw new MixinReloadException(lllIlIlIlIllIll.MixinInfo.this, "Cannot change interfaces");
            }
            if (!new HashSet(lllIlIlIlIllIll.softImplements).equals(new HashSet<InterfaceInfo>(lllIlIlIlIllIll.previous.softImplements))) {
                throw new MixinReloadException(lllIlIlIlIllIll.MixinInfo.this, "Cannot change soft interfaces");
            }
            List<ClassInfo> lllIlIlIlIllIII = lllIlIlIlIllIll.MixinInfo.this.readTargetClasses(lllIlIlIlIllIll.classNode, true);
            if (!new HashSet<ClassInfo>(lllIlIlIlIllIII).equals(new HashSet<ClassInfo>(lllIlIlIlIllIIl))) {
                throw new MixinReloadException(lllIlIlIlIllIll.MixinInfo.this, "Cannot change target classes");
            }
            int lllIlIlIlIlIlll = lllIlIlIlIllIll.MixinInfo.this.readPriority(lllIlIlIlIllIll.classNode);
            if (lllIlIlIlIlIlll != lllIlIlIlIllIll.MixinInfo.this.getPriority()) {
                throw new MixinReloadException(lllIlIlIlIllIll.MixinInfo.this, "Cannot change mixin priority");
            }
        }

        Reloaded(State lllIlIlIllIIIIl, byte[] lllIlIlIllIIlII) {
            Reloaded lllIlIlIllIIIll;
            super(lllIlIlIllIIlII, lllIlIlIllIIIIl.getClassInfo());
            lllIlIlIllIIIll.previous = lllIlIlIllIIIIl;
        }
    }

    static abstract class SubType {
        protected final /* synthetic */ MixinInfo mixin;
        protected final /* synthetic */ boolean targetMustBeInterface;
        protected /* synthetic */ boolean detached;
        protected final /* synthetic */ String annotationType;

        abstract MixinPreProcessorStandard createPreProcessor(MixinClassNode var1);

        Collection<String> getInterfaces() {
            return Collections.emptyList();
        }

        void validateTarget(String lIlIIIlIlIlIIIl, ClassInfo lIlIIIlIlIlIlII) {
            SubType lIlIIIlIlIlIllI;
            boolean lIlIIIlIlIlIIll = lIlIIIlIlIlIlII.isInterface();
            if (lIlIIIlIlIlIIll != lIlIIIlIlIlIllI.targetMustBeInterface) {
                String lIlIIIlIlIlIlll = lIlIIIlIlIlIIll ? "" : "not ";
                throw new InvalidMixinException((IMixinInfo)lIlIIIlIlIlIllI.mixin, String.valueOf(new StringBuilder().append(lIlIIIlIlIlIllI.annotationType).append(" target type mismatch: ").append(lIlIIIlIlIlIIIl).append(" is ").append(lIlIIIlIlIlIlll).append("an interface in ").append(lIlIIIlIlIlIllI)));
            }
        }

        boolean isDetachedSuper() {
            SubType lIlIIIlIlIllllI;
            return lIlIIIlIlIllllI.detached;
        }

        static SubType getTypeFor(MixinInfo lIlIIIlIIlllIlI) {
            if (!lIlIIIlIIlllIlI.getClassInfo().isInterface()) {
                return new Standard(lIlIIIlIIlllIlI);
            }
            boolean lIlIIIlIIlllIll = false;
            for (ClassInfo.Method lIlIIIlIIlllllI : lIlIIIlIIlllIlI.getClassInfo().getMethods()) {
                lIlIIIlIIlllIll |= !lIlIIIlIIlllllI.isAccessor();
            }
            if (lIlIIIlIIlllIll) {
                return new Interface(lIlIIIlIIlllIlI);
            }
            return new Accessor(lIlIIIlIIlllIlI);
        }

        SubType(MixinInfo lIlIIIlIllIIlII, String lIlIIIlIllIIlll, boolean lIlIIIlIllIIllI) {
            SubType lIlIIIlIllIIlIl;
            lIlIIIlIllIIlIl.mixin = lIlIIIlIllIIlII;
            lIlIIIlIllIIlIl.annotationType = lIlIIIlIllIIlll;
            lIlIIIlIllIIlIl.targetMustBeInterface = lIlIIIlIllIIllI;
        }

        abstract void validate(State var1, List<ClassInfo> var2);

        boolean isLoadable() {
            return false;
        }

        static class Interface
        extends SubType {
            @Override
            void validate(State lIIIIIlIIlIll, List<ClassInfo> lIIIIIlIIlIII) {
                Interface lIIIIIlIIllIl;
                if (!MixinEnvironment.getCompatibilityLevel().supportsMethodsInInterfaces()) {
                    throw new InvalidMixinException((IMixinInfo)lIIIIIlIIllIl.mixin, "Interface mixin not supported in current enviromnment");
                }
                MixinClassNode lIIIIIlIIIllI = lIIIIIlIIlIll.getClassNode();
                if (!"java/lang/Object".equals(lIIIIIlIIIllI.superName)) {
                    throw new InvalidMixinException((IMixinInfo)lIIIIIlIIllIl.mixin, String.valueOf(new StringBuilder().append("Super class of ").append(lIIIIIlIIllIl).append(" is invalid, found ").append(lIIIIIlIIIllI.superName.replace('/', '.'))));
                }
            }

            Interface(MixinInfo lIIIIIlIlllll) {
                super(lIIIIIlIlllll, "@Mixin", true);
                Interface lIIIIIllIIIII;
            }

            @Override
            MixinPreProcessorStandard createPreProcessor(MixinClassNode lIIIIIIlllIlI) {
                Interface lIIIIIIlllIll;
                return new MixinPreProcessorInterface(lIIIIIIlllIll.mixin, lIIIIIIlllIlI);
            }
        }

        static class Accessor
        extends SubType {
            private final /* synthetic */ Collection<String> interfaces;

            @Override
            void validate(State llllllllllllllllllIlllIlIIIIIIIl, List<ClassInfo> llllllllllllllllllIlllIlIIIIIlII) {
                MixinClassNode llllllllllllllllllIlllIlIIIIIIll = llllllllllllllllllIlllIlIIIIIIIl.getClassNode();
                if (!"java/lang/Object".equals(llllllllllllllllllIlllIlIIIIIIll.superName)) {
                    Accessor llllllllllllllllllIlllIlIIIIIllI;
                    throw new InvalidMixinException((IMixinInfo)llllllllllllllllllIlllIlIIIIIllI.mixin, String.valueOf(new StringBuilder().append("Super class of ").append(llllllllllllllllllIlllIlIIIIIllI).append(" is invalid, found ").append(llllllllllllllllllIlllIlIIIIIIll.superName.replace('/', '.'))));
                }
            }

            @Override
            Collection<String> getInterfaces() {
                Accessor llllllllllllllllllIlllIlIIlIIIIl;
                return llllllllllllllllllIlllIlIIlIIIIl.interfaces;
            }

            @Override
            boolean isLoadable() {
                return true;
            }

            @Override
            MixinPreProcessorStandard createPreProcessor(MixinClassNode llllllllllllllllllIlllIIllllllII) {
                Accessor llllllllllllllllllIlllIIlllllIll;
                return new MixinPreProcessorAccessor(llllllllllllllllllIlllIIlllllIll.mixin, llllllllllllllllllIlllIIllllllII);
            }

            Accessor(MixinInfo llllllllllllllllllIlllIlIIlIlIll) {
                super(llllllllllllllllllIlllIlIIlIlIll, "@Mixin", false);
                Accessor llllllllllllllllllIlllIlIIlIllII;
                llllllllllllllllllIlllIlIIlIllII.interfaces = new ArrayList<String>();
                llllllllllllllllllIlllIlIIlIllII.interfaces.add(llllllllllllllllllIlllIlIIlIlIll.getClassRef());
            }

            @Override
            void validateTarget(String llllllllllllllllllIlllIlIIIlIIll, ClassInfo llllllllllllllllllIlllIlIIIIllll) {
                boolean llllllllllllllllllIlllIlIIIlIIIl = llllllllllllllllllIlllIlIIIIllll.isInterface();
                if (llllllllllllllllllIlllIlIIIlIIIl && !MixinEnvironment.getCompatibilityLevel().supportsMethodsInInterfaces()) {
                    Accessor llllllllllllllllllIlllIlIIIlIIII;
                    throw new InvalidMixinException((IMixinInfo)llllllllllllllllllIlllIlIIIlIIII.mixin, "Accessor mixin targetting an interface is not supported in current enviromnment");
                }
            }
        }

        static class Standard
        extends SubType {
            @Override
            void validate(State lllllllllllllllllIIllIlIIIlIIlIl, List<ClassInfo> lllllllllllllllllIIllIlIIIlIIlII) {
                MixinClassNode lllllllllllllllllIIllIlIIIlIIlll = lllllllllllllllllIIllIlIIIlIIlIl.getClassNode();
                for (ClassInfo lllllllllllllllllIIllIlIIIlIlIll : lllllllllllllllllIIllIlIIIlIIlII) {
                    if (lllllllllllllllllIIllIlIIIlIIlll.superName.equals(lllllllllllllllllIIllIlIIIlIlIll.getSuperName())) continue;
                    if (!lllllllllllllllllIIllIlIIIlIlIll.hasSuperClass(lllllllllllllllllIIllIlIIIlIIlll.superName, ClassInfo.Traversal.SUPER)) {
                        Standard lllllllllllllllllIIllIlIIIlIlIlI;
                        ClassInfo lllllllllllllllllIIllIlIIIlIllII = ClassInfo.forName(lllllllllllllllllIIllIlIIIlIIlll.superName);
                        if (lllllllllllllllllIIllIlIIIlIllII.isMixin()) {
                            for (ClassInfo lllllllllllllllllIIllIlIIIlIllIl : lllllllllllllllllIIllIlIIIlIllII.getTargets()) {
                                if (!lllllllllllllllllIIllIlIIIlIIlII.contains(lllllllllllllllllIIllIlIIIlIllIl)) continue;
                                throw new InvalidMixinException((IMixinInfo)lllllllllllllllllIIllIlIIIlIlIlI.mixin, String.valueOf(new StringBuilder().append("Illegal hierarchy detected. Derived mixin ").append(lllllllllllllllllIIllIlIIIlIlIlI).append(" targets the same class ").append(lllllllllllllllllIIllIlIIIlIllIl.getClassName()).append(" as its superclass ").append(lllllllllllllllllIIllIlIIIlIllII.getClassName())));
                            }
                        }
                        throw new InvalidMixinException((IMixinInfo)lllllllllllllllllIIllIlIIIlIlIlI.mixin, String.valueOf(new StringBuilder().append("Super class '").append(lllllllllllllllllIIllIlIIIlIIlll.superName.replace('/', '.')).append("' of ").append(lllllllllllllllllIIllIlIIIlIlIlI.mixin.getName()).append(" was not found in the hierarchy of target class '").append(lllllllllllllllllIIllIlIIIlIlIll).append("'")));
                    }
                    lllllllllllllllllIIllIlIIIlIlIlI.detached = true;
                }
            }

            Standard(MixinInfo lllllllllllllllllIIllIlIIIlllIIl) {
                super(lllllllllllllllllIIllIlIIIlllIIl, "@Mixin", false);
                Standard lllllllllllllllllIIllIlIIIlllIlI;
            }

            @Override
            MixinPreProcessorStandard createPreProcessor(MixinClassNode lllllllllllllllllIIllIlIIIIllIII) {
                Standard lllllllllllllllllIIllIlIIIIllIIl;
                return new MixinPreProcessorStandard(lllllllllllllllllIIllIlIIIIllIIl.mixin, lllllllllllllllllIIllIlIIIIllIII);
            }
        }
    }
}

