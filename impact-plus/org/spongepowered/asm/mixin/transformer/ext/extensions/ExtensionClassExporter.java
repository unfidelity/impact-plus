/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.commons.io.FileUtils
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.transformer.ext.extensions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.ext.IDecompiler;
import org.spongepowered.asm.mixin.transformer.ext.IExtension;
import org.spongepowered.asm.mixin.transformer.ext.ITargetClassContext;
import org.spongepowered.asm.util.Constants;
import org.spongepowered.asm.util.perf.Profiler;

public class ExtensionClassExporter
implements IExtension {
    private static final /* synthetic */ String EXPORT_JAVA_DIR;
    private static final /* synthetic */ Logger logger;
    private final /* synthetic */ IDecompiler decompiler;
    private static final /* synthetic */ String DECOMPILER_CLASS;
    private static final /* synthetic */ String EXPORT_CLASS_DIR;
    private final /* synthetic */ File classExportDir;

    public File dumpClass(String lIlIlIIlllIlI, byte[] lIlIlIlIIIIII) {
        ExtensionClassExporter lIlIlIlIIIlII;
        File lIlIlIIlllllI = new File(lIlIlIlIIIlII.classExportDir, String.valueOf(new StringBuilder().append(lIlIlIIlllIlI).append(".class")));
        try {
            FileUtils.writeByteArrayToFile((File)lIlIlIIlllllI, (byte[])lIlIlIlIIIIII);
        }
        catch (IOException lIlIlIIllIlII) {
            // empty catch block
        }
        return lIlIlIIlllllI;
    }

    private boolean applyFilter(String lIlIllIIIIIll, String lIlIllIIIIlll) {
        ExtensionClassExporter lIlIllIIIlIlI;
        return Pattern.compile(lIlIllIIIlIlI.prepareFilter(lIlIllIIIIIll), 2).matcher(lIlIllIIIIlll).matches();
    }

    @Override
    public boolean checkActive(MixinEnvironment lIlIllIIIIIII) {
        return true;
    }

    private IDecompiler initDecompiler(MixinEnvironment lIlIllIlIIIlI, File lIlIllIIlllll) {
        if (!lIlIllIlIIIlI.getOption(MixinEnvironment.Option.DEBUG_EXPORT_DECOMPILE)) {
            return null;
        }
        try {
            boolean lIlIllIlIllII = lIlIllIlIIIlI.getOption(MixinEnvironment.Option.DEBUG_EXPORT_DECOMPILE_THREADED);
            logger.info("Attempting to load Fernflower decompiler{}", new Object[]{lIlIllIlIllII ? " (Threaded mode)" : ""});
            String lIlIllIlIlIIl = String.valueOf(new StringBuilder().append("org.spongepowered.asm.mixin.transformer.debug.RuntimeDecompiler").append(lIlIllIlIllII ? "Async" : ""));
            Class<?> lIlIllIlIIlll = Class.forName(lIlIllIlIlIIl);
            Constructor<?> lIlIllIlIIllI = lIlIllIlIIlll.getDeclaredConstructor(File.class);
            IDecompiler lIlIllIlIIlIl = (IDecompiler)lIlIllIlIIllI.newInstance(lIlIllIIlllll);
            logger.info("Fernflower decompiler was successfully initialised, exported classes will be decompiled{}", new Object[]{lIlIllIlIllII ? " in a separate thread" : ""});
            return lIlIllIlIIlIl;
        }
        catch (Throwable lIlIllIlIIlII) {
            logger.info("Fernflower could not be loaded, exported classes will not be decompiled. {}: {}", new Object[]{lIlIllIlIIlII.getClass().getSimpleName(), lIlIllIlIIlII.getMessage()});
            return null;
        }
    }

    public ExtensionClassExporter(MixinEnvironment lIlIlllIlIlIl) {
        ExtensionClassExporter lIlIlllIlIlll;
        lIlIlllIlIlll.classExportDir = new File(Constants.DEBUG_OUTPUT_DIR, "class");
        lIlIlllIlIlll.decompiler = lIlIlllIlIlll.initDecompiler(lIlIlllIlIlIl, new File(Constants.DEBUG_OUTPUT_DIR, "java"));
        try {
            FileUtils.deleteDirectory((File)lIlIlllIlIlll.classExportDir);
        }
        catch (IOException lIlIlllIlllII) {
            logger.warn("Error cleaning class output directory: {}", new Object[]{lIlIlllIlllII.getMessage()});
        }
    }

    @Override
    public void export(MixinEnvironment lIlIlIlIlllll, String lIlIlIllIIlIl, boolean lIlIlIllIIIll, byte[] lIlIlIlIlllII) {
        if (lIlIlIllIIIll || lIlIlIlIlllll.getOption(MixinEnvironment.Option.DEBUG_EXPORT)) {
            ExtensionClassExporter lIlIlIllIlIII;
            String lIlIlIllIlIIl = lIlIlIlIlllll.getOptionValue(MixinEnvironment.Option.DEBUG_EXPORT_FILTER);
            if (lIlIlIllIIIll || lIlIlIllIlIIl == null || lIlIlIllIlIII.applyFilter(lIlIlIllIlIIl, lIlIlIllIIlIl)) {
                Profiler.Section lIlIlIllIlIll = MixinEnvironment.getProfiler().begin("debug.export");
                File lIlIlIllIlIlI = lIlIlIllIlIII.dumpClass(lIlIlIllIIlIl.replace('.', '/'), lIlIlIlIlllII);
                if (lIlIlIllIlIII.decompiler != null) {
                    lIlIlIllIlIII.decompiler.decompile(lIlIlIllIlIlI);
                }
                lIlIlIllIlIll.end();
            }
        }
    }

    private String prepareFilter(String lIlIllIIlIlll) {
        lIlIllIIlIlll = String.valueOf(new StringBuilder().append("^\\Q").append(lIlIllIIlIlll.replace("**", "\u0081").replace("*", "\u0082").replace("?", "\u0083")).append("\\E$"));
        return lIlIllIIlIlll.replace("\u0081", "\\E.*\\Q").replace("\u0082", "\\E[^\\.]+\\Q").replace("\u0083", "\\E.\\Q").replace("\\Q\\E", "");
    }

    @Override
    public void preApply(ITargetClassContext lIlIlIllllllI) {
    }

    static {
        EXPORT_CLASS_DIR = "class";
        DECOMPILER_CLASS = "org.spongepowered.asm.mixin.transformer.debug.RuntimeDecompiler";
        EXPORT_JAVA_DIR = "java";
        logger = LogManager.getLogger((String)"mixin");
    }

    @Override
    public void postApply(ITargetClassContext lIlIlIlllllII) {
    }
}

