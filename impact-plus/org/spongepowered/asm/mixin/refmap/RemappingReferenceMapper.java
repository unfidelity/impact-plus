/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.common.base.Charsets
 *  com.google.common.base.Strings
 *  com.google.common.io.Files
 *  com.google.common.io.LineProcessor
 *  org.apache.logging.log4j.LogManager
 *  org.apache.logging.log4j.Logger
 */
package org.spongepowered.asm.mixin.refmap;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.io.Files;
import com.google.common.io.LineProcessor;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.refmap.IReferenceMapper;

public final class RemappingReferenceMapper
implements IReferenceMapper {
    private final /* synthetic */ Map<String, String> mappings;
    private final /* synthetic */ IReferenceMapper refMap;
    private static final /* synthetic */ Map<String, Map<String, String>> srgs;
    private final /* synthetic */ Map<String, Map<String, String>> cache;
    private static final /* synthetic */ Logger logger;
    private static final /* synthetic */ String DEFAULT_RESOURCE_PATH_PROPERTY;
    private static final /* synthetic */ String DEFAULT_MAPPING_ENV;

    @Override
    public String remap(String lllllIIIIlllIII, String lllllIIIIllIlll) {
        RemappingReferenceMapper lllllIIIIlllIIl;
        Map<String, String> lllllIIIIlllIll = lllllIIIIlllIIl.getCache(lllllIIIIlllIII);
        String lllllIIIIlllIlI = lllllIIIIlllIll.get(lllllIIIIllIlll);
        if (lllllIIIIlllIlI == null) {
            lllllIIIIlllIlI = lllllIIIIlllIIl.refMap.remap(lllllIIIIlllIII, lllllIIIIllIlll);
            for (Map.Entry<String, String> lllllIIIIllllll : lllllIIIIlllIIl.mappings.entrySet()) {
                lllllIIIIlllIlI = lllllIIIIlllIlI.replace(lllllIIIIllllll.getKey(), lllllIIIIllllll.getValue());
            }
            lllllIIIIlllIll.put(lllllIIIIllIlll, lllllIIIIlllIlI);
        }
        return lllllIIIIlllIlI;
    }

    public static IReferenceMapper of(MixinEnvironment lllllIIIIIIllll, IReferenceMapper lllllIIIIIIlllI) {
        if (!lllllIIIIIIlllI.isDefault() && RemappingReferenceMapper.hasData(lllllIIIIIIllll)) {
            return new RemappingReferenceMapper(lllllIIIIIIllll, lllllIIIIIIlllI);
        }
        return lllllIIIIIIlllI;
    }

    private RemappingReferenceMapper(MixinEnvironment lllllIIIlIllIll, IReferenceMapper lllllIIIlIlIllI) {
        RemappingReferenceMapper lllllIIIlIlllII;
        lllllIIIlIlllII.cache = new HashMap<String, Map<String, String>>();
        lllllIIIlIlllII.refMap = lllllIIIlIlIllI;
        lllllIIIlIlllII.refMap.setContext(RemappingReferenceMapper.getMappingEnv(lllllIIIlIllIll));
        String lllllIIIlIllIIl = RemappingReferenceMapper.getResource(lllllIIIlIllIll);
        lllllIIIlIlllII.mappings = RemappingReferenceMapper.loadSrgs(lllllIIIlIllIIl);
        logger.info("Remapping refMap {} using {}", new Object[]{lllllIIIlIlIllI.getResourceName(), lllllIIIlIllIIl});
    }

    @Override
    public String getContext() {
        RemappingReferenceMapper lllllIIIlIIlIlI;
        return lllllIIIlIIlIlI.refMap.getContext();
    }

    @Override
    public void setContext(String lllllIIIlIIIlll) {
    }

    @Override
    public String getResourceName() {
        RemappingReferenceMapper lllllIIIlIIllll;
        return lllllIIIlIIllll.refMap.getResourceName();
    }

    private static boolean hasData(MixinEnvironment lllllIIIIIIlIIl) {
        String lllllIIIIIIlIII = RemappingReferenceMapper.getResource(lllllIIIIIIlIIl);
        return lllllIIIIIIlIII != null && new File(lllllIIIIIIlIII).exists();
    }

    static {
        DEFAULT_RESOURCE_PATH_PROPERTY = "net.minecraftforge.gradle.GradleStart.srg.srg-mcp";
        DEFAULT_MAPPING_ENV = "searge";
        logger = LogManager.getLogger((String)"mixin");
        srgs = new HashMap<String, Map<String, String>>();
    }

    @Override
    public String remapWithContext(String lllllIIIIlIIlII, String lllllIIIIlIIIll, String lllllIIIIIllllI) {
        RemappingReferenceMapper lllllIIIIlIIlIl;
        return lllllIIIIlIIlIl.refMap.remapWithContext(lllllIIIIlIIlII, lllllIIIIlIIIll, lllllIIIIIllllI);
    }

    @Override
    public boolean isDefault() {
        RemappingReferenceMapper lllllIIIlIlIIll;
        return lllllIIIlIlIIll.refMap.isDefault();
    }

    private static String getResource(MixinEnvironment lllllIIIIIIIIll) {
        String lllllIIIIIIIIlI = lllllIIIIIIIIll.getOptionValue(MixinEnvironment.Option.REFMAP_REMAP_RESOURCE);
        return Strings.isNullOrEmpty((String)lllllIIIIIIIIlI) ? System.getProperty("net.minecraftforge.gradle.GradleStart.srg.srg-mcp") : lllllIIIIIIIIlI;
    }

    private static String getMappingEnv(MixinEnvironment llllIllllllllIl) {
        String llllIllllllllII = llllIllllllllIl.getOptionValue(MixinEnvironment.Option.REFMAP_REMAP_SOURCE_ENV);
        return Strings.isNullOrEmpty((String)llllIllllllllII) ? "searge" : llllIllllllllII;
    }

    private Map<String, String> getCache(String lllllIIIIlIlllI) {
        RemappingReferenceMapper lllllIIIIlIllll;
        Map<String, String> lllllIIIIlIllIl = lllllIIIIlIllll.cache.get(lllllIIIIlIlllI);
        if (lllllIIIIlIllIl == null) {
            lllllIIIIlIllIl = new HashMap<String, String>();
            lllllIIIIlIllll.cache.put(lllllIIIIlIlllI, lllllIIIIlIllIl);
        }
        return lllllIIIIlIllIl;
    }

    @Override
    public String getStatus() {
        RemappingReferenceMapper lllllIIIlIIllIl;
        return lllllIIIlIIllIl.refMap.getStatus();
    }

    private static Map<String, String> loadSrgs(String lllllIIIIIllIII) {
        if (srgs.containsKey(lllllIIIIIllIII)) {
            return srgs.get(lllllIIIIIllIII);
        }
        final HashMap<String, String> lllllIIIIIlIlll = new HashMap<String, String>();
        srgs.put(lllllIIIIIllIII, lllllIIIIIlIlll);
        File lllllIIIIIlIllI = new File(lllllIIIIIllIII);
        if (!lllllIIIIIlIllI.isFile()) {
            return lllllIIIIIlIlll;
        }
        try {
            Files.readLines((File)lllllIIIIIlIllI, (Charset)Charsets.UTF_8, (LineProcessor)new LineProcessor<Object>(){

                public Object getResult() {
                    return null;
                }

                public boolean processLine(String llllllllllllllllIlIIllIIIIIIlIII) throws IOException {
                    if (Strings.isNullOrEmpty((String)llllllllllllllllIlIIllIIIIIIlIII) || llllllllllllllllIlIIllIIIIIIlIII.startsWith("#")) {
                        return true;
                    }
                    int llllllllllllllllIlIIllIIIIIIIlll = 0;
                    int llllllllllllllllIlIIllIIIIIIIllI = 0;
                    if ((llllllllllllllllIlIIllIIIIIIlIII.startsWith("MD: ") ? 2 : (llllllllllllllllIlIIllIIIIIIIllI = llllllllllllllllIlIIllIIIIIIlIII.startsWith("FD: ") ? 1 : 0)) > 0) {
                        1 llllllllllllllllIlIIllIIIIIIlIIl;
                        String[] llllllllllllllllIlIIllIIIIIIlIlI = llllllllllllllllIlIIllIIIIIIlIII.substring(4).split(" ", 4);
                        llllllllllllllllIlIIllIIIIIIlIIl.lllllIIIIIlIlll.put(llllllllllllllllIlIIllIIIIIIlIlI[llllllllllllllllIlIIllIIIIIIIlll].substring(llllllllllllllllIlIIllIIIIIIlIlI[llllllllllllllllIlIIllIIIIIIIlll].lastIndexOf(47) + 1), llllllllllllllllIlIIllIIIIIIlIlI[llllllllllllllllIlIIllIIIIIIIllI].substring(llllllllllllllllIlIIllIIIIIIlIlI[llllllllllllllllIlIIllIIIIIIIllI].lastIndexOf(47) + 1));
                    }
                    return true;
                }
                {
                    1 llllllllllllllllIlIIllIIIIlIIlIl;
                }
            });
        }
        catch (IOException lllllIIIIIllIIl) {
            logger.warn("Could not read input SRG file: {}", new Object[]{lllllIIIIIllIII});
            logger.catching((Throwable)lllllIIIIIllIIl);
        }
        return lllllIIIIIlIlll;
    }
}

