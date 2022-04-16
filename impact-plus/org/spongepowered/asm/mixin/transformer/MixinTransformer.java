/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.extensibility.IMixinConfig;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinErrorHandler;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.ArgsClassGenerator;
import org.spongepowered.asm.mixin.throwables.ClassAlreadyLoadedException;
import org.spongepowered.asm.mixin.throwables.MixinApplyError;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.mixin.throwables.MixinPrepareError;
import org.spongepowered.asm.mixin.transformer.Config;
import org.spongepowered.asm.mixin.transformer.InnerClassGenerator;
import org.spongepowered.asm.mixin.transformer.MixinConfig;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.MixinPostProcessor;
import org.spongepowered.asm.mixin.transformer.TargetClassContext;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;
import org.spongepowered.asm.mixin.transformer.ext.IClassGenerator;
import org.spongepowered.asm.mixin.transformer.ext.IHotSwap;
import org.spongepowered.asm.mixin.transformer.ext.extensions.ExtensionCheckClass;
import org.spongepowered.asm.mixin.transformer.ext.extensions.ExtensionCheckInterfaces;
import org.spongepowered.asm.mixin.transformer.ext.extensions.ExtensionClassExporter;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.mixin.transformer.throwables.MixinTransformerError;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.ITransformer;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.transformers.TreeTransformer;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.ReEntranceLock;
import org.spongepowered.asm.util.perf.Profiler;

public class MixinTransformer
extends TreeTransformer {
    private static final /* synthetic */ String METRONOME_AGENT_CLASS;
    private /* synthetic */ MixinEnvironment currentEnvironment;
    private final /* synthetic */ List<MixinConfig> pendingConfigs;
    static final /* synthetic */ Logger logger;
    private /* synthetic */ boolean errorState;
    private final /* synthetic */ String sessionId;
    private /* synthetic */ Level verboseLoggingLevel;
    private final /* synthetic */ IMixinService service;
    private final /* synthetic */ MixinPostProcessor postProcessor;
    private final /* synthetic */ Profiler profiler;
    private final /* synthetic */ Extensions extensions;
    private final /* synthetic */ List<MixinConfig> configs;
    private static final /* synthetic */ String MIXIN_AGENT_CLASS;
    private final /* synthetic */ ReEntranceLock lock;
    private /* synthetic */ int transformedCount;
    private final /* synthetic */ IHotSwap hotSwapper;

    public List<String> reload(String lllllllllllllllllIllllllllIlIIII, byte[] lllllllllllllllllIllllllllIlIIll) {
        MixinTransformer lllllllllllllllllIllllllllIlIIIl;
        if (lllllllllllllllllIllllllllIlIIIl.lock.getDepth() > 0) {
            throw new MixinApplyError("Cannot reload mixin if re-entrant lock entered");
        }
        ArrayList<String> lllllllllllllllllIllllllllIlIIlI = new ArrayList<String>();
        for (MixinConfig lllllllllllllllllIllllllllIlIllI : lllllllllllllllllIllllllllIlIIIl.configs) {
            lllllllllllllllllIllllllllIlIIlI.addAll(lllllllllllllllllIllllllllIlIllI.reloadMixin(lllllllllllllllllIllllllllIlIIII, lllllllllllllllllIllllllllIlIIll));
        }
        return lllllllllllllllllIllllllllIlIIlI;
    }

    private byte[] writeClass(String lllllllllllllllllIlllllIllIIlIIl, ClassNode lllllllllllllllllIlllllIllIIlIII, boolean lllllllllllllllllIlllllIllIIIlll) {
        MixinTransformer lllllllllllllllllIlllllIllIlIIlI;
        Profiler.Section lllllllllllllllllIlllllIllIIllII = lllllllllllllllllIlllllIllIlIIlI.profiler.begin("write");
        byte[] lllllllllllllllllIlllllIllIIlIll = lllllllllllllllllIlllllIllIlIIlI.writeClass(lllllllllllllllllIlllllIllIIlIII);
        lllllllllllllllllIlllllIllIIllII.end();
        lllllllllllllllllIlllllIllIlIIlI.extensions.export(lllllllllllllllllIlllllIllIlIIlI.currentEnvironment, lllllllllllllllllIlllllIllIIlIIl, lllllllllllllllllIlllllIllIIIlll, lllllllllllllllllIlllllIllIIlIll);
        return lllllllllllllllllIlllllIllIIlIll;
    }

    @Override
    public boolean isDelegationExcluded() {
        return true;
    }

    private int prepareConfigs(MixinEnvironment lllllllllllllllllIllllllIlIIlIlI) {
        MixinTransformer lllllllllllllllllIllllllIlIIlIll;
        int lllllllllllllllllIllllllIlIIllIl = 0;
        final IHotSwap lllllllllllllllllIllllllIlIIllII = lllllllllllllllllIllllllIlIIlIll.hotSwapper;
        for (MixinConfig lllllllllllllllllIllllllIlIlllII : lllllllllllllllllIllllllIlIIlIll.pendingConfigs) {
            lllllllllllllllllIllllllIlIlllII.addListener(lllllllllllllllllIllllllIlIIlIll.postProcessor);
            if (lllllllllllllllllIllllllIlIIllII == null) continue;
            lllllllllllllllllIllllllIlIlllII.addListener(new MixinConfig.IListener(){
                {
                    1 llllllllllllllllIIIlIllIlIIllIIl;
                }

                @Override
                public void onPrepare(MixinInfo llllllllllllllllIIIlIllIlIIlIIll) {
                    1 llllllllllllllllIIIlIllIlIIlIIlI;
                    llllllllllllllllIIIlIllIlIIlIIlI.lllllllllllllllllIllllllIlIIllII.registerMixinClass(llllllllllllllllIIIlIllIlIIlIIll.getClassName());
                }

                @Override
                public void onInit(MixinInfo llllllllllllllllIIIlIllIlIIIllll) {
                }
            });
        }
        for (MixinConfig lllllllllllllllllIllllllIlIllIII : lllllllllllllllllIllllllIlIIlIll.pendingConfigs) {
            try {
                logger.log(lllllllllllllllllIllllllIlIIlIll.verboseLoggingLevel, "Preparing {} ({})", new Object[]{lllllllllllllllllIllllllIlIllIII, lllllllllllllllllIllllllIlIllIII.getDeclaredMixinCount()});
                lllllllllllllllllIllllllIlIllIII.prepare();
                lllllllllllllllllIllllllIlIIllIl += lllllllllllllllllIllllllIlIllIII.getMixinCount();
            }
            catch (InvalidMixinException lllllllllllllllllIllllllIlIllIll) {
                lllllllllllllllllIllllllIlIIlIll.handleMixinPrepareError(lllllllllllllllllIllllllIlIllIII, lllllllllllllllllIllllllIlIllIll, lllllllllllllllllIllllllIlIIlIlI);
            }
            catch (Exception lllllllllllllllllIllllllIlIllIIl) {
                String lllllllllllllllllIllllllIlIllIlI = lllllllllllllllllIllllllIlIllIIl.getMessage();
                logger.error(String.valueOf(new StringBuilder().append("Error encountered whilst initialising mixin config '").append(lllllllllllllllllIllllllIlIllIII.getName()).append("': ").append(lllllllllllllllllIllllllIlIllIlI)), (Throwable)lllllllllllllllllIllllllIlIllIIl);
            }
        }
        for (MixinConfig lllllllllllllllllIllllllIlIlIlII : lllllllllllllllllIllllllIlIIlIll.pendingConfigs) {
            IMixinConfigPlugin lllllllllllllllllIllllllIlIlIllI = lllllllllllllllllIllllllIlIlIlII.getPlugin();
            if (lllllllllllllllllIllllllIlIlIllI == null) continue;
            HashSet<String> lllllllllllllllllIllllllIlIlIlIl = new HashSet<String>();
            for (MixinConfig lllllllllllllllllIllllllIlIlIlll : lllllllllllllllllIllllllIlIIlIll.pendingConfigs) {
                if (lllllllllllllllllIllllllIlIlIlll.equals(lllllllllllllllllIllllllIlIlIlII)) continue;
                lllllllllllllllllIllllllIlIlIlIl.addAll(lllllllllllllllllIllllllIlIlIlll.getTargets());
            }
            lllllllllllllllllIllllllIlIlIllI.acceptTargets(lllllllllllllllllIllllllIlIlIlII.getTargets(), Collections.unmodifiableSet(lllllllllllllllllIllllllIlIlIlIl));
        }
        for (MixinConfig lllllllllllllllllIllllllIlIlIIII : lllllllllllllllllIllllllIlIIlIll.pendingConfigs) {
            try {
                lllllllllllllllllIllllllIlIlIIII.postInitialise();
            }
            catch (InvalidMixinException lllllllllllllllllIllllllIlIlIIll) {
                lllllllllllllllllIllllllIlIIlIll.handleMixinPrepareError(lllllllllllllllllIllllllIlIlIIII, lllllllllllllllllIllllllIlIlIIll, lllllllllllllllllIllllllIlIIlIlI);
            }
            catch (Exception lllllllllllllllllIllllllIlIlIIIl) {
                String lllllllllllllllllIllllllIlIlIIlI = lllllllllllllllllIllllllIlIlIIIl.getMessage();
                logger.error(String.valueOf(new StringBuilder().append("Error encountered during mixin config postInit step'").append(lllllllllllllllllIllllllIlIlIIII.getName()).append("': ").append(lllllllllllllllllIllllllIlIlIIlI)), (Throwable)lllllllllllllllllIllllllIlIlIIIl);
            }
        }
        lllllllllllllllllIllllllIlIIlIll.configs.addAll(lllllllllllllllllIllllllIlIIlIll.pendingConfigs);
        Collections.sort(lllllllllllllllllIllllllIlIIlIll.configs);
        lllllllllllllllllIllllllIlIIlIll.pendingConfigs.clear();
        return lllllllllllllllllIllllllIlIIllIl;
    }

    private void checkSelect(MixinEnvironment lllllllllllllllllIlllllllIlllIlI) {
        MixinTransformer lllllllllllllllllIlllllllIllllII;
        if (lllllllllllllllllIlllllllIllllII.currentEnvironment != lllllllllllllllllIlllllllIlllIlI) {
            lllllllllllllllllIlllllllIllllII.select(lllllllllllllllllIlllllllIlllIlI);
            return;
        }
        int lllllllllllllllllIlllllllIllIlll = Mixins.getUnvisitedCount();
        if (lllllllllllllllllIlllllllIllIlll > 0 && lllllllllllllllllIlllllllIllllII.transformedCount == 0) {
            lllllllllllllllllIlllllllIllllII.select(lllllllllllllllllIlllllllIlllIlI);
        }
    }

    private List<IMixinErrorHandler> getErrorHandlers(MixinEnvironment.Phase lllllllllllllllllIlllllIlllIlIIl) {
        ArrayList<IMixinErrorHandler> lllllllllllllllllIlllllIlllIlIII = new ArrayList<IMixinErrorHandler>();
        for (String lllllllllllllllllIlllllIlllIlIll : Mixins.getErrorHandlerClasses()) {
            try {
                MixinTransformer lllllllllllllllllIlllllIlllIlIlI;
                logger.info("Instancing error handler class {}", new Object[]{lllllllllllllllllIlllllIlllIlIll});
                Class<?> lllllllllllllllllIlllllIlllIllIl = lllllllllllllllllIlllllIlllIlIlI.service.getClassProvider().findClass(lllllllllllllllllIlllllIlllIlIll, true);
                IMixinErrorHandler lllllllllllllllllIlllllIlllIllII = (IMixinErrorHandler)lllllllllllllllllIlllllIlllIllIl.newInstance();
                if (lllllllllllllllllIlllllIlllIllII == null) continue;
                lllllllllllllllllIlllllIlllIlIII.add(lllllllllllllllllIlllllIlllIllII);
            }
            catch (Throwable throwable) {}
        }
        return lllllllllllllllllIlllllIlllIlIII;
    }

    private IHotSwap initHotSwapper(MixinEnvironment llllllllllllllllllIIIIIIlIllIIlI) {
        if (!llllllllllllllllllIIIIIIlIllIIlI.getOption(MixinEnvironment.Option.HOT_SWAP)) {
            return null;
        }
        try {
            MixinTransformer llllllllllllllllllIIIIIIlIllIIll;
            logger.info("Attempting to load Hot-Swap agent");
            Class<?> llllllllllllllllllIIIIIIlIlllIII = Class.forName("org.spongepowered.tools.agent.MixinAgent");
            Constructor<?> llllllllllllllllllIIIIIIlIllIlll = llllllllllllllllllIIIIIIlIlllIII.getDeclaredConstructor(MixinTransformer.class);
            return (IHotSwap)llllllllllllllllllIIIIIIlIllIlll.newInstance(llllllllllllllllllIIIIIIlIllIIll);
        }
        catch (Throwable llllllllllllllllllIIIIIIlIllIllI) {
            logger.info("Hot-swap agent could not be loaded, hot swapping of mixins won't work. {}: {}", new Object[]{llllllllllllllllllIIIIIIlIllIllI.getClass().getSimpleName(), llllllllllllllllllIIIIIIlIllIllI.getMessage()});
            return null;
        }
    }

    @Override
    public String getName() {
        MixinTransformer llllllllllllllllllIIIIIIIIllIllI;
        return llllllllllllllllllIIIIIIIIllIllI.getClass().getName();
    }

    private void handleMixinPrepareError(MixinConfig lllllllllllllllllIllllllIIlIlIIl, InvalidMixinException lllllllllllllllllIllllllIIlIlIII, MixinEnvironment lllllllllllllllllIllllllIIlIIIll) throws MixinPrepareError {
        MixinTransformer lllllllllllllllllIllllllIIlIlIlI;
        lllllllllllllllllIllllllIIlIlIlI.handleMixinError(lllllllllllllllllIllllllIIlIlIIl.getName(), lllllllllllllllllIllllllIIlIlIII, lllllllllllllllllIllllllIIlIIIll, ErrorPhase.PREPARE);
    }

    private byte[] writeClass(TargetClassContext lllllllllllllllllIlllllIllIllllI) {
        MixinTransformer lllllllllllllllllIlllllIllIlllIl;
        return lllllllllllllllllIlllllIllIlllIl.writeClass(lllllllllllllllllIlllllIllIllllI.getClassName(), lllllllllllllllllIlllllIllIllllI.getClassNode(), lllllllllllllllllIlllllIllIllllI.isExportForced());
    }

    static {
        MIXIN_AGENT_CLASS = "org.spongepowered.tools.agent.MixinAgent";
        METRONOME_AGENT_CLASS = "org.spongepowered.metronome.Agent";
        logger = LogManager.getLogger((String)"mixin");
    }

    private byte[] applyMixins(MixinEnvironment lllllllllllllllllIllllllIIlllIlI, TargetClassContext lllllllllllllllllIllllllIIllIlIl) {
        Profiler.Section lllllllllllllllllIllllllIIlllIII;
        MixinTransformer lllllllllllllllllIllllllIIllIlll;
        block2: {
            lllllllllllllllllIllllllIIlllIII = lllllllllllllllllIllllllIIllIlll.profiler.begin("preapply");
            lllllllllllllllllIllllllIIllIlll.extensions.preApply(lllllllllllllllllIllllllIIllIlIl);
            lllllllllllllllllIllllllIIlllIII = lllllllllllllllllIllllllIIlllIII.next("apply");
            lllllllllllllllllIllllllIIllIlll.apply(lllllllllllllllllIllllllIIllIlIl);
            lllllllllllllllllIllllllIIlllIII = lllllllllllllllllIllllllIIlllIII.next("postapply");
            try {
                lllllllllllllllllIllllllIIllIlll.extensions.postApply(lllllllllllllllllIllllllIIllIlIl);
            }
            catch (ExtensionCheckClass.ValidationFailedException lllllllllllllllllIllllllIIllllII) {
                logger.info(lllllllllllllllllIllllllIIllllII.getMessage());
                if (!lllllllllllllllllIllllllIIllIlIl.isExportForced() && !lllllllllllllllllIllllllIIlllIlI.getOption(MixinEnvironment.Option.DEBUG_EXPORT)) break block2;
                lllllllllllllllllIllllllIIllIlll.writeClass(lllllllllllllllllIllllllIIllIlIl);
            }
        }
        lllllllllllllllllIllllllIIlllIII.end();
        return lllllllllllllllllIllllllIIllIlll.writeClass(lllllllllllllllllIllllllIIllIlIl);
    }

    public void audit(MixinEnvironment llllllllllllllllllIIIIIIlIIllIll) {
        MixinTransformer llllllllllllllllllIIIIIIlIlIIIII;
        HashSet<String> llllllllllllllllllIIIIIIlIIllllI = new HashSet<String>();
        for (MixinConfig llllllllllllllllllIIIIIIlIlIIllI : llllllllllllllllllIIIIIIlIlIIIII.configs) {
            llllllllllllllllllIIIIIIlIIllllI.addAll(llllllllllllllllllIIIIIIlIlIIllI.getUnhandledTargets());
        }
        Logger llllllllllllllllllIIIIIIlIIlllIl = LogManager.getLogger((String)"mixin/audit");
        for (String llllllllllllllllllIIIIIIlIlIIlII : llllllllllllllllllIIIIIIlIIllllI) {
            try {
                llllllllllllllllllIIIIIIlIIlllIl.info("Force-loading class {}", new Object[]{llllllllllllllllllIIIIIIlIlIIlII});
                llllllllllllllllllIIIIIIlIlIIIII.service.getClassProvider().findClass(llllllllllllllllllIIIIIIlIlIIlII, true);
            }
            catch (ClassNotFoundException llllllllllllllllllIIIIIIlIlIIlIl) {
                llllllllllllllllllIIIIIIlIIlllIl.error(String.valueOf(new StringBuilder().append("Could not force-load ").append(llllllllllllllllllIIIIIIlIlIIlII)), (Throwable)llllllllllllllllllIIIIIIlIlIIlIl);
            }
        }
        for (MixinConfig llllllllllllllllllIIIIIIlIlIIIIl : llllllllllllllllllIIIIIIlIlIIIII.configs) {
            for (String llllllllllllllllllIIIIIIlIlIIIlI : llllllllllllllllllIIIIIIlIlIIIIl.getUnhandledTargets()) {
                ClassAlreadyLoadedException llllllllllllllllllIIIIIIlIlIIIll = new ClassAlreadyLoadedException(String.valueOf(new StringBuilder().append(llllllllllllllllllIIIIIIlIlIIIlI).append(" was already classloaded")));
                llllllllllllllllllIIIIIIlIIlllIl.error(String.valueOf(new StringBuilder().append("Could not force-load ").append(llllllllllllllllllIIIIIIlIlIIIlI)), (Throwable)llllllllllllllllllIIIIIIlIlIIIll);
            }
        }
        if (llllllllllllllllllIIIIIIlIIllIll.getOption(MixinEnvironment.Option.DEBUG_PROFILER)) {
            llllllllllllllllllIIIIIIlIlIIIII.printProfilerSummary();
        }
    }

    private void handleMixinApplyError(String lllllllllllllllllIllllllIIIllIIl, InvalidMixinException lllllllllllllllllIllllllIIIlllII, MixinEnvironment lllllllllllllllllIllllllIIIllIll) throws MixinApplyError {
        MixinTransformer lllllllllllllllllIllllllIIIllllI;
        lllllllllllllllllIllllllIIIllllI.handleMixinError(lllllllllllllllllIllllllIIIllIIl, lllllllllllllllllIllllllIIIlllII, lllllllllllllllllIllllllIIIllIll, ErrorPhase.APPLY);
    }

    private void printProfilerSummary() {
        MixinTransformer llllllllllllllllllIIIIIIIlIlIllI;
        DecimalFormat llllllllllllllllllIIIIIIIllIlIIl = new DecimalFormat("(###0.000");
        DecimalFormat llllllllllllllllllIIIIIIIllIlIII = new DecimalFormat("(###0.0");
        PrettyPrinter llllllllllllllllllIIIIIIIllIIlll = llllllllllllllllllIIIIIIIlIlIllI.profiler.printer(false, false);
        long llllllllllllllllllIIIIIIIllIIllI = llllllllllllllllllIIIIIIIlIlIllI.profiler.get("mixin.prepare").getTotalTime();
        long llllllllllllllllllIIIIIIIllIIlIl = llllllllllllllllllIIIIIIIlIlIllI.profiler.get("mixin.read").getTotalTime();
        long llllllllllllllllllIIIIIIIllIIlII = llllllllllllllllllIIIIIIIlIlIllI.profiler.get("mixin.apply").getTotalTime();
        long llllllllllllllllllIIIIIIIllIIIll = llllllllllllllllllIIIIIIIlIlIllI.profiler.get("mixin.write").getTotalTime();
        long llllllllllllllllllIIIIIIIllIIIlI = llllllllllllllllllIIIIIIIlIlIllI.profiler.get("mixin").getTotalTime();
        long llllllllllllllllllIIIIIIIllIIIIl = llllllllllllllllllIIIIIIIlIlIllI.profiler.get("class.load").getTotalTime();
        long llllllllllllllllllIIIIIIIllIIIII = llllllllllllllllllIIIIIIIlIlIllI.profiler.get("class.transform").getTotalTime();
        long llllllllllllllllllIIIIIIIlIlllll = llllllllllllllllllIIIIIIIlIlIllI.profiler.get("mixin.debug.export").getTotalTime();
        long llllllllllllllllllIIIIIIIlIllllI = llllllllllllllllllIIIIIIIllIIIlI - llllllllllllllllllIIIIIIIllIIIIl - llllllllllllllllllIIIIIIIllIIIII - llllllllllllllllllIIIIIIIlIlllll;
        double llllllllllllllllllIIIIIIIlIlllIl = (double)llllllllllllllllllIIIIIIIlIllllI / (double)llllllllllllllllllIIIIIIIllIIIlI * 100.0;
        double llllllllllllllllllIIIIIIIlIlllII = (double)llllllllllllllllllIIIIIIIllIIIIl / (double)llllllllllllllllllIIIIIIIllIIIlI * 100.0;
        double llllllllllllllllllIIIIIIIlIllIll = (double)llllllllllllllllllIIIIIIIllIIIII / (double)llllllllllllllllllIIIIIIIllIIIlI * 100.0;
        double llllllllllllllllllIIIIIIIlIllIlI = (double)llllllllllllllllllIIIIIIIlIlllll / (double)llllllllllllllllllIIIIIIIllIIIlI * 100.0;
        long llllllllllllllllllIIIIIIIlIllIIl = 0L;
        Profiler.Section llllllllllllllllllIIIIIIIlIllIII = null;
        for (Profiler.Section llllllllllllllllllIIIIIIIlllIlII : llllllllllllllllllIIIIIIIlIlIllI.profiler.getSections()) {
            long llllllllllllllllllIIIIIIIlllIlIl = llllllllllllllllllIIIIIIIlllIlII.getName().startsWith("class.transform.") ? llllllllllllllllllIIIIIIIlllIlII.getTotalTime() : 0L;
            if (llllllllllllllllllIIIIIIIlllIlIl <= llllllllllllllllllIIIIIIIlIllIIl) continue;
            llllllllllllllllllIIIIIIIlIllIIl = llllllllllllllllllIIIIIIIlllIlIl;
            llllllllllllllllllIIIIIIIlIllIII = llllllllllllllllllIIIIIIIlllIlII;
        }
        llllllllllllllllllIIIIIIIllIIlll.hr().add("Summary").hr().add();
        String llllllllllllllllllIIIIIIIlIlIlll = "%9d ms %12s seconds)";
        llllllllllllllllllIIIIIIIllIIlll.kv("Total mixin time", llllllllllllllllllIIIIIIIlIlIlll, llllllllllllllllllIIIIIIIllIIIlI, llllllllllllllllllIIIIIIIllIlIIl.format((double)llllllllllllllllllIIIIIIIllIIIlI * 0.001)).add();
        llllllllllllllllllIIIIIIIllIIlll.kv("Preparing mixins", llllllllllllllllllIIIIIIIlIlIlll, llllllllllllllllllIIIIIIIllIIllI, llllllllllllllllllIIIIIIIllIlIIl.format((double)llllllllllllllllllIIIIIIIllIIllI * 0.001));
        llllllllllllllllllIIIIIIIllIIlll.kv("Reading input", llllllllllllllllllIIIIIIIlIlIlll, llllllllllllllllllIIIIIIIllIIlIl, llllllllllllllllllIIIIIIIllIlIIl.format((double)llllllllllllllllllIIIIIIIllIIlIl * 0.001));
        llllllllllllllllllIIIIIIIllIIlll.kv("Applying mixins", llllllllllllllllllIIIIIIIlIlIlll, llllllllllllllllllIIIIIIIllIIlII, llllllllllllllllllIIIIIIIllIlIIl.format((double)llllllllllllllllllIIIIIIIllIIlII * 0.001));
        llllllllllllllllllIIIIIIIllIIlll.kv("Writing output", llllllllllllllllllIIIIIIIlIlIlll, llllllllllllllllllIIIIIIIllIIIll, llllllllllllllllllIIIIIIIllIlIIl.format((double)llllllllllllllllllIIIIIIIllIIIll * 0.001)).add();
        llllllllllllllllllIIIIIIIllIIlll.kv("of which", "");
        llllllllllllllllllIIIIIIIllIIlll.kv("Time spent loading from disk", llllllllllllllllllIIIIIIIlIlIlll, llllllllllllllllllIIIIIIIllIIIIl, llllllllllllllllllIIIIIIIllIlIIl.format((double)llllllllllllllllllIIIIIIIllIIIIl * 0.001));
        llllllllllllllllllIIIIIIIllIIlll.kv("Time spent transforming classes", llllllllllllllllllIIIIIIIlIlIlll, llllllllllllllllllIIIIIIIllIIIII, llllllllllllllllllIIIIIIIllIlIIl.format((double)llllllllllllllllllIIIIIIIllIIIII * 0.001)).add();
        if (llllllllllllllllllIIIIIIIlIllIII != null) {
            llllllllllllllllllIIIIIIIllIIlll.kv("Worst transformer", llllllllllllllllllIIIIIIIlIllIII.getName());
            llllllllllllllllllIIIIIIIllIIlll.kv("Class", llllllllllllllllllIIIIIIIlIllIII.getInfo());
            llllllllllllllllllIIIIIIIllIIlll.kv("Time spent", "%s seconds", llllllllllllllllllIIIIIIIlIllIII.getTotalSeconds());
            llllllllllllllllllIIIIIIIllIIlll.kv("called", "%d times", llllllllllllllllllIIIIIIIlIllIII.getTotalCount()).add();
        }
        llllllllllllllllllIIIIIIIllIIlll.kv("   Time allocation:     Processing mixins", "%9d ms %10s%% of total)", llllllllllllllllllIIIIIIIlIllllI, llllllllllllllllllIIIIIIIllIlIII.format(llllllllllllllllllIIIIIIIlIlllIl));
        llllllllllllllllllIIIIIIIllIIlll.kv("Loading classes", "%9d ms %10s%% of total)", llllllllllllllllllIIIIIIIllIIIIl, llllllllllllllllllIIIIIIIllIlIII.format(llllllllllllllllllIIIIIIIlIlllII));
        llllllllllllllllllIIIIIIIllIIlll.kv("Running transformers", "%9d ms %10s%% of total)", llllllllllllllllllIIIIIIIllIIIII, llllllllllllllllllIIIIIIIllIlIII.format(llllllllllllllllllIIIIIIIlIllIll));
        if (llllllllllllllllllIIIIIIIlIlllll > 0L) {
            llllllllllllllllllIIIIIIIllIIlll.kv("Exporting classes (debug)", "%9d ms %10s%% of total)", llllllllllllllllllIIIIIIIlIlllll, llllllllllllllllllIIIIIIIllIlIII.format(llllllllllllllllllIIIIIIIlIllIlI));
        }
        llllllllllllllllllIIIIIIIllIIlll.add();
        try {
            Class<?> llllllllllllllllllIIIIIIIllIlllI = llllllllllllllllllIIIIIIIlIlIllI.service.getClassProvider().findAgentClass("org.spongepowered.metronome.Agent", false);
            Method llllllllllllllllllIIIIIIIllIllIl = llllllllllllllllllIIIIIIIllIlllI.getDeclaredMethod("getTimes", new Class[0]);
            Map llllllllllllllllllIIIIIIIllIllII = (Map)llllllllllllllllllIIIIIIIllIllIl.invoke(null, new Object[0]);
            llllllllllllllllllIIIIIIIllIIlll.hr().add("Transformer Times").hr().add();
            int llllllllllllllllllIIIIIIIllIlIll = 10;
            for (Map.Entry llllllllllllllllllIIIIIIIlllIIll : llllllllllllllllllIIIIIIIllIllII.entrySet()) {
                llllllllllllllllllIIIIIIIllIlIll = Math.max(llllllllllllllllllIIIIIIIllIlIll, ((String)llllllllllllllllllIIIIIIIlllIIll.getKey()).length());
            }
            for (Map.Entry llllllllllllllllllIIIIIIIllIllll : llllllllllllllllllIIIIIIIllIllII.entrySet()) {
                String llllllllllllllllllIIIIIIIlllIIIl = (String)llllllllllllllllllIIIIIIIllIllll.getKey();
                long llllllllllllllllllIIIIIIIlllIIII = 0L;
                for (Profiler.Section llllllllllllllllllIIIIIIIlllIIlI : llllllllllllllllllIIIIIIIlIlIllI.profiler.getSections()) {
                    if (!llllllllllllllllllIIIIIIIlllIIIl.equals(llllllllllllllllllIIIIIIIlllIIlI.getInfo())) continue;
                    llllllllllllllllllIIIIIIIlllIIII = llllllllllllllllllIIIIIIIlllIIlI.getTotalTime();
                    break;
                }
                if (llllllllllllllllllIIIIIIIlllIIII > 0L) {
                    llllllllllllllllllIIIIIIIllIIlll.add(String.valueOf(new StringBuilder().append("%-").append(llllllllllllllllllIIIIIIIllIlIll).append("s %8s ms %8s ms in mixin)")), llllllllllllllllllIIIIIIIlllIIIl, (Long)llllllllllllllllllIIIIIIIllIllll.getValue() + llllllllllllllllllIIIIIIIlllIIII, String.valueOf(new StringBuilder().append("(").append(llllllllllllllllllIIIIIIIlllIIII)));
                    continue;
                }
                llllllllllllllllllIIIIIIIllIIlll.add(String.valueOf(new StringBuilder().append("%-").append(llllllllllllllllllIIIIIIIllIlIll).append("s %8s ms")), llllllllllllllllllIIIIIIIlllIIIl, llllllllllllllllllIIIIIIIllIllll.getValue());
            }
            llllllllllllllllllIIIIIIIllIIlll.add();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        llllllllllllllllllIIIIIIIllIIlll.print();
    }

    MixinTransformer() {
        MixinTransformer llllllllllllllllllIIIIIIlIllllll;
        llllllllllllllllllIIIIIIlIllllll.service = MixinService.getService();
        llllllllllllllllllIIIIIIlIllllll.configs = new ArrayList<MixinConfig>();
        llllllllllllllllllIIIIIIlIllllll.pendingConfigs = new ArrayList<MixinConfig>();
        llllllllllllllllllIIIIIIlIllllll.sessionId = UUID.randomUUID().toString();
        llllllllllllllllllIIIIIIlIllllll.verboseLoggingLevel = Level.DEBUG;
        llllllllllllllllllIIIIIIlIllllll.errorState = false;
        llllllllllllllllllIIIIIIlIllllll.transformedCount = 0;
        MixinEnvironment llllllllllllllllllIIIIIIllIIIIIl = MixinEnvironment.getCurrentEnvironment();
        Object llllllllllllllllllIIIIIIllIIIIII = llllllllllllllllllIIIIIIllIIIIIl.getActiveTransformer();
        if (llllllllllllllllllIIIIIIllIIIIII instanceof ITransformer) {
            throw new MixinException(String.valueOf(new StringBuilder().append("Terminating MixinTransformer instance ").append(llllllllllllllllllIIIIIIlIllllll)));
        }
        llllllllllllllllllIIIIIIllIIIIIl.setActiveTransformer(llllllllllllllllllIIIIIIlIllllll);
        llllllllllllllllllIIIIIIlIllllll.lock = llllllllllllllllllIIIIIIlIllllll.service.getReEntranceLock();
        llllllllllllllllllIIIIIIlIllllll.extensions = new Extensions(llllllllllllllllllIIIIIIlIllllll);
        llllllllllllllllllIIIIIIlIllllll.hotSwapper = llllllllllllllllllIIIIIIlIllllll.initHotSwapper(llllllllllllllllllIIIIIIllIIIIIl);
        llllllllllllllllllIIIIIIlIllllll.postProcessor = new MixinPostProcessor();
        llllllllllllllllllIIIIIIlIllllll.extensions.add(new ArgsClassGenerator());
        llllllllllllllllllIIIIIIlIllllll.extensions.add(new InnerClassGenerator());
        llllllllllllllllllIIIIIIlIllllll.extensions.add(new ExtensionClassExporter(llllllllllllllllllIIIIIIllIIIIIl));
        llllllllllllllllllIIIIIIlIllllll.extensions.add(new ExtensionCheckClass());
        llllllllllllllllllIIIIIIlIllllll.extensions.add(new ExtensionCheckInterfaces());
        llllllllllllllllllIIIIIIlIllllll.profiler = MixinEnvironment.getProfiler();
    }

    private void apply(TargetClassContext lllllllllllllllllIllllllIIllIIII) {
        lllllllllllllllllIllllllIIllIIII.applyMixins();
    }

    private void dumpClassOnFailure(String lllllllllllllllllIlllllIlIllllIl, byte[] lllllllllllllllllIlllllIlIlllIII, MixinEnvironment lllllllllllllllllIlllllIlIllIllI) {
        if (lllllllllllllllllIlllllIlIllIllI.getOption(MixinEnvironment.Option.DUMP_TARGET_ON_FAILURE)) {
            MixinTransformer lllllllllllllllllIlllllIlIlllIlI;
            ExtensionClassExporter lllllllllllllllllIlllllIlIllllll = (ExtensionClassExporter)lllllllllllllllllIlllllIlIlllIlI.extensions.getExtension(ExtensionClassExporter.class);
            lllllllllllllllllIlllllIlIllllll.dumpClass(String.valueOf(new StringBuilder().append(lllllllllllllllllIlllllIlIllllIl.replace('.', '/')).append(".target")), lllllllllllllllllIlllllIlIlllIII);
        }
    }

    private void select(MixinEnvironment lllllllllllllllllIlllllllIIIlIII) {
        MixinTransformer lllllllllllllllllIlllllllIIIlIIl;
        Level level = lllllllllllllllllIlllllllIIIlIIl.verboseLoggingLevel = lllllllllllllllllIlllllllIIIlIII.getOption(MixinEnvironment.Option.DEBUG_VERBOSE) ? Level.INFO : Level.DEBUG;
        if (lllllllllllllllllIlllllllIIIlIIl.transformedCount > 0) {
            logger.log(lllllllllllllllllIlllllllIIIlIIl.verboseLoggingLevel, "Ending {}, applied {} mixins", new Object[]{lllllllllllllllllIlllllllIIIlIIl.currentEnvironment, lllllllllllllllllIlllllllIIIlIIl.transformedCount});
        }
        String lllllllllllllllllIlllllllIIIIlll = lllllllllllllllllIlllllllIIIlIIl.currentEnvironment == lllllllllllllllllIlllllllIIIlIII ? "Checking for additional" : "Preparing";
        logger.log(lllllllllllllllllIlllllllIIIlIIl.verboseLoggingLevel, "{} mixins for {}", new Object[]{lllllllllllllllllIlllllllIIIIlll, lllllllllllllllllIlllllllIIIlIII});
        lllllllllllllllllIlllllllIIIlIIl.profiler.setActive(true);
        lllllllllllllllllIlllllllIIIlIIl.profiler.mark(String.valueOf(new StringBuilder().append(lllllllllllllllllIlllllllIIIlIII.getPhase().toString()).append(":prepare")));
        Profiler.Section lllllllllllllllllIlllllllIIIIllI = lllllllllllllllllIlllllllIIIlIIl.profiler.begin("prepare");
        lllllllllllllllllIlllllllIIIlIIl.selectConfigs(lllllllllllllllllIlllllllIIIlIII);
        lllllllllllllllllIlllllllIIIlIIl.extensions.select(lllllllllllllllllIlllllllIIIlIII);
        int lllllllllllllllllIlllllllIIIIlIl = lllllllllllllllllIlllllllIIIlIIl.prepareConfigs(lllllllllllllllllIlllllllIIIlIII);
        lllllllllllllllllIlllllllIIIlIIl.currentEnvironment = lllllllllllllllllIlllllllIIIlIII;
        lllllllllllllllllIlllllllIIIlIIl.transformedCount = 0;
        lllllllllllllllllIlllllllIIIIllI.end();
        long lllllllllllllllllIlllllllIIIIlII = lllllllllllllllllIlllllllIIIIllI.getTime();
        double lllllllllllllllllIlllllllIIIIIll = lllllllllllllllllIlllllllIIIIllI.getSeconds();
        if (lllllllllllllllllIlllllllIIIIIll > 0.25) {
            long lllllllllllllllllIlllllllIIIlllI = lllllllllllllllllIlllllllIIIlIIl.profiler.get("class.load").getTime();
            long lllllllllllllllllIlllllllIIIllIl = lllllllllllllllllIlllllllIIIlIIl.profiler.get("class.transform").getTime();
            long lllllllllllllllllIlllllllIIIllII = lllllllllllllllllIlllllllIIIlIIl.profiler.get("mixin.plugin").getTime();
            String lllllllllllllllllIlllllllIIIlIll = new DecimalFormat("###0.000").format(lllllllllllllllllIlllllllIIIIIll);
            String lllllllllllllllllIlllllllIIIlIlI = new DecimalFormat("###0.0").format((double)lllllllllllllllllIlllllllIIIIlII / (double)lllllllllllllllllIlllllllIIIIlIl);
            logger.log(lllllllllllllllllIlllllllIIIlIIl.verboseLoggingLevel, "Prepared {} mixins in {} sec ({}ms avg) ({}ms load, {}ms transform, {}ms plugin)", new Object[]{lllllllllllllllllIlllllllIIIIlIl, lllllllllllllllllIlllllllIIIlIll, lllllllllllllllllIlllllllIIIlIlI, lllllllllllllllllIlllllllIIIlllI, lllllllllllllllllIlllllllIIIllIl, lllllllllllllllllIlllllllIIIllII});
        }
        lllllllllllllllllIlllllllIIIlIIl.profiler.mark(String.valueOf(new StringBuilder().append(lllllllllllllllllIlllllllIIIlIII.getPhase().toString()).append(":apply")));
        lllllllllllllllllIlllllllIIIlIIl.profiler.setActive(lllllllllllllllllIlllllllIIIlIII.getOption(MixinEnvironment.Option.DEBUG_PROFILER));
    }

    @Override
    public synchronized byte[] transformClassBytes(String llllllllllllllllllIIIIIIIIIIlIII, String llllllllllllllllllIIIIIIIIIIIIII, byte[] llllllllllllllllllIIIIIIIIIIIllI) {
        MixinTransformer llllllllllllllllllIIIIIIIIIIIIlI;
        if (llllllllllllllllllIIIIIIIIIIIIII == null || llllllllllllllllllIIIIIIIIIIIIlI.errorState) {
            return llllllllllllllllllIIIIIIIIIIIllI;
        }
        MixinEnvironment llllllllllllllllllIIIIIIIIIIIlIl = MixinEnvironment.getCurrentEnvironment();
        if (llllllllllllllllllIIIIIIIIIIIllI == null) {
            for (IClassGenerator llllllllllllllllllIIIIIIIIIllIII : llllllllllllllllllIIIIIIIIIIIIlI.extensions.getGenerators()) {
                Profiler.Section llllllllllllllllllIIIIIIIIIllIIl = llllllllllllllllllIIIIIIIIIIIIlI.profiler.begin("generator", llllllllllllllllllIIIIIIIIIllIII.getClass().getSimpleName().toLowerCase());
                llllllllllllllllllIIIIIIIIIIIllI = llllllllllllllllllIIIIIIIIIllIII.generate(llllllllllllllllllIIIIIIIIIIIIII);
                llllllllllllllllllIIIIIIIIIllIIl.end();
                if (llllllllllllllllllIIIIIIIIIIIllI == null) continue;
                llllllllllllllllllIIIIIIIIIIIIlI.extensions.export(llllllllllllllllllIIIIIIIIIIIlIl, llllllllllllllllllIIIIIIIIIIIIII.replace('.', '/'), false, llllllllllllllllllIIIIIIIIIIIllI);
                return llllllllllllllllllIIIIIIIIIIIllI;
            }
            return llllllllllllllllllIIIIIIIIIIIllI;
        }
        boolean llllllllllllllllllIIIIIIIIIIIlII = llllllllllllllllllIIIIIIIIIIIIlI.lock.push().check();
        Profiler.Section llllllllllllllllllIIIIIIIIIIIIll = llllllllllllllllllIIIIIIIIIIIIlI.profiler.begin("mixin");
        if (!llllllllllllllllllIIIIIIIIIIIlII) {
            try {
                llllllllllllllllllIIIIIIIIIIIIlI.checkSelect(llllllllllllllllllIIIIIIIIIIIlIl);
            }
            catch (Exception llllllllllllllllllIIIIIIIIIlIlll) {
                llllllllllllllllllIIIIIIIIIIIIlI.lock.pop();
                llllllllllllllllllIIIIIIIIIIIIll.end();
                throw new MixinException(llllllllllllllllllIIIIIIIIIlIlll);
            }
        }
        try {
            if (llllllllllllllllllIIIIIIIIIIIIlI.postProcessor.canTransform(llllllllllllllllllIIIIIIIIIIIIII)) {
                Profiler.Section llllllllllllllllllIIIIIIIIIlIllI = llllllllllllllllllIIIIIIIIIIIIlI.profiler.begin("postprocessor");
                byte[] llllllllllllllllllIIIIIIIIIlIlII = llllllllllllllllllIIIIIIIIIIIIlI.postProcessor.transformClassBytes(llllllllllllllllllIIIIIIIIIIlIII, llllllllllllllllllIIIIIIIIIIIIII, llllllllllllllllllIIIIIIIIIIIllI);
                llllllllllllllllllIIIIIIIIIlIllI.end();
                llllllllllllllllllIIIIIIIIIIIIlI.extensions.export(llllllllllllllllllIIIIIIIIIIIlIl, llllllllllllllllllIIIIIIIIIIIIII, false, llllllllllllllllllIIIIIIIIIlIlII);
                byte[] lllllllllllllllllIllllllllllIIlI = llllllllllllllllllIIIIIIIIIlIlII;
                return lllllllllllllllllIllllllllllIIlI;
            }
            TreeSet<MixinInfo> llllllllllllllllllIIIIIIIIIIllII = null;
            boolean llllllllllllllllllIIIIIIIIIIlIll = false;
            for (MixinConfig llllllllllllllllllIIIIIIIIIlIIlI : llllllllllllllllllIIIIIIIIIIIIlI.configs) {
                if (llllllllllllllllllIIIIIIIIIlIIlI.packageMatch(llllllllllllllllllIIIIIIIIIIIIII)) {
                    llllllllllllllllllIIIIIIIIIIlIll = true;
                    continue;
                }
                if (!llllllllllllllllllIIIIIIIIIlIIlI.hasMixinsFor(llllllllllllllllllIIIIIIIIIIIIII)) continue;
                if (llllllllllllllllllIIIIIIIIIIllII == null) {
                    llllllllllllllllllIIIIIIIIIIllII = new TreeSet<MixinInfo>();
                }
                llllllllllllllllllIIIIIIIIIIllII.addAll(llllllllllllllllllIIIIIIIIIlIIlI.getMixinsFor(llllllllllllllllllIIIIIIIIIIIIII));
            }
            if (llllllllllllllllllIIIIIIIIIIlIll) {
                throw new NoClassDefFoundError(String.format("%s is a mixin class and cannot be referenced directly", llllllllllllllllllIIIIIIIIIIIIII));
            }
            if (llllllllllllllllllIIIIIIIIIIllII != null) {
                if (llllllllllllllllllIIIIIIIIIIIlII) {
                    logger.warn("Re-entrance detected, this will cause serious problems.", (Throwable)new MixinException());
                    throw new MixinApplyError("Re-entrance error.");
                }
                if (llllllllllllllllllIIIIIIIIIIIIlI.hotSwapper != null) {
                    llllllllllllllllllIIIIIIIIIIIIlI.hotSwapper.registerTargetClass(llllllllllllllllllIIIIIIIIIIIIII, llllllllllllllllllIIIIIIIIIIIllI);
                }
                try {
                    Profiler.Section llllllllllllllllllIIIIIIIIIlIIII = llllllllllllllllllIIIIIIIIIIIIlI.profiler.begin("read");
                    ClassNode llllllllllllllllllIIIIIIIIIIllll = llllllllllllllllllIIIIIIIIIIIIlI.readClass(llllllllllllllllllIIIIIIIIIIIllI, true);
                    TargetClassContext llllllllllllllllllIIIIIIIIIIlllI = new TargetClassContext(llllllllllllllllllIIIIIIIIIIIlIl, llllllllllllllllllIIIIIIIIIIIIlI.extensions, llllllllllllllllllIIIIIIIIIIIIlI.sessionId, llllllllllllllllllIIIIIIIIIIIIII, llllllllllllllllllIIIIIIIIIIllll, llllllllllllllllllIIIIIIIIIIllII);
                    llllllllllllllllllIIIIIIIIIlIIII.end();
                    llllllllllllllllllIIIIIIIIIIIllI = llllllllllllllllllIIIIIIIIIIIIlI.applyMixins(llllllllllllllllllIIIIIIIIIIIlIl, llllllllllllllllllIIIIIIIIIIlllI);
                    ++llllllllllllllllllIIIIIIIIIIIIlI.transformedCount;
                }
                catch (InvalidMixinException llllllllllllllllllIIIIIIIIIIllIl) {
                    llllllllllllllllllIIIIIIIIIIIIlI.dumpClassOnFailure(llllllllllllllllllIIIIIIIIIIIIII, llllllllllllllllllIIIIIIIIIIIllI, llllllllllllllllllIIIIIIIIIIIlIl);
                    llllllllllllllllllIIIIIIIIIIIIlI.handleMixinApplyError(llllllllllllllllllIIIIIIIIIIIIII, llllllllllllllllllIIIIIIIIIIllIl, llllllllllllllllllIIIIIIIIIIIlIl);
                }
            }
            byte[] byArray = llllllllllllllllllIIIIIIIIIIIllI;
            return byArray;
        }
        catch (Throwable llllllllllllllllllIIIIIIIIIIlIlI) {
            llllllllllllllllllIIIIIIIIIIlIlI.printStackTrace();
            llllllllllllllllllIIIIIIIIIIIIlI.dumpClassOnFailure(llllllllllllllllllIIIIIIIIIIIIII, llllllllllllllllllIIIIIIIIIIIllI, llllllllllllllllllIIIIIIIIIIIlIl);
            throw new MixinTransformerError("An unexpected critical error was encountered", llllllllllllllllllIIIIIIIIIIlIlI);
        }
        finally {
            llllllllllllllllllIIIIIIIIIIIIlI.lock.pop();
            llllllllllllllllllIIIIIIIIIIIIll.end();
        }
    }

    private void handleMixinError(String lllllllllllllllllIlllllIlllllllI, InvalidMixinException lllllllllllllllllIllllllIIIIIllI, MixinEnvironment lllllllllllllllllIlllllIllllllII, ErrorPhase lllllllllllllllllIlllllIlllllIll) throws Error {
        MixinTransformer lllllllllllllllllIlllllIllllllll;
        IMixinErrorHandler.ErrorAction lllllllllllllllllIllllllIIIIIIII;
        lllllllllllllllllIlllllIllllllll.errorState = true;
        IMixinInfo lllllllllllllllllIllllllIIIIIIll = lllllllllllllllllIllllllIIIIIllI.getMixin();
        if (lllllllllllllllllIllllllIIIIIIll == null) {
            logger.error("InvalidMixinException has no mixin!", (Throwable)lllllllllllllllllIllllllIIIIIllI);
            throw lllllllllllllllllIllllllIIIIIllI;
        }
        IMixinConfig lllllllllllllllllIllllllIIIIIIlI = lllllllllllllllllIllllllIIIIIIll.getConfig();
        MixinEnvironment.Phase lllllllllllllllllIllllllIIIIIIIl = lllllllllllllllllIllllllIIIIIIll.getPhase();
        IMixinErrorHandler.ErrorAction errorAction = lllllllllllllllllIllllllIIIIIIII = lllllllllllllllllIllllllIIIIIIlI.isRequired() ? IMixinErrorHandler.ErrorAction.ERROR : IMixinErrorHandler.ErrorAction.WARN;
        if (lllllllllllllllllIlllllIllllllII.getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
            new PrettyPrinter().add("Invalid Mixin").centre().hr('-').kvWidth(10).kv("Action", lllllllllllllllllIlllllIlllllIll.name()).kv("Mixin", lllllllllllllllllIllllllIIIIIIll.getClassName()).kv("Config", lllllllllllllllllIllllllIIIIIIlI.getName()).kv("Phase", lllllllllllllllllIllllllIIIIIIIl).hr('-').add("    %s", lllllllllllllllllIllllllIIIIIllI.getClass().getName()).hr('-').addWrapped("    %s", lllllllllllllllllIllllllIIIIIllI.getMessage()).hr('-').add(lllllllllllllllllIllllllIIIIIllI, 8).trace(lllllllllllllllllIllllllIIIIIIII.logLevel);
        }
        for (IMixinErrorHandler lllllllllllllllllIllllllIIIIlIIl : lllllllllllllllllIlllllIllllllll.getErrorHandlers(lllllllllllllllllIllllllIIIIIIll.getPhase())) {
            IMixinErrorHandler.ErrorAction lllllllllllllllllIllllllIIIIlIlI = lllllllllllllllllIlllllIlllllIll.onError(lllllllllllllllllIllllllIIIIlIIl, lllllllllllllllllIlllllIlllllllI, lllllllllllllllllIllllllIIIIIllI, lllllllllllllllllIllllllIIIIIIll, lllllllllllllllllIllllllIIIIIIII);
            if (lllllllllllllllllIllllllIIIIlIlI == null) continue;
            lllllllllllllllllIllllllIIIIIIII = lllllllllllllllllIllllllIIIIlIlI;
        }
        logger.log(lllllllllllllllllIllllllIIIIIIII.logLevel, lllllllllllllllllIlllllIlllllIll.getLogMessage(lllllllllllllllllIlllllIlllllllI, lllllllllllllllllIllllllIIIIIllI, lllllllllllllllllIllllllIIIIIIll), (Throwable)lllllllllllllllllIllllllIIIIIllI);
        lllllllllllllllllIlllllIllllllll.errorState = false;
        if (lllllllllllllllllIllllllIIIIIIII == IMixinErrorHandler.ErrorAction.ERROR) {
            throw new MixinApplyError(lllllllllllllllllIlllllIlllllIll.getErrorMessage(lllllllllllllllllIllllllIIIIIIll, lllllllllllllllllIllllllIIIIIIlI, lllllllllllllllllIllllllIIIIIIIl), lllllllllllllllllIllllllIIIIIllI);
        }
    }

    private void selectConfigs(MixinEnvironment lllllllllllllllllIllllllIllIllII) {
        MixinTransformer lllllllllllllllllIllllllIllIlIll;
        Iterator<Config> lllllllllllllllllIllllllIllIlllI = Mixins.getConfigs().iterator();
        while (lllllllllllllllllIllllllIllIlllI.hasNext()) {
            Config lllllllllllllllllIllllllIllIllll = lllllllllllllllllIllllllIllIlllI.next();
            try {
                MixinConfig lllllllllllllllllIllllllIlllIIIl = lllllllllllllllllIllllllIllIllll.get();
                if (!lllllllllllllllllIllllllIlllIIIl.select(lllllllllllllllllIllllllIllIllII)) continue;
                lllllllllllllllllIllllllIllIlllI.remove();
                logger.log(lllllllllllllllllIllllllIllIlIll.verboseLoggingLevel, "Selecting config {}", new Object[]{lllllllllllllllllIllllllIlllIIIl});
                lllllllllllllllllIllllllIlllIIIl.onSelect();
                lllllllllllllllllIllllllIllIlIll.pendingConfigs.add(lllllllllllllllllIllllllIlllIIIl);
            }
            catch (Exception lllllllllllllllllIllllllIlllIIII) {
                logger.warn(String.format("Failed to select mixin config: %s", lllllllllllllllllIllllllIllIllll), (Throwable)lllllllllllllllllIllllllIlllIIII);
            }
        }
        Collections.sort(lllllllllllllllllIllllllIllIlIll.pendingConfigs);
    }

    static enum ErrorPhase {
        PREPARE{

            @Override
            protected String getContext(IMixinInfo llllllllllllllllIlIlIllllIIlIlIl, String llllllllllllllllIlIlIllllIIlIlII) {
                return String.format("preparing %s in %s", llllllllllllllllIlIlIllllIIlIlIl.getName(), llllllllllllllllIlIlIllllIIlIlII);
            }

            @Override
            IMixinErrorHandler.ErrorAction onError(IMixinErrorHandler llllllllllllllllIlIlIllllIlIIllI, String llllllllllllllllIlIlIllllIlIllIl, InvalidMixinException llllllllllllllllIlIlIllllIlIIlII, IMixinInfo llllllllllllllllIlIlIllllIlIIIlI, IMixinErrorHandler.ErrorAction llllllllllllllllIlIlIllllIIlllll) {
                try {
                    return llllllllllllllllIlIlIllllIlIIllI.onPrepareError(llllllllllllllllIlIlIllllIlIIIlI.getConfig(), llllllllllllllllIlIlIllllIlIIlII, llllllllllllllllIlIlIllllIlIIIlI, llllllllllllllllIlIlIllllIIlllll);
                }
                catch (AbstractMethodError llllllllllllllllIlIlIllllIllIIll) {
                    return llllllllllllllllIlIlIllllIIlllll;
                }
            }
            {
                1 llllllllllllllllIlIlIllllIllllIl;
            }
        }
        ,
        APPLY{

            @Override
            protected String getContext(IMixinInfo lIIlIIIllIIlII, String lIIlIIIllIIIIl) {
                return String.format("%s -> %s", lIIlIIIllIIlII, lIIlIIIllIIIIl);
            }

            @Override
            IMixinErrorHandler.ErrorAction onError(IMixinErrorHandler lIIlIIIlllIIlI, String lIIlIIIlllIIIl, InvalidMixinException lIIlIIIllIlIll, IMixinInfo lIIlIIIllIllll, IMixinErrorHandler.ErrorAction lIIlIIIllIlllI) {
                try {
                    return lIIlIIIlllIIlI.onApplyError(lIIlIIIlllIIIl, lIIlIIIllIlIll, lIIlIIIllIllll, lIIlIIIllIlllI);
                }
                catch (AbstractMethodError lIIlIIIlllIlII) {
                    return lIIlIIIllIlllI;
                }
            }
            {
                2 lIIlIIIlllllIl;
            }
        };

        private final /* synthetic */ String text;

        abstract IMixinErrorHandler.ErrorAction onError(IMixinErrorHandler var1, String var2, InvalidMixinException var3, IMixinInfo var4, IMixinErrorHandler.ErrorAction var5);

        private ErrorPhase() {
            ErrorPhase lllllllllllllllIllIllIlIIIIIIIIl;
            lllllllllllllllIllIllIlIIIIIIIIl.text = lllllllllllllllIllIllIlIIIIIIIIl.name().toLowerCase();
        }

        protected abstract String getContext(IMixinInfo var1, String var2);

        public String getLogMessage(String lllllllllllllllIllIllIIllllllIII, InvalidMixinException lllllllllllllllIllIllIIlllllIIll, IMixinInfo lllllllllllllllIllIllIIlllllIllI) {
            ErrorPhase lllllllllllllllIllIllIIlllllIlIl;
            return String.format("Mixin %s failed %s: %s %s", lllllllllllllllIllIllIIlllllIlIl.text, lllllllllllllllIllIllIIlllllIlIl.getContext(lllllllllllllllIllIllIIlllllIllI, lllllllllllllllIllIllIIllllllIII), lllllllllllllllIllIllIIlllllIIll.getClass().getName(), lllllllllllllllIllIllIIlllllIIll.getMessage());
        }

        public String getErrorMessage(IMixinInfo lllllllllllllllIllIllIIllllIllII, IMixinConfig lllllllllllllllIllIllIIllllIlIll, MixinEnvironment.Phase lllllllllllllllIllIllIIllllIIllI) {
            ErrorPhase lllllllllllllllIllIllIIllllIlIIl;
            return String.format("Mixin [%s] from phase [%s] in config [%s] FAILED during %s", lllllllllllllllIllIllIIllllIllII, lllllllllllllllIllIllIIllllIIllI, lllllllllllllllIllIllIIllllIlIll, lllllllllllllllIllIllIIllllIlIIl.name());
        }
    }
}

