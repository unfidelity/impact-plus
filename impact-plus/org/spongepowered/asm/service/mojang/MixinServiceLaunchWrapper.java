/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.ImmutableList
 *  net.minecraft.launchwrapper.IClassNameTransformer
 *  net.minecraft.launchwrapper.IClassTransformer
 *  net.minecraft.launchwrapper.ITweaker
 *  net.minecraft.launchwrapper.Launch
 *  org.apache.commons.io.IOUtils
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.service.mojang;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import net.minecraft.launchwrapper.IClassNameTransformer;
import net.minecraft.launchwrapper.IClassTransformer;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.GlobalProperties;
import org.spongepowered.asm.lib.ClassReader;
import org.spongepowered.asm.lib.tree.ClassNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.throwables.MixinException;
import org.spongepowered.asm.service.IClassBytecodeProvider;
import org.spongepowered.asm.service.IClassProvider;
import org.spongepowered.asm.service.ILegacyClassTransformer;
import org.spongepowered.asm.service.IMixinService;
import org.spongepowered.asm.service.ITransformer;
import org.spongepowered.asm.service.mojang.LaunchClassLoaderUtil;
import org.spongepowered.asm.service.mojang.LegacyTransformerHandle;
import org.spongepowered.asm.util.ReEntranceLock;
import org.spongepowered.asm.util.perf.Profiler;

public class MixinServiceLaunchWrapper
implements IMixinService,
IClassProvider,
IClassBytecodeProvider {
    public static final /* synthetic */ String BLACKBOARD_KEY_TWEAKCLASSES;
    private final /* synthetic */ LaunchClassLoaderUtil classLoaderUtil;
    public static final /* synthetic */ String BLACKBOARD_KEY_TWEAKS;
    private static final /* synthetic */ String STATE_TWEAKER;
    private static final /* synthetic */ String TRANSFORMER_PROXY_CLASS;
    private /* synthetic */ IClassNameTransformer nameTransformer;
    private static final /* synthetic */ String LAUNCH_PACKAGE;
    private static final /* synthetic */ String MIXIN_PACKAGE;
    private final /* synthetic */ ReEntranceLock lock;
    private static final /* synthetic */ Logger logger;

    @Override
    public Class<?> findClass(String llllllllllllllllIllllIIlIIIIIIlI, boolean llllllllllllllllIllllIIlIIIIIIIl) throws ClassNotFoundException {
        return Class.forName(llllllllllllllllIllllIIlIIIIIIlI, llllllllllllllllIllllIIlIIIIIIIl, (ClassLoader)Launch.classLoader);
    }

    @Override
    public void registerInvalidClass(String llllllllllllllllIllllIIIlllIlIll) {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIIlllIlIlI;
        llllllllllllllllIllllIIIlllIlIlI.classLoaderUtil.registerInvalidClass(llllllllllllllllIllllIIIlllIlIll);
    }

    private String unmapClassName(String llllllllllllllllIllllIIIIlllllIl) {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIIIlllllII;
        if (llllllllllllllllIllllIIIIlllllII.nameTransformer == null) {
            llllllllllllllllIllllIIIIlllllII.findNameTransformer();
        }
        if (llllllllllllllllIllllIIIIlllllII.nameTransformer != null) {
            return llllllllllllllllIllllIIIIlllllII.nameTransformer.unmapClassName(llllllllllllllllIllllIIIIlllllIl);
        }
        return llllllllllllllllIllllIIIIlllllIl;
    }

    @Override
    public boolean isClassLoaded(String llllllllllllllllIllllIIIlllIIIll) {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIIlllIIlII;
        return llllllllllllllllIllllIIIlllIIlII.classLoaderUtil.isClassLoaded(llllllllllllllllIllllIIIlllIIIll);
    }

    @Override
    public boolean isValid() {
        try {
            Launch.classLoader.hashCode();
        }
        catch (Throwable llllllllllllllllIllllIIlIIIlllII) {
            return false;
        }
        return true;
    }

    private static int findInStackTrace(String llllllllllllllllIllllIIIIIlllIII, String llllllllllllllllIllllIIIIIllIlll) {
        StackTraceElement[] llllllllllllllllIllllIIIIIlllIIl;
        Thread llllllllllllllllIllllIIIIIlllIlI = Thread.currentThread();
        if (!"main".equals(llllllllllllllllIllllIIIIIlllIlI.getName())) {
            return 0;
        }
        for (StackTraceElement llllllllllllllllIllllIIIIIllllIl : llllllllllllllllIllllIIIIIlllIIl = llllllllllllllllIllllIIIIIlllIlI.getStackTrace()) {
            if (!llllllllllllllllIllllIIIIIlllIII.equals(llllllllllllllllIllllIIIIIllllIl.getClassName()) || !llllllllllllllllIllllIIIIIllIlll.equals(llllllllllllllllIllllIIIIIllllIl.getMethodName())) continue;
            return llllllllllllllllIllllIIIIIllllIl.getLineNumber();
        }
        return 0;
    }

    @Override
    public String getName() {
        return "LaunchWrapper";
    }

    @Override
    public IClassProvider getClassProvider() {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIlIIIIlllI;
        return llllllllllllllllIllllIIlIIIIlllI;
    }

    @Override
    public Collection<ITransformer> getTransformers() {
        List llllllllllllllllIllllIIIllIllIlI = Launch.classLoader.getTransformers();
        ArrayList<ITransformer> llllllllllllllllIllllIIIllIllIIl = new ArrayList<ITransformer>(llllllllllllllllIllllIIIllIllIlI.size());
        for (IClassTransformer llllllllllllllllIllllIIIllIlllII : llllllllllllllllIllllIIIllIllIlI) {
            if (llllllllllllllllIllllIIIllIlllII instanceof ITransformer) {
                llllllllllllllllIllllIIIllIllIIl.add((ITransformer)llllllllllllllllIllllIIIllIlllII);
            } else {
                llllllllllllllllIllllIIIllIllIIl.add(new LegacyTransformerHandle(llllllllllllllllIllllIIIllIlllII));
            }
            if (!(llllllllllllllllIllllIIIllIlllII instanceof IClassNameTransformer)) continue;
            logger.debug("Found name transformer: {}", new Object[]{llllllllllllllllIllllIIIllIlllII.getClass().getName()});
            llllllllllllllllIllllIIIllIllIII.nameTransformer = (IClassNameTransformer)llllllllllllllllIllllIIIllIlllII;
        }
        return llllllllllllllllIllllIIIllIllIIl;
    }

    @Override
    public void prepare() {
        Launch.classLoader.addClassLoaderExclusion("org.spongepowered.asm.launch.");
    }

    @Override
    public void checkEnv(Object llllllllllllllllIllllIIIllllIIll) {
        if (llllllllllllllllIllllIIIllllIIll.getClass().getClassLoader() != Launch.class.getClassLoader()) {
            throw new MixinException("Attempted to init the mixin environment in the wrong classloader");
        }
    }

    private byte[] applyTransformers(String llllllllllllllllIllllIIIlIIlIIII, String llllllllllllllllIllllIIIlIIIlIIl, byte[] llllllllllllllllIllllIIIlIIIlllI, Profiler llllllllllllllllIllllIIIlIIIllIl) {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIIlIIlIIIl;
        if (llllllllllllllllIllllIIIlIIlIIIl.classLoaderUtil.isClassExcluded(llllllllllllllllIllllIIIlIIlIIII, llllllllllllllllIllllIIIlIIIlIIl)) {
            return llllllllllllllllIllllIIIlIIIlllI;
        }
        MixinEnvironment llllllllllllllllIllllIIIlIIIllII = MixinEnvironment.getCurrentEnvironment();
        for (ILegacyClassTransformer llllllllllllllllIllllIIIlIIlIIlI : llllllllllllllllIllllIIIlIIIllII.getTransformers()) {
            llllllllllllllllIllllIIIlIIlIIIl.lock.clear();
            int llllllllllllllllIllllIIIlIIlIlIl = llllllllllllllllIllllIIIlIIlIIlI.getName().lastIndexOf(46);
            String llllllllllllllllIllllIIIlIIlIlII = llllllllllllllllIllllIIIlIIlIIlI.getName().substring(llllllllllllllllIllllIIIlIIlIlIl + 1);
            Profiler.Section llllllllllllllllIllllIIIlIIlIIll = llllllllllllllllIllllIIIlIIIllIl.begin(2, llllllllllllllllIllllIIIlIIlIlII.toLowerCase());
            llllllllllllllllIllllIIIlIIlIIll.setInfo(llllllllllllllllIllllIIIlIIlIIlI.getName());
            llllllllllllllllIllllIIIlIIIlllI = llllllllllllllllIllllIIIlIIlIIlI.transformClassBytes(llllllllllllllllIllllIIIlIIlIIII, llllllllllllllllIllllIIIlIIIlIIl, llllllllllllllllIllllIIIlIIIlllI);
            llllllllllllllllIllllIIIlIIlIIll.end();
            if (!llllllllllllllllIllllIIIlIIlIIIl.lock.isSet()) continue;
            llllllllllllllllIllllIIIlIIIllII.addTransformerExclusion(llllllllllllllllIllllIIIlIIlIIlI.getName());
            llllllllllllllllIllllIIIlIIlIIIl.lock.clear();
            logger.info("A re-entrant transformer '{}' was detected and will no longer process meta class data", new Object[]{llllllllllllllllIllllIIIlIIlIIlI.getName()});
        }
        return llllllllllllllllIllllIIIlIIIlllI;
    }

    private String getSideName(String llllllllllllllllIllllIIIIlIIlIIl, String llllllllllllllllIllllIIIIlIIlIII) {
        try {
            Class<?> llllllllllllllllIllllIIIIlIIllll = Class.forName(llllllllllllllllIllllIIIIlIIlIIl, false, (ClassLoader)Launch.classLoader);
            Method llllllllllllllllIllllIIIIlIIlllI = llllllllllllllllIllllIIIIlIIllll.getDeclaredMethod(llllllllllllllllIllllIIIIlIIlIII, new Class[0]);
            return ((Enum)llllllllllllllllIllllIIIIlIIlllI.invoke(null, new Object[0])).name();
        }
        catch (Exception llllllllllllllllIllllIIIIlIIllIl) {
            return null;
        }
    }

    @Override
    public byte[] getClassBytes(String llllllllllllllllIllllIIIlIllIIII, boolean llllllllllllllllIllllIIIlIlIIlll) throws IOException, ClassNotFoundException {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIIlIlIlIIl;
        String llllllllllllllllIllllIIIlIlIlllI = llllllllllllllllIllllIIIlIllIIII.replace('/', '.');
        String llllllllllllllllIllllIIIlIlIllIl = llllllllllllllllIllllIIIlIlIlIIl.unmapClassName(llllllllllllllllIllllIIIlIlIlllI);
        Profiler llllllllllllllllIllllIIIlIlIllII = MixinEnvironment.getProfiler();
        Profiler.Section llllllllllllllllIllllIIIlIlIlIll = llllllllllllllllIllllIIIlIlIllII.begin(1, "class.load");
        byte[] llllllllllllllllIllllIIIlIlIlIlI = llllllllllllllllIllllIIIlIlIlIIl.getClassBytes(llllllllllllllllIllllIIIlIlIllIl, llllllllllllllllIllllIIIlIlIlllI);
        llllllllllllllllIllllIIIlIlIlIll.end();
        if (llllllllllllllllIllllIIIlIlIIlll) {
            Profiler.Section llllllllllllllllIllllIIIlIllIIlI = llllllllllllllllIllllIIIlIlIllII.begin(1, "class.transform");
            llllllllllllllllIllllIIIlIlIlIlI = llllllllllllllllIllllIIIlIlIlIIl.applyTransformers(llllllllllllllllIllllIIIlIlIllIl, llllllllllllllllIllllIIIlIlIlllI, llllllllllllllllIllllIIIlIlIlIlI, llllllllllllllllIllllIIIlIlIllII);
            llllllllllllllllIllllIIIlIllIIlI.end();
        }
        if (llllllllllllllllIllllIIIlIlIlIlI == null) {
            throw new ClassNotFoundException(String.format("The specified class '%s' was not found", llllllllllllllllIllllIIIlIlIlllI));
        }
        return llllllllllllllllIllllIIIlIlIlIlI;
    }

    @Override
    public Class<?> findAgentClass(String llllllllllllllllIllllIIIlllllIIl, boolean llllllllllllllllIllllIIIlllllIII) throws ClassNotFoundException {
        return Class.forName(llllllllllllllllIllllIIIlllllIIl, llllllllllllllllIllllIIIlllllIII, Launch.class.getClassLoader());
    }

    @Override
    public void init() {
        List llllllllllllllllIllllIIlIIIlIlIl;
        if (MixinServiceLaunchWrapper.findInStackTrace("net.minecraft.launchwrapper.Launch", "launch") < 4) {
            logger.error("MixinBootstrap.doInit() called during a tweak constructor!");
        }
        if ((llllllllllllllllIllllIIlIIIlIlIl = (List)GlobalProperties.get("TweakClasses")) != null) {
            llllllllllllllllIllllIIlIIIlIlIl.add("org.spongepowered.asm.mixin.EnvironmentStateTweaker");
        }
    }

    @Override
    public IClassBytecodeProvider getBytecodeProvider() {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIlIIIIlIlI;
        return llllllllllllllllIllllIIlIIIIlIlI;
    }

    @Override
    public void beginPhase() {
        Launch.classLoader.registerTransformer("org.spongepowered.asm.mixin.transformer.Proxy");
    }

    static {
        TRANSFORMER_PROXY_CLASS = "org.spongepowered.asm.mixin.transformer.Proxy";
        BLACKBOARD_KEY_TWEAKS = "Tweaks";
        LAUNCH_PACKAGE = "org.spongepowered.asm.launch.";
        BLACKBOARD_KEY_TWEAKCLASSES = "TweakClasses";
        MIXIN_PACKAGE = "org.spongepowered.asm.mixin.";
        STATE_TWEAKER = "org.spongepowered.asm.mixin.EnvironmentStateTweaker";
        logger = LogManager.getLogger((String)"mixin");
    }

    @Override
    public InputStream getResourceAsStream(String llllllllllllllllIllllIIIllllIIII) {
        return Launch.classLoader.getResourceAsStream(llllllllllllllllIllllIIIllllIIII);
    }

    @Override
    public Class<?> findClass(String llllllllllllllllIllllIIlIIIIIlll) throws ClassNotFoundException {
        return Launch.classLoader.findClass(llllllllllllllllIllllIIlIIIIIlll);
    }

    public MixinServiceLaunchWrapper() {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIlIIIlllll;
        llllllllllllllllIllllIIlIIIlllll.classLoaderUtil = new LaunchClassLoaderUtil(Launch.classLoader);
        llllllllllllllllIllllIIlIIIlllll.lock = new ReEntranceLock(1);
    }

    @Override
    public Collection<String> getPlatformAgents() {
        return ImmutableList.of((Object)"org.spongepowered.asm.launch.platform.MixinPlatformAgentFML");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public byte[] getClassBytes(String llllllllllllllllIllllIIIllIIIIll, String llllllllllllllllIllllIIIllIIIlll) throws IOException {
        byte[] llllllllllllllllIllllIIIllIIIllI = Launch.classLoader.getClassBytes(llllllllllllllllIllllIIIllIIIIll);
        if (llllllllllllllllIllllIIIllIIIllI != null) {
            return llllllllllllllllIllllIIIllIIIllI;
        }
        URLClassLoader llllllllllllllllIllllIIIllIIIlIl = (URLClassLoader)Launch.class.getClassLoader();
        InputStream llllllllllllllllIllllIIIllIIIlII = null;
        try {
            String llllllllllllllllIllllIIIllIIlIll = llllllllllllllllIllllIIIllIIIlll.replace('.', '/').concat(".class");
            llllllllllllllllIllllIIIllIIIlII = llllllllllllllllIllllIIIllIIIlIl.getResourceAsStream(llllllllllllllllIllllIIIllIIlIll);
            byte[] llllllllllllllllIllllIIIlIllllIl = IOUtils.toByteArray((InputStream)llllllllllllllllIllllIIIllIIIlII);
            IOUtils.closeQuietly((InputStream)llllllllllllllllIllllIIIllIIIlII);
            return llllllllllllllllIllllIIIlIllllIl;
        }
        catch (Exception llllllllllllllllIllllIIIllIIlIlI) {
            byte[] llllllllllllllllIllllIIIlIllllIl = null;
            return llllllllllllllllIllllIIIlIllllIl;
        }
        finally {
            IOUtils.closeQuietly(llllllllllllllllIllllIIIllIIIlII);
        }
    }

    @Override
    public ClassNode getClassNode(String llllllllllllllllIllllIIIIllIlIlI) throws ClassNotFoundException, IOException {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIIIllIlIll;
        return llllllllllllllllIllllIIIIllIlIll.getClassNode(llllllllllllllllIllllIIIIllIlIll.getClassBytes(llllllllllllllllIllllIIIIllIlIlI, true), 0);
    }

    private ClassNode getClassNode(byte[] llllllllllllllllIllllIIIIllIIlII, int llllllllllllllllIllllIIIIllIIIll) {
        ClassNode llllllllllllllllIllllIIIIllIIIlI = new ClassNode();
        ClassReader llllllllllllllllIllllIIIIllIIIIl = new ClassReader(llllllllllllllllIllllIIIIllIIlII);
        llllllllllllllllIllllIIIIllIIIIl.accept(llllllllllllllllIllllIIIIllIIIlI, llllllllllllllllIllllIIIIllIIIll);
        return llllllllllllllllIllllIIIIllIIIlI;
    }

    @Override
    public ReEntranceLock getReEntranceLock() {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIlIIIlIIIl;
        return llllllllllllllllIllllIIlIIIlIIIl.lock;
    }

    @Override
    public MixinEnvironment.Phase getInitialPhase() {
        if (MixinServiceLaunchWrapper.findInStackTrace("net.minecraft.launchwrapper.Launch", "launch") > 132) {
            return MixinEnvironment.Phase.DEFAULT;
        }
        return MixinEnvironment.Phase.PREINIT;
    }

    private void findNameTransformer() {
        List llllllllllllllllIllllIIIIlllIlII = Launch.classLoader.getTransformers();
        for (IClassTransformer llllllllllllllllIllllIIIIlllIllI : llllllllllllllllIllllIIIIlllIlII) {
            if (!(llllllllllllllllIllllIIIIlllIllI instanceof IClassNameTransformer)) continue;
            logger.debug("Found name transformer: {}", new Object[]{llllllllllllllllIllllIIIIlllIllI.getClass().getName()});
            llllllllllllllllIllllIIIIlllIIll.nameTransformer = (IClassNameTransformer)llllllllllllllllIllllIIIIlllIllI;
        }
    }

    @Override
    public URL[] getClassPath() {
        return Launch.classLoader.getSources().toArray(new URL[0]);
    }

    @Override
    public final String getSideName() {
        MixinServiceLaunchWrapper llllllllllllllllIllllIIIIlIlIllI;
        for (ITweaker llllllllllllllllIllllIIIIlIllIIl : (List)GlobalProperties.get("Tweaks")) {
            if (llllllllllllllllIllllIIIIlIllIIl.getClass().getName().endsWith(".common.launcher.FMLServerTweaker")) {
                return "SERVER";
            }
            if (!llllllllllllllllIllllIIIIlIllIIl.getClass().getName().endsWith(".common.launcher.FMLTweaker")) continue;
            return "CLIENT";
        }
        String llllllllllllllllIllllIIIIlIlIlll = llllllllllllllllIllllIIIIlIlIllI.getSideName("net.minecraftforge.fml.relauncher.FMLLaunchHandler", "side");
        if (llllllllllllllllIllllIIIIlIlIlll != null) {
            return llllllllllllllllIllllIIIIlIlIlll;
        }
        llllllllllllllllIllllIIIIlIlIlll = llllllllllllllllIllllIIIIlIlIllI.getSideName("cpw.mods.fml.relauncher.FMLLaunchHandler", "side");
        if (llllllllllllllllIllllIIIIlIlIlll != null) {
            return llllllllllllllllIllllIIIIlIlIlll;
        }
        llllllllllllllllIllllIIIIlIlIlll = llllllllllllllllIllllIIIIlIlIllI.getSideName("com.mumfrey.liteloader.launch.LiteLoaderTweaker", "getEnvironmentType");
        if (llllllllllllllllIllllIIIIlIlIlll != null) {
            return llllllllllllllllIllllIIIIlIlIlll;
        }
        return "UNKNOWN";
    }
}

