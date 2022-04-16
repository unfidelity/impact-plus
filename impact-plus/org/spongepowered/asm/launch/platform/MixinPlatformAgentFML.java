/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.launchwrapper.ITweaker
 *  net.minecraft.launchwrapper.Launch
 *  net.minecraft.launchwrapper.LaunchClassLoader
 *  org.apache.logging.log4j.Level
 */
package org.spongepowered.asm.launch.platform;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.logging.log4j.Level;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.launch.platform.MixinPlatformAgentAbstract;
import org.spongepowered.asm.launch.platform.MixinPlatformManager;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.extensibility.IRemapper;

public class MixinPlatformAgentFML
extends MixinPlatformAgentAbstract {
    private static final /* synthetic */ String CORE_MOD_MANAGER_CLASS_LEGACY;
    private /* synthetic */ boolean initInjectionState;
    private static final /* synthetic */ String MFATT_FORCELOADASMOD;
    private static final /* synthetic */ String GET_IGNORED_MODS_METHOD;
    private static final /* synthetic */ String FML_CMDLINE_COREMODS;
    private final /* synthetic */ String fileName;
    private static final /* synthetic */ String FML_PLUGIN_WRAPPER_CLASS;
    private static final /* synthetic */ String FML_REMAPPER_ADAPTER_CLASS;
    private static final /* synthetic */ Set<String> loadedCoreMods;
    private static final /* synthetic */ String GET_REPARSEABLE_COREMODS_METHOD;
    private static final /* synthetic */ String FML_CORE_MOD_INSTANCE_FIELD;
    private /* synthetic */ Class<?> clCoreModManager;
    private static final /* synthetic */ String GET_IGNORED_MODS_METHOD_LEGACY;
    private static final /* synthetic */ String FML_TWEAKER_INJECTION;
    private static final /* synthetic */ String MFATT_COREMODCONTAINSMOD;
    private static final /* synthetic */ String FML_TWEAKER_TERMINAL;
    private static final /* synthetic */ String CORE_MOD_MANAGER_CLASS;
    private static final /* synthetic */ String FML_TWEAKER_DEOBF;
    private final /* synthetic */ ITweaker coreModWrapper;
    private static final /* synthetic */ String MFATT_FMLCOREPLUGIN;
    private static final /* synthetic */ String LOAD_CORE_MOD_METHOD;

    private boolean isIgnoredReparseable() {
        MixinPlatformAgentFML lIlIllIllIllIII;
        return lIlIllIllIllIII.container.toString().contains("deobfedDeps");
    }

    static {
        FML_CORE_MOD_INSTANCE_FIELD = "coreModInstance";
        MFATT_FMLCOREPLUGIN = "FMLCorePlugin";
        GET_REPARSEABLE_COREMODS_METHOD = "getReparseableCoremods";
        CORE_MOD_MANAGER_CLASS_LEGACY = "cpw.mods.fml.relauncher.CoreModManager";
        GET_IGNORED_MODS_METHOD_LEGACY = "getLoadedCoremods";
        GET_IGNORED_MODS_METHOD = "getIgnoredMods";
        FML_REMAPPER_ADAPTER_CLASS = "org.spongepowered.asm.bridge.RemapperAdapterFML";
        FML_CMDLINE_COREMODS = "fml.coreMods.load";
        MFATT_FORCELOADASMOD = "ForceLoadAsMod";
        LOAD_CORE_MOD_METHOD = "loadCoreMod";
        CORE_MOD_MANAGER_CLASS = "net.minecraftforge.fml.relauncher.CoreModManager";
        FML_PLUGIN_WRAPPER_CLASS = "FMLPluginWrapper";
        FML_TWEAKER_TERMINAL = "TerminalTweaker";
        FML_TWEAKER_DEOBF = "FMLDeobfTweaker";
        FML_TWEAKER_INJECTION = "FMLInjectionAndSortingTweaker";
        MFATT_COREMODCONTAINSMOD = "FMLCorePluginContainsFMLMod";
        loadedCoreMods = new HashSet<String>();
        for (String lIlIllIIlIIIIII : System.getProperty("fml.coreMods.load", "").split(",")) {
            if (lIlIllIIlIIIIII.isEmpty()) continue;
            MixinPlatformAgentAbstract.logger.debug("FML platform agent will ignore coremod {} specified on the command line", new Object[]{lIlIllIIlIIIIII});
            loadedCoreMods.add(lIlIllIIlIIIIII);
        }
    }

    private ITweaker initFMLCoreMod() {
        try {
            MixinPlatformAgentFML lIlIllIlllIIIlI;
            try {
                lIlIllIlllIIIlI.clCoreModManager = MixinPlatformAgentFML.getCoreModManagerClass();
            }
            catch (ClassNotFoundException lIlIllIlllIIlII) {
                MixinPlatformAgentAbstract.logger.info("FML platform manager could not load class {}. Proceeding without FML support.", new Object[]{lIlIllIlllIIlII.getMessage()});
                return null;
            }
            if ("true".equalsIgnoreCase(lIlIllIlllIIIlI.attributes.get("ForceLoadAsMod"))) {
                MixinPlatformAgentAbstract.logger.debug("ForceLoadAsMod was specified for {}, attempting force-load", new Object[]{lIlIllIlllIIIlI.fileName});
                lIlIllIlllIIIlI.loadAsMod();
            }
            return lIlIllIlllIIIlI.injectCorePlugin();
        }
        catch (Exception lIlIllIlllIIIll) {
            MixinPlatformAgentAbstract.logger.catching((Throwable)lIlIllIlllIIIll);
            return null;
        }
    }

    @Override
    public void initPrimaryContainer() {
        MixinPlatformAgentFML lIlIllIlIIIIlII;
        if (lIlIllIlIIIIlII.clCoreModManager != null) {
            lIlIllIlIIIIlII.injectRemapper();
        }
    }

    private ITweaker injectCorePlugin() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MixinPlatformAgentFML lIlIllIlIllllll;
        String lIlIllIlIlllllI = lIlIllIlIllllll.attributes.get("FMLCorePlugin");
        if (lIlIllIlIlllllI == null) {
            return null;
        }
        if (lIlIllIlIllllll.isAlreadyInjected(lIlIllIlIlllllI)) {
            MixinPlatformAgentAbstract.logger.debug("{} has core plugin {}. Skipping because it was already injected.", new Object[]{lIlIllIlIllllll.fileName, lIlIllIlIlllllI});
            return null;
        }
        MixinPlatformAgentAbstract.logger.debug("{} has core plugin {}. Injecting it into FML for co-initialisation:", new Object[]{lIlIllIlIllllll.fileName, lIlIllIlIlllllI});
        Method lIlIllIlIllllIl = lIlIllIlIllllll.clCoreModManager.getDeclaredMethod(GlobalProperties.getString("mixin.launch.fml.loadcoremodmethod", "loadCoreMod"), LaunchClassLoader.class, String.class, File.class);
        lIlIllIlIllllIl.setAccessible(true);
        ITweaker lIlIllIlIllllII = (ITweaker)lIlIllIlIllllIl.invoke(null, Launch.classLoader, lIlIllIlIlllllI, lIlIllIlIllllll.container);
        if (lIlIllIlIllllII == null) {
            MixinPlatformAgentAbstract.logger.debug("Core plugin {} could not be loaded.", new Object[]{lIlIllIlIlllllI});
            return null;
        }
        lIlIllIlIllllll.initInjectionState = MixinPlatformAgentFML.isTweakerQueued("FMLInjectionAndSortingTweaker");
        loadedCoreMods.add(lIlIllIlIlllllI);
        return lIlIllIlIllllII;
    }

    @Override
    public void prepare() {
        lIlIllIlIIIlIlI.initInjectionState |= MixinPlatformAgentFML.isTweakerQueued("FMLInjectionAndSortingTweaker");
    }

    private void addReparseableJar() {
        try {
            MixinPlatformAgentFML lIlIllIllIIllll;
            Method lIlIllIllIlIIll = lIlIllIllIIllll.clCoreModManager.getDeclaredMethod(GlobalProperties.getString("mixin.launch.fml.reparseablecoremodsmethod", "getReparseableCoremods"), new Class[0]);
            List lIlIllIllIlIIlI = (List)lIlIllIllIlIIll.invoke(null, new Object[0]);
            if (!lIlIllIllIlIIlI.contains(lIlIllIllIIllll.fileName)) {
                MixinPlatformAgentAbstract.logger.debug("Adding {} to reparseable coremod collection", new Object[]{lIlIllIllIIllll.fileName});
                lIlIllIllIlIIlI.add(lIlIllIllIIllll.fileName);
            }
        }
        catch (Exception lIlIllIllIlIIIl) {
            MixinPlatformAgentAbstract.logger.catching((Throwable)lIlIllIllIlIIIl);
        }
    }

    private static List<String> getIgnoredMods(Class<?> lIlIllIIlIIlIlI) throws IllegalAccessException, InvocationTargetException {
        Method lIlIllIIlIIlIIl = null;
        try {
            lIlIllIIlIIlIIl = lIlIllIIlIIlIlI.getDeclaredMethod(GlobalProperties.getString("mixin.launch.fml.ignoredmodsmethod", "getIgnoredMods"), new Class[0]);
        }
        catch (NoSuchMethodException lIlIllIIlIIlIll) {
            try {
                lIlIllIIlIIlIIl = lIlIllIIlIIlIlI.getDeclaredMethod("getLoadedCoremods", new Class[0]);
            }
            catch (NoSuchMethodException lIlIllIIlIIllII) {
                MixinPlatformAgentAbstract.logger.catching(Level.DEBUG, (Throwable)lIlIllIIlIIllII);
                return Collections.emptyList();
            }
        }
        return (List)lIlIllIIlIIlIIl.invoke(null, new Object[0]);
    }

    @Override
    public String getPhaseProvider() {
        return String.valueOf(new StringBuilder().append(MixinPlatformAgentFML.class.getName()).append("$PhaseProvider"));
    }

    private static boolean isTweakerQueued(String lIlIllIIlIlIlll) {
        for (String lIlIllIIlIllIII : (List)GlobalProperties.get("TweakClasses")) {
            if (!lIlIllIIlIllIII.endsWith(lIlIllIIlIlIlll)) continue;
            return true;
        }
        return false;
    }

    private static Class<?> getCoreModManagerClass() throws ClassNotFoundException {
        try {
            return Class.forName(GlobalProperties.getString("mixin.launch.fml.coremodmanagerclass", "net.minecraftforge.fml.relauncher.CoreModManager"));
        }
        catch (ClassNotFoundException lIlIllIIlIlIIlI) {
            return Class.forName("cpw.mods.fml.relauncher.CoreModManager");
        }
    }

    public MixinPlatformAgentFML(MixinPlatformManager lIlIllIlllIlIII, URI lIlIllIlllIlIlI) {
        super(lIlIllIlllIlIII, lIlIllIlllIlIlI);
        MixinPlatformAgentFML lIlIllIlllIllII;
        lIlIllIlllIllII.fileName = lIlIllIlllIllII.container.getName();
        lIlIllIlllIllII.coreModWrapper = lIlIllIlllIllII.initFMLCoreMod();
    }

    @Override
    public String getLaunchTarget() {
        return null;
    }

    @Override
    public void inject() {
        MixinPlatformAgentFML lIlIllIIllIlIII;
        if (lIlIllIIllIlIII.coreModWrapper != null && lIlIllIIllIlIII.checkForCoInitialisation()) {
            MixinPlatformAgentAbstract.logger.debug("FML agent is co-initiralising coremod instance {} for {}", new Object[]{lIlIllIIllIlIII.coreModWrapper, lIlIllIIllIlIII.uri});
            lIlIllIIllIlIII.coreModWrapper.injectIntoClassLoader(Launch.classLoader);
        }
    }

    private void injectRemapper() {
        try {
            MixinPlatformAgentAbstract.logger.debug("Creating FML remapper adapter: {}", new Object[]{"org.spongepowered.asm.bridge.RemapperAdapterFML"});
            Class<?> lIlIllIIllllIlI = Class.forName("org.spongepowered.asm.bridge.RemapperAdapterFML", true, (ClassLoader)Launch.classLoader);
            Method lIlIllIIllllIII = lIlIllIIllllIlI.getDeclaredMethod("create", new Class[0]);
            IRemapper lIlIllIIlllIllI = (IRemapper)lIlIllIIllllIII.invoke(null, new Object[0]);
            MixinEnvironment.getDefaultEnvironment().getRemappers().add(lIlIllIIlllIllI);
        }
        catch (Exception lIlIllIIlllIlIl) {
            MixinPlatformAgentAbstract.logger.debug("Failed instancing FML remapper adapter, things will probably go horribly for notch-obf'd mods!");
        }
    }

    private void loadAsMod() {
        MixinPlatformAgentFML lIlIllIllIlllII;
        try {
            MixinPlatformAgentFML.getIgnoredMods(lIlIllIllIlllII.clCoreModManager).remove(lIlIllIllIlllII.fileName);
        }
        catch (Exception lIlIllIllIlllIl) {
            MixinPlatformAgentAbstract.logger.catching((Throwable)lIlIllIllIlllIl);
        }
        if (lIlIllIllIlllII.attributes.get("FMLCorePluginContainsFMLMod") != null) {
            if (lIlIllIllIlllII.isIgnoredReparseable()) {
                MixinPlatformAgentAbstract.logger.debug("Ignoring request to add {} to reparseable coremod collection - it is a deobfuscated dependency", new Object[]{lIlIllIllIlllII.fileName});
                return;
            }
            lIlIllIllIlllII.addReparseableJar();
        }
    }

    protected final boolean checkForCoInitialisation() {
        MixinPlatformAgentFML lIlIllIIllIIIIl;
        boolean lIlIllIIllIIIII = MixinPlatformAgentFML.isTweakerQueued("FMLInjectionAndSortingTweaker");
        boolean lIlIllIIlIlllll = MixinPlatformAgentFML.isTweakerQueued("TerminalTweaker");
        if (lIlIllIIllIIIIl.initInjectionState && lIlIllIIlIlllll || lIlIllIIllIIIII) {
            MixinPlatformAgentAbstract.logger.debug("FML agent is skipping co-init for {} because FML will inject it normally", new Object[]{lIlIllIIllIIIIl.coreModWrapper});
            return false;
        }
        return !MixinPlatformAgentFML.isTweakerQueued("FMLDeobfTweaker");
    }

    private boolean isAlreadyInjected(String lIlIllIlIlIIIII) {
        if (loadedCoreMods.contains(lIlIllIlIlIIIII)) {
            return true;
        }
        try {
            List lIlIllIlIlIIIll = (List)GlobalProperties.get("Tweaks");
            if (lIlIllIlIlIIIll == null) {
                return false;
            }
            for (ITweaker lIlIllIlIlIIlII : lIlIllIlIlIIIll) {
                Class<?> lIlIllIlIlIIlIl = lIlIllIlIlIIlII.getClass();
                if (!"FMLPluginWrapper".equals(lIlIllIlIlIIlIl.getSimpleName())) continue;
                Field lIlIllIlIlIIlll = lIlIllIlIlIIlIl.getField("coreModInstance");
                lIlIllIlIlIIlll.setAccessible(true);
                Object lIlIllIlIlIIllI = lIlIllIlIlIIlll.get(lIlIllIlIlIIlII);
                if (!lIlIllIlIlIIIII.equals(lIlIllIlIlIIllI.getClass().getName())) continue;
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }
}

