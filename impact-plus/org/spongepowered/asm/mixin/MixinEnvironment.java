/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  com.google.common.collect.Sets
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 *  org.apache.logging.log4j.core.Appender
 *  org.apache.logging.log4j.core.Filter
 *  org.apache.logging.log4j.core.Layout
 *  org.apache.logging.log4j.core.LogEvent
 *  org.apache.logging.log4j.core.Logger
 *  org.apache.logging.log4j.core.appender.AbstractAppender
 */
package org.spongepowered.asm.mixin;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.extensibility.IEnvironmentTokenProvider;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.mixin.transformer.MixinTransformer;
import org.spongepowered.asm.obfuscation.RemapperChain;
import org.spongepowered.asm.service.ILegacyClassTransformer;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.ITransformer;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.util.ITokenProvider;
import org.spongepowered.asm.util.JavaVersion;
import org.spongepowered.asm.util.PrettyPrinter;
import org.spongepowered.asm.util.perf.Profiler;

public final class MixinEnvironment
implements ITokenProvider {
    private final /* synthetic */ IMixinService service;
    private /* synthetic */ String obfuscationContext;
    private static final /* synthetic */ Profiler profiler;
    private /* synthetic */ Side side;
    private final /* synthetic */ Map<String, Integer> internalTokens;
    private final /* synthetic */ String configsKey;
    private final /* synthetic */ RemapperChain remappers;
    private /* synthetic */ List<ILegacyClassTransformer> transformers;
    private static final /* synthetic */ Set<String> excludeTransformers;
    private final /* synthetic */ List<TokenProviderWrapper> tokenProviders;
    private final /* synthetic */ Set<String> tokenProviderClasses;
    private final /* synthetic */ boolean[] options;
    private static /* synthetic */ Phase currentPhase;
    private static /* synthetic */ MixinEnvironment currentEnvironment;
    private static /* synthetic */ CompatibilityLevel compatibility;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ Phase phase;
    private static /* synthetic */ boolean showHeader;

    public RemapperChain getRemappers() {
        MixinEnvironment llllllllllllllllIIlIIIlIIIlIIIll;
        return llllllllllllllllIIlIIIlIIIlIIIll.remappers;
    }

    @Deprecated
    public static void setCompatibilityLevel(CompatibilityLevel llllllllllllllllIIlIIIIllllIlIlI) throws IllegalArgumentException {
        StackTraceElement[] llllllllllllllllIIlIIIIllllIlIIl = Thread.currentThread().getStackTrace();
        if (!"org.spongepowered.asm.mixin.transformer.MixinConfig".equals(llllllllllllllllIIlIIIIllllIlIIl[2].getClassName())) {
            logger.warn("MixinEnvironment::setCompatibilityLevel is deprecated and will be removed. Set level via config instead!");
        }
        if (llllllllllllllllIIlIIIIllllIlIlI != compatibility && llllllllllllllllIIlIIIIllllIlIlI.isAtLeast(compatibility)) {
            if (!llllllllllllllllIIlIIIIllllIlIlI.isSupported()) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append("The requested compatibility level ").append((Object)llllllllllllllllIIlIIIIllllIlIlI).append(" could not be set. Level is not supported")));
            }
            compatibility = llllllllllllllllIIlIIIIllllIlIlI;
            logger.info("Compatibility level set to {}", new Object[]{llllllllllllllllIIlIIIIllllIlIlI});
        }
    }

    public String getOptionValue(Option llllllllllllllllIIlIIIlIIIllllII) {
        return llllllllllllllllIIlIIIlIIIllllII.getStringValue();
    }

    private void buildTransformerDelegationList() {
        MixinEnvironment llllllllllllllllIIlIIIlIIIIIIIll;
        logger.debug("Rebuilding transformer delegation list:");
        llllllllllllllllIIlIIIlIIIIIIIll.transformers = new ArrayList<ILegacyClassTransformer>();
        for (ITransformer llllllllllllllllIIlIIIlIIIIIIlII : llllllllllllllllIIlIIIlIIIIIIIll.service.getTransformers()) {
            if (!(llllllllllllllllIIlIIIlIIIIIIlII instanceof ILegacyClassTransformer)) continue;
            ILegacyClassTransformer llllllllllllllllIIlIIIlIIIIIIlll = (ILegacyClassTransformer)llllllllllllllllIIlIIIlIIIIIIlII;
            String llllllllllllllllIIlIIIlIIIIIIllI = llllllllllllllllIIlIIIlIIIIIIlll.getName();
            boolean llllllllllllllllIIlIIIlIIIIIIlIl = true;
            for (String llllllllllllllllIIlIIIlIIIIIlIII : excludeTransformers) {
                if (!llllllllllllllllIIlIIIlIIIIIIllI.contains(llllllllllllllllIIlIIIlIIIIIlIII)) continue;
                llllllllllllllllIIlIIIlIIIIIIlIl = false;
                break;
            }
            if (llllllllllllllllIIlIIIlIIIIIIlIl && !llllllllllllllllIIlIIIlIIIIIIlll.isDelegationExcluded()) {
                logger.debug("  Adding:    {}", new Object[]{llllllllllllllllIIlIIIlIIIIIIllI});
                llllllllllllllllIIlIIIlIIIIIIIll.transformers.add(llllllllllllllllIIlIIIlIIIIIIlll);
                continue;
            }
            logger.debug("  Excluding: {}", new Object[]{llllllllllllllllIIlIIIlIIIIIIllI});
        }
        logger.debug("Transformer delegation list created with {} entries", new Object[]{llllllllllllllllIIlIIIlIIIIIIIll.transformers.size()});
    }

    @Override
    public Integer getToken(String llllllllllllllllIIlIIIlIIllIllIl) {
        MixinEnvironment llllllllllllllllIIlIIIlIIllIllII;
        llllllllllllllllIIlIIIlIIllIllIl = llllllllllllllllIIlIIIlIIllIllIl.toUpperCase();
        for (TokenProviderWrapper llllllllllllllllIIlIIIlIIllIllll : llllllllllllllllIIlIIIlIIllIllII.tokenProviders) {
            Integer llllllllllllllllIIlIIIlIIlllIIII = llllllllllllllllIIlIIIlIIllIllll.getToken(llllllllllllllllIIlIIIlIIllIllIl);
            if (llllllllllllllllIIlIIIlIIlllIIII == null) continue;
            return llllllllllllllllIIlIIIlIIlllIIII;
        }
        return llllllllllllllllIIlIIIlIIllIllII.internalTokens.get(llllllllllllllllIIlIIIlIIllIllIl);
    }

    private static Phase getCurrentPhase() {
        if (currentPhase == Phase.NOT_INITIALISED) {
            MixinEnvironment.init(Phase.PREINIT);
        }
        return currentPhase;
    }

    @Deprecated
    public List<String> getMixinConfigs() {
        MixinEnvironment llllllllllllllllIIlIIIlIlIlIIlll;
        ArrayList llllllllllllllllIIlIIIlIlIlIIllI = (ArrayList)GlobalProperties.get(llllllllllllllllIIlIIIlIlIlIIlll.configsKey);
        if (llllllllllllllllIIlIIIlIlIlIIllI == null) {
            llllllllllllllllIIlIIIlIlIlIIllI = new ArrayList();
            GlobalProperties.put(llllllllllllllllIIlIIIlIlIlIIlll.configsKey, llllllllllllllllIIlIIIlIlIlIIllI);
        }
        return llllllllllllllllIIlIIIlIlIlIIllI;
    }

    public static CompatibilityLevel getCompatibilityLevel() {
        return compatibility;
    }

    public String getObfuscationContext() {
        MixinEnvironment llllllllllllllllIIlIIIlIIIlIllIl;
        return llllllllllllllllIIlIIIlIIIlIllIl.obfuscationContext;
    }

    public MixinEnvironment registerTokenProvider(IEnvironmentTokenProvider llllllllllllllllIIlIIIlIIllllIlI) {
        MixinEnvironment llllllllllllllllIIlIIIlIIllllIIl;
        if (llllllllllllllllIIlIIIlIIllllIlI != null && !llllllllllllllllIIlIIIlIIllllIIl.tokenProviderClasses.contains(llllllllllllllllIIlIIIlIIllllIlI.getClass().getName())) {
            String llllllllllllllllIIlIIIlIIlllllIl = llllllllllllllllIIlIIIlIIllllIlI.getClass().getName();
            TokenProviderWrapper llllllllllllllllIIlIIIlIIlllllII = new TokenProviderWrapper(llllllllllllllllIIlIIIlIIllllIlI, llllllllllllllllIIlIIIlIIllllIIl);
            logger.info("Adding new token provider {} to {}", new Object[]{llllllllllllllllIIlIIIlIIlllllIl, llllllllllllllllIIlIIIlIIllllIIl});
            llllllllllllllllIIlIIIlIIllllIIl.tokenProviders.add(llllllllllllllllIIlIIIlIIlllllII);
            llllllllllllllllIIlIIIlIIllllIIl.tokenProviderClasses.add(llllllllllllllllIIlIIIlIIlllllIl);
            Collections.sort(llllllllllllllllIIlIIIlIIllllIIl.tokenProviders);
        }
        return llllllllllllllllIIlIIIlIIllllIIl;
    }

    public Phase getPhase() {
        MixinEnvironment llllllllllllllllIIlIIIlIlIlIlllI;
        return llllllllllllllllIIlIIIlIlIlIlllI.phase;
    }

    private void printHeader(Object llllllllllllllllIIlIIIlIllIlIlIl) {
        MixinEnvironment llllllllllllllllIIlIIIlIllIlIIII;
        String llllllllllllllllIIlIIIlIllIlIlII = llllllllllllllllIIlIIIlIllIlIIII.getCodeSource();
        String llllllllllllllllIIlIIIlIllIlIIll = llllllllllllllllIIlIIIlIllIlIIII.service.getName();
        Side llllllllllllllllIIlIIIlIllIlIIlI = llllllllllllllllIIlIIIlIllIlIIII.getSide();
        logger.info("SpongePowered MIXIN Subsystem Version={} Source={} Service={} Env={}", new Object[]{llllllllllllllllIIlIIIlIllIlIlIl, llllllllllllllllIIlIIIlIllIlIlII, llllllllllllllllIIlIIIlIllIlIIll, llllllllllllllllIIlIIIlIllIlIIlI});
        boolean llllllllllllllllIIlIIIlIllIlIIIl = llllllllllllllllIIlIIIlIllIlIIII.getOption(Option.DEBUG_VERBOSE);
        if (llllllllllllllllIIlIIIlIllIlIIIl || llllllllllllllllIIlIIIlIllIlIIII.getOption(Option.DEBUG_EXPORT) || llllllllllllllllIIlIIIlIllIlIIII.getOption(Option.DEBUG_PROFILER)) {
            PrettyPrinter llllllllllllllllIIlIIIlIllIlIlll = new PrettyPrinter(32);
            llllllllllllllllIIlIIIlIllIlIlll.add("SpongePowered MIXIN%s", llllllllllllllllIIlIIIlIllIlIIIl ? " (Verbose debugging enabled)" : "").centre().hr();
            llllllllllllllllIIlIIIlIllIlIlll.kv("Code source", llllllllllllllllIIlIIIlIllIlIlII);
            llllllllllllllllIIlIIIlIllIlIlll.kv("Internal Version", llllllllllllllllIIlIIIlIllIlIlIl);
            llllllllllllllllIIlIIIlIllIlIlll.kv("Java 8 Supported", CompatibilityLevel.JAVA_8.isSupported()).hr();
            llllllllllllllllIIlIIIlIllIlIlll.kv("Service Name", llllllllllllllllIIlIIIlIllIlIIll);
            llllllllllllllllIIlIIIlIllIlIlll.kv("Service Class", llllllllllllllllIIlIIIlIllIlIIII.service.getClass().getName()).hr();
            for (Option llllllllllllllllIIlIIIlIllIllIII : Option.values()) {
                StringBuilder llllllllllllllllIIlIIIlIllIllIIl = new StringBuilder();
                for (int llllllllllllllllIIlIIIlIllIllIlI = 0; llllllllllllllllIIlIIIlIllIllIlI < llllllllllllllllIIlIIIlIllIllIII.depth; ++llllllllllllllllIIlIIIlIllIllIlI) {
                    llllllllllllllllIIlIIIlIllIllIIl.append("- ");
                }
                llllllllllllllllIIlIIIlIllIlIlll.kv(llllllllllllllllIIlIIIlIllIllIII.property, "%s<%s>", new Object[]{llllllllllllllllIIlIIIlIllIllIIl, llllllllllllllllIIlIIIlIllIllIII});
            }
            llllllllllllllllIIlIIIlIllIlIlll.hr().kv("Detected Side", (Object)llllllllllllllllIIlIIIlIllIlIIlI);
            llllllllllllllllIIlIIIlIllIlIlll.print(System.err);
        }
    }

    public void audit() {
        MixinEnvironment llllllllllllllllIIlIIIlIIIIllllI;
        Object llllllllllllllllIIlIIIlIIIIlllIl = llllllllllllllllIIlIIIlIIIIllllI.getActiveTransformer();
        if (llllllllllllllllIIlIIIlIIIIlllIl instanceof MixinTransformer) {
            MixinTransformer llllllllllllllllIIlIIIlIIIIlllll = (MixinTransformer)llllllllllllllllIIlIIIlIIIIlllIl;
            llllllllllllllllIIlIIIlIIIIlllll.audit(llllllllllllllllIIlIIIlIIIIllllI);
        }
    }

    MixinEnvironment(Phase llllllllllllllllIIlIIIlIlllIllIl) {
        MixinEnvironment llllllllllllllllIIlIIIlIlllIlllI;
        llllllllllllllllIIlIIIlIlllIlllI.tokenProviderClasses = new HashSet<String>();
        llllllllllllllllIIlIIIlIlllIlllI.tokenProviders = new ArrayList<TokenProviderWrapper>();
        llllllllllllllllIIlIIIlIlllIlllI.internalTokens = new HashMap<String, Integer>();
        llllllllllllllllIIlIIIlIlllIlllI.remappers = new RemapperChain();
        llllllllllllllllIIlIIIlIlllIlllI.obfuscationContext = null;
        llllllllllllllllIIlIIIlIlllIlllI.service = MixinService.getService();
        llllllllllllllllIIlIIIlIlllIlllI.phase = llllllllllllllllIIlIIIlIlllIllIl;
        llllllllllllllllIIlIIIlIlllIlllI.configsKey = String.valueOf(new StringBuilder().append("mixin.configs.").append(llllllllllllllllIIlIIIlIlllIlllI.phase.name.toLowerCase()));
        String llllllllllllllllIIlIIIlIlllIllll = llllllllllllllllIIlIIIlIlllIlllI.getVersion();
        if (llllllllllllllllIIlIIIlIlllIllll == null || !"0.7.4".equals(llllllllllllllllIIlIIIlIlllIllll)) {
            throw new MixinException("Environment conflict, mismatched versions or you didn't call MixinBootstrap.init()");
        }
        llllllllllllllllIIlIIIlIlllIlllI.service.checkEnv(llllllllllllllllIIlIIIlIlllIlllI);
        llllllllllllllllIIlIIIlIlllIlllI.options = new boolean[Option.values().length];
        for (Option llllllllllllllllIIlIIIlIllllIIlI : Option.values()) {
            llllllllllllllllIIlIIIlIlllIlllI.options[llllllllllllllllIIlIIIlIllllIIlI.ordinal()] = llllllllllllllllIIlIIIlIllllIIlI.getBooleanValue();
        }
        if (showHeader) {
            showHeader = false;
            llllllllllllllllIIlIIIlIlllIlllI.printHeader(llllllllllllllllIIlIIIlIlllIllll);
        }
    }

    public MixinEnvironment registerTokenProviderClass(String llllllllllllllllIIlIIIlIlIIIIllI) {
        MixinEnvironment llllllllllllllllIIlIIIlIlIIIIlIl;
        if (!llllllllllllllllIIlIIIlIlIIIIlIl.tokenProviderClasses.contains(llllllllllllllllIIlIIIlIlIIIIllI)) {
            try {
                Class<?> llllllllllllllllIIlIIIlIlIIIlIlI = llllllllllllllllIIlIIIlIlIIIIlIl.service.getClassProvider().findClass(llllllllllllllllIIlIIIlIlIIIIllI, true);
                IEnvironmentTokenProvider llllllllllllllllIIlIIIlIlIIIlIIl = (IEnvironmentTokenProvider)llllllllllllllllIIlIIIlIlIIIlIlI.newInstance();
                llllllllllllllllIIlIIIlIlIIIIlIl.registerTokenProvider(llllllllllllllllIIlIIIlIlIIIlIIl);
            }
            catch (Throwable llllllllllllllllIIlIIIlIlIIIlIII) {
                logger.error(String.valueOf(new StringBuilder().append("Error instantiating ").append(llllllllllllllllIIlIIIlIlIIIIllI)), llllllllllllllllIIlIIIlIlIIIlIII);
            }
        }
        return llllllllllllllllIIlIIIlIlIIIIlIl;
    }

    public String getVersion() {
        return (String)GlobalProperties.get("mixin.initialised");
    }

    public void setOption(Option llllllllllllllllIIlIIIlIIlIIIlII, boolean llllllllllllllllIIlIIIlIIlIIIIII) {
        llllllllllllllllIIlIIIlIIlIIIlIl.options[llllllllllllllllIIlIIIlIIlIIIlII.ordinal()] = llllllllllllllllIIlIIIlIIlIIIIII;
    }

    public String toString() {
        MixinEnvironment llllllllllllllllIIlIIIIllllllIIl;
        return String.format("%s[%s]", llllllllllllllllIIlIIIIllllllIIl.getClass().getSimpleName(), llllllllllllllllIIlIIIIllllllIIl.phase);
    }

    public static MixinEnvironment getEnvironment(Phase llllllllllllllllIIlIIIIllllIllIl) {
        if (llllllllllllllllIIlIIIIllllIllIl == null) {
            return Phase.DEFAULT.getEnvironment();
        }
        return llllllllllllllllIIlIIIIllllIllIl.getEnvironment();
    }

    public String getRefmapObfuscationContext() {
        MixinEnvironment llllllllllllllllIIlIIIlIIIlIlIIl;
        String llllllllllllllllIIlIIIlIIIlIlIII = Option.OBFUSCATION_TYPE.getStringValue();
        if (llllllllllllllllIIlIIIlIIIlIlIII != null) {
            return llllllllllllllllIIlIIIlIIIlIlIII;
        }
        return llllllllllllllllIIlIIIlIIIlIlIIl.obfuscationContext;
    }

    void registerConfig(String llllllllllllllllIIlIIIlIlIIllIIl) {
        MixinEnvironment llllllllllllllllIIlIIIlIlIIllIlI;
        List<String> llllllllllllllllIIlIIIlIlIIllIII = llllllllllllllllIIlIIIlIlIIllIlI.getMixinConfigs();
        if (!llllllllllllllllIIlIIIlIlIIllIII.contains(llllllllllllllllIIlIIIlIlIIllIIl)) {
            llllllllllllllllIIlIIIlIlIIllIII.add(llllllllllllllllIIlIIIlIlIIllIIl);
        }
    }

    public boolean getOption(Option llllllllllllllllIIlIIIlIIlIIlIIl) {
        MixinEnvironment llllllllllllllllIIlIIIlIIlIIlIlI;
        return llllllllllllllllIIlIIIlIIlIIlIlI.options[llllllllllllllllIIlIIIlIIlIIlIIl.ordinal()];
    }

    @Deprecated
    public Set<String> getErrorHandlerClasses() {
        return Mixins.getErrorHandlerClasses();
    }

    static {
        excludeTransformers = Sets.newHashSet((Object[])new String[]{"net.minecraftforge.fml.common.asm.transformers.EventSubscriptionTransformer", "cpw.mods.fml.common.asm.transformers.EventSubscriptionTransformer", "net.minecraftforge.fml.common.asm.transformers.TerminalTransformer", "cpw.mods.fml.common.asm.transformers.TerminalTransformer"});
        currentPhase = Phase.NOT_INITIALISED;
        compatibility = Option.DEFAULT_COMPATIBILITY_LEVEL.getEnumValue(CompatibilityLevel.JAVA_6);
        showHeader = true;
        logger = LogManager.getLogger((String)"mixin");
        profiler = new Profiler();
    }

    public <E extends Enum<E>> E getOption(Option llllllllllllllllIIlIIIlIIIllIllI, E llllllllllllllllIIlIIIlIIIllIlll) {
        return llllllllllllllllIIlIIIlIIIllIllI.getEnumValue(llllllllllllllllIIlIIIlIIIllIlll);
    }

    public static Profiler getProfiler() {
        return profiler;
    }

    @Deprecated
    public MixinEnvironment addConfiguration(String llllllllllllllllIIlIIIlIlIlIIIII) {
        MixinEnvironment llllllllllllllllIIlIIIlIlIIlllll;
        logger.warn("MixinEnvironment::addConfiguration is deprecated and will be removed. Use Mixins::addConfiguration instead!");
        Mixins.addConfiguration(llllllllllllllllIIlIIIlIlIlIIIII, llllllllllllllllIIlIIIlIlIIlllll);
        return llllllllllllllllIIlIIIlIlIIlllll;
    }

    public void setActiveTransformer(ITransformer llllllllllllllllIIlIIIlIIllIIIlI) {
        if (llllllllllllllllIIlIIIlIIllIIIlI != null) {
            GlobalProperties.put("mixin.transformer", llllllllllllllllIIlIIIlIIllIIIlI);
        }
    }

    public static void init(Phase llllllllllllllllIIlIIIIlllllIIlI) {
        if (currentPhase == Phase.NOT_INITIALISED) {
            currentPhase = llllllllllllllllIIlIIIIlllllIIlI;
            MixinEnvironment llllllllllllllllIIlIIIIlllllIlII = MixinEnvironment.getEnvironment(llllllllllllllllIIlIIIIlllllIIlI);
            MixinEnvironment.getProfiler().setActive(llllllllllllllllIIlIIIIlllllIlII.getOption(Option.DEBUG_PROFILER));
            MixinLogger llllllllllllllllIIlIIIIlllllIIII = new MixinLogger();
        }
    }

    public void setObfuscationContext(String llllllllllllllllIIlIIIlIIIlIllll) {
        llllllllllllllllIIlIIIlIIIllIIlI.obfuscationContext = llllllllllllllllIIlIIIlIIIlIllll;
    }

    public Side getSide() {
        MixinEnvironment llllllllllllllllIIlIIIlIIlIlIlIl;
        if (llllllllllllllllIIlIIIlIIlIlIlIl.side == null) {
            for (Side llllllllllllllllIIlIIIlIIlIlIllI : Side.values()) {
                if (!llllllllllllllllIIlIIIlIIlIlIllI.detect()) continue;
                llllllllllllllllIIlIIIlIIlIlIlIl.side = llllllllllllllllIIlIIIlIIlIlIllI;
                break;
            }
        }
        return llllllllllllllllIIlIIIlIIlIlIlIl.side != null ? llllllllllllllllIIlIIIlIIlIlIlIl.side : Side.UNKNOWN;
    }

    static void gotoPhase(Phase llllllllllllllllIIlIIIIllllIIIll) {
        if (llllllllllllllllIIlIIIIllllIIIll == null || llllllllllllllllIIlIIIIllllIIIll.ordinal < 0) {
            throw new IllegalArgumentException("Cannot go to the specified phase, phase is null or invalid");
        }
        if (llllllllllllllllIIlIIIIllllIIIll.ordinal > MixinEnvironment.getCurrentPhase().ordinal) {
            MixinService.getService().beginPhase();
        }
        if (llllllllllllllllIIlIIIIllllIIIll == Phase.DEFAULT) {
            org.apache.logging.log4j.core.Logger llllllllllllllllIIlIIIIllllIIlII = (org.apache.logging.log4j.core.Logger)LogManager.getLogger((String)"FML");
            llllllllllllllllIIlIIIIllllIIlII.removeAppender((Appender)MixinLogger.appender);
        }
        currentPhase = llllllllllllllllIIlIIIIllllIIIll;
        currentEnvironment = MixinEnvironment.getEnvironment(MixinEnvironment.getCurrentPhase());
    }

    public static MixinEnvironment getCurrentEnvironment() {
        if (currentEnvironment == null) {
            currentEnvironment = MixinEnvironment.getEnvironment(MixinEnvironment.getCurrentPhase());
        }
        return currentEnvironment;
    }

    public void addTransformerExclusion(String llllllllllllllllIIlIIIlIIIIlIIll) {
        excludeTransformers.add(llllllllllllllllIIlIIIlIIIIlIIll);
        llllllllllllllllIIlIIIlIIIIlIlII.transformers = null;
    }

    @Deprecated
    public MixinEnvironment registerErrorHandlerClass(String llllllllllllllllIIlIIIlIlIIIllll) {
        MixinEnvironment llllllllllllllllIIlIIIlIlIIlIIII;
        Mixins.registerErrorHandlerClass(llllllllllllllllIIlIIIlIlIIIllll);
        return llllllllllllllllIIlIIIlIlIIlIIII;
    }

    private String getCodeSource() {
        try {
            MixinEnvironment llllllllllllllllIIlIIIlIlIlllIII;
            return llllllllllllllllIIlIIIlIlIlllIII.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
        }
        catch (Throwable llllllllllllllllIIlIIIlIlIlllIlI) {
            return "Unknown";
        }
    }

    public static MixinEnvironment getDefaultEnvironment() {
        return MixinEnvironment.getEnvironment(Phase.DEFAULT);
    }

    public Object getActiveTransformer() {
        return GlobalProperties.get("mixin.transformer");
    }

    public List<ILegacyClassTransformer> getTransformers() {
        MixinEnvironment llllllllllllllllIIlIIIlIIIIlIlll;
        if (llllllllllllllllIIlIIIlIIIIlIlll.transformers == null) {
            llllllllllllllllIIlIIIlIIIIlIlll.buildTransformerDelegationList();
        }
        return Collections.unmodifiableList(llllllllllllllllIIlIIIlIIIIlIlll.transformers);
    }

    public MixinEnvironment setSide(Side llllllllllllllllIIlIIIlIIlIllllI) {
        MixinEnvironment llllllllllllllllIIlIIIlIIlIlllll;
        if (llllllllllllllllIIlIIIlIIlIllllI != null && llllllllllllllllIIlIIIlIIlIlllll.getSide() == Side.UNKNOWN && llllllllllllllllIIlIIIlIIlIllllI != Side.UNKNOWN) {
            llllllllllllllllIIlIIIlIIlIlllll.side = llllllllllllllllIIlIIIlIIlIllllI;
        }
        return llllllllllllllllIIlIIIlIIlIlllll;
    }

    static class TokenProviderWrapper
    implements Comparable<TokenProviderWrapper> {
        private final /* synthetic */ MixinEnvironment environment;
        private static /* synthetic */ int nextOrder;
        private final /* synthetic */ int order;
        private final /* synthetic */ IEnvironmentTokenProvider provider;
        private final /* synthetic */ int priority;

        public IEnvironmentTokenProvider getProvider() {
            TokenProviderWrapper lIIlIIIlIIIIlIl;
            return lIIlIIIlIIIIlIl.provider;
        }

        @Override
        public int compareTo(TokenProviderWrapper lIIlIIIlIIIlIIl) {
            TokenProviderWrapper lIIlIIIlIIIlIII;
            if (lIIlIIIlIIIlIIl == null) {
                return 0;
            }
            if (lIIlIIIlIIIlIIl.priority == lIIlIIIlIIIlIII.priority) {
                return lIIlIIIlIIIlIIl.order - lIIlIIIlIIIlIII.order;
            }
            return lIIlIIIlIIIlIIl.priority - lIIlIIIlIIIlIII.priority;
        }

        static {
            nextOrder = 0;
        }

        public TokenProviderWrapper(IEnvironmentTokenProvider lIIlIIIlIIlIIIl, MixinEnvironment lIIlIIIlIIIllIl) {
            TokenProviderWrapper lIIlIIIlIIIllll;
            lIIlIIIlIIIllll.provider = lIIlIIIlIIlIIIl;
            lIIlIIIlIIIllll.environment = lIIlIIIlIIIllIl;
            lIIlIIIlIIIllll.order = nextOrder++;
            lIIlIIIlIIIllll.priority = lIIlIIIlIIlIIIl.getPriority();
        }

        Integer getToken(String lIIlIIIlIIIIIII) {
            TokenProviderWrapper lIIlIIIlIIIIIIl;
            return lIIlIIIlIIIIIIl.provider.getToken(lIIlIIIlIIIIIII, lIIlIIIlIIIIIIl.environment);
        }
    }

    public static final class Phase {
        static final /* synthetic */ List<Phase> phases;
        public static final /* synthetic */ Phase INIT;
        public static final /* synthetic */ Phase PREINIT;
        static final /* synthetic */ Phase NOT_INITIALISED;
        private /* synthetic */ MixinEnvironment environment;
        final /* synthetic */ String name;
        final /* synthetic */ int ordinal;
        public static final /* synthetic */ Phase DEFAULT;

        MixinEnvironment getEnvironment() {
            Phase llIIIlllIIIlllI;
            if (llIIIlllIIIlllI.ordinal < 0) {
                throw new IllegalArgumentException("Cannot access the NOT_INITIALISED environment");
            }
            if (llIIIlllIIIlllI.environment == null) {
                llIIIlllIIIlllI.environment = new MixinEnvironment(llIIIlllIIIlllI);
            }
            return llIIIlllIIIlllI.environment;
        }

        public String toString() {
            Phase llIIIlllIIllIII;
            return llIIIlllIIllIII.name;
        }

        private Phase(int llIIIlllIIlllll, String llIIIlllIIllIll) {
            Phase llIIIlllIIlllIl;
            llIIIlllIIlllIl.ordinal = llIIIlllIIlllll;
            llIIIlllIIlllIl.name = llIIIlllIIllIll;
        }

        static {
            NOT_INITIALISED = new Phase(-1, "NOT_INITIALISED");
            PREINIT = new Phase(0, "PREINIT");
            INIT = new Phase(1, "INIT");
            DEFAULT = new Phase(2, "DEFAULT");
            phases = ImmutableList.of((Object)PREINIT, (Object)INIT, (Object)DEFAULT);
        }

        public static Phase forName(String llIIIlllIIlIIlI) {
            for (Phase llIIIlllIIlIlII : phases) {
                if (!llIIIlllIIlIlII.name.equals(llIIIlllIIlIIlI)) continue;
                return llIIIlllIIlIlII;
            }
            return null;
        }
    }

    public static final class Option
    extends Enum<Option> {
        public static final /* synthetic */ /* enum */ Option REFMAP_REMAP_RESOURCE;
        public static final /* synthetic */ /* enum */ Option DEBUG_PROFILER;
        final /* synthetic */ boolean isFlag;
        final /* synthetic */ String property;
        final /* synthetic */ int depth;
        public static final /* synthetic */ /* enum */ Option HOT_SWAP;
        public static final /* synthetic */ /* enum */ Option DEFAULT_COMPATIBILITY_LEVEL;
        public static final /* synthetic */ /* enum */ Option DEBUG_VERIFY;
        public static final /* synthetic */ /* enum */ Option IGNORE_CONSTRAINTS;
        public static final /* synthetic */ /* enum */ Option OBFUSCATION_TYPE;
        final /* synthetic */ Inherit inheritance;
        public static final /* synthetic */ /* enum */ Option DEBUG_INJECTORS;
        private static final /* synthetic */ String PREFIX;
        public static final /* synthetic */ /* enum */ Option DISABLE_REFMAP;
        public static final /* synthetic */ /* enum */ Option CHECK_IMPLEMENTS_STRICT;
        public static final /* synthetic */ /* enum */ Option INITIALISER_INJECTION_MODE;
        public static final /* synthetic */ /* enum */ Option DEBUG_TARGETS;
        public static final /* synthetic */ /* enum */ Option DEBUG_EXPORT_FILTER;
        public static final /* synthetic */ /* enum */ Option DEBUG_EXPORT;
        public static final /* synthetic */ /* enum */ Option REFMAP_REMAP_SOURCE_ENV;
        public static final /* synthetic */ /* enum */ Option DEBUG_ALL;
        public static final /* synthetic */ /* enum */ Option CHECK_ALL;
        public static final /* synthetic */ /* enum */ Option SHIFT_BY_VIOLATION_BEHAVIOUR;
        public static final /* synthetic */ /* enum */ Option ENVIRONMENT;
        public static final /* synthetic */ /* enum */ Option DEBUG_UNIQUE;
        final /* synthetic */ String defaultValue;
        private static final /* synthetic */ Option[] $VALUES;
        public static final /* synthetic */ /* enum */ Option REFMAP_REMAP;
        public static final /* synthetic */ /* enum */ Option IGNORE_REQUIRED;
        public static final /* synthetic */ /* enum */ Option DEBUG_VERBOSE;
        public static final /* synthetic */ /* enum */ Option CHECK_IMPLEMENTS;
        public static final /* synthetic */ /* enum */ Option DEBUG_EXPORT_DECOMPILE_THREADED;
        public static final /* synthetic */ /* enum */ Option DEBUG_STRICT;
        public static final /* synthetic */ /* enum */ Option DUMP_TARGET_ON_FAILURE;
        public static final /* synthetic */ /* enum */ Option DEBUG_EXPORT_DECOMPILE;
        final /* synthetic */ Option parent;

        final boolean getBooleanValue() {
            Option lIlIlllllIllll;
            if (lIlIlllllIllll.inheritance == Inherit.ALWAYS_FALSE) {
                return false;
            }
            boolean lIlIllllllIIIl = lIlIlllllIllll.getLocalBooleanValue(false);
            if (lIlIlllllIllll.inheritance == Inherit.INDEPENDENT) {
                return lIlIllllllIIIl;
            }
            boolean lIlIllllllIIII = lIlIllllllIIIl || lIlIlllllIllll.getInheritedBooleanValue();
            return lIlIlllllIllll.inheritance == Inherit.INHERIT ? lIlIllllllIIII : lIlIlllllIllll.getLocalBooleanValue(lIlIllllllIIII);
        }

        Option getParent() {
            Option lIllIIIIIIIllI;
            return lIllIIIIIIIllI.parent;
        }

        private boolean getLocalBooleanValue(boolean lIlIlllllllIIl) {
            Option lIlIllllllllII;
            return Boolean.parseBoolean(System.getProperty(lIlIllllllllII.property, Boolean.toString(lIlIlllllllIIl)));
        }

        private Option(Option lIllIIIIIlIllI, Inherit lIllIIIIIIllII, String lIllIIIIIlIlII, boolean lIllIIIIIIlIlI, String lIllIIIIIIlIIl) {
            Option lIllIIIIIlIlll;
            lIllIIIIIlIlll.parent = lIllIIIIIlIllI;
            lIllIIIIIlIlll.inheritance = lIllIIIIIIllII;
            lIllIIIIIlIlll.property = String.valueOf(new StringBuilder().append(lIllIIIIIlIllI != null ? lIllIIIIIlIllI.property : "mixin").append(".").append(lIllIIIIIlIlII));
            lIllIIIIIlIlll.defaultValue = lIllIIIIIIlIIl;
            lIllIIIIIlIlll.isFlag = lIllIIIIIIlIlI;
            int lIllIIIIIlIIIl = 0;
            while (lIllIIIIIlIllI != null) {
                lIllIIIIIlIllI = lIllIIIIIlIllI.parent;
                ++lIllIIIIIlIIIl;
            }
            lIllIIIIIlIlll.depth = lIllIIIIIlIIIl;
        }

        final String getStringValue() {
            Option lIlIlllllIlIll;
            return lIlIlllllIlIll.parent == null || lIlIlllllIlIll.parent.getBooleanValue() ? System.getProperty(lIlIlllllIlIll.property, lIlIlllllIlIll.defaultValue) : lIlIlllllIlIll.defaultValue;
        }

        private Option(Inherit lIllIIlIlIIlII, String lIllIIlIIllllI) {
            lIllIIlIlIIlIl(null, lIllIIlIlIIlII, lIllIIlIIllllI, true);
            Option lIllIIlIlIIlIl;
        }

        private Option(Option lIllIIIllllIII, String lIllIIIlllllII) {
            lIllIIIllllllI(lIllIIIllllIII, Inherit.INHERIT, lIllIIIlllllII, true);
            Option lIllIIIllllllI;
        }

        static {
            PREFIX = "mixin";
            DEBUG_ALL = new Option("debug");
            DEBUG_EXPORT = new Option(DEBUG_ALL, "export");
            DEBUG_EXPORT_FILTER = new Option(DEBUG_EXPORT, "filter", false);
            DEBUG_EXPORT_DECOMPILE = new Option(DEBUG_EXPORT, Inherit.ALLOW_OVERRIDE, "decompile");
            DEBUG_EXPORT_DECOMPILE_THREADED = new Option(DEBUG_EXPORT_DECOMPILE, Inherit.ALLOW_OVERRIDE, "async");
            DEBUG_VERIFY = new Option(DEBUG_ALL, "verify");
            DEBUG_VERBOSE = new Option(DEBUG_ALL, "verbose");
            DEBUG_INJECTORS = new Option(DEBUG_ALL, "countInjections");
            DEBUG_STRICT = new Option(DEBUG_ALL, Inherit.INDEPENDENT, "strict");
            DEBUG_UNIQUE = new Option(DEBUG_STRICT, "unique");
            DEBUG_TARGETS = new Option(DEBUG_STRICT, "targets");
            DEBUG_PROFILER = new Option(DEBUG_ALL, Inherit.ALLOW_OVERRIDE, "profiler");
            DUMP_TARGET_ON_FAILURE = new Option("dumpTargetOnFailure");
            CHECK_ALL = new Option("checks");
            CHECK_IMPLEMENTS = new Option(CHECK_ALL, "interfaces");
            CHECK_IMPLEMENTS_STRICT = new Option(CHECK_IMPLEMENTS, Inherit.ALLOW_OVERRIDE, "strict");
            IGNORE_CONSTRAINTS = new Option("ignoreConstraints");
            HOT_SWAP = new Option("hotSwap");
            ENVIRONMENT = new Option(Inherit.ALWAYS_FALSE, "env");
            OBFUSCATION_TYPE = new Option(ENVIRONMENT, Inherit.ALWAYS_FALSE, "obf");
            DISABLE_REFMAP = new Option(ENVIRONMENT, Inherit.INDEPENDENT, "disableRefMap");
            REFMAP_REMAP = new Option(ENVIRONMENT, Inherit.INDEPENDENT, "remapRefMap");
            REFMAP_REMAP_RESOURCE = new Option(ENVIRONMENT, Inherit.INDEPENDENT, "refMapRemappingFile", "");
            REFMAP_REMAP_SOURCE_ENV = new Option(ENVIRONMENT, Inherit.INDEPENDENT, "refMapRemappingEnv", "searge");
            IGNORE_REQUIRED = new Option(ENVIRONMENT, Inherit.INDEPENDENT, "ignoreRequired");
            DEFAULT_COMPATIBILITY_LEVEL = new Option(ENVIRONMENT, Inherit.INDEPENDENT, "compatLevel");
            SHIFT_BY_VIOLATION_BEHAVIOUR = new Option(ENVIRONMENT, Inherit.INDEPENDENT, "shiftByViolation", "warn");
            INITIALISER_INJECTION_MODE = new Option("initialiserInjectionMode", "default");
            $VALUES = new Option[]{DEBUG_ALL, DEBUG_EXPORT, DEBUG_EXPORT_FILTER, DEBUG_EXPORT_DECOMPILE, DEBUG_EXPORT_DECOMPILE_THREADED, DEBUG_VERIFY, DEBUG_VERBOSE, DEBUG_INJECTORS, DEBUG_STRICT, DEBUG_UNIQUE, DEBUG_TARGETS, DEBUG_PROFILER, DUMP_TARGET_ON_FAILURE, CHECK_ALL, CHECK_IMPLEMENTS, CHECK_IMPLEMENTS_STRICT, IGNORE_CONSTRAINTS, HOT_SWAP, ENVIRONMENT, OBFUSCATION_TYPE, DISABLE_REFMAP, REFMAP_REMAP, REFMAP_REMAP_RESOURCE, REFMAP_REMAP_SOURCE_ENV, IGNORE_REQUIRED, DEFAULT_COMPATIBILITY_LEVEL, SHIFT_BY_VIOLATION_BEHAVIOUR, INITIALISER_INJECTION_MODE};
        }

        <E extends Enum<E>> E getEnumValue(E lIlIllllIllllI) {
            Option lIlIlllllIIIlI;
            String lIlIlllllIIIII = System.getProperty(lIlIlllllIIIlI.property, lIlIllllIllllI.name());
            try {
                return (E)Enum.valueOf(lIlIllllIllllI.getClass(), lIlIlllllIIIII.toUpperCase());
            }
            catch (IllegalArgumentException lIlIlllllIIIll) {
                return lIlIllllIllllI;
            }
        }

        private Option(Option lIllIIIIllllII, String lIllIIIIlllIll, String lIllIIIIllIlII) {
            lIllIIIIllllIl(lIllIIIIllllII, Inherit.INHERIT, lIllIIIIlllIll, false, lIllIIIIllIlII);
            Option lIllIIIIllllIl;
        }

        private Option(Option lIllIIIlIIlllI, Inherit lIllIIIlIIllIl, String lIllIIIlIIIlIl, boolean lIllIIIlIIIlII) {
            lIllIIIlIIlIlI(lIllIIIlIIlllI, lIllIIIlIIllIl, lIllIIIlIIIlIl, lIllIIIlIIIlII, null);
            Option lIllIIIlIIlIlI;
        }

        private Option(Option lIllIIIlIllIIl, String lIllIIIlIllIII, boolean lIllIIIlIlllIl) {
            lIllIIIllIIIII(lIllIIIlIllIIl, Inherit.INHERIT, lIllIIIlIllIII, lIllIIIlIlllIl, null);
            Option lIllIIIllIIIII;
        }

        private Option(Option lIllIIIllIllll, Inherit lIllIIIllIlllI, String lIllIIIllIllIl) {
            lIllIIIllIllII(lIllIIIllIllll, lIllIIIllIlllI, lIllIIIllIllIl, true);
            Option lIllIIIllIllII;
        }

        private boolean getInheritedBooleanValue() {
            Option lIlIllllllIlll;
            return lIlIllllllIlll.parent != null && lIlIllllllIlll.parent.getBooleanValue();
        }

        public static Option valueOf(String lIllIIlIllIlIl) {
            return Enum.valueOf(Option.class, lIllIIlIllIlIl);
        }

        public static Option[] values() {
            return (Option[])$VALUES.clone();
        }

        private Option(String lIllIIlIIlIlll, boolean lIllIIlIIlIllI) {
            lIllIIlIIllIII(null, lIllIIlIIlIlll, lIllIIlIIlIllI);
            Option lIllIIlIIllIII;
        }

        private Option(String lIllIIlIlIllll) {
            lIllIIlIlIlllI(null, lIllIIlIlIllll, true);
            Option lIllIIlIlIlllI;
        }

        private Option(Option lIllIIIIlIlIll, Inherit lIllIIIIlIIIll, String lIllIIIIlIlIIl, String lIllIIIIlIIIIl) {
            lIllIIIIlIllII(lIllIIIIlIlIll, lIllIIIIlIIIll, lIllIIIIlIlIIl, false, lIllIIIIlIIIIl);
            Option lIllIIIIlIllII;
        }

        String getProperty() {
            Option lIllIIIIIIIIll;
            return lIllIIIIIIIIll.property;
        }

        public String toString() {
            Option lIllIIIIIIIIII;
            return lIllIIIIIIIIII.isFlag ? String.valueOf(lIllIIIIIIIIII.getBooleanValue()) : lIllIIIIIIIIII.getStringValue();
        }

        private Option(String lIllIIlIIIlIlI, String lIllIIlIIIlIIl) {
            lIllIIlIIIlIll(null, Inherit.INDEPENDENT, lIllIIlIIIlIlI, false, lIllIIlIIIlIIl);
            Option lIllIIlIIIlIll;
        }

        private static enum Inherit {
            INHERIT,
            ALLOW_OVERRIDE,
            INDEPENDENT,
            ALWAYS_FALSE;


            private Inherit() {
                Inherit lllllllllllllllllIllIIIllIIIlIIl;
            }
        }
    }

    public static enum Side {
        UNKNOWN{
            {
                1 llllllllllllllllllIlIlIlllIIllll;
            }

            @Override
            protected boolean detect() {
                return false;
            }
        }
        ,
        CLIENT{

            @Override
            protected boolean detect() {
                String lllllllllllllllllIllllIlIlIlIlIl = MixinService.getService().getSideName();
                return "CLIENT".equals(lllllllllllllllllIllllIlIlIlIlIl);
            }
            {
                2 lllllllllllllllllIllllIlIlIlllIl;
            }
        }
        ,
        SERVER{
            {
                3 lllllllllllllllllIlIllIlIIIlllll;
            }

            @Override
            protected boolean detect() {
                String lllllllllllllllllIlIllIlIIIllIIl = MixinService.getService().getSideName();
                return "SERVER".equals(lllllllllllllllllIlIllIlIIIllIIl) || "DEDICATEDSERVER".equals(lllllllllllllllllIlIllIlIIIllIIl);
            }
        };


        protected abstract boolean detect();

        private Side() {
            Side llllllllllllllllIlIIllIlIllIIIll;
        }
    }

    static class MixinLogger {
        static /* synthetic */ MixinAppender appender;

        public MixinLogger() {
            MixinLogger llllllllllllllllllIlIlllllIllllI;
            org.apache.logging.log4j.core.Logger llllllllllllllllllIlIlllllIlllll = (org.apache.logging.log4j.core.Logger)LogManager.getLogger((String)"FML");
            appender.start();
            llllllllllllllllllIlIlllllIlllll.addAppender((Appender)appender);
        }

        static {
            appender = new MixinAppender("MixinLogger", null, null);
        }

        static class MixinAppender
        extends AbstractAppender {
            protected MixinAppender(String lllllllllllllllllIllIllIIlllllll, Filter lllllllllllllllllIllIllIIllllllI, Layout<? extends Serializable> lllllllllllllllllIllIllIlIIIIIIl) {
                super(lllllllllllllllllIllIllIIlllllll, lllllllllllllllllIllIllIIllllllI, lllllllllllllllllIllIllIlIIIIIIl);
                MixinAppender lllllllllllllllllIllIllIlIIIIIII;
            }

            public void append(LogEvent lllllllllllllllllIllIllIIllllIIl) {
                if (lllllllllllllllllIllIllIIllllIIl.getLevel() == Level.DEBUG && "Validating minecraft".equals(lllllllllllllllllIllIllIIllllIIl.getMessage().getFormat())) {
                    MixinEnvironment.gotoPhase(Phase.INIT);
                }
            }
        }
    }

    public static class CompatibilityLevel
    extends Enum<CompatibilityLevel> {
        public static final /* synthetic */ /* enum */ CompatibilityLevel JAVA_8;
        private final /* synthetic */ int classVersion;
        private /* synthetic */ CompatibilityLevel maxCompatibleLevel;
        public static final /* synthetic */ /* enum */ CompatibilityLevel JAVA_7;
        private final /* synthetic */ int ver;
        private final /* synthetic */ boolean supportsMethodsInInterfaces;
        private static final /* synthetic */ int CLASS_V1_9;
        public static final /* synthetic */ /* enum */ CompatibilityLevel JAVA_6;
        private static final /* synthetic */ CompatibilityLevel[] $VALUES;
        public static final /* synthetic */ /* enum */ CompatibilityLevel JAVA_9;

        public boolean canElevateTo(CompatibilityLevel llllllllllllllllllIIlllIIIIIIlll) {
            CompatibilityLevel llllllllllllllllllIIlllIIIIIlIII;
            if (llllllllllllllllllIIlllIIIIIIlll == null || llllllllllllllllllIIlllIIIIIlIII.maxCompatibleLevel == null) {
                return true;
            }
            return llllllllllllllllllIIlllIIIIIIlll.ver <= llllllllllllllllllIIlllIIIIIlIII.maxCompatibleLevel.ver;
        }

        static {
            CLASS_V1_9 = 53;
            JAVA_6 = new CompatibilityLevel(6, 50, false);
            JAVA_7 = new CompatibilityLevel(7, 51, false){

                @Override
                boolean isSupported() {
                    return JavaVersion.current() >= 1.7;
                }
                {
                    1 llllllllllllllllIIllIIIIllIlllII;
                }
            };
            JAVA_8 = new CompatibilityLevel(8, 52, true){

                @Override
                boolean isSupported() {
                    return JavaVersion.current() >= 1.8;
                }
                {
                    2 lllllIIlIIIIlll;
                }
            };
            JAVA_9 = new CompatibilityLevel(9, 53, true){

                @Override
                boolean isSupported() {
                    return false;
                }
                {
                    3 llllllllllllllllIIIlIllIlIlIlIIl;
                }
            };
            $VALUES = new CompatibilityLevel[]{JAVA_6, JAVA_7, JAVA_8, JAVA_9};
        }

        public static CompatibilityLevel valueOf(String llllllllllllllllllIIlllIIIlIllll) {
            return Enum.valueOf(CompatibilityLevel.class, llllllllllllllllllIIlllIIIlIllll);
        }

        public boolean supportsMethodsInInterfaces() {
            CompatibilityLevel llllllllllllllllllIIlllIIIIlIIlI;
            return llllllllllllllllllIIlllIIIIlIIlI.supportsMethodsInInterfaces;
        }

        boolean isSupported() {
            return true;
        }

        public static CompatibilityLevel[] values() {
            return (CompatibilityLevel[])$VALUES.clone();
        }

        private CompatibilityLevel(int llllllllllllllllllIIlllIIIlIIllI, int llllllllllllllllllIIlllIIIIlllll, boolean llllllllllllllllllIIlllIIIlIIlII) {
            CompatibilityLevel llllllllllllllllllIIlllIIIlIIIll;
            llllllllllllllllllIIlllIIIlIIIll.ver = llllllllllllllllllIIlllIIIlIIllI;
            llllllllllllllllllIIlllIIIlIIIll.classVersion = llllllllllllllllllIIlllIIIIlllll;
            llllllllllllllllllIIlllIIIlIIIll.supportsMethodsInInterfaces = llllllllllllllllllIIlllIIIlIIlII;
        }

        private void setMaxCompatibleLevel(CompatibilityLevel llllllllllllllllllIIlllIIIIllIlI) {
            llllllllllllllllllIIlllIIIIllIIl.maxCompatibleLevel = llllllllllllllllllIIlllIIIIllIlI;
        }

        public int classVersion() {
            CompatibilityLevel llllllllllllllllllIIlllIIIIlIlII;
            return llllllllllllllllllIIlllIIIIlIlII.classVersion;
        }

        public boolean isAtLeast(CompatibilityLevel llllllllllllllllllIIlllIIIIIlIll) {
            CompatibilityLevel llllllllllllllllllIIlllIIIIIlllI;
            return llllllllllllllllllIIlllIIIIIlIll == null || llllllllllllllllllIIlllIIIIIlllI.ver >= llllllllllllllllllIIlllIIIIIlIll.ver;
        }

        public boolean canSupport(CompatibilityLevel llllllllllllllllllIIllIlllllllll) {
            CompatibilityLevel llllllllllllllllllIIlllIIIIIIIlI;
            if (llllllllllllllllllIIllIlllllllll == null) {
                return true;
            }
            return llllllllllllllllllIIllIlllllllll.canElevateTo(llllllllllllllllllIIlllIIIIIIIlI);
        }
    }
}

