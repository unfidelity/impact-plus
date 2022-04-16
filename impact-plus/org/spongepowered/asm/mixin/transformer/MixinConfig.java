/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.annotations.SerializedName
 *  org.apache.logging.log4j.Level
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinInitialisationError;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IMixinConfig;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.injection.InjectionPoint;
import org.spongepowered.asm.mixin.refmap.IReferenceMapper;
import org.spongepowered.asm.mixin.refmap.ReferenceMapper;
import org.spongepowered.asm.mixin.refmap.RemappingReferenceMapper;
import org.spongepowered.asm.mixin.transformer.Config;
import org.spongepowered.asm.mixin.transformer.MixinInfo;
import org.spongepowered.asm.mixin.transformer.throwables.InvalidMixinException;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.MixinService;
import org.spongepowered.asm.util.VersionNumber;

final class MixinConfig
implements Comparable<MixinConfig>,
IMixinConfig {
    private final transient /* synthetic */ Map<String, List<MixinInfo>> mixinMapping;
    @SerializedName(value="priority")
    private /* synthetic */ int priority;
    private transient /* synthetic */ IReferenceMapper refMapper;
    @SerializedName(value="plugin")
    private /* synthetic */ String pluginClassName;
    private final transient /* synthetic */ List<IListener> listeners;
    @SerializedName(value="mixinPriority")
    private /* synthetic */ int mixinPriority;
    private final transient /* synthetic */ List<MixinInfo> mixins;
    private transient /* synthetic */ MixinEnvironment env;
    @SerializedName(value="setSourceFile")
    private /* synthetic */ boolean setSourceFile;
    @SerializedName(value="required")
    private /* synthetic */ boolean required;
    private final /* synthetic */ Logger logger;
    @SerializedName(value="overwrites")
    private /* synthetic */ OverwriteOptions overwriteOptions;
    @SerializedName(value="verbose")
    private /* synthetic */ boolean verboseLogging;
    private transient /* synthetic */ boolean prepared;
    private static final /* synthetic */ Set<String> globalMixinList;
    private transient /* synthetic */ IMixinConfigPlugin plugin;
    @SerializedName(value="injectors")
    private /* synthetic */ InjectorOptions injectorOptions;
    @SerializedName(value="mixins")
    private /* synthetic */ List<String> mixinClasses;
    @SerializedName(value="target")
    private /* synthetic */ String selector;
    private static /* synthetic */ int configOrder;
    private transient /* synthetic */ boolean visited;
    private transient /* synthetic */ Config handle;
    private transient /* synthetic */ IMixinService service;
    @SerializedName(value="server")
    private /* synthetic */ List<String> mixinClassesServer;
    private final transient /* synthetic */ Set<String> unhandledTargets;
    @SerializedName(value="client")
    private /* synthetic */ List<String> mixinClassesClient;
    private transient /* synthetic */ String name;
    @SerializedName(value="minVersion")
    private /* synthetic */ String version;
    @SerializedName(value="package")
    private /* synthetic */ String mixinPackage;
    private final transient /* synthetic */ int order;
    @SerializedName(value="refmap")
    private /* synthetic */ String refMapperConfig;
    @SerializedName(value="compatibilityLevel")
    private /* synthetic */ String compatibility;

    public int getDefaultRequiredInjections() {
        MixinConfig llllllllllllllllllIllllIlIIlllIl;
        return llllllllllllllllllIllllIlIIlllIl.injectorOptions.defaultRequireValue;
    }

    private boolean onLoad(IMixinService llllllllllllllllllIllllllIIIlIlI, String llllllllllllllllllIllllllIIIllll, MixinEnvironment llllllllllllllllllIllllllIIIllIl) {
        MixinConfig llllllllllllllllllIllllllIlIIlll;
        llllllllllllllllllIllllllIlIIlll.service = llllllllllllllllllIllllllIIIlIlI;
        llllllllllllllllllIllllllIlIIlll.name = llllllllllllllllllIllllllIIIllll;
        llllllllllllllllllIllllllIlIIlll.env = llllllllllllllllllIllllllIlIIlll.parseSelector(llllllllllllllllllIllllllIlIIlll.selector, llllllllllllllllllIllllllIIIllIl);
        llllllllllllllllllIllllllIlIIlll.required = llllllllllllllllllIllllllIlIIlll.required & !llllllllllllllllllIllllllIlIIlll.env.getOption(MixinEnvironment.Option.IGNORE_REQUIRED);
        llllllllllllllllllIllllllIlIIlll.initCompatibilityLevel();
        llllllllllllllllllIllllllIlIIlll.initInjectionPoints();
        return llllllllllllllllllIllllllIlIIlll.checkVersion();
    }

    public Level getLoggingLevel() {
        MixinConfig llllllllllllllllllIllllIIlIlIlIl;
        return llllllllllllllllllIllllIIlIlIlIl.verboseLogging ? Level.INFO : Level.DEBUG;
    }

    private MixinConfig() {
        MixinConfig llllllllllllllllllIllllllllIlIlI;
        llllllllllllllllllIllllllllIlIlI.logger = LogManager.getLogger((String)"mixin");
        llllllllllllllllllIllllllllIlIlI.mixinMapping = new HashMap<String, List<MixinInfo>>();
        llllllllllllllllllIllllllllIlIlI.unhandledTargets = new HashSet<String>();
        llllllllllllllllllIllllllllIlIlI.mixins = new ArrayList<MixinInfo>();
        llllllllllllllllllIllllllllIlIlI.priority = 1000;
        llllllllllllllllllIllllllllIlIlI.mixinPriority = 1000;
        llllllllllllllllllIllllllllIlIlI.setSourceFile = false;
        llllllllllllllllllIllllllllIlIlI.order = configOrder++;
        llllllllllllllllllIllllllllIlIlI.listeners = new ArrayList<IListener>();
        llllllllllllllllllIllllllllIlIlI.injectorOptions = new InjectorOptions();
        llllllllllllllllllIllllllllIlIlI.overwriteOptions = new OverwriteOptions();
        llllllllllllllllllIllllllllIlIlI.prepared = false;
        llllllllllllllllllIllllllllIlIlI.visited = false;
    }

    boolean isVisited() {
        MixinConfig llllllllllllllllllIllllIIllllIII;
        return llllllllllllllllllIllllIIllllIII.visited;
    }

    public boolean packageMatch(String llllllllllllllllllIllllIIlIIlllI) {
        MixinConfig llllllllllllllllllIllllIIlIIllll;
        return llllllllllllllllllIllllIIlIIlllI.startsWith(llllllllllllllllllIllllIIlIIllll.mixinPackage);
    }

    @Override
    public MixinEnvironment getEnvironment() {
        MixinConfig llllllllllllllllllIllllIlIlIllIl;
        return llllllllllllllllllIllllIlIlIllIl.env;
    }

    void addListener(IListener llllllllllllllllllIlllllIIllllll) {
        MixinConfig llllllllllllllllllIlllllIIlllllI;
        llllllllllllllllllIlllllIIlllllI.listeners.add(llllllllllllllllllIlllllIIllllll);
    }

    public String toString() {
        MixinConfig llllllllllllllllllIllllIIIlIIlll;
        return llllllllllllllllllIllllIIIlIIlll.name;
    }

    public boolean shouldSetSourceFile() {
        MixinConfig llllllllllllllllllIllllIIllIllIl;
        return llllllllllllllllllIllllIIllIllIl.setSourceFile;
    }

    private void initCompatibilityLevel() {
        MixinEnvironment.CompatibilityLevel llllllllllllllllllIlllllIlllIlIl;
        MixinConfig llllllllllllllllllIlllllIlllIlll;
        if (llllllllllllllllllIlllllIlllIlll.compatibility == null) {
            return;
        }
        MixinEnvironment.CompatibilityLevel llllllllllllllllllIlllllIlllIllI = MixinEnvironment.CompatibilityLevel.valueOf(llllllllllllllllllIlllllIlllIlll.compatibility.trim().toUpperCase());
        if (llllllllllllllllllIlllllIlllIllI == (llllllllllllllllllIlllllIlllIlIl = MixinEnvironment.getCompatibilityLevel())) {
            return;
        }
        if (llllllllllllllllllIlllllIlllIlIl.isAtLeast(llllllllllllllllllIlllllIlllIllI) && !llllllllllllllllllIlllllIlllIlIl.canSupport(llllllllllllllllllIlllllIlllIllI)) {
            throw new MixinInitialisationError(String.valueOf(new StringBuilder().append("Mixin config ").append(llllllllllllllllllIlllllIlllIlll.name).append(" requires compatibility level ").append((Object)llllllllllllllllllIlllllIlllIllI).append(" which is too old")));
        }
        if (!llllllllllllllllllIlllllIlllIlIl.canElevateTo(llllllllllllllllllIlllllIlllIllI)) {
            throw new MixinInitialisationError(String.valueOf(new StringBuilder().append("Mixin config ").append(llllllllllllllllllIlllllIlllIlll.name).append(" requires compatibility level ").append((Object)llllllllllllllllllIlllllIlllIllI).append(" which is prohibited by ").append((Object)llllllllllllllllllIlllllIlllIlIl)));
        }
        MixinEnvironment.setCompatibilityLevel(llllllllllllllllllIlllllIlllIllI);
    }

    @Override
    public Set<String> getTargets() {
        MixinConfig llllllllllllllllllIllllIIlIllIlI;
        return Collections.unmodifiableSet(llllllllllllllllllIllllIIlIllIlI.mixinMapping.keySet());
    }

    @Override
    public int compareTo(MixinConfig llllllllllllllllllIllllIIIlIIIIl) {
        MixinConfig llllllllllllllllllIllllIIIlIIlII;
        if (llllllllllllllllllIllllIIIlIIIIl == null) {
            return 0;
        }
        if (llllllllllllllllllIllllIIIlIIIIl.priority == llllllllllllllllllIllllIIIlIIlII.priority) {
            return llllllllllllllllllIllllIIIlIIlII.order - llllllllllllllllllIllllIIIlIIIIl.order;
        }
        return llllllllllllllllllIllllIIIlIIlII.priority - llllllllllllllllllIllllIIIlIIIIl.priority;
    }

    void postApply(String llllllllllllllllllIllllIlIlllIII, ClassNode llllllllllllllllllIllllIlIllIlll) {
        MixinConfig llllllllllllllllllIllllIlIlllIIl;
        llllllllllllllllllIllllIlIlllIIl.unhandledTargets.remove(llllllllllllllllllIllllIlIlllIII);
    }

    public String getDefaultInjectorGroup() {
        MixinConfig llllllllllllllllllIllllIlIIllIII;
        String llllllllllllllllllIllllIlIIllIIl = llllllllllllllllllIllllIlIIllIII.injectorOptions.defaultGroup;
        return llllllllllllllllllIllllIlIIllIIl != null && !llllllllllllllllllIllllIlIIllIIl.isEmpty() ? llllllllllllllllllIllllIlIIllIIl : "default";
    }

    @Override
    public boolean isRequired() {
        MixinConfig llllllllllllllllllIllllIlIlIllll;
        return llllllllllllllllllIllllIlIlIllll.required;
    }

    private static int getCollectionSize(Collection<?> ... llllllllllllllllllIllllIIIIIlIlI) {
        int llllllllllllllllllIllllIIIIIlIll = 0;
        for (Collection<?> llllllllllllllllllIllllIIIIIllIl : llllllllllllllllllIllllIIIIIlIlI) {
            if (llllllllllllllllllIllllIIIIIllIl == null) continue;
            llllllllllllllllllIllllIIIIIlIll += llllllllllllllllllIllllIIIIIllIl.size();
        }
        return llllllllllllllllllIllllIIIIIlIll;
    }

    private void prepareMixins(List<String> llllllllllllllllllIllllIllIIIlII, boolean llllllllllllllllllIllllIllIIIllI) {
        if (llllllllllllllllllIllllIllIIIlII == null) {
            return;
        }
        for (String llllllllllllllllllIllllIllIIlIIl : llllllllllllllllllIllllIllIIIlII) {
            MixinConfig llllllllllllllllllIllllIllIIlIII;
            String llllllllllllllllllIllllIllIIlIll = String.valueOf(new StringBuilder().append(llllllllllllllllllIllllIllIIlIII.mixinPackage).append(llllllllllllllllllIllllIllIIlIIl));
            if (llllllllllllllllllIllllIllIIlIIl == null || globalMixinList.contains(llllllllllllllllllIllllIllIIlIll)) continue;
            MixinInfo llllllllllllllllllIllllIllIIlIlI = null;
            try {
                llllllllllllllllllIllllIllIIlIlI = new MixinInfo(llllllllllllllllllIllllIllIIlIII.service, llllllllllllllllllIllllIllIIlIII, llllllllllllllllllIllllIllIIlIIl, true, llllllllllllllllllIllllIllIIlIII.plugin, llllllllllllllllllIllllIllIIIllI);
                if (llllllllllllllllllIllllIllIIlIlI.getTargetClasses().size() <= 0) continue;
                globalMixinList.add(llllllllllllllllllIllllIllIIlIll);
                for (String llllllllllllllllllIllllIllIIllll : llllllllllllllllllIllllIllIIlIlI.getTargetClasses()) {
                    String llllllllllllllllllIllllIllIlIIII = llllllllllllllllllIllllIllIIllll.replace('/', '.');
                    llllllllllllllllllIllllIllIIlIII.mixinsFor(llllllllllllllllllIllllIllIlIIII).add(llllllllllllllllllIllllIllIIlIlI);
                    llllllllllllllllllIllllIllIIlIII.unhandledTargets.add(llllllllllllllllllIllllIllIlIIII);
                }
                for (IListener llllllllllllllllllIllllIllIIlllI : llllllllllllllllllIllllIllIIlIII.listeners) {
                    llllllllllllllllllIllllIllIIlllI.onPrepare(llllllllllllllllllIllllIllIIlIlI);
                }
                llllllllllllllllllIllllIllIIlIII.mixins.add(llllllllllllllllllIllllIllIIlIlI);
            }
            catch (InvalidMixinException llllllllllllllllllIllllIllIIllIl) {
                if (llllllllllllllllllIllllIllIIlIII.required) {
                    throw llllllllllllllllllIllllIllIIllIl;
                }
                llllllllllllllllllIllllIllIIlIII.logger.error(llllllllllllllllllIllllIllIIllIl.getMessage(), (Throwable)llllllllllllllllllIllllIllIIllIl);
            }
            catch (Exception llllllllllllllllllIllllIllIIllII) {
                if (llllllllllllllllllIllllIllIIlIII.required) {
                    throw new InvalidMixinException(llllllllllllllllllIllllIllIIlIlI, String.valueOf(new StringBuilder().append("Error initialising mixin ").append(llllllllllllllllllIllllIllIIlIlI).append(" - ").append(llllllllllllllllllIllllIllIIllII.getClass()).append(": ").append(llllllllllllllllllIllllIllIIllII.getMessage())), (Throwable)llllllllllllllllllIllllIllIIllII);
                }
                llllllllllllllllllIllllIllIIlIII.logger.error(llllllllllllllllllIllllIllIIllII.getMessage(), (Throwable)llllllllllllllllllIllllIllIIllII);
            }
        }
    }

    public IReferenceMapper getReferenceMapper() {
        MixinConfig llllllllllllllllllIllllIIllIlIIl;
        if (llllllllllllllllllIllllIIllIlIIl.env.getOption(MixinEnvironment.Option.DISABLE_REFMAP)) {
            return ReferenceMapper.DEFAULT_MAPPER;
        }
        llllllllllllllllllIllllIIllIlIIl.refMapper.setContext(llllllllllllllllllIllllIIllIlIIl.env.getRefmapObfuscationContext());
        return llllllllllllllllllIllllIIllIlIIl.refMapper;
    }

    public int getDefaultMixinPriority() {
        MixinConfig llllllllllllllllllIllllIlIlIIIIl;
        return llllllllllllllllllIllllIlIlIIIIl.mixinPriority;
    }

    public boolean select(MixinEnvironment llllllllllllllllllIllllIIlllllIl) {
        MixinConfig llllllllllllllllllIllllIlIIIIIll;
        llllllllllllllllllIllllIlIIIIIll.visited = true;
        return llllllllllllllllllIllllIlIIIIIll.env == llllllllllllllllllIllllIIlllllIl;
    }

    private MixinEnvironment parseSelector(String llllllllllllllllllIlllllIllIIIII, MixinEnvironment llllllllllllllllllIlllllIlIlllll) {
        if (llllllllllllllllllIlllllIllIIIII != null) {
            String[] llllllllllllllllllIlllllIllIIlIl;
            for (String llllllllllllllllllIlllllIllIIllI : llllllllllllllllllIlllllIllIIlIl = llllllllllllllllllIlllllIllIIIII.split("[&\\| ]")) {
                llllllllllllllllllIlllllIllIIllI = llllllllllllllllllIlllllIllIIllI.trim();
                Pattern llllllllllllllllllIlllllIllIlIII = Pattern.compile("^@env(?:ironment)?\\(([A-Z]+)\\)$");
                Matcher llllllllllllllllllIlllllIllIIlll = llllllllllllllllllIlllllIllIlIII.matcher(llllllllllllllllllIlllllIllIIllI);
                if (!llllllllllllllllllIlllllIllIIlll.matches()) continue;
                return MixinEnvironment.getEnvironment(MixinEnvironment.Phase.forName(llllllllllllllllllIlllllIllIIlll.group(1)));
            }
            MixinEnvironment.Phase llllllllllllllllllIlllllIllIIlII = MixinEnvironment.Phase.forName(llllllllllllllllllIlllllIllIIIII);
            if (llllllllllllllllllIlllllIllIIlII != null) {
                return MixinEnvironment.getEnvironment(llllllllllllllllllIlllllIllIIlII);
            }
        }
        return llllllllllllllllllIlllllIlIlllll;
    }

    public List<String> reloadMixin(String llllllllllllllllllIllllIIIllIIII, byte[] llllllllllllllllllIllllIIIlIllll) {
        MixinConfig llllllllllllllllllIllllIIIlIlllI;
        for (MixinInfo llllllllllllllllllIllllIIIllIIll : llllllllllllllllllIllllIIIlIlllI.mixins) {
            if (!llllllllllllllllllIllllIIIllIIll.getClassName().equals(llllllllllllllllllIllllIIIllIIII)) continue;
            llllllllllllllllllIllllIIIllIIll.reloadMixin(llllllllllllllllllIllllIIIlIllll);
            return llllllllllllllllllIllllIIIllIIll.getTargetClasses();
        }
        return Collections.emptyList();
    }

    static Config create(String llllllllllllllllllIllllIIIIlIlll, MixinEnvironment llllllllllllllllllIllllIIIIlIllI) {
        try {
            IMixinService llllllllllllllllllIllllIIIIlllII = MixinService.getService();
            MixinConfig llllllllllllllllllIllllIIIIllIll = (MixinConfig)new Gson().fromJson((Reader)new InputStreamReader(llllllllllllllllllIllllIIIIlllII.getResourceAsStream(llllllllllllllllllIllllIIIIlIlll)), MixinConfig.class);
            if (llllllllllllllllllIllllIIIIllIll.onLoad(llllllllllllllllllIllllIIIIlllII, llllllllllllllllllIllllIIIIlIlll, llllllllllllllllllIllllIIIIlIllI)) {
                return llllllllllllllllllIllllIIIIllIll.getHandle();
            }
            return null;
        }
        catch (Exception llllllllllllllllllIllllIIIIllIlI) {
            llllllllllllllllllIllllIIIIllIlI.printStackTrace();
            throw new IllegalArgumentException(String.format("The specified resource '%s' was invalid or could not be read", llllllllllllllllllIllllIIIIlIlll), llllllllllllllllllIllllIIIIllIlI);
        }
    }

    private void removeMixin(MixinInfo llllllllllllllllllIllllIllIllllI) {
        MixinConfig llllllllllllllllllIllllIllIlllll;
        for (List<MixinInfo> llllllllllllllllllIllllIlllIIIlI : llllllllllllllllllIllllIllIlllll.mixinMapping.values()) {
            Iterator<MixinInfo> llllllllllllllllllIllllIlllIIIll = llllllllllllllllllIllllIlllIIIlI.iterator();
            while (llllllllllllllllllIllllIlllIIIll.hasNext()) {
                if (llllllllllllllllllIllllIllIllllI != llllllllllllllllllIllllIlllIIIll.next()) continue;
                llllllllllllllllllIllllIlllIIIll.remove();
            }
        }
    }

    void onSelect() {
        MixinConfig llllllllllllllllllIlllllIIlIlllI;
        if (llllllllllllllllllIlllllIIlIlllI.pluginClassName != null) {
            try {
                Class<?> llllllllllllllllllIlllllIIllIlIl = llllllllllllllllllIlllllIIlIlllI.service.getClassProvider().findClass(llllllllllllllllllIlllllIIlIlllI.pluginClassName, true);
                llllllllllllllllllIlllllIIlIlllI.plugin = (IMixinConfigPlugin)llllllllllllllllllIlllllIIllIlIl.newInstance();
                if (llllllllllllllllllIlllllIIlIlllI.plugin != null) {
                    llllllllllllllllllIlllllIIlIlllI.plugin.onLoad(llllllllllllllllllIlllllIIlIlllI.mixinPackage);
                }
            }
            catch (Throwable llllllllllllllllllIlllllIIllIlII) {
                llllllllllllllllllIlllllIIllIlII.printStackTrace();
                llllllllllllllllllIlllllIIlIlllI.plugin = null;
            }
        }
        if (!llllllllllllllllllIlllllIIlIlllI.mixinPackage.endsWith(".")) {
            llllllllllllllllllIlllllIIlIlllI.mixinPackage = String.valueOf(new StringBuilder().append(llllllllllllllllllIlllllIIlIlllI.mixinPackage).append("."));
        }
        boolean llllllllllllllllllIlllllIIllIIII = false;
        if (llllllllllllllllllIlllllIIlIlllI.refMapperConfig == null) {
            if (llllllllllllllllllIlllllIIlIlllI.plugin != null) {
                llllllllllllllllllIlllllIIlIlllI.refMapperConfig = llllllllllllllllllIlllllIIlIlllI.plugin.getRefMapperConfig();
            }
            if (llllllllllllllllllIlllllIIlIlllI.refMapperConfig == null) {
                llllllllllllllllllIlllllIIllIIII = true;
                llllllllllllllllllIlllllIIlIlllI.refMapperConfig = "mixin.refmap.json";
            }
        }
        llllllllllllllllllIlllllIIlIlllI.refMapper = ReferenceMapper.read(llllllllllllllllllIlllllIIlIlllI.refMapperConfig);
        llllllllllllllllllIlllllIIlIlllI.verboseLogging |= llllllllllllllllllIlllllIIlIlllI.env.getOption(MixinEnvironment.Option.DEBUG_VERBOSE);
        if (!llllllllllllllllllIlllllIIllIIII && llllllllllllllllllIlllllIIlIlllI.refMapper.isDefault() && !llllllllllllllllllIlllllIIlIlllI.env.getOption(MixinEnvironment.Option.DISABLE_REFMAP)) {
            llllllllllllllllllIlllllIIlIlllI.logger.warn("Reference map '{}' for {} could not be read. If this is a development environment you can ignore this message", new Object[]{llllllllllllllllllIlllllIIlIlllI.refMapperConfig, llllllllllllllllllIlllllIIlIlllI});
        }
        if (llllllllllllllllllIlllllIIlIlllI.env.getOption(MixinEnvironment.Option.REFMAP_REMAP)) {
            llllllllllllllllllIlllllIIlIlllI.refMapper = RemappingReferenceMapper.of(llllllllllllllllllIlllllIIlIlllI.env, llllllllllllllllllIlllllIIlIlllI.refMapper);
        }
    }

    @Override
    public String getName() {
        MixinConfig llllllllllllllllllIllllIlIlIlIIl;
        return llllllllllllllllllIllllIlIlIlIIl.name;
    }

    String remapClassName(String llllllllllllllllllIllllIIllIIIIl, String llllllllllllllllllIllllIIllIIIll) {
        MixinConfig llllllllllllllllllIllllIIllIIlIl;
        return llllllllllllllllllIllllIIllIIlIl.getReferenceMapper().remap(llllllllllllllllllIllllIIllIIIIl, llllllllllllllllllIllllIIllIIIll);
    }

    public List<MixinInfo> getMixinsFor(String llllllllllllllllllIllllIIlIIIIlI) {
        MixinConfig llllllllllllllllllIllllIIlIIIIll;
        return llllllllllllllllllIllllIIlIIIIll.mixinsFor(llllllllllllllllllIllllIIlIIIIlI);
    }

    public boolean hasMixinsFor(String llllllllllllllllllIllllIIlIIlIII) {
        MixinConfig llllllllllllllllllIllllIIlIIlIIl;
        return llllllllllllllllllIllllIIlIIlIIl.mixinMapping.containsKey(llllllllllllllllllIllllIIlIIlIII);
    }

    @Override
    public int getPriority() {
        MixinConfig llllllllllllllllllIllllIlIlIIlII;
        return llllllllllllllllllIllllIlIlIIlII.priority;
    }

    public Set<String> getUnhandledTargets() {
        MixinConfig llllllllllllllllllIllllIIlIllIII;
        return Collections.unmodifiableSet(llllllllllllllllllIllllIIlIllIII.unhandledTargets);
    }

    @Override
    public IMixinConfigPlugin getPlugin() {
        MixinConfig llllllllllllllllllIllllIIlIllllI;
        return llllllllllllllllllIllllIIlIllllI.plugin;
    }

    public boolean conformOverwriteVisibility() {
        MixinConfig llllllllllllllllllIllllIlIIlIlII;
        return llllllllllllllllllIllllIlIIlIlII.overwriteOptions.conformAccessModifiers;
    }

    private List<MixinInfo> mixinsFor(String llllllllllllllllllIllllIIIllllIl) {
        MixinConfig llllllllllllllllllIllllIIIlllllI;
        List<MixinInfo> llllllllllllllllllIllllIIIllllII = llllllllllllllllllIllllIIIlllllI.mixinMapping.get(llllllllllllllllllIllllIIIllllIl);
        if (llllllllllllllllllIllllIIIllllII == null) {
            llllllllllllllllllIllllIIIllllII = new ArrayList<MixinInfo>();
            llllllllllllllllllIllllIIIlllllI.mixinMapping.put(llllllllllllllllllIllllIIIllllIl, llllllllllllllllllIllllIIIllllII);
        }
        return llllllllllllllllllIllllIIIllllII;
    }

    static {
        configOrder = 0;
        globalMixinList = new HashSet<String>();
    }

    int getDeclaredMixinCount() {
        MixinConfig llllllllllllllllllIllllIIlllIlIl;
        return MixinConfig.getCollectionSize(llllllllllllllllllIllllIIlllIlIl.mixinClasses, llllllllllllllllllIllllIIlllIlIl.mixinClassesClient, llllllllllllllllllIllllIIlllIlIl.mixinClassesServer);
    }

    private boolean checkVersion() throws MixinInitialisationError {
        VersionNumber llllllllllllllllllIlllllIlIIIllI;
        VersionNumber llllllllllllllllllIlllllIlIIIlll;
        MixinConfig llllllllllllllllllIlllllIlIIlIII;
        if (llllllllllllllllllIlllllIlIIlIII.version == null) {
            llllllllllllllllllIlllllIlIIlIII.logger.error("Mixin config {} does not specify \"minVersion\" property", new Object[]{llllllllllllllllllIlllllIlIIlIII.name});
        }
        if ((llllllllllllllllllIlllllIlIIIlll = VersionNumber.parse(llllllllllllllllllIlllllIlIIlIII.version)).compareTo(llllllllllllllllllIlllllIlIIIllI = VersionNumber.parse(llllllllllllllllllIlllllIlIIlIII.env.getVersion())) > 0) {
            llllllllllllllllllIlllllIlIIlIII.logger.warn("Mixin config {} requires mixin subsystem version {} but {} was found. The mixin config will not be applied.", new Object[]{llllllllllllllllllIlllllIlIIlIII.name, llllllllllllllllllIlllllIlIIIlll, llllllllllllllllllIlllllIlIIIllI});
            if (llllllllllllllllllIlllllIlIIlIII.required) {
                throw new MixinInitialisationError(String.valueOf(new StringBuilder().append("Required mixin config ").append(llllllllllllllllllIlllllIlIIlIII.name).append(" requires mixin subsystem version ").append(llllllllllllllllllIlllllIlIIIlll)));
            }
            return false;
        }
        return true;
    }

    @Override
    public String getMixinPackage() {
        MixinConfig llllllllllllllllllIllllIlIlIIlll;
        return llllllllllllllllllIllllIlIlIIlll.mixinPackage;
    }

    private void initInjectionPoints() {
        MixinConfig llllllllllllllllllIlllllIlIlIIII;
        if (llllllllllllllllllIlllllIlIlIIII.injectorOptions.injectionPoints == null) {
            return;
        }
        for (String llllllllllllllllllIlllllIlIlIIIl : llllllllllllllllllIlllllIlIlIIII.injectorOptions.injectionPoints) {
            try {
                Class<?> llllllllllllllllllIlllllIlIlIIll = llllllllllllllllllIlllllIlIlIIII.service.getClassProvider().findClass(llllllllllllllllllIlllllIlIlIIIl, true);
                if (InjectionPoint.class.isAssignableFrom(llllllllllllllllllIlllllIlIlIIll)) {
                    InjectionPoint.register(llllllllllllllllllIlllllIlIlIIll);
                    continue;
                }
                llllllllllllllllllIlllllIlIlIIII.logger.error("Unable to register injection point {} for {}, class must extend InjectionPoint", new Object[]{llllllllllllllllllIlllllIlIlIIll, llllllllllllllllllIlllllIlIlIIII});
            }
            catch (Throwable llllllllllllllllllIlllllIlIlIIlI) {
                llllllllllllllllllIlllllIlIlIIII.logger.catching(llllllllllllllllllIlllllIlIlIIlI);
            }
        }
    }

    void postInitialise() {
        MixinConfig llllllllllllllllllIllllIllllIIlI;
        if (llllllllllllllllllIllllIllllIIlI.plugin != null) {
            List<String> llllllllllllllllllIllllIllllllIl = llllllllllllllllllIllllIllllIIlI.plugin.getMixins();
            llllllllllllllllllIllllIllllIIlI.prepareMixins(llllllllllllllllllIllllIllllllIl, true);
        }
        Iterator<MixinInfo> llllllllllllllllllIllllIllllIlII = llllllllllllllllllIllllIllllIIlI.mixins.iterator();
        while (llllllllllllllllllIllllIllllIlII.hasNext()) {
            MixinInfo llllllllllllllllllIllllIllllIllI = llllllllllllllllllIllllIllllIlII.next();
            try {
                llllllllllllllllllIllllIllllIllI.validate();
                for (IListener llllllllllllllllllIllllIlllllIll : llllllllllllllllllIllllIllllIIlI.listeners) {
                    llllllllllllllllllIllllIlllllIll.onInit(llllllllllllllllllIllllIllllIllI);
                }
            }
            catch (InvalidMixinException llllllllllllllllllIllllIlllllIlI) {
                llllllllllllllllllIllllIllllIIlI.logger.error(String.valueOf(new StringBuilder().append(llllllllllllllllllIllllIlllllIlI.getMixin()).append(": ").append(llllllllllllllllllIllllIlllllIlI.getMessage())), (Throwable)llllllllllllllllllIllllIlllllIlI);
                llllllllllllllllllIllllIllllIIlI.removeMixin(llllllllllllllllllIllllIllllIllI);
                llllllllllllllllllIllllIllllIlII.remove();
            }
            catch (Exception llllllllllllllllllIllllIlllllIII) {
                llllllllllllllllllIllllIllllIIlI.logger.error(llllllllllllllllllIllllIlllllIII.getMessage(), (Throwable)llllllllllllllllllIllllIlllllIII);
                llllllllllllllllllIllllIllllIIlI.removeMixin(llllllllllllllllllIllllIllllIllI);
                llllllllllllllllllIllllIllllIlII.remove();
            }
        }
    }

    void prepare() {
        MixinConfig llllllllllllllllllIlllllIIIlllIl;
        if (llllllllllllllllllIlllllIIIlllIl.prepared) {
            return;
        }
        llllllllllllllllllIlllllIIIlllIl.prepared = true;
        llllllllllllllllllIlllllIIIlllIl.prepareMixins(llllllllllllllllllIlllllIIIlllIl.mixinClasses, false);
        switch (llllllllllllllllllIlllllIIIlllIl.env.getSide()) {
            case CLIENT: {
                llllllllllllllllllIlllllIIIlllIl.prepareMixins(llllllllllllllllllIlllllIIIlllIl.mixinClassesClient, false);
                break;
            }
            case SERVER: {
                llllllllllllllllllIlllllIIIlllIl.prepareMixins(llllllllllllllllllIlllllIIIlllIl.mixinClassesServer, false);
                break;
            }
            default: {
                llllllllllllllllllIlllllIIIlllIl.logger.warn("Mixin environment was unable to detect the current side, sided mixins will not be applied");
            }
        }
    }

    int getMixinCount() {
        MixinConfig llllllllllllllllllIllllIIlllIIll;
        return llllllllllllllllllIllllIIlllIIll.mixins.size();
    }

    public Config getHandle() {
        MixinConfig llllllllllllllllllIllllIlIllIIlI;
        if (llllllllllllllllllIllllIlIllIIlI.handle == null) {
            llllllllllllllllllIllllIlIllIIlI.handle = new Config(llllllllllllllllllIllllIlIllIIlI);
        }
        return llllllllllllllllllIllllIlIllIIlI.handle;
    }

    public boolean requireOverwriteAnnotations() {
        MixinConfig llllllllllllllllllIllllIlIIlIIIl;
        return llllllllllllllllllIllllIlIIlIIIl.overwriteOptions.requireOverwriteAnnotations;
    }

    public List<String> getClasses() {
        MixinConfig llllllllllllllllllIllllIIllIllll;
        return Collections.unmodifiableList(llllllllllllllllllIllllIIllIllll.mixinClasses);
    }

    public int getMaxShiftByValue() {
        MixinConfig llllllllllllllllllIllllIlIIIlllI;
        return Math.min(Math.max(llllllllllllllllllIllllIlIIIlllI.injectorOptions.maxShiftBy, 0), 0);
    }

    static class InjectorOptions {
        @SerializedName(value="defaultRequire")
        /* synthetic */ int defaultRequireValue;
        @SerializedName(value="injectionPoints")
        /* synthetic */ List<String> injectionPoints;
        @SerializedName(value="defaultGroup")
        /* synthetic */ String defaultGroup;
        @SerializedName(value="maxShiftBy")
        /* synthetic */ int maxShiftBy;

        InjectorOptions() {
            InjectorOptions lllllllllllllllIllllllllIIllIIll;
            lllllllllllllllIllllllllIIllIIll.defaultRequireValue = 0;
            lllllllllllllllIllllllllIIllIIll.defaultGroup = "default";
            lllllllllllllllIllllllllIIllIIll.maxShiftBy = 0;
        }
    }

    static class OverwriteOptions {
        @SerializedName(value="conformVisibility")
        /* synthetic */ boolean conformAccessModifiers;
        @SerializedName(value="requireAnnotations")
        /* synthetic */ boolean requireOverwriteAnnotations;

        OverwriteOptions() {
            OverwriteOptions lIIIlIllllIII;
        }
    }

    static interface IListener {
        public void onPrepare(MixinInfo var1);

        public void onInit(MixinInfo var1);
    }
}

